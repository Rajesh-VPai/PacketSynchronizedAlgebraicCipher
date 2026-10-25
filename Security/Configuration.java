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
import static Calculus.MathsExpressionParser.parse;
import Calculus.MathsExpressionParser;
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
import static RandomNumber.UserResearchStudy.Xn_LCG;
import static RandomNumber.UserResearchStudy.Xn_LCG3;
import static RandomNumber.UserResearchStudy.Xn_LCGDyDx;
import static RandomNumber.UserResearchStudy.Xn_LCGDyDx4;
import static RandomNumber.UserResearchStudy.Xn_XOR;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.b;
import static RandomNumber.UserResearchStudy.c;
import static RandomNumber.UserResearchStudy.d;
import static Security.Calibration.CalibrationSender;
import static Security.Decryption.CyclicDecrypt;
import static Security.Decryption.DecryptedMesg;
import static Security.Decryption.NoSenderReceivermain;
import static Security.Encryption.CyclicEncrypt;
import static Security.Encryption.EncryptedMesg;
import static Security.Encryption.MyMessage;
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
import static Security.EquationPairGeneration.InvTempSurprise;
import static Security.EquationPairGeneration.InvTranspComputerDiffWithRespTo;
import static Security.EquationPairGeneration.InvTranspComputerExprn;
import static Security.EquationPairGeneration.InvTranspositionDiffWithRespTo;
import static Security.EquationPairGeneration.InvTranspositionExprn;
import static Security.EquationPairGeneration.TranspComputerDiffWithRespTo;
import static Security.EquationPairGeneration.TranspComputerExprn;
import static Security.EquationPairGeneration.TranspositionDiffWithRespTo;
import static Security.EquationPairGeneration.TranspositionExprn;
import static Security.EquationPairGeneration.confusionA;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.diffusiond2;
import static Security.LowLevelSecurityFramework.OccaLowerLimitFE;
import static Security.LowLevelSecurityFramework.OccaLowerLimitSE;
import static Security.LowLevelSecurityFramework.OccaUpperLimitFE;
import static Security.LowLevelSecurityFramework.OccaUpperLimitSE;
import static Security.PacketSynchronizedAlgebraicCipher.EveKeyPair;
import static Security.PacketSynchronizedAlgebraicCipher.MesgINCAPS;
import static Security.PacketSynchronizedAlgebraicCipher.RunNumber;
import static Security.PacketSynchronizedAlgebraicCipher.SetupAlice;
import static Security.PacketSynchronizedAlgebraicCipher.SetupBob;
import static Security.PacketSynchronizedAlgebraicCipher.SetupEve;
import static Security.PacketSynchronizedAlgebraicCipher.StrGUI;
import static Security.PacketSynchronizedAlgebraicCipher.SuperSuppressOutput;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.Security.AliceKeyPair;
import static Security.Security.BobKeyPair;
import static Security.Security.MyDecrptionEquation;
import static Security.Security.MyMessage2;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.MySimpleWeiBull;
import static Security.Security.ScramVarGapExprn;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import static Security.Security.variablesStr;
import static Security.SecurityTestHarness.ConfirmedFirstEvent;
import static Security.SecurityTestHarness.ConfirmedSecondEvent;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static Security.SecurityTestHarness.OccasionNoOfTimesIndex;
import static Security.SecurityTestHarness.OccasionNumberOfTimes;
import static Security.SecurityTestHarness.TimeReading;
import static Security.SecurityTestHarness.TimeStart;
import static Security.UsageSecurity.Regressionmain;
import static Security.UsageSecurity.NamesOfTestCase_Objctive;
import static Security.UsageSecurity.TestCase;
import static Security.UsageSecurity.TestCaseInternalVar;
import static Security.UsageSecurity.TestExecResultsMessage;
import static SenderReceiverGUI.Receiver.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class Configuration {

    public static Logger log = Logger.getLogger(Configuration.class.getName());

    public static boolean CyclicFlag = false;//If true calls the Poormans Security a second time
    public static int NumberOfTimes = 1;
    public static int NumberOfTimesOrg = 1;
    public static boolean USE_AES = false;//false = FULL USER CONTROL OVER SOURCE CODE  or true USE MODERN CRYPTOGRAPHIC METHODS
    public static String USEUDP = "USETCP";//USEUDP or USETCP
    public static int UDPBuffLen = 8192;//5;//1024;//8192;
    public static String MessageInvariant = "MessageInvariant";//MessageInvariant OR MessageVariant
    public static String FOBRandomChar = "FOBStandardChar";//Valid Values are : FOBRandomChar :FOBStandardChar
    public static String SecurityPosture = "Normal";//ChangeKeysAfterEveryUse or Normal or WeightedN
    public static int NumberOfFractions = 4; // Minimum =2; Maximum=10;
    public static String PRAGMA = "Normal";//Paranoid , Normal, Strict
    public static String PRAGMADetail = "Normal";//Paranoid , Normal, Strict

    private static String[][] AlicePairKeys = null;
    private static String[][] BobPairKeys = null;
    private static String[][] EvePairKeys = null;
    
    private static String[][] AlicePairKeysQuality = null;
    private static String[][] BobPairKeysQuality = null;
    private static String[][] EvePairKeysQuality = null;
    
    private static String[][] AlicePairKeysQualityLowLvl = null;
    private static String[][] BobPairKeysQualityLowLvl = null;
    private static String[][] EvePairKeysQualityLowLvl = null;
    
    // Frequency Analysis Variables
    private static int[] FrequencyBufferAlice = new int[11];
    private static int[] FrequencyBufferBob = new int[11];
    private static int[] FrequencyBufferEve = new int[11];

    public static int[] AnalysisBufferAlice = new int[1002];
    public static int[] AnalysisBufferBob = new int[102];
    public static int[] AnalysisBufferEve = new int[102];

    public static int[] PatternBufferAlice = new int[102];
    public static int[] PatternBufferBob = new int[102];
    public static int[] PatternBufferEve = new int[102];

    public static int ZeroDigitCountAlice = 0;
    public static int ZeroDigitCountBob = 0;
    public static int ZeroDigitCountEve = 0;
    public static int RepetionDigitCountAlice = 0;
    public static int RepetionDigitCountBob = 0;
    public static int RepetionDigitCountEve = 0;

    public static Long[] PrimeArray = new Long[10000];
    public static int LastIndex=10000;
    
    static String[] OATSType2DigitPattern = {
"1 1 ",//Row=0  Unique Row 
"1 2 ",//Row=1  Unique Row 
"1 3 ",//Row=2  Unique Row 
"1 4 ",//Row=3  Unique Row 
"1 5 ",//Row=4  Unique Row 
"1 6 ",//Row=5  Unique Row 
"1 7 ",//Row=6  Unique Row 
"1 8 ",//Row=7  Unique Row 
"1 9 ",//Row=8  Unique Row 
"1 0 ",//Row=9  Unique Row 
"2 1 ",//Row=10  Unique Row 
"2 2 ",//Row=11  Unique Row 
"2 3 ",//Row=12  Unique Row 
"2 4 ",//Row=13  Unique Row 
"2 5 ",//Row=14  Unique Row 
"2 6 ",//Row=15  Unique Row 
"2 7 ",//Row=16  Unique Row 
"2 8 ",//Row=17  Unique Row 
"2 9 ",//Row=18  Unique Row 
"2 0 ",//Row=19  Unique Row 
"3 1 ",//Row=20  Unique Row 
"3 2 ",//Row=21  Unique Row 
"3 3 ",//Row=22  Unique Row 
"3 4 ",//Row=23  Unique Row 
"3 5 ",//Row=24  Unique Row 
"3 6 ",//Row=25  Unique Row 
"3 7 ",//Row=26  Unique Row 
"3 8 ",//Row=27  Unique Row 
"3 9 ",//Row=28  Unique Row 
"3 0 ",//Row=29  Unique Row 
"4 1 ",//Row=30  Unique Row 
"4 2 ",//Row=31  Unique Row 
"4 3 ",//Row=32  Unique Row 
"4 4 ",//Row=33  Unique Row 
"4 5 ",//Row=34  Unique Row 
"4 6 ",//Row=35  Unique Row 
"4 7 ",//Row=36  Unique Row 
"4 8 ",//Row=37  Unique Row 
"4 9 ",//Row=38  Unique Row 
"4 0 ",//Row=39  Unique Row 
"5 1 ",//Row=40  Unique Row 
"5 2 ",//Row=41  Unique Row 
"5 3 ",//Row=42  Unique Row 
"5 4 ",//Row=43  Unique Row 
"5 5 ",//Row=44  Unique Row 
"5 6 ",//Row=45  Unique Row 
"5 7 ",//Row=46  Unique Row 
"5 8 ",//Row=47  Unique Row 
"5 9 ",//Row=48  Unique Row 
"5 0 ",//Row=49  Unique Row 
"6 1 ",//Row=50  Unique Row 
"6 2 ",//Row=51  Unique Row 
"6 3 ",//Row=52  Unique Row 
"6 4 ",//Row=53  Unique Row 
"6 5 ",//Row=54  Unique Row 
"6 6 ",//Row=55  Unique Row 
"6 7 ",//Row=56  Unique Row 
"6 8 ",//Row=57  Unique Row 
"6 9 ",//Row=58  Unique Row 
"6 0 ",//Row=59  Unique Row 
"7 1 ",//Row=60  Unique Row 
"7 2 ",//Row=61  Unique Row 
"7 3 ",//Row=62  Unique Row 
"7 4 ",//Row=63  Unique Row 
"7 5 ",//Row=64  Unique Row 
"7 6 ",//Row=65  Unique Row 
"7 7 ",//Row=66  Unique Row 
"7 8 ",//Row=67  Unique Row 
"7 9 ",//Row=68  Unique Row 
"7 0 ",//Row=69  Unique Row 
"8 1 ",//Row=70  Unique Row 
"8 2 ",//Row=71  Unique Row 
"8 3 ",//Row=72  Unique Row 
"8 4 ",//Row=73  Unique Row 
"8 5 ",//Row=74  Unique Row 
"8 6 ",//Row=75  Unique Row 
"8 7 ",//Row=76  Unique Row 
"8 8 ",//Row=77  Unique Row 
"8 9 ",//Row=78  Unique Row 
"8 0 ",//Row=79  Unique Row 
"9 1 ",//Row=80  Unique Row 
"9 2 ",//Row=81  Unique Row 
"9 3 ",//Row=82  Unique Row 
"9 4 ",//Row=83  Unique Row 
"9 5 ",//Row=84  Unique Row 
"9 6 ",//Row=85  Unique Row 
"9 7 ",//Row=86  Unique Row 
"9 8 ",//Row=87  Unique Row 
"9 9 ",//Row=88  Unique Row 
"9 0 ",//Row=89  Unique Row 
"0 1 ",//Row=90  Unique Row 
"0 2 ",//Row=91  Unique Row 
"0 3 ",//Row=92  Unique Row 
"0 4 ",//Row=93  Unique Row 
"0 5 ",//Row=94  Unique Row 
"0 6 ",//Row=95  Unique Row 
"0 7 ",//Row=96  Unique Row 
"0 8 ",//Row=97  Unique Row 
"0 9 ",//Row=98  Unique Row 
"0 0 ",//Row=99  Unique Row
            };
    
static  String[] OATSType3DigitPattern = {
        "1 1 1 ",//Row=0  Unique Row 
        "1 2 2 ",//Row=1  Unique Row 
        "1 3 3 ",//Row=2  Unique Row 
        "1 4 4 ",//Row=3  Unique Row 
        "1 5 5 ",//Row=4  Unique Row 
        "1 6 6 ",//Row=5  Unique Row 
        "1 7 7 ",//Row=6  Unique Row 
        "1 8 8 ",//Row=7  Unique Row 
        "1 9 9 ",//Row=8  Unique Row 
        "1 0 0 ",//Row=9  Unique Row 
        "1 1 7 ",//Row=10  Unique Row 
        "1 2 5 ",//Row=11  Unique Row 
        "1 3 9 ",//Row=12  Unique Row 
        "1 4 0 ",//Row=13  Unique Row 
        "1 5 8 ",//Row=14  Unique Row 
        "1 6 1 ",//Row=15  Unique Row 
        "1 7 2 ",//Row=16  Unique Row 
        "1 8 3 ",//Row=17  Unique Row 
        "1 9 4 ",//Row=18  Unique Row 
        "1 0 5 ",//Row=19  Unique Row 
        "1 1 6 ",//Row=20  Unique Row 
        "1 2 7 ",//Row=21  Unique Row 
        "1 3 5 ",//Row=22  Unique Row 
        "1 4 9 ",//Row=23  Unique Row 
        "1 5 0 ",//Row=24  Unique Row 
        "1 6 8 ",//Row=25  Unique Row 
        "1 7 1 ",//Row=26  Unique Row 
        "1 8 2 ",//Row=27  Unique Row 
        "1 9 3 ",//Row=28  Unique Row 
        "1 0 4 ",//Row=29  Unique Row 
        "1 1 5 ",//Row=30  Unique Row 
        "1 2 6 ",//Row=31  Unique Row 
        "1 3 7 ",//Row=32  Unique Row 
        "1 4 5 ",//Row=33  Unique Row 
        "1 5 9 ",//Row=34  Unique Row 
        "1 6 0 ",//Row=35  Unique Row 
        "1 7 8 ",//Row=36  Unique Row 
        "1 8 1 ",//Row=37  Unique Row 
        "1 9 2 ",//Row=38  Unique Row 
        "1 0 3 ",//Row=39  Unique Row 
        "1 1 4 ",//Row=40  Unique Row 
        "1 2 9 ",//Row=41  Unique Row 
        "1 3 6 ",//Row=42  Unique Row 
        "1 4 7 ",//Row=43  Unique Row 
        "1 5 6 ",//Row=44  Unique Row 
        "1 6 9 ",//Row=45  Unique Row 
        "1 7 0 ",//Row=46  Unique Row 
        "1 8 6 ",//Row=47  Unique Row 
        "1 9 1 ",//Row=48  Unique Row 
        "1 0 2 ",//Row=49  Unique Row 
        "1 1 3 ",//Row=50  Unique Row 
        "1 2 4 ",//Row=51  Unique Row 
        "1 4 3 ",//Row=52  Unique Row 
        "1 4 6 ",//Row=53  Unique Row 
        "1 5 7 ",//Row=54  Unique Row 
        "1 6 5 ",//Row=55  Unique Row 
        "1 7 9 ",//Row=56  Unique Row 
        "1 8 0 ",//Row=57  Unique Row 
        "1 9 8 ",//Row=58  Unique Row 
        "1 0 1 ",//Row=59  Unique Row 
        "1 1 2 ",//Row=60  Unique Row 
        "1 2 3 ",//Row=61  Unique Row 
        "1 3 4 ",//Row=62  Unique Row 
        "1 5 4 ",//Row=63  Unique Row 
        "1 6 5 ",//Row=64  Row i=64 duplicate with Row=55
        "1 6 7 ",//Row=65  Unique Row 
        "1 7 5 ",//Row=66  Unique Row 
        "1 8 9 ",//Row=67  Unique Row 
        "1 9 0 ",//Row=68  Unique Row 
        "1 0 8 ",//Row=69  Unique Row 
        "1 1 9 ",//Row=70  Unique Row 
        "1 2 9 ",//Row=71  Row i=71 duplicate with Row=41
        "1 3 9 ",//Row=72  Row i=72 duplicate with Row=12
        "1 4 9 ",//Row=73  Row i=73 duplicate with Row=23
        "1 5 9 ",//Row=74  Row i=74 duplicate with Row=34
        "1 6 0 ",//Row=75  Row i=75 duplicate with Row=35
        "1 7 6 ",//Row=76  Unique Row 
        "1 8 5 ",//Row=77  Unique Row 
        "1 9 6 ",//Row=78  Unique Row 
        "1 0 6 ",//Row=79  Unique Row 
        "1 1 8 ",//Row=80  Unique Row 
        "1 2 1 ",//Row=81  Unique Row 
        "1 3 2 ",//Row=82  Unique Row 
        "1 4 3 ",//Row=83  Row i=83 duplicate with Row=52
        "1 5 4 ",//Row=84  Row i=84 duplicate with Row=63
        "1 6 0 ",//Row=85  Row i=85 duplicate with Row=35
        "1 7 9 ",//Row=86  Row i=86 duplicate with Row=56
        "1 8 7 ",//Row=87  Unique Row 
        "1 9 5 ",//Row=88  Unique Row 
        "1 0 9 ",//Row=89  Unique Row 
        "1 1 0 ",//Row=90  Unique Row 
        "1 2 8 ",//Row=91  Unique Row 
        "1 3 1 ",//Row=92  Unique Row 
        "1 4 2 ",//Row=93  Unique Row 
        "1 5 3 ",//Row=94  Unique Row 
        "1 6 4 ",//Row=95  Unique Row 
        "1 7 9 ",//Row=96  Row i=96 duplicate with Row=56
        "1 8 9 ",//Row=97  Row i=97 duplicate with Row=67
        "1 9 7 ",//Row=98  Unique Row 
        "1 0 9 ",//Row=99  Row i=99 duplicate with Row=89
        "2 1 9 ",//Row=100  Unique Row 
        "2 2 0 ",//Row=101  Unique Row 
        "2 3 8 ",//Row=102  Unique Row 
        "2 4 1 ",//Row=103  Unique Row 
        "2 5 2 ",//Row=104  Unique Row 
        "2 6 3 ",//Row=105  Unique Row 
        "2 7 4 ",//Row=106  Unique Row 
        "2 8 5 ",//Row=107  Unique Row 
        "2 9 6 ",//Row=108  Unique Row 
        "2 0 7 ",//Row=109  Unique Row 
        "2 1 5 ",//Row=110  Unique Row 
        "2 2 9 ",//Row=111  Unique Row 
        "2 3 0 ",//Row=112  Unique Row 
        "2 4 8 ",//Row=113  Unique Row 
        "2 5 1 ",//Row=114  Unique Row 
        "2 6 2 ",//Row=115  Unique Row 
        "2 7 3 ",//Row=116  Unique Row 
        "2 8 4 ",//Row=117  Unique Row 
        "2 9 5 ",//Row=118  Unique Row 
        "2 0 6 ",//Row=119  Unique Row 
        "2 1 7 ",//Row=120  Unique Row 
        "2 2 5 ",//Row=121  Unique Row 
        "2 3 9 ",//Row=122  Unique Row 
        "2 4 0 ",//Row=123  Unique Row 
        "2 5 8 ",//Row=124  Unique Row 
        "2 6 1 ",//Row=125  Unique Row 
        "2 7 2 ",//Row=126  Unique Row 
        "2 8 3 ",//Row=127  Unique Row 
        "2 9 4 ",//Row=128  Unique Row 
        "2 0 5 ",//Row=129  Unique Row 
        "2 1 6 ",//Row=130  Unique Row 
        "2 2 7 ",//Row=131  Unique Row 
        "2 3 5 ",//Row=132  Unique Row 
        "2 4 9 ",//Row=133  Unique Row 
        "2 5 0 ",//Row=134  Unique Row 
        "2 6 8 ",//Row=135  Unique Row 
        "2 7 1 ",//Row=136  Unique Row 
        "2 8 2 ",//Row=137  Unique Row 
        "2 9 3 ",//Row=138  Unique Row 
        "2 0 4 ",//Row=139  Unique Row 
        "2 1 9 ",//Row=140  Row i=140 duplicate with Row=100
        "2 2 6 ",//Row=141  Unique Row 
        "2 3 7 ",//Row=142  Unique Row 
        "2 4 5 ",//Row=143  Unique Row 
        "2 5 9 ",//Row=144  Unique Row 
        "2 6 0 ",//Row=145  Unique Row 
        "2 7 8 ",//Row=146  Unique Row 
        "2 8 1 ",//Row=147  Unique Row 
        "2 9 2 ",//Row=148  Unique Row 
        "2 0 3 ",//Row=149  Unique Row 
        "2 1 4 ",//Row=150  Unique Row 
        "2 2 9 ",//Row=151  Row i=151 duplicate with Row=111
        "2 3 6 ",//Row=152  Unique Row 
        "2 4 7 ",//Row=153  Unique Row 
        "2 5 5 ",//Row=154  Unique Row 
        "2 6 9 ",//Row=155  Unique Row 
        "2 7 0 ",//Row=156  Unique Row 
        "2 8 8 ",//Row=157  Unique Row 
        "2 9 1 ",//Row=158  Unique Row 
        "2 0 2 ",//Row=159  Unique Row 
        "2 1 3 ",//Row=160  Unique Row 
        "2 2 4 ",//Row=161  Unique Row 
        "2 3 9 ",//Row=162  Row i=162 duplicate with Row=122
        "2 4 6 ",//Row=163  Unique Row 
        "2 5 7 ",//Row=164  Unique Row 
        "2 6 5 ",//Row=165  Unique Row 
        "2 7 9 ",//Row=166  Unique Row 
        "2 8 0 ",//Row=167  Unique Row 
        "2 9 8 ",//Row=168  Unique Row 
        "2 0 1 ",//Row=169  Unique Row 
        "2 1 2 ",//Row=170  Unique Row 
        "2 2 3 ",//Row=171  Unique Row 
        "2 3 4 ",//Row=172  Unique Row 
        "2 4 9 ",//Row=173  Row i=173 duplicate with Row=133
        "2 5 6 ",//Row=174  Unique Row 
        "2 6 7 ",//Row=175  Unique Row 
        "2 7 5 ",//Row=176  Unique Row 
        "2 8 9 ",//Row=177  Unique Row 
        "2 9 0 ",//Row=178  Unique Row 
        "2 0 8 ",//Row=179  Unique Row 
        "2 1 1 ",//Row=180  Unique Row 
        "2 2 2 ",//Row=181  Unique Row 
        "2 3 3 ",//Row=182  Unique Row 
        "2 4 4 ",//Row=183  Unique Row 
        "2 5 9 ",//Row=184  Row i=184 duplicate with Row=144
        "2 6 6 ",//Row=185  Unique Row 
        "2 7 7 ",//Row=186  Unique Row 
        "2 8 6 ",//Row=187  Unique Row 
        "2 9 9 ",//Row=188  Unique Row 
        "2 0 0 ",//Row=189  Unique Row 
        "2 1 8 ",//Row=190  Unique Row 
        "2 2 1 ",//Row=191  Unique Row 
        "2 3 2 ",//Row=192  Unique Row 
        "2 4 3 ",//Row=193  Unique Row 
        "2 5 4 ",//Row=194  Unique Row 
        "2 6 0 ",//Row=195  Row i=195 duplicate with Row=145
        "2 7 6 ",//Row=196  Unique Row 
        "2 8 7 ",//Row=197  Unique Row 
        "2 9 9 ",//Row=198  Row i=198 duplicate with Row=188
        "2 0 9 ",//Row=199  Unique Row 
        "3 1 0 ",//Row=200  Unique Row 
        "3 2 8 ",//Row=201  Unique Row 
        "3 3 1 ",//Row=202  Unique Row 
        "3 4 2 ",//Row=203  Unique Row 
        "3 5 3 ",//Row=204  Unique Row 
        "3 6 4 ",//Row=205  Unique Row 
        "3 7 5 ",//Row=206  Unique Row 
        "3 8 6 ",//Row=207  Unique Row 
        "3 9 7 ",//Row=208  Unique Row 
        "3 0 5 ",//Row=209  Unique Row 
        "3 1 9 ",//Row=20  Unique Row 
        "3 2 0 ",//Row=211  Unique Row 
        "3 3 8 ",//Row=212  Unique Row 
        "3 4 1 ",//Row=213  Unique Row 
        "3 5 2 ",//Row=214  Unique Row 
        "3 6 3 ",//Row=215  Unique Row 
        "3 7 4 ",//Row=216  Unique Row 
        "3 8 5 ",//Row=217  Unique Row 
        "3 9 6 ",//Row=218  Unique Row 
        "3 0 7 ",//Row=219  Unique Row 
        "3 1 5 ",//Row=220  Unique Row 
        "3 2 9 ",//Row=221  Unique Row 
        "3 3 0 ",//Row=222  Unique Row 
        "3 4 8 ",//Row=223  Unique Row 
        "3 5 1 ",//Row=224  Unique Row 
        "3 6 2 ",//Row=225  Unique Row 
        "3 7 3 ",//Row=226  Unique Row 
        "3 8 4 ",//Row=227  Unique Row 
        "3 9 5 ",//Row=228  Unique Row 
        "3 0 6 ",//Row=229  Unique Row 
        "3 1 7 ",//Row=230  Unique Row 
        "3 2 5 ",//Row=231  Unique Row 
        "3 3 9 ",//Row=232  Unique Row 
        "3 4 0 ",//Row=233  Unique Row 
        "3 5 8 ",//Row=234  Unique Row 
        "3 6 1 ",//Row=235  Unique Row 
        "3 7 2 ",//Row=236  Unique Row 
        "3 8 3 ",//Row=237  Unique Row 
        "3 9 4 ",//Row=238  Unique Row 
        "3 0 9 ",//Row=239  Unique Row 
        "3 1 6 ",//Row=240  Unique Row 
        "3 2 7 ",//Row=241  Unique Row 
        "3 3 5 ",//Row=242  Unique Row 
        "3 4 9 ",//Row=243  Unique Row 
        "3 5 0 ",//Row=244  Unique Row 
        "3 6 8 ",//Row=245  Unique Row 
        "3 7 1 ",//Row=246  Unique Row 
        "3 8 2 ",//Row=247  Unique Row 
        "3 9 3 ",//Row=248  Unique Row 
        "3 0 4 ",//Row=249  Unique Row 
        "3 1 9 ",//Row=250  Row i=250 duplicate with Row=210
        "3 2 6 ",//Row=251  Unique Row 
        "3 3 7 ",//Row=252  Unique Row 
        "3 4 5 ",//Row=253  Unique Row 
        "3 5 9 ",//Row=254  Unique Row 
        "3 6 0 ",//Row=255  Unique Row 
        "3 7 8 ",//Row=256  Unique Row 
        "3 8 1 ",//Row=257  Unique Row 
        "3 9 2 ",//Row=258  Unique Row 
        "3 0 3 ",//Row=259  Unique Row 
        "3 1 4 ",//Row=260  Unique Row 
        "3 2 9 ",//Row=261  Row i=261 duplicate with Row=221
        "3 3 6 ",//Row=262  Unique Row 
        "3 4 7 ",//Row=263  Unique Row 
        "3 5 5 ",//Row=264  Unique Row 
        "3 6 9 ",//Row=265  Unique Row 
        "3 7 0 ",//Row=266  Unique Row 
        "3 8 8 ",//Row=267  Unique Row 
        "3 9 1 ",//Row=268  Unique Row 
        "3 0 2 ",//Row=269  Unique Row 
        "3 1 3 ",//Row=270  Unique Row 
        "3 2 4 ",//Row=271  Unique Row 
        "3 3 9 ",//Row=272  Row i=272 duplicate with Row=232
        "3 4 6 ",//Row=273  Unique Row 
        "3 5 7 ",//Row=274  Unique Row 
        "3 6 5 ",//Row=275  Unique Row 
        "3 7 9 ",//Row=276  Unique Row 
        "3 8 0 ",//Row=277  Unique Row 
        "3 9 8 ",//Row=278  Unique Row 
        "3 0 1 ",//Row=279  Unique Row 
        "3 1 2 ",//Row=280  Unique Row 
        "3 2 3 ",//Row=281  Unique Row 
        "3 3 4 ",//Row=282  Unique Row 
        "3 4 9 ",//Row=283  Row i=283 duplicate with Row=243
        "3 5 6 ",//Row=284  Unique Row 
        "3 6 7 ",//Row=285  Unique Row 
        "3 7 6 ",//Row=286  Unique Row 
        "3 8 9 ",//Row=287  Unique Row 
        "3 9 0 ",//Row=288  Unique Row 
        "3 0 8 ",//Row=289  Unique Row 
        "3 1 1 ",//Row=290  Unique Row 
        "3 2 2 ",//Row=291  Unique Row 
        "3 3 3 ",//Row=292  Unique Row 
        "3 4 4 ",//Row=293  Unique Row 
        "3 5 9 ",//Row=294  Row i=294 duplicate with Row=254
        "3 6 6 ",//Row=295  Unique Row 
        "3 7 7 ",//Row=296  Unique Row 
        "3 8 9 ",//Row=297  Row i=297 duplicate with Row=287
        "3 9 9 ",//Row=298  Unique Row 
        "3 0 0 ",//Row=299  Unique Row 
        "4 1 8 ",//Row=300  Unique Row 
        "4 2 1 ",//Row=301  Unique Row 
        "4 3 2 ",//Row=302  Unique Row 
        "4 4 3 ",//Row=303  Unique Row 
        "4 5 4 ",//Row=304  Unique Row 
        "4 6 5 ",//Row=305  Unique Row 
        "4 7 6 ",//Row=306  Unique Row 
        "4 8 7 ",//Row=307  Unique Row 
        "4 9 5 ",//Row=308  Unique Row 
        "4 0 9 ",//Row=309  Unique Row 
        "4 1 0 ",//Row=310  Unique Row 
        "4 2 8 ",//Row=311  Unique Row 
        "4 3 1 ",//Row=312  Unique Row 
        "4 4 2 ",//Row=313  Unique Row 
        "4 5 3 ",//Row=314  Unique Row 
        "4 6 4 ",//Row=315  Unique Row 
        "4 7 5 ",//Row=316  Unique Row 
        "4 8 6 ",//Row=317  Unique Row 
        "4 9 7 ",//Row=318  Unique Row 
        "4 0 5 ",//Row=319  Unique Row 
        "4 1 9 ",//Row=320  Unique Row 
        "4 2 0 ",//Row=321  Unique Row 
        "4 3 8 ",//Row=322  Unique Row 
        "4 4 1 ",//Row=323  Unique Row 
        "4 5 2 ",//Row=324  Unique Row 
        "4 6 3 ",//Row=325  Unique Row 
        "4 7 4 ",//Row=326  Unique Row 
        "4 8 5 ",//Row=327  Unique Row 
        "4 9 6 ",//Row=328  Unique Row 
        "4 0 7 ",//Row=329  Unique Row 
        "4 1 5 ",//Row=330  Unique Row 
        "4 2 9 ",//Row=331  Unique Row 
        "4 3 0 ",//Row=332  Unique Row 
        "4 4 8 ",//Row=333  Unique Row 
        "4 5 1 ",//Row=334  Unique Row 
        "4 6 2 ",//Row=335  Unique Row 
        "4 7 3 ",//Row=336  Unique Row 
        "4 8 4 ",//Row=337  Unique Row 
        "4 9 9 ",//Row=338  Unique Row 
        "4 0 6 ",//Row=339  Unique Row 
        "4 1 7 ",//Row=340  Unique Row 
        "4 2 5 ",//Row=341  Unique Row 
        "4 3 9 ",//Row=342  Unique Row 
        "4 4 0 ",//Row=343  Unique Row 
        "4 5 8 ",//Row=344  Unique Row 
        "4 6 1 ",//Row=345  Unique Row 
        "4 7 2 ",//Row=346  Unique Row 
        "4 8 3 ",//Row=347  Unique Row 
        "4 9 4 ",//Row=348  Unique Row 
        "4 0 9 ",//Row=349  Row i=349 duplicate with Row=309
        "4 1 6 ",//Row=350  Unique Row 
        "4 2 7 ",//Row=351  Unique Row 
        "4 3 5 ",//Row=352  Unique Row 
        "4 4 9 ",//Row=353  Unique Row 
        "4 5 0 ",//Row=354  Unique Row 
        "4 6 8 ",//Row=355  Unique Row 
        "4 7 1 ",//Row=356  Unique Row 
        "4 8 2 ",//Row=357  Unique Row 
        "4 9 3 ",//Row=358  Unique Row 
        "4 0 4 ",//Row=359  Unique Row 
        "4 1 9 ",//Row=360  Row i=360 duplicate with Row=320
        "4 2 6 ",//Row=361  Unique Row 
        "4 3 7 ",//Row=362  Unique Row 
        "4 4 5 ",//Row=363  Unique Row 
        "4 5 9 ",//Row=364  Unique Row 
        "4 6 0 ",//Row=365  Unique Row 
        "4 7 8 ",//Row=366  Unique Row 
        "4 8 1 ",//Row=367  Unique Row 
        "4 9 2 ",//Row=368  Unique Row 
        "4 0 3 ",//Row=369  Unique Row 
        "4 1 4 ",//Row=370  Unique Row 
        "4 2 9 ",//Row=371  Row i=371 duplicate with Row=331
        "4 3 6 ",//Row=372  Unique Row 
        "4 4 7 ",//Row=373  Unique Row 
        "4 5 5 ",//Row=374  Unique Row 
        "4 6 9 ",//Row=375  Unique Row 
        "4 7 0 ",//Row=376  Unique Row 
        "4 8 8 ",//Row=377  Unique Row 
        "4 9 1 ",//Row=378  Unique Row 
        "4 0 2 ",//Row=379  Unique Row 
        "4 1 3 ",//Row=380  Unique Row 
        "4 2 4 ",//Row=381  Unique Row 
        "4 3 9 ",//Row=382  Row i=382 duplicate with Row=342
        "4 4 6 ",//Row=383  Unique Row 
        "4 5 7 ",//Row=384  Unique Row 
        "4 6 7 ",//Row=385  Unique Row 
        "4 7 9 ",//Row=386  Unique Row 
        "4 8 0 ",//Row=387  Unique Row 
        "4 9 8 ",//Row=388  Unique Row 
        "4 0 1 ",//Row=389  Unique Row 
        "4 1 2 ",//Row=390  Unique Row 
        "4 2 3 ",//Row=391  Unique Row 
        "4 3 4 ",//Row=392  Unique Row 
        "4 4 9 ",//Row=393  Row i=393 duplicate with Row=353
        "4 5 6 ",//Row=394  Unique Row 
        "4 6 0 ",//Row=395  Row i=395 duplicate with Row=365
        "4 7 9 ",//Row=396  Row i=396 duplicate with Row=386
        "4 8 9 ",//Row=397  Unique Row 
        "4 9 0 ",//Row=398  Unique Row 
        "4 0 8 ",//Row=399  Unique Row 
        "5 1 1 ",//Row=400  Unique Row 
        "5 2 2 ",//Row=401  Unique Row 
        "5 3 3 ",//Row=402  Unique Row 
        "5 4 4 ",//Row=403  Unique Row 
        "5 5 5 ",//Row=404  Unique Row 
        "5 6 6 ",//Row=405  Unique Row 
        "5 7 7 ",//Row=406  Unique Row 
        "5 8 5 ",//Row=407  Unique Row 
        "5 9 9 ",//Row=408  Unique Row 
        "5 0 0 ",//Row=409  Unique Row 
        "5 1 8 ",//Row=410  Unique Row 
        "5 2 1 ",//Row=411  Unique Row 
        "5 3 2 ",//Row=412  Unique Row 
        "5 4 3 ",//Row=413  Unique Row 
        "5 5 4 ",//Row=414  Unique Row 
        "5 6 5 ",//Row=415  Unique Row 
        "5 7 6 ",//Row=416  Unique Row 
        "5 8 7 ",//Row=417  Unique Row 
        "5 9 5 ",//Row=418  Unique Row 
        "5 0 9 ",//Row=419  Unique Row 
        "5 1 0 ",//Row=420  Unique Row 
        "5 2 8 ",//Row=421  Unique Row 
        "5 3 1 ",//Row=422  Unique Row 
        "5 4 2 ",//Row=423  Unique Row 
        "5 5 3 ",//Row=424  Unique Row 
        "5 6 4 ",//Row=425  Unique Row 
        "5 7 5 ",//Row=426  Unique Row 
        "5 8 6 ",//Row=427  Unique Row 
        "5 9 7 ",//Row=428  Unique Row 
        "5 0 5 ",//Row=429  Unique Row 
        "5 1 9 ",//Row=430  Unique Row 
        "5 2 0 ",//Row=431  Unique Row 
        "5 3 8 ",//Row=432  Unique Row 
        "5 4 1 ",//Row=433  Unique Row 
        "5 5 2 ",//Row=434  Unique Row 
        "5 6 3 ",//Row=435  Unique Row 
        "5 7 4 ",//Row=436  Unique Row 
        "5 8 9 ",//Row=437  Unique Row 
        "5 9 6 ",//Row=438  Unique Row 
        "5 0 7 ",//Row=439  Unique Row 
        "5 1 5 ",//Row=440  Unique Row 
        "5 2 9 ",//Row=441  Unique Row 
        "5 3 0 ",//Row=442  Unique Row 
        "5 4 8 ",//Row=443  Unique Row 
        "5 5 1 ",//Row=444  Unique Row 
        "5 6 2 ",//Row=445  Unique Row 
        "5 7 3 ",//Row=446  Unique Row 
        "5 8 4 ",//Row=447  Unique Row 
        "5 9 9 ",//Row=448  Row i=448 duplicate with Row=408
        "5 0 6 ",//Row=449  Unique Row 
        "5 1 7 ",//Row=450  Unique Row 
        "5 2 5 ",//Row=451  Unique Row 
        "5 3 9 ",//Row=452  Unique Row 
        "5 4 0 ",//Row=453  Unique Row 
        "5 5 8 ",//Row=454  Unique Row 
        "5 6 1 ",//Row=455  Unique Row 
        "5 7 2 ",//Row=456  Unique Row 
        "5 8 3 ",//Row=457  Unique Row 
        "5 9 4 ",//Row=458  Unique Row 
        "5 0 9 ",//Row=459  Row i=459 duplicate with Row=419
        "5 1 6 ",//Row=460  Unique Row 
        "5 2 7 ",//Row=461  Unique Row 
        "5 3 5 ",//Row=462  Unique Row 
        "5 4 9 ",//Row=463  Unique Row 
        "5 5 0 ",//Row=464  Unique Row 
        "5 6 8 ",//Row=465  Unique Row 
        "5 7 1 ",//Row=466  Unique Row 
        "5 8 2 ",//Row=467  Unique Row 
        "5 9 3 ",//Row=468  Unique Row 
        "5 0 4 ",//Row=469  Unique Row 
        "5 1 9 ",//Row=470  Row i=470 duplicate with Row=430
        "5 2 6 ",//Row=471  Unique Row 
        "5 3 7 ",//Row=472  Unique Row 
        "5 4 5 ",//Row=473  Unique Row 
        "5 5 9 ",//Row=474  Unique Row 
        "5 6 0 ",//Row=475  Unique Row 
        "5 7 8 ",//Row=476  Unique Row 
        "5 8 1 ",//Row=477  Unique Row 
        "5 9 2 ",//Row=478  Unique Row 
        "5 0 3 ",//Row=479  Unique Row 
        "5 1 4 ",//Row=480  Unique Row 
        "5 2 9 ",//Row=481  Row i=481 duplicate with Row=441
        "5 3 6 ",//Row=482  Unique Row 
        "5 4 7 ",//Row=483  Unique Row 
        "5 5 6 ",//Row=484  Unique Row 
        "5 6 9 ",//Row=485  Unique Row 
        "5 7 0 ",//Row=486  Unique Row 
        "5 8 8 ",//Row=487  Unique Row 
        "5 9 1 ",//Row=488  Unique Row 
        "5 0 2 ",//Row=489  Unique Row 
        "5 1 3 ",//Row=490  Unique Row 
        "5 2 4 ",//Row=491  Unique Row 
        "5 3 9 ",//Row=492  Row i=492 duplicate with Row=452
        "5 4 6 ",//Row=493  Unique Row 
        "5 5 7 ",//Row=494  Unique Row 
        "5 6 7 ",//Row=495  Unique Row 
        "5 7 9 ",//Row=496  Unique Row 
        "5 8 0 ",//Row=497  Unique Row 
        "5 9 8 ",//Row=498  Unique Row 
        "5 0 1 ",//Row=499  Unique Row 
        "6 1 2 ",//Row=500  Unique Row 
        "6 2 3 ",//Row=501  Unique Row 
        "6 3 4 ",//Row=502  Unique Row 
        "6 4 5 ",//Row=503  Unique Row 
        "6 5 6 ",//Row=504  Unique Row 
        "6 6 7 ",//Row=505  Unique Row 
        "6 7 5 ",//Row=506  Unique Row 
        "6 8 9 ",//Row=507  Unique Row 
        "6 9 0 ",//Row=508  Unique Row 
        "6 0 8 ",//Row=509  Unique Row 
        "6 1 1 ",//Row=510  Unique Row 
        "6 2 2 ",//Row=511  Unique Row 
        "6 3 3 ",//Row=512  Unique Row 
        "6 4 4 ",//Row=513  Unique Row 
        "6 5 5 ",//Row=514  Unique Row 
        "6 6 6 ",//Row=515  Unique Row 
        "6 7 7 ",//Row=516  Unique Row 
        "6 8 5 ",//Row=517  Unique Row 
        "6 9 9 ",//Row=518  Unique Row 
        "6 0 0 ",//Row=519  Unique Row 
        "6 1 8 ",//Row=520  Unique Row 
        "6 2 1 ",//Row=521  Unique Row 
        "6 3 2 ",//Row=522  Unique Row 
        "6 4 3 ",//Row=523  Unique Row 
        "6 5 4 ",//Row=524  Unique Row 
        "6 6 5 ",//Row=525  Unique Row 
        "6 7 6 ",//Row=526  Unique Row 
        "6 8 7 ",//Row=527  Unique Row 
        "6 9 5 ",//Row=528  Unique Row 
        "6 0 9 ",//Row=529  Unique Row 
        "6 1 0 ",//Row=530  Unique Row 
        "6 2 8 ",//Row=531  Unique Row 
        "6 3 1 ",//Row=532  Unique Row 
        "6 4 2 ",//Row=533  Unique Row 
        "6 5 3 ",//Row=534  Unique Row 
        "6 6 4 ",//Row=535  Unique Row 
        "6 7 9 ",//Row=536  Unique Row 
        "6 8 6 ",//Row=537  Unique Row 
        "6 9 7 ",//Row=538  Unique Row 
        "6 0 5 ",//Row=539  Unique Row 
        "6 1 9 ",//Row=540  Unique Row 
        "6 2 0 ",//Row=541  Unique Row 
        "6 3 8 ",//Row=542  Unique Row 
        "6 4 1 ",//Row=543  Unique Row 
        "6 5 2 ",//Row=544  Unique Row 
        "6 6 3 ",//Row=545  Unique Row 
        "6 7 4 ",//Row=546  Unique Row 
        "6 8 9 ",//Row=547  Row i=547 duplicate with Row=507
        "6 9 6 ",//Row=548  Unique Row 
        "6 0 7 ",//Row=549  Unique Row 
        "6 1 5 ",//Row=550  Unique Row 
        "6 2 9 ",//Row=551  Unique Row 
        "6 3 0 ",//Row=552  Unique Row 
        "6 4 8 ",//Row=553  Unique Row 
        "6 5 1 ",//Row=554  Unique Row 
        "6 6 2 ",//Row=555  Unique Row 
        "6 7 3 ",//Row=556  Unique Row 
        "6 8 4 ",//Row=557  Unique Row 
        "6 9 9 ",//Row=558  Row i=558 duplicate with Row=518
        "6 0 6 ",//Row=559  Unique Row 
        "6 1 7 ",//Row=560  Unique Row 
        "6 2 5 ",//Row=561  Unique Row 
        "6 3 9 ",//Row=562  Unique Row 
        "6 4 0 ",//Row=563  Unique Row 
        "6 5 8 ",//Row=564  Unique Row 
        "6 6 1 ",//Row=565  Unique Row 
        "6 7 2 ",//Row=566  Unique Row 
        "6 8 3 ",//Row=567  Unique Row 
        "6 9 4 ",//Row=568  Unique Row 
        "6 0 9 ",//Row=569  Row i=569 duplicate with Row=529
        "6 1 6 ",//Row=570  Unique Row 
        "6 2 7 ",//Row=571  Unique Row 
        "6 3 5 ",//Row=572  Unique Row 
        "6 4 9 ",//Row=573  Unique Row 
        "6 5 0 ",//Row=574  Unique Row 
        "6 6 8 ",//Row=575  Unique Row 
        "6 7 1 ",//Row=576  Unique Row 
        "6 8 2 ",//Row=577  Unique Row 
        "6 9 3 ",//Row=578  Unique Row 
        "6 0 4 ",//Row=579  Unique Row 
        "6 1 9 ",//Row=580  Row i=580 duplicate with Row=540
        "6 2 6 ",//Row=581  Unique Row 
        "6 3 7 ",//Row=582  Unique Row 
        "6 4 6 ",//Row=583  Unique Row 
        "6 5 9 ",//Row=584  Unique Row 
        "6 6 0 ",//Row=585  Unique Row 
        "6 7 8 ",//Row=586  Unique Row 
        "6 8 1 ",//Row=587  Unique Row 
        "6 9 2 ",//Row=588  Unique Row 
        "6 0 3 ",//Row=589  Unique Row 
        "6 1 4 ",//Row=590  Unique Row 
        "6 2 9 ",//Row=591  Row i=591 duplicate with Row=551
        "6 3 6 ",//Row=592  Unique Row 
        "6 4 7 ",//Row=593  Unique Row 
        "6 5 9 ",//Row=594  Row i=594 duplicate with Row=584
        "6 6 9 ",//Row=595  Unique Row 
        "6 7 0 ",//Row=596  Unique Row 
        "6 8 8 ",//Row=597  Unique Row 
        "6 9 1 ",//Row=598  Unique Row 
        "6 0 2 ",//Row=599  Unique Row 
        "7 1 3 ",//Row=600  Unique Row 
        "7 2 4 ",//Row=601  Unique Row 
        "7 3 5 ",//Row=602  Unique Row 
        "7 4 6 ",//Row=603  Unique Row 
        "7 5 7 ",//Row=604  Unique Row 
        "7 6 5 ",//Row=605  Unique Row 
        "7 7 9 ",//Row=606  Unique Row 
        "7 8 0 ",//Row=607  Unique Row 
        "7 9 8 ",//Row=608  Unique Row 
        "7 0 1 ",//Row=609  Unique Row 
        "7 1 2 ",//Row=610  Unique Row 
        "7 2 3 ",//Row=611  Unique Row 
        "7 3 4 ",//Row=612  Unique Row 
        "7 4 5 ",//Row=613  Unique Row 
        "7 5 6 ",//Row=614  Unique Row 
        "7 6 7 ",//Row=615  Unique Row 
        "7 7 5 ",//Row=616  Unique Row 
        "7 8 9 ",//Row=617  Unique Row 
        "7 9 0 ",//Row=618  Unique Row 
        "7 0 8 ",//Row=619  Unique Row 
        "7 1 1 ",//Row=620  Unique Row 
        "7 2 2 ",//Row=621  Unique Row 
        "7 3 3 ",//Row=622  Unique Row 
        "7 4 4 ",//Row=623  Unique Row 
        "7 5 5 ",//Row=624  Unique Row 
        "7 6 6 ",//Row=625  Unique Row 
        "7 7 7 ",//Row=626  Unique Row 
        "7 8 5 ",//Row=627  Unique Row 
        "7 9 9 ",//Row=628  Unique Row 
        "7 0 0 ",//Row=629  Unique Row 
        "7 1 8 ",//Row=630  Unique Row 
        "7 2 1 ",//Row=631  Unique Row 
        "7 3 2 ",//Row=632  Unique Row 
        "7 4 3 ",//Row=633  Unique Row 
        "7 5 4 ",//Row=634  Unique Row 
        "7 6 0 ",//Row=635  Unique Row 
        "7 7 6 ",//Row=636  Unique Row 
        "7 8 7 ",//Row=637  Unique Row 
        "7 9 5 ",//Row=638  Unique Row 
        "7 0 9 ",//Row=639  Unique Row 
        "7 1 0 ",//Row=640  Unique Row 
        "7 2 8 ",//Row=641  Unique Row 
        "7 3 1 ",//Row=642  Unique Row 
        "7 4 2 ",//Row=643  Unique Row 
        "7 5 3 ",//Row=644  Unique Row 
        "7 6 4 ",//Row=645  Unique Row 
        "7 7 9 ",//Row=646  Row i=646 duplicate with Row=606
        "7 8 6 ",//Row=647  Unique Row 
        "7 9 7 ",//Row=648  Unique Row 
        "7 0 5 ",//Row=649  Unique Row 
        "7 1 9 ",//Row=650  Unique Row 
        "7 2 0 ",//Row=651  Unique Row 
        "7 3 8 ",//Row=652  Unique Row 
        "7 4 1 ",//Row=653  Unique Row 
        "7 5 2 ",//Row=654  Unique Row 
        "7 6 3 ",//Row=655  Unique Row 
        "7 7 4 ",//Row=656  Unique Row 
        "7 8 9 ",//Row=657  Row i=657 duplicate with Row=617
        "7 9 6 ",//Row=658  Unique Row 
        "7 0 7 ",//Row=659  Unique Row 
        "7 1 5 ",//Row=660  Unique Row 
        "7 2 9 ",//Row=661  Unique Row 
        "7 3 0 ",//Row=662  Unique Row 
        "7 4 8 ",//Row=663  Unique Row 
        "7 5 1 ",//Row=664  Unique Row 
        "7 6 2 ",//Row=665  Unique Row 
        "7 7 3 ",//Row=666  Unique Row 
        "7 8 4 ",//Row=667  Unique Row 
        "7 9 9 ",//Row=668  Row i=668 duplicate with Row=628
        "7 0 6 ",//Row=669  Unique Row 
        "7 1 7 ",//Row=670  Unique Row 
        "7 2 5 ",//Row=671  Unique Row 
        "7 3 9 ",//Row=672  Unique Row 
        "7 4 0 ",//Row=673  Unique Row 
        "7 5 8 ",//Row=674  Unique Row 
        "7 6 1 ",//Row=675  Unique Row 
        "7 7 2 ",//Row=676  Unique Row 
        "7 8 3 ",//Row=677  Unique Row 
        "7 9 4 ",//Row=678  Unique Row 
        "7 0 9 ",//Row=679  Row i=679 duplicate with Row=639
        "7 1 6 ",//Row=680  Unique Row 
        "7 2 7 ",//Row=681  Unique Row 
        "7 3 6 ",//Row=682  Unique Row 
        "7 4 9 ",//Row=683  Unique Row 
        "7 5 0 ",//Row=684  Unique Row 
        "7 6 8 ",//Row=685  Unique Row 
        "7 7 1 ",//Row=686  Unique Row 
        "7 8 2 ",//Row=687  Unique Row 
        "7 9 3 ",//Row=688  Unique Row 
        "7 0 4 ",//Row=689  Unique Row 
        "7 1 9 ",//Row=690  Row i=690 duplicate with Row=650
        "7 2 6 ",//Row=691  Unique Row 
        "7 3 7 ",//Row=692  Unique Row 
        "7 4 9 ",//Row=693  Row i=693 duplicate with Row=683
        "7 5 9 ",//Row=694  Unique Row 
        "7 6 0 ",//Row=695  Row i=695 duplicate with Row=635
        "7 7 8 ",//Row=696  Unique Row 
        "7 8 1 ",//Row=697  Unique Row 
        "7 9 2 ",//Row=698  Unique Row 
        "7 0 3 ",//Row=699  Unique Row 
        "8 1 4 ",//Row=700  Unique Row 
        "8 2 5 ",//Row=701  Unique Row 
        "8 3 6 ",//Row=702  Unique Row 
        "8 4 7 ",//Row=703  Unique Row 
        "8 5 5 ",//Row=704  Unique Row 
        "8 6 9 ",//Row=705  Unique Row 
        "8 7 0 ",//Row=706  Unique Row 
        "8 8 8 ",//Row=707  Unique Row 
        "8 9 1 ",//Row=708  Unique Row 
        "8 0 2 ",//Row=709  Unique Row 
        "8 1 3 ",//Row=710  Unique Row 
        "8 2 4 ",//Row=711  Unique Row 
        "8 3 5 ",//Row=712  Unique Row 
        "8 4 6 ",//Row=713  Unique Row 
        "8 5 7 ",//Row=714  Unique Row 
        "8 6 5 ",//Row=715  Unique Row 
        "8 7 9 ",//Row=716  Unique Row 
        "8 8 0 ",//Row=717  Unique Row 
        "8 9 8 ",//Row=718  Unique Row 
        "8 0 1 ",//Row=719  Unique Row 
        "8 1 2 ",//Row=720  Unique Row 
        "8 2 3 ",//Row=721  Unique Row 
        "8 3 4 ",//Row=722  Unique Row 
        "8 4 5 ",//Row=723  Unique Row 
        "8 5 6 ",//Row=724  Unique Row 
        "8 6 7 ",//Row=725  Unique Row 
        "8 7 5 ",//Row=726  Unique Row 
        "8 8 9 ",//Row=727  Unique Row 
        "8 9 0 ",//Row=728  Unique Row 
        "8 0 8 ",//Row=729  Unique Row 
        "8 1 1 ",//Row=730  Unique Row 
        "8 2 2 ",//Row=731  Unique Row 
        "8 3 3 ",//Row=732  Unique Row 
        "8 4 4 ",//Row=733  Unique Row 
        "8 5 9 ",//Row=734  Unique Row 
        "8 6 6 ",//Row=735  Unique Row 
        "8 7 7 ",//Row=736  Unique Row 
        "8 8 5 ",//Row=737  Unique Row 
        "8 9 9 ",//Row=738  Unique Row 
        "8 0 0 ",//Row=739  Unique Row 
        "8 1 8 ",//Row=740  Unique Row 
        "8 2 1 ",//Row=741  Unique Row 
        "8 3 2 ",//Row=742  Unique Row 
        "8 4 3 ",//Row=743  Unique Row 
        "8 5 4 ",//Row=744  Unique Row 
        "8 6 0 ",//Row=745  Unique Row 
        "8 7 6 ",//Row=746  Unique Row 
        "8 8 7 ",//Row=747  Unique Row 
        "8 9 5 ",//Row=748  Unique Row 
        "8 0 9 ",//Row=749  Unique Row 
        "8 1 0 ",//Row=750  Unique Row 
        "8 2 8 ",//Row=751  Unique Row 
        "8 3 1 ",//Row=752  Unique Row 
        "8 4 2 ",//Row=753  Unique Row 
        "8 5 3 ",//Row=754  Unique Row 
        "8 6 4 ",//Row=755  Unique Row 
        "8 7 9 ",//Row=756  Row i=756 duplicate with Row=716
        "8 8 6 ",//Row=757  Unique Row 
        "8 9 7 ",//Row=758  Unique Row 
        "8 0 5 ",//Row=759  Unique Row 
        "8 1 9 ",//Row=760  Unique Row 
        "8 2 0 ",//Row=761  Unique Row 
        "8 3 8 ",//Row=762  Unique Row 
        "8 4 1 ",//Row=763  Unique Row 
        "8 5 2 ",//Row=764  Unique Row 
        "8 6 3 ",//Row=765  Unique Row 
        "8 7 4 ",//Row=766  Unique Row 
        "8 8 9 ",//Row=767  Row i=767 duplicate with Row=727
        "8 9 6 ",//Row=768  Unique Row 
        "8 0 7 ",//Row=769  Unique Row 
        "8 1 5 ",//Row=770  Unique Row 
        "8 2 9 ",//Row=771  Unique Row 
        "8 3 0 ",//Row=772  Unique Row 
        "8 4 8 ",//Row=773  Unique Row 
        "8 5 1 ",//Row=774  Unique Row 
        "8 6 2 ",//Row=775  Unique Row 
        "8 7 3 ",//Row=776  Unique Row 
        "8 8 4 ",//Row=777  Unique Row 
        "8 9 9 ",//Row=778  Row i=778 duplicate with Row=738
        "8 0 6 ",//Row=779  Unique Row 
        "8 1 7 ",//Row=780  Unique Row 
        "8 2 6 ",//Row=781  Unique Row 
        "8 3 9 ",//Row=782  Unique Row 
        "8 4 0 ",//Row=783  Unique Row 
        "8 5 8 ",//Row=784  Unique Row 
        "8 6 1 ",//Row=785  Unique Row 
        "8 7 2 ",//Row=786  Unique Row 
        "8 8 3 ",//Row=787  Unique Row 
        "8 9 4 ",//Row=788  Unique Row 
        "8 0 9 ",//Row=789  Row i=789 duplicate with Row=749
        "8 1 6 ",//Row=790  Unique Row 
        "8 2 7 ",//Row=791  Unique Row 
        "8 3 9 ",//Row=792  Row i=792 duplicate with Row=782
        "8 4 9 ",//Row=793  Unique Row 
        "8 5 0 ",//Row=794  Unique Row 
        "8 6 8 ",//Row=795  Unique Row 
        "8 7 1 ",//Row=796  Unique Row 
        "8 8 2 ",//Row=797  Unique Row 
        "8 9 3 ",//Row=798  Unique Row 
        "8 0 4 ",//Row=799  Unique Row 
        "9 1 5 ",//Row=800  Unique Row 
        "9 2 6 ",//Row=801  Unique Row 
        "9 3 7 ",//Row=802  Unique Row 
        "9 4 5 ",//Row=803  Unique Row 
        "9 5 9 ",//Row=804  Unique Row 
        "9 6 0 ",//Row=805  Unique Row 
        "9 7 8 ",//Row=806  Unique Row 
        "9 8 1 ",//Row=807  Unique Row 
        "9 9 2 ",//Row=808  Unique Row 
        "9 0 3 ",//Row=809  Unique Row 
        "9 1 4 ",//Row=810  Unique Row 
        "9 2 5 ",//Row=811  Unique Row 
        "9 3 6 ",//Row=812  Unique Row 
        "9 4 7 ",//Row=813  Unique Row 
        "9 5 5 ",//Row=814  Unique Row 
        "9 6 9 ",//Row=815  Unique Row 
        "9 7 0 ",//Row=816  Unique Row 
        "9 8 8 ",//Row=817  Unique Row 
        "9 9 1 ",//Row=818  Unique Row 
        "9 0 2 ",//Row=819  Unique Row 
        "9 1 3 ",//Row=820  Unique Row 
        "9 2 4 ",//Row=821  Unique Row 
        "9 3 5 ",//Row=822  Unique Row 
        "9 4 6 ",//Row=823  Unique Row 
        "9 5 7 ",//Row=824  Unique Row 
        "9 6 5 ",//Row=825  Unique Row 
        "9 7 9 ",//Row=826  Unique Row 
        "9 8 0 ",//Row=827  Unique Row 
        "9 9 8 ",//Row=828  Unique Row 
        "9 0 1 ",//Row=829  Unique Row 
        "9 1 2 ",//Row=830  Unique Row 
        "9 2 3 ",//Row=831  Unique Row 
        "9 3 4 ",//Row=832  Unique Row 
        "9 4 9 ",//Row=833  Unique Row 
        "9 5 6 ",//Row=834  Unique Row 
        "9 6 7 ",//Row=835  Unique Row 
        "9 7 5 ",//Row=836  Unique Row 
        "9 8 9 ",//Row=837  Unique Row 
        "9 9 0 ",//Row=838  Unique Row 
        "9 0 8 ",//Row=839  Unique Row 
        "9 1 1 ",//Row=840  Unique Row 
        "9 2 2 ",//Row=841  Unique Row 
        "9 3 3 ",//Row=842  Unique Row 
        "9 4 4 ",//Row=843  Unique Row 
        "9 5 9 ",//Row=844  Row i=844 duplicate with Row=804
        "9 6 6 ",//Row=845  Unique Row 
        "9 7 7 ",//Row=846  Unique Row 
        "9 8 5 ",//Row=847  Unique Row 
        "9 9 9 ",//Row=848  Unique Row 
        "9 0 0 ",//Row=849  Unique Row 
        "9 1 8 ",//Row=850  Unique Row 
        "9 2 1 ",//Row=851  Unique Row 
        "9 3 2 ",//Row=852  Unique Row 
        "9 4 3 ",//Row=853  Unique Row 
        "9 5 4 ",//Row=854  Unique Row 
        "9 6 0 ",//Row=855  Row i=855 duplicate with Row=805
        "9 7 6 ",//Row=856  Unique Row 
        "9 8 7 ",//Row=857  Unique Row 
        "9 9 5 ",//Row=858  Unique Row 
        "9 0 9 ",//Row=859  Unique Row 
        "9 1 0 ",//Row=860  Unique Row 
        "9 2 8 ",//Row=861  Unique Row 
        "9 3 1 ",//Row=862  Unique Row 
        "9 4 2 ",//Row=863  Unique Row 
        "9 5 3 ",//Row=864  Unique Row 
        "9 6 4 ",//Row=865  Unique Row 
        "9 7 9 ",//Row=866  Row i=866 duplicate with Row=826
        "9 8 6 ",//Row=867  Unique Row 
        "9 9 7 ",//Row=868  Unique Row 
        "9 0 5 ",//Row=869  Unique Row 
        "9 1 9 ",//Row=870  Unique Row 
        "9 2 0 ",//Row=871  Unique Row 
        "9 3 8 ",//Row=872  Unique Row 
        "9 4 1 ",//Row=873  Unique Row 
        "9 5 2 ",//Row=874  Unique Row 
        "9 6 3 ",//Row=875  Unique Row 
        "9 7 4 ",//Row=876  Unique Row 
        "9 8 9 ",//Row=877  Row i=877 duplicate with Row=837
        "9 9 6 ",//Row=878  Unique Row 
        "9 0 7 ",//Row=879  Unique Row 
        "9 1 6 ",//Row=880  Unique Row 
        "9 2 9 ",//Row=881  Unique Row 
        "9 3 0 ",//Row=882  Unique Row 
        "9 4 8 ",//Row=883  Unique Row 
        "9 5 1 ",//Row=884  Unique Row 
        "9 6 2 ",//Row=885  Unique Row 
        "9 7 3 ",//Row=886  Unique Row 
        "9 8 4 ",//Row=887  Unique Row 
        "9 9 9 ",//Row=888  Row i=888 duplicate with Row=848
        "9 0 6 ",//Row=889  Unique Row 
        "9 1 7 ",//Row=890  Unique Row 
        "9 2 9 ",//Row=891  Row i=891 duplicate with Row=881
        "9 3 9 ",//Row=892  Unique Row 
        "9 4 0 ",//Row=893  Unique Row 
        "9 5 8 ",//Row=894  Unique Row 
        "9 6 1 ",//Row=895  Unique Row 
        "9 7 2 ",//Row=896  Unique Row 
        "9 8 3 ",//Row=897  Unique Row 
        "9 9 4 ",//Row=898  Unique Row 
        "9 0 9 ",//Row=899  Row i=899 duplicate with Row=859
        "0 1 6 ",//Row=900  Unique Row 
        "0 2 7 ",//Row=901  Unique Row 
        "0 3 5 ",//Row=902  Unique Row 
        "0 4 9 ",//Row=903  Unique Row 
        "0 5 0 ",//Row=904  Unique Row 
        "0 6 8 ",//Row=905  Unique Row 
        "0 7 1 ",//Row=906  Unique Row 
        "0 8 2 ",//Row=907  Unique Row 
        "0 9 3 ",//Row=908  Unique Row 
        "0 0 4 ",//Row=909  Unique Row 
        "0 1 5 ",//Row=910  Unique Row 
        "0 2 6 ",//Row=911  Unique Row 
        "0 3 7 ",//Row=912  Unique Row 
        "0 4 5 ",//Row=913  Unique Row 
        "0 5 9 ",//Row=914  Unique Row 
        "0 6 0 ",//Row=915  Unique Row 
        "0 7 8 ",//Row=916  Unique Row 
        "0 8 1 ",//Row=917  Unique Row 
        "0 9 2 ",//Row=918  Unique Row 
        "0 0 3 ",//Row=919  Unique Row 
        "0 1 4 ",//Row=920  Unique Row 
        "0 2 5 ",//Row=921  Unique Row 
        "0 3 6 ",//Row=922  Unique Row 
        "0 4 7 ",//Row=923  Unique Row 
        "0 5 5 ",//Row=924  Unique Row 
        "0 6 9 ",//Row=925  Unique Row 
        "0 7 0 ",//Row=926  Unique Row 
        "0 8 8 ",//Row=927  Unique Row 
        "0 9 1 ",//Row=928  Unique Row 
        "0 0 2 ",//Row=929  Unique Row 
        "0 1 3 ",//Row=930  Unique Row 
        "0 2 4 ",//Row=931  Unique Row 
        "0 3 9 ",//Row=932  Unique Row 
        "0 4 6 ",//Row=933  Unique Row 
        "0 5 7 ",//Row=934  Unique Row 
        "0 6 5 ",//Row=935  Unique Row 
        "0 7 9 ",//Row=936  Unique Row 
        "0 8 0 ",//Row=937  Unique Row 
        "0 9 8 ",//Row=938  Unique Row 
        "0 0 1 ",//Row=939  Unique Row 
        "0 1 2 ",//Row=940  Unique Row 
        "0 2 3 ",//Row=941  Unique Row 
        "0 3 4 ",//Row=942  Unique Row 
        "0 4 9 ",//Row=943  Row i=943 duplicate with Row=903
        "0 5 6 ",//Row=944  Unique Row 
        "0 6 7 ",//Row=945  Unique Row 
        "0 7 5 ",//Row=946  Unique Row 
        "0 8 9 ",//Row=947  Unique Row 
        "0 9 0 ",//Row=948  Unique Row 
        "0 0 8 ",//Row=949  Unique Row 
        "0 1 1 ",//Row=950  Unique Row 
        "0 2 2 ",//Row=951  Unique Row 
        "0 3 3 ",//Row=952  Unique Row 
        "0 4 4 ",//Row=953  Unique Row 
        "0 5 9 ",//Row=954  Row i=954 duplicate with Row=914
        "0 6 6 ",//Row=955  Unique Row 
        "0 7 7 ",//Row=956  Unique Row 
        "0 8 5 ",//Row=957  Unique Row 
        "0 9 9 ",//Row=958  Unique Row 
        "0 0 0 ",//Row=959  Unique Row 
        "0 1 8 ",//Row=960  Unique Row 
        "0 2 1 ",//Row=961  Unique Row 
        "0 3 2 ",//Row=962  Unique Row 
        "0 4 3 ",//Row=963  Unique Row 
        "0 5 4 ",//Row=964  Unique Row 
        "0 6 0 ",//Row=965  Row i=965 duplicate with Row=915
        "0 7 6 ",//Row=966  Unique Row 
        "0 8 7 ",//Row=967  Unique Row 
        "0 9 5 ",//Row=968  Unique Row 
        "0 0 9 ",//Row=969  Unique Row 
        "0 1 0 ",//Row=970  Unique Row 
        "0 2 8 ",//Row=971  Unique Row 
        "0 3 1 ",//Row=972  Unique Row 
        "0 4 2 ",//Row=973  Unique Row 
        "0 5 3 ",//Row=974  Unique Row 
        "0 6 4 ",//Row=975  Unique Row 
        "0 7 9 ",//Row=976  Row i=976 duplicate with Row=936
        "0 8 6 ",//Row=977  Unique Row 
        "0 9 7 ",//Row=978  Unique Row 
        "0 0 5 ",//Row=979  Unique Row 
        "0 1 9 ",//Row=980  Unique Row 
        "0 2 0 ",//Row=981  Unique Row 
        "0 3 8 ",//Row=982  Unique Row 
        "0 4 1 ",//Row=983  Unique Row 
        "0 5 2 ",//Row=984  Unique Row 
        "0 6 3 ",//Row=985  Unique Row 
        "0 7 4 ",//Row=986  Unique Row 
        "0 8 9 ",//Row=987  Row i=987 duplicate with Row=947
        "0 9 6 ",//Row=988  Unique Row 
        "0 0 7 ",//Row=989  Unique Row 
        "0 1 9 ",//Row=990  Row i=990 duplicate with Row=980
        "0 2 9 ",//Row=991  Unique Row 
        "0 3 0 ",//Row=992  Unique Row 
        "0 4 8 ",//Row=993  Unique Row 
        "0 5 1 ",//Row=994  Unique Row 
        "0 6 2 ",//Row=995  Unique Row 
        "0 7 3 ",//Row=996  Unique Row 
        "0 8 4 ",//Row=997  Unique Row 
        "0 9 9 ",//Row=998  Row i=998 duplicate with Row=958
        "0 0 6 ",//Row=999  Unique Row 
    };
    static String[] OATSType4DigitPattern = {
        //DataArray:Header(Name):FirsttPat SecondPat 
        "1 1 1 0 ",//Row=0  Unique Row 
"1 2 1 9 ",//Row=1  Unique Row 
"1 3 1 8 ",//Row=2  Unique Row 
"1 4 1 7 ",//Row=3  Unique Row 
"1 5 1 6 ",//Row=4  Unique Row 
"1 6 1 5 ",//Row=5  Unique Row 
"1 7 1 4 ",//Row=6  Unique Row 
"1 8 1 3 ",//Row=7  Unique Row 
"1 9 1 2 ",//Row=8  Unique Row 
"1 0 1 1 ",//Row=9  Unique Row 
"1 1 1 3 ",//Row=10  Unique Row 
"1 2 1 3 ",//Row=11  Unique Row 
"1 3 1 3 ",//Row=12  Unique Row 
"1 4 1 3 ",//Row=13  Unique Row 
"1 5 1 3 ",//Row=14  Unique Row 
"1 6 1 3 ",//Row=15  Unique Row 
"1 7 1 3 ",//Row=16  Unique Row 
"1 9 2 8 ",//Row=17  Unique Row 
"1 9 1 3 ",//Row=18  Unique Row 
"1 0 1 3 ",//Row=19  Unique Row 
"1 2 2 1 ",//Row=20  Unique Row 
"1 3 2 2 ",//Row=21  Unique Row 
"1 3 2 4 ",//Row=22  Unique Row 
"1 5 2 4 ",//Row=23  Unique Row 
"1 6 2 5 ",//Row=24  Unique Row 
"1 7 2 6 ",//Row=25  Unique Row 
"1 8 2 7 ",//Row=26  Unique Row 
"1 2 2 9 ",//Row=28  Unique Row 
"1 1 2 0 ",//Row=29  Unique Row 
"1 1 2 9 ",//Row=38  Unique Row 
"1 0 2 9 ",//Row=58  Unique Row 
"1 9 2 9 ",//Row=68  Unique Row 
"1 8 2 9 ",//Row=78  Unique Row 
"1 5 2 9 ",//Row=88  Unique Row 
"1 6 2 9 ",//Row=98  Unique Row 
"1 0 0 1 ",//Row=99  Unique Row 
"2 1 0 0 ",//Row=100  Unique Row 
"2 2 0 9 ",//Row=101  Unique Row 
"2 3 0 8 ",//Row=102  Unique Row 
"2 4 0 7 ",//Row=103  Unique Row 
"2 5 0 6 ",//Row=104  Unique Row 
"2 6 0 5 ",//Row=105  Unique Row 
"2 7 0 4 ",//Row=106  Unique Row 
"2 8 0 3 ",//Row=107  Unique Row 
"2 9 0 2 ",//Row=108  Unique Row 
"2 0 0 1 ",//Row=109  Unique Row 
"2 1 0 3 ",//Row=110  Unique Row 
"2 2 0 3 ",//Row=111  Unique Row 
"2 3 0 3 ",//Row=112  Unique Row 
"2 4 0 3 ",//Row=113  Unique Row 
"2 5 0 3 ",//Row=114  Unique Row 
"2 6 0 3 ",//Row=115  Unique Row 
"2 7 0 3 ",//Row=116  Unique Row 
"2 9 1 8 ",//Row=117  Unique Row 
"2 9 0 3 ",//Row=118  Unique Row 
"2 0 0 3 ",//Row=119  Unique Row 
"2 2 1 1 ",//Row=120  Unique Row 
"2 3 1 2 ",//Row=121  Unique Row 
"2 3 1 4 ",//Row=122  Unique Row 
"2 5 1 4 ",//Row=123  Unique Row 
"2 6 1 5 ",//Row=124  Unique Row 
"2 7 1 6 ",//Row=125  Unique Row 
"2 8 1 7 ",//Row=126  Unique Row 
"2 3 1 9 ",//Row=128  Unique Row 
"2 1 1 0 ",//Row=129  Unique Row 
"2 2 1 9 ",//Row=138  Unique Row 
"3 7 9 4 ",//Row=206  Unique Row 
"3 8 9 3 ",//Row=207  Unique Row 
"3 9 9 2 ",//Row=208  Unique Row 
"3 0 9 1 ",//Row=209  Unique Row 
"3 1 9 3 ",//Row=210  Unique Row 
"3 2 9 3 ",//Row=211  Unique Row 
"3 3 9 3 ",//Row=212  Unique Row 
"3 4 9 3 ",//Row=213  Unique Row 
"3 5 9 3 ",//Row=214  Unique Row 
"3 6 9 3 ",//Row=215  Unique Row 
"3 7 9 3 ",//Row=216  Unique Row 
"3 9 5 8 ",//Row=217  Unique Row 
"3 9 9 3 ",//Row=218  Unique Row 
"3 0 9 3 ",//Row=219  Unique Row 
"3 2 5 1 ",//Row=220  Unique Row 
"3 3 9 2 ",//Row=221  Unique Row 
"3 3 0 4 ",//Row=222  Unique Row 
"3 5 8 4 ",//Row=223  Unique Row 
"3 6 1 5 ",//Row=224  Unique Row 
"3 7 2 6 ",//Row=225  Unique Row 
"3 8 3 7 ",//Row=226  Unique Row 
"3 9 4 8 ",//Row=227  Unique Row 
"3 4 5 9 ",//Row=228  Unique Row 
"3 1 6 0 ",//Row=229  Unique Row 
"3 2 7 1 ",//Row=230  Unique Row 
"3 3 5 2 ",//Row=231  Unique Row 
"3 3 9 4 ",//Row=232  Unique Row 
"3 5 0 4 ",//Row=233  Unique Row 
"3 6 8 5 ",//Row=234  Unique Row 
"3 7 1 6 ",//Row=235  Unique Row 
"3 8 2 7 ",//Row=236  Unique Row 
"3 9 3 8 ",//Row=237  Unique Row 
"3 3 4 9 ",//Row=238  Unique Row 
"3 1 5 0 ",//Row=239  Unique Row 
"3 2 6 1 ",//Row=240  Unique Row 
"3 3 7 2 ",//Row=241  Unique Row 
"3 3 5 4 ",//Row=242  Unique Row 
"3 5 9 4 ",//Row=243  Unique Row 
"3 6 0 5 ",//Row=244  Unique Row 
"3 7 8 6 ",//Row=245  Unique Row 
"3 8 1 7 ",//Row=246  Unique Row 
"3 9 2 8 ",//Row=247  Unique Row 
"3 2 3 9 ",//Row=248  Unique Row 
"3 1 4 0 ",//Row=249  Unique Row 
"3 3 6 2 ",//Row=251  Unique Row 
"3 3 7 4 ",//Row=252  Unique Row 
"3 5 5 4 ",//Row=253  Unique Row 
"3 7 0 6 ",//Row=255  Unique Row 
"3 8 8 7 ",//Row=256  Unique Row 
"3 9 1 8 ",//Row=257  Unique Row 
"3 1 2 9 ",//Row=258  Unique Row 
"3 1 3 0 ",//Row=259  Unique Row 
"3 2 4 1 ",//Row=260  Unique Row 
"3 3 6 4 ",//Row=262  Unique Row 
"3 5 7 4 ",//Row=263  Unique Row 
"3 6 5 5 ",//Row=264  Unique Row 
"3 7 9 6 ",//Row=265  Unique Row 
"3 8 0 7 ",//Row=266  Unique Row 
"3 9 8 8 ",//Row=267  Unique Row 
"3 1 1 9 ",//Row=268  Unique Row 
"3 1 2 0 ",//Row=269  Unique Row 
"3 2 3 1 ",//Row=270  Unique Row 
"3 3 4 2 ",//Row=271  Unique Row 
"3 5 6 4 ",//Row=273  Unique Row 
"3 6 7 5 ",//Row=274  Unique Row 
"3 7 5 6 ",//Row=275  Unique Row 
"3 8 9 7 ",//Row=276  Unique Row 
"3 9 0 8 ",//Row=277  Unique Row 
"3 0 8 9 ",//Row=278  Unique Row 
"3 1 1 0 ",//Row=279  Unique Row 
"3 2 2 1 ",//Row=280  Unique Row 
"3 3 3 2 ",//Row=281  Unique Row 
"3 3 4 4 ",//Row=282  Unique Row 
"3 6 6 5 ",//Row=284  Unique Row 
"3 7 7 6 ",//Row=285  Unique Row 
"3 8 5 7 ",//Row=286  Unique Row 
"3 9 9 8 ",//Row=287  Unique Row 
"3 9 0 9 ",//Row=288  Unique Row 
"3 1 8 0 ",//Row=289  Unique Row 
"3 2 1 1 ",//Row=290  Unique Row 
"3 3 2 2 ",//Row=291  Unique Row 
"3 3 3 4 ",//Row=292  Unique Row 
"3 5 4 4 ",//Row=293  Unique Row 
"3 7 6 6 ",//Row=295  Unique Row 
"3 8 7 7 ",//Row=296  Unique Row 
"3 8 9 9 ",//Row=298  Unique Row 
"3 0 8 1 ",//Row=299  Unique Row 
"4 1 8 0 ",//Row=300  Unique Row 
"4 2 8 9 ",//Row=301  Unique Row 
"4 3 8 8 ",//Row=302  Unique Row 
"4 4 8 7 ",//Row=303  Unique Row 
"4 5 8 6 ",//Row=304  Unique Row 
"4 6 8 5 ",//Row=305  Unique Row 
"4 7 8 4 ",//Row=306  Unique Row 
"4 8 8 3 ",//Row=307  Unique Row 
"4 9 8 2 ",//Row=308  Unique Row 
"4 10 8 1 ",//Row=309  Unique Row 
"4 1 8 3 ",//Row=30  Unique Row 
"4 2 8 3 ",//Row=311  Unique Row 
"4 3 8 3 ",//Row=312  Unique Row 
"4 4 8 3 ",//Row=313  Unique Row 
"4 5 8 3 ",//Row=314  Unique Row 
"4 6 8 3 ",//Row=315  Unique Row 
"4 7 8 3 ",//Row=316  Unique Row 
"4 9 9 8 ",//Row=317  Unique Row 
"4 9 8 3 ",//Row=318  Unique Row 
"4 0 8 3 ",//Row=319  Unique Row 
"4 2 9 1 ",//Row=320  Unique Row 
"4 3 9 2 ",//Row=321  Unique Row 
"4 3 9 4 ",//Row=322  Unique Row 
"4 5 9 4 ",//Row=323  Unique Row 
"4 6 9 5 ",//Row=324  Unique Row 
"4 7 9 6 ",//Row=325  Unique Row 
"4 8 9 7 ",//Row=326  Unique Row 
"4 5 9 9 ",//Row=328  Unique Row 
"4 1 9 0 ",//Row=329  Unique Row 
"4 4 9 9 ",//Row=338  Unique Row 
"4 3 9 9 ",//Row=348  Unique Row 
"4 2 9 9 ",//Row=358  Unique Row 
"4 1 9 9 ",//Row=368  Unique Row 
"4 0 9 9 ",//Row=388  Unique Row 
"4 9 9 9 ",//Row=398  Unique Row 
"4 0 7 1 ",//Row=399  Unique Row 
"5 1 7 0 ",//Row=400  Unique Row 
"5 2 7 9 ",//Row=401  Unique Row 
"5 3 7 8 ",//Row=402  Unique Row 
"5 4 7 7 ",//Row=403  Unique Row 
"5 5 7 6 ",//Row=404  Unique Row 
"5 6 7 5 ",//Row=405  Unique Row 
"5 7 7 4 ",//Row=406  Unique Row 
"5 8 7 3 ",//Row=407  Unique Row 
"5 9 7 2 ",//Row=408  Unique Row 
"5 0 7 1 ",//Row=409  Unique Row 
"5 1 7 3 ",//Row=410  Unique Row 
"5 2 7 3 ",//Row=411  Unique Row 
"5 3 7 3 ",//Row=412  Unique Row 
"5 4 7 3 ",//Row=413  Unique Row 
"5 5 7 3 ",//Row=414  Unique Row 
"5 6 7 3 ",//Row=415  Unique Row 
"5 7 7 3 ",//Row=416  Unique Row 
"5 9 8 8 ",//Row=417  Unique Row 
"5 9 7 3 ",//Row=418  Unique Row 
"5 0 7 3 ",//Row=419  Unique Row 
"5 2 8 1 ",//Row=420  Unique Row 
"5 3 8 2 ",//Row=421  Unique Row 
"5 3 8 4 ",//Row=422  Unique Row 
"5 5 8 4 ",//Row=423  Unique Row 
"5 6 8 5 ",//Row=424  Unique Row 
"5 7 8 6 ",//Row=425  Unique Row 
"5 8 8 7 ",//Row=426  Unique Row 
"5 6 8 9 ",//Row=428  Unique Row 
"5 1 8 0 ",//Row=429  Unique Row 
"5 5 8 9 ",//Row=438  Unique Row 
"5 4 8 9 ",//Row=448  Unique Row 
"5 3 8 9 ",//Row=458  Unique Row 
"5 2 8 9 ",//Row=468  Unique Row 
"5 1 8 9 ",//Row=478  Unique Row 
"5 0 8 9 ",//Row=498  Unique Row 
"5 0 6 1 ",//Row=499  Unique Row 
"6 1 6 0 ",//Row=500  Unique Row 
"6 2 6 9 ",//Row=501  Unique Row 
"6 3 6 8 ",//Row=502  Unique Row 
"6 4 6 7 ",//Row=503  Unique Row 
"6 5 6 6 ",//Row=504  Unique Row 
"6 6 6 5 ",//Row=505  Unique Row 
"6 7 6 4 ",//Row=506  Unique Row 
"6 8 6 3 ",//Row=507  Unique Row 
"6 9 6 2 ",//Row=508  Unique Row 
"6 0 6 1 ",//Row=509  Unique Row 
"6 1 6 3 ",//Row=510  Unique Row 
"6 2 6 3 ",//Row=511  Unique Row 
"6 3 6 3 ",//Row=512  Unique Row 
"6 4 6 3 ",//Row=513  Unique Row 
"6 5 6 3 ",//Row=514  Unique Row 
"6 6 6 3 ",//Row=515  Unique Row 
"6 7 6 3 ",//Row=516  Unique Row 
"6 9 7 8 ",//Row=517  Unique Row 
"6 9 6 3 ",//Row=518  Unique Row 
"6 0 6 3 ",//Row=519  Unique Row 
"6 2 7 1 ",//Row=520  Unique Row 
"6 3 7 2 ",//Row=521  Unique Row 
"6 3 7 4 ",//Row=522  Unique Row 
"6 5 7 4 ",//Row=523  Unique Row 
"6 6 7 5 ",//Row=524  Unique Row 
"6 7 7 6 ",//Row=525  Unique Row 
"6 8 7 7 ",//Row=526  Unique Row 
"6 5 7 9 ",//Row=528  Unique Row 
"6 1 7 0 ",//Row=529  Unique Row 
"6 6 7 9 ",//Row=538  Unique Row 
"6 4 7 9 ",//Row=558  Unique Row 
"6 3 7 9 ",//Row=568  Unique Row 
"6 2 7 9 ",//Row=578  Unique Row 
"6 1 7 9 ",//Row=588  Unique Row 
"6 0 5 1 ",//Row=599  Unique Row 
"7 1 5 0 ",//Row=600  Unique Row 
"7 2 5 9 ",//Row=601  Unique Row 
"7 3 5 8 ",//Row=602  Unique Row 
"7 4 5 7 ",//Row=603  Unique Row 
"7 5 5 6 ",//Row=604  Unique Row 
"7 6 5 5 ",//Row=605  Unique Row 
"7 7 5 4 ",//Row=606  Unique Row 
"7 8 5 3 ",//Row=607  Unique Row 
"7 9 5 2 ",//Row=608  Unique Row 
"7 0 5 1 ",//Row=609  Unique Row 
"7 1 5 3 ",//Row=610  Unique Row 
"7 2 5 3 ",//Row=611  Unique Row 
"7 3 5 3 ",//Row=612  Unique Row 
"7 4 5 3 ",//Row=613  Unique Row 
"7 5 5 3 ",//Row=614  Unique Row 
"7 6 5 3 ",//Row=615  Unique Row 
"7 7 5 3 ",//Row=616  Unique Row 
"7 9 6 8 ",//Row=617  Unique Row 
"7 9 5 3 ",//Row=618  Unique Row 
"7 0 5 3 ",//Row=619  Unique Row 
"7 2 6 1 ",//Row=620  Unique Row 
"7 3 6 2 ",//Row=621  Unique Row 
"7 3 6 4 ",//Row=622  Unique Row 
"7 5 6 4 ",//Row=623  Unique Row 
"7 6 6 5 ",//Row=624  Unique Row 
"7 7 6 6 ",//Row=625  Unique Row 
"7 8 6 7 ",//Row=626  Unique Row 
"7 8 6 9 ",//Row=628  Unique Row 
"7 1 6 0 ",//Row=629  Unique Row 
"7 5 6 9 ",//Row=638  Unique Row 
"7 6 6 9 ",//Row=648  Unique Row 
"7 4 6 9 ",//Row=668  Unique Row 
"7 3 6 9 ",//Row=678  Unique Row 
"7 2 6 9 ",//Row=688  Unique Row 
"7 1 6 9 ",//Row=698  Unique Row 
"7 0 4 1 ",//Row=699  Unique Row 
"8 1 4 0 ",//Row=700  Unique Row 
"8 2 4 9 ",//Row=701  Unique Row 
"8 3 4 8 ",//Row=702  Unique Row 
"8 4 4 7 ",//Row=703  Unique Row 
"8 5 4 6 ",//Row=704  Unique Row 
"8 6 4 5 ",//Row=705  Unique Row 
"8 7 4 4 ",//Row=706  Unique Row 
"8 8 4 3 ",//Row=707  Unique Row 
"8 9 4 2 ",//Row=708  Unique Row 
"8 0 4 1 ",//Row=709  Unique Row 
"8 1 4 3 ",//Row=710  Unique Row 
"8 2 4 3 ",//Row=711  Unique Row 
"8 3 4 3 ",//Row=712  Unique Row 
"8 4 4 3 ",//Row=713  Unique Row 
"8 5 4 3 ",//Row=714  Unique Row 
"8 6 4 3 ",//Row=715  Unique Row 
"8 7 4 3 ",//Row=716  Unique Row 
"8 9 5 8 ",//Row=717  Unique Row 
"8 9 4 3 ",//Row=718  Unique Row 
"8 0 4 3 ",//Row=719  Unique Row 
"8 2 5 1 ",//Row=720  Unique Row 
"8 3 5 2 ",//Row=721  Unique Row 
"8 3 5 4 ",//Row=722  Unique Row 
"8 5 5 4 ",//Row=723  Unique Row 
"8 6 5 5 ",//Row=724  Unique Row 
"8 7 5 6 ",//Row=725  Unique Row 
"8 8 5 7 ",//Row=726  Unique Row 
"8 9 5 9 ",//Row=728  Unique Row 
"8 1 5 0 ",//Row=729  Unique Row 
"8 8 5 9 ",//Row=738  Unique Row 
"8 5 5 9 ",//Row=748  Unique Row 
"8 6 5 9 ",//Row=758  Unique Row 
"8 4 5 9 ",//Row=778  Unique Row 
"8 3 5 9 ",//Row=788  Unique Row 
"8 2 5 9 ",//Row=798  Unique Row 
"8 0 3 1 ",//Row=799  Unique Row 
"9 1 3 0 ",//Row=800  Unique Row 
"9 2 3 9 ",//Row=801  Unique Row 
"9 3 3 8 ",//Row=802  Unique Row 
"9 4 3 7 ",//Row=803  Unique Row 
"9 5 3 6 ",//Row=804  Unique Row 
"9 6 3 5 ",//Row=805  Unique Row 
"9 7 3 4 ",//Row=806  Unique Row 
"9 8 3 3 ",//Row=807  Unique Row 
"9 9 3 2 ",//Row=808  Unique Row 
"9 0 3 1 ",//Row=809  Unique Row 
"9 1 3 3 ",//Row=810  Unique Row 
"9 2 3 3 ",//Row=811  Unique Row 
"9 3 3 3 ",//Row=812  Unique Row 
"9 4 3 3 ",//Row=813  Unique Row 
"9 5 3 3 ",//Row=814  Unique Row 
"9 6 3 3 ",//Row=815  Unique Row 
"9 7 3 3 ",//Row=816  Unique Row 
"9 9 3 3 ",//Row=818  Unique Row 
"9 10 3 3 ",//Row=819  Unique Row 
"9 0 2 1 ",//Row=899  Unique Row 
"0 1 2 0 ",//Row=900  Unique Row 
"0 2 2 9 ",//Row=901  Unique Row 
"0 3 2 8 ",//Row=902  Unique Row 
"0 4 2 7 ",//Row=903  Unique Row 
"0 5 2 6 ",//Row=904  Unique Row 
"0 6 2 5 ",//Row=905  Unique Row 
"0 7 2 4 ",//Row=906  Unique Row 
"0 8 2 3 ",//Row=907  Unique Row 
"0 9 2 2 ",//Row=908  Unique Row 
"0 0 2 1 ",//Row=909  Unique Row 
"0 1 2 4 ",//Row=910  Unique Row 
"0 2 2 4 ",//Row=911  Unique Row 
"0 3 2 4 ",//Row=912  Unique Row 
"0 4 2 4 ",//Row=913  Unique Row 
"0 5 2 4 ",//Row=914  Unique Row 
"0 6 2 4 ",//Row=915  Unique Row 
"0 8 2 4 ",//Row=917  Unique Row 
"0 9 2 4 ",//Row=918  Unique Row 
"0 0 2 4 ",//Row=919  Unique Row 
"0 0 1 1 ",//Row=999  Unique Row 
    };

    static String[] OATSType5DigitPattern = {
        //DataArray:Header(Name):FirsttPat SecondPat 
            "1 1 1 0 1 ",//Row=0  Unique Row 
"1 2 1 9 2 ",//Row=1  Unique Row 
"1 3 1 8 3 ",//Row=2  Unique Row 
"1 4 1 7 4 ",//Row=3  Unique Row 
"1 5 1 6 5 ",//Row=4  Unique Row 
"1 6 1 5 6 ",//Row=5  Unique Row 
"1 7 1 4 7 ",//Row=6  Unique Row 
"1 8 1 3 8 ",//Row=7  Unique Row 
"1 9 1 2 9 ",//Row=8  Unique Row 
"1 0 1 1 0 ",//Row=9  Unique Row 
"1 1 1 0 2 ",//Row=0  Unique Row 
"1 2 1 9 3 ",//Row=11  Unique Row 
"1 3 1 8 4 ",//Row=12  Unique Row 
"1 4 1 7 5 ",//Row=13  Unique Row 
"1 5 1 6 7 ",//Row=14  Unique Row 
"1 6 1 5 8 ",//Row=15  Unique Row 
"1 7 1 4 9 ",//Row=16  Unique Row 
"1 8 1 3 0 ",//Row=17  Unique Row 
"1 9 1 2 1 ",//Row=18  Unique Row 
"1 0 1 1 2 ",//Row=19  Unique Row 
"1 1 1 0 3 ",//Row=20  Unique Row 
"1 2 1 9 4 ",//Row=21  Unique Row 
"1 3 1 8 5 ",//Row=22  Unique Row 
"1 4 1 7 6 ",//Row=23  Unique Row 
"1 5 1 6 6 ",//Row=24  Unique Row 
"1 6 1 5 5 ",//Row=25  Unique Row 
"1 7 1 4 4 ",//Row=26  Unique Row 
"1 8 1 3 3 ",//Row=27  Unique Row 
"1 9 1 2 6 ",//Row=28  Unique Row 
"1 0 1 1 6 ",//Row=29  Unique Row 
"1 1 1 0 0 ",//Row=30  Unique Row 
"1 2 1 9 9 ",//Row=31  Unique Row 
"1 3 1 8 8 ",//Row=32  Unique Row 
"1 4 1 7 7 ",//Row=33  Unique Row 
"1 6 2 1 5 ",//Row=34  Unique Row 
"1 6 2 1 7 ",//Row=35  Unique Row 
"1 7 2 1 8 ",//Row=36  Unique Row 
"1 8 1 3 6 ",//Row=37  Unique Row 
"1 1 2 1 9 ",//Row=38  Unique Row 
"1 1 2 2 0 ",//Row=39  Unique Row 
"1 1 1 0 6 ",//Row=40  Unique Row 
"1 2 1 9 6 ",//Row=41  Unique Row 
"1 3 1 8 6 ",//Row=42  Unique Row 
"1 5 2 1 4 ",//Row=43  Unique Row 
"1 9 2 1 8 ",//Row=47  Unique Row 
"1 2 2 1 1 ",//Row=50  Unique Row 
"1 3 2 1 2 ",//Row=51  Unique Row 
"1 4 2 1 3 ",//Row=52  Unique Row 
"1 0 2 1 9 ",//Row=58  Unique Row 
"1 9 2 1 9 ",//Row=68  Unique Row 
"1 8 2 1 9 ",//Row=78  Unique Row 
"1 5 2 1 9 ",//Row=88  Unique Row 
"1 6 2 1 9 ",//Row=98  Unique Row 
"1 4 2 1 9 ",//Row=118  Unique Row 
"1 3 2 1 9 ",//Row=128  Unique Row 
"1 2 2 1 9 ",//Row=138  Unique Row 
"1 0 0 1 2 ",//Row=999  Unique Row 
"2 1 0 0 3 ",//Row=1000  Unique Row 
"2 2 0 9 4 ",//Row=1001  Unique Row 
"2 3 0 8 5 ",//Row=1002  Unique Row 
"2 4 0 7 6 ",//Row=1003  Unique Row 
"2 5 0 6 7 ",//Row=1004  Unique Row 
"2 6 0 5 8 ",//Row=1005  Unique Row 
"2 7 0 4 9 ",//Row=1006  Unique Row 
"2 8 0 3 0 ",//Row=1007  Unique Row 
"2 9 0 2 1 ",//Row=1008  Unique Row 
"2 0 0 1 2 ",//Row=1009  Unique Row 
"2 1 0 0 0 ",//Row=100  Unique Row 
"2 2 0 9 9 ",//Row=1011  Unique Row 
"2 3 0 8 8 ",//Row=1012  Unique Row 
"2 4 0 7 7 ",//Row=1013  Unique Row 
"2 5 0 6 6 ",//Row=1014  Unique Row 
"2 6 0 5 5 ",//Row=1015  Unique Row 
"2 7 0 4 4 ",//Row=1016  Unique Row 
"2 8 0 3 3 ",//Row=1017  Unique Row 
"2 9 0 2 6 ",//Row=1018  Unique Row 
"2 0 0 1 6 ",//Row=1019  Unique Row 
"2 1 0 0 6 ",//Row=1020  Unique Row 
"2 2 0 9 6 ",//Row=1021  Unique Row 
"2 3 0 8 6 ",//Row=1022  Unique Row 
"2 5 1 0 4 ",//Row=1023  Unique Row 
"2 6 1 0 5 ",//Row=1024  Unique Row 
"2 6 0 5 6 ",//Row=1025  Unique Row 
"2 7 0 4 7 ",//Row=1026  Unique Row 
"2 8 0 3 6 ",//Row=1027  Unique Row 
"2 1 1 0 9 ",//Row=1028  Unique Row 
"2 1 1 0 0 ",//Row=1029  Unique Row 
"2 2 1 1 1 ",//Row=1030  Unique Row 
"2 3 1 0 2 ",//Row=1031  Unique Row 
"2 4 1 0 3 ",//Row=1032  Unique Row 
"2 6 1 0 7 ",//Row=1035  Unique Row 
"2 7 1 0 8 ",//Row=1036  Unique Row 
"2 9 1 0 8 ",//Row=1037  Unique Row 
"2 0 1 0 9 ",//Row=1048  Unique Row 
"2 9 1 0 9 ",//Row=1058  Unique Row 
"2 8 1 0 9 ",//Row=1068  Unique Row 
"2 5 1 0 9 ",//Row=1078  Unique Row 
"2 6 1 0 9 ",//Row=1088  Unique Row 
"2 4 1 0 9 ",//Row=1108  Unique Row 
"2 3 1 0 9 ",//Row=1118  Unique Row 
"2 2 1 0 9 ",//Row=1128  Unique Row 
"2 0 9 1 2 ",//Row=1999  Unique Row 
"3 1 9 0 3 ",//Row=2000  Unique Row 
"3 2 9 9 4 ",//Row=2001  Unique Row 
"3 3 9 8 5 ",//Row=2002  Unique Row 
"3 4 9 7 6 ",//Row=2003  Unique Row 
"3 5 9 6 7 ",//Row=2004  Unique Row 
"3 6 9 5 8 ",//Row=2005  Unique Row 
"3 7 9 4 9 ",//Row=2006  Unique Row 
"3 8 9 3 0 ",//Row=2007  Unique Row 
"3 9 9 2 1 ",//Row=2008  Unique Row 
"3 0 9 1 2 ",//Row=2009  Unique Row 
"3 1 9 0 0 ",//Row=200  Unique Row 
"3 2 9 9 9 ",//Row=2011  Unique Row 
"3 3 9 8 8 ",//Row=2012  Unique Row 
"3 4 9 7 7 ",//Row=2013  Unique Row 
"3 5 9 6 6 ",//Row=2014  Unique Row 
"3 6 9 5 5 ",//Row=2015  Unique Row 
"3 7 9 4 4 ",//Row=2016  Unique Row 
"3 8 9 3 3 ",//Row=2017  Unique Row 
"3 9 9 2 6 ",//Row=2018  Unique Row 
"3 0 9 1 6 ",//Row=2019  Unique Row 
"3 1 9 0 6 ",//Row=2020  Unique Row 
"3 2 9 9 6 ",//Row=2021  Unique Row 
"3 3 9 8 6 ",//Row=2022  Unique Row 
"3 5 7 9 4 ",//Row=2023  Unique Row 
"3 6 5 9 5 ",//Row=2024  Unique Row 
"3 6 9 5 6 ",//Row=2025  Unique Row 
"3 7 9 4 7 ",//Row=2026  Unique Row 
"3 8 9 3 6 ",//Row=2027  Unique Row 
"3 1 1 9 9 ",//Row=2028  Unique Row 
"3 1 2 9 0 ",//Row=2029  Unique Row 
"3 2 3 9 1 ",//Row=2030  Unique Row 
"3 3 5 5 2 ",//Row=2031  Unique Row 
"3 4 5 9 3 ",//Row=2032  Unique Row 
"3 5 6 9 4 ",//Row=2033  Unique Row 
"3 6 7 9 5 ",//Row=2034  Unique Row 
"3 6 5 9 7 ",//Row=2035  Unique Row 
"3 7 9 9 8 ",//Row=2036  Unique Row 
"3 9 0 9 8 ",//Row=2037  Unique Row 
"3 0 8 9 9 ",//Row=2038  Unique Row 
"3 1 1 9 0 ",//Row=2039  Unique Row 
"3 2 2 9 1 ",//Row=2040  Unique Row 
"3 3 4 4 2 ",//Row=2041  Unique Row 
"3 4 4 9 3 ",//Row=2042  Unique Row 
"3 5 5 9 4 ",//Row=2043  Unique Row 
"3 6 6 9 5 ",//Row=2044  Unique Row 
"3 6 7 9 7 ",//Row=2045  Unique Row 
"3 7 5 9 8 ",//Row=2046  Unique Row 
"3 9 9 9 8 ",//Row=2047  Unique Row 
"3 9 0 9 9 ",//Row=2048  Unique Row 
"3 1 8 9 0 ",//Row=2049  Unique Row 
"3 2 1 9 1 ",//Row=2050  Unique Row 
"3 3 3 3 2 ",//Row=2051  Unique Row 
"3 4 3 9 3 ",//Row=2052  Unique Row 
"3 5 4 9 4 ",//Row=2053  Unique Row 
"3 6 6 9 7 ",//Row=2055  Unique Row 
"3 7 7 9 8 ",//Row=2056  Unique Row 
"3 9 5 9 8 ",//Row=2057  Unique Row 
"3 8 9 9 9 ",//Row=2058  Unique Row 
"3 1 0 9 0 ",//Row=2059  Unique Row 
"3 2 8 9 1 ",//Row=2060  Unique Row 
"3 3 2 2 2 ",//Row=2061  Unique Row 
"3 4 2 9 3 ",//Row=2062  Unique Row 
"3 5 3 9 4 ",//Row=2063  Unique Row 
"3 6 4 9 5 ",//Row=2064  Unique Row 
"3 7 6 9 8 ",//Row=2066  Unique Row 
"3 9 7 9 8 ",//Row=2067  Unique Row 
"3 5 5 9 9 ",//Row=2068  Unique Row 
"3 1 9 9 0 ",//Row=2069  Unique Row 
"3 2 0 9 1 ",//Row=2070  Unique Row 
"3 3 1 1 2 ",//Row=2071  Unique Row 
"3 4 9 9 3 ",//Row=2072  Unique Row 
"3 5 2 9 4 ",//Row=2073  Unique Row 
"3 6 3 9 5 ",//Row=2074  Unique Row 
"3 6 4 9 7 ",//Row=2075  Unique Row 
"3 9 6 9 8 ",//Row=2077  Unique Row 
"3 6 7 9 9 ",//Row=2078  Unique Row 
"3 1 5 9 0 ",//Row=2079  Unique Row 
"3 2 9 9 1 ",//Row=2080  Unique Row 
"3 4 1 9 3 ",//Row=2082  Unique Row 
"3 5 1 9 4 ",//Row=2083  Unique Row 
"3 6 2 9 5 ",//Row=2084  Unique Row 
"3 6 3 9 7 ",//Row=2085  Unique Row 
"3 7 4 9 8 ",//Row=2086  Unique Row 
"3 5 6 9 9 ",//Row=2088  Unique Row 
"3 1 7 9 0 ",//Row=2089  Unique Row 
"3 2 5 9 1 ",//Row=2090  Unique Row 
"3 3 0 0 2 ",//Row=2091  Unique Row 
"3 4 0 9 3 ",//Row=2092  Unique Row 
"3 5 8 9 4 ",//Row=2093  Unique Row 
"3 6 1 9 5 ",//Row=2094  Unique Row 
"3 6 2 9 7 ",//Row=2095  Unique Row 
"3 7 3 9 8 ",//Row=2096  Unique Row 
"3 9 4 9 8 ",//Row=2097  Unique Row 
"3 4 5 9 9 ",//Row=2098  Unique Row 
"3 1 6 9 0 ",//Row=2099  Unique Row 
"3 2 7 9 1 ",//Row=2100  Unique Row 
"3 5 0 9 4 ",//Row=2103  Unique Row 
"3 6 8 9 5 ",//Row=2104  Unique Row 
"3 6 1 9 7 ",//Row=2105  Unique Row 
"3 7 2 9 8 ",//Row=2106  Unique Row 
"3 9 3 9 8 ",//Row=2107  Unique Row 
"3 3 4 9 9 ",//Row=2108  Unique Row 
"3 2 6 9 1 ",//Row=20  Unique Row 
"3 3 8 8 2 ",//Row=2111  Unique Row 
"3 5 9 9 4 ",//Row=2113  Unique Row 
"3 6 0 9 5 ",//Row=2114  Unique Row 
"3 6 8 9 7 ",//Row=2115  Unique Row 
"3 7 1 9 8 ",//Row=2116  Unique Row 
"3 9 2 9 8 ",//Row=2117  Unique Row 
"3 2 3 9 9 ",//Row=2118  Unique Row 
"3 1 4 9 0 ",//Row=2119  Unique Row 
"3 3 7 7 2 ",//Row=2121  Unique Row 
"3 4 7 9 3 ",//Row=2122  Unique Row 
"3 6 9 9 5 ",//Row=2124  Unique Row 
"3 6 0 9 7 ",//Row=2125  Unique Row 
"3 7 8 9 8 ",//Row=2126  Unique Row 
"3 9 1 9 8 ",//Row=2127  Unique Row 
"3 1 2 9 9 ",//Row=2128  Unique Row 
"3 1 3 9 0 ",//Row=2129  Unique Row 
"3 2 4 9 1 ",//Row=2130  Unique Row 
"3 3 6 6 2 ",//Row=2131  Unique Row 
"3 4 6 9 3 ",//Row=2132  Unique Row 
"3 6 9 9 7 ",//Row=2135  Unique Row 
"3 7 0 9 8 ",//Row=2136  Unique Row 
"3 9 8 9 8 ",//Row=2137  Unique Row 
"3 0 8 1 2 ",//Row=2999  Unique Row 
"4 1 8 0 3 ",//Row=3000  Unique Row 
"4 2 8 9 4 ",//Row=3001  Unique Row 
"4 3 8 8 5 ",//Row=3002  Unique Row 
"4 4 8 7 6 ",//Row=3003  Unique Row 
"4 5 8 6 7 ",//Row=3004  Unique Row 
"4 6 8 5 8 ",//Row=3005  Unique Row 
"4 7 8 4 9 ",//Row=3006  Unique Row 
"4 8 8 3 0 ",//Row=3007  Unique Row 
"4 9 8 2 1 ",//Row=3008  Unique Row 
"4 0 8 1 2 ",//Row=3009  Unique Row 
"4 1 8 0 0 ",//Row=300  Unique Row 
"4 2 8 9 9 ",//Row=3011  Unique Row 
"4 3 8 8 8 ",//Row=3012  Unique Row 
"4 4 8 7 7 ",//Row=3013  Unique Row 
"4 5 8 6 6 ",//Row=3014  Unique Row 
"4 6 8 5 5 ",//Row=3015  Unique Row 
"4 7 8 4 4 ",//Row=3016  Unique Row 
"4 8 8 3 3 ",//Row=3017  Unique Row 
"4 9 8 2 6 ",//Row=3018  Unique Row 
"4 0 8 1 6 ",//Row=3019  Unique Row 
"4 1 8 0 6 ",//Row=3020  Unique Row 
"4 2 8 9 6 ",//Row=3021  Unique Row 
"4 3 8 8 6 ",//Row=3022  Unique Row 
"4 5 9 8 4 ",//Row=3023  Unique Row 
"4 6 9 8 5 ",//Row=3024  Unique Row 
"4 6 8 5 6 ",//Row=3025  Unique Row 
"4 7 8 4 7 ",//Row=3026  Unique Row 
"4 8 8 3 6 ",//Row=3027  Unique Row 
"4 0 9 8 9 ",//Row=3028  Unique Row 
"4 1 9 8 0 ",//Row=3029  Unique Row 
"4 2 9 8 1 ",//Row=3030  Unique Row 
"4 3 9 8 2 ",//Row=3031  Unique Row 
"4 4 9 9 3 ",//Row=3032  Unique Row 
"4 6 9 8 7 ",//Row=3035  Unique Row 
"4 7 9 8 8 ",//Row=3036  Unique Row 
"4 9 9 8 8 ",//Row=3037  Unique Row 
"4 9 9 8 9 ",//Row=3038  Unique Row 
"4 8 9 8 9 ",//Row=3048  Unique Row 
"4 5 9 8 9 ",//Row=3058  Unique Row 
"4 6 9 8 9 ",//Row=3068  Unique Row 
"4 4 9 8 9 ",//Row=3088  Unique Row 
"4 3 9 8 9 ",//Row=3098  Unique Row 
"4 2 9 8 9 ",//Row=3108  Unique Row 
"4 1 9 8 9 ",//Row=3118  Unique Row 
"4 0 7 1 2 ",//Row=3999  Unique Row 
"5 1 7 0 3 ",//Row=4000  Unique Row 
"5 2 7 9 4 ",//Row=4001  Unique Row 
"5 3 7 8 5 ",//Row=4002  Unique Row 
"5 4 7 7 6 ",//Row=4003  Unique Row 
"5 5 7 6 7 ",//Row=4004  Unique Row 
"5 6 7 5 8 ",//Row=4005  Unique Row 
"5 7 7 4 9 ",//Row=4006  Unique Row 
"5 8 7 3 0 ",//Row=4007  Unique Row 
"5 9 7 2 1 ",//Row=4008  Unique Row 
"5 0 7 1 2 ",//Row=4009  Unique Row 
"5 1 7 0 0 ",//Row=400  Unique Row 
"5 2 7 9 9 ",//Row=4011  Unique Row 
"5 3 7 8 8 ",//Row=4012  Unique Row 
"5 4 7 7 7 ",//Row=4013  Unique Row 
"5 5 7 6 6 ",//Row=4014  Unique Row 
"5 6 7 5 5 ",//Row=4015  Unique Row 
"5 7 7 4 4 ",//Row=4016  Unique Row 
"5 8 7 3 3 ",//Row=4017  Unique Row 
"5 9 7 2 6 ",//Row=4018  Unique Row 
"5 0 7 1 6 ",//Row=4019  Unique Row 
"5 1 7 0 6 ",//Row=4020  Unique Row 
"5 2 7 9 6 ",//Row=4021  Unique Row 
"5 3 7 8 6 ",//Row=4022  Unique Row 
"5 5 8 8 4 ",//Row=4023  Unique Row 
"5 6 8 7 5 ",//Row=4024  Unique Row 
"5 6 7 5 6 ",//Row=4025  Unique Row 
"5 7 7 4 7 ",//Row=4026  Unique Row 
"5 8 7 3 6 ",//Row=4027  Unique Row 
"5 9 8 7 9 ",//Row=4028  Unique Row 
"5 1 8 7 0 ",//Row=4029  Unique Row 
"5 2 8 7 1 ",//Row=4030  Unique Row 
"5 3 8 7 2 ",//Row=4031  Unique Row 
"5 4 8 7 3 ",//Row=4032  Unique Row 
"5 6 8 7 7 ",//Row=4035  Unique Row 
"5 7 8 7 8 ",//Row=4036  Unique Row 
"5 9 8 7 8 ",//Row=4037  Unique Row 
"5 8 8 7 9 ",//Row=4038  Unique Row 
"5 5 8 7 9 ",//Row=4048  Unique Row 
"5 6 8 7 9 ",//Row=4058  Unique Row 
"5 4 8 7 9 ",//Row=4078  Unique Row 
"5 1 8 7 9 ",//Row=4108  Unique Row 
"5 0 8 7 9 ",//Row=4128  Unique Row 
"5 0 6 1 2 ",//Row=4999  Unique Row 
"6 1 6 0 3 ",//Row=5000  Unique Row 
"6 2 6 9 4 ",//Row=5001  Unique Row 
"6 3 6 8 5 ",//Row=5002  Unique Row 
"6 4 6 7 6 ",//Row=5003  Unique Row 
"6 5 6 6 7 ",//Row=5004  Unique Row 
"6 6 6 5 8 ",//Row=5005  Unique Row 
"6 7 6 4 9 ",//Row=5006  Unique Row 
"6 8 6 3 0 ",//Row=5007  Unique Row 
"6 9 6 2 1 ",//Row=5008  Unique Row 
"6 0 6 1 2 ",//Row=5009  Unique Row 
"6 1 6 0 0 ",//Row=500  Unique Row 
"6 2 6 9 9 ",//Row=5011  Unique Row 
"6 3 6 8 8 ",//Row=5012  Unique Row 
"6 4 6 7 7 ",//Row=5013  Unique Row 
"6 5 6 6 6 ",//Row=5014  Unique Row 
"6 6 6 5 5 ",//Row=5015  Unique Row 
"6 7 6 4 4 ",//Row=5016  Unique Row 
"6 8 6 3 3 ",//Row=5017  Unique Row 
"6 9 6 2 6 ",//Row=5018  Unique Row 
"6 0 6 1 6 ",//Row=5019  Unique Row 
"6 1 6 0 6 ",//Row=5020  Unique Row 
"6 2 6 9 6 ",//Row=5021  Unique Row 
"6 3 6 8 6 ",//Row=5022  Unique Row 
"6 5 7 6 4 ",//Row=5023  Unique Row 
"6 6 7 7 5 ",//Row=5024  Unique Row 
"6 6 6 5 6 ",//Row=5025  Unique Row 
"6 7 6 4 7 ",//Row=5026  Unique Row 
"6 8 6 3 6 ",//Row=5027  Unique Row 
"6 8 7 6 9 ",//Row=5028  Unique Row 
"6 1 7 6 0 ",//Row=5029  Unique Row 
"6 2 7 6 1 ",//Row=5030  Unique Row 
"6 3 7 6 2 ",//Row=5031  Unique Row 
"6 4 7 6 3 ",//Row=5032  Unique Row 
"6 6 7 6 7 ",//Row=5035  Unique Row 
"6 7 7 6 8 ",//Row=5036  Unique Row 
"6 9 7 6 8 ",//Row=5037  Unique Row 
"6 5 7 6 9 ",//Row=5038  Unique Row 
"6 6 7 6 9 ",//Row=5048  Unique Row 
"6 4 7 6 9 ",//Row=5068  Unique Row 
"6 3 7 6 9 ",//Row=5078  Unique Row 
"6 2 7 6 9 ",//Row=5088  Unique Row 
"6 1 7 6 9 ",//Row=5098  Unique Row 
"6 0 7 6 9 ",//Row=5118  Unique Row 
"6 9 7 6 9 ",//Row=5128  Unique Row 
"6 0 5 1 2 ",//Row=5999  Unique Row 
"7 1 5 0 3 ",//Row=6000  Unique Row 
"7 2 5 9 4 ",//Row=6001  Unique Row 
"7 3 5 8 5 ",//Row=6002  Unique Row 
"7 4 5 7 6 ",//Row=6003  Unique Row 
"7 5 5 6 7 ",//Row=6004  Unique Row 
"7 6 5 5 8 ",//Row=6005  Unique Row 
"7 7 5 4 9 ",//Row=6006  Unique Row 
"7 8 5 3 0 ",//Row=6007  Unique Row 
"7 9 5 2 1 ",//Row=6008  Unique Row 
"7 0 5 1 2 ",//Row=6009  Unique Row 
"7 1 5 0 0 ",//Row=600  Unique Row 
"7 2 5 9 9 ",//Row=6011  Unique Row 
"7 3 5 8 8 ",//Row=6012  Unique Row 
"7 4 5 7 7 ",//Row=6013  Unique Row 
"7 5 5 6 6 ",//Row=6014  Unique Row 
"7 6 5 5 5 ",//Row=6015  Unique Row 
"7 7 5 4 4 ",//Row=6016  Unique Row 
"7 8 5 3 3 ",//Row=6017  Unique Row 
"7 9 5 2 6 ",//Row=6018  Unique Row 
"7 0 5 1 6 ",//Row=6019  Unique Row 
"7 1 5 0 6 ",//Row=6020  Unique Row 
"7 2 5 9 6 ",//Row=6021  Unique Row 
"7 3 5 8 6 ",//Row=6022  Unique Row 
"7 5 6 5 4 ",//Row=6023  Unique Row 
"7 6 6 5 5 ",//Row=6024  Unique Row 
"7 6 5 5 6 ",//Row=6025  Unique Row 
"7 7 5 4 7 ",//Row=6026  Unique Row 
"7 8 5 3 6 ",//Row=6027  Unique Row 
"7 5 6 5 9 ",//Row=6028  Unique Row 
"7 1 6 5 0 ",//Row=6029  Unique Row 
"7 2 6 5 1 ",//Row=6030  Unique Row 
"7 3 6 5 2 ",//Row=6031  Unique Row 
"7 4 6 5 3 ",//Row=6032  Unique Row 
"7 6 6 6 7 ",//Row=6035  Unique Row 
"7 7 6 5 8 ",//Row=6036  Unique Row 
"7 9 6 5 8 ",//Row=6037  Unique Row 
"7 6 6 5 9 ",//Row=6038  Unique Row 
"7 4 6 5 9 ",//Row=6058  Unique Row 
"7 3 6 5 9 ",//Row=6068  Unique Row 
"7 2 6 5 9 ",//Row=6078  Unique Row 
"7 1 6 5 9 ",//Row=6088  Unique Row 
"7 0 6 5 9 ",//Row=6108  Unique Row 
"7 9 6 5 9 ",//Row=6118  Unique Row 
"7 8 6 5 9 ",//Row=6128  Unique Row 
"7 0 4 1 2 ",//Row=6999  Unique Row 
"8 1 4 0 3 ",//Row=7000  Unique Row 
"8 2 4 9 4 ",//Row=7001  Unique Row 
"8 3 4 8 5 ",//Row=7002  Unique Row 
"8 4 4 7 6 ",//Row=7003  Unique Row 
"8 5 4 6 7 ",//Row=7004  Unique Row 
"8 6 4 5 8 ",//Row=7005  Unique Row 
"8 7 4 4 9 ",//Row=7006  Unique Row 
"8 8 4 3 0 ",//Row=7007  Unique Row 
"8 9 4 2 1 ",//Row=7008  Unique Row 
"8 0 4 1 2 ",//Row=7009  Unique Row 
"8 1 4 0 0 ",//Row=700  Unique Row 
"8 2 4 9 9 ",//Row=7011  Unique Row 
"8 3 4 8 8 ",//Row=7012  Unique Row 
"8 4 4 7 7 ",//Row=7013  Unique Row 
"8 5 4 6 6 ",//Row=7014  Unique Row 
"8 6 4 5 5 ",//Row=7015  Unique Row 
"8 7 4 4 4 ",//Row=7016  Unique Row 
"8 8 4 3 3 ",//Row=7017  Unique Row 
"8 9 4 2 6 ",//Row=7018  Unique Row 
"8 0 4 1 6 ",//Row=7019  Unique Row 
"8 1 4 0 6 ",//Row=7020  Unique Row 
"8 2 4 9 6 ",//Row=7021  Unique Row 
"8 3 4 8 6 ",//Row=7022  Unique Row 
"8 5 5 4 4 ",//Row=7023  Unique Row 
"8 6 5 4 5 ",//Row=7024  Unique Row 
"8 6 4 5 6 ",//Row=7025  Unique Row 
"8 7 4 4 7 ",//Row=7026  Unique Row 
"8 8 4 3 6 ",//Row=7027  Unique Row 
"8 6 5 4 9 ",//Row=7028  Unique Row 
"8 1 5 4 0 ",//Row=7029  Unique Row 
"8 2 5 4 1 ",//Row=7030  Unique Row 
"8 3 5 4 2 ",//Row=7031  Unique Row 
"8 4 5 4 3 ",//Row=7032  Unique Row 
"8 6 5 4 7 ",//Row=7035  Unique Row 
"8 7 5 5 8 ",//Row=7036  Unique Row 
"8 9 5 4 8 ",//Row=7037  Unique Row 
"8 5 5 4 9 ",//Row=7038  Unique Row 
"8 4 5 4 9 ",//Row=7048  Unique Row 
"8 3 5 4 9 ",//Row=7058  Unique Row 
"8 2 5 4 9 ",//Row=7068  Unique Row 
"8 1 5 4 9 ",//Row=7078  Unique Row 
"8 0 5 4 9 ",//Row=7098  Unique Row 
"8 9 5 4 9 ",//Row=7108  Unique Row 
"8 0 3 1 2 ",//Row=7999  Unique Row 
"9 1 3 0 3 ",//Row=8000  Unique Row 
"9 2 3 9 4 ",//Row=8001  Unique Row 
"9 3 3 8 5 ",//Row=8002  Unique Row 
"9 4 3 7 6 ",//Row=8003  Unique Row 
"9 5 3 6 7 ",//Row=8004  Unique Row 
"9 6 3 5 8 ",//Row=8005  Unique Row 
"9 7 3 4 9 ",//Row=8006  Unique Row 
"9 8 3 3 0 ",//Row=8007  Unique Row 
"9 9 3 2 1 ",//Row=8008  Unique Row 
"9 0 3 1 2 ",//Row=8009  Unique Row 
"9 1 3 0 0 ",//Row=800  Unique Row 
"9 2 3 9 9 ",//Row=8011  Unique Row 
"9 3 3 8 8 ",//Row=8012  Unique Row 
"9 4 3 7 7 ",//Row=8013  Unique Row 
"9 5 3 6 6 ",//Row=8014  Unique Row 
"9 6 3 5 5 ",//Row=8015  Unique Row 
"9 7 3 4 4 ",//Row=8016  Unique Row 
"9 8 3 3 3 ",//Row=8017  Unique Row 
"9 9 3 2 6 ",//Row=8018  Unique Row 
"9 0 3 1 6 ",//Row=8019  Unique Row 
"9 1 3 0 6 ",//Row=8020  Unique Row 
"9 2 3 9 6 ",//Row=8021  Unique Row 
"9 3 3 8 6 ",//Row=8022  Unique Row 
"9 5 4 3 4 ",//Row=8023  Unique Row 
"9 6 4 3 5 ",//Row=8024  Unique Row 
"9 6 3 5 6 ",//Row=8025  Unique Row 
"9 7 3 4 7 ",//Row=8026  Unique Row 
"9 8 3 3 6 ",//Row=8027  Unique Row 
"9 5 4 3 9 ",//Row=8028  Unique Row 
"9 1 4 3 0 ",//Row=8029  Unique Row 
"9 2 4 3 1 ",//Row=8030  Unique Row 
"9 3 4 3 2 ",//Row=8031  Unique Row 
"9 4 4 3 3 ",//Row=8032  Unique Row 
"9 6 4 3 7 ",//Row=8035  Unique Row 
"9 7 4 3 8 ",//Row=8036  Unique Row 
"9 9 4 4 8 ",//Row=8037  Unique Row 
"9 4 4 3 9 ",//Row=8038  Unique Row 
"9 3 4 3 9 ",//Row=8048  Unique Row 
"9 2 4 3 9 ",//Row=8058  Unique Row 
"9 1 4 3 9 ",//Row=8068  Unique Row 
"9 0 4 3 9 ",//Row=8088  Unique Row 
"9 9 4 3 9 ",//Row=8098  Unique Row 
"9 8 4 3 9 ",//Row=8108  Unique Row 
"9 6 4 3 9 ",//Row=8128  Unique Row 
"9 0 2 1 2 ",//Row=8999  Unique Row 
"0 1 2 0 3 ",//Row=9000  Unique Row 
"0 2 2 9 4 ",//Row=9001  Unique Row 
"0 3 2 8 5 ",//Row=9002  Unique Row 
"0 4 2 7 6 ",//Row=9003  Unique Row 
"0 5 2 6 7 ",//Row=9004  Unique Row 
"0 6 2 5 8 ",//Row=9005  Unique Row 
"0 7 2 4 9 ",//Row=9006  Unique Row 
"0 8 2 3 0 ",//Row=9007  Unique Row 
"0 9 2 2 1 ",//Row=9008  Unique Row 
"0 0 2 1 2 ",//Row=9009  Unique Row 
"0 1 2 0 0 ",//Row=900  Unique Row 
"0 2 2 9 9 ",//Row=9011  Unique Row 
"0 3 2 8 8 ",//Row=9012  Unique Row 
"0 4 2 7 7 ",//Row=9013  Unique Row 
"0 5 2 6 6 ",//Row=9014  Unique Row 
"0 6 2 5 5 ",//Row=9015  Unique Row 
"0 7 2 4 4 ",//Row=9016  Unique Row 
"0 8 2 3 3 ",//Row=9017  Unique Row 
"0 9 2 2 6 ",//Row=9018  Unique Row 
"0 0 2 1 6 ",//Row=9019  Unique Row 
"0 1 2 0 6 ",//Row=9020  Unique Row 
"0 2 2 9 6 ",//Row=9021  Unique Row 
"0 3 2 8 6 ",//Row=9022  Unique Row 
"0 5 3 2 4 ",//Row=9023  Unique Row 
"0 6 3 2 5 ",//Row=9024  Unique Row 
"0 6 2 5 6 ",//Row=9025  Unique Row 
"0 7 2 4 7 ",//Row=9026  Unique Row 
"0 8 2 3 6 ",//Row=9027  Unique Row 
"0 4 3 3 9 ",//Row=9028  Unique Row 
"0 1 3 2 0 ",//Row=9029  Unique Row 
"0 2 3 2 1 ",//Row=9030  Unique Row 
"0 3 3 2 2 ",//Row=9031  Unique Row 
"0 4 3 2 3 ",//Row=9032  Unique Row 
"0 6 3 2 7 ",//Row=9035  Unique Row 
"0 7 3 2 8 ",//Row=9036  Unique Row 
"0 9 3 2 8 ",//Row=9037  Unique Row 
"0 3 3 3 9 ",//Row=9038  Unique Row 
"0 2 3 3 9 ",//Row=9048  Unique Row 
"0 1 3 3 9 ",//Row=9058  Unique Row 
"0 0 3 3 9 ",//Row=9078  Unique Row 
"0 9 3 3 9 ",//Row=9088  Unique Row 
"0 8 3 3 9 ",//Row=9098  Unique Row 
"0 5 3 3 9 ",//Row=9108  Unique Row 
"0 6 3 3 9 ",//Row=9118  Unique Row 
"0 0 1 1 2 ",//Row=9999  Unique Row 
};
    
    static String[] OrthogonalArrayKeyTypeOATS = {"1 1",//Row=0
                "1 2",//Row=1
                "1 3",//Row=2
                "2 1",//Row=3
                "2 2",//Row=4
                "2 3",//Row=5
                "3 1",//Row=6
                "3 2",//Row=7
                "3 3"//Row=8
            };
    
    public enum KeytypeEnum {
        Symmetric(2), Public(1), Private(0);
        public int Keytype = -1;

        KeytypeEnum(int Keytype1) {
            Keytype = Keytype1;
        }
    }

    public static void DefaultConfig() {
        CyclicFlag = false;//If true calls the Poormans Security a second time
        NumberOfTimes = 1;
        NumberOfTimesOrg = 1;
        USEUDP = "USETCP";//USEUDP or USETCP
        UDPBuffLen = 8192;//5;//1024;//8192;
        MessageInvariant = "MessageVariant";//MessageInvariant OR MessageVariant
        FOBRandomChar = "FOBStandardChar";//Valid Values are : FOBRandomChar :FOBStandardChar
        SecurityPosture = "ChangeKeysAfterEveryUse";//ChangeKeysAfterEveryUse or Normal
        NumberOfFractions = 4; // Minimum =2; Maximum=10;
        PRAGMA = "Normal";//Paranoid , Normal, Strict:// Calls Malicious Mallory
        PRAGMADetail = "Normal";//Paranoid , Normal, Strict:// Calls Malicious Mallory
    }

    public static void DisplaySecurityConfigTCP() {
        System.out.println("************************Critical Security Config Parameters Begins ***********");
        System.out.println("Parameters:CyclicFlag:=" + CyclicFlag);
        System.out.println("Parameters:NumberOfTimes:=" + NumberOfTimes);
        System.out.println("Parameters:NumberOfTimesOrg:=" + NumberOfTimesOrg);
        System.out.println("Parameters:USEUDP:=" + USEUDP);
        System.out.println("Parameters:UDPBuffLen:=" + UDPBuffLen);
        System.out.println("Parameters:MessageInvariant:=" + MessageInvariant);
        System.out.println("Parameters:FOBRandomChar:=" + FOBRandomChar);
        System.out.println("Parameters:RANDProdPerform:=" + RANDProdPerform);
        System.out.println("Parameters:SecurityPosture:=" + SecurityPosture);
        System.out.println("Parameters:NumberOfFractions:=" + NumberOfFractions);
        System.out.println("Parameters:PRAGMA:=" + PRAGMA);
        System.out.println("Parameters:PRAGMADetail:=" + PRAGMADetail);
        System.out.println("**************************Critical Security Config Parameters Ends ***********");
    }

    public static void DisplayConfigEncryption() {
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
    }

    public static void DisplayConfigDecryption() {
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
    }

    public static void DisplayUserTweaks() {
        System.out.println("************************Critical UserTweaks Parameters Begins ***********");
        System.out.println("Parameters:Xn_LCG:=" + Xn_LCG);
        System.out.println("Parameters:Xn_LCGDyDx:=" + Xn_LCGDyDx);
        System.out.println("Parameters:Modulus:=" + Modulus);
        System.out.println("Parameters:MaxExponent:=" + MaxExponent);
        System.out.println("Parameters:ModulusEncrypt:=" + ModulusEncrypt);
        System.out.println("Parameters:a:=" + a);
        System.out.println("Parameters:c:=" + c);
        System.out.println("Parameters:b:=" + b);
        System.out.println("Parameters:d:=" + d);
        System.out.println("**************************Critical UserTweaks Parameters Ends ***********");
    }

    public static String SingleConfig(String AlgoName, String StationaryEquation, String DiffWithRespTo, int Iteration, String[] OptionsArray) {
        ConfigLambda LCGConfigLambda = (() -> "");
        LCGConfigLambda = parseOptions(AlgoName,StationaryEquation, DiffWithRespTo, Iteration, OptionsArray);
        return LCGConfigLambda.SelectedOptions();
    }

    @FunctionalInterface
    public interface ConfigLambda {

        String SelectedOptions();
    }

    public static ConfigLambda parseOptions(String AlgoName,String StationaryEquation, String DiffWithRespTo, int Iteration, String[] OptionsArray) {

        return new Object() {
            ConfigLambda parseConfigOptions() {
                ConfigLambda x = (() -> "");
                if (AlgoName.equalsIgnoreCase("Encrypt")){
                variablesEncrypt.put(DiffWithRespTo, (1.0 * Iteration));
                variablesEncrypt.put("MaximumOptions", (1.0 * OptionsArray.length));
                }else if (AlgoName.equalsIgnoreCase("Decrypt")){
                    variablesDecrypt.put(DiffWithRespTo, (1.0 * Iteration));
                variablesDecrypt.put("MaximumOptions", (1.0 * OptionsArray.length));
                }
                MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
                boolean SilentFlag = true;
                if (AlgoName.equalsIgnoreCase("Encrypt")){
                LCGexpValue = parse(StationaryEquation, variablesEncrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                }else if (AlgoName.equalsIgnoreCase("Decrypt")){
                LCGexpValue = parse(StationaryEquation, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                }
                int RetValue = LCGexpValue.eval().intValue();
                if ((RetValue >= 0) && (RetValue < OptionsArray.length)) {
                    x = (() -> OptionsArray[RetValue]);
                }
                return x;
            }
        }.parseConfigOptions();
    }

    public static void main(String... args) {
        String StationaryEquation = "Iteration % MaximumOptions";
        String DiffWithRespTo = "Iteration";

        StrGUI = "Poorman'smain:RegressionTesting";
        // TODO code application logic here
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
        }
        UserTweaks_Entropy();// Called Here because all UserTweaks variables are not configured.
        // UserTweaks variables are overwritten in DOEmainUserTweaks
        DOEmainHighLevelSecurity("Encrypt");
        DOEmainUserTweaks();
        KeymainUserTweaks();
        KeymainTest();
    }

    public static void DOEmainHighLevelSecurity(String AlgoName) {
        String StationaryEquation = "Iteration % MaximumOptions";
        String DiffWithRespTo = "Iteration";
        String StrTimeTaken1 = "";
        System.out.println("DOEmainHighLevel:TestSuite:TimeTaken:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken1 = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken1 = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("DOEmainHighLevelSecurity:TestSuite Started:Run Time:" + current + " ");
        }
        // TODO code application logic here
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
        }
        String[] OrthogonalArrayRowOATS = {"1 1 1 3 1",//Row=0
            "1 2 1 2 2",//Row=1
            "1 1 1 1 2",//Row=2
            "1 2 2 3 1",//Row=3
            "2 1 2 2 3",//Row=4
            "2 2 2 1 3",//Row=5
            "2 1 2 3 1",//Row=6
            "2 2 1 2 3",//Row=7
            "1 1 1 1 1"};//Row=8

        for (int i = 0, j = 0; i < OrthogonalArrayRowOATS.length; i++) {
            String StrTimeTaken = "";
            System.out.println("DataArray:Header(Name):SecurityPosture MessageInvariant FOBRandomChar PRAGMA PRAGMADetail");
            System.out.println("DataArray:Header(Name):_Factor_0_ _Factor_1_ _Factor_2_ _Factor_3_ _Factor_4_");

            System.out.println("DOEmainHighLevel:" + i + ":OrthogonalArrayRowOATS=" + OrthogonalArrayRowOATS[i]);
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                if (TimeTaken.length == 3) {
                    StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("/************************** ConfigurationCycle Begins :" + i + ":*************** */");
                System.out.println("ConfigurationCycle Started:" + i + ":Run Time:" + current + " ");
            }
            String[] OptionsArray = {"ChangeKeysAfterEveryUse", "Normal"};
            SecurityPosture = SingleConfigDOE(AlgoName, 0, StationaryEquation, DiffWithRespTo, OptionsArray, OrthogonalArrayRowOATS[i]);
            String[] OptionsArray1 = {"MessageVariant", "MessageInvariant"};
            MessageInvariant = SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArray1, OrthogonalArrayRowOATS[i]);
            String[] OptionsArray2 = {"FOBStandardChar", "FOBRandomChar"};
            FOBRandomChar = SingleConfigDOE(AlgoName,2, StationaryEquation, DiffWithRespTo, OptionsArray2, OrthogonalArrayRowOATS[i]);
            String[] OptionsArray3 = {"Paranoid", "Normal", "Strict"};
            PRAGMA = SingleConfigDOE(AlgoName,3, StationaryEquation, DiffWithRespTo, OptionsArray3, OrthogonalArrayRowOATS[i]);
            String[] OptionsArray4 = {"Paranoid", "Normal", "Strict"};
            PRAGMADetail = SingleConfigDOE(AlgoName,4, StationaryEquation, DiffWithRespTo, OptionsArray4, OrthogonalArrayRowOATS[i]);
            DisplaySecurityConfigTCP();
            DisplayUserTweaks();
            HighLevelConfigTestCase();
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                String localStrCurrentTimeTaken = "";
                if (TimeTaken.length == 3) {
                    localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("ConfigurationCycle Completed:" + i + ":Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
                System.out.println("/************************** ConfigurationCycle Ends :" + i + ":*************** */");
                StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
            }
            DisplaySecurityConfigTCP();
            DisplayUserTweaks();
        }
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("DOEmainHighLevelSecurity:TestSuite Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1))) + " seconds.");
            System.out.println("/************************** ConfigurationCycle Ends *************** */");
            
            StrTimeTaken1 = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1)));
        }
    }

    public static String SingleConfigDOE(String AlgoName,int FactorNumber, String StationaryEquation, String DiffWithRespTo, String[] OptionsArray, String Row) {
        ConfigLambda LCGConfigLambda = (() -> "");
        String[] DataTemp = Row.split(" ");
        
        int Iteration = -1;
        if(Integer.parseInt(DataTemp[FactorNumber]) >1)
            Iteration = Integer.parseInt(DataTemp[FactorNumber]) - 1;
        else if(Integer.parseInt(DataTemp[FactorNumber]) ==1)
            Iteration = Integer.parseInt(DataTemp[FactorNumber]) - 1;
        else if(Integer.parseInt(DataTemp[FactorNumber]) ==0)
            Iteration = Integer.parseInt(DataTemp[FactorNumber]);
        LCGConfigLambda = parseOptions(AlgoName,StationaryEquation, DiffWithRespTo, Iteration, OptionsArray);
        return LCGConfigLambda.SelectedOptions();
    }
    public static void DOEmainUserTweaks(String... args) {
        String StationaryEquation = "Iteration % MaximumOptions";
        String DiffWithRespTo = "Iteration";
        String StrTimeTaken1 = "";
        String AlgoName="Encrypt";
        System.out.println("DOEmainUserTweaks:TestSuite:TimeTaken:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken1 = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken1 = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("DOEmainUserTweaks:TestSuite Started:Run Time:" + current + " ");
        }
        // TODO code application logic here
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
        }
        String[] OrthogonalArrayRowOATS = {"1 1 1 4 1 1 1 1 1",//Row=0
            "1 2 1 3 2 2 2 2 2",//Row=1
            "1 3 1 2 3 3 3 3 3",//Row=2
            "1 4 1 1 4 4 4 4 4",//Row=3
            "1 1 1 4 1 2 3 4 1",//Row=4
            "1 2 1 3 2 1 2 3 1",//Row=5
            "1 3 4 2 3 1 4 1 2",//Row=6
            "2 4 4 1 4 1 4 2 3",//Row=7
            "2 1 4 4 1 4 1 4 1",//Row=8
            "2 2 4 3 1 2 1 2 1",//Row=9
            "2 3 4 2 1 2 3 4 1",//Row=10
            "2 4 4 1 3 1 2 3 2",//Row=11
            "2 1 4 4 3 1 2 1 2",//Row=12
            "2 2 3 3 1 2 1 2 1",//Row=13
            "3 3 3 2 1 2 3 4 1",//Row=14
            "3 4 3 1 2 1 2 3 1",//Row=15
            "3 1 3 4 2 1 4 1 2",//Row=16
            "3 2 3 3 4 1 4 2 3",//Row=17
            "3 3 3 2 4 1 4 1 4",//Row=18
            "3 4 3 1 2 1 2 1 2",//Row=19
            "3 1 2 4 1 2 3 4 1",//Row=20
            "4 2 2 3 4 1 2 3 2",//Row=21
            "4 3 2 2 3 1 2 1 2",//Row=22
            "4 4 2 1 2 1 2 1 2",//Row=23
            "4 1 2 4 1 2 3 4 1",//Row=24
            "4 2 2 3 2 1 2 3 1",//Row=25
            "4 3 2 2 3 1 4 1 2",//Row=26
            "4 4 1 1 4 1 4 2 3",//Row=27
            "1 1 1 4 1 4 1 4 1",//Row=28
            "1 2 1 3 1 2 1 2 1"//Row=29
        };
        for (int i = 0, j = 0; i < OrthogonalArrayRowOATS.length; i++) {
            String StrTimeTaken = "";
            System.out.println("DataArray:Header(Name):_Factor_0_ _Factor_1_ _Factor_2_ _Factor_3_ _Factor_4_ _Factor_5_ _Factor_6_ _Factor_7_ _Factor_8_ _Factor_9_");
            System.out.println("DataArray:Header(Name):Xn_LCG Xn_LCGDyDx Modulus MaxExponent ModulusEncrypt a c b d ");
            System.out.println("DOEmainUserTweaks:OrthogonalArrayRowOATS=" + OrthogonalArrayRowOATS[i]);
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                if (TimeTaken.length == 3) {
                    StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("/************************** ConfigurationCycle Begins :" + i + ":*************** */");
                System.out.println("ConfigurationCycle Started:" + i + ":Run Time:" + current + " ");
            }
            String[] OptionsArray = {"3", "5", "7", "11"};
            Xn_LCG = Long.parseLong(SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArray, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray1 = {"3", "5", "7", "11"};
            Xn_LCGDyDx = Long.parseLong(SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArray1, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray2 = {"300", "500", "5000", "1000"};
            Modulus = Long.parseLong(SingleConfigDOE(AlgoName,2, StationaryEquation, DiffWithRespTo, OptionsArray2, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray3 = {"3", "23", "29", "31"};
            MaxExponent = Long.parseLong(SingleConfigDOE(AlgoName,3, StationaryEquation, DiffWithRespTo, OptionsArray3, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray4 = {"3", "7", "11", "13"};
            ModulusEncrypt = Long.parseLong(SingleConfigDOE(AlgoName,4, StationaryEquation, DiffWithRespTo, OptionsArray4, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray5 = {"3", "23", "29", "31"};
            a = Long.parseLong(SingleConfigDOE(AlgoName,5, StationaryEquation, DiffWithRespTo, OptionsArray5, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray6 = {"7", "17", "29", "31"};
            c = Long.parseLong(SingleConfigDOE(AlgoName,6, StationaryEquation, DiffWithRespTo, OptionsArray6, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray7 = {"3", "5", "29", "31"};
            b = Long.parseLong(SingleConfigDOE(AlgoName,7, StationaryEquation, DiffWithRespTo, OptionsArray7, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray8 = {"3", "9", "29", "31"};
            d = Long.parseLong(SingleConfigDOE(AlgoName,8, StationaryEquation, DiffWithRespTo, OptionsArray8, OrthogonalArrayRowOATS[i]));
            DisplaySecurityConfigTCP();
            DisplayUserTweaks();
            HighLevelConfigTestCase();
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                String localStrCurrentTimeTaken = "";
                if (TimeTaken.length == 3) {
                    localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("ConfigurationCycle Completed:" + i + ":Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
                System.out.println("/************************** ConfigurationCycle Ends :" + i + ":*************** */");
                StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
            }
            DisplaySecurityConfigTCP();
            DisplayUserTweaks();
        }
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("DOEmainUserTweaks:TestSuite Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1))) + " seconds.");
            StrTimeTaken1 = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1)));
        }
    }
    public static void KeymainUserTweaks(String... args) {
        String StationaryEquation = "Iteration % MaximumOptions";
        String DiffWithRespTo = "Iteration";
        String StrTimeTaken1 = "";
        String AlgoName="Encrypt";
        System.out.println("DOEmainUserTweaks:TestSuite:TimeTaken:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken1 = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken1 = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("DOEmainUserTweaks:TestSuite Started:Run Time:" + current + " ");
        }
        // TODO code application logic here
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
        }
        String[] OrthogonalArrayRowOATS = {"1 1 1 4 1 1 1 1 1",//Row=0
            "1 2 1 3 2 2 2 2 2",//Row=1
            "1 3 1 2 3 3 3 3 3",//Row=2
            "1 4 1 1 4 4 4 4 4",//Row=3
            "1 1 1 4 1 2 3 4 1",//Row=4
            "1 2 1 3 2 1 2 3 1",//Row=5
            "1 3 4 2 3 1 4 1 2",//Row=6
            "2 4 4 1 4 1 4 2 3",//Row=7
            "2 1 4 4 1 4 1 4 1",//Row=8
            "2 2 4 3 1 2 1 2 1",//Row=9
            "2 3 4 2 1 2 3 4 1",//Row=10
            "2 4 4 1 3 1 2 3 2",//Row=11
            "2 1 4 4 3 1 2 1 2",//Row=12
            "2 2 3 3 1 2 1 2 1",//Row=13
            "3 3 3 2 1 2 3 4 1",//Row=14
            "3 4 3 1 2 1 2 3 1",//Row=15
            "3 1 3 4 2 1 4 1 2",//Row=16
            "3 2 3 3 4 1 4 2 3",//Row=17
            "3 3 3 2 4 1 4 1 4",//Row=18
            "3 4 3 1 2 1 2 1 2",//Row=19
            "3 1 2 4 1 2 3 4 1",//Row=20
            "4 2 2 3 4 1 2 3 2",//Row=21
            "4 3 2 2 3 1 2 1 2",//Row=22
            "4 4 2 1 2 1 2 1 2",//Row=23
            "4 1 2 4 1 2 3 4 1",//Row=24
            "4 2 2 3 2 1 2 3 1",//Row=25
            "4 3 2 2 3 1 4 1 2",//Row=26
            "4 4 1 1 4 1 4 2 3",//Row=27
            "1 1 1 4 1 4 1 4 1",//Row=28
            "1 2 1 3 1 2 1 2 1"//Row=29
        };
        TestCase = 10000;
        AlicePairKeys = new String[OrthogonalArrayRowOATS.length][3];
        BobPairKeys = new String[OrthogonalArrayRowOATS.length][3];
        EvePairKeys = new String[OrthogonalArrayRowOATS.length][3];
        
        AlicePairKeysQuality = new String[OrthogonalArrayRowOATS.length][3];
        BobPairKeysQuality = new String[OrthogonalArrayRowOATS.length][3];
        EvePairKeysQuality = new String[OrthogonalArrayRowOATS.length][3];
        
        AlicePairKeysQualityLowLvl = new String[OrthogonalArrayRowOATS.length][3];
        BobPairKeysQualityLowLvl = new String[OrthogonalArrayRowOATS.length][3];
        EvePairKeysQualityLowLvl = new String[OrthogonalArrayRowOATS.length][3];
        
        
        
        boolean statusflag = false;
        int i = 0;
        for (; i < OrthogonalArrayRowOATS.length; i++) {
            TestCaseInternalVar = i;
            String StrTimeTaken = "";
            System.out.println("DataArray:Header(Name):_Factor_0_ _Factor_1_ _Factor_2_ _Factor_3_ _Factor_4_ _Factor_5_ _Factor_6_ _Factor_7_ _Factor_8_ _Factor_9_");
            System.out.println("DataArray:Header(Name):Xn_LCG Xn_LCGDyDx Modulus MaxExponent ModulusEncrypt a c b d ");
            System.out.println("DOEmainUserTweaks:OrthogonalArrayRowOATS=" + OrthogonalArrayRowOATS[i]);
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                if (TimeTaken.length == 3) {
                    StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("/************************** ConfigurationCycle Begins :" + i + ":*************** */");
                System.out.println("ConfigurationCycle Started:" + i + ":Run Time:" + current + " ");
            }
            String[] OptionsArray = {"3", "5", "7", "11"};
            Xn_LCG = Long.parseLong(SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArray, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray1 = {"3", "5", "7", "11"};
            Xn_LCGDyDx = Long.parseLong(SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArray1, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray2 = {"300", "500", "5000", "1000"};
            Modulus = Long.parseLong(SingleConfigDOE(AlgoName,2, StationaryEquation, DiffWithRespTo, OptionsArray2, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray3 = {"3", "23", "29", "31"};
            MaxExponent = Long.parseLong(SingleConfigDOE(AlgoName,3, StationaryEquation, DiffWithRespTo, OptionsArray3, OrthogonalArrayRowOATS[i]));
            String[] OptionsArray4 = {"3", "7", "11", "13"};
            ModulusEncrypt = Long.parseLong(SingleConfigDOE(AlgoName,4, StationaryEquation, DiffWithRespTo, OptionsArray4, OrthogonalArrayRowOATS[i]));
//            String[] OptionsArray5 = {"3", "7", "11", "13"};
//            a = Long.parseLong(SingleConfigDOE(5, StationaryEquation, DiffWithRespTo, OptionsArray5, OrthogonalArrayRowOATS[i]));
//            String[] OptionsArray6 = {"3", "7", "11", "13"};
//            c = Long.parseLong(SingleConfigDOE(6, StationaryEquation, DiffWithRespTo, OptionsArray6, OrthogonalArrayRowOATS[i]));
//            String[] OptionsArray7 = {"3", "7", "11", "13"};
//            b = Long.parseLong(SingleConfigDOE(7, StationaryEquation, DiffWithRespTo, OptionsArray7, OrthogonalArrayRowOATS[i]));
//            String[] OptionsArray8 = {"3", "7", "11", "13"};
//            d = Long.parseLong(SingleConfigDOE(8, StationaryEquation, DiffWithRespTo, OptionsArray8, OrthogonalArrayRowOATS[i]));
//            //DisplaySecurityConfigTCP();
            DisplayUserTweaks();
            //RandomEngineResetFactFlag=false;
            //RandomEngineResetValueFlag=false;
            statusflag = KeyTest(AlgoName,StationaryEquation, DiffWithRespTo, i);
            if (statusflag == true) {
                break;
            }
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                String localStrCurrentTimeTaken = "";
                if (TimeTaken.length == 3) {
                    localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("ConfigurationCycle Completed:" + i + ":Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
                System.out.println("/************************** ConfigurationCycle Ends :" + i + ":*************** */");
                StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
            }
        }
        if (statusflag == false) {
            System.out.println(ConsoleColors.GREEN + "KeymainUserTweaks: All Unique Keys Generated" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "KeymainUserTweaks: Some Duplicates Keys Generated:i=" + i + " Dup " + ConsoleColors.RESET);
        }
        DisplayKeysPairs(OrthogonalArrayRowOATS.length);
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("DOEmainUserTweaks:TestSuite Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1))) + " seconds.");
            StrTimeTaken1 = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1)));
        }
    }
    public static void DisplayKeysPairs(int Length){
        int BadKeyDuplicateCount=0;
        int BadKeyCount=0;
        int i = 0;
        for (; i < Length; i++) {
            System.out.println("DisplayKeysPairs:Alice:i=" + i + ":Private=" +AlicePairKeys[i][0] + " Quality=" + AlicePairKeysQualityLowLvl[i][0] + " Quality=" + AlicePairKeysQuality[i][0]);
            System.out.println("DisplayKeysPairs:Alice:i=" + i + ":Public=" +AlicePairKeys[i][1] + " Quality=" + AlicePairKeysQualityLowLvl[i][1] + " Quality=" + AlicePairKeysQuality[i][1]);
            System.out.println("DisplayKeysPairs:Alice:i=" + i + ":Symmetric=" +AlicePairKeys[i][2] + " Quality=" + AlicePairKeysQualityLowLvl[i][2] + " Quality=" + AlicePairKeysQuality[i][2]);
            if( (AlicePairKeysQualityLowLvl[i][0]==null)
                    ||(AlicePairKeysQualityLowLvl[i][1]==null)
                    ||(AlicePairKeysQualityLowLvl[i][2]==null)){
                BadKeyCount++;
            }
            if( (AlicePairKeysQuality[i][0] != null)
                    ||(AlicePairKeysQuality[i][1]!=null)
                    ||(AlicePairKeysQuality[i][2]!=null)){
                BadKeyDuplicateCount++;
            }
            System.out.print(System.lineSeparator());
            System.out.println("DisplayKeysPairs:Bob:i=" + i + ":Private=" +BobPairKeys[i][0] + " Quality=" + BobPairKeysQualityLowLvl[i][0] + " Quality=" + BobPairKeysQuality[i][0]);
            System.out.println("DisplayKeysPairs:Bob:i=" + i + ":Public=" +BobPairKeys[i][1] + " Quality=" + BobPairKeysQualityLowLvl[i][1] + " Quality=" + BobPairKeysQuality[i][1]);
            System.out.println("DisplayKeysPairs:Bob:i=" + i + ":Symmetric=" +BobPairKeys[i][2] + " Quality=" + BobPairKeysQualityLowLvl[i][2] + " Quality=" + BobPairKeysQuality[i][2]);
            if( (BobPairKeysQualityLowLvl[i][0]==null)
                    ||(BobPairKeysQualityLowLvl[i][1]==null)
                    ||(BobPairKeysQualityLowLvl[i][2]==null)){
                BadKeyCount++;
            }
            if( (BobPairKeysQuality[i][0] != null)
                    ||(BobPairKeysQuality[i][1]!=null)
                    ||(BobPairKeysQuality[i][2]!=null)){
                BadKeyDuplicateCount++;
            }
            System.out.print(System.lineSeparator());
            System.out.println("DisplayKeysPairs:Eve:i=" + i + ":Private=" +EvePairKeys[i][0] + " Quality=" + EvePairKeysQualityLowLvl[i][0] + " Quality=" + EvePairKeysQuality[i][0]);
            System.out.println("DisplayKeysPairs:Eve:i=" + i + ":Public=" +EvePairKeys[i][1] + " Quality=" + EvePairKeysQualityLowLvl[i][1] + " Quality=" + EvePairKeysQuality[i][1]);
            System.out.println("DisplayKeysPairs:Eve:i=" + i + ":Symmetric=" +EvePairKeys[i][2] + " Quality=" + EvePairKeysQualityLowLvl[i][2] + " Quality=" + EvePairKeysQuality[i][2]);
            if( (EvePairKeysQualityLowLvl[i][0]==null)
                    ||(EvePairKeysQualityLowLvl[i][1]==null)
                    ||(EvePairKeysQualityLowLvl[i][2]==null)){
                BadKeyCount++;
            }
            if( (EvePairKeysQuality[i][0] != null)
                    ||(EvePairKeysQuality[i][1]!=null)
                    ||(EvePairKeysQuality[i][2]!=null)){
                BadKeyDuplicateCount++;
            }
            System.out.print(System.lineSeparator());
        }
         System.out.println("DisplayKeysPairs:BadKeyCount=" + BadKeyCount + " BadKeyDuplicateCount=" + BadKeyDuplicateCount);
    }
    public static void KeymainTest(String... args) {
        String StationaryEquation = "Iteration % MaximumOptions";
        String DiffWithRespTo = "Iteration";
        String StrTimeTaken1 = "";
        String AlgoName="Encrypt";
        System.out.println("KeymainTest:TestSuite:TimeTaken:");
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                StrTimeTaken1 = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                StrTimeTaken1 = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("KeymainTest:TestSuite Started:Run Time:" + current + " ");
        }
        // TODO code application logic here
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
        }
        
        TestCase = 10000;
        int NumberOfTests=100;
        AlicePairKeys = new String[NumberOfTests][3];
        BobPairKeys = new String[NumberOfTests][3];
        EvePairKeys = new String[NumberOfTests][3];
        
        AlicePairKeysQuality = new String[NumberOfTests][3];
        BobPairKeysQuality = new String[NumberOfTests][3];
        EvePairKeysQuality = new String[NumberOfTests][3];
        
        AlicePairKeysQualityLowLvl = new String[NumberOfTests][3];
        BobPairKeysQualityLowLvl = new String[NumberOfTests][3];
        EvePairKeysQualityLowLvl = new String[NumberOfTests][3];
        
        
        
        boolean statusflag = false;
        int i = 0;
        for (; i < NumberOfTests; i++) {
            TestCaseInternalVar = i;
            String StrTimeTaken = "";
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                if (TimeTaken.length == 3) {
                    StrTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    StrTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("/************************** ConfigurationCycle Begins :" + i + ":*************** */");
                System.out.println("ConfigurationCycle Started:" + i + ":Run Time:" + current + " ");
            }
            DisplayUserTweaks();
            statusflag = KeyTest(AlgoName,StationaryEquation, DiffWithRespTo, i);
            {
                LocalDateTime current = LocalDateTime.now();
                String[] TimeTaken = current.toString().split(":");
                String localStrCurrentTimeTaken = "";
                if (TimeTaken.length == 3) {
                    localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
                } else {
                    localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
                }
                System.out.println("ConfigurationCycle Completed:" + i + ":Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken))) + " seconds.");
                System.out.println("/************************** ConfigurationCycle Ends :" + i + ":*************** */");
                StrTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken)));
            }
        }
        if (statusflag == false) {
            System.out.println(ConsoleColors.GREEN + "KeymainTest: All Unique Keys Generated" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "KeymainTest: Some Duplicates Keys Generated:i=" + i + " Dup " + ConsoleColors.RESET);
        }
        DisplayKeysPairs(NumberOfTests);
        {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60.0);
            }
            System.out.println("KeymainTest:TestSuite Completed:Run Time:" + current + " Time Taken=" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1))) + " seconds.");
            StrTimeTaken1 = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrTimeTaken1)));
        }
    }
    public static boolean KeyTest(String AlgoName,String StationaryEquation, String DiffWithRespTo, int i) {
        boolean GoodKeyAllflag = false;
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:KeymainUserTweaks";
        SetupAlice(AlgoName);
        SetupBob(AlgoName);
        SetupEve(AlgoName);

        AlicePairKeys[i][0] = AliceKeyPair.getPrivateKey(AlgoName);
        AlicePairKeys[i][1] = AliceKeyPair.getPublicKey(AlgoName);

        BobPairKeys[i][0] = BobKeyPair.getPrivateKey(AlgoName);
        BobPairKeys[i][1] = BobKeyPair.getPublicKey(AlgoName);

        EvePairKeys[i][0] = EveKeyPair.getPrivateKey(AlgoName);
        EvePairKeys[i][1] = EveKeyPair.getPublicKey(AlgoName);
        GoodKeyAllflag = Frequency1DigitAnalysis(i);
        if (GoodKeyAllflag == true) {
            System.out.println(ConsoleColors.GREEN + "Configuration:KeyTest:Frequency1DigitAnalysis:All Keys Are Good." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Configuration:KeyTest:Frequency1DigitAnalysis:Paterns Present." + ConsoleColors.RESET);
        }
        boolean statusflag = false;
        boolean PatternSetflag=false;
        int KeyType = 0;
        String Pattern = "";
        
        for (; KeyType < 3; KeyType++) {
            for (int j = 0; j < 100; j++) {
                PatternBufferAlice[j] = -1;
                PatternBufferBob[j] = -1;
                PatternBufferEve[j] = -1;
            }
            for (int k = 0; k < OATSType2DigitPattern.length; k++) {
                String[] OptionsArrayPat = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String FirstPart = SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArrayPat, OATSType2DigitPattern[k]);
                String[] OptionsArrayPat1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String SecondPart = SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArrayPat1, OATSType2DigitPattern[k]);
                Pattern = FirstPart + SecondPart;
                NoKeyPatternTest(i, KeyType, Pattern);
            }
            PatternSetflag = AnalysisOfKey2DigitPattern(KeyType, PatternBufferAlice, PatternBufferBob, PatternBufferEve);
            for (int k = 0; k < OATSType3DigitPattern.length; k++) {
                String[] OptionsArrayPat = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String FirstPart = SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArrayPat, OATSType3DigitPattern[k]);
                String[] OptionsArrayPat1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String SecondPart = SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArrayPat1, OATSType3DigitPattern[k]);
                Pattern = FirstPart + SecondPart;
                NoKeyPatternTest(i, KeyType, Pattern);
            }
            PatternSetflag = AnalysisOfKey3DigitPattern(KeyType, PatternBufferAlice, PatternBufferBob, PatternBufferEve);
            
            for (int k = 0; k < OATSType4DigitPattern.length; k++) {
                String[] OptionsArrayPat = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String FirstPart = SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArrayPat, OATSType4DigitPattern[k]);
                String[] OptionsArrayPat1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String SecondPart = SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArrayPat1, OATSType4DigitPattern[k]);
                Pattern = FirstPart + SecondPart;
                NoKeyPatternTest(i, KeyType, Pattern);
            }
            PatternSetflag = AnalysisOfKey4DigitPattern(KeyType, PatternBufferAlice, PatternBufferBob, PatternBufferEve);
            
            for (int k = 0; k < OATSType5DigitPattern.length; k++) {
                String[] OptionsArrayPat = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String FirstPart = SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArrayPat, OATSType5DigitPattern[k]);
                String[] OptionsArrayPat1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String SecondPart = SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArrayPat1, OATSType5DigitPattern[k]);
                Pattern = FirstPart + SecondPart;
                NoKeyPatternTest(i, KeyType, Pattern);
            }
            PatternSetflag = AnalysisOfKey5DigitPattern(KeyType, PatternBufferAlice, PatternBufferBob, PatternBufferEve);
            
            if(PatternSetflag==false)
                System.out.println(ConsoleColors.RED + "Configuration:KeyTest:Key With 2 Digit Pattern.:PatternSetflag=" + PatternSetflag + " KeyType=" + KeyType + ConsoleColors.RESET);
            else
                System.out.println(ConsoleColors.GREEN + "Configuration:KeyTest:GOOD KEY: NO Pattern.:PatternSetflag=" + PatternSetflag + " KeyType=" + KeyType + ConsoleColors.RESET);
           }
        
        int j = 0;
        // No Key Repeated Test();
        for (; j < i; j++) {
            if (j == 0) {
                statusflag = BasicKeyTest(i);
            }
            for (int k = 0; k < OrthogonalArrayKeyTypeOATS.length; k++) {
                // o:Private Key 1:Public Key 2:Symmetric Key
                String[] OptionsArray = {"0", "1", "2"};
                int iKeyType = Integer.parseInt(SingleConfigDOE(AlgoName,0, StationaryEquation, DiffWithRespTo, OptionsArray, OrthogonalArrayKeyTypeOATS[k]));
                String[] OptionsArray1 = {"0", "1", "2"};
                int jKeyType = Integer.parseInt(SingleConfigDOE(AlgoName,1, StationaryEquation, DiffWithRespTo, OptionsArray1, OrthogonalArrayKeyTypeOATS[k]));
                statusflag = CrossKeyRepeatedTest(i, iKeyType, j, jKeyType);
            }
        }
        HighLevelKeyTestTestCase();
        return statusflag;
    }

    public static boolean BasicKeyTest(int i) {
        boolean statusflag = false;
        if (!AlicePairKeys[i][0].equalsIgnoreCase(AlicePairKeys[i][1]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Alice:Private Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!AlicePairKeys[i][0].equalsIgnoreCase(AlicePairKeys[i][2]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Alice:Private Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!AlicePairKeys[i][1].equalsIgnoreCase(AlicePairKeys[i][2]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Alice:Public Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!BobPairKeys[i][0].equalsIgnoreCase(BobPairKeys[i][1]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Bob:Private Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!BobPairKeys[i][0].equalsIgnoreCase(BobPairKeys[i][2]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Bob:Private Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!BobPairKeys[i][1].equalsIgnoreCase(BobPairKeys[i][2]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Bob:Public Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!EvePairKeys[i][0].equalsIgnoreCase(EvePairKeys[i][1]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Eve:Private Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!EvePairKeys[i][0].equalsIgnoreCase(EvePairKeys[i][2]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Eve:Private Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        if (!EvePairKeys[i][1].equalsIgnoreCase(EvePairKeys[i][2]))
                ; else {
            System.out.println(ConsoleColors.RED + "BasicKeyTest:Eve:Public Key:Duplicate Keys Generated:Current=" + i + ConsoleColors.RESET);
            statusflag = true;
        }
        //System.out.println(ConsoleColors.BLUE + "BasicKeyTest:Overall:Flag=" + statusflag + ConsoleColors.RESET);
        return statusflag;
    }

    public static boolean NoKeyRepeatedTest(int i, int j) {
        boolean statusflag = false;
        if (i > j) {
            // Private Key
            if (!AlicePairKeys[i][0].equalsIgnoreCase(AlicePairKeys[j][0]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Alice:Private Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            if (!BobPairKeys[i][0].equalsIgnoreCase(BobPairKeys[j][0]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Bob:Private Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            if (!EvePairKeys[i][0].equalsIgnoreCase(EvePairKeys[j][0]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Eve:Private Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            // Public Key
            if (!AlicePairKeys[i][1].equalsIgnoreCase(AlicePairKeys[j][1]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Alice:Public Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            if (!BobPairKeys[i][1].equalsIgnoreCase(BobPairKeys[j][1]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Bob:Public Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            if (!EvePairKeys[i][1].equalsIgnoreCase(EvePairKeys[j][1]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Eve:Public Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            // Symmetric Key
            if (!AlicePairKeys[i][2].equalsIgnoreCase(AlicePairKeys[j][2]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Alice:Symmetric Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            if (!BobPairKeys[i][2].equalsIgnoreCase(BobPairKeys[j][2]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Bob:Symmetric Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
            if (!EvePairKeys[i][2].equalsIgnoreCase(EvePairKeys[j][2]))
                ; else {
                System.out.println(ConsoleColors.RED + "NoKeyRepeatedTest:Eve:Symmetric Key:Duplicate Keys Generated:Current=" + i + " equals j=" + j + ConsoleColors.RESET);
                statusflag = true;
            }
        }
        return statusflag;
    }

    public static boolean CrossKeyRepeatedTest(int i, int iKeyType, int j, int jKeyType) {
        boolean statusflag = false;
        if (i > j) {
            // Private Key
            if (!AlicePairKeys[i][iKeyType].equalsIgnoreCase(BobPairKeys[j][jKeyType]))
                ; else {
                AlicePairKeysQuality[i][iKeyType] +="BADKEY:Duplicate Alice(" + i +")(" + iKeyType + "):Bob(" + j +")(" + jKeyType + ")";
                PrintKey("Alice", i, iKeyType, j, jKeyType, "Bob");
                statusflag = true;
            }
            if (!AlicePairKeys[i][iKeyType].equalsIgnoreCase(EvePairKeys[j][jKeyType]))
                ; else {
                AlicePairKeysQuality[i][iKeyType] +="BADKEY:Duplicate Alice(" + i +")(" + iKeyType + "):Eve(" + j +")(" + jKeyType + ")";
                PrintKey("Alice", i, iKeyType, j, jKeyType, "Eve");
                statusflag = true;
            }
            if (!BobPairKeys[i][iKeyType].equalsIgnoreCase(EvePairKeys[j][jKeyType]))
                ; else {
                BobPairKeysQuality[i][iKeyType] +="BADKEY:Duplicate Bob(" + i +")(" + iKeyType + "):Eve(" + j +")(" + jKeyType + ")";
                PrintKey("Bob", i, iKeyType, j, jKeyType, "Eve");
                statusflag = true;
            }
            if (!BobPairKeys[i][iKeyType].equalsIgnoreCase(AlicePairKeys[j][jKeyType]))
                ; else {
                BobPairKeysQuality[i][iKeyType] +="BADKEY:Duplicate Bob(" + i +")(" + iKeyType + "):Alice(" + j +")(" + jKeyType + ")";
                PrintKey("Bob", i, iKeyType, j, jKeyType, "Alice");
                statusflag = true;
            }
            if (!EvePairKeys[i][iKeyType].equalsIgnoreCase(BobPairKeys[j][jKeyType]))
                ; else {
                EvePairKeysQuality[i][iKeyType] +="BADKEY:Duplicate Eve(" + i +")(" + iKeyType + "):Bob(" + j +")(" + jKeyType + ")";
                PrintKey("Eve", i, iKeyType, j, jKeyType, "Bob");
                statusflag = true;
            }
            if (!EvePairKeys[i][iKeyType].equalsIgnoreCase(AlicePairKeys[j][jKeyType]))
                ; else {
                EvePairKeysQuality[i][iKeyType] +="BADKEY:Duplicate Eve(" + i +")(" + iKeyType + "):Alice(" + j +")(" + jKeyType + ")";
                PrintKey("Eve", i, iKeyType, j, jKeyType, "Alice");
                statusflag = true;
            }
        }
        return statusflag;
    }

    public static void PrintKey(String Person, int i, int iKeyType, int j, int jKeyType, String Person2) {
        if ((iKeyType == 0) && (jKeyType == 0)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Private + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Private + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 0) && (jKeyType == 1)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Private + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Public + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 0) && (jKeyType == 2)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Private + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Symmetric + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 1) && (jKeyType == 0)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Public + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Private + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 1) && (jKeyType == 1)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Public + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Public + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 1) && (jKeyType == 2)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Public + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Symmetric + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 2) && (jKeyType == 0)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Symmetric + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Private + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 2) && (jKeyType == 1)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Symmetric + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Public + ":" + ConsoleColors.RESET);
            return;
        }
        if ((iKeyType == 2) && (jKeyType == 2)) {
            System.out.println(ConsoleColors.RED + "CrossKeyRepeatedTest:" + Person + ":iKeyType=" + KeytypeEnum.Symmetric + ":Duplicate Keys Generated:Current=" + i + " " + Person2 + " equals j=" + j + ":jKeyType=" + KeytypeEnum.Symmetric + ":" + ConsoleColors.RESET);
            return;
        }

    }

    public static boolean Frequency1DigitAnalysis(int i) {

        boolean GoodKeyAllSetflag = false;
        for (int KeyType = 0; KeyType < 3; KeyType++) {
            for (int j = 0; j < 11; j++) {
                FrequencyBufferAlice[j] = 0;
                FrequencyBufferBob[j] = 0;
                FrequencyBufferEve[j] = 0;
            }
            for (int indexDigit = 0; indexDigit < 10; indexDigit++) {
                //Compute the number of indexDigit
                String[] DataTemp = AlicePairKeys[i][KeyType].split("" + indexDigit,AlicePairKeys[i][KeyType].length());
                if (DataTemp.length > 1) {
                    FrequencyBufferAlice[indexDigit] = DataTemp.length;
                }else
                     FrequencyBufferAlice[indexDigit] =-1;
                FrequencyBufferAlice[10] = AlicePairKeys[i][KeyType].length();

                String[] DataTemp1 = BobPairKeys[i][KeyType].split("" + indexDigit,BobPairKeys[i][KeyType].length());
                if (DataTemp1.length > 1) {
                    FrequencyBufferBob[indexDigit] = DataTemp1.length;
                } else 
                    FrequencyBufferBob[indexDigit] =-1;
                FrequencyBufferBob[10] = BobPairKeys[i][KeyType].length();

                String[] DataTemp2 = EvePairKeys[i][KeyType].split("" + indexDigit,EvePairKeys[i][KeyType].length());
                if (DataTemp2.length > 1) {
                    FrequencyBufferEve[indexDigit] = DataTemp2.length;
                }else
                    FrequencyBufferEve[indexDigit] =-1;
                FrequencyBufferEve[10] = EvePairKeys[i][KeyType].length();
            }
            GoodKeyAllSetflag = AnalysisOfKeyDigit(KeyType,i, FrequencyBufferAlice, FrequencyBufferBob, FrequencyBufferEve);
            PrintFreqAnalysis(i, KeyType, FrequencyBufferAlice, FrequencyBufferBob, FrequencyBufferEve);
            if (GoodKeyAllSetflag == true){
                AlicePairKeysQualityLowLvl[i][KeyType]=":Good Key Alice:KeyType=" + KeyType ;
                BobPairKeysQualityLowLvl[i][KeyType]=":Good Key Bob:KeyType=" + KeyType ;
                EvePairKeysQualityLowLvl[i][KeyType]=":Good Key Eve:KeyType=" + KeyType ;
            }
        }
        return GoodKeyAllSetflag;
    }

    public static boolean AnalysisOfKeyDigit(int KeyType, int i, int[] FrequencyBufferAlice, int[] FrequencyBufferBob, int[] FrequencyBufferEve) {
        boolean GoodKeyflagAlice = false;
        boolean GoodKeyflagBob = false;
        boolean GoodKeyflagEve = false;
        boolean OverallKeySetFlag = false;
        RepetionDigitCountAlice = 0;
        ZeroDigitCountAlice = 0;
        RepetionDigitCountBob = 0;
        ZeroDigitCountBob = 0;
        RepetionDigitCountEve = 0;
        ZeroDigitCountEve = 0;
        for (int j = 0; j < 10; j++) {
            AnalysisBufferAlice[j] = 0;
            AnalysisBufferBob[j] = 0;
            AnalysisBufferEve[j] = 0;
        }
        for (int index = 0; index < 10; index++) {
            // Alice Key (KeyType) Computation
            if (FrequencyBufferAlice[index] >= (int) (0.10 * (double) FrequencyBufferAlice[10])) {
                AnalysisBufferAlice[index] = FrequencyBufferAlice[index];
                RepetionDigitCountAlice++;
                GoodKeyflagAlice = false;
            } else if ((FrequencyBufferAlice[index] > 1) && (FrequencyBufferAlice[index] <= (int) (0.10 * (double) FrequencyBufferAlice[10]))) {
                AnalysisBufferAlice[index] = FrequencyBufferAlice[index];
                GoodKeyflagAlice = true;
            } else if (FrequencyBufferAlice[index] == -1) {
                ZeroDigitCountAlice++;
                AnalysisBufferAlice[index] = -1;
            }
            // Bob Key (KeyType) Computation
            if (FrequencyBufferBob[index] >= (int) (0.10 * (double) FrequencyBufferBob[10])) {
                AnalysisBufferBob[index] = FrequencyBufferBob[index];
                RepetionDigitCountBob++;
                GoodKeyflagBob = false;
            } else if ((FrequencyBufferBob[index] > 1) && (FrequencyBufferBob[index] <= (int) (0.10 * (double) FrequencyBufferBob[10]))) {
                AnalysisBufferBob[index] = FrequencyBufferBob[index];
                GoodKeyflagBob = true;
            } else if (FrequencyBufferBob[index] == -1) {
                ZeroDigitCountBob++;
                AnalysisBufferBob[index] = -1;
            }
            // Eve Key (KeyType) Computation
            if (FrequencyBufferEve[index] >= (int) (0.10 * (double) FrequencyBufferEve[10])) {
                AnalysisBufferEve[index] = FrequencyBufferEve[index];
                RepetionDigitCountEve++;
                GoodKeyflagEve = false;
            } else if ((FrequencyBufferEve[index] > 1) && (FrequencyBufferEve[index] <= (int) (0.10 * (double) FrequencyBufferAlice[10]))) {
                AnalysisBufferEve[index] = FrequencyBufferEve[index];
                GoodKeyflagEve = true;
            } else if (FrequencyBufferEve[index] == -1) {
                ZeroDigitCountEve++;
                AnalysisBufferEve[index] = -1;
            }
        }
        for (int index = 0; index < 10; index++) {
            if (((ZeroDigitCountAlice >= 5) && (RepetionDigitCountAlice <= 5) ) ) {
                //System.out.println(ConsoleColors.BLUE + "AnalysisOfKeyDigit:BAD Key Alice:KeyType=" + KeyType + " Digit=" + index + ConsoleColors.RESET);
                GoodKeyflagAlice = false;
                AlicePairKeysQualityLowLvl[i][KeyType]=":BAD Key Alice:KeyType=" + KeyType + " Digit=" + index ;
            } else if ((AnalysisBufferAlice[index] > 0) && (AnalysisBufferAlice[index] <= (0.1 * (double) FrequencyBufferAlice[10]))) {
                GoodKeyflagAlice = true;
            }
            if (((ZeroDigitCountBob >= 5) && (RepetionDigitCountBob <= 5) ) ) {
                //System.out.println(ConsoleColors.BLUE + "AnalysisOfKeyDigit:BAD Key Bob:KeyType=" + KeyType + " Digit=" + index + ConsoleColors.RESET);
                BobPairKeysQualityLowLvl[i][KeyType]=":BAD Key Bob:KeyType=" + KeyType + " Digit=" + index ;
                GoodKeyflagBob = false;
            } else if ((AnalysisBufferBob[index] > 0) && (AnalysisBufferBob[index] <= (0.1 * (double) FrequencyBufferBob[10]))) {
                GoodKeyflagBob = true;
            }
            if (((ZeroDigitCountEve >= 5) && (RepetionDigitCountEve <= 5) ) ){
                EvePairKeysQualityLowLvl[i][KeyType]=":BAD Key Eve:KeyType=" + KeyType + " Digit=" + index ;
                GoodKeyflagEve = false;
            } else if ((AnalysisBufferEve[index] > 0) && (AnalysisBufferEve[index] <= (0.1 * (double) FrequencyBufferEve[10]))) {
                GoodKeyflagEve = true;
            }
            OverallKeySetFlag = (GoodKeyflagAlice && GoodKeyflagBob && GoodKeyflagEve);
        }
        //System.out.println(ConsoleColors.BLUE + "Configuration:AnalysisOfKeyDigit:Overall:KeyType=" + KeyType +" Flag=" + (GoodKeyflagAlice&&GoodKeyflagBob&&GoodKeyflagEve) + " Alice:" + GoodKeyflagAlice + " Bob:" + GoodKeyflagBob + " Eve:" + GoodKeyflagEve + ConsoleColors.RESET);
        return OverallKeySetFlag;
    }

    public static void PrintFreqAnalysis(int i, int KeyType, int[] FrequencyBufferAlice, int[] FrequencyBufferBob, int[] FrequencyBufferEve) {
        System.out.println("PrintFreqAnalysis:Alice:i=" + i + " KeyType=" + KeyType);
        for (int indexDigit = 0; indexDigit < 11; indexDigit++) {
            System.out.print(":" + indexDigit + " =" + FrequencyBufferAlice[indexDigit] + " ");
        }
        System.out.print(System.lineSeparator());
        System.out.println("PrintFreqAnalysis:Alice:ZeroDigit=" + ZeroDigitCountAlice + " RepetionDigit=" + RepetionDigitCountAlice);
        System.out.println("PrintFreqAnalysis:Bob:i=" + i + " KeyType=" + KeyType);
        for (int indexDigit = 0; indexDigit < 11; indexDigit++) {
            System.out.print(":" + indexDigit + " =" + FrequencyBufferBob[indexDigit] + " ");
        }
        System.out.print(System.lineSeparator());
        System.out.println("PrintFreqAnalysis:Bob:ZeroDigit=" + ZeroDigitCountBob + " RepetionDigit=" + RepetionDigitCountBob);

        System.out.println("PrintFreqAnalysis:Eve:i=" + i + " KeyType=" + KeyType);
        for (int indexDigit = 0; indexDigit < 11; indexDigit++) {
            System.out.print(":" + indexDigit + " =" + FrequencyBufferEve[indexDigit] + " ");
        }
        System.out.print(System.lineSeparator());
        System.out.println("PrintFreqAnalysis:Eve:ZeroDigit=" + ZeroDigitCountEve + " RepetionDigit=" + RepetionDigitCountEve);

    }

    public static void NoKeyPatternTest(int i, int KeyType, String Pattern) {
        boolean statusflag = false;
        int indexDigit = Integer.parseInt(Pattern);
        // Private Key
        String[] DataTemp = AlicePairKeys[i][KeyType].split(Pattern);
        if (DataTemp.length > 1) {
            PatternBufferAlice[indexDigit] = DataTemp.length;
        }
        PatternBufferAlice[101] = AlicePairKeys[i][KeyType].length();
        String[] DataTemp1 = BobPairKeys[i][KeyType].split(Pattern);
        if (DataTemp1.length > 1) {
            PatternBufferBob[indexDigit] = DataTemp1.length;
        }
        PatternBufferBob[101] = BobPairKeys[i][KeyType].length();
        String[] DataTemp2 = EvePairKeys[i][KeyType].split(Pattern);
        if (DataTemp2.length > 1) {
            PatternBufferEve[indexDigit] = DataTemp2.length;
        }
        PatternBufferEve[101] = EvePairKeys[i][KeyType].length();
    }
public static boolean AnalysisOfKey2DigitPattern(int KeyType, int[] PatternBufferAlice, int[] PatternBufferBob, int[] PatternBufferEve) {
        boolean GoodKeyflagAlice = false;
        boolean GoodKeyflagBob = false;
        boolean GoodKeyflagEve = false;
        boolean PatternflagAlice = false;
        boolean PatternflagBob = false;
        boolean PatternflagEve = false;
        boolean GoodKeySetAlice = false;
        boolean GoodKeySetBob = false;
        boolean GoodKeySetEve = false;
        boolean OverallKeySetFlag = false;
        
        for (int j = 0; j < 100; j++) {
            AnalysisBufferAlice[j] = 0;
            AnalysisBufferBob[j] = 0;
            AnalysisBufferEve[j] = 0;
        }
        for (int index = 0; index < 100; index++) {
            // Alice Key (KeyType) Computation
            if ( (PatternBufferAlice[index] >= (int) (0.30 * (double) PatternBufferAlice[101])) ) {
                AnalysisBufferAlice[index] = PatternBufferAlice[index];
                PatternflagAlice=true;
            } 
            
            if((index==99)&&(GoodKeySetAlice==false)&&(PatternflagAlice==false))
                GoodKeySetAlice=true;
            
            // Bob Key (KeyType) Computation
            if ( (PatternBufferBob[index] >= (int) (0.30 * (double) PatternBufferBob[101])) ) {
                AnalysisBufferBob[index] = PatternBufferBob[index];
                PatternflagBob=true;
            } 
            
            if((index==99)&&(GoodKeySetBob==false)&&(PatternflagBob==false))
                GoodKeySetBob=true;
            
            // Eve Key (KeyType) Computation
            if ( (PatternBufferEve[index] >= (int) (0.30 * (double) PatternBufferEve[101])) ) {
                AnalysisBufferEve[index] = PatternBufferEve[index];
                PatternflagEve=true;
            } 
            if((index==99)&&(GoodKeySetEve==false)&&(PatternflagEve==false))
                GoodKeySetEve=true; 
        }
            OverallKeySetFlag = (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:KeyType=" + KeyType +" Flag=" + (GoodKeyflagAlice&&GoodKeyflagBob&&GoodKeyflagEve) + " Alice:" + GoodKeyflagAlice + " Bob:" + GoodKeyflagBob + " Eve:" + GoodKeyflagEve + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:Set:KeyType=" + KeyType +" Flag=" + (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve) + " Alice:" + GoodKeySetAlice + " Bob:" + GoodKeySetBob + " Eve:" + GoodKeySetEve + ConsoleColors.RESET);
        
        return OverallKeySetFlag;
    }
public static boolean AnalysisOfKey3DigitPattern(int KeyType, int[] PatternBufferAlice, int[] PatternBufferBob, int[] PatternBufferEve) {
        boolean GoodKeyflagAlice = false;
        boolean GoodKeyflagBob = false;
        boolean GoodKeyflagEve = false;
        boolean PatternflagAlice = false;
        boolean PatternflagBob = false;
        boolean PatternflagEve = false;
        boolean GoodKeySetAlice = false;
        boolean GoodKeySetBob = false;
        boolean GoodKeySetEve = false;
        boolean OverallKeySetFlag = false;
        
        for (int j = 0; j < 100; j++) {
            AnalysisBufferAlice[j] = 0;
            AnalysisBufferBob[j] = 0;
            AnalysisBufferEve[j] = 0;
        }
        for (int index = 0; index < 100; index++) {
            // Alice Key (KeyType) Computation
            if ( (PatternBufferAlice[index] >= (int) (0.30 * (double) PatternBufferAlice[101])) ) {
                AnalysisBufferAlice[index] = PatternBufferAlice[index];
                PatternflagAlice=true;
            } 
            
            if((index==99)&&(GoodKeySetAlice==false)&&(PatternflagAlice==false))
                GoodKeySetAlice=true;
            
            // Bob Key (KeyType) Computation
            if ( (PatternBufferBob[index] >= (int) (0.30 * (double) PatternBufferBob[101])) ) {
                AnalysisBufferBob[index] = PatternBufferBob[index];
                PatternflagBob=true;
            } 
            
            if((index==99)&&(GoodKeySetBob==false)&&(PatternflagBob==false))
                GoodKeySetBob=true;
            
            // Eve Key (KeyType) Computation
            if ( (PatternBufferEve[index] >= (int) (0.30 * (double) PatternBufferEve[101])) ) {
                AnalysisBufferEve[index] = PatternBufferEve[index];
                PatternflagEve=true;
            } 
            if((index==99)&&(GoodKeySetEve==false)&&(PatternflagEve==false))
                GoodKeySetEve=true; 
        }
            OverallKeySetFlag = (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:KeyType=" + KeyType +" Flag=" + (GoodKeyflagAlice&&GoodKeyflagBob&&GoodKeyflagEve) + " Alice:" + GoodKeyflagAlice + " Bob:" + GoodKeyflagBob + " Eve:" + GoodKeyflagEve + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:Set:KeyType=" + KeyType +" Flag=" + (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve) + " Alice:" + GoodKeySetAlice + " Bob:" + GoodKeySetBob + " Eve:" + GoodKeySetEve + ConsoleColors.RESET);
        
        return OverallKeySetFlag;
    }
public static boolean AnalysisOfKey4DigitPattern(int KeyType, int[] PatternBufferAlice, int[] PatternBufferBob, int[] PatternBufferEve) {
        boolean GoodKeyflagAlice = false;
        boolean GoodKeyflagBob = false;
        boolean GoodKeyflagEve = false;
        boolean PatternflagAlice = false;
        boolean PatternflagBob = false;
        boolean PatternflagEve = false;
        boolean GoodKeySetAlice = false;
        boolean GoodKeySetBob = false;
        boolean GoodKeySetEve = false;
        boolean OverallKeySetFlag = false;
        
        for (int j = 0; j < 100; j++) {
            AnalysisBufferAlice[j] = 0;
            AnalysisBufferBob[j] = 0;
            AnalysisBufferEve[j] = 0;
        }
        for (int index = 0; index < 100; index++) {
            // Alice Key (KeyType) Computation
            if ( (PatternBufferAlice[index] >= (int) (0.30 * (double) PatternBufferAlice[101])) ) {
                AnalysisBufferAlice[index] = PatternBufferAlice[index];
                PatternflagAlice=true;
            } 
            
            if((index==99)&&(GoodKeySetAlice==false)&&(PatternflagAlice==false))
                GoodKeySetAlice=true;
            
            // Bob Key (KeyType) Computation
            if ( (PatternBufferBob[index] >= (int) (0.30 * (double) PatternBufferBob[101])) ) {
                AnalysisBufferBob[index] = PatternBufferBob[index];
                PatternflagBob=true;
            } 
            
            if((index==99)&&(GoodKeySetBob==false)&&(PatternflagBob==false))
                GoodKeySetBob=true;
            
            // Eve Key (KeyType) Computation
            if ( (PatternBufferEve[index] >= (int) (0.30 * (double) PatternBufferEve[101])) ) {
                AnalysisBufferEve[index] = PatternBufferEve[index];
                PatternflagEve=true;
            } 
            if((index==99)&&(GoodKeySetEve==false)&&(PatternflagEve==false))
                GoodKeySetEve=true; 
        }
            OverallKeySetFlag = (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:KeyType=" + KeyType +" Flag=" + (GoodKeyflagAlice&&GoodKeyflagBob&&GoodKeyflagEve) + " Alice:" + GoodKeyflagAlice + " Bob:" + GoodKeyflagBob + " Eve:" + GoodKeyflagEve + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:Set:KeyType=" + KeyType +" Flag=" + (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve) + " Alice:" + GoodKeySetAlice + " Bob:" + GoodKeySetBob + " Eve:" + GoodKeySetEve + ConsoleColors.RESET);
        
        return OverallKeySetFlag;
    }
public static boolean AnalysisOfKey5DigitPattern(int KeyType, int[] PatternBufferAlice, int[] PatternBufferBob, int[] PatternBufferEve) {
        boolean GoodKeyflagAlice = false;
        boolean GoodKeyflagBob = false;
        boolean GoodKeyflagEve = false;
        boolean PatternflagAlice = false;
        boolean PatternflagBob = false;
        boolean PatternflagEve = false;
        boolean GoodKeySetAlice = false;
        boolean GoodKeySetBob = false;
        boolean GoodKeySetEve = false;
        boolean OverallKeySetFlag = false;
        
        for (int j = 0; j < 100; j++) {
            AnalysisBufferAlice[j] = 0;
            AnalysisBufferBob[j] = 0;
            AnalysisBufferEve[j] = 0;
        }
        for (int index = 0; index < 100; index++) {
            // Alice Key (KeyType) Computation
            if ( (PatternBufferAlice[index] >= (int) (0.30 * (double) PatternBufferAlice[101])) ) {
                AnalysisBufferAlice[index] = PatternBufferAlice[index];
                PatternflagAlice=true;
            } 
            
            if((index==99)&&(GoodKeySetAlice==false)&&(PatternflagAlice==false))
                GoodKeySetAlice=true;
            
            // Bob Key (KeyType) Computation
            if ( (PatternBufferBob[index] >= (int) (0.30 * (double) PatternBufferBob[101])) ) {
                AnalysisBufferBob[index] = PatternBufferBob[index];
                PatternflagBob=true;
            } 
            
            if((index==99)&&(GoodKeySetBob==false)&&(PatternflagBob==false))
                GoodKeySetBob=true;
            
            // Eve Key (KeyType) Computation
            if ( (PatternBufferEve[index] >= (int) (0.30 * (double) PatternBufferEve[101])) ) {
                AnalysisBufferEve[index] = PatternBufferEve[index];
                PatternflagEve=true;
            } 
            if((index==99)&&(GoodKeySetEve==false)&&(PatternflagEve==false))
                GoodKeySetEve=true; 
        }
            OverallKeySetFlag = (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:KeyType=" + KeyType +" Flag=" + (GoodKeyflagAlice&&GoodKeyflagBob&&GoodKeyflagEve) + " Alice:" + GoodKeyflagAlice + " Bob:" + GoodKeyflagBob + " Eve:" + GoodKeyflagEve + ConsoleColors.RESET);
        //System.out.println(ConsoleColors.BLUE + "AnalysisOfKey2DigitPattern:Overall:Set:KeyType=" + KeyType +" Flag=" + (GoodKeySetAlice && GoodKeySetBob && GoodKeySetEve) + " Alice:" + GoodKeySetAlice + " Bob:" + GoodKeySetBob + " Eve:" + GoodKeySetEve + ConsoleColors.RESET);
        
        return OverallKeySetFlag;
    }

public static void HighLevelConfigTestCase(){
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:DOEmainUserTweaks";
        String AlgoName="Encrypt";
            SetupAlice(AlgoName);
            SetupBob(AlgoName);
            SetupEve(AlgoName);
            MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
            //MyMessage ="Hel";
            //MyMessage = "1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
            //MyMessage = "4{}[]";
            MesgINCAPS = false;
            EncryptMesgKey("1", true);
            //TestCasePassHighLevelFlag = TestExecResultsMessage();
    }
    public static void HighLevelKeyTestTestCase() {
        NamesOfTestCase_Objctive = "EncryptMesgSimple Encryption && Decryption:DOEmainUserTweaks";
        String AlgoName = "Encrypt";
        SetupAlice(AlgoName);
        SetupBob(AlgoName);
        SetupEve(AlgoName);
        MyMessage = "the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage ="Hel";
        //MyMessage = "1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\";
        //MyMessage = "4{}[]";
        MesgINCAPS = false;
        EncryptMesgKey("1", true);
        //TestCasePassHighLevelFlag = TestExecResultsMessage();
    }
    public static void EncryptMesgKey(String MesgNum, boolean SilentFlag) {

        System.out.println("EncryptMesgSimple:myPrivKy=" + myPrivKy + " myPubKy=" + myPubKy);
        UserStrings_EncryptMesgSimple_Entropy();
        // Encryption && Decryption Parameters
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");

        /**
         * ************************ Encryption Begins ***************
         */
        if (SuperSuppressOutput == false) {
            System.out.println("/************************** Encryption Begins *************** */");
        }
        String StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        String AlgoName="Encrypt";
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        CalibrationSender = "ContextSetMesgSenderBob";
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:KeyReading=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        if (SuperSuppressOutput == false) {
            System.out.println("EncryptMesgSimple:NumberOfTimes=" + NumberOfTimes + ":Message:Alice To Bob:" + MesgNum + ":Forward");
        }
        EncryptedMesg =new StringBuilder("");
        int Rand1Rotate = (int) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        Double WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        int OffsetRotate1 = SenderReceiverGUI.Sender.OffsetRotate1;
        int OffsetRotate2 = SenderReceiverGUI.Sender.OffsetRotate2;
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:Random OTP Generation =" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        CyclicEncrypt(Rand1Rotate, OffsetRotate1, OffsetRotate2, WeiRand2, WeiCharRand3, SilentFlag);
        //WorkInProgress1Encrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        variablesEncrypt.clear();
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:CyclicEncrypt=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        if (SuperSuppressOutput == false) {
            System.out.println("/************************** Encryption Ends *************** */");
        }

        /**
         * ************************ Encryption Ends ***************
         */
        /**
         * ************************ Decryption Begins ***************
         */
        NoSenderReceivermain();
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        System.out.println("/************************** Decryption Begins *************** */");
        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        AlgoName="Decrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:Decryption:Key Reading=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }

        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        EavesdroppingFlag = false;
        //WorkInProgress1Decrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);
        CyclicDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, BobKeyPair.getPrivateKey(AlgoName), SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        EavesdroppingFlag = true;
        //variables.clear();
        ConfirmedFirstEvent = null;
        ConfirmedSecondEvent = null;
        OccasionNumberOfTimes = 0;
        OccasionNoOfTimesIndex = 0;
        StrTimeTaken = TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:Decryption:CyclicDecrypt=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        if ((MyMessage2 != null) && (!MyMessage2.equalsIgnoreCase(""))) {
            MyMessage = MyMessage2;
        }
        DecryptedMesg = new StringBuilder(DecryptedMesg.toString().trim());
        TestExecResultsMessage();
        System.out.print(System.lineSeparator());
        SenderReceiverGUI.Sender.OffsetRotate1 = -1;
        SenderReceiverGUI.Sender.StrlenRotate1 = -1;
        SenderReceiverGUI.Sender.OffsetRotate2 = -1;
        SenderReceiverGUI.Sender.StrlenRotate2 = -1;
        System.out.println("/************************** Decryption Ends *************** */");
        /**
         * ************************ Decryption Ends ***************
         */
        System.out.println("EncryptMesgSimple:NumberOfTimes=" + NumberOfTimes + ":Message:Bob To Alice:" + MesgNum + ":Reverse");
        if ((MyMessage2 != null) && (!MyMessage2.equalsIgnoreCase(""))) {
            MyMessage = MyMessage2;
        }
        if (SuperSuppressOutput == false) {
            System.out.println("/************************** Encryption Begins *************** */");
        }
        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        AlgoName="Encrypt";
        MyPublicKey = AliceKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = BobKeyPair.getPrivateKey(AlgoName);
        MyPublicEquation = EqnUnderTest;
        CalibrationSender = "ContextSetMesgSenderAlice";
        EncryptedMesg =new StringBuilder("");
        DecryptedMesg =new StringBuilder("");
        //NumberOfTimes = 1;
        OccasionNumberOfTimes = 0;
        OccasionNoOfTimesIndex = 0;
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:Encryption:Key Reading=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        StrTimeTaken = TimeStart();
        /**
         * ************************ Encryption Begins ***************
         */
        Rand1Rotate = (int) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        WeiRand2 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        WeiCharRand3 = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        ConfirmedFirstEvent = new Double[NumberOfTimes + 2];
        ConfirmedSecondEvent = new Double[NumberOfTimes + 2];
        OffsetRotate1 = SenderReceiverGUI.Sender.OffsetRotate1;
        OffsetRotate2 = SenderReceiverGUI.Sender.OffsetRotate2;
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:Encryption:OTP Generation=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        StrTimeTaken = TimeStart();

        CyclicEncrypt(Rand1Rotate, OffsetRotate1, OffsetRotate2, WeiRand2, WeiCharRand3, SilentFlag);
        //WorkInProgress1Encrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);

        MyPublicKey = "";
        MyPrivateKey = "";
        MyPublicEquation = "";
        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:CyclicEncrypt:=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        if (SuperSuppressOutput == false) {
            System.out.println("/************************** Encryption Ends *************** */");
        }
        /**
         * ************************ Encryption Ends ***************
         */
        /**
         * ************************ Decryption Begins ***************
         */
        System.out.println("/************************** Decryption Begins *************** */");
        NoSenderReceivermain();
        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        AlgoName="Decrypt";
        MyPublicKey = BobKeyPair.getPublicKey(AlgoName);
        MyPrivateKey = AliceKeyPair.getPrivateKey(AlgoName);
        MyDecrptionEquation = InverseEqnUnderTest;

        StrTimeTaken = TimeReading(StrTimeTaken);
        if (SuperSuppressOutput == false) {
            System.out.println("StrTimeTaken:Decryption:Key Reading:=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        }
        /**
         * ************************ Decryption Begins ***************
         */
        DecryptedMesg = new StringBuilder(EncryptedMesg);
        if (SuperSuppressOutput == false) {
            System.out.println("EncryptMesgSimple::EncryptedMesg=" + EncryptedMesg);
            System.out.println("EncryptMesgSimple::DecryptedMesg=" + DecryptedMesg);
        }

        StrTimeTaken = "0.0";
        StrTimeTaken = TimeStart();
        EavesdroppingFlag = false;
        //WorkInProgress1Decrypt(Rand1Rotate,WeiRand2, WeiCharRand3,SilentFlag);
        CyclicDecrypt(Rand1Rotate, WeiRand2, WeiCharRand3, AliceKeyPair.getPrivateKey(AlgoName), SilentFlag);
        MyPublicKey = "";
        MyPrivateKey = "";
        MyDecrptionEquation = "";
        //variables.clear();
        ConfirmedFirstEvent = null;
        ConfirmedSecondEvent = null;
        OccasionNumberOfTimes = 0;
        OccasionNoOfTimesIndex = 0;
        EavesdroppingFlag = true;
        SenderReceiverGUI.Sender.OffsetRotate1 = -1;
        SenderReceiverGUI.Sender.StrlenRotate1 = -1;
        SenderReceiverGUI.Sender.OffsetRotate2 = -1;
        SenderReceiverGUI.Sender.StrlenRotate2 = -1;
        if ((MyMessage2 != null) && (!MyMessage2.equalsIgnoreCase(""))) {
            MyMessage = MyMessage2;
        }
        StrTimeTaken = TimeReading(StrTimeTaken);
        System.out.println("StrTimeTaken:CyclicDecrypt:CyclicDecrypt:=" + (Double.parseDouble(StrTimeTaken) * 1000) + " milliseconds");
        System.out.println("/************************** Decryption Ends *************** */");
        /**
         * ************************ Decryption Ends ***************
         */
    }

    /* ******************************* Ends ***************************/
 /* ************************** **************************** ***********/
 /* ************************** USER Defined Variables below Begin *****/
 /* ************************** **************************** ***********/
    // Make any changes to change the values of 
    //  of Security Encryption && Decryption
    // This function is used everywhere (in some Test Cases)
    // Change the values as per the documentation.
    public static void UserStrings_MessageShannon_Entropy() {
        EqnUnderTest = "Xn^2+2*Xn*c+c^2";  //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseEqnUnderTest = "y^0.5-c";       //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        // Diffusion Parameters
        ExprnDiffusion = "Xn^2+2*Xn*c+c^2+0.2"; //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        DiffWithRespToDiffusion = "Xn";
        InvExprnDiffusion = "y^0.5-c";          //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        InvDiffusionDiffWithRespTo = "y";
        // Surprise Parameters

        ExprnSurprise = "d*Xn^n+d2^n";          //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        DiffWithRespToSurprise = "Xn";
        InvTempSurprise = "y/d-d2^n/d";
        InvExprnSurprise = "y^a";               //x=y1^1/n
        InvSurpriseDiffWithRespTo = "y";
    }

    // Make any changes to change the values of 
    //  of Security Encryption && Decryption
    // This function is used everywhere (in some Test Cases)
    // Change the values as per the documentation.
    public static void UserStrings_MessageShannonSimple_Entropy() {
        EqnUnderTest = "Xn^2+2*Xn*c+c^2";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseEqnUnderTest = "y^0.5-c";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        // Diffusion Parameters
        ExprnDiffusion = "Xn^2+2*Xn*c+c^2"; //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        DiffWithRespToDiffusion = "Xn";
        InvExprnDiffusion = "y^0.5-c";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        InvDiffusionDiffWithRespTo = "y";
        // Surprise Parameters
        ExprnSurprise = "Xn^n+2*Xn*d2+d2^n+0.2";      //y=(Xn+d2)^n;//y=(Xn+d2)^n; //y=Xn^2+2*Xn*d2+d2^2
        DiffWithRespToSurprise = "Xn";
        InvExprnSurprise = "y^a-d2";
        InvSurpriseDiffWithRespTo = "y";
    }

    // Make any changes to change the values of 
    //  of Security Encryption && Decryption
    // This function is used everywhere (Most Test Cases and Production )
    // Change the values as per the documentation(PoorMan's Security V 3.0.doc).
    public static void UserStrings_EncryptMesgSimple_Entropy() {
        // Equation Pair 1
        EqnUnderTest = "m^2*Xn^2+2*m*Xn*c+c^2";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        InverseEqnUnderTest = "y^0.5/m-c/m";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        if ((myPrivKy <= 75)) {
            EqnUnderTest = "m*Xn+5";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
            InverseEqnUnderTest = "y/m-5/m";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        }
        //variables.put("m", diffusiond2);
        //variables.put("c", diffusionN);
        //variablesStr.put("m", "m");
        //variablesStr.put("c", "c");
        //VerifyInverse( EqnUnderTest,  "Xn",  InverseEqnUnderTest, "y");
        // Equation Pair 2
        // Confusion and Diffusion Parameters
        ExprnDiffusion = "Xn^2+2*Xn*c+c^2"; //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
        DiffWithRespToDiffusion = "Xn";
        InvExprnDiffusion = "y^0.5-c";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
        InvDiffusionDiffWithRespTo = "y";
        //variables.put("c", diffusionN);
        //variablesStr.put("c", "c");
        //VerifyInverse( ExprnDiffusion,  DiffWithRespToDiffusion,  InvExprnDiffusion, InvDiffusionDiffWithRespTo);
        // Equation Pair 3
        // Surprise Parameters
        ExprnSurprise = "Xn^diffusionN+2*Xn*diffusiond2+diffusiond2^diffusionN+0.2";      //y=(Xn+d2)^n;//y=(Xn+d2)^n; //y=Xn^2+2*Xn*d2+d2^2
        DiffWithRespToSurprise = "Xn";
        InvExprnSurprise = "y^confusionA-diffusiond2";
        InvSurpriseDiffWithRespTo = "y";
        // Static values
        diffusiond2 = 4.0;
        diffusionN = 2.0;
        confusionA = 1.0 / diffusionN;
        // Diffusion Parameters
        // Surprise Parameters
        //variables.put("diffusiond2", diffusiond2);
        //variables.put("diffusionN", diffusionN);
        //variables.put("confusionA", confusionA);
        //variablesStr.put("diffusiond2", "diffusiond2");
        //variablesStr.put("diffusionN", "diffusionN");
        //variablesStr.put("confusionA", "confusionA");
        //VerifyInverse( ExprnSurprise,  DiffWithRespToSurprise,  InvExprnSurprise, InvSurpriseDiffWithRespTo);
        //Fractionating Encrypt Parameters
        // Equation Pair 4
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

        ScramVarGapExprn = "m*Xn+c";

        MySimpleWeiBull = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
        variablesStr.clear();
        variablesEncrypt.clear();
        variablesDecrypt.clear();
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
        SeedSimple = 41;// Preferably Prime Number
        SeedDyDx = 29;// Preferably Prime Number
        SeedXOR = 31;// Preferably Prime Number
        RANDProdPerform = "Production";
        // Initialize Prime Numbers
        long MaxValue=Math.max(d,Math.max(b, Math.max(a,c)) );
        PrimeNumber(10000);
        long Prime=GetPrimeNumber(MaxValue);
        System.out.println("UserTweaks:MaxValue="+ MaxValue + " LastIndex=" + LastIndex + " Prime=" + Prime);
        // Tweaks End
    }
//Function to generate Prime Number just below MaxValue

    public static void PrimeNumber(long MaxValue) {
        long Prime = 0;
        long number = 1;
        PrimeArray = new Long[(int)MaxValue];
        PrimeArray[0] = (long)3;
        int i = 0;
        
        for (number = 3; number < MaxValue; number += 2) {
            LastIndex=(int)MaxValue;
            for (i = 0; i < LastIndex;) {
                //System.out.println("PrimeNumber:MaxValue="+ MaxValue + " LastIndex=" + LastIndex + " number=" + number + " PrimeArray[" + i + ":]=" + PrimeArray[i]);
                if ( (PrimeArray[i] != null) && ((number % PrimeArray[i]) == 0) ) {
                    break;
                } 
                else if (i > (6 * Math.sqrt(number))) {
                    break;
                } 
                else if (PrimeArray[i]==null) {
                    break;
                }
                else if (i < LastIndex){
                    i++;
                }
            }
            if ((i+1) == LastIndex) {
                PrimeArray[i++] = number;
                LastIndex=i;
                //System.out.println("PrimeNumber:Adding number:MaxValue="+ MaxValue + " LastIndex=" + LastIndex + " number=" + number + " PrimeArray[" + i + ":]=" + PrimeArray[i]);
            }else if (PrimeArray[i]==null){
                PrimeArray[i++] = number;
                LastIndex=i;
                //System.out.println("PrimeNumber:Adding number:null:MaxValue="+ MaxValue + " LastIndex=" + LastIndex + " number=" + number + " PrimeArray[" + i + ":]=" + PrimeArray[i]);
            }
        }
    }
public static long GetPrimeNumber(long CurrentValue) {
    //System.out.println("GetPrimeNumber:MaxValue=" + MaxValue + " LastIndex=" + LastIndex);
        long Prime = 0;
        for (int i = 1; (i < LastIndex)&&(i < PrimeArray.length)&&(PrimeArray[i] != null); i++) {
                Prime = PrimeArray[i];
                if (CurrentValue <= PrimeArray[i]) {
                    Prime = PrimeArray[i + 1];
                return Prime;
            }
        }
        return Prime;
    }
    /* ************************** **************************** ***********/
 /* ************************** USER Defined Variables below End ******/
 /* ************************** **************************** **********/
}
