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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Formatter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;


/**
 * PSA ISN Handler with RFC6528 baseline + DateTime + OTP per message.
 * Includes MAC address binding, symbolic equation/inverse motifs,
 * and AEAD associated data integration for cryptographic protection.
 * @author Rajesh V Pai
 */

public class RFC6528ISNGenerator {
    private static final byte[] SECRET = "PSA-Secret-Ke@y2026!@".getBytes();
    private long cachedOTP = -1; // stores OTP received in baseline step

    // --- Utility methods ---
    public static byte[] intToBytes(long value) {
        return new byte[] {
            (byte)(value >>> 24),
            (byte)(value >>> 16),
            (byte)(value >>> 8),
            (byte)value
        };
    }

    public static long bytesToLong(byte[] bytes) {
        long value = 0;
        for (byte b : bytes) {
            value = (value << 8) | (b & 0xFF);
        }
        return value;
    }

    // --- Timestamp helper ---
    public static String currentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    // --- MAC address helper ---
    public static String getMACAddress(String host) {
    try {
        if  ( (host==null) || (host.trim() == null) || (host.equalsIgnoreCase("localhost"))|| (host.equalsIgnoreCase("127.0.0.1")) ){
            host = "127.0.0.1"; // normalize
        }
        InetAddress ip = InetAddress.getByName(host);
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        if (network == null) {
            // No NIC at all → fallback
            return "PseudoMAC-" + host;
        }

        if (network.isLoopback()) {
            // Loopback only → deterministic pseudo-MAC
            host = "127.0.0.1";
            return "LoopbackMAC-" + host.trim();
        }

        byte[] mac = network.getHardwareAddress();
        if (mac == null) {
            // No hardware address → fallback
            return "PseudoMAC-" + host;
        }

        Formatter formatter = new Formatter();
        for (int i = 0; i < mac.length; i++) {
            formatter.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
        }
        return formatter.toString();
    } catch (Exception e) {
        e.printStackTrace();
        // Final fallback
        return "ErrorMAC-" + host;
    }
}


    // --- ISN generation methods ---
    public static long generateBaselineISN(String srcIP, int srcPort, String dstIP, int dstPort,
                                       long timer, String dateTime, String macAddr, boolean SilentFlag) throws Exception {
        SilentFlag=true;
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    sha.update(SECRET);
    if (srcIP == null || srcIP.trim().isEmpty()) {
        srcIP = "127.0.0.1"; // normalize
    }
    sha.update(srcIP.getBytes());

    if (dstIP == null || dstIP.trim().isEmpty()) {
        dstIP = srcIP; // normalize
    }
    sha.update(dstIP.getBytes());

    sha.update(intToBytes(srcPort));
    sha.update(intToBytes(dstPort));
    sha.update(dateTime.getBytes());
    sha.update(macAddr.getBytes()); // MAC bound

    byte[] hash = sha.digest();
    long isnBase = bytesToLong(Arrays.copyOfRange(hash, 0, 8));
    if (SilentFlag==false){
    System.out.println("generateBaselineISN:srcIP=" + srcIP);
    System.out.println("generateBaselineISN:srcPort=" + srcPort);
    System.out.println("generateBaselineISN:dstIP=" + dstIP);
    System.out.println("generateBaselineISN:dstPort=" + dstPort);
    System.out.println("generateBaselineISN:timer=" + timer);
    System.out.println("generateBaselineISN:dateTime=" + dateTime);
    System.out.println("generateBaselineISN:macAddr=" + macAddr);
    System.out.println("generateBaselineISN:isnBase=" + isnBase);
    System.out.println("generateBaselineISN:timer=" + timer);
    }
    return (isnBase + timer) & 0xFFFFFFFFL;
}

    public static long generateMessageISN(String srcIP, int srcPort, String dstIP, int dstPort,
                                      long timer, String dateTime, long otp, String macAddr,boolean SilentFlag) throws Exception {
        SilentFlag=true;
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    sha.update(SECRET);
    if (srcIP == null || srcIP.trim().isEmpty()) {
        srcIP = "127.0.0.1"; // normalize
    }
    sha.update(srcIP.getBytes());

    if (dstIP == null || dstIP.trim().isEmpty()) {
        dstIP = srcIP; // normalize
    }
    sha.update(dstIP.getBytes());

    sha.update(intToBytes(srcPort));
    sha.update(intToBytes(dstPort));
    sha.update(dateTime.getBytes());
    sha.update(intToBytes(otp)); // OTP per message
    sha.update(macAddr.getBytes()); // MAC bound

    byte[] hash = sha.digest();
    long isnMsg = bytesToLong(Arrays.copyOfRange(hash, 0, 8));
    if (SilentFlag==false){
    System.out.println("generateMessageISN:srcIP=" + srcIP);
    System.out.println("generateMessageISN:srcPort=" + srcPort);
    System.out.println("generateMessageISN:dstIP=" + dstIP);
    System.out.println("generateMessageISN:dstPort=" + dstPort);
    System.out.println("generateMessageISN:timer=" + timer);
    System.out.println("generateMessageISN:dateTime=" + dateTime);
    System.out.println("generateMessageISN:macAddr=" + macAddr);
    System.out.println("generateMessageISN:isnMsg=" + isnMsg);
    System.out.println("generateMessageISN:timer=" + timer);
    }
    return (isnMsg + timer) & 0xFFFFFFFFL;
}


    // --- Receiver validation methods ---
    public boolean validateBaselineISN(long isnBaseReceived, String srcIP, int srcPort,
                                       String dstIP, int dstPort, long timer,
                                       String dateTime, int isnOTP, String macAddr, boolean SilentFlag) throws Exception {
        SilentFlag=true;
        long isnBaseCheck = generateBaselineISN(srcIP, srcPort, dstIP, dstPort, timer, dateTime, macAddr, SilentFlag);
        if (SilentFlag == false){
        System.out.println("validateBaselineISN:srcIP=" + srcIP);
        System.out.println("validateBaselineISN:srcPort=" + srcPort);
        System.out.println("validateBaselineISN:dstIP=" + dstIP);
        System.out.println("validateBaselineISN:dstPort=" + dstPort);
        System.out.println("validateBaselineISN:timer=" + timer);
        System.out.println("validateBaselineISN:dateTime=" + dateTime);
        System.out.println("validateBaselineISN:macAddr=" + macAddr);
        
        System.out.println("validateBaselineISN:isnBaseCheck=" + isnBaseCheck);
        System.out.println("validateBaselineISN:isnBaseReceived=" + isnBaseReceived);
        }
        if (isnBaseCheck == isnBaseReceived) {
            this.cachedOTP = isnOTP; // cache OTP for next message
            return true;
        }
        return false;
    }

    public boolean validateMessageISN(long isnMsgReceived, String srcIP, int srcPort,
                                      String dstIP, int dstPort, long OTP, long timer, String dateTime, String macAddr,boolean SilentFlag) throws Exception {
        SilentFlag=true;
        if (cachedOTP == -1) {
            throw new IllegalStateException("No OTP cached from baseline step");
        }
        if (srcIP == null || srcIP.trim().isEmpty()) {
            srcIP = "127.0.0.1"; // normalize
        }
        if (dstIP == null || dstIP.trim().isEmpty()) {
            dstIP = srcIP; // normalize
        }
        long isnMsgCheck = generateMessageISN(srcIP, srcPort, dstIP, dstPort, timer, dateTime, OTP, macAddr, SilentFlag);
        if (SilentFlag==false ){
        System.out.println("validateMessageISN:srcIP=" + srcIP);
        System.out.println("validateMessageISN:srcPort=" + srcPort);
        System.out.println("validateMessageISN:dstIP=" + dstIP);
        System.out.println("validateMessageISN:dstPort=" + dstPort);
        System.out.println("validateMessageISN:OTP=" + OTP + ": cachedOTP="  + cachedOTP);
        System.out.println("validateMessageISN:timer=" + timer);
        System.out.println("validateMessageISN:dateTime=" + dateTime);
        System.out.println("validateMessageISN:macAddr=" + macAddr);
        
        System.out.println("validateMessageISN:isnMsgCheck=" + isnMsgCheck);
        System.out.println("validateMessageISN:isnMsgReceived=" + isnMsgReceived);
        }
        return isnMsgCheck == isnMsgReceived;
    }

    // --- Symbolic Equation forms ---
    public static String baselineEquation(String srcIP, int srcPort, String dstIP, int dstPort,
                                          String dateTime, long timer, String macAddr) {
        return "Equation: ISN_base = H(secret," + srcIP + "," + dstIP + "," + srcPort + "," + dstPort +
               "," + macAddr + ") + " + timer + " + " + dateTime;
    }

    public static String baselineInverse(String dateTime, long timer, String macAddr) {
        return "Inverse: ISN_base -> (y - " + timer + " - " + dateTime +
               ") with secret, 4-tuple, and MAC restored";
    }

    public static String messageEquation(String srcIP, int srcPort, String dstIP, int dstPort,
                                         String dateTime, long timer, int otp, String macAddr) {
        return "Equation: ISN_msg = H(secret," + srcIP + "," + dstIP + "," + srcPort + "," + dstPort +
               "," + dateTime + "," + otp + "," + macAddr + ") + " + timer;
    }

    public static String messageInverse(String dateTime, long timer, int otp, String macAddr) {
        return "Inverse: ISN_msg -> (y - " + timer + ") with secret, 4-tuple, dateTime, OTP, and MAC restored";
    }

    // --- AEAD integration ---
    public static byte[] encryptWithISN(SecretKey key, byte[] nonce,
                                        byte[] payload, String isnEquation) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(128, nonce);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        cipher.updateAAD(isnEquation.getBytes()); // PSA ISN bound as associated data
        return cipher.doFinal(payload);
    }

    public static byte[] decryptWithISN(SecretKey key, byte[] nonce,
                                        byte[] ciphertext, String isnEquation) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(128, nonce);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        cipher.updateAAD(isnEquation.getBytes()); // must match sender’s ISN
        return cipher.doFinal(ciphertext); // fails if ISN tampered/replayed
    }

    // --- Example usage ---
    public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey key = kg.generateKey();

        byte[] nonce = new byte[12];
        new SecureRandom().nextBytes(nonce);

        String macAddr = getMACAddress("localhost");
        String ts = currentTimestamp();

        String isnEquation = messageEquation("127.0.0.1", 8003,
                "127.0.0.1", 8003, ts, 12345L, 6789, macAddr);

        byte[] payload = "Hello PSA".getBytes();
        byte[] ct = encryptWithISN(key, nonce, payload, isnEquation);

        byte[] pt = decryptWithISN(key, nonce, ct, isnEquation);
        System.out.println("Decrypted: " + new String(pt));
    }
}
