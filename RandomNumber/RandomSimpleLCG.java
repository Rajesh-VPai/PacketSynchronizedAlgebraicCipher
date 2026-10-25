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

import Calculus.DiffrIntegrSep;
import static Calculus.DiffrIntegrSep.parseDiff;
import Calculus.MathsContxtLAv;
import Calculus.MathsExpressionParser;
import static Calculus.DiffrIntegrSep.MyFuncDiff;
import static Calculus.MathematicalTestHarness.GBLMyLogLevel;
import static Calculus.MathematicalTestHarness.GBLSilent;
import static Calculus.MathematicalTestHarness.HideInRecurseFlag;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.MathsContxtLAv.eatAll;
import static Calculus.MathsExpressionParser.parse;
import static Calculus.MathsContxtLAv.parseSimple;
import static RandomNumber.RandomFactorialLCGDyDx.InitEquationVar;
import static RandomNumber.ShannonRNGFrameWork.ComputeConfusion;
import static RandomNumber.ShannonRNGFrameWork.E;
import static RandomNumber.ShannonRNGFrameWork.K;
import static RandomNumber.ShannonRNGFrameWork.MaxExponentORTerms;
import static RandomNumber.ShannonRNGFrameWork.NumberOfFunctions;
import static RandomNumber.ShannonRNGFrameWork.NumberOfKeyParts;
import static RandomNumber.UserResearchStudy.AntiCounterModeFlag;
import static RandomNumber.UserResearchStudy.CompletionTime;
import static RandomNumber.UserResearchStudy.CompletionTimeOverall;
import static RandomNumber.UserResearchStudy.EntPool;
import static RandomNumber.UserResearchStudy.InitFlagRecordTime;
import static RandomNumber.UserResearchStudy.LCGPatternLastBits;
import static RandomNumber.UserResearchStudy.LowInitFlagRecordTime;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.MonoBitOneLCG;
import static RandomNumber.UserResearchStudy.MonoBitTestFlag;
import static RandomNumber.UserResearchStudy.MonoBitZeroLCG;
import static RandomNumber.UserResearchStudy.NextEvenNumber;
import static RandomNumber.UserResearchStudy.NoOfBits;
import static RandomNumber.UserResearchStudy.NoOfBuffBitsMax;
import static RandomNumber.UserResearchStudy.NoOfSlots;
import static RandomNumber.UserResearchStudy.NumberOfStates;
import static RandomNumber.UserResearchStudy.Path;
import static RandomNumber.UserResearchStudy.PatternFreqMaxIndex;
import static RandomNumber.UserResearchStudy.PatternLength;
import static RandomNumber.UserResearchStudy.PatternRepLength;
import static RandomNumber.UserResearchStudy.RANDProdPerform;
import static RandomNumber.UserResearchStudy.SeedSimple;
import static RandomNumber.UserResearchStudy.Xn_LCGXn;
import Shannon_Mapping.E_Mapping;
import Shannon_Mapping.K_Mapping;
import static Shannon_Mapping.ShannonHighLevelUsage.variables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.DoubleBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class RandomSimpleLCG {

    public static Logger log = Logger.getLogger(RandomSimpleLCG.class.getName());
    public static boolean LCGXnplus1Avail = false;

    //Theory & Source:Wiki Confusion and Diffusion
    public static long ConfuseValue = 1;//1;
    public static long DiffusionValue = 2;//2;
    public static long ConfuseFunction2Value = 1;//1;
    public static long DiffusionFunction2Value = 2;//2;
    //Theory & Source:Wiki Information Content
    public static long SupportValue = 3;//3;
    public static long SurprisalValue = 4;//4;

    private long LCGXValuemin = 0;
    private long LCGXValuemax = 0;
    private long LCGXValueInc = 0;

    private MathsContxtLAv.SimpleExpression LCGexpSimple = (() -> "");
    private MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
    private String LCGValueStatelessObjString = "";
    private String LCGValueStatelessObjNameStr = "";
    private boolean LCGexpValueObjExpire = false;
    private MathsExpressionParser.Expression LCGexpValue2 = (() -> 0.0);
    private boolean LCGexpValueObjExpire2 = false;
    private String LCGValueStatelessObjStringDiff2 = "";
    private String LCGValueStatelessObjNameStrDiff2 = "";
    private DiffrIntegrSep.DiffExpr LCGexp = (() -> "");
    private boolean LCGexpObjExpire = false;
    private String LCGValueStatelessObjStringDiff = "";
    private String LCGValueStatelessObjNameStrDiff = "";

    // Core Variables
    public String ExprnLCG = "";
    public String ConfuseExprnLCG = "";
    public String DiffusionExprnLCG = "";
    public String SupportExprnLCG = "";
    public String SurprisalExprnLCG = "";

    // I+1th Bit (NextIth Bit)
    //Theory & Source:Wiki next-bit Test
    public long NextIthLCGPatternRep = 0;
    public long NextIthLCGPattern = 0;
    public long NextIthLCGBuffer = 0;
    public long NextIthLCGPatRecog = 0;

    public long GuessLCG = 0;
    public long GuessLCGPatRecog = 0;
    public long GuessLCGRep = 0;
    public long GuessLCGPattern = 0;
    public long GuessLCGBuff = 0;

    //    LCG Pattern: 1 5 4 5 3 5 4 4 7 1 1 5 7 7 7 7 5 1 7 1 3 3 2 4 3 1 6 6 2 2 1 2 3 5   
    public static long[] LCGPattern = {1, 53, 48, 36, 71, 31, 122, 1, 5, 4, 5, 3, 5, 4, 4, 7, 1, 1, 5, 7, 7, 7, 7, 5, 1, 7, 1, 3, 3, 2, 4, 3, 1, 6, 6, 2, 2, 1, 2, 3, 5};
    public LinkedList LCGNextBitDataBuff = new LinkedList();

    public ArrayList<PatternBits> DataStoreLCG = null;

    // Stats Data Structures
    public double[] FreqStore = null;
    public double[][] FreqMaxStore = null;
    public double[] GaussianPDFStore = null;
    public double[] EntropyPDFStore = null;
    public double[] MeanSigma = null;
    // Number Mechanisms
    public double Mean = 0.0;
    public double Sigma = 0.0;

    // Read Write File Control Mechanism
    public String ReadExpireStr = "Number";//Number,FactorNumberOfBits,Linear
    public long ReadExpireFactor = 3;
    public long ReadExpireMax = 1000;
    public long ReadExpireNumber = 0;
    public boolean ReadExpireFlag = false;

    //InitValues for Documentation -Variables
    public static Map<String, String> InitValue = new HashMap<>();

    //Counter Mode Parameters
    public String[] ProbablePattern = new String[(int)NoOfSlots];
    public LinkedList<Long> LCGDataBuff = new LinkedList<>();
    public boolean InitProbablePatternFlag = false;
    public int PatternStartIndex = 10;
    public static Map<String, Double> variables = new HashMap<>();
    
    //Performance Variables
    public static String baseEquationLCG="";
    // Use ArrayDeque for fast push/pop and HashSet for O(1) lookup
    private ArrayDeque<Long> patternBuffer = new ArrayDeque<>();
    private HashSet<Long> patternSet = new HashSet<>();
    public static boolean PerformPreComputeFlag=true;
    public static boolean PerformSeedUnchangedFlag=true;

    public RandomSimpleLCG(int Index, long NoOfSlots, long ModulusEncrypt, long Xn_LCG, long a, long c, long b, long MaxExponent) {
        for(int i=0; i < NoOfSlots; i++)
            ProbablePattern[i] = "";
        variables = new HashMap<>();
        MaxExponent = MaxExponent + Index;
        if((baseEquationLCG.equalsIgnoreCase(""))&&(PerformPreComputeFlag==true) && ((a!=UserResearchStudy.a)&&(b!=UserResearchStudy.b)&&(c!=UserResearchStudy.c)&&(MaxExponent!=UserResearchStudy.MaxExponent)) &&(PerformSeedUnchangedFlag==true)){
            PerformanceFormEquation( Xn_LCG,  a,  c,  b, "Xn", (int)MaxExponent);
        }else if (((PerformPreComputeFlag)||(PerformSeedUnchangedFlag==true)) && (baseEquationLCG.equalsIgnoreCase("")) ){        
            ExprnLCG = FormEquationLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationLocal:a=" + a + " b=" + b + " c=" + c + " ExprnLCG=" + ExprnLCG);
        ConfuseExprnLCG = FormEquationSimpleLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSimpleLocal:ConfuseExprnLCG=" + ConfuseExprnLCG);
        DiffusionExprnLCG = FormEquationSimpleLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSimpleLocal:DiffusionExprnLCG=" + DiffusionExprnLCG);
        SupportExprnLCG = FormEquationSupportLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSupportLocal:SupportExprnLCG=" + SupportExprnLCG);
        SurprisalExprnLCG = FormEquationSurpriseLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSurpriseLocal:SurprisalExprnLCG=" + SurprisalExprnLCG);
        }
        //ConfuseValue = 4 + Index;
        //DiffusionValue = 5 + Index;
        //SupportValue = 13 + Index;
        //SurprisalValue = 31 + Index;
        DocumentInitValues(Index, NoOfSlots, ModulusEncrypt, Xn_LCG, Xn_LCGXn, a, c, b, MaxExponent);
        FreqStore = new double[(int) NumberOfStates];
        FreqMaxStore = new double[(int)NumberOfStates][2];
        GaussianPDFStore = new double[(int) NoOfSlots];
        EntropyPDFStore = new double[(int) NoOfSlots];
        MeanSigma = new double[3];
        for (int j = 0; j < NumberOfStates; j++) {
            FreqStore[j] = 0.0;
        }
        for (int j = 0; j < NoOfSlots; j++) {
            GaussianPDFStore[j] = 0.0;
            EntropyPDFStore[j] = 0.0;
        }
        for (int j = 0; j < 3; j++) {
            MeanSigma[j] = 0.0;
        }
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < NumberOfStates; k++) {
                FreqMaxStore[k][j] = 0.0;
            }
        }
        DataStoreLCG = null;
        DataStoreLCG = new ArrayList<RandomSimpleLCG.PatternBits>();
        for (int i = 0; i < NumberOfStates; i++) {
            DataStoreLCG.add(new PatternBits(i, 0));
        }
        if (ReadExpireStr.equalsIgnoreCase("Number")) {
            ReadExpireMax = ReadExpireMax;
        } else if (ReadExpireStr.equalsIgnoreCase("FactorNumberOfBits")) {
            ReadExpireMax = NoOfBits / ReadExpireFactor;
        } else if (ReadExpireStr.equalsIgnoreCase("Linear")) {
            ReadExpireMax = ReadExpireMax + NoOfBits / ReadExpireFactor;
        }
        InitFlagRecordTime = false;
        LowInitFlagRecordTime = false;
    }

    void DocumentInitValues(long Index, long NoOfSlots, long ModulusEncrypt, long Xn_LCG, long Xn_LCGXn, long a, long c, long b, long MaxExponent) {
        //Init Values
        InitValue.put("InitVal" + Index, "" + Xn_LCG);
        InitValue.put("a" + Index, "" + a);
        InitValue.put("c" + Index, "" + c);
        InitValue.put("b" + Index, "" + b);
        InitValue.put("ModulusEncrypt" + Index, "" + ModulusEncrypt);
        InitValue.put("MaxExponent" + Index, "" + MaxExponent);

        //Equations
        InitValue.put("Exprn" + Index, ExprnLCG);
        InitValue.put("ConfuseExprn" + Index, ConfuseExprnLCG);
        InitValue.put("DiffusionExprn" + Index, DiffusionExprnLCG);
        InitValue.put("SupportExprn" + Index, SupportExprnLCG);
        InitValue.put("SurprisalExprn" + Index, SurprisalExprnLCG);

        // Seed Values
        InitValue.put("ConfuseValue" + Index, "" + ConfuseValue);
        InitValue.put("DiffusionValue" + Index, "" + DiffusionValue);
        InitValue.put("SupportValue" + Index, "" + SupportValue);
        InitValue.put("SurprisalValue" + Index, "" + SurprisalValue);

    }

    void GetExprnMinMaxRange(long Xn, String DiffWithRespTo, long Modulus, int NoOfTimes) {
        this.LCGXValuemax = Modulus;
        if (Xn > 0) {
            this.LCGXValuemin = Xn;
        } else {
            this.LCGXValuemin = -Modulus;
        }
        if (Modulus > 0) {
            this.LCGXValueInc = NoOfTimes * 1 / Modulus;
        } else if ((Modulus != 0) && (this.LCGXValueInc == NoOfTimes * 1 / Modulus)) {
            this.LCGXValueInc = NoOfTimes * 1 / this.LCGXValuemax;
        } else {
            this.LCGXValueInc = 1;
        }
    }

    // Precompute static part once
public static String precomputedEquationBaseLCG(long MgtACoeff, long MgtbCoeff,long MgtcCoeff,String TechDiffWithRespTo, int MgtMaxExponent) {
    StringBuilder exprn = new StringBuilder();
    exprn.append(MgtACoeff).append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);

    for (int i = MgtMaxExponent - 1; i > 1; i--) {
        exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
        MgtbCoeff = NextEvenNumber(3 + 2 * (MgtMaxExponent - i)); // precompute odd increments
    }

    if (MgtbCoeff > 2) {
        exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
    } else {
        exprn.append(" + ").append(TechDiffWithRespTo);
    }

    return eatAll(exprn.toString(), ' ');
}

// Add current state only
static String FormEquationLocal(long Xn, long Mgtc, String baseEquation) {
    StringBuilder exprn = new StringBuilder(baseEquation);
    if ((Xn != 0) && (Mgtc != 0)) {
        exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
    } else {
        exprn.append(" + ").append(NextEvenNumber(1)).append(" + ").append(NextEvenNumber(1)) ;
    }
    return exprn.toString();
}
    public static String FormEquationLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
//        //if(Xn==0) MaxExponent=5;
//        //else MaxExponent=(int)Xn;
//        long bCoeffStore = MgtbCoeff;
//        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
//        StringBuilder Exprn = new StringBuilder("" + MgtACoeff);
//        Exprn.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
//        for (int i = MgtMaxExponent - 1; i > 1; i--) {
//            int j = 3;
//            if (MgtbCoeff > 2) {
//                Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
//            } else {
//                Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
//                //MgtbCoeff = bCoeffStore;
//            }
//            //MgtbCoeff++;
//            //MgtbCoeff=NextPrimeNumber(j);
//            MgtbCoeff = NextEvenNumber(j);
//            j += 2;
//            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
//        }
//        if (MgtbCoeff > 2) {
//            Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
//        } else {
//            Exprn.append(" + ").append(TechDiffWithRespTo);
//        }
//        Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        if ((Xn != 0) && (Mgtc != 0)) {
//            Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        } else {
//            Exprn.append(" + ").append(NextEvenNumber(1)).append(" + ").append(NextEvenNumber(1));
//        }
//        Exprn = new StringBuilder(eatAll(Exprn.toString(), ' '));
        //log.info("FormEquation:Exprn=" + Exprn);
        //System.out.println("FormEquationLocal:Exprn=" + Exprn);
        String Exprn=FormEquationLocal( Xn,  Mgtc, baseEquationLCG);
        return Exprn.toString();
    }

    static String FormEquationSimpleLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        StrBuild.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i >= 1; i--) {
            int j = 3;
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextEvenNumber(j);
            j += 2;
            //System.out.println("FormEquationSimpleLocal:Reached:i=" + i + " MgtbCoeff=" + MgtbCoeff);
        }
        if (MgtbCoeff > 2) {
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
        }
        if ((Xn != 0) && (Mgtc != 0)) {
            StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc);
        } else {
            StrBuild.append(" + ").append(NextEvenNumber(1)).append(" + ").append(NextEvenNumber(1));
        }
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSimpleLocal:Exprn=" + Exprn);
        return Exprn;
    }

    static String FormEquationSupportLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i >= 1; i--) {
            int j = 3;
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextEvenNumber(j);
            j += 2;
            //System.out.println("FormEquationSimpleLocal:Reached:i=" + i + " MgtbCoeff=" + MgtbCoeff);
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc).append(" * ").append(SeedSimple++);

        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSupportLocal:Exprn=" + Exprn);
        return Exprn;
    }

    static String FormEquationSurpriseLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextEvenNumber(j);
            j += 2;
            //System.out.println("FormEquationSimpleLocal:Reached:i=" + i + " MgtbCoeff=" + MgtbCoeff);
        }
        StrBuild.append("/").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc).append(" * ").append(SeedSimple++);

        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSurpriseLocal:Exprn=" + Exprn);
        return Exprn;
    }

    void UpdateStats(long Xn_LCG) {
        if ((NextIthLCGPatRecog == Xn_LCG)
                || (NextIthLCGPatternRep == Xn_LCG)
                || (NextIthLCGPattern == Xn_LCG)
                || (NextIthLCGBuffer == Xn_LCG)) {
            GuessLCG++;
            if (NextIthLCGPatRecog == Xn_LCG) {
                GuessLCGPatRecog++;
            }
            if (NextIthLCGPatternRep == Xn_LCG) {
                GuessLCGRep++;
            }
            if (NextIthLCGPattern == Xn_LCG) {
                GuessLCGPattern++;
            }
            if (NextIthLCGBuffer == Xn_LCG) {
                GuessLCGBuff++;
            }
        }
    }

    //Detect the Pattern
    void DetectLCGPattern(int EntIndex, long NoOfSlots, long Xn, int k) {
//        boolean LoopAssignFlag = false;
//        // Extract Freq Distribution Info from FreqStore
//        if ((PatternFreqMaxIndex[EntIndex] < PatternLength)
//                && (Xn >= 0)
//                &&( Xn < this.FreqStore.length)
//                && (PatternFreqMaxIndex[EntIndex] == 0)
//                && (this.FreqMaxStore[0][0] == 0) && (this.FreqMaxStore[0][1] == 0)) {
//            this.FreqMaxStore[0][0] = Xn;
//            this.FreqMaxStore[0][1] = this.FreqStore[(int) Xn];
//            PatternFreqMaxIndex[EntIndex]++;
//        } else if ((PatternFreqMaxIndex[EntIndex] < PatternLength)
//                && (PatternFreqMaxIndex[EntIndex] == 0)
//                && (Xn == EntPool[0].MySimple.FreqMaxStore[0][0])
//                && (this.FreqStore[(int) Xn] >= this.FreqMaxStore[0][1])) {
//            this.FreqMaxStore[0][0] = Xn;
//            this.FreqMaxStore[0][1] = this.FreqStore[(int) Xn];
//        } else if ((PatternFreqMaxIndex[EntIndex] < PatternLength)
//                && (PatternFreqMaxIndex[EntIndex] > 0)) {
//            for (int i = 0; (i < PatternLength) && (i < PatternFreqMaxIndex[EntIndex]); i++) {
//                if ((Xn == this.FreqMaxStore[i][0])) {
//                    this.FreqMaxStore[i][1] = this.FreqStore[(int) Xn];
//                    LoopAssignFlag = true;
//                }
//            }
//            if ((LoopAssignFlag == false) && (PatternFreqMaxIndex[EntIndex] < PatternLength)
//                    && (Xn >= 0) && (Xn < this.FreqStore.length)
//                    && (PatternFreqMaxIndex[EntIndex] > 0)
//                    && (this.FreqMaxStore[PatternFreqMaxIndex[EntIndex]][0] == 0)
//                    && (this.FreqMaxStore[PatternFreqMaxIndex[EntIndex]][1] == 0)) {
//                this.FreqMaxStore[PatternFreqMaxIndex[EntIndex]][0] = Xn;
//                this.FreqMaxStore[PatternFreqMaxIndex[EntIndex]][1] = this.FreqStore[(int) Xn];
//                PatternFreqMaxIndex[EntIndex]++;
//            }
//        } else if ((PatternFreqMaxIndex[EntIndex] < PatternLength)
//                && (PatternFreqMaxIndex[EntIndex] > 0)
//                && (Xn == this.FreqMaxStore[PatternFreqMaxIndex[0]][0])
//                && (this.FreqStore[(int) Xn] >= this.FreqMaxStore[PatternFreqMaxIndex[0]][1])) {
//            this.FreqMaxStore[PatternFreqMaxIndex[0]][0] = Xn;
//            this.FreqMaxStore[PatternFreqMaxIndex[0]][1] = this.FreqStore[(int) Xn];
//            PatternFreqMaxIndex[EntIndex]++;
//        }

        //Sort by Frequency
        this.Mean += Xn;
        this.DataStoreLCG.removeAll(DataStoreLCG);
        for (int i = 0; i < EntPool[EntIndex].MySimple.FreqStore.length-1; i++) {
            if (Xn < this.FreqStore.length)
                    this.DataStoreLCG.add(new PatternBits(  (int)Xn, ((int) this.FreqStore[(int)Xn]) ) );
        }
        Collections.sort(this.DataStoreLCG, new SortbyFreq());
    }

    void SearcNFormLCGPattern(int EntIndex, long Xn) {
        int i = 0;
        int j = 0;
        for (i = 0; (i < PatternFreqMaxIndex[EntIndex])&&(i < this.DataStoreLCG.size()) ; i++) {
            if ((EntIndex == 0) && (Xn != this.DataStoreLCG.get(i).Xn))
                       ; else if ((EntIndex == 2) && (Xn != this.DataStoreLCG.get(i).Xn))
                   ; else {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((i < PatternFreqMaxIndex[EntIndex]) && ((i + 1) <= DataStoreLCG.size())) {
            this.NextIthLCGPatRecog = (long) DataStoreLCG.get(i).Xn;
        }//Random Pattern
        else if ((i < PatternFreqMaxIndex[EntIndex]) && ((i + 1) < DataStoreLCG.size()) && (DataStoreLCG.get(i + 1).Freq > 1)) {
            this.NextIthLCGPatRecog = (long) DataStoreLCG.get(i + 1).Xn;
        }
    }

    void PatternRepetionTest(long IthXn) {
    // Check membership in O(1)
    if (patternSet.contains(IthXn)) {
        // If found, set next pattern directly
        this.NextIthLCGPatternRep = IthXn;
    }

    // Maintain buffer size
    if (patternBuffer.size() >= PatternRepLength) {
        Long removed = patternBuffer.removeFirst();
        patternSet.remove(removed);
    }

    // Add new element
    patternBuffer.addLast(IthXn);
    patternSet.add(IthXn);
}
    void PatternRepetionTest(int i, long IthXn_LCG) {
        int j = 0;
        if (LCGPatternLastBits.isEmpty()) {
            LCGPatternLastBits.addLast(IthXn_LCG);
        } else {
            for (j = 0; j < LCGPatternLastBits.size() - 1; j++) {
                if ((long) LCGPatternLastBits.get(j) == IthXn_LCG) {
                    break;
                }
            }
            //Found PatternBit
            //Constant Pattern
            if ((j < LCGPatternLastBits.size()) && ((j + 1) <= LCGPatternLastBits.size())) {
                this.NextIthLCGPatternRep = (long) LCGPatternLastBits.get(j);
            }//Random Pattern
            else if (j < LCGPatternLastBits.size() - 1) {
                this.NextIthLCGPatternRep = (long) LCGPatternLastBits.get(j + 1);
            }
            if (LCGPatternLastBits.size() < PatternRepLength) {
                LCGPatternLastBits.push(IthXn_LCG);
            } else if (LCGPatternLastBits.size() == PatternRepLength) {
                LCGPatternLastBits.removeFirst();
                LCGPatternLastBits.push(IthXn_LCG);
            }
        }
    }

    void PatternTest(int i, long IthXn_LCG) {
        int j = 0;
        for (j = 0; j < LCGPattern.length; j++) {
            if (LCGPattern[j] == IthXn_LCG) {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((j < LCGPattern.length) && ((j + 1) <= LCGPattern.length)) {
            this.NextIthLCGPattern = LCGPattern[j];
        }//Random Pattern
        else if (j < LCGPattern.length) {
            this.NextIthLCGPattern = LCGPattern[j + 1];
        }
    }

    void BufferTest(int i, long IthXn_LCG) {
        int j = 0;
        for (j = 0; j < LCGNextBitDataBuff.size() - 1; j++) {
            if ((long) LCGNextBitDataBuff.get(j) == IthXn_LCG) {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((j < LCGNextBitDataBuff.size()) && ((j + 1) <= LCGNextBitDataBuff.size())) {
            this.NextIthLCGBuffer = (long) LCGNextBitDataBuff.get(j);
        }//Random Pattern
        else if (j < LCGNextBitDataBuff.size() - 1) {
            this.NextIthLCGBuffer = (long) LCGNextBitDataBuff.get(j + 1);
        }
    }
//public static void readMemoryMappedFile(String filePath) {
//        try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
//             FileChannel channel = file.getChannel()) {
//
//            // Map the entire file into memory
//            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
//
//            // Example: read as text
//            byte[] data = new byte[(int) channel.size()];
//            buffer.get(data);
//
//            String content = new String(data, StandardCharsets.UTF_8);
//            System.out.println("File content length: " + content.length());
//
//            // You can now parse entropy values directly from 'content'
//            // or tokenize into numbers without repeated disk I/O.
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    // --- Write entropy values to binary file ---
    public static void writeEntropy(String filePath, double[] entropyValues) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (double val : entropyValues) {
                dos.writeDouble(val);
            }
        }
        // FileOutputStream is closed here, so no lock remains
    }

    // --- Read entropy values via memory mapping ---
    public static double[] readEntropy(String filePath, int count) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r");
             FileChannel channel = raf.getChannel()) {

            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            DoubleBuffer doubleBuffer = buffer.asDoubleBuffer();

            double[] values = new double[count];
            doubleBuffer.get(values);
            return values;
        }
        // Channel and RAF closed here, mapping released
    }
    void ReadFromFile(int j, int EntIndex, long NoOfBuffBitsMax, long Xn_LCG, String RunNumber) {
        try {
            String FileName = Path + "RNDXn_LCG" + RunNumber + "_TESTSUITE_" + j;
            FileInputStream fp = new FileInputStream(FileName);
            BufferedReader din = new BufferedReader(new InputStreamReader(fp));
            LinkedList Temp = new LinkedList();
            long data = 0;
            if (ReadExpireFlag == false) {
                while (fp.available() > 0) {
                    String line = din.readLine();
                    if (line != null) {
                        line = line.trim();
                        Temp.add(Long.parseLong(line));
                    } else {
                        break;
                    }
                }
                din = null;
                fp.close();
                this.LCGNextBitDataBuff.clear();
                int k = Temp.size() - 1;
                int i = (k - (int) NoOfBuffBitsMax);
                if (i < 0) {
                    for (i = 0; (i < Temp.size()); i++) {
                        data = (long) Temp.get(i);
                        if (NoOfBuffBitsMax > this.LCGNextBitDataBuff.size()) {
                            this.LCGNextBitDataBuff.add(data);
                        } else {
                            this.LCGNextBitDataBuff.push(data);
                        }
                    }
                } else {
                    for (; (i < Temp.size()); i++) {
                        data = (long) Temp.get(i);
                        if (NoOfBuffBitsMax > this.LCGNextBitDataBuff.size()) {
                            this.LCGNextBitDataBuff.add(data);
                        } else {
                            this.LCGNextBitDataBuff.push(data);
                        }
                    }
                }
                ReadExpireFlag = true;
            } else {
                this.LCGNextBitDataBuff.add(Xn_LCG);
                ReadExpireNumber++;
                if (ReadExpireNumber == ReadExpireMax) {
                    ReadExpireNumber = 0;
                    ReadExpireFlag = false;
                }
            }
        } catch (Exception RND) {
            log.info("Exception: RND ReadFromFile");
            System.out.println(RND.getStackTrace());
            System.out.println(RND.getMessage());
            RND.printStackTrace();
        }
    }

    void printDocValues(int Index, int NoOfBits) {
        System.out.println("LCG InitValues:" + Index);
        //PrintSeedValues(Index);
        PrintMeanValues(Index);
        System.out.printf("GuessLCG=%d %%=%5.4f\n", EntPool[Index].MySimple.GuessLCG, (100.0 * (double) EntPool[Index].MySimple.GuessLCG / (double) NoOfBits));
        System.out.printf("GuessLCGPatRecog=%d %%=%5.4f\n", EntPool[Index].MySimple.GuessLCGPatRecog, (100.0 * (double) EntPool[Index].MySimple.GuessLCGPatRecog / (double) NoOfBits));
        System.out.printf("GuessLCGRep=%d %%=%5.4f\n", EntPool[Index].MySimple.GuessLCGRep, (100.0 * (double) EntPool[Index].MySimple.GuessLCGRep / (double) NoOfBits));
        System.out.printf("GuessLCGPattern=%d %%=%5.4f\n", EntPool[Index].MySimple.GuessLCGPattern, (100.0 * (double) EntPool[Index].MySimple.GuessLCGPattern / (double) NoOfBits));
        System.out.printf("GuessLCGBuff=%d %%=%5.4f\n", EntPool[Index].MySimple.GuessLCGBuff, (100.0 * (double) EntPool[Index].MySimple.GuessLCGBuff / (double) NoOfBits));
        if (MonoBitTestFlag == true) {
            System.out.printf("Monobit:LCG:0:Index:%d:MonoBitZero=%d\n", Index, MonoBitZeroLCG);
            System.out.printf("Monobit:LCG:1:Index:%d:MonoBitONE=%d\n", Index, MonoBitOneLCG);
        }
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        //PrintFreqStore(Index);
        PrintFreqMaxStore(Index);
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());
        EntPool[Index].MySimple.GuessLCG = 0;
        EntPool[Index].MySimple.GuessLCGPatRecog = 0;
        EntPool[Index].MySimple.GuessLCGRep = 0;
        EntPool[Index].MySimple.GuessLCGPattern = 0;
        EntPool[Index].MySimple.GuessLCGBuff = 0;
        MonoBitZeroLCG = 0;
        MonoBitOneLCG = 0;

    }

    void PrintSeedValues(int Index) {
        System.out.println("LCG InitVal:" + this.InitValue.get("InitVal" + Index));
        System.out.println("LCG a:" + this.InitValue.get("a" + Index));
        System.out.println("LCG c:" + this.InitValue.get("c" + Index));
        System.out.println("LCG b:" + this.InitValue.get("b" + Index));
        System.out.println("LCG ModulusEncrypt:" + this.InitValue.get("ModulusEncrypt" + Index));
        System.out.println("LCG MaxExponent:" + this.InitValue.get("MaxExponent" + Index));

        System.out.println("LCG Seed Equations:" + Index);
        System.out.println("LCG Exprn:" + this.InitValue.get("Exprn" + Index));
        System.out.println("LCG ConfuseExprn:" + this.InitValue.get("ConfuseExprn" + Index));
        System.out.println("LCG DiffusionExprn:" + this.InitValue.get("DiffusionExprn" + Index));
        System.out.println("LCG SupportExprn:" + this.InitValue.get("SupportExprn" + Index));
        System.out.println("LCG SurprisalExprn:" + this.InitValue.get("SurprisalExprn" + Index));

        System.out.println("LCG Seed Values:");
        System.out.println("LCG ConfuseValue:" + this.InitValue.get("ConfuseValue" + Index));
        System.out.println("LCG DiffusionValue:" + this.InitValue.get("DiffusionValue" + Index));
        System.out.println("LCG SupportValue:" + this.InitValue.get("SupportValue" + Index));
        System.out.println("LCG SurprisalValue:" + this.InitValue.get("SurprisalValue" + Index));

    }

    public void PrintMeanValues(int Index) {
        System.out.println("LCG Stats:" + Index + ":Mean=" + this.MeanSigma[0] + " Low Level Mean=" + this.Mean / NoOfBits);
        System.out.println("LCG Stats:" + Index + ":Sigma=" + this.MeanSigma[1]);
        System.out.println("LCG Stats:" + Index + ":Sigma(2 bit)=" + this.MeanSigma[2]);

    }

    void PrintFreqStore(int Index) {
        for (int i = 0; i < NoOfSlots; i++) {
            System.out.println("LCG Stats: i=" + i + " " + this.FreqStore[i] + " Probability=" + this.GaussianPDFStore[i] + " TheoryProb=" + (100.0 * RandomNumber.Probability(i, this.MeanSigma[0], this.MeanSigma[1])) + " Actual=" + 100 * this.FreqStore[i] / NoOfBits);
        }
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());
    }

    void PrintFreqMaxStore(int Index) {
        int Freq = 0;
        double mean = 0.0;
        for (int i = 0; i < EntPool[Index].MySimple.FreqStore.length; i++) {
            if ( (EntPool[Index].MySimple.FreqStore[i] > 0)) {
                Freq += EntPool[Index].MySimple.FreqStore[i];
                mean += i * EntPool[Index].MySimple.FreqStore[i];
                System.out.println("LCG Stats:" + Index + ":Max:i=" + i + " Number=" + i + " " + EntPool[Index].MySimple.FreqStore[i]);
            }
        }
        System.out.println("LCG Stats:Max:Freq=" + Freq + " mean=" + (mean / NoOfBits) + ":PatternFreqMaxIndex[Index]=" + PatternFreqMaxIndex[Index] + " Index=" + Index);
    }

    public void TestInfraSingle(int j, int i, long Xn_LCG, String FileName, String RunNumber) {
        WriteToFileInfra(j, i, Xn_LCG, FileName, RunNumber);
        StatsSingle(0, Xn_LCG);
        ReadFromFile(j, 0, NoOfBuffBitsMax, Xn_LCG, RunNumber);
        DetectLCGPattern(0, NoOfSlots, Xn_LCG, i);
        GuessNextIthBit(0, i, Xn_LCG);
    }

    void GuessNextIthBit(int EntIndex, int i, long IthXn_LCG) {
        this.SearcNFormLCGPattern(0, IthXn_LCG);
        this.PatternRepetionTest(i, IthXn_LCG);
        this.PatternTest(i, IthXn_LCG);
        this.BufferTest(i, IthXn_LCG);
    }

    void WriteToFileInfra(int j, int i, long Xn_LCG, String FileName, String RunNumber) {
        //if (i < NoOfBuffBitsMax) {
        FileWriter fp = null;
        BufferedWriter bw = null;
        PrintWriter fpout = null;
        FileName = Path + FileName + RunNumber + "_TESTSUITE_" + j;
        String DataLCG = "" + Xn_LCG + " ";
        try {
            if (i == 0) {
                fp = new FileWriter(FileName, false);
                bw = new BufferedWriter(fp);
                fpout = new PrintWriter(bw);
            } else {
                fp = new FileWriter(FileName, true);
                bw = new BufferedWriter(fp);
                fpout = new PrintWriter(bw);
            }
            fpout.println(DataLCG);
            fpout.close();
            fpout = null;
            bw = null;
            fp = null;

        } catch (Exception RND) {
            log.info("Exception: RND WriteToFileInfra");
            System.out.println(RND.getStackTrace());
            System.out.println(RND.getMessage());
            RND.printStackTrace();
        }
        // }
    }

    public void StatsSingle(int EntIndex, long Xn_LCG) {
        int i = EntIndex;
//for (int i = EntIndex; i < EntPoolIndex; i++) {
        this.FreqStore[(int) Xn_LCG]++;
        this.UpdateStats(Xn_LCG);

        //}
    }

    class PatternBits {

        int Xn = 0;
        int Freq = 0;

        PatternBits(int myXn, int myFreq) {
            Xn = myXn;
            Freq = myFreq;
        }

    }

    class SortbyFreq implements Comparator<PatternBits> {

        public int compare(PatternBits a, PatternBits b) {

            return b.Freq - a.Freq;
        }
    }

    class SortbyXn implements Comparator<PatternBits> {

        public int compare(PatternBits a, PatternBits b) {

            return a.Xn - b.Xn;
        }
    }

    /**
     * ****************************************************
     */
    /**
     * ******************************* Random Generation Mechanisms Begin
     * *********************
     */
    /**
     * ****************************************************
     */
    public long LCG_Value_RandomSimple(int EntIndex, String ObjNameStrStateless, long Xn_LCG, long a, long c, int Modulus, int MaxExponent, int ModulusEncrypt, long IthNum) {
        String TempSupportExprnLCG = SupportExprnLCG;
        String TempSurprisalExprnLCG = SurprisalExprnLCG;
//        if (InitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTimeOverall = Double.parseDouble(TimeTaken[2]);
//            System.out.println("LCG_Value_RandomSimple:Started:Run Started Time:" + current + " ");
//        }
        //long Xn_LCGXn = Xn_LCG;
        long ConfuseValueXn = ConfuseValue;
        long DiffusionValueXn = DiffusionValue;
        long ConfuseFunction2ValueXn = ConfuseFunction2Value;
        long SupportValueXn = SupportValue;
        long SurprisalValueXn = SurprisalValue;
        //System.out.println("1LCG_Value_RandomSimple:Initial:" + ObjNameStrStateless + ":Xn_LCG=" + Xn_LCG + " ConfuseValue=" + ConfuseValue + " DiffusionValue=" + DiffusionValue + " SupportValue=" + SupportValue + " SurprisalValue=" + SurprisalValue);
        if (InitFlagRecordTime == false) {
            Xn_LCG = InitialUncertainity(ObjNameStrStateless, Xn_LCG, a, c, Modulus, MaxExponent, ModulusEncrypt);
        }
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (InitFlagRecordTime == true)) {
            ResetSimpleObj();
        }
        LCGValueStatelessObjString = "Xn_LCG";
        LCGValueStatelessObjStringDiff2 = "Xn_LCG";
        LCGValueStatelessObjStringDiff = "Xn_LCG";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        Xn_LCG = LCG_Value_Random_Stateless("LCG_Value_RandomSimple", ExprnLCG, a, c, Xn_LCG, (long) Modulus, MaxExponent, "Xn_LCG", ObjNameStrStateless);
        

        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (InitFlagRecordTime == true)) {
            ResetSimpleObj();
        }
        LCGValueStatelessObjString = "ConfuseValue";
        LCGValueStatelessObjStringDiff2 = "ConfuseValue";
        LCGValueStatelessObjStringDiff = "ConfuseValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            ConfuseValue = (ConfuseValue + LCG_Value_Random_Stateless("LCG_Value_RandomSimple", ConfuseExprnLCG, a, c, Xn_LCG, (int) ModulusEncrypt, ModulusEncrypt, "ConfuseValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        ConfuseFunction2Value = ConfusionFunctionValue((int) ConfuseFunction2Value);
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (InitFlagRecordTime == true)) {
            ResetSimpleObj();
        }
        LCGValueStatelessObjString = "DiffusionValue";
        LCGValueStatelessObjStringDiff2 = "DiffusionValue";
        LCGValueStatelessObjStringDiff = "DiffusionValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            DiffusionValue = (DiffusionValue + LCG_Value_Random_Stateless("LCG_Value_RandomSimple", DiffusionExprnLCG, a, c, Xn_LCG, (int) ModulusEncrypt, ModulusEncrypt, "DiffusionValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        DiffusionFunction2Value = DiffusionFunctionValue((int) DiffusionFunction2Value);
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (InitFlagRecordTime == true)) {
            ResetSimpleObj();
        }
        LCGValueStatelessObjString = "SupportValue";
        LCGValueStatelessObjStringDiff2 = "SupportValue";
        LCGValueStatelessObjStringDiff = "SupportValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        TempSupportExprnLCG = SupportExprnLCG + "-" + SurprisalValue;
        if (ModulusEncrypt > 0) {
            SupportValue = (SupportValue + LCG_Value_Random_Stateless("LCG_Value_RandomSimple", TempSupportExprnLCG, a, c, Xn_LCG, (int) ModulusEncrypt, ModulusEncrypt, "SupportValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (InitFlagRecordTime == true)) {
            ResetSimpleObj();
        }
        LCGValueStatelessObjString = "SurprisalValue";
        LCGValueStatelessObjStringDiff2 = "SurprisalValue";
        LCGValueStatelessObjStringDiff = "SurprisalValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        TempSurprisalExprnLCG = SurprisalExprnLCG + "-" + SurprisalValue;
        TempSurprisalExprnLCG = SurprisalExprnLCG + "-" + SurprisalValue;
        if (ModulusEncrypt > 0) {
            SurprisalValue = (SurprisalValue + LCG_Value_Random_Stateless("LCG_Value_RandomSimple", TempSurprisalExprnLCG, a, c, Xn_LCG, (int) ModulusEncrypt, ModulusEncrypt, "SurpriseValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        //System.out.println("2LCG_Value_RandomSimple:Middle:Xn_LCG=" + Xn_LCG + " ConfuseValue=" + ConfuseValue + " DiffusionValue=" + DiffusionValue + " SupportValue=" + SupportValue + " SurprisalValue=" + SurprisalValue);
        if (Modulus > 0) {
            Xn_LCG = (Xn_LCG + ConfuseValue + ConfuseFunction2Value + DiffusionValue + DiffusionFunction2Value - SupportValue + SurprisalValue) % (Modulus);
        }
        //System.out.println("3    LCG_Value_RandomSimple:Final:" + ObjNameStrStateless + ":Xn_LCG=" + Xn_LCG + " ConfuseValue=" + ConfuseValue + " DiffusionValue=" + DiffusionValue + " SupportValue=" + SupportValue + " SurprisalValue=" + SurprisalValue);
        Xn_LCG = EliminateIndividualState(Xn_LCG, ObjNameStrStateless, Xn_LCGXn, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        if(Xn_LCG == Xn_LCGXn)
                Xn_LCG = EliminatePatternInSet(Xn_LCG, ObjNameStrStateless, Xn_LCGXn, IthNum);
        else if ( (AntiCounterModeFlag==true) && (Modulus < 8)   )
            Xn_LCG = EliminatePatternInSet(Xn_LCG, ObjNameStrStateless, Xn_LCGXn, IthNum);
        else if(Xn_LCG != Xn_LCGXn)
                Xn_LCG = EliminatePatternInSet(Xn_LCG, ObjNameStrStateless, Xn_LCGXn, IthNum);
        if (Xn_LCG < 0) {
            Xn_LCG = Xn_LCG * -1;
        }
//        if (InitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTimeOverall = Double.parseDouble(TimeTaken[2]) - CompletionTimeOverall;
//            //System.out.println("LCG_Value_RandomSimple:Completed:Run Started Time:" + current + " " + " InitFlagRecordTime=" + InitFlagRecordTime + " Modulus=" + Modulus + " MaxExponent=" + MaxExponent + " ModulusEncrypt=" + ModulusEncrypt + " CompletionTimeOverall=" + CompletionTimeOverall * 1000 + " millisecs");
//            InitFlagRecordTime = true;
//        }
        this.LCGDataBuff.add(Xn_LCG);
        return Xn_LCG;
    }

    long InitialUncertainity(String ObjNameStrStateless, long Xn_LCG, long a, long c, int Modulus, int MaxExponent, int ModulusEncrypt) {
        ResetSimpleObj();
        LCGValueStatelessObjString = "Xn_LCG";
        LCGValueStatelessObjStringDiff2 = "Xn_LCG";
        LCGValueStatelessObjStringDiff = "Xn_LCG";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            Xn_LCG = (Xn_LCG + LCG_Value_Random_Stateless("InitialUncertainity", ExprnLCG, a, c, Xn_LCG, (long) Modulus, MaxExponent, "Xn_LCG", ObjNameStrStateless)) % ModulusEncrypt;
        }
        ResetSimpleObj();
        LCGValueStatelessObjString = "ConfuseValue";
        LCGValueStatelessObjStringDiff2 = "ConfuseValue";
        LCGValueStatelessObjStringDiff = "ConfuseValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            ConfuseValue = (ConfuseValue + LCG_Value_Random_Stateless("InitialUncertainity", ConfuseExprnLCG, a, c, ConfuseValue, (int) ModulusEncrypt, ModulusEncrypt, "ConfuseValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        ResetSimpleObj();
        LCGValueStatelessObjString = "DiffusionValue";
        LCGValueStatelessObjStringDiff2 = "DiffusionValue";
        LCGValueStatelessObjStringDiff = "DiffusionValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            DiffusionValue = (DiffusionValue + LCG_Value_Random_Stateless("InitialUncertainity", DiffusionExprnLCG, a, c, DiffusionValue, (int) ModulusEncrypt, ModulusEncrypt, "DiffusionValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        ResetSimpleObj();
        LCGValueStatelessObjString = "SupportValue";
        LCGValueStatelessObjStringDiff2 = "SupportValue";
        LCGValueStatelessObjStringDiff = "SupportValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            SupportValue = (SupportValue + LCG_Value_Random_Stateless("InitialUncertainity", SupportExprnLCG, a, c, SupportValue, (int) ModulusEncrypt, ModulusEncrypt, "SupportValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        ResetSimpleObj();
        LCGValueStatelessObjString = "SurprisalValue";
        LCGValueStatelessObjStringDiff2 = "SurprisalValue";
        LCGValueStatelessObjStringDiff = "SurprisalValue";
        LCGValueStatelessObjNameStr = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff = ObjNameStrStateless;
        LCGValueStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            SurprisalValue += (SurprisalValue + LCG_Value_Random_Stateless("InitialUncertainity", SurprisalExprnLCG, a, c, SurprisalValue, (int) ModulusEncrypt, ModulusEncrypt, "SurpriseValue", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        //System.out.println("LCG_Value_RandomSimple:Middle:Xn_LCG=" + Xn_LCG + " ConfuseValue=" + ConfuseValue + " DiffusionValue=" + DiffusionValue);
        if (Xn_LCG < 0) {
            Xn_LCG = Xn_LCG * -1;
        }
        return Xn_LCG;
    }

    void ResetSimpleObj() {
        LCGexpValueObjExpire = false;
        LCGexpObjExpire = false;
        LCGexpValueObjExpire2 = false;
        LCGValueStatelessObjString = "";
        LCGValueStatelessObjStringDiff2 = "";
        LCGValueStatelessObjStringDiff = "";
        LCGValueStatelessObjNameStr = "";
        LCGValueStatelessObjNameStrDiff = "";
        LCGValueStatelessObjNameStrDiff2 = "";
    }

    // The LCG_Value_Random Method uses F(x)==Xn && ODE Dy/Dx(F(x))== Xn
    // If Xn != Xn+1, Method Returns Xn+1
    // This can be viewed as a Lyapunov Function Also 
    //(Source :wikiLyapunov) where F'(x)=F(x)
    public long LCG_Value_Random_Memory(String AlgoName, String Exprn, long a, long c, long Xn, long Modulus, long MaxExponent, String EqnCompFlag) {
//        if (LowInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTime = Double.parseDouble(TimeTaken[2]);
//            System.out.println("LCG_Value_Random_Memory:Started:Run Started Time:" + current + " ");
//        }
        Map<String, Double> variables = new HashMap<>();
        MyFuncExpress();
        MyFuncDiff();
        MyFuncSimple();
        String DiffWithRespTo = "Xn";

        String StrexpSimpleExpress = "";
        String StrexpDiffExpress = "";
        int i = 1;
        long Xnplus1 = Xn;
        long TempXn = 0;
        StringBuilder StrBuildTemp = new StringBuilder(Exprn);
        StrBuildTemp.append("-").append(a).append("*").append(DiffWithRespTo).append("+").append(c).append("*").append(Xn).append("-").append(Xn);
        Exprn = StrBuildTemp.toString();
        StrBuildTemp = new StringBuilder(eatAll(Exprn, ' '));
        //System.out.println("Expr_LCG_Value:Exprn=" + Exprn + " EqnCompFlag=" + EqnCompFlag);
        GetExprnMinMaxRange(Xn, DiffWithRespTo, Modulus, 10);
        LCGXnplus1Avail = false;
        for (long x = LCGXValuemin; (i < 5) && ((i < 3) || (Xn == Xnplus1) || (TempXn == Xnplus1)); x += LCGXValueInc, i++) {
            variables.put(DiffWithRespTo, ((double) x));
            if (LCGexpValueObjExpire == false) {
                LCGexpValue = parse(Exprn.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                LCGexpValueObjExpire = true;
            }
            //F(x)==Xn 
            TempXn = (long) ((LCGexpValue.eval()) % (Modulus));
            if ((TempXn == Xn) || (i >= 1)) {
                StrexpSimpleExpress = eatAll(Exprn.toString(), ' ');
                if (LCGexpObjExpire == false) {
                    StrexpSimpleExpress = StrexpSimpleExpress + "-" + Xnplus1 + "-" + Xn;
                    StrexpSimpleExpress = eatAll(StrexpSimpleExpress, ' ');
                    LCGexp = parseDiff(StrexpSimpleExpress, variables, DiffWithRespTo, "Map1", "Diffr");
                    LCGexpObjExpire = true;
                }
                StrexpDiffExpress = LCGexp.DiffExpr();
                StrexpSimpleExpress = eatAll(StrexpDiffExpress, ' ');
                if (LCGexpValueObjExpire2 == false) {
                    LCGexpValue2 = parse(StrexpSimpleExpress, variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    LCGexpValueObjExpire2 = true;
                }
                StringBuilder StrBuild = new StringBuilder(StrexpSimpleExpress);
                Exprn = StrBuild.toString();
                //ODE Dy/Dx(F(x))== Xn
                Xnplus1 = (long) ((LCGexpValue2.eval() + x) % (MaxExponent));
                LCGXnplus1Avail = true;
                GetExprnMinMaxRange(Xnplus1, DiffWithRespTo, (LCGXValuemax - x), (10 - i));
                System.out.println("LCG_Value_Random:Reached:Depth=" + i + " EqnCompFlag=" + EqnCompFlag + " TempXn=" + TempXn + " Xnplus1=" + Xnplus1 + " Xn=" + Xn);
            } else if (TempXn != Xnplus1) {
                Xnplus1 = (long) (LCGexpValue2.eval() % (MaxExponent));
                break;
            }
        }
        LCGXnplus1Avail = false;
        LCGexpValueObjExpire = false;
        LCGexpObjExpire = false;
        LCGexpValueObjExpire2 = false;
//        if (LowInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            if (TimeTaken.length >= 2) {
//                CompletionTime = Double.parseDouble(TimeTaken[2]) - CompletionTime;
//            } else {
//                CompletionTime = Double.parseDouble(TimeTaken[1]);
//            }
//            System.out.println("LCG_Value_Random_Memory:Completed:Run Started Time:" + current + " " + " CompletionTime=" + CompletionTime * 1000 + " millisecs");
//            LowInitFlagRecordTime = true;
//        }
        //System.out.println("LCG_Value_Random:Completed:Xnplus1=" + Xnplus1 + " Modulus=" + Modulus);
        return ((long) Xnplus1);
    }

    // The LCG_Value_Random Method uses F(x)==Xn && ODE Dy/Dx(F(x))== Xn
    // If Xn != Xn+1, Method Returns Xn+1
    // This can be viewed as a Lyapunov Function Also 
    //(Source :wikiLyapunov) where F'(x)=F(x)
    public long LCG_Value_Random_Stateless(String AlgoName, String Exprn, long a, long c, long Xn, long Modulus, long MaxExponent, String EqnCompFlag, String ObjNameStr) {
//        if (LowInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTime = Double.parseDouble(TimeTaken[2]);
//            System.out.println("LCG_Value_Random_Stateless:Started:Run Started Time:" + current + " ");
//        }
        Map<String, Double> variables = new HashMap<>();
        MyFuncExpress();
        MyFuncDiff();
        MyFuncSimple();
        String DiffWithRespTo = "Xn";

        StringBuilder StrexpSimpleExpress = new StringBuilder("");
        String StrexpDiffExpress = "";
        int i = 1;
        long Xnplus1 = Xn;
        long TempXn = 0;
        StringBuilder StrBuildTemp = new StringBuilder(Exprn);
        StrBuildTemp.append("-").append(a).append("*").append(DiffWithRespTo).append("+").append(c).append("*").append(Xn).append("-").append(Xn);
        Exprn = StrBuildTemp.toString();
        StrBuildTemp = new StringBuilder(eatAll(Exprn, ' '));
        //System.out.println("Expr_LCG_Value:Exprn=" + Exprn + " EqnCompFlag=" + EqnCompFlag);
        GetExprnMinMaxRange(Xn, DiffWithRespTo, Modulus, 10);
        LCGXnplus1Avail = false;
        for (long x = LCGXValuemin; (i < 3) && ((i < 3) || (Xn == Xnplus1) || (TempXn == Xnplus1)); x += LCGXValueInc, i++) {
            variables.put(DiffWithRespTo, ((double) x));
            if ((LCGexpValueObjExpire == false) && (LCGValueStatelessObjString.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStr.equalsIgnoreCase(ObjNameStr))) {
                LCGexpValue = parse(StrBuildTemp.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                LCGexpValueObjExpire = true;
                LCGValueStatelessObjString = EqnCompFlag;
                LCGValueStatelessObjNameStr = ObjNameStr;
            } else if ((LCGexpValueObjExpire == true) && (LCGValueStatelessObjString.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStr.equalsIgnoreCase(ObjNameStr))) {
                LCGexpValue = parse(StrBuildTemp.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                LCGexpValueObjExpire = false;
                LCGValueStatelessObjString = EqnCompFlag;
                LCGValueStatelessObjNameStr = ObjNameStr;
            }
            //F(x)==Xn 
            if ((LCGexpValue != null) && (LCGValueStatelessObjString.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStr.equalsIgnoreCase(ObjNameStr))) {
                TempXn = (long) ((LCGexpValue.eval()) % (MaxExponent));
            }
            if (((TempXn == Xn) || (i >= 1)) && (LCGValueStatelessObjString.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStr.equalsIgnoreCase(ObjNameStr))) {
                StrexpSimpleExpress = new StringBuilder(eatAll(Exprn, ' '));
                //System.out.println("LCG_Value_Random:Reached1:StrexpSimpleExpress=" + StrexpSimpleExpress );
                if ((LCGexpObjExpire == false) && (LCGValueStatelessObjStringDiff.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStrDiff.equalsIgnoreCase(ObjNameStr))) {
                    StrexpSimpleExpress.append("-").append(Xnplus1).append("-").append(Xn);
                    StrexpSimpleExpress = new StringBuilder(eatAll(StrexpSimpleExpress.toString(), ' '));
                    MathsContxtLAv.SimpleExpression expSimple = null;
                    expSimple = parseSimple(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, "Map1", "Diffr", HideInRecurseFlag, GBLSilent, GBLMyLogLevel);
                    LCGexp = parseDiff(expSimple.SimpleExpr(), variables, DiffWithRespTo, "Map1", "Diffr");
                    //LCGexp = parseDiff(StrexpSimpleExpress.toString(), variables, DiffWithRespTo);
                    LCGexpObjExpire = true;
                    LCGValueStatelessObjStringDiff = EqnCompFlag;
                    LCGValueStatelessObjNameStrDiff = ObjNameStr;
                } else if ((LCGexpObjExpire == true) && (LCGValueStatelessObjStringDiff.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStrDiff.equalsIgnoreCase(ObjNameStr))) {
                    StrexpSimpleExpress.append("-").append(Xnplus1).append("-").append(Xn);
                    StrexpSimpleExpress = new StringBuilder(eatAll(StrexpSimpleExpress.toString(), ' '));
                    MathsContxtLAv.SimpleExpression expSimple = null;
                    expSimple = parseSimple(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, "Map1", "Diffr", HideInRecurseFlag, GBLSilent, GBLMyLogLevel);
                    LCGexp = parseDiff(expSimple.SimpleExpr(), variables, DiffWithRespTo, "Map1", "Diffr");
                    //LCGexp = parseDiff(StrexpSimpleExpress.toString(), variables, DiffWithRespTo);
                    LCGexpObjExpire = false;
                    LCGValueStatelessObjStringDiff = EqnCompFlag;
                    LCGValueStatelessObjNameStrDiff = ObjNameStr;
                }
                StrexpDiffExpress = LCGexp.DiffExpr();
                StrexpSimpleExpress = new StringBuilder(eatAll(StrexpDiffExpress, ' '));
                //System.out.println("LCG_Value_Random:Reached3:StrexpDiffExpress=" + StrexpDiffExpress );
                if ((LCGexpValueObjExpire2 == false) && (LCGValueStatelessObjStringDiff2.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStrDiff2.equalsIgnoreCase(ObjNameStr))) {
                    LCGexpValue2 = parse(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    LCGexpValueObjExpire2 = true;
                    LCGValueStatelessObjStringDiff2 = EqnCompFlag;
                    LCGValueStatelessObjNameStrDiff2 = ObjNameStr;
                } else if ((LCGexpValueObjExpire2 == true) && (LCGValueStatelessObjStringDiff2.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStrDiff2.equalsIgnoreCase(ObjNameStr))) {
                    LCGexpValue2 = parse(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    LCGexpValueObjExpire2 = false;
                    LCGValueStatelessObjStringDiff2 = EqnCompFlag;
                    LCGValueStatelessObjNameStrDiff2 = ObjNameStr;
                }
                StringBuilder StrBuild = new StringBuilder(StrexpSimpleExpress);
                if (!StrexpSimpleExpress.toString().equalsIgnoreCase("")) {
                    Exprn = StrBuild.toString();
                }
                //ODE Dy/Dx(F(x))== Xn
                Xnplus1 = (long) ((LCGexpValue2.eval() + x) % (MaxExponent));
                LCGXnplus1Avail = true;
                GetExprnMinMaxRange(Xnplus1, DiffWithRespTo, (LCGXValuemax - x), (10 - i));
                //System.out.println("LCG_Value_Random:Reached2:Depth=" + i + " EqnCompFlag=" + EqnCompFlag + " TempXn=" + TempXn + " Xnplus1=" + Xnplus1 + " Xn=" + Xn );
                //System.out.println("LCG_Value_Random:Reached2:Exprn=" + Exprn );
                //System.out.println("LCG_Value_Random:Reached2:StrexpSimpleExpress=" + StrexpSimpleExpress );
                //System.out.println("LCG_Value_Random:Reached2:StrexpDiffExpress=" + StrexpDiffExpress );
            } else if ((TempXn != Xnplus1) && (LCGValueStatelessObjString.equalsIgnoreCase(EqnCompFlag)) && (LCGValueStatelessObjNameStr.equalsIgnoreCase(ObjNameStr))) {
                Xnplus1 = (long) (LCGexpValue2.eval() % (MaxExponent));
                break;
            }
        }
//        if (LowInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            if (TimeTaken.length >= 2) {
//                CompletionTime = Double.parseDouble(TimeTaken[2]) - CompletionTime;
//            } else {
//                CompletionTime = Double.parseDouble(TimeTaken[1]);
//            }
//            System.out.println("LCG_Value_Random_Stateless:Completed:Run Started Time:" + current + " " + " CompletionTime=" + CompletionTime * 1000 + " millisecs");
//            LowInitFlagRecordTime = true;
//        }
        //System.out.println("LCG_Value_Random:Completed:Xnplus1=" + Xnplus1 + " Modulus=" + Modulus);
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    /**
     * ****************************************************
     */
    /**
     * ******************************* Random Mechanisms End
     * *********************
     */
    /**
     * ****************************************************
     */
    /**
     * ****************************************************
     */
    /**
     * ******************************* Stable State IndividualState Elimination
     * Mechanisms Begin *********************
     */
    /**
     * ****************************************************
     */
    public long EliminateZeroInOutputLCG(long Xn1, long Xnplus1, long ConfuseValue1, long DiffusionValue1, long SupportValue1, long SurprisalValue1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseValue==ConfuseValue1)
                //&&(DiffusionValue==DiffusionValue1)
                //&&(SupportValue==SupportValue1)
                //&&(SurprisalValue==SurprisalValue1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateZeroInOutputLCG: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 0) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateZeroInOutputLCG: Failed Elimination:0:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateZeroInOutputLCG: Failed Elimination:1:--");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 2) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1 -= 2;
                //System.out.println("EliminateZeroInOutputLCG: Failed Elimination:2:-=2");
            }
        } else {
            //System.out.println("EliminateZeroInOutputLCG: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateZeroInOutputLCG3(long Xn1, long Xnplus1, long ConfuseValue1, long DiffusionValue1, long SupportValue1, long SurprisalValue1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseValue==ConfuseValue1)
                //&&(DiffusionValue==DiffusionValue1)
                //&&(SupportValue==SupportValue1)
                //&&(SurprisalValue==SurprisalValue1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateZeroInOutputLCG3: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 0) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateZeroInOutputLCG3: Failed Elimination:0:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateZeroInOutputLCG3: Failed Elimination:1:--");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 2) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1 -= 2;
                //System.out.println("EliminateZeroInOutputLCG3: Failed Elimination:1:-=2");
            }
        } else {
            //System.out.println("EliminateZeroInOutputLCG3: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateOneInOutputLCG(long Xn1, long Xnplus1, long ConfuseValue1, long DiffusionValue1, long SupportValue1, long SurprisalValue1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseValue==ConfuseValue1)
                //&&(DiffusionValue==DiffusionValue1)
                //&&(SupportValue==SupportValue1)
                //&&(SurprisalValue==SurprisalValue1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateOneInOutputLCG: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateOneInOutputLCG: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateOneInOutputLCG: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateOneInOutputLCG: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateOneInOutputLCG3(long Xn1, long Xnplus1, long ConfuseValue1, long DiffusionValue1, long SupportValue1, long SurprisalValue1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseValue==ConfuseValue1)
                //&&(DiffusionValue==DiffusionValue1)
                //&&(SupportValue==SupportValue1)
                //&&(SurprisalValue==SurprisalValue1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateOneInOutputLCG3: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateOneInOutputLCG3: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateOneInOutputLCG3: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateOneInOutputLCG3: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateTwoInOutputLCG(long Xn1, long Xnplus1, long ConfuseValue1, long DiffusionValue1, long SupportValue1, long SurprisalValue1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseValue==ConfuseValue1)
                //&&(DiffusionValue==DiffusionValue1)
                //&&(SupportValue==SupportValue1)
                //&&(SurprisalValue==SurprisalValue1)
                ) {
            Xnplus1++;
        } else if ((Xnplus1 != Xn1) && (Xnplus1 == 2)) {
            //System.out.println("EliminateTwoInOutputLCG: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateTwoInOutputLCG: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateTwoInOutputLCG: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateTwoInOutputLCG: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateTwoInOutputLCG3(long Xn1, long Xnplus1, long ConfuseValue1, long DiffusionValue1, long SupportValue1, long SurprisalValue1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseValue==ConfuseValue1)
                //&&(DiffusionValue==DiffusionValue1)
                //&&(SupportValue==SupportValue1)
                //&&(SurprisalValue==SurprisalValue1)
                ) {
            Xnplus1++;
        } else if ((Xnplus1 != Xn1) && (Xnplus1 == 2)) {
            //System.out.println("EliminateTwoInOutputLCG3: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateTwoInOutputLCG3: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateTwoInOutputLCG3: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateTwoInOutputLCG3: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateIndividualState(long Xn_LCG, String ObjNameStrStateless, long Xn_LCGXn, long ConfuseValueXn, long DiffusionValueXn, long SupportValueXn, long SurprisalValueXn) {
        if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCG")) {
            //1 2 3 0 1 2 0 2 3 2 3 2 3 0 
            Xn_LCG = EliminateZeroInOutputLCG(Xn_LCGXn, Xn_LCG, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        } else if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCG3")) {
            //1 2 3 2 0 1 2 3 2 3 2 3 2 0 
            Xn_LCG = EliminateZeroInOutputLCG3(Xn_LCGXn, Xn_LCG, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        }
        if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCG")) && (Modulus > 2)) {
            Xn_LCG = EliminateOneInOutputLCG(Xn_LCGXn, Xn_LCG, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        } else if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCG3")) && (Modulus > 2)) {
            Xn_LCG = EliminateOneInOutputLCG3(Xn_LCGXn, Xn_LCG, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        }
        if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCG")) && (Modulus > 2)) {
            Xn_LCG = EliminateTwoInOutputLCG(Xn_LCGXn, Xn_LCG, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        } else if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCG3")) && (Modulus > 2)) {
            Xn_LCG = EliminateTwoInOutputLCG3(Xn_LCGXn, Xn_LCG, ConfuseValueXn, DiffusionValueXn, SupportValueXn, SurprisalValueXn);
        }
        return Xn_LCG;
    }

    public long EliminatePatternInSet(long Xn_LCG, String ObjNameStrStateless, long Xn_LCGXn, long IthNum) {
        if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCG")) {
            //0 1 2 3 0 1 
            Xn_LCG = DetectAndEliminate(0, IthNum, NoOfSlots, Xn_LCG, Xn_LCGXn, ObjNameStrStateless);
        } else if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCG3")) {
            //0 1 2 3 2 3 
            Xn_LCG = DetectAndEliminate(2, IthNum, NoOfSlots, Xn_LCG, Xn_LCGXn, ObjNameStrStateless);
        }

        if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCG")) {
            Xn_LCG = DetectAndEliminateFreqStoreMethod(0, IthNum, NoOfSlots, Xn_LCG, Xn_LCGXn, ObjNameStrStateless);
        } else if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCG3")) {
            Xn_LCG = DetectAndEliminateFreqStoreMethod(2, IthNum, NoOfSlots, Xn_LCG, Xn_LCGXn, ObjNameStrStateless);
        }
        return Xn_LCG;
    }

    public long DetectAndEliminate(int EntIndex, long IthNum, long NoOfSlots, long Xn_LCG, long Xn_LCGXn, String ObjNameStrStateless) {
        //Detect the Pattern
        boolean CounterModeDetectedFlag = false;
        boolean InittempStateLongFlag = false;
        boolean HumanErrorCounterMode = false;
        int InittempStateLongLen = -1;
        int i = 0;
        int j = 0;
        // Form Pattern
        long[] tempStateLong = null;
        tempStateLong = new long[10];
        if (IthNum > 10) {
            if ((ProbablePattern[EntIndex].equalsIgnoreCase("")) && (InitProbablePatternFlag == false)) {
                i = PatternStartIndex; //Do NOTHING
                //System.out.println("DetectAndEliminate:1:Reached:if");
            } else {
                i = (int) (IthNum - 10);
            }
            while ((i >= PatternStartIndex) && (i < IthNum)) {
                int k = 0;
                
                for (j = PatternStartIndex; ((j < PatternStartIndex + 10) && ((j - PatternStartIndex) < 10) || (k < 10)) && (j < this.LCGDataBuff.size()); j++, k++) {
                    tempStateLong[k] = this.LCGDataBuff.get(j).longValue();
                    InittempStateLongFlag = true;
                    InittempStateLongLen = k + 1;
                    int m=0;
                    for (; m < k ; m++){
                    if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&&( ( (tempStateLong[m] == Xn_LCGXn) && (tempStateLong[m + 1] == Xn_LCGXn)) ||( (tempStateLong[m] == Xn_LCG) && ((tempStateLong[m + 1] == Xn_LCG))) || (((j + 1) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j + 1).longValue() == Xn_LCG)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&&( ( (tempStateLong[m] == Xn_LCGXn) && (tempStateLong[m + 1] == Xn_LCG)) ||( (tempStateLong[m] == Xn_LCG) && (tempStateLong[m + 1] == Xn_LCGXn)) || (((j + 1) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j + 1).longValue() == Xn_LCGXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGXn) && ((tempStateLong[m + 1] == Xn_LCG) || ((j > 1) && ((j - 1) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j - 1).longValue() == Xn_LCG)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCG) && ((tempStateLong[m + 1] == Xn_LCGXn) || ((j > 1) && ((j - 1) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j - 1).longValue() == Xn_LCGXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    }// Hindsight Error Correction:Correct even if it is too late
                    else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGXn) && ((tempStateLong[m + 1] == Xn_LCG) || ((j > 2) && ((j - 2) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j - 2).longValue() == Xn_LCG)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCG) && ((tempStateLong[m + 1] == Xn_LCGXn) || ((j > 2) && ((j - 2) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j - 2).longValue() == Xn_LCGXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    }else if ((m >= 0) &&(m  < 10 )&&(m  <= k ) && (tempStateLong[m] == Xn_LCGXn) && ((tempStateLong[m + 1] == Xn_LCG) || ((j > 2) && ((j - 2) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j - 2).longValue() == Xn_LCGXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCG) && ((tempStateLong[m + 1] == Xn_LCGXn) || ((j > 2) && ((j - 2) < this.LCGDataBuff.size()) && (this.LCGDataBuff.get(j - 2).longValue() == Xn_LCG)))) {
                        HumanErrorCounterMode = true;
                        break;
                    }
                    }
                    //System.out.println("DetectAndEliminate:3:" + ObjNameStrStateless + ":Pattern Formed=" + tempStateLong[k] + " PatternStartIndex=" + PatternStartIndex + ":i=" + i + ":IthNum=" + IthNum + ":HumanErrorCounterMode=" + HumanErrorCounterMode + ":Xn_LCGXn=" + Xn_LCGXn + ":Xn_LCG=" + Xn_LCG);
                    i++;
                    if (HumanErrorCounterMode==true )
                        break;
                }
                ProbablePattern[EntIndex] = "";
                InitProbablePatternFlag = false;
                if ((InittempStateLongLen >= 5) && ((InitProbablePatternFlag == false) || (InittempStateLongFlag == true))
                        || ((InittempStateLongLen >= 2) && ((InitProbablePatternFlag == false) || (InittempStateLongFlag == true)))
                        || (HumanErrorCounterMode == true)) {
                    for (k = 0; ((k < InittempStateLongLen) && (InittempStateLongFlag == true)); k++) {
                        ProbablePattern[EntIndex] = ProbablePattern[EntIndex] + " " + tempStateLong[k];
                        InitProbablePatternFlag = true;
                    }
                    //System.out.println("DetectAndEliminate:4:Pattern Formed:ProbablePattern=" + ProbablePattern[EntIndex] + " i=" + i);
                }
                if (InitProbablePatternFlag == true) {
                    //System.out.println("DetectAndEliminate:5:" + ObjNameStrStateless + ":Formed Pattern :ProbablePattern=" + ProbablePattern[EntIndex] + ":Xn_LCG=" + Xn_LCG + " Xn_LCGXn=" + Xn_LCGXn + " HumanErrorCounterMode=" + HumanErrorCounterMode);
                    break;
                }
            }
        }
        //Constant Pattern
        //Random Pattern
        // If Pattern matches AB
        if ((InitProbablePatternFlag == true) && ((ProbablePattern[EntIndex].contains("" + Xn_LCGXn + " " + Xn_LCG + " "))
                || (ProbablePattern[EntIndex].startsWith("" + Xn_LCGXn + " " + Xn_LCG + " ")))) {
            CounterModeDetectedFlag = true;
        }// If Pattern matches ABA:Human Error of Reading Xn+1 state and Xn+2 state where Xn+2 is equal to Xn
        else if ((InitProbablePatternFlag == true) && ((ProbablePattern[EntIndex].contains("" + Xn_LCG + " " + Xn_LCGXn + " "))
                || (ProbablePattern[EntIndex].startsWith("" + Xn_LCG + " " + Xn_LCGXn + " ")))) {
            CounterModeDetectedFlag = true;
        } else if ((InitProbablePatternFlag == true) && ((ProbablePattern[EntIndex].equalsIgnoreCase("" + Xn_LCG + " " + Xn_LCGXn + " ")
                || (ProbablePattern[EntIndex].equalsIgnoreCase("" + Xn_LCGXn + " " + Xn_LCG + " "))))) {
            CounterModeDetectedFlag = true;
        } else if (HumanErrorCounterMode == true) {
            CounterModeDetectedFlag = true;
        }
        if ((CounterModeDetectedFlag == true) ) {
            //Xn_LCG += 2;
            Xn_LCG = GenerateNumbersNotUsed(EntIndex, IthNum, NoOfSlots, Xn_LCG, Xn_LCGXn, ObjNameStrStateless);
            ProbablePattern[EntIndex] = "";
            InitProbablePatternFlag = false;
            //System.out.println("DetectAndEliminate:6:" + ObjNameStrStateless + ":Broken Patterns:" + ObjNameStrStateless + ":IthNum=" + IthNum + ":Xn_LCG=" + Xn_LCG + ":Xn_LCGXn=" + Xn_LCGXn + ":PatternStartIndex=" + PatternStartIndex);
            PatternStartIndex = (int) IthNum;
        }
        return Xn_LCG;
    }

    public long DetectAndEliminateFreqStoreMethod(int EntIndex, long IthNum, long NoOfSlots, long Xn_LCG, long Xn_LCGXn, String ObjNameStrStateless) {
        //Detect the Pattern
        boolean PatternDetectedFlagNumLevel = false;
        int i = 0;
        int j = 0;
        for (i = 0; (i < PatternFreqMaxIndex[EntIndex]); i++) {
            if ((i > 0) && (EntIndex == 0) && (Xn_LCG != this.DataStoreLCG.get(i).Xn) && (Xn_LCGXn != this.DataStoreLCG.get(i - 1).Xn))
                       ; else if ((i > 0) && (EntIndex == 2) && (Xn_LCG != this.DataStoreLCG.get(i).Xn) && (Xn_LCGXn != this.DataStoreLCG.get(i - 1).Xn))
                   ; else {
                break;
            }

        }
        //Found PatternBit
        //Constant Pattern
        if ((i < PatternFreqMaxIndex[EntIndex]) && ((i + 1) <= this.DataStoreLCG.size())) {
            PatternDetectedFlagNumLevel = true;
        }//Random Pattern
        else if ((i < PatternFreqMaxIndex[EntIndex]) && ((i + 1) < this.DataStoreLCG.size()) && (this.DataStoreLCG.get(i + 1).Freq > 1)) {
            PatternDetectedFlagNumLevel = true;
        }
        if (PatternDetectedFlagNumLevel == true) {
            //Xn_LCG++;
            //System.out.println("DetectAndEliminateFreqStoreMethod:Found Patterns:" + ObjNameStrStateless + ":IthNum=" + IthNum + ":Xn_LCG=" + Xn_LCG + " Xn_LCGXn=" + Xn_LCGXn);
        }
        return Xn_LCG;
    }

    public long GenerateNumbersNotUsed(int EntIndex, long IthNum, long NoOfSlots, long Xn_LCG, long Xn_LCGXn, String ObjNameStrStateless) {
        // Collect Unused Numbers
        int i = 0;
        boolean GotUnusedStateFlag = false;
        ArrayList<PatternBits> UnUsedStatesStore = new ArrayList<RandomSimpleLCG.PatternBits>();
        for (i = 0; i < EntPool[EntIndex].MySimple.FreqStore.length; i++) {
            if ((EntPool[EntIndex].MySimple.FreqStore[i] == 0) 
                    || ( (PatternFreqMaxIndex[EntIndex] >0) && (EntPool[EntIndex].MySimple.FreqStore[(int)i] <= (0.5 * PatternFreqMaxIndex[EntIndex])  ) )
                    ) {
                UnUsedStatesStore.add(new PatternBits( i, (int)EntPool[EntIndex].MySimple.FreqStore[i] ) );
                GotUnusedStateFlag = true;
                //System.out.println("GenerateNumbersNotUsed:Got Unused State=" + i);
            }
        }
        Collections.sort(UnUsedStatesStore, new SortbyXn());
        if ((!UnUsedStatesStore.isEmpty()) && (GotUnusedStateFlag == true) &&(Xn_LCG >1) &&( (i/(int)Xn_LCG) < UnUsedStatesStore.size())) {
            Xn_LCG = UnUsedStatesStore.get(i/(int)Xn_LCG).Xn;
        }else if ((!UnUsedStatesStore.isEmpty()) && (GotUnusedStateFlag == true) )
            Xn_LCG = UnUsedStatesStore.get(0).Xn;
        System.out.println("GenerateNumbersNotUsed:Changed Number to Xn_LCG=" + Xn_LCG);
        return Xn_LCG;
    }
 public void PerformanceFormEquation(long Xn, long a, long c, long b, String TechDiffWithRespTo, int MaxExponent){
     Long Xn_LCG=Xn;
     // Form the Equations
        ExprnLCG = FormEquationLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationLocal:a=" + a + " b=" + b + " c=" + c + " ExprnLCG=" + ExprnLCG);
        ConfuseExprnLCG = FormEquationSimpleLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSimpleLocal:ConfuseExprnLCG=" + ConfuseExprnLCG);
        DiffusionExprnLCG = FormEquationSimpleLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSimpleLocal:DiffusionExprnLCG=" + DiffusionExprnLCG);
        SupportExprnLCG = FormEquationSupportLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSupportLocal:SupportExprnLCG=" + SupportExprnLCG);
        SurprisalExprnLCG = FormEquationSurpriseLocal(Xn_LCG, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomSimpleLCG:FormEquationSurpriseLocal:SurprisalExprnLCG=" + SurprisalExprnLCG);
        PerformSeedUnchangedFlag=false;
 }
    /**
     * ****************************************************
     */
    /**
     * ******************************* Stable State IndividualState Elimination
     * Mechanisms End *********************
     */
    /**
     * ****************************************************
     */
    /* ****************************************************************************** */
    ////Functions to Form Equation String Begin
    /* ****************************************************************************** */
    public static String FormEquationE(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        StringBuilder Exprn = new StringBuilder("" + MgtACoeff);
        Exprn.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            } else {
                Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
                //MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            //MgtbCoeff = NextEvenNumber(j);
            j += 2;
            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
        }
        if (MgtbCoeff > 2) {
            Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
        } else {
            Exprn.append(" + ").append(TechDiffWithRespTo);
        }
//        Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        if( (Xn !=0)&&(Mgtc !=0))
//            Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        else
//            Exprn.append(" + ").append(NextEvenNumber(1)).append(" + ").append(NextEvenNumber(1));
        Exprn = new StringBuilder(eatAll(Exprn.toString(), ' '));
        //log.info("FormEquation:Exprn=" + Exprn);
        //System.out.println("FormEquationLocal:Exprn=" + Exprn);
        return Exprn.toString();
    }

    public static String FormEquationKey(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        String Exprn = MgtACoeff + " * " + TechDiffWithRespTo + "^" + (MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
            } else {
                Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff=GetPrimeNumber(MgtbCoeff,i);
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            //MgtbCoeff = NextOddNumber(j);
            j += 2;
            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
        }
//        if (MgtbCoeff > 2) {
//            Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo;
//        } else {
//            Exprn = Exprn + " + " + TechDiffWithRespTo;
//        }
//        Exprn = Exprn + " + " + Xn + " + " + Mgtc;
        Exprn = eatAll(Exprn, ' ');
        //log.info("FormEquation:Exprn=" + Exprn);
        //System.out.println("FormEquation:Exprn=" + Exprn);
        return Exprn;
    }

    public static long ConfusionFunctionValue(int i) {
        InitEquationVar();
        SetFunctions("m*Xn+c");
        SetKeyParts("m*keyx+c");
        return ComputeConfusion(i);
    }

    public static long DiffusionFunctionValue(long i) {

        i = i % NumberOfKeyParts;
        if (( i > 0)&&(i < E.length))
            return K[(int) i].LCGexpValue.eval().longValue();
        else 
            return 1;
    }

    public static void SetFunctions(String Exprn) {
        double m = 1.0;
        double a = 1.0;
        double c = 1.0;
        double b = 1.0;
        String TempExprn = "";
        E = new E_Mapping[NumberOfFunctions];
        for (int i = 0; i < NumberOfFunctions; i++) {
            TempExprn = FormEquationE((int) m, (int) a, (int) c, (int) b, "Xn", (int) MaxExponentORTerms) + "+" + Exprn;
            E[i] = new E_Mapping(TempExprn);
            //System.out.println("Hello World:SetFunctions:TempExprn:" + TempExprn);
        }
    }

    public static void SetKeyParts(String Exprn) {
        double m = 1.0;
        double a = 1.0;
        double c = 1.0;
        double b = 1.0;
        double keyx=1.0;
        String KeyTempExprn = "";
        variables.put("keyx", keyx);
        K = new K_Mapping[NumberOfKeyParts];
        for (int i = 0; i < NumberOfKeyParts; i++) {
            KeyTempExprn = FormEquationKey((int) m + i, (int) a + i, (int) c, (int) b, "keyx", (int) MaxExponentORTerms) + "+" + Exprn;
            K[i] = new K_Mapping(KeyTempExprn);
            //System.out.println("Hello World:SetKeyParts:KeyTempExprn:" + KeyTempExprn);
        }
    }

    /* ****************************************************************************** */
    ////Low level Functions End
    /* ****************************************************************************** */
}
