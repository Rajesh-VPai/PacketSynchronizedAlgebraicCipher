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

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class EquationPairGeneration {

    public static Logger log = Logger.getLogger(EquationPairGeneration.class.getName());
    // Equations Begin
    public static String ExprnDiffusion = "m^2*Xn^2+2*m*Xn*c+c^2";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
    public static String DiffWithRespToDiffusion = "Xn";
    public static String InvExprnDiffusion = "y^0.5/m-2.0/m";   //x="y^0.5/m-2.0/m";// x="y^0.5-2.0";//x=y^0.5/m-c/m
    public static String InvDiffusionDiffWithRespTo = "y";
    public static String ExprnSurprise = "m^2*Xn^2+2*m*Xn*c+c^2";      //y=(m*Xn+2)^2;//y=(Xn+2)^2; //y=m^2*Xn^2+2*m*Xn*c+c^2
    public static String DiffWithRespToSurprise = "Xn";
    public static String InvTempSurprise = "";
    public static String InvExprnSurprise = "y^0.5/m-2.0/m";   //x=y1^1/n
    public static String InvSurpriseDiffWithRespTo = "y";
    // Constants used in Diffusion
    public static Double diffusiond2 = 0.0;
    public static Double diffusionN = 0.0;
    public static Double confusionA = 0.0;
    public static long zSecret = 54;
    public static long aSecret = 4;
    public static long bSecret = 5;
    public static long cSecret = 3;
    public static long dSecret = 23;
    public static long sSecret = 31;
    public static long rSecretValue = 3;
    public static long zSecretValue = 54;
    public static long aSecretValue = 2;
    public static long bSecretValue = 5;
    public static long cSecretValue = 4;
    public static long dSecretValue = 23;
    public static long eSecretValue = 23;
    public static long pSecretValue = 23;
    public static long qSecretValue = 23;
    public static long sSecretValue = 31;

    public static Set<Long> seenSeedsSender = new HashSet<>();
    public static Set<Long> seenSeedsReceiver = new HashSet<>();
    // Equations End
    //Fractionating Encrypt
    public static String FractionEncryptExprn = "";//MorseCode Table Traversal
    public static String FractionEncryptDiffWithRespTo = "x";
    public static String FractionEncryptComputerExprn = "";//Computer Memory Traversal
    public static String FractionEncryptComputerDiffWithRespTo = "x";
    //Fractionating Decrypt
    public static String FractionDecryptExprn = "";
    public static String FractionDecryptDiffWithRespTo = "";
    public static String InvFractionDecryptComputerExprn = "";//Computer Memory Traversal
    public static String InvFractionDecryptComputerDiffWithRespTo = "x";

    //Transposition Encrypt
    public static String TranspositionExprn = "";
    public static String TranspositionDiffWithRespTo = "len";
    public static String TranspComputerExprn = "";
    public static String TranspComputerDiffWithRespTo = "len";
    //Transposition Decrypt
    public static String InvTranspositionExprn = "";
    public static String InvTranspositionDiffWithRespTo = "len";
    public static String InvTranspComputerExprn = "";
    public static String InvTranspComputerDiffWithRespTo = "len";

    private static String EquationType1;
    private static String InvEquationType1;

    private static String EquationType2;
    private static String InvEquationType2;

    private static String EquationType3;
    private static String InvEquationType3;

    private static String EquationType4;
    private static String InvEquationType4;

    private static String EquationType5;
    private static String InvEquationType5;

    public static String EquationType6;
    public static String InvEquationType6;

    private static String EquationType7;
    private static String InvEquationType7;

    public static String EquationType8;
    public static String InvEquationType8;

    public static String EquationType9;
    public static String InvEquationType9;

    public static String EquationType10;
    public static String InvEquationType10;

    public static String EquationType11;
    public static String InvEquationType11;

    private static String Equation1Type1;
    private static String InvEquation1Type1;

    private static String Equation1Type2;
    private static String InvEquation1Type2;

    private static String Equation1Type3;
    private static String InvEquation1Type3;

    private static String Equation1Type4;
    private static String InvEquation1Type4;

    private static String Equation1Type5;
    private static String InvEquation1Type5;

    public static String Equation1Type6;
    public static String InvEquation1Type6;

    private static String Equation1Type7;
    private static String InvEquation1Type7;

    public static String Equation1Type8;
    public static String InvEquation1Type8;

    public static String Equation1Type9;
    public static String InvEquation1Type9;

    public static String Equation1Type10;
    public static String InvEquation1Type10;

    public static String Equation1Type11;
    public static String InvEquation1Type11;
    
    public static String Equation1Type12;
    public static String InvEquation1Type12;

    public static String Equation1Type13;
    public static String InvEquation1Type13;
    
    public static String Equation1Type14;
    public static String InvEquation1Type14;
    
    public static void ListOfEquationsThatCanBeUsed() {
        // As a ready Referenceof List of Equations :Function not used anywhere
        // Input Transformation OR Just the Equation
        EquationType1 = "Xn+c";
        InvEquationType1 = "(y-c)";

        EquationType2 = "m*Xn+c";
        InvEquationType2 = "(y-c)/m";

        // Non Linear Invertible Equation of the form y=x^2+c
        EquationType3 = "Xn^2+2*Xn*c+c^2"; //y=(Xn+c)^2
        InvEquationType3 = "y^0.5-c";

        // Non Linear Invertible Equation of the form y=(mx)^2
        EquationType4 = "m^2*Xn^2+2*m*Xn*c+c^2"; //y=(m*Xn+c)^2 
        InvEquationType4 = "y^0.5/m-c/m";

        // Output Transformation
        EquationType5 = "a*(m^2*Xn^2+2*m*Xn*c+c^2)+b"; //y=a*((m*Xn+c)^2 )+b
        InvEquationType5 = "(((y-b)/a)^0.5-c)/m";      //x=(((y-b)/a)^0.5-c)/m :remember to add variable.put("a", Some Value) etc;

        // Non Linear Invertible Equation
        EquationType6 = "Xn^2+Xn"; //y=Xn^2+Xn 
        InvEquationType6 = "(-1+(1+4*y)^0.5)/2";

        EquationType7 = "(m*Xn+q)^r"; //y=(m*Xn+c)^r where r is a number constant
        InvEquationType7 = "(y^(1/r)-q)/m";// remember to add variable.put("r", Some Value);variable.put("q", Some Value);

        // Linear Rational Function
        EquationType8 = "(m*Xn+q)/(s*Xn+d)"; //y=(m*Xn+q)/(s*Xn+d) 
        InvEquationType8 = "(d*y-q)/(m-s*y)";//x=(d*y -q)/(m-s*y):remember to add variable.put("s", Some Value) etc;

        // Transcendental Equations Not Tested Below
        EquationType9 = "exp(Xn/10000)"; //y=e^x 
        InvEquationType9 = "10000*ln(y)";

        EquationType10 = "exp(m*Xn/10000)"; //y=e^(m*x) 
        InvEquationType10 = "ln(y)*10000/m";
        
        // Values goes to infinity during mapping:Not to be used.
        EquationType11 = "exp(m*Xn/10000+q/10000)"; //y=e^(m*x+q) 
        InvEquationType11 = "ln(y)*10000/m-q/m";

    }
    public static void ListOfEquationsThatCanBeUsed1() {
    // Linear
    Equation1Type1 = "Xn - c";
    InvEquation1Type1 = "y + c";

    Equation1Type2 = "m*Xn - c";
    InvEquation1Type2 = "(y + c)/m";

    // Quadratic
    Equation1Type3 = "(Xn - c)^2"; 
    InvEquation1Type3 = "y^0.5 + c";

    Equation1Type4 = "(m*Xn - c)^2"; 
    InvEquation1Type4 = "y^0.5/m + c/m";

    // Output Transformation
    Equation1Type5 = "a*((m*Xn - c)^2) - b"; 
    InvEquation1Type5 = "(((y + b)/a)^0.5 + c)/m";

    // Non Linear
    Equation1Type6 = "Xn^2 - Xn"; 
    InvEquation1Type6 = "(1 + (1 + 4*y)^0.5)/2";

    // Power
    Equation1Type7 = "(m*Xn - q)^r"; 
    InvEquation1Type7 = "(y^(1/r) + q)/m";

    // Rational
    Equation1Type8 = "(m*Xn - q)/(s*Xn - d)"; 
    InvEquation1Type8 = "(d*y + q)/(m - s*y)";

    // Exponential
    Equation1Type9 = "exp(-Xn/10000)"; 
    InvEquation1Type9 = "-10000*ln(y)";

    Equation1Type10 = "exp(-m*Xn/10000)"; 
    InvEquation1Type10 = "-ln(y)*10000/m";

    Equation1Type11 = "exp(-(m*Xn/10000 + q/10000))"; 
    InvEquation1Type11 = "-(ln(y)*10000/m) + q/m";

    // Binomial
    Equation1Type12 = "(Xn - q)^r"; 
    InvEquation1Type12 = "y^(1/r) + q";

    Equation1Type13 = "(m*Xn - q)^r"; 
    InvEquation1Type13 = "(y^(1/r) + q)/m";

    // Exponential with offset
    Equation1Type14 = "exp(-(m*Xn + q))"; 
    InvEquation1Type14 = "(-(ln(y) - q))/m";
}
}
