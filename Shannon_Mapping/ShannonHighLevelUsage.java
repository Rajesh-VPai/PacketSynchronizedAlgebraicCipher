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
package Shannon_Mapping;

import static Calculus.DiffrIntegrSep.MyFuncDiff;
import Calculus.MathsContxtLAv;
import Calculus.MathsExpressionParser;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.MathsExpressionParser.eatAll;
import static Calculus.MathsExpressionParser.parse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rajesh V Pai
 */
public class ShannonHighLevelUsage {

    public static E_Mapping[] E = null;
    public static K_Mapping[] K = null;
    private static R_Region[] R_Region = null;
    private static S_Mapping S = null;
    public static Map<String, Double> variables = new HashMap<>();
    private static int MaxExponentORTerms = 3;

    public static int NumberOfFunctions = 26;
    public static int NumberOfKeyParts = 26;
    public static int NumberOfChars = 100;
    public static int DiffusedNumberOfChars = 8;

    public static String PlainText = "";
    public static String DiffusedCrytogram = "";
    public static String DecryptedDiffusedCrytogram = "";
    public static String R_EncryptedCrytogram = "";
    public static String DecodedPlainText = "";

    public static Long[] EvenArray = new Long[100000];
    public static int EvenLastIndex = 1;
    public static int EvenIssuedLCGPrimeNumber = 1;

    public static Long[] OddArray = new Long[100000];
    public static int OddLastIndex = 1;
    public static int OddIssuedLCGPrimeNumber = 1;

    public static Long[] PrimeArray = new Long[10000];
    public static int LastIndex = 1;
    public static int IssuedLCGPrimeNumber = 1;

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
    public static void ComputeConfusion() {
        for (int i = 0; i < NumberOfFunctions; i++) {
            //System.out.println("Hello World:i=" + i + ":ComputeConfusion:E=" + E[i].LCGexpValue.eval());
            if (i < NumberOfKeyParts) {
                ;//System.out.println("Hello World:i=" + i + ":ComputeConfusion:Key=" + K[i].LCGexpValue.eval());
            }
        }
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

    static String FormEquationKey(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
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
 /* ****************************************************************************** */
    //Functions to generate Odd and Even and Prime Numbers just below MaxValue Begin
    /* ****************************************************************************** */
    public static long PrimeNumber(long MaxValue) {
        long Prime = 0;
        long number = 1;
        PrimeArray[0] = (long)2;
        int i = 0;
        for (number = 3; number < MaxValue; number += 2) {
            for (i = 0; i < LastIndex;) {
                if ((number % PrimeArray[i]) == 0) {
                    break;
                } else if (i > (6 * Math.sqrt(number))) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == LastIndex) {
                PrimeArray[LastIndex++] = number;
            }
        }
        Prime = PrimeArray[LastIndex - 1];
        return Prime;
    }

    public static long NextPrimeNumber(long MaxValue) {
        long Prime = 0;
        if (IssuedLCGPrimeNumber < PrimeArray.length) {
            Prime = PrimeArray[IssuedLCGPrimeNumber++];
        }
        return Prime;
    }

    public static long GetPrimeNumber(long MaxValue, int j) {
        long Prime = 0;
        for (int i = LastIndex - 1; (i >= 0); i--) {
            if (MaxValue <= PrimeArray[i]) {
                Prime = PrimeArray[i - 1];
            }
        }
        return Prime;
    }

    public static long OddNumber(long MaxValue) {
        long Odd = 0;
        long number = 1;
        OddArray[0] =  (long)2;
        int i = 0;
        for (number = 1; number < MaxValue; number += 2, i++) {
            if (i == OddLastIndex) {
                OddArray[OddLastIndex++] = number;
            }
        }
        Odd = OddArray[OddLastIndex - 1];
        return Odd;
    }

    public static long NextOddNumber(long MaxValue) {
        long Odd = 0;
        if (OddIssuedLCGPrimeNumber < OddArray.length) {
            Odd = OddArray[OddIssuedLCGPrimeNumber++];
        }
        return Odd;
    }

    public static long EvenNumber(long MaxValue) {
        long Even = 0;
        long number = 1;
        EvenArray[0] = (long)2;
        int i = 0;
        for (number = 0; number < MaxValue; number += 2, i++) {
            if (i == EvenLastIndex) {
                EvenArray[EvenLastIndex++] = number;
            }
        }
        Even = EvenArray[EvenLastIndex - 1];
        return Even;
    }

    public static long NextEvenNumber(long MaxValue) {
        long Prime = 0;
        if (EvenIssuedLCGPrimeNumber < EvenArray.length) {
            Prime = EvenArray[EvenIssuedLCGPrimeNumber++];
        }
        return Prime;
    }

    /* ****************************************************************************** */
    //Functions to generate Odd and Even and Prime Numbers just below MaxValue End
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
        EvenNumber(100000);
        PrimeNumber(100000);
        OddNumber(100000);
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
        Confusion();
        Diffusion();
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

    public static void Confusion() {
        InitEquationVar();
        SetFunctions("m*x+c");
        SetKeyParts("m*keyx+c");
        ComputeConfusion();
    }

    public static void Diffusion() {
        int i = 0;
        int j = 0;
        long DiffusedSumChar = 0;

        String[] TempCryptogram = R_EncryptedCrytogram.split(";@");
        for (i = 0; (i < TempCryptogram.length) && (TempCryptogram[i] != null); DiffusedSumChar = 0, i++) {
            //System.out.println("Hello World:Diffusion:Before:i=" + i + ":EncryptedChar=" + (char) DiffusedSumChar + " int=" + (int) (DiffusedSumChar) );
            for (j = i; j <= (i + DiffusedNumberOfChars) && (j < TempCryptogram.length); j++) {
                long MyTempData = 0;
                for (int k = 0; (k < TempCryptogram[j].length()); k++) {
                    if (MyTempData == 0) {
                        MyTempData = MyTempData + (char) TempCryptogram[j].charAt(k);
                    } else {
                        MyTempData = MyTempData * 10 + (char) TempCryptogram[j].charAt(k);
                    }
                    DiffusedSumChar += (char) MyTempData;
                }
            }
            //System.out.println("Hello World:Diffusion:After:i=" + i + " int=" + (int) (DiffusedSumChar) + " TempCryptogram[i]=" + TempCryptogram[i]);
            DiffusedCrytogram = DiffusedCrytogram + DiffusedSumChar + ";@";
        }
        // Copy the remaining characters of TempCryptogram
        if (j <= (i + DiffusedNumberOfChars)) {
            for (int k = j; k < (TempCryptogram.length); k++) {
                DiffusedCrytogram = DiffusedCrytogram + TempCryptogram[k] + ";@";
            }
        }
        R_EncryptedCrytogram = DiffusedCrytogram;
        //System.out.println("Hello World:Diffusion:Cryptogram=" + R_EncryptedCrytogram);
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
