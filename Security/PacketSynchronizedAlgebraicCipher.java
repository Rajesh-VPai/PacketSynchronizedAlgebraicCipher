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
import Calculus.RuleAnalytics;
import static Calculus.UsageCalculus.ruleAnalytics;
import static RandomNumber.UserResearchStudy.EntPoolIndex;
import static RandomNumber.UserResearchStudy.EvenNumber;
import static RandomNumber.UserResearchStudy.OddNumber;
import static RandomNumber.UserResearchStudy.PoolIndexSeries;
import static RandomNumber.UserResearchStudy.PrimeNumber;
import static Security.Calibration.ContextSetChar4TCP;
import static Security.Calibration.ContextSetMesg;
import static Security.Configuration.SecurityPosture;
import static Security.Configuration.UserTweaks_Entropy;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.CConstant;
import static Security.Security.EncryptPKIAliceKeyDiffr;
import static Security.Security.DecryptPKIAliceKeyDiffr;
import static Security.Security.DecryptPKIBobKeyDiffr;
import static Security.Security.DecryptPKIValues;
import static Security.Security.DecryptedByte;
import static Security.Security.Mychar;
import static Security.UsageSecurity.TestCase;
import static Security.Security.MyPublicKey;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyDecrptionEquation;
import static Security.Security.EncryptPKIBobKeyDiffr;
import static Security.Security.EncryptPKIValues;
import static Security.Security.MDivisor;
import static Security.Encryption.MyMessage;
import static Security.PSACKeyVaultNew.KeyCombinationEqn;
import static Security.Security.mult_div;
import static Security.Security.constant;
import static Security.SecurityTestHarness.EncryptMesgSimple;
import static Security.UsageSecurity.Regressionmain;
import static Security.UsageSecurity.TestExecResultsMessage;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class PacketSynchronizedAlgebraicCipher {

    public static Logger log = Logger.getLogger(PacketSynchronizedAlgebraicCipher.class.getName());
    public static String RunNumber = "0001";
    public static PSACKeyVaultNew EveKeyPair = null;
    public static MathsRelations EveEquation1;
    public static long myPrivKy = 100;//29;//31;//39;//43;//53;//100;//8;//100;//250// Global Variable Private Key Length
    public static long myPubKy = 100;//29;//31;//39;//43;//53;//100;//8;//100;//250 // Global Variable Public Key Length 
    public static int mySeedKey = 1367;//41;
    public static int mySeed1DyDx = 1523;//113;
    public static boolean SafeEquationsFlag = true;
    public static int SafeEquations = 5;
    public static int TCPSafeEquations = 5;
    public static int ExtremelySafeEquations = 7;

    public static boolean RandomEngineResetFactFlag = false;
    public static boolean RandomEngineResetValueFlag = false;

    public static String StrGUI = "Poorman'smain";

    public static boolean SuppressSystemOutput = true;// Suppresses System.out output

    public static boolean MesgINCAPS = false;

    public static boolean SuperSuppressOutput = true;// Suppresses System.out output

    public static boolean PrintKeys = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StrGUI = "Poorman'smain:RegressionTesting";
        IntegrateRandomNumberPackageSetGBLVar();
        // TODO code application logic here
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
        }
        UserTweaks_Entropy();// Initialize the Random Number Generator Over the hard coded Default Values.
        Regressionmain();
    }

    public static void SetupAlice(String AlgoName) {
        String StrTimeTaken = "";
        System.out.println("Alice:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Started:Run Time:" + current + " ");
        }
        if ((AliceKeyPair == null) || (AliceKeyPair.getPrivateKey(AlgoName) == null)
                || (AliceKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))
                || (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))) {
            AliceKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            AliceKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            AliceKeyPair.generateKeys(AlgoName);
            //AliceKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Alice:");
                System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey(AlgoName) + " Length=" + AliceKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey(AlgoName) + " Length=" + AliceKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getSymmetricKey()));
            }
        } else if ((SecurityPosture.equalsIgnoreCase("Normal"))
                && ((!(AliceKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))) && (AliceKeyPair.getPrivateKey(AlgoName).length() != myPrivKy)
                || (!(AliceKeyPair.getPublicKey(AlgoName).equalsIgnoreCase(""))) && (AliceKeyPair.getPublicKey(AlgoName).length() != myPubKy))) {
            AliceKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            AliceKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            AliceKeyPair.generateKeys(AlgoName);
            //AliceKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Alice:");
                System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey(AlgoName) + " Length=" + AliceKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey(AlgoName) + " Length=" + AliceKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getSymmetricKey()));
            }
        } else if ((SecurityPosture.equalsIgnoreCase("WeightedN"))
                && ((!(AliceKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))) && (AliceKeyPair.getPrivateKey(AlgoName).length() != myPrivKy)
                || (!(AliceKeyPair.getPublicKey(AlgoName).equalsIgnoreCase(""))) && (AliceKeyPair.getPublicKey(AlgoName).length() != myPubKy))) {
            AliceKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            AliceKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            AliceKeyPair.generateKeys(AlgoName);
           //AliceKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Alice:");
                System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey(AlgoName) + " Length=" + AliceKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey(AlgoName) + " Length=" + AliceKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getSymmetricKey()));
            }
        }
        AliceKeyPair.MyTCCKeyPair = new TCPECCKeyPairGeneration();
        AliceKeyPair.MyTCCKeyPair.init(AlgoName, mySeedKey, mySeedKey);
        AliceKeyPair.MyTCCKeyPair.GenerateKeys();
        System.out.println("Alice:ECCPrivateKey=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey() + " Length=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.MyTCCKeyPair.getTCPECCPrivateKey()) + " myPrivKy=" + myPrivKy);
        System.out.println("Alice:ECCPublicKey=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey() + " Length=" + AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.MyTCCKeyPair.getTCPECCPublicKey()) + " myPubKy=" + myPubKy);

        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
            StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
        }
    }

    public static void SetupBob(String AlgoName) {
        String StrTimeTaken = "";
        System.out.println("Bob:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Started:Run Time:" + current + " ");
        }
        if ((BobKeyPair == null) || (BobKeyPair.getPrivateKey(AlgoName) == null)
                || (BobKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))
                || (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))) {
            BobKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            BobKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            BobKeyPair.generateKeys(AlgoName);
            
            //BobKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Bob:");
                System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey(AlgoName) + " Length=" + BobKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey(AlgoName) + " Length=" + BobKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getSymmetricKey()));
            }
        } else if ((SecurityPosture.equalsIgnoreCase("Normal"))
                && ((!(BobKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))) && (BobKeyPair.getPrivateKey(AlgoName).length() != myPrivKy)
                || (!(BobKeyPair.getPublicKey(AlgoName).equalsIgnoreCase(""))) && (BobKeyPair.getPublicKey(AlgoName).length() != myPubKy))) {
            BobKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            BobKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            BobKeyPair.generateKeys(AlgoName);
            
            //BobKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Bob:");
                System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey(AlgoName) + " Length=" + BobKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey(AlgoName) + " Length=" + BobKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getSymmetricKey()));
            }
        } else if ((SecurityPosture.equalsIgnoreCase("WeightedN"))
                && ((!(BobKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))) && (BobKeyPair.getPrivateKey(AlgoName).length() != myPrivKy)
                || (!(BobKeyPair.getPublicKey(AlgoName).equalsIgnoreCase(""))) && (BobKeyPair.getPublicKey(AlgoName).length() != myPubKy))) {
            BobKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            BobKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            BobKeyPair.generateKeys(AlgoName);
            
            //BobKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Bob:");
                System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey(AlgoName) + " Length=" + BobKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey(AlgoName) + " Length=" + BobKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getSymmetricKey()));
            }
        }
        BobKeyPair.MyTCCKeyPair = new TCPECCKeyPairGeneration();
        BobKeyPair.MyTCCKeyPair.init(AlgoName, mySeedKey, mySeedKey);
        BobKeyPair.MyTCCKeyPair.GenerateKeys();
        System.out.println("Bob:ECCPrivateKey=" + BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey() + " Length=" + BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.MyTCCKeyPair.getTCPECCPrivateKey()) + " myPrivKy=" + myPrivKy);
        System.out.println("Bob:ECCPublicKey=" + BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey() + " Length=" + BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.MyTCCKeyPair.getTCPECCPublicKey()) + " myPubKy=" + myPubKy);

        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
            StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
        }
    }

    public static void SetupEve(String AlgoName) {
        String StrTimeTaken = "";
        System.out.println("Eve:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Started:Run Time:" + current + " ");
        }
        if ((EveKeyPair == null) || (EveKeyPair.getPrivateKey(AlgoName) == null)
                || (EveKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))
                || (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))) {
            EveKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            EveKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            EveKeyPair.generateKeys(AlgoName);
            
            //EveKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Eve:");
                System.out.println("Eve:PrivateKey=" + EveKeyPair.getPrivateKey(AlgoName) + " Length=" + EveKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Eve:PublicKey=" + EveKeyPair.getPublicKey(AlgoName) + " Length=" + EveKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Eve:SymmetricKey=" + EveKeyPair.getSymmetricKey() + " Length=" + EveKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getSymmetricKey()));
            }
        } else if ((SecurityPosture.equalsIgnoreCase("WeightedN"))
                && ((!(EveKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))) && (EveKeyPair.getPrivateKey(AlgoName).length() != myPrivKy)
                || (!(EveKeyPair.getPublicKey(AlgoName).equalsIgnoreCase(""))) && (EveKeyPair.getPublicKey(AlgoName).length() != myPubKy))) {
            EveKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            EveKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            EveKeyPair.generateKeys(AlgoName);
            
        } else if ((SecurityPosture.equalsIgnoreCase("Normal"))
                && ((!(EveKeyPair.getPrivateKey(AlgoName).equalsIgnoreCase(""))) && (EveKeyPair.getPrivateKey(AlgoName).length() != myPrivKy)
                || (!(EveKeyPair.getPublicKey(AlgoName).equalsIgnoreCase(""))) && (EveKeyPair.getPublicKey(AlgoName).length() != myPubKy))) {
            EveKeyPair = new PSACKeyVaultNew(AlgoName, myPrivKy, myPubKy);
            EveKeyPair.init(AlgoName, mySeedKey, mySeed1DyDx);
            EveKeyPair.generateKeys(AlgoName);
            //EveKeyPair.genSymmetricKey();
            if ((PrintKeys == true) && (StrGUI.equalsIgnoreCase("Poorman'smain:RegressionTesting"))) {
                System.out.println("Eve:");
                System.out.println("Eve:PrivateKey=" + EveKeyPair.getPrivateKey(AlgoName) + " Length=" + EveKeyPair.getPrivateKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPrivateKey(AlgoName)) + " myPrivKy=" + myPrivKy);
                System.out.println("Eve:PublicKey=" + EveKeyPair.getPublicKey(AlgoName) + " Length=" + EveKeyPair.getPublicKey(AlgoName).length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPublicKey(AlgoName)) + " myPubKy=" + myPubKy);
                //System.out.println("Eve:SymmetricKey=" + EveKeyPair.getSymmetricKey() + " Length=" + EveKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getSymmetricKey()));
            }
        }
        EveKeyPair.MyTCCKeyPair = new TCPECCKeyPairGeneration();
        EveKeyPair.MyTCCKeyPair.init(AlgoName, mySeedKey, mySeedKey);
        EveKeyPair.MyTCCKeyPair.GenerateKeys();
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
            StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
        }
    }

    public static void StudyOfPoorManSecurityLin() {
        String AlgoName = "Encrypt";
        System.out.println("StudyOfPoorManSecurityLin:");
        EqnUnderTest = "m*Xn+c";
        InverseEqnUnderTest = "y/m-c/m";
        System.out.println("StudyOfPoorManSecurityLin:Alice To Bob");
        Mychar = 'a' * 1.0;
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        Double Value = EncryptPKIBobKeyDiffr(Mychar.intValue());
        AlgoName = "Decrypt";
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIBobKeyDiffr(Value);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        if (Mychar.intValue() == DecryptedByte.intValue()) {
            System.out.println(ConsoleColors.GREEN + "StudyOfPoorManSecurityLin:Alice To Bob:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfPoorManSecurityLin:Alice To Bob:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println("StudyOfPoorManSecurityLin:Bob To Alice");
        AlgoName = "Encrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        Value = EncryptPKIAliceKeyDiffr(Mychar.intValue());
        AlgoName = "Decrypt";
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIAliceKeyDiffr(Value);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        if (Mychar.intValue() == DecryptedByte.intValue()) {
            System.out.println(ConsoleColors.GREEN + "StudyOfPoorManSecurityLin:Bob To Alice:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfPoorManSecurityLin:Bob To Alice:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println(ConsoleColors.BLUE + "TestExecutionResults: TestCase= " + TestCase + " Mychar=" + Mychar + " DecryptedByte=" + DecryptedByte + ConsoleColors.RESET);
    }

    public static void StudyOfPoorManSecurityValues() {
        String AlgoName = "Encrypt";
        System.out.println("StudyOfPoorManSecurityValues:");
        EqnUnderTest = "Xn^2+2*2*Xn+4";      //y=(m*Xn+2)^2;////y=(Xn+2)^2
        InverseEqnUnderTest = "y^0.5-2.0";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";
        Mychar = 'a' * 1.0;
        System.out.println("StudyOfPoorManSecurity:Values:Alice To Bob");
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        Double Value = EncryptPKIValues(Mychar.intValue(), 10E210, 0.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        AlgoName = "Decrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIValues(Value, 10E210, 0.0, 1.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        DecryptedByte = (double) Math.round(DecryptedByte);
        if (Mychar.intValue() == DecryptedByte.intValue()) {
            System.out.println(ConsoleColors.GREEN + "StudyOfPoorManSecurity:Values:Alice To Bob:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfPoorManSecurity:Values:Alice To Bob:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }

        System.out.println("StudyOfPoorManSecurity:Values:Bob To Alice");
        AlgoName = "Encrypt";
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        Value = EncryptPKIValues(Mychar.intValue(), 10E210, 0.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        System.out.println("StudyOfPoorManSecurity:Values:MyPublicKey:MyPrivKey:" + BobKeyPair.getPublicKey(AlgoName) + " : " + AliceKeyPair.getPrivateKey(AlgoName));
        AlgoName = "Decrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIValues(Value, 10E210, 0.0, 1.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        if (Mychar.intValue() == DecryptedByte.intValue()) {
            System.out.println(ConsoleColors.GREEN + "StudyOfPoorManSecurity:Values:Bob To Alice:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfPoorManSecurity:Values:Bob To Alice:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println(ConsoleColors.BLUE + "TestExecutionResults: TestCase= " + TestCase + " Mychar=" + Mychar + " DecryptedByte=" + DecryptedByte + ConsoleColors.RESET);
    }

    public static void StudyOfPoorManSecurityValuesM() {
        String AlgoName = "Encrypt";
        System.out.println("StudyOfPoorManSecurityValuesM:");
        EqnUnderTest = "Xn^2+2*Xn*c+c^2";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseEqnUnderTest = "y^0.5-c";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m

        Mychar = 'a' * 1.0;
        System.out.println("StudyOfPoorManSecurity:ValuesM:Alice To Bob");
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        Double Value = EncryptPKIValues(Mychar.intValue(), 10E100, 0.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        AlgoName = "Decrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIValues(Value, 10E100, 0.0, 1.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        DecryptedByte = (double) Math.round(DecryptedByte);
        if (Mychar.intValue() == DecryptedByte.intValue()) {
            System.out.println(ConsoleColors.GREEN + "StudyOfPoorManSecurity:ValuesM:Alice To Bob:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfPoorManSecurity:ValuesM:Alice To Bob:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }

        System.out.println("StudyOfPoorManSecurity:ValuesM:Bob To Alice");
        AlgoName = "Encrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        Value = EncryptPKIValues(Mychar.intValue(), 10E100, 0.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        AlgoName = "Decrypt";
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        DecryptedByte = DecryptPKIValues(Value, 10E100, 0.0, 1.0, 0.0, false);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        if (Mychar.intValue() == DecryptedByte.intValue()) {
            System.out.println(ConsoleColors.GREEN + "StudyOfPoorManSecurity:ValuesM:Bob To Alice:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfPoorManSecurity:ValuesM:Bob To Alice:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println(ConsoleColors.BLUE + "TestExecutionResults: TestCase= " + TestCase + " Mychar=" + Mychar + " DecryptedByte=" + DecryptedByte + ConsoleColors.RESET);
    }

    public static void StudyOfValuesMLinearStates(boolean SilentFlag) {
        String AlgoName = "Encrypt";
        System.out.println("StudyOfValuesMLinearStates:");
        EqnUnderTest = "m^2*Xn^2+2*m*Xn*c+c^2";       //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseEqnUnderTest = "y^0.5/m-c/m";    //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        KeyCombinationEqn = "pubkey+privkey";
        Double initMDivisor = 10E10;
        Double initCConstant = 10000.0;
        Double initmult_div = 1.0;
        Double initconstant = 10000.0;
        if (SilentFlag == false) {
            System.out.println("StudyOfValuesMLinearStates:MLinearStates:Alice To Bob");
        }
        ContextSetMesg("ShannonSimEncrypt", "Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        Double Value = EncryptPKIValues(Mychar.intValue(), MDivisor, CConstant, constant, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        AlgoName = "Decrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;

        ContextSetMesg("ShannonSimDecrypt", "Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        DecryptedByte = DecryptPKIValues(Value, MDivisor, CConstant, mult_div, constant, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        DecryptedByte = (double) Math.round(DecryptedByte);
        if ((Mychar.intValue() == DecryptedByte.intValue()) || (Mychar == Math.rint(DecryptedByte))) {
            System.out.println(ConsoleColors.GREEN + "StudyOfValuesMLinearStates:MLinearStates:Alice To Bob:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfValuesMLinearStates:MLinearStates:Alice To Bob:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }

        if (SilentFlag == false) {
            System.out.println("StudyOfValuesMLinearStates:MLinearStates:Bob To Alice");
        }
        AlgoName = "Encrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;

        ContextSetChar4TCP(MyPublicEquation, "CharEncrypt", "Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        //ContextSetMesg(MyPublicEquation, "ShannonSimEncrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        Value = EncryptPKIValues(Mychar.intValue(), MDivisor, CConstant, constant, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        AlgoName = "Decrypt";
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;

        ContextSetChar4TCP(MyDecrptionEquation, "CharDecrypt", "Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        //ContextSetMesg(MyDecrptionEquation, "ShannonSimDecrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        DecryptedByte = DecryptPKIValues(Value, MDivisor, CConstant, mult_div, constant, SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";

        if ((Mychar.intValue() == DecryptedByte.intValue()) || (Mychar == Math.rint(DecryptedByte))) {
            System.out.println(ConsoleColors.GREEN + "StudyOfValuesMLinearStates:MLinearStates:Bob To Alice:Information Success:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + " Mychar=" + (char) Mychar.intValue() + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "StudyOfValuesMLinearStates:MLinearStates:Bob To Alice:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + " DecryptedByte=" + Math.rint(DecryptedByte) + ConsoleColors.RESET);
        }
        System.out.println(ConsoleColors.BLUE + "TestExecutionResults: TestCase= " + TestCase + " Mychar=" + Mychar + " DecryptedByte=" + DecryptedByte + ConsoleColors.RESET);
    }

    public static void UserProgram() {
        boolean SilentFlag = true;
        String AlgoName = "Encrypt";
        SetupAlice(AlgoName);
        SetupBob(AlgoName);
        SetupEve(AlgoName);
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:!@#$%^&*()+={}[];><,./?|\\";
        String xExprn = MyMessage;
        System.out.println("1) Run Test Message OR ");
        System.out.println("2) Your Message Demo");
        System.out.print("Your Choice [" + xExprn + "]:");
        Scanner scanner = new Scanner(System.in);
        String TempxExprn = xExprn.trim();
        TempxExprn = scanner.nextLine();
        if (TempxExprn.equalsIgnoreCase("")) {
            TempxExprn = xExprn.trim();
            System.out.println("Test Message:" + xExprn);
        } else if ((TempxExprn.equalsIgnoreCase("TestMessage")) || (TempxExprn.equalsIgnoreCase("1"))) {
            TempxExprn = xExprn.trim();
            System.out.println("Test Message:" + xExprn);
        } else if ((TempxExprn.equalsIgnoreCase("2")) || (TempxExprn.equalsIgnoreCase("Demo")) || (TempxExprn.equalsIgnoreCase("UserInteractive"))) {
            System.out.print("Your Message:");
            TempxExprn = scanner.nextLine();
        }
        TempxExprn = TempxExprn.trim();
        MyMessage = TempxExprn;
        EncryptMesgSimple("1", SilentFlag);
        TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:!@#$%^&*()+={}[];><,./?|\\";
        xExprn = MyMessage;
        System.out.println("1) Run Test Message OR ");
        System.out.println("2) Your Message Demo");
        System.out.print(": Your Choice [" + xExprn + "]:");
        scanner = new Scanner(System.in);
        TempxExprn = xExprn.trim();
        System.out.print("Your Message:");
        TempxExprn = scanner.nextLine();
        if (TempxExprn.equalsIgnoreCase("")) {
            TempxExprn = xExprn.trim();
            System.out.println("Test Message:" + xExprn);
        } else if ((TempxExprn.equalsIgnoreCase("TestMessage")) || (TempxExprn.equalsIgnoreCase("1"))) {
            TempxExprn = xExprn.trim();
            System.out.println("Test Message:" + xExprn);
        } else if ((TempxExprn.equalsIgnoreCase("2")) || (TempxExprn.equalsIgnoreCase("Demo")) || (TempxExprn.equalsIgnoreCase("UserInteractive"))) {
            System.out.print("Your Message:");
            TempxExprn = scanner.nextLine();
        }
        TempxExprn = TempxExprn.trim();
        MyMessage = TempxExprn;
        EncryptMesgSimple("2", SilentFlag);
        TestExecResultsMessage();
        System.out.print(System.lineSeparator());
    }

    public static void IntegrateRandomNumberPackageSetGBLVar() {
        RandomNumber.UserResearchStudy.IssuedLCGPrimeNumber = 1;
        RandomNumber.UserResearchStudy.EvenIssuedLCGPrimeNumber = 1;
        RandomNumber.UserResearchStudy.OddIssuedLCGPrimeNumber = 1;
        RandomNumber.UserResearchStudy.PatternFreqMaxIndex = new int[(int) (EntPoolIndex)];
        RandomNumber.UserResearchStudy.PatternFreqMaxIndexSeries = new int[(int) (PoolIndexSeries)];
        PrimeNumber(10000);
        EvenNumber(10000);
        OddNumber(10000);
        ruleAnalytics = new RuleAnalytics();
        ruleAnalytics.Init();
    }

}
