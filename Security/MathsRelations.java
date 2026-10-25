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

import Calculus.DiffrIntegrSep;
import static Calculus.DiffrIntegrSep.parseDiff;
import Calculus.MathsContxtLAv;
import static Calculus.DiffrIntegrSep.MyFuncDiff;
import static Calculus.DiffrIntegrSep.parseIntegr;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.StrExpr;
import static Calculus.MathsExpressionParser.chExpr;
import static Calculus.MathsExpressionParser.parse;
import static Calculus.MathsExpressionParser.posExpr;
import static Calculus.UsageCalculus.Order;
import static Calculus.UsageCalculus.StageMapping;
import static Calculus.UsageCalculus.TestCase;
import static Security.EquationPairGeneration.aSecretValue;
import static Security.EquationPairGeneration.bSecretValue;
import static Security.EquationPairGeneration.cSecretValue;
import static Security.EquationPairGeneration.dSecretValue;
import static Security.EquationPairGeneration.diffusionN;
import static Security.EquationPairGeneration.eSecretValue;
import static Security.EquationPairGeneration.pSecretValue;
import static Security.EquationPairGeneration.qSecretValue;
import static Security.EquationPairGeneration.rSecretValue;
import static Security.EquationPairGeneration.sSecret;
import static Security.EquationPairGeneration.sSecretValue;
import static Security.EquationPairGeneration.zSecret;
import static Security.Security.variablesEncrypt;
import static SenderReceiverGUI.Receiver.ReceiverStrTCPDecrypt;
import static SenderReceiverGUI.Sender.SenderStrTCPEncrypt;
import java.util.HashMap;

import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class MathsRelations {

    public static Logger log = Logger.getLogger(MathsRelations.class.getName());
    public MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
    public DiffrIntegrSep.DiffExpr Diffrexp = (() -> "");
    public DiffrIntegrSep.IntegrExpr Integrexp = (() -> "");
    String DiffWithRespTo = "Xn";
    Map<String, Double> variables = new HashMap<>();

    public MathsRelations() {
        MyFuncExpress();
        MyFuncDiff();
        MyFuncSimple();
    }

    public void SetDiffWithRespTo(String MyDiffWithRespTo) {
        DiffWithRespTo = MyDiffWithRespTo;
    }

    public void initExprn(String Exprn,  Map<String, Double> variables1 , String DiffWithRespTo) {
        //System.out.println("Sender:MathsRelations:initExprn:Before parse:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        Exprn=MathsContxtLAv.eatAll(Exprn, ' ');
        variables=variables1;
               
//        if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongA)"))
//            variables.put("c", (double)4.0);
//        else if (SenderStrTCPEncrypt.equalsIgnoreCase("StrongB"))
//            variables.put("c", (double)5.0);
//        else if(SenderStrTCPEncrypt.equalsIgnoreCase("Weak"))
//            variables.put("c", (double)4.0);
//        if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongA)"))
//            variables.put("c", (double)4.0);
//        else if (ReceiverStrTCPDecrypt.equalsIgnoreCase("StrongB"))
//            variables.put("c", (double)5.0);
//        else if(ReceiverStrTCPDecrypt.equalsIgnoreCase("Weak"))
//            variables.put("c", (double)4.0);
        PutHiddenValuesGeneric();
        MappingContextCheck(Exprn);
        LCGexpValue = parse(Exprn, variables, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        if( (LCGexpValue.eval()==0) && (Exprn.equalsIgnoreCase("")) ){
            System.out.println(Calculus.ConsoleColors.RED + "MathsRelations:initExprn:Cannot MAP:is BLANK" + Calculus.ConsoleColors.RESET);
            throw new RuntimeException("Exprn:Cannot MAP:is BLANK");
        }else if( (LCGexpValue.eval()==0) && (Exprn.contains("("))&&(Exprn.contains(")") ) ) {
            System.out.println(Calculus.ConsoleColors.RED + "MathsRelations:initExprn:Cannot MAP: Contains Parenthesis " + Calculus.ConsoleColors.RESET);
            //throw new RuntimeException("Exprn:Cannot MAP:Contains Parenthesis");
        }else if (Exprn.equalsIgnoreCase("")) { 
            System.out.println(Calculus.ConsoleColors.RED + "MathsRelations:initExprn:MAPPED: is Blank:LCGexpValue=" + LCGexpValue.eval() + Calculus.ConsoleColors.RESET);
            throw new RuntimeException("Exprn:MAPPED:MAPPED: is Blank:");
        }
    }
  private void MappingContextCheck(String Exprn){
      if(Exprn.contains("z"))
            variables.put("z", (double)zSecret);
        else if( (Exprn.contains("z")) && (!variables.containsKey("z")))
            System.out.println(Calculus.ConsoleColors.RED +"WARN z UNUSABLE" + Calculus.ConsoleColors.RESET);
        if(Exprn.contains("s"))
            variables.put("s", (double)sSecret);
        else if( (Exprn.contains("s")) && (!variables.containsKey("s")))
            System.out.println(Calculus.ConsoleColors.RED +"WARN s UNUSABLE" + Calculus.ConsoleColors.RESET);
        if((Exprn.contains("m"))&&variables.containsKey("m"))
            ;
        else if(Exprn.contains("m"))
            System.out.println(Calculus.ConsoleColors.RED +"WARN m UNUSABLE" + Calculus.ConsoleColors.RESET);
        if((Exprn.contains("a"))&&variables.containsKey("a"))
            ;
        else if(Exprn.contains("a"))
            System.out.println(Calculus.ConsoleColors.RED +"WARN a UNUSABLE" + Calculus.ConsoleColors.RESET);
        if((Exprn.contains("c"))&&variables.containsKey("c"))
            ;
        else if(Exprn.contains("c"))
            System.out.println(Calculus.ConsoleColors.RED +"WARN c UNUSABLE" + Calculus.ConsoleColors.RESET);
  }
  private void PutHiddenValuesGeneric(){
      variables.put("a", (double)aSecretValue);
        if (!(variables.containsKey("b")) )
               variables.put("b", (double)bSecretValue);
        if (!(variables.containsKey("d")) )
                variables.put("d", (double)dSecretValue);
        if (!(variables.containsKey("e")) )
                variables.put("e", (double)eSecretValue);
        if (!(variables.containsKey("r")) )
                variables.put("r", (double)rSecretValue);
        if (!(variables.containsKey("s")) )
                variables.put("s", (double)sSecretValue);
        if (!(variables.containsKey("p")) )
                variables.put("p", (double)pSecretValue);
        if (!(variables.containsKey("q")) )
                variables.put("q", (double)qSecretValue);
  }
    public Double CalculateExprn() {
        return (Double) LCGexpValue.eval();
    }

    public void initDiffExprn(String Exprn) {
        Diffrexp = parseDiff(Exprn, variables, DiffWithRespTo, "Map1", "Diffr");
    }

    String CalculateDiffExprn(String Exprn) {
        System.out.println("MathsRelations:CalculateDiffExprn:Exprn=" + Exprn + " DiffWithRespTo=" + DiffWithRespTo);
        return Diffrexp.DiffExpr();
    }

    public void initIntegrExprn(String Exprn) {
        Integrexp = parseIntegr(Exprn, variables, DiffWithRespTo, "Map1", "Integre");
    }

    String CalculateIntegrExprn(String Exprn) {
        System.out.println("MathsRelations:CalculateIntegrExprn:Exprn=" + Exprn + " DiffWithRespTo=" + DiffWithRespTo);
        return Integrexp.IntegrExpr();
    }
}
