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


import Calculus.MathsContxtLAv;
import Calculus.MathsExpressionParser;
import Calculus.MathsExpressionParser.Expression;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.DiffrIntegrSep.MyFuncDiff;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.DiffrIntegrSep.MyFuncIntegr;
import Calculus.MathsContxtLAv.SimpleExpression;
import static Calculus.MathsContxtLAv.eatAll;
import static Calculus.MathsExpressionParser.parse;
import static Calculus.MathsContxtLAv.parseSimple;
import Calculus.PredicateSep;
import Calculus.PredicateSep.PredicateBool;
import static Regression.Regression.DataArray;
import static Regression.Regression.MyGroup;
import static Regression.Regression.MyGroupIndex;
import static Regression.Regression.ROWSREG;
import static Regression.Regression.WaveData;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class RegressionFreshman{

    public static Logger log = Logger.getLogger(RegressionFreshman.class.getName());
    //Processed Output can be accessed either on Stack or Linked List
    LinkedList<Integer> PCMaximaLinkedIndex;// Maxima LinkedList Value Store
    LinkedList<Integer> PCMinimaLinkedIndex;// Minima LinkedList Value Store

    //Data Array(Input Data) Variables
    public static int MAX_DATA = 1000;
    static int Max_Data_Col = 2;
    static int COLUMNSSTART = 0;
    
    public RegressionFreshman(String Path, String FileName) {
        log.info("Regression:Constructor:Entered");
        DataArray = new LinkedList<Double[]>();
        int i = 0;
        for ( i = 0; i < MAX_DATA; i++) {
            Double[] Temp = new Double[Max_Data_Col];
            for (int x = 0; x < Max_Data_Col; x++) {
                Temp[x] = 0.0;
            }
            DataArray.add(Temp);
        }
        MyReadData(Path, FileName, DataArray);
        //MyReadData Modifies MAX_DATA to Actual Data Read 
        ROWSREG=MAX_DATA;
        log.info("Regression:Constructor:Exited");
    }

    public RegressionFreshman(String Equation, String Dimension, String ColumnType, String DiffWithRespTo) {
        log.info("Regression:Constructor:Entered");
        DataArray = new LinkedList<Double[]>();
        // ProcessIndex Function needs 2 extra at the end 
        // of the code for Trend
        for (int i = 0; i < (ROWSREG + 2); i++) {
            Double[] Temp = new Double[1];
            for (int x = 0; x < 1; x++) {
                Temp[x] = 0.0;
            }
            DataArray.add(Temp);
        }
        GenerateData(Equation, Dimension, ColumnType, DiffWithRespTo, DataArray);
        log.info("Regression:Constructor:Exited:DataArray.size=" + DataArray.size());
    }

//    public Regression(int planeNum, String Dimension, String ColumnType, String DiffWithRespTo) {
//        log.info("Regression:Constructor:Entered");
//        CopyData(Dimension, ColumnType, DiffWithRespTo, planeNum);
//        
//    }

    public void MyReadData(String Path, String FileName, LinkedList<Double[]> Data) {
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
            if ((s != null) && (s.contains(","))) {
//                    sTemp = s.split(",");
//                    GlblVars.nameOutputNN = new String[sTemp.length - 1];
//                    for (int i = 0; i < sTemp.length - 1; i++) {
//                        GlblVars.nameOutputNN[i] = new String(sTemp[i + 1]);
//                    }
            }
//                if (InputCOLUMNSNN > sTemp.length) {
//                    MAX_HIST_COLNN = sTemp.length - 1;
//                }

            // Traverse Array and store the Output against
            // the corresponding Parameter & Level of Prameter.
            for (exp = 0; exp < MAX_DATA; exp++) {
                s = din.readLine();
                //log.info(s);
                if ((s == null) || (s.isEmpty()) || (s.equalsIgnoreCase(""))) {
                    // Set Max Computation Row equal to Historical Data Read Count
                    //MAX_HIST_DATANN = exp;
                    break;
                } else if ((s != null) && (!s.isEmpty()) && (!s.equalsIgnoreCase("")) && (s.contains(","))) {
                    sTemp = s.split(",");
                    //log.info("Split ReadLine sTemp[0]=" + sTemp[0] + " sTemp[1]=" + sTemp[1] + " sTemp[2]=" + sTemp[2] + " sTemp[3]=" + sTemp[3]);
                    for (param = 0; ((param < Max_Data_Col) && ((param + 1) < sTemp.length) && (sTemp[param + 1] != null) && (!sTemp[param + 1].isEmpty())); param++) {
                        //if ((param >= 0) && (levels >= 1) && (exp >= 0)) {
                        if (!sTemp[param + 1].isEmpty()) {
                            sTemp[param + 1] = sTemp[param + 1].replaceAll("\t", " ").replaceAll("\"", " ").trim();
                            //log.error("Read String="+sTemp[param+1]);
                            Data.get(exp)[COLUMNSSTART + param] = Double.parseDouble(sTemp[param + 1]);
                            //log.info("Read String=" + sTemp[param + 1] + " [COLUMNSSTART + param]=" + Data.get(exp)[COLUMNSSTART + param]);
                        } else {
                            Data.get(exp)[COLUMNSSTART + param] = 0.0;
                        }
                        //log.info("MyReadData data param=" + param + " COLUMNSSTART+param=" + (COLUMNSSTART + param) + " exp=" + exp + " Ortho[exp][column]=" + Data.get(exp)[COLUMNSSTART + param]);
                        //}
                    }
                }
            }
            //This code affects all Other Code Globally
            MAX_DATA = exp;
            log.info("MyReadData:Read MAX_DATA=" + MAX_DATA);
            //log.error("MyReadData : Read All Parameters rows=" + exp);
        } catch (Exception NNse) {
            log.error("Exception: Neural Network MyReadDataArrayNN");
            System.out.println(NNse.getStackTrace());
            System.out.println(NNse.getMessage());
            NNse.printStackTrace();
        }
    }

    public LinkedList<Double[]> CopyDataArray(int StartIndex, int StopIndex, LinkedList<Double[]> Data) {
        WaveData = new LinkedList<Double[]>();
        for (int i = StartIndex; i < (StopIndex + 2); i++) {
            WaveData.add(Data.get(i));
        }
        return WaveData;
    }

    public void GenerateData(String Equation, String Dimension, String ColumnType, String DiffWithRespTo, LinkedList<Double[]> Data) {
        Expression expValue;
        Map<String, Double> variables = new HashMap<>();
        MyFuncExpress();

        for (int i = 0; i < ROWSREG; i++) {
            variables.put(DiffWithRespTo, (double) (i));
            expValue = parse(Equation, variables, DiffWithRespTo,false, "Silent", MathsExpressionParser.LogLevel.Off);
            Data.get(i)[0] = expValue.eval();
        }
    }

    void StoreLocalMaxMin(String MaxOrMin, Double Value, int ValIndex, HashMap PCHash, int HashMapIndex) {
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

    public void StoreLocal(String MaxOrMin, Double Value, int ValIndex, HashMap PCHash, int HashMapIndex) {
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

    public MaximaMinima ProcessData(int StartIndex, int Max_Index, LinkedList<Double[]> Data, int Mapped) {
        HashMap PCHash = new HashMap();// Hash Map to store Maxima/Minima Details as CSV

        int SigIndex = 0;//Index of WaveData : Input Waveform Index element that is being Processed.
        //Store the Initial Value
        StoreLocal("Neutral-Zero", Data.get(0)[SigIndex], 0, PCHash, 0/*HashMapIndex*/);
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
                Integer HashMapIndex = 1;// Running Index of Elements of HashMap

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
                    }
                    //
                    //  PCountP3 -> PCountPlus2 Mechanism
                    //
                    //
                    if ((PCountP3 > PCountPlus2) && (AscFlagMinusT == true)) {
                        //Wave on the Ascending
                        AscFlagP3 = true;
                        DscFlagP3 = false;
                    } else if ((PCountP3 < PCountPlus2) && (DscFlagMinusT == true)) {
                        //Wave on the Descending
                        AscFlagP3 = false;
                        DscFlagP3 = true;
                    }
                    //Actual Work gets done here
                    //NextXt -> ProgramCounter Mechanism
                    //
                    //
                    if (NextXt > ProgramCounter) {
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
                    } else if (NextXt < ProgramCounter) {
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
                    }

                    PCountMinusT = ProgramCounter;
                    ProgramCounter = NextXt;
                    PCRowIndex++;
                    if (PCRowIndex <= (PCLastRowIndex)) {
                        log.info("Regression:ProcessIndex:PCLastRowIndex=" + PCLastRowIndex + " PCRowIndex=" + PCRowIndex + " Data.size()=" + Data.size());
                        if (Mapped == 0) {
                            NextXt = Data.get(PCRowIndex)[SigIndex];
                        } else {
                            NextXt = WaveData.get(PCRowIndex)[SigIndex];
                        }
                        if (PCRowIndex < PCLastRowIndex) {
                            if (Mapped == 0) {
                                PCountPlus2 = Data.get(PCRowIndex + 1)[SigIndex];
                            } else {
                                PCountPlus2 = WaveData.get(PCRowIndex + 1)[SigIndex];
                            }
                        }
                        if (PCRowIndex < (PCLastRowIndex - 1)) {
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
                log.info("Regression:ProcessIndex:Exited PCRowIndex=" + PCRowIndex);
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
                DisplayHash(PCHash);
                log.info("Regression:ProcessOutputTrend:Exited PCRowIndex=" + PCRowIndex + " ProgramCounter=" + ProgramCounter + " NextXt=" + NextXt);
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

    public RegressionExpr RegressionExpr(String AscDescStart, String AscDescStop, int StartIndex, int StopIndex, HashMap PCHash, String Symbol, LinkedList<Double[]> Data, int MaxIndex) {

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
                String MyEqn="";
                int k = (StopIndex - StartIndex);
                //Form Base Equation
                log.fatal("Regression:ExtractEquation:Base Equation:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);  
                String BaseEqn = FormLine(StartIndex, StopIndex, PCHash, "Global");
                log.fatal("Regression:ExtractEquation:Base Equation:BaseEqn=" + BaseEqn );  
                MyEqn=BaseEqn;
                // If there are N points between Maxima & Minima
                if (k > 2) {
                    double ExprnexpValue = 0.0;
                    log.fatal("Regression:ExtractEquation:N Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop); 
                    for (int j = StartIndex+1; j < StopIndex; j++) {
                        MyEqn = MyEqn+FormEquationReg((long) 1.0, (long) 1.0, (long) 1.0, (long) 1.0, DiffWithRespTo, (j-StartIndex),BaseEqn, ExprnexpValue);
                        log.fatal("Regression:ExtractEquation:N Points:Equation=" + MyEqn);
                        for (double z = 0; ((z < 5.0) &&(ExprnexpValue != Data.get(j)[0]) ); z+=1.00) {
                            variables.put(DiffWithRespTo, ( ((double) j)+ ((double)z) ));
                            expValue = parse(MyEqn, variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                            ExprnexpValue = expValue.eval();
                            log.fatal("Regression:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation Value=" + ExprnexpValue + " j=" + j + " z=" + z);
                        }
                        log.fatal("Regression:ExtractEquation:N Points:x=" + j + " y=" + Data.get(j)[0] + " Equation=" + MyEqn);
                    }
                    final String MyEqn1 = MyEqn;
                    x = (() -> MyEqn1);
                }
                // If there are 2 points between Maxima & Minima
                else if (k == 2) {
                    log.fatal("Regression:ExtractEquation:2 Points:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);  
                    final String LocalGlobal = "Local";
                    WaveData = CopyDataArray(StartIndex, StopIndex, Data);
                    MaximaMinima MyData1 = ProcessData(0, (StopIndex - StartIndex), WaveData, 1);
                    // Data is put in Hash Map
                    HashMap TempPCHash = MyData1.Extrema();
                    int j = StartIndex;
                    for (int i = 0; i < k; i++, j++) {
                        log.info("Regression:ExtractEquation:Local StopIndex=" + StopIndex + " StartIndex=" + StartIndex);
                        String Temp = (String) TempPCHash.get(i);
                        String[] TempData = Temp.split(",");
                        log.info("Regression:ExtractEquation:Local ProcessData:TempData[0]=" + TempData[0]);
                        if ((TempData[0].contains("Neutral-Asc:Local")) || (TempData[0].contains("Maxima:Local")) || (TempData[0].contains("Neutral-Zero"))) {
                            final int StrtIndex = j;
                            x = (() -> Line(1, StrtIndex, StrtIndex + 1, PCHash, LocalGlobal, MaxIndex));
                            log.info("Regression:ExtractEquation:FormedLine:Asc:j=" + j + " (j+1)=" + (j + 1) + " x.Equation()=" + x.Equation());
                        } else if ((TempData[0].contains("Neutral-Dsc:Local")) || (TempData[0].contains("Minima:Local")) || (TempData[0].contains("Neutral-Zero"))) {
                            final int StrtIndex = i;
                            x = (() -> Line(-1, StrtIndex, StrtIndex + 1, PCHash, LocalGlobal, MaxIndex));
                            log.info("Regression:ExtractEquation:FormedLine:Dsc:j=" + j + " (j+1)=" + (j + 1) + " x.Equation()=" + x.Equation());
                        }
                        BadData = ConfirmEqn(x.Equation(), j, j + 1, PCHash, variables, DiffWithRespTo, LocalGlobal);
                        ConfirmFlag = BadData.eval();
                        log.info("Regression:ExtractEquation::j=" + j + " (j+1)=" + (j + 1) + " ConfirmFlag=" + ConfirmFlag);
                        log.info("Regression:ExtractEquation:Returning Final:" + LocalGlobal + ":x.Equation()=" + x.Equation());
                    }

                    final String MyEqn1 = x.Equation();
                    x = (() -> MyEqn1);
                    return x;
                } 
                else {
                    log.fatal("Regression:ExtractEquation:0 OR 1 Points:ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex + " AscDescStart=" + AscDescStart + " AscDescStop=" + AscDescStop);  
                    final String LocalGlobal = "Global";
                    log.info("Regression:ExtractEquation:DataArray ProcessData:StopIndex=" + StopIndex + " StartIndex=" + StartIndex);
                    String Temp = FormLine(StartIndex, StopIndex, PCHash, LocalGlobal);
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

                if (((AscDescStart.equalsIgnoreCase("Maxima")) || (AscDescStop.equalsIgnoreCase("Neutral-Dsc")))) {
                    NewEqnPart = Line(-1, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = (() -> FinxNewEqnPart);
                    log.info("FormLine:Final:" + LocalGlobal + ":Minima:x.Equation()=" + x.Equation());
                } else if (((AscDescStart.equalsIgnoreCase("Minima")) || (AscDescStop.equalsIgnoreCase("Neutral-Asc")))) {
                    NewEqnPart = Line(1, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex);
                    final String FinxNewEqnPart = NewEqnPart;
                    x = (() -> FinxNewEqnPart);
                    log.info("FormLine:Final:" + LocalGlobal + ":Maxima:x.Equation()=" + x.Equation());
                } else {
                    NewEqnPart = Line(1, StrtIndx, StpIndx, MyPCHash, LocalGlobal, MaxIndex);
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
//                if ((x.Equation()==null)||(x.Equation().equalsIgnoreCase(""))) 
//                    return MyEquation1;
//                else 
                return x.Equation();
            }

            String Line(int InterceptDirection, int Strt, int Stp, HashMap MyPCHash, String LocalGlobal, int MaxIndex) {
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
                log.info("Line:Initial:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("Line:Initial:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("Line:Initial:" + LocalGlobal + ":Strt(y1)=" + MyPCHash.get(Strt));
                log.info("Line:Initial:" + LocalGlobal + ":Stp(y2)=" + MyPCHash.get(Stp));
                //y2
                String TempStop = (String) MyPCHash.get(Stp);
                log.info("Line:" + LocalGlobal + ":TempStop=" + TempStop);
                if ((TempStop != null) && (!TempStop.equalsIgnoreCase(""))) {
                    TempDataStop = TempStop.split(",");
                    StopFlagInit = true;
                }
                //y1
                String TempStart = (String) MyPCHash.get(Strt);
                log.info("Line:" + LocalGlobal + ":TempStart=" + TempStart);
                if ((TempStart != null) && (!TempStart.equalsIgnoreCase(""))) {
                    TempDataStart = TempStart.split(",");
                    StartFlagInit = true;
                }
                log.info("Line:InterceptDirection=" + InterceptDirection + " StartFlagInit=" + StartFlagInit + ":StopFlagInit=" + StopFlagInit);

                log.info("Line:Symbol=" + Symbol);
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    //y=m*(x-x1) +y1
                    //m=(y2-y1)/(x2-x1)
                    //c= (x2y1-x1y2)/(x2-x1)
                    //c=y1 
                    m = (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1]))
                            / (Stp - Strt);
                    c = Double.parseDouble(TempDataStart[1]);
                    log.info("Line:TempDataStop[1])=" + TempDataStop[1] + " TempDataStart[1]=" + TempDataStart[1]);
                    log.info("Line:(Double.parseDouble(TempDataStop[1])-Double.parseDouble(TempDataStart[1])=" + (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1])));
                }
                if ((InterceptDirection == 1)) {
                    Extrema = "Maxima";
                } else if ((InterceptDirection == -1)) {
                    Extrema = "Minima";
                }
                log.info("Line:m=" + m + " c=" + c);
                log.info("Line:(Stp+Strt)=" + (Stp + Strt) + " (Stp-Strt)=" + (Stp - Strt));

                if (c > 0.0) {
                    NewEqnPart = m + "*" + ("(" + Symbol + "-" + Strt + ")") + "+" + (c);
                } else if (c < 0.0) {
                    NewEqnPart = m + "*" + ("(" + Symbol + "-" + Strt + ")") + (c);
                } else {
                    NewEqnPart = m + "*" + ("(" + Symbol + "-" + Strt + ")");
                }
                if ((StartFlagInit == true) && (StopFlagInit == true)) {
                    log.info("Line:" + Extrema + ":" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                    variables.put(DiffWithRespTo, (double) (Stp));
                    BadData = ConfirmEqn(NewEqnPart, Strt, Stp, PCHash, variables, DiffWithRespTo, LocalGlobal);
                    ConfirmFlag = BadData.eval();
//                String Symbol1="";
//                for (int j=1; j < MaxIndex; j++){
//                    if ((!Symbol1.equalsIgnoreCase(""))&&(j != (Stp-1))) 
//                        Symbol1=Symbol1 +"*" + "(" + Symbol + "-" + j+ ")" ;
//                    else if ((Symbol1.equalsIgnoreCase(""))&&(j != (Stp-1))) 
//                        Symbol1="(" + Symbol + "-" + j+ ")" ;
//                    else if ((Symbol1.equalsIgnoreCase(""))&&(j == (Stp) ))
//                        Symbol1="(" + 1.0 + ")" ;
//                    else if ((!Symbol1.equalsIgnoreCase(""))&&(j == (Stp-1) ))
//                        Symbol1=Symbol1 +"*" + "(" + 1.0 + ")" ;
//                    }
//                NewEqnPart= "(" + NewEqnPart + ")" + "*" + Symbol1; 
                    NewEqnPart = NewEqnPart;
                }
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":NewEqnPart=" + NewEqnPart);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":Strt(x1)=" + Strt);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":Stp(x2)=" + Stp);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":m=" + m);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":c=" + c);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStop[1](y2)=" + TempDataStop[1]);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":TempDataStart[1](y1)=" + TempDataStart[1]);
                log.info("Line:" + Extrema + ":Final:" + LocalGlobal + ":ConfirmFlag=" + ConfirmFlag);
                return NewEqnPart;
            }

        }.ExtractEquation();
    }

    @FunctionalInterface
    public interface ConfirmTest {

        boolean eval();
    }

    public ConfirmTest ConfirmEqn(String MyEquation, int StartIndex, int StopIndex, HashMap PCHash, Map<String, Double> variables, String DiffWithRespTo, String LocalGlobal) {
        return new Object() {

            ConfirmTest parseConfirm() {
                ConfirmTest x = (() -> false);
                Expression expValue;
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
                expValue = parse(MyEquation, variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                if ((PCHash != null) && (PCHash.size() > StopIndex) && (TempDataStart[1] != null) && (TempDataStop[1] != null)) {
                    log.info(LocalGlobal + ":" + " MyEquation=" + MyEquation + " x=" + variables.get(DiffWithRespTo));
                    log.info(LocalGlobal + ":" + "ConfirmTest:Result(F(x))=" + expValue.eval()
                            + " y1=" + TempDataStart[1] + " x1=" + StartIndex
                            + " y2=" + TempDataStop[1] + " x2=" + StopIndex);

                    log.info(LocalGlobal + ":" + "ConfirmTest: Diff(y0)=" + (expValue.eval() - Double.parseDouble(TempDataStop[1])));
                    log.info(LocalGlobal + ":" + "ConfirmTest:(TempDataStop[1]-TempDataStart[1])=" + (Double.parseDouble(TempDataStop[1]) - Double.parseDouble(TempDataStart[1]))
                            + " Math.round(expValue.eval()=" + Math.round(expValue.eval()));
                    if (expValue.eval() == (Double.parseDouble(TempDataStop[1]))) {
                        x = (() -> true);
                    }
                }
                log.info(LocalGlobal + ":ConfirmFlag:x.eval()=" + x.eval());
                return x;
            }
        }.parseConfirm();
    }

    public void DisplayHash(HashMap PCHash) {
        String Temp = "";
        for (int i = 0; i < PCHash.size(); i++) {
            Temp = (String) PCHash.get(i);
            //log.fatal(" Hash Element=" + i + " Temp=" + Temp);
        }
    }

    public static void main(String... args) {
        RegressionFreshman MyDataAnalyser;
        MyDataAnalyser = new RegressionFreshman("data\\", "Goto-Final.csv");
        MyDataAnalyser.pmain(MyDataAnalyser);
        TimeSeries_AWT.visible=true;
        TimeSeries_AWT.Sigvisible=true;
        //TimeSeries_AWT.DemoNewDraw();
        TimeSeries_AWT.DemoRealTimeNewDraw();
    }

    public void pmain(RegressionFreshman MyDataAnalyser) {
        // Regression Expression Variables
        LinkedList<Double[]> WaveData;
        // Integral Expression Variables
        Map<String, Double> variables = new HashMap<>();
        MyFuncExpress();
        String DiffWithRespTo = "x";
        log.fatal("Regression:pmain:DataArray.size=" + DataArray.size());
        MaximaMinima MyData = ProcessData(0, (int) ROWSREG, DataArray, 0);
        // Data is put in Hash Map
        HashMap PCHash = MyData.Extrema();
        log.fatal("Regression:pmain:PCHash.size=" + PCHash.size());
        DisplayHash(PCHash);

        int Max_Index = (int) ROWSREG;
        int i = 0;
        int k = 0;
        for (i = 0; i < PCHash.size() - 1; i++) {
            k = FormGroup(i, DiffWithRespTo, PCHash.size(), 6, PCHash);

            variables.put(DiffWithRespTo, (double) (i));
            ConfirmTest BadData = ConfirmEqn(MyGroup[MyGroupIndex - 1][2], i, k, PCHash, variables, DiffWithRespTo, "Global");
            boolean ConfirmFlag = BadData.eval();
            variables.put(DiffWithRespTo, (double) (k));
            BadData = ConfirmEqn(MyGroup[MyGroupIndex - 1][2], i, k, PCHash, variables, DiffWithRespTo, "Global");
            ConfirmFlag = BadData.eval();
            PredicateBool MyCondition = PredicateSep.parsePredicate(MyGroup[MyGroupIndex - 1][3], variables, "Silent", MathsContxtLAv.LogLevel.Off);
            boolean ConfirmPredicateFlag = MyCondition.eval();

            Expression expValue;
            expValue = parse(MyGroup[MyGroupIndex - 1][2], variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
            log.fatal("pmain:i=" + i + " k=" + k + " x=" + variables.get(DiffWithRespTo));
            log.fatal("pmain:i=" + i + " k=" + k + " Expr.eval()=" + expValue.eval());
            log.fatal("pmain:i=" + i + " k=" + k + " Equation=" + MyGroup[MyGroupIndex - 1][2]);
            log.fatal("pmain:i=" + i + " k=" + k + " Predicate=" + MyGroup[MyGroupIndex - 1][3]);
            log.fatal("pmain:i=" + i + " k=" + k + " ConfirmFlag=" + ConfirmFlag);
            log.fatal("pmain:i=" + i + " k=" + k + " ConfirmPredicateFlag=" + ConfirmPredicateFlag);
            i = k - 1;
        }

    }

    public int FormGroup(int Start, String Symbol, int Max_Data, int MaxLen, HashMap PCHash) {
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
            if ((TempDataK[0].equalsIgnoreCase("Minima"))/*&&(TempData[0].equalsIgnoreCase("Maxima"))*/) {
                break;
            } else if ((TempDataK[0].equalsIgnoreCase("Maxima")) /*&& (TempData[0].equalsIgnoreCase("Minima")) */) {
                break;
            } else {
                k++;
            }
        }
        MyEqn = RegressionExpr(TempData[0], TempDataK[0], Start, k, PCHash, Symbol, DataArray, PCHash.size());

        if ((Start < Max_Data) && (k < Max_Data)) {
            //for(j=0; j < MaxLen; ){
            //1st Segment :F(x) =0 for x < Start;
            //F(x)=0
            MyGroup[MyGroupIndex][j++] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][j++] = Symbol + "<" + Start;
            //2nd Segment :F(x) =Equation for Start <=x <= Stop
            //F(x)=Equation
            MyGroup[MyGroupIndex][j++] = MyEqn.Equation();
            //Predicate for F(x)=Equation
            MyGroup[MyGroupIndex][j++] = "(" + Start + "<=" + Symbol + ")&&(" + Symbol + "<=" + k + ")";
            //3rd Segment :F(x) =0 for x > Stop;
            //F(x)=0
            MyGroup[MyGroupIndex][j++] = "0";
            //Predicate for F(x)=0
            MyGroup[MyGroupIndex][j++] = Symbol + ">" + k;
            // }
            MyGroupIndex++;
        }
        return k;
    }
    public static String FormEquationReg(long Xn,long MgtACoeff, long Mgtc, long MgtbCoeff,String TechDiffWithRespTo, int MgtMaxExponent, String BaseEquation, Double ExprnexpValue) {
        //if(Xn==0) MaxExponent=5;
        //else MaxExponent=(int)Xn;
        long bCoeffStore=MgtbCoeff;
        //log.fatal("FormEquation: MgtbCoeff=" + MgtbCoeff );
        String Exprn = "";
        int i=MgtMaxExponent;
            if(MgtbCoeff >2){
                if ((i !=0)&&(i%2==0))
                    if (ExprnexpValue < 0)
                        Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                    else 
                        Exprn = Exprn + " - " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                else if ((i !=0)&&(i%2 !=0))
                    if (ExprnexpValue < 0)
                        Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                    else 
                        Exprn = Exprn + " - " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                
            }
            else {
                if ((i !=0)&&(i%2==0))
                    if (ExprnexpValue < 0)
                        Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                    else 
                        Exprn = Exprn + " - " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                else if ((i !=0)&&(i%2 !=0))
                    if (ExprnexpValue < 0)
                        Exprn = Exprn + " + " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                    else 
                        Exprn = Exprn + " - " + MgtbCoeff + "*" + TechDiffWithRespTo + "^" + i;
                MgtbCoeff=bCoeffStore;
            }
        //Exprn = Exprn + " - " + Mgtc;
        Exprn = eatAll(Exprn, ' ');
        log.fatal("FormEquation:Exprn=" + Exprn + " MgtMaxExponent=" + MgtMaxExponent);
        return Exprn;
    }
}
