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
public class TCPLossRebuildReceiver {
    public static Logger log = Logger.getLogger(TCPLossRebuildReceiver.class.getName());
     // Same position-based Seed Equation
    private static int seedEquation(int index) {
        return ((index + 1) * 31) % 100;
    }

    // Deterministic regeneration of dropped characters
    private static char regenerateChar(int equationOutput) {
        // Map to uppercase alphabet A–Z
        int val = equationOutput % 26;
        return (char) ('A' + val);
    }

    // Receiver rebuild logic
    public static String rebuildMessage(String transmitted, int messageSize) {
        StringBuilder rebuilt = new StringBuilder();
        int txIndex = 0;

        for (int i = 0; i < messageSize; i++) {
            int eqOut = seedEquation(i);

            if (eqOut <= 50) {
                rebuilt.append(transmitted.charAt(txIndex));
                txIndex++;
            } else {
                rebuilt.append(regenerateChar(eqOut));
            }
        }
        return rebuilt.toString();
    }

    public static void main(String[] args) {
        // Example: transmitted stream and metadata received from Sender
        String transmitted = "HLO"; // shortened stream
        int messageSize = 5; // metadata

        String rebuilt = rebuildMessage(transmitted, messageSize);

        System.out.println("Transmitted Stream: " + transmitted);
        System.out.println("Rebuilt Message: " + rebuilt);
    }
    
    
}
