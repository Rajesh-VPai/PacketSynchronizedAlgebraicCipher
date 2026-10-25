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
import Calculus.MathsContxtLAv;
import static Calculus.DiffrIntegrSep.MyFuncDiff;
import static Calculus.DiffrIntegrSep.parseDiff;
import Calculus.ExprSimpleStrSep.LogLevel;
import static Calculus.MathematicalTestHarness.GBLMyLogLevel;
import static Calculus.MathematicalTestHarness.GBLSilent;
import static Calculus.MathematicalTestHarness.HideInRecurseFlag;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.MathsContxtLAv.eatAll;
import static Calculus.MathsExpressionParser.parse;
import static Calculus.MathsContxtLAv.parseSimple;
import Calculus.MathsExpressionParser;
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
import static RandomNumber.UserResearchStudy.FactorialInitFlagRecordTime;
import static RandomNumber.UserResearchStudy.LCGDyDxPatternLastBits;
import static RandomNumber.UserResearchStudy.LowFactorialInitFlagRecordTime;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.MonoBitOneLCGDyDx;
import static RandomNumber.UserResearchStudy.MonoBitTestFlag;
import static RandomNumber.UserResearchStudy.MonoBitZeroLCGDyDx;
import static RandomNumber.UserResearchStudy.NextOddNumber;
import static RandomNumber.UserResearchStudy.NoOfBits;
import static RandomNumber.UserResearchStudy.NoOfBuffBitsMax;
import static RandomNumber.UserResearchStudy.NoOfSlots;
import static RandomNumber.UserResearchStudy.NumberOfStates;
import static RandomNumber.UserResearchStudy.Path;
import static RandomNumber.UserResearchStudy.PatternFreqMaxIndex;
import static RandomNumber.UserResearchStudy.PatternLength;
import static RandomNumber.UserResearchStudy.PatternRepLength;
import static RandomNumber.UserResearchStudy.RANDProdPerform;
import static RandomNumber.UserResearchStudy.SeedDyDx;
import static RandomNumber.UserResearchStudy.Xn_LCGDyDxXn;
import Shannon_Mapping.E_Mapping;
import Shannon_Mapping.K_Mapping;
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
public class RandomFactorialLCGDyDx {

    public static Logger log = Logger.getLogger(RandomFactorialLCGDyDx.class.getName());

    // Below Set must be different from Above Set for Multivariate Random Number
    //Theory & Source:Wiki Confusion and Diffusion
    public long ConfuseFactorial = 1;//1;
    public long DiffusionFactorial = 2;//2;
    public long ConfuseFunction2Factorial = 1;//1;
    public long DiffusionFunction2Factorial = 1;//1;
    //Theory & Source:Wiki Information Content
    public long SupportFactorial = 3;//3;
    public long SurprisalFactorial = 4;//4;

    private MathsContxtLAv.SimpleExpression FactorialexpSimple;
    private MathsExpressionParser.Expression FactorialexpValue;
    private String FactorialStatelessObjStringLCGDyDx = "";
    private String FactorialStatelessObjNameStrDyDx = "";
    private boolean FactorialexpValueObjExpire = false;
    private MathsExpressionParser.Expression FactorialexpValue2 = (() -> 0.0);
    private boolean FactorialexpValueObjExpire2 = false;
    private String FactorialStatelessObjStringLCGDiff2 = "";
    private String FactorialStatelessObjNameStrDiff2 = "";
    private DiffrIntegrSep.DiffExpr Factorialexp = (() -> "");
    private boolean FactorialexpObjExpire = false;
    private String FactorialStatelessObjStringLCGDiff = "";
    private String FactorialStatelessObjNameStrDiff = "";
    private boolean FactorialXnplus1Avail = false;

    // Core Variables
    public String ExprnLCGDyDx = "";
    public String ConfuseExprnLCGDyDx = "";
    public String DiffusionExprnLCGDyDx = "";
    public String SupportExprnLCGDyDx = "";
    public String SurprisalExprnLCGDyDx = "";

    private long LCGDyDxXValuemin = 0;
    private long LCGDyDxXValuemax = 0;
    private long LCGDyDxXValueInc = 0;

    // I+1th Bit (NextIth Bit)
    //Theory & Source:Wiki next-bit Test
    public long NextIthLCGDyDxPatternRep = 0;
    public long NextIthLCGDyDxPattern = 0;
    public long NextIthLCGDyDxBuffer = 0;
    public long NextIthLCGDyDxPatRecog = 0;
    
    public long GuessLCGDyDx = 0;
    public long GuessLCGDyDxPatRecog = 0;
    public long GuessLCGDyDxRep = 0;
    public long GuessLCGDyDxPattern = 0;
    public long GuessLCGDyDxBuff = 0;

    //LCGDyDx Pattern: 6 7 2 6 3 1 7 5 4 4 4 6 1 5 3 3 6 7 2 1 7 1 1 4 6 1 1 2 2 1 1 3 6 7 4 
    public static long[] LCGDyDxPattern = {12, 45, 86, 65, 22, 52, 6, 7, 2, 6, 3, 1, 7, 5, 4, 4, 4, 6, 1, 5, 3, 3, 6, 7, 2, 1, 7, 1, 1, 4, 6, 1, 1, 2, 2, 1, 1, 3, 6, 7, 4};
    public LinkedList LCGDyDxNextBitDataBuff = new LinkedList();
    public ArrayList<PatternBits> DataStoreLCGDyDx = null;

    // Stats Data Structures
    public double[] FreqStore = null;
    public double[][] FreqMaxStore = null;
    public double[] GaussianPDFStore = null;
    public double[] EntropyPDFStore = null;
    public double[] MeanSigma = null;

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
    public LinkedList<Long> LCGDyDxDataBuff = new LinkedList<>();
    public boolean InitProbablePatternFlag = false;
    public int PatternStartIndex = 10;
    public static Map<String, Double> variables = new HashMap<>();
    
    //Performance Variables
    public static String baseEquationFactorial="";
    // Use ArrayDeque for fast push/pop and HashSet for O(1) lookup
    private ArrayDeque<Long> patternBuffer = new ArrayDeque<>();
    private HashSet<Long> patternSet = new HashSet<>();
    public static boolean PerformPreComputeFlag=true;
    public static boolean PerformSeedUnchangedFlag=true;


    public RandomFactorialLCGDyDx(int Index, long NoOfSlots, long ModulusEncrypt, long Xn_LCGDyDx, long a, long c, long b, long MaxExponent) {
        for(int i=0; i < NoOfSlots; i++)
            ProbablePattern[i] = "";
        variables = new HashMap<>();
        //Form The Prime Number List
        if((baseEquationFactorial.equalsIgnoreCase(""))&&(PerformPreComputeFlag==true) && ((a!=UserResearchStudy.a)&&(b!=UserResearchStudy.b)&&(c!=UserResearchStudy.c)&&(MaxExponent!=UserResearchStudy.MaxExponent)) &&(PerformSeedUnchangedFlag==true)){
            PerformanceFormEquation( Xn_LCGDyDx,  a,  c,  b, "Xn", (int)MaxExponent);
        }else if (((PerformPreComputeFlag)||(PerformSeedUnchangedFlag==true)) && (baseEquationFactorial.equalsIgnoreCase("")) ){
            ExprnLCGDyDx = precomputedEquationBase(a,  c,  b,"Xn", (int)MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationFactorial:a=" + a + " b=" + b + " c=" + c + " ExprnLCGDyDx=" + ExprnLCGDyDx);
        ConfuseExprnLCGDyDx = precomputedEquationBase(a,  c,  b,"Xn", (int)MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSimple:ConfuseExprnLCGDyDx=" + ConfuseExprnLCGDyDx);
        DiffusionExprnLCGDyDx = precomputedEquationBase(a,  c,  b,"Xn", (int)MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSimple:DiffusionExprnLCGDyDx=" + DiffusionExprnLCGDyDx);
        SupportExprnLCGDyDx = precomputedEquationBase(a,  c,  b,"Xn", (int)MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSupport:SupportExprnLCGDyDx=" + SupportExprnLCGDyDx);
        SurprisalExprnLCGDyDx = precomputedEquationBase(a,  c,  b,"Xn", (int)MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSimple:SurprisalExprnLCGDyDx=" + SurprisalExprnLCGDyDx);
        PerformPreComputeFlag=false;
        }
        //ConfuseFactorial = 7 + Index;
        //DiffusionFactorial = 11 + Index;
        //SupportFactorial = 17 + Index;
        //SurprisalFactorial = 19 + Index;
        DocumentInitValues(Index, NoOfSlots, ModulusEncrypt, Xn_LCGDyDx, Xn_LCGDyDxXn, a, c, b, MaxExponent);
        FreqStore = new double[(int) NumberOfStates];
        FreqMaxStore = new double[NumberOfStates][2];
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
        DataStoreLCGDyDx = null;
        DataStoreLCGDyDx = new ArrayList<RandomFactorialLCGDyDx.PatternBits>();
        for (int i = 0; i < NumberOfStates; i++) {
            DataStoreLCGDyDx.add(new PatternBits(i, 0));
        }
        if (ReadExpireStr.equalsIgnoreCase("Number")) {
            ReadExpireMax = ReadExpireMax;
        } else if (ReadExpireStr.equalsIgnoreCase("FactorNumberOfBits")) {
            ReadExpireMax = NoOfBits / ReadExpireFactor;
        } else if (ReadExpireStr.equalsIgnoreCase("Linear")) {
            ReadExpireMax = ReadExpireMax + NoOfBits / ReadExpireFactor;
        }
        FactorialInitFlagRecordTime = false;
        LowFactorialInitFlagRecordTime = false;
        
    }

    void DocumentInitValues(long Index, long NoOfSlots, long ModulusEncrypt, long Xn_LCG, long Xn_LCGDyDx, long a, long c, long b, long MaxExponent) {
        //Init Values
        InitValue.put("InitVal" + Index, "" + Xn_LCGDyDx);
        InitValue.put("a" + Index, "" + a);
        InitValue.put("c" + Index, "" + c);
        InitValue.put("b" + Index, "" + b);
        InitValue.put("ModulusEncrypt" + Index, "" + ModulusEncrypt);
        InitValue.put("MaxExponent" + Index, "" + MaxExponent);

        //Equations
        InitValue.put("Exprn" + Index, ExprnLCGDyDx);
        InitValue.put("ConfuseExprn" + Index, ConfuseExprnLCGDyDx);
        InitValue.put("DiffusionExprn" + Index, DiffusionExprnLCGDyDx);
        InitValue.put("SupportExprn" + Index, SupportExprnLCGDyDx);
        InitValue.put("SurprisalExprn" + Index, SurprisalExprnLCGDyDx);

        // Seed Values
        InitValue.put("ConfuseFactorial" + Index, "" + ConfuseFactorial);
        InitValue.put("DiffusionFactorial" + Index, "" + DiffusionFactorial);
        InitValue.put("SupportFactorial" + Index, "" + SupportFactorial);
        InitValue.put("SurprisalFactorial" + Index, "" + SurprisalFactorial);

    }

    static String FormEquation(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
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
            MgtbCoeff = NextOddNumber(j);
            j += 2;
            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
        }
        if (MgtbCoeff > 2) {
            Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo;
        } else {
            Exprn = Exprn + " + " + TechDiffWithRespTo;
        }
        Exprn = Exprn + " + " + Xn + " + " + Mgtc;
        Exprn = eatAll(Exprn, ' ');
        //log.info("FormEquation:Exprn=" + Exprn);
        //System.out.println("FormEquation:Exprn=" + Exprn);
        return Exprn;
    }

    // Precompute static part once
public static String precomputedEquationBase(long MgtACoeff, long MgtcCoeff, long MgtbCoeff,
                                              String TechDiffWithRespTo, int MgtMaxExponent) {
    StringBuilder exprn = new StringBuilder();
    exprn.append(MgtACoeff).append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);

    for (int i = MgtMaxExponent - 1; i > 1; i--) {
        exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
        MgtbCoeff = NextOddNumber(3 + 2 * (MgtMaxExponent - i)); // precompute odd increments
    }

    if (MgtbCoeff > 2) {
        exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
    } else {
        exprn.append(" + ").append(TechDiffWithRespTo);
    }

    return eatAll(exprn.toString(), ' ');
}

// Add current state only
static String FormEquationFactorial(long Xn, long Mgtc, String baseEquation) {
    StringBuilder exprn = new StringBuilder(baseEquation);
    if ((Xn != 0) && (Mgtc != 0)) {
        exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
    } else {
        exprn.append(" + ").append(NextOddNumber(1)).append(" + ").append(NextOddNumber(1));
    }
    return exprn.toString();
}

    static String FormEquationFactorialLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
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
//            MgtbCoeff = NextOddNumber(j);
//            j += 2;
//            //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff + " i=" + i);
//        }
//        if (MgtbCoeff > 2) {
//            Exprn.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
//        } else {
//            Exprn.append(" + ").append(TechDiffWithRespTo);
//        }
//        //Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        if ((Xn != 0) && (Mgtc != 0)) {
//            Exprn.append(" + ").append(Xn).append(" + ").append(Mgtc);
//        } else {
//            Exprn.append(" + ").append(NextOddNumber(1)).append(" + ").append(NextOddNumber(1));
//        }
//        Exprn = new StringBuilder(eatAll(Exprn.toString(), ' '));
//        //log.info("FormEquation:Exprn=" + Exprn);
//        //System.out.println("FormEquationFactorial:Exprn=" + Exprn);
//        return Exprn.toString();
String Exprn=FormEquationFactorial( Xn,  Mgtc, baseEquationFactorial);
    return Exprn;
    }

    static String FormEquationSimpleLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
            //System.out.println("FormEquationSimpleLocal:Reached:i=" + i + " MgtbCoeff=" + MgtbCoeff);
        }
        if (MgtbCoeff > 2) {
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc);
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSimple:Exprn=" + Exprn);
        return Exprn;
    }

    static String FormEquationSupportLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            } else {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
                //MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc).append(" * ").append(SeedDyDx++);
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSupport:Exprn=" + Exprn);
        return Exprn;
    }

    static String FormEquationSurpriseLocal(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append("/").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            } else {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
                //MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc).append(" * ").append(SeedDyDx++);
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSurprise:Exprn=" + Exprn);
        return Exprn;
    }

    void GetExprnMinMaxRangeLCGDyDx(long Xn, String DiffWithRespTo, long Modulus, int NoOfTimes) {
        this.LCGDyDxXValuemax = Modulus;
        if (Xn > 0) {
            this.LCGDyDxXValuemin = Xn;
        } else {
            this.LCGDyDxXValuemin = -Modulus;
        }
        if (Modulus > 0) {
            this.LCGDyDxXValueInc = NoOfTimes * 1 / Modulus;
        } else if ((Modulus != 0) && (this.LCGDyDxXValueInc == NoOfTimes * 1 / Modulus)) {
            this.LCGDyDxXValueInc = NoOfTimes * 1 / this.LCGDyDxXValuemax;
        } else {
            this.LCGDyDxXValueInc = 1;
        }
    }

    void UpdateStats(long Xn_LCGDyDx) {
        if ((NextIthLCGDyDxPatRecog == Xn_LCGDyDx)
                || (NextIthLCGDyDxPatternRep == Xn_LCGDyDx)
                || (NextIthLCGDyDxPattern == Xn_LCGDyDx)
                || (NextIthLCGDyDxBuffer == Xn_LCGDyDx)) {
            GuessLCGDyDx++;
            if (NextIthLCGDyDxPatRecog == Xn_LCGDyDx) {
                GuessLCGDyDxPatRecog++;
            }
            if (NextIthLCGDyDxPatternRep == Xn_LCGDyDx) {
                GuessLCGDyDxRep++;
            }
            if (NextIthLCGDyDxPattern == Xn_LCGDyDx) {
                GuessLCGDyDxPattern++;
            }
            if (NextIthLCGDyDxBuffer == Xn_LCGDyDx) {
                GuessLCGDyDxBuff++;
            }
        }
    }

    void DetectLCGDyDxPattern(int EntIndex, long NoOfSlots, long Xn, int k) {
        boolean LoopAssignFlag = false;

//        // Extract Freq Distribution Info from FreqStore
//        if ((PatternFreqMaxIndex[EntIndex] < PatternLength)
//                && (Xn >= 0)
//                && (Xn < this.FreqStore.length)
//                && (PatternFreqMaxIndex[EntIndex] == 0)
//                && (this.FreqMaxStore[0][0] == 0) && (this.FreqMaxStore[0][1] == 0)) {
//            this.FreqMaxStore[0][0] = Xn;
//            this.FreqMaxStore[0][1] = this.FreqStore[(int) Xn];
//            PatternFreqMaxIndex[EntIndex]++;
//        } else if ((PatternFreqMaxIndex[EntIndex] < PatternLength)
//                && (PatternFreqMaxIndex[EntIndex] == 0)
//                && (Xn == this.FreqMaxStore[0][0])
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
//            if (((LoopAssignFlag == false) && (PatternFreqMaxIndex[EntIndex] < PatternLength) && (Xn >= 0))
//                    && (PatternFreqMaxIndex[EntIndex] > 0)
//                    && (Xn < this.FreqStore.length)
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
        this.Mean += Xn;
        //Sort by Frequency
        this.DataStoreLCGDyDx.clear();
        for (int i = 0; i < EntPool[EntIndex].MyFactorial.FreqStore.length-1; i++) {
            if (Xn < this.FreqStore.length)
                this.DataStoreLCGDyDx.add(new PatternBits(((int) Xn), ((int) this.FreqStore[(int)Xn]) ) );
        }
        Collections.sort(this.DataStoreLCGDyDx, new SortbyFreq());
    }

    void SearcNFormLCGDyDxPattern(int EntIndex, long Xn) {
        int i = 0;
        int j = 0;
        for (i = 0; (i < PatternFreqMaxIndex[EntIndex])&&(i < this.DataStoreLCGDyDx.size()); i++) {
            if ((Xn != this.DataStoreLCGDyDx.get(i).Xn))
                   ; else {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((i < PatternFreqMaxIndex[EntIndex]) && (i < this.DataStoreLCGDyDx.size()) && ((i + 1) <= this.DataStoreLCGDyDx.size())) {
            this.NextIthLCGDyDxPatRecog = (long) this.DataStoreLCGDyDx.get(i).Xn;
        }//Random Pattern
        else if ((i < PatternFreqMaxIndex[EntIndex]) && ((i) < this.DataStoreLCGDyDx.size()) && (this.DataStoreLCGDyDx.get(i).Freq > 1)) {
            this.NextIthLCGDyDxPatRecog = (long) this.DataStoreLCGDyDx.get(i + 1).Xn;
        }
    }

void PatternRepetionTest(long IthXn) {
    // Check membership in O(1)
    if (patternSet.contains(IthXn)) {
        // If found, set next pattern directly
        this.NextIthLCGDyDxPatternRep = IthXn;
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

//    void PatternRepetionTest(int i, long IthXn_LCGDyDx) {
//        int j = 0;
//
//        if (LCGDyDxPatternLastBits.isEmpty()) {
//            LCGDyDxPatternLastBits.addLast(IthXn_LCGDyDx);
//        } else {
//            for (j = 0; j < LCGDyDxPatternLastBits.size() - 1; j++) {
//                if ((long) LCGDyDxPatternLastBits.get(j) == IthXn_LCGDyDx) {
//                    break;
//                }
//            }
//            //Found PatternBit
//            //Constant Pattern
//            if ((j < LCGDyDxPatternLastBits.size()) && ((j + 1) <= LCGDyDxPatternLastBits.size())) {
//                this.NextIthLCGDyDxPatternRep = (long) LCGDyDxPatternLastBits.get(j);
//            }//Random Pattern
//            else if (j < LCGDyDxPatternLastBits.size() - 1) {
//                this.NextIthLCGDyDxPatternRep = (long) LCGDyDxPatternLastBits.get(j + 1);
//            }
//            if (LCGDyDxPatternLastBits.size() < PatternRepLength) {
//                LCGDyDxPatternLastBits.push(IthXn_LCGDyDx);
//            } else if (LCGDyDxPatternLastBits.size() == PatternRepLength) {
//                LCGDyDxPatternLastBits.removeFirst();
//                LCGDyDxPatternLastBits.push(IthXn_LCGDyDx);
//            }
//        }
//    }

    void PatternTest(int i, long IthXn_LCGDyDx) {
        int j = 0;
        for (j = 0; j < LCGDyDxPattern.length; j++) {
            if (LCGDyDxPattern[j] == IthXn_LCGDyDx) {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((j < LCGDyDxPattern.length) && ((j + 1) <= LCGDyDxPattern.length)) {
            this.NextIthLCGDyDxPattern = LCGDyDxPattern[j];
        }//Random Pattern
        else if (j < LCGDyDxPattern.length) {
            this.NextIthLCGDyDxPattern = LCGDyDxPattern[j + 1];
        }
    }

    void BufferTest(int i, long IthXn_LCGDyDx) {
        int j = 0;
        for (j = 0; j < LCGDyDxNextBitDataBuff.size() - 1; j++) {
            if ((long) LCGDyDxNextBitDataBuff.get(j) == IthXn_LCGDyDx) {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((j < LCGDyDxNextBitDataBuff.size()) && ((j + 1) < LCGDyDxNextBitDataBuff.size())) {
            this.NextIthLCGDyDxBuffer = (long) LCGDyDxNextBitDataBuff.get(j);
        }//Random Pattern
        else if (j < LCGDyDxNextBitDataBuff.size() - 1) {
            this.NextIthLCGDyDxBuffer = (long) LCGDyDxNextBitDataBuff.get(j + 1);
        }
    }

    void ReadFromFile(int j, int EntIndex, long NoOfBuffBitsMax, long Xn_LCGDyDx, String RunNumber) {
        try {
            String FileName = Path + "RNDXn_LCGDyDx" + RunNumber + "_TESTSUITE_" + j;
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
                this.LCGDyDxNextBitDataBuff.clear();
                int k = Temp.size() - 1;
                int i = (k - (int) NoOfBuffBitsMax);
                if (i < 0) {
                    for (i = 0; (i < Temp.size()); i++) {
                        data = (long) Temp.get(i);
                        if (NoOfBuffBitsMax > this.LCGDyDxNextBitDataBuff.size()) {
                            this.LCGDyDxNextBitDataBuff.add(data);
                        } else {
                            this.LCGDyDxNextBitDataBuff.push(data);
                        }
                    }
                } else {
                    for (; (i < Temp.size()); i++) {
                        data = (long) Temp.get(i);
                        if (NoOfBuffBitsMax > this.LCGDyDxNextBitDataBuff.size()) {
                            this.LCGDyDxNextBitDataBuff.add(data);
                        } else {
                            this.LCGDyDxNextBitDataBuff.push(data);
                        }
                    }
                }
                ReadExpireFlag = true;
            } else {
                this.LCGDyDxNextBitDataBuff.add(Xn_LCGDyDx);
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
        System.out.println("LCGDyDx InitValues:" + Index);
        //PrintSeedValues(Index);
        PrintMeanValues(Index);
        System.out.printf("GuessLCGDyDx=%d %%=%5.4f\n", EntPool[Index].MyFactorial.GuessLCGDyDx, (100.0 * (double) EntPool[Index].MyFactorial.GuessLCGDyDx / (double) NoOfBits));
        System.out.printf("GuessLCGDyDxPatRecog=%d %%=%5.4f\n", EntPool[Index].MyFactorial.GuessLCGDyDxPatRecog, (100.0 * (double) EntPool[Index].MyFactorial.GuessLCGDyDxPatRecog / (double) NoOfBits));
        System.out.printf("GuessLCGDyDxRep=%d %%=%5.4f\n", EntPool[Index].MyFactorial.GuessLCGDyDxRep, (100.0 * (double) EntPool[Index].MyFactorial.GuessLCGDyDxRep / (double) NoOfBits));
        System.out.printf("GuessLCGDyDxPattern=%d %%=%5.4f\n", EntPool[Index].MyFactorial.GuessLCGDyDxPattern, (100.0 * (double) EntPool[Index].MyFactorial.GuessLCGDyDxPattern / (double) NoOfBits));
        System.out.printf("GuessLCGDyDxBuff=%d %%=%5.4f\n", EntPool[Index].MyFactorial.GuessLCGDyDxBuff, (100.0 * (double) EntPool[Index].MyFactorial.GuessLCGDyDxBuff / (double) NoOfBits));
        if (MonoBitTestFlag == true) {
            System.out.printf("Monobit:0:LCGDyDx:Index:%d:MonoBitZero=%d\n", Index, MonoBitZeroLCGDyDx);
            System.out.printf("Monobit:1:LCGDyDx:Index:%d:MonoBitONE=%d\n", Index, MonoBitOneLCGDyDx);
        }
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());
        //PrintFreqStore(Index);
        PrintFreqMaxStore(Index);
        System.out.print(System.lineSeparator());
        EntPool[Index].MyFactorial.GuessLCGDyDx = 0;
        EntPool[Index].MyFactorial.GuessLCGDyDxPatRecog = 0;
        EntPool[Index].MyFactorial.GuessLCGDyDxRep = 0;
        EntPool[Index].MyFactorial.GuessLCGDyDxPattern = 0;
        EntPool[Index].MyFactorial.GuessLCGDyDxBuff = 0;
        MonoBitZeroLCGDyDx = 0;
        MonoBitOneLCGDyDx = 0;

    }

    void PrintSeedValues(int Index) {
        System.out.println("LCGDyDx InitVal:" + this.InitValue.get("InitVal" + Index));
        System.out.println("LCGDyDx a:" + this.InitValue.get("a" + Index));
        System.out.println("LCGDyDx c:" + this.InitValue.get("c" + Index));
        System.out.println("LCGDyDx b:" + this.InitValue.get("b" + Index));
        System.out.println("LCGDyDx ModulusEncrypt:" + this.InitValue.get("ModulusEncrypt" + Index));
        System.out.println("LCGDyDx MaxExponent:" + this.InitValue.get("MaxExponent" + Index));

        System.out.println("LCGDyDx Seed Equations:" + Index);
        System.out.println("LCGDyDx Exprn:" + this.InitValue.get("Exprn" + Index));
        System.out.println("LCGDyDx ConfuseExprn:" + this.InitValue.get("ConfuseExprn" + Index));
        System.out.println("LCGDyDx DiffusionExprn:" + this.InitValue.get("DiffusionExprn" + Index));
        System.out.println("LCGDyDx SupportExprn:" + this.InitValue.get("SupportExprn" + Index));
        System.out.println("LCGDyDx SurprisalExprn:" + this.InitValue.get("SurprisalExprn" + Index));

        System.out.println("LCGDyDx Seed Values:" + Index);
        System.out.println("LCGDyDx ConfuseFactorial:" + this.InitValue.get("ConfuseFactorial" + Index));
        System.out.println("LCGDyDx DiffusionFactorial:" + this.InitValue.get("DiffusionFactorial" + Index));
        System.out.println("LCGDyDx SupportFactorial:" + this.InitValue.get("SupportFactorial" + Index));
        System.out.println("LCGDyDx SurprisalFactorial:" + this.InitValue.get("SurprisalFactorial" + Index));

    }

    void PrintMeanValues(int Index) {
        System.out.println("LCGDyDx Stats:" + Index + ":Mean=" + this.MeanSigma[0] + " Low Level Mean=" + this.Mean / NoOfBits);
        System.out.println("LCGDyDx Stats:" + Index + ":Sigma=" + this.MeanSigma[1]);
        System.out.println("LCGDyDx Stats:" + Index + ":Sigma(2 bit)=" + this.MeanSigma[2]);

    }

    void PrintFreqStore(int Index) {
        for (int i = 0; i < NoOfSlots; i++) {
            System.out.println("LCGDyDx Stats: i=" + i + " " + FreqStore[i] + " Probability=" + GaussianPDFStore[i] + " TheoryProb=" + (100.0 * RandomNumber.Probability(i, MeanSigma[0], MeanSigma[1])) + " Actual=" + 100 * FreqStore[i] / NoOfBits);
        }
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

    }

    void PrintFreqMaxStore(int Index) {
        int Freq1 = 0;
        double mean = 0.0;
        Collections.sort(this.DataStoreLCGDyDx, new SortbyXn());
        for (int i = 0; i < EntPool[Index].MyFactorial.FreqStore.length; i++) {
            if ( (EntPool[Index].MyFactorial.FreqStore[i] > 0)) {
                Freq1 += EntPool[Index].MyFactorial.FreqStore[i];
                mean += i * EntPool[Index].MyFactorial.FreqStore[i];
                System.out.println("LCGDyDx Stats:" + Index + ":Max:i=" + i + " Number=" + i + " " + EntPool[Index].MyFactorial.FreqStore[i]);
            }
        }
        System.out.println("LCGDyDx Stats:" + Index + " :Max:Freq1=" + Freq1 + " mean=" + (mean / NoOfBits) + ":PatternFreqMaxIndex[Index]=" + PatternFreqMaxIndex[Index] + " Index=" + Index);
    }

    public void TestInfraSingle(int j, int i, long Xn_LCGDyDx, String FileName, String RunNumber) {
        try{
        WriteToFileInfra(j, i, Xn_LCGDyDx, NoOfBuffBitsMax, FileName, RunNumber);
        StatsSingle(0, Xn_LCGDyDx);
        //ReadFromFile(j, 0, NoOfBuffBitsMax, Xn_LCGDyDx, RunNumber);
        //readMemoryMappedFile("data\\entropy.dat");
        readEntropy("data\\Xn_LCGDyDxentropy.dat",1);
        DetectLCGDyDxPattern(0, NoOfSlots, Xn_LCGDyDx, i);
        GuessNextIthBit(0, i, Xn_LCGDyDx);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void GuessNextIthBit(int EntIndex, int i, long IthXn_LCGDyDx) {
        this.SearcNFormLCGDyDxPattern(0, IthXn_LCGDyDx);
        this.PatternRepetionTest(IthXn_LCGDyDx);
        this.PatternTest(i, IthXn_LCGDyDx);
        this.BufferTest(i, IthXn_LCGDyDx);
    }

    static void WriteToFileInfra(int j, int i, long Xn_LCGDyDx, long NoOfBuffBitsMax, String FileName, String RunNumber) {
        //if (i < NoOfBuffBitsMax) {
        FileWriter fp = null;
        BufferedWriter bw = null;
        PrintWriter fpout = null;
        FileName = Path + FileName + RunNumber + "_TESTSUITE_" + j;
        String DataLCG = "" + Xn_LCGDyDx + " ";
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

    void StatsSingle(int EntIndex, long Xn_LCGDyDx) {
        int i = EntIndex;
//for (int i = EntIndex; i < EntPoolIndex; i++) {
        this.FreqStore[(int) Xn_LCGDyDx]++;
        this.UpdateStats(Xn_LCGDyDx);
        //}
    }

    class PatternBits {

        int Xn = 0;
        int Freq = 0;

        public PatternBits(int myXn, int myFreq) {
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
     * ******************************* Random Generation Mechanisms Begin
     * *********************
     */
    /**
     * ****************************************************
     */
    public long LCG_Factorial_RandomSimple(int EntIndex, String ObjNameStrStateless, long Xn_LCGDyDx, long a, long c, int Modulus, int MaxExponent, int ModulusEncrypt, long IthNum) {
        String TempSupportExprnLCGDyDx = SupportExprnLCGDyDx;
        String TempSurprisalExprnLCGDyDx = SurprisalExprnLCGDyDx;
//        if (FactorialInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTimeOverall = Double.parseDouble(TimeTaken[2]);
//            System.out.println("LCG_Factorial_RandomSimple:Started:Run Started Time:" + current + " ");
//        }
        //long Xn_LCGDyDxXn = Xn_LCGDyDx;
        long ConfuseFactorialXn = ConfuseFactorial;
        long DiffusionFactorialXn = DiffusionFactorial;
        long ConfuseFunction2FactorialXn = ConfuseFunction2Factorial;
        long DiffusionFunction2FactorialXn = DiffusionFunction2Factorial;
        long SupportFactorialXn = SupportFactorial;
        long SurprisalFactorialXn = SurprisalFactorial;

        FactorialStatelessObjStringLCGDyDx = "Xn_LCGDyDx";
        FactorialStatelessObjStringLCGDiff2 = "Xn_LCGDyDx";
        FactorialStatelessObjStringLCGDiff = "Xn_LCGDyDx";
        FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
        //System.out.println("1LCG_Factorial_RandomSimple:Initial:" + ObjNameStrStateless + ":Xn_LCGDyDx=" + Xn_LCGDyDx + " ConfuseFactorial=" + ConfuseFactorial + " DiffusionFactorial=" + DiffusionFactorial + " SupportFactorial=" + SupportFactorial + " SurprisalFactorial=" + SurprisalFactorial);
        if (FactorialInitFlagRecordTime == false) {
            Xn_LCGDyDx = InitialUncertainity(ObjNameStrStateless, Xn_LCGDyDx, a, c, Modulus, MaxExponent, ModulusEncrypt);
        }
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (FactorialInitFlagRecordTime == true)) {
            ResetFactorialObj();
        }
        FactorialStatelessObjStringLCGDyDx = "Xn_LCGDyDx";
        FactorialStatelessObjStringLCGDiff2 = "Xn_LCGDyDx";
        FactorialStatelessObjStringLCGDiff = "Xn_LCGDyDx";
        FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
        Xn_LCGDyDx = (LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", ExprnLCGDyDx, a, c, Xn_LCGDyDx, Modulus, MaxExponent, "Xn_LCGDyDx", ObjNameStrStateless));
        
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (FactorialInitFlagRecordTime == true)) {
            ResetFactorialObj();
        }
        FactorialStatelessObjStringLCGDyDx = "ConfuseFactorial";
        FactorialStatelessObjStringLCGDiff2 = "ConfuseFactorial";
        FactorialStatelessObjStringLCGDiff = "ConfuseFactorial";
        FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            ConfuseFactorial = (ConfuseFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", ConfuseExprnLCGDyDx, a, c, Xn_LCGDyDx, (int) ModulusEncrypt, ModulusEncrypt, "ConfuseFactorial", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        ConfuseFunction2Factorial = ConfusionFactorialValue((int) ConfuseFunction2Factorial);
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (FactorialInitFlagRecordTime == true)) {
            ResetFactorialObj();
        }
        FactorialStatelessObjStringLCGDyDx = "DiffusionFactorial";
        FactorialStatelessObjStringLCGDiff2 = "DiffusionFactorial";
        FactorialStatelessObjStringLCGDiff = "DiffusionFactorial";
        FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
        if (ModulusEncrypt > 0) {
            DiffusionFactorial = (DiffusionFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", DiffusionExprnLCGDyDx, a, c, Xn_LCGDyDx, (int) ModulusEncrypt, ModulusEncrypt, "DiffusionFactorial", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        DiffusionFunction2Factorial = DiffusionFactorialValue((int) DiffusionFunction2Factorial);
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (FactorialInitFlagRecordTime == true)) {
            ResetFactorialObj();
        }
        FactorialStatelessObjStringLCGDyDx = "SupportFactorial";
        FactorialStatelessObjStringLCGDiff2 = "SupportFactorial";
        FactorialStatelessObjStringLCGDiff = "SupportFactorial";
        FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
        TempSupportExprnLCGDyDx = SupportExprnLCGDyDx + "-" + SupportFactorial;
        if (ModulusEncrypt > 0) {
            SupportFactorial = (SupportFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", TempSupportExprnLCGDyDx, a, c, Xn_LCGDyDx, (int) ModulusEncrypt, ModulusEncrypt, "SupportFactorial", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        if ((RANDProdPerform.equalsIgnoreCase("Normal")) && (FactorialInitFlagRecordTime == true)) {
            ResetFactorialObj();
        }
        FactorialStatelessObjStringLCGDyDx = "SurprisalFactorial";
        FactorialStatelessObjStringLCGDiff2 = "SurprisalFactorial";
        FactorialStatelessObjStringLCGDiff = "SurprisalFactorial";
        FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
        FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
        TempSupportExprnLCGDyDx = SurprisalExprnLCGDyDx + "-" + SurprisalFactorial;
        if (ModulusEncrypt > 0) {
            SurprisalFactorial = (SurprisalFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", TempSupportExprnLCGDyDx, a, c, Xn_LCGDyDx, (int) ModulusEncrypt, ModulusEncrypt, "SurpriseFactorial", ObjNameStrStateless)) % (ModulusEncrypt);
        }
        //System.out.println("2LCG_Factorial_RandomSimple:Middle:Xn_LCGDyDx=" + Xn_LCGDyDx + " ConfuseFactorial=" + ConfuseFactorial + " DiffusionFactorial=" + DiffusionFactorial + " SupportFactorial=" + SupportFactorial + " SurprisalFactorial=" + SurprisalFactorial);
        if (Modulus > 0) {
            Xn_LCGDyDx = (Xn_LCGDyDx + ConfuseFactorial + DiffusionFactorial - SupportFactorial + SurprisalFactorial) % (Modulus);
        }
        //System.out.println("3    LCG_Factorial_RandomSimple:Final:" + ObjNameStrStateless + ":Xn_LCGDyDx=" + Xn_LCGDyDx + " ConfuseFactorial=" + ConfuseFactorial + " DiffusionFactorial=" + DiffusionFactorial + " SupportFactorial=" + SupportFactorial + " SurprisalFactorial=" + SurprisalFactorial);
        Xn_LCGDyDx = EliminateIndividualState(Xn_LCGDyDx, ObjNameStrStateless, Xn_LCGDyDxXn, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        if(Xn_LCGDyDx == Xn_LCGDyDxXn)
            Xn_LCGDyDx = EliminatePatternInSet(Xn_LCGDyDx, ObjNameStrStateless, Xn_LCGDyDxXn, IthNum);
        else if ( (AntiCounterModeFlag==true) && (Modulus < 8)   )
            Xn_LCGDyDx = EliminatePatternInSet(Xn_LCGDyDx, ObjNameStrStateless, Xn_LCGDyDxXn, IthNum);
        else if(Xn_LCGDyDx != Xn_LCGDyDxXn)
            Xn_LCGDyDx = EliminatePatternInSet(Xn_LCGDyDx, ObjNameStrStateless, Xn_LCGDyDxXn, IthNum);
        if (Xn_LCGDyDx < 0) {
            Xn_LCGDyDx = Xn_LCGDyDx * -1;
        }
//        if (FactorialInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTimeOverall = Double.parseDouble(TimeTaken[2]) - CompletionTimeOverall;
//            System.out.println("LCG_Factorial_RandomSimple:Completed:Run Started Time:" + current + " " + " FactorialInitFlagRecordTime=" + FactorialInitFlagRecordTime + " Modulus=" + Modulus + " MaxExponent=" + MaxExponent + " ModulusEncrypt=" + ModulusEncrypt + " CompletionTimeOverall=" + CompletionTimeOverall * 1000 + " millisecs");
//            FactorialInitFlagRecordTime = true;
//        }
        this.LCGDyDxDataBuff.add(Xn_LCGDyDx);
        return Xn_LCGDyDx;
    }

    long InitialUncertainity(String ObjNameStrStateless, long Xn_LCGDyDx, long a, long c, int Modulus, int MaxExponent, int ModulusEncrypt) {
        if (FactorialInitFlagRecordTime == false) {
            ResetFactorialObj();
            FactorialStatelessObjStringLCGDyDx = "Xn_LCGDyDx";
            FactorialStatelessObjStringLCGDiff2 = "Xn_LCGDyDx";
            FactorialStatelessObjStringLCGDiff = "Xn_LCGDyDx";
            FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
            if (ModulusEncrypt > 0) {
                Xn_LCGDyDx = (Xn_LCGDyDx + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", ExprnLCGDyDx, a, c, Xn_LCGDyDx, Modulus, MaxExponent, "Xn_LCGDyDx", ObjNameStrStateless)) % (ModulusEncrypt);
            }
            ResetFactorialObj();
            FactorialStatelessObjStringLCGDyDx = "ConfuseFactorial";
            FactorialStatelessObjStringLCGDiff2 = "ConfuseFactorial";
            FactorialStatelessObjStringLCGDiff = "ConfuseFactorial";
            FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
            if (ModulusEncrypt > 0) {
                ConfuseFactorial = (ConfuseFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", ConfuseExprnLCGDyDx, a, c, ConfuseFactorial, (int) ModulusEncrypt, ModulusEncrypt, "ConfuseValue", ObjNameStrStateless)) % (ModulusEncrypt);
            }
            ResetFactorialObj();
            FactorialStatelessObjStringLCGDyDx = "DiffusionFactorial";
            FactorialStatelessObjStringLCGDiff2 = "DiffusionFactorial";
            FactorialStatelessObjStringLCGDiff = "DiffusionFactorial";
            FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
            if (ModulusEncrypt > 0) {
                DiffusionFactorial = (DiffusionFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", DiffusionExprnLCGDyDx, a, c, DiffusionFactorial, (int) ModulusEncrypt, ModulusEncrypt, "DiffusionValue", ObjNameStrStateless)) % (ModulusEncrypt);
            }
            ResetFactorialObj();
            FactorialStatelessObjStringLCGDyDx = "SupportFactorial";
            FactorialStatelessObjStringLCGDiff2 = "SupportFactorial";
            FactorialStatelessObjStringLCGDiff = "SupportFactorial";
            FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
            SupportExprnLCGDyDx = SupportExprnLCGDyDx + "-" + SupportFactorial;
            if (ModulusEncrypt > 0) {
                SupportFactorial -= (SupportFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", SupportExprnLCGDyDx, a, c, SupportFactorial, (int) ModulusEncrypt, ModulusEncrypt, "SupportValue", ObjNameStrStateless)) % (ModulusEncrypt);
            }
            ResetFactorialObj();
            FactorialStatelessObjStringLCGDyDx = "SurprisalFactorial";
            FactorialStatelessObjStringLCGDiff2 = "SurprisalFactorial";
            FactorialStatelessObjStringLCGDiff = "SurprisalFactorial";
            FactorialStatelessObjNameStrDyDx = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff = ObjNameStrStateless;
            FactorialStatelessObjNameStrDiff2 = ObjNameStrStateless;
            SurprisalExprnLCGDyDx = SurprisalExprnLCGDyDx + "-" + SurprisalFactorial;
            if (ModulusEncrypt > 0) {
                SurprisalFactorial = (SurprisalFactorial + LCG_Factorial_Random_Stateless("LCG_Factorial_RandomSimple", SurprisalExprnLCGDyDx, a, c, SurprisalFactorial, (int) ModulusEncrypt, ModulusEncrypt, "SurpriseValue", ObjNameStrStateless)) % (ModulusEncrypt);
            }
            //System.out.println("LCG_Factorial_RandomSimple:Middle:Xn_LCGDyDx=" + Xn_LCGDyDx + " ConfuseFactorial=" + ConfuseFactorial + " DiffusionFactorial=" + DiffusionFactorial);
        }
        if (Xn_LCGDyDx < 0) {
            Xn_LCGDyDx = Xn_LCGDyDx * -1;
        }
        return Xn_LCGDyDx;
    }

    void ResetFactorialObj() {
        FactorialexpValueObjExpire = false;
        FactorialexpObjExpire = false;
        FactorialexpValueObjExpire2 = false;
        FactorialStatelessObjStringLCGDyDx = "";
        FactorialStatelessObjStringLCGDiff2 = "";
        FactorialStatelessObjStringLCGDiff = "";
        FactorialStatelessObjNameStrDyDx = "";
        FactorialStatelessObjNameStrDiff = "";
        FactorialStatelessObjNameStrDiff2 = "";
    }

    // The LCG_Factorial_Random Method uses F(x)==Xn && ODE Dy/Dx(F(x))== Xn
    // If Xn != Xn+1, Method Returns Xn+1
    // This can be viewed as a Lyapunov Function Also 
    //(Source :wikiLyapunov) where F'(x)=F(x)
    public long LCG_Factorial_Random_Memory(String AlgoName, String Exprn, long a, long c, long Xn, long Modulus, long MaxExponent, String EqnCompFlag) {
//        if (LowFactorialInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTime = Double.parseDouble(TimeTaken[2]);
//            System.out.println("LCG_Factorial_Random_Memory:Started:Run Started Time:" + current + " ");
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
        GetExprnMinMaxRangeLCGDyDx(Xn, DiffWithRespTo, Modulus, 10);
        FactorialXnplus1Avail = false;
        for (long x = LCGDyDxXValuemin; (i < 5) && ((i < 3) || (Xn == Xnplus1) || (TempXn == Xnplus1)); x += LCGDyDxXValueInc, i++) {
            variables.put(DiffWithRespTo, ((double) x));
            if (FactorialexpValueObjExpire == false) {
                FactorialexpValue = parse(Exprn, variables, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
                FactorialexpValueObjExpire = true;
            }
            //F(x)==Xn 
            TempXn = (long) ((FactorialexpValue.eval()) % (Modulus));
            if ((TempXn == Xn) || (i >= 1)) {
                StrexpSimpleExpress = eatAll(Exprn, ' ');
                if (FactorialexpObjExpire == false) {
                    StrexpSimpleExpress = StrexpSimpleExpress + "-" + Xnplus1 + "-" + Xn;
                    StrexpSimpleExpress = eatAll(StrexpSimpleExpress, ' ');
                    Factorialexp = parseDiff(StrexpSimpleExpress, variables, DiffWithRespTo,"Map1", "Diffr");
                    FactorialexpObjExpire = true;
                }
                StrexpDiffExpress = Factorialexp.DiffExpr();
                StrexpSimpleExpress = eatAll(StrexpDiffExpress, ' ');
                if (FactorialexpValueObjExpire2 == false) {
                    FactorialexpValue2 = parse(StrexpSimpleExpress, variables, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
                    FactorialexpValueObjExpire2 = true;
                }
                StringBuilder StrBuild = new StringBuilder(StrexpSimpleExpress);
                Exprn = StrBuild.toString();
                //ODE Dy/Dx(F(x))== Xn
                Xnplus1 = (long) ((FactorialexpValue2.eval() + x) % (MaxExponent));
                FactorialXnplus1Avail = true;
                GetExprnMinMaxRangeLCGDyDx(Xnplus1, DiffWithRespTo, (LCGDyDxXValuemax - x), (10 - i));
                System.out.println("LCG_Factorial_Random:Reached:Depth=" + i + " EqnCompFlag=" + EqnCompFlag + " TempXn=" + TempXn + " Xnplus1=" + Xnplus1 + " Xn=" + Xn);
            } else if (TempXn != Xnplus1) {
                Xnplus1 = (long) (FactorialexpValue2.eval() % (MaxExponent));
                break;
            }
        }
//        if (LowFactorialInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            if (TimeTaken.length >= 2) {
//                CompletionTime = Double.parseDouble(TimeTaken[2]) - CompletionTime;
//            } else {
//                CompletionTime = Double.parseDouble(TimeTaken[1]);
//            }
//            System.out.println("LCG_Factorial_Random_Memory:Completed:Run Started Time:" + current + " " + " CompletionTime=" + CompletionTime * 1000 + " millisecs");
//            LowFactorialInitFlagRecordTime = true;
//        }
        FactorialXnplus1Avail = false;
        FactorialexpValueObjExpire = false;
        FactorialexpObjExpire = false;
        FactorialXnplus1Avail = false;
        //System.out.println("LCG_Factorial_Random:Completed:Xnplus1=" + Xnplus1 + " Modulus=" + Modulus);
        return ((long) Xnplus1);
    }
// The LCG_Factorial_Random Method uses F(x)==Xn && ODE Dy/Dx(F(x))== Xn
    // If Xn != Xn+1, Method Returns Xn+1
    // This can be viewed as a Lyapunov Function Also 
    //(Source :wikiLyapunov) where F'(x)=F(x)

    public long LCG_Factorial_Random_Stateless(String AlgoName, String Exprn, long a, long c, long Xn, long Modulus, long MaxExponent, String EqnCompFlag, String ObjNameStr) {
//        if (LowFactorialInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            CompletionTime = Double.parseDouble(TimeTaken[2]);
//            System.out.println("LCG_Factorial_Random_Stateless:Started:Run Started Time:" + current + " ");
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
        GetExprnMinMaxRangeLCGDyDx(Xn, DiffWithRespTo, Modulus, 10);
        FactorialXnplus1Avail = false;
        for (long x = LCGDyDxXValuemin; (i < 3) && ((i < 3) || (Xn == Xnplus1) || (TempXn == Xnplus1)); x += LCGDyDxXValueInc, i++) {
            variables.put(DiffWithRespTo, ((double) x));
            if ((FactorialexpValueObjExpire == false) && (FactorialStatelessObjStringLCGDyDx.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDyDx.equalsIgnoreCase(ObjNameStr))) {
                FactorialexpValue = parse(Exprn, variables, DiffWithRespTo,false, "Silent", MathsExpressionParser.LogLevel.Off);
                FactorialexpValueObjExpire = true;
                FactorialStatelessObjStringLCGDyDx = EqnCompFlag;
                FactorialStatelessObjNameStrDyDx = ObjNameStr;
            } else if ((FactorialexpValueObjExpire == true) && (FactorialStatelessObjStringLCGDyDx.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDyDx.equalsIgnoreCase(ObjNameStr))) {
                FactorialexpValue = parse(Exprn, variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                FactorialexpValueObjExpire = false;
                FactorialStatelessObjStringLCGDyDx = EqnCompFlag;
                FactorialStatelessObjNameStrDyDx = ObjNameStr;
            }
            //F(x)==Xn 
            if ((FactorialexpValue != null) && (FactorialStatelessObjStringLCGDyDx.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDyDx.equalsIgnoreCase(ObjNameStr))) {
                TempXn = (long) ((FactorialexpValue.eval()) % (MaxExponent));
            }
            if (((TempXn == Xn) || (i >= 1)) && (FactorialStatelessObjStringLCGDyDx.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDyDx.equalsIgnoreCase(ObjNameStr))) {
                StrexpSimpleExpress = new StringBuilder(eatAll(Exprn, ' '));
                //System.out.println("LCG_Factorial_Random:Reached1:StrexpSimpleExpress=" + StrexpSimpleExpress );
                if ((FactorialexpObjExpire == false) && (FactorialStatelessObjStringLCGDiff.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDiff.equalsIgnoreCase(ObjNameStr))) {
                    StrexpSimpleExpress.append("-").append(Xnplus1).append("-").append(Xn);
                    StrexpSimpleExpress = new StringBuilder(eatAll(StrexpSimpleExpress.toString(), ' '));
                    MathsContxtLAv.SimpleExpression expSimple = null;
                    expSimple = parseSimple(StrexpSimpleExpress.toString(), variables, DiffWithRespTo,"Map2", "Diffr", HideInRecurseFlag, GBLSilent, GBLMyLogLevel);
                    Factorialexp = parseDiff(expSimple.SimpleExpr(), variables, DiffWithRespTo, "Map1", "Diffr");
                    //Factorialexp = parseDiff(StrexpSimpleExpress.toString(), variables, DiffWithRespTo);
                    FactorialexpObjExpire = true;
                    FactorialStatelessObjStringLCGDiff = EqnCompFlag;
                    FactorialStatelessObjNameStrDiff = ObjNameStr;
                } else if ((FactorialexpObjExpire == true) && (FactorialStatelessObjStringLCGDiff.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDiff.equalsIgnoreCase(ObjNameStr))) {
                    StrexpSimpleExpress.append("-").append(Xnplus1).append("-").append(Xn);
                    StrexpSimpleExpress = new StringBuilder(eatAll(StrexpSimpleExpress.toString(), ' '));
                    Calculus.MathsContxtLAv.SimpleExpression expSimple = null;
                    expSimple = parseSimple(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, "Map1", "Diffr", HideInRecurseFlag, GBLSilent, GBLMyLogLevel);
                    Factorialexp = parseDiff(expSimple.SimpleExpr(), variables, DiffWithRespTo, "Map1", "Diffr");
                    //Factorialexp = parseDiff(StrexpSimpleExpress.toString(), variables, DiffWithRespTo);
                    FactorialexpObjExpire = false;
                    FactorialStatelessObjStringLCGDiff = EqnCompFlag;
                    FactorialStatelessObjNameStrDiff = ObjNameStr;
                }
                StrexpDiffExpress = Factorialexp.DiffExpr();
                StrexpSimpleExpress = new StringBuilder(eatAll(StrexpDiffExpress, ' '));
                //System.out.println("LCG_Factorial_Random:Reached3:StrexpDiffExpress=" + StrexpDiffExpress );
                if ((FactorialexpValueObjExpire2 == false) && (FactorialStatelessObjStringLCGDiff2.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDiff2.equalsIgnoreCase(ObjNameStr))) {
                    FactorialexpValue2 = parse(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    FactorialexpValueObjExpire2 = true;
                    FactorialStatelessObjStringLCGDiff2 = EqnCompFlag;
                    FactorialStatelessObjNameStrDiff2 = ObjNameStr;
                } else if ((FactorialexpValueObjExpire2 == true) && (FactorialStatelessObjStringLCGDiff2.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDiff2.equalsIgnoreCase(ObjNameStr))) {
                    FactorialexpValue2 = parse(StrexpSimpleExpress.toString(), variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    FactorialexpValueObjExpire2 = false;
                    FactorialStatelessObjStringLCGDiff2 = EqnCompFlag;
                    FactorialStatelessObjNameStrDiff2 = ObjNameStr;
                }
                StringBuilder StrBuild = new StringBuilder(StrexpSimpleExpress);
                if (!StrexpSimpleExpress.toString().equalsIgnoreCase("")) {
                    Exprn = StrBuild.toString();
                }
                //ODE Dy/Dx(F(x))== Xn
                Xnplus1 = (long) ((FactorialexpValue2.eval() + x) % (MaxExponent));
                FactorialXnplus1Avail = true;
                GetExprnMinMaxRangeLCGDyDx(Xnplus1, DiffWithRespTo, (LCGDyDxXValuemax - x), (10 - i));
                //System.out.println("LCG_Factorial_Random:Reached2:Depth=" + i + " EqnCompFlag=" + EqnCompFlag + " TempXn=" + TempXn + " Xnplus1=" + Xnplus1 + " Xn=" + Xn );
                //System.out.println("LCG_Factorial_Random:Reached2:Exprn=" + Exprn );
                //System.out.println("LCG_Factorial_Random:Reached2:StrexpSimpleExpress=" + StrexpSimpleExpress );
                //System.out.println("LCG_Factorial_Random:Reached2:StrexpDiffExpress=" + StrexpDiffExpress );
            } else if ((TempXn != Xnplus1) && (FactorialStatelessObjStringLCGDyDx.equalsIgnoreCase(EqnCompFlag)) && (FactorialStatelessObjNameStrDyDx.equalsIgnoreCase(ObjNameStr))) {
                Xnplus1 = (long) (FactorialexpValue2.eval() % (MaxExponent));
                break;
            }
        }
//        if (LowFactorialInitFlagRecordTime == false) {
//            LocalDateTime current = LocalDateTime.now();
//            String[] TimeTaken = current.toString().split(":");
//            if (TimeTaken.length >= 2) {
//                CompletionTime = Double.parseDouble(TimeTaken[2]) - CompletionTime;
//            } else {
//                CompletionTime = Double.parseDouble(TimeTaken[1]);
//            }
//            System.out.println("LCG_Factorial_Random_Stateless:Completed:Run Started Time:" + current + " " + " CompletionTime=" + CompletionTime * 1000 + " millisecs");
//            LowFactorialInitFlagRecordTime = true;
//        }
        //System.out.println("LCG_Factorial_Random:Completed:Xnplus1=" + Xnplus1 + " Modulus=" + Modulus);
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
    public long EliminateZeroInOutputXn_LCGDyDx(long Xn1, long Xnplus1, long ConfuseFactorial1, long DiffusionFactorial1, long SupportFactorial1, long SurprisalFactorial1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseFactorial==ConfuseFactorial1)
                //&&(DiffusionFactorial==DiffusionFactorial1)
                //&&(SupportFactorial==SupportFactorial1)
                //&&(SurprisalFactorial==SurprisalFactorial1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateZeroInOutputXn_LCGDyDx: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 0) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateZeroInOutputXn_LCGDyDx: Failed Elimination:0:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateZeroInOutputXn_LCGDyDx: Failed Elimination:1:--");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 2) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1 -= 2;
                //System.out.println("EliminateZeroInOutputXn_LCGDyDx: Failed Elimination:1:-=2");
            }
        } else {
            //System.out.println("EliminateZeroInOutputXn_LCGDyDx: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateZeroInOutputXn_LCGDyDx4(long Xn1, long Xnplus1, long ConfuseFactorial1, long DiffusionFactorial1, long SupportFactorial1, long SurprisalFactorial1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseFactorial==ConfuseFactorial1)
                //&&(DiffusionFactorial==DiffusionFactorial1)
                //&&(SupportFactorial==SupportFactorial1)
                //&&(SurprisalFactorial==SurprisalFactorial1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateZeroInOutputXn_LCGDyDx4: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 0) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateZeroInOutputXn_LCGDyDx4: Failed Elimination:0:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateZeroInOutputXn_LCGDyDx4: Failed Elimination:1:--");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 2) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1 -= 2;
                //System.out.println("EliminateZeroInOutputXn_LCGDyDx4: Failed Elimination:1:-=2");
            }
        } else {
            //System.out.println("EliminateZeroInOutputXn_LCGDyDx4: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateOneInOutputXn_LCGDyDx(long Xn1, long Xnplus1, long ConfuseFactorial1, long DiffusionFactorial1, long SupportFactorial1, long SurprisalFactorial1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseFactorial==ConfuseFactorial1)
                //&&(DiffusionFactorial==DiffusionFactorial1)
                //&&(SupportFactorial==SupportFactorial1)
                //&&(SurprisalFactorial==SurprisalFactorial1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateOneInOutputXn_LCGDyDx: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateOneInOutputXn_LCGDyDx: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateOneInOutputXn_LCGDyDx: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateOneInOutputXn_LCGDyDx: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateOneInOutputXn_LCGDyDx4(long Xn1, long Xnplus1, long ConfuseFactorial1, long DiffusionFactorial1, long SupportFactorial1, long SurprisalFactorial1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseFactorial==ConfuseFactorial1)
                //&&(DiffusionFactorial==DiffusionFactorial1)
                //&&(SupportFactorial==SupportFactorial1)
                //&&(SurprisalFactorial==SurprisalFactorial1)
                ) {
            Xnplus1++;
        } else if (Xnplus1 != Xn1) {
            //System.out.println("EliminateOneInOutputXn_LCGDyDx4: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateOneInOutputXn_LCGDyDx4: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateOneInOutputXn_LCGDyDx4: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateOneInOutputXn_LCGDyDx4: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateTwoInOutputXn_LCGDyDx(long Xn1, long Xnplus1, long ConfuseFactorial1, long DiffusionFactorial1, long SupportFactorial1, long SurprisalFactorial1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseFactorial==ConfuseFactorial1)
                //&&(DiffusionFactorial==DiffusionFactorial1)
                //&&(SupportFactorial==SupportFactorial1)
                //&&(SurprisalFactorial==SurprisalFactorial1)
                ) {
            Xnplus1++;
        } else if ((Xnplus1 != Xn1) && (Xnplus1 == 2)) {
            //System.out.println("EliminateTwoInOutputXn_LCGDyDx: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateTwoInOutputXn_LCGDyDx: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateTwoInOutputXn_LCGDyDx: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateTwoInOutputXn_LCGDyDx: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateTwoInOutputXn_LCGDyDx4(long Xn1, long Xnplus1, long ConfuseFactorial1, long DiffusionFactorial1, long SupportFactorial1, long SurprisalFactorial1) {
        if ((Xnplus1 == Xn1) //&&(ConfuseFactorial==ConfuseFactorial1)
                //&&(DiffusionFactorial==DiffusionFactorial1)
                //&&(SupportFactorial==SupportFactorial1)
                //&&(SurprisalFactorial==SurprisalFactorial1)
                ) {
            Xnplus1++;
        } else if ((Xnplus1 != Xn1) && (Xnplus1 == 2)) {
            //System.out.println("EliminateTwoInOutputXn_LCGDyDx4: Failed Elimination:!=");
            if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1++;
                //System.out.println("EliminateTwoInOutputXn_LCGDyDx4: Failed Elimination:1:++");
            } else if ((AntiCounterModeFlag == true) && (Xnplus1 == 1) && ((Modulus == 3) && (ModulusEncrypt == 3) || ((Modulus == 2) && (ModulusEncrypt == 2)))) {
                Xnplus1--;
                //System.out.println("EliminateTwoInOutputXn_LCGDyDx4: Failed Elimination:1:--");
            }
        } else {
            //System.out.println("EliminateTwoInOutputXn_LCGDyDx4: Failed Elimination");
        }
        if (Xnplus1 < 0) {
            Xnplus1 = Xnplus1 * -1;
        }
        return ((long) Xnplus1);
    }

    public long EliminateIndividualState(long Xn_LCGDyDx, String ObjNameStrStateless, long Xn_LCGDyDxXn, long ConfuseFactorialXn, long DiffusionFactorialXn, long SupportFactorialXn, long SurprisalFactorialXn) {
        if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx")) {
            //2 3 0 1 2 3 2 0
            Xn_LCGDyDx = EliminateZeroInOutputXn_LCGDyDx(Xn_LCGDyDxXn, Xn_LCGDyDx, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        } else if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx4")) {
            //2 3 0 2 3 2 3 0
            Xn_LCGDyDx = EliminateZeroInOutputXn_LCGDyDx4(Xn_LCGDyDxXn, Xn_LCGDyDx, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        }
        if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx")) && (Modulus > 2)) {
            Xn_LCGDyDx = EliminateOneInOutputXn_LCGDyDx(Xn_LCGDyDxXn, Xn_LCGDyDx, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        } else if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx4"))) {
            Xn_LCGDyDx = EliminateOneInOutputXn_LCGDyDx4(Xn_LCGDyDxXn, Xn_LCGDyDx, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        }
        if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx")) && (Modulus > 2)) {
            Xn_LCGDyDx = EliminateTwoInOutputXn_LCGDyDx(Xn_LCGDyDxXn, Xn_LCGDyDx, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        } else if ((ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx4")) && (Modulus > 2)) {
            Xn_LCGDyDx = EliminateTwoInOutputXn_LCGDyDx4(Xn_LCGDyDxXn, Xn_LCGDyDx, ConfuseFactorialXn, DiffusionFactorialXn, SupportFactorialXn, SurprisalFactorialXn);
        }
        return Xn_LCGDyDx;
    }

    public long EliminatePatternInSet(long Xn_LCGDyDx, String ObjNameStrStateless, long Xn_LCGDyDxXn, long IthNum) {
        if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx")) {
            //1 0
            Xn_LCGDyDx = DetectAndEliminate(1, IthNum, NoOfSlots, Xn_LCGDyDx, Xn_LCGDyDxXn, ObjNameStrStateless);
        } else if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx4")) //0 1 2 3 0 2 3
        {
            Xn_LCGDyDx = DetectAndEliminate(3, IthNum, NoOfSlots, Xn_LCGDyDx, Xn_LCGDyDxXn, ObjNameStrStateless);
        }

        if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx")) {
            Xn_LCGDyDx = DetectAndEliminateFreqStoreMethod(1, IthNum, NoOfSlots, Xn_LCGDyDx, Xn_LCGDyDxXn, ObjNameStrStateless);
        } else if (ObjNameStrStateless.equalsIgnoreCase("Xn_LCGDyDx4")) {
            Xn_LCGDyDx = DetectAndEliminateFreqStoreMethod(3, IthNum, NoOfSlots, Xn_LCGDyDx, Xn_LCGDyDxXn, ObjNameStrStateless);
        }
        return Xn_LCGDyDx;
    }

    public long DetectAndEliminate(int EntIndex, long IthNum, long NoOfSlots, long Xn_LCGDyDx, long Xn_LCGDyDxXn, String ObjNameStrStateless) {
        //Detect the Pattern
        boolean CounterModeDetectedFlag = false;
        boolean InPatternFlag = false;
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
                i = (int) (IthNum - 1);
            }
            while ((i >= PatternStartIndex) && (i < IthNum)) {
                int k = 0;
                for (j = PatternStartIndex; ((j < PatternStartIndex + 10) && ((j - PatternStartIndex) < 10) || (k < 10)) && (j < this.LCGDyDxDataBuff.size()); j++, k++) {
                    tempStateLong[k] = this.LCGDyDxDataBuff.get(j).longValue();
                    InittempStateLongFlag = true;
                    InittempStateLongLen = k + 1;
                    int m=0;
                    for (; m < k ; m++){
                    if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&&( ( (tempStateLong[m] == Xn_LCGDyDxXn) && (tempStateLong[m + 1] == Xn_LCGDyDxXn)) ||( (tempStateLong[m] == Xn_LCGDyDx) && ((tempStateLong[m + 1] == Xn_LCGDyDx))) || (((j + 1) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j + 1).longValue() == Xn_LCGDyDx)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&&( ( (tempStateLong[m] == Xn_LCGDyDxXn) && (tempStateLong[m + 1] == Xn_LCGDyDx)) ||( (tempStateLong[m] == Xn_LCGDyDx) && (tempStateLong[m + 1] == Xn_LCGDyDxXn)) || (((j + 1) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j + 1).longValue() == Xn_LCGDyDxXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGDyDxXn) && ((tempStateLong[m + 1] == Xn_LCGDyDx) || ((j > 1) && ((j - 1) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j - 1).longValue() == Xn_LCGDyDx)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGDyDx) && ((tempStateLong[m + 1] == Xn_LCGDyDxXn) || ((j > 1) && ((j - 1) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j - 1).longValue() == Xn_LCGDyDxXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    }// Hindsight Error Correction:Correct even if it is too late
                    else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGDyDxXn) && ((tempStateLong[m + 1] == Xn_LCGDyDx) || ((j > 2) && ((j - 2) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j - 2).longValue() == Xn_LCGDyDx)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGDyDx) && ((tempStateLong[m + 1] == Xn_LCGDyDxXn) || ((j > 2) && ((j - 2) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j - 2).longValue() == Xn_LCGDyDxXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    }else if ((m >= 0) &&(m  < 10 )&&(m  <= k ) && (tempStateLong[m] == Xn_LCGDyDxXn) && ((tempStateLong[m + 1] == Xn_LCGDyDx) || ((j > 2) && ((j - 2) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j - 2).longValue() == Xn_LCGDyDxXn)))) {
                        HumanErrorCounterMode = true;
                        break;
                    } else if ((m >= 0) &&(m  < 10 ) &&(m  <= k )&& (tempStateLong[m] == Xn_LCGDyDx) && ((tempStateLong[m + 1] == Xn_LCGDyDxXn) || ((j > 2) && ((j - 2) < this.LCGDyDxDataBuff.size()) && (this.LCGDyDxDataBuff.get(j - 2).longValue() == Xn_LCGDyDx)))) {
                        HumanErrorCounterMode = true;
                        break;
                    }
                    }
                    //System.out.println("DetectAndEliminate:3:" + ObjNameStrStateless + ":Pattern Formed=" + tempStateLong[k] + " PatternStartIndex=" + PatternStartIndex + ":i=" + i + ":IthNum=" + IthNum + ":HumanErrorCounterMode=" + HumanErrorCounterMode + ":Xn_LCGDyDxXn=" + Xn_LCGDyDxXn + ":Xn_LCGDyDx=" + Xn_LCGDyDx);
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
                    //System.out.println("DetectAndEliminate:4:Pattern Formed:ProbablePattern=" + ProbablePattern + " i=" + i);
                }
                if (InitProbablePatternFlag == true) {
                    //System.out.println("DetectAndEliminate:5:" + ObjNameStrStateless + ":Formed Pattern :ProbablePattern=" + ProbablePattern[EntIndex] + ":Xn_LCGDyDx=" + Xn_LCGDyDx + " Xn_LCGDyDxXn=" + Xn_LCGDyDxXn + " HumanErrorCounterMode=" + HumanErrorCounterMode);
                    break;
                }
            }
        }
        //Constant Pattern
        //Random Pattern
        // If Pattern matches AB
        if ((InitProbablePatternFlag == true) && ((ProbablePattern[EntIndex].contains("" + Xn_LCGDyDxXn + " " + Xn_LCGDyDx + " "))
                || (ProbablePattern[EntIndex].startsWith("" + Xn_LCGDyDxXn + " " + Xn_LCGDyDx + " ")))) {
            CounterModeDetectedFlag = true;
        }// If Pattern matches ABA:Human Error of Reading Xn+1 state and Xn+2 state where Xn+2 is equal to Xn
        else if ((InitProbablePatternFlag == true) && ((ProbablePattern[EntIndex].contains("" + Xn_LCGDyDx + " " + Xn_LCGDyDxXn + " "))
                || (ProbablePattern[EntIndex].startsWith("" + Xn_LCGDyDx + " " + Xn_LCGDyDxXn + " ")))) {
            CounterModeDetectedFlag = true;
        } else if ((InitProbablePatternFlag == true) && ((ProbablePattern[EntIndex].equalsIgnoreCase("" + Xn_LCGDyDx + " " + Xn_LCGDyDxXn + " ")
                || (ProbablePattern[EntIndex].equalsIgnoreCase("" + Xn_LCGDyDxXn + " " + Xn_LCGDyDx + " "))))) {
            CounterModeDetectedFlag = true;
        } else if (HumanErrorCounterMode == true) {
            CounterModeDetectedFlag = true;
        }
        if ((CounterModeDetectedFlag == true) ) {
            //Xn_LCGDyDx += 2;
            Xn_LCGDyDx = GenerateNumbersNotUsed(EntIndex, IthNum, NoOfSlots, Xn_LCGDyDx, Xn_LCGDyDxXn, ObjNameStrStateless);
            ProbablePattern[EntIndex] = "";
            InitProbablePatternFlag = false;
            //System.out.println("DetectAndEliminate:6:Broken Patterns:" + ObjNameStrStateless + ":IthNum=" + IthNum + ":Xn_LCGDyDx=" + Xn_LCGDyDx + ":Xn_LCGDyDxXn=" + Xn_LCGDyDxXn + ":PatternStartIndex=" + PatternStartIndex);
            PatternStartIndex = (int) IthNum;
        }
        return Xn_LCGDyDx;
    }

    public long DetectAndEliminateFreqStoreMethod(int EntIndex, long IthNum, long NoOfSlots, long Xn_LCGDyDx, long Xn_LCGDyDxXn, String ObjNameStrStateless) {
        //Detect the Pattern
        boolean PatternDetectedFlagNumLevel = false;
        int i = 0;
        int j = 0;
        for (i = 0; (i < PatternFreqMaxIndex[EntIndex]); i++) {
            if ((i > 0) && (EntIndex == 1) && (Xn_LCGDyDx != this.DataStoreLCGDyDx.get(i).Xn) && (Xn_LCGDyDxXn != this.DataStoreLCGDyDx.get(i - 1).Xn))
                       ; else if ((i > 0) && (EntIndex == 3) && (Xn_LCGDyDx != this.DataStoreLCGDyDx.get(i).Xn) && (Xn_LCGDyDxXn != this.DataStoreLCGDyDx.get(i - 1).Xn))
                   ; else {
                break;
            }
        }
        //Found PatternBit
        //Constant Pattern
        if ((i < PatternFreqMaxIndex[EntIndex]) && ((i + 1) <= DataStoreLCGDyDx.size())) {
            PatternDetectedFlagNumLevel = true;
        }//Random Pattern
        else if ((i < PatternFreqMaxIndex[EntIndex]) && ((i + 1) < DataStoreLCGDyDx.size()) && (DataStoreLCGDyDx.get(i + 1).Freq > 1)) {
            PatternDetectedFlagNumLevel = true;
        }
        if (PatternDetectedFlagNumLevel == true) {
            //Xn_LCGDyDx++;
            //System.out.println("DetectAndEliminateFreqStoreMethod:Found Patterns:" + ObjNameStrStateless + ":IthNum=" + IthNum + ":Xn_LCGDyDx=" + Xn_LCGDyDx + " Xn_LCGDyDxXn=" + Xn_LCGDyDxXn);
        }
        return Xn_LCGDyDx;
    }

    public long GenerateNumbersNotUsed(int EntIndex, long IthNum, long NoOfSlots, long Xn_LCGDyDx, long Xn_LCGDyDxXn, String ObjNameStrStateless) {
        // Collect Unused Numbers
        int i = 0;
        boolean GotUnusedStateFlag = false;
        ArrayList<PatternBits> UnUsedStatesStore = new ArrayList<RandomFactorialLCGDyDx.PatternBits>();
        for (i = 0; i < EntPool[EntIndex].MyFactorial.FreqStore.length; i++) {
            if ((EntPool[EntIndex].MyFactorial.FreqStore[i] == 0) 
                    || ( (PatternFreqMaxIndex[EntIndex] >0) && (EntPool[EntIndex].MyFactorial.FreqStore[(int)i] <= (0.5 * PatternFreqMaxIndex[EntIndex])  ) )
                    ) {
                UnUsedStatesStore.add(new PatternBits( i, (int)EntPool[EntIndex].MyFactorial.FreqStore[i] ) );
                GotUnusedStateFlag = true;
                //System.out.println("GenerateNumbersNotUsed:Got Unused State=" + i);
            }
        }
        Collections.sort(UnUsedStatesStore, new SortbyXn());
        if ((!UnUsedStatesStore.isEmpty()) && (GotUnusedStateFlag == true) &&(Xn_LCGDyDx >1) &&( (i/(int)Xn_LCGDyDx) < UnUsedStatesStore.size())) {
            Xn_LCGDyDx = UnUsedStatesStore.get(i/(int)Xn_LCGDyDx).Xn;
        }else if ((!UnUsedStatesStore.isEmpty()) && (GotUnusedStateFlag == true))
            Xn_LCGDyDx = UnUsedStatesStore.get(0).Xn;
        System.out.println("GenerateNumbersNotUsed:Changed Number to Xn_LCGDyDx=" + Xn_LCGDyDx);
        return Xn_LCGDyDx;
    }

    /**
     * ****************************************************
     */
    /**
     * ******************************* Stable State IndividualState Elimination
     * Mechanisms End *********************
     */
    public void PerformanceFormEquation(long Xn, long a, long c, long b, String TechDiffWithRespTo, int MaxExponent){
        // Form the Equations
        Long Xn_LCGDyDx=Xn;
        ExprnLCGDyDx = FormEquationFactorial(Xn_LCGDyDx,  c, ExprnLCGDyDx);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationFactorial:a=" + a + " b=" + b + " c=" + c + " ExprnLCGDyDx=" + ExprnLCGDyDx);
        ConfuseExprnLCGDyDx = FormEquationSimple(Xn_LCGDyDx, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSimple:ConfuseExprnLCGDyDx=" + ConfuseExprnLCGDyDx);
        DiffusionExprnLCGDyDx = FormEquationSimple(Xn_LCGDyDx, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSimple:DiffusionExprnLCGDyDx=" + DiffusionExprnLCGDyDx);
        SupportExprnLCGDyDx = FormEquationSupport(Xn_LCGDyDx, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSupport:SupportExprnLCGDyDx=" + SupportExprnLCGDyDx);
        SurprisalExprnLCGDyDx = FormEquationSurprise(Xn_LCGDyDx, a, c, b, "Xn", (int) MaxExponent);
        //System.out.println("RandomFactorialLCGDyDx:FormEquationSimple:SurprisalExprnLCGDyDx=" + SurprisalExprnLCGDyDx);
        PerformSeedUnchangedFlag=false;
    }
    static String FormEquationSimple(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore = MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
            //System.out.println("FormEquationSimpleLocal:Reached:i=" + i + " MgtbCoeff=" + MgtbCoeff);
        }
        if (MgtbCoeff > 2) {
            StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo);
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc);
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSimple:Exprn=" + Exprn);
        return Exprn;
    }

    static String FormEquationSupport(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append(" * ").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            } else {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
                //MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc).append(" * ").append(SeedDyDx++);
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSupport:Exprn=" + Exprn);
        return Exprn;
    }

    static String FormEquationSurprise(long Xn, long MgtACoeff, long Mgtc, long MgtbCoeff, String TechDiffWithRespTo, int MgtMaxExponent) {
        StringBuilder StrBuild = new StringBuilder("" + MgtACoeff);
        String Exprn = "";
        StrBuild.append("/").append(TechDiffWithRespTo).append("^").append(MgtMaxExponent);
        for (int i = MgtMaxExponent - 1; i > 1; i--) {
            int j = 3;
            if (MgtbCoeff > 2) {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
            } else {
                StrBuild.append(" + ").append(MgtbCoeff).append("*").append(TechDiffWithRespTo).append("^").append(i);
                //MgtbCoeff = bCoeffStore;
            }
            //MgtbCoeff++;
            //MgtbCoeff=NextPrimeNumber(j);
            MgtbCoeff = NextOddNumber(j);
            j += 2;
        }
        StrBuild.append(" + ").append(Xn).append(" + ").append(Mgtc).append(" * ").append(SeedDyDx++);
        Exprn = eatAll(StrBuild.toString(), ' ');
        //log.info("FormEquationSimple:Exprn=" + Exprn);
        //System.out.println("FormEquationSurprise:Exprn=" + Exprn);
        return Exprn;
    }
//    public static void readMemoryMappedFile(String filePath) {
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
    /* ****************************************************************************** */
    //Functions to Form Equation String End
    /* ****************************************************************************** */
    public static long ConfusionFactorialValue(int i) {
        InitEquationVar();
        SetFunctions("m*x+c");
        SetKeyParts("m*keyx+c");
        return ComputeConfusion(i);
    }

    public static long DiffusionFactorialValue(long i) {

        i = i % NumberOfKeyParts;
        if (( i > 0)&&(i < K.length))
        return K[(int) i].LCGexpValue.eval().longValue();
        else
            return 1;
    }

    /* ****************************************************************************** */
    ////Low level Functions Begin
    /* ****************************************************************************** */
    public static void InitEquationVar() {
        variables.put("m", Double.NaN);
        variables.put("x", Double.NaN);
        variables.put("c", Double.NaN);
        variables.put("Xn", Double.NaN);
        variables.put("keyx", Double.NaN);
    }

    public static void SetVariablesValues(int mychar) {
        variables.put("m", 1.0);
        variables.put("x", (double) (mychar));
        variables.put("c", 0.0);
        variables.put("Xn", 0.0);
        variables.put("keyx", 0.0);
    }

    /* ****************************************************************************** */
    ////Low level Functions End
    /* ****************************************************************************** */
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
            //MgtbCoeff = ShannonNextEvenNumber(j);
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
        String KeyTempExprn = "";
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
