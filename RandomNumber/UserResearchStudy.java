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
package RandomNumber;

import Calculus.ConsoleColors;
import Calculus.MathsContxtLAv;
import Calculus.MathsExpressionParser;
import static Calculus.DiffrIntegrSep.MyFuncDiff;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.MathsExpressionParser.eatAll;
import static Calculus.MathsExpressionParser.parse;
import Calculus.RuleAnalytics;
import static Calculus.UsageCalculus.ruleAnalytics;
import static RandomNumber.RandomNumber.DetectPattern;
import static RandomNumber.RandomNumber.GuessNextIthBit;
import static RandomNumber.RandomNumber.PrintOutStats;
import static RandomNumber.RandomNumber.ReadFromFile;
import static RandomNumber.RandomNumber.Stats;
import static RandomNumber.RandomNumber.WriteToFile;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class UserResearchStudy {

    public static Logger log = Logger.getLogger(UserResearchStudy.class.getName());
    public static boolean DebugFlag = true;
    public static boolean MonoBitTestFlag = true;
    public static boolean AntiCounterModeFlag = true;
    public static Map<String, String> functionsDiff = new HashMap<>();
    private static MathsExpressionParser.Expression RandStudyValue = (() -> 0.0);
    //Entropy Pool Parameters
    public static Rand_Pool[] EntPool = null;
    public static int EntPoolIndex = 5;
    public static int PoolIndexSeries = 6;

    public static String Path = "data\\";

    public static long SeedSimple = 41;
    public static long SeedDyDx = 29;
    public static long SeedXOR = 31;

    //Entropy Pool Parameters
    public static int PatternLength = 100;
    public static int[] PatternFreqMaxIndex = null;
    public static int[] PatternFreqMaxIndexSeries = null;

    public static LinkedList LCGPatternLastBits = new LinkedList();
    public static LinkedList LCGDyDxPatternLastBits = new LinkedList();
    public static long PatternRepLength = 500;
    //Counter Mode Parameters
    public static String[] ProbablePattern = new String[EntPoolIndex];

    // Performance Parameters
    public static boolean InitFlagRecordTime = false;
    public static boolean InitFlagXORRecordTime = false;
    public static boolean FactorialInitFlagRecordTime = false;
    public static boolean LowInitFlagRecordTime = false;
    public static boolean LowInitFlagXORRecordTime = false;
    public static boolean LowFactorialInitFlagRecordTime = false;
    public static String ReadExpireStr = "Number";//Number,FactorNumberOfBits,Linear
    public static long ReadExpireFactor = 3;
    public static long ReadExpireMax = 100;
    public static long ReadExpireNumber = 0;
    public static boolean ReadExpireFlag = false;
    public static boolean InitFlagBitRecordTime = false;

    public static double CompletionTime = 0.0;
    public static double CompletionTimeOverall = 0.0;

    //User Tweaks Begin
    public static long Xn_XOR = 1;//3;
    public static double Xn_Circular = 0;//3.0;
    public static double Radius = 0;//5.0;
    public static int NumberOfStates = 2;//17;
    public static long Xn_LCG = 0;//3;
    public static long Xn_LCGDyDx = 0;//5;
    public static long Xn_LCG3 = 0;//7;
    public static long Xn_LCGDyDx4 = 0;//11;
    public static long Xn_Series0 = 0;
    public static long Xn_Series1 = 0;
    public static long Xn_Series2 = 0;
    public static long Xn_Series3 = 0;
    public static long Xn_Series4 = 0;
    public static long Xn_Series5 = 0;

    // Memory States
    public static long Xn_LCGXn = 0;//3;
    public static long Xn_LCGDyDxXn = 0;//5;
    public static long Xn_LCG3Xn = 0;//7;
    public static long Xn_LCGDyDx4Xn = 0;//11;

    // Equation Coefficients
    public static long Modulus = 7;//128;
    public static long NoOfBits = 500;
    public static long NoOfSlots = 5;
    public static long NoOfBuffBitsMax = 500;//Modulus;
    //Equation Common Parameters Below
    public static long MaxExponent = 23;
    public static long ModulusEncrypt = 7;//7;
    public static long a = 43;//0;//43;
    public static long c = 47;//0;//47;
    public static long b = 53;//0;//53;
    public static long d = 59;//0;//59;
    public static long MonoBitZeroLCG = 0;
    public static long MonoBitOneLCG = 0;
    ;
    public static long MonoBitZeroLCGDyDx = 0;
    public static long MonoBitOneLCGDyDx = 0;
    public static String StudyType = "";
    public static String RunNumber = "_0005";

    public static long Success = 0;
    public static long FailedMesg = 0;

//    public static Long[] ShannonEvenArray = new Long[10000];
//    public static int ShannonEvenLastIndex = 1;
//    public static int ShannonEvenIssuedLCGPrimeNumber = 1;
//
//    public static Long[] ShannonOddArray = new Long[10000];
//    public static int ShannonOddLastIndex = 1;
//    public static int ShannonOddIssuedLCGPrimeNumber = 1;
//
//    public static Long[] ShannonPrimeArray = new Long[10000];
//    public static int ShannonLastIndex = 1;
//    public static int ShannonIssuedLCGPrimeNumber = 1;
    // Number Mechanisms
    public static Long[] PrimeArray = new Long[10000];
    public static int LastIndex = 1;
    public static int IssuedLCGPrimeNumber = 1;

    public static Long[] EvenArray = new Long[10000];
    public static int EvenLastIndex = 1;
    public static int EvenIssuedLCGPrimeNumber = 1;

    public static Long[] OddArray = new Long[100000];
    public static int OddLastIndex = 1;
    public static int OddIssuedLCGPrimeNumber = 1;

    public static String RANDProdPerform = "Normal";//Valid Values are : Production :Normal
    public static LocalDateTime CurrentStart = null;
    public static long MyTimeTakenStart = 0;
    public static LocalDateTime CurrentStartBit = null;
    public static double MyTimeTakenStartBit = 0;

    public static void mymain(String[] args) {
        int xLocal = 0, mLocal = 0, cLocal = 0, opLocal = '+';
        ruleAnalytics = new RuleAnalytics();
        ruleAnalytics.Init();
        Map<String, Double> variables = new HashMap<>();
        MyFuncExpress();
        MyFuncDiff();
        MyFuncSimple();
        UserTweaks();

        PrimeNumber(10000);
        EvenNumber(10000);
        OddNumber(10000);
        int j = 0;
        for (; (j < 61)&& (j < 3); j++) {
            InitFlagBitRecordTime = false;
            // Overrides UserTweaks Settings for Modulus and ModulusEncrypt
            TestSuiteModANDModEncrypt(j);
            IssuedLCGPrimeNumber = 1;
            EvenIssuedLCGPrimeNumber = 1;
            OddIssuedLCGPrimeNumber = 1;
            PatternFreqMaxIndex = new int[(int) (EntPoolIndex)];
            PatternFreqMaxIndexSeries = new int[(int) (PoolIndexSeries)];
            {
                LocalDateTime current = LocalDateTime.now();
                System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
                CurrentStart = current;
            }
            if (ReadExpireStr.equalsIgnoreCase("Number")) {
                ReadExpireMax = ReadExpireMax;
            } else if (ReadExpireStr.equalsIgnoreCase("FactorNumberOfBits")) {
                ReadExpireMax = NoOfBits / ReadExpireFactor;
            } else if (ReadExpireStr.equalsIgnoreCase("Linear")) {
                ReadExpireMax = ReadExpireMax + NoOfBits / ReadExpireFactor;
            }
            //Init Parameters
            PatternLength = (int) NoOfSlots;
            //MySimple && Factorial Objects
            EntPool = new Rand_Pool[EntPoolIndex + PoolIndexSeries];
            EntPool[0] = new Rand_Pool("RandomSimpleLCG", 0, (int) NoOfSlots, ModulusEncrypt, Xn_LCG, Xn_LCGDyDx, a, c, b, MaxExponent);
            EntPool[1] = new Rand_Pool("RandomFactorialLCGDyDx", 1, (int) NoOfSlots, ModulusEncrypt, Xn_LCG, Xn_LCGDyDx, a, c, b, MaxExponent);
            EntPool[2] = new Rand_Pool("RandomSimpleLCG", 2, (int) NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a /*+ 2*/, c /*+ 4*/, b /*+ 6*/, MaxExponent);
            EntPool[3] = new Rand_Pool("RandomFactorialLCGDyDx", 3, (int) NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a/* + 1*/, c/* + 3*/, b/* + 7*/, MaxExponent);
            //XOR Object
            EntPool[4] = new Rand_Pool("XORRandom", 4, (int) NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a + 1, c/* + 3*/, b/* + 7*/, MaxExponent);
//        //Series Objects
//        EntPool[5] = new Rand_Pool("Series", 5, NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a /* + 1*/, c/* + 3*/, b /* + 7*/, MaxExponent);
//        EntPool[6] = new Rand_Pool("Series", 6, NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a/* + 1*/, c /* + 3*/, b /* + 7*/, MaxExponent);
//        EntPool[7] = new Rand_Pool("Series", 7, NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a /* + 1*/, c/* + 3*/, b /* + 7*/, MaxExponent);
//        EntPool[8] = new Rand_Pool("Series", 8, NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a /* + 1*/, c /* + 3*/, b/* + 7*/, MaxExponent);
//        EntPool[9] = new Rand_Pool("Series", 9, NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a /* + 1*/, c/* + 3*/, b /* + 7*/, MaxExponent);
//        EntPool[10] = new Rand_Pool("Series", 10, NoOfSlots, ModulusEncrypt, Xn_LCG3, Xn_LCGDyDx4, a /* + 1*/, c/* + 3*/, b/* + 7*/, MaxExponent);
            System.out.println("main:RunNumber=" + RunNumber + " Xn_XOR=" + Xn_XOR + " Xn_LCG=" + Xn_LCG + " Xn_LCGDyDx=" + Xn_LCGDyDx + " Xn_LCG3=" + Xn_LCG3 + " Xn_LCGDyDx4=" + Xn_LCGDyDx4);
            System.out.println("main:NoOfBits=" + NoOfBits + " NoOfSlots=" + NoOfSlots + " NoOfBuffBitsMax=" + NoOfBuffBitsMax + " Modulus=" + Modulus + " PatternRepLength=" + PatternRepLength);
            System.out.println("main:FileRead/Write Parameters:ReadExpireNumber=" + ReadExpireNumber + " ReadExpireMax=" + ReadExpireMax + " ReadExpireFactor=" + ReadExpireFactor + " ReadExpireStr=" + ReadExpireStr);
            System.out.println("main:Low Level Performance Parameters:MaxExponent=" + MaxExponent + " ModulusEncrypt=" + ModulusEncrypt);
            System.out.println("main:Low Level Performance Parameters:a=" + a + " c=" + c + " b=" + b + " d=" + d + " SeedSimple=" + SeedSimple + " SeedDyDx=" + SeedDyDx);
            System.out.println("main:Low Level Uniqueness Parameters:LCG:ConfuseValue=" + EntPool[0].MySimple.ConfuseValue + " DiffusionValue=" + EntPool[0].MySimple.DiffusionValue + " SupportValue=" + EntPool[0].MySimple.SupportValue + " SurprisalValue=" + EntPool[0].MySimple.SurprisalValue);
            System.out.println("main:Low Level Uniqueness Parameters:LCGDyDx:ConfuseFactorial=" + EntPool[1].MyFactorial.ConfuseFactorial + " DiffusionFactorial=" + EntPool[1].MyFactorial.DiffusionFactorial + " SupportFactorial=" + EntPool[1].MyFactorial.SupportFactorial + " SurprisalFactorial=" + EntPool[1].MyFactorial.SurprisalFactorial);
            String Exprn = "";

            for (int i = 0; i < NoOfBits &&(i < 30); i++) {
                if ((i == 1) && (InitFlagBitRecordTime == false)) {
                    LocalDateTime current = LocalDateTime.now();
                    System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
                    CurrentStartBit = current;
                }
                Xn_LCGXn = Xn_LCG;
                Xn_LCGDyDxXn = Xn_LCGDyDx;
                Xn_LCG3Xn = Xn_LCG3;
                Xn_LCGDyDx4Xn = Xn_LCGDyDx4;

                Xn_LCG = EntPool[0].MySimple.LCG_Value_RandomSimple(0, "Xn_LCG", Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, i);
                Xn_LCGDyDx = EntPool[1].MyFactorial.LCG_Factorial_RandomSimple(1, "Xn_LCGDyDx", Xn_LCGDyDx, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, i);
                Xn_LCG3 = EntPool[2].MySimple.LCG_Value_RandomSimple(2, "Xn_LCG3", Xn_LCG3, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, i);
                Xn_LCGDyDx4 = EntPool[3].MyFactorial.LCG_Factorial_RandomSimple(3, "Xn_LCGDyDx4", Xn_LCGDyDx4, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt, i);
                //Xn_XOR = EntPool[4].MyXOR.LCG_XOR_Random(Xn_XOR, (int) a, (int) c, (int) b, (int) d, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt);
                StudyComputerEntropy(i);
                //StudyRandomValues(i);
                //StudyRandomVariables(i);
                //StudyLogicValues(i);
                //StudyXORLogicValues(i);
                //StudyRandomLinearEqns(i);
                //StudyRandomSecurity(i);
                if ((Xn_XOR == 0) || (Xn_XOR < 1)) {
                    Xn_XOR = 1;
                }
                if (Xn_LCG == 0) {
                    //Xn_LCG = 1;
                    if (MonoBitTestFlag == true) {
                        MonoBitZeroLCG++;
                    }
                } else if (Xn_LCG < 1) {
                    System.out.println("main:Negative Number:Before:Xn_LCG=" + Xn_LCG);
                    //Xn_LCG = -Xn_LCG;
                    System.out.println("main:Negative Number:After:Xn_LCG=" + Xn_LCG);
                } else if (Xn_LCG == 1) {
                    if (MonoBitTestFlag == true) {
                        MonoBitOneLCG++;
                    }
                }
                if (Xn_LCG3 == 0) {
                    //Xn_LCG3 = 1;
                } else if (Xn_LCG3 < 1) {
                    System.out.println("main:Negative Number:Before:Xn_LCG3=" + Xn_LCG3);
                    //Xn_LCG3 = -Xn_LCG;
                    System.out.println("main:Negative Number:After:Xn_LCG3=" + Xn_LCG3);
                }
                if ((Xn_LCGDyDx == 0) || (Xn_LCGDyDx < 1)) {
                    //Xn_LCGDyDx = 1;
                    if (MonoBitTestFlag == true) {
                        MonoBitZeroLCGDyDx++;
                    }
                } else if (Xn_LCGDyDx == 1) {
                    if (MonoBitTestFlag == true) {
                        MonoBitOneLCGDyDx++;
                    }
                }
                if ((Xn_LCGDyDx4 == 0) || (Xn_LCGDyDx4 < 1)) {
                    // Xn_LCGDyDx4 = 1;
                }
//                if (Xn_Series0 == 0) {
//                    //Xn_Series0 = 1;
//                } else if (Xn_Series0 < 1) {
//                    //System.out.println("main:Negative Number:Before:Xn_Series0=" + Xn_Series0);
//                    //Xn_Series0 = -Xn_Series0;
//                    //System.out.println("main:Negative Number:After:Xn_Series0=" + Xn_Series0);
//                }
//                if (Xn_Series1 == 0) {
//                    //Xn_Series1 = 1;
//                } else if (Xn_Series1 < 1) {
//                    //System.out.println("main:Negative Number:Before:Xn_Series1=" + Xn_Series1);
//                    //Xn_Series1 = -Xn_Series1;
//                    //System.out.println("main:Negative Number:After:Xn_Series1=" + Xn_Series1);
//                }
//                if (Xn_Series2 == 0) {
//                    //Xn_Series2 = 1;
//                } else if (Xn_Series2 < 1) {
//                    //System.out.println("main:Negative Number:Before:Xn_Series2=" + Xn_Series2);
//                    //Xn_Series2 = -Xn_Series2;
//                    //System.out.println("main:Negative Number:After:Xn_Series2=" + Xn_Series2);
//                }
//                if (Xn_Series3 == 0) {
//                    //Xn_Series3 = 1;
//                } else if (Xn_Series3 < 1) {
//                    //System.out.println("main:Negative Number:Before:Xn_Series3=" + Xn_Series3);
//                    //Xn_Series3 = -Xn_Series3;
//                    //System.out.println("main:Negative Number:After:Xn_Series3=" + Xn_Series3);
//                }
//                //Not Sure why Guess% goes to 100 %
//                //when below lines are commented
//                xLocal = (int) Xn_LCG;
//                mLocal = (int) Xn_LCGDyDx;
//                cLocal = (int) Xn_LCG3;
//                opLocal = (int) Xn_Series0 % 2;
//                if (opLocal == 0) {
//                    opLocal = '+';
//                } else {
//                    opLocal = '-';
//                }
//                Exprn = "mLocal*xLocal" + (char) opLocal + "cLocal";
//                Exprn = eatAll(Exprn, ' ');
//                variables.put("xLocal", ((double) xLocal));
//                variables.put("mLocal", ((double) mLocal));
//                variables.put("cLocal", ((double) cLocal));
//                if (i == 0) {
//                    RandStudyValue = parse(Exprn, variables, DiffWithRespTo, "Silent", MathsContxtLAv.LogLevel.Off);
//                }
//                Xn_Series4 = (long) ((RandStudyValue.eval()) % (Modulus));
//                //LowLevelPrintOut(i,StudyType);
//                if (Xn_Series4 == 0) {
//                    //Xn_Series4 = 1;
//                } else if (Xn_Series4 < 1) {
//                    //System.out.println("main:Negative Number:Before:Xn_Series4=" + Xn_Series4);
//                    //Xn_Series4 = -Xn_Series4;
//                    //System.out.println("main:Negative Number:After:Xn_Series4=" + Xn_Series4);
//                }
//                Xn_Series5 = (long) Xn_Circular;
                //WriteToFileXOR(i, Xn_XOR, NoOfBuffBitsMax, RunNumber);
                //WriteToFileXORCircular(i, (long) Xn_Circular, NoOfBuffBitsMax, RunNumber);
                WriteToFile(j, i, Xn_LCG, Xn_LCGDyDx, Xn_LCG3, Xn_LCGDyDx4, NoOfBuffBitsMax, RunNumber);
                int k=0;
                double[] entropyValues= new double[8];
                entropyValues[k++]=i;
                entropyValues[k++]=j;
                entropyValues[k++]=Xn_LCG;
                //writeBinaryEntropy("data\\" , "Xn_LCGentropy", entropyValues);
                
                entropyValues[k]=Xn_LCGDyDx;
                //writeBinaryEntropy("data\\" , "Xn_LCGDyDxentropy", entropyValues);
                entropyValues[k]=Xn_LCG3;
                //writeBinaryEntropy("data\\" , "Xn_LCG3entropy", entropyValues);
                entropyValues[k]=Xn_LCGDyDx4;
                //writeBinaryEntropy("data\\" , "Xn_LCGDyDx4entropy", entropyValues);
                //entropyValues[++k]=NoOfBuffBitsMax;
                //entropyValues[++k]=Double.parseDouble(RunNumber.replaceFirst("_", ""));
                //WriteToFileSeries(i, Xn_Series0, Xn_Series1, Xn_Series2, Xn_Series3, Xn_Series4, Xn_Series5, NoOfBuffBitsMax, RunNumber);
                Stats(0, Xn_LCG, Xn_LCGDyDx, Xn_LCG3, Xn_LCGDyDx4, Xn_XOR);
                //SeriesStats(0, NoOfSlots, Xn_Series0, Xn_Series1, Xn_Series2, Xn_Series3, Xn_Series4, Xn_Series5);
                ReadFromFile(j, 0, NoOfBuffBitsMax, Xn_LCG, Xn_LCGDyDx, Xn_LCG3, Xn_LCGDyDx4, Xn_XOR, RunNumber);
                //ReadFromFileSeries(0, NoOfBuffBitsMax, Xn_Series0, Xn_Series1, Xn_Series2, Xn_Series3, Xn_Series4, Xn_Series5, RunNumber);
                DetectPattern(0, NoOfSlots, Xn_LCG, Xn_LCGDyDx, Xn_LCG3, Xn_LCGDyDx4, Xn_XOR, i);
                //DetectSeriesPattern(0, NoOfSlots, Xn_Series0, Xn_Series1, Xn_Series2, Xn_Series3, Xn_Series4, Xn_Series5);
                GuessNextIthBit(0, i, Xn_LCG, Xn_LCGDyDx, Xn_LCG3, Xn_LCGDyDx4, Xn_XOR);
                //GuessNextIthBitSeries(0, i, Xn_Series0, Xn_Series1, Xn_Series2, Xn_Series3, Xn_Series4, Xn_Series5);
                //System.out.println("main:Xn_XOR=" + Xn_XOR + " Xn_LCG=" + Xn_LCG + " Xn_LCGDyDx=" + Xn_LCGDyDx + " Xn_LCG3=" + Xn_LCG3 + " Xn_LCGDyDx4=" + Xn_LCGDyDx4);
                if ((i == 1) && (InitFlagBitRecordTime == false)){
                    LocalDateTime currentEnd = LocalDateTime.now();
                    System.out.println("Run Completed Time:" + currentEnd + " " + " RunNumber=" + RunNumber);
                    System.out.println("Time Taken=:" + (CurrentStartBit + "- End Time:" + currentEnd) + " " + " RunNumber=" + RunNumber);
                    String[] TimeTakenStart = CurrentStartBit.toString().split(":");
                    if (TimeTakenStart.length >= 2) {
                        MyTimeTakenStartBit =  Double.parseDouble(TimeTakenStart[2]) + (Integer.parseInt(TimeTakenStart[1]) * 60);
                    } else {
                        MyTimeTakenStartBit =  Double.parseDouble(TimeTakenStart[1]);
                    }
                    String[] TimeTakenEnd = currentEnd.toString().split(":");
                    double MyTimeTakenEnd = 0.0;
                    if (TimeTakenEnd.length >= 2) {
                        MyTimeTakenEnd = Double.parseDouble(TimeTakenEnd[2]) + (Integer.parseInt(TimeTakenEnd[1]) * 60);
                    } else {
                        MyTimeTakenEnd = Double.parseDouble(TimeTakenEnd[1]);
                    }
                    double FinalTimeTaken = (MyTimeTakenEnd - MyTimeTakenStartBit);
                    String StrFinalTimeTaken = "";
                    if(FinalTimeTaken > 1)
                            StrFinalTimeTaken = "" + ((int) FinalTimeTaken / 60) + " mins and " + (((FinalTimeTaken))*1000) + " milliseconds.";
                    else
                            StrFinalTimeTaken = "" + ((int) FinalTimeTaken / 60) + " mins and " + "0 secs and " + (((FinalTimeTaken))*1000) + " milliseconds.";
                    System.out.println("main:Bit:TimeTaken:" + FinalTimeTaken + ":" + StrFinalTimeTaken);
                    InitFlagBitRecordTime=true;
                }
                LowLevelPrintOut(i, "StudyComputerEntropy");
            }
            PrintOutStats(0, NoOfSlots, NoOfBits);
            //PrintOutStatsSeriesValues( NoOfSlots, NoOfBits);
            //PrintOutStatsSeriesVariables(NoOfSlots, NoOfBits);
            //PrintOutStatsSeriesLogic(NoOfSlots, NoOfBits);
            //PrintOutStatsSeriesImplies(NoOfSlots, NoOfBits);
            //PrintOutStatsSeriesLinEqn(NoOfSlots, NoOfBits);
            System.out.println("main:Success=" + Success + " FailedMesg=" + FailedMesg + " NoOfBits=" + NoOfBits);
            {
                LocalDateTime currentEnd = LocalDateTime.now();
                System.out.println("Run Completed Time:" + currentEnd + " " + " RunNumber=" + RunNumber);
                System.out.println("Time Taken=:" + (CurrentStart + "- End Time:" + currentEnd) + " " + " RunNumber=" + RunNumber);
                String[] TimeTakenStart = CurrentStart.toString().split(":");
                if (TimeTakenStart.length >= 2) {
                    MyTimeTakenStart = (long) Double.parseDouble(TimeTakenStart[2]) + (Integer.parseInt(TimeTakenStart[1]) * 60);
                } else {
                    MyTimeTakenStart = (long) Double.parseDouble(TimeTakenStart[1]);
                }
                String[] TimeTakenEnd = currentEnd.toString().split(":");
                long MyTimeTakenEnd = 0;
                if (TimeTakenEnd.length >= 2) {
                    MyTimeTakenEnd = (long) Double.parseDouble(TimeTakenEnd[2]) + (Integer.parseInt(TimeTakenEnd[1]) * 60);
                } else {
                    MyTimeTakenEnd = (long) Double.parseDouble(TimeTakenEnd[1]);
                }
                long FinalTimeTaken = (MyTimeTakenEnd - MyTimeTakenStart);
                String StrFinalTimeTaken = "" + ((int) FinalTimeTaken / 60) + " mins and " + ((int) (FinalTimeTaken % 60)) + " seconds.";
                System.out.println("main:TimeTaken:" + FinalTimeTaken + ":" + StrFinalTimeTaken);
            }
            System.out.println("***************Test:" + j + ":End ************");
        }
    }

    public static void main(String... args) {
        mymain(args);
        //xmain(args);
    }

    static void xmain(String... args) {
        String All = "-1"; // Test Case Number : Options :All or a Single Number
        String StartMyTestCase = "-1";
        String MyEndTestCase = "-1";//Test Case Number : Options :All or a Single Number
        String RegrORIndivORLimit = "LimitedRegression";

        DOETest.TestHarnessDOE TestData = new DOETest.TestHarnessDOE(All, MyEndTestCase, RegrORIndivORLimit);
        DOETest.UsageDOE.mainRegresssionDOE(TestData);
    }

    static void UserTweaks() {
        DebugFlag = false;
        MonoBitTestFlag = true;
        AntiCounterModeFlag = true;
        Xn_XOR = 1;//1;
        Radius = 3.0;
        Xn_LCG = 3;//3;
        Xn_LCGDyDx = 5;//5;
        Xn_LCG3 = 7;//7;
        Xn_LCGDyDx4 = 11;//11;
        Modulus = 2;//2;//3;//4;//5;//5000;
        NoOfBits = 100;//500//100;
        NumberOfStates = (int) Modulus + 2;//170;//17;
        NoOfBuffBitsMax = 100;//Modulus;
        //Equation Common Parameters Below
        MaxExponent = 23;
        ModulusEncrypt = 2;//2;//3;//4;//5;//5000;//7;
        a = 3;//0;//3;
        c = 7;//0;//7;
        b = 3;//0;//3;
        d = 11;//0;//11;
        MonoBitZeroLCG = 0;
        MonoBitOneLCG = 0;
        MonoBitZeroLCGDyDx = 0;
        MonoBitOneLCGDyDx = 0;

        StudyType = "";

        // Seed Initialization
        SeedSimple = 41;
        SeedDyDx = 29;
        SeedXOR = 31;
        RANDProdPerform = "Production";
    }

    // Overrides UserTweaks Settings for Modulus and ModulusEncrypt
    static void TestSuiteModANDModEncrypt(int j) {
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Run Started Time:" + current + " RunNumber=" + RunNumber);
            CurrentStart = current;
        }
        if ((j >= 0) && (j < 65)) {
            System.out.println("***************Test:" + j + ":****************");
            UserTweaks();
            Modulus = j;
            ModulusEncrypt = j;
            NumberOfStates = (int) Modulus + 2;//170;//17;
            System.out.println("***************Test:Modulus=" + Modulus + ":ModulusEncrypt=" + ModulusEncrypt + ":Begin ************");
        }
    }

    static void StudyComputerEntropy(int i) {
        if (i == 0) {
            StudyType = "StudyComputerEntropy";
            System.out.println("***************StudyComputerEntropy************");
        }
        //Xn_Circular=XOR_SandCastle("main", (long) Xn_Circular, (long)Radius,  a,  c, b,  d,  Modulus, (i%NumberOfStates) );
        //Xn_Circular=XOR_ComputerEntropyValues("main", (long) Xn_Circular, (long)Radius,  a,  c, b,  d,  Modulus);
        //Xn_Circular=XOR_CircularRandom("main", (long) Xn_Circular, (long)Radius,  a,  c, b,  d,  Modulus);
        //Xn_Circular=XOR_CounterFlipFlop("main", (long) Xn_Circular, (long)Radius,  a,  c, b,  d,  Modulus);
        //Xn_Circular=XOR_ComputerEntropyJavaCalculus("main", (long) Xn_Circular, (long)Radius,  a,  c, b,  d,  Modulus);
    }

    static void StudyRandomValues(int i) {
        if (i == 0) {
            StudyType = "StudyRandomValues";
            System.out.println("***************StudyRandomValues************");
        }
        Xn_Series0 = (Xn_LCG + Xn_LCGDyDx) % (NoOfSlots);
        Xn_Series1 = (Xn_LCG - Xn_LCG3) % (NoOfSlots);
        Xn_Series2 = (Xn_LCGDyDx - Xn_LCGDyDx4) % (NoOfSlots);
        if (Xn_LCG > 64) {
            Xn_Series3 = (Xn_LCG3) % (NoOfSlots);
        } else {
            Xn_Series3 = 2;
        }
    }

    static void StudyRandomVariables(int i) {
        if (i == 0) {
            StudyType = "StudyRandomVariables";
            System.out.println("***************StudyRandomVariables************");
        }
        if (Xn_LCG > 64) {
            Xn_Series0 = (Xn_LCG3) % (NoOfSlots);
        } else {
            Xn_Series0 = 2;
        }
        if (Xn_LCG > 50) {
            Xn_Series1 = (5000) % (Xn_LCG);
        } else {
            Xn_Series1 = 2;
        }
        if (Xn_LCG > 50) {
            Xn_Series2 = (i) % (Xn_LCG);
        } else {
            Xn_Series2 = 2;
        }
    }

    static void StudyLogicValues(int i) {
        if (i == 0) {
            StudyType = "StudyLogicValues";
            System.out.println("***************StudyLogicValues************");
        }
        if (Xn_LCG > Xn_LCGDyDx) {
            Xn_Series0 = (Xn_LCG) % (NoOfSlots);
            //To Keep Dataflow Concepts intact
            Xn_Series1 = 0;
            Xn_Series2 = 0;
            Xn_Series3 = 0;
        } else if (Xn_LCG < Xn_LCGDyDx) {
            //To Keep Dataflow Concepts intact
            Xn_Series0 = 0;
            Xn_Series1 = (Xn_LCG) % (NoOfSlots);
            //To Keep Dataflow intact
            Xn_Series2 = 0;
            Xn_Series3 = 0;
        } else if (Xn_LCG == Xn_LCGDyDx) {
            //To Keep Dataflow Concepts intact
            Xn_Series0 = 0;
            Xn_Series1 = 0;
            Xn_Series2 = (Xn_LCG) % (NoOfSlots);
            Xn_Series3 = 0;
        }// Below CODE will never execute as Operator can be > or < or ==

    }

    static void StudyXORLogicValues(int i) {
        if (i == 0) {
            StudyType = "StudyXORLogicValues";
            System.out.println("***************StudyXORLogicValues************");
        }
        //P=(Xn_LCG > Xn_LCGDyDx)
        //Q=(Xn_LCG3 > Xn_LCGDyDx4)
        //p=> q= ((p^q)&&(p' v (OR) q')
        if (((Xn_LCG > Xn_LCGDyDx) && (Xn_LCG3 > Xn_LCGDyDx4))
                && ((!(Xn_LCG > Xn_LCGDyDx)) && (!(Xn_LCG3 > Xn_LCGDyDx4)))) {
            Xn_Series0 = (Xn_LCG) % (NoOfSlots);
            //To Keep Dataflow Concepts intact
            Xn_Series1 = 0;
            Xn_Series2 = 0;
        } // If NOT ((p=> q))
        else if (!(((Xn_LCG > Xn_LCGDyDx) && (Xn_LCG3 > Xn_LCGDyDx4))
                && ((!(Xn_LCG > Xn_LCGDyDx)) && (!(Xn_LCG3 > Xn_LCGDyDx4))))) {
            //To Keep Dataflow Concepts intact
            Xn_Series0 = 0;
            Xn_Series1 = (Xn_LCG) % (NoOfSlots);
            //To Keep Dataflow intact
            Xn_Series2 = 0;
        } else {
            //To Keep Dataflow Concepts intact
            Xn_Series0 = 0;
            Xn_Series1 = 0;
            Xn_Series2 = 0;
        }
    }

    static void StudyRandomLinearEqns(int i) {
        MathsExpressionParser.Expression RandStudyValue0 = (() -> 0.0);
        MathsExpressionParser.Expression RandStudyValue1 = (() -> 0.0);
        MathsExpressionParser.Expression RandStudyValue2 = (() -> 0.0);
        MathsExpressionParser.Expression RandStudyValue3 = (() -> 0.0);
        Map<String, Double> variables = new HashMap<>();
        String Exprn = "";
        if (i == 0) {
            StudyType = "StudyRandomLinearEquations";
            System.out.println("***************StudyRandomLinearEquations************");
        }
        Exprn = "i*Xn";
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Xn_LCG));
        variables.put("i", ((double) i));
        RandStudyValue0 = parse(Exprn, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
        Xn_Series0 = (long) ((RandStudyValue0.eval()) % (Modulus));

        Exprn = "i*Xn" + "+" + "c";
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Xn_LCG));
        variables.put("i", ((double) i));
        variables.put("c", ((double) c));
        RandStudyValue1 = parse(Exprn, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
        Xn_Series1 = (long) ((RandStudyValue1.eval()) % (Modulus));

        Exprn = "m*Xn";
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Xn_LCG));
        variables.put("m", ((double) Xn_LCGDyDx));
        RandStudyValue2 = parse(Exprn, variables, "Xn", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Xn_Series2 = (long) ((RandStudyValue2.eval()) % (Modulus));

        Exprn = "m*Xn" + "+" + "c";
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Xn_LCG));
        variables.put("m", ((double) 2.0));
        variables.put("c", ((double) c));
        RandStudyValue3 = parse(Exprn, variables, "Xn", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Xn_Series3 = (long) ((RandStudyValue3.eval()) % (Modulus));
    }

    static void StudyRandomSecurity(int i) {
        System.out.println("StudyRandomSecurity:");
        //SymmetricKey(i);
        //PKILin(i);
        PKINonLin(i);
    }

    static void SymmetricKey(int i) {
        MathsExpressionParser.Expression RandStudyValueEncryption = (() -> 0.0);
        MathsExpressionParser.Expression RandStudyValueDecryption = (() -> 0.0);
        Map<String, Double> variables = new HashMap<>();
        String EqnUnderTest = "m*Xn+c";
        String InverseEqnUnderTest = "(y-c)/m";
        int Mychar = 'a';
        String Exprn = EqnUnderTest;
        if (i == 0) {
            StudyType = "StudyRandomSecurity";
            System.out.println("***************StudyRandomLinearEquations************");
        }
        System.out.println("SymmetricKey:Symmetric");
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Mychar));
        variables.put("m", ((double) Xn_LCG));
        variables.put("c", ((double) c));
        RandStudyValueEncryption = parse(Exprn, variables, "Xn", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Double Value = (RandStudyValueEncryption.eval());
        System.out.println("SymmetricKey:Symmetric Key:Encryption:Value=" + Value + " Mychar=" + Mychar + " m=" + variables.get("m") + " Random Value=" + Xn_LCG);
        Xn_Series0 = (long) (Value % Modulus);

        Exprn = InverseEqnUnderTest;
        Exprn = eatAll(Exprn, ' ');
        variables.put("y", ((double) Value));
        variables.put("m", ((double) Xn_LCG));
        variables.put("c", ((double) c));
        RandStudyValueDecryption = parse(Exprn, variables, "y", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Value = (RandStudyValueDecryption.eval());
        System.out.println("SymmetricKey:Symmetric Key:Decryption:Value=" + Value + " Mychar=" + Mychar + " m=" + variables.get("m") + " Random Value=" + Xn_LCG);
        Xn_Series1 = (long) (Value % Modulus);
        if (Mychar == Value.intValue()) {
            System.out.println(ConsoleColors.GREEN + "SymmetricKey:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Value + ConsoleColors.RESET);
            Success++;
        } else {
            System.out.println(ConsoleColors.RED + "SymmetricKey:Information Loss:" + " Mychar=" + Mychar + " Value=" + Value + ConsoleColors.RESET);
            FailedMesg++;
        }
    }

    static void PKILin(int i) {
        MathsExpressionParser.Expression RandStudyValueEncryption = (() -> 0.0);
        MathsExpressionParser.Expression RandStudyValueDecryption = (() -> 0.0);
        Map<String, Double> variables = new HashMap<>();
        System.out.println("PKI:");
        String EqnUnderTest = "m*Xn+c";
        String InverseEqnUnderTest = "(y-c)/m";
        int Mychar = 'a';
        String Exprn = EqnUnderTest;
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Mychar));
        variables.put("m", ((double) Xn_LCG));
        variables.put("c", ((double) c));
        RandStudyValueEncryption = parse(Exprn, variables, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double Value = (RandStudyValueEncryption.eval());
        System.out.println("PKI:PKI Key:Encryption:Value=" + Value + " Mychar=" + Mychar + " m=" + variables.get("m") + " Random Value=" + Xn_LCG + " Xn=" + variables.get("Xn"));
        Xn_Series2 = (long) (Value % Modulus);

        Exprn = InverseEqnUnderTest;
        Exprn = eatAll(Exprn, ' ');
        variables.put("y", ((double) Value));
        variables.put("m", ((double) Xn_LCGDyDx));
        variables.put("c", ((double) c));
        RandStudyValueDecryption = parse(Exprn, variables, "y", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Value = (RandStudyValueDecryption.eval());
        System.out.println("PKI:PKI Key:Decryption:Value=" + Value + " Mychar=" + Mychar + " m=" + variables.get("m") + " Random Value=" + Xn_LCGDyDx + " y=" + variables.get("y"));
        Xn_Series3 = (long) (Value % Modulus);
        if (Mychar == Math.rint(Value)) {
            System.out.println(ConsoleColors.GREEN + "PKI:PKI Key:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Math.rint(Value) + ConsoleColors.RESET);
            Success++;
        } else {
            System.out.println(ConsoleColors.RED + "PKI:PKI Key:Information Loss:" + " Mychar=" + Mychar + " Value=" + Math.rint(Value) + ConsoleColors.RESET);
            FailedMesg++;
        }
    }

    static void PKINonLin(int i) {
        MathsExpressionParser.Expression RandStudyValueEncryption = (() -> 0.0);
        MathsExpressionParser.Expression RandStudyValueDecryption = (() -> 0.0);
        Map<String, Double> variables = new HashMap<>();
        System.out.println("PKI:");
        String EqnUnderTest = "m*Xn^5+c";
        String InverseEqnUnderTest = "((y-c)/m)^(1/5)";
        int Mychar = 'a';
        String Exprn = EqnUnderTest;
        Exprn = eatAll(Exprn, ' ');
        variables.put("Xn", ((double) Mychar));
        variables.put("m", ((double) Xn_LCG));
        variables.put("c", ((double) c));
        RandStudyValueEncryption = parse(Exprn, variables, "Xn", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Double Value = (RandStudyValueEncryption.eval());
        System.out.println("PKI:PKI Key:Encryption:Value=" + Value + " Mychar=" + Mychar + " m=" + variables.get("m") + " Random Value=" + Xn_LCG + " Xn=" + variables.get("Xn"));
        Xn_Series2 = (long) (Value % Modulus);

        Exprn = InverseEqnUnderTest;
        Exprn = eatAll(Exprn, ' ');
        variables.put("y", ((double) Value));
        variables.put("m", ((double) Xn_LCGDyDx));
        variables.put("c", ((double) c));
        RandStudyValueDecryption = parse(Exprn, variables, "y", false, "Silent", MathsExpressionParser.LogLevel.Off);
        Value = (RandStudyValueDecryption.eval());
        System.out.println("PKI:PKI Key:Decryption:Value=" + Value + " Mychar=" + Mychar + " m=" + variables.get("m") + " Random Value=" + Xn_LCGDyDx + " y=" + variables.get("y"));
        Xn_Series3 = (long) (Value % Modulus);
        if (Mychar == Math.rint(Value)) {
            System.out.println(ConsoleColors.GREEN + "PKI:PKI Key:Information Sucess:" + " Mychar=" + Mychar + " Value=" + Math.rint(Value) + ConsoleColors.RESET);
            Success++;
        } else {
            System.out.println(ConsoleColors.RED + "PKI:PKI Key:Information Loss:" + " Mychar=" + Mychar + " Value=" + Math.rint(Value) + ConsoleColors.RESET);
            FailedMesg++;
        }
    }

    static void LowLevelPrintOut(int i, String StudyType) {
        System.out.println("*******************************:" + StudyType + ": i=" + i + " Begin*******************************");
        System.out.println("main:Xn_XOR=" + Xn_XOR);
        System.out.println("main:Xn_Circular=" + Xn_Circular);
        System.out.println("main:Xn_LCG=" + Xn_LCG);
        System.out.println("main:Xn_LCGDyDx=" + Xn_LCGDyDx);
        System.out.println("main:Xn_LCG3=" + Xn_LCG3);
        System.out.println("main:Xn_LCGDyDx4=" + Xn_LCGDyDx4);
        System.out.println("main:Xn_Series0=" + Xn_Series0);
        System.out.println("main:Xn_Series1=" + Xn_Series1);
        System.out.println("main:Xn_Series2=" + Xn_Series2);
        System.out.println("main:Xn_Series3=" + Xn_Series3);
        System.out.println("main:Xn_Series4=" + Xn_Series4);
        System.out.println("main:Xn_Series5=" + Xn_Series5);
        System.out.println("*******************************:" + StudyType + ": i=" + i + " End*******************************");

    }

    /* ****************************************************************************** */
    //Function to generate Even and Prime Number just below MaxValue
    /* ****************************************************************************** */
    public static void PrimeNumber(long MaxValue) {
        long Prime = 0;
        long number = 1;
        PrimeArray = new Long[(int) MaxValue];
        PrimeArray[0] = (long) 2;
        int i = 0;
        for (number = 3; number < MaxValue; number += 2) {
            for (i = 0; i < LastIndex;) {
                if ((number % PrimeArray[i]) == 0) {
                    break;
                } else if (i > (6 * Math.sqrt(number))) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == LastIndex) {
                PrimeArray[LastIndex++] = number;
            }
        }
    }

    public static long NextPrimeNumber(long MaxValue) {
        long Prime = 0;
        if (IssuedLCGPrimeNumber < PrimeArray.length) {
            Prime = PrimeArray[IssuedLCGPrimeNumber];
            IssuedLCGPrimeNumber++;
        }
        return Prime;
    }

    public static long GetPrimeNumber(long MaxValue, int j) {
        long Prime = 0;
        for (int i = LastIndex - 1; (i >= 0); i--) {
            if (MaxValue <= PrimeArray[i]) {
                Prime = PrimeArray[i - 1];
            }
        }
        return Prime;
    }

    public static void EvenNumber(long MaxValue) {
        long Even = 0;
        long number = 1;
        EvenArray = new Long[(int) MaxValue];
        EvenArray[0] = (long) 2;
        int i = 0;
        for (number = 0; number < MaxValue; number += 2, i++) {
            if (i == EvenLastIndex) {
                EvenArray[EvenLastIndex++] = number;
            }
        }
    }

    public static long NextEvenNumber(long MaxValue) {
        long Prime = 0;
        if (EvenIssuedLCGPrimeNumber < EvenArray.length) {
            Prime = EvenArray[EvenIssuedLCGPrimeNumber];
            EvenIssuedLCGPrimeNumber++;
        }
        return Prime;
    }

    public static long OddNumber(long MaxValue) {
        long Odd = 0;
        long number = 1;
        OddArray[0] = (long) 2;
        int i = 0;
        for (number = 1; number < MaxValue; number += 2, i++) {
            if (i == OddLastIndex) {
                OddArray[OddLastIndex++] = number;
            }
        }
        Odd = OddArray[OddLastIndex - 1];
        return Odd;
    }

    public static long NextOddNumber(long MaxValue) {
        long Odd = 0;
        if (OddIssuedLCGPrimeNumber < OddArray.length) {
            Odd = OddArray[OddIssuedLCGPrimeNumber++];
        }
        return Odd;
    }

    /**
     * ****************************************************
     */
}
