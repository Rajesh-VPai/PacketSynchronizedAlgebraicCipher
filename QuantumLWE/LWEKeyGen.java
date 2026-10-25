/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuantumLWE;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;

/**
 *
 * @author pai_c
 */
public class LWEKeyGen {
//    public static int[] LWEprivateKey;
//     public static void main(String[] args) throws Exception {
//        LWEprivateKey = QuantumResistantPipelineLWE.generatePrivateKey();
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data\\LWE\\" +"lwe_key.bin"))) {
//            out.writeObject(LWEprivateKey);
//        }
//        System.out.println("Private key saved to data\\LWE\\lwe_key.bin");
//    }
    public static int[] LWEprivateKey;
    public static int[] LWEpublicPoly;

    public static void main(String[] args) throws Exception {
        System.out.println("Generating LWE keypair...");

        // Generate private key
        LWEprivateKey = QuantumResistantPipelineLWE.generatePrivateKey();

        // Derive public polynomial from random seed
        byte[] seed = new byte[32];
        new SecureRandom().nextBytes(seed);
        LWEpublicPoly = QuantumResistantPipelineLWE.expandSeedToPolynomial(seed);

        // Persist private key
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("data\\LWE\\lwe_key.bin"))) {
            out.writeObject(LWEprivateKey);
        }

        // Persist public polynomial
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("data\\LWE\\lwe_pub.bin"))) {
            out.writeObject(LWEpublicPoly);
        }

        System.out.println("Private key saved to data\\LWE\\lwe_key.bin");
        System.out.println("Public polynomial saved to data\\LWE\\lwe_pub.bin");
    }
}
