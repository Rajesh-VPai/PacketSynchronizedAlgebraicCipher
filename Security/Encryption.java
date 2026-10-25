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
import static Security.Decryption.DecryptedMesg;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.Configuration.FOBRandomChar;
import static Security.LowLevelSecurityFramework.FormOccasionDiffEqnFEvent;
import static Security.LowLevelSecurityFramework.FormOccasionDiffEqnSEvent;
import static Security.LowLevelSecurityFramework.FormOccasionEqnFEvent;
import static Security.LowLevelSecurityFramework.FormOccasionEqnSEvent;
import static Security.LowLevelSecurityFramework.OccaLowerLimitFE;
import static Security.LowLevelSecurityFramework.OccaLowerLimitSE;
import static Security.LowLevelSecurityFramework.OccaUpperLimitFE;
import static Security.LowLevelSecurityFramework.OccaUpperLimitSE;
import static Security.LowLevelSecurityFramework.OccasionalismEncryptionFEvent;
import static Security.LowLevelSecurityFramework.OccasionalismEncryptionSEvent;
import static Security.Configuration.CyclicFlag;
import static Security.Configuration.NumberOfTimes;
import static Security.Configuration.NumberOfTimesOrg;
import static Security.Configuration.SecurityPosture;
import static Security.PacketSynchronizedAlgebraicCipher.SuppressSystemOutput;
import static Security.Security.ScramblerVarGap;
import static Security.Security.varOccassion;
import static Security.SecurityTestHarness.TypeOfEquation;
import static Security.TranspositionPBox.RotateStrEncrypt;
import static Security.Security.MyMessage2;
import static Security.Configuration.PRAGMA;
import static Security.Configuration.PRAGMADetail;
import static Security.SecurityTestHarness.ConfirmedFirstEvent;
import static Security.SecurityTestHarness.ConfirmedSecondEvent;
import static Security.Configuration.MessageInvariant;
import static Security.SecurityTestHarness.OccasionNoOfTimesIndex;
import static Security.SecurityTestHarness.OccasionNumberOfTimes;
import static Security.SecurityTestHarness.SecEncPerfFLAG;
import static Security.SecurityTestHarness.SecEncStrCurrentTimeTaken;
import static Security.SubstitutionBox.DiffusionJunkSimEncrypt;
import static Security.SubstitutionBox.DiffusionJunkWeiBullEncrypt;
import static Security.SubstitutionBox.ShannonSimEncrypt;
import static Security.SubstitutionBox.WeibullEncrypt;
import static Security.TranspositionPBox.DiffusionJunkRotateEncrypt;
import static Security.TranspositionPBox.FractionEncryptN;
import static Security.TranspositionPBox.JumbleStrEncrypt;
import static Security.Configuration.NumberOfFractions;
import static Security.OTPGeneratorClass.GenerateOTP;
import static Security.PacketSynchronizedAlgebraicCipher.SuperSuppressOutput;
import static Security.Security.MyPrivateKey;
import static Security.Security.variablesEncrypt;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import static SenderReceiverGUI.Sender.HighLevel_Sender_Cycle;
import static SenderReceiverGUI.Sender.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.OTPLength;
import static SenderReceiverGUI.Sender.User_SecretHighOTP;
import static SenderReceiverGUI.Sender.User_SecretSeedHighLevel;
import static SenderReceiverGUI.Sender.User_SecretSeedTCPLevel;
import static SenderReceiverGUI.Sender.User_SecretTCPOTP;
import static Security.Security.MyPublicEquation;
import static SenderReceiverGUI.SenderGUI.SenderMesg;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class Encryption {

    public static Logger log = Logger.getLogger(Encryption.class.getName());
    private static String MyKey = null;
    public static boolean OverallEncryptPerfFLAG = false;
    public static boolean EncryptPerfFLAG = false;
    public static boolean EncryptPerfFLAG1 = false;
    public static boolean EncryptPerfFLAG2 = false;
    public static String EncryptStrFuncTimeTaken = "0.0";
    public static String OverallEncryptStrFuncTimeTaken = "0.0";
    public static String EncryptStr1FuncTimeTaken = "0.0";
    public static String EncryptStr2FuncTimeTaken = "0.0";
    public static StringBuilder EncryptedMesg = null;
    public static String MyMessage = "";
    public static final String EncTerminatorString = ",@";
    public static int LayersOfSecurityEncrypt = 0;

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

    public static String EncryptMessageDetail(int Rand1Rotate, Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        if ((OverallEncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                OverallEncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                OverallEncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        LayersOfSecurityEncrypt = 0;
        //ResetState();
        EncryptStrFuncTimeTaken = "0.0";
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
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + " CyclicFlag=" + CyclicFlag + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex + " OccasionNumberOfTimes=" + OccasionNumberOfTimes + " Begin");
        }
        StringBuilder NewEncryptedMesg = new StringBuilder(SenderMesg);
        EncryptedMesg = NewEncryptedMesg;

        EncryptStrFuncTimeTaken = "0.0";
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:Initial:Length=" + MyMessage.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
            NewEncryptedMesg = Layer0EncryptScamble(SilentFlag);
            LayersOfSecurityEncrypt++;
        }
        EncryptedMesg = NewEncryptedMesg;
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:ScramblerVarGap:ScramVarGap:Length=" + NewEncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        // Diffusion Parameters
        // Surprise Parameters
        variablesEncrypt.put("diffusiond2", diffusiond2);
        variablesEncrypt.put("diffusionN", diffusionN);
        variablesEncrypt.put("confusionA", confusionA);
        if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
            NewEncryptedMesg = Layer1EncryptSimple(SilentFlag);
            LayersOfSecurityEncrypt++;
        }
        EncryptedMesg = NewEncryptedMesg;
        String DiffWithRespTo = "Xn";
        FESender = (double) GenerateOTP(OTPLength); //1234.0;
        FEReceiver = 0.0;
        FEOTP = 1.0;
        FEOTP_1_ = (double) GenerateOTP(OTPLength); //213.0;
        FEOTP_3_ = (double) GenerateOTP(OTPLength); //2134.0;
        FEOTP_2_ = (double) GenerateOTP(OTPLength); //233.0;
        String[] argsXnFE = {"OTP_1_", ("" + FEOTP_1_),
            "OTP_2_", ("" + FEOTP_2_),
            "OTP_3_", ("" + FEOTP_3_)
        };
        String StrFirstEvent = "";
        String OccassionStrMesg1 = EncryptedMesg.toString();
        varOccassion.clear();
        if (TypeOfEquation.equalsIgnoreCase("UseZerothEquation")) {
            StrFirstEvent = FormOccasionEqnFEvent(DiffWithRespTo, FESender, FEReceiver, OccassionStrMesg1.length(), FEOTP, (OccasionNoOfTimesIndex * 1.0), argsXnFE);
        } else {
            StrFirstEvent = FormOccasionDiffEqnFEvent(DiffWithRespTo, FESender, FEReceiver, OccassionStrMesg1.length(), FEOTP, argsXnFE);
        }
        Double FirstEvent = OccasionalismEncryptionFEvent("EncryptMessageDetail", 1.0, StrFirstEvent, DiffWithRespTo);
        ConfirmedFirstEvent[OccasionNoOfTimesIndex] = FirstEvent;
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:Occasionalism Param:ConfirmedFirstEvent=" + ConfirmedFirstEvent[OccasionNoOfTimesIndex] + " (EncryptedMesg.length()=" + OccassionStrMesg1.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:Param:DiffWithRespTo=" + DiffWithRespTo + " Sender=" + FESender + " Receiver=" + FEReceiver + " (EncryptedMesg.length()=" + OccassionStrMesg1.length() + " FEOTP=" + FEOTP + " TypeOfEquation=" + TypeOfEquation);
            System.out.println("EncryptDetail:After OccasionalismEncryptionFE:ConfirmedFirstEvent=" + ConfirmedFirstEvent[OccasionNoOfTimesIndex] + " NumberOfTimes=" + NumberOfTimes + " OccasionNumberOfTimes=" + OccasionNumberOfTimes + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex);
            System.out.println("EncryptDetail:After OccasionalismDecryptionFE:FEOTP_1_=" + FEOTP_1_ + " FEOTP_2_=" + FEOTP_2_ + " FEOTP_3_=" + FEOTP_3_);
            System.out.println("EncryptDetail:After OccasionalismEncryptionFE:StrFirstEvent=" + StrFirstEvent + " MessageInvariant=" + MessageInvariant);
        }
        varOccassion.clear();
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After FractionEncryptOne:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After FractionEncryptOne:DecryptedMesg=" + DecryptedMesg);
        }
        NewEncryptedMesg = EncryptedMesg;
        if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
            NewEncryptedMesg = Layer2EncryptRotate(NewEncryptedMesg, Rand1Rotate, SilentFlag);
            LayersOfSecurityEncrypt++;
        }
        EncryptedMesg = NewEncryptedMesg;
        if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
            NewEncryptedMesg = Layer3EncryptJumble(SilentFlag);
            LayersOfSecurityEncrypt++;
        }
        EncryptedMesg = NewEncryptedMesg;
        if ((!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true)))/*&&(false)*/) {
            NewEncryptedMesg = Layer4EncryptWeiBull(WeiRand2, WeiCharRand3, SilentFlag);
            LayersOfSecurityEncrypt++;
        }
        EncryptedMesg = NewEncryptedMesg;
        if (!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) {
            NewEncryptedMesg = Layer5EncryptWorkFactor(Rand1Rotate, SilentFlag);
            LayersOfSecurityEncrypt++;
        }
        EncryptedMesg = NewEncryptedMesg;
        DiffWithRespTo = "Xn";
        SESender = (double) GenerateOTP(OTPLength); //1234.0;
        SEReceiver = 0.0;
        SEOTP = 1.0;
        SEOTP_1_ = (double) GenerateOTP(OTPLength); //213.0;
        SEOTP_3_ = (double) GenerateOTP(OTPLength); //2134.0;
        SEOTP_2_ = (double) GenerateOTP(OTPLength); //233.0;
        String[] argsXnSE = {"OTP_1_", ("" + SEOTP_1_),
            "OTP_2_", ("" + SEOTP_2_),
            "OTP_3_", ("" + SEOTP_3_)
        };
        String StrSecondEvent = "";
        varOccassion.clear();
        if (TypeOfEquation.equalsIgnoreCase("UseZerothEquation")) {
            StrSecondEvent = FormOccasionEqnSEvent(DiffWithRespTo, SESender, SEReceiver, EncryptedMesg.length(), SEOTP, (OccasionNoOfTimesIndex * 1.0), argsXnSE);
        } else {
            StrSecondEvent = FormOccasionDiffEqnSEvent(DiffWithRespTo, SESender, SEReceiver, EncryptedMesg.length(), SEOTP, argsXnSE);
        }

        Double SecondEvent = OccasionalismEncryptionSEvent("EncryptMessageDetail", 1.0, StrSecondEvent, DiffWithRespTo);
        ConfirmedSecondEvent[OccasionNoOfTimesIndex] = SecondEvent;
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:Occasionalism Param:ConfirmedSecondEvent=" + ConfirmedSecondEvent[OccasionNoOfTimesIndex] + " (EncryptedMesg.length()=" + EncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:Param:DiffWithRespTo=" + DiffWithRespTo + " SESender=" + SESender + " SEReceiver=" + SEReceiver + " (EncryptedMesg.length()=" + EncryptedMesg.length() + " SEOTP=" + SEOTP + " TypeOfEquation=" + TypeOfEquation);
            System.out.println("EncryptDetail:After OccasionalismEncryptionSE:ConfirmedSecondEvent=" + ConfirmedSecondEvent[OccasionNoOfTimesIndex] + " NumberOfTimes=" + NumberOfTimes + " OccasionNumberOfTimes=" + OccasionNumberOfTimes + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex);
            System.out.println("EncryptDetail:After OccasionalismDecryptionSE:SEOTP_1_=" + SEOTP_1_ + " SEOTP_2_=" + SEOTP_2_ + " SEOTP_3_=" + SEOTP_3_);
            System.out.println("EncryptDetail:After OccasionalismEncryptionSE:StrSecondEvent=" + StrSecondEvent + " MessageInvariant=" + MessageInvariant);
        }
        varOccassion.clear();
        //if (SilentFlag == false) {
        System.out.println("EncryptDetail:End:EncryptedMesg=" + EncryptedMesg + " Length Encrypted=" + EncryptedMesg.toString().length());
        System.out.println("EncryptDetail:End:DecryptedMesg=" + DecryptedMesg + " Length DecryptedMesg=" + DecryptedMesg.toString().length());
        //}
        //EncryptedMesg=NewEncryptedMesg.toString();
        /**
         * ************************ Encryption Ends ***************
         */
        System.out.println("/************************** Cycle Ends *************** */" + " Length Encrypted=" + EncryptedMesg.toString().length());
        //Vulnerability1( WeiRand2,  WeiCharRand3,  SilentFlag);
        //SenderMesg=EncryptedMesg;
        if ((OverallEncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            OverallEncryptStrFuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(OverallEncryptStrFuncTimeTaken)));
            System.out.println("Encryption Cycle Time Taken:OverallEncryptStrFuncTimeTaken=" + OverallEncryptStrFuncTimeTaken + " Seconds.");
        }
        return EncryptedMesg.toString();
    }

    public static StringBuilder ReWork(String Algo) {
        System.out.println("Encryption ReWork:Called from Algo=" + Algo);
        String[] TempData;
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        TempData = EncryptedMesg.toString().split(EncTerminatorString);
        int exp = 0;
        for (exp = 0; (exp < TempData.length); exp++) {
            if (TempData[exp].matches("[0-9]*\\.[0-9Ee]*")) {
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(EncTerminatorString);
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
                    NewEncryptedMesg.append(EncTerminatorString);
                    TempReworkMesg.append(MyReworkData[i]);
                    TempReworkMesg.append(EncTerminatorString);
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
                    NewEncryptedMesg.append(EncTerminatorString);
                    TempReworkMesg.append(MyReworkData[i]);
                    TempReworkMesg.append(EncTerminatorString);
                }
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:@:Complete:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:@: ReWorked Data=" + TempReworkMesg + ConsoleColors.RESET);
            } else if (TempData[exp].matches("[0-9Ee.]*\\.[0-9Ee.]*")) {
                String[] MyReworkData = TempData[exp].split("\\.");
                if ((MyReworkData.length <= 2) && (TempData[exp].contains("."))) {
                    MyReworkData = TempData[exp].split("\\.");
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.:FATAL ERROR:BUG NOT CORRECTED:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }
                StringBuilder TempReworkMesg = new StringBuilder("");
                for (int i = 0; (i < MyReworkData.length) && (!MyReworkData[i].equalsIgnoreCase("")); i++) {
                    if (MyReworkData[i + 1].startsWith("0")) {
                        NewEncryptedMesg.append(MyReworkData[i]).append(".0");
                        NewEncryptedMesg.append(EncTerminatorString);
                        TempReworkMesg.append(MyReworkData[i]).append(".0");
                        TempReworkMesg.append(EncTerminatorString);
                        // Process NEXT PART
                        MyReworkData[i + 1] = MyReworkData[i + 1].replaceFirst("0", "");
                        if ((i + 2) < MyReworkData.length) {
                            MyReworkData[i + 1] = MyReworkData[i + 1] + "." + MyReworkData[i + 2];
                        }
                        MyReworkData[i + 2] = "";
                    } else {
                        NewEncryptedMesg.append(MyReworkData[i]);
                        NewEncryptedMesg.append(EncTerminatorString);
                        TempReworkMesg.append(MyReworkData[i]);
                        TempReworkMesg.append(EncTerminatorString);
                    }
                }
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.:Complete:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "ReWork:REWORK:Dup.: ReWorked Data=" + TempReworkMesg + ConsoleColors.RESET);
            } else if (TempData[exp].contains("EE")) {
                TempData[exp] = TempData[exp].replaceFirst("EE", "E");
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(EncTerminatorString);
            } else if (TempData[exp].contains("..")) {
                TempData[exp] = TempData[exp].replaceFirst("\\.\\.", ".");
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(EncTerminatorString);
            } else if (TempData[exp].matches("[0-9]*")) {
                NewEncryptedMesg.append(TempData[exp]);
                NewEncryptedMesg.append(EncTerminatorString);
            } else {
                System.out.println(ConsoleColors.RED + "ReWork:Else:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
            }
        }
        EncryptedMesg = NewEncryptedMesg;
        return NewEncryptedMesg;
    }

    public static String ReWorkLowLevel(String Mesg, String RegEx) {
        String[] TempData;
        TempData = Mesg.split(RegEx);
        TempData = Mesg.split(RegEx);
        return TempData[0];
    }

    public static void Parameters() {
        System.out.println("Parameters Encryption:CyclicFlag:=" + CyclicFlag);
        System.out.println("Parameters Encryption:NumberOfTimes:=" + NumberOfTimes);
        System.out.println("Parameters Encryption:NumberOfTimesOrg:=" + NumberOfTimesOrg);
        System.out.println("Parameters Encryption:MessageInvariant:=" + MessageInvariant);
        System.out.println("Parameters Encryption:FOBRandomChar:=" + FOBRandomChar);
        System.out.println("Parameters:RANDProdPerform:=" + RANDProdPerform);
        System.out.println("Parameters Encryption:NumberOfFractions:=" + NumberOfFractions);
        System.out.println("Parameters Encryption:PRAGMA:=" + PRAGMA);
        System.out.println("Parameters Encryption:PRAGMADetail:=" + PRAGMADetail);
        System.out.println("Parameters Encryption:SecurityPosture:=" + SecurityPosture);
        System.out.println("Parameters Encryption:CalibrationSender:=" + CalibrationSender);
        System.out.println("Parameters Encryption:OccaLowerLimitFE:=" + OccaLowerLimitFE);
        System.out.println("Parameters Encryption:OccaUpperLimitFE:=" + OccaUpperLimitFE);
        System.out.println("Parameters Encryption:OccaLowerLimitSE:=" + OccaLowerLimitSE);
        System.out.println("Parameters Encryption:OccaUpperLimitSE:=" + OccaUpperLimitSE);
        System.out.println("Parameters Encryption:EavesdroppingFlag:=" + EavesdroppingFlag);
        System.out.println("Parameters Encryption:LayersOfSecurityEncrypt:=" + LayersOfSecurityEncrypt);
    }

    public static StringBuilder WorkFactorEncrypt(StringBuilder NewEncryptedMesg, int Rand1Rotate, boolean SilentFlag) {
        if ((NewEncryptedMesg == null) || (NewEncryptedMesg.toString().equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        if (SilentFlag == false) {
            System.out.println("WorkFactorEncrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before FractionatingEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorEncrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before FractionatingEncrypt:DecryptedMesg=" + DecryptedMesg);
        }
        EncryptStrFuncTimeTaken = "0.0";
        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorEncrypt:WorkFactorEncrypt:Length=" + NewEncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        EncryptedMesg = NewEncryptedMesg;
        NewEncryptedMesg = Layer5DOT1EncryptRotate(NewEncryptedMesg, Rand1Rotate, SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
        NewEncryptedMesg = Layer5DOT2EncryptJumble(NewEncryptedMesg, SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
        NewEncryptedMesg = Layer5DOT3EncryptFractionate(NewEncryptedMesg, SilentFlag);
        EncryptedMesg = NewEncryptedMesg;

        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorEncrypt:JumbleStrEncrypt:Length=" + NewEncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        return NewEncryptedMesg;
    }

    public static void CyclicEncrypt(int Rand1Rotate, int OffsetRotate1, int OffsetRotate2, Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        //Encryption MyEncrpt = new Encryption();
        if (NumberOfTimes == NumberOfTimesOrg) {
            MyMessage2 = MyMessage;
        }
        for (int i = 0; i < (NumberOfTimes + 2); i++) {
            ConfirmedFirstEvent[i] = 0.0;
            ConfirmedSecondEvent[i] = 0.0;
            //System.out.println("CycleTest:CyclicDecrypt:ConfirmedFirstEvent[" + i + "]=" + ConfirmedFirstEvent[i]);
            //System.out.println("CycleTest:CyclicDecrypt:ConfirmedSecondEvent[" + i + "]=" + ConfirmedSecondEvent[i]);
        }
        if ((CyclicFlag == false) && (NumberOfTimes == 1)) {
            if ((ConfirmedFirstEvent[OccasionNoOfTimesIndex] != null) && (ConfirmedSecondEvent[OccasionNoOfTimesIndex] != null)) {
                EncryptMessageDetail(Rand1Rotate, WeiRand2, WeiCharRand3, SilentFlag);
            }
        } else {
            for (int i = 1; (i <= NumberOfTimesOrg) && (CyclicFlag == true); i++, OccasionNumberOfTimes++, OccasionNoOfTimesIndex++) {
                NumberOfTimes = i;
                if ((SecEncPerfFLAG == false) && (NumberOfTimes == 3)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    SecEncStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    System.out.println("Cycle Started:Run Time:" + current + " ");
                }
                if ((ConfirmedFirstEvent[OccasionNoOfTimesIndex] != null) && (ConfirmedSecondEvent[OccasionNoOfTimesIndex] != null)) {
                    EncryptMessageDetail(Rand1Rotate, WeiRand2, WeiCharRand3, SilentFlag);
                }
                MyMessage = EncryptedMesg.toString();
                if ((SecEncPerfFLAG == false) && (NumberOfTimes == 3)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(SecEncStrCurrentTimeTaken))) + " seconds.");
                }
                if (NumberOfTimes == 3) {
                    SecEncPerfFLAG = true;
                }
                //System.out.println("CycleTest:CyclicEncrypt:EncryptedMesg=" + EncryptedMesg);
                //System.out.println("CycleTest:CyclicEncrypt:DecryptedMesg=" + DecryptedMesg);
            }
        }
    }

    public static void ResetState() {
        SenderReceiverGUI.Sender.StrlenRotate1 = -1;
        SenderReceiverGUI.Sender.OffsetRotate1 = -1;
        SenderReceiverGUI.Sender.StrlenRotate2 = -1;
        SenderReceiverGUI.Sender.OffsetRotate2 = -1;

        SenderReceiverGUI.Receiver.StrlenRotate1 = -1;
        SenderReceiverGUI.Receiver.OffsetRotate1 = -1;
        SenderReceiverGUI.Receiver.StrlenRotate2 = -1;
        SenderReceiverGUI.Receiver.OffsetRotate2 = -1;

        EncryptedMesg = new StringBuilder("");
        MyKey = null;
        //variables.clear();
    }

    public static StringBuilder Layer0EncryptScamble(boolean SilentFlag) {
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        NewEncryptedMesg = ScramblerVarGap(MyMessage, SilentFlag);
        //System.out.println("Layer0EncryptScamble:NewEncryptedMesg="+NewEncryptedMesg);
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer1EncryptSimple(boolean SilentFlag) {
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        if (SilentFlag==false){
        System.out.println("Layer1EncryptSimple:User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP);
        System.out.println("Layer1EncryptSimple:User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel + " User_SecretTCPOTP=" + User_SecretTCPOTP);
        System.out.println("Layer1EncryptSimple:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
        }
        String[] Temp = new String[EncryptedMesg.length()];
        Temp = EncryptedMesg.toString().split("");
        EncryptedMesg = new StringBuilder("");
        HighLevel_Sender_Cycle();
        if (SilentFlag==false){
        System.out.println("Layer1EncryptSimple:User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP);
        System.out.println("Layer1EncryptSimple:User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel + " User_SecretTCPOTP=" + User_SecretTCPOTP);
        System.out.println("Layer1EncryptSimple:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
        }
        MyPublicEquation=EqnUnderTest;
        for (int i = 0; i < Temp.length;) {

            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase(""))) {
                if ((EncryptPerfFLAG1 == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    if (TimeTaken.length == 3) {
                        EncryptStr1FuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                    } else {
                        EncryptStr1FuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
                    }
                }
                //System.out.println("EncryptDetail:Layer1EncryptSimple:Temp[" + i + "]=" + Temp[i]);
                if ((i == 0)
                        || ((i > 0) && (EncryptedMesg.toString().endsWith(EncTerminatorString)))) {
                    ShannonSimEncrypt(Temp[i], SilentFlag);
                    i++;
                } else {
                    EncryptedMesg.append(EncTerminatorString);
                    i--;
                }
                if ((EncryptPerfFLAG1 == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                    } else {
                        localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
                    }
                    EncryptStr1FuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(EncryptStr1FuncTimeTaken)));
                    //System.out.println("EncryptDetail:Loop ShannonSimEncrypt:Length=" + EncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStr1FuncTimeTaken) * 1000) + " milliseconds");
                }
            }
        }
        System.out.println("EncryptDetail:Layer1EncryptSimple:m=" + variablesEncrypt.get("m"));
        System.out.println("EncryptDetail:Layer1EncryptSimple:N=" + variablesEncrypt.get("N"));
        EncryptStrFuncTimeTaken = "0.0";
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
            System.out.println("Encryption Cycle Time Taken:EncryptStrFuncTimeTaken=" + EncryptStrFuncTimeTaken + " Seconds.");
        }
        NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        String[] MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:ShannonSimEncrypt:Length=" + EncryptedMesg.length() + " Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        // Adding Sucessive Chars
        NewEncryptedMesg = DiffusionJunkSimEncrypt(NewEncryptedMesg, "Double", SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:Layer1EncryptSimple:After DiffusionJunkSimEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptDetail:Layer1EncryptSimple:After DiffusionJunkSimEncrypt:DecryptedMesg=" + DecryptedMesg);;
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
            System.out.println("Encryption Layer1 Time Taken:EncryptStrFuncTimeTaken=" + EncryptStrFuncTimeTaken + " Seconds.");
        }
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:DiffusionJunkSimEncrypt:Length=" + EncryptedMesg.length() + " Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer2EncryptRotate(StringBuilder Exprn, int Rand1Rotate, boolean SilentFlag) {
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        StringBuilder NewEncryptedMesg = Exprn;
        String[] MyCharDropped = NewEncryptedMesg.toString().split(EncTerminatorString);
        SenderReceiverGUI.Sender.StrlenRotate1 = MyCharDropped.length;
        SenderReceiverGUI.Sender.OffsetRotate1 = Rand1Rotate % SenderReceiverGUI.Sender.StrlenRotate1;
        int StrLen = MyCharDropped.length;
        int OffsetRotate = Rand1Rotate % StrLen;
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate, StrLen, SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("Layer2EncryptRotate:RotateStrEncrypt:Length=" + EncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }

        EncryptStrFuncTimeTaken = "0.0";
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        // Add Confusion && Diffusion
        NewEncryptedMesg = DiffusionJunkRotateEncrypt(NewEncryptedMesg, "Double", SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("Layer2EncryptRotate:DiffusionJunkRotateEncrypt:Length=" + EncryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Layer2EncryptRotate:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptDetail:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Layer2EncryptRotate:DecryptedMesg=" + DecryptedMesg);
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer3EncryptJumble(boolean SilentFlag) {
        //SilentFlag=false;
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        String[] MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        EncryptedMesg = new StringBuilder(JumbleStrEncrypt(EncryptedMesg.toString(), "Double", SilentFlag));
        if (SilentFlag == false) {
            System.out.println("Layer3EncryptJumble:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Reverse:EncryptedMesg=" + EncryptedMesg);
            System.out.println("Layer3EncryptJumble:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After Reverse:DecryptedMesg=" + DecryptedMesg);
        }
        NewEncryptedMesg = new StringBuilder(EncryptedMesg);
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
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("Layer3EncryptJumble:JumbleEncrypt:Length=" + EncryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }

        return NewEncryptedMesg;
    }

    public static StringBuilder Layer4EncryptWeiBull(Double WeiRand2, Double WeiCharRand3, boolean SilentFlag) {
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        String[] MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:Layer4EncryptWeiBull:Char Length:Length=" + MyCharDropped.length);
        }
        WeibullEncrypt(EncryptedMesg.toString(), WeiRand2, WeiCharRand3, SilentFlag);
        StringBuilder NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + ":After Layer4EncryptWeiBull:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + ":After Layer4EncryptWeiBull:DecryptedMesg=" + DecryptedMesg);
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
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:Layer4EncryptWeiBull:Length=" + EncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        NewEncryptedMesg = DiffusionJunkWeiBullEncrypt(NewEncryptedMesg, "Double", SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + ":After DiffusionJunkWeiBullEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + ":After DiffusionJunkWeiBullEncrypt:DecryptedMesg=" + DecryptedMesg);
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
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:DiffusionJunkWeiBullEncrypt:Length=" + EncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5EncryptWorkFactor(int Rand1Rotate, boolean SilentFlag) {
        EncryptStrFuncTimeTaken = "0.0";
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        String[] MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        StringBuilder NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = WorkFactorEncrypt(NewEncryptedMesg, Rand1Rotate, SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
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
        MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput == false) {
            System.out.println("EncryptDetail:WorkFactorEncrypt:Length=" + EncryptedMesg.length() + " :Char Length:Length=" + MyCharDropped.length + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        if (SilentFlag == false) {
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + ":After WorkFactorEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptDetail:NumberOfTimes=" + NumberOfTimes + ":After WorkFactorEncrypt:DecryptedMesg=" + DecryptedMesg);
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DOT3EncryptFractionate(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        EncryptedMesg = new StringBuilder(FractionEncryptN(NewEncryptedMesg.toString(), SilentFlag));
        if (SilentFlag == false) {
            System.out.println("WorkFactorEncrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After FractionatingEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorEncrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After FractionatingEncrypt:DecryptedMesg=" + DecryptedMesg);
        }
        NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        if (SuppressSystemOutput == false) {
            System.out.println("WorkFactorEncrypt:FractionEncryptN:Length=" + NewEncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DOT1EncryptRotate(StringBuilder Exprn, int Rand1Rotate, boolean SilentFlag) {
        StringBuilder NewEncryptedMesg = Exprn;
        EncryptedMesg = NewEncryptedMesg;
        String[] MyCharDropped = EncryptedMesg.toString().split(EncTerminatorString);
        SenderReceiverGUI.Sender.StrlenRotate2 = MyCharDropped.length;
        SenderReceiverGUI.Sender.OffsetRotate2 = Rand1Rotate % MyCharDropped.length;
        int StrLen = MyCharDropped.length;
        int OffsetRotate = Rand1Rotate % StrLen;
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate, StrLen, SilentFlag);
        EncryptedMesg = NewEncryptedMesg;
        if (SilentFlag == false) {
            System.out.println("WorkFactorEncrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After RotateStrEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorEncrypt:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After RotateStrEncrypt:DecryptedMesg=" + DecryptedMesg);
        }
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer5DOT2EncryptJumble(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        EncryptedMesg = NewEncryptedMesg;
        EncryptedMesg = new StringBuilder(JumbleStrEncrypt(EncryptedMesg.toString(), "Double", SilentFlag));
        if (SilentFlag == false) {
            System.out.println("WorkFactorEncrypt:MathsReverse:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After JumbleEncrypt:EncryptedMesg=" + EncryptedMesg);
            System.out.println("WorkFactorEncrypt:MathsReverse:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":After JumbleEncrypt:DecryptedMesg=" + DecryptedMesg);
        }
        NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        return NewEncryptedMesg;
    }

    public static StringBuilder Layer6EncryptQuantumLWE(StringBuilder NewEncryptedMesg, boolean SilentFlag) {
        SilentFlag = false;
        EncryptStrFuncTimeTaken = "0.0";
        EncryptedMesg = NewEncryptedMesg;

        // Ensure array dimensions map exactly to LWE parameter dimensions (1024)
        int[] MyLWEKey = new int[1024];
        for (int i = 0; i < MyLWEKey.length; i++) {
            // Expand, map, or loop the PrivateKey string characters safely to populate the matrix
            MyLWEKey[i] = (MyPrivateKey != null && MyPrivateKey.length() > 0)
                    ? (MyPrivateKey.charAt(i % MyPrivateKey.length()) % 3) - 1 : 0;
        }

        EncryptedMesg = new StringBuilder(QuantumResistantPipelineLWE.senderEncryptAndPackage(EncryptedMesg.toString(), MyLWEKey));
        return EncryptedMesg;
    }
}
