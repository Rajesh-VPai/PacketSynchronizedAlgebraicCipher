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
import QuantumLWE.QuantumResistantPipelineLWE;
import static RandomNumber.UserResearchStudy.RANDProdPerform;
import static Security.Calibration.CalibrationSender;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.LowLevelSecurityFramework.CauseFirstEventNNCReceiver;
import static Security.LowLevelSecurityFramework.CauseSecondEventNNCReceiver;
import static Security.Configuration.FOBRandomChar;
import static Security.LowLevelSecurityFramework.FormOccasionDiffEqnFEvent;
import static Security.LowLevelSecurityFramework.FormOccasionDiffEqnSEvent;
import static Security.LowLevelSecurityFramework.FormOccasionEqnFEvent;
import static Security.LowLevelSecurityFramework.FormOccasionEqnSEvent;
import static Security.LowLevelSecurityFramework.OccaLowerLimitFE;
import static Security.LowLevelSecurityFramework.OccaLowerLimitSE;
import static Security.LowLevelSecurityFramework.OccaUpperLimitFE;
import static Security.LowLevelSecurityFramework.OccaUpperLimitSE;
import static Security.LowLevelSecurityFramework.OccasionalismDecryptionFEvent;
import static Security.LowLevelSecurityFramework.OccasionalismDecryptionSEvent;
import static Security.Configuration.CyclicFlag;
import static Security.Configuration.NumberOfTimes;
import static Security.Configuration.NumberOfTimesOrg;
import static Security.Encryption.EncryptedMesg;
import static Security.Encryption.MyMessage;
import static Security.Configuration.SecurityPosture;
import static Security.PacketSynchronizedAlgebraicCipher.SuppressSystemOutput;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.Security.MyMessage2;
import static Security.Security.MyPrivateKey;
import static Security.Security.UnScramblerVarGap;
import static Security.Security.varOccassion;
import static Security.SecurityTestHarness.TypeOfEquation;
import static Security.Configuration.PRAGMA;
import static Security.Configuration.PRAGMADetail;
import static Security.SecurityTestHarness.ConfirmedFirstEvent;
import static Security.SecurityTestHarness.ConfirmedSecondEvent;
import static Security.Configuration.MessageInvariant;
import static Security.SecurityTestHarness.OccasionNoOfTimesIndex;
import static Security.SecurityTestHarness.OccasionNumberOfTimes;
import static Security.SecurityTestHarness.SecDecPerfFLAG;
import static Security.SecurityTestHarness.SecDecStrCurrentTimeTaken;
import static Security.SubstitutionBox.DiffusionJunkSimDecrypt;
import static Security.SubstitutionBox.DiffusionJunkWeiBullDecrypt;
import static Security.SubstitutionBox.ShannonSimDecrypt;
import static Security.SubstitutionBox.WeibullDecrypt;
import static Security.TranspositionPBox.DiffusionJunkRotateDecrypt;
import static Security.TranspositionPBox.FractionDecryptN;
import static Security.TranspositionPBox.JumbleStrDecrypt;
import static Security.Configuration.NumberOfFractions;
import static Security.PacketSynchronizedAlgebraicCipher.SuperSuppressOutput;
import static Security.Security.MyPublicKey;
import static Security.Security.MyDecrptionEquation;
import static Security.Security.variablesDecrypt;
import static Security.TranspositionPBox.RotateStrDecrypt;
import static SenderReceiverGUI.Receiver.EqnUnderTest;
import static SenderReceiverGUI.Receiver.HighLevel_Receiver_Cycle;
import static SenderReceiverGUI.Receiver.InitialMsgDecryptState_HighOTP;
import static SenderReceiverGUI.Receiver.InitialMsgDecryptState_SecretSeed;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Receiver.RecevTurnOffOccassionalism;
import static SenderReceiverGUI.Receiver.User_SecretHighOTP;
import static SenderReceiverGUI.Receiver.User_SecretSeedHighLevel;
import static SenderReceiverGUI.Receiver.User_SecretSeedTCPLevel;
import static SenderReceiverGUI.Receiver.User_SecretTCPOTP;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class Decryption {

    public static Logger log = Logger.getLogger(Decryption.class.getName());
    private String MyKey = null;
    public static boolean DecryptPerfFLAG = false;
    public static String DecryptStrFuncTimeTaken = "0.0";
    public static StringBuilder DecryptedMesg = new StringBuilder("");
    public static String[] delimiters = {":@", "#@", ",:", ",#", "\n"};
    public static final String DeTerminatorString = ",@";
    public static final String DatumTerminatorString = ",$";
    public static final String DatumTerminatorStringEscSeq = ",\\$";
    public static final String TCPCharTerminatorString = ",:";
    public static int LayersOfSecurityDecrypt = 0;

    public static String InternalObjDecryptKey1 = null;
    public static String PassedDecryptKey1 = null;

    // OTP Variables of Occassionalism
    public static Double FESender = 1234.0;
    public static Double FEReceiver = 0.0;
    public static Double FEOTP = 1.0;
    public static Double FEOTP_1_ = 213.0;
    public static Double FEOTP_3_ = 2134.0;
    public static Double FEOTP_2_ = 233.0;
    public static Double SESender = 1234.0;
    public static Double SEReceiver = 0.0;
    public static Double SEOTP = 1.0;
    public static Double SEOTP_1_ = 213.0;
    public static Double SEOTP_3_ = 2134.0;
    public static Double SEOTP_2_ = 233.0;

    public static String TestDebug = "Production"; // Debugging OR "Production"
    public static boolean PlainText = false; // toggle as needed

    public Decryption(String key) {
        MyKey = key;
    }

    public String getKey() {
        return MyKey;
    }

    public String DecryptMessageDetail(boolean SilentFlag, int OffsetRotate1, int OffsetRotate2, Double WeiRand2, Double WeiCharRand3, Double SenderFirstEvent, Double SenderSecondEvent, String MyKeyDecrypt, boolean EavesTestCasesRunning, boolean EavesdroppingFlag) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        LayersOfSecurityDecrypt = 0;
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:NumberOfTimes=" + NumberOfTimes + " CyclicFlag=" + CyclicFlag + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex + " OccasionNumberOfTimes=" + OccasionNumberOfTimes + " Begin");
        }
        System.out.println("/************************** Cycle Starts *************** */");
        if (SuperSuppressOutput == false) {
            System.out.println("**************** Parameters Begin***************");
        }
        if (SuperSuppressOutput == false) {
            Parameters();
        }
        if (SuperSuppressOutput == false) {
            System.out.println("****************** Parameters End***************");
        }
        System.out.println("DecryptMessageDetail:DecryptedMesg=" + DecryptedMesg);
        DecryptStrFuncTimeTaken = "0.0";
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        if (((EavesdroppingFlag == false)
                && (MyKeyDecrypt.equalsIgnoreCase(MyKey))
                && (MyKeyDecrypt.length() == myPrivKy)) //|| ((EavesTestCasesRunning == true)&&(StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting") ) )
                ) {
            System.out.println(ConsoleColors.GREEN + "DecryptDetail:Overall:Decryption Permitted:" + ConsoleColors.RESET);
            String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
            NewEncryptedMesg = new StringBuilder(DecryptedMesg);
            String DiffWithRespTo = "Xn";
            String[] argsXnSE = {"OTP_1_", ("" + SEOTP_1_),
                "OTP_2_", ("" + SEOTP_2_),
                "OTP_3_", ("" + SEOTP_3_)
            };
            String StrSecondEvent = "";
            varOccassion.clear();
            if (TypeOfEquation.equalsIgnoreCase("UseZerothEquation")) {
                StrSecondEvent = FormOccasionEqnSEvent(DiffWithRespTo, SESender, SEReceiver, NewEncryptedMesg.length(), SEOTP, (OccasionNoOfTimesIndex * 1.0), argsXnSE);
            } else {
                StrSecondEvent = FormOccasionDiffEqnSEvent(DiffWithRespTo, SESender, SEReceiver, NewEncryptedMesg.length(), SEOTP, argsXnSE);
            }

            Double SecondEvent = OccasionalismDecryptionSEvent("DecryptMessageDetail", 1.0, StrSecondEvent, DiffWithRespTo);
            boolean FlagCausedSecondEvent = false;
            if (RecevTurnOffOccassionalism == false) {
                FlagCausedSecondEvent = CauseSecondEventNNCReceiver(SenderSecondEvent, SecondEvent);
            } else {
                FlagCausedSecondEvent = true;
            }
            if (SuppressSystemOutput == false) {
                System.out.println("DecryptDetail:Occasionalism Param:SecondEvent=" + SecondEvent + " NewEncryptedMesg.length()=" + NewEncryptedMesg.length());
            }
            if (SilentFlag == false) {
                System.out.println("DecryptDetail:Param:DiffWithRespTo=" + DiffWithRespTo + " SESender=" + SESender + " SEReceiver=" + SEReceiver + " NewEncryptedMesg.length()=" + NewEncryptedMesg.length() + " SEOTP=" + SEOTP + " TypeOfEquation=" + TypeOfEquation);
                System.out.println("DecryptDetail:After OccasionalismDecryptionSE:SecondEvent=" + SecondEvent + " SenderSecondEvent=" + SenderSecondEvent + " NumberOfTimes=" + NumberOfTimes + " OccasionNumberOfTimes=" + OccasionNumberOfTimes + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex);
                System.out.println("DecryptDetail:After OccasionalismDecryptionSE:SEOTP_1_=" + SEOTP_1_ + " SEOTP_2_=" + SEOTP_2_ + " SEOTP_3_=" + SEOTP_3_);
                System.out.println("DecryptDetail:After OccasionalismDecryptionSE:StrSecondEvent=" + StrSecondEvent + " MessageInvariant=" + MessageInvariant);
            }
            varOccassion.clear();
            if (FlagCausedSecondEvent == false) {
                System.out.println(ConsoleColors.RED + "DecryptDetail:Aborting due to Occasionalism Failure:Second Event" + ConsoleColors.RESET);
                DecryptedMesg = new StringBuilder("");
                EncryptedMesg = new StringBuilder("");
                return "Error:DecryptDetail:Occasionalism Failed";
            }
            if (SilentFlag == false) {
                System.out.println("DecryptDetail:NumberOfTimes=" + NumberOfTimes + ":Initial Decryption:EncryptedMesg=" + EncryptedMesg);
                System.out.println("DecryptDetail:NumberOfTimes=" + NumberOfTimes + ":Initial Decryption:DecryptedMesg=" + DecryptedMesg);
            }
            if ((TestDebug.equalsIgnoreCase("Production")) && (PlainText == true))
                ; else if ((TestDebug.equalsIgnoreCase("Production")) && (DecryptedMesg.toString().contains(" ")) && (PlainText == false)) {
                ;//DecryptedMesg = new StringBuilder(DecryptedMesg.toString().replaceAll(" ", "@,#"));
            } else {
                System.out.println("DecryptDetail:NO SPACES:");
            }
            if (DecryptedMesg.toString().trim().isEmpty()) {
                return "Error:DecryptDetail:DecryptedMesg Empty";
            }
            NewEncryptedMesg = new StringBuilder(DecryptedMesg);
            if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
                NewEncryptedMesg = Layer5DecryptWorkFactor(SilentFlag);
                LayersOfSecurityDecrypt++;
            }
            DecryptedMesg = NewEncryptedMesg;
            if ( (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) /*&& (false)*/ ) {
                NewEncryptedMesg = Layer4DecryptWeiBull(WeiRand2, WeiCharRand3, MyKey, SilentFlag);
                LayersOfSecurityDecrypt++;
            }
            DecryptedMesg = NewEncryptedMesg;
            if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
                NewEncryptedMesg = Layer3DecryptJumble(SilentFlag);
                LayersOfSecurityDecrypt++;
            }
            DecryptedMesg = NewEncryptedMesg;
            if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
                NewEncryptedMesg = Layer2DecryptRotate(NewEncryptedMesg, SilentFlag);
                LayersOfSecurityDecrypt++;
            }
            DecryptedMesg = NewEncryptedMesg;
            DiffWithRespTo = "Xn";
            String[] argsXnFE = {"OTP_1_", ("" + FEOTP_1_),
                "OTP_2_", ("" + FEOTP_2_),
                "OTP_3_", ("" + FEOTP_3_)
            };
            String StrFirstEvent = "";
            varOccassion.clear();
            if (TypeOfEquation.equalsIgnoreCase("UseZerothEquation")) {
                StrFirstEvent = FormOccasionEqnFEvent(DiffWithRespTo, FESender, FEReceiver, NewEncryptedMesg.length(), FEOTP, (OccasionNoOfTimesIndex * 1.0), argsXnFE);
            } else {
                StrFirstEvent = FormOccasionDiffEqnFEvent(DiffWithRespTo, FESender, FEReceiver, NewEncryptedMesg.length(), FEOTP, argsXnFE);
            }
            Double FirstEvent = OccasionalismDecryptionFEvent("DecryptMessageDetail", 1.0, StrFirstEvent, DiffWithRespTo);
            boolean FlagCausedFirstEvent = false;
            if (RecevTurnOffOccassionalism == false) {
                FlagCausedFirstEvent = CauseFirstEventNNCReceiver(SenderFirstEvent, FirstEvent);
            } else {
                FlagCausedFirstEvent = true;
            }
            if (SuppressSystemOutput == false) {
                System.out.println("DecryptDetail:Occasionalism Param:SenderFirstEvent=" + SenderFirstEvent + " :FirstEvent=" + FirstEvent + " NewEncryptedMesg.length()=" + NewEncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
            }

            if (SilentFlag == false) {
                System.out.println("DecryptDetail:Param:DiffWithRespTo=" + DiffWithRespTo + " FESender=" + FESender + " FEReceiver=" + FEReceiver + " NewEncryptedMesg.length()=" + NewEncryptedMesg.length() + " FEOTP=" + FEOTP + " TypeOfEquation=" + TypeOfEquation);
                System.out.println("DecryptDetail:After OccasionalismDecryptionFE:FirstEvent=" + FirstEvent + " SenderFirstEvent=" + SenderFirstEvent + " NumberOfTimes=" + NumberOfTimes + " OccasionNumberOfTimes=" + OccasionNumberOfTimes + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex);
                System.out.println("DecryptDetail:After OccasionalismDecryptionFE:FEOTP_1_=" + FEOTP_1_ + " FEOTP_2_=" + FEOTP_2_ + " FEOTP_3_=" + FEOTP_3_);
                System.out.println("DecryptDetail:After OccasionalismDecryptionFE:StrFirstEvent=" + StrFirstEvent + " MessageInvariant=" + MessageInvariant);
            }
            varOccassion.clear();
            if (FlagCausedFirstEvent == false) {
                System.out.println(ConsoleColors.RED + "DecryptDetail:Aborting due to Occasionalism Failure:First Event" + ConsoleColors.RESET);
                DecryptedMesg = new StringBuilder("");
                EncryptedMesg = new StringBuilder("");
                return "Error:DecryptDetail:Occasionalism FirstEvent Failed";
            }
            NewEncryptedMesg = new StringBuilder(DecryptedMesg);
            if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
                NewEncryptedMesg = Layer1DecryptSimple(NewEncryptedMesg, MyKey, EavesdroppingFlag, SilentFlag);
                LayersOfSecurityDecrypt++;
            }
            DecryptedMesg = NewEncryptedMesg;
            if (((EavesdroppingFlag == false)
                    && (MyKeyDecrypt.equalsIgnoreCase(MyKey))
                    && (MyKeyDecrypt.length() == myPrivKy)) //|| ((EavesTestCasesRunning == true)&&(StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting") ) ) 
                    ) {
                System.out.println(ConsoleColors.GREEN + "DecryptDetail:Scamble:Decryption Permitted:" + ConsoleColors.RESET);
                if (NewEncryptedMesg.toString().endsWith(DeTerminatorString)) {
                    MyCharDropped = NewEncryptedMesg.toString().split(DeTerminatorString);
                    if (MyCharDropped.length == 1) {
                        NewEncryptedMesg = new StringBuilder(MyCharDropped[0]);
                    }
                }
                if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
                    NewEncryptedMesg = Layer0DecryptScamble(NewEncryptedMesg, SilentFlag);
                    LayersOfSecurityDecrypt++;
                }
                DecryptedMesg = NewEncryptedMesg;
                if (SuppressSystemOutput == false) {
                    System.out.println("DecryptDetail:UnScramblerVarGap:Length=" + DecryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
                }
                System.out.println("Result:DecryptedMesg=" + DecryptedMesg.toString() + " Len=" + DecryptedMesg.toString().length());
            } else {
                System.out.println(ConsoleColors.RED + "DecryptDetail:Failed Eavesdropping Key" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "DecryptDetail:UnScramblerVarGap:Eavesdropping NOT Permitted:EavesdroppingFlag=" + EavesdroppingFlag + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "DecryptDetail:UnScramblerVarGap:Eavesdropping NOT Permitted:Decryption.MyKeyDecrypt=" + MyKeyDecrypt + " Length=" + MyKeyDecrypt.length() + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "DecryptDetail:UnScramblerVarGap:Eavesdropping NOT Permitted:myPrivKy=" + myPrivKy + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "DecryptDetail:UnScramblerVarGap:Eavesdropping NOT Permitted:MyKey=" + MyKey + " Length=" + MyKey.length() + ConsoleColors.RESET);
                variablesDecrypt.clear();
                DecryptedMesg = new StringBuilder("");
                NewEncryptedMesg = new StringBuilder("");
                return "Error:DecryptDetail:Eavesdropping Failed";
            }
        } else {
            System.out.println(ConsoleColors.RED + "DecryptDetail:Overall:Failed Eavesdropping Key" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "DecryptDetail:Overall:Eavesdropping NOT Permitted:EavesdroppingFlag=" + EavesdroppingFlag + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "DecryptDetail:Overall:Eavesdropping NOT Permitted:Decryption.MyKeyDecrypt=" + MyKeyDecrypt + " Length=" + MyKeyDecrypt.length() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "DecryptDetail:Overall:Eavesdropping NOT Permitted:myPrivKy=" + myPrivKy + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "DecryptDetail:Overall:Eavesdropping NOT Permitted:MyKey=" + MyKey + " Length=" + MyKey.length() + ConsoleColors.RESET);
            variablesDecrypt.clear();
            DecryptedMesg = new StringBuilder("");
            NewEncryptedMesg = new StringBuilder("");
            return "Error:DecryptDetail:Eavesdropping Overall Failed";
        }

        if (SilentFlag == false) {
            System.out.println("DecryptDetail:Final:EncryptedMesg=" + EncryptedMesg);
            System.out.println("DecryptDetail:Final:DecryptedMesg=" + DecryptedMesg);
        }
        System.out.println("Result:DecryptedMesg=" + DecryptedMesg);
        
        System.out.println("/************************** Cycle Ends *************** */");
        /**
         * ************************ Decryption Ends ***************
         */
        return DecryptedMesg.toString();
    }

    public static StringBuilder ReWork(String Algo) {
        System.out.println("Decryption ReWork:Called from Algo=" + Algo);
        String[] TempData;
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        TempData = DecryptedMesg.toString().split(DeTerminatorString);
        int exp = 0;
        for (exp = 0; (exp < TempData.length); exp++) {
            if (TempData[exp].matches("[0-9]*\\.[0-9Ee]*")) {
                NewEncryptedMesg.append(TempData[exp].trim());
                NewEncryptedMesg.append(DeTerminatorString);
            } else if (TempData[exp].matches("[0-9Ee.]*\\,[0-9Ee.]*")) {
                String[] MyReworkData = TempData[exp].split(",");
                if ((MyReworkData.length <= 2) && (TempData[exp].contains(","))) {
                    MyReworkData = TempData[exp].split(",");
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:,:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:,:FATAL ERROR:BUG NOT CORRECTED:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }
                StringBuilder TempReworkMesg = new StringBuilder("");
                for (int i = 0; i < MyReworkData.length; i++) {
                    NewEncryptedMesg.append(MyReworkData[i]);
                    NewEncryptedMesg.append(DeTerminatorString);
                    TempReworkMesg.append(MyReworkData[i]);
                    TempReworkMesg.append(DeTerminatorString);
                }
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:,:Complete:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:,: ReWorked Data=" + TempReworkMesg + ConsoleColors.RESET);
            } else if (TempData[exp].matches("[0-9Ee.]*\\@[0-9Ee.]*")) {
                String[] MyReworkData = TempData[exp].split("@");
                if ((MyReworkData.length <= 2) && (TempData[exp].contains("@"))) {
                    MyReworkData = TempData[exp].split("@");
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:@:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:@:FATAL ERROR:BUG NOT CORRECTED:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }
                StringBuilder TempReworkMesg = new StringBuilder("");
                for (int i = 0; i < MyReworkData.length; i++) {
                    NewEncryptedMesg.append(MyReworkData[i]);
                    NewEncryptedMesg.append(DeTerminatorString);
                    TempReworkMesg.append(MyReworkData[i]);
                    TempReworkMesg.append(DeTerminatorString);
                }
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:@:Complete:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:@: ReWorked Data=" + TempReworkMesg + ConsoleColors.RESET);
            } else if (TempData[exp].matches("[0-9Ee.]*\\.[0-9Ee.]*")) {
                String[] MyReworkData = TempData[exp].split("\\.");
                if (TempData[exp].contains(".")) {
                    MyReworkData = TempData[exp].split("\\.");
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.:FATAL ERROR:BUG NOT CORRECTED:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }
                StringBuilder TempReworkMesg = new StringBuilder("");
                for (int i = 0; (i < MyReworkData.length - 1) && (!MyReworkData[i].equalsIgnoreCase("")); i++) {
                    if (MyReworkData[i + 1].startsWith("0")) {
                        NewEncryptedMesg.append(MyReworkData[i]).append(".0");
                        NewEncryptedMesg.append(DeTerminatorString);
                        TempReworkMesg.append(MyReworkData[i]).append(".0");
                        TempReworkMesg.append(DeTerminatorString);
                        // Process NEXT PART
                        MyReworkData[i + 1] = MyReworkData[i + 1].replaceFirst("0", "");
                        if ((i + 2) < MyReworkData.length) {
                            MyReworkData[i + 1] = MyReworkData[i + 1] + "." + MyReworkData[i + 2];
                        }
                        MyReworkData[i + 2] = "";
                    } else {
                        NewEncryptedMesg.append(MyReworkData[i]);
                        NewEncryptedMesg.append(DeTerminatorString);
                        TempReworkMesg.append(MyReworkData[i]);
                        TempReworkMesg.append(DeTerminatorString);
                    }
                }
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.:Complete:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.: ReWorked Data=" + TempReworkMesg + ConsoleColors.RESET);
            } else if (TempData[exp].contains("EE")) {
                TempData[exp] = TempData[exp].replaceFirst("EE", "E");
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(DeTerminatorString);
            } else if (TempData[exp].contains("..")) {
                TempData[exp] = TempData[exp].replaceFirst("\\.\\.", ".");
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(DeTerminatorString);
            } else if (TempData[exp].matches("[0-9]*")) {
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(DeTerminatorString);
            } else {
                //System.out.println("ReWork:" + Algo +":Else:");
                //System.out.println(ConsoleColors.RED + "ReWork:Else:TempData[" + exp + "]=t" + TempData[exp] +"t" + ConsoleColors.RESET);
            }
        }
        DecryptedMesg = NewEncryptedMesg;
        return NewEncryptedMesg;
    }

    public static String ReWorkLowLevel(String Mesg, String RegEx) {
        String[] TempData;
        TempData = Mesg.split(RegEx);
        return TempData[0];
    }

    public static void Parameters() {
        System.out.println("Parameters Decryption:CyclicFlag:=" + CyclicFlag);
        System.out.println("Parameters Decryption:NumberOfTimes:=" + NumberOfTimes);
        System.out.println("Parameters Decryption:NumberOfTimesOrg:=" + NumberOfTimesOrg);
        System.out.println("Parameters Decryption:MessageInvariant:=" + MessageInvariant);
        System.out.println("Parameters Decryption:FOBRandomChar:=" + FOBRandomChar);
        System.out.println("Parameters:RANDProdPerform:=" + RANDProdPerform);
        System.out.println("Parameters Decryption:NumberOfFractions:=" + NumberOfFractions);
        System.out.println("Parameters Decryption:PRAGMA:=" + PRAGMA);
        System.out.println("Parameters Decryption:PRAGMADetail:=" + PRAGMADetail);
        System.out.println("Parameters Decryption:SecurityPosture:=" + SecurityPosture);
        System.out.println("Parameters Decryption:CalibrationSender:=" + CalibrationSender);
        System.out.println("Parameters Encryption:OccaLowerLimitFE:=" + OccaLowerLimitFE);
        System.out.println("Parameters Encryption:OccaUpperLimitFE:=" + OccaUpperLimitFE);
        System.out.println("Parameters Encryption:OccaLowerLimitSE:=" + OccaLowerLimitSE);
        System.out.println("Parameters Encryption:OccaUpperLimitSE:=" + OccaUpperLimitSE);
        System.out.println("Parameters Decryption:EavesdroppingFlag:=" + EavesdroppingFlag);
        System.out.println("Parameters Decryption:LayersOfSecurityDecrypt:=" + LayersOfSecurityDecrypt);
    }

    public static StringBuilder WorkFactorDecrypt(StringBuilder Exprn, int OffsetRotate2, int StrlenRotate2, boolean SilentFlag) {
        if ((Exprn == null) || (Exprn.toString().equalsIgnoreCase(""))) {
            return Exprn;
        }
        StringBuilder NewEncryptedMesg = new StringBuilder(DecryptedMesg);
        DecryptStrFuncTimeTaken = "0.0";
        if (NewEncryptedMesg.toString().contains(" ")) {
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceAll(" ", ""));
        } else {
            System.out.println("WorkFactorDecrypt:NO SPACES:");
        }
        NewEncryptedMesg = Layer5DOT3DecryptFractionate(NewEncryptedMesg, SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        NewEncryptedMesg = Layer5DOT2DecryptJumble(NewEncryptedMesg, SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        NewEncryptedMesg = Layer5DOT1DecryptRotate(NewEncryptedMesg, SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        return NewEncryptedMesg;
    }

    public static void CyclicDecrypt(int Rand1Rotate, Double WeiRand2, Double WeiCharRand3, String MyKey, boolean SilentFlag) {
        if ((InternalObjDecryptKey1 == null) || (InternalObjDecryptKey1.equalsIgnoreCase(""))) {
            InternalObjDecryptKey1 = MyPrivateKey;
        }
        if ((PassedDecryptKey1 == null) || (PassedDecryptKey1.equalsIgnoreCase(""))) {
            PassedDecryptKey1 = MyKey;
        }

        Decryption MyDecrypt = new Decryption(InternalObjDecryptKey1);
        NumberOfTimes = NumberOfTimesOrg;
        OccasionNoOfTimesIndex = NumberOfTimes - 1;
        OccasionNumberOfTimes = OccasionNoOfTimesIndex;
        if ((CyclicFlag == false) && (NumberOfTimes == 1)) {
            if ((ConfirmedFirstEvent[OccasionNoOfTimesIndex] != null) && (ConfirmedSecondEvent[OccasionNoOfTimesIndex] != null)) {
                MyDecrypt.DecryptMessageDetail(SilentFlag, SenderReceiverGUI.Receiver.OffsetRotate1, SenderReceiverGUI.Receiver.OffsetRotate2, WeiRand2, WeiCharRand3, ConfirmedFirstEvent[OccasionNoOfTimesIndex], ConfirmedSecondEvent[OccasionNoOfTimesIndex], PassedDecryptKey1, false, EavesdroppingFlag);
            }
            if ((InternalObjDecryptKey1 != null) && (!InternalObjDecryptKey1.equalsIgnoreCase(""))) {
                InternalObjDecryptKey1 = null;
            }
            if ((PassedDecryptKey1 != null) && (!PassedDecryptKey1.equalsIgnoreCase(""))) {
                PassedDecryptKey1 = null;
            }
        } else {
            for (int i = 1; (i <= NumberOfTimesOrg) && (CyclicFlag == true) && (NumberOfTimes <= NumberOfTimesOrg); i++) {
                NumberOfTimes = i;
                if ((SecDecPerfFLAG == false) && (NumberOfTimes == 3)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    SecDecStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    System.out.println("Cycle Started:Run Time:" + current + " ");
                }
                if ((ConfirmedFirstEvent[OccasionNoOfTimesIndex] != null) && (ConfirmedSecondEvent[OccasionNoOfTimesIndex] != null)) {
                    MyDecrypt.DecryptMessageDetail(SilentFlag, SenderReceiverGUI.Receiver.OffsetRotate1, SenderReceiverGUI.Receiver.OffsetRotate2, WeiRand2, WeiCharRand3, ConfirmedFirstEvent[OccasionNoOfTimesIndex], ConfirmedSecondEvent[OccasionNoOfTimesIndex], PassedDecryptKey1, false, EavesdroppingFlag);
                }
                if ((NumberOfTimes > 1) && (!DecryptedMesg.toString().equalsIgnoreCase(""))) {
                    if (NumberOfTimes < (NumberOfTimesOrg - 1)) {
                        EncryptedMesg = DecryptedMesg;
                    }
                    OccasionNumberOfTimes--;
                    OccasionNoOfTimesIndex--;
                }
                if ((SecDecPerfFLAG == false) && (NumberOfTimes == 3)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(SecDecStrCurrentTimeTaken))) + " seconds.");
                }
                if (NumberOfTimes == 3) {
                    SecDecPerfFLAG = true;
                }
            }
            MyMessage = MyMessage2;
            if ((InternalObjDecryptKey1 != null) && (!InternalObjDecryptKey1.equalsIgnoreCase(""))) {
                InternalObjDecryptKey1 = null;
            }
            if ((PassedDecryptKey1 != null) && (!PassedDecryptKey1.equalsIgnoreCase(""))) {
                PassedDecryptKey1 = null;
            }
        }
    }

    public static void NoSenderReceivermain() {
        if (PacketSynchronizedAlgebraicCipher.StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting")) {
            SenderReceiverGUI.Receiver.StrlenRotate1 = SenderReceiverGUI.Sender.StrlenRotate1;
            SenderReceiverGUI.Receiver.OffsetRotate1 = SenderReceiverGUI.Sender.OffsetRotate1;
            SenderReceiverGUI.Receiver.StrlenRotate2 = SenderReceiverGUI.Sender.StrlenRotate2;
            SenderReceiverGUI.Receiver.OffsetRotate2 = SenderReceiverGUI.Sender.OffsetRotate2;
            if (/*(EavesTestCasesRunning == false) &&*/(!SenderReceiverGUI.ReceiverGUI.StrGUI.equalsIgnoreCase("GUI"))
                    && (!SenderReceiverGUI.ReceiverGUI.StrGUI.equalsIgnoreCase("Console"))) {
                EavesdroppingFlag = true;
            }
        } else if ((SenderReceiverGUI.ReceiverGUI.StrGUI.equalsIgnoreCase("GUI"))
                || (!SenderReceiverGUI.ReceiverGUI.StrGUI.equalsIgnoreCase("Console"))) {
            EavesdroppingFlag = false;
        } else {
            EavesdroppingFlag = true;
        }
    }

    public static StringBuilder Layer0DecryptScamble(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
            }
        }
        //System.out.println("Layer0DecryptScamble:NewEncryptedMesg="+NewEncryptedMesg);
        if (NewEncryptedMesg.toString().contains("@,#")) {
            //NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceAll("@,#", "]"));
        }
        NewEncryptedMesg = UnScramblerVarGap(NewEncryptedMesg, SilentFlag);
        //if((DecryptedByte.intValue() <0)||(DecryptedByte.intValue() > 255) )
        //            throw new RuntimeException("Layer0DecryptScamble:DecryptedByte:MAPPED:Outside Range:");
        if (NewEncryptedMesg.toString().contains("]")) {
            //NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceAll("]", " "));
        }
        DecryptedMesg = NewEncryptedMesg;
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
        if (SuppressSystemOutput == false) {
            System.out.println("Layer0DecryptScamble:UnScramblerVarGap:Length=" + DecryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        
        //System.out.println("Layer0DecryptScamble:NewEncryptedMesg="+NewEncryptedMesg);
        return NewEncryptedMesg;
    }

    public StringBuilder Layer1DecryptSimple(StringBuilder Exprn, String MyKeyDecrypt, boolean EavesdroppingFlag, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        String[] MyCharDropped = null;
        if (((EavesdroppingFlag == false)
                && (MyKeyDecrypt.equalsIgnoreCase(MyKey))
                && (MyKeyDecrypt.length() == myPrivKy)) //|| /*((EavesTestCasesRunning == true)*/
                //&& (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))
                ) {
            System.out.println(ConsoleColors.GREEN + "DecryptDetail:ShannonSimDecrypt:Decryption Overall Permitted:" + ConsoleColors.RESET);
            if ((EavesdroppingFlag == false)
                    && (MyKeyDecrypt.equalsIgnoreCase(MyKey))
                    && (MyKeyDecrypt.length() == myPrivKy)) {
                System.out.println(ConsoleColors.GREEN + "DecryptDetail:ShannonSimDecrypt:Decryption Permitted:" + ConsoleColors.RESET);
                // Diffusion Parameters
                // Surprise Parameters
                variablesDecrypt.put("diffusiond2", diffusiond2);
                variablesDecrypt.put("diffusionN", diffusionN);
                variablesDecrypt.put("confusionA", confusionA);
            } else {
                System.out.println(ConsoleColors.RED + "DecryptDetail:ShannonSimDecrypt:Decryption NOT Permitted:" + ConsoleColors.RESET);
                variablesDecrypt.clear();
                Exprn = new StringBuilder("");
                DecryptedMesg = new StringBuilder("");
                NewEncryptedMesg = new StringBuilder("");
                return NewEncryptedMesg;
            }
            MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
            if (SuppressSystemOutput == false) {
                System.out.println("ConfusionSimDecrypt:Given:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
            }
            NewEncryptedMesg = DiffusionJunkSimDecrypt(Exprn.toString(), "Double", SilentFlag);
            DecryptedMesg = NewEncryptedMesg;
            MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
            if (SuppressSystemOutput == false) {
                System.out.println("ConfusionSimDecrypt:Final:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
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
            if (SuppressSystemOutput == false) {
                System.out.println("Layer1DecryptSimple:DiffusionJunkSimDecrypt:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
            }

            DecryptStrFuncTimeTaken = "0.0";
            if ((DecryptPerfFLAG == false)) {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                if (TimeTaken.length == 3) {
                    DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
                }
            }
            String[] Temp = NewEncryptedMesg.toString().split(DeTerminatorString);
            int NumOfChars = Temp.length - 1;
            if (SuppressSystemOutput == false) {
                System.out.println("DecryptDetail:ShannonSimDecrypt:length=" + NewEncryptedMesg.length());
            }
            if (SuppressSystemOutput == false) {
                System.out.println("DecryptDetail:ShannonSimDecrypt:Number of Characters:len=" + Temp.length);
            }
            //System.out.println("Layer1DecryptSimple:User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP);
            //System.out.println("Layer1DecryptSimple:User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel + " User_SecretTCPOTP=" + User_SecretTCPOTP);
            //System.out.println("Layer1DecryptSimple:InitialMsgDecryptState_SecretSeed=" + InitialMsgDecryptState_SecretSeed + " InitialMsgDecryptState_HighOTP=" + InitialMsgDecryptState_HighOTP);
            //System.out.println("Layer1DecryptSimple:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
            HighLevel_Receiver_Cycle();
            System.out.println("Layer1DecryptSimple:User_SecretHighOTP=" + User_SecretHighOTP + ":User_SecretSeedHighLevel=" + User_SecretSeedHighLevel);
            //System.out.println("Layer1DecryptSimple:User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel + " User_SecretTCPOTP=" + User_SecretTCPOTP);
            System.out.println("Layer1DecryptSimpleInitialMsgDecryptState_HighOTP=" + InitialMsgDecryptState_HighOTP + ":InitialMsgDecryptState_SecretSeed=" + InitialMsgDecryptState_SecretSeed);
            System.out.println("Layer1DecryptSimple:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
            MyDecrptionEquation=InverseEqnUnderTest;
            DecryptedMesg = new StringBuilder("");
            for (int i = 0; (i <= NumOfChars) && (NumOfChars > 0);) {
                if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                    //System.out.println("DecryptDetail:ShannonSimDecrypt:Temp[" + i + "]=" + Temp[i]);
                    ShannonSimDecrypt(Temp[i], SilentFlag);
                    i++;
                }
                //if((DecryptedByte.intValue() <0)||(DecryptedByte.intValue() > 255) )
                //    throw new RuntimeException("Layer1DecryptSimple:DecryptedByte:MAPPED:Outside Range:");
                //if((!DecryptedByte.isNaN())&&( (DecryptedByte.intValue() <=32)||(DecryptedByte.intValue() >=126) ) )
                //    throw new RuntimeException("Layer1DecryptSimple:DecryptedByte:MAPPED:Outside Range:");
            }
            System.out.println("DecryptDetail:Layer1DecryptSimple:m=" + variablesDecrypt.get("m"));
            System.out.println("DecryptDetail:Layer1DecryptSimple:N=" + variablesDecrypt.get("N"));
            System.out.println("Layer1DecryptSimple:User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP);
            System.out.println("Layer1DecryptSimple:User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel + " User_SecretTCPOTP=" + User_SecretTCPOTP);
            System.out.println("Layer1DecryptSimple:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
            //System.out.println("Layer1DecryptSimple:DecryptedMesg=" + DecryptedMesg);
            //System.out.println("Layer1DecryptSimple:DecryptedByte=" + (char) DecryptedByte.intValue() + ":DecryptedByte(y)=" +  DecryptedByte.intValue() + " Xn=" + variablesDecrypt.get("Xn"));
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
            MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
            if (SuppressSystemOutput == false) {
                System.out.println("DecryptDetail:ShannonSimDecrypt:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
            }
            //System.out.println("DecryptDetail:ShannonSimDecrypt:DecryptedMesg=" + DecryptedMesg );
            NewEncryptedMesg = new StringBuilder(DecryptedMesg);
            return NewEncryptedMesg;
        } else {
            System.out.println(ConsoleColors.RED + "DecryptDetail:ShannonSimDecrypt:Eavesdropping NOT Permitted:" + ConsoleColors.RESET);
//            System.out.println(ConsoleColors.RED + "DecryptDetail:ShannonSimDecrypt:Eavesdropping NOT Permitted:EavesdroppingFlag=" + EavesdroppingFlag + ConsoleColors.RESET);
//            System.out.println(ConsoleColors.RED + "DecryptDetail:ShannonSimDecrypt:Eavesdropping NOT Permitted:Decryption.MyKeyDecrypt=" + MyKeyDecrypt + " Length=" + MyKeyDecrypt.length() + ConsoleColors.RESET);
//            System.out.println(ConsoleColors.RED + "DecryptDetail:ShannonSimDecrypt:Eavesdropping NOT Permitted:myPrivKy=" + myPrivKy + ConsoleColors.RESET);
//            System.out.println(ConsoleColors.RED + "DecryptDetail:ShannonSimDecrypt:Eavesdropping NOT Permitted:MyKey=" + MyKey + " Length=" + MyKey.length() + ConsoleColors.RESET);
            DecryptedMesg = new StringBuilder("");
            Exprn = new StringBuilder("");
            variablesDecrypt.clear();
            NewEncryptedMesg = new StringBuilder("");
            return NewEncryptedMesg;
        }
    }

    public static StringBuilder Layer2DecryptRotate(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        DecryptedMesg = NewEncryptedMesg;
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:Layer2DecryptRotate:Char Length:Length=" + MyCharDropped.length);
        }
        NewEncryptedMesg = DiffusionJunkRotateDecrypt(NewEncryptedMesg.toString(), "Double", SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
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
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:DiffusionJunkRotateDecrypt:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:RotateStrDecrypt:Char Length:Length=" + MyCharDropped.length);
        }
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Receiver.OffsetRotate1, SenderReceiverGUI.Receiver.StrlenRotate1, SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:RotateStrDecrypt:Length=" + DecryptedMesg.length() + " Chars=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("DecryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Rotate:EncryptedMesg=" + EncryptedMesg);
            System.out.println("DecryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Rotate:DecryptedMesg=" + DecryptedMesg);
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer3DecryptJumble(boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        //SilentFlag=false;
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder(DecryptedMesg);
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:JumbleStrDecrypt:Char Length:Length=" + MyCharDropped.length);
        }
        NewEncryptedMesg = JumbleStrDecrypt(NewEncryptedMesg, "Double", SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:JumbleDecrypt:MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("DecryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Reverse:EncryptedMesg=" + EncryptedMesg);
            System.out.println("DecryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Reverse:DecryptedMesg=" + DecryptedMesg);
        }
        return NewEncryptedMesg;
    }

    public StringBuilder Layer4DecryptWeiBull(Double WeiRand2, Double WeiCharRand3, String MyKeyDecrypt, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder(DecryptedMesg);
        if (((EavesdroppingFlag == false)
                && (MyKeyDecrypt.equalsIgnoreCase(MyKey))
                && (MyKeyDecrypt.length() == myPrivKy)) //|| (EavesTestCasesRunning == true)
                ) {
            System.out.println("DecryptDetail:WeibullDecrypt:Decryption Permitted:");
            // Diffusion Parameters
            // Surprise Parameters
            variablesDecrypt.put("diffusiond2", diffusiond2);
            variablesDecrypt.put("diffusionN", diffusionN);
            variablesDecrypt.put("confusionA", confusionA);
        }
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:Given:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
        }
        NewEncryptedMesg = new StringBuilder(DecryptedMesg);

        NewEncryptedMesg = DiffusionJunkWeiBullDecrypt(NewEncryptedMesg, "Double", SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("Layer4DecryptWeiBull:DiffusionJunkWeiBullDecrypt:MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        WeibullDecrypt(NewEncryptedMesg.toString(), WeiRand2, WeiCharRand3, SilentFlag);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:WeibullDecrypt:Length=" + DecryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("DecryptDetail:After WeibullDecrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("DecryptDetail:After WeibullDecrypt:DecryptedMesg=" + DecryptedMesg);
        }
        DecryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("Layer4DecryptWeiBull:WeibullDecrypt:Length=" + DecryptedMesg.length() + " :MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }

        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DecryptWorkFactor(boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = WorkFactorDecrypt(NewEncryptedMesg, SenderReceiverGUI.Receiver.OffsetRotate2, SenderReceiverGUI.Receiver.StrlenRotate2, SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("DecryptDetail:WorkFactorDecrypt:Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("DecryptDetail:NumberOfTimes=" + NumberOfTimes + ":After WorkFactorDecrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("DecryptDetail:NumberOfTimes=" + NumberOfTimes + ":After WorkFactorDecrypt:DecryptedMesg=" + DecryptedMesg);
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
        if (SuppressSystemOutput == false) {
            System.out.println("Layer5DecryptWorkFactor:WorkFactorDecrypt:Length=" + DecryptedMesg.length() + " :MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }

        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DOT3DecryptFractionate(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        DecryptedMesg = new StringBuilder(FractionDecryptN(NewEncryptedMesg.toString(), SilentFlag));
        if (SilentFlag == false) {
            System.out.println("WorkFactorDecrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WorkFactorDecrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorDecrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After WorkFactorDecrypt:DecryptedMesg=" + DecryptedMesg);
        }
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorDecrypt:FractionDecryptN: Length=" + DecryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        NewEncryptedMesg = new StringBuilder(DecryptedMesg);
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DOT1DecryptRotate(StringBuilder Exprn, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        StringBuilder NewEncryptedMesg = Exprn;
        DecryptedMesg = NewEncryptedMesg;
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        NewEncryptedMesg = RotateStrDecrypt(NewEncryptedMesg, "Double", SenderReceiverGUI.Receiver.OffsetRotate2, SenderReceiverGUI.Receiver.StrlenRotate2, SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorDecrypt:DecryptedMesg.length=" + NewEncryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("WorkFactorDecrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before FractionatingDecrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorDecrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before FractionatingDecrypt:DecryptedMesg=" + DecryptedMesg);
        }
        MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorDecrypt:FractionDecryptN: Length=" + DecryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DOT2DecryptJumble(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        DecryptStrFuncTimeTaken = "0.0";
        DecryptedMesg = NewEncryptedMesg;
        String[] MyCharDropped = DecryptedMesg.toString().split(DeTerminatorString);
        NewEncryptedMesg = JumbleStrDecrypt(NewEncryptedMesg, "Double", SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        if (SilentFlag == false) {
            System.out.println("WorkFactorDecrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before JumbleStrDecrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorDecrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before JumbleStrDecrypt:DecryptedMesg=" + DecryptedMesg);
        }
        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorDecrypt:JumbleStrDecrypt: Length=" + DecryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(DecryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer6DecryptQuantumLWE(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        SilentFlag = false;
        DecryptStrFuncTimeTaken = "0.0";
        DecryptedMesg = NewEncryptedMesg;

        int[] MyLWEKey = new int[1024];
        for (int i = 0; i < MyLWEKey.length; i++) {
            MyLWEKey[i] = (MyPublicKey != null && MyPublicKey.length() > 0)
                    ? (MyPublicKey.charAt(i % MyPublicKey.length()) % 3) - 1 : 0;
        }

        String plaintext = QuantumResistantPipelineLWE.receiverUnpackAndDecrypt(DecryptedMesg.toString(), MyLWEKey);

        NewEncryptedMesg = new StringBuilder(plaintext);
        DecryptedMesg = NewEncryptedMesg;
        return NewEncryptedMesg;
    }
}
