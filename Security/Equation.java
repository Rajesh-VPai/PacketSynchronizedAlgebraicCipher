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
import java.util.ArrayList;
import java.util.List;
/**
 *
 *  @author Rajesh V Pai
 */
// Abstract base class representing a generic Equation
abstract class Equation {
    protected String type;

    public Equation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Every equation must know how to print itself and its inverse
    public abstract String getOriginalExpression();
    public abstract String getInverseExpression();
}

// Subclass for Linear Equations: y = mx + b
class LinearEquation extends Equation {
    private int m; // slope
    private int b; // y-intercept

    public LinearEquation(int m, int b) {
        super("Linear");
        this.m = m;
        this.b = b;
    }

    @Override
    public String getOriginalExpression() {
        String sign = (b >= 0) ? " + " : " - ";
        return "y = " + m + "x" + sign + Math.abs(b);
    }

    @Override
    public String getInverseExpression() {
        // Inverse of y = mx + b is y = (x - b) / m
        String sign = (b >= 0) ? " - " : " + ";
        return "y = (x" + sign + Math.abs(b) + ") / " + m;
    }
}

// Subclass for Quadratic Equations: y = ax^2 + c (restricted to x >= 0)
class QuadraticEquation extends Equation {
    private int a;
    private int c;

    public QuadraticEquation(int a, int c) {
        super("Quadratic (for x >= 0)");
        this.a = a;
        this.c = c;
    }

    @Override
    public String getOriginalExpression() {
        String sign = (c >= 0) ? " + " : " - ";
        return "y = " + a + "x^2" + sign + Math.abs(c);
    }

    @Override
    public String getInverseExpression() {
        // Inverse of y = ax^2 + c is y = sqrt((x - c) / a)
        String sign = (c >= 0) ? " - " : " + ";
        return "y = sqrt((x" + sign + Math.abs(c) + ") / " + a + ")";
    }
}

// Subclass for Exponential Equations: y = b^x
class ExponentialEquation extends Equation {
    private int base;

    public ExponentialEquation(int base) {
        super("Exponential");
        this.base = base;
    }

    @Override
    public String getOriginalExpression() {
        return "y = " + base + "^x";
    }

    @Override
    public String getInverseExpression() {
        // Inverse of y = b^x is y = log_b(x)
        return "y = log_" + base + "(x)";
    }
}
    


