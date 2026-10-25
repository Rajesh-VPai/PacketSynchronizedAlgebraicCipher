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

import Calculus.ConsoleColors;
import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.parse;
import static Security.Configuration.FOBRandomChar;
import static Security.PSACKeyVaultNew.KeyCombinationEqn;
import static Security.PacketSynchronizedAlgebraicCipher.MesgINCAPS;
import static Security.Security.CConstant;
import static Security.Security.MDivisor;
import static Security.Security.MDivisorTCP;
import static Security.Security.MDivisorWeiBull;
import static Security.Security.MyDecrptionEquation;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicEquation;
import static Security.Security.MyPublicKey;
import static Security.Security.RemoveVariationInM;
import static Security.Security.constant;
import static Security.Security.mult_div;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import static SenderReceiverGUI.Receiver.ReceiverStrTCPDecrypt;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class Calibration {
    public static Logger log = Logger.getLogger(Calibration.class.getName());
    public static String CalibrationSender=null;
    public static void ContextSetMesg(String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
        variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
         LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        
        if (initMDivisor == 1.0) {
            MDivisor = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSet:1.0:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E300) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E280;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E280;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:>initMDivisor*1E300:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            //ShannonSimEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            //Double WeiBullFactorDecrypt=1.0E13/((int)'a');
            Double WeiBullFactorDecrypt=1.0E0;
            Double WeiBullFactorMultDecrypt=1.0E0;
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E260 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:>initMDivisor*1E288:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E275;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E275;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:<initMDivisor*1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor / 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E270;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E270;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:<initMDivisor/1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() > initMDivisor ) {
            // Operative - Alternative
            //ShannonSimEncrypt:MDivisor=1.0E90 initMDivisor=1.0E11 LCGexpValue.eval()=6.889460333710546E99 
            //EncryptPKIValues:Equation1:m=6.8894603337105465E9 n=1.0E280 c=40000.0 MDivisor=1.0E90 CConstant=20000.0 constant=20000.0 
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                Double WeiBullFactorDecrypt=3.6379310344827586206896551724138;
                Double WeiBullFactorMultDecrypt=1.0;
                MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = 1E60 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:>initMDivisor:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }else {
            MDivisor = LCGexpValue.eval()/1E8;
            if (SilentFlag == false) {
                System.out.println("ContextSet:Else:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
    }

    public static void ContextSetChar(String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        MDivisor = 1.0;
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
        variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
         LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisor = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSet:1.0:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E6) {
            if (Algo.equalsIgnoreCase("CharDecrypt")) {
                MDivisor = initMDivisor * 1E90;
            } else if (Algo.equalsIgnoreCase("CharEncrypt")) {
                MDivisor = initMDivisor * 1E90;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:>1E6:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E6) {
            if (Algo.equalsIgnoreCase("CharDecrypt")) {
                MDivisor = initMDivisor / 1E160;
            } else if (Algo.equalsIgnoreCase("CharEncrypt")) {
                MDivisor = initMDivisor / 1E160;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSet:<1E6:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else {
            MDivisor = LCGexpValue.eval();
            if (SilentFlag == false) {
                System.out.println("ContextSet:Else:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
    }

    public static void ContextSetChar4TCP(String Exprn, String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
        variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }
        if( (Algo.equalsIgnoreCase("CharEncrypt"))&&( (Exprn==null) || (KeyCombinationEqn==null)
                ||(Exprn.equalsIgnoreCase("")||(KeyCombinationEqn.equalsIgnoreCase(""))) ) ){
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCP:Algo=" + Algo +  ":Cannot Encrypt:Exprn=" + Exprn + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCP:Algo=" + Algo +  ":Cannot Encrypt:MyPublicEquation=" + MyPublicEquation + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCP:Algo=" + Algo +  ":Cannot Encrypt:KeyCombinationEqn=" + KeyCombinationEqn + ConsoleColors.RESET);
        }
        if( (Algo.equalsIgnoreCase("CharDecrypt"))&&( (Exprn==null) || (KeyCombinationEqn==null)
                ||(Exprn.equalsIgnoreCase("")||(KeyCombinationEqn.equalsIgnoreCase(""))) ) ){
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCP:Algo=" + Algo +  ":Cannot Decrypt:Exprn=" + Exprn + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCP:Algo=" + Algo +  ":Cannot Decrypt:MyDecrptionEquation=" + MyDecrptionEquation + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCP:Algo=" + Algo +  ":Cannot Decrypt:KeyCombinationEqn=" + KeyCombinationEqn + ConsoleColors.RESET);
        }
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
         LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisorTCP = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCP:1.0:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            if (Algo.equalsIgnoreCase("CharDecrypt")) {
                MDivisorTCP = initMDivisor * 1.0E285;
            } else if (Algo.equalsIgnoreCase("CharEncrypt")) {
                MDivisorTCP = initMDivisor * 1E8;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCP:>=1E288:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < 1E8) {
            if (Algo.equalsIgnoreCase("CharDecrypt")) {
                MDivisorTCP = initMDivisor * 1E100;
            } else if (Algo.equalsIgnoreCase("CharEncrypt")) {
                MDivisorTCP = initMDivisor * 1E100;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCP:<1E8:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else {
            MDivisorTCP = LCGexpValue.eval();
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCP:Else:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesEncrypt.put("c", 1.0 * (constant + CConstant));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
        variablesDecrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesDecrypt.put("c", 1.0 * (constant + CConstant));
        }
        
        //System.out.println("ContextSetChar4TCP:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
    }
public static void ContextSetMesgWeiBull(String Exprn, String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        //MDivisorWeiBull = 1.0;
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
              variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
            variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));  
        }
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
            LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey",false, "Silent", MathsExpressionParser.LogLevel.Off);
        } else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey",false, "Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisorWeiBull = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:1.0:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E300) {
            if (Algo.equalsIgnoreCase("WeibullDecrypt")) {
                MDivisorWeiBull = initMDivisor * 1E280;
            }else if (Algo.equalsIgnoreCase("WeibullEncrypt")) {
                MDivisorWeiBull = initMDivisor * 1E280;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:>initMDivisor*1E300:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            //ShannonSimEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            if (Algo.equalsIgnoreCase("WeibullDecrypt")) {
                MDivisorWeiBull = initMDivisor * 1E18;
            }else if (Algo.equalsIgnoreCase("WeibullEncrypt")) {
                MDivisorWeiBull = initMDivisor * 1E8;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:>initMDivisor*1E288:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E8) {
            if (Algo.equalsIgnoreCase("WeibullDecrypt")) {
                MDivisorWeiBull = initMDivisor ;
            }else if (Algo.equalsIgnoreCase("WeibullEncrypt")) {
                MDivisorWeiBull = initMDivisor ;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:<initMDivisor*1E8:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor / 1E8) {
            if (Algo.equalsIgnoreCase("WeibullDecrypt")) {
                MDivisorWeiBull = initMDivisor / 1E270;
            }else if (Algo.equalsIgnoreCase("WeibullEncrypt")) {
                MDivisorWeiBull = initMDivisor / 1E270;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:<initMDivisor/1E8:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() > initMDivisor ) {
            if (Algo.equalsIgnoreCase("WeibullDecrypt")) {
                MDivisorWeiBull = initMDivisor * 1E57;
            }else if (Algo.equalsIgnoreCase("WeibullEncrypt")) {
                MDivisorWeiBull = initMDivisor * 1E57;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:>initMDivisor:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else {
            MDivisorWeiBull = LCGexpValue.eval()/1E8;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgWeiBull:Else:" + Algo + ":MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
    }
public static void ContextSetMesgShannon(String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        }
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisor = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:1.0:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E300) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E280;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E280;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:>initMDivisor*1E300:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            //ShannonSimEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            //Double WeiBullFactorDecrypt=1.0E13/((int)'a');
            Double WeiBullFactorDecrypt=366.0/116.0;// This is a specific Theorem 2 alignment 
                                                    // where the Decrypted Byte is 366.0 whereas Message First letter is 't';
            Double WeiBullFactorMultDecrypt=1.0E10;
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E260 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:>initMDivisor*1E288:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E275;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E275;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:<initMDivisor*1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor / 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E270;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E270;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:<initMDivisor/1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() > initMDivisor ) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E265;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E265;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:>initMDivisor:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }else {
            MDivisor = LCGexpValue.eval()/1E8;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:Else:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
    }
public static void ContextSetMesgEaves(String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisor = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:1.0:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E300) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E280;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E280;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:>initMDivisor*1E300:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            //ShannonSimEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            //Double WeiBullFactorDecrypt=1.0E13/((int)'a');
            Double WeiBullFactorDecrypt=366.0/116.0;// This is a specific Theorem 2 alignment 
                                                    // where the Decrypted Byte is 366.0 whereas Message First letter is 't';
            Double WeiBullFactorMultDecrypt=1.0E10;
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E260 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:>initMDivisor*1E288:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E275;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E275;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:<initMDivisor*1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor / 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E270;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E270;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:<initMDivisor/1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() > initMDivisor ) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E265;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E265;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:>initMDivisor:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }else {
            MDivisor = LCGexpValue.eval()/1E8;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgShannon:Else:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
    }
    public static void ContextSetMesgSenderAlice(String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisor = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:1.0:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E300) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E280;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E280;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:>initMDivisor*1E300:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            //ShannonSimEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            //Double WeiBullFactorDecrypt=1.0E13/((int)'a');
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                if(MesgINCAPS==false){
                    Double WeiBullFactorDecrypt=1.0E0;
                    Double WeiBullFactorMultDecrypt=1.0E0;
                    MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                }else if(MesgINCAPS==true){
                    Double WeiBullFactorDecrypt=94.0;
                    Double WeiBullFactorMultDecrypt=84.0;
                    MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                }
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E260 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:>initMDivisor*1E288:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E275;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E275;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:<initMDivisor*1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor / 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E270;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E270;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:<initMDivisor/1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() > initMDivisor ) {
            // Operative - Alternative
            //ShannonSimEncrypt:MDivisor=1.0E90 initMDivisor=1.0E11 LCGexpValue.eval()=6.889460333710546E99 
            //EncryptPKIValues:Equation1:m=6.8894603337105465E9 n=1.0E280 c=40000.0 MDivisor=1.0E90 CConstant=20000.0 constant=20000.0 
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                if(MesgINCAPS==false){
                    Double WeiBullFactorDecrypt=600.0;
                    Double WeiBullFactorMultDecrypt=58.0*0.3765;
                    MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                }else if(MesgINCAPS==true){
                    if(FOBRandomChar.equalsIgnoreCase("FOBStandardChar")){
                    //Double WeiBullFactorDecrypt=24.428571428571428571428571428571;
                    Double WeiBullFactorDecrypt=24.431034482758620689655172413793;
                    Double WeiBullFactorMultDecrypt=1.0;
                    MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                    }else if(FOBRandomChar.equalsIgnoreCase("FOBRandomChar")){
                    Double WeiBullFactorDecrypt=6.4544790652385589094449853943525;
                    Double WeiBullFactorMultDecrypt=1.0;
                    MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;        
                    }
                }
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = 1E60 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:>initMDivisor:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }else {
            MDivisor = LCGexpValue.eval()/1E8;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderAlice:Else:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesEncrypt.put("c", 1.0 * (constant + CConstant));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
             variablesDecrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesDecrypt.put("c", 1.0 * (constant + CConstant));
        }
        //System.out.println("ContextSetChar4TCPWeak:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
    }
    public static void ContextSetMesgSenderBob(String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        } else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
             variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if (initMDivisor == 1.0) {
            MDivisor = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:1.0:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E300) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor * 1E280;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E280;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:>initMDivisor*1E300:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            //ShannonSimEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            //Double WeiBullFactorDecrypt=1.0E13/((int)'a');
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                if(MesgINCAPS==false){
                    Double WeiBullFactorDecrypt=1.0E0;
                    Double WeiBullFactorMultDecrypt=1.0E0;
                    MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                }else if(MesgINCAPS==true){
                    Double WeiBullFactorDecrypt=1.0;
                    Double WeiBullFactorMultDecrypt=1.0;
                    MDivisor = initMDivisor * 1E260 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                }
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor * 1E260 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:>initMDivisor*1E288:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        } else if (LCGexpValue.eval() < initMDivisor * 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E275;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E275;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:<initMDivisor*1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < initMDivisor / 1E8) {
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                MDivisor = initMDivisor / 1E270;
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = initMDivisor / 1E270;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:<initMDivisor/1E8:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }else if (LCGexpValue.eval() > initMDivisor ) {
            // Operative - Alternative
            //ShannonSimEncrypt:MDivisor=1.0E90 initMDivisor=1.0E11 LCGexpValue.eval()=6.889460333710546E99 
            //EncryptPKIValues:Equation1:m=6.8894603337105465E9 n=1.0E280 c=40000.0 MDivisor=1.0E90 CConstant=20000.0 constant=20000.0 
            //WeibullEncrypt:MDivisor=1.0000000000000001E291 initMDivisor=1.0E11 LCGexpValue.eval()=1.0E300
            Double WeiBullFactorEncrypt=1.0;
            if (Algo.equalsIgnoreCase("ShannonSimDecrypt")) {
                if(MesgINCAPS==false){
                    Double WeiBullFactorDecrypt=602.0;
                    Double WeiBullFactorMultDecrypt=58.0*2.85;
                    MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                }else if(MesgINCAPS==true){
                    if(FOBRandomChar.equalsIgnoreCase("FOBStandardChar")){
                    //Double WeiBullFactorDecrypt=4.0952380952380952380952380952381;
                    Double WeiBullFactorDecrypt=4.0862068965517241379310344827586;
                    Double WeiBullFactorMultDecrypt=1.0;
                    MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt;
                    }else if(FOBRandomChar.equalsIgnoreCase("FOBRandomChar")){
                        Double WeiBullFactorDecrypt=15.493184031158714703018500486855;
                        Double WeiBullFactorMultDecrypt=1.0;
                        MDivisor = 1E61 /(WeiBullFactorDecrypt)*WeiBullFactorMultDecrypt; 
                    }
                }
            } else if (Algo.equalsIgnoreCase("ShannonSimEncrypt")) {
                MDivisor = 1E60 * WeiBullFactorEncrypt;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:>initMDivisor:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }else {
            MDivisor = LCGexpValue.eval()/1E8;
            if (SilentFlag == false) {
                System.out.println("ContextSetMesgSenderBob:Else:" + Algo + ":MDivisor=" + MDivisor + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesEncrypt.put("c", 1.0 * (constant + CConstant));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
        variablesDecrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesDecrypt.put("c", 1.0 * (constant + CConstant));
        } 
        //System.out.println("ContextSetMesgSenderBob:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
    }
    public static void ContextSetChar4TCPWeak(String Exprn, String Algo, String AlgoEncryptDecrypt,Double initMDivisor, Double initCConstant, Double initmult_div, Double initconstant) {
        boolean SilentFlag = true;
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        CConstant = 0.0;
        mult_div = 1.0;
        constant = 0.0;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
            variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "pubkey", false,"Silent", MathsExpressionParser.LogLevel.Off);
        }
        if( (Algo.equalsIgnoreCase("CharEncrypt"))&&( (Exprn==null) || (KeyCombinationEqn==null)
                ||(Exprn.equalsIgnoreCase("")||(KeyCombinationEqn.equalsIgnoreCase(""))) ) ){
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCPWeak:Algo=" + Algo +  ":Cannot Encrypt:Exprn=" + Exprn + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCPWeak:Algo=" + Algo +  ":Cannot Encrypt:MyPublicEquation=" + MyPublicEquation + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCPWeak:Algo=" + Algo +  ":Cannot Encrypt:KeyCombinationEqn=" + KeyCombinationEqn + ConsoleColors.RESET);
        }
        if( (Algo.equalsIgnoreCase("CharDecrypt"))&&( (Exprn==null) || (KeyCombinationEqn==null)
                ||(Exprn.equalsIgnoreCase("")||(KeyCombinationEqn.equalsIgnoreCase(""))) ) ){
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCPWeak:Algo=" + Algo +  ":Cannot Decrypt:Exprn=" + Exprn + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCPWeak:Algo=" + Algo +  ":Cannot Decrypt:MyDecrptionEquation=" + MyDecrptionEquation + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "ContextSetChar4TCPWeak:Algo=" + Algo +  ":Cannot Decrypt:KeyCombinationEqn=" + KeyCombinationEqn + ConsoleColors.RESET);
        }
        if (initMDivisor == 1.0) {
            MDivisorTCP = 1.0;
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCPWeak:1.0:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() >= initMDivisor * 1E288) {
            // Operative
            if (Algo.equalsIgnoreCase("CharDecrypt")) {
                MDivisorTCP = initMDivisor * 1.0E285;
            } else if (Algo.equalsIgnoreCase("CharEncrypt")) {
                MDivisorTCP = initMDivisor * 1E8;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCPWeak:>=1E288:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else if (LCGexpValue.eval() < 1E8) {
            if (Algo.equalsIgnoreCase("CharDecrypt")) {
                MDivisorTCP = initMDivisor * 1E100;
            } else if (Algo.equalsIgnoreCase("CharEncrypt")) {
                MDivisorTCP = initMDivisor * 1E100;
            }
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCPWeak:<1E8:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval());
            }
        } else {
            MDivisorTCP = LCGexpValue.eval();
            if (SilentFlag == false) {
                System.out.println("ContextSetChar4TCPWeak:Else:" + Algo + ":MDivisor=" + MDivisor + " MDivisorTCP=" + MDivisorTCP + " initMDivisor=" + initMDivisor + " LCGexpValue.eval()=" + LCGexpValue.eval() + " KeyCombinationEqn=" + KeyCombinationEqn);
            }
        }
        CConstant = initCConstant;
        mult_div = initmult_div;
        constant = initconstant;
        if (AlgoEncryptDecrypt.equalsIgnoreCase("Encrypt")){
        variablesEncrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesEncrypt.put("c", 1.0 * (constant + CConstant));
        }else if (AlgoEncryptDecrypt.equalsIgnoreCase("Decrypt")){
         variablesDecrypt.put("m", RemoveVariationInM("" + LCGexpValue.eval()));
        variablesDecrypt.put("c", 1.0 * (constant + CConstant));   
        }
        //System.out.println("ContextSetChar4TCPWeak:variables:");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
    }
}
