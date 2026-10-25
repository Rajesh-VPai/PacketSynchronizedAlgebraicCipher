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
import static Calculus.MathsExpressionParser.parse;
import RandomNumber.RandomFactorialLCGDyDx;
import static RandomNumber.RandomFactorialLCGDyDx.baseEquationFactorial;
import RandomNumber.RandomSimpleLCG;
import static RandomNumber.RandomSimpleLCG.baseEquationLCG;
import RandomNumber.UserResearchStudy;
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.NoOfSlots;
import static RandomNumber.UserResearchStudy.SeedDyDx;
import static RandomNumber.UserResearchStudy.SeedSimple;
import static RandomNumber.UserResearchStudy.Xn_LCGDyDx;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.b;
import static RandomNumber.UserResearchStudy.c;
import static RandomNumber.UserResearchStudy.d;
import static Security.Configuration.GetPrimeNumber;
import static Security.Configuration.PrimeNumber;
import static Security.Configuration.SingleConfigDOE;
import static Security.Configuration.UserTweaks_Entropy;
import static Security.PacketSynchronizedAlgebraicCipher.RandomEngineResetFactFlag;
import static Security.PacketSynchronizedAlgebraicCipher.RandomEngineResetValueFlag;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.Security.MyFactorial;
import static Security.Security.MySimple;
import static Security.Security.SeedGenFormula;
import static Security.Security.Xn_LCG;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
// import your shared PSA variables
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rajesh V Pai
 */
public class PSACKeyVaultNew {

    private String publicKey = "";
    private String privateKey = "";
    long PrivateKeyLength = -1;
    long PublicKeyLength = -1;
    Double N = 0.0;
    String StationaryEquation = "Iteration % MaximumOptions";
    String DiffWithRespTo = "Iteration";
    String Pattern = "";
    public static String NProductGenFormula = "Xn";
    public static String KeyLengthGenFormula = "x+y";
    // Key Pair Generation Equations Begin
    public static String KeyCombinationEqn = "pubkey+privkey";//Used Everywhere:
    public static String KeyDerivationEqn = "pubkey+privkey";
    public static String KeyReverseEnggEqn = "KCE-RevEnggPubKey";//KCE full form=KeyCombinationEqn
    public static String KeyCombinationEqnTCP = "privkey";//TCP Used Everywhere:StrongB
    //public static String KeyCombinationEqnTCP = "pubkey+privkey";//TCP Used Everywhere:StrongA

    public TCPECCKeyPairGeneration MyTCCKeyPair = null;

    static int[] PatternBufferPrivate = new int[1002];
    static int[] PatternBufferPublic = new int[1002];
    static int[] PatternBufferSymmetric = new int[1002];

    public static int[] AnalysisBufferPrivate = new int[1002];
    public static int[] AnalysisBufferPublic = new int[1002];
    public static int[] AnalysisBufferSymmetric = new int[1002];
    private static Set<String> SecretKeyDatabasePrivate = new HashSet<String>();
    private static Set<String> SecretKeyDatabasePublic = new HashSet<String>();
    private static boolean SuppressCurses = true;
    private static Set<Integer> OATSTypeSet = new HashSet<Integer>();
    String[] OATSType2DigitPattern = {
        //DataArray:Header(Name):FirsttPat SecondPat 
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
        "7 10 ",//Row=69  Unique Row 
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
    String[] OATSType3DigitPattern = {
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
    String[] OATSType4DigitPattern = {
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
    };// Length = 1594-1223:371

    String[] OATSType5DigitPattern = {
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
    };// 2138-1599:539

    public void PrepareSets() {
        for (int i = 0; i < OATSType2DigitPattern.length; i++) {
            OATSTypeSet.add(Integer.parseInt(OATSType2DigitPattern[i].replaceAll(" ", "")));
        }
        for (int i = 0; i < OATSType3DigitPattern.length; i++) {
            OATSTypeSet.add(Integer.parseInt(OATSType3DigitPattern[i].replaceAll(" ", "")));
        }
        for (int i = 0; i < OATSType4DigitPattern.length; i++) {
            OATSTypeSet.add(Integer.parseInt(OATSType4DigitPattern[i].replaceAll(" ", "")));
        }
        for (int i = 0; i < OATSType5DigitPattern.length; i++) {
            OATSTypeSet.add(Integer.parseInt(OATSType5DigitPattern[i].replaceAll(" ", "")));
        }
    }

    public PSACKeyVaultNew(String Algo, long myPrivKy, long myPubKy) {
        PrivateKeyLength = myPrivKy;
        PublicKeyLength = myPubKy;
        UserTweaks_Entropy();
        PrimeNumber(10000);
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        String DiffWithRespTo = "Xn";
        if (Algo.equalsIgnoreCase("Decrypt")) {
            variablesDecrypt.put("x", PrivateKeyLength * 1.0);
            variablesDecrypt.put("y", PublicKeyLength * 1.0);
            LCGexpValue = parse(KeyLengthGenFormula, variablesDecrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);

            variablesDecrypt.put(DiffWithRespTo, LCGexpValue.eval());
            MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
            LCGexpValue1 = parse(NProductGenFormula, variablesDecrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            if (myPubKy == 100) {
                N = Double.parseDouble("1.0e" + (LCGexpValue1.eval().intValue()));
            } else if (LCGexpValue1.eval().intValue() < 306) {
                N = Double.parseDouble("1.0e" + (LCGexpValue1.eval().intValue()));
            } else {
                N = Double.parseDouble("1.0e306");
            }
            variablesEncrypt.put("N", N);
            variablesDecrypt.remove(DiffWithRespTo);
            variablesDecrypt.remove("y");
            variablesDecrypt.remove("x");
        } else if (Algo.equalsIgnoreCase("Encrypt")) {
            variablesEncrypt.put("x", PrivateKeyLength * 1.0);
            variablesEncrypt.put("y", PublicKeyLength * 1.0);
            LCGexpValue = parse(KeyLengthGenFormula, variablesEncrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);

            variablesEncrypt.put(DiffWithRespTo, LCGexpValue.eval());
            MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
            LCGexpValue1 = parse(NProductGenFormula, variablesEncrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            if (myPubKy == 100) {
                N = Double.parseDouble("1.0e" + (LCGexpValue1.eval().intValue()));
            } else if (LCGexpValue1.eval().intValue() < 306) {
                N = Double.parseDouble("1.0e" + (LCGexpValue1.eval().intValue()));
            } else {
                N = Double.parseDouble("1.0e306");
            }
            variablesEncrypt.put("N", N);
            variablesEncrypt.remove(DiffWithRespTo);
            variablesEncrypt.remove("y");
            variablesEncrypt.remove("x");
        }
    }

    public void init(String Algo, int mySeed, int mySeed1) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        this.PrivateKeyLength = myPrivKy;
        this.PublicKeyLength = myPubKy;
        if ((SenderReceiverGUI.Receiver.FirstTimeFlagKeys) && (OATSTypeSet.isEmpty())) {
            PrepareSets();
        } else if ((SenderReceiverGUI.Sender.FirstTimeFlagKeys) && (OATSTypeSet.isEmpty())) {
            PrepareSets();
        }
        String DiffWithRespTo = "Xn";
        if (Algo.equalsIgnoreCase("Decrypt")) {
            variablesDecrypt.put("x", mySeed * 1.0);
            LCGexpValue = parse(SeedGenFormula, variablesDecrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            UserResearchStudy.SeedSimple = LCGexpValue.eval().longValue();
            variablesDecrypt.put("x", mySeed1 * 1.0);
            MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
            LCGexpValue1 = parse(SeedGenFormula, variablesDecrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            UserResearchStudy.SeedDyDx = LCGexpValue1.eval().longValue();
            variablesDecrypt.remove("x");
        } else if (Algo.equalsIgnoreCase("Encrypt")) {
            variablesEncrypt.put("x", mySeed * 1.0);
            LCGexpValue = parse(SeedGenFormula, variablesEncrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            UserResearchStudy.SeedSimple = LCGexpValue.eval().longValue();
            variablesEncrypt.put("x", mySeed1 * 1.0);
            MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
            LCGexpValue1 = parse(SeedGenFormula, variablesEncrypt, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
            UserResearchStudy.SeedDyDx = LCGexpValue1.eval().longValue();
            variablesEncrypt.remove("x");
        }
        if ((OATSTypeSet.isEmpty())) {
            RandomNumber.RandomFactorialLCGDyDx.PerformPreComputeFlag = true;
            RandomNumber.RandomFactorialLCGDyDx.PerformSeedUnchangedFlag = true;
            RandomNumber.RandomSimpleLCG.PerformPreComputeFlag = true;
            RandomNumber.RandomSimpleLCG.PerformSeedUnchangedFlag = true;
        }
    }

    public void generateKeys(String Algo) {
        long OldState = Xn_LCGDyDx;
        if (RandomEngineResetFactFlag == false) {
            baseEquationFactorial = RandomFactorialLCGDyDx.precomputedEquationBase(a, c, b, "Xn_LCGDyDx", (int) MaxExponent);
            MyFactorial = new RandomFactorialLCGDyDx(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
            RandomEngineResetFactFlag = true;
        }
        boolean GoodKeyFlagPriv = false;

        for (int retry = 0; retry < 8; retry++) {
            this.privateKey = "";
            for (long i = 0; (i < this.PrivateKeyLength) && (this.privateKey.length() < this.PrivateKeyLength); i++) {
                Xn_LCGDyDx = MyFactorial.LCG_Factorial_RandomSimple(1, "Xn_LCGDyDx", Xn_LCGDyDx, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
                boolean GoodKeySetPrivate = false;
                GoodKeySetPrivate = OATSTypeSet.contains(Xn_LCGDyDx);

                if ((GoodKeySetPrivate == false) && ((this.privateKey.length() == PrivateKeyLength)
                        && (this.PrivateKeyLength == myPrivKy))) {
                    System.out.println("PSAKeyVaultNewGenerator:genPrivateKey:Good Pattern Generated:0");
                    GoodKeyFlagPriv = GoodKeySetPrivate;
                }
                if ((this.privateKey.length() == PrivateKeyLength)
                        && (this.PrivateKeyLength == myPrivKy)) {
                    break;
                } else if ((this.privateKey.length() > this.PrivateKeyLength)
                        && (this.PrivateKeyLength == myPrivKy)) {
                    this.privateKey = this.privateKey.substring(0, (int) (myPrivKy - 1));
                    break;
                }
                //MyFactorial.TestInfraSingle((int) i, Xn_LCGDyDx, "RNDXn_LCGDyDx", "_0006");
                //if(OldState != Xn_LCGDyDx){
                this.privateKey += (int) (Xn_LCGDyDx);
                OldState = Xn_LCGDyDx;
                //}
            }
            if ((GoodKeyFlagPriv == true) && ((this.privateKey.length() == PrivateKeyLength)
                    && (this.PrivateKeyLength == myPrivKy))) {
                System.out.println("PSAKeyVaultNewGenerator:genPrivateKey:Good Pattern Generated:0");
                break;
            }

            //if (GoodKeyFlagPriv == true) {
            GoodKeyFlagPriv = KeyDBSearchPrivate(this.privateKey, 0);
            //}
            if (GoodKeyFlagPriv == true) {
                break;
            } else {
                if ((retry == 0) || (retry == 6)) {
                    MyFactorial = new RandomFactorialLCGDyDx(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
                } else if (retry == 1) {
                    SeedDyDx++;
                    Xn_LCGDyDx++;
                } else if ((retry == 2) || (retry == 3) || (retry == 4) || (retry == 5)) {
                    int lowlevelentropy = 1367;//1;
                    a = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + a));
                    c = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + c));
                    b = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + b));
                    d = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + d));
                    ModulusEncrypt = GetPrimeNumber((int) (retry + (lowlevelentropy++) + ModulusEncrypt));
                    Xn_LCGDyDx = GetPrimeNumber((int) (retry + (lowlevelentropy++) + Xn_LCGDyDx));
                }
                System.out.println(ConsoleColors.RED + "PSAKeyVaultNewGenerator:genPrivateKey:Generated BAD Key:retry=" + retry + " Cause:DBSearch=" + KeyDBSearchPrivate(this.privateKey, 0) + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "PSAKeyVaultNewGenerator:genPrivateKey:a=" + a + " c=" + c + " b=" + b + " d=" + d + ConsoleColors.RESET);
            }
        }
        if ((this.PrivateKeyLength == myPrivKy) && (this.PrivateKeyLength > this.privateKey.length())) {
            this.privateKey = this.privateKey.substring(0, (int) myPrivKy);
            //System.out.println("genPrivateKey:length:<:PrivateKey="+PrivateKey);
            if (GoodKeyFlagPriv == true) {
                System.out.println(ConsoleColors.GREEN + "PSAKeyVaultNewGenerator:genPrivateKey:Good Key Generated:1" + ConsoleColors.RESET);
            }
        } else if ((this.PrivateKeyLength == myPrivKy) && (this.privateKey.length() > this.PrivateKeyLength)) {
            this.privateKey = this.privateKey.substring(0, (int) myPrivKy);
            //System.out.println("genPrivateKey:length:>:PrivateKey="+PrivateKey);
            if (GoodKeyFlagPriv == true) {
                System.out.println(ConsoleColors.GREEN + "PSAKeyVaultNewGenerator:genPrivateKey:Good Key Generated:2" + ConsoleColors.RESET);
            }
        } else if ((this.PrivateKeyLength == myPrivKy) && (this.privateKey.length() == this.PrivateKeyLength)) {
            //System.out.println("genPrivateKey:length:=:PrivateKey="+PrivateKey);
            if (GoodKeyFlagPriv == true) {
                System.out.println(ConsoleColors.GREEN + "PSAKeyVaultNewGenerator:genPrivateKey:Good Key Generated:3" + ConsoleColors.RESET);
            }
        } else {
            System.out.println("PSAKeyVaultNewGenerator:genPrivateKey:Error:PrivateKey=" + this.privateKey);
        }
        long OldStatePublic = 0;
        Pattern = "";
        if (RandomEngineResetValueFlag == false) {
            baseEquationLCG = RandomSimpleLCG.precomputedEquationBaseLCG(a, c, b, "Xn_LCG", (int) MaxExponent);
            MySimple = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
        }
        boolean GoodKeyFlagPublic = false;

        for (int retry = 0; retry < 8; retry++) {
            this.publicKey = "";
            for (long i = 0; (i < this.PublicKeyLength) && (this.publicKey.length() < this.PublicKeyLength); i++) {
                Xn_LCG = MySimple.LCG_Value_RandomSimple(0, "Xn_LCGx", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, 0);
                boolean GoodKeySetPublic = false;
                GoodKeySetPublic = OATSTypeSet.contains(Xn_LCG);
                if ((GoodKeySetPublic == false) && ((this.publicKey.length() == PublicKeyLength)
                        && (this.PublicKeyLength == myPubKy))) {
                    System.out.println("PSAKeyVaultNewGenerator:genPublicKey:Good Pattern Generated:0");
                }
                if ((this.publicKey.length() == PublicKeyLength)
                        && (this.PublicKeyLength == myPubKy)) {
                    break;
                } else if ((this.publicKey.length() > this.PublicKeyLength)
                        && (this.PublicKeyLength == myPubKy)) {
                    this.publicKey = this.publicKey.substring(0, (int) (myPubKy - 1));
                    break;
                }
                //if(OldState != Xn_LCGDyDx){
                this.publicKey += (int) (Xn_LCG);
                OldState = Xn_LCG;
                //}
            }
            //if (GoodKeyFlagPublic == true) {
            GoodKeyFlagPublic = KeyDBSearchPublic(this.publicKey, 0);
            //}
            if (GoodKeyFlagPublic == true) {
                break;
            } else {
                if ((retry == 0) || (retry == 6)) {
                    MySimple = new RandomSimpleLCG(0, NoOfSlots, ModulusEncrypt, Xn_LCG, a, c, b, MaxExponent);
                } else if (retry == 1) {
                    SeedSimple++;
                    Xn_LCG++;
                } else if ((retry == 2) || (retry == 3) || (retry == 4) || (retry == 5)) {
                    int lowlevelentropy = 1223;//1;
                    a = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + a));
                    c = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + c));
                    b = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + b));
                    d = GetPrimeNumber((int) (10 * retry + (lowlevelentropy++) + d));
                    ModulusEncrypt = GetPrimeNumber((int) (retry + (lowlevelentropy++) + ModulusEncrypt));
                    Xn_LCG = GetPrimeNumber((int) (retry + (lowlevelentropy++) + Xn_LCG));
                }
                System.out.println(ConsoleColors.RED + "PSAKeyVaultNewGenerator:genpublicKey:Generated BAD Key:retry=" + retry + " Cause:DBSearch=" + KeyDBSearchPublic(this.publicKey, 0) + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "PSAKeyVaultNewGenerator:genpublicKey:a=" + a + " c=" + c + " b=" + b + " d=" + d + ConsoleColors.RESET);
            }
        }
        if ((this.PublicKeyLength == myPubKy) && (this.PublicKeyLength > this.publicKey.length())) {
            this.publicKey = this.publicKey.substring(0, (int) myPubKy);
            //System.out.println("genPrivateKey:length:<:PrivateKey="+PrivateKey);
            if (GoodKeyFlagPriv == true) {
                System.out.println(ConsoleColors.GREEN + "PSAKeyVaultNewGenerator:genPublicKey:Good Key Generated:1" + ConsoleColors.RESET);
            }
        } else if ((this.PublicKeyLength == myPubKy) && (this.publicKey.length() > this.PublicKeyLength)) {
            this.publicKey = this.publicKey.substring(0, (int) myPubKy);
            //System.out.println("genPrivateKey:length:>:PrivateKey="+PrivateKey);
            if (GoodKeyFlagPriv == true) {
                System.out.println(ConsoleColors.GREEN + "PSAKeyVaultNewGenerator:genPublicKey:Good Key Generated:2" + ConsoleColors.RESET);
            }
        } else if ((this.PublicKeyLength == myPubKy) && (this.publicKey.length() == this.PublicKeyLength)) {
            //System.out.println("genPrivateKey:length:=:PrivateKey="+PrivateKey);
            if (GoodKeyFlagPriv == true) {
                System.out.println(ConsoleColors.GREEN + "PSAKeyVaultNewGenerator:genPublicKey:Good Key Generated:3" + ConsoleColors.RESET);
            }
        } else {
            System.out.println("PSAKeyVaultNewGenerator:genPublicKey:Error:PrivateKey=" + this.publicKey);
        }
        if (Algo.equalsIgnoreCase("Decrypt")) {
            variablesDecrypt.put("pubkey", (double) Double.parseDouble(publicKey));
            variablesDecrypt.put("privkey", (double) Double.parseDouble(privateKey));
        } else if (Algo.equalsIgnoreCase("Encrypt")) {
            variablesEncrypt.put("pubkey", (double) Double.parseDouble(publicKey));
            variablesEncrypt.put("privkey", (double) Double.parseDouble(privateKey));
        }
    }

    // Populate PSA variables when returning public key
    public String getPublicKey(String Algo) {
        if (Algo.equalsIgnoreCase("Decrypt")) {
            if ((publicKey != null) && (!publicKey.equalsIgnoreCase(""))) {
                variablesDecrypt.put("pubkey", (double) Double.parseDouble(publicKey));
            }
            if ((privateKey != null) && (!privateKey.equalsIgnoreCase(""))) {
                variablesDecrypt.put("privkey", (double) Double.parseDouble(privateKey));
            }
        } else if (Algo.equalsIgnoreCase("Encrypt")) {
            if ((publicKey != null) && (!publicKey.equalsIgnoreCase(""))) {
                variablesEncrypt.put("pubkey", (double) Double.parseDouble(publicKey));
            }
            if ((privateKey != null) && (!privateKey.equalsIgnoreCase(""))) {
                variablesEncrypt.put("privkey", (double) Double.parseDouble(privateKey));
            }
        }
        return publicKey;
    }

    public String getPrivateKey(String Algo) {
        // Optionally also populate here
        if (Algo.equalsIgnoreCase("Decrypt")) {
            if ((publicKey != null) && (!publicKey.equalsIgnoreCase(""))) {
                variablesDecrypt.put("pubkey", (double) Double.parseDouble(publicKey));
            }
            if ((privateKey != null) && (!privateKey.equalsIgnoreCase(""))) {
                variablesDecrypt.put("privkey", (double) Double.parseDouble(privateKey));
            }
        } else if (Algo.equalsIgnoreCase("Encrypt")) {
            if ((publicKey != null) && (!publicKey.equalsIgnoreCase(""))) {
                variablesEncrypt.put("pubkey", (double) Double.parseDouble(publicKey));
            }
            if ((privateKey != null) && (!privateKey.equalsIgnoreCase(""))) {
                variablesEncrypt.put("privkey", (double) Double.parseDouble(privateKey));
            }
        }
        return privateKey;
    }

    public Double getN(String Algo) {
        // Optionally also populate here
        if (Algo.equalsIgnoreCase("Decrypt")) {
            variablesDecrypt.put("N", (double) N);
        } else if (Algo.equalsIgnoreCase("Encrypt")) {
            variablesEncrypt.put("N", N);
        }
        return N;
    }

    public boolean NoKeyPatternTestPrivate(String Pattern) {
        boolean statusflag = false;
        int indexDigit = -1;
        if (!Pattern.equalsIgnoreCase("")) {
            indexDigit = Integer.parseInt(Pattern);
        }

        // Private Key
        String[] DataTemp = this.privateKey.split(Pattern, (int) PrivateKeyLength);
        if (DataTemp.length > 1) {
            PatternBufferPrivate[indexDigit] = DataTemp.length;
        } else {
            statusflag = true;
        }
        PatternBufferPrivate[1001] = this.privateKey.length();
        return statusflag;
    }

    public boolean NoKeyPatternTestPublic(String Pattern) {
        boolean statusflag = false;
        int indexDigit = -1;
        if (!Pattern.equalsIgnoreCase("")) {
            indexDigit = Integer.parseInt(Pattern);
        }
        // Private Key
        String[] DataTemp = this.publicKey.split(Pattern, (int) PublicKeyLength);
        if (DataTemp.length > 1) {
            PatternBufferPublic[indexDigit] = DataTemp.length;
        } else {
            statusflag = true;
        }
        PatternBufferPublic[1001] = this.publicKey.length();
        return statusflag;
    }

    private static boolean KeyDBSearchPrivate(String Key, int retry) {
        if ((retry == 0) && (SecretKeyDatabasePrivate.isEmpty())) {
            SecretKeyDatabasePrivate.add(Key);
            return true;
        } else {
            return SecretKeyDatabasePrivate.add(Key);
        }
    }

    private static boolean KeyDBSearchPublic(String Key, int retry) {
        if ((retry == 0) && (SecretKeyDatabasePublic.isEmpty())) {
            SecretKeyDatabasePublic.add(Key);
            return true;
        } else {
            return SecretKeyDatabasePublic.add(Key);
        }
    }
}
