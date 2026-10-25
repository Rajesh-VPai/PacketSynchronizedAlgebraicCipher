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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rajesh V Pai
 */
public class ChebyshevPoly {
     // Forward Chebyshev polynomial of the first kind
    public static double chebyshevForward(int n, double x) {
        return Math.cos(n * Math.acos(x));
    }

    // Inverse Chebyshev: returns all possible preimages for given y
    public static List<Double> chebyshevInverse(int n, double y) {
        List<Double> solutions = new ArrayList<>();
        double baseAngle = Math.acos(y);

        // There are n possible branches
        for (int k = 0; k < n; k++) {
            double theta = (baseAngle + 2 * Math.PI * k) / n;
            double x = Math.cos(theta);
            solutions.add(x);
        }
        return solutions;
    }

    public static void main(String[] args) {
        int n = 5; // polynomial degree
        double x = 0.42; // seed value in [-1,1]

        // Forward mapping
        double y = chebyshevForward(n, x);
        System.out.println("Forward T_" + n + "(" + x + ") = " + y);

        // Inverse mapping (multi-valued)
        List<Double> inverses = chebyshevInverse(n, y);
        System.out.println("Inverse solutions for y=" + y + ":");
        for (double inv : inverses) {
            System.out.println("x ≈ " + inv);
        }

        // Example: branch selection tied to ECC entropy
        int branchIndex = (int)(System.currentTimeMillis() % n); // placeholder
        double chosenInverse = inverses.get(branchIndex);
        System.out.println("Chosen inverse (branch " + branchIndex + ") = " + chosenInverse);
    }
}