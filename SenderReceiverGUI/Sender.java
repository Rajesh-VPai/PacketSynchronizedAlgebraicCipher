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
import static Security.Encryption.EncryptMessageDetail;
import static Security.Encryption.EncryptStrFuncTimeTaken;
import static Security.EquationPairGeneration.DiffWithRespToDiffusion;
import static Security.EquationPairGeneration.DiffWithRespToSurprise;
import static Security.EquationPairGeneration.ExprnDiffusion;
import static Security.EquationPairGeneration.ExprnSurprise;
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
import static Security.Encryption.MyMessage;
import static Security.Security.MySimpleWeiBull;
import static Security.Configuration.PRAGMA;
import static Security.Configuration.PRAGMADetail;
import static Security.SubstitutionBox.SuccessiveCharsIncrementSim;
import static Security.SubstitutionBox.SuccessiveCharsLenSim;
import static Security.Security.Xn_LCG;
import static Security.SecurityTestHarness.ConfirmedFirstEvent;
import static Security.SecurityTestHarness.ConfirmedSecondEvent;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static Security.Configuration.MessageInvariant;
import static Security.SecurityTestHarness.OccasionNoOfTimesIndex;
import static Security.Configuration.NumberOfFractions;
import static Security.Configuration.SecurityPosture;
import static Security.SecurityTestHarness.PreEncryptBlock;
import static Security.EquationPairGeneration.InvExprnDiffusion;
import static Security.Security.variablesStr;
import static Security.EquationPairGeneration.InvDiffusionDiffWithRespTo;
import static Security.EquationPairGeneration.InvExprnSurprise;
import static Security.EquationPairGeneration.InvSurpriseDiffWithRespTo;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.FractionEncryptExprn;
import static Security.EquationPairGeneration.FractionEncryptDiffWithRespTo;
import static Security.EquationPairGeneration.FractionEncryptComputerExprn;
import static Security.EquationPairGeneration.FractionEncryptComputerDiffWithRespTo;
import static Security.EquationPairGeneration.FractionDecryptExprn;
import static Security.EquationPairGeneration.FractionDecryptDiffWithRespTo;
import static Security.EquationPairGeneration.InvFractionDecryptComputerExprn;
import static Security.EquationPairGeneration.InvFractionDecryptComputerDiffWithRespTo;
import static Security.EquationPairGeneration.TranspositionExprn;
import static Security.EquationPairGeneration.TranspositionDiffWithRespTo;
import static Security.EquationPairGeneration.TranspComputerDiffWithRespTo;
import static Security.EquationPairGeneration.TranspComputerExprn;
import static Security.EquationPairGeneration.InvTranspositionExprn;
import static Security.EquationPairGeneration.InvTranspositionDiffWithRespTo;
import static Security.EquationPairGeneration.InvTranspComputerExprn;
import static Security.EquationPairGeneration.InvTranspComputerDiffWithRespTo;
import static Security.Encryption.EncryptedMesg;
import static Security.Encryption.LayersOfSecurityEncrypt;
import static Security.Encryption.PlainText;
import static Security.Encryption.TestDebug;
import Security.OTPGeneratorClass;
import static Security.Configuration.USE_AES;
import static Security.Encryption.FEOTP;
import static Security.Encryption.FEOTP_1_;
import static Security.Encryption.FEOTP_2_;
import static Security.Encryption.FEOTP_3_;
import static Security.Encryption.FEReceiver;
import static Security.Encryption.FESender;
import static Security.Encryption.SEOTP;
import static Security.Encryption.SEOTP_1_;
import static Security.Encryption.SEOTP_2_;
import static Security.Encryption.SEOTP_3_;
import static Security.Encryption.SEReceiver;
import static Security.Encryption.SESender;
import Security.EquationPairGeneration;
import static Security.EquationPairGeneration.aSecret;
import static Security.EquationPairGeneration.bSecret;
import static Security.EquationPairGeneration.cSecret;
import static Security.EquationPairGeneration.dSecret;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.sSecret;
import static Security.EquationPairGeneration.zSecret;
import static Security.EquationPairGeneration.aSecretValue;
import static Security.EquationPairGeneration.bSecretValue;
import static Security.EquationPairGeneration.cSecretValue;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.sSecretValue;
import static Security.EquationPairGeneration.rSecretValue;
import static Security.EquationPairGeneration.seenSeedsSender;
import Security.ISNHandler;
import Security.MetaDataEncryptor;
import static Security.PacketSynchronizedAlgebraicCipher.IntegrateRandomNumberPackageSetGBLVar;
import static Security.PacketSynchronizedAlgebraicCipher.MesgINCAPS;
import static Security.PacketSynchronizedAlgebraicCipher.SafeEquationsFlag;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import Security.RFC6528ISNGenerator;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.variablesEncrypt;
import static Security.SubstitutionBox.DiffusionJunkWeiBullEncrypt;
import static Security.SubstitutionBox.SuccessiveCharsIncrementWeiBull;
import static Security.SubstitutionBox.SuccessiveCharsLenWeiBull;
import static Security.SubstitutionBox.WeibullEncrypt;
import static Security.TCPEncryption.SendTCPEncryptStrData;
import static Security.TCPEncryption.TearDown;
import static Security.TCPEncryption.makeConnectionSender;
import static Security.TranspositionPBox.SuccessiveCharsIncrementJumble;
import static Security.TranspositionPBox.SuccessiveCharsIncrementRotate;
import static Security.TranspositionPBox.SuccessiveCharsLenJumble;
import static Security.TranspositionPBox.SuccessiveCharsLenRotate;
import static SenderReceiverGUI.SenderGUI.SenderMesg;
import static SenderReceiverGUI.SenderGUI.StrGUI;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

/**
 *
 * @author Rajesh V Pai
 */
//Program Taken from java2s.com/Tutorial/java
// Google string:Java UDP sender and receiver example
public class Sender {

    private static ServerSocket server = null;
    public static String hostName = "";//"localhost";//"127.0.0.1";
    public static int port = 8003;
    public int portUDP = 8004;
    public static Socket socketSend;
    public static DataOutputStream output;
    public static PrintWriter outputPWR;
    public static boolean SenderTCPEncrypt = true;// true for StrongA, StrongB, Weak && false for None
    public static String SenderStrTCPEncrypt = "StrongA";// Values are :StrongA, StrongB,Weak, None
    public static StringBuilder TCPEncryptedMesg;
    public static String LowLevelTCPEncryptedBytes = "";
    public static String TCPEqnUnderTestStrongA = "";
    public static String TCPEqnUnderTestStrongB = "";
    public static String TCPEqnUnderTestWeakBinomial = "";
    public static String TCPEqnUnderTestWeak = "";
    public static String InverseTCPEqnUnderTestStrongA = "";
    public static String InverseTCPEqnUnderTestStrongB = "";
    public static String InverseTCPEqnUnderTestWeakBinomial = "";
    public static String InverseTCPEqnUnderTestWeak = "";
    public static String TCPExprnDiffusion = "";
    public static String TCPExprnSurprise = "";
    public static String InverseTCPExprnSurprise = "";
    public static String InverseTCPExprnDiffusion = "";
    public static String TCPDiffWithRespToDiffusion = "";
    public static String InverseTCPDiffusionDiffWithRespTo = "";
    public static String InverseTCPEqnUnderTestStrong = "";

    public static String EqnUnderTest = "";
    public static String InverseEqnUnderTest = "";
    public static long User_SecretHighOTP = -1;
    public static Long User_SecretTCPOTP = -1L;
    public static long User_SecretSeedHighLevel = 123456789L;
    public static Long User_SecretSeedTCPLevel = 123456789L;

    // State of OTP for EqnUnderTest
    public static long InitialMsgEncryptState_HighOTP = 123456789L;
    public static long InitialMsgEncryptState_SecretSeed = 123456789L;

    public static int SenderChunkNumber = 400;
    public static int ActualChunksSent = 0;

    // The OTPs
    public static int OTPLength = 8;
    public static int Rand1Rotate = 0;
    public static Double WeiRand2 = 0.0;
    public static Double WeiCharRand3 = 0.0;
    public static int MessageSize = 0;

    // Rotation Variables
    public static int OffsetRotate1 = 0;
    public static int StrlenRotate1 = 0;
    public static int OffsetRotate2 = 0;
    public static int StrlenRotate2 = 0;

    public static boolean SendTurnOffOccassionalism = true;
    public static boolean FirstTimeFlag = true;
    public static boolean FirstTimeFlagTCPOptimised = true;
    public static boolean FirstTimeFlagKeys = true;
    public static int ReadTCPPacketCount = 0;
    public static int SenderHighLevelSelector = -1;
    public static int SenderHighLevelUnsupportedSelector = -1;

    // Frame Variables
    public static int FRAME_SIZE = 20; // configurable : Max=MaxMessages

    public static void SendPacket(StringBuilder MyMessage, boolean EncryptFlag) throws Exception {
        //if (USEUDP.equalsIgnoreCase("USEUDP"))
        //    SendPacketUDP(MyMessage);
        //else
        if ((USEUDP.equalsIgnoreCase("USETCP"))
                && (StrGUI.equalsIgnoreCase("Console"))) {
            SendPacketTCPConsole(MyMessage, EncryptFlag);
        } else if ((USEUDP.equalsIgnoreCase("USETCP"))
                && (StrGUI.equalsIgnoreCase("GUI"))) {
            SendPacketTCPConsole(MyMessage, EncryptFlag);
        }

    }

    public void SendPacketUDP(String MyMessage) throws Exception {
        if (hostName == null) {
            hostName = "localhost";
        }
        byte[] buffer = MyMessage.getBytes();
        if (UDPBuffLen < buffer.length) {
            System.out.println(" CANNOT SEND:DUE TO SIZE LIMITATION");
            return;
        }
        System.out.println("Sender:");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                new InetSocketAddress(this.hostName, this.port));
        DatagramSocket socket = new DatagramSocket(this.portUDP);
        System.out.println(packet.getSocketAddress());
        System.out.println("Sender:Just Before send Packet");
        socket.send(packet);
        System.out.println(new String(buffer));
        socket.close();
        System.out.println("Sender:Closed Socket");
    }

    public static void SendPacketTCPConsole(StringBuilder MyMessage, boolean EncryptFlag) throws Exception {
        boolean SilentFlag = false;
        makeConnectionSender();
        if ((socketSend != null) && (socketSend.isBound()) && (socketSend.isConnected())) {
            if (SilentFlag == false) {
                System.out.println("Sender:SendPacketTCPConsole:Connected:ReadTCPPacketCount=" + ReadTCPPacketCount);
            }
            mainObjectsCreationConsole(MyMessage, EncryptFlag);
        } else {
            if (SilentFlag == false) {
                System.out.println("Sender:SendPacketTCPConsole:Connection refused:ReadTCPPacketCount=" + ReadTCPPacketCount);
            }
            makeConnectionSender();
            if (SilentFlag == false) {
                System.out.println("Sender:SendPacketTCPConsole:Connected:ReadTCPPacketCount=" + ReadTCPPacketCount);
            }
            mainObjectsCreationConsole(MyMessage, EncryptFlag);
        }
    }

    public static void mainObjectsCreationConsole(StringBuilder MyMessage, boolean EncryptFlag) {
        try {
            DataOutputStream out = new DataOutputStream(socketSend.getOutputStream());
            StringBuilder MyMessage1;

            // Apply encryption if requested
            if (EncryptFlag) {
                MyMessage1 = SendTCPEncryptStrData(MyMessage);
            } else {
                MyMessage1 = MyMessage;
            }

            byte[] data = MyMessage1.toString().getBytes("UTF-8");

            // Write length prefix first
            //System.out.println("mainObjectsCreationConsole:Sending length=" + data.length + " bytes");
            out.writeInt(data.length);

            // Write actual message bytes
            out.write(data);
            //System.out.println("mainObjectsCreationConsole:Sent=" + data.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TCPSenderHighLevel1on1() {
        try {

            boolean EncryptFlag = true;
            boolean SilentFlag = true;

            ReadTCPPacketCount = 0;
            SecretKey aesKey = MetaDataEncryptor.aesKey;
            //makeConnectionSender();
            //SendLWEmain();
            // Step 1: Send baseline ISN using ISNHandler
            //InitialMsgEncryptState_HighOTP = User_SecretHighOTP;
            //InitialMsgEncryptState_SecretSeed = User_SecretSeedHighLevel;
            String baselinePacket = ISNHandler.attachBaseline(hostName, port, SilentFlag);
            String ts = RFC6528ISNGenerator.currentTimestamp();
            long timer = System.currentTimeMillis(); // generate once here
            SendPacket(new StringBuilder(baselinePacket), false);
            if (SilentFlag == false) {
                System.out.println("Baseline ISN sent: " + baselinePacket);
            }

            // Step 2: Send rotation/entropy parameters as message ISN packets
            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg1 = ISNHandler.attachMessage(new StringBuilder("" + Rand1Rotate), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg1, ts, timer);
            SendPacket(new StringBuilder(msg1), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg2 = ISNHandler.attachMessage(new StringBuilder("" + OffsetRotate1), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg2, ts, timer);
            SendPacket(new StringBuilder(msg2), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg3 = ISNHandler.attachMessage(new StringBuilder("" + StrlenRotate1), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg3, ts, timer);
            SendPacket(new StringBuilder(msg3), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg4 = ISNHandler.attachMessage(new StringBuilder("" + OffsetRotate2), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg4, ts, timer);
            SendPacket(new StringBuilder(msg4), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg5 = ISNHandler.attachMessage(new StringBuilder("" + StrlenRotate2), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg5, ts, timer);
            SendPacket(new StringBuilder(msg5), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg6 = ISNHandler.attachMessage(new StringBuilder("" + WeiRand2), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg6, ts, timer);
            SendPacket(new StringBuilder(msg6), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg7 = ISNHandler.attachMessage(new StringBuilder("" + WeiCharRand3), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg7, ts, timer);
            SendPacket(new StringBuilder(msg7), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg8 = ISNHandler.attachMessage(new StringBuilder("" + UDPBuffLen), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg8, ts, timer);
            SendPacket(new StringBuilder(msg8), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            MessageSize = EncryptedMesg.length();
            String msg9 = ISNHandler.attachMessage(new StringBuilder("" + MessageSize), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg9, ts, timer);
            SendPacket(new StringBuilder(msg9), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg10 = ISNHandler.attachMessage(new StringBuilder("" + CyclicFlag), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg10, ts, timer);
            SendPacket(new StringBuilder(msg10), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg11 = ISNHandler.attachMessage(new StringBuilder("" + NumberOfTimes), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg11, ts, timer);
            SendPacket(new StringBuilder(msg11), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg12 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsLenSim), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg12, ts, timer);
            SendPacket(new StringBuilder(msg12), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg13 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsIncrementSim), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg13, ts, timer);
            SendPacket(new StringBuilder(msg13), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg14 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsLenWeiBull), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg14, ts, timer);
            SendPacket(new StringBuilder(msg14), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg15 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsIncrementWeiBull), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg15, ts, timer);
            SendPacket(new StringBuilder(msg15), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg16 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsLenRotate), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg16, ts, timer);
            SendPacket(new StringBuilder(msg16), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg17 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsIncrementRotate), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg17, ts, timer);
            SendPacket(new StringBuilder(msg17), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg18 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsLenJumble), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg18, ts, timer);
            SendPacket(new StringBuilder(msg18), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg19 = ISNHandler.attachMessage(new StringBuilder("" + SuccessiveCharsIncrementJumble), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg19, ts, timer);
            SendPacket(new StringBuilder(msg19), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg20 = ISNHandler.attachMessage(new StringBuilder("" + EavesdroppingFlag), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg20, ts, timer);
            SendPacket(new StringBuilder(msg20), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg21 = ISNHandler.attachMessage(new StringBuilder("" + OccasionNoOfTimesIndex), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg21, ts, timer);
            SendPacket(new StringBuilder(msg21), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg22 = ISNHandler.attachMessage(new StringBuilder("" + ConfirmedFirstEvent[0]), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg22, ts, timer);
            SendPacket(new StringBuilder(msg22), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg23 = ISNHandler.attachMessage(new StringBuilder("" + ConfirmedSecondEvent[0]), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg23, ts, timer);
            SendPacket(new StringBuilder(msg23), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg24 = ISNHandler.attachMessage(new StringBuilder("" + AliceKeyPair.getPublicKey("Encrypt")), hostName, port, SilentFlag);
            SendPacket(new StringBuilder(msg24), false);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg25 = ISNHandler.attachMessage(new StringBuilder("" + SenderStrTCPEncrypt), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg25, ts, timer);
            SendPacket(new StringBuilder(msg25), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg26 = ISNHandler.attachMessage(new StringBuilder("" + ActualChunksSent), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg26, ts, timer);
            SendPacket(new StringBuilder(msg26), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            // Step 3: Send encrypted payload itself
            String encryptedMsgPacket = ISNHandler.attachMessage(new StringBuilder(EncryptedMesg), hostName, port, SilentFlag);
            SendPacket(new StringBuilder(encryptedMsgPacket), false);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg27 = ISNHandler.attachMessage(new StringBuilder("" + FESender), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg27, ts, timer);
            SendPacket(new StringBuilder(msg27), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg28 = ISNHandler.attachMessage(new StringBuilder("" + FEReceiver), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg28, ts, timer);
            SendPacket(new StringBuilder(msg28), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg29 = ISNHandler.attachMessage(new StringBuilder("" + FEOTP), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg29, ts, timer);
            SendPacket(new StringBuilder(msg29), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg30 = ISNHandler.attachMessage(new StringBuilder("" + FEOTP_1_), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg30, ts, timer);
            SendPacket(new StringBuilder(msg30), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg31 = ISNHandler.attachMessage(new StringBuilder("" + FEOTP_3_), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg31, ts, timer);
            SendPacket(new StringBuilder(msg31), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg32 = ISNHandler.attachMessage(new StringBuilder("" + FEOTP_2_), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg32, ts, timer);
            SendPacket(new StringBuilder(msg32), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg33 = ISNHandler.attachMessage(new StringBuilder("" + SESender), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg33, ts, timer);
            SendPacket(new StringBuilder(msg33), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg34 = ISNHandler.attachMessage(new StringBuilder("" + SEReceiver), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg34, ts, timer);
            SendPacket(new StringBuilder(msg34), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg35 = ISNHandler.attachMessage(new StringBuilder("" + SEOTP), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg35, ts, timer);
            SendPacket(new StringBuilder(msg35), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg36 = ISNHandler.attachMessage(new StringBuilder("" + SEOTP_1_), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg36, ts, timer);
            SendPacket(new StringBuilder(msg36), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg37 = ISNHandler.attachMessage(new StringBuilder("" + SEOTP_3_), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg37, ts, timer);
            SendPacket(new StringBuilder(msg37), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg38 = ISNHandler.attachMessage(new StringBuilder("" + SEOTP_2_), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg38, ts, timer);
            SendPacket(new StringBuilder(msg38), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg39 = ISNHandler.attachMessage(new StringBuilder("" + InitialMsgEncryptState_HighOTP), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg39, ts, timer);
            SendPacket(new StringBuilder(msg39), EncryptFlag);

            User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
            String msg40 = ISNHandler.attachMessage(new StringBuilder("" + InitialMsgEncryptState_SecretSeed), hostName, port, SilentFlag);
            SendMeta(output, aesKey, hostName, port, baselinePacket, msg40, ts, timer);
            SendPacket(new StringBuilder(msg40), EncryptFlag);

            System.out.println("All message ISN packets sent successfully.");
        } catch (Exception e) {
            System.out.println("Exception in TCPSenderHighLevel: " + e);
            e.printStackTrace();
        }
    }

    public static void TCPSenderHighLevelFrame() {
        try {
            boolean EncryptFlag = true;
            boolean SilentFlag = true;
            ReadTCPPacketCount = 0;
            SecretKey aesKey = Security.MetaDataEncryptor.aesKey;
            //makeConnectionSender();
            //QuantumLWE.SenderMainLWE.SendLWEmain(EncryptedMesg.toString());

            // Step 1: Baseline ISN
            String baselinePacket = Security.ISNHandler.attachBaseline(hostName, port, SilentFlag);
            String ts = Security.RFC6528ISNGenerator.currentTimestamp();
            long timer = System.currentTimeMillis();
            SendPacket(new StringBuilder(baselinePacket), false);

            // Step 2: Bundle variables
            String[] vars = {
                "" + SenderReceiverGUI.Sender.Rand1Rotate,
                "" + SenderReceiverGUI.Sender.OffsetRotate1,
                "" + SenderReceiverGUI.Sender.StrlenRotate1,
                "" + SenderReceiverGUI.Sender.OffsetRotate2,
                "" + SenderReceiverGUI.Sender.StrlenRotate2,
                "" + SenderReceiverGUI.Sender.WeiRand2,
                "" + SenderReceiverGUI.Sender.WeiCharRand3,
                "" + Security.Configuration.UDPBuffLen,
                "" + Security.Encryption.EncryptedMesg.length(),
                "" + Security.Configuration.CyclicFlag,
                "" + Security.Configuration.NumberOfTimes,
                "" + Security.SubstitutionBox.SuccessiveCharsLenSim,
                "" + Security.SubstitutionBox.SuccessiveCharsIncrementSim,
                "" + Security.SubstitutionBox.SuccessiveCharsLenWeiBull,
                "" + Security.SubstitutionBox.SuccessiveCharsIncrementWeiBull,
                "" + Security.TranspositionPBox.SuccessiveCharsLenRotate,
                "" + Security.TranspositionPBox.SuccessiveCharsIncrementRotate,
                "" + Security.TranspositionPBox.SuccessiveCharsLenJumble,
                "" + Security.TranspositionPBox.SuccessiveCharsIncrementJumble,
                "" + Security.SecurityTestHarness.EavesdroppingFlag,
                "" + Security.SecurityTestHarness.OccasionNoOfTimesIndex,
                "" + Security.SecurityTestHarness.ConfirmedFirstEvent[0],
                "" + Security.SecurityTestHarness.ConfirmedSecondEvent[0],
                "" + SenderReceiverGUI.Sender.SenderStrTCPEncrypt,
                "" + SenderReceiverGUI.Sender.ActualChunksSent,
                "" + Security.Encryption.FESender,
                "" + Security.Encryption.FEReceiver,
                "" + Security.Encryption.FEOTP,
                "" + Security.Encryption.FEOTP_1_,
                "" + Security.Encryption.FEOTP_3_,
                "" + Security.Encryption.FEOTP_2_,
                "" + Security.Encryption.SESender,
                "" + Security.Encryption.SEReceiver,
                "" + Security.Encryption.SEOTP,
                "" + Security.Encryption.SEOTP_1_,
                "" + Security.Encryption.SEOTP_3_,
                "" + Security.Encryption.SEOTP_2_,
                "" + InitialMsgEncryptState_HighOTP,
                "" + InitialMsgEncryptState_SecretSeed
            };

            for (int i = 0; i < vars.length; i += FRAME_SIZE) {
                StringBuilder frame = new StringBuilder();
                SenderReceiverGUI.Sender.User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount++, SilentFlag);
                System.out.println("TCPSenderHighLevel:TCP Encryption ON:TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + " :InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
                SendMeta(output, aesKey, hostName, port, baselinePacket, "", ts, timer);
                for (int j = i; j < i + FRAME_SIZE && j < vars.length; j++) {
                    frame.append("VAR").append(j).append("_:").append(vars[j]).append(",|");
                }
                String msg = Security.ISNHandler.attachMessage(frame, hostName, port, SilentFlag);
                SendPacketNew(new StringBuilder(msg), EncryptFlag);

            }
            String msg = Security.ISNHandler.attachMessage(new StringBuilder(AliceKeyPair.getPublicKey("Encrypt")), hostName, port, SilentFlag);
            SendPacketNew(new StringBuilder(msg), false);
            ReadTCPPacketCount++;

            SenderMesg = EncryptedMesg;
            System.out.println("TCPSenderHighLevel:SenderMesg:" + SenderMesg);
            System.out.println("TCPSenderHighLevel:EncryptedMesg:" + EncryptedMesg);
            String msg1 = Security.ISNHandler.attachMessage(new StringBuilder(EncryptedMesg), hostName, port, SilentFlag);
            SendPacketNew(new StringBuilder(msg1), false);
            ReadTCPPacketCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SendPacketNew(StringBuilder MyMessage, boolean EncryptFlag) throws Exception {
        if ((Security.Configuration.USEUDP.equalsIgnoreCase("USETCP"))) {
            DataOutputStream out = new DataOutputStream(socketSend.getOutputStream());
            // Apply encryption if requested
            if (EncryptFlag && SenderTCPEncrypt) {
                System.out.println("SendPacketNew:TCP Encryption ON:EncryptFlag=" + EncryptFlag);
                MyMessage = SendTCPEncryptStrData(MyMessage);
            } else {
                MyMessage = MyMessage;
            }
            byte[] data = MyMessage.toString().getBytes("UTF-8");
            out.writeInt(data.length);
            out.write(data);
            out.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        StrGUI = "Console";
        if (USE_AES == false) {
            System.out.println(ConsoleColors.GREEN + "Sender:USER HAS FULL CONTROL OVER SOURCE CODE AND FULL RESPONSIBILITY FOR SECURITY." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE + "Sender:USER IS USING MODERN METHODS FOR SECURITY." + ConsoleColors.RESET);
        }
        if (SenderTCPEncrypt == false) {
            System.out.println(ConsoleColors.RED + "Sender:WARNING:TCP Encryption is OFF." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Sender:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        if (PlainText == true) {
            System.out.println(ConsoleColors.RED + "Sender:WARNING:PlainText is ON." + " TestDebug=" + TestDebug + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "Receiver:WARNING:TCP Encryprtion is Probably ON.TestDebug=" + TestDebug + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Sender:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        if (SafeEquationsFlag == true) {
            System.out.println(ConsoleColors.GREEN + "Receiver:Safe Equations is ON. All Equations will NOT be used. Output Guarantee True OUTPUT" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Receiver:Safe Equations is OFF. All Equations will be used. Output Variations does NOT Guarantee True OUTPUT" + ConsoleColors.RESET);
        }
        mainHeader();
        variablesEncrypt.clear();
        MyMessage = "";
        while ((!MyMessage.equalsIgnoreCase("Bye"))
                && (!MyMessage.equalsIgnoreCase("quit"))
                && (!MyMessage.equalsIgnoreCase("exit"))) {
            if ((FirstTimeFlagKeys == false) && (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse")) && (((TestDebug.equalsIgnoreCase("Production")) && (PlainText == false)))) {
                SetupAlice("Encrypt");
                SetupBob("Encrypt");
                //SetupEve();
                FirstTimeFlagKeys = false;
            }
//            else {
//                String AlgoName="Encrypt";
//                AliceKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
//                AliceKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
//                AliceKeyPair.MyTCCKeyPair = new TCPECCKeyPairGeneration();
//                AliceKeyPair.MyTCCKeyPair.init(AlgoName, mySeedKey, mySeedKey);
//                AliceKeyPair.MyTCCKeyPair.GenerateKeys();
//                
//                BobKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
//                BobKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
//                BobKeyPair.MyTCCKeyPair = new TCPECCKeyPairGeneration();
//                BobKeyPair.MyTCCKeyPair.init(AlgoName, mySeedKey, mySeedKey);
//                BobKeyPair.MyTCCKeyPair.GenerateKeys();
//                
//            }
            if (StrGUI.equalsIgnoreCase("Console")) {
                MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
                //MyMessage="Test Message Test Message Test Message Test Message Test Message Test Message Test Message Test Message Test Message";
                //MyMessage="Hel";
                //MyMessage=" ";
                //MyMessage="ok";
                //MyMessage="k";
                //MyMessage="K";
                //MyMessage="No";
                //MyMessage="no";
                //MyMessage="bye";
                //MyMessage="Hello,@World Hello,@World";
                //MyMessage="Data,:Payload";
                //MyMessage="Amount,$Value Amount,$Value";
                //MyMessage="Test Message Test Message Test Message Test Message Test Message Test Message Test Message Test Message Test Message the quick brown fox jumps over the lazy dog.1234567890\\\"\\'!@#$%^&*()+-_={}[];><,./?|\\\\";
                //MyMessage="???????????????????????????????????????????????????????????????????????????????????????";
                System.out.println("Message To Send to Receiver =" + "Test Message" /*MyMessage*/);
                System.out.print(" : Your Choice [Default]:");
                Scanner scanner = new Scanner(System.in);
                String TempxExprn = scanner.nextLine();
                if (TempxExprn.equalsIgnoreCase("")) {
                    ;
                } else {
                    MyMessage = TempxExprn;
                }
                //TestStageStubSender(true);
            }
            SenderMesg = new StringBuilder(MyMessage);
            SendAMessage();
            Communicate_Sender();
            SentValues();
            ResetData();
            System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: InitialMsgEncryptState_HighOTP=" + InitialMsgEncryptState_HighOTP + " InitialMsgEncryptState_SecretSeed=" + InitialMsgEncryptState_SecretSeed + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: SenderHighLevelSelector=" + SenderHighLevelSelector + " SenderHighLevelUnsupportedSelector=" + SenderHighLevelUnsupportedSelector + ConsoleColors.RESET);
            FirstTimeFlagKeys = false;
            UserStrings_Sender_Entropy();
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
        System.out.println("Parameters:SenderTCPEncrypt:=" + SenderTCPEncrypt);
        System.out.println("Parameters:SenderStrTCPEncrypt:=" + SenderStrTCPEncrypt);
        //System.out.println("Parameters:SenderTCPEncryptLowLevel:=" + SenderTCPEncryptLowLevel);
        System.out.println("Parameters:FOBRandomChar:=" + FOBRandomChar);
        System.out.println("Parameters:RANDProdPerform:=" + RANDProdPerform);
        System.out.println("Parameters:SecurityPosture:=" + SecurityPosture);
        System.out.println("Parameters:NumberOfFractions:=" + NumberOfFractions);
        System.out.println("Parameters:PRAGMA:=" + PRAGMA);
        System.out.println("Parameters:PRAGMADetail:=" + PRAGMADetail);
        System.out.println("Parameters:TestDebug:=" + TestDebug);
        System.out.println("Parameters:PlainText:=" + PlainText);
        System.out.println("Parameters:LayersOfSecurityEncrypt:=" + LayersOfSecurityEncrypt);
    }

    public static void SendAMessage() {
        System.out.println("SendAMessage:Function=" + "SendAMessage");
        EncryptedMesg = new StringBuilder(SenderMesg);
        boolean SilentFlag = true;
        MyMessage = MyMessage.trim();

        // Encryption && Decryption Parameters
        if (StrGUI.equalsIgnoreCase("Console")) {
            System.out.println("Sending:Console:SenderMesg=" + SenderMesg);
            System.out.println("SendAMessage:EncryptedMesg=" + EncryptedMesg);
        } else if (StrGUI.equalsIgnoreCase("GUI")) {
            System.out.println("Sending:GUI:SenderMesg=" + SenderMesg);
            System.out.println("SendAMessage:EncryptedMesg=" + EncryptedMesg);
        }
        /**
         * ************************ Encryption Begins ***************
         */
        System.out.println("/************************** Encryption Begins *************** */");
        if ( ( (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))||(SecurityPosture.equalsIgnoreCase("Normal")) )
            &&(!((TestDebug.equalsIgnoreCase("Debugging")) && (PlainText == true))) ) {
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        //MyPublicEquation = EqnUnderTest;
        CalibrationSender = "ContextSetMesgSenderBob";
        if ((MyPublicKey == null) || (MyPublicKey.equalsIgnoreCase(""))) {
            System.out.println("SendAMessage:FATAL ERROR:MyPublicKey=null");
        }
        if ((MyPrivateKey == null) || (MyPrivateKey.equalsIgnoreCase(""))) {
            System.out.println("SendAMessage:FATAL ERROR:MyPrivateKey=null");
        }
        System.out.println("Sender:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob");
        Rand1Rotate = OTPGeneratorClass.GenerateOTP(OTPLength);//(int) MySimpleWeiBull.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
        WeiRand2 = (double) OTPGeneratorClass.GenerateOTP(OTPLength);//(double) MySimpleWeiBull.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
        WeiCharRand3 = (double) OTPGeneratorClass.GenerateOTP(OTPLength);//MySimpleWeiBull.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
        }
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        for (int i = 0; i < (NumberOfTimes + 2); i++) {
            ConfirmedFirstEvent[i] = 0.0;
            ConfirmedSecondEvent[i] = 0.0;
        }
        //CyclicEncrypt(Rand1Rotate,OffsetRotate1,OffsetRotate2, WeiRand2, WeiCharRand3, SilentFlag);
        String TempEncrypt = EncryptMessageDetail(Rand1Rotate, WeiRand2, WeiCharRand3, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        System.out.println("/************************** Encryption Ends *************** */");
        System.out.println("Sender:EncryptedMesg=" + EncryptedMesg + " Length=" + EncryptedMesg.toString().length());
        
        for (int i = 0; i < (NumberOfTimes + 2); i++) {
            if ((ConfirmedFirstEvent[i] == 0.0)
                    || (ConfirmedSecondEvent[i] == 0.0)) {
                NumberOfTimes = i;
                break;
            }
        }
        /**
         * ************************ Encryption Ends ***************
         */

    }

    public static void Communicate_Sender() {
        if (FRAME_SIZE == 1) {
            TCPSenderHighLevel1on1();
        } else {
            TCPSenderHighLevelFrame();
        }
    }

    public static void mainHeader() {
        IntegrateRandomNumberPackageSetGBLVar();

        //myPrivKy = 100;
        //myPubKy = 100;
        System.out.println("Sender:myPrivKy=" + myPrivKy + " myPubKy=" + myPubKy);
        System.out.println("Sender:StrGUI=" + StrGUI);
        UserTweaks_Entropy();
        System.out.println("**************** Parameters Begin***************");
        Parameters();
        System.out.println("****************** Parameters End***************");
        String AlgoName = "Encrypt";
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
            System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey(AlgoName) + " Length=" + BobKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
            System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey(AlgoName) + " Length=" + BobKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
            System.out.println("Bob:ECCPrivateKey=" + BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey() + " Length=" + BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey()) + " myPrivKy=" + myPrivKy);
            System.out.println("Bob:ECCPublicKey=" + BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey() + " Length=" + BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey()) + " myPubKy=" + myPubKy);
            //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getSymmetricKey()));

            //System.out.println("Eve:");
            //System.out.println("Eve:PrivateKey=" + EveKeyPair.getPrivateKey() + " Length=" + EveKeyPair.getPrivateKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPrivateKey()) + " myPrivKy=" + myPrivKy);
            //System.out.println("Eve:PublicKey=" + EveKeyPair.getPublicKey() + " Length=" + EveKeyPair.getPublicKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPublicKey()) + " N=" + EveKeyPair.getNKey() + " myPubKy=" + myPubKy);
            //System.out.println("Eve:SymmetricKey=" + EveKeyPair.getSymmetricKey() + " Length=" + EveKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getSymmetricKey()));
    }

    /**
     * *************************************************** ******
     */

    /* ************************** UTF Function *************/
    public static void SendPacketTCPUTFConsole(StringBuilder MyMessage, boolean EncryptFlag) throws Exception {
        if (socketSend.isBound() && (socketSend.isConnected())) {
            if (FirstTimeFlag == true) {
                System.out.println("Sender:SendPacketTCPConsole:Connected");
            }
            output = new DataOutputStream(socketSend.getOutputStream());
            StringBuilder MyMessage1 = new StringBuilder("");
            if (EncryptFlag == true) {
                MyMessage1 = SendTCPEncryptStrData(MyMessage);
                LocalDateTime current = LocalDateTime.now();
                //System.out.println("Sender:SendPacketTCP:Sending:Data:Time=" + current);
                output.writeUTF(MyMessage1.toString());
                //System.out.println("Sender:SendPacketTCP:Sent:Data:Time=" + current);
                output.flush();
                TCPEncryptedMesg = MyMessage1;
            } else if (EncryptFlag == false) {
                int beginindex = 0;
                int lastindex = SenderMesg.length() / UDPBuffLen;
                System.out.println("Sender:SendPacketTCPConsole:Sending:lastindex=" + lastindex);
                int oldLastIndex = 0;
                for (int i = 1; i <= SenderChunkNumber; i++) {
                    String EncryptedMesg1 = "";
                    if (i < SenderChunkNumber - 1) {
                        if ((beginindex >= 0) && (beginindex < lastindex * UDPBuffLen) && ((beginindex + UDPBuffLen) <= SenderMesg.length())) {
                            EncryptedMesg1 = SenderMesg.substring(beginindex, (beginindex + UDPBuffLen));
                            oldLastIndex = (beginindex + UDPBuffLen) + 1;
                            beginindex = (UDPBuffLen * i) + 1;
                        }
                        if (((EncryptedMesg1.equalsIgnoreCase(",#"))
                                || (EncryptedMesg1.equalsIgnoreCase("")))
                                && (EncryptedMesg1.length() <= 4)) {
                            i = SenderChunkNumber - 1;
                        }
                    } else if ((i == SenderChunkNumber)) {
                        EncryptedMesg1 = SenderMesg.substring(oldLastIndex);
                        beginindex = 0;
                    }
                    LocalDateTime current = LocalDateTime.now();
                    output.writeUTF(EncryptedMesg1);
                    output.flush();
                    TCPEncryptedMesg = new StringBuilder(EncryptedMesg1);
                }
            }
        } else {
            System.out.println("Sender:SendPacketTCPConsole:Connection refused");
        }

    }

    public static void SentValues() {
        System.out.println("****************** Sent Values Begin***************");
        System.out.println("Sender:1:Rand1Rotate=" + Rand1Rotate);
        System.out.println("Sender:2:OffsetRotate1=" + OffsetRotate1);
        System.out.println("Sender:3:StrlenRotate1=" + StrlenRotate1);
        System.out.println("Sender:4:OffsetRotate2=" + OffsetRotate2);
        System.out.println("Sender:5:StrlenRotate2=" + StrlenRotate2);
        System.out.println("Sender:6:UDPBuffLen=" + UDPBuffLen);
        System.out.println("Sender:7:MessageSize=" + MessageSize);
        System.out.println("Sender:8:WeiRand2=" + WeiRand2);
        System.out.println("Sender:9:WeiCharRand3=" + WeiCharRand3);
        System.out.println("Sender:10:MyPublicKey=" + AliceKeyPair.getPublicKey("Encrypt"));
        System.out.println("Sender:12:CyclicFlag=" + CyclicFlag);
        System.out.println("Sender:13:NumberOfTimes=" + NumberOfTimes);
        System.out.println("Sender:14:SuccessiveCharsLenSim=" + SuccessiveCharsLenSim);
        System.out.println("Sender:15:SuccessiveCharsIncrementSim=" + SuccessiveCharsIncrementSim);
        System.out.println("Sender:16:SuccessiveCharsLenWeiBull=" + SuccessiveCharsLenWeiBull);
        System.out.println("Sender:17:SuccessiveCharsIncrementWeiBull=" + SuccessiveCharsIncrementWeiBull);
        System.out.println("Sender:18:SuccessiveCharsLenRotate=" + SuccessiveCharsLenRotate);
        System.out.println("Sender:19:SuccessiveCharsIncrementRotate=" + SuccessiveCharsIncrementRotate);
        System.out.println("Sender:20:SuccessiveCharsLenJumble=" + SuccessiveCharsLenJumble);
        System.out.println("Sender:21:SuccessiveCharsIncrementJumble=" + SuccessiveCharsIncrementJumble);
        System.out.println("Sender:22:EavesdroppingFlag=" + EavesdroppingFlag);
        System.out.println("Sender:23:OccasionNoOfTimesIndex=" + OccasionNoOfTimesIndex);
        System.out.println("Sender:24:CalibrationSender=" + CalibrationSender);
        System.out.println("Sender:25:MesgINCAPS=" + MesgINCAPS);
        for (int i = 0; i < NumberOfTimes; i++) {
            System.out.println("Sender:26:ConfirmedFirstEvent=" + ConfirmedFirstEvent[i]);
            System.out.println("Sender:27:ConfirmedSecondEvent=" + ConfirmedSecondEvent[i]);
        }
        System.out.println("Sender:28:SenderStrTCPEncrypt=" + SenderStrTCPEncrypt);
        System.out.println("Sender:29:ActualChunksSent=" + ActualChunksSent);
        System.out.println("Sender:30:SenderMesg=" + EncryptedMesg);
        System.out.println("Sender:31:MyMessage=:" + MyMessage + ": len=" + MyMessage.length());
        System.out.println("Sender:32:MyMessage Length=: len=" + MyMessage.length());
        System.out.println("Sender:33:LayersOfSecurityEncrypt:=" + LayersOfSecurityEncrypt);
        System.out.println("****************** Sent Values End***************");
        Parameters();
    }

    /* ************* Testing Stub Sender *************** */
    public static void TestStageStubSender(boolean SilentFlag) {
        System.out.println("TestStageStubSender:Function=" + "TestStageStubSender");
        Rand1Rotate = OTPGeneratorClass.GenerateOTP(OTPLength);//(int) MySimpleWeiBull.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
        WeiRand2 = (double) OTPGeneratorClass.GenerateOTP(OTPLength);//(double) MySimpleWeiBull.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
        WeiCharRand3 = (double) OTPGeneratorClass.GenerateOTP(OTPLength);//(double) MySimpleWeiBull.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        for (int i = 0; i < (NumberOfTimes + 2); i++) {
            ConfirmedFirstEvent[i] = 0.0;
            ConfirmedSecondEvent[i] = 0.0;
        }
        PreEncryptBlock();
        //EncryptedMesg=FormatMessage();
        System.out.println("/************************** Encryption Begins *************** */");
        System.out.println("TestStagemain:Encryption Ends:CyclicFlag=" + CyclicFlag + ":NumberOfTimes=" + NumberOfTimes + ":SenderMesg=" + SenderMesg);
        //System.out.println("/************************** WorkFactorEncrypt Encryption Begins *************** */");
        EncryptStrFuncTimeTaken = "0.0";
        System.out.println("TestStagemain:Encryption:FuncTimeTaken:=" + (Double.parseDouble(EncryptStrFuncTimeTaken) * 1000) + " milliseconds");
        String[] MyCharDropped = SenderMesg.toString().split(",@");
        // UNCOMMENT LINES BELOW for low level Testing of Encryption
        StrlenRotate1 = MyCharDropped.length;
        OffsetRotate1 = Rand1Rotate % StrlenRotate1;
        // FUNCTIONS CALL BEGIN
        //EncryptedMesg = RotateStrEncrypt(EncryptedMesg, "Double", OffsetRotate1, StrlenRotate1,SilentFlag);
        //EncryptedMesg = JumbleStrEncrypt(EncryptedMesg, "Double", SilentFlag);
        //EncryptedMesg = FractionEncryptN(EncryptedMesg, SilentFlag);
        //EncryptedMesg = WorkFactorEncrypt(EncryptedMesg, Rand1Rotate, SilentFlag);
        // Diffusion Parameters
        // Surprise Parameters
        variablesEncrypt.put("diffusiond2", diffusiond2);
        variablesEncrypt.put("diffusionN", diffusionN);
        variablesEncrypt.put("confusionA", confusionA);
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        if ((MyPublicKey == null) || (MyPublicKey.equalsIgnoreCase(""))) {
            System.out.println("TestStageStubSender:FATAL ERROR:MyPublicKey=null");
        }
        if ((MyPrivateKey == null) || (MyPrivateKey.equalsIgnoreCase(""))) {
            System.out.println("TestStageStubSender:FATAL ERROR:MyPrivateKey=null");
        }
        WeibullEncrypt(SenderMesg.toString(), WeiRand2, WeiCharRand3, SilentFlag);
        StringBuilder NewEncryptedMesg = new StringBuilder(SenderMesg);
        StringBuilder NewEncryptedMesg1 = DiffusionJunkWeiBullEncrypt(NewEncryptedMesg, "Double", SilentFlag);
        SenderMesg = NewEncryptedMesg1;
        System.out.println("/************************** Encryption Ends *************** */");
    }

    public static void SenderAES() {
        try {
            DataOutputStream out = new DataOutputStream(socketSend.getOutputStream());
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey aesKey = keyGen.generateKey();

            // Load receiver's public RSA key (Base64 string for demo)
            String receiverPubKeyStr = "..."; // obtained securely
            byte[] pubBytes = Base64.getDecoder().decode(receiverPubKeyStr);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(pubBytes);
            PublicKey receiverPubKey = KeyFactory.getInstance("RSA").generatePublic(spec);

            // Encrypt AES key with RSA
            Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS5Padding");
            rsaCipher.init(Cipher.ENCRYPT_MODE, receiverPubKey);
            byte[] encryptedKey = rsaCipher.doFinal(aesKey.getEncoded());

            // Send encryptedKey over socket
            out.writeInt(encryptedKey.length);
            out.write(encryptedKey);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SendMeta(DataOutputStream out,
            SecretKey aesKey,
            String hostName,
            int port,
            String baselineISN,
            String messageISN,
            String ts,
            long timer) throws Exception {
        boolean SilentFlag = true;
        //SenderAES();
        DataOutputStream output = new DataOutputStream(socketSend.getOutputStream());
        String MyMessage1 = "" + User_SecretTCPOTP + ",|" + User_SecretSeedTCPLevel;
        byte[] data = MyMessage1.toString().getBytes("UTF-8");

        // Write length prefix first
        //System.out.println("mainObjectsCreationConsole:Sending length=" + data.length + " bytes");
        output.writeInt(data.length);

        // Write actual message bytes
        output.write(data);
        //System.out.println("mainObjectsCreationConsole:Sent=" + data.toString());
        output.flush();
        if (SilentFlag == false) {
            System.out.println("SendMeta:User_SecretTCPOTP=" + User_SecretTCPOTP + ":User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
        }
    }

    public static void sendMeta(DataOutputStream out,
            SecretKey aesKey,
            String hostName,
            int port,
            Long otp,
            long baselineISN,
            long messageISN,
            String ts,
            long timer) throws Exception {
        // --- Step 1: Meta-data packet ---
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);

        String metaPayload = "BASELINE_ISN:" + baselineISN
                + "|MESSAGE_ISN:" + messageISN
                + "|TS:" + ts
                + "|TIMER:" + timer
                + "|MAC:" + macAddr
                + "|OTP:" + otp;

        byte[] nonce = new byte[12];
        new SecureRandom().nextBytes(nonce);

//    String isnEquation = RFC6528ISNGenerator.messageEquation(
//        "127.0.0.1", port, hostName, port, ts, timer, otp, macAddr);
//    byte[] ctMeta = RFC6528ISNGenerator.encryptWithISN(aesKey, nonce,
//        metaPayload.getBytes("UTF-8"), isnEquation);
        byte[] ctMeta = User_SecretTCPOTP.toString().getBytes();
        byte[] ctMeta1 = User_SecretSeedTCPLevel.toString().getBytes();

        // Send nonce + ciphertext
        out.writeInt(nonce.length);
        out.write(nonce);
        out.writeInt(ctMeta.length);
        out.write(ctMeta);
        out.writeInt(ctMeta1.length);
        out.write(ctMeta1);
        out.flush();

//    // --- Step 2: ISN+payload packet ---
//    String msg = ISNHandler.attachMessage(new StringBuilder(payload), hostName, port, false);
//    byte[] payloadBytes = msg.getBytes("UTF-8");
//    out.writeInt(payloadBytes.length);
//    out.write(payloadBytes);
//    out.flush();
    }

    public static void ResetData() {
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
        if ((SenderMesg == null)) {
            SenderMesg = new StringBuilder("");
        }
        FOBRandomChar = "FOBStandardChar";
    }

    /**
     * *************************************************** ******
     */
    /**
     * *********** SENDER TAILORED EQUATIONS *********
     */
    /**
     * *************************************************** ******
     */
    // Make any changes to change the values of 
    //  of Security Encryption && Decryption
    // This function is used everywhere (Most Test Cases and Production )
    // Change the values as per the documentation(PoorMan's Security V 3.0.doc).
    // REMEMBER: Equations used in Decryption are not needed here
    // Only VerifyInverse function needs both eqns. 
    // It is not used in any other place.
    // This is a potential Security Leak.
    public static void UserStrings_Sender_Entropy() {
        boolean SilentFlag = false;
        variablesEncrypt.put("z", (double) zSecret);
        variablesEncrypt.put("s", (double) sSecret);
        variablesEncrypt.put("r", (double) rSecretValue);
        variablesEncrypt.put("m", diffusiond2);
        variablesEncrypt.put("c", diffusionN);
        variablesStr.put("z", "z");
        variablesStr.put("s", "s");
        variablesStr.put("m", "m");
        variablesStr.put("c", "c");
        // Equation Pair 1
        MySimpleWeiBull = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
        //HighLevel_Sender_Cycle();
        //VerifyInverse( EqnUnderTest,  "Xn",  InverseEqnUnderTest, "y");
        // Equation Pair 2
        // Confusion and Diffusion Parameters
        ExprnDiffusion = "Xn^2+2*Xn*c+c^2"; //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        DiffWithRespToDiffusion = "Xn";
        InvExprnDiffusion = "y^0.5-c";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        InvDiffusionDiffWithRespTo = "y";
        variablesEncrypt.put("c", diffusionN);
        variablesStr.put("c", "c");
        //VerifyInverse( ExprnDiffusion,  DiffWithRespToDiffusion,  InvExprnDiffusion, InvDiffusionDiffWithRespTo);
        // Equation Pair 3
        // Surprise Parameters
        ExprnSurprise = "Xn^diffusionN+2*Xn*diffusiond2+diffusiond2^diffusionN+0.2";
        ////y=(Xn+diffusiond2)^diffusionN;//y=(Xn+d2)^n; //y=Xn^2+2*Xn*d2+d2^2
        DiffWithRespToSurprise = "Xn";
        InvExprnSurprise = "y^confusionA-diffusiond2";
        InvSurpriseDiffWithRespTo = "y";
        // Static values
        diffusiond2 = 4.0;
        diffusionN = 2.0;
        confusionA = 1.0 / diffusionN;
        // Diffusion Parameters
        // Surprise Parameters
        variablesEncrypt.put("diffusiond2", diffusiond2);
        variablesEncrypt.put("diffusionN", diffusionN);
        variablesEncrypt.put("confusionA", confusionA);
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
        User_TCP_Equations_Entropy_MessageCycleT(ReadTCPPacketCount, SilentFlag);
        // Equation Pair 8
        TCPExprnDiffusion = "Xn^2+2*Xn*10+400";
        TCPDiffWithRespToDiffusion = "Xn";
        InverseTCPExprnDiffusion = "y^0.5-20";
        InverseTCPDiffusionDiffWithRespTo = "y";
        // Equation Pair 9
        TCPExprnSurprise = "Xn^2+2*Xn*10+100";
        InverseTCPExprnSurprise = "y^0.5-10";
//        // Debugging TCP Encryption
//        TCPEqnUnderTest = "Xn";//"3*Xn+100";
//        InverseTCPEqnUnderTest = "y";//(y-100)/3";
//        TCPExprnDiffusion = "Xn";
//        InverseTCPExprnDiffusion = "y";
//        TCPExprnSurprise = "Xn";
//        InverseTCPExprnSurprise = "y";

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
        UserStrings_Sender_Entropy();

    }

    public static long User_SecretValues(String layerType, long epoch, long timeStepSeconds, long Seed, long OTP) {
        long seed;
        if (layerType.equalsIgnoreCase("HighLevel")) {
            seed = Seed;
        } else if (layerType.equalsIgnoreCase("TCPLevel")) {
            seed = Seed;
        } else {
            seed = 0;
        }
        zSecret = 54;
        aSecret = 4;
        bSecret = 5;
        cSecret = 3;
        dSecret = 23;
        sSecret = 31;
        aSecretValue = 2;
        cSecretValue = 4;
        rSecretValue = 3;
        if ((SenderStrTCPEncrypt.equalsIgnoreCase("StrongA")) || (SenderStrTCPEncrypt.equalsIgnoreCase("None"))) {
            ; // Do Nothing
        } else if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongB")) {
            aSecretValue = 2;
            cSecretValue = 5;
        } else if (SenderStrTCPEncrypt.equalsIgnoreCase("Weak")) {
            aSecretValue = 2;
            cSecretValue = 3;
        }
        bSecretValue = 5;
        dSecretValue = 23;
        sSecretValue = 31;
        int i = 0;
        if ((EquationPairGeneration.seenSeedsSender.contains(seed)) && (i < 3) && (layerType.equalsIgnoreCase("TCPLevel"))) {
            OTP = OTPGeneratorClass.GenerateOTP(OTPLength);
            seed = OTP;
        } else if ((seenSeedsSender.contains(seed)) && (i < 3) && (!layerType.equalsIgnoreCase("HighLevel"))) {
            throw new IllegalArgumentException("Known seed:seed=" + seed);
        }
        while ((!seenSeedsSender.contains(seed)) && (i < 3)) {
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
            if (seenSeedsSender.add(seed)) {
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

    public static void User_TCP_Equations_Entropy_MessageCycleT(int ReadTCPPacketCount, boolean SilentFlag) {
        try {
            long epoch = System.nanoTime();
            long timeStepSeconds = 30;
            User_SecretTCPOTP = (long) OTPGeneratorClass.GenerateOTP(OTPLength);
            User_SecretSeedTCPLevel = User_SecretValues("TCPLevel", epoch, timeStepSeconds, User_SecretSeedTCPLevel, User_SecretTCPOTP);
            if (SilentFlag == false) {
                System.out.println("User_TCP_Equations_Entropy_MessageCycleT:User_SecretTCPOTP=" + User_SecretTCPOTP + " ReadTCPPacketCount=" + ReadTCPPacketCount + ":User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
            }
            TCPEqnUnderTestStrongA = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseTCPEqnUnderTestStrongA = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//"y^0.5/m-c/m";   //x="y^0.5*n/m-2.0*n/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
            //System.out.println("UserStrings_Receiver:TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + " InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
            TCPEqnUnderTestStrongB = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.expandAmXnEquation(2, 3, 5/*(int)myPubKy*/,2);      //y=(2*x+3)^myPubKy;
            InverseTCPEqnUnderTestStrongB = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.inverseAmXnEquation(2, 3, 5/*(int)myPubKy*/,2); //x="y^1/myPubKy/2-3.0/2";
            //System.out.println("UserStrings_Receiver:TCPEqnUnderTestStrongB=" + TCPEqnUnderTestStrongB + " InverseTCPEqnUnderTestStrongB=" + InverseTCPEqnUnderTestStrongB);

            TCPEqnUnderTestWeakBinomial = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);      //y=(2*x+3)^4
            InverseTCPEqnUnderTestWeakBinomial = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);
            //System.out.println("UserStrings_Receiver:TCPEqnUnderTestWeakBinomial=" + TCPEqnUnderTestWeakBinomial + " InverseTCPEqnUnderTestWeakBinomial=" + InverseTCPEqnUnderTestWeakBinomial);

            TCPEqnUnderTestWeak = PSACOTPEquation.buildOTPEquation("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.expandAmXnEquation(2,3,4,  2);//y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseTCPEqnUnderTestWeak = PSACOTPEquation.buildOTPInverse("TCPLevel", User_SecretSeedTCPLevel, User_SecretTCPOTP);//PSAEquationSuite.inverseAmXnEquation(2,3,4,  2);//"y^0.5/m-c/m"; 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(ConsoleColors.RED + "Sender:Enryption System Wrong" + ConsoleColors.RESET);
            System.out.println("Sender_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":User_SecretTCPOTP=" + User_SecretTCPOTP + ":User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
        }
        if (SilentFlag == false) {
            //if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongA")){
            System.out.println("Sender_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + ":InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
            //}else if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongB")){
            System.out.println("Sender_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongB=" + TCPEqnUnderTestStrongB + ":InverseTCPEqnUnderTestStrongB=" + InverseTCPEqnUnderTestStrongB);
            //}else if (SenderStrTCPEncrypt.equalsIgnoreCase("Weak")){
            System.out.println("Sender_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak + ":InverseTCPEqnUnderTestWeak=" + InverseTCPEqnUnderTestWeak);
            //}else if (SenderStrTCPEncrypt.equalsIgnoreCase("None")){
            System.out.println("Sender_MessageCycleTPlus1:ReadTCPPacketCount=" + ReadTCPPacketCount + ":TCPEqnUnderTestStrongA=" + TCPEqnUnderTestStrongA + ":InverseTCPEqnUnderTestStrongA=" + InverseTCPEqnUnderTestStrongA);
            //}
        }
    }

    public static void HighLevel_Sender_Cycle() {
        boolean SilentFlag = true;
        long epoch = System.nanoTime();
        long timeStepSeconds = 30;
        User_SecretTCPOTP = (long) OTPGeneratorClass.GenerateOTP(OTPLength);
        User_SecretHighOTP = OTPGeneratorClass.GenerateOTP(OTPLength);
        User_SecretSeedHighLevel = User_SecretValues("HighLevel", epoch, timeStepSeconds, User_SecretSeedHighLevel, User_SecretHighOTP);
        User_SecretSeedTCPLevel = User_SecretValues("TCPLevel", epoch, timeStepSeconds, User_SecretSeedTCPLevel, User_SecretTCPOTP);
        InitialMsgEncryptState_HighOTP = User_SecretHighOTP;
        InitialMsgEncryptState_SecretSeed = User_SecretSeedHighLevel;
        if (SilentFlag == false) {
            System.out.println("HighLevel_Sender_Cycle:User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
            System.out.println("HighLevel_Sender_Cycle:User_SecretHighOTP=" + User_SecretHighOTP + " User_SecretTCPOTP=" + User_SecretTCPOTP);
            System.out.println("HighLevel_Sender_Cycle:InitialMsgEncryptState_HighOTP=" + InitialMsgEncryptState_HighOTP + " InitialMsgEncryptState_SecretSeed=" + InitialMsgEncryptState_SecretSeed);
        }
        try {
            EqnUnderTest = PSACOTPEquation.buildOTPEquation("HighLevel", InitialMsgEncryptState_SecretSeed, InitialMsgEncryptState_HighOTP);//PSAEquationSuite.expandAmXnEquation((int)rSecretValue);// "m^2*Xn^2+2*m*Xn*c+c^2";    
            InverseEqnUnderTest = PSACOTPEquation.buildOTPInverse("HighLevel", InitialMsgEncryptState_SecretSeed, InitialMsgEncryptState_HighOTP);//PSAEquationSuite.inverseAmXnEquation((int)rSecretValue);//"y^0.5/m-c/m"; ;
        } catch (Exception e) {
            e.printStackTrace();
            EqnUnderTest = PSACEquationFactory.buildEquation(2);
            InverseEqnUnderTest = PSACEquationFactory.buildInverse(2);
        }
        if (SilentFlag == false) {
            System.out.println("HighLevel_Sender_Cycle:User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretSeedTCPLevel=" + User_SecretSeedTCPLevel);
            System.out.println("HighLevel_Sender_Cycle:User_SecretHighOTP=" + User_SecretHighOTP + " User_SecretTCPOTP=" + User_SecretTCPOTP);
            System.out.println("HighLevel_Sender_Cycle:InitialMsgEncryptState_HighOTP=" + InitialMsgEncryptState_HighOTP + " InitialMsgEncryptState_SecretSeed=" + InitialMsgEncryptState_SecretSeed);
            System.out.println("HighLevel_Sender_Cycle:EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
        }
    }
}
