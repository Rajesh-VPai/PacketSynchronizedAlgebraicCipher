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

import static Equations.PSACEquationFactory.selectorName;
import static Equations.PSACEquationSuiteExtremelySafe.selectorSafeName;
import static Security.EquationPairGeneration.ListOfEquationsThatCanBeUsed;
import static Security.PacketSynchronizedAlgebraicCipher.ExtremelySafeEquations;
import static Security.PacketSynchronizedAlgebraicCipher.SafeEquations;
import static Security.PacketSynchronizedAlgebraicCipher.SafeEquationsFlag;
import static Security.PacketSynchronizedAlgebraicCipher.TCPSafeEquations;
import static SenderReceiverGUI.Receiver.ReceiverHighLevelSelector;
import static SenderReceiverGUI.Receiver.ReceiverHighLevelUnsupportedSelector;
import static SenderReceiverGUI.Sender.SenderHighLevelSelector;
import static SenderReceiverGUI.Sender.SenderHighLevelUnsupportedSelector;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Rajesh V Pai
 */
public class PSACOTPEquation {

    public static final String[] DEFAULT_VARS = {"Xn", "z", "m", "s", "a"};// {"Xn", "z", "s", "d"};
    public static int[] DEFAULT_COEFFS = {2, 3, 4, 5, 3};//{1, 1, 1, 1, 0}; // [a,b,c,d,hashedSeed]
    // === Generate coefficients securely from seed ===

    public static int[] generateCoefficientsFromSeed(long seed, long OTP) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha.digest(Long.toString(seed + OTP).getBytes());

        int a = (hash[0] & 0xFF) % 23 + 1;
        //System.out.println("PSACOTPEquation:generateCoefficientsFromSeed:a=" + a + " hash[0]=" + hash[0]);
        int b = (hash[1] & 0xFF) % 23 + 1;
        //System.out.println("PSACOTPEquation:generateCoefficientsFromSeed:b=" + b + " hash[1]=" + hash[1]);
        int c = (hash[2] & 0xFF) % 23 + 1;
        //System.out.println("PSACOTPEquation:generateCoefficientsFromSeed:c=" + c + " hash[2]=" + hash[2]);
        int d = (hash[3] & 0xFF) % 23 + 1;
        //System.out.println("PSACOTPEquation:generateCoefficientsFromSeed:d=" + d + " hash[3]=" + hash[3]);

        // Collapse first 4 bytes into a hashedSeed integer
        int hashedSeed = ((hash[0] & 0xFF) << 24) | ((hash[1] & 0xFF) << 16) | ((hash[2] & 0xFF) << 8) | (hash[3] & 0xFF);
        //System.out.println("PSACOTPEquation:generateCoefficientsFromSeed:hashedSeed=" + hashedSeed);
        // Store hashedSeed in DEFAULT_COEFFS[4]
        return new int[]{a, b, c, d, hashedSeed};
    }

    // === Build Expansion Equation ===
    public static String buildOTPEquation(String LayerType,long seed, long OTP) throws NoSuchAlgorithmException {
        boolean SilentFlag = true;
        DEFAULT_COEFFS = generateCoefficientsFromSeed(seed, OTP);
        ListOfEquationsThatCanBeUsed();
        // Selector derived from hashedSeed
        int selector = -1;
        if ((SafeEquationsFlag==true)&&(LayerType.equalsIgnoreCase("HighLevel")))
                selector=(DEFAULT_COEFFS[4] % SafeEquations)+1;//11//14;//7 Safe Equations
        else if ((SafeEquationsFlag==true)&&(LayerType.equalsIgnoreCase("TCPLevel")))
                selector=(DEFAULT_COEFFS[4] % TCPSafeEquations)+1;//11//14;//7 Safe Equations
        else if ((SafeEquationsFlag==false)&&(LayerType.equalsIgnoreCase("TCPLevel")))
            selector=(DEFAULT_COEFFS[4] % 14)+1;//11//14;//7 Safe Equations
        else if ((SafeEquationsFlag==false)&&(LayerType.equalsIgnoreCase("HighLevel")))
                selector=(DEFAULT_COEFFS[4] % 14)+1;//11//14;//7 Safe Equations
        if (selector < 0) {
            selector = -1 * selector;
        }
        //selector=1;
        if (SilentFlag == false) {
            //System.out.println("buildOTPEquation:LayerType=" + LayerType + " selector=" + selector);
            if (LayerType.equalsIgnoreCase("TCPLevel")) {
                System.out.println("buildOTPEquation:selectorName=" + selectorName(selector) + " selector=" + selector);
            }
            if (LayerType.equalsIgnoreCase("HighLevel")) {
                System.out.println("buildOTPEquation:selectorName=" + selectorSafeName(selector) + " selector=" + selector);
            }
        }
        String Temp="";
        if ((SafeEquationsFlag==true)&&(LayerType.equalsIgnoreCase("HighLevel")))
                Temp=PSACEquationSuiteExtremelySafe.buildSafeEquation(selector);
        else if ((SafeEquationsFlag==false)&&(LayerType.equalsIgnoreCase("HighLevel")))
                Temp=PSACEquationFactory.buildEquation(selector);
        else if (LayerType.equalsIgnoreCase("TCPLevel"))
                Temp=PSACEquationFactory.buildEquation(selector);
        if (Temp.contains("Unsupported"))
            Temp=PSACEquationSuiteExtremelySafe.buildSafeEquation((selector % ExtremelySafeEquations )+1 );
        
        return Temp;
    }

    // === Build Inverse Equation ===
    public static String buildOTPInverse(String LayerType, long seed, long OTP) throws NoSuchAlgorithmException {
        boolean SilentFlag = true;
        DEFAULT_COEFFS = generateCoefficientsFromSeed(seed, OTP);
        ListOfEquationsThatCanBeUsed();
        int selector = -1;
        if ((SafeEquationsFlag==true)&&(LayerType.equalsIgnoreCase("HighLevel")))
                selector=(DEFAULT_COEFFS[4] % SafeEquations)+1;//11//14;//7 Safe Equations
        else if ((SafeEquationsFlag==true)&&(LayerType.equalsIgnoreCase("TCPLevel")))
                selector=(DEFAULT_COEFFS[4] % SafeEquations)+1;//11//14;//7 Safe Equations
        else if ((SafeEquationsFlag==false)&&(LayerType.equalsIgnoreCase("TCPLevel")))
            selector=(DEFAULT_COEFFS[4] % 14)+1;//11//14;//7 Safe Equations
        else if ((SafeEquationsFlag==false)&&(LayerType.equalsIgnoreCase("HighLevel")))
                selector=(DEFAULT_COEFFS[4] % 14)+1;//11//14;//7 Safe Equations
        if (selector < 0) {
            selector = -1 * selector;
        }
        //selector=1;
        if (SilentFlag == false) {
            //System.out.println("buildOTPInverse:LayerType=" + LayerType + " selector=" + selector);
            if (LayerType.equalsIgnoreCase("TCPLevel")) {
                //System.out.println("buildOTPInverse:selectorName=" + selectorName(selector) + " selector=" + selector);
            }
            if (LayerType.equalsIgnoreCase("HighLevel")) {
                ReceiverHighLevelSelector=selector;
                SenderHighLevelSelector=selector;
                System.out.println("buildOTPInverse:selectorName=" + selectorSafeName(selector) + " selector=" + selector);
            }
        }
        String Temp="";
        if ((SafeEquationsFlag==true)&&(LayerType.equalsIgnoreCase("HighLevel")))
                Temp=PSACEquationSuiteExtremelySafe.buildSafeInverse(selector);
        else
                Temp=PSACEquationFactory.buildInverse(selector);
        if (Temp.contains("Unsupported")){
            Temp=PSACEquationSuiteExtremelySafe.buildSafeInverse((selector % ExtremelySafeEquations )+1 );
            ReceiverHighLevelUnsupportedSelector=(selector % ExtremelySafeEquations )+1;
            SenderHighLevelUnsupportedSelector=(selector % ExtremelySafeEquations )+1;
        }
        return Temp;
    }

    // === Demo Harness ===
    public static void main(String[] args) {
        try {
            long seed = 123456789L; // securely derived in production

            String equation = buildOTPEquation("TCPLevel",seed, 123496789L);
            String inverse = buildOTPInverse("TCPLevel",seed, 123496789L);

            System.out.println("OTP Equation: " + equation);
            System.out.println("OTP Inverse: " + inverse);
            System.out.println("Hashed Seed: " + DEFAULT_COEFFS[4]);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 not available: " + e.getMessage());
        }
    }
}
