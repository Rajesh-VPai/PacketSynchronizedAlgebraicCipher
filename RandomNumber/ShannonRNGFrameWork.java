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
package RandomNumber;

import static Calculus.MathsContxtLAv.eatAll;
import static RandomNumber.UserResearchStudy.NextEvenNumber;
import static RandomNumber.UserResearchStudy.NextOddNumber;
import Shannon_Mapping.E_Mapping;
import Shannon_Mapping.K_Mapping;
import Shannon_Mapping.R_Region;
import Shannon_Mapping.S_Mapping;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Rajesh V Pai
 */
public class ShannonRNGFrameWork {

    public static E_Mapping[] E = null;
    public static K_Mapping[] K = null;
    private static R_Region[] R_Region = null;
    private static S_Mapping S = null;
    public static Map<String, Double> variables = new HashMap<>();
    public static int MaxExponentORTerms = 3;

    public static int NumberOfFunctions = 26;
    public static int NumberOfKeyParts = 26;
    public static int NumberOfChars = 100;
    public static int DiffusedNumberOfChars = 8;

    public static String PlainText = "";
    public static String DiffusedCrytogram = "";
    public static String DecryptedDiffusedCrytogram = "";
    public static String R_EncryptedCrytogram = "";
    public static String DecodedPlainText = "";

    

    /* ****************************************************************************** */
    ////Low level Functions Begin
    /* ****************************************************************************** */
    public static void InitEquationVar() {
        variables.put("m", Double.NaN);
        variables.put("x", Double.NaN);
        variables.put("c", Double.NaN);
        variables.put("Xn", Double.NaN);
        variables.put("keyx", Double.NaN);
    }

    public static void SetVariablesValues(int mychar) {
        variables.put("m", 1.0);
        variables.put("x", (double) (mychar));
        variables.put("c", 0.0);
        variables.put("Xn", 0.0);
        variables.put("keyx", 0.0);
    }

    public static void Set1Function(String Exprn) {
        S = new S_Mapping(Exprn);
    }

    public static void SetFunctions(String Exprn) {
        double m = 1.0;
        double a = 1.0;
        double c = 1.0;
        double b = 1.0;
        String TempExprn = "";
        E = new E_Mapping[NumberOfFunctions];
        for (int i = 0; i < NumberOfFunctions; i++) {
            TempExprn = FormEquationE((int) m, (int) a, (int) c, (int) b, "Xn", (int) MaxExponentORTerms) + "+" + Exprn;
            E[i] = new E_Mapping(TempExprn);
            //System.out.println("Hello World:SetFunctions:TempExprn:" + TempExprn);
        }
    }

    public static void SetKeyParts(String Exprn) {
        double m = 1.0;
        double a = 1.0;
        double c = 1.0;
        double b = 1.0;
        String KeyTempExprn = "";
        K = new K_Mapping[NumberOfKeyParts];
        for (int i = 0; i < NumberOfKeyParts; i++) {
            KeyTempExprn = FormEquationKey((int) m + i, (int) a + i, (int) c, (int) b, "keyx", (int) MaxExponentORTerms) + "+" + Exprn;
            K[i] = new K_Mapping(KeyTempExprn);
            //System.out.println("Hello World:SetKeyParts:KeyTempExprn:" + KeyTempExprn);
        }
    }

    /* ****************************************************************************** */
    ////Low level Functions End
    /* ****************************************************************************** */
 /* ****************************************************************************** */
    ////Functions to Cryptogram Begin
    /* ****************************************************************************** */
    public static long ComputeConfusion(int i) {
        i = i % NumberOfFunctions;
        if (( i > 0)&&(i < E.length))
            return E[i].LCGexpValue.eval().longValue();
        else 
            return 1;
    }
    public static void DebugECryptogram() {
        for (int i = 0; i < NumberOfFunctions; i++) {
            System.out.println("Hello World:i=" + i + ":DebugECryptogram:E=" + E[i].EFunctionStr);
            if (i < NumberOfKeyParts) {
                System.out.println("Hello World:i=" + i + ":DebugECryptogram:Key=" + K[i].KFunctionStr);
            }
        }
    }

    /* ****************************************************************************** */
    ////Functions to Cryptogram End
    /* ****************************************************************************** */

 /* ****************************************************************************** */
    ////Functions to Form Equation String Begin
    /* ****************************************************************************** */
    public static String FormEquationE(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        StringBuilder Exprn = new StringBuilder("" + MgtACoeff);
        Exprn.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            } else {
                Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
                //MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextEvenNumber(j);
            j += 2;
            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
        }
        if (MgtbCoeff > 2) {
            Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
        } else {
            Exprn.append(" + ").append(TechDiffWithRespTo);
        }
//        Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        if( (Xn !=0)&&(Mgtc !=0))
//            Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        else
//            Exprn.append(" + ").append(NextEvenNumber(1)).append(" + ").append(NextEvenNumber(1));
        Exprn = new StringBuilder(eatAll(Exprn.toString(), ' '));
        //log.info("FormEquation:Exprn=" + Exprn);
        //System.out.println("FormEquationLocal:Exprn=" + Exprn);
        return Exprn.toString();
    }

    public static String FormEquationKey(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        String Exprn = MgtACoeff + " * " + TechDiffWithRespTo + "^" + (MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
            } else {
                Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff=GetPrimeNumber(MgtbCoeff,i);
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
        }
//        if (MgtbCoeff > 2) {
//            Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo;
//        } else {
//            Exprn = Exprn + " + " + TechDiffWithRespTo;
//        }
//        Exprn = Exprn + " + " + Xn + " + " + Mgtc;
        Exprn = eatAll(Exprn, ' ');
        //log.info("FormEquation:Exprn=" + Exprn);
        //System.out.println("FormEquation:Exprn=" + Exprn);
        return Exprn;
    }

    /* ****************************************************************************** */
    //Functions to Form Equation String End
    /* ****************************************************************************** */
    /**
     * ****************************************************
     */
    /**
     * ******************************* Random Generation Mechanisms Begin
     * *********************
     */
    /**
     * ****************************************************
     */
    /* ****************************************************************************** */
    ////Main Function End
    /* ****************************************************************************** */
    public static void main(String[] args) {
        Set1Function("m*x+c");
        PlainText = "abcdefghijklmnopqrstuvwxyzHelloMyDearWrongNumber";
        System.out.println("Hello World:Init:PlainTest Message=" + PlainText);
        Encryption();
        Decryption();
        System.out.println("Hello World:Decryption:DecodedPlainText=" + DecodedPlainText);
    }

    /* ****************************************************************************** */
    ////Main Function End
    /* ****************************************************************************** */
    public static void Encryption() {
        NumberOfChars = PlainText.length();
        NumberOfFunctions = PlainText.length();
        NumberOfKeyParts = PlainText.length();
        for (int i = 0; i < PlainText.length(); i++) {
            R_EncryptedCrytogram = R_EncryptedCrytogram + (char) (PlainText.charAt(i) - 'a') + ";@";
        }
        System.out.println("Encryption:R_EncryptedCrytogram=" + R_EncryptedCrytogram);
        //ConfusionFunctionValue((int)(ConfuseFunction2Value % NumberOfFunctions) );
        //DiffusionFunctionValue((int)(DiffusionFunction2Value % NumberOfKeyParts) );
    }

    public static void Decryption() {
        //DebugECryptogram();
        R_Region = new R_Region[NumberOfChars];
        long[] SecureCharMessage = new long[NumberOfChars];
        long DecryptionChar = 'a';
        DecryptDiffusionFromEnd();
        String[] TempCryptogram = R_EncryptedCrytogram.split(";@");
        System.out.println(" /* ****************************************************************************** */ :");
        System.out.println(" Main Mapping :");
        System.out.println(" /* ****************************************************************************** */ :");
        int j = 0;
        for (int i = 0; (i < NumberOfFunctions) && (i < TempCryptogram.length); i++) {
            long MyTempData = 0;
            for (int k = 0; (k < TempCryptogram[i].length()); k++) {
                if (MyTempData == 0) {
                    MyTempData = MyTempData + ((char) TempCryptogram[i].charAt(k) - '0');
                } else {
                    MyTempData = MyTempData * 10 + ((char) TempCryptogram[i].charAt(k) - '0');
                }
            }
            R_Region[i] = new R_Region();
            SetVariablesValues((int) MyTempData);
            SecureCharMessage[i] = (long) (DecryptionChar + R_Region[i].ParseEquation(i));
            //System.out.println("Hello World:Decryption:i=" + i + ":SecureChar:R=" + (char) SecureCharMessage[i] + " int=" + (int) SecureCharMessage[i]);
            //System.out.println("Hello World:Decryption:i=" + i + ":S=" + S.LCGexpValue.eval());
            DecodedPlainText += "" + (char) SecureCharMessage[i];
        }
    }

    

    public static void DecryptDiffusionFromEnd() {
        int i = 0;
        int j = 0;

        String[] TempCryptogram = R_EncryptedCrytogram.split(";@");
        long EncryptedDiffChar = ConverttoNumber(TempCryptogram, TempCryptogram.length - 1, 0);
        DecryptedDiffusedCrytogram = DecryptedDiffusedCrytogram + EncryptedDiffChar + ";@";
        for (i = TempCryptogram.length - 2; (i >= 0) && (i < TempCryptogram.length) && (TempCryptogram[i] != null); EncryptedDiffChar = 0, i--) {
            long MyTempData = 0;
            if (DiffusedNumberOfChars > 0) {
                MyTempData = SumEncodedChars(DecryptedDiffusedCrytogram, i, TempCryptogram.length - 1, TempCryptogram);
            }
            long MyTempDataCurrent = ConverttoNumber(TempCryptogram, i, 0);
            EncryptedDiffChar = MyTempDataCurrent - MyTempData;
            //System.out.println("DecryptDiffusionFromEnd:j=" + j + ":MyTempDataCurrent=" + MyTempDataCurrent + ":MyTempData=" + MyTempData + ":EncryptedDiffChar=" + (char) EncryptedDiffChar + " int=" + (int) EncryptedDiffChar + " PlainTextChar=" + TempCryptogram[i]);
            DecryptedDiffusedCrytogram = DecryptedDiffusedCrytogram + EncryptedDiffChar + ";@";
        }
        DecryptedDiffusedCrytogram = ReverseStr(DecryptedDiffusedCrytogram);
        R_EncryptedCrytogram = DecryptedDiffusedCrytogram;
        //System.out.println("Hello World:DecryptDiffusionFromEnd:Final:Cryptogram=t" + R_EncryptedCrytogram + "t");
    }

    public static long ConverttoNumber(String[] TempCryptogram, int i, long MyTempData) {
        if (i == 0) {
            for (int k = 0; (i == 0) && (k < TempCryptogram[i].length()); k++) {
                if (MyTempData == 0) {
                    MyTempData = MyTempData + ((char) TempCryptogram[i].charAt(k) - '0');
                } else {
                    MyTempData = MyTempData * 10 + ((char) TempCryptogram[i].charAt(k) - '0');
                }
            }
        } else {
            for (int k = 0; (i > 0) && (i < TempCryptogram.length) && (k < TempCryptogram[i].length()); k++) {
                if (MyTempData == 0) {
                    MyTempData = MyTempData + ((char) TempCryptogram[i].charAt(k) - '0');
                } else {
                    MyTempData = MyTempData * 10 + ((char) TempCryptogram[i].charAt(k) - '0');
                }
            }

        }
        return MyTempData;
    }

    public static long SumEncodedChars(String DecryptedCrytogram, int i, int MesgLength, String[] TempCryptogram) {
        long EncryptedDiffChar = 0;
        String[] CheatTempCryptogram = DecryptedCrytogram.split(";@");
        int y = CheatTempCryptogram.length;
        int k = 0;
        long z = 0;
        //System.out.println("SumPreviousChars:Init:i=" + i + ":MesgLength=" + MesgLength + " :length of Decoded Str=" + CheatTempCryptogram.length);
        if (i == MesgLength) {
            z = ConverttoNumber(TempCryptogram, (i - 1), 0);
            EncryptedDiffChar = z;
            //System.out.println("SumPreviousChars:z=" + z + ":MesgLength - 1:EncryptedDiffChar=" + (char) EncryptedDiffChar + " int=" + (int) EncryptedDiffChar + " DecryptedCrytogram=" + DecryptedCrytogram);
        } else {
            for (k = DiffusedNumberOfChars; (k > 0); k--) {
                EncryptedDiffChar += ConverttoNumber(CheatTempCryptogram, CheatTempCryptogram.length - k, 0);
                //System.out.println("SumPreviousChars:Loop:EncryptedDiffChar=" + (char) EncryptedDiffChar + " int=" + (int) EncryptedDiffChar + " DecryptedCrytogram=" + DecryptedCrytogram);
            }
        }
        //System.out.println("SumPreviousChars:Return Value:EncryptedDiffChar=" + (char) EncryptedDiffChar + " int=" + (int) EncryptedDiffChar + " DecryptedCrytogram=" + DecryptedCrytogram);
        return EncryptedDiffChar;
    }

    public static String ReverseStr(String DecryptedDiffusedCrytogram) {
        String[] TempDecryptReverse = DecryptedDiffusedCrytogram.split(";@");
        for (int k = 0; k < (TempDecryptReverse.length / 2); k++) {
            String SwapInit = TempDecryptReverse[k];
            TempDecryptReverse[k] = TempDecryptReverse[TempDecryptReverse.length - 1 - k];
            TempDecryptReverse[TempDecryptReverse.length - 1 - k] = SwapInit;
        }
        DecryptedDiffusedCrytogram = "";
        for (int k = 0; k < TempDecryptReverse.length; k++) {
            DecryptedDiffusedCrytogram = DecryptedDiffusedCrytogram + TempDecryptReverse[k] + ";@";
        }
        return DecryptedDiffusedCrytogram;
    }

}
