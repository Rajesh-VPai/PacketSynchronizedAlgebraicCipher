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
package Security;

import Calculus.ConsoleColors;
import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.parse;
import RandomNumber.RandomFactorialLCGDyDx;
import RandomNumber.RandomSimpleLCG;
import static RandomNumber.UserResearchStudy.SeedSimple;
import static Security.Configuration.FOBRandomChar;
import static Security.Configuration.PRAGMA;
import static Security.Configuration.PRAGMADetail;
import static Security.Decryption.DecryptPerfFLAG;
import static Security.Decryption.DecryptStrFuncTimeTaken;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.EncryptPerfFLAG;
import static Security.Encryption.EncryptStrFuncTimeTaken;
import static Security.Encryption.EncryptedMesg;
import static Security.Encryption.MyMessage;
import static Security.EquationPairGeneration.aSecretValue;
import static Security.EquationPairGeneration.bSecretValue;
import static Security.EquationPairGeneration.cSecretValue;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.eSecretValue;
import static Security.EquationPairGeneration.pSecretValue;
import static Security.EquationPairGeneration.qSecretValue;
import static Security.EquationPairGeneration.rSecretValue;
import static Security.EquationPairGeneration.sSecret;
import static Security.EquationPairGeneration.sSecretValue;
import static Security.EquationPairGeneration.zSecret;
import static Security.LowLevelSecurityFramework.Scram;
import static Security.LowLevelSecurityFramework.ScramVarGap;
import static Security.LowLevelSecurityFramework.TheFOBRandomCharScram;
import static Security.LowLevelSecurityFramework.UnScram;
import static Security.LowLevelSecurityFramework.UnScramVarGap;
import static Security.PSACKeyVaultNew.KeyCombinationEqn;
import static Security.PSACKeyVaultNew.KeyReverseEnggEqn;
import static Security.PacketSynchronizedAlgebraicCipher.SuppressSystemOutput;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class Security {

    public static Logger log = Logger.getLogger(Security.class.getName());
    //Key Variables
    public static PSACKeyVaultNew AliceKeyPair = null;
    public static MathsRelations AliceEquation1;

    public static PSACKeyVaultNew BobKeyPair = null;
    public static MathsRelations BobEquation1;

    public static MathsRelations Equation1;

    public static int FixedLength = 10;
    //Random Number Generator Parameters
    public static RandomSimpleLCG MySimple = null;
    public static RandomSimpleLCG MySimpleWeiBull = null;
    public static RandomFactorialLCGDyDx MyFactorial = null;
    public static String SeedGenFormula = "x";
    public static long Xn_LCG = 3;
    // Mathematical Relation Variables
    public static Map<String, Double> variables = new HashMap<>();
    public static Map<String, Double> variablesEncrypt = new HashMap<>();
    public static Map<String, Double> variablesDecrypt = new HashMap<>();
    public static Map<String, Double> varOccassion = new HashMap<>();
    public static Map<String, String> variablesDiff = new HashMap<>();
    public static Map<String, String> variablesStr = new HashMap<>();

    // Encrpytion Decryption Variables
    public static Double Mychar = 'a' * 1.0;

    public static Double DecryptedByte = 0.0;
    public static Double EncryptedByte = 0.0;

    // Equations
    public static String ScramVarGapExprn = "";

    // Test Case Variables
    public static String MyPublicKey = "";
    public static String MyPublicKeyHighLevel = "";
    public static String MyPrivateKey = "";
    public static String MyPublicEquation = "";
    public static String MyDecrptionEquation = "";
    public static String MyMessage2 = "";
    public static String EncryptedMesgEntropy = "";
    public static String DecryptedMesgEntropy = "";

    // RSA Encrption Case Variables
    //public static String p = "";
    //public static String q = "";
    //public static String dec = "";//Encryption Equation
    //public static String dcb = "";//Decryption Equation
//     
//  //Context Variables
    public static Double MDivisor = 1.0;
    public static Double MDivisorTCP = 1.0;
    public static Double MDivisorWeiBull = 1.0;
    public static Double CConstant = 0.0;
    public static Double mult_div = 1.0;
    public static Double constant = 0.0;

    static String RunNumber = "0007";

    public static Double EncryptPKIAliceKeyDiffr(int Mychar) {
        String DiffExprn = "";
        String MyDiffWithRespTo = "Xn";
        Double initMDivisor = 10E250;
        Double initCConstant = 10000.0;
        Double initmult_div = 1.0;
        Double initconstant = 10000.0;
        AliceEquation1 = new MathsRelations();
        AliceEquation1.SetDiffWithRespTo(MyDiffWithRespTo);
        variablesEncrypt.put("m", (Double.parseDouble(MyPublicKey) + Double.parseDouble(MyPrivateKey)));
        System.out.println("Security:EncryptPKIALiceKey:AliceEquation1:m=" + variablesEncrypt.get("m"));
        variablesEncrypt.put(MyDiffWithRespTo, Mychar * 1.0);
        Mychar = (variablesEncrypt.get(MyDiffWithRespTo)).intValue();
        variablesEncrypt.put("c", 1.0 * SeedSimple);
        AliceEquation1.initExprn(MyPublicEquation, variablesEncrypt, MyDiffWithRespTo);
        System.out.println("Security:EncryptPKIALiceKey:AliceEquation1:PublicEquation=" + MyPublicEquation);
        EncryptedByte = AliceEquation1.CalculateExprn();
        AliceEquation1.initDiffExprn(MyPublicEquation);
        DiffExprn = AliceEquation1.CalculateDiffExprn(MyPublicEquation);
        System.out.println("Security:EncryptPKIALiceKey:AliceEquation1:DiffExprn=" + DiffExprn);
        System.out.println("Security:EncryptPKIALiceKey:AliceEquation1:EncryptedByte=" + EncryptedByte + " plainText=" + variablesEncrypt.get(MyDiffWithRespTo) + " char=" + (char) Mychar);
        return EncryptedByte;
    }

    public static Double DecryptPKIAliceKeyDiffr(Double Value) {
        double DecryptedByte = 0;
        String DiffExprn = "";
        String MyDiffWithRespTo = "y";
        Double initMDivisor = 10E250;
        Double initCConstant = 10000.0;
        Double initmult_div = 10000.0;
        Double initconstant = 10000.0;
        AliceEquation1 = new MathsRelations();
        AliceEquation1.SetDiffWithRespTo(MyDiffWithRespTo);
        variablesDecrypt.put("m", (Double.parseDouble(MyPublicKey) + Double.parseDouble(MyPrivateKey)));
        System.out.println("Security:DecryptPKIAliceKey:AliceEquation1:m=" + variablesDecrypt.get("m"));
        variablesDecrypt.put(MyDiffWithRespTo, 1.0 * Value);
        variablesDecrypt.put("c", 1.0 * SeedSimple);
        System.out.println("Security:DecryptPKIALiceKey:AliceEquation1:DecrptionEquation=" + MyDecrptionEquation);
        AliceEquation1.initExprn(MyDecrptionEquation, variablesDecrypt, MyDiffWithRespTo);
        DecryptedByte = AliceEquation1.CalculateExprn();
        //DecryptedByte=AliceEquation1.CalculateExprn();
        AliceEquation1.initDiffExprn(MyDecrptionEquation);
        DiffExprn = AliceEquation1.CalculateDiffExprn(MyDecrptionEquation);
        System.out.println("Security:DecryptPKIALiceKey:AliceEquation1:DiffExprn=" + DiffExprn);
        System.out.println("Security:DecryptPKIALiceKey:AliceEquation1:Decrypt:DecryptedByte=" + DecryptedByte + " plainText=" + variablesDecrypt.get(MyDiffWithRespTo) + " char=" + (char) DecryptedByte);
        return DecryptedByte;
    }

    public static Double EncryptPKIBobKeyDiffr(int Mychar) {
        String DiffExprn = "";
        String MyDiffWithRespTo = "Xn";
        Double initMDivisor = 10E250;
        Double initCConstant = 10000.0;
        Double initmult_div = 1.0;
        Double initconstant = 10000.0;
        BobEquation1 = new MathsRelations();
        BobEquation1.SetDiffWithRespTo(MyDiffWithRespTo);
        variablesEncrypt.put("m", (Double.parseDouble(MyPublicKey) + Double.parseDouble(MyPrivateKey)) / initMDivisor);
        System.out.println("Security:EncryptPKIBobKey:BobEquation1:m=" + variablesEncrypt.get("m"));
        variablesEncrypt.put(MyDiffWithRespTo, Mychar * 1.0);
        Mychar = (variablesEncrypt.get(MyDiffWithRespTo)).intValue();
        variablesEncrypt.put("c", 1.0 * SeedSimple);
        BobEquation1.initExprn(MyPublicEquation, variablesEncrypt, MyDiffWithRespTo);
        System.out.println("Security:EncryptPKIBobKey:BobEquation1:PublicEquation=" + MyPublicEquation);
        EncryptedByte = BobEquation1.CalculateExprn();
        BobEquation1.initDiffExprn(MyPublicEquation);
        DiffExprn = BobEquation1.CalculateDiffExprn(MyPublicEquation);
        System.out.println("Security:EncryptPKIBobKey:BobEquation1:DiffExprn=" + DiffExprn);

        System.out.println("Security:EncryptPKIBobKey:BobEquation1:EncryptedByte=" + EncryptedByte + " plainText=" + variablesEncrypt.get(MyDiffWithRespTo) + " char=" + (char) Mychar);
        return EncryptedByte;
    }

    public static Double DecryptPKIBobKeyDiffr(Double Value) {
        Double DecryptedByte = 0.0;
        String DiffExprn = "";
        String MyDiffWithRespTo = "y";
        Double initMDivisor = 10E250;
        Double initCConstant = 10000.0;
        Double initmult_div = 10000.0;
        Double initconstant = 10000.0;
        BobEquation1 = new MathsRelations();
        BobEquation1.SetDiffWithRespTo(MyDiffWithRespTo);
        System.out.println("Security:DecryptPKIBobKey:BobEquation1:DecrptionEquation=" + MyDecrptionEquation);
        variablesDecrypt.put("m", (Double.parseDouble(MyPublicKey) + Double.parseDouble(MyPrivateKey)) / initMDivisor);
        System.out.println("Security:DecryptPKIBobKey:BobEquation1:m=" + variablesDecrypt.get("m"));
        variablesDecrypt.put(MyDiffWithRespTo, Value);
        variablesDecrypt.put("c", 1.0 * SeedSimple);
        BobEquation1.initExprn(MyDecrptionEquation, variablesDecrypt, MyDiffWithRespTo);
        DecryptedByte = BobEquation1.CalculateExprn();
        BobEquation1.initDiffExprn(MyDecrptionEquation);
        DiffExprn = BobEquation1.CalculateDiffExprn(MyDecrptionEquation);
        System.out.println("Security:DecryptPKIBobKey:BobEquation1:DiffExprn=" + DiffExprn);
        System.out.println("Security:DecryptPKIBobKey:Decrypt:DecryptedByte=" + DecryptedByte + " plainText=" + variablesDecrypt.get(MyDiffWithRespTo) + " char=" + (char) DecryptedByte.intValue());
        return DecryptedByte;
    }

    public static void StudyOfAliceBobPKI() {
        System.out.println("StudyOfAliceBobPKI:");
        String EqnUnderTest = "m*Xn^5+c";
        String InverseEqnUnderTest = "((y-c)/m)^(1/5)";
        int Mychar = 'a';
        System.out.println("StudyOfAliceBobPKI:Alice To Bob");
        System.out.println("StudyOfAliceBobPKI:Bob-MyPublicKey:Alice-MyPrivKey:" + BobKeyPair.getPublicKey("Encrypt") + " : " + AliceKeyPair.getPrivateKey("Encrypt"));
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        Double Value = EncryptPKIAliceKeyDiffr(Mychar);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        System.out.println(System.lineSeparator());
        System.out.println("StudyOfAliceBobPKI:Alice-MyPublicKey:Bob-MyPrivKey:" + AliceKeyPair.getPublicKey("Decrypt") + " : " + BobKeyPair.getPrivateKey("Decrypt"));
        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        Double DecryptedByte = DecryptPKIBobKeyDiffr(Value);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        DecryptedByte = (double) Math.round(DecryptedByte);
        System.out.println(System.lineSeparator());
        if (Mychar == Math.rint(DecryptedByte)) {
            System.out.println(ConsoleColors.GREEN + "StudyOfAliceBobPKI:Alice To Bob:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfAliceBobPKI:Alice To Bob:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }

        System.out.println("StudyOfAliceBobPKI:Bob To Alice");
        System.out.println("StudyOfAliceBobPKI:MyPublicKey:MyPrivKey:" + AliceKeyPair.getPublicKey("Encrypt") + " : " + BobKeyPair.getPrivateKey("Encrypt"));
        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        Value = EncryptPKIBobKeyDiffr(Mychar);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        System.out.println(System.lineSeparator());
        System.out.println("StudyOfAliceBobPKI:MyPublicKey:MyPrivKey:" + BobKeyPair.getPublicKey("Decrypt") + " : " + AliceKeyPair.getPrivateKey("Decrypt"));
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        DecryptedByte = DecryptPKIAliceKeyDiffr(Value);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        if (Mychar == Math.rint(DecryptedByte)) {
            System.out.println(ConsoleColors.GREEN + "StudyOfAliceBobPKI:Bob To Alice:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfAliceBobPKI:Bob To Alice:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }

    }

    public static void StudyOfAliceBobPKILin() {
        System.out.println("StudyOfAliceBobPKILin:");
        String EqnUnderTest = "m*Xn+c";
        String InverseEqnUnderTest = "y/m-c/m";
        int Mychar = 'a';
        System.out.println("StudyOfAliceBobPKILin:Alice To Bob");
        System.out.println("StudyOfAliceBobPKILin:Bob-MyPublicKey:Alice-MyPrivKey:" + BobKeyPair.getPublicKey("Encrypt") + " : " + AliceKeyPair.getPrivateKey("Encrypt"));
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        Double Value = EncryptPKIAliceKeyDiffr(Mychar);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        System.out.println(System.lineSeparator());
        System.out.println("StudyOfAliceBobPKILin:Alice-MyPublicKey:Bob-MyPrivKey:" + AliceKeyPair.getPublicKey("Decrypt") + " : " + BobKeyPair.getPrivateKey("Decrypt"));
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        Double DecryptedByte = DecryptPKIBobKeyDiffr(Value);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        if (Mychar == Math.rint(DecryptedByte)) {
            System.out.println(ConsoleColors.GREEN + "StudyOfAliceBobPKILin:Alice To Bob:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfAliceBobPKILin:Alice To Bob:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println(System.lineSeparator());
        System.out.println("StudyOfAliceBobPKILin:Bob To Alice");
        System.out.println("StudyOfAliceBobPKILin:Alice-MyPublicKey:Bob-MyPrivKey:" + AliceKeyPair.getPublicKey("Encrypt") + " : " + BobKeyPair.getPrivateKey("Encrypt"));
        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        Value = EncryptPKIBobKeyDiffr(Mychar);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        System.out.println(System.lineSeparator());
        System.out.println("StudyOfAliceBobPKILin:Bob-MyPublicKey:Alice-MyPrivKey:" + BobKeyPair.getPublicKey("Decrypt") + " : " + AliceKeyPair.getPrivateKey("Decrypt"));
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIAliceKeyDiffr(Value);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        if (Mychar == Math.rint(DecryptedByte)) {
            System.out.println(ConsoleColors.GREEN + "StudyOfAliceBobPKILin:Bob To Alice:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfAliceBobPKILin:Bob To Alice:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println(System.lineSeparator());
    }
    // Values Decryption

    public static Double EncryptPKIValues(int Mychar, Double MDivisor, Double CConstant, Double constant, boolean SilentFlag) {
        //SilentFlag=false;
        String MyDiffWithRespTo = "Xn";
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        if (Mychar < 0)
            System.out.println(ConsoleColors.RED + "Mychar:WARN Mapped Input is Negative UNUSABLE:Mychar=" + Mychar + ConsoleColors.RESET);
        Equation1 = new MathsRelations();
        Equation1.SetDiffWithRespTo(MyDiffWithRespTo);
        variablesEncrypt.put("n", 1.0E280);

        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));

        variablesEncrypt.put("A", 1.0e200);
        EncryptedByte = 0.0;
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, MyDiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
        variablesEncrypt.put("m", 1000.0 + RemoveVariationInM("" + LCGexpValue.eval()));
        variablesEncrypt.put("c", 1.0 * (constant + CConstant));
        String TempM = "" + variablesEncrypt.get("m");
        if ((TempM.equalsIgnoreCase("Infinity"))
                || (TempM.equalsIgnoreCase("-Infinity"))
                || (TempM.equalsIgnoreCase("null"))
                || (TempM.equalsIgnoreCase("NaN"))) {
            System.out.println(ConsoleColors.RED + "EncryptPKIValues:m:WARN m UNUSABLE:m=" + TempM + " m=" + variablesEncrypt.get("m") + ConsoleColors.RESET);
        }
        Double N = AliceKeyPair.getN("Encrypt");
        String TempN = "" + variablesEncrypt.get("N");
        if ((TempN.equalsIgnoreCase("Infinity"))
                || (TempN.equalsIgnoreCase("null"))
                || (TempN.equalsIgnoreCase("-Infinity"))
                || (TempN.equalsIgnoreCase("NaN"))) {
            System.out.println(ConsoleColors.RED + "EncryptPKIValues:N:WARN m UNUSABLE:N=" + TempN + ConsoleColors.RESET);
        }
        if (SilentFlag == false) {
            System.out.println("Security:EncryptPKIValues:Equation1:m=" + variablesEncrypt.get("m") + " MyDiffWithRespTo=" + MyDiffWithRespTo + " n=" + variablesEncrypt.get("n") + " c=" + variablesEncrypt.get("c") + " MDivisor=" + MDivisor + " CConstant=" + CConstant + " constant=" + constant + " MyPublicEquation=" + MyPublicEquation + " Mychar=" + (char) Mychar);
        }
        variablesEncrypt.put(MyDiffWithRespTo, Mychar * 1.0);
        Mychar = (variablesEncrypt.get(MyDiffWithRespTo)).intValue();
        PutHiddenValuesEncrypt();
        MappingContextCheckEncrypt();
        if (SilentFlag == false) {
            System.out.println(ConsoleColors.BLUE + "Security:EncryptPKIValues:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "Security:EncryptPKIValues:MyDecrptionEquation=" + MyDecrptionEquation + " MyPublicEquation=" + MyPublicEquation + ConsoleColors.RESET);
        }
        Equation1.initExprn(MyPublicEquation, variablesEncrypt, MyDiffWithRespTo);
        EncryptedByte = Equation1.CalculateExprn();
        if (SilentFlag == false) {
            System.out.println("Security:EncryptPKIValues:Equation1:EncryptedByte=" + EncryptedByte + " plainText=" + variablesEncrypt.get(MyDiffWithRespTo) + " char=" + (char) Mychar + " N=" + variablesEncrypt.get("N"));
        }
        String TempEncrypByte = "" + EncryptedByte;
        if ((TempEncrypByte.equalsIgnoreCase("Infinity"))
                || (TempEncrypByte.equalsIgnoreCase("-Infinity"))
                || (TempEncrypByte.equalsIgnoreCase("NaN"))) {
            System.out.println(ConsoleColors.RED + "EncryptPKIValues:TempEncrypByte:WARN m UNUSABLE:TempEncrypByte=" + TempEncrypByte + " MyPublicEquation=" + MyPublicEquation + ConsoleColors.RESET);
        }
        variablesEncrypt.remove(MyDiffWithRespTo);
        variablesEncrypt.remove("A");
        variablesEncrypt.remove("n");
        variablesEncrypt.remove("c");
        //variables.remove("m");
        variablesEncrypt.remove("privkey");
        variablesEncrypt.remove("pubkey");
        if (EncryptedByte < 0)
            System.out.println(ConsoleColors.RED + "Mychar:WARN Mapped Input is Negative UNUSABLE:EncryptedByte=" + EncryptedByte + ConsoleColors.RESET);
        return EncryptedByte;
    }

    public static void MappingContextCheckEncrypt() {
        if (MyPublicEquation.contains("z")) {
            variablesEncrypt.put("z", (double) zSecret);
        }
        if (MyPublicEquation.contains("s")) {
            variablesEncrypt.put("s", (double) sSecret);
        }
        if (MyPublicEquation.contains("z")) {
            variablesEncrypt.put("z", (double) zSecret);
        } else if ((MyPublicEquation.contains("z")) && (!variablesEncrypt.containsKey("z"))) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN z UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if (MyPublicEquation.contains("s")) {
            variablesEncrypt.put("s", (double) sSecret);
        } else if ((MyPublicEquation.contains("s")) && (!variablesEncrypt.containsKey("s"))) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN s UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if ((MyPublicEquation.contains("m")) && variablesEncrypt.containsKey("m"))
            ; else if (MyPublicEquation.contains("m")) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN m UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if ((MyPublicEquation.contains("a")) && variablesEncrypt.containsKey("a"))
            ; else if (MyPublicEquation.contains("a")) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN a UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if ((MyPublicEquation.contains("c")) && variablesEncrypt.containsKey("c"))
            ; else if (MyPublicEquation.contains("c")) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN c UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
    }

    public static void PutHiddenValuesEncrypt() {
        variablesEncrypt.put("a", (double) aSecretValue);
        //variablesEncrypt.put("c", (double) cSecretValue);// Depends on EquationUnderTest
        if (!(variablesEncrypt.containsKey("b"))) {
            variablesEncrypt.put("b", (double) bSecretValue);
        }
        if (!(variablesEncrypt.containsKey("d"))) {
            variablesEncrypt.put("d", (double) dSecretValue);
        }
        if (!(variablesEncrypt.containsKey("e"))) {
            variablesEncrypt.put("e", (double) eSecretValue);
        }
        if (!(variablesEncrypt.containsKey("r"))) {
            variablesEncrypt.put("r", (double) rSecretValue);
        }
        if (!(variablesEncrypt.containsKey("s"))) {
            variablesEncrypt.put("s", (double) sSecretValue);
        }
        if (!(variablesEncrypt.containsKey("p"))) {
            variablesEncrypt.put("p", (double) pSecretValue);
        }
        if (!(variablesEncrypt.containsKey("q"))) {
            variablesEncrypt.put("q", (double) qSecretValue);
        }
    }

    public static Double DecryptPKIValues(Double Value, Double MDivisor, Double CConstant, Double multiplier, Double constant, boolean SilentFlag) {
        //SilentFlag=false;
        Double DecryptedByte = 0.0;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        String DiffExprn = "";
        String MyDiffWithRespTo = "y";
        Double ConstantOfMapping = 4.0;
        if (SilentFlag == false) {
            System.out.println("Security:DecryptPKIValues:Equation1:DecrptionEquation=" + MyDecrptionEquation + " Value(" + MyDiffWithRespTo + ")=" + Value);
        }
        Equation1 = new MathsRelations();
        Equation1.SetDiffWithRespTo(MyDiffWithRespTo);
        ;
        variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        variablesDecrypt.put("A", 1.0e200);
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, MyDiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
        variablesDecrypt.put("n", 1.0E7);
        variablesDecrypt.put("m", 1000.0 + RemoveVariationInM("" + LCGexpValue.eval()));
        variablesDecrypt.put("c", 1.0 * (constant + CConstant));
        PutHiddenValuesDecrypt();
        
        variablesDecrypt.put(MyDiffWithRespTo, 1.0 * Value);
        MappingContextCheckDecrypt();
        if (SilentFlag == false) {
            System.out.println(ConsoleColors.BLUE + "DecryptPKIValues:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "DecryptPKIValues:MyDecrptionEquation=" + MyDecrptionEquation + " MyPublicEquation+" + MyPublicEquation + ConsoleColors.RESET);
        }
        Equation1.initExprn(MyDecrptionEquation, variablesDecrypt, MyDiffWithRespTo);
        String TempM = "" + variablesDecrypt.get("m");
        if ((TempM.equalsIgnoreCase("Infinity"))
                || (TempM.equalsIgnoreCase("null"))
                || (TempM.equalsIgnoreCase("-Infinity"))
                || (TempM.equalsIgnoreCase("NaN"))) {
            System.out.println(ConsoleColors.RED + "DecryptPKIValues:m:WARN m UNUSABLE:m=" + TempM + ConsoleColors.RESET);
        }
        Double N = BobKeyPair.getN("Decrypt");
        String TempN = "" + variablesDecrypt.get("N");
        if ((TempN.equalsIgnoreCase("Infinity"))
                || (TempN.equalsIgnoreCase("null"))
                || (TempN.equalsIgnoreCase("-Infinity"))
                || (TempN.equalsIgnoreCase("NaN"))) {
            System.out.println(ConsoleColors.RED + "DecryptPKIValues:N:WARN m UNUSABLE:N=" + TempN + ConsoleColors.RESET);
        }
        //DecryptedByte=10000*AliceEquation1.CalculateExprn();
        // Eliminate Numerical Noise in m && Decryption Process by using Math.rint
        Double Xn = Equation1.CalculateExprn();
        DecryptedByte = Math.rint(Xn);
        if (SilentFlag == false) {
            System.out.println("Security:DecryptPKIValues:Equation1:m=" + variablesDecrypt.get("m") + " n=" + variablesDecrypt.get("n") + " c=" + variablesDecrypt.get("c") + " MDivisor=" + MDivisor + " CConstant=" + CConstant + " multiplier=" + multiplier + " constant=" + constant + " MyDecrptionEquation=" + MyDecrptionEquation + " DecryptedByte=" + DecryptedByte);
        }
        if (SilentFlag == false) {
            System.out.println("Security:DecryptPKIValues:Equation1:Decrypt:DecryptedByte=" + DecryptedByte + " plainText=" + variablesDecrypt.get(MyDiffWithRespTo) + " Xn=" + Xn + " char=" + (char) DecryptedByte.byteValue() + " N=" + variablesDecrypt.get("N"));
        }
        String TempDecrypByte = "" + DecryptedByte;
        if ((TempDecrypByte.equalsIgnoreCase("Infinity"))
                || (TempDecrypByte.equalsIgnoreCase("-Infinity"))
                || (TempDecrypByte.equalsIgnoreCase("NaN"))) {
            System.out.println(ConsoleColors.RED + "TempDecrypByte:WARN m UNUSABLE:TempDecrypByte=" + TempDecrypByte + ConsoleColors.RESET);
        }
        if (DecryptedByte < 0)
            System.out.println(ConsoleColors.RED + "TempDecrypByte:WARN Mapped Output is Negative UNUSABLE:TempDecrypByte=" + TempDecrypByte + ConsoleColors.RESET);
        MaliciousMalloryBob(Value, DecryptedByte, LCGexpValue);
        MaliciousMalloryAlice(Value, DecryptedByte, LCGexpValue);
        variablesDecrypt.remove(MyDiffWithRespTo);
        variablesDecrypt.remove("A");
        variablesDecrypt.remove("n");
        variablesDecrypt.remove("c");
        //variables.remove("m");
        variablesDecrypt.remove("privkey");
        variablesDecrypt.remove("pubkey");
        return DecryptedByte;
    }

    public static void MappingContextCheckDecrypt() {
        if (MyDecrptionEquation.contains("z")) {
            variablesDecrypt.put("z", (double) zSecret);
        }
        if (MyDecrptionEquation.contains("s")) {
            variablesDecrypt.put("s", (double) sSecret);
        }

        if (MyDecrptionEquation.contains("z")) {
            variablesDecrypt.put("z", (double) zSecret);
        } else if ((MyDecrptionEquation.contains("z")) && (!variablesDecrypt.containsKey("z"))) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN z UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if (MyDecrptionEquation.contains("s")) {
            variables.put("s", (double) sSecret);
        } else if ((MyDecrptionEquation.contains("s")) && (!variablesDecrypt.containsKey("s"))) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN s UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if ((MyDecrptionEquation.contains("m")) && variablesDecrypt.containsKey("m"))
            ; else if (MyDecrptionEquation.contains("m")) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN m UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if ((MyDecrptionEquation.contains("a")) && variablesDecrypt.containsKey("a"))
            ; else if (MyDecrptionEquation.contains("a")) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN a UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
        if ((MyDecrptionEquation.contains("c")) && variablesDecrypt.containsKey("c"))
            ; else if (MyDecrptionEquation.contains("c")) {
            System.out.println(Calculus.ConsoleColors.RED + "WARN c UNUSABLE" + Calculus.ConsoleColors.RESET);
        }
    }

    public static void PutHiddenValuesDecrypt() {
        //variablesDecrypt.put("c", (double)cSecretValue);// Depends on EquationUnderTest
        variablesDecrypt.put("a", (double) aSecretValue);

        if (!(variablesDecrypt.containsKey("b"))) {
            variablesDecrypt.put("b", (double) bSecretValue);
        }
        if (!(variablesDecrypt.containsKey("d"))) {
            variablesDecrypt.put("d", (double) dSecretValue);
        }
        if (!(variablesDecrypt.containsKey("e"))) {
            variablesDecrypt.put("e", (double) eSecretValue);
        }
        if (!(variablesDecrypt.containsKey("r"))) {
            variablesDecrypt.put("r", (double) rSecretValue);
        }
        if (!(variablesDecrypt.containsKey("s"))) {
            variablesDecrypt.put("s", (double) sSecretValue);
        }
        if (!(variablesDecrypt.containsKey("p"))) {
            variablesDecrypt.put("p", (double) pSecretValue);
        }
        if (!(variablesDecrypt.containsKey("q"))) {
            variablesDecrypt.put("q", (double) qSecretValue);
        }

    }

    public static Double RemoveVariationInM(String Key) {
        Double TempCalibrate = Double.parseDouble(Key);
        String ProcessesedStrM = "";
        String ProcessesedStrEXP = "";
        String[] DataTemp;
        String StrTempCal = "" + TempCalibrate;
        if (StrTempCal.contains("e")) {
            DataTemp = StrTempCal.split("e");
            if (DataTemp.length == 2) {
                ProcessesedStrM = DataTemp[0];
                ProcessesedStrEXP = DataTemp[1];
            }
        } else if (StrTempCal.contains("E")) {
            DataTemp = StrTempCal.split("E");
            if (DataTemp.length == 2) {
                ProcessesedStrM = DataTemp[0];
                ProcessesedStrEXP = DataTemp[1];
            }
        }
        if (!ProcessesedStrEXP.equalsIgnoreCase("")) {
            return Double.parseDouble(ProcessesedStrEXP);
        } else {
            return TempCalibrate;
        }
    }

    public static void ShannonConfuseEncrypt(String ExprnDiffusion, String ExprnSurprise, String DiffWithRespToDiffusion, String DiffWithRespToSurprise, boolean SilentFlag) {
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        for (int i = 0; i < MyMessage.length(); i++) {
            Mychar = MyMessage.charAt(i) * 1.0;
            Value = EncryptPKIValues(Mychar.intValue(), 10E10, 10000.0, 10000.0, SilentFlag);
//            ValueDiffusion = ShannonEncryption("MessageShannon", Value, ExprnDiffusion, DiffWithRespToDiffusion);
//            if (ValueDiffusion != 0.0) {
//                Value = ValueDiffusion;
//            }
//            ValueSurprise = ShannonEncryption("MessageShannon", Value, ExprnSurprise, DiffWithRespToSurprise);
//            if (ValueSurprise != 0.0) {
//                Value = ValueSurprise;
//            }

            if ((EncryptedMesg == null) || (EncryptedMesg.toString().equalsIgnoreCase(""))) {
                EncryptedMesg = new StringBuilder(Value.toString());
            } else {
                EncryptedMesg.append(",@").append(Value);
            }
        }
    }

    public static void ShannonConfuseDecrypt(int NumOfChars, String[] Temp, String InvExprnDiffusion, String InvExprnSurprise, String InvTempSurprise, String InvDiffusionDiffWithRespTo, String InvSurpriseDiffWithRespTo, boolean SilentFlag) {
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        Value = 0.0;
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                Value = Double.parseDouble(Temp[i]);
                variablesDecrypt.put(InvSurpriseDiffWithRespTo, Value);
//                LCGexpValue = parse(InvTempSurprise, variables, InvSurpriseDiffWithRespTo, "Silent", MathsContxtLAv.LogLevel.Off);
//                // Add Surprise Decryption Code
//                ValueSurprise = ShannonDecryption("MessageShannon", LCGexpValue.eval(), InvExprnSurprise, InvSurpriseDiffWithRespTo);
//                if (ValueSurprise != 0.0) {
//                    Value = ValueSurprise;
//                }
//                // Add Diffustion Decryption Code
//                ValueDiffusion = ShannonDecryption("MessageShannon", Value, InvExprnDiffusion, InvDiffusionDiffWithRespTo);
//                if (ValueDiffusion != 0.0) {
//                    Value = ValueDiffusion;
//                }
                DecryptedByte = DecryptPKIValues(Value, 10E10, 10000.0, 1.0, 10000.0, SilentFlag);
                DecryptedMesg.append((char) DecryptedByte.intValue());
            }
        }
    }

    // This function(Scrambler) makes Cryptogram E = F(Message, Key, Position)
    public static String Scrambler(String MyMesg, boolean SilentFlag) {
        int m = 3;
        char[] Data = new char[MyMesg.length() * m];
        Data = Scram(MyMesg, SilentFlag);
        String ScrambledMesg = "";
        for (int i = 0, DataLimit = Data.length; i < Data.length; i++) {
            if ((DataLimit <= Data.length) && (i < DataLimit)) {
                ScrambledMesg = ScrambledMesg + Data[i];
            }
        }
        if (SilentFlag == false) {
            System.out.println("Scrambler:ScrambledMesg=" + ScrambledMesg);
        }
        return ScrambledMesg;
    }

    // This function(UnScrambler) makes Plaintext M= Inverse of F(Message, Key, Position)
    public static String UnScrambler(String MyMesg, boolean SilentFlag) {
        int m = 3;
        char[] Data = new char[MyMesg.length() * m + 1];
        String ScrambledMesg = "";
        ScrambledMesg = UnScram(MyMesg, SilentFlag);
        if (SilentFlag == false) {
            System.out.println("UnScrambler:ScrambledMesg=" + ScrambledMesg);
        }
        return ScrambledMesg;
    }

    // This function(Scrambler) makes Cryptogram E = F(Message, Key, Position)
    public static StringBuilder ScramblerVarGap(String MyMesg, boolean SilentFlag) {
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        int m = 3;
        char[] Data = new char[MyMesg.length() * m];
        Data = ScramVarGap(MyMesg, SilentFlag);
        StringBuilder ScrambledMesg = new StringBuilder("");
        for (int i = 0, DataLimit = Data.length; i < Data.length; i++) {
            if ((DataLimit <= Data.length) && (i < DataLimit)) {
                ScrambledMesg.append(Data[i]);
            }
        }
        if (SilentFlag == false) {
            System.out.println("ScramblerVarGap:ScramVarGap:ScrambledMesg=" + ScrambledMesg);
        }
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            EncryptStrFuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(EncryptStrFuncTimeTaken)));
        }
        return ScrambledMesg;
    }

    // This function(UnScrambler) makes Plaintext M= Inverse of F(Message, Key, Position)
    public static StringBuilder UnScramblerVarGap(StringBuilder ScrambledMesg, boolean SilentFlag) {
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        char[] Data = new char[ScrambledMesg.length()];
        if (SuppressSystemOutput == false) {
            System.out.println("UnScramblerVarGap: Length=" + ScrambledMesg.length());
            System.out.println("UnScramblerVarGap: ScrambledMesg=" + ScrambledMesg);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        for (int i = 0; i < ScrambledMesg.length(); i++) {
            int z = 0;
            String Temp = "";
            if ((i + 3) < ScrambledMesg.length()) {
                Temp = ScrambledMesg.toString().substring(i, i + 3);
            }
            //System.out.println("UnScramblerVarGap:0th FSM: i=" + i + " Temp=" + Temp + " ScrambledMesg.charAt(i)="+ScrambledMesg.charAt(i));
            //System.out.println("UnScramblerVarGap:0th FSM: Length=" + ScrambledMesg.length() + " ScrambledMesg=" + ScrambledMesg);
            if (Temp.equalsIgnoreCase("@,#")) {
                NewEncryptedMesg.append(' ');
                //System.out.println("UnScramblerVarGap:1st FSM: Length=" + NewEncryptedMesg.length() + " NewEncryptedMesg=t" + NewEncryptedMesg +"t");
            } else {
                z = UnScramVarGap(i, ScrambledMesg, SilentFlag);
                if ((z > 0) && (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) && (z != TheFOBRandomCharScram)) {
                    NewEncryptedMesg.append((char) z);
                    //System.out.println("UnScramblerVarGap:2nd FSM: Length=" + NewEncryptedMesg.length() + " NewEncryptedMesg=t" + NewEncryptedMesg + "t :(char) z=" + (char) z);
                } else if ((z > 0) && (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))) {
                    NewEncryptedMesg.append((char) z);
                    //System.out.println("UnScramblerVarGap:3rd FSM: Length=" + NewEncryptedMesg.length() + " NewEncryptedMesg=t" + NewEncryptedMesg + "t :(char) z=" + (char) z);
                }
            }
            //System.out.println("UnScramblerVarGap:4th FSM: i=" + i + " Temp=" + Temp + " ScrambledMesg.charAt(i)="+ScrambledMesg.charAt(i) + ":(char) z=" + (char) z);

        }
        if (SuppressSystemOutput == false) {
            System.out.println("UnScramblerVarGap:Final: Length=" + NewEncryptedMesg.length() + " NewEncryptedMesg=" + NewEncryptedMesg);
        }
        if (SilentFlag == false) {
            System.out.println("UnScramblerVarGap:ScrambledMesg=" + ScrambledMesg);
        }
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            DecryptStrFuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(DecryptStrFuncTimeTaken)));
        }
        return NewEncryptedMesg;
    }

    public static void MaliciousMalloryBob(Double XnValue, Double yDecryptedByte, MathsExpressionParser.Expression LCGexpValue) {
        if (PRAGMA.equalsIgnoreCase("Paranoid")) {
            MathsExpressionParser.Expression SenderPrivateKeyValue = (() -> 0.0);

            String MyDiffWithRespTo = "y";
            variablesDecrypt.put("KCE", LCGexpValue.eval());
            variablesDecrypt.put("RevEnggM", variablesDecrypt.get("m") * MDivisor);
            variablesDecrypt.put("RevEnggPubKey", Double.parseDouble(MyPublicKey));
            SenderPrivateKeyValue = parse(KeyReverseEnggEqn, variablesDecrypt, MyDiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            //if (("" + SenderPrivateKeyValue.eval()).equalsIgnoreCase(MyPrivateKey))//Bob's Private Key
            {
                System.out.println(ConsoleColors.YELLOW + "Security:MaliciousMalloryBob:RKey=" + SenderPrivateKeyValue.eval() + " Bob's MyPrivateKey=" + BobKeyPair.getPrivateKey("Decrypt") + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN + "Security:MaliciousMalloryBob:RKeyCheat=" + (variablesDecrypt.get("privkey").toString()) + ConsoleColors.RESET);
            }
            if (PRAGMADetail.equalsIgnoreCase("Paranoid")) {
                System.out.println(ConsoleColors.YELLOW + "Security:MaliciousMalloryBob:RevEnggN=" + variablesDecrypt.get("KCE") + ConsoleColors.RESET);
                System.out.println(ConsoleColors.YELLOW + "Security:MaliciousMalloryBob:RevEnggPubKey=" + variablesDecrypt.get("RevEnggPubKey") + ConsoleColors.RESET);
            }

        }
    }

    public static void MaliciousMalloryAlice(Double XnValue, Double yDecryptedByte, MathsExpressionParser.Expression LCGexpValue) {
        if (PRAGMA.equalsIgnoreCase("Paranoid")) {
            MathsExpressionParser.Expression SenderPrivateKeyValue = (() -> 0.0);

            String MyDiffWithRespTo = "y";
            variablesDecrypt.put("KCE", LCGexpValue.eval());
            variablesDecrypt.put("RevEnggM", variablesDecrypt.get("m") * MDivisor);
            variablesDecrypt.put("RevEnggPubKey", Double.parseDouble(AliceKeyPair.getPublicKey("Decrypt")));
            SenderPrivateKeyValue = parse(KeyReverseEnggEqn, variablesDecrypt, MyDiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            //if (("" + SenderPrivateKeyValue.eval()).equalsIgnoreCase(MyPrivateKey))//Bob's Private Key
            {
                System.out.println(ConsoleColors.YELLOW + "Security:MaliciousMalloryAlice:RKey=" + SenderPrivateKeyValue.eval() + " Alice's MyPrivateKey=" + AliceKeyPair.getPrivateKey("Decrypt") + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN + "Security:MaliciousMalloryAlice:RKeyCheat=" + (variablesDecrypt.get("RevEnggPubKey").toString()) + ConsoleColors.RESET);
            }
            if (PRAGMADetail.equalsIgnoreCase("Paranoid")) {
                System.out.println(ConsoleColors.YELLOW + "Security:MaliciousMalloryAlice:RevEnggN=" + variablesDecrypt.get("KCE") + ConsoleColors.RESET);
                System.out.println(ConsoleColors.YELLOW + "Security:MaliciousMalloryAlice:RevEnggPubKey=" + variablesDecrypt.get("RevEnggPubKey") + ConsoleColors.RESET);
            }
        }
    }

}
