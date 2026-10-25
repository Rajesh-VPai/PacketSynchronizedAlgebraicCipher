/*
CC0 1.0 Universal (CC0 1.0) Public Domain Dedication

To the extent possible under law, the author(s) have dedicated all copyright
and related rights to this software to the public domain worldwide. This
software is distributed without any warranty.

You may copy, modify, distribute, and perform the work, even for commercial
purposes, all without asking permission.

For more information, see <https://creativecommons.org/publicdomain/zero/1.0/>
 */
 /*
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or distribute
this software, either in source code form or as a compiled binary, for any
purpose, commercial or non-commercial, and by any means.

In jurisdictions that recognize copyright laws, the author(s) dedicate any
and all copyright interest in the software to the public domain. We make
this dedication for the benefit of the public at large and to the detriment
of our heirs and successors. We intend this dedication to be an overt act
of relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <https://unlicense.org/>
 */
/**
 *
 * @author Rajesh V Pai
 */
package QuantumLWE;
import java.math.BigInteger;
 import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
/**
 *
 * @author Rajesh V Pai
 */
public class QuantumResistantPipelineLWE {

     // --- SYSTEM PARAMETERS ---
    private static final int MOD = 3329; // Kyber modulus
    private static final int N = 1024; // Polynomial dimension
    private static final double SIGMA = 1.0; // Noise deviation
    private static final int PSI = 17; // Primitive root (example)
    private static final int INV_N = 3326; // Modular inverse of N mod MOD

    private static final SecureRandom SECURE_RAND = new SecureRandom();

    // --- Utility: Generate private key ---
    public static int[] generatePrivateKey() {
        int[] privateKey = new int[N];
        for (int i = 0; i < N; i++) {
            privateKey[i] = SECURE_RAND.nextInt(3) - 1; // -1, 0, or 1
        }
        return privateKey;
    }

    // --- SENDER ENGINE ---
    public static String senderEncryptAndPackage(String textMessage, int[] privateKey) {
        int[] messagePoly = new int[N];
        for (int i = 0; i < textMessage.length() && i < N; i++) {
            messagePoly[i] = textMessage.charAt(i);
        }

        byte[] seed = new byte[32];
        SECURE_RAND.nextBytes(seed);
        int[] publicA = expandSeedToPolynomial(seed);

        int[] nttA = forwardNTT(publicA);
        int[] nttSecret = forwardNTT(privateKey);

        int[] nttProduct = new int[N];
        for (int i = 0; i < N; i++) {
            nttProduct[i] = (int)(((long)nttA[i] * nttSecret[i]) % MOD);
        }

        int[] normalProduct = inverseNTT(nttProduct);

        int[] ciphertextB = new int[N];
        for (int i = 0; i < N; i++) {
            int noise = (int)Math.round(SECURE_RAND.nextGaussian() * SIGMA);
            ciphertextB[i] = Math.floorMod(normalProduct[i] + noise + messagePoly[i], MOD);
        }

        byte[] rawPayloadBytes = new byte[32 + (N * 2)];
        System.arraycopy(seed, 0, rawPayloadBytes, 0, 32);
        for (int i = 0; i < N; i++) {
            rawPayloadBytes[32 + (i * 2)] = (byte)((ciphertextB[i] >> 8) & 0xFF);
            rawPayloadBytes[32 + (i * 2) + 1] = (byte)(ciphertextB[i] & 0xFF);
        }

        return Base64.getEncoder().encodeToString(rawPayloadBytes);
    }

    // --- RECEIVER ENGINE ---
    public static String receiverUnpackAndDecrypt(String payload, int[] privateKey) {
        byte[] rawPayloadBytes = Base64.getDecoder().decode(payload);

        byte[] seed = Arrays.copyOfRange(rawPayloadBytes, 0, 32);

        int[] ciphertextB = new int[N];
        for (int i = 0; i < N; i++) {
            int high = (rawPayloadBytes[32 + (i * 2)] & 0xFF) << 8;
            int low = rawPayloadBytes[32 + (i * 2) + 1] & 0xFF;
            ciphertextB[i] = high | low;
        }

        int[] recoveredPublicA = expandSeedToPolynomial(seed);
        int[] nttA = forwardNTT(recoveredPublicA);
        int[] nttSecret = forwardNTT(privateKey);

        int[] nttProduct = new int[N];
        for (int i = 0; i < N; i++) {
            nttProduct[i] = (int)(((long)nttA[i] * nttSecret[i]) % MOD);
        }
        int[] decryptedProduct = inverseNTT(nttProduct);

        StringBuilder outputText = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int isolatedValue = Math.floorMod(ciphertextB[i] - decryptedProduct[i], MOD);
            if (isolatedValue >= 0 && isolatedValue <= 255) {
                outputText.append((char)isolatedValue);
            }
        }
        return outputText.toString();
    }

    // --- CRYPTOGRAPHIC UTILITIES ---
    public static int[] expandSeedToPolynomial(byte[] seed) {
        int[] polyA = new int[N];
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] buffer = seed;
            int generatedCount = 0;
            while (generatedCount < N) {
                buffer = sha256.digest(buffer);
                for (int i = 0; i < buffer.length - 1; i += 2) {
                    int val = ((buffer[i] & 0xFF) << 8) | (buffer[i + 1] & 0xFF);
                    if (val < MOD && generatedCount < N) {
                        polyA[generatedCount++] = val;
                    }
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return polyA;
    }

    private static int modPow(int base, int exp, int mod) {
        return BigInteger.valueOf(base).modPow(BigInteger.valueOf(exp), BigInteger.valueOf(mod)).intValue();
    }

    private static int[] forwardNTT(int[] poly) {
        int[] src = Arrays.copyOf(poly, N);
        int t = N;
        for (int m = 1; m < N; m <<= 1) {
            t >>= 1;
            for (int i = 0; i < m; i++) {
                int j1 = i * (t << 1);
                int j2 = j1 + t;
                int j = i + m;
                int w = modPow(PSI, j, MOD);
                for (int jLoop = j1; jLoop < j2; jLoop++) {
                    int u = src[jLoop];
                    int v = (int)((src[jLoop + t] * (long)w) % MOD);
                    src[jLoop] = (u + v) % MOD;
                    src[jLoop + t] = Math.floorMod(u - v, MOD);
                }
            }
        }
        return src;
    }

    private static int[] inverseNTT(int[] nttPoly) {
        int[] src = Arrays.copyOf(nttPoly, N);
        int t = 1;
        for (int m = N >> 1; m > 0; m >>= 1) {
            for (int i = 0; i < m; i++) {
                int j1 = i * (t << 1);
                int j2 = j1 + t;
                int j = i + m;
                int w = modPow(PSI, j, MOD);
                for (int jLoop = j1; jLoop < j2; jLoop++) {
                    int u = src[jLoop];
                    int v = src[jLoop + t];
                    src[jLoop] = (u + v) % MOD;
                    src[jLoop + t] = (int)(Math.floorMod(u - v, MOD) * (long)w % MOD);
                }
            }
            t <<= 1;
        }
        for (int i = 0; i < N; i++) {
            src[i] = (int)((src[i] * (long)INV_N) % MOD);
        }
        return src;
    }
}

