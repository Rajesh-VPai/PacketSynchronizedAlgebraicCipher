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
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.Xn_LCG;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.c;
import static Security.Decryption.NoSenderReceivermain;
import static Security.EquationPairGeneration.DiffWithRespToDiffusion;
import static Security.EquationPairGeneration.DiffWithRespToSurprise;
import static Security.EquationPairGeneration.ExprnDiffusion;
import static Security.EquationPairGeneration.ExprnSurprise;
import static Security.EquationPairGeneration.InvDiffusionDiffWithRespTo;
import static Security.EquationPairGeneration.InvExprnDiffusion;
import static Security.EquationPairGeneration.InvExprnSurprise;
import static Security.EquationPairGeneration.InvSurpriseDiffWithRespTo;
import static Security.Configuration.NumberOfTimes;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.Security.MyDecrptionEquation;
import static Security.Encryption.MyMessage;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.MySimpleWeiBull;
import static Security.Configuration.UserStrings_EncryptMesgSimple_Entropy;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.EncryptedMesg;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import static Security.SubstitutionBox.SuccessiveCharsLenSim;
import static Security.TranspositionPBox.RotateStrDecrypt;
import static Security.TranspositionPBox.RotateStrEncrypt;
import static Security.UsageSecurity.TestCaseInternalVar;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static Security.SubstitutionBox.ShannonSimDecrypt;
import static Security.SubstitutionBox.ShannonSimEncrypt;
import static Security.UsageSecurity.NamesOfTestCase_Objctive;
import static Security.UsageSecurity.TestCasePassHighLevelFlag;
import static Security.UsageSecurity.TestExecResultsMessage;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class BasicTests {

    public static Logger log = Logger.getLogger(BasicTests.class.getName());
    //Sanity Test Cases

    public static void BasicTestCases(String AlgoName, int j) {
        System.out.println(ConsoleColors.BLACK + "TestCase:j= " + j + ConsoleColors.RESET);
        switch (j) {
            case 2001:
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** Basic TestCases Begins *************** */");
                TestCase2001Fail();
                break;
            case 2002:
                TestCase2002Fail();
                break;
            case 2003:
                TestCase2003Fail();
                break;
            case 2004:
                TestCase2004Pass();
                System.out.println("/************************** Basic TestCases Ends *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                break;
            case 2005:
                TestCase0000Default();
                break;
            case 2006:
                TestCase0000Default();
                break;
            case 2007:
                TestCase0000Default();
                break;
            case 2008:
                TestCase0000Default();
                break;
            case 2009:
                TestCase0000Default();
                break;
            case 2000:
                TestCase0000Default();
                break;
            case 2011:
                TestCase0000Default();
                break;
            case 2012:
                TestCase0000Default();
                break;
            case 2013:
                TestCase0000Default();
                break;
            default:
                System.out.println(ConsoleColors.RED + "ShannonTestCases TestCase:j= " + j + ": Gap" + ConsoleColors.RESET);
                break;
        }
    }

    public static void TestCase0000Default() {
        //Test Case 000Default
        NamesOfTestCase_Objctive = "DefaultDummy";
        TestCasePassHighLevelFlag = false;
    }

    /* *************************** ************************ ********** */
 /* *************************** Failure Test Cases Begin ********** */
 /* *************************** ************************ ********** */
    public static void TestCase2001Fail() {
        //Test Case 2001
        TestCaseInternalVar = 2001;
        NamesOfTestCase_Objctive = "BasicTestCases TestCase2001Fail:Failure:";
        System.out.println(ConsoleColors.RED + "TestCase2001Fail:Obj:=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);

//        SetupAliceKeyShannon();
//        SetupBobKeyShannon();
//        SetupEveKeyShannon();

        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2001FailLowLevelFail(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2001FailLowLevelFail(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase2002Fail() {
        //Test Case 2002
        TestCaseInternalVar = 2002;
        NamesOfTestCase_Objctive = "BasicTestCases TestCase2002Fail:Failure:";
        System.out.println(ConsoleColors.RED + "TestCase2002Fail:Obj:=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);

//        SetupAliceKeyShannon();
//        SetupBobKeyShannon();
//        SetupEveKeyShannon();
//
//        SetupjKeyShannon();
//        SetupkKeyShannon();

        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2002FailLowLevelFail(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2002FailLowLevelFail(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();

    }

    public static void TestCase2003Fail() {
        //Test Case 2002
        TestCaseInternalVar = 2003;
        NamesOfTestCase_Objctive = "BasicTestCases TestCase2003Fail:Failure:";
        System.out.println(ConsoleColors.RED + "TestCase2003Fail:Obj:=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);

//        SetupAliceKeyShannon();
//        SetupBobKeyShannon();
//        SetupEveKeyShannon();
//
//        SetupjKeyShannon();
//        SetupkKeyShannon();

        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2003FailLowLevelFail(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2003FailLowLevelFail(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();

    }

    public static void TestCase2004Pass() {
        //Test Case 2004
        TestCaseInternalVar = 2004;
        NamesOfTestCase_Objctive = "BasicTestCases TestCase2004Pass:Pass:";
        System.out.println(ConsoleColors.RED + "TestCase2004Pass:Obj:=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);

//        SetupAliceKeyShannon();
//        SetupBobKeyShannon();
//        SetupEveKeyShannon();

        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2004PassLowLevelPass(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        TestCase2004PassLowLevelPass(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();

    }

    /* *************************** ************************ ********** */
 /* *************************** Failure Test Cases End ********** */
 /* *************************** ************************ ********** */
 /* *************************** ************************ ********** */
 /* *************************** Failure Test Cases Low Level Begin ********** */
 /* *************************** ************************ ********** */
    public static void TestCase2001FailLowLevelFail(boolean SilentFlag) {
        //Tj-1TkTk-1Tj=I
        System.out.println("/************************** Encryption Begins *************** */");
        System.out.println("TestCase2001FailLowLevelFail:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob");
        /**
         * ************************ Theorem Begins ***************
         */
        PreEncryptBlockShannon();
        System.out.println("EncryptedMesg=" + EncryptedMesg);
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("DecryptedMesg=" + DecryptedMesg);
        PostDecryptBlockShannon();
        /**
         * ************************ Theorem Ends ***************
         */
        System.out.println("/************************** Theorem Ends *************** */");
    }

    public static void TestCase2002FailLowLevelFail(boolean SilentFlag) {
        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Encryption Begins *************** */");
        PreEncryptBlockShannon();
        System.out.println("TestCase2002FailLowLevelFail:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob");
        final Double Rand1Rotate = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        /**
         * ************************ Theorem Begins ***************
         */
//        //Tj-1TkTk-1Tj=I
        Double Rand2Rotate = Rand1Rotate;
        System.out.println("Operation:Tj");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(jKeyShannon.getPrivateKey());
        String[] MyCharDropped=EncryptedMesg.toString().split(",@");
        StringBuilder NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Sender.OffsetRotate1, MyCharDropped.length,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("Operation:Tj:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tj:EncryptedMesg=" + EncryptedMesg);
        System.out.println("Operation:Tk-1");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(kKeyShannon.getPrivateKey());
        MyCharDropped=DecryptedMesg.toString().split(",@");
        NoSenderReceivermain();
        NewEncryptedMesg=new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Receiver.OffsetRotate2, MyCharDropped.length, SilentFlag);
        DecryptedMesg=NewEncryptedMesg;
        EncryptedMesg = DecryptedMesg;
        System.out.println("Operation:Tk-1:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tk-1:EncryptedMesg=" + EncryptedMesg);
        System.out.println("Operation:Tk");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(kKeyShannon.getPrivateKey());
        MyCharDropped=EncryptedMesg.toString().split(",@");
        NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Sender.OffsetRotate1, MyCharDropped.length,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        DecryptedMesg = EncryptedMesg;
        System.out.println("Operation:Tk:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tk:EncryptedMesg=" + EncryptedMesg);
        System.out.println("Operation:Tj-1");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(jKeyShannon.getPrivateKey());
        MyCharDropped=DecryptedMesg.toString().split(",@");
        NoSenderReceivermain();
        NewEncryptedMesg=new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Receiver.OffsetRotate2, MyCharDropped.length, SilentFlag);
        DecryptedMesg=NewEncryptedMesg;
        System.out.println("Operation:Tj-1:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tj-1:EncryptedMesg=" + EncryptedMesg);
        /**
         * ************************ Theorem Ends ***************
         */
        PostDecryptBlockShannonFailjKey();
        System.out.println("/************************** Theorem Ends *************** */");
    }

    public static void TestCase2003FailLowLevelFail(boolean SilentFlag) {
        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Encryption Begins *************** */");
        PreEncryptBlockShannon();
        System.out.println("TestCase2003FailLowLevelFail:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob");
        final Double Rand1Rotate = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        /**
         * ************************ Theorem Begins ***************
         */
//        //Tj-1TkTk-1Tj=I
        Double Rand2Rotate = Rand1Rotate;
        System.out.println("Operation:Tj");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(BobKeyShannon.getPublicKey());
        String[] MyCharDropped=EncryptedMesg.toString().split(",@");
        StringBuilder NewEncryptedMesg =new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Sender.OffsetRotate1, MyCharDropped.length,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("Operation:Tj:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tj:EncryptedMesg=" + EncryptedMesg);
        System.out.println("Operation:Tk-1");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(EveKeyShannon.getPrivateKey());
        MyCharDropped=DecryptedMesg.toString().split(",@");
        NoSenderReceivermain();
        NewEncryptedMesg =new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Receiver.OffsetRotate1, MyCharDropped.length, SilentFlag);
        DecryptedMesg=NewEncryptedMesg;
        EncryptedMesg = DecryptedMesg;
        System.out.println("Operation:Tk-1:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tk-1:EncryptedMesg=" + EncryptedMesg);
        System.out.println("Operation:Tk");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(EveKeyShannon.getPrivateKey());
        MyCharDropped=EncryptedMesg.toString().split(",@");
        NewEncryptedMesg =new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Sender.OffsetRotate1, MyCharDropped.length,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("Operation:Tk:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tk:EncryptedMesg=" + EncryptedMesg);
        System.out.println("Operation:Tj-1");
        //Rand2Rotate = Rand1Rotate + Double.parseDouble(BobKeyShannon.getPublicKey());
        MyCharDropped=DecryptedMesg.toString().split(",@");
        NoSenderReceivermain();
        NewEncryptedMesg=new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Receiver.OffsetRotate1, MyCharDropped.length, SilentFlag);
        DecryptedMesg=NewEncryptedMesg;
        System.out.println("Operation:Tj-1:DecryptedMesg=" + DecryptedMesg);
        System.out.println("Operation:Tj-1:EncryptedMesg=" + EncryptedMesg);
        /**
         * ************************ Theorem Ends ***************
         */
        EavesdroppingFlag = true;
        PostDecryptBlockShannonFailEve();
        System.out.println("/************************** Theorem Ends *************** */");
    }

    public static void TestCase2004PassLowLevelPass(boolean SilentFlag) {
        //Tj-1TkTk-1Tj=I
        System.out.println("/************************** Encryption Begins *************** */");
        System.out.println("TestCase2004PassLowLevelPass:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob");
        /**
         * ************************ Theorem Begins ***************
         */
        PreEncryptBlockShannon();
        System.out.println("EncryptedMesg=" + EncryptedMesg);
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("DecryptedMesg=" + DecryptedMesg);
        PostDecryptBlockShannonNonEveasdropping();
        /**
         * ************************ Theorem Ends ***************
         */
        System.out.println("/************************** Theorem Ends *************** */");
    }

    /* *************************** ************************ ********** */
 /* *************************** Failure Test Cases Low Level End ********** */
 /* *************************** ************************ ********** */

    public static void PostDecryptBlockShannonFailEve() {
        System.out.println("/************************** Post Decryption Begins *************** */");

        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        variablesDecrypt.clear();
        //MyPublicKey = BobKeyShannon.getPublicKey();
        //MyPrivateKey = EveKeyShannon.getPrivateKey();
        MyDecrptionEquation = InverseEqnUnderTest;

        String[] Temp = DecryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) && (Double.isFinite(Double.valueOf(Temp[i])))) {
                ShannonSimDecrypt(Temp[i], true);
            }
        }
    }

    public static void PreEncryptBlockShannon() {
        System.out.println("PreEncryptBlockShannon:myPrivKy=" + myPrivKy + " myPubKy=" + myPubKy);
        UserStrings_EncryptMesgSimple_Entropy();
        // Encryption && Decryption Parameters
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Pre Encryption Begins *************** */");
        // Diffusion Parameters
        // Surprise Parameters
        variablesEncrypt.put("diffusiond2", diffusiond2);
        variablesEncrypt.put("diffusionN", diffusionN);
        variablesEncrypt.put("confusionA", confusionA);
        //MyPublicKey = BobKeyShannon.getPublicKey();
        //MyPrivateKey = AliceKeyShannon.getPrivateKey();
        MyPublicEquation = EqnUnderTest;
        String[] Temp = MyMessage.split("");
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
     }

    public static void PostDecryptBlockShannonFailjKey() {
        System.out.println("/************************** Post Decryption Begins *************** */");

        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        variablesDecrypt.clear();
        //MyPublicKey = BobKeyShannon.getPublicKey();
        //MyPrivateKey = jKeyShannon.getPrivateKey();
        MyDecrptionEquation = InverseEqnUnderTest;

        String[] Temp = DecryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) && (Double.isFinite(Double.valueOf(Temp[i])))) {
                ShannonSimDecrypt(Temp[i], true);
            }
        }
    }

    public static void PostDecryptBlockShannon() {
        System.out.println("/************************** Post Decryption Begins *************** */");

        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        variablesDecrypt.clear();
        //MyPublicKey = AliceKeyShannon.getPublicKey();
        //MyPrivateKey = BobKeyShannon.getPrivateKey();
        MyDecrptionEquation = InverseEqnUnderTest;
        String[] Temp = DecryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) && (Double.isFinite(Double.valueOf(Temp[i])))) {
                ShannonSimDecrypt(Temp[i], true);
            }
        }
    }

    public static void PostDecryptBlockShannonNonEveasdropping() {
        System.out.println("/************************** Post Decryption Begins *************** */");

        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        variablesDecrypt.clear();
        // Diffusion Parameters
        // Surprise Parameters
        variablesDecrypt.put("diffusiond2", diffusiond2);
        variablesDecrypt.put("diffusionN", diffusionN);
        variablesDecrypt.put("confusionA", confusionA);
        //MyPublicKey = AliceKeyShannon.getPublicKey();
        //MyPrivateKey = BobKeyShannon.getPrivateKey();
        MyDecrptionEquation = InverseEqnUnderTest;
        String[] Temp = DecryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) && (Double.isFinite(Double.valueOf(Temp[i])))) {
                ShannonSimDecrypt(Temp[i], true);
                // Ignoring Sucessive Chars
                i = i + SuccessiveCharsLenSim;
            }
        }
    }
}
