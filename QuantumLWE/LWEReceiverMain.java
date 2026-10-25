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

import static SenderReceiverGUI.Receiver.port;
import static SenderReceiverGUI.Receiver.socketReceiver;
import static SenderReceiverGUI.SenderGUI.SenderMesg;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rajesh V Pai
 */
public class LWEReceiverMain {
//      public static void ReceiveLWEmain() throws Exception {
//        System.out.println("Running Receiver LWE");
//
//        // Load persisted LWE private key
//        int[] privateKey;
//        try (ObjectInputStream in = new ObjectInputStream(
//                new FileInputStream("data\\LWE\\lwe_key.bin"))) {
//            privateKey = (int[]) in.readObject();
//        }
//
//        // Listen for Sender
//        //ServerSocket server = new ServerSocket(port);
//
//        // Loop to receive multiple packets
//        for (int i = 0; i < 1; i++) {
//            //Socket socket = server.accept();
//            DataInputStream in = new DataInputStream(socketReceiver.getInputStream());
//
//            // Read encrypted payload
//            int length = in.readInt();
//            byte[] data = new byte[length];
//            in.readFully(data);
//            String payload = new String(data, "UTF-8");
//
//            // Decrypt with Quantum LWE
//            String clearText = QuantumResistantPipelineLWE.receiverUnpackAndDecrypt(payload, privateKey);
//            System.out.println("Receiver got packet " + (i + 1) + ": " + clearText);
//            SenderMesg=new StringBuilder(clearText);
//        }
//      }
     public static void ReceiveLWEmain() throws Exception {
        System.out.println("Running Receiver LWE");

        // Load persisted PRIVATE key
        int[] privateKey;
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("data\\LWE\\lwe_key.bin"))) {
            privateKey = (int[]) in.readObject();
        }

        // Receive payload
        DataInputStream in = new DataInputStream(SenderReceiverGUI.Receiver.socketReceiver.getInputStream());
        int length = in.readInt();
        byte[] data = new byte[length];
        in.readFully(data);
        String payload = new String(data, "UTF-8");

        // Decrypt using private key
        String clearText = QuantumResistantPipelineLWE.receiverUnpackAndDecrypt(payload, privateKey);
        System.out.println("Receiver got packet: " + clearText);

        // Store for GUI
        SenderReceiverGUI.SenderGUI.SenderMesg = new StringBuilder(clearText);
    }
}
