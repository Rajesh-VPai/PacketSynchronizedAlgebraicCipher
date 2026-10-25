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
package SenderReceiverGUI;

import Calculus.ConsoleColors;
import Equations.PSACEquationFactory;
import Equations.PSACEquationSuite;
import Equations.PSACOTPEquation;
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
import static Security.Calibration.CalibrationSender;
import Security.Decryption;
import static Security.Decryption.DecryptStrFuncTimeTaken;
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
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.Configuration.FOBRandomChar;
import static Security.Configuration.CyclicFlag;
import static Security.Configuration.GetPrimeNumber;
import static Security.Configuration.LastIndex;
import static Security.Configuration.NumberOfTimes;
import static Security.Configuration.NumberOfTimesOrg;
import static Security.PacketSynchronizedAlgebraicCipher.SetupAlice;
import static Security.PacketSynchronizedAlgebraicCipher.SetupBob;
import static Security.Configuration.UDPBuffLen;
import static Security.Configuration.USEUDP;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.MyMessage;
import static Security.Configuration.SecurityPosture;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.PacketSynchronizedAlgebraicCipher.MesgINCAPS;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.MyDecrptionEquation;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicKey;
import static Security.Security.MyPublicKeyHighLevel;
import static Security.Security.MySimpleWeiBull;
import static Security.Configuration.PRAGMA;
import static Security.Configuration.PRAGMADetail;
import static Security.SubstitutionBox.SuccessiveCharsIncrementSim;
import static Security.SubstitutionBox.SuccessiveCharsIncrementWeiBull;
import static Security.SubstitutionBox.SuccessiveCharsLenSim;
import static Security.SubstitutionBox.SuccessiveCharsLenWeiBull;
import static Security.Security.Xn_LCG;
import static Security.Security.variablesStr;
import static Security.SubstitutionBox.DiffusionJunkWeiBullDecrypt;
import static Security.SubstitutionBox.WeibullDecrypt;
import static Security.Configuration.NumberOfFractions;
import static Security.TranspositionPBox.SuccessiveCharsIncrementJumble;
import static Security.TranspositionPBox.SuccessiveCharsIncrementRotate;
import static Security.TranspositionPBox.SuccessiveCharsLenJumble;
import static Security.TranspositionPBox.SuccessiveCharsLenRotate;
import static SenderReceiverGUI.SenderGUI.SenderMesg;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static Security.SecurityTestHarness.ConfirmedFirstEvent;
import static Security.SecurityTestHarness.ConfirmedSecondEvent;
import static Security.SecurityTestHarness.OccasionNoOfTimesIndex;
import static Security.Configuration.MessageInvariant;
import static Security.Configuration.USE_AES;
import static Security.Decryption.LayersOfSecurityDecrypt;
import static Security.Decryption.PlainText;
import static Security.Decryption.TestDebug;
import static Security.PacketSynchronizedAlgebraicCipher.IntegrateRandomNumberPackageSetGBLVar;
import static Security.SecurityTestHarness.PostDecryptBlock;
import static Security.TCPDecryption.TCPDecryptStrData;
import static Security.TCPDecryption.TearDown;
import static Security.TCPDecryption.makeConnectionReceiv;
import static Security.Decryption.FEOTP;
import static Security.Decryption.FEOTP_1_;
import static Security.Decryption.FEOTP_2_;
import static Security.Decryption.FEOTP_3_;
import static Security.Decryption.FEReceiver;
import static Security.Decryption.FESender;
import static Security.Decryption.SEReceiver;
import static Security.Decryption.SESender;
import static Security.Decryption.SEOTP;
import static Security.Decryption.SEOTP_1_;
import static Security.Decryption.SEOTP_2_;
import static Security.Decryption.SEOTP_3_;
import static Security.Decryption.TCPCharTerminatorString;
import static Security.EquationPairGeneration.aSecret;
import static Security.EquationPairGeneration.bSecret;
import static Security.EquationPairGeneration.cSecret;
import static Security.EquationPairGeneration.dSecret;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.sSecret;
import static Security.EquationPairGeneration.aSecretValue;
import static Security.EquationPairGeneration.bSecretValue;
import static Security.EquationPairGeneration.cSecretValue;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.sSecretValue;
import static Security.EquationPairGeneration.rSecretValue;
import static Security.EquationPairGeneration.seenSeedsReceiver;
import static Security.EquationPairGeneration.zSecret;
import Security.ISNValidator;
import Security.MetaDataEncryptor;
import Security.OTPGeneratorClass;
import Security.PSACKeyVaultNew;
import static Security.PacketSynchronizedAlgebraicCipher.SafeEquationsFlag;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.PacketSynchronizedAlgebraicCipher.mySeed1DyDx;
import static Security.PacketSynchronizedAlgebraicCipher.mySeedKey;
import static Security.RFC6528ISNGenerator.bytesToLong;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.variablesDecrypt;
import Security.TCPECCKeyPairGeneration;
import static SenderReceiverGUI.ReceiverGUI.StrGUI;
import static SenderReceiverGUI.Sender.FRAME_SIZE;
import static SenderReceiverGUI.Sender.OTPLength;
import java.io.DataInputStream;
import java.io.EOFException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.apache.log4j.Logger;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

/**
 *
 * @author Rajesh V Pai
 */
//Program Taken from java2s.com/Tutorial/java
// Google string:Java UDP sender and receiver example
public class Receiver {

    public static Logger log = Logger.getLogger(Receiver.class.getName());
    public static ServerSocket server = null;
    public static String hostName = null;//"127.0.0.1";
    public static int port = 8003;
    public int portUDP = 8004;
    public static Socket socketReceiver;
    public static DataInputStream input = null;
    public static Scanner inputScannerCommReadStrCommon = null;
    public static String CommReadString = "";
    public static boolean CommStrFlag = false;
    //public static String ReadString="";
    public static char[] ResultStrCharArray = new char[100];
    //public static byte[] ResultStrCharArray = new byte[100];
    public static int ReadByteCount = 0;
    public static int ReadTCPPacketCount = 0;
    public char CommStart1 = 0;
    public char DatumLength = 0;
    public static boolean ReceiverTCPDecrypt = true;// true for StrongA,StrongB, Weak && false for None
    public static String ReceiverStrTCPDecrypt = "StrongA";// Values are :StrongA,StrongB, Weak, None
    public static String TCPDecryptedMesg = null;
    public static String LowLevelTCPDecryptedBytes = "";
    public static String TCPEqnUnderTestStrongA = "";
    public static String TCPEqnUnderTestStrongB = "";
    public static String TCPEqnUnderTestWeakBinomial = "";
    public static String TCPEqnUnderTestWeak = "";
    public static String TCPExprnDiffusion = "";
    public static String TCPExprnSurprise = "";
    public static String InverseTCPExprnSurprise = "";
    public static String InverseTCPExprnDiffusion = "";
    public static String InverseTCPEqnUnderTestStrongA = "";
    public static String InverseTCPEqnUnderTestStrongB = "";
    public static String InverseTCPEqnUnderTestWeakBinomial = "";
    public static String InverseTCPEqnUnderTestWeak = "";
    public static String TCPDiffWithRespToDiffusion = "";
    public static String InverseTCPDiffusionDiffWithRespTo = "";

    public static String EqnUnderTest = "";
    public static String InverseEqnUnderTest = "";
    public static long User_SecretHighOTP = -1;
    public static long User_SecretTCPOTP = -1;
    public static long User_SecretSeedHighLevel = 123456789L;
    public static long User_SecretSeedTCPLevel = 123456789L;
    // State of OTP for EqnUnderTest
    public static long InitialMsgDecryptState_HighOTP = 123456789L;
    public static long InitialMsgDecryptState_SecretSeed = 123456789L;

    public static int ReceiverChunkNumber = 100;
    public static int ActualChunksReceived = 0;
    public static String SenderEncryptReceived = "";
    public static boolean IsStringFlag = false;
    public static boolean IsStringFlagEncryptedMesg = false;
    //Decryption Variables :OTPs
    public static int Rand1Rotate = 0;
    public static Double WeiRand2 = 0.0;
    public static Double WeiCharRand3 = 0.0;
    public static int MessageSize = 0;

    // Rotation Variables
    public static int OffsetRotate1 = 0;
    public static int StrlenRotate1 = 0;
    public static int OffsetRotate2 = 0;
    public static int StrlenRotate2 = 0;

    public static boolean FirstTimeFlag = true;
    public static boolean FirstTimeFlagTCPOptimised = true;
    private static boolean MyExceptionFlag = false;
    public static boolean RecevTurnOffOccassionalism = true;
    private static boolean FirstTimeFlagSendMsgBuffOverflow = false;
    private static int FirstTimeSenderChunkNumber = 0;
    public static boolean FirstTimeFlagKeys = true;
    private static int MaxMessages = 41;
    public static int ReceiverHighLevelSelector = -1;
    public static int ReceiverHighLevelUnsupportedSelector = -1;

    public static StringBuilder ReceivePacket() {
        try {
            if ((USEUDP.equalsIgnoreCase("USETCP"))
                    && (StrGUI.equalsIgnoreCase("Console"))) {
                return ReceivePacketConsole();
            } else if ((USEUDP.equalsIgnoreCase("USETCP"))
                    && (StrGUI.equalsIgnoreCase("GUI"))) {
                return ReceivePacketConsole();

            }
        } catch (Exception MyException) {
            System.out.println("Exception:" + ReadTCPPacketCount + ":MyException=" + MyException);
            MyException.printStackTrace();
        }
        return new StringBuilder("");
    }

    public static StringBuilder ReceivePacketConsole() throws Exception {
        StringBuilder ResultStr = new StringBuilder("");
        boolean EncryptFlag = true;//ReceiverTCPEncryptLowLevel;
        if (FRAME_SIZE == 1) {
            ResultStr = ReceivePacketTCP1on1();
        } else {
            ResultStr = ReceivePacketTCP1on1Frame();//ReceivePacketTCP1on1();
        }
        StringBuilder MyMessage1 = ResultStr;
        if ((ReadTCPPacketCount < MaxMessages) && (EncryptFlag == false) && (ReceiverTCPDecrypt == false)) {
            MyMessage1 = TCPDecryptStrData(ResultStr);
        }// Low Level TCP Decryption
        else if ((EncryptFlag == true) && (ReceiverTCPDecrypt == false)) {
            if ((ReadTCPPacketCount < MaxMessages)) {
                //System.out.println("ReceivePacketConsole:Before TCPDecryptStrData:variables:");
                //variables.forEach((key,value)-> System.out.println(key + " " + value));
                MyMessage1 = TCPDecryptStrData(ResultStr);
                //System.out.println("ReceivePacketConsole:After TCPDecryptStrData:variables:");
                //variables.forEach((key,value)-> System.out.println(key + " " + value));
            }
        }// High Level TCP Decryption
        else if ((EncryptFlag == true) && (ReceiverTCPDecrypt == true)) {
            if ((ReadTCPPacketCount < MaxMessages)) {
                //System.out.println("ReceivePacketConsole:Before:variables:");
                //variables.forEach((key,value)-> System.out.println(key + " " + value));
                MyMessage1 = TCPDecryptStrData(ResultStr);
                //System.out.println("ReceivePacketConsole:After:variables:");
                //variables.forEach((key,value)-> System.out.println(key + " " + value));
            }
        } else {
            MyMessage1 = ResultStr;
        }
        //System.out.println("ReceivePacketConsole:Decrypted Message:MyMessage1=" + MyMessage1 + " ResultStr=" + ResultStr);
        return MyMessage1;
    }

    String ReceivePacketUDP() throws Exception {
        byte[] buffer = new byte[UDPBuffLen];
        String ResultStr = "";
        DatagramSocket socket = null;
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket = new DatagramSocket(this.port);
        System.out.println("Receiver:Just Before Receive Packet");
        //socket.receive(packet);
        System.out.println(packet.getSocketAddress());
        System.out.println("Receiver:Just After Receive Packet");
        socket.receive(packet);
        System.out.println(packet.getSocketAddress());
        buffer = packet.getData();
        socket.close();
        System.out.println("Receiver:Closed Socket");
        ResultStr = new String(buffer);
        if (ResultStr.contains(",#")) {
            ResultStr = ResultStr.replaceAll(",#", "");
        }
        System.out.println("Receiver:ResultStr=" + ResultStr);
        return ResultStr;
    }

    // Main Receiver function
    public static StringBuilder ReceivePacketTCP1on1() throws Exception {
        StringBuilder ResultStr = new StringBuilder("");
        boolean SilentFlag = true;
        boolean EncryptFlag = true;
        long baselineISN = -1;
        if (socketReceiver != null && socketReceiver.isBound() && socketReceiver.isConnected()) {
            DataInputStream in = new DataInputStream(socketReceiver.getInputStream());
            //ReceiveLWEmain();
            int tokenIndex = -1; // -1 = baseline, >=0 = messages
            ReadTCPPacketCount = -1;
            Set<Long> seenISNs = new HashSet<>(); // replay protection

            while (true) {
                if (((tokenIndex != -1) && (tokenIndex != 23) && (tokenIndex != 26))) {
                    String tokenRead1 = ReceiveMeta();
                    String[] DataTemp = tokenRead1.split(",\\|");
                    User_SecretTCPOTP = Long.parseLong(DataTemp[0]);
                    User_SecretSeedTCPLevel = Long.parseLong(DataTemp[1]);
                    if (SilentFlag == false) {
                        System.out.println("ReceivePacketTCP1on1:User_SecretTCPOTP=" + User_SecretTCPOTP + " tokenIndex=" + tokenIndex + ":User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
                    }
                    Receiver_MessageCycleT(SilentFlag);
                }
                int length = 0;
                try {
                    length = in.readInt();
                } catch (EOFException e) {
                    break; // no more data
                } catch (Exception e) {
                    break; // no more data
                }
                if (length == 0) {
                    return ResultStr;
                }
                byte[] data = new byte[length];
                in.readFully(data);
                String tokenRead = new String(data, "UTF-8");
                //System.out.println("ReceivePacketTCP1on1:Read tokenRead=" + tokenRead);

                String[] DataTemp = tokenRead.split(",\\|");

                if (tokenIndex == -1) {
                    // --- Baseline ISN packet ---
                    baselineISN = Long.parseLong(DataTemp[0].split(":")[1]);
                    int otp = Integer.parseInt(DataTemp[1].split(":")[1]);
                    String ts = DataTemp[2].split(":")[1];
                    long timer = Long.parseLong(DataTemp[3].split(":")[1]);
                    String macAddr = DataTemp[4].split(":")[1];
                    boolean baselineOk = ISNValidator.validateBaseline(
                            baselineISN, hostName, port, ts, timer, otp, SilentFlag);
                    if (!baselineOk) {
                        throw new SecurityException("Baseline ISN invalid – drop connection");
                    }
                    System.out.println("Baseline ISN validated successfully.");
                    tokenIndex = 0; // move to message mode
                    ReadTCPPacketCount = 0;
                } else if ((tokenIndex == 23) || (tokenIndex == 26) || (EncryptFlag == false)) {
                    // --- Message ISN packet ---
                    if (SilentFlag == false) {
                        for (int i = 0; i < DataTemp.length; i++) {
                            System.out.println("Message:DataTemp[" + i + "]=" + DataTemp[i]);
                        }
                    }
                    if (SilentFlag == false) {
                        System.out.println("ReceivePacketTCP1on1:tokenRead:" + tokenRead);
                    }
                    long messageISN = Long.parseLong(DataTemp[0].split(":")[1]);
                    long OTP = Long.parseLong(DataTemp[1].split(":")[1]);
                    String ts = DataTemp[2].split(":")[1];
                    long timer = Long.parseLong(DataTemp[3].split(":")[1]);
                    String macAddr = DataTemp[4].split(":")[1];
                    String payload = "";
                    if ((tokenIndex != 23) && (tokenIndex != 26)) {
                        payload = DataTemp[5].split(":")[1];
                    } else {
                        payload = DataTemp[5].split("PAYLOAD:")[1];
                    }
                    if (seenISNs.contains(messageISN)) {
                        throw new SecurityException("Replay detected – drop connection");
                    }
                    seenISNs.add(messageISN);

                    boolean messageOk = ISNValidator.validateMessage(
                            messageISN, hostName, port, OTP, ts, timer, SilentFlag);
                    if (!messageOk) {
                        throw new SecurityException("Message ISN invalid – possible replay/tamper");
                    }
                    if (SilentFlag == false) {
                        System.out.println("Message ISN validated successfully.");
                    }
                    ResultStr = SwitchAssignToVar(ResultStr, payload, tokenIndex, tokenIndex);
                    if ((tokenIndex != 23) && (tokenIndex != 26)) {
                        tokenIndex++;
                        ReadTCPPacketCount++;
                    } else if (((FirstTimeSenderChunkNumber > 0) || (FirstTimeSenderChunkNumber == 0)) && ((tokenIndex == 23) || (tokenIndex == 26))) {
                        tokenIndex++;
                        ReadTCPPacketCount++;
                    }
                    if (tokenIndex == MaxMessages) {
                        break;
                    }
                } else if (EncryptFlag == true) {
                    try {
                        // --- Generic ISN packet for all other tokenIndex values ---
                        DataTemp = decryptWholeMessage(tokenRead, SilentFlag).split(",\\|");

                        // Decrypt ISN parts + payload directly
                        long genericISN = Long.parseLong(DataTemp[0].split(":")[1]);
                        long OTP = Long.parseLong(DataTemp[1].split(":")[1]);
                        String ts = DataTemp[2].split(":")[1];
                        long timer = Long.parseLong(DataTemp[3].split(":")[1]);
                        String macAddr = DataTemp[4].split(":")[1];
                        String payload = DataTemp[5].split(":")[1];
                        if (SilentFlag == false) {
                            System.out.println("ReceivePacketTCP1on1:tokenIndex=" + tokenIndex + ":EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
                            System.out.println("ReceivePacketTCP1on1:tokenIndex=" + tokenIndex + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                            System.out.println("ReceivePacketTCP1on1:tokenIndex=" + tokenIndex + ":TCPEqnUnderTestStrongB=" + TCPEqnUnderTestStrongB + " InverseTCPEqnUnderTestStrongB=" + InverseTCPEqnUnderTestStrongB);
                            System.out.println("ReceivePacketTCP1on1:tokenIndex=" + tokenIndex + ":TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak + " InverseTCPEqnUnderTestWeak=" + InverseTCPEqnUnderTestWeak);
                            System.out.println("ReceivePacketTCP1on1:tokenIndex=" + tokenIndex + ":TCPEqnUnderTestWeakBinomial=" + TCPEqnUnderTestWeakBinomial + " InverseTCPEqnUnderTestWeakBinomial=" + InverseTCPEqnUnderTestWeakBinomial);
                        }
                        // Validate ISN
                        boolean genericOk = ISNValidator.validateMessage(genericISN, hostName, port, OTP, ts, timer, SilentFlag);
                        if (!genericOk) {
                            throw new SecurityException("Generic ISN invalid – possible replay/tamper");
                        }
                        if (SilentFlag == false) {
                            System.out.println("Generic ISN validated successfully.");
                        }

                        // Replay protection
                        if (seenISNs.contains(genericISN)) {
                            throw new SecurityException("Replay detected – drop connection");
                        }
                        seenISNs.add(genericISN);

                        // Assign payload
                        ResultStr = SwitchAssignToVar(ResultStr, payload, tokenIndex, tokenIndex);

                        tokenIndex++;
                        ReadTCPPacketCount++;
                        if (tokenIndex == MaxMessages) {
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(ConsoleColors.RED + "Receiver:Decryption System Wrong" + ConsoleColors.RESET);
                    }
                }
                ResultStr.append(" ");
            }
        }
        return ResultStr;
    }

    public static StringBuilder ReceivePacketTCP1on1Frame() throws Exception {
        StringBuilder ResultStr = new StringBuilder("");
        boolean SilentFlag = true;
        boolean EncryptFlag = true;
        long baselineISN = -1;
        if (socketReceiver != null && socketReceiver.isBound() && socketReceiver.isConnected()) {
            DataInputStream in = new DataInputStream(socketReceiver.getInputStream());
            //QuantumLWE.LWEReceiverMain.ReceiveLWEmain();
            int tokenIndex = -1;
            ReadTCPPacketCount = -1;
            Set<Long> seenISNs = new HashSet<>();

            while (true) {
                if ((tokenIndex != -1) && (tokenIndex != 39) && (tokenIndex != 40)) {
                    String tokenRead1 = ReceiveMeta();
                    String[] DataTemp = tokenRead1.split(",\\|");
                    User_SecretTCPOTP = Long.parseLong(DataTemp[0]);
                    User_SecretSeedTCPLevel = Long.parseLong(DataTemp[1]);
                    //if (SilentFlag == false) {
                    System.out.println("ReceivePacketTCP1on1:User_SecretTCPOTP=" + User_SecretTCPOTP + " tokenIndex=" + tokenIndex + ":User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
                    //}
                    Receiver_MessageCycleT(SilentFlag);
                }
                int length;
                try {
                    length = in.readInt();
                } catch (EOFException e) {
                    break;
                }
                if (length == 0) {
                    return ResultStr;
                }

                byte[] data = new byte[length];
                in.readFully(data);
                String tokenRead = new String(data, "UTF-8");
                String tokenRead1 = "";
                String[] DataTemp = null;

                if (tokenIndex == -1) {
                    DataTemp = tokenRead.split(",\\|");
                    // Baseline ISN
                    baselineISN = Long.parseLong(DataTemp[0].split(":")[1]);
                    int otp = Integer.parseInt(DataTemp[1].split(":")[1]);
                    String ts = DataTemp[2].split(":")[1];
                    long timer = Long.parseLong(DataTemp[3].split(":")[1]);
                    String macAddr = DataTemp[4].split(":")[1];
                    if (!Security.ISNValidator.validateBaseline(baselineISN, Sender.hostName, Sender.port, ts, timer, otp, SilentFlag)) {
                        throw new SecurityException("Baseline ISN invalid – drop connection");
                    }
                    System.out.println("Baseline ISN validated successfully.");
                    tokenIndex = 0;
                    ReadTCPPacketCount = 0;
                } else {
                    System.out.println("ReceivePacketTCP1on1Frame:else:tokenRead=" + tokenRead);
                    if ((tokenIndex <= 38) && (EncryptFlag == true) && (!tokenRead.contains("MESSAGE_ISN:")) && (tokenRead.contains(TCPCharTerminatorString))) {
                        System.out.println("ReceivePacketTCP1on1Frame:TCP Encryption ON:TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + " :InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                        tokenRead1 = decryptWholeMessage(tokenRead, SilentFlag);
                        System.out.println("ReceivePacketTCP1on1Frame:TCP Encryption ON:tokenRead1=" + tokenRead1);
                        tokenRead = "";
                    }
                    if ((tokenRead1.contains("MESSAGE_ISN:"))) {
                        DataTemp = tokenRead1.split(",\\|");
                    } else if (tokenRead.contains("MESSAGE_ISN:")) {
                        DataTemp = tokenRead.split(",\\|");
                    }

                    // Message ISN with bundled variables
                    long messageISN = Long.parseLong(DataTemp[0].split(":")[1]);
                    if (seenISNs.contains(messageISN)) {
                        throw new SecurityException("Replay detected – drop connection");
                    }
                    seenISNs.add(messageISN);

                    long OTP = Long.parseLong(DataTemp[1].split(":")[1]);
                    String ts = DataTemp[2].split(":")[1];
                    long timer = Long.parseLong(DataTemp[3].split(":")[1]);
                    String macAddress = DataTemp[4].split(":")[1];
                    if (!Security.ISNValidator.validateMessage(messageISN, Sender.hostName, Sender.port, OTP, ts, timer, SilentFlag)) {
                        throw new SecurityException("Message ISN invalid – possible replay/tamper");
                    }
                    boolean LoopFlag = false;
                    // Extract bundled variables
                    for (int i = 5; (i < DataTemp.length) && ((tokenIndex != 39) && (tokenIndex != 40)); i++) {
                        String[] parts = DataTemp[i].split("_:");
                        String payload = "";
                        payload = parts.length > 1 ? parts[1] : parts[0];
                        ResultStr = SwitchAssignToVar(ResultStr, payload, tokenIndex, tokenIndex);
                        tokenIndex++;
                        ReadTCPPacketCount++;
                        LoopFlag = true;
                    }
                    if ((LoopFlag == false) && ((tokenIndex == 39) || (tokenIndex == 40))) {
                        String payload = tokenRead;
                        if ((payload.contains("PAYLOAD:")) && (tokenIndex == 39) && (LoopFlag == false) && (payload.split("PAYLOAD:").length > 1)) {
                            payload = payload.split("PAYLOAD:")[1];
                        } else if ((payload.contains("PAYLOAD:")) && (tokenIndex == 40) && (LoopFlag == false) && (payload.split("PAYLOAD:").length > 1)) {
                            payload = payload.split("PAYLOAD:")[1];
                        }
                        if ((!payload.equalsIgnoreCase("")) && (!payload.contains("MESSAGE_ISN:"))) {
                            ResultStr = SwitchAssignToVar(ResultStr, payload, tokenIndex, tokenIndex);
                            tokenIndex++;
                            ReadTCPPacketCount++;
                        } else {
                            System.out.println("ReceivePacketTCP1on1Frame:IGNORED 40th Message");
                            tokenIndex++;
                            ReadTCPPacketCount++;
                        }
                    }
                    tokenRead1 = "";
                    tokenRead = "";
                    if (tokenIndex == MaxMessages) {
                        break;
                    }
                }
                ResultStr.append(" ");
            }
        }
        return ResultStr;
    }

// Helper: decrypt a field that is encoded as doubles
    public static String decryptWholeMessage(String encrypted, boolean SilentFlag) {
        StringBuilder sb = new StringBuilder();
        try {
            // Split into encoded tokens (your delimiter is ",:")
            String[] tokens = encrypted.split(",:");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    StringBuilder Temp1 = new StringBuilder(token);
                    StringBuilder Temp = TCPDecryptStrData(Temp1);
                    sb.append(Temp); // map encoded token → character
                }
            }
            if (SilentFlag == false) {
                System.out.println("decryptWholeMessage:" + sb.toString());
                //if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA")){
                System.out.println("decryptWholeMessage:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + ":InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                //}else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB")){
                System.out.println("decryptWholeMessage:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongB=" + TCPEqnUnderTestStrongB + ":InverseTCPEqnUnderTestStrongB=" + InverseTCPEqnUnderTestStrongB);
                //}else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("Weak")){
                System.out.println("decryptWholeMessage:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak + ":InverseTCPEqnUnderTestWeak=" + InverseTCPEqnUnderTestWeak);
                //}else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("None")){
                System.out.println("decryptWholeMessage:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + ":InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                //}
                System.out.println("decryptWholeMessage:ReadTCPPacketCount=" + ReadTCPPacketCount + ":User_SecretTCPOTP=" + User_SecretTCPOTP + ":User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
                System.out.println("decryptWholeMessage:ReadTCPPacketCount=" + ReadTCPPacketCount + ":User_SecretHighOTP=" + User_SecretHighOTP + ":User_SecretSeedHighLevel=" + User_SecretSeedHighLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static StringBuilder SwitchAssignToVar(StringBuilder ResultStr, String token, int tokenIndex, int i) {
        boolean SilentFlag = false;
        try {
            switch (tokenIndex) {
                case 0:
                    Rand1Rotate = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " Rand1Rotate=" + Rand1Rotate + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " Rand1Rotate=" + Rand1Rotate + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 1:
                    OffsetRotate1 = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " OffsetRotate1=" + OffsetRotate1 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " OffsetRotate1=" + OffsetRotate1 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 2:
                    StrlenRotate1 = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " StrlenRotate1=" + StrlenRotate1 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " StrlenRotate1=" + StrlenRotate1 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 3:
                    OffsetRotate2 = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " OffsetRotate2=" + OffsetRotate2 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " OffsetRotate2=" + OffsetRotate2 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 4:
                    StrlenRotate2 = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " StrlenRotate2=" + StrlenRotate2 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " StrlenRotate2=" + StrlenRotate2 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 5:
                    WeiRand2 = Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " WeiRand2=" + WeiRand2 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " WeiRand2=" + WeiRand2 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 6:
                    WeiCharRand3 = Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " WeiCharRand3=" + WeiCharRand3 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " WeiCharRand3=" + WeiCharRand3 + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 7:
                    UDPBuffLen = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " UDPBuffLen=" + UDPBuffLen + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " UDPBuffLen=" + UDPBuffLen + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 8:
                    MessageSize = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " MessageSize=" + MessageSize + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " MessageSize=" + MessageSize + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 9:
                    CyclicFlag = Boolean.parseBoolean(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " CyclicFlag=" + CyclicFlag + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " CyclicFlag=" + CyclicFlag + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 10:
                    NumberOfTimes = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " NumberOfTimes=" + NumberOfTimes + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " NumberOfTimes=" + NumberOfTimes + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 11:
                    SuccessiveCharsLenSim = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsLenSim=" + SuccessiveCharsLenSim + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsLenSim=" + SuccessiveCharsLenSim + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 12:
                    SuccessiveCharsIncrementSim = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsIncrementSim=" + SuccessiveCharsIncrementSim + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsIncrementSim=" + SuccessiveCharsIncrementSim + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 13:
                    SuccessiveCharsLenWeiBull = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsLenWeiBull=" + SuccessiveCharsLenWeiBull + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsLenWeiBull=" + SuccessiveCharsLenWeiBull + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 14:
                    SuccessiveCharsIncrementWeiBull = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsIncrementWeiBull=" + SuccessiveCharsIncrementWeiBull + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsIncrementWeiBull=" + SuccessiveCharsIncrementWeiBull + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 15:
                    SuccessiveCharsLenRotate = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsLenRotate=" + SuccessiveCharsLenRotate + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsLenRotate=" + SuccessiveCharsLenRotate + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 16:
                    SuccessiveCharsIncrementRotate = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsIncrementRotate=" + SuccessiveCharsIncrementRotate + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsIncrementRotate=" + SuccessiveCharsIncrementRotate + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 17:
                    SuccessiveCharsLenJumble = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsLenJumble=" + SuccessiveCharsLenJumble + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsLenJumble=" + SuccessiveCharsLenJumble + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 18:
                    SuccessiveCharsIncrementJumble = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SuccessiveCharsIncrementJumble=" + SuccessiveCharsIncrementJumble + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SuccessiveCharsIncrementJumble=" + SuccessiveCharsIncrementJumble + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 19:
                    EavesdroppingFlag = Boolean.parseBoolean(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " EavesdroppingFlag=" + EavesdroppingFlag + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " EavesdroppingFlag=" + EavesdroppingFlag + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 20:
                    OccasionNoOfTimesIndex = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 21:
                    ConfirmedFirstEvent[0] = Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " ConfirmedFirstEvent[0]=" + ConfirmedFirstEvent[0] + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " ConfirmedFirstEvent[0]=" + ConfirmedFirstEvent[0] + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 22:
                    ConfirmedSecondEvent[0] = Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " ConfirmedSecondEvent[0]=" + ConfirmedSecondEvent[0] + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " ConfirmedSecondEvent[0]=" + ConfirmedSecondEvent[0] + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;

                case 23://SenderEncryptReceived
                    SenderEncryptReceived = token;
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SenderEncryptReceived=" + SenderEncryptReceived + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SenderEncryptReceived=" + SenderEncryptReceived + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 24:
                    ActualChunksReceived = (int) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " ActualChunksReceived=" + ActualChunksReceived + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " ActualChunksReceived=" + ActualChunksReceived + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 25:
                    FESender = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " FESender=" + FESender + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " FESender=" + FESender + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 26:
                    FEReceiver = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " FEReceiver=" + FEReceiver + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " FEReceiver=" + FEReceiver + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 27:
                    FEOTP = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " FEOTP=" + FEOTP + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " FEOTP=" + FEOTP + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 28:
                    FEOTP_1_ = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " FEOTP_1_=" + FEOTP_1_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " FEOTP_1_=" + FEOTP_1_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 29:
                    FEOTP_3_ = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " FEOTP_3_=" + FEOTP_3_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " FEOTP_3_=" + FEOTP_3_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 30:
                    FEOTP_2_ = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " FEOTP_2_=" + FEOTP_2_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " FEOTP_2_=" + FEOTP_2_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 31:
                    SESender = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SESender=" + SESender + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SESender=" + SESender + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 32:
                    SEReceiver = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SEReceiver=" + SEReceiver + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SEReceiver=" + SEReceiver + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 33:
                    SEOTP = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SEOTP=" + SEOTP + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SEOTP=" + SEOTP + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 34:
                    SEOTP_1_ = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SEOTP_1_=" + SEOTP_1_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SEOTP_1_=" + SEOTP_1_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 35:
                    SEOTP_3_ = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SEOTP_3_=" + SEOTP_3_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SEOTP_3_=" + SEOTP_3_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 36:
                    SEOTP_2_ = (double) Double.parseDouble(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " SEOTP_2_=" + SEOTP_2_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " SEOTP_2_=" + SEOTP_2_ + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 37:
                    InitialMsgDecryptState_HighOTP = (long) Long.parseLong(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " InitialMsgDecryptState_HighOTP=" + InitialMsgDecryptState_HighOTP + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " InitialMsgDecryptState_HighOTP=" + InitialMsgDecryptState_HighOTP + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 38:
                    InitialMsgDecryptState_SecretSeed = (long) Long.parseLong(token);
                    if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " InitialMsgDecryptState_SecretSeed=" + InitialMsgDecryptState_SecretSeed + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else if (SilentFlag == false) {
                        System.out.println("Receiver:" + tokenIndex + " InitialMsgDecryptState_SecretSeed=" + InitialMsgDecryptState_SecretSeed + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    User_SecretHighOTP = InitialMsgDecryptState_HighOTP;
                    User_SecretSeedHighLevel = InitialMsgDecryptState_SecretSeed;
                    //HighLevel_Receiver_Cycle();
                    if (StrGUI.equalsIgnoreCase("Console")) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " EqnUnderTest=" + EqnUnderTest + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else {
                        System.out.println("Receiver:" + tokenIndex + " EqnUnderTest=" + EqnUnderTest + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    if (StrGUI.equalsIgnoreCase("Console")) {
                        System.out.println(ConsoleColors.GREEN + "Receiver:" + tokenIndex + " InverseEqnUnderTest=" + InverseEqnUnderTest + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                    } else {
                        System.out.println("Receiver:" + tokenIndex + " InverseEqnUnderTest=" + InverseEqnUnderTest + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                    }
                    break;
                case 39:
                    //MyPublicKeyHighLevel = token;
                    try {
                        String EncryptedMesg1 = token;

                        if ((FirstTimeSenderChunkNumber == 0)) {
                            // First Time when SenderMesg==null OR ""
                            MyPublicKeyHighLevel = (new StringBuilder(EncryptedMesg1.trim()).toString());
                        } else if ((FirstTimeSenderChunkNumber > 0) && (MyPublicKeyHighLevel.length() == myPubKy) && (MyPublicKeyHighLevel != null) && (!MyPublicKeyHighLevel.toString().equalsIgnoreCase(""))) // Other than First Time when SenderMesg==null OR ""
                        {
                            MyPublicKeyHighLevel += EncryptedMesg1.trim();
                        }
                        System.out.println("Receiver:RAW1:tokenIndex=" + tokenIndex + ": MyPublicKeyHighLevel=" + MyPublicKeyHighLevel);
                        if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                            System.out.println(ConsoleColors.GREEN + "Receiver:tokenIndex=" + tokenIndex + ": Received MyPublicKeyHighLevel correctly.len=" + MyPublicKeyHighLevel.length() + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                        } else if (SilentFlag == false) {
                            System.out.println("Receiver:tokenIndex=" + tokenIndex + ": Received MyPublicKeyHighLevel correctly.len=" + MyPublicKeyHighLevel.length() + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                        }
                        break;
                    } catch (Exception MyException) {
                        CommReadString = "";
                        MyExceptionFlag = true;
                        System.out.println("Exception:EncryptedMesg:" + tokenIndex + ":MyException=" + MyException);
                        MyException.printStackTrace();
                    }
                    break;
                case 40:
                    try {
                        String EncryptedMesg1 = token;
                        if ((FirstTimeSenderChunkNumber == 0)) {
                            // First Time when SenderMesg==null OR ""
                            SenderMesg = (new StringBuilder(EncryptedMesg1));
                            DecryptedMesg = (new StringBuilder(EncryptedMesg1));
                        } else if (FirstTimeSenderChunkNumber > 0) // Other than First Time when SenderMesg==null OR ""
                        {
                            SenderMesg.append(EncryptedMesg1);
                            DecryptedMesg.append(EncryptedMesg1);
                        }
                        System.out.println("Receiver:RAW1:tokenIndex=" + tokenIndex + ": SenderMesg=" + SenderMesg);
                        System.out.println("Receiver:RAW1:tokenIndex=" + tokenIndex + ": DecryptedMesg=" + DecryptedMesg);
                        if ((StrGUI.equalsIgnoreCase("Console")) && (SilentFlag == false)) {
                            System.out.println(ConsoleColors.GREEN + "Receiver:tokenIndex=" + tokenIndex + ": Received SenderMesg correctly.len=" + SenderMesg.length() + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA + ConsoleColors.RESET);
                        } else if (SilentFlag == false) {
                            System.out.println("Receiver:tokenIndex=" + tokenIndex + ": Received SenderMesg correctly.len=" + SenderMesg.length() + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                        }
                        break;
                    } catch (Exception MyException) {
                        CommReadString = "";
                        MyExceptionFlag = true;
                        System.out.println("Exception:EncryptedMesg:" + ReadTCPPacketCount + ":MyException=" + MyException);
                        MyException.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Extra token ignored: " + token + " tokenIndex=" + tokenIndex);
            }
            ResultStr.append(token).append(" ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format at index " + tokenIndex + ":token=" + token + " i=" + i);
            MyExceptionFlag = true;
            e.printStackTrace();
        }
        return ResultStr;
    }

    public static void ReceiverAES() {
        try {
            DataInputStream in = new DataInputStream(socketReceiver.getInputStream());
            // Read encrypted AES key from socket
            int len = in.readInt();
            byte[] encryptedKey = new byte[len];
            in.readFully(encryptedKey);

            // Decrypt with receiver's private RSA key
            Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS5Padding");
            rsaCipher.init(Cipher.DECRYPT_MODE, MetaDataEncryptor.aesKey);
            byte[] aesKeyBytes = rsaCipher.doFinal(encryptedKey);

            // Reconstruct AES key
            SecretKey aesKey = new SecretKeySpec(aesKeyBytes, "AES");

            System.out.println("AES key received successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String ReceiveMeta() throws Exception {
        DataInputStream in = new DataInputStream(socketReceiver.getInputStream());
        //ReceiverAES();
        //SecretKey aesKey=MetaDataEncryptor.aesKey;
        String ResultStr = "";
        int length = 0;
        try {
            length = in.readInt();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (length == 0) {
            return ResultStr;
        }
        byte[] data = new byte[length];
        in.readFully(data);
        String tokenRead = new String(data, "UTF-8");
        return tokenRead;
    }

    public static void receiveMeta() throws Exception {
        DataInputStream in = new DataInputStream(socketReceiver.getInputStream());
        SecretKey aesKey = MetaDataEncryptor.aesKey;

        // --- Step 1: Meta-data packet 1 ---
        int nonceLen = in.readInt();
        byte[] nonce = new byte[nonceLen];
        in.readFully(nonce);

        int ctLen = in.readInt();
        byte[] ctMeta = new byte[ctLen];
        in.readFully(ctMeta);
        for (int i = 0; i < ctLen; i++) {
            User_SecretTCPOTP = bytesToLong(ctMeta);
        }
        // --- Step 2: Meta-data packet 2 ---
        int nonceLen1 = in.readInt();
        byte[] nonce1 = new byte[nonceLen1];
        in.readFully(nonce1);

        int ctLen1 = in.readInt();
        byte[] ctMeta1 = new byte[ctLen1];
        in.readFully(ctMeta1);
        User_SecretSeedTCPLevel = bytesToLong(ctMeta1);

//        String tokenRead = new String(ctMeta, "UTF-8");
//        String[] DataTemp = tokenRead.split(",\\|");
//        
//        int otp = Integer.parseInt(DataTemp[1].split(":")[1]);
//        String ts = DataTemp[2].split(":")[1];
//        long timer = Long.parseLong(DataTemp[3].split(":")[1]);
//        String macAddr = DataTemp[4].split(":")[1];
//    String isnEquation = RFC6528ISNGenerator.messageEquation(
//        "127.0.0.1", port, hostName, port, ts, timer, otp, macAddr);
//
//    byte[] ptMeta = RFC6528ISNGenerator.decryptWithISN(aesKey, nonce, ctMeta, isnEquation);
//    String metaData = new String(ptMeta, "UTF-8");
//    long isnOTP=OTPGeneratorClass.GenerateOTP(OTPLength);
//    // Validate ISNs
//    boolean ok = ISNValidator.validateISN(baselineISNReceived, messageISNReceived,hostName, port, ts, timer,(int)isnOTP,otp,false);
//    if (!ok) throw new SecurityException("MITM detected: ISN mismatch");
//
//    // Replay protection
//    if (!SeenISN.checkAndAdd(messageISNReceived)) {
//        throw new SecurityException("Replay attack detected: ISN already seen");
//    }
//    Receiver_MessageCycleT();
//    // --- Step 2: ISN+payload packet ---
//    int payloadLen = in.readInt();
//    byte[] payloadBytes = new byte[payloadLen];
//    in.readFully(payloadBytes);
//    String tokenRead = new String(payloadBytes, "UTF-8");
//    StringBuilder decryptedPayload = TCPDecryption.TCPDecryptStrData(new StringBuilder(tokenRead));
        //return decryptedPayload.toString();
    }

    public static void ResetData() {
        ReadTCPPacketCount = 0;
        Rand1Rotate = 0;
        OffsetRotate1 = 0;
        StrlenRotate1 = 0;
        OffsetRotate2 = 0;
        StrlenRotate2 = 0;
        UDPBuffLen = 8192;
        MessageSize = 0;
        WeiRand2 = 0.0;
        WeiCharRand3 = 0.0;
        MyPublicKey = "";
        CyclicFlag = false;
        NumberOfTimes = 0;//1;
        // System Variables SET TO SYSTEM DEFAULTS BEGINS
        SuccessiveCharsLenSim = 2;
        SuccessiveCharsIncrementSim = 1;
        SuccessiveCharsLenWeiBull = 2;
        SuccessiveCharsIncrementWeiBull = 1;
        SuccessiveCharsLenRotate = 2;
        SuccessiveCharsIncrementRotate = 1;
        SuccessiveCharsLenJumble = 2;
        SuccessiveCharsIncrementJumble = 1;
        EavesdroppingFlag = false;
        // System Variables SET TO SYSTEM DEFAULTS ENDS
        OccasionNoOfTimesIndex = 0;
        for (int i = 0; i < NumberOfTimes; i++) {
            ConfirmedFirstEvent[i] = 0.0;
            ConfirmedSecondEvent[i] = 0.0;
        }
        CommStrFlag = false;
        CommReadString = "";
        MyPublicKeyHighLevel = "";
        if ((SenderMesg == null)) {
            SenderMesg = new StringBuilder("");
        }
        //FOBRandomChar = "FOBStandardChar";
    }

    public static void pmain(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        DatagramSocket socket = new DatagramSocket(5002);
        System.out.println("Receiver:Just Before Receive Packet");
        socket.receive(packet);
        System.out.println("Receiver:Just After Receive Packet");
        System.out.println(packet.getSocketAddress());
        buffer = packet.getData();
        System.out.println(new String(buffer));
        socket.close();
        System.out.println("Receiver:Closed Socket");
        TearDown();
    }

    public static void main(String[] args) throws Exception {
        StrGUI = "Console";
        if (USE_AES == false) {
            System.out.println(ConsoleColors.GREEN + "Receiver:USER HAS FULL CONTROL OVER SOURCE CODE AND FULL RESPONSIBILITY FOR SECURITY." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE + "Receiver:USER IS USING MODERN METHODS FOR SECURITY." + ConsoleColors.RESET);
        }

        if (ReceiverTCPDecrypt == false) {
            System.out.println(ConsoleColors.RED + "Receiver:WARNING:TCP Encryption is OFF." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Receiver:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        if (PlainText == true) {
            System.out.println(ConsoleColors.RED + "Receiver:WARNING:PlainText is ON.TestDebug=" + TestDebug + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "Receiver:WARNING:TCP Encryprtion is Probably ON.TestDebug=" + TestDebug + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Receiver:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        if (SafeEquationsFlag == true) {
            System.out.println(ConsoleColors.GREEN + "Receiver:Safe Equations is ON. All Equations will NOT be used. Output Guarantee True OUTPUT" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Receiver:Safe Equations is OFF. All Equations will be used. Output Variations does NOT Guarantee True OUTPUT" + ConsoleColors.RESET);
        }
        mainHeader();
        variablesDecrypt.clear();
        if (DecryptedMesg == null) {
            DecryptedMesg = new StringBuilder("");
        }
        while ((!DecryptedMesg.toString().equalsIgnoreCase("Bye"))
                && (!DecryptedMesg.toString().equalsIgnoreCase("quit"))
                && (!DecryptedMesg.toString().equalsIgnoreCase("exit"))) {
            DecryptedMesg = new StringBuilder("");
            if ((FirstTimeFlagKeys == false) && (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse")) 
                    && (((TestDebug.equalsIgnoreCase("Production")) && (PlainText == false)))) {
                SetupAlice("Decrypt");
                SetupBob("Decrypt");
                //SetupEve();
                FirstTimeFlagKeys = false;
            }
            makeConnectionReceiv();
            ReceivePacketTCP1on1Frame();
            PrintReadValues();
            System.out.print("SenderMesg=" + SenderMesg);
            String Temp = ReceiveAMessage();
            System.out.println("Mesg=" + Temp);
            TestExecResultsMessage();
            System.out.print("Mesg=" + DecryptedMesg);
            System.out.print(System.lineSeparator());
            System.out.println("/************************** Decryption Ends *************** */");

            /**
             * ************************ Decryption Ends ***************
             */
            //TestStageStubReceiver(true);
            //ReceiveAMessage();
            //TestStageStubReceiver(true);
            ResetData();
            FirstTimeFlagKeys = false;
            UserStrings_Receiver_Entropy();
            if (Temp.contains("Exit:bye:")) {
                break;
            }
        }
        TearDown();
    }

    public static void Parameters() {
        System.out.println("Parameters:Mode:StrGUI=" + StrGUI);
        System.out.println("Parameters:CyclicFlag:=" + CyclicFlag);
        System.out.println("Parameters:NumberOfTimes:=" + NumberOfTimes);
        System.out.println("Parameters:NumberOfTimesOrg:=" + NumberOfTimesOrg);
        System.out.println("Parameters:USEUDP:=" + USEUDP);
        System.out.println("Parameters:UDPBuffLen:=" + UDPBuffLen);
        System.out.println("Parameters:MessageInvariant:=" + MessageInvariant);
        System.out.println("Parameters:ReceiverTCPDecrypt:=" + ReceiverTCPDecrypt);
        System.out.println("Parameters:ReceiverStrTCPDecrypt:=" + ReceiverStrTCPDecrypt);
        //System.out.println("Parameters:ReceiverTCPEncryptLowLevel:=" + ReceiverTCPEncryptLowLevel);
        System.out.println("Parameters:FOBRandomChar:=" + FOBRandomChar);
        System.out.println("Parameters:RANDProdPerform:=" + RANDProdPerform);
        System.out.println("Parameters:SecurityPosture:=" + SecurityPosture);
        System.out.println("Parameters:NumberOfFractions:=" + NumberOfFractions);
        System.out.println("Parameters:PRAGMA:=" + PRAGMA);
        System.out.println("Parameters:PRAGMADetail:=" + PRAGMADetail);
        System.out.println("Parameters:TestDebug:=" + TestDebug);
        System.out.println("Parameters:PlainText:=" + PlainText);
        System.out.println("Parameters:LayersOfSecurityDecrypt:=" + LayersOfSecurityDecrypt);
    }

    public static String PrintReadValues() {

        //if (SilentFlag == false) {
        System.out.println("****************** Read Values Begin***************");
        System.out.println("Receiver:1:Rand1Rotate=" + Rand1Rotate);
        System.out.println("Receiver:2:OffsetRotate1=" + OffsetRotate1);
        System.out.println("Receiver:3:StrlenRotate1=" + StrlenRotate1);
        System.out.println("Receiver:4:OffsetRotate2=" + OffsetRotate2);
        System.out.println("Receiver:5:StrlenRotate2=" + StrlenRotate2);
        System.out.println("Receiver:6:UDPBuffLen=" + UDPBuffLen);
        System.out.println("Receiver:7:MessageSize=" + MessageSize);
        System.out.println("Receiver:8:WeiRand2=" + WeiRand2);
        System.out.println("Receiver:9:WeiCharRand3=" + WeiCharRand3);
        System.out.println("Receiver:10:MyPublicKeyHighLevel=" + MyPublicKeyHighLevel);
        System.out.println("Receiver:12:CyclicFlag=" + CyclicFlag);
        System.out.println("Receiver:13:NumberOfTimes=" + NumberOfTimes);
        System.out.println("Receiver:14:SuccessiveCharsLenSim=" + SuccessiveCharsLenSim);
        System.out.println("Receiver:15:SuccessiveCharsIncrementSim=" + SuccessiveCharsIncrementSim);
        System.out.println("Receiver:16:SuccessiveCharsLenWeiBull=" + SuccessiveCharsLenWeiBull);
        System.out.println("Receiver:17:SuccessiveCharsIncrementWeiBull=" + SuccessiveCharsIncrementWeiBull);
        System.out.println("Receiver:18:SuccessiveCharsLenRotate=" + SuccessiveCharsLenRotate);
        System.out.println("Receiver:19:SuccessiveCharsIncrementRotate=" + SuccessiveCharsIncrementRotate);
        System.out.println("Receiver:20:SuccessiveCharsLenJumble=" + SuccessiveCharsLenJumble);
        System.out.println("Receiver:21:SuccessiveCharsIncrementJumble=" + SuccessiveCharsIncrementJumble);
        System.out.println("Receiver:22:EavesdroppingFlag=" + EavesdroppingFlag);
        System.out.println("Receiver:23:OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex);
        System.out.println("Receiver:24:CalibrationSender=" + CalibrationSender);
        System.out.println("Receiver:25:MesgINCAPS=" + MesgINCAPS);
        for (int i = 0; (i < NumberOfTimes) && (i < ConfirmedFirstEvent.length) && (i < ConfirmedSecondEvent.length); i++) {
            System.out.println("Receiver:26:ConfirmedFirstEvent=" + ConfirmedFirstEvent[i]);
            System.out.println("Receiver:27:ConfirmedSecondEvent=" + ConfirmedSecondEvent[i]);
        }
        System.out.println("Receiver:27:SenderEncryptReceived=" + SenderEncryptReceived);
        System.out.println("Receiver:28:ActualChunksReceived=" + ActualChunksReceived);
        System.out.println("****************** Read Values End***************");
        //}
        return "Finished:PrintReadValues";
    }

    public static String ReceiveAMessage() {
        System.out.println("ReceiveAMessage:Function=" + "ReceiveAMessage");

        boolean SilentFlag = true;
        System.out.println("/************************** Decryption Begins *************** */");
        /**
         * ************************ Decryption Begins ***************
         */
        if ((MyPublicKeyHighLevel == null) || (MyPublicKeyHighLevel.equalsIgnoreCase(""))) {
            System.out.println("ReceiveAMessage:FATAL ERROR:MyPublicKeyHighLevel=null");
        }
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        //MyDecrptionEquation = InverseEqnUnderTest;
        if ((MyPublicKeyHighLevel == null) || (MyPublicKeyHighLevel.isEmpty()) || (MyPublicKeyHighLevel.equalsIgnoreCase(""))) {
            return "Exit:bye:ReceiveAMessage:Empty String";
        }
        MyPublicKey = MyPublicKeyHighLevel;
        if ((MyPublicKey == null) || (MyPublicKey.equalsIgnoreCase(""))) {
            System.out.println("ReceiveAMessage:FATAL ERROR:MyPublicKey=null");
        }
        if ((MyPrivateKey == null) || (MyPrivateKey.equalsIgnoreCase(""))) {
            System.out.println("ReceiveAMessage:FATAL ERROR:MyPrivateKey=null");
        }

        if (SilentFlag == false) {
            System.out.println("Receiver:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WorkInProgress1Decrypt:SenderMesg=" + SenderMesg);
            System.out.println("Receiver:Decryption:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":Before WorkInProgress1Decrypt:DecryptedMesg=" + DecryptedMesg);
        }
        Decryption MyDecrypt = new Decryption(BobKeyPair.getPrivateKey("Decrypt"));
        //CyclicDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, MyPrivateKey, SilentFlag);
        String TempDecrypt = MyDecrypt.DecryptMessageDetail(SilentFlag, SenderReceiverGUI.Receiver.OffsetRotate1, SenderReceiverGUI.Receiver.OffsetRotate2, WeiRand2, WeiCharRand3, ConfirmedFirstEvent[OccasionNoOfTimesIndex], ConfirmedSecondEvent[OccasionNoOfTimesIndex], BobKeyPair.getPrivateKey("Decrypt"), false/*EavesTestCasesRunning*/, EavesdroppingFlag);
        MyMessage = DecryptedMesg.toString();
        Parameters();
        //MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        return DecryptedMesg.toString();
    }

    public static void mainHeader() {
        IntegrateRandomNumberPackageSetGBLVar();
        System.out.println("Receiver:myPrivKy=" + myPrivKy + " myPubKy=" + myPubKy);
        System.out.println("Receiver:StrGUI=" + StrGUI);
        UserTweaks_Entropy();
        System.out.println("**************** Parameters Begin***************");
        Parameters();
        System.out.println("****************** Parameters End***************");
        String AlgoName = "Decrypt";
        SetupAlice(AlgoName);
        SetupBob(AlgoName);
        
        //SetupEve();
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey(AlgoName) + " Length=" + AliceKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey(AlgoName) + " Length=" + AliceKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
        System.out.println("Alice:ECCPrivateKey=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey() + " Length=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey()) + " myPrivKy=" + myPrivKy);
        System.out.println("Alice:ECCPublicKey=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey() + " Length=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey()) + " myPrivKy=" + myPrivKy);
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getSymmetricKey()) );

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Decrypt") + " Length=" + BobKeyPair.getPrivateKey("Decrypt").length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey("Decrypt")) + " myPrivKy=" + myPrivKy);
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Decrypt") + " Length=" + BobKeyPair.getPublicKey("Decrypt").length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPublicKey("Decrypt")) + " myPubKy=" + myPubKy);
        System.out.println("Bob:ECCPrivateKey=" + BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey() + " Length=" + BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey()) + " myPrivKy=" + myPrivKy);
        System.out.println("Bob:ECCPublicKey=" + BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey() + " Length=" + BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey()) + " myPubKy=" + myPubKy);
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getSymmetricKey()));

        //System.out.println("Eve:");
        //System.out.println("Eve:PrivateKey=" + EveKeyPair.getPrivateKey() + " Length=" + EveKeyPair.getPrivateKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPrivateKey()) + " myPrivKy=" + myPrivKy);
        //System.out.println("Eve:PublicKey=" + EveKeyPair.getPublicKey() + " Length=" + EveKeyPair.getPublicKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPublicKey()) + " N=" + EveKeyPair.getNKey() + " myPubKy=" + myPubKy);
        //System.out.println("Eve:SymmetricKey=" + EveKeyPair.getSymmetricKey() + " Length=" + EveKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getSymmetricKey()));

        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        for (int i = 0; i < (NumberOfTimes + 2); i++) {
            ConfirmedFirstEvent[i] = 0.0;
            ConfirmedSecondEvent[i] = 0.0;
        }
    }

    /**
     * *************************************************** ******
     */
    /**
     * *********** RECEIVER GUI LOW LEVEL TCP FUNCTIONS *********
     */
    public static String Communicate_Receiver() {
        if ((USEUDP.equalsIgnoreCase("USETCP"))
                && (((server == null) && (socketReceiver == null))
                || ((server.isClosed()) && (socketReceiver.isClosed())))) {
            makeConnectionReceiv();
        }
        System.out.println("Communicate_Receiver:Ready to Read Data:");
        if (USEUDP.equalsIgnoreCase("USETCP")) {
            //ReceiverTCPHighLevel();
            makeConnectionReceiv();
            ReceivePacket().toString();
        }
        return "Finished:Communicate_Receiver";
    }

    /* ********************* Testing Stubs Receiver *******/
    public static void TestStageStubReceiver(boolean SilentFlag) {
        System.out.println("TestStageStubReceiver:Function=" + "TestStageStubReceiver");
        System.out.println("/************************** Decryption Begins *************** */");
        int Rand1RotateRecv = Rand1Rotate;
        Double WeiRand2Recv = WeiRand2;
        Double WeiCharRand3Recv = WeiCharRand3;

        DecryptedMesg = new StringBuilder(SenderMesg);
        DecryptStrFuncTimeTaken = "0.0";
        // UNCOMMENT LINES BELOW for low level Testing of Decryption
        //TestStageLowLevelDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, SilentFlag);
        // FUNCTIONS CALL BEGIN
        //DecryptedMesg = FractionDecryptN(DecryptedMesg, SilentFlag);
        //DecryptedMesg = JumbleStrDecrypt(DecryptedMesg, "Double", SilentFlag);
        //DecryptedMesg = RotateStrDecrypt(DecryptedMesg, "Double", OffsetRotate1, StrlenRotate1, SilentFlag);
        //DecryptedMesg = WorkFactorDecrypt(DecryptedMesg, OffsetRotate2, StrlenRotate2,SilentFlag);
//        MyPublicKey = AliceKeyPair.getPublicKey();
//        MyPrivateKey = BobKeyPair.getPrivateKey();
//        if((MyPublicKey==null)||(MyPublicKey.equalsIgnoreCase("")))
//            System.out.println("TestStageStubReceiver:FATAL ERROR:MyPublicKey=null");
//        if((MyPrivateKey==null)||(MyPrivateKey.equalsIgnoreCase("")))
//            System.out.println("TestStageStubReceiver:FATAL ERROR:MyPrivateKey=null");
//        
//        if ((EavesdroppingFlag == false) ) {
//            System.out.println("TestStagemain:WeibullDecrypt:Decryption Permitted:");
//            // Diffusion Parameters
//            // Surprise Parameters
//            variables.put("diffusiond2", diffusiond2);
//            variables.put("diffusionN", diffusionN);
//            variables.put("confusionA", confusionA);
//        }
        String[] MyCharDropped = DecryptedMesg.toString().split(",@");
        System.out.println("PostDecryptBlock:Given:DecryptedMesg=" + DecryptedMesg);
        System.out.println("PostDecryptBlock:Given:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
        StringBuilder NewEncryptedMesg = new StringBuilder(DecryptedMesg);
        NewEncryptedMesg = DiffusionJunkWeiBullDecrypt(NewEncryptedMesg, "Double", SilentFlag);
        DecryptedMesg = NewEncryptedMesg;
        MyCharDropped = DecryptedMesg.toString().split(",@");
        System.out.println("PostDecryptBlock:Final:DecryptedMesg=" + DecryptedMesg);
        System.out.println("PostDecryptBlock:Final:Length=" + DecryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
        WeibullDecrypt(DecryptedMesg.toString(), WeiRand2, WeiCharRand3, SilentFlag);
        System.out.println("TestStagemain:DecryptedMesg=" + DecryptedMesg);
        System.out.println("TestStagemain:DecryptedMesg.length=" + DecryptedMesg.length());
        PostDecryptBlock();
        MyMessage = DecryptedMesg.toString();
        TestExecResultsMessage();

    }

    //Process Test Message
    public static boolean TestExecResultsMessage() {
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage:InitialMsgEncryptState_HighOTP=" + InitialMsgDecryptState_HighOTP + " InitialMsgEncryptState_SecretSeed=" + InitialMsgDecryptState_SecretSeed + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: ReceiverHighLevelSelector=" + ReceiverHighLevelSelector + " ReceiverHighLevelUnsupportedSelector=" + ReceiverHighLevelUnsupportedSelector + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: MyMessage=" + MyMessage + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: Length=" + MyMessage.length() + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: SenderMesg=" + SenderMesg + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: Length=" + SenderMesg.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: DecryptedMesg=:" + DecryptedMesg + ":" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: Length=" + DecryptedMesg.length() + ConsoleColors.RESET);
        MyMessage = MyMessage.trim();
        if (MyMessage.compareTo(DecryptedMesg.toString()) == 0) {
            System.out.println(ConsoleColors.GREEN + "TestExecResultsMessage: Test Case Passes TestCase" + ConsoleColors.RESET);
            return true;
        }
        System.out.println(ConsoleColors.RED + "TestExecResultsMessage: Test Case Fails TestCase= " + ConsoleColors.RESET);
        return false;
    }

    /**
     * *************************************************** ******
     */
    /**
     * *************************************************** ******
     */
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
        boolean SilentFlag = true;
        variablesDecrypt.put("z", (double) zSecret);
        variablesDecrypt.put("s", (double) sSecret);
        variablesDecrypt.put("r", (double) rSecretValue);
        variablesDecrypt.put("m", diffusiond2);
        variablesDecrypt.put("c", diffusionN);

        variablesStr.put("z", "z");
        variablesStr.put("s", "s");
        variablesStr.put("m", "m");
        variablesStr.put("c", "c");
        // Equation Pair 1
        MySimpleWeiBull = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
        System.out.println("EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
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
        Receiver_MessageCycleT(SilentFlag);

        // Equation Pair 8
        TCPExprnDiffusion = "m^2*Xn^2+2*m*Xn*c+c^2";
        TCPDiffWithRespToDiffusion = "Xn";
        InverseTCPExprnDiffusion = "y^0.5/m-c/m";
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
        a = 2591;//2591;//1181;//911;//773;//641;//401;//131;//23;//29;//23;// Preferably Prime Number
        c = 2609;//2609;//1193;//919;//787;//643;//367//101;//17;//17;//7;// Preferably Prime Number
        b = 2647;//2647;//1229;//941;//811;//647;//373;//101;//13;//5;//3;// Preferably Prime Number
        d = 2521;//2521;//1091;//811;//677;//379//109;//19;// Preferably Prime Number
        StudyType = "";
        // Seed Initialization
        SeedSimple = 1181;//41;
        SeedDyDx = 1193;//29;
        SeedXOR = 31;
        RANDProdPerform = "Production";
        // Initialize Prime Numbers
        long MaxValue = Math.max(d, Math.max(b, Math.max(a, c)));
        long Prime = GetPrimeNumber(MaxValue);
        System.out.println("UserTweaks:MaxValue=" + MaxValue + " LastIndex=" + LastIndex + " Prime=" + Prime);
        // Tweaks End
        UserStrings_Receiver_Entropy();
        User_SecretValues("TCPLevel", 1000, 30, User_SecretSeedTCPLevel, User_SecretTCPOTP);
    }

    public static long User_SecretValues(String layerType, long epoch, long timeStepSeconds, long Seed, long OTP) {
        long seed = User_SecretSeedHighLevel;
        zSecret = 54;
        aSecret = 4;
        bSecret = 5;
        cSecret = 10;
        dSecret = 23;
        sSecret = 31;
        aSecretValue = 2;
        cSecretValue = 4;
        rSecretValue = 3;
        if ((ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA")) || (ReceiverStrTCPDecrypt.equalsIgnoreCase("None"))) {
            ; // Do Nothing
        } else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB")) {
            aSecretValue = 2;
            cSecretValue = 5;
        } else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("Weak")) {
            aSecretValue = 2;
            cSecretValue = 3;
        }
        bSecretValue = 5;
        dSecretValue = 23;
        sSecretValue = 31;
        int i = 0;
        if ((seenSeedsReceiver.contains(seed)) && (i < 3) && (layerType.equalsIgnoreCase("TCPLevel"))) {
            OTP = OTPGeneratorClass.GenerateOTP(OTPLength);
            seed = OTP;
        } else if ((seenSeedsReceiver.contains(seed)) && (i < 3) && (!layerType.equalsIgnoreCase("HighLevel"))) {
            throw new IllegalArgumentException("Known seed:seed=" + seed);
        }
        while ((!seenSeedsReceiver.contains(seed)) && (i < 3)) {
            switch (layerType) {
                case "HighLevel":
                    // Slower rotation for algebraic motifs
                    seed = zSecret ^ (epoch / (timeStepSeconds * OTP));
                    break;
                case "TCPLevel":
                    //OTP=OTPGeneratorClass.GenerateOTP(OTPLength);
                    // Faster rotation for packet-level agility
                    seed = zSecret ^ (epoch * timeStepSeconds * 2 * OTP);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown layerType: " + layerType);
            }
            if (seed < 0) {
                seed = seed * -1;
            }
            if (seenSeedsReceiver.add(seed)) {
                break;
            } else {
                i++;
                if (i >= 3) {
                    break;
                }
            }
        }
        return seed;
    }

    public static void Receiver_MessageCycleT(boolean SilentFlag) {
        try {
            TCPEqnUnderTestStrongA = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseTCPEqnUnderTestStrongA = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//"y^0.5/m-c/m";   //x="y^0.5*n/m-2.0*n/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
            TCPEqnUnderTestStrongB = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.expandAmXnEquation(2, 3, 5/*(int)myPubKy*/,2);      //y=(2*x+3)^myPubKy;
            InverseTCPEqnUnderTestStrongB = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.inverseAmXnEquation(2, 3, 5/*(int)myPubKy*/,2); //x="y^1/myPubKy/2-3.0/2";

            TCPEqnUnderTestWeakBinomial = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);      //y=(2*x+3)^4
            InverseTCPEqnUnderTestWeakBinomial = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);

            TCPEqnUnderTestWeak = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.expandAmXnEquation(2,3,4,  2);//y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseTCPEqnUnderTestWeak = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.inverseAmXnEquation(2,3,4,  2);//"y^0.5/m-c/m";
        } catch (Exception e) {
            e.printStackTrace();
            TCPEqnUnderTestStrongA = PSACEquationFactory.buildEquation(7);//y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseTCPEqnUnderTestStrongA = PSACEquationFactory.buildInverse(7);//"y^0.5/m-c/m";   //x="y^0.5*n/m-2.0*n/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
            TCPEqnUnderTestStrongB = PSACEquationFactory.buildEquation(6);//PSAEquationSuite.expandAmXnEquation(2, 3, 5/*(int)myPubKy*/,2);      //y=(2*x+3)^myPubKy;
            InverseTCPEqnUnderTestStrongB = PSACEquationFactory.buildInverse(6);//PSAEquationSuite.inverseAmXnEquation(2, 3, 5/*(int)myPubKy*/,2); //x="y^1/myPubKy/2-3.0/2";
            TCPEqnUnderTestWeakBinomial = PSACEquationSuite.expandMultinomialAmXnEquation();      //y=(2*x+3)^4
            InverseTCPEqnUnderTestWeakBinomial = PSACEquationSuite.inverseMultinomialAmXnEquation();
            TCPEqnUnderTestWeak = PSACEquationFactory.buildEquation(4);//PSAEquationSuite.expandAmXnEquation(2,3,4,  2);//y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseTCPEqnUnderTestWeak = PSACEquationFactory.buildInverse(4);//PSAEquationSuite.inverseAmXnEquation(2,3,4,  2);//"y^0.5/m-c/m"; 
        }
        if (SilentFlag == false) {
            //if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA")){
            System.out.println("Receiver_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + ":InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
            //}else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB")){
            System.out.println("Receiver_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongB=" + TCPEqnUnderTestStrongB + ":InverseTCPEqnUnderTestStrongB=" + InverseTCPEqnUnderTestStrongB);
            //}else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("Weak")){
            System.out.println("Receiver_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak + ":InverseTCPEqnUnderTestWeak=" + InverseTCPEqnUnderTestWeak);
            //}else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("None")){
            System.out.println("Receiver_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + ":InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
            //}
        }
    }

    public static void HighLevel_Receiver_Cycle() {
        try {
            EqnUnderTest = PSACOTPEquation.buildOTPEquation("HighLevel", InitialMsgDecryptState_SecretSeed, InitialMsgDecryptState_HighOTP);//PSAEquationSuite.expandAmXnEquation((int)rSecretValue);// "m^2*Xn^2+2*m*Xn*c+c^2";    
            InverseEqnUnderTest = PSACOTPEquation.buildOTPInverse("HighLevel", InitialMsgDecryptState_SecretSeed, InitialMsgDecryptState_HighOTP);//PSAEquationSuite.inverseAmXnEquation((int)rSecretValue);//"y^0.5/m-c/m"; ;
        } catch (Exception e) {
            e.printStackTrace();
            EqnUnderTest = PSACEquationFactory.buildEquation(3);
            InverseEqnUnderTest = PSACEquationFactory.buildInverse(3);
        }
    }
}
