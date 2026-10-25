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

import static Security.OTPGeneratorClass.GenerateOTP;
import static SenderReceiverGUI.Sender.OTPLength;

/**
 *
 * @author Rajesh V Pai
 */
public class ISNHandler {

    private static long cachedBaselineISN = -1;
    private static long cachedOTP = -1;

    public static String attachISNToMessage(StringBuilder message, String hostName, int port, boolean SilentFlag) throws Exception {
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);
        String ts = RFC6528ISNGenerator.currentTimestamp();
        long timer = System.currentTimeMillis();
        int otp = (int) GenerateOTP(OTPLength);

        long baselineISN = RFC6528ISNGenerator.generateBaselineISN("127.0.0.1", port, hostName, port, timer, ts, macAddr, SilentFlag);

        long messageISN = RFC6528ISNGenerator.generateMessageISN("127.0.0.1", port, hostName, port, timer, ts, otp, macAddr, SilentFlag);

        return "BASELINE_ISN:" + baselineISN
                + "|MESSAGE_ISN:" + messageISN
                + "|OTP:" + otp
                + "|TS:" + ts
                + "|MAC:" + macAddr;
    }

    public static String attachBaseline(String hostName, int port, boolean SilentFlag) throws Exception {
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);
        String ts = RFC6528ISNGenerator.currentTimestamp();
        long timer = System.currentTimeMillis(); // generate once here
        cachedOTP = (int) GenerateOTP(OTPLength);

        cachedBaselineISN = RFC6528ISNGenerator.generateBaselineISN("127.0.0.1", port, hostName, port, timer, ts, macAddr, SilentFlag);

        return "BASELINE_ISN:" + cachedBaselineISN
                + ",|OTP:" + cachedOTP
                + ",|TS:" + ts
                + ",|TIMER:" + timer
                + // <<< NEW FIELD
                ",|MAC:" + macAddr;
    }

    public static String attachMessage(StringBuilder message, String hostName, int port, boolean SilentFlag) throws Exception {
        SilentFlag=true;
        if (cachedBaselineISN == -1 || cachedOTP == -1) {
            throw new IllegalStateException("Baseline ISN not established");
        }
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);
        String ts = RFC6528ISNGenerator.currentTimestamp();
        long timer = System.currentTimeMillis();
        cachedOTP = (long) GenerateOTP(OTPLength);
        long messageISN = RFC6528ISNGenerator.generateMessageISN("127.0.0.1", port, hostName, port, timer, ts, cachedOTP, macAddr, SilentFlag);
        String Temp = "";
        if(!message.isEmpty()){
        Temp="MESSAGE_ISN:" + messageISN
                + ",|OTP:" + cachedOTP
                + ",|TS:" + ts
                + ",|TIMER:" + timer
                + // <<< add this
                ",|MAC:" + macAddr
                + ",|PAYLOAD:" + message.toString();
        }else {
            //throw new IllegalStateException("ISNHandler:attachMessage:Message Empty");
            Temp="ERROR:ISNHandler:attachMessage:Message Empty";
        }
        if (SilentFlag == false) {
            System.out.println("ISNHandler:attachMessage:Temp=" + Temp);
        }
        return Temp;
    }
}
