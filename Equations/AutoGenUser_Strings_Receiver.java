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

import RandomNumber.RandomSimpleLCG;
import static RandomNumber.UserResearchStudy.DebugFlag;
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.NoOfBits;
import static RandomNumber.UserResearchStudy.NoOfBuffBitsMax;
import static RandomNumber.UserResearchStudy.NoOfSlots;
import static RandomNumber.UserResearchStudy.NumberOfStates;
import static RandomNumber.UserResearchStudy.RANDProdPerform;
import static RandomNumber.UserResearchStudy.Radius;
import static RandomNumber.UserResearchStudy.SeedDyDx;
import static RandomNumber.UserResearchStudy.SeedSimple;
import static RandomNumber.UserResearchStudy.SeedXOR;
import static RandomNumber.UserResearchStudy.StudyType;
import static RandomNumber.UserResearchStudy.Xn_LCG3;
import static RandomNumber.UserResearchStudy.Xn_LCGDyDx;
import static RandomNumber.UserResearchStudy.Xn_LCGDyDx4;
import static RandomNumber.UserResearchStudy.Xn_XOR;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.b;
import static RandomNumber.UserResearchStudy.c;
import static RandomNumber.UserResearchStudy.d;
import static Security.Configuration.GetPrimeNumber;
import static Security.Configuration.LastIndex;
import static Security.EquationPairGeneration.DiffWithRespToDiffusion;
import static Security.EquationPairGeneration.DiffWithRespToSurprise;
import static Security.EquationPairGeneration.ExprnDiffusion;
import static Security.EquationPairGeneration.ExprnSurprise;
import static Security.EquationPairGeneration.FractionDecryptDiffWithRespTo;
import static Security.EquationPairGeneration.FractionDecryptExprn;
import static Security.EquationPairGeneration.FractionEncryptComputerDiffWithRespTo;
import static Security.EquationPairGeneration.FractionEncryptComputerExprn;
import static Security.EquationPairGeneration.FractionEncryptDiffWithRespTo;
import static Security.EquationPairGeneration.FractionEncryptExprn;
import static Security.EquationPairGeneration.InvDiffusionDiffWithRespTo;
import static Security.EquationPairGeneration.InvExprnDiffusion;
import static Security.EquationPairGeneration.InvExprnSurprise;
import static Security.EquationPairGeneration.InvFractionDecryptComputerDiffWithRespTo;
import static Security.EquationPairGeneration.InvFractionDecryptComputerExprn;
import static Security.EquationPairGeneration.InvSurpriseDiffWithRespTo;
import static Security.EquationPairGeneration.InvTranspComputerDiffWithRespTo;
import static Security.EquationPairGeneration.InvTranspComputerExprn;
import static Security.EquationPairGeneration.InvTranspositionDiffWithRespTo;
import static Security.EquationPairGeneration.InvTranspositionExprn;
import static Security.EquationPairGeneration.TranspComputerDiffWithRespTo;
import static Security.EquationPairGeneration.TranspComputerExprn;
import static Security.EquationPairGeneration.TranspositionDiffWithRespTo;
import static Security.EquationPairGeneration.TranspositionExprn;
import static Security.EquationPairGeneration.aSecret;
import static Security.EquationPairGeneration.aSecretValue;
import static Security.EquationPairGeneration.bSecret;
import static Security.EquationPairGeneration.bSecretValue;
import static Security.EquationPairGeneration.cSecret;
import static Security.EquationPairGeneration.cSecretValue;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.dSecret;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.EquationPairGeneration.rSecretValue;
import static Security.EquationPairGeneration.sSecret;
import static Security.EquationPairGeneration.sSecretValue;
import static Security.EquationPairGeneration.zSecret;
import static Security.Security.MySimpleWeiBull;
import static Security.Security.Xn_LCG;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesStr;
import static SenderReceiverGUI.Receiver.EqnUnderTest;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Receiver.InverseTCPDiffusionDiffWithRespTo;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestStrongA;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestStrongB;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestWeak;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestWeakBinomial;
import static SenderReceiverGUI.Receiver.InverseTCPExprnDiffusion;
import static SenderReceiverGUI.Receiver.InverseTCPExprnSurprise;
import static SenderReceiverGUI.Receiver.ReceiverStrTCPDecrypt;
import static SenderReceiverGUI.Receiver.TCPDiffWithRespToDiffusion;
import static SenderReceiverGUI.Receiver.TCPEqnUnderTestStrongA;
import static SenderReceiverGUI.Receiver.TCPEqnUnderTestStrongB;
import static SenderReceiverGUI.Receiver.TCPEqnUnderTestWeak;
import static SenderReceiverGUI.Receiver.TCPEqnUnderTestWeakBinomial;
import static SenderReceiverGUI.Receiver.TCPExprnDiffusion;
import static SenderReceiverGUI.Receiver.TCPExprnSurprise;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipFile;

/**
 *
 * @author Rajesh V Pai
 */
public class AutoGenUser_Strings_Receiver {
    public static FileWriter writer5 = null;
    static String Path = "data\\";
    static String dump = "dump\\";
    static String msg = "";
    
    /**
     * *********** RECEIVER TAILORED EQUATIONS *********
     */
    /**
     * *************************************************** ******
     */
    // Make any changes to change the values of 
    //  of Security Encryption && Decryption
    // This function is used everywhere (Most Test Cases and Production )
    // Change the values as per the documentation(PoorMan's Security V 3.0.doc).
    // REMEMBER: Equations used in Encryption are not needed here
    // Only VerifyInverse function needs both eqns. 
    // It is not used in any other place.
    // This is a potential Security Leak.
    public static void UserStrings_Receiver_Entropy() {
        
        variablesDecrypt.put("z", (double) zSecret);
        variablesDecrypt.put("s", (double) sSecret);
        variablesDecrypt.put("m", diffusiond2);
        variablesDecrypt.put("c", diffusionN);
        
        variablesStr.put("z", "z");
        variablesStr.put("s", "s");
        variablesStr.put("m", "m");
        variablesStr.put("c", "c");
        // Equation Pair 1
        EqnUnderTest = PSACEquationSuite.expandAmXnEquation();// "m^2*Xn^2+2*m*Xn*c+c^2";    
        InverseEqnUnderTest = PSACEquationSuite.inverseAmXnEquation();//"y^0.5/m-c/m"; ;
        System.out.println("EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
        System.out.println("buildEquation:" + PSACEquationFactory.buildEquation(3)); 
        System.out.println("buildEquation:Inverse:" + PSACEquationFactory.buildInverse(3)); 
        //VerifyInverse( EqnUnderTest,  "Xn",  InverseEqnUnderTest, "y");
        // Equation Pair 2
        // Confusion and Diffusion Parameters
        ExprnDiffusion = "Xn^2+2*Xn*c+c^2"; //y=(Xn+c)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        DiffWithRespToDiffusion = "Xn";
        InvExprnDiffusion = "y^0.5-c";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        InvDiffusionDiffWithRespTo = "y";
        variablesDecrypt.put("c", diffusionN);
        variablesStr.put("c", "c");
        //VerifyInverse( ExprnDiffusion,  DiffWithRespToDiffusion,  InvExprnDiffusion, InvDiffusionDiffWithRespTo);
        // Equation Pair 3
        // Surprise Parameters
        ExprnSurprise = "Xn^diffusionN+2*Xn*diffusiond2+diffusiond2^diffusionN+0.2";      //y=(Xn+diffusiond2)^diffusionN;//y=(Xn+d2)^n; //y=Xn^2+2*Xn*d2+d2^2
        DiffWithRespToSurprise = "Xn";
        InvExprnSurprise = "y^confusionA-diffusiond2";
        InvSurpriseDiffWithRespTo = "y";
        // Static values
        diffusiond2 = 4.0;
        diffusionN = 2.0;
        confusionA = 1.0 / diffusionN;
        // Diffusion Parameters
        // Surprise Parameters
        variablesDecrypt.put("diffusiond2", diffusiond2);
        variablesDecrypt.put("diffusionN", diffusionN);
        variablesDecrypt.put("confusionA", confusionA);
        variablesStr.put("diffusiond2", "diffusiond2");
        variablesStr.put("diffusionN", "diffusionN");
        variablesStr.put("confusionA", "confusionA");
        //VerifyInverse( ExprnSurprise,  DiffWithRespToSurprise,  InvExprnSurprise, InvSurpriseDiffWithRespTo);
        // Equation Pair 4
        //Fractionating Encrypt Parameters
        FractionEncryptExprn = "x-" + '0';
        FractionEncryptDiffWithRespTo = "x";
        FractionEncryptComputerExprn = "i";
        FractionEncryptComputerDiffWithRespTo = "i";
        // Equation Pair 5
        //Fractionating Decrypt Parameters
        FractionDecryptExprn = "x-" + '0';
        FractionDecryptDiffWithRespTo = "x";
        InvFractionDecryptComputerExprn = "i";
        InvFractionDecryptComputerDiffWithRespTo = "i";
        // Equation Pair 6
        //TranspositionEncrypt
        TranspositionExprn = "MesgIndex";
        TranspositionDiffWithRespTo = "MesgIndex";
        TranspComputerExprn = "NumOfChars-1.0-MesgIndex";
        TranspComputerDiffWithRespTo = "MesgIndex";
        //TranspositionDecryptA
        InvTranspositionExprn = "MesgIndex";
        InvTranspositionDiffWithRespTo = "MesgIndex";
        InvTranspComputerExprn = "NumOfChars-1.0-MesgIndex";
        InvTranspComputerDiffWithRespTo = "MesgIndex";
        // Equation Pair 7
        // TCP Encryption
        TCPEqnUnderTestStrongA = PSACEquationFactory.buildEquation(3);//y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseTCPEqnUnderTestStrongA = PSACEquationFactory.buildInverse(3);//"y^0.5/m-c/m";   //x="y^0.5*n/m-2.0*n/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        System.out.println("UserStrings_Receiver:TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
        TCPEqnUnderTestStrongB = PSACEquationFactory.buildEquation(2);//PSAEquationSuite.expandAmXnEquation(2, 3, 5/*(int)myPubKy*/,2);      //y=(2*x+3)^myPubKy;
        InverseTCPEqnUnderTestStrongB = PSACEquationFactory.buildInverse(2);//PSAEquationSuite.inverseAmXnEquation(2, 3, 5/*(int)myPubKy*/,2); //x="y^1/myPubKy/2-3.0/2";
        System.out.println("UserStrings_Receiver:TCPEqnUnderTestStrongB=" + TCPEqnUnderTestStrongB + " InverseTCPEqnUnderTestStrongB=" + InverseTCPEqnUnderTestStrongB);

        TCPEqnUnderTestWeakBinomial = PSACEquationSuite.expandAmXnEquation();      //y=(2*x+3)^4
        InverseTCPEqnUnderTestWeakBinomial = PSACEquationSuite.inverseAmXnEquation();
        System.out.println("UserStrings_Receiver:TCPEqnUnderTestWeakBinomial=" + TCPEqnUnderTestWeakBinomial + " InverseTCPEqnUnderTestWeakBinomial=" + InverseTCPEqnUnderTestWeakBinomial);

        TCPEqnUnderTestWeak = PSACEquationSuite.expandBinomialEquation();
        InverseTCPEqnUnderTestWeak = PSACEquationSuite.inverseBinomialEquation();
        System.out.println("UserStrings_Receiver:TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak + " InverseTCPEqnUnderTestWeak=" + InverseTCPEqnUnderTestWeak);

        // Equation Pair 8
        TCPExprnDiffusion = "Xn^2+2*Xn*10+400";
        TCPDiffWithRespToDiffusion = "Xn";
        InverseTCPExprnDiffusion = "y^0.5-20";
        InverseTCPDiffusionDiffWithRespTo = "y";
        // Equation Pair 9
        TCPExprnSurprise = "Xn^2+2*Xn*10+100";
        InverseTCPExprnSurprise = "y^0.5-10";
        ////       // Debugging TCP Encryption
//        TCPEqnUnderTest = "Xn";//"3*Xn+100";
//        InverseTCPEqnUnderTest = "y";//(y-100)/3";
//        TCPExprnDiffusion = "Xn";
//        InverseTCPExprnDiffusion="y";
//        TCPExprnSurprise="Xn";
//        InverseTCPExprnSurprise="y";

        MySimpleWeiBull = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
        
    }

    // Random Number Generator Tweaks
    // Make any changes to change the values of Random Number Streams Generated
    // instead of faking Computer Clock Time
    // Change the values as per the documentation(Random Number Doc :Application Notes to Java RNG V 1.0 .doc).
    // The mathematical rule is User Entropy is never ZERO
    // This triggers the Uniqueness and Randomness
    public static void UserTweaks_Entropy() {
        DebugFlag = false;
        Xn_XOR = 1;
        // Tweaks Begin
        Radius = 3.0;
        NumberOfStates = 29;// Preferably Prime Number
        Xn_LCG = 41;//5;//3;// Preferably Prime Number
        Xn_LCGDyDx = 23;// Preferably Prime Number
        Xn_LCG3 = 17;// Preferably Prime Number
        Xn_LCGDyDx4 = 11;// Preferably Prime Number
        Modulus = 5000;
        NoOfBits = 100;
        NoOfSlots = Modulus + 2;
        NoOfBuffBitsMax = Modulus;
        //Equation Common Parameters Below
        MaxExponent = 31;// Preferably Prime Number
        ModulusEncrypt = 5000;// Preferably Prime Number
        a = 1181;//1181;//911;//773;//641;//401;//131;//23;//29;//23;// Preferably Prime Number
        c = 1193;//1193;//919;//787;//643;//367//101;//17;//17;//7;// Preferably Prime Number
        b = 1229;//1229;//941;//811;//647;//373;//101;//13;//5;//3;// Preferably Prime Number
        d = 1091;//1091;//811;//677;//379//109;//19;// Preferably Prime Number
        StudyType = "";
        // Seed Initialization
        SeedSimple = 41;// Preferably Prime Number
        SeedDyDx = 29;// Preferably Prime Number
        SeedXOR = 31;// Preferably Prime Number
        RANDProdPerform = "Production";
        // Initialize Prime Numbers
        long MaxValue = Math.max(d, Math.max(b, Math.max(a, c)));
        long Prime = GetPrimeNumber(MaxValue);
        System.out.println("UserTweaks:MaxValue=" + MaxValue + " LastIndex=" + LastIndex + " Prime=" + Prime);
        // Tweaks End
        UserStrings_Receiver_Entropy();
    }
    public static long User_SecretValues(String layerType, long zSecret1, long epoch, long timeStepSeconds, int OTP) {
    long seed;
        zSecret = zSecret1;
        aSecret = 4;
        bSecret = 5;
        cSecret = 10;
        dSecret = 23;
        sSecret = 31;
        aSecretValue = 2;
        cSecretValue = 4;
        if( (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA")) ||(ReceiverStrTCPDecrypt.equalsIgnoreCase("None")) ){
        
        }else if(ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB")){
            aSecretValue = 2;
            cSecretValue = 5;
        }
        bSecretValue = 5;
        dSecretValue = 23;
        sSecretValue = 31;
    switch (layerType) {
        case "HighLevel":
            // Slower rotation for algebraic motifs
            seed = zSecret ^ (epoch / (timeStepSeconds * OTP));
            break;
        case "TCPLevel":
            // Faster rotation for packet-level agility
            seed = zSecret ^ (epoch / (timeStepSeconds / OTP));
            break;
        default:
            throw new IllegalArgumentException("Unknown layerType: " + layerType);
    }
    return seed;
}
     
        public static void main(String... args) {
        FileWriter writer7 = null;
        CreateFilesParallel(Path, dump, "SenderName", "ReceiverName", 1);
        generateTestCaseMethodDOE_UserTweaks(writer7, 5000, 100, 31, 1181, 1229, 1193, 1091, 41, 29, 31);
        generateTestCaseMethodDOE_UserSecretValues(writer7, 4, 5, 10, 23, 31);
    }

 private static void CreateFilesParallel(String Path, String dump, String senderName, String receiverName, int k) {
        try {
            // File name includes Receiver name
            String fileName = Path + dump + "AutoGenUser_Strings_Receiver_" + receiverName + "_" + k + ".java";
            writer5 = new FileWriter(fileName);

            // Generate password
            String dateStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String actualPassword = "PSA_" + senderName + "_MyName_" + receiverName + "_" + dateStamp;
            String maskedPassword = "PSA_****_MyName_****_" + dateStamp;

            // Wrap in password-protected ZIP
            String zipFileName = Path + dump + "AutoGenUser_Strings_Receiver_" + receiverName + "_" + k + ".zip";
            //ZipFile zipFile = new ZipFile(zipFileName, actualPassword.toCharArray());
            //zipFile.addFile(new File(fileName));


            // Maintain neutral inventory
            FileWriter inventory = new FileWriter(Path + dump + "EntropyInventory.txt", true);
            inventory.write(senderName + " → " + receiverName + " → " + maskedPassword + "\n");
            inventory.close();

            System.out.println("Archive created: " + zipFileName);
            System.out.println("Entry stored in EntropyInventory.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------------------
    // Generator for UserStrings_Receiver_Entropy
    // -------------------------------
    private static void generateTestCaseMethodDOE_ReceiverEntropy(
            FileWriter writer7,
            int[] coeffs,
            String[] vars,
            String eqnUnderTest,
            String inverseEqnUnderTest) {
        try {
            StringBuilder sbDOE = new StringBuilder();
            sbDOE.append("public static void UserStrings_Receiver_Entropy() {").append("\n");

            sbDOE.append(" int[] coeffs = {")
                 .append(Arrays.toString(coeffs).replaceAll("[\\[\\]]", ""))
                 .append("};").append("\n");
            sbDOE.append(" String[] vars = {")
                 .append(Arrays.toString(vars).replaceAll("[\\[\\]]", "\"$1\""))
                 .append("};").append("\n");
            sbDOE.append(" EqnUnderTest = \"" + eqnUnderTest + "\";").append("\n");
            sbDOE.append(" InverseEqnUnderTest = \"" + inverseEqnUnderTest + "\";").append("\n");

            sbDOE.append(" ExprnDiffusion = \"Xn^2+2*Xn*c+c^2\";").append("\n");
            sbDOE.append(" InvExprnDiffusion = \"y^0.5-c\";").append("\n");
            sbDOE.append(" ExprnSurprise = \"Xn^diffusionN+2*Xn*diffusiond2+diffusiond2^diffusionN+0.2\";").append("\n");
            sbDOE.append(" InvExprnSurprise = \"y^confusionA-diffusiond2\";").append("\n");

            sbDOE.append(" MySimpleWeiBull = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);").append("\n");
            sbDOE.append("}").append("\n\n");

            writer7.write(sbDOE.toString());
            writer7.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------------------
    // Generator for UserTweaks_Entropy
    // -------------------------------
    private static void generateTestCaseMethodDOE_UserTweaks(
            FileWriter writer7,
            int modulus,
            int noOfBits,
            int maxExponent,
            int a, int b, int c, int d,
            int seedSimple, int seedDyDx, int seedXOR) {
        try {
            StringBuilder sbDOE = new StringBuilder();
            sbDOE.append("public static void UserTweaks_Entropy() {").append("\n");

            sbDOE.append(" DebugFlag = false;").append("\n");
            sbDOE.append(" Xn_XOR = 1;").append("\n");
            sbDOE.append(" Radius = 3.0;").append("\n");
            sbDOE.append(" NumberOfStates = 29;").append("\n");
            sbDOE.append(" Xn_LCG = 41;").append("\n");
            sbDOE.append(" Modulus = " + modulus + ";").append("\n");
            sbDOE.append(" NoOfBits = " + noOfBits + ";").append("\n");
            sbDOE.append(" MaxExponent = " + maxExponent + ";").append("\n");
            sbDOE.append(" a = " + a + "; b = " + b + "; c = " + c + "; d = " + d + ";").append("\n");
            sbDOE.append(" SeedSimple = " + seedSimple + "; SeedDyDx = " + seedDyDx + "; SeedXOR = " + seedXOR + ";").append("\n");
            sbDOE.append(" RANDProdPerform = \"Production\";").append("\n");
            sbDOE.append(" long MaxValue = Math.max(d, Math.max(b, Math.max(a, c)));").append("\n");
            sbDOE.append(" long Prime = GetPrimeNumber(MaxValue);").append("\n");
            sbDOE.append(" System.out.println(\"UserTweaks:MaxValue=\" + MaxValue + \" Prime=\" + Prime);").append("\n");
            sbDOE.append(" UserStrings_Receiver_Entropy();").append("\n");

            sbDOE.append("}").append("\n\n");

            writer7.write(sbDOE.toString());
            writer7.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------------------
    // Generator for User_SecretValues
    // -------------------------------
    private static void generateTestCaseMethodDOE_UserSecretValues(
            FileWriter writer7,
            int aSecret, int bSecret, int cSecret, int dSecret, int sSecret) {
        try {
            StringBuilder sbDOE = new StringBuilder();
            sbDOE.append("public static long User_SecretValues(String layerType, long zSecret1, long epoch, long timeStepSeconds, int OTP) {").append("\n");
            sbDOE.append(" long seed;").append("\n");
            sbDOE.append(" zSecret = zSecret1;").append("\n");
            sbDOE.append(" aSecret = " + aSecret + "; bSecret = " + bSecret + "; cSecret = " + cSecret + "; dSecret = " + dSecret + "; sSecret = " + sSecret + ";").append("\n");
            sbDOE.append(" switch (layerType) {").append("\n");
            sbDOE.append(" case \"HighLevel\":").append("\n");
            sbDOE.append(" seed = zSecret ^ (epoch / (timeStepSeconds * OTP));").append("\n");
            sbDOE.append(" break;").append("\n");
            sbDOE.append(" case \"TCPLevel\":").append("\n");
            sbDOE.append(" seed = zSecret ^ (epoch / (timeStepSeconds / OTP));").append("\n");
            sbDOE.append(" break;").append("\n");
            sbDOE.append(" default:").append("\n");
            sbDOE.append(" throw new IllegalArgumentException(\"Unknown layerType: \" + layerType);").append("\n");
            sbDOE.append(" }").append("\n");
            sbDOE.append(" return seed;").append("\n");
            sbDOE.append("}").append("\n\n");

            writer7.write(sbDOE.toString());
            writer7.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------------------
    // Orchestrator: Generate all three in one shot
    // -------------------------------
    public static void generateAllEntropyMethods(FileWriter writer7) {
        generateTestCaseMethodDOE_ReceiverEntropy(writer7, new int[]{2,3,4}, new String[]{"z"}, "m^2*Xn^2+2*m*Xn*c+c^2", "y^0.5/m-c/m");
        generateTestCaseMethodDOE_UserTweaks(writer7, 5000, 100, 31, 1181, 1229, 1193, 1091, 41, 29, 31);
        generateTestCaseMethodDOE_UserSecretValues(writer7, 4, 5, 10, 23, 31);
    }

}
