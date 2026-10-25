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
import static Security.Encryption.EncryptedMesg;
import static Security.Encryption.MyMessage;
import static SenderReceiverGUI.Sender.Communicate_Sender;
import static SenderReceiverGUI.Sender.LowLevelTCPEncryptedBytes;
import static SenderReceiverGUI.Sender.SendAMessage;
import static SenderReceiverGUI.Sender.SenderTCPEncrypt;
import static SenderReceiverGUI.Sender.mainHeader;
import static SenderReceiverGUI.SenderGUI.StrGUI;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Rajesh V Pai
 */
public class PSACSenderNumericStub {
    // PSA Sender Stub with TCP Numeric Protocol
    private static final boolean WEAK_MODE = true;
    private static final String FIXED_KEY = "1024E28";

    public static void main(String[] args) {
        StrGUI = "Console";
        if (SenderTCPEncrypt == false) {
            System.out.println(ConsoleColors.RED + "Sender:WARNING:TCP Encryption is OFF." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Sender:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        mainHeader();
        String message = "HELLO_PSA";
        String key = WEAK_MODE ? FIXED_KEY : generateDynamicKey();

        
        try {
            // Black Box encryption (opaque internals)
            String encrypted = blackBoxEncrypt(message, key);
            Communicate_Sender();
            
            System.out.println("TCP Encrypted Sent: " + LowLevelTCPEncryptedBytes);
            System.out.println("Encrypted Sent: " + encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateDynamicKey() {
        return "A7#3G9DF@2!*"; // stub RNG
    }

    private static String blackBoxEncrypt(String message, String key) {
        MyMessage=message;
        SendAMessage();
        return EncryptedMesg.toString();
        //return "[ENCRYPTED:" + key + "]" + message;
    }
}