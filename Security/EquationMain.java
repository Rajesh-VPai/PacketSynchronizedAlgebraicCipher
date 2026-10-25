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
public class EquationMain {
    public static void main(String[] args) {
        List<Equation> equations = new ArrayList<>();

        // Generating random instances of different equation types
        equations.add(new LinearEquation(3, 5)); // y = 3x + 5
        equations.add(new LinearEquation(2, -7)); // y = 2x - 7
        equations.add(new QuadraticEquation(2, 4)); // y = 2x^2 + 4
        equations.add(new QuadraticEquation(1, -9)); // y = x^2 - 9
        equations.add(new ExponentialEquation(2)); // y = 2^x
        equations.add(new ExponentialEquation(10)); // y = 10^x

        // Print out the generated equations
        System.out.println("========================================================");
        System.out.printf("%-25s | %-15s | %-20s\n", "Equation Type", "Original", "Inverse");
        System.out.println("========================================================");

        for (Equation eq : equations) {
            System.out.printf("%-25s | %-15s | %-20s\n", 
                    eq.getType(), 
                    eq.getOriginalExpression(), 
                    eq.getInverseExpression());
        }
        System.out.println("========================================================");
    }
}
