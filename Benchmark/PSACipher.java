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

/**
 *
 * @author Rajesh V Pai
 */
public class PSACipher {
     private byte[] key;
    private int mode; // 1 = ENCRYPT, 2 = DECRYPT

    public static final int ENCRYPT_MODE = 1;
    public static final int DECRYPT_MODE = 2;

    public PSACipher(byte[] key) {
        this.key = key;
    }

    public void init(int mode) {
        this.mode = mode;
    }

    // Simulate update (process partial data)
    public byte[] update(byte[] input) {
        return process(input);
    }

    // Simulate doFinal (process last block + padding)
    public byte[] doFinal(byte[] input) {
        // For toy purposes, no real padding — just process directly
        return process(input);
    }

    // Core block processing: XOR with key
    private byte[] process(byte[] input) {
        byte[] output = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = (byte)(input[i] ^ key[i % key.length]);
        }
        return output;
    }

    // Demo
    public static void main(String[] args) {
        byte[] key = "toykey1234567890".getBytes(); // 16-byte toy key
        PSACipher cipher = new PSACipher(key);

        String plainText = "HELLO WORLD";

        // Encrypt
        cipher.init(PSACipher.ENCRYPT_MODE);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        System.out.println("Encrypted bytes: " + java.util.Arrays.toString(encrypted));

        // Decrypt
        cipher.init(PSACipher.DECRYPT_MODE);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted text: " + new String(decrypted));
    }
}