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

import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.parse;
import RandomNumber.UserResearchStudy;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.PacketSynchronizedAlgebraicCipher.myPubKy;
import static Security.Security.SeedGenFormula;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import org.apache.log4j.Logger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 *
 * @author Rajesh V Pai
 */
public class TCPECCKeyPairGeneration {
    public static Logger log = Logger.getLogger(TCPECCKeyPairGeneration.class.getName());
    public long TCPECCPrivateKeyLength = -1;
    public String TCPECCPublicKey = "";
    public long TCPECCPublicKeyLength = -1;
    public String TCPECCSymmetricKey = "";
    public long TCPECCSymmetricKeyLength = -1;
    
    public String TCPECCPrivateKey = "";


   private PublicKey pubKey;
    private PrivateKey privKey;

    public TCPECCKeyPairGeneration(){
        TCPECCPrivateKey = "";
    TCPECCPrivateKeyLength = -1;
    TCPECCPublicKey = "";
    TCPECCPublicKeyLength = -1;
    TCPECCSymmetricKey = "";
    TCPECCSymmetricKeyLength = -1;
    }
    public void GenerateKeys() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            SecureRandom sr = SecureRandom.getInstanceStrong();
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");
            keyGen.initialize(ecSpec, sr);

            KeyPair pair = keyGen.generateKeyPair();
            pubKey = pair.getPublic();
            privKey = pair.getPrivate();

            // store numeric strings if needed
            this.TCPECCPublicKey = new BigInteger(1, pubKey.getEncoded()).toString();
            this.TCPECCPrivateKey = new BigInteger(1, privKey.getEncoded()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Encrypt baseline ISN string with public key
    public String encryptBaseline(String baseline) throws Exception {
        Cipher cipher = Cipher.getInstance("ECC");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] encrypted = cipher.doFinal(baseline.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt baseline ISN string with private key
    public String decryptBaseline(String encryptedBaseline) throws Exception {
        Cipher cipher = Cipher.getInstance("ECC");
        cipher.init(Cipher.DECRYPT_MODE, privKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedBaseline));
        return new String(decrypted, StandardCharsets.UTF_8);
    }


    public String getTCPECCPrivateKey() {
        return TCPECCPrivateKey;
    }

    public String getTCPECCPublicKey() {
        return TCPECCPublicKey;
    }

    public String getTCPECCSymmetricKey() {
        return TCPECCSymmetricKey;
    }
    
    

    public void init(String AlgoName,int mySeed, int mySeed1) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        this.TCPECCPrivateKeyLength = myPrivKy;
        this.TCPECCPublicKeyLength = myPubKy;
        this.TCPECCSymmetricKeyLength = myPubKy;
        String DiffWithRespTo = "Xn";
        if (AlgoName.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("x", mySeed * 1.0);
        LCGexpValue = parse(SeedGenFormula, variablesEncrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoName.equalsIgnoreCase("Decrypt")){
         variablesDecrypt.put("x", mySeed * 1.0);
        LCGexpValue = parse(SeedGenFormula, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        UserResearchStudy.SeedSimple = LCGexpValue.eval().longValue();
        if (AlgoName.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("x", mySeed1 * 1.0);
        }else if (AlgoName.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.put("x", mySeed1 * 1.0);
        }
        MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
        if (AlgoName.equalsIgnoreCase("Encrypt")){
        LCGexpValue1 = parse(SeedGenFormula, variablesEncrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoName.equalsIgnoreCase("Decrypt")){
        LCGexpValue1 = parse(SeedGenFormula, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        UserResearchStudy.SeedDyDx = LCGexpValue1.eval().longValue();
        
        if (AlgoName.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.remove("x");
        }else if (AlgoName.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.remove("x");
        }
    }
     public void GenerateKeysOld() {
        try {
//            // Initialize KeyPairGenerator for Elliptic Curve
//            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
//            keyGen.initialize(256); // common curve size (256 bits)
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            SecureRandom sr;
            try {
                sr = SecureRandom.getInstanceStrong(); // prefer OS-backed CSPRNG
            } catch (NoSuchAlgorithmException e) {
                sr = new SecureRandom(); // fallback
            }
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1"); // explicit curve
            keyGen.initialize(ecSpec, sr);

            // Generate the key pair
            KeyPair pair = keyGen.generateKeyPair();
            PublicKey pubKey = pair.getPublic();
            PrivateKey privKey = pair.getPrivate();


            
            // Print keys in Base64 for readability
            //System.out.println("ECC Public Key: " + java.util.Base64.getEncoder().encodeToString(pubKey.getEncoded()));
            //System.out.println("ECC Private Key: " + java.util.Base64.getEncoder().encodeToString(privKey.getEncoded()));

            
            byte[] pubBytes = pubKey.getEncoded();
            BigInteger bigInt = new BigInteger(1, pubBytes);

            // Convert to decimal string (digits only)
            String numericString = bigInt.toString();
            this.TCPECCPublicKey=numericString;
            //System.out.println("Numeric Public Key: " + this.TCPECCPublicKey);

            byte[] privBytes = privKey.getEncoded();
            BigInteger bigInt1 = new BigInteger(1, privBytes);

            // Convert to decimal string (digits only)
            String numericString1 = bigInt1.toString();
            this.TCPECCPrivateKey=numericString1;
            //System.out.println("Numeric Public Key: " + this.TCPECCPrivateKey);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}