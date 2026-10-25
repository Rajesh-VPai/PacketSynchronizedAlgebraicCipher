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
package Equations;

import Calculus.MathsExpressionParser;
import static Equations.PSACEquationSuite.InverseCubicEquation;
import static Equations.PSACEquationSuite.InverseEqnPairEquation10;
import static Equations.PSACEquationSuite.InverseEqnPairEquation11;
import static Equations.PSACEquationSuite.InverseEqnPairEquation8;
import static Equations.PSACEquationSuite.InverseEqnPairEquation9;
import static Equations.PSACEquationSuite.InverseLogisticEquation;
import static Equations.PSACEquationSuite.InverseNonLinear12;
import static Equations.PSACEquationSuite.InverseSafeEqnPairEquation9;
import static Equations.PSACEquationSuite.InverseSafeRationalEquation;
import static Equations.PSACEquationSuite.InverseSafeTough;
import static Equations.PSACEquationSuite.expandEqnPairEquation10;
import static Equations.PSACEquationSuite.expandEqnPairEquation11;
import static Equations.PSACEquationSuite.expandEqnPairEquation8;
import static Equations.PSACEquationSuite.expandEqnPairEquation9;
import static Equations.PSACEquationSuite.expandNonLinear12;
import static Equations.PSACEquationSuite.expandCubicEquation;
import static Equations.PSACEquationSuite.expandLogisticEquation;
import static Equations.PSACEquationSuite.expandSafeAmXnEquation;
import static Equations.PSACEquationSuite.expandSafeBinomialEquation;
import static Equations.PSACEquationSuite.expandSafeEqnPairEquation9;
import static Equations.PSACEquationSuite.expandSafeMultinomialAmXn4VarEquation;
import static Equations.PSACEquationSuite.expandSafeMultinomialAmXnEquation;
import static Equations.PSACEquationSuite.expandSafeRationalEquation;
import static Equations.PSACEquationSuite.expandSafeSimpleStatic;
import static Equations.PSACEquationSuite.expandSafeStatic;
import static Equations.PSACEquationSuite.expandSafeTough;
import static Equations.PSACEquationSuite.inverseSafeAmXnEquation;
import static Equations.PSACEquationSuite.inverseSafeBinomialEquation;
import static Equations.PSACEquationSuite.inverseSafeMultinomialAmXn4VarEquation;
import static Equations.PSACEquationSuite.inverseSafeSimpleStatic;
import static Equations.PSACEquationSuite.inverseSafeStatic;
/**
 *
 * @author Rajesh V Pai
 */
public class PSACEquationFactory {

    public static final String[] DEFAULT_VARS = {"Xn", "z", "m", "s", "a"};// {"Xn", "z", "s", "d"};
    public static int[] DEFAULT_COEFFS = {2, 3, 4, 5, 3};//{1, 1, 1, 1, 0}; // [a,b,c,d,hashedSeed]

    public static String expandSimpleStatic() {
        return PSACEquationSuite.expandSimpleStatic();
    }

    public static String inverseSimpleStatic() {
        return PSACEquationSuite.inverseSimpleStatic();
    }

    public static String expandStatic() {
        return PSACEquationSuite.expandStatic();
    }

    public static String inverseStatic() {
        return PSACEquationSuite.inverseStatic();
    }

    public static String expandBinomialEquation() {
        return PSACEquationSuite.expandBinomialEquation();
    }

    public static String inverseBinomialEquation() {
        return PSACEquationSuite.inverseBinomialEquation();
    }

    public static String expandAmXnEquation() {
        return PSACEquationSuite.expandAmXnEquation();
    }

    public static String inverseAmXnEquation() {
        return PSACEquationSuite.inverseAmXnEquation();
    }

    public static String expandMultinomialAmXnEquation() {
        return  MathsExpressionParser.eatAll(PSACEquationSuite.expandMultinomialAmXnEquation(), ' ');//( DEFAULT_COEFFS[4]);
    }

    public static String inverseMultinomialAmXnEquation() {
        return  MathsExpressionParser.eatAll(PSACEquationSuite.inverseMultinomialAmXnEquation(), ' ');//(DEFAULT_COEFFS[4]);
    }

    public static String expandTough() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.expandTough(),' ');
    }

    public static String InverseTough() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.InverseTough(),' ');
    }

    public static String expandRationalEquation() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.expandRationalEquation(),' ');
    }

    public static String InverseRationalEquation() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.InverseRationalEquation(),' ');
    }
    public static String expandRationalEqnPairEquation8() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.expandEqnPairEquation8(),' ');
    }

    public static String InverseRationalEqnPairEquation8() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.InverseEqnPairEquation8(),' ');
    }
    public static String expandMultinomialAmXn4VarEquation() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.expandMultinomialAmXn4VarEquation(), ' ');
    }

    public static String inverseMultinomialAmXn4VarEquation() {
        return MathsExpressionParser.eatAll(PSACEquationSuite.inverseMultinomialAmXn4VarEquation(), ' ');
    }

    public static String buildEquation(int selector) {
        boolean SilentFlag = true;
        if (SilentFlag == false) {
            System.out.println("buildEquation:selectorName=" + selectorName(selector) + " selector=" + selector);
        }
        switch (selector) {
            case 0:
                return expandSimpleStatic();//(Xn+c)^2
            case 1:
                return expandStatic();//(m*Xn+c)^2
            case 2:
                return expandBinomialEquation();//y=(m*Xn+q)^r
            case 3:
                return expandAmXnEquation();//(a*m*Xn + c)^r
            case 4:
                return expandRationalEqnPairEquation8();//y=(m*Xn+c)/(n*Xn+d)
            case 5:
                return expandNonLinear12();// y=Xn^2+Xn                
            case 6 :
                return expandCubicEquation(); // y= Xn^3+Xn
            case 7:
                return expandMultinomialAmXnEquation();//y=(a*m*Xn + b*z + c)^r
            case 8:
                return expandTough();// ((a*m*Xn +b*z)/(d*s+e*p)+c)^r
            case 9:
                return expandRationalEquation();// (((amXn + bz)+e)/(dsXn+ep)+c)^r
            case 10:
                return expandMultinomialAmXn4VarEquation();// (a*m*Xn + b*z + d*s + e*p + c)^r
            case 11:
                return expandLogisticEquation();//y=r*Xn*(1 - Xn)
            case 12:
                return expandEqnPairEquation9();// y=exp^(Xn)
            case 13:
                return expandEqnPairEquation10();// y=exp^(m*Xn)
            case 14:// Not to be used as values goes to infinity on Encryption && Decryption
                return expandEqnPairEquation11();// y=exp^(m*x+c)
            default:
                return "Unsupported Equation";
        }
    }

    public static String buildInverse(int selector) {
        boolean SilentFlag = true;
        if (SilentFlag == false) {
            System.out.println("buildInverse:selectorName=" + selectorName(selector) + " selector=" + selector);
        }
        switch (selector) {
            case 0:
                return inverseSimpleStatic();//(Xn+c)^2
            case 1:
                return inverseStatic();//(m*Xn+c)^2
            case 2:
                return inverseBinomialEquation();//y=(m*Xn+q)^r
            case 3:
                return inverseAmXnEquation();//(a*m*Xn + c)^r
            case 4:
                return InverseRationalEqnPairEquation8();//y=(m*Xn+c)/(n*Xn+d)
            case 5:
                return InverseNonLinear12();// y=Xn^2+Xn                
            case 6 :
                return InverseCubicEquation(); // y= Xn^3+Xn
            case 7:
                return inverseMultinomialAmXnEquation();//y=(a*m*Xn + b*z + c)^r
            case 8:
                return InverseTough();// ((a*m*Xn +b*z)/(d*s+e*p)+c)^r
            case 9:
                return InverseRationalEquation();// (((amXn + bz)+e)/(dsXn+ep)+c)^r
            case 10:
                return inverseMultinomialAmXn4VarEquation();// (a*m*Xn + b*z + d*s + e*p + c)^r
            case 11:
                return InverseLogisticEquation();//y=r*Xn*(1 - Xn)
            case 12:
                return InverseEqnPairEquation9();// y=exp^Xn
            case 13:
                return InverseEqnPairEquation10();// y=exp^(m*Xn)
            case 14:// Not to be used as values goes to infinity on Encryption && Decryption
                return InverseEqnPairEquation11();// y=exp^(m*Xn+c)
            default:
                return "Unsupported Inverse";
        }
    }

    public static String selectorName(int selector) {
        switch (selector) {
            case 0:
                return "SimpleStatic";//(Xn+c)^2
            case 1:
                return "Static";//(m*Xn+c)^2
            case 2:
                return "MBinomialEquation";//y=(Xn+q)^r
            case 3:
                return "AmXnEquation";//(a*m*Xn + c)^r
            case 4:
                return "RationalEqnPairEquation8";//y=(m*Xn+c)/(n*Xn+d)
            case 5:
                return "NonLinear12";// y=Xn^2+Xn                
            case 6 :
                return "CubicEquation"; // y= Xn^3+Xn
            case 7:
                return "MultinomialAmXnEquation";//y=(a*m*Xn + b*z + c)^r
            case 8:
                return "Tough";// ((a*m*Xn +b*z)/(d*s+e*p)+c)^r
            case 9:
                return "RationalEquation";// (((amXn + bz)+e)/(dsXn+ep)+c)^r
            case 10:
                return "MultinomialAmXn4VarEquation";// (a*m*Xn + b*z + d*s + e*p + c)^r
            case 11:
                return "LogisticEquation";//y=r*Xn*(1 - Xn)
            case 12:
                return "EqnPairEquation9";// y=exp^Xn
            case 13:
                return "EqnPairEquation10";// y=exp^(m*Xn)
            case 14:// Not to be used as values goes to infinity on Encryption && Decryption
                return "EqnPairEquation11";// y=exp^(m*Xn+c)
            default:
                return "Unsupported";
        }
    }
    
}
