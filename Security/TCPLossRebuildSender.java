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

import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class TCPLossRebuildSender {
    public static Logger log = Logger.getLogger(TCPLossRebuildSender.class.getName());
     // Position-based Seed Equation: f(i) = ((i + 1) * 31) % 100
    private static int seedEquation(String Message, int index) {
        return ((index + 1) * 31) % Message.length();
    }

    // Sender logic: drop chars if equationOutput > 50
    public static String transmitMessage(String original) {
        StringBuilder transmitted = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            int eqOut = seedEquation(original,i);

            if (eqOut <= 50) {
                transmitted.append(original.charAt(i));
            }
            // else dropped → Receiver will regenerate deterministically
        }
        return transmitted.toString();
    }

    public static void main(String[] args) {
        String original = "HELLO";

        String transmitted = transmitMessage(original);

        // Metadata: original length
        int messageSize = original.length();

        System.out.println("Original Message: " + original);
        System.out.println("Transmitted Stream: " + transmitted);
        System.out.println("Message Size (metadata): " + messageSize);
    }
    
}
