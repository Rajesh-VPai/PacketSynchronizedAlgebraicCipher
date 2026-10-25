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
package Benchmark;
import Equations.PSACEquationFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author Rajesh V Pai
 */
public class BenchmarkHarness {
        // === Utility: Shannon entropy ===
    public static double shannonEntropy(byte[] data) {
        int[] freq = new int[256];
        for (byte b : data) freq[b & 0xFF]++;
        double entropy = 0.0;
        int len = data.length;
        for (int f : freq) {
            if (f > 0) {
                double p = (double) f / len;
                entropy -= p * (Math.log(p) / Math.log(2));
            }
        }
        return entropy;
    }

    // === PSA encryption simulation ===
    public static String psaEncrypt(String plaintext,
                                    long zSecret, int timeStepSeconds, int aSecret, int bSecret,
                                    int cSecret, int dSecret, int diffusionN, int sSecret) {
        int[] coeffs={2,3,4,2};
        String[] vars={"Xn","m","z"};                                  
        String equation = PSACEquationFactory.buildEquation(3);
        return plaintext + "|" + equation;
    }

    // === PSA decryption simulation ===
    public static String psaDecrypt(String ciphertext,
                                    long zSecret, int aSecret, int bSecret,
                                    int cSecret, int dSecret, int diffusionN,int sSecret) {
        int[] coeffs={2,3,4,2};
        String[] vars={"Xn","m","z"};
        String inverse = PSACEquationFactory.buildInverse(3);
        return ciphertext.split("\\|")[0] + " (decrypted with " + inverse + ")";
    }

    // === AES encryption ===
    public static byte[] aesEncrypt(byte[] plaintext) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, new SecureRandom());
        SecretKey secretKey = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plaintext);
    }

    // === Resilience Tests ===
    public static void knownPlaintextTest(long zSecret, int aSecret, int bSecret,
                                          int cSecret, int dSecret,int diffusionN, int sSecret) {
        String plaintext = "AAAAAA";
        String cipher = psaEncrypt(plaintext,zSecret, 30, aSecret, bSecret,cSecret,dSecret, diffusionN, sSecret);
        System.out.println("Known-Plaintext Test: " + cipher);
    }

    public static void chosenCiphertextTest(long zSecret,  int timeStepSeconds,int aSecret, int bSecret,
                                            int cSecret, int dSecret, int sSecret) {
        String fakeCipher = "FAKECIPHERTEXT|InjectedEquation";
        String decrypted = psaDecrypt(fakeCipher, zSecret, timeStepSeconds, aSecret, bSecret, cSecret, dSecret, sSecret);
        System.out.println("Chosen-Ciphertext Test: " + decrypted);
    }

    // === CSV Report Line ===
    public static String reportLine(String algo, long timeNs, double entropy) {
        return algo + "," + timeNs + "," + entropy;
    }

    // === Benchmark runner ===
    public static void main(String[] args) throws Exception {
        long zSecret = 987654321L;
        int aSecret = 7, bSecret = 13, cSecret = 5, dSecret = 11, sSecret = 3;
        int timeStepSeconds=30;
        int diffusionN=30;
        String plaintext = "Benchmarking PSA vs AES";

        // PSA
        long startPSA = System.nanoTime();
        String psaCipher = psaEncrypt(plaintext, zSecret, timeStepSeconds, aSecret, bSecret, cSecret, dSecret, diffusionN,sSecret);
        long endPSA = System.nanoTime();
        double psaEntropy = shannonEntropy(psaCipher.getBytes());

        // AES
        long startAES = System.nanoTime();
        byte[] aesCipher = aesEncrypt(plaintext.getBytes());
        long endAES = System.nanoTime();
        double aesEntropy = shannonEntropy(aesCipher);

        // Print results
        System.out.println("PSA Cipher: " + psaCipher);
        System.out.println("AES Cipher: " + Arrays.toString(aesCipher));

        // CSV-style report
        System.out.println("\nAlgorithm,Time(ns),Entropy");
        System.out.println(reportLine("PSA", (endPSA - startPSA), psaEntropy));
        System.out.println(reportLine("AES", (endAES - startAES), aesEntropy));

        // Resilience tests
        System.out.println("\n--- Resilience Tests ---");
        knownPlaintextTest(zSecret, aSecret, bSecret, cSecret, dSecret, diffusionN,sSecret);
        chosenCiphertextTest(zSecret, aSecret, bSecret, cSecret, dSecret, diffusionN, sSecret);
    }
}
