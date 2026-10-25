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

import static Calculus.UsageCalculus.DiffWithRespTo;
import static RandomNumber.UserResearchStudy.SeedSimple;
import static Security.Security.AliceEquation1;
import static Security.Security.EncryptedByte;
import static Security.Security.FixedLength;
import static Security.Security.Mychar;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class SymmetricKey {

    public static Logger log = Logger.getLogger(SymmetricKey.class.getName());

    public static Double EncryptSymetricKey(String AlgoName, String SymKey, String PublicEquation) {
        String DiffExprn = "";
        DiffWithRespTo = "Xn";
        AliceEquation1 = new MathsRelations();
        if (AlgoName.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("m", Double.parseDouble(SymKey));
        variablesEncrypt.put(DiffWithRespTo, 'a' * 1.0);
        Mychar = (variablesEncrypt.get(DiffWithRespTo));
        variablesEncrypt.put("c", 1.0 * SeedSimple);
        AliceEquation1.initExprn(PublicEquation, variablesEncrypt,DiffWithRespTo);
        }else if (AlgoName.equalsIgnoreCase("Decrypt")){
         variablesDecrypt.put("m", Double.parseDouble(SymKey));
        variablesDecrypt.put(DiffWithRespTo, 'a' * 1.0);
        Mychar = (variablesDecrypt.get(DiffWithRespTo));
        variablesDecrypt.put("c", 1.0 * SeedSimple);  
        AliceEquation1.initExprn(PublicEquation, variablesDecrypt,DiffWithRespTo);
        }
        EncryptedByte = AliceEquation1.CalculateExprn();
        System.out.println("Security:EncryptSymmetricKey:EncryptedByte=" + EncryptedByte + " plainText=" + variablesEncrypt.get(DiffWithRespTo) + " char=" + (char) Mychar.intValue());
        System.out.println("Security:EncryptSymmetricKey:DiffExprn=" + DiffExprn);
        return EncryptedByte;
    }

    public static void DecryptSymetricKey(String AlgoName, String SymKey, String DecrptionEquation, Double Value) {
        double DecryptedByte = 0;
        String DiffExprn = "";
        DiffWithRespTo = "y";
        int Mychar = 0;
        AliceEquation1 = new MathsRelations();
        if (AlgoName.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("m", Double.parseDouble(SymKey));
        variablesEncrypt.put(DiffWithRespTo, 1.0 * Value);
        Mychar = (variablesEncrypt.get(DiffWithRespTo)).intValue();
        variablesEncrypt.put("c", 1.0 * SeedSimple);
        AliceEquation1.initExprn(DecrptionEquation,variablesEncrypt, DiffWithRespTo);
        }else if (AlgoName.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.put("m", Double.parseDouble(SymKey));
        variablesDecrypt.put(DiffWithRespTo, 1.0 * Value);
        Mychar = (variablesDecrypt.get(DiffWithRespTo)).intValue();
        variablesDecrypt.put("c", 1.0 * SeedSimple);
        AliceEquation1.initExprn(DecrptionEquation,variablesDecrypt, DiffWithRespTo);
        }
        DecryptedByte = AliceEquation1.CalculateExprn();
        System.out.println("Security:DecryptSymmetricKey:Decrypt:DecryptedByte=" + DecryptedByte + " plainText=" + variablesDecrypt.get(DiffWithRespTo) + " char=" + (char) DecryptedByte);
    }

    public static void StudyOfSymetricEncrption(String MySymetricKey) {
        String EqnUnderTest = "m*Xn+c";
        String InverseEqnUnderTest = "y/m-c/m";
        Double Value = EncryptSymetricKey("Encrypt",MySymetricKey, EqnUnderTest);
        DecryptSymetricKey("Decrypt", MySymetricKey, InverseEqnUnderTest, Value);
        for (int i = 0; (i + FixedLength) < MySymetricKey.length(); i += FixedLength) {
            String TempKey = MySymetricKey.substring(i, i + FixedLength);
            Value = EncryptSymetricKey("Encrypt",MySymetricKey, EqnUnderTest);
            DecryptSymetricKey("Decrypt",MySymetricKey, InverseEqnUnderTest, Value);
        }
    }
}
