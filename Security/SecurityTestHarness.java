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

import Calculus.ExprSimpleStrSep;
import static Calculus.ExprSimpleStrSep.parseSimple;
import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.parse;
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.c;
import static Security.Decryption.CyclicDecrypt;
import static Security.Decryption.DecryptStrFuncTimeTaken;
import static Security.Decryption.NoSenderReceivermain;
import static Security.Encryption.CyclicEncrypt;
import static Security.Encryption.EncryptStrFuncTimeTaken;
import static Security.EquationPairGeneration.DiffWithRespToDiffusion;
import static Security.EquationPairGeneration.DiffWithRespToSurprise;
import static Security.EquationPairGeneration.ExprnDiffusion;
import static Security.EquationPairGeneration.ExprnSurprise;
import static Security.EquationPairGeneration.InvDiffusionDiffWithRespTo;
import static Security.EquationPairGeneration.InvExprnDiffusion;
import static Security.EquationPairGeneration.InvExprnSurprise;
import static Security.EquationPairGeneration.InvSurpriseDiffWithRespTo;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.InvTempSurprise;
import static Security.EquationPairGeneration.diffusionN;
import static Security.Configuration.CyclicFlag;
import static Security.Configuration.NumberOfTimes;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.MyMessage2;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicKey;
import static Security.Security.MySimple;
import static Security.Security.MySimpleWeiBull;
import static Security.Security.ShannonConfuseDecrypt;
import static Security.Security.ShannonConfuseEncrypt;
import static Security.Security.Xn_LCG;
import static Security.Security.variablesStr;
import static Security.Configuration.UserStrings_EncryptMesgSimple_Entropy;
import static Security.Configuration.UserStrings_MessageShannon_Entropy;
import static Security.Configuration.UserStrings_MessageShannonSimple_Entropy;
import static Security.Configuration.UserTweaks_Entropy;
import static Security.Security.CConstant;
import static Security.Security.DecryptPKIValues;
import static Security.Security.DecryptedByte;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.EncryptedMesg;
import static Security.Security.EncryptPKIValues;
import static Security.Security.MDivisor;
import static Security.Security.MyDecrptionEquation;
import static Security.Encryption.MyMessage;
import static Security.Configuration.SecurityPosture;
import static Security.PacketSynchronizedAlgebraicCipher.SetupAlice;
import static Security.PacketSynchronizedAlgebraicCipher.SetupBob;
import static Security.PacketSynchronizedAlgebraicCipher.SetupEve;
import static Security.Security.MyPublicEquation;
import static Security.Security.Mychar;
import static Security.SubstitutionBox.WeibullDecrypt;
import static Security.SubstitutionBox.WeibullEncrypt;
import static Security.Security.constant;
import static Security.Security.mult_div;
import static Security.Security.variables;
import static Security.SubstitutionBox.DiffusionJunkSimEncrypt;
import static Security.SubstitutionBox.DiffusionJunkSimDecrypt;
import static Security.SubstitutionBox.ShannonSimDecrypt;
import static Security.SubstitutionBox.ShannonSimEncrypt;
import static Security.TranspositionPBox.FractionDecryptN;
import static Security.TranspositionPBox.FractionEncryptN;
import static Security.TranspositionPBox.JumbleStrDecrypt;
import static Security.TranspositionPBox.JumbleStrEncrypt;
import static Security.TranspositionPBox.RotateStrDecrypt;
import static Security.TranspositionPBox.RotateStrEncrypt;
import static Security.UsageSecurity.TestExecResultsMessage;
import static Security.UsageSecurity.TestCasePassHighLevelFlag;
import static SenderReceiverGUI.Receiver.OffsetRotate1;
import static SenderReceiverGUI.Receiver.OffsetRotate2;
import static Security.Calibration.CalibrationSender;
import static Security.PacketSynchronizedAlgebraicCipher.SuperSuppressOutput;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class SecurityTestHarness {

    public static Logger log = Logger.getLogger(SecurityTestHarness.class.getName());
    public static Double[] ConfirmedFirstEvent = null;
    public static Double[] ConfirmedSecondEvent = null;
    public static int OccasionNumberOfTimes = 0;
    public static int OccasionNoOfTimesIndex = 0;
    public static String TypeOfEquation = "UseZerothEquation";//UseZerothEquation OR UseDifferentEquation
    
    public static boolean SecEncPerfFLAG = false;
    public static String SecEncStrCurrentTimeTaken = null;
    public static boolean SecDecPerfFLAG = false;
    public static String SecDecStrCurrentTimeTaken = null;
    public static boolean TestSecEncPerfFLAG = false;
    public static String TestSecEncStrCurrentTimeTaken = null;

    public static boolean EavesdroppingFlag = false;// true=EavesDropping Alert ON , false=EavesDropping Alert OFF
    
    public static void MessageMLinearStates(boolean SilentFlag) {
        System.out.println("MessageMLinearStates:");
        Double Value = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 10000.0;
        Double initmult_div = 1.0;
        Double initconstant = 10000.0;
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        EqnUnderTest = "m^2*Xn^2+2*m*Xn*c+c^2";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseEqnUnderTest = "y^0.5/m-c/m";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        
        System.out.println("MessageMLinearStates:Message:Alice To Bob");
        EncryptedMesg =new StringBuilder("");
        //ContextSetMesg("ShannonSimEncrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        for (int i = 0; i < MyMessage.length(); i++) {
            Mychar = MyMessage.charAt(i) * 1.0;
            Value = EncryptPKIValues(Mychar.intValue(), MDivisor, CConstant, constant, SilentFlag);
            if ((EncryptedMesg == null) || (EncryptedMesg.toString().equalsIgnoreCase(""))) {
                EncryptedMesg.append(Value).append(",@");
            } else {
                EncryptedMesg.append(",@").append(Value);
            }
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        String[] Temp = EncryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        Value = 0.0;
        //ContextSetMesg("ShannonSimDecrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                DecryptedByte = DecryptPKIValues(Double.parseDouble(Temp[i]), MDivisor, CConstant, mult_div, constant, SilentFlag);
                DecryptedMesg.append((char) DecryptedByte.intValue());
            }
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
        TestExecResultsMessage();
        System.out.print(System.lineSeparator());

        System.out.println("MessageMLinearStates:Message:Bob To Alice");

        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;

        EncryptedMesg =new StringBuilder("");
        //ContextSetMesg("ShannonSimEncrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        for (int i = 0; i < MyMessage.length(); i++) {
            Mychar = MyMessage.charAt(i) * 1.0;
            Value = EncryptPKIValues(Mychar.intValue(), MDivisor, CConstant, constant, SilentFlag);
            if ((EncryptedMesg == null) || (EncryptedMesg.toString().equalsIgnoreCase(""))) {
                EncryptedMesg.append(Value).append(",@");
            } else {
                EncryptedMesg.append(",@").append(Value);
            }
        }
        System.out.print(System.lineSeparator());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        Temp = EncryptedMesg.toString().split(",@");
        NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        Value = 0.0;
        //ContextSetMesg("ShannonSimDecrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                DecryptedByte = DecryptPKIValues(Double.parseDouble(Temp[i]), MDivisor, CConstant, mult_div, constant, SilentFlag);
                DecryptedMesg.append((char) DecryptedByte.intValue());
            }
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
    }

    public static void MessageShannon(boolean SilentFlag) {
        System.out.println("MessageShannon:");
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);

        // Encryption && Decryption Parameters
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        // Diffusion Parameters
        // Surprise Parameters
        Double n = 8.0;
        UserStrings_MessageShannon_Entropy();
        variables.put("d", 2.0);
        variables.put("d2", 4.0);
        variables.put("n", n);
        variables.put("a", 1.0 / n);

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;

        System.out.println("MessageShannon:Message:Alice To Bob");
        EncryptedMesg =new StringBuilder("");
        ShannonConfuseEncrypt(ExprnDiffusion, ExprnSurprise, DiffWithRespToDiffusion, DiffWithRespToSurprise, SilentFlag);
        System.out.print("MessageShannon:ShannonConfuseEncrypt:m=" + variables.get("m") );
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");;
        MyDecrptionEquation = InverseEqnUnderTest;

        String[] Temp = EncryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        ShannonConfuseDecrypt(NumOfChars, Temp, InvExprnDiffusion, InvExprnSurprise, InvTempSurprise, InvDiffusionDiffWithRespTo, InvSurpriseDiffWithRespTo, SilentFlag);
        System.out.print("MessageShannon:ShannonConfuseEncrypt:m=" + variables.get("m") );
        
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
        TestExecResultsMessage();
        System.out.print(System.lineSeparator());

        System.out.println("MessageShannon:Message:Bob To Alice");
        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;

        EncryptedMesg =new StringBuilder("");
        ShannonConfuseEncrypt(ExprnDiffusion, ExprnSurprise, DiffWithRespToDiffusion, DiffWithRespToSurprise, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        System.out.print(System.lineSeparator());

        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        Temp = EncryptedMesg.toString().split(",@");
        NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        ShannonConfuseDecrypt(NumOfChars, Temp, InvExprnDiffusion, InvExprnSurprise, InvTempSurprise, InvDiffusionDiffWithRespTo, InvSurpriseDiffWithRespTo, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
    }

    public static void MessageShannonSimple(boolean SilentFlag) {
        System.out.println("MessageShannonSimple:");
        // Encryption && Decryption Parameters
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        UserStrings_MessageShannonSimple_Entropy();
        // Diffusion Parameters
        // Surprise Parameters
        Double n = 2.0;
        variables.put("d", 2.0);
        variables.put("d2", 4.0);
        variables.put("n", n);
        variables.put("a", 1.0 / n);

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        System.out.println("MessageShannonSimple:Message:Alice To Bob");
        EncryptedMesg =new StringBuilder("");
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        String[] Temp = EncryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                ShannonSimDecrypt(Temp[i], SilentFlag);
                //i = i + SuccessiveCharsLenSim;
            }
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
        TestExecResultsMessage();
        System.out.print(System.lineSeparator());

        System.out.println("MessageShannonSimple:Message:Bob To Alice");

        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;

        EncryptedMesg =new StringBuilder("");
        //String[] Temp2 = MyMessage.split("");
        String[] Temp2= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp2[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp2.length; i++) {
            ShannonSimEncrypt(Temp2[i], true);
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";

        System.out.print(System.lineSeparator());
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;

        Temp = EncryptedMesg.toString().split(",@");
        NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                ShannonSimDecrypt(Temp[i], SilentFlag);
                //i = i + SuccessiveCharsLenSim;
            }
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
    }

    public static void EncryptMesgSimple(String MesgNum, boolean SilentFlag) {
        
        System.out.println("EncryptMesgSimple:myPrivKy=" + myPrivKy + " myPubKy=" + myPubKy);
        UserStrings_EncryptMesgSimple_Entropy();
        if (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse") ) {
             SetupAlice("Encrypt");
             SetupBob("Encrypt");
             SetupEve("Encrypt");
        }
        // Encryption && Decryption Parameters
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Encryption Begins *************** */");
        String StrTimeTaken = "0.0";
        StrTimeTaken=TimeStart();
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyPublicEquation = EqnUnderTest;
        CalibrationSender="ContextSetMesgSenderBob";
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:KeyReading=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        StrTimeTaken = "0.0";
        StrTimeTaken=TimeStart();
        System.out.println("EncryptMesgSimple:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob:" + MesgNum + ":Forward");
        EncryptedMesg =new StringBuilder("");
        int Rand1Rotate = (int) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        int OffsetRotate1=SenderReceiverGUI.Sender.OffsetRotate1;
        int OffsetRotate2=SenderReceiverGUI.Sender.OffsetRotate2;
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Random OTP Generation =" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        StrTimeTaken = "0.0";
        StrTimeTaken=TimeStart();
        CyclicEncrypt(Rand1Rotate,OffsetRotate1,OffsetRotate2, WeiRand2, WeiCharRand3, SilentFlag);
        //WorkInProgress1Encrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:CyclicEncrypt=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        System.out.println("/************************** Encryption Ends *************** */");

        /**
         * ************************ Encryption Ends ***************
         */
        /**
         * ************************ Decryption Begins ***************
         */
        NoSenderReceivermain();
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("/************************** Decryption Begins *************** */");
        StrTimeTaken="0.0";
        StrTimeTaken=TimeStart();
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Decryption Begins:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Decryption Begins:DecryptedMesg=" + DecryptedMesg);
        }
        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Decryption:Key Reading=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WorkInProgress1Decrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WorkInProgress1Decrypt:DecryptedMesg=" + DecryptedMesg);
        }
        StrTimeTaken="0.0";
        StrTimeTaken=TimeStart();
        EavesdroppingFlag=false;
        //WorkInProgress1Decrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);
        CyclicDecrypt(Rand1Rotate,WeiRand2, WeiCharRand3, BobKeyPair.getPrivateKey("Decrypt"), SilentFlag);
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before DecryptMessageDetail:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before DecryptMessageDetail:DecryptedMesg=" + DecryptedMesg);
        }
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After DecryptMessageDetail:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After DecryptMessageDetail:DecryptedMesg=" + DecryptedMesg);
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        EavesdroppingFlag=true;
        //variables.clear();
        ConfirmedFirstEvent = null;
        ConfirmedSecondEvent = null;
        OccasionNumberOfTimes = 0;
        OccasionNoOfTimesIndex = 0;
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Decryption:CyclicDecrypt=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        if ((MyMessage2 != null) && (!MyMessage2.equalsIgnoreCase(""))) {
            MyMessage = MyMessage2;
        }
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
        TestExecResultsMessage();
        System.out.print(System.lineSeparator());
        SenderReceiverGUI.Sender.OffsetRotate1=-1;
        SenderReceiverGUI.Sender.StrlenRotate1=-1;
        SenderReceiverGUI.Sender.OffsetRotate2=-1;
        SenderReceiverGUI.Sender.StrlenRotate2=-1;
        System.out.println("/************************** Decryption Ends *************** */");
        /**
         * ************************ Decryption Ends ***************
         */
        System.out.println("EncryptMesgSimple:NumberOfTimes=" + NumberOfTimes + ":Message:Bob To Alice:" + MesgNum + ":Reverse");
        if ((MyMessage2 != null) && (!MyMessage2.equalsIgnoreCase(""))) {
            MyMessage = MyMessage2;
        }
//        if (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse") ) {
//             SetupAlice();
//             SetupBob();
//             SetupEve();
//        }
        System.out.println("/************************** Encryption Begins *************** */");
        StrTimeTaken="0.0";
        StrTimeTaken=TimeStart();
        MyPublicKey = AliceKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        CalibrationSender="ContextSetMesgSenderAlice";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //NumberOfTimes = 1;
        OccasionNumberOfTimes = 0;
        OccasionNoOfTimesIndex = 0;
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Encryption:Key Reading=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        StrTimeTaken=TimeStart();
        /**
         * ************************ Encryption Begins ***************
         */
        Rand1Rotate = (int) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        OffsetRotate1=SenderReceiverGUI.Sender.OffsetRotate1;
        OffsetRotate2=SenderReceiverGUI.Sender.OffsetRotate2;
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Encryption:OTP Generation=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        StrTimeTaken=TimeStart();
       
        CyclicEncrypt(Rand1Rotate,OffsetRotate1,OffsetRotate2, WeiRand2, WeiCharRand3, SilentFlag);
        //WorkInProgress1Encrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);

        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:CyclicEncrypt:=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        
        System.out.print(System.lineSeparator());
        System.out.println("/************************** Encryption Ends *************** */");
        /**
         * ************************ Encryption Ends ***************
         */
        /**
         * ************************ Decryption Begins ***************
         */
        System.out.println("/************************** Decryption Begins *************** */");
        NoSenderReceivermain();
        StrTimeTaken = "0.0";
        StrTimeTaken=TimeStart();
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        
        
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Decryption:Key Reading:=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Decryption Begins:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Decryption Begins:DecryptedMesg=" + DecryptedMesg);
        }
        /**
         * ************************ Decryption Begins ***************
         */
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        if (SuperSuppressOutput==false){
            System.out.println("EncryptMesgSimple::EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple::DecryptedMesg=" + DecryptedMesg);
        }
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WorkInProgress1Decrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WorkInProgress1Decrypt:DecryptedMesg=" + DecryptedMesg);
        }
        StrTimeTaken = "0.0";
        StrTimeTaken=TimeStart();
        EavesdroppingFlag=false;
        //WorkInProgress1Decrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);
        CyclicDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, AliceKeyPair.getPrivateKey("Decrypt"), SilentFlag);
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WorkInProgress1Decrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WorkInProgress1Decrypt:DecryptedMesg=" + DecryptedMesg);
        }
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        //variables.clear();
        ConfirmedFirstEvent = null;
        ConfirmedSecondEvent = null;
        OccasionNumberOfTimes = 0;
        OccasionNoOfTimesIndex = 0;
        EavesdroppingFlag=true;
        SenderReceiverGUI.Sender.OffsetRotate1=-1;
        SenderReceiverGUI.Sender.StrlenRotate1=-1;
        SenderReceiverGUI.Sender.OffsetRotate2=-1;
        SenderReceiverGUI.Sender.StrlenRotate2=-1;
        if ((MyMessage2 != null) && (!MyMessage2.equalsIgnoreCase(""))) {
            MyMessage = MyMessage2;
        }
        if (SilentFlag == false) {
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After CyclicDecrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After CyclicDecrypt:DecryptedMesg=" + DecryptedMesg);
        }
        StrTimeTaken=TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:CyclicDecrypt:CyclicDecrypt:=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        System.out.println("/************************** Decryption Ends *************** */");
        /**
         * ************************ Decryption Ends ***************
         */
    }

    public static Double JuliusCaeserEncryptSimple(String Mesg) {
        MathsExpressionParser.Expression LCGexpValueInput = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValueOutput = (() -> 0.0);
        Double Rand = (double) MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        String ExprnInput = "Xn+c";
        String ExprnOutput = "Xn1";
        EncryptedMesg =new StringBuilder("");
        variables.put("c", Rand);
        boolean OtherCharsFlag = false;
        //System.out.println("JuliusCaeserEncryptSimple:Rand=" + Rand + " c=" + (Rand%26) );

        for (int i = 0; i < Mesg.length(); i++) {
            Mychar = MyMessage.charAt(i) * 1.0;
            if ((Mychar.intValue() >= 'A') && (Mychar.intValue() <= 'Z')) {
                ExprnInput = "Xn+c";
                ExprnOutput = "Xn1";
            } else if ((Mychar.intValue() >= 'a') && (Mychar.intValue() <= 'z')) {
                ExprnInput = "Xn+c";
                ExprnOutput = "Xn1";
            } else {
                ExprnInput = "Xn";
                ExprnOutput = "Xn1";
            }
            variables.put("Xn", Mychar.doubleValue());
            //System.out.println("JuliusCaeserEncryptSimple:ExprnInput="+ExprnInput );
            //System.out.println("JuliusCaeserEncryptSimple:ExprnOutput="+ExprnOutput );
            LCGexpValueInput = parse(ExprnInput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserEncryptSimple:LCGexpValueInput="+(char)(LCGexpValueInput.eval().intValue()) + " LCGexpValueInput.eval().intValue()=" + LCGexpValueInput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            variables.put("Xn1", LCGexpValueInput.eval().doubleValue());
            LCGexpValueOutput = parse(ExprnOutput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserEncryptSimple:LCGexpValueOutput="+(char)LCGexpValueOutput.eval().intValue() + " LCGexpValueOutput.eval().intValue()=" + LCGexpValueOutput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            EncryptedMesg.append((char) (LCGexpValueOutput.eval().intValue()) );
        }
        return Rand;
    }

    public static void JuliusCaeserDecryptSimple(String Mesg, Double ShiftValue) {
        MathsExpressionParser.Expression LCGexpValueInput = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValueOutput = (() -> 0.0);
        String ExprnInput = "";
        String ExprnOutput = "";
        DecryptedMesg =new StringBuilder("");
        variables.put("c", ShiftValue);
        int c = variables.get("c").intValue();
        //System.out.println("JuliusCaeserDecrypt:ShiftValue=" + ShiftValue + " c=" + (ShiftValue%26) + " Range:CAPS:Min=" + ('A'-c-1) + " Max=" +('Z'+c+1)+ " Range:LOWER:Min=" + ('a'-c-1) + " Max=" +('z'+c+1));
        for (int i = 0; i < Mesg.length(); i++) {
            Mychar = Mesg.charAt(i) * 1.0;
            if ((!IsPermittedChar_OfJuliusCaeser(Mychar.intValue())) && (((Mychar.intValue() >= ('A' + c)) && (Mychar.intValue() <= ('Z' + c))))) {
                ExprnInput = "(Xn-c)";
                ExprnOutput = "Xn1";
                //System.out.println("JuliusCaeserDecryptSimple:Reached Else:All CAPS");
            } else if ((!IsPermittedChar_OfJuliusCaeser(Mychar.intValue())) && ((Mychar.intValue() >= ('a' + c)) && (Mychar.intValue() <= ('z' + c)))) {
                ExprnInput = "(Xn-c)";
                ExprnOutput = "Xn1";
                //System.out.println("JuliusCaeserDecryptSimple:Reached Else:All Small");
            } else if ((IsPermittedChar_OfJuliusCaeser(Mychar.intValue()))) {
                ExprnInput = "Xn";
                ExprnOutput = "Xn1";
                //System.out.println("JuliusCaeserDecryptSimple:Reached Else:OtherCharsFlag==true");
            } else {
                ExprnInput = "Xn";
                ExprnOutput = "Xn1";
                //System.out.println("JuliusCaeserDecryptSimple:Reached Else:Else");
            }
            variables.put("Xn", Mychar.intValue() * 1.0);
            //System.out.println("JuliusCaeserDecryptSimple:ExprnInput="+ExprnInput + " Xn=" + variables.get("Xn")+ " CapsORSmallFlag=" + CapsORSmallFlag + " a" + (int)'a' + " z=" + (int)'z');
            //System.out.println("JuliusCaeserDecryptSimple:ExprnOutput="+ExprnOutput + " CapsORSmallFlagElse=" + CapsORSmallFlagElse + " A" + (int)'A' + " Z=" + (int)'Z');
            LCGexpValueInput = parse(ExprnInput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserDecryptSimple:LCGexpValueInput="+(char)LCGexpValueInput.eval().intValue()+ " LCGexpValueInput.eval().intValue()=" + LCGexpValueInput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            variables.put("Xn1", LCGexpValueInput.eval().doubleValue());
            LCGexpValueOutput = parse(ExprnOutput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserDecryptSimple:LCGexpValueOutput="+(char)LCGexpValueOutput.eval().intValue() + " LCGexpValueOutput.eval().intValue()=" + LCGexpValueOutput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            DecryptedMesg.append((char) (LCGexpValueOutput.eval().intValue()));
        }
    }

    public static boolean IsPermittedChar_OfJuliusCaeser(int Mch) {
        if ((Mch == ' ') || (Mch == '.')) {
            return true;
        }
        return false;
    }

    public static Double JuliusCaeserEncryptComplex(String Mesg) {
        MathsExpressionParser.Expression LCGexpValueInput = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValueOutput = (() -> 0.0);
        Double Rand = (double) MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        String ExprnInput = "Xn-" + 'A' + "+c";
        String ExprnOutput = "Xn+" + 'A';
        EncryptedMesg =new StringBuilder("");
        variables.put("c", Rand);
        boolean OtherCharsFlag = false;
        //System.out.println("JuliusCaeserEncrypt:Rand=" + Rand + " c=" + (Rand%26) );

        for (int i = 0; i < Mesg.length(); i++) {
            Mychar = MyMessage.charAt(i) * 1.0;
            if ((Mychar >= 'A') && (Mychar <= 'Z')) {
                ExprnInput = "(Xn+c-" + (int) 'A' + ")+" + (int) 'A';
                ExprnOutput = "Xn1";
            } else if ((Mychar >= 'a') && (Mychar <= 'z')) {
                ExprnInput = "(Xn+c-" + (int) 'a' + ")+" + (int) 'a';
                ExprnOutput = "Xn1";
            } else {
                ExprnInput = "Xn";
                ExprnOutput = "Xn1";
            }
            variables.put("Xn", Mychar);
            //System.out.println("JuliusCaeserEncrypt:ExprnInput="+ExprnInput );
            //System.out.println("JuliusCaeserEncrypt:ExprnOutput="+ExprnOutput );
            LCGexpValueInput = parse(ExprnInput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserEncrypt:LCGexpValueInput="+(char)(LCGexpValueInput.eval().intValue()) + " LCGexpValueInput.eval().intValue()=" + LCGexpValueInput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            variables.put("Xn1", LCGexpValueInput.eval().doubleValue());
            LCGexpValueOutput = parse(ExprnOutput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserEncrypt:LCGexpValueOutput="+(char)LCGexpValueOutput.eval().intValue() + " LCGexpValueOutput.eval().intValue()=" + LCGexpValueOutput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            EncryptedMesg.append((char) (LCGexpValueOutput.eval().intValue()));
        }
        return Rand;
    }

    public static void JuliusCaeserDecryptComplex(String Mesg, Double ShiftValue) {
        MathsExpressionParser.Expression LCGexpValueInput = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValueOutput = (() -> 0.0);
        String ExprnInput = "";
        String ExprnOutput = "";
        boolean CapsORSmallFlag = false;
        boolean AllSmallFlag = false;
        boolean AllCAPSFlag = false;
        boolean CapsORSmallFlagElse = false;
        DecryptedMesg =new StringBuilder("");
        variables.put("c", ShiftValue);
        int c = variables.get("c").intValue();
        //System.out.println("JuliusCaeserDecrypt:ShiftValue=" + ShiftValue + " c=" + (ShiftValue%26) + " Range:CAPS:Min=" + ('A'-c-1) + " Max=" +('Z'+c+1)+ " Range:LOWER:Min=" + ('a'-c-1) + " Max=" +('z'+c+1));
        for (int i = 0; i < Mesg.length(); i++) {
            Mychar = Mesg.charAt(i) * 1.0;
            if ((!IsPermittedChar_OfJuliusCaeser(Mychar.intValue())) && (((Mychar >= ('A' + c)) && (Mychar <= ('Z' + c))))) {
                if (((CapsORSmallFlag == false) && (CapsORSmallFlagElse == true))
                        || ((AllCAPSFlag == true) && (AllSmallFlag == false))) {
                    // All Small Test Case End To End
                    ExprnInput = "(Xn-c)";
                    ExprnOutput = "Xn1";
                    CapsORSmallFlag = false;
                    CapsORSmallFlagElse = true;
                    //System.out.println("JuliusCaeserDecrypt:Reached if: Some Upper");
                } else if (AllSmallFlag == true) {
                    // Camel Case Test Case End To End
                    ExprnInput = "(Xn-c)";
                    ExprnOutput = "Xn1";
                    CapsORSmallFlag = true;
                    CapsORSmallFlagElse = false;
                    //System.out.println("JuliusCaeserDecrypt:Reached Else:Upper");
                } else if ((AllSmallFlag == false) && (AllCAPSFlag == false)) {
                    // All CAPS Test Case End To End
                    ExprnInput = "(Xn-c)";
                    ExprnOutput = "(Xn1)";
                    CapsORSmallFlag = true;
                    CapsORSmallFlagElse = false;
                    //System.out.println("JuliusCaeserDecrypt:Reached Else:Initial Character:Upper");
                } else {
                    // Characters outside the Latin/English Alphabet
                    ExprnInput = "(Xn-c)";
                    ExprnOutput = "Xn1";
                    CapsORSmallFlag = false;
                    CapsORSmallFlagElse = true;
                    //System.out.println("JuliusCaeserDecrypt:Reached Else:All Upper");
                }
                AllCAPSFlag = true;
            } else if ((!IsPermittedChar_OfJuliusCaeser(Mychar.intValue())) && ((Mychar >= ('a' + c)) && (Mychar <= ('z' + c)))) {
                ExprnInput = "(Xn-c)";
                ExprnOutput = "Xn1";
                CapsORSmallFlag = false;
                CapsORSmallFlagElse = false;
                AllSmallFlag = true;
                //System.out.println("JuliusCaeserDecrypt:Reached Else:All Small");
            } else if ((IsPermittedChar_OfJuliusCaeser(Mychar.intValue()))) {
                ExprnInput = "Xn";
                ExprnOutput = "Xn1";
                CapsORSmallFlag = false;
                CapsORSmallFlagElse = false;
                //System.out.println("JuliusCaeserDecrypt:Reached Else:OtherCharsFlag==true");
            } else {
                if (CapsORSmallFlag == true) {
                    ExprnInput = "Xn-c";
                    ExprnOutput = "Xn1+" + (int) ('Z' - 'A' + 1);
                    CapsORSmallFlagElse = true;
                    //System.out.println("JuliusCaeserDecrypt:Reached Else:CapsORSmallFlagElse==true");
                } else {
                    ExprnInput = "Xn-c";
                    ExprnOutput = "Xn1+" + (int) ('z' - 'a' + 1);
                    CapsORSmallFlagElse = true;
                    //System.out.println("JuliusCaeserDecrypt:Reached Else:Else");
                }
            }
            variables.put("Xn", Mychar);
            //System.out.println("JuliusCaeserDecrypt:ExprnInput="+ExprnInput + " Xn=" + variables.get("Xn")+ " CapsORSmallFlag=" + CapsORSmallFlag + " a" + (int)'a' + " z=" + (int)'z');
            //System.out.println("JuliusCaeserDecrypt:ExprnOutput="+ExprnOutput + " CapsORSmallFlagElse=" + CapsORSmallFlagElse + " A" + (int)'A' + " Z=" + (int)'Z');
            LCGexpValueInput = parse(ExprnInput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserDecrypt:LCGexpValueInput="+(char)LCGexpValueInput.eval().intValue()+ " LCGexpValueInput.eval().intValue()=" + LCGexpValueInput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            variables.put("Xn1", LCGexpValueInput.eval().doubleValue());
            LCGexpValueOutput = parse(ExprnOutput, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            //System.out.println("JuliusCaeserDecrypt:LCGexpValueOutput="+(char)LCGexpValueOutput.eval().intValue() + " LCGexpValueOutput.eval().intValue()=" + LCGexpValueOutput.eval().intValue() + " Mychar=" + (char)Mychar.intValue());
            DecryptedMesg.append( (char) (LCGexpValueOutput.eval().intValue()) );
        }
    }

    public static boolean VerifyInverse(String FunctionF, String DiffWithF, String FunctionG, String DiffWithG) {

        variables.put(DiffWithG, 2.0);
        variables.put(DiffWithF, 4.0);
        variablesStr.put(DiffWithG, DiffWithG);
        variablesStr.put(DiffWithF, DiffWithF);
        String FunctionG1 = FunctionG;
        FunctionG1 = FunctionG1.replaceAll(DiffWithG, DiffWithF);
        System.out.println(" FunctionF=" + FunctionF);
        System.out.println(" FunctionG=" + FunctionG1);
        ExprSimpleStrSep.SimpleStr SimpleString = parseSimple(FunctionF, variablesStr, DiffWithF, "Silent", ExprSimpleStrSep.LogLevel.Info);
        String IdX = SimpleString.evalStr().replaceAll(DiffWithF, FunctionG1);
        System.out.println(" SimpleString.evalStr()=" + SimpleString.evalStr());
        System.out.println(" IdX=" + IdX);

        String FunctionF1 = FunctionF.replaceAll(DiffWithF, DiffWithG);
        System.out.println(" FunctionF=" + FunctionF1);
        System.out.println(" FunctionG=" + FunctionG);
        ExprSimpleStrSep.SimpleStr SimpleString1 = parseSimple(FunctionG, variablesStr, DiffWithF, "Silent", ExprSimpleStrSep.LogLevel.Info);
        String IdY = SimpleString1.evalStr().replaceAll(DiffWithG, FunctionF1);
        System.out.println(" SimpleString1.evalStr()=" + SimpleString1.evalStr());
        System.out.println(" IdY=" + IdY);

        String xExprn = "";
        Scanner scanner = new Scanner(System.in);
        String TempxExprn = xExprn.trim();
        TempxExprn = scanner.nextLine();

        variablesStr.clear();
        variables.clear();
        return false;
    }

    public static void xmain(String... args) {
        boolean SilentFlag = true;
        UserTweaks_Entropy();// Initialize the Random Number Generator Over the hard coded Default Values.

        MyMessage = "azAZthe quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage = "How I Like A Drink, Alcoholic Of Course, After A Dull And Heavy Chapter Of Quantum Mechanics.";
        //MyMessage = "How I Like A Drink, Alcoholic Of Course, After A Dull And Heavy Chapter Of Quantum Mechanics.";
        //MyMessage = "How I .";
        //MyMessage = "How I.";
        //MyMessage = "able was I ere I saw elba.";
        myPrivKy = 8;
        myPubKy = 8;
        UserStrings_EncryptMesgSimple_Entropy();
        SetupAlice("Encrypt");
        System.out.println(System.lineSeparator());
        SetupBob("Encrypt");
        System.out.println(System.lineSeparator());
        SetupEve("Encrypt");
        System.out.println(System.lineSeparator());

        System.out.println("Alice:");
        //AliceKeyPair.init(mySeedKey, mySeed1DyDx);
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt"));
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt"));
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey());

        System.out.println("Bob:");
        //BobKeyPair.init(mySeedKey, mySeed1DyDx);
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt"));
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt"));
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey());

        TestStageStubAtomic(SilentFlag);
        //CycleTest(SilentFlag);
    }

    public static void CycleTest(boolean SilentFlag) {
        int Rand1Rotate = (int) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                
        variables.clear();
        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];

        CyclicEncrypt(Rand1Rotate,OffsetRotate1,OffsetRotate2, WeiRand2, WeiCharRand3, SilentFlag);
        System.out.println("/************************** Encryption Ends *************** */");
        System.out.println("EncryptedMesg=" + EncryptedMesg);
        System.out.println("/************************** Decryption Begins *************** */");

        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        variables.clear();
        MyPublicKey = BobKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Decrypt");;
        MyDecrptionEquation = InverseEqnUnderTest;
        CyclicDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, AliceKeyPair.getPrivateKey("Decrypt"), SilentFlag);
        System.out.println("/************************** Decryption Ends *************** */");

        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestStageStubAtomic(boolean SilentFlag) {
        Double Rand1Rotate = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);

        PreEncryptBlock();
        System.out.println("/************************** Encryption Begins *************** */");
        System.out.println("TestStagemain:Encryption Ends:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":EncryptedMesg=" + EncryptedMesg);
        System.out.println("TestStagemain:Encryption Ends:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":DecryptedMesg=" + DecryptedMesg);
        //System.out.println("/************************** WorkFactorEncrypt Encryption Begins *************** */");
        EncryptStrFuncTimeTaken="0.0";
        System.out.println("TestStagemain:Encryption:FuncTimeTaken:=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds" );
        EncryptedMesg = new StringBuilder(FractionEncryptN(EncryptedMesg.toString(), SilentFlag));
        String[] MyCharDropped = EncryptedMesg.toString().split(",@");
        System.out.println("TestStagemain:EncryptedMesg.length=" + EncryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length);
        //System.out.println("TestStagemain:FractionEncryptN:FuncTimeTaken:=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds" );
        //EncryptedMesg = WorkFactorEncrypt(EncryptedMesg, Rand1Rotate, SilentFlag);
        // UNCOMMENT LINES BELOW for low level Testing of Encryption
        //EncryptedMesg = RotateStrEncrypt(EncryptedMesg, "Double", Rand1Rotate, SilentFlag);
        //EncryptedMesg = JumbleStrEncrypt(EncryptedMesg, "Double", SilentFlag);
        System.out.println("TestStagemain:FractionEncryptN Ends:EncryptedMesg=" + EncryptedMesg);
        //EncryptedMesg = SplitEncryptDBl(EncryptedMesg, SilentFlag);
        System.out.println("TestStagemain:SplitEncryptDBl Ends:EncryptedMesg=" + EncryptedMesg);
        WeibullEncrypt(EncryptedMesg.toString(), WeiRand2, WeiCharRand3, SilentFlag);
        //TestStageLowLevelEncrypt(Rand1Rotate, WeiRand2, WeiCharRand3, SilentFlag);
        MyCharDropped = EncryptedMesg.toString().split(",@");
        System.out.println("TestStagemain:EncryptedMesg.length=" + EncryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length);
        System.out.println("TestStagemain:WeibullEncrypt Ends:EncryptedMesg=" + EncryptedMesg);
        System.out.println("TestStagemain:WeibullEncrypt:FuncTimeTaken:=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds" );
        
        System.out.println("/************************** Encryption Ends *************** */");

        System.out.println("/************************** Decryption Begins *************** */");
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        DecryptStrFuncTimeTaken="0.0";
        System.out.println("TestStagemain:Encryption Ends:EncryptedMesg=" + EncryptedMesg);
        System.out.println("TestStagemain:Encryption Ends:DecryptedMesg=" + DecryptedMesg);
        // UNCOMMENT LINES BELOW for low level Testing of Decryption
        //TestStageLowLevelDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, SilentFlag);
        //DecryptedMesg = RotateStrDecrypt(DecryptedMesg, "Double", Rand1Rotate, SilentFlag);
        //DecryptedMesg = JumbleStrDecrypt(EncryptedMesg, "Double", SilentFlag);
        MyCharDropped = DecryptedMesg.toString().split(",@");
        System.out.println("TestStagemain:DecryptedMesg.length=" + DecryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length);
        WeibullDecrypt(DecryptedMesg.toString(), WeiRand2, WeiCharRand3, SilentFlag);
        System.out.println("TestStagemain:WeibullDecrypt Ends:DecryptedMesg=" + DecryptedMesg);
        MyCharDropped = DecryptedMesg.toString().split(",@");
        System.out.println("TestStagemain:DecryptedMesg.length=" + DecryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length);
        //System.out.println("/************************** WorkFactorDecrypt Decryption Begins *************** */");
        //DecryptedMesg = WorkFactorDecrypt(EncryptedMesg, Rand1Rotate, SilentFlag);
        //DecryptedMesg = JoinDecryptDBl(DecryptedMesg, SilentFlag);
        System.out.println("TestStagemain:JoinDecryptDBl Ends:DecryptedMesg=" + DecryptedMesg);
        DecryptedMesg = new StringBuilder(FractionDecryptN(DecryptedMesg.toString(), SilentFlag));
        MyCharDropped = DecryptedMesg.toString().split(",@");
        System.out.println("TestStagemain:DecryptedMesg.length=" + DecryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length);
        //System.out.println("TestStagemain:FractionEncryptN:FuncTimeTaken:=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds" );
        System.out.println("TestStagemain:FractionDecryptN:FuncTimeTaken:=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds" );
        
        PostDecryptBlock();

        TestCasePassHighLevelFlag = TestExecResultsMessage();

    }

    public static void PreEncryptBlock() {
        variables.clear();
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        MyPublicEquation="";
        variables.clear();
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Pre Encryption Begins *************** */");
        
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; ) {
             
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) ){
                ShannonSimEncrypt(Temp[i],true);
                i++;
            }else {
                EncryptedMesg.append(' ').append(",@");
                i++;
            }
        }
        System.out.println("PreEncryptBlock:Final:EncryptedMesg=" + EncryptedMesg);
        // Adding Sucessive Chars
        StringBuilder NewEncryptedMesg= new StringBuilder(EncryptedMesg);
        EncryptedMesg=DiffusionJunkSimEncrypt( NewEncryptedMesg, "Double", true);
        System.out.println("PreEncryptBlock:Final:After ConfusionSim:EncryptedMesg=" + EncryptedMesg);
       
        variables.clear();
    }

    public static void PostDecryptBlock() {
        System.out.println("/************************** Post Decryption Begins *************** */");

        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        MyPublicEquation="";
        variables.clear();
        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        String[] MyCharDropped=DecryptedMesg.toString().split(",@");
        System.out.println("PostDecryptBlock:Given:DecryptedMesg=" + DecryptedMesg );
        System.out.println("PostDecryptBlock:Given:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
        DecryptedMesg=DiffusionJunkSimDecrypt( DecryptedMesg.toString(), "Double",true);
        MyCharDropped=DecryptedMesg.toString().split(",@");
        System.out.println("PostDecryptBlock:Final:DecryptedMesg=" + DecryptedMesg );
        System.out.println("PostDecryptBlock:Final:Length=" + DecryptedMesg.length()+ " MyCharDropped=" + MyCharDropped.length);
        String[] Temp = DecryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        if (EavesdroppingFlag == false) {
            // Diffusion Parameters
            // Surprise Parameters
            variables.put("diffusiond2", diffusiond2);
            variables.put("diffusionN", diffusionN);
            variables.put("confusionA", confusionA);
        }
        DecryptedMesg =new StringBuilder("");
        for (int i = 0; i <= NumOfChars; ) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) && (Double.isFinite(Double.valueOf(Temp[i])))) {
                ShannonSimDecrypt(Temp[i], true);
                i++;
            }else {
                i++;
            }
        }
        System.out.println("PostDecryptBlock:Final:DecryptedMesg=" + DecryptedMesg);
       
        variables.clear();
    }

    public static void TestStageLowLevelEncrypt(int Rand1Rotate, Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        System.out.println("/************************** TestStageLowEncrypt Begins *************** */");
        EncryptedMesg = new StringBuilder(FractionEncryptN(EncryptedMesg.toString(), SilentFlag));
        String[] MyCharDropped=EncryptedMesg.toString().split(",@");
        int StrlenRotate1=MyCharDropped.length;
        StringBuilder NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate1, StrlenRotate1,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        EncryptedMesg = new StringBuilder(JumbleStrEncrypt(EncryptedMesg.toString(), "Double", SilentFlag));
    }

    public static void TestStageLowLevelDecrypt(int  Rand1Rotate, Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        System.out.println("/************************** TestStageLowDecrypt Begins *************** */");
        StringBuilder NewEncryptedMesg =new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = JumbleStrDecrypt(NewEncryptedMesg, "Double", SilentFlag);
        DecryptedMesg=NewEncryptedMesg;
        String[] MyCharDropped=DecryptedMesg.toString().split(",@");
        int StrlenRotate1=MyCharDropped.length;
        NewEncryptedMesg=new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", OffsetRotate1, StrlenRotate1,SilentFlag);
        DecryptedMesg = new StringBuilder(FractionDecryptN(DecryptedMesg.toString(), SilentFlag));
    }

    public static void WorkInProgress1Encrypt(Double Rand1Rotate, Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        String WeiBullExprn = "Rand3";
        //if (SilentFlag == false) {
        System.out.println("WorkInProgress1Encrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WeiBullEncryptionChar:EncryptedMesg=" + EncryptedMesg);
        System.out.println("WorkInProgress1Encrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WeiBullEncryptionChar:DecryptedMesg=" + DecryptedMesg);
        //}
        //WeiBullEncryptionChar("WorkInProgress1Encrypt", WeiBullExprn, "Rand3", WeiCharRand3, "Xn", SilentFlag);
        //if (SilentFlag == false) {
        System.out.println("WorkInProgress1Encrypt:Encryption Ends:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WeiBullEncryptionChar:EncryptedMesg=" + EncryptedMesg);
        System.out.println("WorkInProgress1Encrypt:Encryption Ends:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WeiBullEncryptionChar:DecryptedMesg=" + DecryptedMesg);
        //}
    }

    public static void WorkInProgress1Decrypt(Double Rand1Rotate, Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        String WeiBullInvExprn = "1/Rand3";
        String[] Temp = EncryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        if (SilentFlag == false) {
            System.out.println("KeySensitivitySimple:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WeiBullDecryptionChar:EncryptedMesg=" + EncryptedMesg);
            System.out.println("KeySensitivitySimple:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WeiBullDecryptionChar:DecryptedMesg=" + DecryptedMesg);
        }
        //WeiBullDecryptionChar(NumOfChars, Temp, WeiBullInvExprn, "Xn", "Rand3", WeiCharRand3, SilentFlag);
        if (SilentFlag == false) {
            System.out.println("KeySensitivitySimple:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WeiBullDecryptionChar:EncryptedMesg=" + EncryptedMesg);
            System.out.println("KeySensitivitySimple:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WeiBullDecryptionChar:DecryptedMesg=" + DecryptedMesg);
        }
    }

    public static String TimeStart(){
        String StrTimeTaken = "";
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken = "" + ( (Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2]) ) );
            } else {
                StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Started:Run Time:" + current + " ");
        }
        return StrTimeTaken;
    }
    public static String TimeReading(String StrTimeTaken){
           {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ( (Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2]) ) );
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            StrTimeTaken= ""+((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
        }     
    return StrTimeTaken;
    }
    public static String FormatMessage(){
        String Result="";
       for (int i = 0; i < MyMessage.length(); i++) {
            Result +=MyMessage.charAt(i)+",@" ;
        }
    return Result;   
    }
}
