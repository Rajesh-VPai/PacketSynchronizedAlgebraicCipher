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

/**
 *
 * @author Rajesh V Pai
 */
public class TCPEquationSecurity {
    // === Sender Side: Encrypt using Expansion Equation ===
    public static String encryptWithEquation(long seed, long OTP,String[] vars) {
        try{
        int[] coeffs = PSACOTPEquation.generateCoefficientsFromSeed(seed,OTP);
        int selector = coeffs[4];
        return PSACEquationFactory.buildEquation(selector);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Unsupported Equation)";
    }

    // === Receiver Side: Decrypt using Inverse Equation ===
    public static String decryptWithInverse(long seed, long OTP, String[] vars) {
        try{
        int[] coeffs = PSACOTPEquation.generateCoefficientsFromSeed(seed,OTP);
        int selector = coeffs[4];
        return PSACEquationFactory.buildInverse(selector);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Unsupported Equation)";
    }

    // === Demo Harness ===
    public static void main(String[] args) {
        long sharedSeed = 123456789L; // OTP shared secret
        String[] vars = {"Xn", "z", "s", "d"};

        // Sender encrypts
        String equation = encryptWithEquation(sharedSeed, 123456789L,vars);
        System.out.println("Sender Expansion Equation (Encrypt): " + equation);

        // Receiver decrypts
        String inverse = decryptWithInverse(sharedSeed, 123456789L, vars);
        System.out.println("Receiver Inverse Equation (Decrypt): " + inverse);
    }
}
