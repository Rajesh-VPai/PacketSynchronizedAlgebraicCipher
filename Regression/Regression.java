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
package Regression;

import Calculus.ConsoleColors;
import Calculus.MathsContxtLAv;
import Calculus.MathsExpressionParser;
import Calculus.MathsExpressionParser.Expression;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.DiffrIntegrSep.MyFuncDiff;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.DiffrIntegrSep.MyFuncIntegr;
import Calculus.MathsContxtLAv.SimpleExpression;
import static Calculus.MathsExpressionParser.parse;
import Calculus.PredicateSep;
import Calculus.PredicateSep.PredicateBool;
import static Calculus.PredicateSep.parsePredicate;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.log4j.Logger;

    
/**
 *
 * @author Rajesh V Pai
 */
public class Regression {

    public static Logger log = Logger.getLogger(Regression.class.getName());
    public static Map<String, Double> variables = new HashMap<>();
    public static Map<String, Double> variablesEntValue = new HashMap<>();

    //FileName
    public static String FileName = "500180-HDFC.csv";
    //Processed Output can be accessed either on Stack or Linked List
    LinkedList<Integer> PCMaximaLinkedIndex;// Maxima LinkedList Value Store
    LinkedList<Integer> PCMinimaLinkedIndex;// Minima LinkedList Value Store

    //Data Array(Input Data) Variables
    public static int MAX_DATA = 1000000;
    static int Max_Data_Col = 2;
    static int COLUMNSSTART = 0;
    public static LinkedList<Double[]> DataArray = null;
    public static LinkedList<Double[]> DataArrayOutput = null;
    public static LinkedList<Double[]> DataOutputCer = null;
    public static LinkedList<Double[]> DataOutputPredicted = null;
    public static LinkedList<Double[]> DataRegressed = null;
    public static LinkedList<Double[]> WaveData = new LinkedList<Double[]>();
    public static LinkedList<Double[]> DataUncertainity = null;
    public static LinkedList<Double[]> DataUncerEntropy = null;
    public static LinkedList<Double[]> DataUncertainityHindSight = null;
    public static LinkedList<Double>  DataArraySecurity = null;
    
    public static String[][] MyGroup = new String[MAX_DATA][6];
    public static int MyGroupIndex = 0;
    public static String[][] MyGroupUnCer = new String[MAX_DATA][6];
    public static int MyGroupUnCerIndex = 0;
    public static int ROWSREG = 0;
    public static int PastREADDATA = 0;
    public static int PresentREADDATA = 0;
    public static int FutureREADDATA = 0;

    public static boolean ApplyAtLowLevel = true;
    public static int MisMatchCountRegress = 0;
    public static int MisMatchCountUncer = 0;
    public static int MisMatchCountEntropy = 0;
    public static String FinalEquation = "";
    public static String FinalPredicate = "";
    public static String FinalEquationUnCer = "";
    public static String FinalPredicateUnCer = "";
    public static String[] FinalEquationEntropy = null;
    public static String FinalPredicateEntropy = "";
    public static String FinalEndPointEquationUnCer = "";
    public static String FinalUncertainityEntropy = "";
    public static boolean parseFlag = false;
    public static Expression expValue;
    public static boolean expValueFlag = false;
    public static Expression expValueUncer;
    public static boolean expValueUncerFlag = false;
    public static Expression expValueUncer1;
    public static boolean expValueUncerFlag1 = false;
    public static Expression expValueUncer2;
    public static boolean expValueUncerFlag2 = false;
    public static Expression expValueUncer3;
    public static boolean expValueUncerFlag3 = false;
    public static Expression expValueUncer4;
    public static boolean expValueUncerFlag4 = false;
    public static int EntropyLimit = 5;
    public static int UncertaityLimit = 1;
    public static int EntropySelected = 3;
    public static Expression expValueUNCEREntropy;
    public static boolean expValueFlagUNCEREntropy = false;
    public static Expression expValueUncerHindSight;
    public static boolean expValueUncerFlagHindSight = false;
    public static Expression expValueUncerHindSight1;
    public static boolean expValueUncerFlagHindSight1 = false;
    public static Expression expValueUncerHindSight2;
    public static boolean expValueUncerFlagHindSight2 = false;
    public static Expression expValueUncerHindSight3;
    public static boolean expValueUncerFlagHindSight3 = false;
    public static Expression expValueUncerHindSight4;
    public static boolean expValueUncerFlagHindSight4 = false;
    public static String StrCurrentTimeTaken = "";
    public Regression() {

    }

    public static void MyReadData(String Path, String FileName, LinkedList<Double[]> Data) {
        FileInputStream fpinput;
        String msg;
        DataInputStream d;
        String s = new String();
        String[] sTemp = null;
        int param = 0;
        int exp = 0;

        try {

            if ((fpinput = new FileInputStream(Path + FileName)) == null) {
                msg = "Input: can't open " + Path + FileName;
                log.error(msg);
            }
            d = new DataInputStream(fpinput);
            BufferedReader din = new BufferedReader(new InputStreamReader(d));
            // Read the Header Row in File
            s = din.readLine();
            // Traverse Array and store the Output 
            for (exp = 0; (exp < MAX_DATA); exp++) {
                s = din.readLine();
                //log.info(s);
                if ((s == null) || (s.isEmpty()) || (s.equalsIgnoreCase(""))) {
                    break;
                } else if ((s != null) && (!s.isEmpty()) && (!s.equalsIgnoreCase("")) && (s.contains(","))) {
                    sTemp = s.split(",");
                    for (param = 0; ((param < Max_Data_Col) && ((param + 1) < sTemp.length) && (sTemp[param + 1] != null) && (!sTemp[param + 1].isEmpty())); param++) {
                        if (!sTemp[param + 1].isEmpty()) {
                            //sTemp[param + 1] = sTemp[param + 1].replaceAll("\\s", " ").trim();
                            Data.get(exp)[COLUMNSSTART + param] = Double.parseDouble(sTemp[param + 1]);
                        } else {
                            Data.get(exp)[COLUMNSSTART + param] = 0.0;
                        }
                    }
                }
            }
            MAX_DATA = exp;
            log.info("MyReadData:Read MAX_DATA=" + MAX_DATA);
        } catch (Exception NNse) {
            log.error("Exception: Neural Network MyReadDataArrayNN");
            System.out.println(NNse.getStackTrace());
            System.out.println(NNse.getMessage());
            NNse.printStackTrace();
        }
    }

    static void StoreLocalMaxMin(String MaxOrMin, Double Value, int ValIndex, HashMap PCHash, int HashMapIndex) {
        //log.info("Regression:StoreLocalMaxMin:Entered Maxima Inflection Point");
        String MyHashData = new String("");
        //LocalMean = LocalMeanCompute(0, ValIndex, WaveData, SigIndex);
        MyHashData = MaxOrMin + "," //Store if "Maxima" or "Minima"
                + Value + "," //Store the Value
                + 0 + "," //Store the Start of the Ascent/Descent
                + ValIndex + "," //Store the Maxima or Minima Index (Range End) Value
                + 0 + "," // Store the Local Mean of the Ascent/ Descent
                + 0; // Store the Local Std Dev of the Ascent/ Descent

        PCHash.put(HashMapIndex, MyHashData);
        //log.info("Inflection Point :" + MaxOrMin + " :If:Index=" + (PCRowIndex) + " ValIndex=" + ValIndex + " Value=" + Value + " and ProgramCounter=" + ProgramCounter + " and PCPksMaximaCntrValue=" + PCPksMaximaCntrValue.peek() + " and PCPksMinimaCntrValue=" + PCPksMinimaCntrValue.peek()   + " RangeEnd=" + ValIndex);
        //LocalMeanStart = ValIndex + 1;
        //log.info("Regression:StoreLocalMaxMin:Exited");
    }

    public static void StoreLocal(String MaxOrMin, Double Value, int ValIndex, HashMap PCHash, int HashMapIndex) {
        //log.info("Regression:StoreLocalMaxMin:Entered Maxima Inflection Point");
        String MyHashData = new String("");
        MyHashData = MaxOrMin + "," //Store if "Maxima" or "Minima"
                + Value + "," //Store the Value
                + 0 + "," //Store the Start of the Ascent/Descent
                + ValIndex + "," //Store the Maxima or Minima Index (Range End) Value
                + 0 + "," // Store the Local Mean of the Ascent/ Descent
                + 0; // Store the Local Std Dev of the Ascent/ Descent

        PCHash.put(HashMapIndex, MyHashData);
        //log.info("Inflection Point :" + MaxOrMin + " :If:Index=" + (PCRowIndex) + " ValIndex=" + ValIndex + " Value=" + Value + " and ProgramCounter=" + ProgramCounter + " and PCPksMaximaCntrValue=" + PCPksMaximaCntrValue.peek() + " and PCPksMinimaCntrValue=" + PCPksMinimaCntrValue.peek() + " RangeEnd=" + ValIndex);
        //LocalMeanStart = ValIndex + 1;
        //log.info("Regression:StoreLocalMaxMin:Exited");
    }

    @FunctionalInterface
    public interface MaximaMinima {

        HashMap Extrema();
    }

    public static MaximaMinima ProcessData(int StartIndex, int Max_Index, LinkedList<Double[]> Data, int Mapped) {
        HashMap PCHash = new HashMap();// Hash Map to store Maxima/Minima Details as CSV

        int SigIndex = 0;//Index of WaveData : Input Waveform Index element that is being Processed.
        //Store the Initial Value
        //StoreLocal("Neutral-Zero", Data.get(0)[SigIndex], 0, PCHash, 0/*HashMapIndex*/);
        //HashMapIndex++;

        return new Object() {

            HashMap ProcessIndex() //ProcessIndex Function with Trend Flags (AscFlagP3,DscFlagP3)
            // Only the flags AscFlag & DscFlag are used for trifurcation logic. 
            // 1) GOTO Above: Wave Ascending
            // 2) GOTO Same Line : Wave is a constant
            // 3) GOTO below: Waveform Descending
            // Design for Local Minima & Local Maxima where Trend is unidirectional (either all Asc or All Desc).
            // Points between a) Maxima followed by Minima OR 
            //                b) Minima followed by Maxima
            {
                // Order of parameter (details) in StoreLocalMaxMin Function
                Integer HashMapIndex = 0;// Running Index of Elements of HashMap

                Double PCountMinusT = 0.0;//ProgramCounter at t-1:Previous Element
                Double ProgramCounter = 0.0;//ProgramCounter at t:Current Element
                Double NextXt = 0.0;//ProgramCounter at t+1:Next Element
                Double PCountPlus2 = 0.0;//ProgramCounter at t+2:Previous Element
                Double PCountP3 = 0.0;//ProgramCounter at t+3:Previous Element

                int PCRowIndex = StartIndex;//Current Element:Current Row
                int PCLastRowIndex = Max_Index;//Maximum Elements in WaveData i.e Last Index

                // Below flags control the ProgramCounter -> PCountMinusT Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlagMinusT = false;
                boolean DscFlagMinusT = false;

                // Below flags control the NextXt -> ProgramCounter Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlag = false;
                boolean DscFlag = false;

                // Below flags control the NextXt -> PCountPlus2 Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlagPlus2 = false;
                boolean DscFlagPlus2 = false;

                // Below flags control the PCountPlus2 -> PCountP3 Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlagP3 = false;
                boolean DscFlagP3 = false;

                //b)	if 000 (row) Load Program Counter with 000(row).
                PCountMinusT = Data.get(PCRowIndex)[SigIndex];
                ProgramCounter = Data.get(PCRowIndex)[SigIndex];
                NextXt = Data.get(PCRowIndex)[SigIndex];

                PCountPlus2 = 0.0;

                log.info("Regression:ProcessIndex:Entered SigIndex(Column in DataArray)=" + SigIndex + " StartIndex=" + StartIndex + " PCRowIndex=" + PCRowIndex + " Max_Index=" + PCLastRowIndex);

                // Since Lower down in the code we are using PCRowIndex+2: 
                // Hence PCRowIndex <= (PCLastRowIndex). PCLastRowIndex:1 Unknown 
                // May have to revist for Next Day Data( 1 New Point(s) added) 
                // when added
                while (PCRowIndex <= (PCLastRowIndex)) {
                    //
                    //  ProgramCounter -> PCountMinusT Mechanism
                    //
                    //
                    if ((ProgramCounter > PCountMinusT)) {
                        //Wave on the Ascending
                        // GOTO Higher Value(ProgramCounter):Maxima:
                        // Waveform is Ascending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number below current line
                        // (line which is being compiled)
                        // OR GOTO Code defined below (between line number & current line)
                        // (line number is after current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is below (ProgramCounter) is ignored).
                        AscFlagMinusT = true;
                        DscFlagMinusT = false;
                    } else if ((ProgramCounter < PCountMinusT)) {
                        //Wave on the Descending
                        // GOTO Lower Value(ProgramCounter):Minima:
                        // Waveform is Descending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number above current line
                        // (line which is being compiled)
                        // OR GOTO Code defined above (line number is before current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is between (ProgramCounter) is already compiled 
                        // and can be ignored [from compiler point of view]).
                        // From code perspective this is a potential infinite loop.
                        // [going back to old lines without a condition{unconditional GOTO}]
                        AscFlagMinusT = false;
                        DscFlagMinusT = true;

                    } else if ((ProgramCounter == PCountMinusT)) {
                        //Wave on the Descending
                        // GOTO Lower Value(ProgramCounter):Minima:
                        // Waveform is Descending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number above current line
                        // (line which is being compiled)
                        // OR GOTO Code defined above (line number is before current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is between (ProgramCounter) is already compiled 
                        // and can be ignored [from compiler point of view]).
                        // From code perspective this is a potential infinite loop.
                        // [going back to old lines without a condition{unconditional GOTO}]
                        AscFlagMinusT = false;
                        DscFlagMinusT = false;

                    }
                    //
                    //  PCountPlus2 -> NextXt Mechanism
                    //
                    //
                    if ((PCountPlus2 > NextXt) && (AscFlagMinusT == true)) {
                        //Wave on the Ascending
                        AscFlagPlus2 = true;
                        DscFlagPlus2 = false;
                    } else if ((PCountPlus2 < NextXt) && (DscFlagMinusT == true)) {
                        //Wave on the Descending
                        AscFlagPlus2 = false;
                        DscFlagPlus2 = true;
                    } else if ((PCountPlus2 == NextXt) && (DscFlagMinusT == false) && (AscFlagMinusT == false)) {
                        //Wave on the Descending
                        AscFlagPlus2 = false;
                        DscFlagPlus2 = true;
                    }
                    //
                    //  PCountP3 -> PCountPlus2 Mechanism
                    //
                    //
                    if ((PCountP3 > PCountPlus2)) {
                        //Wave on the Ascending
                        AscFlagP3 = true;
                        DscFlagP3 = false;
                    } else if ((PCountP3 < PCountPlus2) && (DscFlagMinusT == true)) {
                        //Wave on the Descending
                        AscFlagP3 = false;
                        DscFlagP3 = true;
                    } else if ((PCountP3 == PCountPlus2) && (DscFlagMinusT == false) && (AscFlagMinusT == false)) {
                        //Wave on the Descending
                        AscFlagP3 = false;
                        DscFlagP3 = false;
                    }
                    //Actual Work gets done here
                    //NextXt -> ProgramCounter Mechanism
                    //
                    //
                    if ((NextXt > ProgramCounter) && (AscFlagMinusT == false) && (AscFlagMinusT != DscFlagMinusT)) {
                        //Wave on the Ascending
                        if ((DscFlagMinusT == true) && (AscFlagMinusT == false) && (DscFlag == true) && (AscFlag == false)) {
                            StoreLocalMaxMin("Minima", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                            if ((DscFlagPlus2 == true) && (AscFlagPlus2 == false)) {
                                log.info("Regression:ProcessIndex:Asc:Early Warning:Descent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                            if ((DscFlagP3 == true) && (AscFlagP3 == false)) {
                                log.info("Regression:ProcessIndex:Asc:Alert:Descent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                        } else {
                            StoreLocal("Neutral-Asc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                        AscFlag = true;
                        DscFlag = false;
                        if ((DscFlagPlus2 == false) && (AscFlagPlus2 == true)) {
                            log.info("Regression:ProcessIndex:Asc:Ascent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        if ((DscFlagP3 == false) && (AscFlagP3 == true)) {
                            log.info("Regression:ProcessIndex:Asc:Alert:Ascent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        log.info("Regression:ProcessIndex:Ascending:NextXt:" + NextXt + " at PCRowIndex=" + PCRowIndex + " and ProgramCounter=" + ProgramCounter + " PCountMinusT=" + PCountMinusT + " PCountPlus2=" + PCountPlus2);
                    } else if ((NextXt < ProgramCounter) && (DscFlagMinusT == false) && (AscFlagMinusT != DscFlagMinusT)) {
                        //Wave on the Descending
                        if ((DscFlagMinusT == false) && (AscFlagMinusT == true) && (DscFlag == false) && (AscFlag == true)) {
                            StoreLocalMaxMin("Maxima", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                            if ((DscFlagPlus2 == false) && (AscFlagPlus2 == true)) {
                                log.info("Regression:ProcessIndex:Dsc:Early Warning:Ascent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                            if ((DscFlagP3 == false) && (AscFlagP3 == true)) {
                                log.info("Regression:ProcessIndex:Dsc:Alert:Ascent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                        } else {
                            StoreLocal("Neutral-Dsc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                        AscFlag = false;
                        DscFlag = true;
                        if ((DscFlagPlus2 == true) && (AscFlagPlus2 == false)) {
                            log.info("Regression:ProcessIndex:Dsc:Descent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        if ((DscFlagP3 == true) && (AscFlagP3 == false)) {
                            log.info("Regression:ProcessIndex:Dsc:Alert:Descent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        log.info("Regression:ProcessIndex:Descending:NextXt:" + NextXt + " at PCRowIndex=" + PCRowIndex + " and ProgramCounter=" + ProgramCounter + " PCountMinusT=" + PCountMinusT + " PCountPlus2=" + PCountPlus2);
                    } else {
                        if ((NextXt >= ProgramCounter) && (DscFlagMinusT == false) && (AscFlagMinusT == true)) {
                            StoreLocal("Neutral-Constant-Asc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        } else if ((NextXt <= ProgramCounter) && (DscFlagMinusT == true) && (AscFlagMinusT == false)) {
                            StoreLocal("Neutral-Constant-Dsc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        } else if ((DscFlagMinusT == false) && (AscFlagMinusT == false)) {
                            StoreLocal("Neutral-Constant-Zero", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                    }
                    // Load Next Value
                    PCountMinusT = ProgramCounter;
                    ProgramCounter = NextXt;
                    PCRowIndex++;
                    if ((PCRowIndex <= (PCLastRowIndex)) && (PCRowIndex < Data.size())) {
                        log.info("Regression:ProcessIndex:PCLastRowIndex=" + PCLastRowIndex + " PCRowIndex=" + PCRowIndex + " Data.size()=" + Data.size());
                        if (Mapped == 0) {
                            NextXt = Data.get(PCRowIndex)[SigIndex];
                        } else {
                            NextXt = WaveData.get(PCRowIndex)[SigIndex];
                        }
                        if ((PCRowIndex < PCLastRowIndex) && (PCRowIndex + 1 < Data.size())) {
                            if (Mapped == 0) {
                                PCountPlus2 = Data.get(PCRowIndex + 1)[SigIndex];
                            } else {
                                PCountPlus2 = WaveData.get(PCRowIndex + 1)[SigIndex];
                            }
                        }
                        if ((PCRowIndex < (PCLastRowIndex - 1)) && (PCRowIndex + 2 < Data.size())) {
                            if (Mapped == 0) {
                                PCountP3 = Data.get(PCRowIndex + 2)[SigIndex];
                            } else {
                                PCountP3 = WaveData.get(PCRowIndex + 2)[SigIndex];
                            }
                        }
                        //Do Nothing OR Add ToDo Code Here
                    } else {
                        //Store the Final 2 Values Value
                        //StoreLocal("Neutral-Final", Data.get((PCLastRowIndex - 1))[SigIndex], (PCLastRowIndex - 1), PCHash,HashMapIndex);
                        //HashMapIndex++;
                        //StoreLocal("Neutral-Final", Data.get((PCLastRowIndex))[SigIndex], (PCLastRowIndex), PCHash,HashMapIndex);
                        //HashMapIndex++;
                    }
                }
                log.fatal("Regression:ProcessIndex:Exited PCRowIndex=" + PCRowIndex);
                return PCHash;
            }

            //	Stack is always aware if Waveform is Above OR Below Program Counter
            //	Stack is always aware if Waveform is above or below Overall Mean.
            //	Stack is always aware if Waveform is above or below local Mean.
            HashMap ProcessOutputTrend() //ProcessIndex Function without Trend Flags (AscFlagP3,DscFlagP3)
            // Only the flags AscFlag & DscFlag are used for trifurcation logic. 
            // 1) GOTO Above: Wave Ascending
            // 2) GOTO Same Line : Wave is a constant
            // 3) GOTO below: Waveform Descending
            // Simpler Design for Local Minima & Local Maxima where Trend is unidirectional (either all Asc or All Desc).
            // Points between a) Maxima followed by Minima OR 
            //                b) Minima followed by Maxima
            {
                // Order of parameter (details) in StoreLocalMaxMin Function
                Integer HashMapIndex = 0;// Running Index of Elements of HashMap

                Double ProgramCounter = 0.0;//ProgramCounter at t:Current Element
                Double NextXt = 0.0;//ProgramCounter at t+1:Next Element

                int PCRowIndex = StartIndex;//Current Element:Current Row
                int PCLastRowIndex = Max_Index;//Maximum Elements in WaveData i.e Last Index

                // Below flags control the NextXt -> ProgramCounter Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlag = false;
                boolean DscFlag = false;

                //b)	if 000 (row) Load Program Counter with 000(row).
                ProgramCounter = WaveData.get(PCRowIndex)[SigIndex];
                NextXt = WaveData.get(PCRowIndex)[SigIndex];

                log.info("Regression:ProcessOutputTrend:Entered SigIndex(Column in DataArray)=" + SigIndex + " StartIndex=" + StartIndex + " PCRowIndex=" + PCRowIndex + " Max_Index=" + PCLastRowIndex + " ProgramCounter=" + ProgramCounter + " NextXt=" + NextXt);

                // Since Lower down in the code we are using PCRowIndex+2: 
                // Hence PCRowIndex <= (PCLastRowIndex). PCLastRowIndex:1 Unknown 
                // May have to revist for Next Day Data( 1 New Point(s) added) 
                // when added
                while (PCRowIndex <= (PCLastRowIndex)) {
                    //Actual Work gets done here
                    //NextXt -> ProgramCounter Mechanism
                    //
                    //
                    if (NextXt > ProgramCounter) {
                        //Wave on the Ascending
                        // GOTO Higher Value(ProgramCounter):Maxima:
                        // Waveform is Ascending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number below current line
                        // (line which is being compiled)
                        // OR GOTO Code defined below (between line number & current line)
                        // (line number is after current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is below (ProgramCounter) is ignored).
                        if ((DscFlag == true) && (AscFlag == false)) {
                            StoreLocalMaxMin("Minima" + ":Local:" + PCRowIndex + ":", ProgramCounter, (PCRowIndex), PCHash, HashMapIndex);
                            HashMapIndex++;

                        } else if (StartIndex != PCRowIndex) {
                            StoreLocal("Neutral-Asc" + ":Local:" + PCRowIndex + ":", ProgramCounter, (PCRowIndex), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                        AscFlag = true;
                        DscFlag = false;
                        log.info("Regression:ProcessOutputTrend:Ascending:ProgramCounter=" + ProgramCounter + " NextXt:" + NextXt + " at PCRowIndex=" + PCRowIndex + " and ProgramCounter=" + ProgramCounter);
                    } else if (NextXt < ProgramCounter) {
                        //Wave on the Descending
                        // GOTO Lower Value(ProgramCounter):Minima:
                        // Waveform is Descending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number above current line
                        // (line which is being compiled)
                        // OR GOTO Code defined above (line number is before current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is between (ProgramCounter) is already compiled 
                        // and can be ignored [from compiler point of view]).
                        // From code perspective this is a potential infinite loop.
                        // [going back to old lines without a condition{unconditional GOTO}]
                        if ((DscFlag == false) && (AscFlag == true)) {
                            StoreLocalMaxMin("Maxima" + ":Local:" + PCRowIndex + ":", ProgramCounter, (PCRowIndex), PCHash, HashMapIndex);
                            HashMapIndex++;

                        } else if (StartIndex != PCRowIndex) {
                            StoreLocal("Neutral-Dsc" + ":Local:" + PCRowIndex + ":", ProgramCounter, (PCRowIndex), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                        AscFlag = false;
                        DscFlag = true;
                        log.info("Regression:ProcessOutputTrend:Descending:ProgramCounter=" + ProgramCounter + " NextXt:" + NextXt + " at PCRowIndex=" + PCRowIndex + " and ProgramCounter=" + ProgramCounter);
                    }
                    // Load Next Value
                    ProgramCounter = NextXt;
                    PCRowIndex++;
                    if (PCRowIndex <= (PCLastRowIndex)) {
                        log.info("Regression:ProcessOutputTrend:ProgramCounter=" + ProgramCounter + " NextXt=" + NextXt + " PCLastRowIndex=" + PCLastRowIndex + " PCRowIndex=" + PCRowIndex + " Data.size()=" + Data.size());
                        if (Mapped == 0) {
                            NextXt = Data.get(PCRowIndex)[SigIndex];
                        } else {
                            NextXt = WaveData.get(PCRowIndex)[SigIndex];
                        }

                        //Do Nothing OR Add ToDo Code Here
                    } else {
                        //Store the Final 2 Values Value
                        //StoreLocal("Neutral-Final", Data.get((PCLastRowIndex - 1))[SigIndex], (PCLastRowIndex - 1), PCHash,HashMapIndex);
                        //HashMapIndex++;
                        //StoreLocal("Neutral-Final", Data.get((PCLastRowIndex))[SigIndex], (PCLastRowIndex), PCHash,HashMapIndex);
                        //HashMapIndex++;
                    }
                }
                log.fatal("Regression:ProcessOutputTrend:Exited PCRowIndex=" + PCRowIndex + " ProgramCounter=" + ProgramCounter + " NextXt=" + NextXt);
                return PCHash;
            }
            //	Stack is always aware if Waveform is Above OR Below Program Counter
            //	Stack is always aware if Waveform is above or below Overall Mean.
            //	Stack is always aware if Waveform is above or below local Mean.

            MaximaMinima ExtractExtrema() {
                MaximaMinima x;
                if (Mapped == 0) {
                    x = (() -> ProcessIndex());
                } else {
                    x = (() -> ProcessOutputTrend());
                }
                return x;
            }
        }.ExtractExtrema();
    }

    @FunctionalInterface
    public interface RegressionExpr {

        String Equation();
    }

    public static RegressionExpr RegressExtractEqnExpr(String AscDescStart, String AscDescStop, int StartIndex, int StopIndex, HashMap PCHash, String Symbol, LinkedList<Double[]> Data, int MaxIndex, boolean ApplyAtLowLevel, String FinalEqn, String FinalPred, int Innerk) {

        return new Object() {

            RegressionExpr ExtractEquation() {
                RegressionExpr x = (() -> "");
                RegressionExpr y = (() -> "");
                ConfirmTest BadData;

                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);
                SimpleExpression expSimple;
                Expression expValue;
                String MyEqn = "";
                int k = (StopIndex - StartIndex);
                //Form Base Equation
                log.fatal("Regression:ExtractEquation:Base Equation:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                String BaseEqn = "";
                log.info("Regression:ExtractEquation:Base Equation:BaseEqn=" + BaseEqn);
                log.info("Regression:ExtractEquation:Base Equation:FinalEqn=" + FinalEqn);
                log.info("Regression:ExtractEquation:Base Equation:FinalPred=" + FinalPred);
                MyEqn = BaseEqn;
                // If there are N points between Maxima & Minima
                if (k > 2) {
                    double ExprnexpValue = 0.0;
                    if (ApplyAtLowLevel) {
                        log.fatal("Regression:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex + 1; j <= StopIndex; j++) {
                            if (!MyEqn.contains("(" + DiffWithRespTo + j + ")")) {
                                MyEqn = MyEqn + Data.get(j)[0] + "*" + "(" + DiffWithRespTo + j + ")" + "+";
                            }
                            log.info("Regression:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("Regression:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    } else {
                        log.info("Regression:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex + 1; j <= StopIndex; j++) {
                            if (!MyEqn.contains("(" + DiffWithRespTo + j + ")")) {
                                MyEqn = MyEqn + Data.get(j)[0] + "*" + "(" + DiffWithRespTo + j + ")" + "+";
                            }
                            log.info("Regression:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("Regression:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                } // If there are 2 points between Maxima & Minima
                else if (k == 2) {
                    log.info("Regression:ExtractEquation:2 Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    final String LocalGlobal = "Local";
                    log.info("Regression:ExtractEquation:2 Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    int j = StartIndex;
                    if (StartIndex == 0) {
                        final String TempStr = MyEqn;
                        x = (() -> TempStr);
                    } else {
                        for (j = StartIndex + 1; j <= StopIndex; j++) {
                            if (!MyEqn.contains("(" + DiffWithRespTo + j + ")")) {
                                MyEqn = MyEqn + Data.get(j)[0] + "*" + "(" + DiffWithRespTo + j + ")" + "+";
                            }
                            log.info("Regression:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("Regression:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }

                    log.fatal("Regression:ExtractEquation:k==2:Return Equation=" + x.Equation());
                    return x;
                } else {
                    log.info("Regression:ExtractEquation:0 OR 1 Points:ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    final String LocalGlobal = "Global";
                    log.info("Regression:ExtractEquation:DataArray ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex);
                    String Temp = "";
                    if ((AscDescStop == null) || (AscDescStop.equalsIgnoreCase("")) || (AscDescStart == null) || AscDescStart.equalsIgnoreCase(""))
                        ; else {
                        Temp = FormLine(StartIndex, StopIndex, PCHash, LocalGlobal);
                    }
                    if ((Temp != null) && (!Temp.equalsIgnoreCase(""))) {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("Regression:ExtractEquation:Final:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                    } else {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("Regression:ExtractEquation:Returning Final:" + LocalGlobal);
                    }

                }
                log.fatal("Regression:ExtractEquation:Else:Return Equation=" + x.Equation());
                return x;
            }

            String FormLine(int StrtIndx, int StpIndx, HashMap MyPCHash, String LocalGlobal) {
                RegressionExpr x = (() -> "");
                String NewEqnPart = "";
                log.info("FormLine:Initial:" + LocalGlobal + ":AscDescStart=" + AscDescStart);
                log.info("FormLine:Initial:" + LocalGlobal + ":AscDescStop=" + AscDescStop);
                log.info("FormLine:Initial:" + LocalGlobal + ":StrtIndx=" + StrtIndx);
                log.info("FormLine:Initial:" + LocalGlobal + ":StpIndx=" + StpIndx);
                log.info("FormLine:Initial:" + LocalGlobal + ":StrtIndx(y)=" + MyPCHash.get(StrtIndx));
                log.info("FormLine:Initial:" + LocalGlobal + ":StpIndx(y)=" + MyPCHash.get(StpIndx));
                if ((AscDescStart == null) || (AscDescStart.equalsIgnoreCase("")) || (AscDescStop == null) || (AscDescStop.equalsIgnoreCase(""))) {
                    log.fatal("FormLine:Final:NULL:Return Value:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                    return x.Equation();
                }
                if (((AscDescStart.equalsIgnoreCase("Maxima")) || (AscDescStop.equalsIgnoreCase("Neutral-Dsc")))) {
                    NewEqnPart = FormEqn(-1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = (() -> FinxNewEqnPart);
                    log.info("FormLine:Final:" + LocalGlobal + ":Minima:x.Equation()=" + x.Equation());
                } else if (((AscDescStart.equalsIgnoreCase("Minima")) || (AscDescStop.equalsIgnoreCase("Neutral-Asc")))) {
                    NewEqnPart = FormEqn(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = (() -> FinxNewEqnPart);
                    log.info("FormLine:Final:" + LocalGlobal + ":Maxima:x.Equation()=" + x.Equation());
                } else {
                    NewEqnPart = FormEqn(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    if (((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) && ((x.Equation() != null) && (!x.Equation().equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = x.Equation() + NewEqnPart;
                        x = (() -> FinxNewEqnPart);
                        log.info("FormLine:else:x.Equation():" + LocalGlobal + ":Neutral:x.Equation()=" + x.Equation());
                    } else if (((x.Equation() == null) || (x.Equation().equalsIgnoreCase(""))) && ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = (() -> FinxNewEqnPart);
                        log.info("FormLine:else:NewEqnPart:Upper:" + LocalGlobal + ":Neutral:x.Equation()=" + x.Equation());
                    } else if ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = (() -> FinxNewEqnPart);
                        log.info("FormLine:else:NewEqnPart:Lower:" + LocalGlobal + ":Neutral:x.Equation()=" + x.Equation());
                    }
                    log.info("FormLine:Final:" + LocalGlobal + ":Neutral:x.Equation()=" + x.Equation());
                }
                log.fatal("FormLine:Final:Return Value:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                return x.Equation();
            }

            String FormEqn(int InterceptDirection, int Base, int Strt, int Stp, HashMap MyPCHash, String LocalGlobal, int MaxIndex, String FinalEqn) {
                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                ConfirmTest BadData;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);

                String NewEqnPart = "";
                String Extrema = "";
                boolean StopFlagInit = false;
                boolean StartFlagInit = false;
                String[] TempDataStop = new String[6];
                String[] TempDataStart = new String[6];
                log.info("FormEqn:Initial:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("FormEqn:Initial:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("FormEqn:Initial:" + LocalGlobal + ":Strt(y1)=" + MyPCHash.get(Strt));
                log.info("FormEqn:Initial:" + LocalGlobal + ":Stp(y2)=" + MyPCHash.get(Stp));
                //y2
                String TempStop = (String) MyPCHash.get(Stp);
                log.info("FormEqn:" + LocalGlobal + ":TempStop=" + TempStop);
                if ((TempStop != null) && (!TempStop.equalsIgnoreCase(""))) {
                    TempDataStop = TempStop.split(",");
                    StopFlagInit = true;
                }
                //y1
                String TempStart = (String) MyPCHash.get(Strt);
                log.info("FormEqn:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempStart != null) && (!TempStart.equalsIgnoreCase(""))) {
                    TempDataStart = TempStart.split(",");
                    StartFlagInit = true;
                }
                log.info("FormEqn:InterceptDirection=" + InterceptDirection + " StartFlagInit=" + StartFlagInit + ":StopFlagInit=" + StopFlagInit);
                if ((TempDataStart[1] == null) || (TempDataStart[1].equalsIgnoreCase("")) || (TempDataStop[1] == null) || (TempDataStop[1].equalsIgnoreCase(""))) {
                    log.fatal("FormEqn:NULL:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    return NewEqnPart;
                }
                if ((!FinalEqn.contains(Symbol + (Base + 1))) && (!FinalEqn.contains(Symbol + Base))) {
                    NewEqnPart = Double.parseDouble(TempDataStart[1]) + "*" + ("(" + Symbol + Base + ")") + "+" + Double.parseDouble(TempDataStop[1]) + "*" + ("(" + Symbol + (Base + 1) + ")");
                } else if (!FinalEqn.contains(Symbol + Base)) {
                    NewEqnPart = Double.parseDouble(TempDataStart[1]) + "*" + ("(" + Symbol + Base + ")");
                } else if (!FinalEqn.contains(Symbol + (Base + 1))) {
                    NewEqnPart = Double.parseDouble(TempDataStop[1]) + "*" + ("(" + Symbol + (Base + 1) + ")");
                }
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    log.info("FormEqn:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    variables.put(DiffWithRespTo, (double) (Stp));
                    BadData = ConfirmEqn(NewEqnPart, Strt, Stp, PCHash, variables, DiffWithRespTo, LocalGlobal);
                    ConfirmFlag = BadData.eval();
                }
                log.fatal("FormEqn:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                log.info("FormEqn:" + Extrema + ":Final:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("FormEqn:" + Extrema + ":Final:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("FormEqn:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStop[1](y2)=" + TempDataStop[1]);
                log.info("FormEqn:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStart[1](y1)=" + TempDataStart[1]);
                log.info("FormEqn:" + Extrema + ":Final:" + LocalGlobal + ":ConfirmFlag=" + ConfirmFlag);
                return NewEqnPart;
            }

        }.ExtractEquation();
    }

    @FunctionalInterface
    public interface ConfirmTest {

        boolean eval();
    }

    public static ConfirmTest ConfirmEqn(String MyEquation, int StartIndex, int StopIndex, HashMap PCHash, Map<String, Double> variables, String DiffWithRespTo, String LocalGlobal) {
        return new Object() {

            ConfirmTest parseConfirm() {
                ConfirmTest x = (() -> false);
                Expression expValue = (() -> 0.0);
                Double ExprnValue = 0.0;
                String[] TempDataStop = null;
                String[] TempDataStart = null;
                //y2
                String TempStop = (String) PCHash.get(StopIndex);
                log.info("Line:" + LocalGlobal + ":TempStop=" + TempStop);
                if ((TempStop != null) && (!TempStop.equalsIgnoreCase(""))) {
                    TempDataStop = TempStop.split(",");
                }
                //y1
                String TempStart = (String) PCHash.get(StartIndex);
                log.info("Line:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempStart != null) && (!TempStart.equalsIgnoreCase(""))) {
                    TempDataStart = TempStart.split(",");
                }
                //expValue = parse(MyEquation, variables, DiffWithRespTo, "Silent", MathsContxtLAv.LogLevel.Off);
                for (int i = StartIndex; (i <= StopIndex); i++) {
                    variables.put((DiffWithRespTo + (i)), 1.0);
                    expValue = parse(MyEquation, variables, (DiffWithRespTo + (i)), false,"Silent", MathsExpressionParser.LogLevel.Off);
                    ExprnValue += expValue.eval();
                    log.info(LocalGlobal + ":" + "expValue.eval()=" + expValue.eval() + " ExprnValue=" + ExprnValue + " i=" + i + " DiffWithRespTo + (i )=" + DiffWithRespTo + (i));
                    if ((i + 1) <= StopIndex) {
                        variables.put((DiffWithRespTo + (i)), 0.0);
                    }
                }

                if ((PCHash != null) && (PCHash.size() > StopIndex) && (TempDataStart[1] != null) && (TempDataStop[1] != null)) {
                    log.info(LocalGlobal + ":" + " MyEquation=" + MyEquation + " x=" + variables.get(DiffWithRespTo));
                    log.info(LocalGlobal + ":" + "ConfirmTest:Result(F(x))=" + expValue.eval()
                            + " y1=" + TempDataStart[1] + " x1=" + StartIndex
                            + " y2=" + TempDataStop[1] + " x2=" + StopIndex);

                    log.info(LocalGlobal + ":" + "ConfirmTest: Diff(y0)=" + (expValue.eval()));
                    log.info(LocalGlobal + ":" + "ConfirmTest:(TempDataStop[1])=" + (Double.parseDouble(TempDataStop[1]))
                            + " Math.round(expValue.eval()=" + Math.round(expValue.eval()));
                    if (expValue.eval() == (Double.parseDouble(TempDataStop[1]))) {
                        x = (() -> true);
                    }
                }
                variables.put((DiffWithRespTo + (StopIndex)), 0.0);
                log.fatal(LocalGlobal + ":ConfirmFlag:x.eval()=" + x.eval() + " expValue.eval()=" + expValue.eval() + " ExprnValue=" + ExprnValue);
                return x;
            }
        }.parseConfirm();
    }

    public static void DisplayHash(HashMap PCHash) {
        String Temp = "";
        for (int i = 0; i < PCHash.size(); i++) {
            Temp = (String) PCHash.get(i);
            log.fatal(" Hash Element=" + i + " Temp=" + Temp);
        }
    }

    @FunctionalInterface
    public interface RegressOLSExpr {

        String Equation();
    }

    public static RegressOLSExpr RegExtractEqnExpr(String AscDescStart, String AscDescStop, int StartIndex, int StopIndex, HashMap PCHash, String Symbol, LinkedList<Double[]> Data, int MaxIndex, boolean ApplyAtLowLevel, String FinalEqn, String FinalPred, int Innerk) {

        return new Object() {

            RegressOLSExpr ExtractEquation() {
                RegressOLSExpr x = (() -> "");
                RegressOLSExpr y = (() -> "");
                ConfirmTest BadData;

                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);
                SimpleExpression expSimple;
                Expression expValue;
                String MyEqn = "";
                int k = (StopIndex - StartIndex);
                String LocalGlobal = "Local";
                log.fatal("RegressOLSExpr:ExtractEquation:Base Equation:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                String BaseEqn = "";
                log.info("RegressOLSExpr:ExtractEquation:Base Equation:BaseEqn=" + BaseEqn);
                log.fatal("RegressOLSExpr:ExtractEquation:Base Equation:FinalEqn=" + FinalEqn);
                log.info("RegressOLSExpr:ExtractEquation:Base Equation:FinalPred=" + FinalPred);
                MyEqn = BaseEqn;
                // If there are N points between Maxima & Minima
                if (k > 2) {
                    double ExprnexpValue = 0.0;
                    MyEqn = "";
                    if (ApplyAtLowLevel) {
                        log.fatal("RegressOLSExpr:ExtractEquation:ApplyAtLowLevel:N Points:StopIndex=" + (StopIndex + 1) + " StartIndex=" + (StartIndex + 1) + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:MyEqn=" + MyEqn);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:FinalEqn=" + FinalEqn);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:FinalPred=" + FinalPred);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex; j < StopIndex; j++) {
                            String HoldEqn = FormLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                MyEqn += HoldEqn + "+";
                            }
                            j++;
                            log.info("RegressOLSExpr:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("RegressOLSExpr:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    } else {
                        log.fatal("RegressOLSExpr:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex; j < StopIndex; j++) {
                            String HoldEqn = FormLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                MyEqn += HoldEqn + "+";
                            }
                            j++;
                            log.info("RegressOLSExpr:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("RegressOLSExpr:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                } // If there are 2 points between Maxima & Minima
                else if (k == 2) {
                    log.fatal("RegressOLSExpr:ExtractEquation:2 Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    if (StartIndex == 0) {
                        final String TempStr = MyEqn;
                        x = (() -> TempStr);
                    } else {
                        for (int j = StartIndex; j <= StopIndex; j++) {
                            String HoldEqn = FormLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                MyEqn += HoldEqn + "+";
                            }
                            j++;
                            log.info("RegressOLSExpr:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("RegressOLSExpr:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                    log.fatal("RegressOLSExpr:ExtractEquation:k==2:Return Equation=" + x.Equation());
                    return x;
                } else {
                    log.info("RegressOLSExpr:ExtractEquation:0 OR 1 Points:ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    log.info("RegressOLSExpr:ExtractEquation:DataArray ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex);
                    String Temp = "";
                    if ((AscDescStop == null) || (AscDescStop.equalsIgnoreCase("")) || (AscDescStart == null) || AscDescStart.equalsIgnoreCase(""))
                        ; else {
                        Temp = FormLine(StartIndex, StopIndex, PCHash, LocalGlobal);
                    }
                    if ((Temp != null) && (!Temp.equalsIgnoreCase(""))) {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("RegressOLSExpr:ExtractEquation:Final:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                    } else {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("RegressOLSExpr:ExtractEquation:Returning Final:" + LocalGlobal);
                    }

                }
                log.fatal("RegressOLSExpr:ExtractEquation:Else:Return Equation=" + x.Equation());
                return x;
            }

            String FormLine(int StrtIndx, int StpIndx, HashMap MyPCHash, String LocalGlobal) {
                String x = "";
                String NewEqnPart = "";
                log.info("FormLine:Initial:" + LocalGlobal + ":AscDescStart=" + AscDescStart);
                log.info("FormLine:Initial:" + LocalGlobal + ":AscDescStop=" + AscDescStop);
                log.info("FormLine:Initial:" + LocalGlobal + ":StrtIndx=" + StrtIndx);
                log.info("FormLine:Initial:" + LocalGlobal + ":StpIndx=" + StpIndx);
                log.info("FormLine:Initial:" + LocalGlobal + ":StrtIndx(y)=" + MyPCHash.get(StrtIndx));
                log.info("FormLine:Initial:" + LocalGlobal + ":StpIndx(y)=" + MyPCHash.get(StpIndx));
                if ((AscDescStart == null) || (AscDescStart.equalsIgnoreCase("")) || (AscDescStop == null) || (AscDescStop.equalsIgnoreCase(""))) {
                    log.fatal("FormLine:Final:NULL:Return Value:" + LocalGlobal + ":x=" + x);
                    return x;
                }
                if (((AscDescStart.equalsIgnoreCase("Maxima")) || (AscDescStop.equalsIgnoreCase("Neutral-Dsc")))) {
                    NewEqnPart = LineOLS(-1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = FinxNewEqnPart;
                    log.info("FormLine:Final:" + LocalGlobal + ":Minima:x=" + x);
                } else if (((AscDescStart.equalsIgnoreCase("Minima")) || (AscDescStop.equalsIgnoreCase("Neutral-Asc")))) {
                    NewEqnPart = LineOLS(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = FinxNewEqnPart;
                    log.info("FormLine:Final:" + LocalGlobal + ":Maxima:x=" + x);
                } else {
                    NewEqnPart = LineOLS(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    if (((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) && ((x != null) && (!x.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = x + NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormLine:else:" + LocalGlobal + ":Neutral:x=" + x);
                    } else if (((x == null) || (x.equalsIgnoreCase(""))) && ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormLine:else:NewEqnPart:Upper:" + LocalGlobal + ":Neutral:x=" + x);
                    } else if ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormLine:else:NewEqnPart:Lower:" + LocalGlobal + ":Neutral:x=" + x);
                    }
                    log.info("FormLine:Final:" + LocalGlobal + ":Neutral:x=" + x);
                }
                log.fatal("FormLine:Final:Return Value:" + LocalGlobal + ":x=" + x);
                return x;
            }

            String LineOLS(int InterceptDirection, int Base, int Strt, int Stp, HashMap MyPCHash, String LocalGlobal, int MaxIndex, String FinalEqn) {
                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                ConfirmTest BadData;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);

                String NewEqnPart = "";
                String Extrema = "";
                Double m = 0.0;
                Double c = 0.0;
                boolean StopFlagInit = false;
                boolean StartFlagInit = false;
                String[] TempDataStop = new String[6];
                String[] TempDataStart = new String[6];
                log.info("LineOLS:Initial:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("LineOLS:Initial:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("LineOLS:Initial:" + LocalGlobal + ":Strt(y1)=" + MyPCHash.get(Strt));
                log.info("LineOLS:Initial:" + LocalGlobal + ":Stp(y2)=" + MyPCHash.get(Stp));
                //y2
                String TempStop = (String) MyPCHash.get(Stp);
                log.info("LineOLS:" + LocalGlobal + ":TempStop=" + TempStop);
                if ((TempStop != null) && (!TempStop.equalsIgnoreCase(""))) {
                    TempDataStop = TempStop.split(",");
                    StopFlagInit = true;
                }
                //y1
                String TempStart = (String) MyPCHash.get(Strt);
                log.info("LineOLS:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempStart != null) && (!TempStart.equalsIgnoreCase(""))) {
                    TempDataStart = TempStart.split(",");
                    StartFlagInit = true;
                }
                log.info("LineOLS:InterceptDirection=" + InterceptDirection + " StartFlagInit=" + StartFlagInit + ":StopFlagInit=" + StopFlagInit);

                log.info("LineOLS:Symbol=" + Symbol);
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    //y=m*(x-x1) +y1
                    //m=(y2-y1)/(x2-x1)
                    //c= (x2y1-x1y2)/(x2-x1)
                    //c=y1 
                    m = (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1]))
                            / (Stp - Strt);
                    c = Double.parseDouble(TempDataStart[1]);
                    log.info("LineOLS:TempDataStop[1])=" + TempDataStop[1] + " TempDataStart[1]=" + TempDataStart[1]);
                    log.info("LineOLS:(Double.parseDouble(TempDataStop[1])-Double.parseDouble(TempDataStart[1])=" + (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1])));
                }
                if ((InterceptDirection == 1)) {
                    Extrema = "Maxima";
                } else if ((InterceptDirection == -1)) {
                    Extrema = "Minima";
                }
                log.info("LineOLS:m=" + m + " c=" + c);
                log.info("LineOLS:Base=" + Base + " (Stp+Strt)=" + (Stp + Strt) + " (Stp-Strt)=" + (Stp - Strt));
                log.info("LineOLS:TempDataStart[1]=" + TempDataStart[1] + " TempDataStop[1]=" + TempDataStop[1]);
                if ((TempDataStart[1] == null) || (TempDataStart[1].equalsIgnoreCase("")) || (TempDataStop[1] == null) || (TempDataStop[1].equalsIgnoreCase(""))) {
                    log.info("LineOLS:NULL:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    return NewEqnPart;
                }
                if ((!FinalEqn.contains(Symbol + (Base + 1))) && (!FinalEqn.contains(Symbol + Base))) {
                    NewEqnPart = Double.parseDouble(TempDataStart[1]) + "*" + ("(" + Symbol + Base + ")") + "+" + Double.parseDouble(TempDataStop[1]) + "*" + ("(" + Symbol + (Base + 1) + ")");
                } else if (!FinalEqn.contains(Symbol + Base)) {
                    NewEqnPart = Double.parseDouble(TempDataStart[1]) + "*" + ("(" + Symbol + Base + ")");
                } else if (!FinalEqn.contains(Symbol + (Base + 1))) {
                    NewEqnPart = Double.parseDouble(TempDataStop[1]) + "*" + ("(" + Symbol + (Base + 1) + ")");
                }
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    log.info("LineOLS:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    variables.put(DiffWithRespTo, (double) (Stp));
                    BadData = ConfirmEqn(NewEqnPart, Strt, Stp, PCHash, variables, DiffWithRespTo, LocalGlobal);
                    ConfirmFlag = BadData.eval();
                }
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":m=" + m);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":c=" + c);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStop[1](y2)=" + TempDataStop[1]);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStart[1](y1)=" + TempDataStart[1]);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":ConfirmFlag=" + ConfirmFlag);
                return NewEqnPart;
            }

        }.ExtractEquation();
    }

    @FunctionalInterface
    public interface UncertainityOLSExpr {

        String Equation();
    }

    public static UncertainityOLSExpr UncExtractEqnExpr(String AscDescStart, String AscDescStop, int StartIndex, int StopIndex, HashMap PCHash, String Symbol, LinkedList<Double[]> Data, int MaxIndex, boolean ApplyAtLowLevel, String FinalEqn, String FinalPred, int Innerk) {

        return new Object() {

            UncertainityOLSExpr ExtractUncEquation() {
                UncertainityOLSExpr x = (() -> "");
                UncertainityOLSExpr y = (() -> "");
                ConfirmTest BadData;

                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);
                SimpleExpression expSimple;
                Expression expValue;
                String MyEqn = "";
                int k = (StopIndex - StartIndex);
                String LocalGlobal = "Local";
                log.fatal("UncertainityOLSExpr:ExtractUncEquation:Base Equation:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                String BaseEqn = "";
                log.info("UncertainityOLSExpr:ExtractUncEquation:Base Equation:BaseEqn=" + BaseEqn);
                log.fatal("UncertainityOLSExpr:ExtractUncEquation:Base Equation:FinalEqn=" + FinalEqn);
                log.info("UncertainityOLSExpr:ExtractUncEquation:Base Equation:FinalPred=" + FinalPred);
                MyEqn = BaseEqn;
                // If there are N points between Maxima & Minima
                if (k > 2) {
                    double ExprnexpValue = 0.0;
                    MyEqn = "";
                    if (ApplyAtLowLevel) {
                        log.fatal("UncertainityOLSExpr:ExtractUncEquation:ApplyAtLowLevel:N Points:StopIndex=" + (StopIndex + 1) + " StartIndex=" + (StartIndex + 1) + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:MyEqn=" + MyEqn);
                        log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:FinalEqn=" + FinalEqn);
                        log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:FinalPred=" + FinalPred);
                        log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex; j < StopIndex; j++) {
                            String HoldEqn = FormUnCerLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                if (HoldEqn.startsWith("-")) {
                                    int i = MyEqn.lastIndexOf("+");
                                    if (i > 1) {
                                        MyEqn = MyEqn.substring(0, i);
                                    }
                                    log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:Equation=" + MyEqn);
                                    MyEqn += HoldEqn + "+";
                                } else {
                                    MyEqn += HoldEqn + "+";
                                }
                            }
                            j++;
                            log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:Equation=" + MyEqn + " HoldEqn=" + HoldEqn);
                            log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    } else {
                        log.fatal("UncertainityOLSExpr:ExtractUncEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex; j < StopIndex; j++) {
                            String HoldEqn = FormUnCerLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                if (HoldEqn.startsWith("-")) {
                                    int i = MyEqn.lastIndexOf("+");
                                    if (i > 1) {
                                        MyEqn = MyEqn.substring(0, i);
                                    }
                                    log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:Equation=" + MyEqn);

                                    MyEqn += HoldEqn + "+";
                                } else {
                                    MyEqn += HoldEqn + "+";
                                }
                            }
                            j++;
                            log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:Equation=" + MyEqn + " HoldEqn=" + HoldEqn);
                            log.info("UncertainityOLSExpr:ExtractUncEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                } // If there are 2 points between Maxima & Minima
                else if (k == 2) {
                    log.fatal("UncertainityOLSExpr:ExtractUncEquation:2 Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    if (StartIndex == 0) {
                        final String TempStr = MyEqn;
                        x = (() -> TempStr);
                    } else {
                        for (int j = StartIndex; j <= StopIndex; j++) {
                            String HoldEqn = FormUnCerLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                if (HoldEqn.startsWith("-")) {
                                    int i = MyEqn.lastIndexOf("+");
                                    if (i > 1) {
                                        MyEqn = MyEqn.substring(0, i);
                                    }
                                    log.info("UncertainityOLSExpr:ExtractUncEquation:2 Points:Equation=" + MyEqn + " HoldEqn=" + HoldEqn);

                                    MyEqn += HoldEqn + "+";
                                } else {
                                    MyEqn += HoldEqn + "+";
                                }
                            }
                            j++;
                            log.info("UncertainityOLSExpr:ExtractUncEquation:2 Points:Equation=" + MyEqn);
                            log.info("UncertainityOLSExpr:ExtractUncEquation:2 Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                    log.fatal("UncertainityOLSExpr:ExtractUncEquation:k==2:Return Equation=" + x.Equation());
                    return x;
                } else {
                    log.info("UncertainityOLSExpr:ExtractUncEquation:0 OR 1 Points:ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    log.info("UncertainityOLSExpr:ExtractUncEquation:DataArray ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex);
                    String Temp = "";
                    if ((AscDescStop == null) || (AscDescStop.equalsIgnoreCase("")) || (AscDescStart == null) || AscDescStart.equalsIgnoreCase(""))
                        ; else {
                        Temp = FormUnCerLine(StartIndex, StopIndex, PCHash, LocalGlobal);
                    }
                    if ((Temp != null) && (!Temp.equalsIgnoreCase(""))) {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("UncertainityOLSExpr:ExtractUncEquation:Final:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                    } else {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("UncertainityOLSExpr:ExtractUncEquation:Returning Final:" + LocalGlobal);
                    }

                }
                log.fatal("UncertainityOLSExpr:ExtractUncEquation:Else:Return Equation=" + x.Equation());
                return x;
            }

            String FormUnCerLine(int StrtIndx, int StpIndx, HashMap MyPCHash, String LocalGlobal) {
                String x = "";
                String NewEqnPart = "";
                log.info("FormUnCerLine:Initial:" + LocalGlobal + ":AscDescStart=" + AscDescStart);
                log.info("FormUnCerLine:Initial:" + LocalGlobal + ":AscDescStop=" + AscDescStop);
                log.info("FormUnCerLine:Initial:" + LocalGlobal + ":StrtIndx=" + StrtIndx);
                log.info("FormUnCerLine:Initial:" + LocalGlobal + ":StpIndx=" + StpIndx);
                log.info("FormUnCerLine:Initial:" + LocalGlobal + ":StrtIndx(y)=" + MyPCHash.get(StrtIndx));
                log.info("FormUnCerLine:Initial:" + LocalGlobal + ":StpIndx(y)=" + MyPCHash.get(StpIndx));
                if ((AscDescStart == null) || (AscDescStart.equalsIgnoreCase("")) || (AscDescStop == null) || (AscDescStop.equalsIgnoreCase(""))) {
                    log.fatal("FormUnCerLine:Final:NULL:Return Value:" + LocalGlobal + ":x=" + x);
                    return x;
                }
                if (((AscDescStart.equalsIgnoreCase("Maxima")) || (AscDescStop.equalsIgnoreCase("Neutral-Dsc")) || (AscDescStop.equalsIgnoreCase("Neutral-Constant-Dsc")))) {
                    NewEqnPart = LineUnCerOLS(-1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = FinxNewEqnPart;
                    log.info("FormUnCerLine:Final:" + LocalGlobal + ":Minima:x=" + x);
                } else if (((AscDescStart.equalsIgnoreCase("Minima")) || (AscDescStop.equalsIgnoreCase("Neutral-Asc")) || (AscDescStop.equalsIgnoreCase("Neutral-Constant-Asc")))) {
                    NewEqnPart = LineUnCerOLS(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = FinxNewEqnPart;
                    log.info("FormUnCerLine:Final:" + LocalGlobal + ":Maxima:x=" + x);
                } else {
                    NewEqnPart = LineUnCerOLS(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    if (((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) && ((x != null) && (!x.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = x + NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormUnCerLine:else:" + LocalGlobal + ":Neutral:x=" + x);
                    } else if (((x == null) || (x.equalsIgnoreCase(""))) && ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormUnCerLine:else:NewEqnPart:Upper:" + LocalGlobal + ":Neutral:x=" + x);
                    } else if ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormUnCerLine:else:NewEqnPart:Lower:" + LocalGlobal + ":Neutral:x=" + x);
                    }
                    log.info("FormUnCerLine:Final:" + LocalGlobal + ":Neutral:x=" + x);
                }
                log.fatal("FormUnCerLine:Final:Return Value:" + LocalGlobal + ":x=" + x);
                return x;
            }

            String LineUnCerOLS(int InterceptDirection, int Base, int Strt, int Stp, HashMap MyPCHash, String LocalGlobal, int MaxIndex, String FinalEqn) {
                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                ConfirmTest BadData;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);

                String NewEqnPart = "";
                String Extrema = "";
                Double m = 0.0;
                Double c = 0.0;
                boolean StopFlagInit = false;
                boolean StartFlagInit = false;
                boolean BaseFlagInit = false;
                String[] TempDataStop = new String[6];
                String[] TempDataStart = new String[6];
                String[] TempDataBase = new String[6];
                log.info("LineUnCerOLS:Initial:" + LocalGlobal + ":Base(x0)=" + Base);
                log.info("LineUnCerOLS:Initial:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("LineUnCerOLS:Initial:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("LineUnCerOLS:Initial:" + LocalGlobal + ":Strt(y0)=" + MyPCHash.get(Base));
                log.info("LineUnCerOLS:Initial:" + LocalGlobal + ":Strt(y1)=" + MyPCHash.get(Strt));
                log.info("LineUnCerOLS:Initial:" + LocalGlobal + ":Stp(y2)=" + MyPCHash.get(Stp));
                //y2
                String TempStop = "";
                if (Stp >= 1) {
                    TempStop = (String) MyPCHash.get(Stp);
                }
                log.info("LineUnCerOLS:" + LocalGlobal + ":TempStop=" + TempStop);
                if ((TempStop != null) && (!TempStop.equalsIgnoreCase(""))) {
                    TempDataStop = TempStop.split(",");
                    StopFlagInit = true;
                }
                //y1
                String TempStart = "";
                TempStart = (String) MyPCHash.get(Strt);
                log.info("LineUnCerOLS:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempStart != null) && (!TempStart.equalsIgnoreCase(""))) {
                    TempDataStart = TempStart.split(",");
                    StartFlagInit = true;
                }
                //y0    OR  BASE
                String TempBase = "";
                TempBase = (String) MyPCHash.get(Base);
                log.info("LineUnCerOLS:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempBase != null) && (!TempBase.equalsIgnoreCase(""))) {
                    TempDataBase = TempBase.split(",");
                    if ((TempDataStart[1].equalsIgnoreCase(TempDataBase[1])) && (Base > 1)) {
                        TempBase = (String) MyPCHash.get(Base - 1);
                        log.info("LineUnCerOLS:" + LocalGlobal + ":TempBase=" + TempBase);
                        TempDataBase = TempBase.split(",");
                    }
                    BaseFlagInit = true;
                }
                log.info("LineUnCerOLS:" + LocalGlobal + ":TempBase=" + TempBase);

                log.info("LineUnCerOLS:InterceptDirection=" + InterceptDirection + " StartFlagInit=" + StartFlagInit + ":StopFlagInit=" + StopFlagInit);

                log.info("LineUnCerOLS:Symbol=" + Symbol);
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    //y=m*(x-x1) +y1
                    //m=(y2-y1)/(x2-x1)
                    //c= (x2y1-x1y2)/(x2-x1)
                    //c=y1 
                    m = (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1]))
                            / (Stp - Strt);
                    c = Double.parseDouble(TempDataStart[1]);
                    log.info("LineUnCerOLS:TempDataStop[1])=" + TempDataStop[1] + " TempDataStart[1]=" + TempDataStart[1]);
                    log.info("LineUnCerOLS:(Double.parseDouble(TempDataStop[1])-Double.parseDouble(TempDataStart[1])=" + (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1])));
                }
                if ((InterceptDirection == 1)) {
                    Extrema = "Maxima";
                } else if ((InterceptDirection == -1)) {
                    Extrema = "Minima";
                }
                log.info("LineUnCerOLS:m=" + m + " c=" + c);
                log.info("LineUnCerOLS:Base=" + Base + " (Stp+Strt)=" + (Stp + Strt) + " (Stp-Strt)=" + (Stp - Strt));
                log.info("LineUnCerOLS:TempDataBase[1]=" + TempDataBase[1] + " TempDataStart[1]=" + TempDataStart[1] + " TempDataStop[1]=" + TempDataStop[1]);
                if ((TempDataStart[1] == null) || (TempDataStart[1].equalsIgnoreCase("")) || (TempDataStop[1] == null) || (TempDataStop[1].equalsIgnoreCase(""))) {
                    log.fatal("LineUnCerOLS:NULL:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    return NewEqnPart;
                }
                if ((!FinalEqn.contains(Symbol + "P" + (Base + 1))) && (!FinalEqn.contains(Symbol + "P" + Base))) {
                    NewEqnPart = (Double.parseDouble(TempDataStart[1]) - Double.parseDouble(TempDataBase[1])) + "*" + ("(" + Symbol + "P" + Base + ")") + "+" + (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1])) + "*" + ("(" + Symbol + "P" + (Base + 1) + ")");
                    log.info("LineUnCerOLS:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                } else if (!FinalEqn.contains(Symbol + "P" + Base)) {
                    NewEqnPart = (Double.parseDouble(TempDataStart[1]) - Double.parseDouble(TempDataBase[1])) + "*" + ("(" + Symbol + "P" + Base + ")");
                    log.info("LineUnCerOLS:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                } else if (!FinalEqn.contains(Symbol + "P" + (Base + 1))) {
                    NewEqnPart = (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1])) + "*" + ("(" + Symbol + "P" + (Base + 1) + ")");
                    log.info("LineUnCerOLS:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                }
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    log.info("LineUnCerOLS:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    variables.put(DiffWithRespTo, (double) (Stp));
                    BadData = ConfirmEqn(NewEqnPart, Strt, Stp, PCHash, variables, DiffWithRespTo, LocalGlobal);
                    ConfirmFlag = BadData.eval();
                }
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":m=" + m);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":c=" + c);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStop[1](y2)=" + TempDataStop[1]);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStart[1](y1)=" + TempDataStart[1]);
                log.info("LineUnCerOLS:" + Extrema + ":Final:" + LocalGlobal + ":ConfirmFlag=" + ConfirmFlag);
                return NewEqnPart;
            }

        }.ExtractUncEquation();
    }

    @FunctionalInterface
    public interface EntropyExpr {

        String Equation();
    }

    public static EntropyExpr EntropyEqnExpr(int StartIndex, String Symbol, LinkedList<Double[]> Data, int MaxIndex, boolean ApplyAtLowLevel, final int EntropySelected, String FinalEntropyEqn, String FinalPredEntropy) {

        return new Object() {

            EntropyExpr ExtractEntropyEquation() {
                MathsExpressionParser.Expression x = (() -> 0.0);
                EntropyExpr y = (() -> "");
                ConfirmTest BadData;
                Map<String, Double> variables = new HashMap<>();

                String DiffWithRespTo = "x";
                String MyEqn = "";
                log.fatal("EntropyExpr:ExtractEntropyEquation:Initial:StartIndex=" + StartIndex);
                // If there are N points between Maxima & Minima
                for (int i = StartIndex; (i < MaxIndex); i++) {
                    String HoldEqn = EntropyCalculate(i, x, variables, FinalEntropyEqn, DiffWithRespTo, EntropySelected);
                    if (HoldEqn.startsWith("-")) {
                        int j = MyEqn.lastIndexOf("+");
                        if (j > 0) {
                            MyEqn = MyEqn.substring(0, j);
                            MyEqn = MyEqn + HoldEqn + "+";
                        } else {
                            MyEqn = MyEqn + HoldEqn + "+";
                        }
                    } else if ((!MyEqn.equalsIgnoreCase("")) && (!HoldEqn.equalsIgnoreCase(""))) {
                        MyEqn = MyEqn + HoldEqn + "+";
                    } else if ((MyEqn.equalsIgnoreCase("")) && (!HoldEqn.equalsIgnoreCase(""))) {
                        MyEqn = HoldEqn + "+";
                    }
                }
                final String MyEqn1 = MyEqn;
                y = (() -> MyEqn1);
                log.fatal("EntropyExpr:ExtractEntropyEquation:Return Equation=" + y.Equation());
                return y;
            }

            String EntropyCalculate(int i, Expression expValueEntropy, Map<String, Double> variables, String FinalEquationEntropy, String DiffWithRespTo, final int EntropySelected) {
                Double PredictedValueDiff = 0.0;
                Double PredictedValue = 0.0;
                Double[] Temp2 = new Double[Max_Data_Col];
                Double[] Temp3 = new Double[Max_Data_Col];
                String FinalEqnEntropy = "";
                int j = i - EntropySelected;
                // Processing Entropy Output Values
                if ((i >= 1)&&(j >=0)) {
                    PredictedValueDiff = (Data.get(i)[0].doubleValue() - Data.get(j)[0].doubleValue());
                    Temp2[0] = PredictedValueDiff;
                    PredictedValue = Data.get(i - 1)[0].doubleValue() + PredictedValueDiff;
                    Temp3[0] = PredictedValue;
                    if (PredictedValueDiff > 0) {
                        if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                            FinalEquationEntropy = FinalEquationEntropy + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j));
                        } else {
                            FinalEquationEntropy = PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j));
                        }
                    } else if (PredictedValueDiff == 0) {
                        if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                            FinalEquationEntropy = FinalEquationEntropy + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j));
                        } else {
                            FinalEquationEntropy = PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j));
                        }
                    } else if (PredictedValueDiff < 0) {
                        if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                            FinalEquationEntropy = FinalEquationEntropy + PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j));
                        } else {
                            FinalEquationEntropy = PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j));
                        }
                    }
                    variables.put((DiffWithRespTo + (i) + "E" + (j)), 1.0);
                    expValueEntropy = parse(FinalEquationEntropy, variables, (DiffWithRespTo + (i + 1) + "E" + (j)),false, "Silent", MathsExpressionParser.LogLevel.Off);
                    PredictedValue = Data.get(j)[0].doubleValue() + expValueEntropy.eval();
                    if (PredictedValue != Data.get(i)[0].doubleValue()) {
                        log.fatal("EntropyCalculate:FATAL:i=" + i + " j=" + j + " DataArray.get(i)[0]=" + Data.get(i)[0].doubleValue() + " PredictedValue=" + PredictedValue + " expValueEntropy.eval()=" + expValueEntropy.eval());
                    }
                    variables.put((DiffWithRespTo + (i) + "E" + (j - 1)), 0.0);
                } else if (i == 0) {
                    PredictedValueDiff = 0.0;
                    Temp2[0] = PredictedValueDiff;
                    Temp3[0] = Data.get(i)[0].doubleValue();
                }
                if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                    FinalEqnEntropy = FinalEquationEntropy;
                }
                log.fatal("EntropyCalculate:i=" + i + " FinalEqnEntropy=" + FinalEqnEntropy);
                return FinalEqnEntropy;
            }

        }.ExtractEntropyEquation();
    }

    @FunctionalInterface
    public interface EntropyPredicateExpr {

        String Equation();
    }

    public static EntropyPredicateExpr EntropyEqnPredicate(int StartIndex, HashMap PCHash, String Symbol, LinkedList<Double[]> Data, int MaxIndex, boolean ApplyAtLowLevel, String FinalEntropyEqn, String FinalPredEntropy) {

        return new Object() {

            EntropyPredicateExpr ExtractEntropyPredicate() {
                EntropyPredicateExpr y = (() -> "");
                ConfirmTest BadData;

                String DiffWithRespTo = "x";
                String MyEqn = "";
                log.fatal("EntropyExpr:ExtractEntropyEquation:Initial:StartIndex=" + StartIndex);
                // If there are N points between Maxima & Minima
                for (int i = StartIndex; (i < MaxIndex); i++) {
                    String HoldEqn = EntropyFormPredicate(i, variables, FinalPredEntropy, DiffWithRespTo);
                    if (!HoldEqn.equalsIgnoreCase("")) {
                        //System.out.println("ExtractEntropyPredicate:HoldEqn=" + HoldEqn);
                        if ((HoldEqn.startsWith("||")) && (MyEqn.equalsIgnoreCase(""))) {
                            MyEqn = HoldEqn.replaceFirst("||", "");
                        } else if (HoldEqn.startsWith("||")) {
                            MyEqn = MyEqn + HoldEqn;
                        } else if ((!HoldEqn.startsWith("||")) && (!MyEqn.equalsIgnoreCase(""))) {
                            MyEqn = MyEqn + "||" + HoldEqn;
                        } else if ((!HoldEqn.startsWith("||")) && (MyEqn.equalsIgnoreCase(""))) {
                            MyEqn = HoldEqn;
                        }
                    } else
                        ;//Do Nothing
                }
                final String MyEqn1 = MyEqn;
                y = (() -> MyEqn1);
                log.fatal("EntropyExpr:ExtractEntropyEquation:Return Equation=" + y.Equation());
                return y;
            }

            String EntropyFormPredicate(int i, Map<String, Double> variables, String FinalPredEntropy, String DiffWithRespTo) {
                // Processing Entropy Predicate Variables
                if (i >= 1) {
                    for (int j = i; (j > 0) && (j > (i - EntropyLimit)); j--) {
                        variables.put((DiffWithRespTo + (i) + "E" + (j - 1)), 1.0);
                        if (!FinalPredEntropy.equalsIgnoreCase("")) {
                            FinalPredEntropy = FinalPredEntropy + "||" + "(" + DiffWithRespTo + "==" + (DiffWithRespTo + (i) + "E" + (j - 1)) + ")";
                        } else {
                            FinalPredEntropy = "(" + DiffWithRespTo + "==" + (DiffWithRespTo + (i) + "E" + (j - 1)) + ")";
                        }
                        variables.put((DiffWithRespTo + (i) + "E" + (j - 1)), 0.0);
                    }
                } else if (i == 0) {
                    ;//Do Nothing
                }
                log.fatal("EntropyCalculate:i=" + i + " FinalEqnEntropy=" + FinalPredEntropy);
                return FinalPredEntropy;
            }

        }.ExtractEntropyPredicate();
    }

    @FunctionalInterface
    public interface EndPointExpr {

        String Equation();
    }

    public static EndPointExpr EndPointUncerExpr(int StartIndex, String Symbol, LinkedList<Double[]> Data, int MaxIndex) {

        return new Object() {

            EndPointExpr EndPointUncerEquation() {
                Expression x = (() -> 0.0);
                EndPointExpr y = (() -> "");
                ConfirmTest BadData;
                Map<String, Double> variables = new HashMap<>();

                String DiffWithRespTo = "x";
                String MyEqn = "";
                log.fatal("EntropyExpr:ExtractEntropyEquation:Initial:StartIndex=" + StartIndex);
                // If there are N points between Maxima & Minima
                for (int i = StartIndex; (i < MaxIndex); i++) {
                    String HoldEqn = EndPointUncerCalculate(MaxIndex, i, x, variables, DiffWithRespTo);
                    if (HoldEqn.startsWith("-")) {
                        int j = MyEqn.lastIndexOf("+");
                        if (j > 0) {
                            MyEqn = MyEqn.substring(0, j);
                            MyEqn = MyEqn + HoldEqn + "+";
                        } else {
                            MyEqn = MyEqn + HoldEqn + "+";
                        }
                    } else if ((!MyEqn.equalsIgnoreCase("")) && (!HoldEqn.equalsIgnoreCase(""))) {
                        MyEqn = MyEqn + HoldEqn + "+";
                    } else if ((MyEqn.equalsIgnoreCase("")) && (!HoldEqn.equalsIgnoreCase(""))) {
                        MyEqn = HoldEqn + "+";
                    }
                }
                final String MyEqn1 = MyEqn;
                y = (() -> MyEqn1);
                log.fatal("EntropyExpr:ExtractEntropyEquation:Return Equation=" + y.Equation());
                return y;
            }

            String EndPointUncerCalculate(int MaxIndex, int i, Expression expValueEntropy, Map<String, Double> variables, String DiffWithRespTo) {
                Double PredictedValueDiff = 0.0;
                Double PredictedValue = 0.0;
                String FinalEqnEntropy = "";
                // Processing Entropy Output Values
                PredictedValueDiff = (Data.get(MaxIndex)[0].doubleValue() - Data.get(i)[0].doubleValue());
                FinalEndPointEquationUnCer = PredictedValueDiff + "*" + (DiffWithRespTo + MaxIndex + "L" + (i));
                variables.put((DiffWithRespTo + (MaxIndex) + "L" + (i)), 1.0);
                expValueEntropy = parse(FinalEndPointEquationUnCer, variables, (DiffWithRespTo + (MaxIndex) + "L" + (i)), false,"Silent", MathsExpressionParser.LogLevel.Off);
                PredictedValue = Data.get(MaxIndex)[0].doubleValue() + expValueEntropy.eval();
                if (PredictedValue != Data.get(i)[0].doubleValue()) {
                    log.fatal("EntropyCalculate:FATAL:i=" + i + " DataArray.get(i)[0]=" + Data.get(i)[0].doubleValue() + " PredictedValue=" + PredictedValue + " expValueEntropy.eval()=" + expValueEntropy.eval());
                }
                variables.put((DiffWithRespTo + (MaxIndex) + "L" + (i)), 0.0);
                if (!FinalEndPointEquationUnCer.equalsIgnoreCase("")) {
                    FinalEqnEntropy = FinalEndPointEquationUnCer;
                }
                log.fatal("EntropyCalculate:i=" + i + " FinalEqnEntropy=" + FinalEqnEntropy);
                return FinalEqnEntropy;
            }

        }.EndPointUncerEquation();
    }

    @FunctionalInterface
    public interface UncertainityExpr {

        String Equation();
    }

    public static UncertainityExpr UncertainityEntropyEqnExpr(int StartIndex, String Symbol, LinkedList<Double[]> Data, int MaxIndex, boolean ApplyAtLowLevel, String FinalEntropyEqn, String FinalPredEntropy) {

        return new Object() {

            UncertainityExpr ExtractUncertainityEntropyEquation() {
                Expression x = (() -> 0.0);
                UncertainityExpr y = (() -> "");
                ConfirmTest BadData;
                Map<String, Double> variables = new HashMap<>();

                String DiffWithRespTo = "x";
                String MyEqn = "";
                log.fatal("UncertainityEntropyEqnExpr:ExtractUncertainityEntropyEquation:Initial:StartIndex=" + StartIndex);
                // If there are N points between Maxima & Minima
                for (int i = StartIndex; (i < MaxIndex); i++) {
                    String HoldEqn = EntropyCalculate(i, x, variables, FinalEntropyEqn, DiffWithRespTo);
                    if (HoldEqn.startsWith("-")) {
                        int j = MyEqn.lastIndexOf("+");
                        if (j > 0) {
                            MyEqn = MyEqn.substring(0, j);
                            MyEqn = MyEqn + HoldEqn + "+";
                        } else {
                            MyEqn = MyEqn + HoldEqn + "+";
                        }
                    } else if ((!MyEqn.equalsIgnoreCase("")) && (!HoldEqn.equalsIgnoreCase(""))) {
                        MyEqn = MyEqn + HoldEqn + "+";
                    } else if ((MyEqn.equalsIgnoreCase("")) && (!HoldEqn.equalsIgnoreCase(""))) {
                        MyEqn = HoldEqn + "+";
                    }
                }
                final String MyEqn1 = MyEqn;
                y = (() -> MyEqn1);
                log.fatal("UncertainityEntropyEqnExpr:ExtractUncertainityEntropyEquation:Return Equation=" + y.Equation());
                return y;
            }

            String EntropyCalculate(int i, Expression expValueEntropy, Map<String, Double> variables, String FinalEquationEntropy, String DiffWithRespTo) {
                Double PredictedValueDiff = 0.0;
                Double PredictedValue = 0.0;
                Double[] Temp2 = new Double[Max_Data_Col];
                Double[] Temp3 = new Double[Max_Data_Col];
                String FinalEqnUncerEntropy = "";
                // Processing Entropy Output Values
                if (i >= 1) {
                    for (int j = i - 1; (j >= 0) && (j >= (i - UncertaityLimit)); j--) {
                        PredictedValueDiff = (Data.get(i)[0].doubleValue() - Data.get(j)[0].doubleValue());
                        Temp2[0] = PredictedValueDiff;
                        PredictedValue = Data.get(j)[0].doubleValue() + PredictedValueDiff;
                        Temp3[0] = PredictedValue;
                        if (PredictedValueDiff > 0) {
                            if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                                FinalEquationEntropy = FinalEquationEntropy + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + i + "UE" + (j));
                            } else {
                                FinalEquationEntropy = PredictedValueDiff + "*" + (DiffWithRespTo + i + "UE" + (j));
                            }
                        } else if (PredictedValueDiff == 0) {
                            if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                                FinalEquationEntropy = FinalEquationEntropy + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + i + "UE" + (j));
                            } else {
                                FinalEquationEntropy = PredictedValueDiff + "*" + (DiffWithRespTo + i + "UE" + (j));
                            }
                        } else if (PredictedValueDiff < 0) {
                            if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                                FinalEquationEntropy = FinalEquationEntropy + PredictedValueDiff + "*" + (DiffWithRespTo + i + "UE" + (j));
                            } else {
                                FinalEquationEntropy = PredictedValueDiff + "*" + (DiffWithRespTo + i + "UE" + (j));
                            }
                        }
                        variables.put((DiffWithRespTo + (i) + "UE" + (j)), 1.0);
                        expValueEntropy = parse(FinalEquationEntropy, variables, (DiffWithRespTo + (i + 1) + "UE" + (j)), false,"Silent", MathsExpressionParser.LogLevel.Off);
                        PredictedValue = Data.get(j)[0].doubleValue() + expValueEntropy.eval();
                        if (PredictedValue != Data.get(i)[0].doubleValue()) {
                            log.fatal("EntropyCalculate:FATAL:i=" + i + " j=" + j + " DataArray.get(i)[0]=" + Data.get(i)[0].doubleValue() + " PredictedValue=" + PredictedValue + " expValueEntropy.eval()=" + expValueEntropy.eval());
                        }
                        variables.put((DiffWithRespTo + (i) + "UE" + (j)), 0.0);
                        variables.remove(DiffWithRespTo + (i) + "UE" + (j));
                    }
                } else if (i == 0) {
                    PredictedValueDiff = 0.0;
                    Temp2[0] = PredictedValueDiff;
                    Temp3[0] = Data.get(i)[0].doubleValue();
                }
                variables.clear();
                if (!FinalEquationEntropy.equalsIgnoreCase("")) {
                    FinalEqnUncerEntropy = FinalEquationEntropy;
                }
                log.fatal("EntropyCalculate:i=" + i + " FinalEqnUncerEntropy=" + FinalEqnUncerEntropy);
                return FinalEqnUncerEntropy;
            }

        }.ExtractUncertainityEntropyEquation();
    }

    /* ************************** Main Calling Functions and Routines Begin *******/
    public static int FormGroup(int Start, String Symbol, int Max_Data, HashMap PCHash, Map<String, Double> variables, String FinalEqn, String FinalPred, int Innerk, int InnerStart) {
        int j = 0;
        String Temp = "";
        String TempK = "";
        String[] TempDataK = new String[6];
        RegressionExpr MyEqn;

        Temp = (String) PCHash.get(Start);
        String[] TempData = new String[6];
        TempData = Temp.split(",");
        int k = Start + 1;
        for (; (k < (PCHash.size() - 1));) {
            //for (k = i + 1; (k < (15));) {
            TempK = (String) PCHash.get(k);
            TempDataK = TempK.split(",");
            if ((TempDataK[0].equalsIgnoreCase("Minima")) || (TempDataK[0].equalsIgnoreCase("Neutral-Zero"))) {
                break;
            } else if ((TempDataK[0].equalsIgnoreCase("Maxima"))) {
                break;
            } else {
                k++;
            }
        }
        if (InnerStart == 0) {
            MyEqn = RegressExtractEqnExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
        } else if ((InnerStart > 0) && (k <= 2)) {
            MyEqn = RegressExtractEqnExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
        } else {
            MyEqn = RegressExtractEqnExpr(TempData[0], TempDataK[0], InnerStart, Innerk, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
        }
        final String Equation = MyEqn.Equation();
        log.info("FormGroup:k=" + k + " InnerStart=" + InnerStart + " Equation=" + Equation);
        log.info("FormGroup:k=" + k + " InnerStart=" + InnerStart + " FinalEqn=" + FinalEqn);
        log.info("FormGroup:k=" + k + " InnerStart=" + InnerStart + " FinalPred=" + FinalPred);
        log.info("FormGroup:k=" + k + " Start=" + Start + " Max_Data=" + Max_Data + " InnerStart=" + InnerStart);
        if ((Start < Max_Data) && (k <= Max_Data)) {
            MyGroup[MyGroupIndex][0] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][1] = Symbol + "==" + Symbol + Start;
            //2nd Segment :F(x) =Equation for Start <=x <= Stop
            //F(x)=Equation
            if ((Equation != null) && (!Equation.equalsIgnoreCase(""))) {
                MyGroup[MyGroupIndex][2] = Equation;
            }

            log.fatal("FormGroup:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyGroup[MyGroupIndex][j]);
            //Predicate for F(x)=Equation
            String TempPred = "";
            for (int z = Start; (z <= k) && ((k - Start) > 2); z++) {
                if (z <= (k - 1)) {
                    if (!FinalPred.contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + z + ")" + "||";
                    }
                } else if (z == k) {
                    if (!FinalPred.contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + z + ")";
                    }
                }
                variables.put(Symbol + z, (double) 0.0);
            }
            if ((k - Start) > 2) 
                ; else if (((k - Start) >= 1) && (Start > 0)) {
                if ((!FinalPred.contains(Symbol + k)) && (!FinalPred.contains(Symbol + (k - 1)))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (k - 1) + ")" + "||" + "(" + Symbol + "==" + Symbol + k + ")";
                } else if (!FinalPred.contains(Symbol + k)) {
                    TempPred = "(" + Symbol + "==" + Symbol + k + ")";
                } else if (!FinalPred.contains(Symbol + (k - 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (k - 1) + ")";
                }
                variables.put(Symbol + (k - 1), (double) 0.0);
                variables.put(Symbol + (k), (double) 0.0);
                log.fatal("FormGroup:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            } else {

                if ((!FinalPred.contains(Symbol + (Start + 1))) && (!FinalPred.contains(Symbol + Start))) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")" + "||" + "(" + Symbol + "==" + Symbol + (Start + 1) + ")";
                } else if (!FinalPred.contains(Symbol + (Start + 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (Start + 1) + ")";
                } else if (!FinalPred.contains(Symbol + Start)) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")";
                } else if (!FinalPred.equalsIgnoreCase("")) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")";
                }
                variables.put(Symbol + Start, (double) 0.0);
                variables.put(Symbol + (Start + 1), (double) 0.0);
                log.fatal("FormGroup:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            }
            MyGroup[MyGroupIndex][3] = TempPred;

            //3rd Segment :F(x) =0 for x > Stop;
            //F(x)=0
            MyGroup[MyGroupIndex][4] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][5] = Symbol + "!=" + k;
            MyGroupIndex++;
        }
        return k;
    }

    public static int FormGroupOLS(int Start, String Symbol, int Max_Data, HashMap PCHash, Map<String, Double> variables, String FinalEqn, String FinalPred, int Innerk, int InnerStart) {
        int j = 0;
        String Temp = "";
        String TempK = "";
        String[] TempDataK = new String[6];
        RegressOLSExpr MyEqn;

        Temp = (String) PCHash.get(Start);
        String[] TempData = new String[6];
        TempData = Temp.split(",");
        int k = Start + 1;
        for (; (k < (PCHash.size() - 1));) {
            TempK = (String) PCHash.get(k);
            TempDataK = TempK.split(",");
            if ((TempDataK[0].equalsIgnoreCase("Minima")) || (TempDataK[0].equalsIgnoreCase("Neutral-Zero"))) {
                break;
            } else if ((TempDataK[0].equalsIgnoreCase("Maxima"))) {
                break;
            } else {
                k++;
            }
        }
        if ((InnerStart == 0)) {
            MyEqn = RegExtractEqnExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        } else if ((InnerStart > 0) && (k <= 2)) {
            MyEqn = RegExtractEqnExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        } else {
            MyEqn = RegExtractEqnExpr(TempData[0], TempDataK[0], InnerStart, Innerk, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupOLS:Else:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        }
        String Equation = MyEqn.Equation();
        log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + Equation);
        log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " FinalEqn=" + FinalEqn + " FinalEqn=" + FinalEqn);
        log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " FinalPred=" + FinalPred);
        log.fatal("FormGroupOLS:k=" + k + " Start=" + Start + " Max_Data=" + Max_Data + " InnerStart=" + InnerStart);
        if ((Start < Max_Data) && (k <= Max_Data)) {
            MyGroup[MyGroupIndex][0] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][1] = Symbol + "==" + Symbol + Start;
            //2nd Segment :F(x) =Equation for Start <=x <= Stop
            //F(x)=Equation
            if ((Equation != null) && (!Equation.equalsIgnoreCase(""))) {
                MyGroup[MyGroupIndex][2] = Equation;
                log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " MyGroup[MyGroupIndex][2]=" + MyGroup[MyGroupIndex][2] + " FinalEqn=" + FinalEqn);

            }

            log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyGroup[MyGroupIndex][2]);
            //Predicate for F(x)=Equation
            String TempPred = "";
            for (int z = Start; (z <= k) && ((k - Start) > 2); z++) {
                if (z <= (k - 1)) {
                    if (!FinalPred.contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + z + ")" + "||";
                    }
                } else if (z == k) {
                    if (!FinalPred.contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + z + ")";
                    }
                }
                variables.put(Symbol + z, (double) 0.0);
            }
            if ((k - Start) > 2) 
                ; else if (((k - Start) >= 1) && (Start > 0)) {
                if ((!FinalPred.contains(Symbol + k)) && (!FinalPred.contains(Symbol + (k - 1)))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (k - 1) + ")" + "||" + "(" + Symbol + "==" + Symbol + k + ")";
                } else if (!FinalPred.contains(Symbol + k)) {
                    TempPred = "(" + Symbol + "==" + Symbol + k + ")";
                } else if (!FinalPred.contains(Symbol + (k - 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (k - 1) + ")";
                }
                variables.put(Symbol + (k - 1), (double) 0.0);
                variables.put(Symbol + (k), (double) 0.0);
                log.fatal("FormGroupOLS:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            } else {

                if ((!FinalPred.contains(Symbol + (Start + 1))) && (!FinalPred.contains(Symbol + Start))) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")" + "||" + "(" + Symbol + "==" + Symbol + (Start + 1) + ")";
                } else if (!FinalPred.contains(Symbol + (Start + 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (Start + 1) + ")";
                } else if (!FinalPred.contains(Symbol + Start)) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")";
                } else if (!FinalPred.equalsIgnoreCase("")) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")";
                }
                variables.put(Symbol + Start, (double) 0.0);
                variables.put(Symbol + (Start + 1), (double) 0.0);
                log.fatal("FormGroupOLS:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            }
            MyGroup[MyGroupIndex][3] = TempPred;

            //3rd Segment :F(x) =0 for x > Stop;
            //F(x)=0
            MyGroup[MyGroupIndex][4] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][5] = Symbol + "!=" + k;
            MyGroupIndex++;
        }
        return k;
    }

    public static void RegressionOLSMain(HashMap PCHash) {
        // Regression Expression Variables
        // Integral Expression Variables
        Map<String, Double> variables = new HashMap<>();
        Expression expValue = (() -> 0.0);
        MyFuncExpress();
        String DiffWithRespTo = "x";
        // Generate the PCHASH MAP
        log.fatal("Regression:RegressionOLSMain:DataArray.size=" + DataArray.size());
        log.fatal("Regression:RegressionOLSMain:PCHash.size=" + PCHash.size());
        String FinalEquationRegress = "";
        String FinalPredicateRegress = "";
        int Max_Index = (int) ROWSREG;
        int i = 0;
        int k = 0;
        // Generate the Entropy Equation
        // Generate the Entropy Predicate Equation
        DataArrayOutput = new LinkedList<Double[]>();
        for (i = 0; (i < PCHash.size()); i++) {
            variables.clear();
            k = FormGroupOLS(i, DiffWithRespTo, PCHash.size(), PCHash, variables, FinalEquationRegress, FinalPredicateRegress, 0, 0);
            if ((MyGroup[MyGroupIndex - 1][2] != null)
                    && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
                ConfirmTest BadData = ConfirmEqn(MyGroup[MyGroupIndex - 1][2], i, k, PCHash, variables, DiffWithRespTo, "Global");
                boolean ConfirmFlag = BadData.eval();
                BadData = ConfirmEqn(MyGroup[MyGroupIndex - 1][2], i, k, PCHash, variables, DiffWithRespTo, "Global");
                ConfirmFlag = BadData.eval();
                log.fatal("RegressionOLSMain:i=" + i + " k=" + k + " ConfirmFlag=" + ConfirmFlag);
            }
            variables.remove((DiffWithRespTo + i));
            variables.put((DiffWithRespTo + k), 1.0);
            variables.put((DiffWithRespTo), 1.0);
            PredicateBool MyCondition = PredicateSep.parsePredicate(MyGroup[MyGroupIndex - 1][3], variables, "Silent", MathsContxtLAv.LogLevel.Off);
            boolean ConfirmPredicateFlag = MyCondition.eval();
            log.fatal("RegressionOLSMain:i=" + i + " k=" + k + " ConfirmPredicateFlag=" + ConfirmPredicateFlag + " MyGroup[" + (MyGroupIndex - 1) + "][3]=" + MyGroup[MyGroupIndex - 1][3] + " variables.get((DiffWithRespTo)=" + variables.get(DiffWithRespTo) + " variables.get(" + (DiffWithRespTo + k) + ")=" + variables.get(DiffWithRespTo + k));

            if ((MyGroup[MyGroupIndex - 1][2] != null) && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
                if (FinalEquationRegress.endsWith("+")) {
                    FinalEquationRegress = FinalEquationRegress + MyGroup[MyGroupIndex - 1][2];
                } else {
                    FinalEquationRegress = FinalEquationRegress + "+" + MyGroup[MyGroupIndex - 1][2];
                }
            } else if ((MyGroup[MyGroupIndex - 1][2] != null) && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
                FinalEquationRegress = MyGroup[MyGroupIndex - 1][2];
            }

            if ((MyGroup[MyGroupIndex - 1][3] != null) && (!MyGroup[MyGroupIndex - 1][3].equalsIgnoreCase("")) && (!FinalPredicateRegress.equalsIgnoreCase(""))) {
                FinalPredicateRegress = FinalPredicateRegress + "||" + MyGroup[MyGroupIndex - 1][3];
            } else {
                FinalPredicateRegress = MyGroup[MyGroupIndex - 1][3];
            }
            variables.remove((DiffWithRespTo + k));
            variables.remove((DiffWithRespTo));
            i = k - 1;
        }
        System.out.println("RegressionOLSMain:FinalEquationRegress=" + FinalEquationRegress);
        System.out.println("RegressionOLSMain:FinalPredicateRegress=" + FinalPredicateRegress);
        for (i = 0; (i < PCHash.size()); i++) {
            Double[] Temp1 = new Double[Max_Data_Col];
            variables.clear();
            variables.put((DiffWithRespTo + (i)), 1.0);
            expValue = parse(FinalEquationRegress, variables, (DiffWithRespTo + (i)), false,"Silent", MathsExpressionParser.LogLevel.Off);
            Temp1[0] = expValue.eval();
            DataArrayOutput.addLast(Temp1);
            if ((i < DataArrayOutput.size()) && (DataArrayOutput.get(i) != null) && (Temp1[0] != null)) {
                log.fatal("RegressionOLSMain:i=" + i + " x=" + variables.get((DiffWithRespTo + (i))) + " (" + DiffWithRespTo + (i) + ")=" + (DiffWithRespTo + (i)));
                log.fatal("RegressionOLSMain:i=" + i + " DataArrayOutput.get(i)[0]=" + DataArrayOutput.get(i)[0] + " Temp1[0]=" + Temp1[0].doubleValue() + " DataArrayOutput=" + DataArrayOutput.size());
                log.fatal("RegressionOLSMain:i=" + i + " Equation=" + FinalEquationRegress);
                log.fatal("RegressionOLSMain:i=" + i + " expValue.eval()=" + expValue.eval());
                log.fatal("RegressionOLSMain:i=" + i + " Predicate=" + FinalPredicateRegress);
                if (DataArray.get(i)[0].doubleValue() == DataArrayOutput.get(i)[0].doubleValue()) {
                    ;//System.out.println(ConsoleColors.GREEN + "RegressionOLSMain:Data Match:MisMatchCountRegress=" + MisMatchCountRegress + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataArrayOutput.get(" + i + ")[0]=" + DataArrayOutput.get(i)[0] + ConsoleColors.RESET);
                } else if (DataArray.get(i)[0].doubleValue() != DataArrayOutput.get(i)[0].doubleValue()) {
                    MisMatchCountRegress++;
                    //System.out.println(ConsoleColors.RED + "RegressionOLSMain:Data Mismatch:MisMatchCountRegress=" + MisMatchCountRegress + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataArrayOutput.get(" + i + ")[0]=" + DataArrayOutput.get(i)[0] + ConsoleColors.RESET);
                }
            }
            variables.remove(DiffWithRespTo + (i));
        }
//        for (i = 0; (i < DataArray.size()) && (i < DataArrayOutput.size()) && (DataArrayOutput.get(i) != null) && (DataArrayOutput.get(i)[0] != null); i++) {
//            System.out.println("RegressionOLSMain:DataArray.get[" + i + "][0].doubleValue()=" + DataArray.get(i)[0].doubleValue()
//                    + " DataArrayOutput[" + i + "]get(i)[0].doubleValue()=" + DataArrayOutput.get(i)[0].doubleValue());
//        }
        FinalEquation = FinalEquationRegress;
        FinalPredicate = FinalPredicateRegress;
    }

    public static int FormGroupUnCerOLS(int Start, String Symbol, int Max_Data, HashMap PCHash, Map<String, Double> variables, String FinalEqn, String FinalPred, int Innerk, int InnerStart) {
        int j = 0;
        String Temp = "";
        String TempK = "";
        String[] TempDataK = new String[6];
        UncertainityOLSExpr MyEqn;

        Temp = (String) PCHash.get(Start);
        String[] TempData = new String[6];
        TempData = Temp.split(",");
        int k = Start + 1;
        for (; (k < (PCHash.size() - 1));) {
            TempK = (String) PCHash.get(k);
            TempDataK = TempK.split(",");
            if ((TempDataK[0].equalsIgnoreCase("Minima")) || (TempDataK[0].equalsIgnoreCase("Neutral-Zero"))) {
                break;
            } else if ((TempDataK[0].equalsIgnoreCase("Maxima"))) {
                break;
            } else {
                k++;
            }
        }
        if ((InnerStart == 0)) {
            MyEqn = UncExtractEqnExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        } else if ((InnerStart > 0) && (k <= 2)) {
            MyEqn = UncExtractEqnExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        } else {
            MyEqn = UncExtractEqnExpr(TempData[0], TempDataK[0], InnerStart, Innerk, PCHash, Symbol, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupUnCerOLS:Else:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        }
        String Equation = MyEqn.Equation();
        log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + Equation);
        log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " FinalEqn=" + FinalEqn + " FinalEqn=" + FinalEqn);
        log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " FinalPred=" + FinalPred);
        log.fatal("FormGroupUnCerOLS:k=" + k + " Start=" + Start + " Max_Data=" + Max_Data + " InnerStart=" + InnerStart);
        if ((Start < Max_Data) && (k <= Max_Data)) {
            MyGroupUnCer[MyGroupUnCerIndex][0] = "0";
            //Predicate for F(x)=0
            MyGroupUnCer[MyGroupUnCerIndex][1] = Symbol + "==" + Symbol + "P" + Start;
            //2nd Segment :F(x) =Equation for Start <=x <= Stop
            //F(x)=Equation
            if ((Equation != null) && (!Equation.equalsIgnoreCase(""))) {
                MyGroupUnCer[MyGroupUnCerIndex][2] = Equation;
                log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " MyGroupUnCer[MyGroupUnCerIndex][2]=" + MyGroupUnCer[MyGroupUnCerIndex][2] + " FinalEqn=" + FinalEqn);

            }

            log.fatal("FormGroupUnCerOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyGroupUnCer[MyGroupUnCerIndex][2]);
            //Predicate for F(x)=Equation
            String TempPred = "";
            for (int z = Start; (z <= k) && ((k - Start) > 2); z++) {
                if (z <= (k - 1)) {
                    if (!FinalPred.contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + "P" + z + ")" + "||";
                    }
                } else if (z == k) {
                    if (!FinalPred.contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + "P" + z + ")";
                    }
                }
                variables.put(Symbol + z, (double) 0.0);
            }
            if ((k - Start) > 2) 
                ; else if (((k - Start) >= 1) && (Start > 0)) {
                if ((!FinalPred.contains(Symbol + k)) && (!FinalPred.contains(Symbol + (k - 1)))) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + (k - 1) + ")" + "||" + "(" + Symbol + "==" + Symbol + "P" + k + ")";
                } else if (!FinalPred.contains(Symbol + k)) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + k + ")";
                } else if (!FinalPred.contains(Symbol + (k - 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + (k - 1) + ")";
                }
                variables.put(Symbol + "P" + (k - 1), (double) 0.0);
                variables.put(Symbol + "P" + (k), (double) 0.0);
                log.fatal("FormGroupUnCerOLS:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            } else {

                if ((!FinalPred.contains(Symbol + (Start + 1))) && (!FinalPred.contains(Symbol + Start))) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + Start + ")" + "||" + "(" + Symbol + "==" + Symbol + "P" + (Start + 1) + ")";
                } else if (!FinalPred.contains(Symbol + (Start + 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + (Start + 1) + ")";
                } else if (!FinalPred.contains(Symbol + Start)) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + Start + ")";
                } else if (!FinalPred.equalsIgnoreCase("")) {
                    TempPred = "(" + Symbol + "==" + Symbol + "P" + Start + ")";
                }
                variables.put(Symbol + "P" + Start, (double) 0.0);
                variables.put(Symbol + "P" + (Start + 1), (double) 0.0);
                log.fatal("FormGroupUnCerOLS:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            }
            MyGroupUnCer[MyGroupUnCerIndex][3] = TempPred;

            //3rd Segment :F(x) =0 for x > Stop;
            //F(x)=0
            MyGroupUnCer[MyGroupUnCerIndex][4] = "0";
            //Predicate for F(x)=0
            MyGroupUnCer[MyGroupUnCerIndex][5] = Symbol + "!=" + k;
            MyGroupUnCerIndex++;
        }
        return k;
    }

    public static void UncertainityOLSMain(HashMap PCHash) {
        // Regression Expression Variables
        // Integral Expression Variables
        Map<String, Double> variablesUnCer = new HashMap<>();
        Expression expValue = (() -> 0.0);
        MyFuncExpress();
        String DiffWithRespTo = "x";
        // Generate the PCHASH MAP
        log.fatal("Regression:UncertainityOLSMain:DataArray.size=" + DataArray.size());
        log.fatal("Regression:UncertainityOLSMain:PCHash.size=" + PCHash.size());
        String FinalEqnUnCer = "";
        String FinalPredUnCer = "";
        int Max_Index = (int) ROWSREG;
        int i = 0;
        int k = 0;
        Double PredictedValue = 0.0;
        DataOutputCer = new LinkedList<Double[]>();
        DataOutputPredicted = new LinkedList<Double[]>();
        // Generate the Uncertainity Equation
        // Generate the Uncertainity Predicate Equation
        for (i = 0; (i < PCHash.size()); i++) {
            variablesUnCer.clear();
            k = FormGroupUnCerOLS(i, DiffWithRespTo, PCHash.size(), PCHash, variablesUnCer, FinalEqnUnCer, FinalPredUnCer, 0, 0);
            if ((MyGroupUnCer[MyGroupUnCerIndex - 1][2] != null)
                    && (!MyGroupUnCer[MyGroupUnCerIndex - 1][2].equalsIgnoreCase(""))) {
                ConfirmTest BadData = ConfirmEqn(MyGroupUnCer[MyGroupUnCerIndex - 1][2], i, k, PCHash, variablesUnCer, DiffWithRespTo, "Global");
                boolean ConfirmFlag = BadData.eval();
                BadData = ConfirmEqn(MyGroupUnCer[MyGroupUnCerIndex - 1][2], i, k, PCHash, variablesUnCer, DiffWithRespTo, "Global");
                ConfirmFlag = BadData.eval();
                log.fatal("UncertainityOLSMain:i=" + i + " k=" + k + " ConfirmFlag=" + ConfirmFlag);
            }
            variablesUnCer.remove(DiffWithRespTo + "P" + (i));
            variablesUnCer.put((DiffWithRespTo + "P" + k), 1.0);
            variablesUnCer.put((DiffWithRespTo), 1.0);
            PredicateBool MyCondition = parsePredicate(MyGroupUnCer[MyGroupUnCerIndex - 1][3], variablesUnCer, "Silent", MathsContxtLAv.LogLevel.Off);
            boolean ConfirmPredicateFlag = MyCondition.eval();
            log.fatal("UncertainityOLSMain:i=" + i + " k=" + k + " ConfirmPredicateFlag=" + ConfirmPredicateFlag + " MyGroup[" + (MyGroupUnCerIndex - 1) + "][3]=" + MyGroupUnCer[MyGroupUnCerIndex - 1][3] + " variablesUnCer.get((DiffWithRespTo)=" + variablesUnCer.get(DiffWithRespTo) + " variablesUnCer.get(" + (DiffWithRespTo + k) + ")=" + variablesUnCer.get(DiffWithRespTo + k));

            if ((!FinalEqnUnCer.equalsIgnoreCase("")) && (MyGroupUnCer[MyGroupUnCerIndex - 1][2] != null) && (!MyGroupUnCer[MyGroupUnCerIndex - 1][2].equalsIgnoreCase(""))) {
                if (FinalEqnUnCer.endsWith("+")) {
                    FinalEqnUnCer = FinalEqnUnCer + MyGroupUnCer[MyGroupUnCerIndex - 1][2];
                } else {
                    String MyEqn = MyGroupUnCer[MyGroupUnCerIndex - 1][2];
                    if (MyEqn.startsWith("-")) {
                        FinalEqnUnCer = FinalEqnUnCer + MyGroupUnCer[MyGroupUnCerIndex - 1][2];
                    } else {
                        FinalEqnUnCer = FinalEqnUnCer + "+" + MyGroupUnCer[MyGroupUnCerIndex - 1][2];
                    }
                }
            } else if ((MyGroupUnCer[MyGroupUnCerIndex - 1][2] != null) && (!MyGroupUnCer[MyGroupUnCerIndex - 1][2].equalsIgnoreCase(""))) {
                FinalEqnUnCer = MyGroupUnCer[MyGroupUnCerIndex - 1][2];
            }

            if ((!FinalPredUnCer.equalsIgnoreCase("")) && (MyGroupUnCer[MyGroupUnCerIndex - 1][3] != null) && (!MyGroupUnCer[MyGroupUnCerIndex - 1][3].equalsIgnoreCase(""))) {
                FinalPredUnCer = FinalPredUnCer + "||" + MyGroupUnCer[MyGroupUnCerIndex - 1][3];
            } else {
                FinalPredUnCer = MyGroupUnCer[MyGroupUnCerIndex - 1][3];
            }
            //variablesUnCer.put((DiffWithRespTo + "P" + k), 0.0);
            //variablesUnCer.put((DiffWithRespTo), 0.0);
            variablesUnCer.remove(DiffWithRespTo + "P" + (i));
            variablesUnCer.remove(DiffWithRespTo);
            i = k - 1;
        }
        System.out.println("UncertainityOLSMain:FinalEqnUnCer=" + FinalEqnUnCer);
        System.out.println("UncertainityOLSMain:FinalPredUnCer=" + FinalPredUnCer);
        for (i = 0; (i < PCHash.size()); i++) {
            Double[] Temp1 = new Double[Max_Data_Col];
            Double[] Temp2 = new Double[Max_Data_Col];
            variablesUnCer.put((DiffWithRespTo + "P" + (i)), 1.0);
            expValue = parse(FinalEqnUnCer, variablesUnCer, (DiffWithRespTo + (i)), false,"Silent", MathsExpressionParser.LogLevel.Off);
            Temp1[0] = expValue.eval();
            DataOutputCer.addLast(Temp1);
            if (i > 0) {
                PredictedValue = DataArrayOutput.get(i - 1)[0] + Temp1[0];
                Temp2[0] = PredictedValue;
            } else if (i == 0) {
                PredictedValue = DataArrayOutput.get(i)[0];
                Temp2[0] = PredictedValue;
            }
            DataOutputPredicted.addLast(Temp2);
            if ((i < DataOutputCer.size()) && (DataOutputCer.get(i) != null) && (Temp1[0] != null)) {
                log.fatal("UncertainityOLSMain:i=" + i + " x=" + variablesUnCer.get((DiffWithRespTo + "P" + (i))) + " (" + DiffWithRespTo + "P" + (i) + ")=" + (DiffWithRespTo + "P" + (i)));
                log.fatal("UncertainityOLSMain:i=" + i + " DataOutputCer.get(i)[0]=" + DataOutputCer.get(i)[0] + " Temp1[0]=" + Temp1[0].doubleValue() + " DataOutputCer=" + DataOutputCer.size());
                log.fatal("UncertainityOLSMain:i=" + i + " Equation=" + FinalEqnUnCer);
                log.fatal("UncertainityOLSMain:i=" + i + " expValue.eval()=" + expValue.eval());
                log.fatal("UncertainityOLSMain:i=" + i + " Predicate=" + FinalPredUnCer);
                if (DataArray.get(i)[0].doubleValue() == PredictedValue.doubleValue()) {
                    ;//System.out.println(ConsoleColors.GREEN + "UncertainityOLSMain:Data Match:MisMatchCountUncer=" + MisMatchCountUncer + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataOutputCer.get(" + i + ")[0]=" + DataOutputCer.get(i)[0] + " PredictedValue=" + PredictedValue + ConsoleColors.RESET);
                } else if (DataArray.get(i)[0].doubleValue() != PredictedValue.doubleValue()) {
                    MisMatchCountUncer++;
                    //System.out.println(ConsoleColors.RED + "UncertainityOLSMain:Data Mismatch:MisMatchCountUncer=" + MisMatchCountUncer + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataOutputCer.get(" + i + ")[0]=" + DataOutputCer.get(i)[0] + " PredictedValue=" + PredictedValue + ConsoleColors.RESET);
                }
            }
            //variablesUnCer.put((DiffWithRespTo + "P" + (i)), 0.0);
            variablesUnCer.remove((DiffWithRespTo + "P" + (i)));
        }
//        for (i = 0; (i < DataArray.size()) && (i < DataOutputCer.size()) && (DataOutputCer.get(i) != null) && (DataOutputCer.get(i)[0] != null); i++) {
//            System.out.println("UncertainityOLSMain:DataArray.get[" + i + "][0].doubleValue()=" + DataArray.get(i)[0].doubleValue()
//                    + " PredictedValue=" + DataOutputPredicted.get(i)[0].doubleValue()
//                    + " DataOutputCer[" + i + "]get(i)[0].doubleValue()=" + DataOutputCer.get(i)[0].doubleValue());
//        }
        FinalEquationUnCer = FinalEqnUnCer;
        FinalPredicateUnCer = FinalPredUnCer;
    }

    public static void EntropyMain(HashMap PCHash) {
        // Regression Expression Variables
        // Integral Expression Variables
        EntropyExpr x = (() -> "");
        EntropyPredicateExpr EntrpyConditionEqn = (() -> "");
        MyFuncExpress();
        String DiffWithRespTo = "x";
        log.fatal("Regression:EntropyMain:DataArray.size=" + DataArray.size());
        log.fatal("Regression:EntropyMain:PCHash.size=" + PCHash.size());
        String FinalEqnEntropy = "";
        String FinalPredEntropy = "";
        int i = 0;

        FinalEquationEntropy = new String[EntropyLimit];
        // Generate the Entropy Equation
        for (int kEntropySelected = 0; (kEntropySelected >= 0) && (kEntropySelected < EntropyLimit); kEntropySelected++) {
            x = EntropyEqnExpr(i, DiffWithRespTo, DataArray, PCHash.size(), ApplyAtLowLevel, kEntropySelected, FinalEqnEntropy, FinalPredEntropy);
            FinalEquationEntropy[kEntropySelected] = x.Equation();
        }
        // Generate the Entropy Predicate Equation
        EntrpyConditionEqn = EntropyEqnPredicate(i, PCHash, DiffWithRespTo, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqnEntropy, FinalPredEntropy);
        FinalPredicateEntropy = EntrpyConditionEqn.Equation();

        System.out.println("EntropyMain:FinalEquationUnCer=" + FinalEquationUnCer);
        System.out.println("EntropyMain:FinalPredicateUnCer=" + FinalPredicateUnCer);

        System.out.println("EntropyMain:FinalEquationEntropy[" + EntropySelected + "]=" + FinalEquationEntropy[EntropySelected]);
        System.out.println("EntropyMain:FinalPredicateEntropy=" + FinalPredicateEntropy);
        EndPointProcessMain(PCHash);
        System.out.println("EntropyMain:FinalEndPointEquationUnCer=" + FinalEndPointEquationUnCer);
    }

    public static void EndPointProcessMain(HashMap PCHash) {
        String FinalEndPointStr = "";
        String DiffWithRespTo = "x";
        int i = 0;
        EndPointExpr x = (() -> "");
        x = EndPointUncerExpr(i, DiffWithRespTo, DataArray, PCHash.size() - 2);
        FinalEndPointStr = x.Equation();

        FinalEndPointEquationUnCer = FinalEndPointStr;
    }

    public static void UncertainityMain(HashMap PCHash) {
        // Regression Expression Variables
        // Integral Expression Variables
        UncertainityExpr x = (() -> "");
        EntropyPredicateExpr EntrpyConditionEqn = (() -> "");
        MyFuncExpress();
        String DiffWithRespTo = "x";
        log.fatal("Regression:UncertainityMain:DataArray.size=" + DataArray.size());
        log.fatal("Regression:UncertainityMain:PCHash.size=" + PCHash.size());
        String FinalEqnEntropy = "";
        String FinalPredEntropy = "";
        int i = 0;
        // Generate the Entropy Equation
        x = UncertainityEntropyEqnExpr(i, DiffWithRespTo, DataArray, PCHash.size(), ApplyAtLowLevel, FinalEqnEntropy, FinalPredEntropy);
        FinalUncertainityEntropy = x.Equation();
        System.out.println("UncertainityMain:FinalEquationUnCer=" + FinalUncertainityEntropy);

    }

    public static void DisplayData(HashMap PCHash) {
        String DiffWithRespTo = "x";
        for (int m = 0, nEntrpy = -EntropySelected, jUncer = -UncertaityLimit, k = 0; m < (PastREADDATA + FutureREADDATA); m++, jUncer++, nEntrpy++) {
            k = m - 2;
            if (k <= -1) {
                Double[] MyTemp = new Double[Max_Data_Col];
                MyTemp[0] = DataArray.get(m)[0].doubleValue();
                DataRegressed.addFirst(MyTemp);
                DataUncertainity.addFirst(MyTemp);
                System.out.println(ConsoleColors.RED + "Input:Output: Data=" + MyTemp[0] + " at point:i=" + m + " j=" + jUncer + ConsoleColors.RESET);
            } else if (k == 0) {
                Double[] MyTemp = new Double[Max_Data_Col];
                MyTemp[0] = DataArray.get(m)[0].doubleValue();
                DataRegressed.addLast(MyTemp);
                ComputedValueUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                ComputedValueUNCEREntropy(m, jUncer, k, DiffWithRespTo);
                ComputedValueHindSightUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                System.out.println(ConsoleColors.RED + "Input:Output: Data=" + MyTemp[0] + " at point:i=" + m + " j=" + jUncer + ConsoleColors.RESET);
            } else if (k == 1) {
                Double[] MyTemp = new Double[Max_Data_Col];
                MyTemp[0] = DataArray.get(m)[0].doubleValue();
                DataRegressed.addLast(MyTemp);
                ComputedValueUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                ComputedValueUNCEREntropy(m, jUncer, k, DiffWithRespTo);
                ComputedValueHindSightUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                System.out.println(ConsoleColors.RED + "Input:Output: Data=" + MyTemp[0] + " at point:i=" + m + " j=" + jUncer + ConsoleColors.RESET);
            } else if ((k > 1) && (k < (PastREADDATA + FutureREADDATA)) && (nEntrpy >= 0) && (nEntrpy < m)) {
                {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    } else {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60);
                    }
                    System.out.println("DisplayData (k > 1) Started:Run Time:" + current + " ");
                    StrCurrentTimeTaken = localStrCurrentTimeTaken;
                }
                ComputedValue(FinalEquationEntropy[EntropySelected], m, nEntrpy, k, DiffWithRespTo);
                {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    } else {
                        if (TimeTaken.length == 3)
                            System.out.println("DisplayData (k > 1):ComputedValue:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] + " Time Taken2=" + TimeTaken[2]);
                        else
                            System.out.println("DisplayData (k > 1):Else:ComputedValue:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] );
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60);
                    }
                    System.out.println("DisplayData (k > 1):ComputedValue:Completed: Started:Run Time:" + current + " Time Taken=" + (1000.0 * (Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrCurrentTimeTaken))) + " milli seconds.");
                    StrCurrentTimeTaken = localStrCurrentTimeTaken;
                }
                ComputedValueUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    } else {
                        if (TimeTaken.length == 3)
                            System.out.println("DisplayData (k > 1):ComputedValueUncer:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] + " Time Taken2=" + TimeTaken[2]);
                        else
                            System.out.println("DisplayData (k > 1):Else:ComputedValueUncer:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] );
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60);
                    }
                    System.out.println("DisplayData (k > 1):ComputedValueUncer:Completed: Started:Run Time:" + current + " Time Taken=" + (1000.0 * (Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrCurrentTimeTaken))) + " milli seconds.");
                    StrCurrentTimeTaken = localStrCurrentTimeTaken;
                }
                ComputedValueUNCEREntropy(m, jUncer, k, DiffWithRespTo);
                {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    } else {
                        if (TimeTaken.length == 3)
                            System.out.println("DisplayData (k > 1):ComputedValueUNCEREntropy:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] + " Time Taken2=" + TimeTaken[2]);
                        else
                            System.out.println("DisplayData (k > 1):Else:ComputedValueUNCEREntropy:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] );
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60);
                    }
                    System.out.println("DisplayData (k > 1):ComputedValueUNCEREntropy:Completed: Started:Run Time:" + current + " Time Taken=" + (1000.0 * (Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrCurrentTimeTaken))) + " milli seconds.");
                    StrCurrentTimeTaken = localStrCurrentTimeTaken;
                }
                ComputedValueHindSightUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                {
                    LocalDateTime current = LocalDateTime.now();
                    String[] TimeTaken = current.toString().split(":");
                    String localStrCurrentTimeTaken = "";
                    if (TimeTaken.length == 3) {
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60) + (Double.parseDouble(TimeTaken[2]));
                    } else {
                        if (TimeTaken.length == 3)
                            System.out.println("DisplayData (k > 1):ComputedValueHindSightUncer:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] + " Time Taken2=" + TimeTaken[2]);
                        else
                            System.out.println("DisplayData (k > 1):Else:ComputedValueHindSightUncer:Completed: Started:Run Time:" + current + " Time Taken0=" + TimeTaken[0] + " Time Taken1=" + TimeTaken[1] );
                        localStrCurrentTimeTaken = "" + (Integer.parseInt(TimeTaken[1]) * 60);
                    }
                    System.out.println("DisplayData (k > 1):ComputedValueHindSightUncer:Completed: Started:Run Time:" + current + " Time Taken=" + (1000.0 * (Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(StrCurrentTimeTaken))) + " milli seconds.");
                }
            } else if (nEntrpy < 0) {
                Double[] MyTemp = new Double[Max_Data_Col];
                MyTemp[0] = DataArray.get(m)[0].doubleValue();
                if (jUncer > -EntropyLimit) {
                    DataRegressed.addLast(MyTemp);
                }
                ComputedValueUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                ComputedValueUNCEREntropy(m, jUncer, k, DiffWithRespTo);
                ComputedValueHindSightUncer(m, jUncer, k, DiffWithRespTo, PCHash);
                System.out.println(ConsoleColors.RED + "Input:Output: Data=" + MyTemp[0] + " at point:i=" + m + " j=" + jUncer + ConsoleColors.RESET);
            }
        }
    }

    public static void ComputedValue(final String localFinalEquationEntropy, final int ActualDataIndexi, final int ReferenceDataIndexj, final int PredictiveIndexk, final String DiffWithRespTo) {
        if ((ReferenceDataIndexj >= 0)
                && (ReferenceDataIndexj < ActualDataIndexi)
                && (ReferenceDataIndexj == (ActualDataIndexi - EntropySelected))) {
            final String MyDiff = DiffWithRespTo + ActualDataIndexi + "E" + ReferenceDataIndexj;
            variables.put(MyDiff, 1.0);
            //if (expValueFlag == false) {
            expValue = parse(localFinalEquationEntropy, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
            //}
            final Double RegressedValue1 = expValue.eval();
            double RegressedValue = 0.0;
            RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() + RegressedValue1;
            //RegressedValue =  DataRegressed.get(PredictiveIndexk)[0].doubleValue()+ RegressedValue1;
            Double[] Temp1 = new Double[Max_Data_Col];
            Temp1[0] = RegressedValue;
            DataRegressed.addLast(Temp1);
            if (RegressedValue == DataArray.get(ActualDataIndexi)[0].doubleValue()) {
                //System.out.println("EntropyMain:ConfirmPredicateFlag=" + ConfirmPredicateFlag );
                System.out.println(ConsoleColors.GREEN + " Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + " Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " RegressedValue1=" + RegressedValue1);
                System.out.println(" Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            } else {
                //System.out.println("EntropyMain:ConfirmPredicateFlag=" + ConfirmPredicateFlag );
                System.out.println(ConsoleColors.RED + " Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.RED + " Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " RegressedValue1=" + RegressedValue1);
                System.out.println(" Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
                System.out.println(ConsoleColors.RED + " ERROR in Prediction =" + (DataArray.get(ActualDataIndexi)[0].doubleValue() - RegressedValue));
            }
            variables.remove(DiffWithRespTo);
            variables.remove(MyDiff);
            //expValueFlag = true;
        } else if (ReferenceDataIndexj < 0) {
            System.out.println(ConsoleColors.RED + " ReferenceDataIndexj is < 0=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        } else if (ReferenceDataIndexj < ActualDataIndexi) {
            System.out.println(ConsoleColors.RED + " ReferenceDataIndexj is < ActualDataIndexi=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        }
    }

    public static void ComputedValueUncer(final int ActualDataIndexi, final int ReferenceDataIndexj, final int PredictiveIndexk, final String DiffWithRespTo, HashMap PCHash) {
        if ((ReferenceDataIndexj >= 0)
                && (ReferenceDataIndexj <= ActualDataIndexi)
                && (ReferenceDataIndexj == (ActualDataIndexi - UncertaityLimit))) {
            String MyDiff = DiffWithRespTo + "P" + ActualDataIndexi;
            variables.put(MyDiff, 1.0);
            final String MyEntropyUnCer = FinalEquationUnCer;
            //if (expValueUncerFlag == false) {
            expValueUncer = parse(MyEntropyUnCer, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
            //}
            //expValueUncerFlag = true;
            Double RegressedValue1 = expValueUncer.eval();
            double RegressedValue = 0.0;
            // Take j-1 as the Reference Value instead of j
            RegressedValue = DataArray.get(ReferenceDataIndexj - 1)[0].doubleValue() + RegressedValue1;
            Double[] Temp1 = new Double[Max_Data_Col];
            Temp1[0] = RegressedValue;

            //System.out.println(ConsoleColors.GREEN + "0ComputedValueUncer Data=" + RegressedValue1 + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
            //System.out.println(ConsoleColors.GREEN + "0ComputedValueUncer Actual Data(i)=" + DataUncertainity.getLast()[0].doubleValue() + ConsoleColors.RESET );
            //System.out.println("0ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            if ((ActualDataIndexi >= PastREADDATA) && (ActualDataIndexi < PastREADDATA + FutureREADDATA - 1)) {
                // After learning from PastDATA, Algorithm uses DataUncertainity to predict future data
                // using the Uncertainity Equation
                int lastindex = DataUncertainity.size();
                RegressedValue = DataUncertainity.get(lastindex - 1)[0].doubleValue() + RegressedValue1;
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainity.addLast(Temp1);
                if ((RegressedValue == DataUncertainity.getLast()[0].doubleValue())) {
                    System.out.println(ConsoleColors.GREEN + "5ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + " at point:(lastindex+1)=" + (lastindex + 1));
                    System.out.println(ConsoleColors.GREEN + "5ComputedValueUncer Actual Data(i)=" + DataUncertainity.getLast()[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("5ComputedValueUncer Reference Data(j)=" + DataUncertainity.get(lastindex - 1)[0].doubleValue() + " MyDiff=" + MyDiff + " Reference at point:(lastindex-1)=" + (lastindex - 1));
                } else {
                    System.out.println(ConsoleColors.RED + "3ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + " at point:(lastindex+1)=" + (lastindex + 1));
                    System.out.println(ConsoleColors.RED + "3ComputedValueUncer Actual Data(i)=" + DataUncertainity.getLast()[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("3ComputedValueUncer Reference Data(j)=" + DataUncertainity.get(lastindex - 1)[0].doubleValue() + " MyDiff=" + MyDiff + " Reference at point:(lastindex-1)=" + (lastindex - 1));
                    System.out.println(ConsoleColors.RED + "3ComputedValueUncer ERROR in Prediction =" + (DataUncertainity.get(lastindex - 1)[0].doubleValue() - RegressedValue));
                }
            } else if (ActualDataIndexi == (PastREADDATA - 1)) {
                DataUncertainity.addLast(Temp1);
                String Temp = (String) PCHash.get(ActualDataIndexi);
                String[] TempData = new String[6];
                TempData = Temp.split(",");
                String TempK = (String) PCHash.get(ReferenceDataIndexj);
                String[] TempDataK = new String[6];
                TempDataK = TempK.split(",");
                if ((TempDataK[0].equalsIgnoreCase("Neutral-Asc"))
                        || (TempDataK[0].equalsIgnoreCase("Minima"))) {
                    // Last Data is a Maxima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " LAST DATA IS A Maxima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + "P" + ReferenceDataIndexj;
                    variables.put(MyDiff, 1.0);
                    //if (expValueUncerFlag1 == false) {
                    expValueUncer1 = parse(MyEntropyUnCer, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    //expValueUncerFlag1 = true;
                    RegressedValue1 = expValueUncer1.eval();
                    RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() + RegressedValue1;
                } else if ((TempDataK[0].equalsIgnoreCase("Neutral-Dsc"))
                        || (TempDataK[0].equalsIgnoreCase("Maxima"))) {
                    // Last Data is a Minima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " LAST DATA IS A Minima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + "P" + ReferenceDataIndexj;
                    variables.put(MyDiff, 1.0);
                    //if (expValueUncerFlag2 == false) {
                    expValueUncer2 = parse(MyEntropyUnCer, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    expValueUncerFlag2 = true;
                    RegressedValue1 = expValueUncer2.eval();
                    RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() + RegressedValue1;
                }
                System.out.println(ConsoleColors.YELLOW + "2ComputedValueUncer ACTUAL TempData=" + TempData[0] + " Value=" + TempData[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.YELLOW + "2ComputedValueUncer REFERENCE TempDataK=" + TempDataK[0] + " ValueK=" + TempDataK[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "2ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "2ComputedValueUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                System.out.println("2ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
                System.out.println(ConsoleColors.GREEN + "2ComputedValueUncer ERROR in Prediction =" + (DataArray.get(ActualDataIndexi)[0].doubleValue() - RegressedValue));
            } else if (ActualDataIndexi == (PastREADDATA + FutureREADDATA - 1)) {
                String Temp = (String) PCHash.get(ActualDataIndexi);
                String[] TempData = new String[6];
                TempData = Temp.split(",");
                String TempK = (String) PCHash.get(ActualDataIndexi - 1);
                String[] TempDataK = new String[6];
                TempDataK = TempK.split(",");
                if ((TempDataK[0].equalsIgnoreCase("Neutral-Asc"))
                        || (TempDataK[0].equalsIgnoreCase("Minima"))) {
                    // Last Data is a Maxima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueUncer Reference Data(j)=" + DataArray.get(ActualDataIndexi - 1)[0].doubleValue() + " LAST DATA IS A Maxima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + (PCHash.size() - 2) + "L" + +(PCHash.size() - 3);
                    variables.put(MyDiff, 1.0);
                    final String MyEntropyEndPointUnCer = FinalEndPointEquationUnCer;
                    //if (expValueUncerFlag3 == false) {
                    expValueUncer3 = parse(MyEntropyEndPointUnCer, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    //expValueUncerFlag3=true;
                    RegressedValue1 = expValueUncer3.eval();
                    RegressedValue = Double.parseDouble(TempDataK[1]) + RegressedValue1;
                } else if ((TempDataK[0].equalsIgnoreCase("Neutral-Dsc"))
                        || (TempDataK[0].equalsIgnoreCase("Maxima"))) {
                    // Last Data is a Minima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueUncer Reference Data(j)=" + DataArray.get(ActualDataIndexi - 1)[0].doubleValue() + " LAST DATA IS A Minima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + (PCHash.size() - 2) + "L" + +(PCHash.size() - 3);
                    variables.put(MyDiff, 1.0);
                    final String MyEntropyEndPointUnCer = FinalEndPointEquationUnCer;
                    //if (expValueUncerFlag4 == false) {
                    expValueUncer4 = parse(MyEntropyEndPointUnCer, variables, MyDiff,false, "Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    expValueUncerFlag4 = true;
                    RegressedValue1 = expValueUncer4.eval();
                    RegressedValue = Double.parseDouble(TempDataK[1]) + RegressedValue1;
                }
                System.out.println(ConsoleColors.YELLOW + "6ComputedValueUncer ACTUAL TempData=" + TempData[0] + " Value=" + TempData[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.YELLOW + "6ComputedValueUncer REFERENCE TempDataK=" + TempDataK[0] + " ValueK=" + TempDataK[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                if ((RegressedValue == Double.parseDouble(TempData[1]))) {
                    System.out.println(ConsoleColors.GREEN + "7ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                    System.out.println(ConsoleColors.GREEN + "7ComputedValueUncer Actual Data(i)=" + TempData[1] + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("7ComputedValueUncer Reference Data(j)=" + TempDataK[1] + " MyDiff=" + MyDiff);

                } else {
                    System.out.println(ConsoleColors.RED + "8ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                    System.out.println(ConsoleColors.RED + "8ComputedValueUncer Actual Data(i)=" + TempData[1] + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("8ComputedValueUncer Reference Data(j)=" + TempDataK[1] + " MyDiff=" + MyDiff);
                    System.out.println(ConsoleColors.RED + "8ComputedValueUncer ERROR in Prediction =" + (Double.parseDouble(TempData[1]) - RegressedValue));
                }
            } else if (RegressedValue == DataArray.get(ActualDataIndexi)[0].doubleValue()) {
                // Learning from PastDATA, Algorithm uses DataArray.get(ReferenceDataIndexj) to predict future data
                // using the Uncertainity Equation
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainity.addLast(Temp1);
                System.out.println(ConsoleColors.GREEN + "1ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "1ComputedValueUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                System.out.println("1ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            } else if ((ActualDataIndexi < PastREADDATA) && (RegressedValue == DataArray.get(ReferenceDataIndexj)[0].doubleValue())) {
                // No Learning from PastDATA, Due to inherent data properties of PCHash, cannot use : 
                // Algorithm uses DataArray.get(ReferenceDataIndexj) to predict future data
                // using the Uncertainity Equation
                // PCHash and therefore all equations cannot be used 
                RegressedValue = DataArray.get(ReferenceDataIndexj + 1)[0].doubleValue();
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainity.addLast(Temp1);
                System.out.println(ConsoleColors.GREEN + "9ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "9ComputedValueUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                System.out.println("9ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            } else {
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainity.addLast(Temp1);
                //System.out.println("EntropyMain:ConfirmPredicateFlag=" + ConfirmPredicateFlag );
                System.out.println(ConsoleColors.RED + "4ComputedValueUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.RED + "4ComputedValueUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " RegressedValue1=" + RegressedValue1);
                System.out.println("4ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " ERROR in Prediction =" + (DataArray.get(ActualDataIndexi)[0].doubleValue() - RegressedValue));
                System.out.println("4ComputedValueUncer Reference Data(j+1)=" + DataArray.get(ReferenceDataIndexj + 1)[0].doubleValue() + " ERROR+1 in Prediction =" + (DataArray.get(ActualDataIndexi + 1)[0].doubleValue() - RegressedValue));
                System.out.println("4ComputedValueUncer Reference Data(j-1)=" + DataArray.get(ReferenceDataIndexj - 1)[0].doubleValue() + " ERROR-1 in Prediction =" + (DataArray.get(ActualDataIndexi - 1)[0].doubleValue() - RegressedValue));
                System.out.println("4ComputedValueUncer MyDiff=" + MyDiff);
            }
            variables.remove(DiffWithRespTo);
            variables.remove(MyDiff);
            variables.clear();
        } else if (ReferenceDataIndexj < 0) {
            System.out.println(ConsoleColors.RED + "ComputedValueUncer ReferenceDataIndexj is < 0=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        } else if (ReferenceDataIndexj <= ActualDataIndexi) {
            System.out.println(ConsoleColors.RED + "ComputedValueUncer ReferenceDataIndexj is < ActualDataIndexi=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        }
    }

    public static void ComputedValueUNCEREntropy(final int ActualDataIndexi, final int ReferenceDataIndexj, final int PredictiveIndexk, final String DiffWithRespTo) {
        if ((ReferenceDataIndexj >= 0)
                && (ReferenceDataIndexj < ActualDataIndexi)
                && (ReferenceDataIndexj == (ActualDataIndexi - UncertaityLimit))) {
            final String MyDiff = DiffWithRespTo + ActualDataIndexi + "UE" + ReferenceDataIndexj;
            variables.put(MyDiff, 1.0);
            final String MyEntropyUncertainity = FinalUncertainityEntropy;
            //if (expValueFlagUNCEREntropy == false) {
            expValueUNCEREntropy = parse(MyEntropyUncertainity, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
            //}
            final Double RegressedValue1 = expValueUNCEREntropy.eval();
            double RegressedValue = 0.0;
            RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() + RegressedValue1;
            //RegressedValue =  DataRegressed.get(PredictiveIndexk)[0].doubleValue()+ RegressedValue1;
            Double[] Temp1 = new Double[Max_Data_Col];
            Temp1[0] = RegressedValue;
            DataUncerEntropy.addLast(Temp1);
            if (RegressedValue == DataArray.get(ActualDataIndexi)[0].doubleValue()) {
                //System.out.println("EntropyMain:ConfirmPredicateFlag=" + ConfirmPredicateFlag );
                System.out.println(ConsoleColors.GREEN + "UNCEREntropy Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "UNCEREntropy Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " RegressedValue1=" + RegressedValue1);
                System.out.println("UNCEREntropy Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            } else {
                //System.out.println("EntropyMain:ConfirmPredicateFlag=" + ConfirmPredicateFlag );
                System.out.println(ConsoleColors.RED + "UNCEREntropy Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.RED + "UNCEREntropy Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " RegressedValue1=" + RegressedValue1);
                System.out.println("UNCEREntropy Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
                System.out.println(ConsoleColors.RED + "UNCEREntropy ERROR in Prediction =" + (DataArray.get(ActualDataIndexi)[0].doubleValue() - RegressedValue));
            }
            variables.remove(DiffWithRespTo);
            variables.remove(MyDiff);
            //expValueFlagUNCEREntropy = true;
        } else if (ReferenceDataIndexj < 0) {
            System.out.println(ConsoleColors.RED + "UNCEREntropy ReferenceDataIndexj is < 0=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        } else if (ReferenceDataIndexj < ActualDataIndexi) {
            System.out.println(ConsoleColors.RED + "UNCEREntropy ReferenceDataIndexj is < ActualDataIndexi=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        }

    }

    public static void ComputedValueHindSightUncer(final int ActualDataIndexi, final int ReferenceDataIndexj, final int PredictiveIndexk, final String DiffWithRespTo, HashMap PCHash) {
        if ((ReferenceDataIndexj >= 0)
                && (ReferenceDataIndexj <= ActualDataIndexi)
                && (ReferenceDataIndexj == (ActualDataIndexi - UncertaityLimit))) {
            String MyDiff = DiffWithRespTo + ActualDataIndexi + "UE" + ReferenceDataIndexj;
            variables.put(MyDiff, 1.0);
            final String MyEntropyUncertainity = FinalUncertainityEntropy;
            //if (expValueUncerFlagHindSight == false) {
            expValueUncerHindSight = parse(MyEntropyUncertainity, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
            //}
            expValueUncerFlagHindSight = true;
            Double RegressedValue1 = expValueUncerHindSight.eval();
            double RegressedValue = 0.0;
            // Take j-1 as the Reference Value instead of j
            RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() + RegressedValue1;
            Double[] Temp1 = new Double[Max_Data_Col];
            Temp1[0] = RegressedValue;

            //System.out.println(ConsoleColors.GREEN + "0ComputedValueUncer Data=" + RegressedValue1 + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
            //System.out.println(ConsoleColors.GREEN + "0ComputedValueUncer Actual Data(i)=" + DataUncertainity.getLast()[0].doubleValue() + ConsoleColors.RESET );
            //System.out.println("0ComputedValueUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            if ((ActualDataIndexi >= PastREADDATA) && (ActualDataIndexi < PastREADDATA + FutureREADDATA - 1)) {
                // After learning from PastDATA, Algorithm uses DataUncertainity to predict future data
                // using the Uncertainity Equation
                int lastindex = DataUncertainityHindSight.size();
                RegressedValue = DataUncertainityHindSight.get(lastindex - 1)[0].doubleValue() + RegressedValue1;
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainityHindSight.addLast(Temp1);
                if ((RegressedValue == DataUncertainityHindSight.getLast()[0].doubleValue())) {
                    System.out.println(ConsoleColors.GREEN + "5ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + " at point:(lastindex+1)=" + (lastindex + 1));
                    System.out.println(ConsoleColors.GREEN + "5ComputedValueHindSightUncer Actual Data(i)=" + DataUncertainityHindSight.getLast()[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("5ComputedValueHindSightUncer Reference Data(j)=" + DataUncertainityHindSight.get(lastindex - 1)[0].doubleValue() + " MyDiff=" + MyDiff + " Reference at point:(lastindex-1)=" + (lastindex - 1));
                } else {
                    System.out.println(ConsoleColors.RED + "3ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + " at point:(lastindex+1)=" + (lastindex + 1));
                    System.out.println(ConsoleColors.RED + "3ComputedValueHindSightUncer Actual Data(i)=" + DataUncertainityHindSight.getLast()[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("3ComputedValueHindSightUncer Reference Data(j)=" + DataUncertainityHindSight.get(lastindex - 1)[0].doubleValue() + " MyDiff=" + MyDiff + " Reference at point:(lastindex-1)=" + (lastindex - 1));
                    System.out.println(ConsoleColors.RED + "3ComputedValueHindSightUncer ERROR in Prediction =" + (DataUncertainityHindSight.get(lastindex - 1)[0].doubleValue() - RegressedValue));
                }
            } else if (ActualDataIndexi == (PastREADDATA - 1)) {
                DataUncertainityHindSight.addLast(Temp1);
                String Temp = (String) PCHash.get(ActualDataIndexi);
                String[] TempData = new String[6];
                TempData = Temp.split(",");
                String TempK = (String) PCHash.get(ReferenceDataIndexj);
                String[] TempDataK = new String[6];
                TempDataK = TempK.split(",");
                if ((TempDataK[0].equalsIgnoreCase("Neutral-Asc"))
                        || (TempDataK[0].equalsIgnoreCase("Minima"))) {
                    // Last Data is a Maxima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " LAST DATA IS A Maxima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + ActualDataIndexi + "UE" + ReferenceDataIndexj;
                    variables.put(MyDiff, 1.0);
                    //if (expValueUncerFlagHindSight1 == false) {
                    expValueUncerHindSight1 = parse(MyEntropyUncertainity, variables, MyDiff,false, "Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    //expValueUncerFlagHindSight1 = true;
                    RegressedValue1 = expValueUncerHindSight1.eval();
                    RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() + RegressedValue1;
                } else if ((TempDataK[0].equalsIgnoreCase("Neutral-Dsc"))
                        || (TempDataK[0].equalsIgnoreCase("Maxima"))) {
                    // Last Data is a Minima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " LAST DATA IS A Minima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + ActualDataIndexi + "UE" + ReferenceDataIndexj;
                    variables.put(MyDiff, 1.0);
                    //if (expValueUncerFlagHindSight2 == false) {
                    expValueUncerHindSight2 = parse(MyEntropyUncertainity, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    //expValueUncerFlagHindSight2 = true;
                    RegressedValue1 = expValueUncerHindSight2.eval();
                    RegressedValue = DataArray.get(ReferenceDataIndexj)[0].doubleValue() - RegressedValue1;
                }
                System.out.println(ConsoleColors.YELLOW + "2ComputedValueHindSightUncer ACTUAL TempData=" + TempData[0] + " Value=" + TempData[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.YELLOW + "2ComputedValueHindSightUncer REFERENCE TempDataK=" + TempDataK[0] + " ValueK=" + TempDataK[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "2ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "2ComputedValueHindSightUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                System.out.println("2ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
                System.out.println(ConsoleColors.GREEN + "2ComputedValueHindSightUncer ERROR in Prediction =" + (DataArray.get(ActualDataIndexi)[0].doubleValue() - RegressedValue));
            } else if (ActualDataIndexi == (PastREADDATA + FutureREADDATA - 1)) {
                String Temp = (String) PCHash.get(ActualDataIndexi);
                String[] TempData = new String[6];
                TempData = Temp.split(",");
                String TempK = (String) PCHash.get(ActualDataIndexi - 1);
                String[] TempDataK = new String[6];
                TempDataK = TempK.split(",");
                if ((TempDataK[0].equalsIgnoreCase("Neutral-Asc"))
                        || (TempDataK[0].equalsIgnoreCase("Minima"))) {
                    // Last Data is a Maxima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ActualDataIndexi - 1)[0].doubleValue() + " LAST DATA IS A Maxima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + (PCHash.size() - 2) + "L" + +(PCHash.size() - 3);
                    variables.put(MyDiff, 1.0);
                    final String MyEntropyEndPointUncertainity = FinalEndPointEquationUnCer;
                    //if (expValueUncerFlagHindSight3 == false) {
                    expValueUncerHindSight3 = parse(MyEntropyEndPointUncertainity, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    //expValueUncerFlag3=true;
                    RegressedValue1 = expValueUncerHindSight3.eval();
                    RegressedValue = Double.parseDouble(TempDataK[1]) + RegressedValue1;
                } else if ((TempDataK[0].equalsIgnoreCase("Neutral-Dsc"))
                        || (TempDataK[0].equalsIgnoreCase("Maxima"))) {
                    // Last Data is a Minima
                    System.out.println(ConsoleColors.BLUE + "ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ActualDataIndexi - 1)[0].doubleValue() + " LAST DATA IS A Minima" + ConsoleColors.RESET);
                    variables.remove(MyDiff);
                    MyDiff = DiffWithRespTo + (PCHash.size() - 2) + "L" + +(PCHash.size() - 3);
                    variables.put(MyDiff, 1.0);
                    final String MyEntropyEndPointUncertainity = FinalEndPointEquationUnCer;
                    //if (expValueUncerFlagHindSight4 == false) {
                    expValueUncerHindSight4 = parse(MyEntropyEndPointUncertainity, variables, MyDiff, false,"Silent", MathsExpressionParser.LogLevel.Off);
                    //}
                    //expValueUncerFlagHindSight4 = true; 
                    RegressedValue1 = expValueUncerHindSight4.eval();
                    RegressedValue = Double.parseDouble(TempDataK[1]) + RegressedValue1;
                }
                System.out.println(ConsoleColors.YELLOW + "6ComputedValueHindSightUncer ACTUAL TempData=" + TempData[0] + " Value=" + TempData[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.YELLOW + "6ComputedValueHindSightUncer REFERENCE TempDataK=" + TempDataK[0] + " ValueK=" + TempDataK[1] + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                if ((RegressedValue == Double.parseDouble(TempData[1]))) {
                    System.out.println(ConsoleColors.GREEN + "7ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                    System.out.println(ConsoleColors.GREEN + "7ComputedValueHindSightUncer Actual Data(i)=" + TempData[1] + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("7ComputedValueHindSightUncer Reference Data(j)=" + TempDataK[1] + " MyDiff=" + MyDiff);

                } else {
                    System.out.println(ConsoleColors.RED + "8ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                    System.out.println(ConsoleColors.RED + "8ComputedValueHindSightUncer Actual Data(i)=" + TempData[1] + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                    System.out.println("8ComputedValueHindSightUncer Reference Data(j)=" + TempDataK[1] + " MyDiff=" + MyDiff);
                    System.out.println(ConsoleColors.RED + "8ComputedValueHindSightUncer ERROR in Prediction =" + (Double.parseDouble(TempData[1]) - RegressedValue));
                }
            } else if (RegressedValue == DataArray.get(ActualDataIndexi)[0].doubleValue()) {
                // Learning from PastDATA, Algorithm uses DataArray.get(ReferenceDataIndexj) to predict future data
                // using the Uncertainity Equation
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainityHindSight.addLast(Temp1);
                System.out.println(ConsoleColors.GREEN + "1ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.GREEN + "1ComputedValueHindSightUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " Uncertainity=" + RegressedValue1);
                System.out.println("1ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " MyDiff=" + MyDiff);
            } else {
                Temp1 = new Double[Max_Data_Col];
                Temp1[0] = RegressedValue;
                DataUncertainityHindSight.addLast(Temp1);
                //System.out.println("EntropyMain:ConfirmPredicateFlag=" + ConfirmPredicateFlag );
                System.out.println(ConsoleColors.RED + "4ComputedValueHindSightUncer Data=" + RegressedValue + ConsoleColors.RESET + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj);
                System.out.println(ConsoleColors.RED + "4ComputedValueHindSightUncer Actual Data(i)=" + DataArray.get(ActualDataIndexi)[0].doubleValue() + ConsoleColors.RESET + " RegressedValue1=" + RegressedValue1);
                System.out.println("4ComputedValueHindSightUncer Reference Data(j)=" + DataArray.get(ReferenceDataIndexj)[0].doubleValue() + " ERROR in Prediction =" + (DataArray.get(ActualDataIndexi)[0].doubleValue() - RegressedValue));
                System.out.println("4ComputedValueHindSightUncer Reference Data(j+1)=" + DataArray.get(ReferenceDataIndexj + 1)[0].doubleValue() + " ERROR+1 in Prediction =" + (DataArray.get(ActualDataIndexi + 1)[0].doubleValue() - RegressedValue));
                System.out.println("4ComputedValueHindSightUncer Reference Data(j-1)=" + DataArray.get(ReferenceDataIndexj - 1)[0].doubleValue() + " ERROR-1 in Prediction =" + (DataArray.get(ActualDataIndexi - 1)[0].doubleValue() - RegressedValue));
                System.out.println("4ComputedValueHindSightUncer MyDiff=" + MyDiff);
            }
            variables.remove(DiffWithRespTo);
            variables.remove(MyDiff);
            variables.clear();
        } else if (ReferenceDataIndexj < 0) {
            System.out.println(ConsoleColors.RED + "ComputedValueHindSightUncer ReferenceDataIndexj is < 0=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        } else if (ReferenceDataIndexj <= ActualDataIndexi) {
            System.out.println(ConsoleColors.RED + "ComputedValueHindSightUncer ReferenceDataIndexj is < ActualDataIndexi=" + ReferenceDataIndexj + " at point:i=" + ActualDataIndexi + " j=" + ReferenceDataIndexj + ConsoleColors.RESET);
        }
    }

    public static void main(String... args) {
        //FileName = "500180-HDFC.csv";
        FileName = "500875-ITC-Final.csv";
        //FileName = "500510-L&T-Final.csv";
        //FileName = "500325-RIL-Final.csv";
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Start:Run Started Time:" + current + " Processing:FileName=" + FileName);
        }
        DataArray = new LinkedList<Double[]>();
        int i = 0;
        for (i = 0; i < MAX_DATA; i++) {
            Double[] Temp = new Double[Max_Data_Col];
            for (int x = 0; x < Max_Data_Col; x++) {
                Temp[x] = 0.0;
            }
            DataArray.add(Temp);
        }
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Initialization Complete:Run Time:" + current + " ");
        }
        MyReadData("data\\", FileName, DataArray);
        //MyReadData Modifies MAX_DATA to Actual Data Read 
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Read FileData:Run Time:" + current + " MAX_DATA=" + MAX_DATA);
        }
        ROWSREG = MAX_DATA;
        if (((MAX_DATA % 2) == 1) && (MAX_DATA > 5)) {
            //PastREADDATA = (MAX_DATA - 1) / 2;
            PastREADDATA = (MAX_DATA - 1) * 10 / 100;
        } else if (((MAX_DATA % 2) == 0) && (MAX_DATA > 5)) {
            //PastREADDATA = MAX_DATA / 2;
            PastREADDATA = MAX_DATA * 10 / 100;
        }
        if ((PastREADDATA > 0) && ((MAX_DATA % 2) == 1) && (MAX_DATA > 5)) {
            FutureREADDATA = MAX_DATA - PastREADDATA;
        } else if ((PastREADDATA > 0) && ((MAX_DATA % 2) == 0) && (MAX_DATA > 5)) {
            FutureREADDATA = MAX_DATA - PastREADDATA;
        }
        MaximaMinima MyData = ProcessData(0, (int) ROWSREG, DataArray, 0);
        // Data is put in Hash Map
        HashMap PCHash = MyData.Extrema();
        String Temp = null;
        String[] TempData = null;
        for (int j = 0; (j < PCHash.size()); j++) {
            Temp = (String) PCHash.get(j);
            TempData = Temp.split(",");
            System.out.println("Read Data(" + j + ") =" + TempData[0] + " 1=" + TempData[1] + " Array:=" + DataArray.get(j)[0] + " 2=" + TempData[2] + " 3=" + TempData[3]);
        }

        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Formed PCHash:Run Time:" + current + " PCHash.size=" + PCHash.size());
        }
        RegressionOLSMain(PCHash);
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Entropy Equation Completed:Run Time:" + current + " ");
        }
        UncertainityOLSMain(PCHash);
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Uncertainity Equation Completed:Run Time:" + current + " ");
        }
        EntropyMain(PCHash);
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("Processing Completed:Run Time:" + current + " ");
        }
        UncertainityMain(PCHash);
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("UncertainityMain Completed:Run Time:" + current + " ");
        }
        DataRegressed = new LinkedList<Double[]>();
        DataUncertainity = new LinkedList<Double[]>();
        DataUncerEntropy = new LinkedList<Double[]>();
        DataUncertainityHindSight = new LinkedList<Double[]>();
        DisplayData(PCHash);
        {
            LocalDateTime current = LocalDateTime.now();
            System.out.println("DisplayData Completed:Run Time:" + current + " ");
        }
        
    }
    /* ************************** Main Calling Functions and Routines End *******/
    public static StringBuilder SecurityEncryptEntropy(String EncryptMesg){
        FormDataArray(EncryptMesg);
        ROWSREG = MAX_DATA;
        if (((MAX_DATA % 2) == 1) && (MAX_DATA > 5)) {
            //PastREADDATA = (MAX_DATA - 1) / 2;
            PastREADDATA = (MAX_DATA - 1) * 10 / 100;
        } else if (((MAX_DATA % 2) == 0) && (MAX_DATA > 5)) {
            //PastREADDATA = MAX_DATA / 2;
            PastREADDATA = MAX_DATA * 10 / 100;
        }
        if ((PastREADDATA > 0) && ((MAX_DATA % 2) == 1) && (MAX_DATA > 5)) {
            FutureREADDATA = MAX_DATA - PastREADDATA;
        } else if ((PastREADDATA > 0) && ((MAX_DATA % 2) == 0) && (MAX_DATA > 5)) {
            FutureREADDATA = MAX_DATA - PastREADDATA;
        }
        MaximaMinimaSecure MyData = ProcessDataSecure(0, (int) ROWSREG, DataArraySecurity, 0);
        HashMap PCHash = MyData.Extrema();
        System.out.println("ProcessDataSecure:Completed");
        
        RegressionOLSMainSecure(PCHash);
        System.out.println("SecurityEncryptEntropy:Completed");
        //UncertainityOLSMain(PCHash);
        //EntropyMain(PCHash);
        return new StringBuilder(FinalEquation);
    }
    public static void FormDataArray(String EncryptMesg){
        String[] TempData;
        if ((EncryptMesg == null) || (EncryptMesg.equalsIgnoreCase(""))) {
            return ;
        }
        DataArraySecurity = new LinkedList<Double>();
        TempData=EncryptMesg.split(",@");
        int exp = 0;
        for (exp = 0; (exp < TempData.length); exp++) {
            if (TempData[exp].matches("[0-9Ee.]*"))
                    DataArraySecurity.add(Double.parseDouble(TempData[exp]));
            else if(TempData[exp].matches("[0-9Ee.]*[,@]*[0-9Ee.]*")){
                String[] MyReworkData=TempData[exp].split(",");
                if ((MyReworkData.length <= 2)&&(TempData[exp].contains("@")) ){
                    MyReworkData=TempData[exp].split("@");
                    System.out.println(ConsoleColors.RED + "FormDataArray:REWORK:@:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }else {
                    System.out.println(ConsoleColors.RED + "FormDataArray:REWORK:,:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }
                for(int i=0; i < MyReworkData.length;i++){
                    DataArraySecurity.add(Double.parseDouble(MyReworkData[i]));
                }
                System.out.println(ConsoleColors.RED + "FormDataArray:REWORK:Complete:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
            }else {
                    System.out.println(ConsoleColors.RED + "FormDataArray:Else:TempData[" + exp + "]=" + TempData[exp] + ConsoleColors.RESET);
                }
        }
        MAX_DATA = exp;
        System.out.println("FormDataArray:Completed");
    }
    public static void SecurityDecryptEntropy(String DecryptMesg){
        FormDataArray(DecryptMesg);
        ROWSREG = DataArraySecurity.size();
        if (((MAX_DATA % 2) == 1) && (MAX_DATA > 5)) {
            //PastREADDATA = (MAX_DATA - 1) / 2;
            PastREADDATA = (MAX_DATA - 1) * 10 / 100;
        } else if (((MAX_DATA % 2) == 0) && (MAX_DATA > 5)) {
            //PastREADDATA = MAX_DATA / 2;
            PastREADDATA = MAX_DATA * 10 / 100;
        }
        if ((PastREADDATA > 0) && ((MAX_DATA % 2) == 1) && (MAX_DATA > 5)) {
            FutureREADDATA = MAX_DATA - PastREADDATA;
        } else if ((PastREADDATA > 0) && ((MAX_DATA % 2) == 0) && (MAX_DATA > 5)) {
            FutureREADDATA = MAX_DATA - PastREADDATA;
        }
        MaximaMinimaSecure MyData = ProcessDataSecure(0, (int) ROWSREG, DataArraySecurity, 0);
        HashMap PCHash = MyData.Extrema();
        
//        String Temp = null;
//        String[] TempData = null;
//        for (int j = 0; (j < PCHash.size())&&(j < DataArraySecurity.size()); j++) {
//            Temp = (String) PCHash.get(j);
//            TempData = Temp.split(",");
//            System.out.println("SecurityDecryptEntropy:Read Data(" + j + ") =" + TempData[0] + " Array:=" + DataArraySecurity.get(j) );
//        }
        return ;
    }
    public static void RegressionOLSMainSecure(HashMap PCHash) {
        // Regression Expression Variables
        // Integral Expression Variables
        Map<String, Double> variables = new HashMap<>();
        Expression expValue = (() -> 0.0);
        MyFuncExpress();
        String DiffWithRespTo = "x";
        // Generate the PCHASH MAP
        log.fatal("Regression:RegressionOLSMain:DataArray.size=" + DataArraySecurity.size());
        log.fatal("Regression:RegressionOLSMain:PCHash.size=" + PCHash.size());
        StringBuilder FinalEquationRegress = new StringBuilder("");
        StringBuilder FinalPredicateRegress = new StringBuilder("");
        int Max_Index = (int) ROWSREG;
        int i = 0;
        int k = 0;
        // Generate the Entropy Equation
        // Generate the Entropy Predicate Equation
        DataArrayOutput = new LinkedList<Double[]>();
        for (i = 0; (i < PCHash.size()); i++) {
            variables.clear();
            k = FormGroupOLSSecure(i, DiffWithRespTo, PCHash.size(), PCHash, variables, FinalEquationRegress, FinalPredicateRegress, 0, 0);
            if ((MyGroup[MyGroupIndex - 1][2] != null)
                    && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
                ConfirmTest BadData = ConfirmEqn(MyGroup[MyGroupIndex - 1][2], i, k, PCHash, variables, DiffWithRespTo, "Global");
                boolean ConfirmFlag = BadData.eval();
                BadData = ConfirmEqn(MyGroup[MyGroupIndex - 1][2], i, k, PCHash, variables, DiffWithRespTo, "Global");
                ConfirmFlag = BadData.eval();
                log.fatal("RegressionOLSMain:i=" + i + " k=" + k + " ConfirmFlag=" + ConfirmFlag);
            }
            variables.remove((DiffWithRespTo + i));
            variables.put((DiffWithRespTo + k), 1.0);
            variables.put((DiffWithRespTo), 1.0);
            PredicateBool MyCondition = PredicateSep.parsePredicate(MyGroup[MyGroupIndex - 1][3], variables, "Silent", MathsContxtLAv.LogLevel.Off);
            boolean ConfirmPredicateFlag = MyCondition.eval();
            log.fatal("RegressionOLSMain:i=" + i + " k=" + k + " ConfirmPredicateFlag=" + ConfirmPredicateFlag + " MyGroup[" + (MyGroupIndex - 1) + "][3]=" + MyGroup[MyGroupIndex - 1][3] + " variables.get((DiffWithRespTo)=" + variables.get(DiffWithRespTo) + " variables.get(" + (DiffWithRespTo + k) + ")=" + variables.get(DiffWithRespTo + k));

            if ((MyGroup[MyGroupIndex - 1][2] != null) && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
                if (FinalEquationRegress.toString().endsWith("+")) {
                    FinalEquationRegress.append(MyGroup[MyGroupIndex - 1][2]);
                } else {
                    FinalEquationRegress.append("+").append(MyGroup[MyGroupIndex - 1][2]);
                }
            } else if ((MyGroup[MyGroupIndex - 1][2] != null) && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
                FinalEquationRegress.append(MyGroup[MyGroupIndex - 1][2]);
            }

            if ((MyGroup[MyGroupIndex - 1][3] != null) && (!MyGroup[MyGroupIndex - 1][3].equalsIgnoreCase("")) && (!FinalPredicateRegress.toString().equalsIgnoreCase(""))) {
                FinalPredicateRegress.append("||").append(MyGroup[MyGroupIndex - 1][3]);
            } else {
                FinalPredicateRegress.append(MyGroup[MyGroupIndex - 1][3]);
            }
            variables.remove((DiffWithRespTo + k));
            variables.remove((DiffWithRespTo));
            i = k - 1;
        }
        System.out.println("RegressionOLSMain:FinalEquationRegress=" + FinalEquationRegress);
        System.out.println("RegressionOLSMain:FinalPredicateRegress=" + FinalPredicateRegress);
//        for (i = 0; (i < PCHash.size()); i++) {
//            Double[] Temp1 = new Double[Max_Data_Col];
//            variables.clear();
//            variables.put((DiffWithRespTo + (i)), 1.0);
//            expValue = parse(FinalEquationRegress.toString(), variables, (DiffWithRespTo + (i)), "Silent", MathsContxtLAv.LogLevel.Off);
//            Temp1[0] = expValue.eval();
//            DataArrayOutput.addLast(Temp1);
//            if ((i < DataArrayOutput.size()) && (DataArrayOutput.get(i) != null) && (Temp1[0] != null)) {
//                log.fatal("RegressionOLSMain:i=" + i + " x=" + variables.get((DiffWithRespTo + (i))) + " (" + DiffWithRespTo + (i) + ")=" + (DiffWithRespTo + (i)));
//                log.fatal("RegressionOLSMain:i=" + i + " DataArrayOutput.get(i)[0]=" + DataArrayOutput.get(i)[0] + " Temp1[0]=" + Temp1[0].doubleValue() + " DataArrayOutput=" + DataArrayOutput.size());
//                log.fatal("RegressionOLSMain:i=" + i + " Equation=" + FinalEquationRegress);
//                log.fatal("RegressionOLSMain:i=" + i + " expValue.eval()=" + expValue.eval());
//                log.fatal("RegressionOLSMain:i=" + i + " Predicate=" + FinalPredicateRegress);
//                if (DataArraySecurity.get(i).doubleValue() == DataArrayOutput.get(i)[0].doubleValue()) {
//                    ;//System.out.println(ConsoleColors.GREEN + "RegressionOLSMain:Data Match:MisMatchCountRegress=" + MisMatchCountRegress + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataArrayOutput.get(" + i + ")[0]=" + DataArrayOutput.get(i)[0] + ConsoleColors.RESET);
//                } else if (DataArraySecurity.get(i).doubleValue() != DataArrayOutput.get(i)[0].doubleValue()) {
//                    MisMatchCountRegress++;
//                    //System.out.println(ConsoleColors.RED + "RegressionOLSMain:Data Mismatch:MisMatchCountRegress=" + MisMatchCountRegress + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataArrayOutput.get(" + i + ")[0]=" + DataArrayOutput.get(i)[0] + ConsoleColors.RESET);
//                }
//            }
//            variables.remove(DiffWithRespTo + (i));
//        }
//        for (i = 0; (i < DataArray.size()) && (i < DataArrayOutput.size()) && (DataArrayOutput.get(i) != null) && (DataArrayOutput.get(i)[0] != null); i++) {
//            System.out.println("RegressionOLSMain:DataArray.get[" + i + "][0].doubleValue()=" + DataArray.get(i)[0].doubleValue()
//                    + " DataArrayOutput[" + i + "]get(i)[0].doubleValue()=" + DataArrayOutput.get(i)[0].doubleValue());
//        }
        FinalEquation = FinalEquationRegress.toString();
        FinalPredicate = FinalPredicateRegress.toString();
    }
    @FunctionalInterface
    public interface MaximaMinimaSecure {

        HashMap Extrema();
    }

    public static MaximaMinimaSecure ProcessDataSecure(int StartIndex, int Max_Index, LinkedList<Double> Data, int Mapped) {
        HashMap PCHash = new HashMap();// Hash Map to store Maxima/Minima Details as CSV

        int SigIndex = 0;//Index of WaveData : Input Waveform Index element that is being Processed.
        //Store the Initial Value
        //StoreLocal("Neutral-Zero", Data.get(0)[SigIndex], 0, PCHash, 0/*HashMapIndex*/);
        //HashMapIndex++;

        return new Object() {

            HashMap ProcessIndex() //ProcessIndex Function with Trend Flags (AscFlagP3,DscFlagP3)
            // Only the flags AscFlag & DscFlag are used for trifurcation logic. 
            // 1) GOTO Above: Wave Ascending
            // 2) GOTO Same Line : Wave is a constant
            // 3) GOTO below: Waveform Descending
            // Design for Local Minima & Local Maxima where Trend is unidirectional (either all Asc or All Desc).
            // Points between a) Maxima followed by Minima OR 
            //                b) Minima followed by Maxima
            {
                // Order of parameter (details) in StoreLocalMaxMin Function
                Integer HashMapIndex = 0;// Running Index of Elements of HashMap

                Double PCountMinusT = 0.0;//ProgramCounter at t-1:Previous Element
                Double ProgramCounter = 0.0;//ProgramCounter at t:Current Element
                Double NextXt = 0.0;//ProgramCounter at t+1:Next Element
                Double PCountPlus2 = 0.0;//ProgramCounter at t+2:Previous Element
                Double PCountP3 = 0.0;//ProgramCounter at t+3:Previous Element

                int PCRowIndex = StartIndex;//Current Element:Current Row
                int PCLastRowIndex = Max_Index;//Maximum Elements in WaveData i.e Last Index

                // Below flags control the ProgramCounter -> PCountMinusT Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlagMinusT = false;
                boolean DscFlagMinusT = false;

                // Below flags control the NextXt -> ProgramCounter Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlag = false;
                boolean DscFlag = false;

                // Below flags control the NextXt -> PCountPlus2 Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlagPlus2 = false;
                boolean DscFlagPlus2 = false;

                // Below flags control the PCountPlus2 -> PCountP3 Mechanism
                // 2 Flags so that in future we can expand the logic 
                // by using the other flag if necessary
                boolean AscFlagP3 = false;
                boolean DscFlagP3 = false;

                //b)	if 000 (row) Load Program Counter with 000(row).
                PCountMinusT = Data.get(PCRowIndex);
                ProgramCounter = Data.get(PCRowIndex);
                NextXt = Data.get(PCRowIndex);

                PCountPlus2 = 0.0;

                log.info("Regression:ProcessIndex:Entered SigIndex(Column in DataArray)=" + SigIndex + " StartIndex=" + StartIndex + " PCRowIndex=" + PCRowIndex + " Max_Index=" + PCLastRowIndex);

                // Since Lower down in the code we are using PCRowIndex+2: 
                // Hence PCRowIndex <= (PCLastRowIndex). PCLastRowIndex:1 Unknown 
                // May have to revist for Next Day Data( 1 New Point(s) added) 
                // when added
                while (PCRowIndex <= (PCLastRowIndex)) {
                    //
                    //  ProgramCounter -> PCountMinusT Mechanism
                    //
                    //
                    if ((ProgramCounter > PCountMinusT)) {
                        //Wave on the Ascending
                        // GOTO Higher Value(ProgramCounter):Maxima:
                        // Waveform is Ascending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number below current line
                        // (line which is being compiled)
                        // OR GOTO Code defined below (between line number & current line)
                        // (line number is after current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is below (ProgramCounter) is ignored).
                        AscFlagMinusT = true;
                        DscFlagMinusT = false;
                    } else if ((ProgramCounter < PCountMinusT)) {
                        //Wave on the Descending
                        // GOTO Lower Value(ProgramCounter):Minima:
                        // Waveform is Descending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number above current line
                        // (line which is being compiled)
                        // OR GOTO Code defined above (line number is before current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is between (ProgramCounter) is already compiled 
                        // and can be ignored [from compiler point of view]).
                        // From code perspective this is a potential infinite loop.
                        // [going back to old lines without a condition{unconditional GOTO}]
                        AscFlagMinusT = false;
                        DscFlagMinusT = true;

                    } else if ((ProgramCounter == PCountMinusT)) {
                        //Wave on the Descending
                        // GOTO Lower Value(ProgramCounter):Minima:
                        // Waveform is Descending:
                        // Hence Ascending is made true
                        // In terms of Java Source Code:
                        // GOTO line number above current line
                        // (line which is being compiled)
                        // OR GOTO Code defined above (line number is before current line)
                        // Also Code between Currentline(PCountMinusT) & Line number 
                        // (line which is between (ProgramCounter) is already compiled 
                        // and can be ignored [from compiler point of view]).
                        // From code perspective this is a potential infinite loop.
                        // [going back to old lines without a condition{unconditional GOTO}]
                        AscFlagMinusT = false;
                        DscFlagMinusT = false;

                    }
                    //
                    //  PCountPlus2 -> NextXt Mechanism
                    //
                    //
                    if ((PCountPlus2 > NextXt) && (AscFlagMinusT == true)) {
                        //Wave on the Ascending
                        AscFlagPlus2 = true;
                        DscFlagPlus2 = false;
                    } else if ((PCountPlus2 < NextXt) && (DscFlagMinusT == true)) {
                        //Wave on the Descending
                        AscFlagPlus2 = false;
                        DscFlagPlus2 = true;
                    } else if ((PCountPlus2 == NextXt) && (DscFlagMinusT == false) && (AscFlagMinusT == false)) {
                        //Wave on the Descending
                        AscFlagPlus2 = false;
                        DscFlagPlus2 = true;
                    }
                    //
                    //  PCountP3 -> PCountPlus2 Mechanism
                    //
                    //
                    if ((PCountP3 > PCountPlus2)) {
                        //Wave on the Ascending
                        AscFlagP3 = true;
                        DscFlagP3 = false;
                    } else if ((PCountP3 < PCountPlus2) && (DscFlagMinusT == true)) {
                        //Wave on the Descending
                        AscFlagP3 = false;
                        DscFlagP3 = true;
                    } else if ((PCountP3 == PCountPlus2) && (DscFlagMinusT == false) && (AscFlagMinusT == false)) {
                        //Wave on the Descending
                        AscFlagP3 = false;
                        DscFlagP3 = false;
                    }
                    //Actual Work gets done here
                    //NextXt -> ProgramCounter Mechanism
                    //
                    //
                    if ((NextXt > ProgramCounter) && (AscFlagMinusT == false) && (AscFlagMinusT != DscFlagMinusT)) {
                        //Wave on the Ascending
                        if ((DscFlagMinusT == true) && (AscFlagMinusT == false) && (DscFlag == true) && (AscFlag == false)) {
                            StoreLocalMaxMin("Minima", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                            if ((DscFlagPlus2 == true) && (AscFlagPlus2 == false)) {
                                log.info("Regression:ProcessIndex:Asc:Early Warning:Descent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                            if ((DscFlagP3 == true) && (AscFlagP3 == false)) {
                                log.info("Regression:ProcessIndex:Asc:Alert:Descent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                        } else {
                            StoreLocal("Neutral-Asc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                        AscFlag = true;
                        DscFlag = false;
                        if ((DscFlagPlus2 == false) && (AscFlagPlus2 == true)) {
                            log.info("Regression:ProcessIndex:Asc:Ascent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        if ((DscFlagP3 == false) && (AscFlagP3 == true)) {
                            log.info("Regression:ProcessIndex:Asc:Alert:Ascent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        log.info("Regression:ProcessIndex:Ascending:NextXt:" + NextXt + " at PCRowIndex=" + PCRowIndex + " and ProgramCounter=" + ProgramCounter + " PCountMinusT=" + PCountMinusT + " PCountPlus2=" + PCountPlus2);
                    } else if ((NextXt < ProgramCounter) && (DscFlagMinusT == false) && (AscFlagMinusT != DscFlagMinusT)) {
                        //Wave on the Descending
                        if ((DscFlagMinusT == false) && (AscFlagMinusT == true) && (DscFlag == false) && (AscFlag == true)) {
                            StoreLocalMaxMin("Maxima", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                            if ((DscFlagPlus2 == false) && (AscFlagPlus2 == true)) {
                                log.info("Regression:ProcessIndex:Dsc:Early Warning:Ascent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                            if ((DscFlagP3 == false) && (AscFlagP3 == true)) {
                                log.info("Regression:ProcessIndex:Dsc:Alert:Ascent Started : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                            }
                        } else {
                            StoreLocal("Neutral-Dsc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                        AscFlag = false;
                        DscFlag = true;
                        if ((DscFlagPlus2 == true) && (AscFlagPlus2 == false)) {
                            log.info("Regression:ProcessIndex:Dsc:Descent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        if ((DscFlagP3 == true) && (AscFlagP3 == false)) {
                            log.info("Regression:ProcessIndex:Dsc:Alert:Descent Continued : PCountMinusT=" + PCountMinusT + " and ProgramCounter=" + ProgramCounter + " :NextXt:" + NextXt + " PCountPlus2=" + PCountPlus2 + " PCountP3=" + PCountP3);
                        }
                        log.info("Regression:ProcessIndex:Descending:NextXt:" + NextXt + " at PCRowIndex=" + PCRowIndex + " and ProgramCounter=" + ProgramCounter + " PCountMinusT=" + PCountMinusT + " PCountPlus2=" + PCountPlus2);
                    } else {
                        if ((NextXt >= ProgramCounter) && (DscFlagMinusT == false) && (AscFlagMinusT == true)) {
                            StoreLocal("Neutral-Constant-Asc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        } else if ((NextXt <= ProgramCounter) && (DscFlagMinusT == true) && (AscFlagMinusT == false)) {
                            StoreLocal("Neutral-Constant-Dsc", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        } else if ((DscFlagMinusT == false) && (AscFlagMinusT == false)) {
                            StoreLocal("Neutral-Constant-Zero", ProgramCounter, (PCRowIndex - 1), PCHash, HashMapIndex);
                            HashMapIndex++;
                        }
                    }
                    // Load Next Value
                    PCountMinusT = ProgramCounter;
                    ProgramCounter = NextXt;
                    PCRowIndex++;
                    if ((PCRowIndex <= (PCLastRowIndex)) && (PCRowIndex < Data.size())) {
                        log.info("Regression:ProcessIndex:PCLastRowIndex=" + PCLastRowIndex + " PCRowIndex=" + PCRowIndex + " Data.size()=" + Data.size());
                        if (Mapped == 0) {
                            NextXt = Data.get(PCRowIndex);
                        } 
                        if ((PCRowIndex < PCLastRowIndex) && (PCRowIndex + 1 < Data.size())) {
                            if (Mapped == 0) {
                                PCountPlus2 = Data.get(PCRowIndex + 1);
                            } 
                        }
                        if ((PCRowIndex < (PCLastRowIndex - 1)) && (PCRowIndex + 2 < Data.size())) {
                            if (Mapped == 0) {
                                PCountP3 = Data.get(PCRowIndex + 2);
                            } 
                        }
                        //Do Nothing OR Add ToDo Code Here
                    } else {
                        //Store the Final 2 Values Value
                        //StoreLocal("Neutral-Final", Data.get((PCLastRowIndex - 1))[SigIndex], (PCLastRowIndex - 1), PCHash,HashMapIndex);
                        //HashMapIndex++;
                        //StoreLocal("Neutral-Final", Data.get((PCLastRowIndex))[SigIndex], (PCLastRowIndex), PCHash,HashMapIndex);
                        //HashMapIndex++;
                    }
                }
                log.fatal("Regression:ProcessIndex:Exited PCRowIndex=" + PCRowIndex);
                return PCHash;
            }
            //	Stack is always aware if Waveform is Above OR Below Program Counter
            //	Stack is always aware if Waveform is above or below Overall Mean.
            //	Stack is always aware if Waveform is above or below local Mean.

            MaximaMinimaSecure ExtractExtremaSecure() {
                MaximaMinimaSecure x;
                if (Mapped == 0) {
                    x = (() -> ProcessIndex());
                    return x;
                }
                return null;
            }
        }.ExtractExtremaSecure();
    }
    public static int FormGroupOLSSecure(int Start, String Symbol, int Max_Data, HashMap PCHash, Map<String, Double> variables, StringBuilder FinalEqn, StringBuilder FinalPred, int Innerk, int InnerStart) {
        int j = 0;
        String Temp = "";
        String TempK = "";
        String[] TempDataK = new String[6];
        RegressOLSExprSecure MyEqn;

        Temp = (String) PCHash.get(Start);
        String[] TempData = new String[6];
        TempData = Temp.split(",");
        int k = Start + 1;
        for (; (k < (PCHash.size() - 1));) {
            TempK = (String) PCHash.get(k);
            TempDataK = TempK.split(",");
            if ((TempDataK[0].equalsIgnoreCase("Minima")) || (TempDataK[0].equalsIgnoreCase("Neutral-Zero"))) {
                break;
            } else if ((TempDataK[0].equalsIgnoreCase("Maxima"))) {
                break;
            } else {
                k++;
            }
        }
        if ((InnerStart == 0)) {
            MyEqn = RegExtractEqnExprSecure(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArraySecurity, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        } else if ((InnerStart > 0) && (k <= 2)) {
            MyEqn = RegExtractEqnExprSecure(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArraySecurity, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        } else {
            MyEqn = RegExtractEqnExprSecure(TempData[0], TempDataK[0], InnerStart, Innerk, PCHash, Symbol, DataArraySecurity, PCHash.size(), ApplyAtLowLevel, FinalEqn, FinalPred, Innerk);
            log.fatal("FormGroupOLS:Else:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyEqn.Equation() + " FinalEqn=" + FinalEqn);
        }
        String Equation = MyEqn.Equation();
        log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + Equation);
        log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " FinalEqn=" + FinalEqn + " FinalEqn=" + FinalEqn);
        log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " FinalPred=" + FinalPred);
        log.fatal("FormGroupOLS:k=" + k + " Start=" + Start + " Max_Data=" + Max_Data + " InnerStart=" + InnerStart);
        if ((Start < Max_Data) && (k <= Max_Data)) {
            MyGroup[MyGroupIndex][0] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][1] = Symbol + "==" + Symbol + Start;
            //2nd Segment :F(x) =Equation for Start <=x <= Stop
            //F(x)=Equation
            if ((Equation != null) && (!Equation.equalsIgnoreCase(""))) {
                MyGroup[MyGroupIndex][2] = Equation;
                log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " MyGroup[MyGroupIndex][2]=" + MyGroup[MyGroupIndex][2] + " FinalEqn=" + FinalEqn);

            }

            log.fatal("FormGroupOLS:k=" + k + " InnerStart=" + InnerStart + " Equation=" + MyGroup[MyGroupIndex][2]);
            //Predicate for F(x)=Equation
            String TempPred = "";
            for (int z = Start; (z <= k) && ((k - Start) > 2); z++) {
                if (z <= (k - 1)) {
                    if (!FinalPred.toString().contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + z + ")" + "||";
                    }
                } else if (z == k) {
                    if (!FinalPred.toString().contains(Symbol + z)) {
                        TempPred = TempPred + "(" + Symbol + "==" + Symbol + z + ")";
                    }
                }
                variables.put(Symbol + z, (double) 0.0);
            }
            if ((k - Start) > 2) 
                ; else if (((k - Start) >= 1) && (Start > 0)) {
                if ((!FinalPred.toString().contains(Symbol + k)) && (!FinalPred.toString().contains(Symbol + (k - 1)))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (k - 1) + ")" + "||" + "(" + Symbol + "==" + Symbol + k + ")";
                } else if (!FinalPred.toString().contains(Symbol + k)) {
                    TempPred = "(" + Symbol + "==" + Symbol + k + ")";
                } else if (!FinalPred.toString().contains(Symbol + (k - 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (k - 1) + ")";
                }
                variables.put(Symbol + (k - 1), (double) 0.0);
                variables.put(Symbol + (k), (double) 0.0);
                log.fatal("FormGroupOLS:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            } else {

                if ((!FinalPred.toString().contains(Symbol + (Start + 1))) && (!FinalPred.toString().contains(Symbol + Start))) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")" + "||" + "(" + Symbol + "==" + Symbol + (Start + 1) + ")";
                } else if (!FinalPred.toString().contains(Symbol + (Start + 1))) {
                    TempPred = "(" + Symbol + "==" + Symbol + (Start + 1) + ")";
                } else if (!FinalPred.toString().contains(Symbol + Start)) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")";
                } else if (!FinalPred.toString().equalsIgnoreCase("")) {
                    TempPred = "(" + Symbol + "==" + Symbol + Start + ")";
                }
                variables.put(Symbol + Start, (double) 0.0);
                variables.put(Symbol + (Start + 1), (double) 0.0);
                log.fatal("FormGroupOLS:k=" + k + " Predicate=" + TempPred + " Symbol=" + Symbol + " Start=" + Start + " k=" + k);
            }
            MyGroup[MyGroupIndex][3] = TempPred;

            //3rd Segment :F(x) =0 for x > Stop;
            //F(x)=0
            MyGroup[MyGroupIndex][4] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][5] = Symbol + "!=" + k;
            MyGroupIndex++;
        }
        return k;
    }
    @FunctionalInterface
    public interface RegressOLSExprSecure {

        String Equation();
    }

    public static RegressOLSExprSecure RegExtractEqnExprSecure(String AscDescStart, String AscDescStop, int StartIndex, int StopIndex, HashMap PCHash, String Symbol, LinkedList<Double> Data, int MaxIndex, boolean ApplyAtLowLevel, StringBuilder FinalEqn, StringBuilder FinalPred, int Innerk) {

        return new Object() {

            RegressOLSExprSecure ExtractEquation() {
                RegressOLSExprSecure x = (() -> "");
                RegressOLSExprSecure y = (() -> "");
                ConfirmTest BadData;

                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);
                SimpleExpression expSimple;
                Expression expValue;
                String MyEqn = "";
                int k = (StopIndex - StartIndex);
                String LocalGlobal = "Local";
                log.fatal("RegressOLSExpr:ExtractEquation:Base Equation:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                String BaseEqn = "";
                log.info("RegressOLSExpr:ExtractEquation:Base Equation:BaseEqn=" + BaseEqn);
                log.fatal("RegressOLSExpr:ExtractEquation:Base Equation:FinalEqn=" + FinalEqn);
                log.info("RegressOLSExpr:ExtractEquation:Base Equation:FinalPred=" + FinalPred);
                MyEqn = BaseEqn;
                // If there are N points between Maxima & Minima
                if (k > 2) {
                    double ExprnexpValue = 0.0;
                    MyEqn = "";
                    if (ApplyAtLowLevel) {
                        log.fatal("RegressOLSExpr:ExtractEquation:ApplyAtLowLevel:N Points:StopIndex=" + (StopIndex + 1) + " StartIndex=" + (StartIndex + 1) + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:MyEqn=" + MyEqn);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:FinalEqn=" + FinalEqn);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:FinalPred=" + FinalPred);
                        log.info("RegressOLSExpr:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex; j < StopIndex; j++) {
                            String HoldEqn = FormLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                MyEqn += HoldEqn + "+";
                            }
                            j++;
                            //log.info("RegressOLSExpr:ExtractEquation:N Points:Equation=" + MyEqn);
                            //log.info("RegressOLSExpr:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j) + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    } else {
                        log.fatal("RegressOLSExpr:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                        for (int j = StartIndex; j < StopIndex; j++) {
                            String HoldEqn = FormLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                MyEqn += HoldEqn + "+";
                            }
                            j++;
                            log.info("RegressOLSExpr:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("RegressOLSExpr:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)+ " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                } // If there are 2 points between Maxima & Minima
                else if (k == 2) {
                    log.fatal("RegressOLSExpr:ExtractEquation:2 Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    if (StartIndex == 0) {
                        final String TempStr = MyEqn;
                        x = (() -> TempStr);
                    } else {
                        for (int j = StartIndex; j <= StopIndex; j++) {
                            String HoldEqn = FormLine(j, j + 1, PCHash, LocalGlobal);
                            if (!HoldEqn.equalsIgnoreCase("")) {
                                MyEqn += HoldEqn + "+";
                            }
                            j++;
                            log.info("RegressOLSExpr:ExtractEquation:N Points:Equation=" + MyEqn);
                            log.info("RegressOLSExpr:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j) + " Equation=" + MyEqn);
                        }
                        final String MyEqn1 = MyEqn;
                        x = (() -> MyEqn1);
                    }
                    log.fatal("RegressOLSExpr:ExtractEquation:k==2:Return Equation=" + x.Equation());
                    return x;
                } else {
                    log.info("RegressOLSExpr:ExtractEquation:0 OR 1 Points:ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);
                    log.info("RegressOLSExpr:ExtractEquation:DataArray ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex);
                    String Temp = "";
                    if ((AscDescStop == null) || (AscDescStop.equalsIgnoreCase("")) || (AscDescStart == null) || AscDescStart.equalsIgnoreCase(""))
                        ; else {
                        Temp = FormLine(StartIndex, StopIndex, PCHash, LocalGlobal);
                    }
                    if ((Temp != null) && (!Temp.equalsIgnoreCase(""))) {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("RegressOLSExpr:ExtractEquation:Final:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                    } else {
                        final String MyEqn2 = Temp;
                        x = (() -> MyEqn2);
                        log.info("RegressOLSExpr:ExtractEquation:Returning Final:" + LocalGlobal);
                    }

                }
                log.fatal("RegressOLSExpr:ExtractEquation:Else:Return Equation=" + x.Equation());
                return x;
            }

            String FormLine(int StrtIndx, int StpIndx, HashMap MyPCHash, String LocalGlobal) {
                String x = "";
                String NewEqnPart = "";
                log.info("FormLine:Initial:" + LocalGlobal + ":AscDescStart=" + AscDescStart);
                log.info("FormLine:Initial:" + LocalGlobal + ":AscDescStop=" + AscDescStop);
                log.info("FormLine:Initial:" + LocalGlobal + ":StrtIndx=" + StrtIndx);
                log.info("FormLine:Initial:" + LocalGlobal + ":StpIndx=" + StpIndx);
                log.info("FormLine:Initial:" + LocalGlobal + ":StrtIndx(y)=" + MyPCHash.get(StrtIndx));
                log.info("FormLine:Initial:" + LocalGlobal + ":StpIndx(y)=" + MyPCHash.get(StpIndx));
                if ((AscDescStart == null) || (AscDescStart.equalsIgnoreCase("")) || (AscDescStop == null) || (AscDescStop.equalsIgnoreCase(""))) {
                    log.fatal("FormLine:Final:NULL:Return Value:" + LocalGlobal + ":x=" + x);
                    return x;
                }
                if (((AscDescStart.equalsIgnoreCase("Maxima")) || (AscDescStop.equalsIgnoreCase("Neutral-Dsc")))) {
                    NewEqnPart = LineOLS(-1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = FinxNewEqnPart;
                    log.info("FormLine:Final:" + LocalGlobal + ":Minima:x=" + x);
                } else if (((AscDescStart.equalsIgnoreCase("Minima")) || (AscDescStop.equalsIgnoreCase("Neutral-Asc")))) {
                    NewEqnPart = LineOLS(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = FinxNewEqnPart;
                    log.info("FormLine:Final:" + LocalGlobal + ":Maxima:x=" + x);
                } else {
                    NewEqnPart = LineOLS(1, StrtIndx, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex, FinalEqn);
                    if (((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) && ((x != null) && (!x.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = x + NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormLine:else:" + LocalGlobal + ":Neutral:x=" + x);
                    } else if (((x == null) || (x.equalsIgnoreCase(""))) && ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase("")))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormLine:else:NewEqnPart:Upper:" + LocalGlobal + ":Neutral:x=" + x);
                    } else if ((NewEqnPart != null) && (!NewEqnPart.equalsIgnoreCase(""))) {
                        final String FinxNewEqnPart = NewEqnPart;
                        x = FinxNewEqnPart;
                        log.info("FormLine:else:NewEqnPart:Lower:" + LocalGlobal + ":Neutral:x=" + x);
                    }
                    log.info("FormLine:Final:" + LocalGlobal + ":Neutral:x=" + x);
                }
                log.fatal("FormLine:Final:Return Value:" + LocalGlobal + ":x=" + x);
                return x;
            }

            String LineOLS(int InterceptDirection, int Base, int Strt, int Stp, HashMap MyPCHash, String LocalGlobal, int MaxIndex, StringBuilder FinalEqn) {
                // Integral Expression Variables
                Map<String, Double> variables = new HashMap<>();
                Map<String, String> variablesDiff = new HashMap<>();
                Map<String, String> variablesIntegr = new HashMap<>();
                boolean ConfirmFlag = false;
                ConfirmTest BadData;
                MyFuncExpress();
                MyFuncDiff();
                MyFuncSimple();
                MyFuncIntegr();
                String DiffWithRespTo = "x";
                String Constant = "C";
                variablesDiff.put(DiffWithRespTo, DiffWithRespTo);
                variables.put(Constant, 5.0);

                String NewEqnPart = "";
                String Extrema = "";
                Double m = 0.0;
                Double c = 0.0;
                boolean StopFlagInit = false;
                boolean StartFlagInit = false;
                String[] TempDataStop = new String[6];
                String[] TempDataStart = new String[6];
                log.info("LineOLS:Initial:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("LineOLS:Initial:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("LineOLS:Initial:" + LocalGlobal + ":Strt(y1)=" + MyPCHash.get(Strt));
                log.info("LineOLS:Initial:" + LocalGlobal + ":Stp(y2)=" + MyPCHash.get(Stp));
                //y2
                String TempStop = (String) MyPCHash.get(Stp);
                log.info("LineOLS:" + LocalGlobal + ":TempStop=" + TempStop);
                if ((TempStop != null) && (!TempStop.equalsIgnoreCase(""))) {
                    TempDataStop = TempStop.split(",");
                    StopFlagInit = true;
                }
                //y1
                String TempStart = (String) MyPCHash.get(Strt);
                log.info("LineOLS:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempStart != null) && (!TempStart.equalsIgnoreCase(""))) {
                    TempDataStart = TempStart.split(",");
                    StartFlagInit = true;
                }
                log.info("LineOLS:InterceptDirection=" + InterceptDirection + " StartFlagInit=" + StartFlagInit + ":StopFlagInit=" + StopFlagInit);

                log.info("LineOLS:Symbol=" + Symbol);
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    //y=m*(x-x1) +y1
                    //m=(y2-y1)/(x2-x1)
                    //c= (x2y1-x1y2)/(x2-x1)
                    //c=y1 
                    m = (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1]))
                            / (Stp - Strt);
                    c = Double.parseDouble(TempDataStart[1]);
                    log.info("LineOLS:TempDataStop[1])=" + TempDataStop[1] + " TempDataStart[1]=" + TempDataStart[1]);
                    log.info("LineOLS:(Double.parseDouble(TempDataStop[1])-Double.parseDouble(TempDataStart[1])=" + (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1])));
                }
                if ((InterceptDirection == 1)) {
                    Extrema = "Maxima";
                } else if ((InterceptDirection == -1)) {
                    Extrema = "Minima";
                }
                log.info("LineOLS:m=" + m + " c=" + c);
                log.info("LineOLS:Base=" + Base + " (Stp+Strt)=" + (Stp + Strt) + " (Stp-Strt)=" + (Stp - Strt));
                log.info("LineOLS:TempDataStart[1]=" + TempDataStart[1] + " TempDataStop[1]=" + TempDataStop[1]);
                if ((TempDataStart[1] == null) || (TempDataStart[1].equalsIgnoreCase("")) || (TempDataStop[1] == null) || (TempDataStop[1].equalsIgnoreCase(""))) {
                    log.info("LineOLS:NULL:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    return NewEqnPart;
                }
                if ((!FinalEqn.toString().contains(Symbol + (Base + 1))) && (!FinalEqn.toString().contains(Symbol + Base))) {
                    NewEqnPart = Double.parseDouble(TempDataStart[1]) + "*" + ("(" + Symbol + Base + ")") + "+" + Double.parseDouble(TempDataStop[1]) + "*" + ("(" + Symbol + (Base + 1) + ")");
                } else if (!FinalEqn.toString().contains(Symbol + Base)) {
                    NewEqnPart = Double.parseDouble(TempDataStart[1]) + "*" + ("(" + Symbol + Base + ")");
                } else if (!FinalEqn.toString().contains(Symbol + (Base + 1))) {
                    NewEqnPart = Double.parseDouble(TempDataStop[1]) + "*" + ("(" + Symbol + (Base + 1) + ")");
                }
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    log.info("LineOLS:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    variables.put(DiffWithRespTo, (double) (Stp));
                    BadData = ConfirmEqn(NewEqnPart, Strt, Stp, PCHash, variables, DiffWithRespTo, LocalGlobal);
                    ConfirmFlag = BadData.eval();
                }
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":m=" + m);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":c=" + c);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStop[1](y2)=" + TempDataStop[1]);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStart[1](y1)=" + TempDataStart[1]);
                log.info("LineOLS:" + Extrema + ":Final:" + LocalGlobal + ":ConfirmFlag=" + ConfirmFlag);
                return NewEqnPart;
            }

        }.ExtractEquation();
    }
}
