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
package Equations;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Rajesh V Pai
 */
public class GaloisUtils {
    // Irreducible polynomial for GF(2^128): x^128 + x^7 + x^2 + x + 1
    private static final BigInteger POLY = new BigInteger("E1000000000000000000000000000000", 16);

    /**
     * Multiply two 128-bit blocks in GF(2^128).
     */
    public static byte[] galoisMultiply(byte[] x, byte[] y) {
        BigInteger a = new BigInteger(1, x);
        BigInteger b = new BigInteger(1, y);
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < 128; i++) {
            if (b.testBit(i)) result = result.xor(a);
            boolean lsb = a.testBit(0);
            a = a.shiftRight(1);
            if (lsb) a = a.xor(POLY);
        }
        byte[] out = result.toByteArray();
        return Arrays.copyOfRange(out, Math.max(0, out.length - 16), out.length);
    }

    /**
     * Compute multiplicative inverse of an element in GF(2^128).
     */
    public static BigInteger inverse(BigInteger h) {
        BigInteger r0 = POLY, r1 = h;
        BigInteger t0 = BigInteger.ZERO, t1 = BigInteger.ONE;

        while (!r1.equals(BigInteger.ZERO)) {
            int shift = r0.bitLength() - r1.bitLength();
            if (shift < 0) break;
            r0 = r0.xor(r1.shiftLeft(shift));
            t0 = t0.xor(t1.shiftLeft(shift));

            if (r0.bitLength() < r1.bitLength()) {
                BigInteger tmpR = r0; r0 = r1; r1 = tmpR;
                BigInteger tmpT = t0; t0 = t1; t1 = tmpT;
            }
        }
        return t0; // h⁻¹ modulo POLY
    }

    /**
     * Verify tag by recomputing GHASH.
     */
    public static boolean verifyTag(byte[] cipherBlock, byte[] tag, byte[] H) {
        byte[] computed = galoisMultiply(cipherBlock, H);
        return Arrays.equals(tag, computed);
    }

    // --- Demo main ---
    public static void main(String[] args) {
        byte[] H = new byte[16]; Arrays.fill(H, (byte)0xAB);
        byte[] block = "BlockOne-16bytes!".getBytes();

        byte[] tag = galoisMultiply(block, H);
        System.out.println("Tag: " + new BigInteger(1, tag).toString(16));

        BigInteger invH = inverse(new BigInteger(1, H));
        BigInteger recovered = new BigInteger(1, tag).multiply(invH).mod(POLY);
        System.out.println("Recovered (toy): " + recovered.toString(16));

        boolean ok = verifyTag(block, tag, H);
        System.out.println("Verification: " + ok);
    }
}