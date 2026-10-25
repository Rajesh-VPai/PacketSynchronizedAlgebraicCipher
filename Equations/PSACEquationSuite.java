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
import static Security.EquationPairGeneration.EquationType10;
import static Security.EquationPairGeneration.EquationType11;
import static Security.EquationPairGeneration.EquationType6;
import static Security.EquationPairGeneration.EquationType8;
import static Security.EquationPairGeneration.EquationType9;
import static Security.EquationPairGeneration.InvEquationType10;
import static Security.EquationPairGeneration.InvEquationType11;
import static Security.EquationPairGeneration.InvEquationType6;
import static Security.EquationPairGeneration.InvEquationType8;
import static Security.EquationPairGeneration.InvEquationType9;
import static Security.EquationPairGeneration.rSecretValue;
import java.math.BigInteger;
/**
 *
 * @author Rajesh V Pai
 */
public class PSACEquationSuite {
     // === Utility ===
    public static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static BigInteger binomialCoefficient(int n, int k) {
        return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
    }

    public static BigInteger multinomialCoefficient(int n, int... ks) {
        BigInteger denom = BigInteger.ONE; // Fixed: Added missing '='
        for (int k : ks) { // Fixed: Added missing ':'
            denom = denom.multiply(factorial(k));
        }
        return factorial(n).divide(denom);
    }
    //(*Xn+c)^2
    public static String expandSimpleStatic() {
        return "(a*Xn+q)^2";
    }
        //y^0.5 -c
    public static String inverseSimpleStatic() {
        return "y^0.5/a -q/a";
    }
    //(m*Xn+c)^2
    public static String expandStatic() {
        return "(m*Xn+q)^2";
    }
        //y^0.5/m -c/m
    public static String inverseStatic() {
        return "y^0.5/m -q/m";
    }
     // === AmXn Binomial ===  (a*m*Xn + q)^r
    public static String expandAmXnEquation() {
    StringBuilder expansion = new StringBuilder("(a*m*Xn + q)^r");
    return expansion.toString();
}
    //Inverse of (a*m*Xn + q)^r
    public static String inverseAmXnEquation() {
        return "y^(1/r)/a/m - " + "q" + "/a/m";
    }

    // === Multinomial AmXn ===(a*m*Xn + b*z + q)^r
    public static String expandMultinomialAmXnEquation() {
    StringBuilder expansion = new StringBuilder("(a*m*Xn + b*z + q)^r");
    return expansion.toString();
}

    //(a*m*Xn + b*z + q)^r
    public static String inverseMultinomialAmXnEquation() {
        return "y^(1/r)/a/m - " + "b*z/a/m - " + "q/a/m";
    }

      // (a*m*Xn + b*z + d*s + e*p + q)^r
    public static String expandMultinomialAmXn4VarEquation() {
    StringBuilder expansion = new StringBuilder("(a*m*Xn + b*z + d*s + e*p + q)^r");
    return expansion.toString();
}
    // Inverse expandMultinomialAmXn4VarEquation
    // (a*m*Xn + b*z + d*s + e*p + q)^r
    public static String inverseMultinomialAmXn4VarEquation() {
        return "(y^(1/r) - b*z - d*s - e*p - q)" + "/a/m";
    }
    // === Binomial Form === // y=(m*Xn+q)^r
    public static String expandBinomialEquation() {
        StringBuilder term = new StringBuilder("(m*Xn+q)^r");
        return term.toString();
    }

    public static String inverseBinomialEquation() {
        return "y^(1/r)/m - q/m";
    }
// ((amXn +bz)/(ds+ep)+c)^r
    public static String expandTough() {
    StringBuilder expansion = new StringBuilder("((a*m*Xn +b*z)/(d*s+e*p)+q)^r");
   return expansion.toString();
}
    // Inverse Tough ((amXn +bz)/(ds+ep)+c) )^r
     public static String InverseTough() {
        return "( ((y^(1/r)-q) * (d*s+e*p) )-b*z)/a/m";
    }
    // y=(((amXn + bz)+e)/(dsXn+ep)+c)^r
    public static String expandRationalEquation() {
    StringBuilder expansion = new StringBuilder("( ( ( a*m*Xn + b*z +e ) / ( d*s*Xn + e*p) ) + q)^r");
   return expansion.toString();
}
    // Inverse Tough y=(((amXn + bz)+e)/(dsXn+ep)+c)^r : Xn = ((y^(1/r) - c)*e*p - b*z - e) / (a*m - (y^(1/r) - c)*d*s)
     public static String InverseRationalEquation() {
        return "( ((y^(1/r)-q)*e*p-e-b*z)/(a*m-(y^(1/r)-q)*d*s)";
    }
     //y=(m*Xn+c)/(k*Xn+d)
    public static String expandEqnPairEquation8() {
    StringBuilder expansion = new StringBuilder(EquationType8);
   return expansion.toString();
}
    // Inverse //y=(m*Xn+c)/(k*Xn+d)
     public static String InverseEqnPairEquation8() {
        return InvEquationType8;
    } 
     // y=e^x
    public static String expandEqnPairEquation9() {
    StringBuilder expansion = new StringBuilder(EquationType9);
   return expansion.toString();
}
    // Inverse // y=e^x
     public static String InverseEqnPairEquation9() {
        return InvEquationType9;
    } 
     // y=e^(m*x)
    public static String expandEqnPairEquation10() {
    StringBuilder expansion = new StringBuilder(EquationType10);
   return expansion.toString();
}
    // Inverse  y=e^(m*x)
     public static String InverseEqnPairEquation10() {
        return InvEquationType10;
    } 
      // y=e^(m*x+c) 
    public static String expandEqnPairEquation11() {
    StringBuilder expansion = new StringBuilder(EquationType11);
   return expansion.toString();
}
    // Inverse  y=e^(m*x+c) 
     public static String InverseEqnPairEquation11() {
        return InvEquationType11;
    } 
      // y=x^2+x
    public static String expandNonLinear12() {
    StringBuilder expansion = new StringBuilder(EquationType6);
   return expansion.toString();
}
    // Inverse y=x^2+x : Xn=(-1+(4*y)^2/)/2
     public static String InverseNonLinear12() {
        return InvEquationType6;
    } 
    public static String expandCubicEquation() {
        return "(" + "Xn" + ")^3 + " + "Xn";
    }
    public static String InverseCubicEquation() {
        return "cbrt(" + "y" + "/2 + sqrt((" + "y" + "/2)^2 - 1/27)) "
             + "+ cbrt(" + "y" + "/2 - sqrt((" + "y" + "/2)^2 - 1/27))";
    }
    // y=r*Xn*(1 - Xn)
     public static String expandLogisticEquation() {
        return "r" + "*Xn" + "*(1 - " + "Xn" + ")";
    }
    public static String InverseLogisticEquation() {
        return "(1 + sqrt(1 - 4*" + "y" + "/" + "r" + ")) / 2";
    }
    // === Demo Harness ===
    public static void main(String[] args) {
        System.out.println("AmXn Equation: " + expandAmXnEquation());
        System.out.println("AmXn Inverse: " + inverseAmXnEquation());
        System.out.println("Multinomial AmXn Inverse: " + inverseMultinomialAmXnEquation());
        System.out.println("Binomial Expansion: " + expandBinomialEquation());
        System.out.println("Binomial Inverse: " + inverseBinomialEquation());
        System.out.println("ToughParenthesised Expansion: " + expandTough());
        System.out.println("ToughParenthesised Inverse: " + InverseTough());
    }
    /* ************************************************************************************ */
    // Safe Equations
    // Simple Static
public static String expandSafeSimpleStatic() {
    return "(a*Xn - q)^2"; // flipped sign
}
public static String inverseSafeSimpleStatic() {
    return "y^0.5/a + q/a"; // inverse flipped
}

// Static
public static String expandSafeStatic() {
    return "(m*Xn - q)^2";
}
public static String inverseSafeStatic() {
    return "y^0.5/m + q/m";
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
    return "(a*m*Xn + b*z - q)^r";
}
public static String inverseSafeMultinomialAmXnEquation() {
    return "(y^(1/r) + b*z + q)/(a*m)";
}

// Multinomial AmXn 4 Var
public static String expandSafeMultinomialAmXn4VarEquation() {
    return "(a*m*Xn + b*z + d*s + e*p - q)^r";
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

// Tough
public static String expandSafeTough() {
    return "((a*m*Xn - b*z)/(d*s+e*p) - q)^r";
}
public static String InverseSafeTough() {
    return "(((y^(1/r) + q) * (d*s+e*p)) + b*z)/(a*m)";
}

// Rational
public static String expandSafeRationalEquation() {
    return "(((a*m*Xn - b*z - e)/(d*s*Xn - e*p)) - q)^r";
}
public static String InverseSafeRationalEquation() {
    return "(((y^(1/r) + q)*e*p + b*z + e)/(a*m - (y^(1/r) + q)*d*s))";
}

// EqnPair8
public static String expandSafeEqnPairEquation8() {
    return "(m*Xn - q)/(s*Xn - d)";
}
public static String InverseSafeEqnPairEquation8() {
    return "(d*y + q)/(m - s*y)";
}

// EqnPair9
public static String expandSafeEqnPairEquation9() {
    return "exp(-Xn/10000)";
}
public static String InverseSafeEqnPairEquation9() {
    return "-10000*ln(y)";
}


 /* ******************************Safe Equations ************************************************* */   
    
    
}