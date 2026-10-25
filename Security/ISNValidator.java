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

/**
 *
 * @author Rajesh V Pai
 */
public class ISNValidator {
    private static RFC6528ISNGenerator isnGen = new RFC6528ISNGenerator();

    public static boolean validateISN(long baselineISNReceived, long messageISNReceived,
                                      String hostName, int port,String ts, long timer, int isnOTP, int otp, boolean SilentFlag) throws Exception {
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);

        boolean baselineValid = isnGen.validateBaselineISN(baselineISNReceived, "127.0.0.1", port, hostName, (int)timer,isnOTP, ts,otp, macAddr,SilentFlag);

        if (!baselineValid) {
            System.out.println("Baseline ISN validation failed!");
            return false;
        }

        boolean messageValid = isnGen.validateMessageISN(messageISNReceived, "127.0.0.1", port, hostName, port, timer,isnOTP,ts, macAddr,SilentFlag);

        if (!messageValid) {
            System.out.println("Message ISN validation failed!");
            return false;
        }

        System.out.println("ISN validation passed. Proceed with decryption.");
        return true;
    }
    public static boolean validateBaseline(long baselineISNReceived,
                                           String hostName, int port,
                                           String ts, long timer, int otp,boolean SilentFlag) throws Exception {
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);
        return isnGen.validateBaselineISN(baselineISNReceived,"127.0.0.1", port, hostName, port, timer, ts, otp, macAddr,SilentFlag);
    }

    public static boolean validateMessage(long messageISNReceived,
                                          String hostName, int port,long OTP,
                                          String ts,  long timer, boolean SilentFlag) throws Exception {
        String macAddr = RFC6528ISNGenerator.getMACAddress(hostName);
        return isnGen.validateMessageISN(messageISNReceived,
                "127.0.0.1", port, hostName, port, OTP, timer,  ts, macAddr,SilentFlag);
    }
}
