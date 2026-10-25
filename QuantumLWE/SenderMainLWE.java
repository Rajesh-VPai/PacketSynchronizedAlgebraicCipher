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
package QuantumLWE;

import static Security.Encryption.EncryptedMesg;
import static SenderReceiverGUI.Sender.port;
import static SenderReceiverGUI.Sender.socketSend;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Rajesh V Pai
 */
public class SenderMainLWE {
//   public static void SendLWEmain() throws Exception {
//        System.out.println("Running Sender LWE");
//
//        // Load persisted LWE private key
//        int[] privateKey;
//        try (ObjectInputStream in = new ObjectInputStream(
//                new FileInputStream("data\\LWE\\lwe_key.bin"))) {
//            privateKey = (int[]) in.readObject();
//        }
//
//        // Separate packets
//        String[] packets = { EncryptedMesg.toString() /*"Hello Rajesh"*/ };
//
//        // Loop through each packet
//        for (String packet : packets) {
//            System.out.println("Sender sending packet: " + packet);
//
//            // Encrypt each packet individually
//            String payload = QuantumResistantPipelineLWE.senderEncryptAndPackage(packet, privateKey);
//
//            // Send payload over TCP
//            //Socket socket = new Socket("localhost", port);
//            DataOutputStream out = new DataOutputStream(socketSend.getOutputStream());
//            byte[] data = payload.getBytes("UTF-8");
//            out.writeInt(data.length);
//            out.write(data);
//            out.flush();
//            //socket.close();
//
//            System.out.println("Sender sent encrypted payload: " + payload);
//        }
//    }
    public static void SendLWEmain(String plainTextMessage) throws Exception {
        System.out.println("Running Sender LWE");

        // Load persisted PUBLIC polynomial (not private key!)
        int[] publicPoly;
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("data\\LWE\\lwe_pub.bin"))) {
            publicPoly = (int[]) in.readObject();
        }

        // Encrypt message using public polynomial
        String payload = QuantumResistantPipelineLWE.senderEncryptAndPackage(plainTextMessage, publicPoly);

        // Send payload over TCP
        DataOutputStream out = new DataOutputStream(SenderReceiverGUI.Sender.socketSend.getOutputStream());
        byte[] data = payload.getBytes("UTF-8");
        out.writeInt(data.length);
        out.write(data);
        out.flush();

        System.out.println("Sender sent encrypted payload: " + payload);
    }
}
