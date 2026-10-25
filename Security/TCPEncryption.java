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

import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.parse;
import static Security.Decryption.TCPCharTerminatorString;
import static Security.EquationPairGeneration.DiffWithRespToDiffusion;
import static Security.EquationPairGeneration.DiffWithRespToSurprise;
import static Security.EquationPairGeneration.ExprnDiffusion;
import static Security.EquationPairGeneration.ExprnSurprise;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.eSecretValue;
import static Security.EquationPairGeneration.pSecretValue;
import static Security.PSACKeyVaultNew.KeyCombinationEqnTCP;
import static Security.LowLevelSecurityFramework.ShannonEncryption;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.CConstant;
import static Security.Security.EncryptedByte;
import static Security.Security.Equation1;
import static Security.Security.MDivisorTCP;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.Mychar;
import static Security.Security.constant;
import static Security.Security.mult_div;
import static Security.Security.variablesEncrypt;
import static SenderReceiverGUI.Sender.FirstTimeFlag;
import static SenderReceiverGUI.Sender.FirstTimeFlagTCPOptimised;
import static SenderReceiverGUI.Sender.SenderStrTCPEncrypt;
import static SenderReceiverGUI.Sender.SenderTCPEncrypt;
import static SenderReceiverGUI.Sender.TCPDiffWithRespToDiffusion;
import static SenderReceiverGUI.Sender.TCPEncryptedMesg;
import static SenderReceiverGUI.Sender.TCPEqnUnderTestStrongA;
import static SenderReceiverGUI.Sender.TCPEqnUnderTestStrongB;
import static SenderReceiverGUI.Sender.TCPEqnUnderTestWeak;
import static SenderReceiverGUI.Sender.TCPExprnDiffusion;
import static SenderReceiverGUI.Sender.TCPExprnSurprise;
import static SenderReceiverGUI.Sender.hostName;
import static SenderReceiverGUI.Sender.output;
import static SenderReceiverGUI.Sender.outputPWR;
import static SenderReceiverGUI.Sender.port;
import static SenderReceiverGUI.Sender.socketSend;
import static SenderReceiverGUI.SenderGUI.StrGUI;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class TCPEncryption {

    public static Logger log = Logger.getLogger(TCPEncryption.class.getName());
    private static String HyperSuperSecretDelimiter = "Hyper Super Delimiter@2026!";

    public static void makeConnectionSender() {
        try {
            if ((StrGUI.equalsIgnoreCase("Console")) && (FirstTimeFlag == true)) {
                System.out.print("Receiver hostName/IP address[localhost]=" + hostName);
                System.out.print(" : Your Choice [" + hostName + "]:");
                Scanner scanner = new Scanner(System.in);
                String TempxExprn = scanner.nextLine();
                if (TempxExprn.equalsIgnoreCase("")) {
                    ;
                } else {
                    hostName = TempxExprn;
                }
                System.out.print("Receiver Port[" + port + "]:");
                System.out.print(" Your Choice:");
                TempxExprn = scanner.nextLine();
                if (TempxExprn.equalsIgnoreCase("")) {
                    ;
                } else {
                    port = Integer.parseInt(TempxExprn);
                }
                FirstTimeFlag = false;
            } else if ((StrGUI.equalsIgnoreCase("GUI")) && (FirstTimeFlag == true)) {
                System.out.print("Receiver hostName/IP address[localhost]=" + hostName);
                System.out.print(" : Your Choice [" + hostName + "]:");

                System.out.print("Receiver Port[" + port + "]=");
                System.out.print(" Your Choice:");
                FirstTimeFlag = false;
            } else if ((StrGUI.equalsIgnoreCase("GUI")) && (FirstTimeFlag == false)) {
                System.out.println("Receiver Settings:hostName=" + hostName + " port=" + port);
                System.out.println("Receiver Settings:Waiting:");
            }
            //System.out.println("Receiver Settings:hostName=" + hostName + " port=" + port);
            //System.out.println("Sender:Start makeConnectionSender");
            if ((socketSend == null) || (socketSend.isClosed())) {
                socketSend = new Socket(hostName, port);
            }
            if (FirstTimeFlagTCPOptimised) {
                // Enable TCP_NODELAY (disable Nagle’s algorithm for low latency)
                socketSend.setTcpNoDelay(true);

                // Increase send/receive buffer sizes
                socketSend.setSendBufferSize(16 * 1024 * 1024); // 16 MB
                socketSend.setReceiveBufferSize(16 * 1024 * 1024); // 1

                // Enable keep-alive
                socketSend.setKeepAlive(true);
                System.out.println("Sender:makeConnectionSender:TCP Optimised");
                FirstTimeFlagTCPOptimised=false;
            }
        } catch (Exception MyException) {
            System.out.println("Exception:makeConnectionSender:MyException=" + MyException);
            MyException.printStackTrace();
        }
    }

    /**
     * *********** SENDER GUI LOW LEVEL TCP FUNCTIONS *********
     */
    public static void TearDown() {
        try {
            if (outputPWR != null) {
                outputPWR.flush();
                outputPWR.close();
                outputPWR = null;
            }
            if (output != null) {
                output.flush();
                output.close();
                output = null;
            }
            if (socketSend != null) {
                socketSend.close();
            }
            socketSend = null;
            
            System.out.println("Sender:Closed Socket");
        } catch (Exception MyException) {
            System.out.println("Exception:TearDown:MyException=" + MyException);
            MyException.printStackTrace();
        }
    }

    public static void pmain(String[] args) throws Exception {
        String MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:!@#$%^&*()+={}[];><,./?|\\";
        byte[] buffer = MyMessage.getBytes();
        System.out.println("Sender:");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, new InetSocketAddress("localhost", 5002));
        DatagramSocket socket = new DatagramSocket(5003);
        System.out.println("Sender:Just Before send Packet");
        socket.send(packet);

        System.out.println("Sender:sent Packet:=");
        //for(int i=0; i < buffer.length;i++){
        //    System.out.format("%c", buffer[i]);
        //}
        System.out.println(new String(buffer));
        System.out.println("Sender:Second Time:Packet");
        socket.send(packet);
        socket.close();
        System.out.println("Sender:Closed Socket");
        TearDown();
    }

    public static StringBuilder SendTCPEncryptStrData(StringBuilder MyMessage) {
        StringBuilder MyMessage1 = new StringBuilder("");
        TCPEncryptedMesg = new StringBuilder("");
        //System.out.println("SendTCPEncryptStrData:Before StrongA:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        if ((SenderTCPEncrypt == true) && ((SenderStrTCPEncrypt.equalsIgnoreCase("StrongA")) || (SenderStrTCPEncrypt.equalsIgnoreCase("StrongB")))) {//Encrypted
            if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongA")) {
                KeyCombinationEqnTCP = "pubkey+privkey";
                MyPublicEquation = new String(TCPEqnUnderTestStrongA);
            } else if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongB")) {
                KeyCombinationEqnTCP = "privkey";
                MyPublicEquation = new String(TCPEqnUnderTestStrongB);
            }
            MyPublicKey = BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey();
            MyPrivateKey = AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey();
            Double initMDivisor = 10E10;
            Double initCConstant = 20000.0;
            Double initmult_div = 1.0;
            Double initconstant = 20000.0;
            CConstant = initCConstant;
            mult_div = initmult_div;
            constant = initconstant;
            Calibration.ContextSetChar4TCP(MyPublicEquation, "CharEncrypt", "Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);

            for (int i = 0; i < MyMessage.length(); i++) {
                TCPEncryptStrong((MyMessage.charAt(i) * 1.0), true, ExprnDiffusion, DiffWithRespToDiffusion, ExprnSurprise, DiffWithRespToSurprise);
            }
            MyMessage1 = TCPEncryptedMesg;
            //System.out.println("SendTCPEncryptStrData:MyMessage1=" + MyMessage1);
        } else if ((SenderTCPEncrypt == true) && (SenderStrTCPEncrypt.equalsIgnoreCase("Weak"))) {//Encrypted
            MyMessage1 = SendTCPEncryptStrDataWeak(MyMessage);
            //MyMessage1 = TCPEncryptedMesg;
            //System.out.println("SendTCPEncryptStrData:MyMessage1=" + MyMessage1);  
        } else if ((SenderTCPEncrypt == false) && (SenderStrTCPEncrypt.equalsIgnoreCase("None"))) {//TCP Alone Encrypted

            KeyCombinationEqnTCP = "pubkey+privkey";
            MyPublicEquation = new String(TCPEqnUnderTestStrongA);
            MyPublicKey = BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey();
            MyPrivateKey = AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey();
            Double initMDivisor = 10E10;
            Double initCConstant = 20000.0;
            Double initmult_div = 1.0;
            Double initconstant = 20000.0;
            CConstant = initCConstant;
            mult_div = initmult_div;
            constant = initconstant;
            //System.out.println("SendTCPEncryptStrData:Before ContextSetChar4TCP:MyPublicEquation:"+ MyPublicEquation);
            Calibration.ContextSetChar4TCP(MyPublicEquation, "CharEncrypt", "Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
            //System.out.println("SendTCPEncryptStrData:Before:variables:");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));
            for (int i = 0; i < MyMessage.length(); i++) {
                TCPEncryptStrong((MyMessage.charAt(i) * 1.0), true, ExprnDiffusion, DiffWithRespToDiffusion, ExprnSurprise, DiffWithRespToSurprise);
            }
//            variables.remove("n");
//            variables.remove("c");
//            variables.remove("m");
//            variables.remove("privkey");
//            variables.remove("pubkey");
            MyMessage1 = TCPEncryptedMesg;
            //System.out.println("SendTCPEncryptStrData:MyMessage1=" + MyMessage1);
            //System.out.println("SendTCPEncryptStrData:After:variables:");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));
        }
        return MyMessage1;
    }

    static StringBuilder SendTCPEncryptStrDataWeak(StringBuilder MyMessage) {
        StringBuilder MyMessage1 = new StringBuilder("");
        TCPEncryptedMesg = new StringBuilder("");
        //System.out.println("SendTCPEncryptStrDataWeak:Before Weak:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        if ((SenderTCPEncrypt == true) && (SenderStrTCPEncrypt.equalsIgnoreCase("Weak"))) {//TCP Alone Encrypted

            KeyCombinationEqnTCP = "pubkey+privkey";
            MyPublicEquation = new String(TCPEqnUnderTestWeak);//TCPEqnUnderTestWeak;//TCPEqnUnderTestWeakBinomial;
            //System.out.println("SendTCPEncryptStrDataWeak:MyPublicEquation="+ MyPublicEquation + " TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak);
            MyPublicKey = BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey();
            MyPrivateKey = AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey();
            Double initMDivisor = 10E10;
            Double initCConstant = 20000.0;
            Double initmult_div = 1.0;
            Double initconstant = 20000.0;
            CConstant = initCConstant;
            mult_div = initmult_div;
            constant = initconstant;
            //System.out.println("SendTCPEncryptStrDataWeak:Before ContextSetChar4TCP:MyPublicEquation="+ MyPublicEquation + " TCPEqnUnderTestWeak=" + TCPEqnUnderTestWeak);
            Calibration.ContextSetChar4TCPWeak(MyPublicEquation, "CharEncrypt", "Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
            //System.out.println("SendTCPEncryptStrData:Before TCPEncryptStrong:variables:");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));
            for (int i = 0; i < MyMessage.length(); i++) {
                TCPEncryptStrong((MyMessage.charAt(i) * 1.0), true, ExprnDiffusion, DiffWithRespToDiffusion, ExprnSurprise, DiffWithRespToSurprise);
            }
//            variables.remove("n");
//            variables.remove("c");
//            variables.remove("m");
//            variables.remove("privkey");
//            variables.remove("pubkey");
            MyMessage1 = TCPEncryptedMesg;
            //System.out.println("SendTCPEncryptStrData:MyMessage1=" + MyMessage1);
            //System.out.println("SendTCPEncryptStrData:After:variables:");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));
        }
        return MyMessage1;
    }

    public static void TCPEncrypt(Double i, boolean SilentFlag, String ExprnDiffusion, String DiffWithRespToDiffusion, String ExprnSurprise, String DiffWithRespToSurprise) {
        //SilentFlag=false;
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        if (SilentFlag == false) {
            System.out.println("TCPEncrypt:Initial:i=" + i);
            System.out.println("TCPEncrypt:Initial:MyPublicEquation=" + MyPublicEquation);
            System.out.println("TCPEncrypt:Initial:Xn=" + "Xn");
        }
        Value = ShannonEncryption("MessageShannonSimple", i, MyPublicEquation, "Xn");
        if (SilentFlag == false) {
            System.out.println("TCPEncrypt:After Initial:Value=" + Value);
        }
        if ((SenderTCPEncrypt == true) && (SenderStrTCPEncrypt.equalsIgnoreCase("Weak"))) {
            ValueDiffusion = Value;//Do Nothing
        } else {
            ValueDiffusion = ShannonEncryption("MessageShannonSimple", Value, TCPExprnDiffusion, TCPDiffWithRespToDiffusion);
        }
        if (ValueDiffusion != 0.0) {
            Value = ValueDiffusion;
        }
        if (SilentFlag == false) {
            System.out.println("TCPEncrypt:After Diffusion:Value=" + Value + " ValueDiffusion=" + ValueDiffusion);
            System.out.println("TCPEncrypt:After Diffusion:ExprnSurprise=" + ExprnSurprise);
            System.out.println("TCPEncrypt:After Diffusion:DiffWithRespToSurprise=" + DiffWithRespToSurprise);
        }
        if ((SenderTCPEncrypt == true) && (SenderStrTCPEncrypt.equalsIgnoreCase("Weak"))) {

        } else {
            ValueSurprise = ShannonEncryption("MessageShannonSimple", Value, TCPExprnSurprise, DiffWithRespToSurprise);
        }
        if (ValueSurprise != 0.0) {
            Value = ValueSurprise;
        }

        if (SilentFlag == false) {
            System.out.println("TCPEncrypt:After Surprise:Value=" + Value + " ValueSurprise=" + ValueSurprise);
            System.out.println("TCPEncrypt:After ShannonEncryptSBox:Value=" + Value);
        }
        String EncryptedExprn = TCPEncryptedMesg.toString();
        StringBuilder NewEncryptedMesg = TCPEncryptedMesg;
        String Str1 = Value.toString();
        if ((EncryptedExprn.endsWith(TCPCharTerminatorString)) && (Str1.endsWith(TCPCharTerminatorString)) && (Str1.startsWith(TCPCharTerminatorString))) {
            NewEncryptedMesg.append(Str1);
        } else if ((!EncryptedExprn.endsWith(TCPCharTerminatorString)) && (Str1.endsWith(TCPCharTerminatorString)) && (!Str1.startsWith(TCPCharTerminatorString))) {
            NewEncryptedMesg.append(TCPCharTerminatorString).append(Str1);
        } else if ((!EncryptedExprn.endsWith(TCPCharTerminatorString)) && (!Str1.endsWith(TCPCharTerminatorString)) && (!Str1.startsWith(TCPCharTerminatorString))) {
            NewEncryptedMesg.append(TCPCharTerminatorString).append(Str1).append(TCPCharTerminatorString);
        } else if ((!EncryptedExprn.endsWith(TCPCharTerminatorString)) && (Str1.endsWith(TCPCharTerminatorString)) && (!Str1.startsWith(TCPCharTerminatorString))) {
            NewEncryptedMesg.append(TCPCharTerminatorString).append(Str1);
        } else if ((EncryptedExprn.endsWith(TCPCharTerminatorString)) && (!Str1.endsWith(TCPCharTerminatorString))) {
            NewEncryptedMesg.append(Str1).append(TCPCharTerminatorString);
        } else if ((EncryptedExprn.endsWith(TCPCharTerminatorString)) && (Str1.endsWith(TCPCharTerminatorString)) && (!Str1.startsWith(TCPCharTerminatorString))) {
            NewEncryptedMesg.append(Str1);
        }
        if (NewEncryptedMesg.toString().startsWith(TCPCharTerminatorString)) {
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceFirst(TCPCharTerminatorString, ""));
        }
        TCPEncryptedMesg = NewEncryptedMesg;
        if (SilentFlag == false) {
            System.out.println("TCPEncrypt:Final:TCPEncryptedMesg=" + TCPEncryptedMesg);
        }
    }

    public static void TCPEncryptStrong(Double i, boolean SilentFlag, String ExprnDiffusion, String DiffWithRespToDiffusion, String ExprnSurprise, String DiffWithRespToSurprise) {
        //SilentFlag=false;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        Double Value = ShannonEncryptSBoxTCP(i, SilentFlag);
        String EncryptedExprn = TCPEncryptedMesg.toString();
        StringBuilder NewEncryptedMesg = TCPEncryptedMesg;
        String Str1 = Value.toString();
        if ((EncryptedExprn.endsWith(",:")) && (Str1.endsWith(",:")) && (Str1.startsWith(",:"))) {
            NewEncryptedMesg.append(Str1);
        } else if ((!EncryptedExprn.endsWith(",:")) && (Str1.endsWith(",:")) && (!Str1.startsWith(",:"))) {
            NewEncryptedMesg.append(",:").append(Str1);
        } else if ((!EncryptedExprn.endsWith(",:")) && (!Str1.endsWith(",:")) && (!Str1.startsWith(",:"))) {
            NewEncryptedMesg.append(",:").append(Str1).append(",:");
        } else if ((!EncryptedExprn.endsWith(",:")) && (Str1.endsWith(",:")) && (!Str1.startsWith(",:"))) {
            NewEncryptedMesg.append(",:").append(Str1);
        } else if ((EncryptedExprn.endsWith(",:")) && (!Str1.endsWith(",:"))) {
            NewEncryptedMesg.append(Str1).append(",:");
        } else if ((EncryptedExprn.endsWith(",:")) && (Str1.endsWith(",:")) && (!Str1.startsWith(",:"))) {
            NewEncryptedMesg.append(Str1);
        }
        if (NewEncryptedMesg.toString().startsWith(",:")) {
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceFirst(",:", ""));
        }
        TCPEncryptedMesg = NewEncryptedMesg;
        if (SilentFlag == false) {
            System.out.println("TCPEncrypt:Final:TCPEncryptedMesg=" + TCPEncryptedMesg);
        }
    }

    public static Double ShannonEncryptSBoxTCP(Double i, boolean SilentFlag) {
        Double Value = 0.0;
        Mychar = i;
        //ContextSetChar4TCP(MyPublicEquation, "CharEncrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        if (SilentFlag == false) {
            System.out.println("ShannonEncryptSBoxTCP:After ContextSetMesg:Mychar=" + Mychar + " Mychar(char)=" + (char) Mychar.byteValue());
        }
        //System.out.println("ShannonEncryptSBoxTCP:Before EncryptPKIValuesTCP:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        Value = EncryptPKIValuesTCP(Mychar.intValue(), MDivisorTCP, CConstant, constant, SilentFlag);
        //System.out.println("ShannonEncryptSBoxTCP:After EncryptPKIValuesTCP:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        if (SilentFlag == false) {
            System.out.println("ShannonEncryptSBoxTCP:After Surprise:Value=" + Value);
        }
        return Value;
    }
    // Values Encryption

    public static Double EncryptPKIValuesTCP(int Mychar, Double MDivisor, Double CConstant, Double constant, boolean SilentFlag) {
        String MyDiffWithRespTo = "Xn";
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        Equation1 = new MathsRelations();
        Equation1.SetDiffWithRespTo(MyDiffWithRespTo);
        if (SilentFlag == false) {
            System.out.println("Sender:EncryptPKIValuesTCP:MyPublicEquation=" + MyPublicEquation + ":KeyCombinationEqnTCP=" + KeyCombinationEqnTCP);
        }
        variablesEncrypt.put("n", 1.0E280);
        if ((MyPublicKey != null) && (!MyPublicKey.equalsIgnoreCase(""))) {
            variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        }
        if ((MyPrivateKey != null) && (!MyPrivateKey.equalsIgnoreCase(""))) {
            variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }
        EncryptedByte = 0.0;
        //System.out.println("Sender:EncryptPKIValuesTCP:Before parse:KeyCombinationEqnTCP:KeyCombinationEqnTCP=" + KeyCombinationEqnTCP);
        //System.out.println("Sender:EncryptPKIValuesTCP:Before parse:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        LCGexpValue = parse(KeyCombinationEqnTCP, variablesEncrypt, MyDiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
        //System.out.println("Sender:EncryptPKIValuesTCP:After parse:LCGexpValue:LCGexpValue=" + LCGexpValue.eval());
        variablesEncrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesEncrypt.put("c", 1.0 * (constant + CConstant));
        if (SilentFlag == false) {
            System.out.println("Sender:EncryptPKIValuesTCP:Equation1:m=" + variablesEncrypt.get("m") + " n=" + variablesEncrypt.get("n") + " c=" + variablesEncrypt.get("c") + " MDivisor=" + MDivisor + " CConstant=" + CConstant + " constant=" + constant + " MyPublicEquation=" + MyPublicEquation + " Mychar=" + Mychar);
        }
        variablesEncrypt.put(MyDiffWithRespTo, Mychar * 1.0);
        variablesEncrypt.put("d", (double) dSecretValue);
        variablesEncrypt.put("e", (double) eSecretValue);
        variablesEncrypt.put("p", (double) pSecretValue);
        //System.out.println("Sender:EncryptPKIValuesTCP:Before Equation1:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        Mychar = (variablesEncrypt.get(MyDiffWithRespTo)).intValue();

        Equation1.initExprn(MyPublicEquation, variablesEncrypt, MyDiffWithRespTo);

        EncryptedByte = Equation1.CalculateExprn();
        if (SilentFlag == false) {
            System.out.println("Sender:EncryptPKIValuesTCP:Equation1:EncryptedByte=" + EncryptedByte + " plainText=" + variablesEncrypt.get(MyDiffWithRespTo) + " char=" + (char) Mychar);
        }
//        variables.remove(MyDiffWithRespTo);
//        variables.remove("n");
//        variables.remove("c");
//        variables.remove("m");
//        variables.remove("privkey");
//        variables.remove("pubkey");
        return EncryptedByte;
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
}
