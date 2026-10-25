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
import static Security.EquationPairGeneration.InvDiffusionDiffWithRespTo;
import static Security.EquationPairGeneration.InvSurpriseDiffWithRespTo;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.eSecretValue;
import static Security.EquationPairGeneration.pSecretValue;
import static Security.PSACKeyVaultNew.KeyCombinationEqnTCP;
import static Security.LowLevelSecurityFramework.ShannonDecryption;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.CConstant;
import static Security.Security.DecryptedByte;
import static Security.Security.Equation1;
import static Security.Security.MDivisorTCP;
import static Security.Security.MaliciousMalloryAlice;
import static Security.Security.MaliciousMalloryBob;
import static Security.Security.MyDecrptionEquation;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.constant;
import static Security.Security.mult_div;
import static Security.Security.variablesDecrypt;
import static SenderReceiverGUI.Receiver.FirstTimeFlag;
import static SenderReceiverGUI.Receiver.FirstTimeFlagTCPOptimised;
import static SenderReceiverGUI.Receiver.InverseTCPDiffusionDiffWithRespTo;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestStrongA;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestStrongB;
import static SenderReceiverGUI.Receiver.InverseTCPEqnUnderTestWeak;
import static SenderReceiverGUI.Receiver.InverseTCPExprnDiffusion;
import static SenderReceiverGUI.Receiver.InverseTCPExprnSurprise;
import static SenderReceiverGUI.Receiver.ReceiverStrTCPDecrypt;
import static SenderReceiverGUI.Receiver.ReceiverTCPDecrypt;
import static SenderReceiverGUI.Receiver.hostName;
import static SenderReceiverGUI.Receiver.input;
import static SenderReceiverGUI.Receiver.port;
import static SenderReceiverGUI.Receiver.server;
import static SenderReceiverGUI.Receiver.socketReceiver;
import static SenderReceiverGUI.ReceiverGUI.StrGUI;
import static SenderReceiverGUI.Receiver.TCPDecryptedMesg;
import static SenderReceiverGUI.Receiver.inputScannerCommReadStrCommon;
import java.net.ServerSocket;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class TCPDecryption {

    public static Logger log = Logger.getLogger(TCPDecryption.class.getName());
    private static String HyperSuperSecretDelimiter = "Hyper Super Delimiter@2026!";

    public static void makeConnectionReceiv() {
        try {
            System.out.println("Receiver:Opening Socket");
            if ((StrGUI.equalsIgnoreCase("Console")) && (FirstTimeFlag == true)) {
                System.out.print("Sender hostName/IP address[localhost]=" + hostName);
                System.out.print(" : Your Choice [" + hostName + "]:");
                Scanner scanner = new Scanner(System.in);
                String TempxExprn = null;
                TempxExprn = scanner.nextLine();
                if (TempxExprn.equalsIgnoreCase("")) {
                    ;
                } else {
                    hostName = TempxExprn;
                }
                if (FirstTimeFlag == true) {
                    System.out.print("Sender Port[" + port + "]=");
                    System.out.print(" Your Choice:");
                    TempxExprn = scanner.nextLine();
                    if (TempxExprn.equalsIgnoreCase("")) {
                        ;
                    } else {
                        port = Integer.parseInt(TempxExprn);
                    }
                    FirstTimeFlag = false;
                }
            } else if ((StrGUI.equalsIgnoreCase("GUI")) && (FirstTimeFlag == true)) {
                System.out.print("Sender hostName/IP address[localhost]=" + hostName);
                System.out.print(" : Your Choice [" + hostName + "]:");
                System.out.print("Sender Port[" + port + "]=");
                System.out.print(" Your Choice:");
                FirstTimeFlag = false;
            }

            System.out.println("Receiver Settings:hostName=" + hostName + " port=" + port);
            if ((socketReceiver != null) && (socketReceiver.isBound()) && (socketReceiver.isConnected())) {
                System.out.println("Receiver:makeConnectionReceiv:1:Listening");
                while ((inputScannerCommReadStrCommon != null) && (!inputScannerCommReadStrCommon.hasNext())) {
                    System.out.println("Receiver:makeConnectionReceiv:2:Listening");
                    //Thread.sleep(10000);
                }
            } else if ((socketReceiver == null) && (server != null) && (FirstTimeFlag == false)) {
                System.out.println("Receiver:makeConnectionReceiv:3:Listening");
                socketReceiver = server.accept();
            } else if (((socketReceiver == null) || (socketReceiver.isClosed()))) {
                System.out.println("Receiver:makeConnectionReceiv:4:Listening");
                server = new ServerSocket(port);
                if ((server != null) && ((socketReceiver != null) && (socketReceiver.isClosed()) || ((socketReceiver != null) && (socketReceiver.isConnected()) && (FirstTimeFlag == false)))) {
                    // RESET Button State
                    socketReceiver = server.accept();
                    // Listen Button State
                } else if ((server != null) && ((socketReceiver == null))) {
                    // RESET Button State
                    //Thread.sleep(1000);
                    socketReceiver = server.accept();
                                       // Listen Button State
                }
            }
            // Apply TCP-level optimizations
             // Enable address reuse for faster restarts
            if (FirstTimeFlagTCPOptimised) {
                socketReceiver.setReuseAddress(true);
                socketReceiver.setTcpNoDelay(true); // Disable Nagle’s algorithm
                //socketReceiver.setSendBufferSize(16 * 1024 * 1024); // 16 MB
                socketReceiver.setReceiveBufferSize(16 * 1024 * 1024); // 16 MB
                socketReceiver.setKeepAlive(true);
                System.out.println("Receiver:makeConnectionReceiv:TCP Optimised");
                FirstTimeFlagTCPOptimised=false;
            }
        } catch (Exception MyException) {
            System.out.println("Exception:makeConnectionReceiv:MyException=" + MyException);
            MyException.printStackTrace();
        }
    }

    public static void TearDown() {
        try {
            if (input != null) {
                input.close();
                input = null;
            }
            if (socketReceiver != null) {
                socketReceiver.close();
            }
            socketReceiver = null;
            if (server != null) {
                server.close();
            }
            server = null;
            System.out.println("Receiver:Closed Socket");
        } catch (Exception MyException) {
            System.out.println("Exception:MyException=" + MyException);
            MyException.printStackTrace();
        }
    }

    public static StringBuilder TCPDecryptStrData(StringBuilder ResultStr) {
        StringBuilder MyMessage1 = new StringBuilder("");
        TCPDecryptedMesg = "";
        if ((ReceiverTCPDecrypt == true) && ((ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA")) || (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB")))) {//Encrypted
            if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA")) {
                KeyCombinationEqnTCP = "pubkey+privkey";
                MyDecrptionEquation = new String(InverseTCPEqnUnderTestStrongA);
            } else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB")) {
                KeyCombinationEqnTCP = "privkey";
                MyDecrptionEquation = new String(InverseTCPEqnUnderTestStrongB);
            }
            MyPublicKey = AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey();
            MyPrivateKey = BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey();
            TCPDecryptedMesg = "";
            Double initMDivisor = 10E10;
            Double initCConstant = 20000.0;
            Double initmult_div = 1.0;
            Double initconstant = 20000.0;
            CConstant = initCConstant;
            mult_div = initmult_div;
            constant = initconstant;
            //System.out.println("TCPDecryptStrData:"+ ReceiverStrTCPDecrypt + ":MyDecrptionEquation=" + MyDecrptionEquation);
            Calibration.ContextSetChar4TCP(MyDecrptionEquation, "CharDecrypt", "Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
            //System.out.println("TCPDecryptStrData:StrongA:StrongB:ResultStr=" + ResultStr);  
            String[] Temp = ResultStr.toString().split(TCPCharTerminatorString);
            int NumOfUnits = Temp.length;// 4 Units packed in 1 ResultStr
            for (int i = 0; i < NumOfUnits; i++) {
                if (!Temp[i].equalsIgnoreCase("") && (!Temp[i].contains(" "))) {
                    TCPDecryptSBoxStrong(Temp[i], true);
                }
            }
            MyMessage1 = new StringBuilder(TCPDecryptedMesg);
        } else if ((ReceiverTCPDecrypt == true) && (ReceiverStrTCPDecrypt.equalsIgnoreCase("Weak"))) {//Encrypted
            MyMessage1 = TCPDecryptStrDataWeak1(ResultStr);
        } else if ((ReceiverTCPDecrypt == false) && (ReceiverStrTCPDecrypt.equalsIgnoreCase("None"))) {  //TCP Encrypted              
            KeyCombinationEqnTCP = "pubkey+privkey";

            MyDecrptionEquation = new String(InverseTCPEqnUnderTestStrongA);
            MyPublicKey = AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey();
            MyPrivateKey = BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey();
            TCPDecryptedMesg = "";
            Double initMDivisor = 10E10;
            Double initCConstant = 20000.0;
            Double initmult_div = 1.0;
            Double initconstant = 20000.0;
            CConstant = initCConstant;
            mult_div = initmult_div;
            constant = initconstant;
            Calibration.ContextSetChar4TCP(MyDecrptionEquation, "CharDecrypt", "Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
            //System.out.println("TCPDecryptStrData:TCP Encrypted:ResultStr=" + ResultStr);  
            String[] Temp = ResultStr.toString().split(TCPCharTerminatorString);
            int NumOfUnits = Temp.length;// 4 Units packed in 1 ResultStr
            for (int i = 0; i < NumOfUnits; i++) {
                if ((!Temp[i].equalsIgnoreCase("")) && (!Temp[i].contains(" "))) {// Spaces Condition needs to be confirmed
                    //System.out.println("TCPDecryptStrData:TCP Encrypted:Inbetween:Temp[i]=" + Temp[i]); 
                    TCPDecryptSBoxStrong(Temp[i], true);
                }
            }
            MyMessage1 = new StringBuilder(TCPDecryptedMesg);
            TCPDecryptedMesg = MyMessage1.toString();
            //System.out.println("TCPDecryptStrData:TCP Encrypted:Output:TCPDecryptedMesg=" + TCPDecryptedMesg);  
        }
        return MyMessage1;
    }

    public static StringBuilder TCPDecryptStrDataWeak1(StringBuilder ResultStr) {
        StringBuilder MyMessage1 = new StringBuilder("");
        TCPDecryptedMesg = "";
        if ((ReceiverTCPDecrypt == true) && (ReceiverStrTCPDecrypt.equalsIgnoreCase("Weak"))) {  //TCP Encrypted              
            KeyCombinationEqnTCP = "pubkey+privkey";

            MyDecrptionEquation = new String(InverseTCPEqnUnderTestWeak);//InverseTCPEqnUnderTestWeak;//InverseTCPEqnUnderTestWeakBinomial;
            //System.out.println("TCPDecryptStrDataWeak:MyDecrptionEquation=" + MyDecrptionEquation + " InverseTCPEqnUnderTestWeak=" + InverseTCPEqnUnderTestWeak);
            MyPublicKey = AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey();
            MyPrivateKey = BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey();//BobKeyPair.getPrivateKey();
            TCPDecryptedMesg = "";
            Double initMDivisor = 10E10;
            Double initCConstant = 20000.0;
            Double initmult_div = 1.0;
            Double initconstant = 20000.0;
            CConstant = initCConstant;
            mult_div = initmult_div;
            constant = initconstant;
            Calibration.ContextSetChar4TCPWeak(MyDecrptionEquation, "CharDecrypt", "Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
            //System.out.println("TCPDecryptStrDataWeak:variables:");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));  
            String[] Temp = ResultStr.toString().split(TCPCharTerminatorString);
            int NumOfUnits = Temp.length;// 4 Units packed in 1 ResultStr
            for (int i = 0; i < NumOfUnits; i++) {
                if ((!Temp[i].equalsIgnoreCase("")) && (!Temp[i].contains(" "))) {// Spaces Condition needs to be confirmed
                    //System.out.println("TCPDecryptStrDataWeak:TCP Encrypted:Inbetween:Temp[i]=" + Temp[i]); 
                    TCPDecryptSBoxStrong(Temp[i], true);
                }
            }
            MyMessage1 = new StringBuilder(TCPDecryptedMesg);
            TCPDecryptedMesg = MyMessage1.toString();
            //System.out.println("TCPDecryptStrDataWeak:TCP Encrypted:Output:TCPDecryptedMesg=" + TCPDecryptedMesg);  
        }
        return MyMessage1;
    }

    public static void TCPDecryptSBox(String ValueStr, boolean SilentFlag) {
        //SilentFlag=false;
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        Double Constant_Of_Mapping = 4.0;
        if (!ValueStr.equalsIgnoreCase("")) {
            Value = Double.parseDouble(ValueStr);
        }
        if (SilentFlag == false) {
            System.out.println("TCPDecryptSBox:Initial:Value=" + Value + " ValueStr=" + ValueStr);
            System.out.println("TCPDecryptSBox:Initial:MyDecrptionEquation=" + MyDecrptionEquation);
            System.out.println("TCPDecryptSBox:Initial:y=" + "y");
        }
        // Add Surprise Decryption Code
        ValueSurprise = ShannonDecryption("MessageShannonSimple", Value, InverseTCPExprnSurprise, InvSurpriseDiffWithRespTo);
        if (SilentFlag == false) {
            System.out.println("TCPDecryptSBox:After Surprise:Value=" + Value + " ValueSurprise=" + ValueSurprise);
            System.out.println("TCPDecryptSBox:After Surprise:Value=" + Value);
            System.out.println("TCPDecryptSBox:After Surprise:InverseTCPExprnDiffusion=" + InverseTCPExprnDiffusion);
            System.out.println("TCPDecryptSBox:After Surprise:InvDiffusionDiffWithRespTo=" + InvDiffusionDiffWithRespTo);
        }
        if (ValueSurprise != 0.0) {
            Value = ValueSurprise;
        }
        ValueDiffusion = ShannonDecryption("MessageShannonSimple", Value, InverseTCPExprnDiffusion, InverseTCPDiffusionDiffWithRespTo);
        if (ValueDiffusion != 0.0) {
            Value = ValueDiffusion;
        }
        if (SilentFlag == false) {
            System.out.println("TCPDecryptSBox:After Diffusion:Value=" + Value);
            System.out.println("TCPDecryptSBox:After Diffusion:MyPublicEquation=" + MyPublicEquation);
            System.out.println("TCPDecryptSBox:After Diffusion:y=" + "y");
            System.out.println("TCPDecryptSBox:After Diffusion:Value=" + Value + " ValueDiffusion=" + ValueDiffusion);
        }
        DecryptedByte = ShannonDecryption("MessageShannonSimple", Value, MyDecrptionEquation, "y");//+Constant_Of_Mapping;
        if (SilentFlag == false) {
            System.out.println("TCPDecryptSBox:Final:DecryptedByte=" + DecryptedByte);
        }
        TCPDecryptedMesg = TCPDecryptedMesg + (char) DecryptedByte.intValue();
    }

    public static void TCPDecryptSBoxStrong(String ValueStr, boolean SilentFlag) {
        //SilentFlag=false;
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double Constant_Of_Mapping = 4.0;
        if (SilentFlag == false) {
            System.out.println("TCPDecryptSBoxStrong:Initial:ValueStr=" + ValueStr);
        }
        if (!ValueStr.equalsIgnoreCase("")) {
            ShannonDecryptSBoxTCP(ValueStr, SilentFlag);
        }
        if (SilentFlag == false) {
            System.out.println("TCPDecryptSBoxStrong:Final:DecryptedByte=" + DecryptedByte);
        }
        TCPDecryptedMesg = TCPDecryptedMesg + (char) DecryptedByte.intValue();
    }
    // Values Decryption

    public static Double DecryptPKIValuesTCP(Double Value, Double MDivisorTCP, Double CConstant, Double multiplier, Double constant, boolean SilentFlag) {
        //SilentFlag=false;
        Double DecryptedByte = 0.0;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        String DiffExprn = "";
        String MyDiffWithRespTo = "y";
        if (SilentFlag == false) {
            System.out.println("Receiver:DecryptPKIValuesTCP:Equation1:DecrptionEquation=" + MyDecrptionEquation + " KeyCombinationEqnTCP=" + KeyCombinationEqnTCP);
        }
        Equation1 = new MathsRelations();
        Equation1.SetDiffWithRespTo(MyDiffWithRespTo);
        if ((MyPublicKey != null) && (!MyPublicKey.equalsIgnoreCase(""))) {
            variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        }
        if ((MyPrivateKey != null) && (!MyPrivateKey.equalsIgnoreCase(""))) {
            variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }
        LCGexpValue = parse(KeyCombinationEqnTCP, variablesDecrypt, MyDiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
        variablesDecrypt.put("n", 1.0E3);
        variablesDecrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        //variables.put("m", LCGexpValue.eval()/1.0E6 );
        variablesDecrypt.put("c", 1.0 * (constant + CConstant));
        variablesDecrypt.put(MyDiffWithRespTo, 1.0 * Value);
        variablesDecrypt.put("d", (double) dSecretValue);
        variablesDecrypt.put("e", (double) eSecretValue);
        variablesDecrypt.put("p", (double) pSecretValue);
        Equation1.initExprn(MyDecrptionEquation, variablesDecrypt, MyDiffWithRespTo);
        //System.out.println("Receiver:DecryptPKIValuesTCP:Before CalculateExprn:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        //DecryptedByte=10000*AliceEquation1.CalculateExprn();
        // Eliminate Numerical Noise in m && Decryption Process by using Math.rint
        DecryptedByte = Math.rint(Equation1.CalculateExprn());
        if (SilentFlag == false) {
            System.out.println("Receiver:DecryptPKIValuesTCP:Equation1:m=" + variablesDecrypt.get("m") + " n=" + variablesDecrypt.get("n") + " c=" + variablesDecrypt.get("c") + " MDivisorTCP=" + MDivisorTCP + " CConstant=" + CConstant + " multiplier=" + multiplier + " constant=" + constant + " MyDecrptionEquation=" + MyDecrptionEquation + " DecryptedByte=" + DecryptedByte + " y=" + variablesDecrypt.get("y"));
        }
        if (SilentFlag == false) {
            System.out.println("Receiver:DecryptPKIValuesTCP:Equation1:Decrypt:DecryptedByte=" + DecryptedByte + " plainText=" + variablesDecrypt.get(MyDiffWithRespTo) + " char=" + (char) DecryptedByte.byteValue());
        }
        MaliciousMalloryBob(Value, DecryptedByte, LCGexpValue);
        MaliciousMalloryAlice(Value, DecryptedByte, LCGexpValue);
//        variables.remove(MyDiffWithRespTo);
//        variables.remove("n");
//        variables.remove("c");
//        variables.remove("m");
//        variables.remove("privkey");
//        variables.remove("pubkey");
        return DecryptedByte;
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

    public static void ShannonDecryptSBoxTCP(String ValueStr, boolean SilentFlag) {
        //SilentFlag=false;
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        Double Constant_Of_Mapping = 4.0;
        //System.out.println("ShannonDecryptSBoxTCP:ValueStr=" + ValueStr);
        if (!ValueStr.equalsIgnoreCase("")) {
            Value = Double.parseDouble(ValueStr);
        }
        variablesDecrypt.put("c", diffusionN);
        variablesDecrypt.put("y", Value);
        DecryptedByte = DecryptPKIValuesTCP(Value, MDivisorTCP, CConstant, mult_div, constant, SilentFlag);//+Constant_Of_Mapping;
        //DecryptedMesg.append(DecryptedByte.intValue());
        //System.out.println("ShannonDecryptSBoxTCP:DecryptedByte=" + DecryptedByte + " DecryptedMesg=" + DecryptedMesg + " TCPDecryptedMesg=" + TCPDecryptedMesg);
    }
}
