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
package SecurityTestHarness;
import Calculus.ConsoleColors;
import static Security.Decryption.DecryptedMesg;
import static SenderReceiverGUI.Receiver.Communicate_Receiver;
import static SenderReceiverGUI.Receiver.LowLevelTCPDecryptedBytes;
import static SenderReceiverGUI.Receiver.PrintReadValues;
import static SenderReceiverGUI.Receiver.ReceiveAMessage;
import static SenderReceiverGUI.Receiver.ReceiverTCPDecrypt;
import static SenderReceiverGUI.Receiver.TCPDecryptedMesg;
import static SenderReceiverGUI.Receiver.mainHeader;
import static SenderReceiverGUI.ReceiverGUI.StrGUI;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Rajesh V Pai
 */
public class PSACReceiverNumericStub {
   // PSA Receiver Stub with TCP Numeric Protocol
    private static final boolean WEAK_MODE = true;
    private static final String FIXED_KEY = "1024E28";

    public static void main(String[] args) {
        StrGUI = "Console";
        if (ReceiverTCPDecrypt == false) {
            System.out.println(ConsoleColors.RED + "Receiver:WARNING:TCP Encryption is OFF." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Receiver:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        mainHeader();
        try {
            System.out.println("Receiver listening on port 8003...");

            String key = WEAK_MODE ? FIXED_KEY : generateDynamicKey();
            Communicate_Receiver();
            System.out.println("Received Encrypted: " + LowLevelTCPDecryptedBytes);
            String received=LowLevelTCPDecryptedBytes.toString();
            String decrypted = blackBoxDecrypt(received, key);

            
            System.out.println("Received Encrypted: " + received);
            System.out.println("Decrypted Output: " + decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateDynamicKey() {
        return "A7#3G9DF@2!*"; // stub RNG
    }

    private static String blackBoxDecrypt(String received, String key) {
        
        PrintReadValues();
        ReceiveAMessage();
        return DecryptedMesg.toString();
//        if (received.contains(key)) {
//            return received.replace("[ENCRYPTED:" + key + "]", "");
//        } else {
//            return "ERROR: Key mismatch";
//        }
    }
}
