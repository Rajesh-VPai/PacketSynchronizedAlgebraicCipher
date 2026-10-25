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

/**
 *
 * @author Rajesh V Pai
 */
public class PSACEquationSuiteExtremelySafe {
    // === Safe Equations ===

    // Simple Static
    public static String expandSafeSimpleStatic() {
        return "(a*Xn - q)^2";
    }
    public static String inverseSafeSimpleStatic() {
        return "sqrt(y)/a + q/a";
    }

    // Static
    public static String expandSafeStatic() {
        return "(m*Xn - q)^2";
    }
    public static String inverseSafeStatic() {
        return "sqrt(y)/m + q/m";
    }

    // AmXn Binomial
    public static String expandSafeAmXnEquation() {
        return "(a*m*Xn - q)^r";
    }
    public static String inverseSafeAmXnEquation() {
        return "(y^(1/r) + q)/(a*m)";
    }

    // Multinomial AmXn
    public static String expandSafeMultinomialAmXnEquation() {
        return "(a*m*Xn - b*z - q)^r";
    }
    public static String inverseSafeMultinomialAmXnEquation() {
        return "(y^(1/r) + b*z + q)/(a*m)";
    }

    // Multinomial AmXn 4 Var
    public static String expandSafeMultinomialAmXn4VarEquation() {
        return "(a*m*Xn - b*z - d*s - e*p - q)^r";
    }
    public static String inverseSafeMultinomialAmXn4VarEquation() {
        return "(y^(1/r) + b*z + d*s + e*p + q)/(a*m)";
    }

    // Binomial
    public static String expandSafeBinomialEquation() {
        return "(m*Xn - q)^r";
    }
    public static String inverseSafeBinomialEquation() {
        return "y^(1/r)/m + q/m";
    }

    // Tough Rational
    public static String expandSafeToughEquation() {
        return "((a*m*Xn - b*z)/(d*s-e*p) - q)^r";
    }
    public static String inverseSafeToughEquation() {
        return "(((y^(1/r) + q)*(d*s-e*p)) + b*z)/(a*m)";
    }

    // Rational
    public static String expandSafeRationalEquation() {
        return "(((a*m*Xn - b*z - e)/(d*s*Xn - e*p)) - q)^r";
    }
    public static String inverseSafeRationalEquation() {
        return "(((y^(1/r) + q)*e*p + b*z + e)/(a*m - (y^(1/r) + q)*d*s))";
    }

    // EqnPair8
    public static String expandSafeEqnPair8() {
        return "(m*Xn - q)/(s*Xn - d)";
    }
    public static String inverseSafeEqnPair8() {
        return "(d*y + q)/(m - s*y)";
    }

    // Exponential
    public static String expandSafeEqnPair9() {
        return "exp(-Xn/10000)";
    }
    public static String inverseSafeEqnPair9() {
        return "-10000*ln(y)";
    }

    public static String expandSafeEqnPair10() {
        return "exp(-m*Xn/10000)";
    }
    public static String inverseSafeEqnPair10() {
        return "-ln(y)*10000/m";
    }

    public static String expandSafeEqnPair11() {
        return "exp(-(m*Xn/10000 + q/10000))";
    }
    public static String inverseSafeEqnPair11() {
        return "-(ln(y)*10000/m) + q/m";
    }

    // NonLinear
    public static String expandSafeNonLinear12() {
        return "Xn^2 - Xn";
    }
    public static String inverseSafeNonLinear12() {
        return "(1 + sqrt(1 + 4*y))/2";
    }

    // Cubic
    public static String expandSafeCubicEquation() {
        return "Xn^3 - Xn";
    }
    public static String inverseSafeCubicEquation() {
        return "cbrt(y/2 + sqrt((y/2)^2 - 1/27)) + cbrt(y/2 - sqrt((y/2)^2 - 1/27))";
    }

    // Logistic
    public static String expandSafeLogisticEquation() {
        return "r*Xn*(1 - Xn)";
    }
    public static String inverseSafeLogisticEquation() {
        return "(1 + sqrt(1 - 4*y/r))/2";
    }
// Expansion: y = (255 * Xn^2) / (1 - Xn^2)
    public static String expandSaturatedQuadratic() {
        return "(255.0 * Xn * Xn) / (1.0 - Xn * Xn)";
    }

    // Inverse: Xn = sqrt(y / (255 + y))
    public static String inverseSaturatedQuadratic() {
        return "sqrt(y/ (255 + y))";
    }
    // === Demo Harness ===
    public static void main(String[] args) {
        System.out.println("Safe Simple Static: " + expandSafeSimpleStatic() + " | Inverse: " + inverseSafeSimpleStatic());
        System.out.println("Safe Static: " + expandSafeStatic() + " | Inverse: " + inverseSafeStatic());
        System.out.println("Safe AmXn: " + expandSafeAmXnEquation() + " | Inverse: " + inverseSafeAmXnEquation());
        System.out.println("Safe Multinomial AmXn: " + expandSafeMultinomialAmXnEquation() + " | Inverse: " + inverseSafeMultinomialAmXnEquation());
        System.out.println("Safe Multinomial AmXn 4Var: " + expandSafeMultinomialAmXn4VarEquation() + " | Inverse: " + inverseSafeMultinomialAmXn4VarEquation());
        System.out.println("Safe Binomial: " + expandSafeBinomialEquation() + " | Inverse: " + inverseSafeBinomialEquation());
        System.out.println("Safe Tough: " + expandSafeToughEquation() + " | Inverse: " + inverseSafeToughEquation());
        System.out.println("Safe Rational: " + expandSafeRationalEquation() + " | Inverse: " + inverseSafeRationalEquation());
        System.out.println("Safe EqnPair8: " + expandSafeEqnPair8() + " | Inverse: " + inverseSafeEqnPair8());
        System.out.println("Safe EqnPair9: " + expandSafeEqnPair9() + " | Inverse: " + inverseSafeEqnPair9());
        System.out.println("Safe EqnPair10: " + expandSafeEqnPair10() + " | Inverse: " + inverseSafeEqnPair10());
        System.out.println("Safe EqnPair11: " + expandSafeEqnPair11() + " | Inverse: " + inverseSafeEqnPair11());
        System.out.println("Safe NonLinear12: " + expandSafeNonLinear12() + " | Inverse: " + inverseSafeNonLinear12());
        System.out.println("Safe Cubic: " + expandSafeCubicEquation() + " | Inverse: " + inverseSafeCubicEquation());
        System.out.println("Safe Logistic: " + expandSafeLogisticEquation() + " | Inverse: " + inverseSafeLogisticEquation());
    }
    public static String buildSafeEquation(int selector) {
        boolean SilentFlag = true;
        if (SilentFlag == false) {
            System.out.println("PSAEquationSuiteExtremelySafe:buildSafeEquation:selectorSafeName=" + selectorSafeName(selector) + " selector=" + selector);
        }
        switch (selector) {
            case 0:
                return expandSafeSimpleStatic();//(Xn - q)^2
            case 1:
                return expandSafeStatic();//(m*Xn - q)^2
            case 2:
                return expandSafeBinomialEquation();//y=(Xn - q)^r
            case 3:
                return expandSafeAmXnEquation();//(a*m*Xn - q)^r
            case 4:
                return expandSafeMultinomialAmXnEquation();//y=(a*m*Xn - b*z - q)^r
            case 5:
                return expandSafeMultinomialAmXn4VarEquation();// (a*m*Xn + b*z + d*s + e*p + c)^r
            case 6:
                //return expandSaturatedQuadratic();//y = (255 * Xn^2) / (1 - Xn^2)
                return "Unsupported Safe Equation";
            case 7:
                //return expandSafeToughEquation();// ((a*m*Xn +b*z)/(d*s+e*p)+c)^r
                return "Unsupported Equation";
            case 8:
                //return expandSafeEqnPair8();// (((amXn + bz)+e)/(dsXn+ep)+c)^r
                return "Unsupported Safe Equation";
            case 9:
                //return expandSafeNonLinear12();// y=Xn^2+Xn                
                return "Unsupported Safe Equation";
            case 10:
                //return expandCubicEquation(); // y= Xn^3+Xn
                return "Unsupported Safe Equation";
            case 11:
                //return expandSafeLogisticEquation();//y=r*Xn*(1 - Xn)
                return "Unsupported Safe Equation";
            case 12:
                //return expandSafeEqnPair9();// y=exp^(Xn)
                return "Unsupported Safe Equation";
            case 13:
                //return expandSafeEqnPair10();// y=exp^(m*Xn)
                return "Unsupported Safe Equation";
            case 14:// Not to be used as values goes to infinity on Encryption && Decryption
                //return expandSafeEqnPair11();// y=exp^(m*x+c)
                return "Unsupported Safe Equation";
            default:
                return "Unsupported Safe Equation";
        }
    }

    public static String buildSafeInverse(int selector) {
        boolean SilentFlag = true;
        if (SilentFlag == false) {
            System.out.println("PSAEquationSuiteExtremelySafe:buildSafeInverse:selectorSafeName=" + selectorSafeName(selector) + " selector=" + selector);
        }
        switch (selector) {
            case 0:
                return inverseSafeSimpleStatic();//sqrt(y) + q
            case 1:
                return inverseSafeStatic();//sqrt(y)/m + q/m
            case 2:
                return inverseSafeBinomialEquation();//y^(1/r) + q
            case 3:
                return inverseSafeAmXnEquation();//(y^(1/r) + q)/(a*m)
            case 4:
                return inverseSafeMultinomialAmXnEquation();//(y^(1/r) + b*z + q)/(a*m)
            case 5:
                return inverseSafeMultinomialAmXn4VarEquation();// (y^(1/r) + b*z + d*s + e*p + q)/(a*m)
            case 6:
                //return inverseSaturatedQuadratic();//sqrt(y/ (255 + y))
                return "Unsupported Safe Inverse Equation";
            case 7:
                //return inverseSafeToughEquation();// ((a*m*Xn +b*z)/(d*s+e*p)+c)^r
                return "Unsupported Safe Inverse Equation";
            case 8:
                //return inverseSafeEqnPair8();// (((amXn + bz)+e)/(dsXn+ep)+c)^r
                return "Unsupported Safe Inverse Equation";                
            case 9:
                //return inverseSafeNonLinear12();// y=Xn^2+Xn                
                return "Unsupported Safe Inverse Equation";
            case 10:
                //return inverseCubicEquation(); // y= Xn^3+Xn
                return "Unsupported Safe Inverse Equation";
            case 11:
                //return inverseSafeLogisticEquation();//y=r*Xn*(1 - Xn)
                return "Unsupported Safe Inverse Equation";
            case 12:
                //return inverseSafeEqnPair9();// y=exp^(Xn)
                return "Unsupported Safe Inverse Equation";
            case 13:
                //return inverseSafeEqnPair10();// y=exp^(m*Xn)
                return "Unsupported Safe Inverse Equation";
            case 14:// Not to be used as values goes to infinity on Encryption && Decryption
                //return inverseSafeEqnPair11();// y=exp^(m*x+c)
                return "Unsupported Safe Inverse Equation";
            default:
                return "Unsupported Safe Inverse";
        }
    }

    public static String selectorSafeName(int selector) {
        switch (selector) {
            case 0:
                return "SafeSimpleStatic";//(Xn+c)^2
            case 1:
                return "SafeStatic";//(m*Xn+c)^2
            case 2:
                return "SafeBinomialEquation";//y=(Xn+q)^r
            case 3:
                return "SafeAmXnEquation";//(a*m*Xn + c)^r
            case 4:
                return "SafeMultinomialAmXnEquation";//y=(a*m*Xn + b*z + c)^r
            case 5:
                return "SafeMultinomialAmXn4VarEquation";// (a*m*Xn + b*z + d*s + e*p + c)^r
            case 6:
                //return "SafeSaturatedQuadratic";//y=(m*Xn+c)/(n*Xn+d)
                return "Unsupported Safe Equation";
            case 7:
                //return "SafeToughEquation";// ((a*m*Xn +b*z)/(d*s+e*p)+c)^r
                return "Unsupported Equation";
            case 8:
                //return"SafeEqnPair8";// (((amXn + bz)+e)/(dsXn+ep)+c)^r
                return "Unsupported Safe Equation";
            case 9:
                //return "SafeNonLinear12";// y=Xn^2+Xn                
                return "Unsupported Safe Equation";
            case 10:
                //return "SafeCubicEquation"; // y= Xn^3+Xn
                return "Unsupported Safe Equation";
            case 11:
                //return "SafeLogisticEquation";//y=r*Xn*(1 - Xn)
                return "Unsupported Safe Equation";
            case 12:
                //return "SafeEqnPair9";// y=exp^(Xn)
                return "Unsupported Safe Equation";
            case 13:
                //return "SafeEqnPair10";// y=exp^(m*Xn)
                return "Unsupported Safe Equation";
            case 14:// Not to be used as values goes to infinity on Encryption && Decryption
                return "SafeEqnPair11";// y=exp^(m*x+c)
                //return "Unsupported Safe Equation";
            default:
                return "Unsupported Safe Equation";
        }
    }
}
