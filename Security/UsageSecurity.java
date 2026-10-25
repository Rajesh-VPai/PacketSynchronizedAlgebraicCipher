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
import static Calculus.MathsContxtLAv.eatAll;
import DOETest.HDOEDefine;
import DOETest.TestHarnessDOE;
import static Security.BasicTests.BasicTestCases;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static Security.Encryption.WorkFactorEncrypt;
import static Security.EquationPairGeneration.DiffWithRespToDiffusion;
import static Security.EquationPairGeneration.DiffWithRespToSurprise;
import static Security.EquationPairGeneration.ExprnDiffusion;
import static Security.EquationPairGeneration.ExprnSurprise;
import static Security.EquationPairGeneration.InvDiffusionDiffWithRespTo;
import static Security.EquationPairGeneration.InvExprnDiffusion;
import static Security.EquationPairGeneration.InvExprnSurprise;
import static Security.EquationPairGeneration.InvSurpriseDiffWithRespTo;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.PacketSynchronizedAlgebraicCipher.SetupAlice;
import static Security.PacketSynchronizedAlgebraicCipher.SetupBob;
import static Security.PacketSynchronizedAlgebraicCipher.SetupEve;
import static Security.PacketSynchronizedAlgebraicCipher.StudyOfPoorManSecurityLin;
import static Security.PacketSynchronizedAlgebraicCipher.StudyOfPoorManSecurityValues;
import static Security.PacketSynchronizedAlgebraicCipher.StudyOfPoorManSecurityValuesM;
import static Security.PacketSynchronizedAlgebraicCipher.StudyOfValuesMLinearStates;
import static Security.PacketSynchronizedAlgebraicCipher.UserProgram;
import static Security.Configuration.NumberOfTimesOrg;
import static Security.Configuration.CyclicFlag;
import static Security.PacketSynchronizedAlgebraicCipher.EveKeyPair;
import static Security.Configuration.NumberOfTimes;
import static Security.Configuration.DOEmainHighLevelSecurity;
import static Security.Configuration.DOEmainUserTweaks;
import static Security.Configuration.KeymainUserTweaks;
import static Security.Configuration.KeymainTest;
import static Security.Security.DecryptedByte;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.EncryptedMesg;
import static Security.Security.MyDecrptionEquation;
import static Security.Encryption.MyMessage;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.Mychar;
import static Security.SubstitutionBox.WeibullEncrypt;
import static Security.Security.variables;
import static Security.SecurityTestHarness.EncryptMesgSimple;
import static Security.SecurityTestHarness.JuliusCaeserDecryptSimple;
import static Security.SecurityTestHarness.JuliusCaeserEncryptSimple;
import static Security.SecurityTestHarness.MessageMLinearStates;
import static Security.SecurityTestHarness.MessageShannon;
import static Security.SecurityTestHarness.MessageShannonSimple;
import static Security.SecurityTestHarness.TestSecEncPerfFLAG;
import static Security.SecurityTestHarness.TestSecEncStrCurrentTimeTaken;
import static Security.Configuration.UserStrings_EncryptMesgSimple_Entropy;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.PacketSynchronizedAlgebraicCipher.mySeed1DyDx;
import static Security.PacketSynchronizedAlgebraicCipher.mySeedKey;
import static Security.PacketSynchronizedAlgebraicCipher.MesgINCAPS;
import static Security.PacketSynchronizedAlgebraicCipherTheorems.PoormansTheoremTestCases;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.SecurityTestHarness.JuliusCaeserDecryptComplex;
import static Security.SecurityTestHarness.JuliusCaeserEncryptComplex;
import static Security.SubstitutionBox.ShannonSimDecrypt;
import static Security.SubstitutionBox.ShannonSimEncrypt;
import static Security.TranspositionPBox.JumbleStrEncrypt;
import static Security.TranspositionPBox.RotateStrEncrypt;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Receiver.OffsetRotate1;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class UsageSecurity {

    public static Logger log = Logger.getLogger(UsageSecurity.class.getName());
    // Maximum number of Double Fractional Digits displayed in Equation
    private static int MaximumCompFractionDigits = 2;
    public static String TestCaseRow = "";
    public static String ConfigFileName = "";
    public static String LevelFileName = "";
    public static int TestCase = -1;
    public static int TestCaseInternalVar = -1;
    public static int EndTestCase = 3003;
    public static int LastTestCaseHarness = 3003;
    public static int TestCaseLoopTimes = 0;
    public static long myPrivKyTest = 8;//250
    public static long myPubKyTest = 8;//250

    public static boolean TestCasePassHighLevelFlag = true;
    public static boolean TestCasePassHappyLowLVLFlag = true;
    public static boolean TestCasePassEavesLowLVLFlag = true;
    public static boolean oldTestCasePassHighLevelFlag = false;
    public static HashMap<Integer, String> FailedTestCases = new HashMap<Integer, String>();
    public static HashMap<Integer, String> ExceptionTestCases = new HashMap<Integer, String>();
    public static HashMap<Integer, String> ExceptionStringDB = new HashMap<Integer, String>();
    public static Throwable cause = new Throwable();
    public static int MaxIndexExcept = 0;
    public static int TotalTestCases = 0;
    public static int ByPassedTestCases = 0;
    public static int MissedNumberTestCases = 0;
    public static int MissedTestCasesInfinity = 0;
    public static int MissedTestCasesException = 0;

    public static int MaxIndexFail = 0;
    public static int SectionIndexFail = 1;
    public static String TestCaseFile = "";
    public static String Section = "";
    public static String SectionReportHeading = "";
    public static int FailedTestCount = 0;
    public static int SectionTestCaseStart = 0;
    public static int SectionTestCaseEnd = 0;
    public static String NamesOfTestCase_Objctive = "";
    public static boolean IntegratedTestFlag = false;

    public static Map<Integer, String> EqnDB = new HashMap<>();
    public static int EqnDBIndex = 0;
    public static int EqnDBDupCount = 0;

    public UsageSecurity(String All, String MyEndTestCase, String RegrORIndivORLimit) {

        LastTestCaseHarness = 3003;
        if ((All.equalsIgnoreCase("All")) && (RegrORIndivORLimit.equalsIgnoreCase("Regression"))) {
            TestCase = -1;
            TestCaseLoopTimes = LastTestCaseHarness;
        } else if ((All.equalsIgnoreCase("All")) && (RegrORIndivORLimit.equalsIgnoreCase("LimitedRegression"))) {
            TestCase = -1;
            EndTestCase = Integer.parseInt(MyEndTestCase);
            EndTestCase = Integer.parseInt(MyEndTestCase);
        } else if (RegrORIndivORLimit.equalsIgnoreCase("Individual")) {
            TestCase = Integer.parseInt(All);
            TestCaseLoopTimes = 1;
            EndTestCase = Integer.parseInt(MyEndTestCase);
        } else if ((All.equalsIgnoreCase("All")) && (RegrORIndivORLimit.equalsIgnoreCase("Individual"))) {
            System.out.println(" Wrong Input :All & Individual");
            TestCase = -1;
            TestCaseLoopTimes = 1;
            EndTestCase = Integer.parseInt(MyEndTestCase);
        } else if ((!All.equalsIgnoreCase("All")) && (RegrORIndivORLimit.equalsIgnoreCase("Regression"))) {
            TestCase = Integer.parseInt(All);
            TestCaseLoopTimes = LastTestCaseHarness;
        } else if ((!All.equalsIgnoreCase("All")) && (RegrORIndivORLimit.equalsIgnoreCase("LimitedRegression"))) {
            TestCase = Integer.parseInt(All);
            TestCaseLoopTimes = Integer.parseInt(MyEndTestCase) - TestCase + 1;
            EndTestCase = Integer.parseInt(MyEndTestCase);
        }
    }

    public static int FailingTestHarnessDiff(String AlgoName, int j) {
        jLoopControlTestCases(j, true);
        return j;
    }

    public static void RegresssionDOE() {
        System.out.print(System.lineSeparator());
        if (EndTestCase > LastTestCaseHarness) {
            EndTestCase = LastTestCaseHarness;
        }
        System.out.print(ConsoleColors.BLUE + "Diff EndTestCase=" + EndTestCase + " LastTestCaseHarness=" + LastTestCaseHarness + ConsoleColors.RESET);
        System.out.print(System.lineSeparator());
        if (EndTestCase < TestCase) {
            EndTestCase = TestCase;
        }
        int j = TestCase;
        FailedTestCases = new HashMap<Integer, String>();
        ExceptionTestCases = new HashMap<Integer, String>();
        cause = new Throwable();
        TotalTestCases = 0;
        ByPassedTestCases = 0;
        MissedNumberTestCases = 0;
        MissedTestCasesInfinity = 0;
        MissedTestCasesException = 0;

        MaxIndexExcept = 0;
        MaxIndexFail = 0;
        SectionIndexFail = 1;
        FailedTestCount = 0;
        int OldFailedTestCount = FailedTestCount;
        int SectionDisplayCntrl = 0;
        FailedTestCases = new HashMap<Integer, String>();
        ExceptionStringDB = new HashMap<Integer, String>();
        int OldMaxIndexFail = 0;
        int OldTotalTestCases = 0;
        boolean TestCasePassStrFlag = false;
        String OverallRegressionStatus = "Diff:Pass All (5019 to 100001) Except Test Cases: "
                + "\n" + "TestCases:Unit Test Cases" + " All Passing"
                + "\n" + "TestCases:Names " + " All Passing"
                + "\n" + "TestCases:Coefficients " + " 20016 , 20017"
                + "\n" + "TestCases:Exponent " + " 30006 to 30008";
        System.out.print(ConsoleColors.BLUE + "Diff Overall Regression Status" + OverallRegressionStatus + ConsoleColors.RESET);
        System.out.print(System.lineSeparator());
        if (EndTestCase > LastTestCaseHarness) {
            EndTestCase = LastTestCaseHarness;
        }
        TestHarnessDOE.ConfigFileName = "DOESelfTestConfig\\DOEConfigDefault";
        while (j <= EndTestCase) {
            String TempExprn = "";
            System.out.println(ConsoleColors.YELLOW + "Test Case " + TestCase + " EndTestCase=" + EndTestCase + " j=" + j + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "Test Case " + TestCase + ConsoleColors.RESET);
            TotalTestCases++;
            TestCasePassHighLevelFlag = false;
            oldTestCasePassHighLevelFlag = false;
            try {
                if ((TestSecEncPerfFLAG == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    if (TimeTaken.length == 3) {
                        TestSecEncStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                    } else {
                        TestSecEncStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                    }
                    System.out.println("Cycle Started:Run Time:" + current + " ");
                }
                TestCasePassStrFlag = false;
                TestHarnessDOE.SanityTestCases("mainDiffTest", j);
                FileInputStream fp = new FileInputStream("data\\" + TestHarnessDOE.ConfigFileName);
                HDOEDefine.Myfscanf(fp);
                System.out.print(System.lineSeparator());
                System.out.println(ConsoleColors.GREEN + "DOETestCase Row=:" + TestHarnessDOE.TestCaseRow + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN + "System Set InputFile:" + TestHarnessDOE.ConfigFileName + ConsoleColors.RESET);
                HDOEDefine.Myprintf();
                System.out.println(ConsoleColors.GREEN + "DOETestCase Row=:" + TestHarnessDOE.TestCaseRow + " TestCaseInternalVar=" + TestCaseInternalVar + ConsoleColors.RESET);
                if (IntegratedTestFlag == true) {
                    UsageSecurity.FailingTestHarnessDiff("mainDiffTest", j);
                } else {
                    Section = "DOE Key Generation";
                    if (TestCase == -1) {
                        SetupAlice("Encrypt");
                        SetupBob("Encrypt");
                        SetupEve("Encrypt");
                    }
                    TestCasePassHappyLowLVLFlag = false;
                    TestCasePassEavesLowLVLFlag = false;
                    System.out.println(ConsoleColors.GREEN + "DOETestCase:Internal State Variables: j=:" + j + " TestCaseInternalVar=" + TestCaseInternalVar + " TestCase=" + TestCase + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.GREEN + " TestCaseRow=" + TestHarnessDOE.TestCaseRow + " TestCasePassHighLevelFlag=" + TestCasePassHighLevelFlag + " oldTestCasePassHighLevelFlag=" + oldTestCasePassHighLevelFlag + " Objctive=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.GREEN + "DOETestCase:Internal State Variables: TestCasePassHappyLowLVLFlag=" + TestCasePassHappyLowLVLFlag + " TestCasePassEavesLowLVLFlag=" + TestCasePassEavesLowLVLFlag + ConsoleColors.RESET);
                    // Happy Path Testing
                    HappyPathTesting();
                    // EavesDropping Path Testing
                    EavesdroppingPathTesting();
                    System.out.println(ConsoleColors.GREEN + "DOETestCase:Internal State Variables: j=:" + j + " TestCaseInternalVar=" + TestCaseInternalVar + " TestCase=" + TestCase + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.GREEN + " TestCaseRow=" + TestHarnessDOE.TestCaseRow + " TestCasePassHighLevelFlag=" + TestCasePassHighLevelFlag + " oldTestCasePassHighLevelFlag=" + oldTestCasePassHighLevelFlag + " Objctive=" + NamesOfTestCase_Objctive + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.GREEN + "DOETestCase:Internal State Variables: TestCasePassHappyLowLVLFlag=" + TestCasePassHappyLowLVLFlag + " TestCasePassEavesLowLVLFlag=" + TestCasePassEavesLowLVLFlag + ConsoleColors.RESET);
                }
                System.out.print(System.lineSeparator());
                if ((TestSecEncPerfFLAG == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                    } else {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                    }
                    System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(TestSecEncStrCurrentTimeTaken))) + " seconds.");
                    TestSecEncStrCurrentTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(TestSecEncStrCurrentTimeTaken)));
                }
                if (TestCasePassHighLevelFlag == true) {
                    ;//DO Nothing as Test Cases Passes
                    // Log Time Taken in DB
                    // DO NOT INCREMENT INDICES
                    LogPassTestCase();
                } else if ((!NamesOfTestCase_Objctive.contains("Default") && (!NamesOfTestCase_Objctive.contains("Dummy")))) {
                    LogFailTestCase();
                }
                System.out.print(System.lineSeparator());
            } catch (Exception MyException) {
                System.out.print(System.lineSeparator());
                System.out.print(System.lineSeparator());
                MyException.printStackTrace();
                System.out.println(ConsoleColors.RED + "TestCase " + TestCase + " due to Exception." + ConsoleColors.RESET);
                System.out.print(System.lineSeparator());
                LogException(TestCasePassStrFlag);
            }
            System.out.print(System.lineSeparator());
            if ((!Section.equalsIgnoreCase("DOE Key Generation")) && (j == SectionTestCaseEnd)) {
                SectionDisplayCntrl = 1;
                GapProcess("mainDiffTest", j, OldTotalTestCases, OldMaxIndexFail, SectionDisplayCntrl, OldFailedTestCount, FailedTestCount, EqnDBDupCount);
                OldFailedTestCount = FailedTestCount;
                OldTotalTestCases = TotalTestCases;
            } else if ((Section.equalsIgnoreCase("DOE Key Generation"))) {
                GapDOE(j, OldTotalTestCases, OldFailedTestCount);
                OldFailedTestCount = FailedTestCount;
                OldTotalTestCases = TotalTestCases;
            }
            j = RegressionControlDOE(j);
            TestCase = j;
        }
        LogDOEReport();
    }

    static void LogException(boolean TestCasePassStrFlag) {
        String Temp = FailedTestCases.get(MaxIndexFail);
        String HashVal = "";
        if ((Temp != null) && (!Temp.equalsIgnoreCase(""))) {
            HashVal = Temp + "," + ":LowLvL=" + TestCasePassStrFlag;
        } else {
            HashVal = "TestCase=" + TestCase + ":LowLvL=" + TestCasePassStrFlag;
        }
        if (HashVal != null) {
            FailedTestCases.put(MaxIndexFail, HashVal);
        } else {
            FailedTestCases.put(MaxIndexFail, "");
        }
        String Temp1 = "";
        if (MaxIndexExcept >= 1) {
            Temp1 = ExceptionTestCases.get(MaxIndexExcept);
        }
        String HashVal1 = "";
        if ((Temp1 != null) && (!Temp1.equalsIgnoreCase(""))) {
            HashVal1 = Temp1 + ",";
        } else {
            HashVal1 = "TestCase=" + TestCase;
        }
        if (HashVal1 != null) {
            ExceptionTestCases.put(MaxIndexExcept, HashVal1);
        } else {
            ExceptionTestCases.put(MaxIndexExcept, "");
        }
        MaxIndexExcept++;
        TestCasePassHighLevelFlag = false;
    }

    static void LogPassTestCase() {
        String Temp = FailedTestCases.get(MaxIndexFail);
        String HashVal = "";
        if ((Temp != null) && (!Temp.equalsIgnoreCase("")) && (!Temp.contains("Section"))) {
            HashVal = Temp + "," + ConsoleColors.GREEN + "TestCase=" + TestCase + ":Str=" + TestCasePassHighLevelFlag + " Obj=" + NamesOfTestCase_Objctive;
            HashVal = HashVal + " Timetaken:=" + TestSecEncStrCurrentTimeTaken + " seconds" + "\n" + ConsoleColors.RESET;
        } else {
            HashVal = ConsoleColors.GREEN + "TestCase=" + TestCase + ":Str=" + TestCasePassHighLevelFlag + " Obj=" + NamesOfTestCase_Objctive;
            HashVal = HashVal + " Timetaken:=" + TestSecEncStrCurrentTimeTaken + " seconds" + "\n" + ConsoleColors.RESET;
        }
        if (HashVal != null) {
            FailedTestCases.put(MaxIndexFail, HashVal);
        } else {
            FailedTestCases.put(MaxIndexFail, "");
        }
        MaxIndexFail++;
    }

    static void LogFailTestCase() {
        String Temp = FailedTestCases.get(MaxIndexFail);
        String HashVal = "";
        if ((Temp != null) && (!Temp.equalsIgnoreCase("")) && (!Temp.contains("Section"))) {
            HashVal = Temp + "," + ConsoleColors.RED + "TestCase=" + TestCase + ":Str=" + TestCasePassHighLevelFlag + " Failed " + " Obj=" + NamesOfTestCase_Objctive;
            HashVal = HashVal + " Timetaken:=" + TestSecEncStrCurrentTimeTaken + " seconds" + "\n" + ConsoleColors.RESET;
        } else {
            HashVal = ConsoleColors.RED + "TestCase=" + TestCase + ":Str=" + TestCasePassHighLevelFlag + " Failed " + " Obj=" + NamesOfTestCase_Objctive;
            HashVal = HashVal + " Timetaken:=" + TestSecEncStrCurrentTimeTaken + " seconds" + "\n" + ConsoleColors.RESET;
        }
        if (HashVal != null) {
            FailedTestCases.put(MaxIndexFail, HashVal);
        } else {
            FailedTestCases.put(MaxIndexFail, "");
        }
        MaxIndexFail++;
        FailedTestCount++;
    }

    static void LogDOEReport() {
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Summary : Total Failed=" + FailedTestCount + " Out of Run TestCases-Dups=" + (TotalTestCases) + " Passed Count=" + (TotalTestCases - FailedTestCount) + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Summary : Total Exceptions=" + MaxIndexExcept + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Summary : ByPassedTestCases=" + ByPassedTestCases + " MissedNumberTestCases=" + MissedNumberTestCases + " MissedTestCasesInfinity=" + MissedTestCasesInfinity + " MissedTestCasesException=" + MissedTestCasesException + ConsoleColors.RESET);
        for (int y = 0; (MaxIndexFail >= 0) && (FailedTestCases != null) && (FailedTestCases.size() > 0) && (y < FailedTestCases.size()); y++) {
            if ((FailedTestCases.get(y) != null) && (FailedTestCases.get(y).contains("Section")) && (FailedTestCases.get(y).contains("Complete # of Failures="))) {
                System.out.print(ConsoleColors.GREEN + FailedTestCases.get(y) + ConsoleColors.RESET);
            } else if (FailedTestCases.get(y) == null) {
                ;
            }
        }
        System.out.print(System.lineSeparator());
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Report Detail : " + " Failed Test Cases are:" + ConsoleColors.RESET);
        for (int y = 0; y < MaxIndexFail; y++) {
            if ((FailedTestCases.get(y) != null) && (!FailedTestCases.get(y).contains("Section")) && (!FailedTestCases.get(y).contains("Complete # of Failures="))) {
                System.out.print(FailedTestCases.get(y));
            }

        }
        System.out.print(System.lineSeparator());
        System.out.println(ConsoleColors.RED + "mainDiffTest: Exception TestCase Summary : Total Exceptions=" + MaxIndexExcept + " Exception Test Cases are:" + ConsoleColors.RESET);
        for (int y = 0; y < MaxIndexExcept; y++) {
            System.out.print(ConsoleColors.RED + " " + ExceptionTestCases.get(y) + ", " + ConsoleColors.RESET);
            if ((y != 0) && (y % 5 == 0)) {
                System.out.print(System.lineSeparator());
            }
        }
        System.out.print(System.lineSeparator());
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Duplicate Summary : " + " EqnDBIndex=" + EqnDBIndex + ConsoleColors.RESET);
        for (int y = 0; y < MaxIndexExcept; y++) {
            System.out.println(ConsoleColors.RED + " " + ExceptionStringDB.get(y) + ", " + ConsoleColors.RESET);
        }
        System.out.print(System.lineSeparator());
    }

    static void LogFullReport() {
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Summary : Total Failed=" + FailedTestCount + " Out of Run TestCases-Dups=" + (TotalTestCases) + " Passed Count=" + (TotalTestCases - FailedTestCount) + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Summary : Total Exceptions=" + MaxIndexExcept + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Summary : ByPassedTestCases=" + ByPassedTestCases + " MissedNumberTestCases=" + MissedNumberTestCases + " MissedTestCasesInfinity=" + MissedTestCasesInfinity + " MissedTestCasesException=" + MissedTestCasesException + ConsoleColors.RESET);
        for (int y = 0; (MaxIndexFail >= 0) && (FailedTestCases != null) && (y < FailedTestCases.size()); y++) {
            if ((FailedTestCases.get(y) != null) && (FailedTestCases.get(y).contains("Section")) && (FailedTestCases.get(y).contains("Complete # of Failures="))) {
                System.out.print(ConsoleColors.GREEN + FailedTestCases.get(y) + ConsoleColors.RESET);
            } else if (FailedTestCases.get(y) == null) {
                ;
            }
        }
        System.out.print(System.lineSeparator());
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Report Detail : Failed Test Cases are:" + ConsoleColors.RESET);

        for (int y = 0; y < MaxIndexFail; y++) {
            if ((FailedTestCases.get(y) != null) && (!FailedTestCases.get(y).contains("Section")) && (!FailedTestCases.get(y).contains("Complete # of Failures="))) {
                System.out.print(FailedTestCases.get(y));
            }

        }
        System.out.print(System.lineSeparator());
        System.out.println(ConsoleColors.RED + "mainDiffTest: Exception TestCase Summary : Total Exceptions=" + MaxIndexExcept + " Exception Test Cases are:" + ConsoleColors.RESET);
        for (int y = 0; y < MaxIndexExcept; y++) {
            System.out.print(ConsoleColors.RED + " " + ExceptionTestCases.get(y) + ", " + ConsoleColors.RESET);
            if ((y != 0) && (y % 5 == 0)) {
                System.out.print(System.lineSeparator());
            }
        }
        System.out.print(System.lineSeparator());
        System.out.println(ConsoleColors.RED + "mainDiffTest: TestCase Duplicate Summary : " + " EqnDBIndex=" + EqnDBIndex + ConsoleColors.RESET);
        for (int y = 0; (y < EqnDB.size()); y++) {
            String Temp = EqnDB.get(y);
            if ((Temp != null) && (Temp.contains(":Dup with"))) {
                System.out.print(ConsoleColors.GREEN + EqnDB.get(y) + ConsoleColors.RESET);
                System.out.print(System.lineSeparator());
            }
        }
        System.out.print(System.lineSeparator());
        for (int y = 0; y < MaxIndexExcept; y++) {
            System.out.println(ConsoleColors.RED + " " + ExceptionStringDB.get(y) + ", " + ConsoleColors.RESET);
        }
        System.out.print(System.lineSeparator());
    }

    static void HappyPathTesting() {
        // Happy Path Testing
        EavesdroppingFlag = false;
        TestCase00006();
        TestCasePassHappyLowLVLFlag = TestCasePassHighLevelFlag;
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        //TestCase000013();
        TestCasePassHappyLowLVLFlag = TestCasePassHighLevelFlag;
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == false)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        } else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        } else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        //TestCase000014();
        TestCasePassHappyLowLVLFlag = TestCasePassHighLevelFlag;
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == false)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        } else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        } else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        //TestCase00021();
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == false)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        } else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        } else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        System.out.println("HappyPathTesting:oldTestCasePassHighLevelFlag=" + oldTestCasePassHighLevelFlag + " TestCasePassHighLevelFlag=" + TestCasePassHighLevelFlag + " TestCasePassHappyLowLVLFlag=" + TestCasePassHappyLowLVLFlag + " TestCasePassEavesLowLVLFlag=" + TestCasePassEavesLowLVLFlag + " TestCase=" + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar);
    }

    static void EavesdroppingPathTesting() {
        // EavesDropping Path Testing
        EavesdroppingFlag = true;
        //TestCase001000();
        TestCasePassEavesLowLVLFlag = TestCasePassHighLevelFlag;
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        //TestCase001001();
        TestCasePassEavesLowLVLFlag = TestCasePassHighLevelFlag;
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == false)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        } else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        } else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        //TestCase001002();
        TestCasePassEavesLowLVLFlag = TestCasePassHighLevelFlag;
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == false)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        } else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        } else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        }
        //TestCase001008();
        if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == false))
            ; else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == false)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        } else if ((oldTestCasePassHighLevelFlag == true)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = true;
        } else if ((oldTestCasePassHighLevelFlag == false)
                && (TestCasePassHighLevelFlag == true)) {
            oldTestCasePassHighLevelFlag = TestCasePassHighLevelFlag;
            TestCasePassHighLevelFlag = false;
        }
        System.out.println("EavesdroppingPathTesting:oldTestCasePassHighLevelFlag=" + oldTestCasePassHighLevelFlag + " TestCasePassHighLevelFlag=" + TestCasePassHighLevelFlag + " TestCasePassHappyLowLVLFlag=" + TestCasePassHappyLowLVLFlag + " TestCasePassEavesLowLVLFlag=" + TestCasePassEavesLowLVLFlag + " TestCase=" + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar);
    }

    static void Regressionmain() {
        //Failing Test Cases :22
        String All = "-1";//-1 OR START TESTCASE NUMBER // Test Case Number : Options :All or a Single Number
        String StartMyTestCase = "-1";//-1
        String MyEndTestCase = "3003";//29//3003//1014//Test Case Number : Options :All or a Single Number
        String RegrORIndivORLimit = "LimitedRegression";

        UsageSecurity TestData = new UsageSecurity(All, MyEndTestCase, RegrORIndivORLimit);

        String xExprn = "Normal Full Regression";
        System.out.println("1) Run Normal Full Regression OR ");
        System.out.println("2) 1 Message Demo(UserInteractive)(Demo) OR ");
        System.out.println("3) DOE(Design Of Experiments) Testing (Random Number Key Regression using Files)[Design][DOEKey][Key]");
        System.out.println("4) DOE Testing (Integrated Regression)[DOEIntegrate][Integrated]");
        System.out.println("5) Exit [E]");
        System.out.println("6) DOEmainHighLevelSecurity OR [DOEH] ");
        System.out.println("7) DOEmainUserTweaks OR [DOEU]");
        System.out.println("8) KeymainUserTweaks OR [KU]");
        System.out.println("9) KeymainTest OR [KT]");
        System.out.print(": Your Choice [" + xExprn + "]:");
        Scanner scanner = new Scanner(System.in);
        String TempxExprn = xExprn.trim();
        String BuildTime="";
        TempxExprn = scanner.nextLine();
        if (TempxExprn.equalsIgnoreCase("")) {
            xExprn = "NormalFullRegression";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 4 minutes 11 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("Normal Full Regression")) || (TempxExprn.equalsIgnoreCase("1"))) {
            xExprn = "NormalFullRegression";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 4 minutes 11 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("2")) || (TempxExprn.equalsIgnoreCase("Demo")) || (TempxExprn.equalsIgnoreCase("UserInteractive"))) {
            xExprn = "UserInteractive";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 34 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("DOEKey")) || (TempxExprn.equalsIgnoreCase("Design")) || (TempxExprn.equalsIgnoreCase("Key")) || (TempxExprn.equalsIgnoreCase("3"))) {
            xExprn = "DOEKeyRegression";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 2 minutes 19 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("DOEIntegrate")) || (TempxExprn.equalsIgnoreCase("Integrated")) || (TempxExprn.equalsIgnoreCase("4"))) {
            xExprn = "DOETestingIntegratedRegression";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 2 minutes 19 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("Exit")) || (TempxExprn.equalsIgnoreCase("E")) || (TempxExprn.equalsIgnoreCase("5"))) {
            return;
        } else if ((TempxExprn.equalsIgnoreCase("DOEmainHighLevelSecurity"))|| (TempxExprn.equalsIgnoreCase("DOEH")) || (TempxExprn.equalsIgnoreCase("6"))) {
            xExprn = "DOEmainHighLevelSecurity";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 9 minutes 2 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("DOEmainUserTweaks")) || (TempxExprn.equalsIgnoreCase("DOEU")) || (TempxExprn.equalsIgnoreCase("7"))  ) {
            xExprn = "DOEmainUserTweaks";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 2 minutes 19 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("KeymainUserTweaks")) || (TempxExprn.equalsIgnoreCase("KU")) || (TempxExprn.equalsIgnoreCase("8"))) {
            xExprn = "KeymainUserTweaks";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 3 minutes 58 seconds)";
        } else if ((TempxExprn.equalsIgnoreCase("KeymainTest")) || (TempxExprn.equalsIgnoreCase("KT")) || (TempxExprn.equalsIgnoreCase("9"))) {
            xExprn = "KeymainTest";
            BuildTime=": Takes:BUILD SUCCESSFUL (total time: 28 minutes 5 seconds)";
        }
        xExprn = xExprn.trim();
        xExprn = eatAll(xExprn, ' ');
        System.out.println("You Entered:" + xExprn + ":Estimated Time" + BuildTime);
        if (xExprn.equalsIgnoreCase("NormalFullRegression")) {
            FullRegresssionTest();
        } else if (xExprn.equalsIgnoreCase("UserInteractive")) {
            UserProgram();
        } else if (xExprn.equalsIgnoreCase("DOEKeyRegression")) {
            RegresssionDOE();
        } else if (xExprn.equalsIgnoreCase("DOETestingIntegratedRegression")) {
            IntegratedTestFlag = true;
            RegresssionDOE();
        }else if (xExprn.equalsIgnoreCase("DOEmainHighLevelSecurity")) {
            DOEmainHighLevelSecurity("Encrypt");
        } else if (xExprn.equalsIgnoreCase("DOEmainUserTweaks")) {
            DOEmainUserTweaks();
        } else if (xExprn.equalsIgnoreCase("KeymainUserTweaks")) {
            KeymainUserTweaks();
        }else if (xExprn.equalsIgnoreCase("KeymainTest")) {
            KeymainTest();
        }

    }

    public static boolean Analysis() {
        System.out.println(ConsoleColors.GREEN + "Analysis" + ConsoleColors.RESET);
        boolean Fail = true;//Fail=true mean TestCase Fails; 
        //Fail=false means Test Case Passes            

        if (Fail == false) {
            System.out.println(ConsoleColors.GREEN + "This Test Case (" + TestCase + ") Passes" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "This Test Case (" + TestCase + ") FAILS" + ConsoleColors.RESET);
        }
        return Fail;
    }

    public static int RegressionControlDOE(int j) {
        if ((j >= -1) && (j < 29)) {
            j++;
        } //Bypass Gaps Section
        else if ((j >= 101) && (j < 113)) {
            j++;
        } //Bypass Gaps Section
        else if ((j >= 1000) && (j < 1019)) {
            j++;
        } else if ((j >= 2001) && (j < 2004)) {
            j++;
        } else if ((j >= 3001) && (j < 3003)) {
            j++;
        } //Bypass Gaps Section
        else if (j < -1) {
            j = -1;
        } else if (j == 29) {
            j = 101;
        } else if (j == 113) {
            j = 1000;
        } else if (j == 1019) {
            j = 2001;
        } else if (j == 2004) {
            j = 3001;
        } else if (j == 3003) {
            j = 4000;
        } else {
            System.out.println(ConsoleColors.RED + "RegressionControl:j= " + j + ": Infinite Loop" + ConsoleColors.RESET);
        }
        return j;

    }

    public static void FullRegresssionTest() {
        System.out.print(System.lineSeparator());
        if (EndTestCase > LastTestCaseHarness) {
            EndTestCase = LastTestCaseHarness;
        }
        System.out.print(ConsoleColors.BLUE + "Diff EndTestCase=" + EndTestCase + " LastTestCaseHarness=" + LastTestCaseHarness + ConsoleColors.RESET);
        System.out.print(System.lineSeparator());
        if (EndTestCase < TestCase) {
            EndTestCase = TestCase;
        }
        int j = TestCase;
        FailedTestCases = new HashMap<Integer, String>();
        ExceptionTestCases = new HashMap<Integer, String>();
        cause = new Throwable();
        TotalTestCases = 0;
        ByPassedTestCases = 0;
        MissedNumberTestCases = 0;
        MissedTestCasesInfinity = 0;
        MissedTestCasesException = 0;

        MaxIndexExcept = 0;
        MaxIndexFail = 0;
        SectionIndexFail = 1;
        FailedTestCount = 0;
        int OldFailedTestCount = FailedTestCount;
        int SectionDisplayCntrl = 0;
        ExceptionStringDB = new HashMap<Integer, String>();
        int OldTestCase = j;
        int OldMaxIndexFail = 0;
        int OldTotalTestCases = 0;
        while (j <= EndTestCase) {
            TestCasePassHighLevelFlag = false;
            System.out.println(ConsoleColors.RED + "mainDiffTest: Begin:j=" + j + " TestCase=" + TestCase);
            OldMaxIndexFail = MaxIndexFail;
            try {
                if ((TestSecEncPerfFLAG == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    if (TimeTaken.length == 3) {
                        TestSecEncStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                    } else {
                        TestSecEncStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
                    }
                    System.out.println("Cycle Started:Run Time:" + current + " ");
                }
                UsageSecurity.FailingTestHarnessDiff("mainDiffTest", j);
                if ((TestSecEncPerfFLAG == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                    } else {
                        localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
                    }
                    System.out.println("Cycle Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(TestSecEncStrCurrentTimeTaken))) + " seconds.");
                    TestSecEncStrCurrentTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(TestSecEncStrCurrentTimeTaken)));
                }
                if (TestCasePassHighLevelFlag == true) {
                    ;//DO Nothing as Test Cases Passes
                    // Log Time Taken in DB
                    // DO NOT INCREMENT INDICES
                    LogPassTestCase();
                } else if ((!NamesOfTestCase_Objctive.contains("Default") && (!NamesOfTestCase_Objctive.contains("Dummy")))) {
                    LogFailTestCase();
                }
            } catch (Exception MyException) {
                System.out.print(System.lineSeparator());
                System.out.print(System.lineSeparator());
                MyException.initCause(cause);
                if (MyException.getCause() != null) {
                    ExceptionStringDB.put(MaxIndexExcept, TestCase + ":" + MyException.getMessage());
                }
                System.out.println(ConsoleColors.RED + "TestCase " + TestCase + " due to Exception." + ConsoleColors.RESET);
                System.out.print(System.lineSeparator());
                MyException.printStackTrace();
                LogException(false);
            }
            System.out.println(ConsoleColors.RED + "mainDiffTest:mainRegresssionDiffTest: End: (j)=" + (j) + " Objective=" + NamesOfTestCase_Objctive);
            System.out.println(ConsoleColors.BLACK + "mainDiffTest:mainRegresssionDiffTest: TestCase=" + TestCase + " EndTestCase=" + EndTestCase);

            if ((j == SectionTestCaseEnd) || (j == 4000)) {
                SectionDisplayCntrl = 1;
                GapProcess("mainDiffTest", j, OldTotalTestCases, OldMaxIndexFail, SectionDisplayCntrl, OldFailedTestCount, FailedTestCount, EqnDBDupCount);
                OldFailedTestCount = FailedTestCount;
                OldTotalTestCases = TotalTestCases;
            }
            j = RegressionControl(j);
            TestCase = j;
            TotalTestCases++;
            TestCasePassHighLevelFlag = false;
            NamesOfTestCase_Objctive = "";
        }

        LogFullReport();
    }

    static void jLoopControlTestCases(int j, boolean ExecuteFuncFlag) {
        if ((j >= -1) && (j <= 29)) {
            Section = "Sanity TestCases ";
            SectionTestCaseStart = -1;
            SectionTestCaseEnd = 29;
            TestCaseFile = "Usage";
            if (ExecuteFuncFlag) {
                SanityTestCases("mainDiffTest", j);
            }
        } else if ((j >= 101) && (j <= 113)) {
            Section = "Shannon Theorems TestCases ";
            SectionTestCaseStart = 101;
            SectionTestCaseEnd = 113;
            TestCaseFile = "ShannonTheorems";
            if (ExecuteFuncFlag) {
                ;//ShannonTestCases("mainDiffTest", j);
            }
        } else if ((j >= 1000) && (j <= 1019)) {
            Section = "Eavesdropping TestCases ";
            SectionTestCaseStart = 1000;
            SectionTestCaseEnd = 1019;
            TestCaseFile = "EavesDropTestCases";
            if (ExecuteFuncFlag) {
                ;//EavesdroppingTestCases("mainDiffTest", j);
            }
        } else if ((j >= 2001) && (j <= 2004)) {
            Section = "Basic Failure Test Cases";
            SectionTestCaseStart = 2001;
            SectionTestCaseEnd = 2004;
            TestCaseFile = "BasicTests";
            if (ExecuteFuncFlag) {
                BasicTestCases("mainDiffTest", j);
            }
        } else if ((j >= 3001) && (j <= 3003)) {
            Section = "PoormansSecurityTheorem Test Cases";
            SectionTestCaseStart = 3001;
            SectionTestCaseEnd = 3003;
            TestCaseFile = "PoormansSecurityTheorem";
            if (ExecuteFuncFlag) {
                PoormansTheoremTestCases("mainDiffTest", j);
            }
        }
    }

    public static int RegressionControl(int j) {
        if ((j >= -1) && (j < 29)) {
            j++;
        } //Bypass Gaps Section
        else if ((j >= 101) && (j < 113)) {
            j++;
        } //Bypass Gaps Section
        else if ((j >= 1000) && (j < 1019)) {
            j++;
        } else if ((j >= 2001) && (j < 2004)) {
            j++;
        } else if ((j >= 3001) && (j < 3003)) {
            j++;
        }//Bypass Gaps Section
        else if (j < -1) {
            j = -1;
        } else if (j == 29) {
            j = 101;
        } else if (j == 113) {
            j = 1000;
        } else if (j == 1019) {
            j = 2001;
        } else if (j == 2004) {
            j = 3001;
        } else if (j == 3003) {
            j = 4000;
        } else {
            System.out.println(ConsoleColors.RED + "RegressionControl:j= " + j + ": Infinite Loop" + ConsoleColors.RESET);
        }
        return j;
    }

    //Process Test Results
    public static boolean TestExecutionResults() {
        System.out.println(ConsoleColors.BLUE + "TestExecutionResults: TestCase= " + TestCase + " Mychar=" + Mychar + " DecryptedByte=" + DecryptedByte + ConsoleColors.RESET);
        if (((Mychar.intValue() == DecryptedByte.intValue()) || (Mychar.intValue() == Math.rint(DecryptedByte))) && (Mychar.intValue() != 0)) {
            System.out.println(ConsoleColors.GREEN + "TestExecutionResults: Test Case Passes TestCase= " + TestCase + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
            Mychar = 0.0;
            DecryptedByte = 0.0;
            return true;
        }
        System.out.println(ConsoleColors.RED + "TestExecutionResults: Test Case Fails TestCase= " + TestCase + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
        Mychar = 0.0;
        DecryptedByte = 0.0;
        return false;
    }

    //Process Test Message
    public static boolean TestExecResultsMessage() {
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: MyMessage=" + MyMessage + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: Length=" + MyMessage.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: EncryptedMesg=" + EncryptedMesg + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: Length=" + EncryptedMesg.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: DecryptedMesg=:" + DecryptedMesg + ":" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TestExecResultsMessage: Length=" + DecryptedMesg.length() + ConsoleColors.RESET);
        
        MyMessage = MyMessage.trim();
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
        if (MyMessage.compareTo(DecryptedMesg.toString()) == 0) {
            System.out.println(ConsoleColors.GREEN + "TestExecResultsMessage: Test Case Passes TestCase= " + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
            return true;
        }
        System.out.println(ConsoleColors.RED + "TestExecResultsMessage: Test Case Fails TestCase= " + TestCase + " TestCaseInternalVar=" + TestCaseInternalVar + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
        return false;
    }

    //XOR Plain Text and Cipher Text
    public static boolean TestExecResultsXORCharDouble(String PlainText, String CipherText) {
        System.out.println(ConsoleColors.BLUE + "TERXORCharDouble: MyMessage=" + MyMessage + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TERXORCharDouble: Length=" + MyMessage.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TERXORCharDouble: EncryptedMesg=" + EncryptedMesg + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TERXORCharDouble: Length=" + EncryptedMesg.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TERXORCharDouble: DecryptedMesg=" + DecryptedMesg + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TERXORCharDouble: Length=" + DecryptedMesg.length() + ConsoleColors.RESET);
        PlainText = PlainText.trim();
        String[] TempCipherText = CipherText.trim().split(",@");
        String m = "";
        int i = 0;
        for (i = 0; (i < PlainText.length()); i++) {
            Double Value = Double.parseDouble(TempCipherText[i]);
            char ValueCharC = (char) Value.intValue();
            char ValueCharP = (char) PlainText.charAt(i);
            int n = (ValueCharP ^ ValueCharC);
            m = m + n;
            //System.out.println(ConsoleColors.GREEN + "TERXORCharDouble:intValue: Guessed n=" + n + " ValueCharP=" + ValueCharP + " ValueCharC=" + ValueCharC + " PlainText.charAt(i)=" + PlainText.charAt(i) + " TempCipherText[i]=" + TempCipherText[i] + ConsoleColors.RESET);
        }
        if (!m.equalsIgnoreCase("")) {
            System.out.println(ConsoleColors.GREEN + "TERXORCharDouble:intValue: Guessed m= " + m + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "TERXORCharDouble:intValue: Test Case Passes TestCase= " + TestCase + ConsoleColors.RESET);
            //return true;
        }
        m = "";
        for (i = 0; (i < PlainText.length()); i++) {
            Double Value = Double.parseDouble(TempCipherText[i]);
            char ValueChar = (char) Value.byteValue();
            int n = (PlainText.charAt(i) ^ ValueChar);
            m = m + n;
            //System.out.println(ConsoleColors.GREEN + "TERXORCharDouble:Byte    : Guessed n=" + n + " ValueChar=" + ValueChar + " PlainText.charAt(i)=" + PlainText.charAt(i) + ConsoleColors.RESET);
        }
        if (!m.equalsIgnoreCase("")) {
            System.out.println(ConsoleColors.GREEN + "TERXORCharDouble:Byte    : Guessed m= " + m + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "TERXORCharDouble:Byte    : Test Case Passes TestCase= " + TestCase + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
            return true;
        }
        System.out.println(ConsoleColors.RED + "TERXORCharDouble: Test Case Fails TestCase= " + TestCase + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
        return false;
    }

    //XOR Plain Text and Cipher Text
    public static boolean TestExecResultsXORDoubleDouble(String PlainText, String CipherText) {
        System.out.println(ConsoleColors.BLUE + "TER XORDoubleDouble: MyMessage=" + MyMessage + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TER XORDoubleDouble: Length=" + MyMessage.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TER XORDoubleDouble: EncryptedMesg=" + EncryptedMesg + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TER XORDoubleDouble: Length=" + EncryptedMesg.length() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TER XORDoubleDouble: DecryptedMesg=" + DecryptedMesg + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "TER XORDoubleDouble: Length=" + DecryptedMesg.length() + ConsoleColors.RESET);
        String[] TempPlainText = PlainText.trim().split(",@");
        String[] TempCipherText = CipherText.trim().split(",@");
        String m = "";
        int i = 0;
        for (i = 0; (i < TempPlainText.length); i++) {
            Double Value = Double.parseDouble(TempCipherText[i]);
            char ValueCharC = (char) Value.intValue();
            Double ValueX = Double.parseDouble(TempPlainText[i]);
            char ValueCharP = (char) ValueX.intValue();
            int n = (ValueCharP ^ ValueCharC);
            m = m + n;
            //System.out.println(ConsoleColors.GREEN + "TERXORDoubleDouble:intValue: Guessed n=" + n + " ValueCharC=" + ValueCharC + " ValueCharP=" + ValueCharP + " TempPlainText[i]=" + TempPlainText[i] + " TempCipherText[i]=" + TempCipherText[i] + ConsoleColors.RESET);
        }
        if (!m.equalsIgnoreCase("")) {
            System.out.println(ConsoleColors.GREEN + "TER XORDoubleDouble:intValue: Guessed m= " + m + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "TER XORDoubleDouble:intValue: Test Case Passes TestCase= " + TestCase + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
            return true;
        }
        System.out.println(ConsoleColors.RED + "TER XORDoubleDouble: Test Case Fails TestCase= " + TestCase + " Objctive=" + NamesOfTestCase_Objctive + " Section=" + Section + ConsoleColors.RESET);
        return false;
    }

    //Process Gap && Store Fail Test Cases
    public static void GapProcess(String AlgoName, int CurrentTestCase, int OldTotalTestCases, int OldMaxIndexFail, int SectionDisplayCntrl, int OldFailedTestCount, int FailedTestCount, int DupsCur) {
        String SpacePad = "";
        int i = 0;
        for (; (i < Section.length()); i++) {
            if ((Section != null) && (Section.charAt(i) != ' ')) {
                SpacePad = SpacePad + (char) Section.charAt(i);
            } else {
                SpacePad = SpacePad + (char) ' ';
            }
        }
        for (; i < 28; i++) {
            SpacePad += (char) ' ';
        }
        if ((SectionDisplayCntrl == 1) && (!Section.equalsIgnoreCase("DOE Key Generation"))) {
            String Temp = "";
            Temp = "Section " + SpacePad + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
            FailedTestCases.put(MaxIndexFail, Temp);
            MaxIndexFail++;
            MaxIndexFail++;
        }
    }

    public static void GapDOE(int j, int OldTotalTestCases, int OldFailedTestCount) {
        if ((j >= -1) && (j <= 29)) {
            SectionReportHeading = "Sanity TestCases ";
            SectionTestCaseStart = -1;
            SectionTestCaseEnd = 29;
            TestCaseFile = "Usage";
            if (j == SectionTestCaseEnd) {
                String Temp = "";
                Temp = "Section " + SectionReportHeading + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
                FailedTestCases.put(MaxIndexFail, Temp);
                MaxIndexFail++;
                MaxIndexFail++;
            }
        } else if ((j >= 101) && (j <= 113)) {
            SectionReportHeading = "Shannon Theorems TestCases ";
            SectionTestCaseStart = 101;
            SectionTestCaseEnd = 113;
            TestCaseFile = "ShannonTheorems";
            if (j == SectionTestCaseEnd) {
                String Temp = "";
                Temp = "Section " + SectionReportHeading + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
                FailedTestCases.put(MaxIndexFail, Temp);
                MaxIndexFail++;
                MaxIndexFail++;
            }
        } else if ((j >= 1000) && (j <= 1019)) {
            SectionReportHeading = "Eavesdropping TestCases ";
            SectionTestCaseStart = 1000;
            SectionTestCaseEnd = 1019;
            TestCaseFile = "EavesDropTestCases";
            if (j == SectionTestCaseEnd) {
                String Temp = "";
                Temp = "Section " + SectionReportHeading + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
                FailedTestCases.put(MaxIndexFail, Temp);
                MaxIndexFail++;
                MaxIndexFail++;
            }
        } else if ((j >= 2001) && (j <= 2004)) {
            SectionReportHeading = "Basic Failure Test Cases";
            SectionTestCaseStart = 2001;
            SectionTestCaseEnd = 2004;
            TestCaseFile = "BasicTests";
            if (j == SectionTestCaseEnd) {
                String Temp = "";
                Temp = "Section " + SectionReportHeading + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
                FailedTestCases.put(MaxIndexFail, Temp);
                MaxIndexFail++;
                MaxIndexFail++;
            }
        } else if ((j >= 3001) && (j <= 3003)) {
            SectionReportHeading = "PoormansSecurityTheorem Test Cases";
            SectionTestCaseStart = 3001;
            SectionTestCaseEnd = 3003;
            TestCaseFile = "PoormansSecurityTheorem";
            if (j == SectionTestCaseEnd) {
                String Temp = "";
                Temp = "Section " + SectionReportHeading + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
                FailedTestCases.put(MaxIndexFail, Temp);
                MaxIndexFail++;
                MaxIndexFail++;
            }
        } else {
            SectionReportHeading = "PoormansSecurityTheorem Test Cases";
            SectionTestCaseStart = 3001;
            SectionTestCaseEnd = 3003;
            TestCaseFile = "PoormansSecurityTheorem";
            if (j == SectionTestCaseEnd) {
                String Temp = "";
                Temp = "Section " + SectionReportHeading + " Complete" + " # of Failures=" + (FailedTestCount - OldFailedTestCount) + " Out of=" + (TotalTestCases - OldTotalTestCases) + " in Section \n";
                FailedTestCases.put(MaxIndexFail, Temp);
                MaxIndexFail++;
                MaxIndexFail++;
            }
        }
    }

    //Sanity Test Cases
    public static void SanityTestCases(String AlgoName, int j) {
        System.out.println(ConsoleColors.BLACK + "TestCase:j= " + j + ConsoleColors.RESET);
        switch (j) {
            case -1:
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** Sanity TestCases Begins *************** */");
                TestCaseM00001();
                break;
            case 0:
                TestCase0000();
                break;
            case 1:
                TestCase00001();
                break;
            case 2:
                TestCase00002();
                break;
            case 3:
                TestCase00003();
                break;
            case 4:
                TestCase00004();
                break;
            case 5:
                TestCase00005();
                break;
            case 6:
                TestCase00006();
                break;
            case 7://Julius Caeser Encryption && Decryption:Simple
                TestCase00007();
                break;
            case 8:
                TestCase00008();
                break;
            case 9:
                TestCase00009();
                break;
            case 10:
                TestCase000010();
                break;
            case 11://Julius Caeser Encryption && Decryption:Complex
                TestCase000011();
                break;
            case 12:
                TestCase000012();
                break;
            case 13:
                TestCase000013();
                break;
            case 14://KeyLength=1000
                TestCase000014();
                break;
            // Test Strategy: Guess m & c of each stage
            case 15://Guess m & c:ShannonSimEncrypt
                TestCase000015();
                break;
            case 16://Guess m & c:RotateStrEncrypt
                TestCase000016();
                break;
            case 17://Guess m & c:Whole:JumbleEncrypt
                TestCase000017();
                break;
            case 18://Guess m & c:ShannonSimEncrypt:JumbleEncrypt
                TestCase000018();
                break;
            case 19://Guess m & c:ShannonSimEncrypt:WeibullEncrypt
                TestCase000019();
                break;
            case 20://Guess m & c:ShannonSimEncrypt:WorkFactorEncrypt
                TestCase00020();
                break;
            case 21://Guess m & c:ShannonSimEncrypt:ShannonSimDecrypt
                TestCase00021();
                break;
            case 22:
                TestCase00022();//KeyLength=200
                break;
            case 23:
                //TestCase00023();//Large Number of Times, Long Key Length
                break;
            case 24:
                TestCase00024();//ODD Message Length:A Nmeumonic
                break;
            case 25:
                TestCase00025();//EVEN Message Length:A Nmeumonic
                break;
            case 26:
                TestCase00026();//HelloWorld:A Palindrome
                break;
            case 27:
                TestCase00027();//Short Key Length:20 pairs
                break;
            case 28:
                TestCase00028();// TestCase 6 with Long Message
                break;
            case 29:
                TestCase00029();
                System.out.println("/************************** Sanity TestCases Ends *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                System.out.println("/************************** ************************** *************** */");
                break;
            default:
                System.out.println(ConsoleColors.RED + "SanityTestCases TestCase:j= " + j + ": Gap" + ConsoleColors.RESET);
                break;
        }
    }

    public static void TestCase0000Default() {
        //Test Case 000Default
        NamesOfTestCase_Objctive = "DefaultDummy";
        TestCasePassHighLevelFlag = false;
    }

    public static void TestCaseM00001() {
        //Test Case -1
        TestCaseInternalVar = -1;
        NamesOfTestCase_Objctive = "InitialSanity TestCase";

        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");

        StudyOfPoorManSecurityLin();
        TestCasePassHighLevelFlag = TestExecutionResults();
        System.out.println(System.lineSeparator());
        StudyOfPoorManSecurityValues();
        TestCasePassHighLevelFlag = TestExecutionResults();
        System.out.println(System.lineSeparator());
        StudyOfPoorManSecurityValuesM();
        TestCasePassHighLevelFlag = TestExecutionResults();
        System.out.println(System.lineSeparator());
        Mychar = 'a' * 1.0;
        StudyOfValuesMLinearStates(false);
        TestCasePassHighLevelFlag = TestExecutionResults();
    }

    public static void TestCase0000() {
        //Test Case 000
        TestCaseInternalVar = 0;
        NamesOfTestCase_Objctive = "NewKeyGeneration";
        SetupAlice("Encrypt");

        SetupBob("Encrypt");
        Mychar = 'a' * 1.0;
        TestCaseM00001();
    }

    public static void TestCase00001() {
        //Test Case 001
        TestCaseInternalVar = 1;
        NamesOfTestCase_Objctive = "Extreme Values";
        //Extreme Values of 'a' to 'z' && 'A' to 'Z'
        SetupAlice("Encrypt");

        SetupBob("Encrypt");
        SetupEve("Encrypt");
        Mychar = 'a' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecutionResults();

        Mychar = 'z' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecutionResults();

        Mychar = 'A' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecutionResults();

        Mychar = 'Z' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecutionResults();

    }

    public static void TestCase00002() {
        //Test Case 002
        TestCaseInternalVar = 2;
        //All Characters -1 to 0xFF
        NamesOfTestCase_Objctive = "All Characters";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        for (int i = -1; i <= 0xFF; i++) {
            Mychar = i * 1.0;
            StudyOfValuesMLinearStates(true);
            TestCasePassHighLevelFlag = TestExecutionResults();
        }
    }

    public static void TestCase00003() {
        //Test Case 003
        TestCaseInternalVar = 3;
        // Static Message Encryption && Decryption
        NamesOfTestCase_Objctive = "Static Message:BasicEncryptDecrypt:QuickBrown";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");
        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00004() {
        //Test Case 004
        TestCaseInternalVar = 4;
        // Shannon Diffusion 
        // Static Message Encryption && Decryption
        NamesOfTestCase_Objctive = "Static Message:Shannon Diffusion:QuickBrown";
        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageShannon(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageShannon(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00005() {
        //Test Case 005
        TestCaseInternalVar = 5;
        // Shannon Simple  
        // Static Message Encryption && Decryption
        NamesOfTestCase_Objctive = "Static Message:Shannon Simple:QuickBrown";
        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageShannonSimple(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageShannonSimple(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00006() {
        //Test Case 006
        TestCaseInternalVar = 6;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPrivateKey("Encrypt")));
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getPublicKey("Encrypt")) );
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(AliceKeyPair.getSymmetricKey()) );

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey("Encrypt")));
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPublicKey("Encrypt")));
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(BobKeyPair.getPrivateKey()));
        
        System.out.println("Eve:");
        System.out.println("Eve:PrivateKey=" + EveKeyPair.getPrivateKey("Encrypt") + " Length=" + EveKeyPair.getPrivateKey("Encrypt").length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPrivateKey("Encrypt")));
        System.out.println("Eve:PublicKey=" + EveKeyPair.getPublicKey("Encrypt") + " Length=" + EveKeyPair.getPublicKey("Encrypt").length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPublicKey("Encrypt")) );
        //System.out.println("Eve:SymmetricKey=" + EveKeyPair.getSymmetricKey() + " Length=" + EveKeyPair.getSymmetricKey().length() + " DoubleValue=" + Double.parseDouble(EveKeyPair.getPrivateKey()));
        
        
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage ="Hel";
        //MyMessage = "1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage = "4{}[]";
        MesgINCAPS=false;
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage = "HEL";
        //MyMessage = "1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage = "4{}[]";
        MesgINCAPS=true;
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00007() {
        //Test Case 007
        TestCaseInternalVar = 7;
        // Shannon Simple  
        // Julius Caeser Encryption && Decryption
        NamesOfTestCase_Objctive = "Julius Caeser Encryption && Decryption:Simple";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt"));
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt"));
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt"));
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt"));
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey());

        // All small Case
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        Double Rand = JuliusCaeserEncryptSimple(MyMessage);
        JuliusCaeserDecryptSimple(EncryptedMesg.toString(), Rand);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        // All CAPS Case
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        Rand = JuliusCaeserEncryptSimple(MyMessage);
        JuliusCaeserDecryptSimple(EncryptedMesg.toString(), Rand);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        // Camel Case
        MyMessage = "The Quick Brown Fox Jumps Over The Lazy Dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        Rand = JuliusCaeserEncryptSimple(MyMessage);
        JuliusCaeserDecryptSimple(EncryptedMesg.toString(), Rand);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00008() {
        //Test Case 008
        TestCaseInternalVar = 8;
        NamesOfTestCase_Objctive = "Extreme Values";
        //Extreme Values of 'a' to 'z' && 'A' to 'Z'
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        Mychar = 'a' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(false);
        TestCasePassHighLevelFlag = TestExecutionResults();

        Mychar = 'z' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(false);
        TestCasePassHighLevelFlag = TestExecutionResults();

        Mychar = 'A' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(false);
        TestCasePassHighLevelFlag = TestExecutionResults();

        Mychar = 'Z' * 1.0;
        System.out.println(System.lineSeparator());
        StudyOfValuesMLinearStates(false);
        TestCasePassHighLevelFlag = TestExecutionResults();

    }

    public static void TestCase00009() {
        //Test Case 009
        TestCaseInternalVar = 9;
        //All Characters -1 to 0xFF
        NamesOfTestCase_Objctive = "All Characters";
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        for (int i = -1; i <= 0xFF; i++) {
            Mychar = i * 1.0;
            StudyOfValuesMLinearStates(true);
            TestCasePassHighLevelFlag = TestExecutionResults();
        }
    }

    public static void TestCase000010() {
        //Test Case 010
        TestCaseInternalVar = 10;
        // Static Message Encryption && Decryption
        NamesOfTestCase_Objctive = "Static Message:BasicEncryptDecrypt:QuickBrown";
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageMLinearStates(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase000011() {
        //Test Case 011
        TestCaseInternalVar = 11;
        // Julius Caeser Encryption && Decryption
        NamesOfTestCase_Objctive = "Julius Caeser Encryption && Decryption:Complex";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());


        // All small Case
        MyMessage = "the quick brown fox jumps over the lazy dog.";
        Double Rand = JuliusCaeserEncryptComplex(MyMessage);
        JuliusCaeserDecryptComplex(EncryptedMesg.toString(), Rand);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        // All CAPS Case
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.";
        Rand = JuliusCaeserEncryptComplex(MyMessage);
        JuliusCaeserDecryptComplex(EncryptedMesg.toString(), Rand);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        // Camel Case
        MyMessage = "The Quick Brown Fox Jumps Over The Lazy Dog.";
        Rand = JuliusCaeserEncryptComplex(MyMessage);
        JuliusCaeserDecryptComplex(EncryptedMesg.toString(), Rand);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase000012() {
        //Test Case 012
        TestCaseInternalVar = 12;
        // Shannon Simple  
        // Static Message Encryption && Decryption
        NamesOfTestCase_Objctive = "Static Message:Shannon Simple:QuickBrown";
        //Complete Message
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageShannonSimple(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MessageShannonSimple(true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase000013() {
        //Test Case 013
        TestCaseInternalVar = 13;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption.Keylength=100";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());


        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase000014() {
        //Test Case 014
        TestCaseInternalVar = 14;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:KeyLength=200";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        SetupEve("Encrypt");

        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());


        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase000015() {
        //Test Case 015
        TestCaseInternalVar = 15;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:ShannonSimEncrypt";
        boolean SilentFlag = true;
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        System.out.println("Test Case 015:MyPublicEquation=" + MyPublicEquation);
        System.out.println("Test Case 015:ExprnDiffusion=" + ExprnDiffusion);
        System.out.println("Test Case 015:ExprnSurprise=" + ExprnSurprise);
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
        System.out.println("Test Case 015:EncryptedMesg=" + EncryptedMesg);
        TestCasePassHighLevelFlag = TestExecResultsXORCharDouble(MyMessage, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();

        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
            
        }
        TestCasePassHighLevelFlag = TestExecResultsXORCharDouble(MyMessage, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
    }

    public static void TestCase000016() {
        //Test Case 016
        TestCaseInternalVar = 16;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:RotateStrEncrypt";
        boolean SilentFlag = true;
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
        String[] MyCharDropped=EncryptedMesg.toString().split(",@");
        int StrlenRotate1=MyCharDropped.length;
        StringBuilder NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate1, StrlenRotate1,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        TestCasePassHighLevelFlag = TestExecResultsXORCharDouble(MyMessage, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
            
        }
        MyCharDropped=EncryptedMesg.toString().split(",@");
        StrlenRotate1=MyCharDropped.length;
        NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate1, StrlenRotate1,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        TestCasePassHighLevelFlag = TestExecResultsXORCharDouble(MyMessage, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
    }

    public static void TestCase000017() {
        //Test Case 017
        TestCaseInternalVar = 17;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:Whole:JumbleEncrypt";
        boolean SilentFlag = true;
        String EncryptedMesgTemp = "";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        System.out.println("TestCase000017:MyPublicEquation=" + MyPublicEquation);
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
        String[] MyCharDropped=EncryptedMesg.toString().split(",@");
        int StrlenRotate1=MyCharDropped.length;
        StringBuilder NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate1, StrlenRotate1,SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        EncryptedMesg = new StringBuilder(JumbleStrEncrypt(EncryptedMesg.toString(), "Double", SilentFlag) );
        TestCasePassHighLevelFlag = TestExecResultsXORCharDouble(MyMessage, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
            
        }
        MyCharDropped=EncryptedMesg.toString().split(",@");
        StrlenRotate1=MyCharDropped.length;
        NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        NewEncryptedMesg = RotateStrEncrypt(NewEncryptedMesg, "Double", OffsetRotate1, StrlenRotate1, SilentFlag);
        EncryptedMesg=NewEncryptedMesg;
        TestCasePassHighLevelFlag = TestExecResultsXORCharDouble(MyMessage, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
    }

    public static void TestCase000018() {
        //Test Case 018
        TestCaseInternalVar = 18;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:ShannonSimEncrypt:JumbleEncrypt";
        boolean SilentFlag = true;
        String EncryptedMesgTemp = "";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        EncryptedMesg = new StringBuilder(JumbleStrEncrypt(EncryptedMesg.toString(), "Double", SilentFlag) );
        TestCasePassHighLevelFlag = TestExecResultsXORDoubleDouble(EncryptedMesgTemp, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        EncryptedMesg = new StringBuilder(JumbleStrEncrypt(EncryptedMesg.toString(), "Double", SilentFlag) );
        TestCasePassHighLevelFlag = TestExecResultsXORDoubleDouble(EncryptedMesgTemp, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
    }

    public static void TestCase000019() {
        //Test Case 019
        TestCaseInternalVar = 19;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:ShannonSimEncrypt:WeibullEncrypt";
        boolean SilentFlag = true;
        String EncryptedMesgTemp = "";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        //WeibullEncrypt(EncryptedMesg, MDivisor, 1234.2, 1234.2, SilentFlag);
        TestCasePassHighLevelFlag = TestExecResultsXORDoubleDouble(EncryptedMesgTemp, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        WeibullEncrypt(EncryptedMesg.toString(), 1234.2, 1234.2, SilentFlag);
        TestCasePassHighLevelFlag = TestExecResultsXORDoubleDouble(EncryptedMesgTemp, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
    }

    public static void TestCase00020() {
        //Test Case 020
        TestCaseInternalVar = 20;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:ShannonSimEncrypt:WorkFactorEncrypt";
        boolean SilentFlag = true;
        String EncryptedMesgTemp = "";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");
        
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp = MyMessage.split("");
        String[] Temp= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp.length; i++) {
            ShannonSimEncrypt(Temp[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        StringBuilder NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        WorkFactorEncrypt(NewEncryptedMesg, 1234, SilentFlag);
        TestCasePassHighLevelFlag = TestExecResultsXORDoubleDouble(EncryptedMesgTemp, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        NewEncryptedMesg=new StringBuilder(EncryptedMesg);
        WorkFactorEncrypt(NewEncryptedMesg, 1234, SilentFlag);
        TestCasePassHighLevelFlag = TestExecResultsXORDoubleDouble(EncryptedMesgTemp, EncryptedMesg.toString());
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
    }

    public static void TestCase00021() {
        //Test Case 021
        TestCaseInternalVar = 21;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple:Guess m & c:ShannonSimEncrypt:ShannonSimDecrypt";
        boolean SilentFlag = true;
        String EncryptedMesgTemp = "";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        //Complete Message
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        UserStrings_EncryptMesgSimple_Entropy();
        System.out.println("/************************** Encryption Begins *************** */");

        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp1 = MyMessage.split("");
        String[] Temp1= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp1[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp1.length; i++) {
            ShannonSimEncrypt(Temp1[i], SilentFlag);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        String[] Temp = DecryptedMesg.toString().split(",@");
        int NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) ) {
                ShannonSimDecrypt(Temp[i], SilentFlag);
                //i = i + SuccessiveCharsLenSim;
            }
        }
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyPublicKey = BobKeyPair.getPublicKey("Encrypt");
        MyPrivateKey = AliceKeyPair.getPrivateKey("Encrypt");
        MyPublicEquation = EqnUnderTest;
        // Diffusion Parameters
        // Surprise Parameters
        variables.put("diffusiond2", diffusiond2);
        variables.put("diffusionN", diffusionN);
        variables.put("confusionA", confusionA);
        //String[] Temp2 = MyMessage.split("");
        String[] Temp2= new String[MyMessage.length()];
        for(int i=0; i < MyMessage.length(); i++){
            Temp2[i]=""+MyMessage.charAt(i);
        }
        for (int i = 0; i < Temp2.length; i++) {
            ShannonSimEncrypt(Temp2[i], true);
            
        }
        EncryptedMesgTemp = EncryptedMesg.toString();
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        Temp = DecryptedMesg.toString().split(",@");
        NumOfChars = Temp.length - 1;
        DecryptedMesg =new StringBuilder("");
        MyPublicKey = AliceKeyPair.getPublicKey("Decrypt");
        MyPrivateKey = BobKeyPair.getPrivateKey("Decrypt");
        MyDecrptionEquation = InverseEqnUnderTest;
        for (int i = 0; i <= NumOfChars; i++) {
            if ((Temp[i] != null) && (!Temp[i].equalsIgnoreCase("")) && (Double.isFinite(Double.valueOf(Temp[i])))) {
                ShannonSimDecrypt(Temp[i], SilentFlag);
                //i = i + SuccessiveCharsLenSim;
            }
        }
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variables.clear();
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
    }

    public static void TestCase00022() {
        //Test Case 022
        TestCaseInternalVar = 22;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:KeyLength=200";
        SetupAlice("Encrypt");
        System.out.println("Alice:");
        System.out.println("Alice:PrivateKey=" + AliceKeyPair.getPrivateKey("Encrypt") + " Length=" + AliceKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Alice:PublicKey=" + AliceKeyPair.getPublicKey("Encrypt") + " Length=" + AliceKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Alice:SymmetricKey=" + AliceKeyPair.getSymmetricKey() + " Length=" + AliceKeyPair.getSymmetricKey().length());

        SetupBob("Encrypt");
        System.out.println("Bob:");
        System.out.println("Bob:PrivateKey=" + BobKeyPair.getPrivateKey("Encrypt") + " Length=" + BobKeyPair.getPrivateKey("Encrypt").length());
        System.out.println("Bob:PublicKey=" + BobKeyPair.getPublicKey("Encrypt") + " Length=" + BobKeyPair.getPublicKey("Encrypt").length());
        //System.out.println("Bob:SymmetricKey=" + BobKeyPair.getSymmetricKey() + " Length=" + BobKeyPair.getSymmetricKey().length());

        //Complete Message
        MyMessage = "1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.";
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        
    }

    public static void TestCase00023() {
        //Test Case 023
        TestCaseInternalVar = 23;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:HelloWorld:NumberOfTimes";
        //Complete Message
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        MyMessage = "hello";
        NumberOfTimes = 3;
        NumberOfTimesOrg = 3;
        CyclicFlag = true;
        EncryptMesgSimple("1", true);
        CyclicFlag = false;
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "Hello";
        NumberOfTimes = 3;
        NumberOfTimesOrg = 3;
        CyclicFlag = true;
        EncryptMesgSimple("2", true);
        CyclicFlag = false;
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
    }

    public static void TestCase00024() {
        //Test Case 024
        TestCaseInternalVar = 24;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:93:ODD Message Length:A Nmeumonic";
        System.out.println("Alice:");
        SetupAlice("Encrypt");
        System.out.println("Bob:");
        SetupBob("Encrypt");
        //Complete Message
        MyMessage = "How I like a drink, alcoholic of course, after a dull and heavy chapter of Quantum Mechanics.";
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "How I Like A Drink, Alcoholic Of Course, After A Dull And Heavy Chapter Of Quantum Mechanics.";
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00025() {
        //Test Case 025
        TestCaseInternalVar = 25;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:92:EVEN Message Length:A Nmeumonic";
        //Complete Message
        SetupAlice("Encrypt");

        SetupBob("Encrypt");
        MyMessage = "How I like a drink, alcoholic of course, after a dull and heavy chapter of Quantum Mechanics";
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "How I Like A Drink, Alcoholic Of Course, After A Dull And Heavy Chapter Of Quantum Mechanics";
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00026() {
        //Test Case 026
        TestCaseInternalVar = 26;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:HelloWorld:A Palindrome";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");
        //Complete Message
        MyMessage = "able was I ere I saw elba.";
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "Able Was I Ere I Saw Elba.";
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00027() {
        //Test Case 027
        TestCaseInternalVar = 27;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:Short Key Length";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");

        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00028() {
        //Test Case 028
        TestCaseInternalVar = 28;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:Long Message";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");

        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyMessage += MyMessage;
        MyMessage += MyMessage;
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyMessage += MyMessage;
        MyMessage += MyMessage;
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
    }

    public static void TestCase00029() {
        //Test Case 029
        TestCaseInternalVar = 29;
        // Shannon Simple  
        // Key Sensitivity Encryption && Decryption
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:(Mid Point + 1) Character Dropped";
        SetupAlice("Encrypt");
        SetupBob("Encrypt");

        //MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyMessage = "helloworld";
        //MyMessage = "hatl";
        EncryptMesgSimple("1", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();
        //MyMessage = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        MyMessage = "HELLOWORLD";
        //MyMessage = "HATL";
        EncryptMesgSimple("2", true);
        TestCasePassHighLevelFlag = TestExecResultsMessage();

    }
}
