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
import static Regression.Regression.DataArray;
import static Regression.Regression.DataArrayOutput;
import static Regression.Regression.DataOutputCer;
import static Regression.Regression.DataOutputPredicted;
import static Regression.Regression.EntropyLimit;
import static Regression.Regression.FinalPredicate;
import static Regression.Regression.Max_Data_Col;
import static Regression.Regression.MisMatchCountRegress;
import static Regression.Regression.MisMatchCountUncer;
import static Regression.Regression.MyGroup;
import static Regression.Regression.MyGroupIndex;
import static Regression.Regression.ROWSREG;
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
public class RegressionHighSchool {

    public static Logger log = Logger.getLogger(RegressionHighSchool.class.getName());
    //Processed Output can be accessed either on Stack or Linked List
    LinkedList<Integer> PCMaximaLinkedIndex;// Maxima LinkedList Value Store
    LinkedList<Integer> PCMinimaLinkedIndex;// Minima LinkedList Value Store

    //Data Array(Input Data) Variables
    public static int MAX_DATA = 1000;
    static int COLUMNSSTART = 0;
    public static int MisMatchCount = 0;
    public static String[][] MyGroupUnCer = new String[MAX_DATA][6];
    public static int MyGroupUnCerIndex = 0;

    public RegressionHighSchool() {

    }

    public RegressionHighSchool(String Equation, String Dimension, String ColumnType, String DiffWithRespTo) {
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
            for (exp = 0; exp < MAX_DATA; exp++) {
                s = din.readLine();
                //log.info(s);
                if ((s == null) || (s.isEmpty()) || (s.equalsIgnoreCase(""))) {
                    break;
                } else if ((s != null) && (!s.isEmpty()) && (!s.equalsIgnoreCase("")) && (s.contains(","))) {
                    sTemp = s.split(",");
                    for (param = 0; ((param < Max_Data_Col) && ((param + 1) < sTemp.length) && (sTemp[param + 1] != null) && (!sTemp[param + 1].isEmpty())); param++) {
                        if (!sTemp[param + 1].isEmpty()) {
                            sTemp[param + 1] = sTemp[param + 1].replaceAll("\\s", " ").trim();
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
    public interface ConfirmTest {

        boolean eval();
    }

    public static ConfirmTest ConfirmEqn(String MyEquation, int StartIndex, int StopIndex, HashMap PCHash, Map<String, Double> variables, String DiffWithRespTo, String LocalGlobal) {
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

    public static void DisplayHash(HashMap PCHash) {
        String Temp = "";
        for (int i = 0; i < PCHash.size(); i++) {
            Temp = (String) PCHash.get(i);
            log.fatal(" Hash Element=" + i + " Temp=" + Temp);
        }
    }

    /* ************************** Main Calling Functions and Routines Begin *******/
    public static int FormGroup(int Start, String Symbol, int Max_Data, LinkedList<Double[]> DataArray, Map<String, Double> variables, String FinalEqn, String FinalPred, int Innerk, int InnerStart) {
        int j = 0;
        String Temp = "";
        String TempK = "";
        String[] TempDataK = new String[6];
        String Equation = "";
        int k = Start;
        for (; (k < (DataArray.size() - 1));) {
            TempK = "" + DataArray.get(k)[0];
            String HoldEqn = TempK + "*" + "(" + Symbol + k + ")";
            int i = Equation.lastIndexOf("+");
            if (i > 0) {
                Equation = Equation.substring(0, i);
                Equation = Equation + HoldEqn + "+";
            } else {
                Equation = HoldEqn;
            }
            log.fatal("FormGroup:k=" + k + " InnerStart=" + InnerStart + " Equation=" + Equation);
            log.fatal("FormGroup:k=" + k + " InnerStart=" + InnerStart + " FinalEqn=" + FinalEqn);
            log.fatal("FormGroup:k=" + k + " InnerStart=" + InnerStart + " FinalPred=" + FinalPred);
            log.fatal("FormGroup:k=" + k + " Start=" + Start + " Max_Data=" + Max_Data + " InnerStart=" + InnerStart);
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
        return k;
    }

    public static void pmain() {
        // Regression Expression Variables
        // Integral Expression Variables
        Map<String, Double> variables = new HashMap<>();
        Expression expValue = (() -> 0.0);
        Expression expValueEntropy= (() -> 0.0);
        MyFuncExpress();
        String DiffWithRespTo = "x";
        log.fatal("Regression:pmain:DataArray.size=" + DataArray.size());
        String FinalEquation = "";
        String FinalPredicate = "";
        String FinalEquationUnCer = "";
        String FinalPredicateUnCer = "";
        String FinalEquationEntropy = "";
        String FinalPredicateEntropy = "";
        int i = 0;
        int k = 0;
        DataArrayOutput = new LinkedList<Double[]>();
        DataOutputCer = new LinkedList<Double[]>();
        DataOutputPredicted = new LinkedList<Double[]>();
        Double[] Temp = new Double[Max_Data_Col];
        Temp[0] = DataArray.get(0)[0];
        for (int x = 1; x < Max_Data_Col; x++) {
            Temp[x] = 0.0;
        }
        DataArrayOutput.add(Temp);
        for (i = 0; (i < ROWSREG); i++) {
            k = FormGroup(i, DiffWithRespTo, ROWSREG, DataArray, variables, FinalEquation, FinalPredicate, 0, 0);
            for (int j = 0; (j <= i); j++) {
                variables.put((DiffWithRespTo + (j)), 0.0);
            }
            variables.put((DiffWithRespTo + (i)), 1.0);
            PredicateBool MyCondition = PredicateSep.parsePredicate(MyGroup[MyGroupIndex - 1][3], variables, "Silent", MathsContxtLAv.LogLevel.Off);
            boolean ConfirmPredicateFlag = MyCondition.eval();
            log.fatal("pmain:i=" + i + " k=" + k + " ConfirmPredicateFlag=" + ConfirmPredicateFlag);
            FinalEquation = ProcessEquation(FinalEquation);
            FinalPredicate = ProcessPredicate(FinalPredicate);
        }
        variables.put((DiffWithRespTo + (i)), 0.0);
        for (int j = 0; (j <= ROWSREG); j++) {
            variables.put((DiffWithRespTo + (j)), 0.0);
        }
        for (i = 0; (i < ROWSREG); i++) {
            variables.put((DiffWithRespTo + (i)), 1.0);
            expValue = RegressCalculate(i, variables, DiffWithRespTo, FinalEquation);
            FinalEquationUnCer = UnCerCalculate(i, FinalEquationUnCer, DiffWithRespTo);
            FinalEquationEntropy=EntropyCalculate(i, expValueEntropy,variables,FinalEquationEntropy, DiffWithRespTo);
            variables.put((DiffWithRespTo + (i)), 0.0);
        }
        log.fatal("pmain:i=" + i + " FinalEquationEntropy=" + FinalEquationEntropy);
        for (i = 0; (i < ROWSREG); i++) {
            PrintRegresssion(i, expValue, variables, DiffWithRespTo, FinalEquation);
            PrintUncertainity(i, variables, DiffWithRespTo, FinalEquationUnCer, FinalPredicateUnCer);
            PrintEntropy(i, expValueEntropy,variables, DiffWithRespTo, FinalEquationEntropy, FinalPredicateEntropy);
        }
        for (i = 0; (i < ROWSREG) && (i < DataArrayOutput.size()) && (DataArrayOutput.get(i) != null) && (DataArrayOutput.get(i)[0] != null); i++) {
            if (i >= 1) {
                System.out.println("pmain:DataArray.get[" + i + "][0].doubleValue()=" + DataArray.get(i)[0].doubleValue()
                        + " DataArrayOutput[" + i + "]get(i)[0].doubleValue()=" + DataArrayOutput.get(i)[0].doubleValue()
                        + " DataOutputPredicted[" + i + "]get(i)[0].doubleValue()=" + DataOutputPredicted.get(i - 1)[0].doubleValue());
            } else {
                System.out.println("pmain:DataArray.get[" + i + "][0].doubleValue()=" + DataArray.get(i)[0].doubleValue()
                        + " DataArrayOutput[" + i + "]get(i)[0].doubleValue()=" + DataArrayOutput.get(i)[0].doubleValue()
                        + " DataOutputPredicted[" + i + "]get(i)[0].doubleValue()=" + DataOutputPredicted.get(i)[0].doubleValue());
            }
        }
    }

    public static void main(String... args) {
        DataArray = new LinkedList<Double[]>();
        int i = 0;
        for (i = 0; i < MAX_DATA; i++) {
            Double[] Temp = new Double[Max_Data_Col];
            for (int x = 0; x < Max_Data_Col; x++) {
                Temp[x] = 0.0;
            }
            DataArray.add(Temp);
        }
        MyReadData("data\\", "Goto-Final.csv", DataArray);
        //MyReadData Modifies MAX_DATA to Actual Data Read 
        ROWSREG = MAX_DATA;
        pmain();
        TimeSeries_AWT.visible = true;
        //TimeSeries_AWT.Sigvisible = true;
        //TimeSeries_AWT.DemoNewDraw();
        TimeSeries_AWT.DemoRealTimeNewDraw();
    }

    /* ************************** Main Calling Functions and Routines End *******/
    public static Expression RegressCalculate(int i, Map<String, Double> variables, String DiffWithRespTo, String FinalEquation) {
        Expression expValue;
        Double[] Temp1 = new Double[Max_Data_Col];
        // Processing Regression Output Values
        expValue = parse(FinalEquation, variables, (DiffWithRespTo + (i + 1)), false,"Silent", MathsExpressionParser.LogLevel.Off);
        Temp1[0] = expValue.eval();
        DataArrayOutput.addLast(Temp1);
        log.fatal("RegressCalculate:expValue.eval()=" + expValue.eval());
        return expValue;
    }
    public static String UnCerCalculate(int i, String FinalEquationUnCer, String DiffWithRespTo) {
        Double PredictedValueDiff = 0.0;
        Double PredictedValue = 0.0;
        Double[] Temp2 = new Double[Max_Data_Col];
        Double[] Temp3 = new Double[Max_Data_Col];

        // Processing Uncertainity Output Values
        if (i >= 1) {
            PredictedValueDiff = (DataArray.get(i)[0].doubleValue() - DataArray.get(i - 1)[0].doubleValue());
            Temp2[0] = PredictedValueDiff;
            PredictedValue = DataArray.get(i - 1)[0].doubleValue() + PredictedValueDiff;
            Temp3[0] = PredictedValue;
            if (PredictedValueDiff > 0) {
                FinalEquationUnCer = FinalEquationUnCer + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + "P" + (i - 1));
            } else if (PredictedValueDiff == 0) {
                FinalEquationUnCer = FinalEquationUnCer + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + "P" + (i - 1));
            } else {
                FinalEquationUnCer = FinalEquationUnCer + PredictedValueDiff + "*" + (DiffWithRespTo + "P" + (i - 1));
            }
            DataOutputCer.add(Temp2);
            DataOutputPredicted.addLast(Temp3);
        } else if (i == 0) {
            PredictedValueDiff = 0.0;
            Temp2[0] = PredictedValueDiff;
            Temp3[0] = DataArray.get(i)[0].doubleValue();
            DataOutputCer.add(Temp2);
            DataOutputPredicted.addLast(Temp3);
        }
        log.fatal("UnCerCalculate:FinalEquationUnCer=" + FinalEquationUnCer);
        return FinalEquationUnCer;
    }
public static String EntropyCalculate(int i, Expression expValueEntropy,Map<String, Double> variables, String FinalEquationEntropy, String DiffWithRespTo) {
        Double PredictedValueDiff = 0.0;
        Double PredictedValue = 0.0;
        Double[] Temp2 = new Double[Max_Data_Col];
        Double[] Temp3 = new Double[Max_Data_Col];

        // Processing Entropy Output Values
        if (i >= 1) {
            for (int j = i; (j > 0)&&(j > (i-EntropyLimit)); j--) {
                PredictedValueDiff = (DataArray.get(i)[0].doubleValue() - DataArray.get(j - 1)[0].doubleValue());
                Temp2[0] = PredictedValueDiff;
                PredictedValue = DataArray.get(i - 1)[0].doubleValue() + PredictedValueDiff;
                Temp3[0] = PredictedValue;
                if (PredictedValueDiff > 0) {
                    FinalEquationEntropy = FinalEquationEntropy + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j - 1));
                } else if (PredictedValueDiff == 0) {
                    FinalEquationEntropy = FinalEquationEntropy + "+" + PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j - 1));
                } else {
                    FinalEquationEntropy = FinalEquationEntropy + PredictedValueDiff + "*" + (DiffWithRespTo + i + "E" + (j - 1));
                }
                variables.put((DiffWithRespTo + (i ) + "E" +(j -1)), 1.0);
                expValueEntropy=parse(FinalEquationEntropy, variables, (DiffWithRespTo + (i + 1) + "E" +(j -1)), false,"Silent", MathsExpressionParser.LogLevel.Off);
                PredictedValue=DataArray.get(j - 1)[0].doubleValue()+ expValueEntropy.eval();
                if(PredictedValue !=DataArray.get(i)[0].doubleValue())
                    log.fatal("EntropyCalculate:FATAL:i=" + i + " j=" + j + " DataArray.get(i)[0]=" + DataArray.get(i)[0].doubleValue() + " PredictedValue=" + PredictedValue + " expValueEntropy.eval()=" + expValueEntropy.eval());
                variables.put((DiffWithRespTo + (i ) + "E" +(j -1)), 0.0);
            }
        }else if (i == 0) {
            PredictedValueDiff = 0.0;
            Temp2[0] = PredictedValueDiff;
            Temp3[0] = DataArray.get(i)[0].doubleValue();
            //DataOutputCer.add(Temp2);
            //DataOutputPredicted.addLast(Temp3);
        }
        //log.fatal("EntropyCalculate:i=" + i + " FinalEquationEntropy=" + FinalEquationEntropy);
        return FinalEquationEntropy;
    }
    public static String ProcessEquation(String FinalEquation) {
        if ((!FinalEquation.equalsIgnoreCase("")) && (MyGroup[MyGroupIndex - 1][2] != null) && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
            if (MyGroup[MyGroupIndex - 1][2].startsWith("-")) {
                FinalEquation = FinalEquation + MyGroup[MyGroupIndex - 1][2];
            } else if (MyGroup[MyGroupIndex - 1][2].startsWith("+")) {
                FinalEquation = FinalEquation + MyGroup[MyGroupIndex - 1][2];
            } else {
                FinalEquation = FinalEquation + "+" + MyGroup[MyGroupIndex - 1][2];
            }
        } else if ((MyGroup[MyGroupIndex - 1][2] != null) && (!MyGroup[MyGroupIndex - 1][2].equalsIgnoreCase(""))) {
            FinalEquation = MyGroup[MyGroupIndex - 1][2];
        }
        log.fatal("ProcessEquation:FinalEquation=" + FinalEquation);
        return FinalEquation;
    }

    public static String ProcessPredicate(String FinalPredicate) {
        if ((!FinalPredicate.equalsIgnoreCase("")) && (MyGroup[MyGroupIndex - 1][3] != null) && (!MyGroup[MyGroupIndex - 1][3].equalsIgnoreCase(""))) {
            FinalPredicate = FinalPredicate + "||" + MyGroup[MyGroupIndex - 1][3];
        } else {
            FinalPredicate = MyGroup[MyGroupIndex - 1][3];
        }
        log.fatal("ProcessPredicate:FinalPredicate=" + FinalPredicate);
        return FinalPredicate;
    }

    public static void PrintRegresssion(int i, Expression expValue, Map<String, Double> variables, String DiffWithRespTo, String FinalEquation) {
        // Regression Output Values
        if ((i < DataArrayOutput.size()) && (DataArrayOutput.get(i) != null)) {
            log.fatal("pmain:Regression:i=" + i + " x=" + variables.get((DiffWithRespTo + (i))) + " (DiffWithRespTo + (i))=" + (DiffWithRespTo + (i)));
            log.fatal("pmain:Regression:i=" + i + " DataArrayOutput.get(i)[0]=" + DataArrayOutput.get(i + 1)[0] + " DataOutputCer.get(i)[0]=" + DataOutputCer.get(i)[0].doubleValue() + " DataArrayOutput=" + DataArrayOutput.size());
            log.fatal("pmain:Regression:i=" + i + " Equation=" + FinalEquation);
            log.fatal("pmain:Regression:i=" + i + " expValue.eval()=" + expValue.eval());
            log.fatal("pmain:Regression:i=" + i + " Predicate=" + FinalPredicate);
            if (DataArray.get(i)[0].doubleValue() == DataArrayOutput.get(i + 1)[0].doubleValue()) {
                System.out.println(ConsoleColors.GREEN + "pmain:Regression:Data Match:MisMatchCountRegress=" + MisMatchCountRegress + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataArrayOutput.get(i+1)[0]=" + DataArrayOutput.get(i + 1)[0] + ConsoleColors.RESET);
            } else if (DataArray.get(i)[0].doubleValue() != DataArrayOutput.get(i + 1)[0].doubleValue()) {
                MisMatchCountRegress++;
                System.out.println(ConsoleColors.RED + "pmain:Regression:Data Mismatch:MisMatchCountRegress=" + MisMatchCountRegress + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataArrayOutput.get(i+1)[0]=" + DataArrayOutput.get(i + 1)[0] + ConsoleColors.RESET);
            }
        }
    }

    public static void PrintUncertainity(int i, Map<String, Double> variables, String DiffWithRespTo, String FinalEquationUnCer, String FinalPredicateUnCer) {
        // Uncertainity Output Values
        if ((i < DataOutputPredicted.size()) && (DataOutputPredicted.get(i) != null)) {
            log.fatal("pmain:Uncertainity:i=" + i + " x=" + variables.get((DiffWithRespTo + (i + 1))) + " (DiffWithRespTo + (i+1))=" + (DiffWithRespTo + (i + 1)));
            log.fatal("pmain:Uncertainity:i=" + i + " DataOutputPredicted.get(i)[0]=" + DataOutputPredicted.get(i)[0] + " DataOutputCer.get(i)[0]=" + DataOutputCer.get(i)[0].doubleValue() + " DataOutputPredicted=" + DataOutputPredicted.size());
            //log.fatal("pmain:Uncertainity:i=" + i + " FinalEquationUnCer=" + FinalEquationUnCer);
            log.fatal("pmain:Uncertainity:i=" + i + " FinalPredicateUnCer=" + FinalPredicateUnCer);
            if (DataArray.get(i)[0].doubleValue() == DataOutputPredicted.get(i)[0].doubleValue()) {
                System.out.println(ConsoleColors.GREEN + "pmain:Uncertainity:Data Match:MisMatchCountUncer=" + MisMatchCountUncer + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataOutputPredicted.get(i)[0]=" + DataOutputPredicted.get(i)[0] + ConsoleColors.RESET);
            } else if (DataArray.get(i)[0].doubleValue() != DataOutputPredicted.get(i)[0].doubleValue()) {
                MisMatchCountUncer++;
                System.out.println(ConsoleColors.RED + "pmain:Uncertainity:Data Mismatch:MisMatchCountUncer=" + MisMatchCountUncer + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataOutputPredicted.get(i)[0]=" + DataOutputPredicted.get(i)[0] + ConsoleColors.RESET);
            }
        }
    }
    public static void PrintEntropy(int i, Expression expValueEntropy,Map<String, Double> variables, String DiffWithRespTo, String FinalEquationEntropy, String FinalPredicateEntropy) {
        // Uncertainity Output Values
        if ((i < DataOutputPredicted.size()) && (DataOutputPredicted.get(i) != null)) {
            log.fatal("pmain:Entropy:i=" + i + " x=" + variables.get((DiffWithRespTo + (i + 1) + "E" )) + " (DiffWithRespTo + (i+1) + E )=" + (DiffWithRespTo + (i + 1) + "E" ));
            log.fatal("pmain:Entropy:i=" + i + " DataOutputPredicted.get(i)[0]=" + DataOutputPredicted.get(i)[0] + " DataOutputCer.get(i)[0]=" + DataOutputCer.get(i)[0].doubleValue() + " DataOutputPredicted=" + DataOutputPredicted.size());
            //log.fatal("pmain:Entropy:i=" + i + " FinalEquationEntropy=" + FinalEquationEntropy);
            //log.fatal("pmain:Entropy:i=" + i + " FinalPredicateEntropy=" + FinalPredicateEntropy);
            log.fatal("pmain:Entropy:i=" + i + " expValueEntropy.eval()=" + expValueEntropy.eval());
//            if (DataArray.get(i)[0].doubleValue() == DataOutputPredicted.get(i)[0].doubleValue()) {
//                System.out.println(ConsoleColors.GREEN + "pmain:Uncertainity:Data Match:MisMatchCountUncer=" + MisMatchCountUncer + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataOutputPredicted.get(i)[0]=" + DataOutputPredicted.get(i)[0] + ConsoleColors.RESET);
//            } else if (DataArray.get(i)[0].doubleValue() != DataOutputPredicted.get(i)[0].doubleValue()) {
//                MisMatchCountUncer++;
//                System.out.println(ConsoleColors.RED + "pmain:Uncertainity:Data Mismatch:MisMatchCountUncer=" + MisMatchCountUncer + " DataArray.get(" + (i) + ")[0]=" + DataArray.get(i)[0] + " DataOutputPredicted.get(i)[0]=" + DataOutputPredicted.get(i)[0] + ConsoleColors.RESET);
//            }
        }
    }
}
