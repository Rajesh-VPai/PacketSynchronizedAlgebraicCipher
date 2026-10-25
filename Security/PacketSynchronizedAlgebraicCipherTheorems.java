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
import static Security.PacketSynchronizedAlgebraicCipher.EveKeyPair;
import static Security.PacketSynchronizedAlgebraicCipher.SetupAlice;
import static Security.PacketSynchronizedAlgebraicCipher.SetupBob;
import static Security.PacketSynchronizedAlgebraicCipher.SetupEve;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.PacketSynchronizedAlgebraicCipher.mySeed1DyDx;
import static Security.PacketSynchronizedAlgebraicCipher.mySeedKey;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Encryption.MyMessage;
import static Security.UsageSecurity.NamesOfTestCase_Objctive;
import static Security.UsageSecurity.Section;
import static Security.UsageSecurity.TestCase;
import static Security.UsageSecurity.TestCaseInternalVar;
import static Security.UsageSecurity.TestCasePassHighLevelFlag;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class PacketSynchronizedAlgebraicCipherTheorems {

    public static Logger log = Logger.getLogger(PacketSynchronizedAlgebraicCipherTheorems.class.getName());
    public static String TheoremStmt1 = "";
    public static String TheoremStmt2 = "";
    public static String TheoremStmt3 = "";
    public static String TheoremStmt4 = "";
    public static String TheoremStmt5 = "";
    public static String TheoremStmt6 = "";
    public static String TheoremStmt7 = "";
    public static String TheoremStmt8 = "";
    public static String TheoremStmt9 = "";
    public static String TheoremStmt10 = "";
    public static String TheoremStmt11 = "";
    public static PSACKeyVaultNew[] AnonymousKeyPair = null;
    // High Level Data Collection
    public static HashMap<String, String> DataTheorem1 = new HashMap<String, String>();
    // Low Level Data Collection
    public static HashMap<String, String> DataTheorem1Low = new HashMap<String, String>();

    public static boolean TestTheorem2PerfFLAG = false;// Always False
    public static String TestTheorem2StrCurrentTimeTaken = null;

    //Sanity Test Cases
    public static void PoormansTheoremTestCases(String AlgoName, int j) {
        System.out.println(ConsoleColors.BLACK + "TestCase:j= " + j + ConsoleColors.RESET);
        switch (j) {
            case 3001:
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** PoormansTheorem TestCases Begins *************** */");
                Theorem1();
                break;
            case 3002:
                Theorem2();
                break;
            case 3003:
                TestCase0000Default();
                break;
            case 3004:
                TestCase0000Default();
                break;
            case 3005:
                TestCase0000Default();
                System.out.println("/************************** PoormansTheorem TestCases Ends *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                break;
            default:
                System.out.println(ConsoleColors.RED + "PoormansTheorem TestCase:j= " + j + ": Gap" + ConsoleColors.RESET);
                break;
        }
    }

    public static void TestCase0000Default() {
        //Test Case 000Default
        NamesOfTestCase_Objctive = "DefaultDummy";
        TestCasePassHighLevelFlag = false;
    }

    public static void Theorem1() {
        //Test Case 3001
        TestCaseInternalVar = 3001;
        NamesOfTestCase_Objctive = "PoormansSecurityTheorem:Theorem1:";
        System.out.println(ConsoleColors.GREEN + "Theorem1:Obj:=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);
        TheoremStmt1 = "In a pure cipher, from Number theory";
        TheoremStmt2 = " the run of the key digram (cycles)(numRandcycles) is greater than sqrt(key length) ";
        TheoremStmt3 = " and the number of outliers is less than sqrt (key length)";
        TheoremStmt4 = "RunFailRandOutLiers > sqrt(myPrivKy)";
        TheoremStmt5 = "numFailRandOutLiers < sqrt(myPrivKy)";
        System.out.println(ConsoleColors.GREEN + "Theorem1:TheoremStmt:=" + TheoremStmt1 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt2 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt3 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt4 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt5 + ConsoleColors.RESET);

        SetupAlice("Encrypt");
        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";

        String MyKey = AliceKeyPair.getPrivateKey("Encrypt");
        String KeyPairName = "Alice";
        KeyPairForLoop(KeyPairName, MyKey);

        SetupBob("Encrypt");
        MyKey = BobKeyPair.getPrivateKey("Encrypt");
        KeyPairName = "Bob";
        KeyPairForLoop(KeyPairName, MyKey);

        SetupEve("Encrypt");
        MyKey = EveKeyPair.getPrivateKey("Encrypt");
        KeyPairName = "Eve";
        KeyPairForLoop(KeyPairName, MyKey);

        //SetupAliceKeyShannon();
        //MyKey = AliceKeyShannon.getPrivateKey();
        KeyPairName = "AliceKeyShannon";
        KeyPairForLoop(KeyPairName, MyKey);

        //SetupBobKeyShannon();
        //MyKey = BobKeyShannon.getPrivateKey();
        KeyPairName = "BobKeyShannon";
        KeyPairForLoop(KeyPairName, MyKey);

        //SetupEveKeyShannon();
        //MyKey = EveKeyShannon.getPrivateKey();
        KeyPairName = "EveKeyShannon";
        KeyPairForLoop(KeyPairName, MyKey);

        //SetupiKeyShannon();
        //MyKey = iKeyShannon.getPrivateKey();
        KeyPairName = "iKeyShannon";
        KeyPairForLoop(KeyPairName, MyKey);
        //Complete Message
        MyMessage = "The Quick Brown Fox Jumps Over The Lazy Dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";

        //SetupjKeyShannon();
        //MyKey = jKeyShannon.getPrivateKey();
        KeyPairName = "jKeyShannon";
        KeyPairForLoop(KeyPairName, MyKey);

        ReportTheorem1("Alice", -1);
        ReportTheorem1("Bob", -1);
        ReportTheorem1("Eve", -1);
        ReportTheorem1("AliceKeyShannon", -1);
        ReportTheorem1("BobKeyShannon", -1);
        ReportTheorem1("EveKeyShannon", -1);
        ReportTheorem1("iKeyShannon", -1);
        ReportTheorem1("jKeyShannon", -1);
    }

    static int Theorem1LowLevel(boolean Flag, String Key, String KeyPairName, int instanceKey) {
        int i = Key.length();
        int numRandcycles = 0;
        int numFailRandOutLiers = 0;
        int RunFailRandOutLiers = 0;
        String StrKeyDigits = "";
        String KeyCompDigLast2 = Key.substring(i - 2, i);
        DataTheorem1Low.put(KeyPairName + "KeyCompDigLast2", KeyCompDigLast2);
        for (int keylen = 0; keylen < i; keylen += 2, numRandcycles++) {

            if (keylen + 2 < i) {
                StrKeyDigits = Key.substring(keylen, keylen + 2);
            }
            //System.out.println(ConsoleColors.BLUE + "Theorem1LowLevel:StrKeyDigits=" + StrKeyDigits + " LastKeys=" + KeyCompDig );
            if (StrKeyDigits.equalsIgnoreCase(KeyCompDigLast2)) {
                //System.out.print(System.lineSeparator());
                System.out.println(ConsoleColors.RED + "Theorem1LowLevel:NOT RANDOM:" + " numFailRandOutLiers=" + numFailRandOutLiers + " numRandcycles=" + numRandcycles + " RunFailRandOutLiers=" + RunFailRandOutLiers + " KeyCompDigLast2=" + KeyCompDigLast2 + " StrKeyDigits=" + StrKeyDigits + ConsoleColors.RESET);
                DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "RunFailRandOutLiers" + numFailRandOutLiers, "" + RunFailRandOutLiers);
                DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "numRandcycles" + numFailRandOutLiers, "" + numRandcycles);
                DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "KeyCompDigLast2" + numFailRandOutLiers, KeyCompDigLast2);
                DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "StrKeyDigits" + numFailRandOutLiers, StrKeyDigits);
                numFailRandOutLiers++;
                RunFailRandOutLiers = 1;
            } else if (!StrKeyDigits.equalsIgnoreCase(KeyCompDigLast2)) {
                //System.out.println(ConsoleColors.GREEN +"Theorem1LowLevel:RANDOM:numRandcycles=" + numRandcycles + " KeyCompDig=" + KeyCompDig + " StrKeyDigits=" + StrKeyDigits + ConsoleColors.RESET);
                if ((!StrKeyDigits.equalsIgnoreCase("")) && (Integer.parseInt(StrKeyDigits) < Integer.parseInt(KeyCompDigLast2))) {
                    //System.out.print(ConsoleColors.BLACK +"StrKeyDigits:LessThan:RANDOM:numRandcycles=" + numRandcycles + " KeyCompDig=" + KeyCompDig + " StrKeyDigits=" + StrKeyDigits + ConsoleColors.RESET);
                } else if ((!StrKeyDigits.equalsIgnoreCase("")) && (Integer.parseInt(StrKeyDigits) > Integer.parseInt(KeyCompDigLast2))) {
                    //System.out.print(ConsoleColors.CYAN +"StrKeyDigits:GreaterThan:Theorem1LowLevel::RANDOM:numRandcycles=" + numRandcycles + " KeyCompDig=" + KeyCompDig + " StrKeyDigits=" + StrKeyDigits + ConsoleColors.RESET);
                }
                RunFailRandOutLiers++;
            }
        }
        System.out.println(ConsoleColors.RED + "Theorem1LowLevel:NOT RANDOM:LAST:numFailRandOutLiers=" + numFailRandOutLiers + " numRandcycles=" + numRandcycles + " RunFailRandOutLiers=" + RunFailRandOutLiers + " KeyCompDigLast2=" + KeyCompDigLast2 + " StrKeyDigits=" + StrKeyDigits + ConsoleColors.RESET);
        DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "RunFailRandOutLiers" + numFailRandOutLiers, "" + RunFailRandOutLiers);
        DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "numRandcycles" + numFailRandOutLiers, "" + numRandcycles);
        DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "KeyCompDigLast2" + numFailRandOutLiers, KeyCompDigLast2);
        DataTheorem1Low.put(KeyPairName + ":" + instanceKey + ":" + "StrKeyDigits" + numFailRandOutLiers, StrKeyDigits);
        numFailRandOutLiers++;
        //System.out.print(System.lineSeparator());
        return numFailRandOutLiers;
    }

    static void ReportTheorem1(String KeyPairName, int instanceKey) {
        int numFailRandOutLiers = Integer.parseInt(DataTheorem1.get(KeyPairName + "numFailRandOutLiers"));
        int sqrtdigramlen = (int) Double.parseDouble(DataTheorem1.get(KeyPairName + "SQRT(digramlength)"));
        System.out.println("Theorem1:Low Level Data:" + KeyPairName + ":" + instanceKey + ":" + " numFailRandOutLiers=" + numFailRandOutLiers);
        System.out.println("Theorem1:Low Level Data:" + KeyPairName + ":" + instanceKey + ":" + " SQRT(digramlength)=" + sqrtdigramlen);
        for (int i = 0; i < numFailRandOutLiers; i++) {
            System.out.println("Theorem1:Low Level Data:" + KeyPairName + ":" + instanceKey + ":" + ":" + i + ":RunFailRandOutLiers=" + DataTheorem1Low.get(KeyPairName + "RunFailRandOutLiers" + i));
            System.out.println("Theorem1:Low Level Data:" + KeyPairName + ":" + instanceKey + ":" + ":" + i + ":numRandcycles=" + DataTheorem1Low.get(KeyPairName + "numRandcycles" + i));
            System.out.println("Theorem1:Low Level Data:" + KeyPairName + ":" + instanceKey + ":" + ":" + i + ":KeyCompDigLast2=" + DataTheorem1Low.get(KeyPairName + "KeyCompDigLast2" + i));
            System.out.println("Theorem1:Low Level Data:" + KeyPairName + ":" + instanceKey + ":" + ":" + i + ":StrKeyDigits=" + DataTheorem1Low.get(KeyPairName + "StrKeyDigits" + i));
        }
    }

    //Process Test Message
    public static boolean TestExecResultsTheorem1(String KeyPairName, int OutLiers, int MySqrt) {
        boolean Flag = false;
        int Run = 0;
        int i = 0;
        System.out.println(ConsoleColors.BLUE + "ResultsTheorem1: Length=" + MyMessage.length() + ConsoleColors.RESET);
        if (OutLiers < MySqrt) {
            Flag = true;
            System.out.println(ConsoleColors.GREEN + "ResultsTheorem1: Test Case Passes OutLiers Rule TestCase= " + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
        }
        for (i = 0; i < OutLiers; i++) {
            if (DataTheorem1Low.containsKey(KeyPairName + "RunFailRandOutLiers" + i)) {
                Run = Integer.parseInt(DataTheorem1Low.get(KeyPairName + "RunFailRandOutLiers" + i));
            }
            if (Run < MySqrt) {
                break;
            }
            if (i == (OutLiers - 1)) {
                System.out.println(ConsoleColors.GREEN + "ResultsTheorem1: Test Case Passes TestCase= " + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
                return true;
            }
        }
        System.out.println(ConsoleColors.RED + "ResultsTheorem1: Test Case Fails i=" + i + " Run=" + Run + " MySqrt=" + MySqrt + " TestCase= " + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
        return false;
    }

    public static void KeyPairForLoop(String KeyPairName, String MyKey) {
        System.out.println(KeyPairName + ":PrivateKey=" + MyKey);
        System.out.println(KeyPairName + ":PublicKey=" + AliceKeyPair.getPublicKey("Encrypt"));
        //System.out.println(KeyPairName + ":SymmetricKey=" + AliceKeyPair.getSymmetricKey());

        int numFailRandOutLiers = Theorem1LowLevel(true, MyKey, KeyPairName, -1);
        DataTheorem1.put(KeyPairName + "SQRT(digramlength)", "" + Math.sqrt(myPrivKy));
        DataTheorem1.put(KeyPairName + "numFailRandOutLiers", "" + numFailRandOutLiers);
        System.out.println(ConsoleColors.GREEN + "Theorem1:" + KeyPairName + ":Overall:numFailRandOutLiers=" + numFailRandOutLiers + ConsoleColors.RESET);
        TestCasePassHighLevelFlag = TestExecResultsTheorem1(KeyPairName, numFailRandOutLiers, (int) Math.sqrt(myPrivKy));

    }

    public static void Theorem2() {
        //Test Case 3002
        TestCaseInternalVar = 3002;
        NamesOfTestCase_Objctive = "PoormansSecurityTheorem:Theorem2:";
        System.out.println(ConsoleColors.GREEN + "Theorem2:Obj:=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);
        TheoremStmt1 = "In a pure cipher, from Number theory";
        TheoremStmt2 = " the run of the key digram (cycles)(numRandcycles) is greater than sqrt(key length) ";
        TheoremStmt3 = " and the number of outliers is less than sqrt (key length)";
        TheoremStmt4 = "RunFailRandOutLiers > sqrt(myPrivKy)";
        TheoremStmt5 = "numFailRandOutLiers < sqrt(myPrivKy)";
        System.out.println(ConsoleColors.GREEN + "Theorem2:TheoremStmt:=" + TheoremStmt1 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt2 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt3 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt4 + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + TheoremStmt5 + ConsoleColors.RESET);

        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        String KeyPairName = "AnonymousKeyPair";
        int NumOfKeys = 10;
        AnonymousKeyPair = new PSACKeyVaultNew[NumOfKeys];
        KeyPairLoop(KeyPairName, NumOfKeys);

    }

    public static void KeyPairLoop(String KeyPairName, int NumOfKeys) {
        int i = 0;
        for (i = 0; i < NumOfKeys; i++) {
            System.out.println(KeyPairName + ":i=" + i);
            if ((TestTheorem2PerfFLAG == false)) /* Always False*/ {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                if (TimeTaken.length == 3) {
                    TestTheorem2StrCurrentTimeTaken = "" + (Double.parseDouble(TimeTaken[2]));
                } else {
                    TestTheorem2StrCurrentTimeTaken = "" + 0.0;
                }
                System.out.println("Cycle Started:Run Time:" + current + " ");
            }
            SetupAnonymous(i, NumOfKeys);
            String MyKey = "";
            String KeyType = "";
            if ((i < AnonymousKeyPair.length)
                    && (i < NumOfKeys)) {
                KeyType = "Private Key";
                System.out.println(ConsoleColors.BLUE + KeyPairName + ":i=" + i + " " + KeyType + " Analysis" + ConsoleColors.RESET);
                MyKey = AnonymousKeyPair[i].getPrivateKey("Encrypt");
                //KeyType="Symmetric Key";
                //System.out.println(ConsoleColors.BLUE + KeyPairName + ":i=" + i + " " + KeyType + " Analysis" + ConsoleColors.RESET);
                //MyKey = AnonymousKeyPair[i].getSymmetricKey();
                System.out.println(KeyPairName + ":" + KeyType + "=" + MyKey);
                System.out.println(KeyPairName + ":PrivateKey=" + AnonymousKeyPair[i].getPrivateKey("Encrypt"));
                System.out.println(KeyPairName + ":PublicKey=" + AnonymousKeyPair[i].getPublicKey("Encrypt"));
                //System.out.println(KeyPairName + ":SymmetricKey=" + AnonymousKeyPair[i].getSymmetricKey("Encrypt"));

                int numFailRandOutLiers = Theorem1LowLevel(true, MyKey, KeyPairName, i);
                DataTheorem1.put(KeyPairName + "SQRT(digramlength)", "" + Math.sqrt(myPrivKy));
                DataTheorem1.put(KeyPairName + "numFailRandOutLiers", "" + numFailRandOutLiers);
                System.out.println(ConsoleColors.GREEN + "Theorem1:" + KeyPairName + ":Overall:numFailRandOutLiers=" + numFailRandOutLiers + ConsoleColors.RESET);
                TestCasePassHighLevelFlag = TestExecResultsTheorem1(KeyPairName, numFailRandOutLiers, (int) Math.sqrt(myPrivKy));
                CheckKeys(i, NumOfKeys);
                ReportTheorem1(KeyPairName, i);
                System.out.println(ConsoleColors.BLUE + KeyPairName + ":i=" + i + " " + KeyType + " Analysis Completed." + ConsoleColors.RESET);
            }
            if ((TestTheorem2PerfFLAG == false)) /* Always False*/ {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                String localStrCurrentTimeTaken = "";
                if (TimeTaken.length == 3) {
                    localStrCurrentTimeTaken = "" + (Double.parseDouble(TimeTaken[2]));
                } else {
                    localStrCurrentTimeTaken = "" + 0;
                }
                System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(TestTheorem2StrCurrentTimeTaken))) + " seconds.");
                TestTheorem2StrCurrentTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(TestTheorem2StrCurrentTimeTaken)));
            }
        }
    }

    public static void SetupAnonymous(int i, int NumOfKeys) {
        System.out.println("AnonymousKeyPair:" + i + ":");
        if ((i < AnonymousKeyPair.length)
                && (i < NumOfKeys)) {
            AnonymousKeyPair[i] = new PSACKeyVaultNew("Encrypt",myPrivKy, myPubKy);
            AnonymousKeyPair[i].init("Encrypt",mySeedKey, mySeed1DyDx);
            AnonymousKeyPair[i].getPrivateKey("Encrypt");
            //AnonymousKeyPair[i].genPublicKeyN("Encrypt");
            //AnonymousKeyPair[i].genSymmetricKey();
            String AliceMyPubKey = AnonymousKeyPair[i].getPublicKey("Encrypt");
            String AliceMyPrivKey = AnonymousKeyPair[i].getPrivateKey("Encrypt");
            //String AliceMySymmetricKey = AnonymousKeyPair[i].getSymmetricKey();
        }
    }

    public static void CheckKeys(int i, int NumOfKeys) {
        int j = 0;
        boolean isNOTUniqueFlag = false;
        for (; (j < i) && (j < NumOfKeys); j++) {
            if (AnonymousKeyPair[i].getPrivateKey("Encrypt").equalsIgnoreCase(AnonymousKeyPair[j].getPrivateKey("Encrypt"))) {
                System.out.println(ConsoleColors.RED + "AnonymousKeyPair:" + i + ":PrivateKey=" + " is EQUAL TO  j=" + j + ":PrivateKey" + ConsoleColors.RESET);
                isNOTUniqueFlag = true;
            }
//            if (AnonymousKeyPair[i].getSymmetricKey().equalsIgnoreCase(AnonymousKeyPair[j].getSymmetricKey())) {
//                System.out.println(ConsoleColors.RED + "AnonymousKeyPair:" + i + ":SymmetricKey=" + " is EQUAL TO  j=" + j + ":SymmetricKey" + ConsoleColors.RESET);
//                isNOTUniqueFlag = true;
//            }
        }
        if ((isNOTUniqueFlag == false)
                && ((i == j) || (j == NumOfKeys))) {
            System.out.println(ConsoleColors.GREEN + "AnonymousKeyPair:" + i + ":is UNIQUE." + ConsoleColors.RESET);
        }
    }
}
