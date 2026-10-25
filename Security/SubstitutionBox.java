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
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.c;
import static Security.Calibration.CalibrationSender;
import static Security.Decryption.DeTerminatorString;
import static Security.Encryption.EncryptPerfFLAG2;
import static Security.Encryption.EncryptStr2FuncTimeTaken;
import static Security.EquationPairGeneration.diffusionN;
import static Security.Calibration.ContextSetChar;
import static Security.Calibration.ContextSetMesg;
import static Security.Calibration.ContextSetMesgWeiBull;
import static Security.Calibration.ContextSetMesgEaves;
import static Security.Calibration.ContextSetMesgSenderAlice;
import static Security.Calibration.ContextSetMesgSenderBob;
import static Security.Calibration.ContextSetMesgShannon;
import static Security.Security.CConstant;
import static Security.Security.DecryptPKIValues;
import static Security.Security.DecryptedByte;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.EncTerminatorString;
import static Security.Encryption.EncryptedMesg;
import static Security.Configuration.FOBRandomChar;
import static Security.LowLevelSecurityFramework.TheFOBRandomCharSim;
import static Security.LowLevelSecurityFramework.TheFOBRandomCharWeiBull;
import static Security.LowLevelSecurityFramework.UnicityForEnglish;
import static Security.PacketSynchronizedAlgebraicCipher.SuppressSystemOutput;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.Security.EncryptPKIValues;
import static Security.PSACKeyVaultNew.KeyCombinationEqn;
import static Security.Configuration.SecurityPosture;
import static Security.PacketSynchronizedAlgebraicCipher.SuperSuppressOutput;
import static Security.Security.CConstant;
import static Security.Security.MDivisor;
import static Security.Security.MDivisorWeiBull;
import static Security.Security.MyPrivateKey;
import static Security.Security.MyPublicKey;
import static Security.Security.MySimple;
import static Security.Security.Mychar;
import static Security.Security.RemoveVariationInM;
import static Security.Security.Xn_LCG;
import static Security.Security.constant;
import static Security.Security.mult_div;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class SubstitutionBox {

    public static Logger log = Logger.getLogger(SubstitutionBox.class.getName());
    public static int DOUBLE_PRECISION_BASE=23;
    public static int DOUBLE_PRECISION_OVERALL=300;
    public static int DOUBLE_Number_Of_Parts_OVERALL=30;
    public static String[] HighPrecDoubleEncrypt= new String[DOUBLE_Number_Of_Parts_OVERALL];
    public static String[] HighPrecDoubleDecrypt= new String[DOUBLE_Number_Of_Parts_OVERALL];
    public static int HighPrecDoubleDecryptIndex=0;
    
    // Confusion && Diffusion Low Level Variables
    public static int SuccessiveCharsLenSim = 2;//5;
    public static int SuccessiveCharsIncrementSim = 1;//3;
    public static int SuccessiveCharsLenWeiBull = 2;
    public static int SuccessiveCharsIncrementWeiBull = 1;
    public static int DiffusionOperator = '+';//+;-;*;/;
    
    public static Double ShannonEncryptSBox(String iStr, boolean SilentFlag) {
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;

        Mychar = (int)iStr.charAt(0)*1.0;
        if(
               // (ShannonTestsRunning==true)&&
                (myPrivKy>75) ){
            ContextSetMesgShannon("ShannonSimEncrypt","Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        }else if((CalibrationSender != null)&&(CalibrationSender.equalsIgnoreCase("ContextSetMesgSenderBob"))
                    &&(SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))
                    ) {
            ContextSetMesgSenderBob("ShannonSimEncrypt","Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        }else if((CalibrationSender != null)&&(CalibrationSender.equalsIgnoreCase("ContextSetMesgSenderAlice"))
                    &&(SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))
                    ) {
            ContextSetMesgSenderAlice("ShannonSimEncrypt","Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        }else if ((myPrivKy<=75) ){
           ContextSetChar("ShannonSimEncrypt","Encrypt", initMDivisor, initCConstant, initmult_div, initconstant); 
        }else {
            ContextSetMesg("ShannonSimEncrypt", "Encrypt",initMDivisor, initCConstant, initmult_div, initconstant);
        }
        
        if (SilentFlag == false) {
            System.out.println("ShannonSimEncrypt:After ContextSetMesg:Mychar=" + Mychar + " Mychar(char)=" + (char) Mychar.byteValue());
        }
        Value = EncryptPKIValues(Mychar.intValue(), MDivisor, CConstant, constant, SilentFlag);
        if (SilentFlag == false) {
            System.out.println("ShannonEncryptSBox:After Surprise:Value=" + Value + " ValueSurprise=" + ValueSurprise);
        }
        return Value;
    }

    public static void ShannonDecryptSBox(String ValueStr, boolean SilentFlag) {
        Double Value = 0.0;
        Double ValueDiffusion = 0.0;
        Double ValueSurprise = 0.0;
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        Value = Double.parseDouble(ValueStr);
        // Add Surprise Decryption Code
        variablesDecrypt.put("c", diffusionN);
       if(
               //(EavesTestCasesRunning==true)&&
               (EavesdroppingFlag==true)){
//             ValueSurprise = ShannonDecryption("MessageShannonSimple", Value, InvExprnSurprise, InvSurpriseDiffWithRespTo);
//             if (ValueSurprise != 0.0) {
//                    Value = ValueSurprise;
//             }
//            ValueDiffusion = ShannonDecryption("MessageShannonSimple", Value, InvExprnDiffusion, InvDiffusionDiffWithRespTo);
//            if (ValueDiffusion != 0.0) {
//                Value = ValueDiffusion;
//            }
            ContextSetMesgEaves("ShannonSimDecrypt", "Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        }else if(/*(ShannonTestsRunning==true)&&*/(myPrivKy>75) ){
            ContextSetMesgShannon("ShannonSimDecrypt", "Decrypt",initMDivisor, initCConstant, initmult_div, initconstant);
        }else if(/*(EavesTestCasesRunning==false)||*/(EavesdroppingFlag==false)){
            //System.out.println(ConsoleColors.GREEN + "DecryptDetail:ShannonSimDecrypt:Decryption Permitted:Enabling Correct ContextMesg" + ConsoleColors.RESET);
            if ((CalibrationSender != null)&&(CalibrationSender.equalsIgnoreCase("ContextSetMesgSenderBob"))
                   && (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))) {
               ContextSetMesgSenderBob("ShannonSimDecrypt", "Decrypt",initMDivisor, initCConstant, initmult_div, initconstant);
           } else if ((CalibrationSender != null)&&(CalibrationSender.equalsIgnoreCase("ContextSetMesgSenderAlice"))
                   && (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))) {
               ContextSetMesgSenderAlice("ShannonSimDecrypt", "Decrypt",initMDivisor, initCConstant, initmult_div, initconstant);
           } else if ((myPrivKy <= 75)) {
               ContextSetChar("ShannonSimDecrypt", "Decrypt",initMDivisor, initCConstant, initmult_div, initconstant);
           } else {
               ContextSetMesg("ShannonSimDecrypt", "Decrypt",initMDivisor, initCConstant, initmult_div, initconstant);
           }
        } 
        Double Temp=DecryptPKIValues(Value, MDivisor, CConstant, mult_div, constant, SilentFlag);
        //if (Temp != 0.0){
            DecryptedByte = Temp;
            DecryptedMesg.append((char) DecryptedByte.intValue());
            //System.out.println("ShannonSimDecrypt:DecryptedMesg=" + DecryptedMesg + " char="+ (char) DecryptedByte.intValue()+ " int="+ (int) DecryptedByte.intValue() + " MDivisor=" + MDivisor);
        //}
    }
public static StringBuilder WeibullEncryptSBox(String Exprn, String[] Temp, int MesgIndex, String DiffWithRespTo, Double Constant_Of_Mapping,boolean SilentFlag) {
        //SilentFlag=false;
        try{
        Thread.sleep(10);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        /**
         * ************************ WeiBull Encryption Begins ***************
         */
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        variablesEncrypt.put(DiffWithRespTo, Double.parseDouble(Temp[MesgIndex]));
        LCGexpValue = parse(Exprn, variablesEncrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        if (SilentFlag == false) {
            System.out.println("WeibullEncryptSBox:Message:Temp[MesgIndex]=" + Temp[MesgIndex] + " LCGexpValue.eval()=" + LCGexpValue.eval());
        }
        //System.out.println("WeibullEncryptSBox:Message:Exprn=" + Exprn + " LCGexpValue.eval()=" + LCGexpValue.eval() + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn"));
        if(LCGexpValue.eval() >=0){
            NewEncryptedMesg.append(LCGexpValue.eval()).append(EncTerminatorString);
            //System.out.println("WeibullEncryptSBox:>=0:Message:LCGexpValue.eval()=" + LCGexpValue.eval() + " NewEncryptedMesg=" + NewEncryptedMesg + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn"));
        }else{
            MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
            LCGexpValue1 = parse("-1.0"+"*"+Exprn, variablesEncrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
            if(LCGexpValue1.eval() >=0){
                NewEncryptedMesg.append(LCGexpValue1.eval()).append(EncTerminatorString);
                //System.out.println("WeibullEncryptSBox:<0:Message:Exprn=" + Exprn + " LCGexpValue1.eval()=" + LCGexpValue1.eval() + " NewEncryptedMesg=" + NewEncryptedMesg + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn"));
            }
        }
        /**
         * ************************ WeiBull Encryption Ends ***************
         */
        //System.out.println("WeibullEncryptSBox:Message:LCGexpValue.eval()=" + LCGexpValue.eval() + " NewEncryptedMesg=" + NewEncryptedMesg + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " Xn=" + variables.get("Xn"));
        
        return NewEncryptedMesg;
    }

    public static StringBuilder WeibullDecryptSBox(String Exprn, String BaseExprn,String[] Temp, int MesgIndex, String DiffWithRespTo, String RandCStr, Double RandC,boolean SilentFlag) {
        //SilentFlag=false;
        try{
        Thread.sleep(10);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        Double Scaler=1.0E5;//1.0E19
        /**
         * ************************ WeiBull Decryption Begins ***************
         */
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        String Exprn1 = "(" + DiffWithRespTo + "-" + variablesDecrypt.get(RandCStr) + ")" + "/" + BaseExprn;
            
        //if(Temp[MesgIndex].matches("[0-9\\.]+[Ee]*[0-9]*"))
        // NOT SURE WHY EE comes
        
        //if(Temp[MesgIndex].matches("[0-9]*[\\.]*[Ee]*[0-9]*[^,]")){
                //System.out.println("WeibullDecryptSBox:Temp[" + MesgIndex + "]:=" + Temp[MesgIndex] + " length=" + Temp.length);
                variablesDecrypt.put(DiffWithRespTo, Double.parseDouble(Temp[MesgIndex]));
                //else
                //    variables.put(DiffWithRespTo, 1.0);
                LCGexpValue = parse(Exprn, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                //System.out.println("WeibullDecryptSBox:After WeibullDecryptSBox:DecryptedMesg.length()=" + DecryptedMesg.length());
        //}
        /**
         * ************************ WeiBull Decryption Ends ***************
         */
        //System.out.println("WeibullDecryptSBox:Message:Exprn=" + Exprn + " Exprn1=" + Exprn1 + " LCGexpValue.eval()=" + LCGexpValue.eval() + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn"));
        if(LCGexpValue.eval() >=0){
            NewEncryptedMesg.append(LCGexpValue.eval()/Scaler).append(DeTerminatorString);
            //System.out.println("WeibullDecryptSBox:Message:>=0:LCGexpValue.eval()=" + LCGexpValue.eval() + " NewEncryptedMesg=" + NewEncryptedMesg + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn"));
        }else{
            MathsExpressionParser.Expression LCGexpValue1 = (() -> 0.0);
            LCGexpValue1 = parse(Exprn1, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
            if(LCGexpValue1.eval() <=0){
                NewEncryptedMesg.append(((Double)(LCGexpValue1.eval()*-1.0)) ).append(DeTerminatorString);
                //System.out.println("WeibullDecryptSBox:Message:<=0:Exprn1=" + Exprn1 + " LCGexpValue1.eval()=" + LCGexpValue1.eval() + " NewEncryptedMesg=" + NewEncryptedMesg + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn") + " WeiRand2(RandC)="+ variables.get(RandCStr) + " RandC=" + RandC + " Rand=" + variables.get("Rand") + " y=" + variables.get(DiffWithRespTo));
            }else {
                NewEncryptedMesg.append(LCGexpValue.eval()).append(DeTerminatorString);
                //System.out.println("WeibullDecryptSBox:Message:>0:FATAL ERROR:DECRYPTION:Exprn1=" + Exprn1 + " LCGexpValue1.eval()=" + LCGexpValue1.eval() + " NewEncryptedMesg=" + NewEncryptedMesg + " m=" + variables.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variables.get("Xn") + " WeiRand2(RandC)="+ variables.get(RandCStr) + " RandC=" + RandC + " Rand=" + variables.get("Rand") + " y=" + variables.get(DiffWithRespTo));
            }
        }
        return NewEncryptedMesg;
    }
    
     public static void ShannonSimEncrypt(String iStr, boolean SilentFlag) {
         String EncryptedExprn = "";
         String AlgoEncryptDecrypt="Encrypt";
         StringBuilder NewEncryptedMesg = new StringBuilder("");
        if ((EncryptPerfFLAG2 == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                EncryptStr2FuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                EncryptStr2FuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        Double Value = ShannonEncryptSBox(iStr, SilentFlag);
        // Mapping Equation
        //Value=Value+ValueDiffusion+ValueSurprise;
        if (SilentFlag == false) {
            System.out.println("ShannonSimEncrypt:After ShannonEncryptSBox:Value=" + Value);
        }
        NewEncryptedMesg.append(EncryptedMesg).append(Value).append(EncTerminatorString);
        EncryptedMesg = NewEncryptedMesg;
        if ((EncryptPerfFLAG2 == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            EncryptStr2FuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(EncryptStr2FuncTimeTaken)));
            //System.out.println("EncryptDetail:Inside ShannonSimEncrypt:Length=" + EncryptedMesg.length() + " FuncTimeTaken=" + (Double.parseDouble(EncryptStr2FuncTimeTaken) * 1000) + " milliseconds");
            EncryptPerfFLAG2=true;
        }
        //System.out.println("ShannonSimEncrypt:Final:EncryptedMesg=" + EncryptedMesg);
    }

    public static void ShannonSimDecrypt(String ValueStr, boolean SilentFlag) {
        String AlgoEncryptDecrypt="Decrypt";
        
        ShannonDecryptSBox(ValueStr, SilentFlag);
    }
   
    public static void WeibullEncrypt(String Exprn, Double Rand, Double RandC, boolean SilentFlag) {
        /**
         * ************************ WeiBull Encryption Begins ***************
         */
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        if (SilentFlag == false) {
            System.out.println("WeibullEncrypt:After WorkFactor:EncryptedMesg=" + EncryptedMesg);
        }
        //System.out.println("WeibullEncrypt:After WorkFactor:EncryptedMesg.length()=" + EncryptedMesg.length());
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        Double Constant_Of_Mapping=4.0;
        String WeiBullExprn = "Rand";
        ContextSetMesgWeiBull(WeiBullExprn,"WeibullEncrypt", "Encrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        variablesEncrypt.put("pubkey", Double.parseDouble(MyPublicKey));
        variablesEncrypt.put("privkey", Double.parseDouble(MyPrivateKey));
        //System.out.println("Sender:WeibullEncrypt:variables");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        
        LCGexpValue = parse(KeyCombinationEqn, variablesEncrypt, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
        variablesEncrypt.put("m", LCGexpValue.eval());
        variablesEncrypt.put("A", 1.0e200);
        //System.out.println("Sender:WeiBullEncryptionMesg:variables");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        EncryptedMesg = WeiBullEncryptionMesg("WeiBullEncryptionMesg", WeiBullExprn, "Rand", Rand, "Xn", RandC, Exprn, Constant_Of_Mapping, SilentFlag);
      
        //System.out.println("WeibullEncrypt:After WeiBullEncryptionMesg:EncryptedMesg.length()=" + EncryptedMesg.length());
        /**
         * ************************ WeiBull Encryption Ends ***************
         */
        variablesEncrypt.remove("m");
        variablesEncrypt.remove("A");
    }

    public static void WeibullDecrypt(String Exprn,Double Rand, Double RandC, boolean SilentFlag) {
        
        /**
         * ************************ WeiBull Decryption Begins ***************
         */
        //System.out.println("WeibullDecrypt:Initial:EncryptedMesg.length()=" + EncryptedMesg.length());
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        Double initMDivisor = 10E10;
        Double initCConstant = 20000.0;
        Double initmult_div = 1.0;
        Double initconstant = 20000.0;
        Double Constant_Of_Mapping=4.0;
        ContextSetMesgWeiBull(Exprn,"WeibullDecrypt","Decrypt", initMDivisor, initCConstant, initmult_div, initconstant);
        DecryptedMesg =new StringBuilder("");
        String WeiBullExprn = "Rand";
        if ((MyPublicKey != null) && (!MyPublicKey.equalsIgnoreCase(""))) {
            variablesDecrypt.put("pubkey", Double.parseDouble(MyPublicKey));
            variablesDecrypt.put("privkey", Double.parseDouble(MyPrivateKey));
            //System.out.println("Receiver:WeibullDecrypt:variables");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));
            LCGexpValue = parse(KeyCombinationEqn, variablesDecrypt, "Xn", false,"Silent", MathsExpressionParser.LogLevel.Off);
            variablesDecrypt.put("m", LCGexpValue.eval() );
            variablesDecrypt.put("A", 1.0e200);
            //System.out.println("Receiver:WeiBullDecryptionMesg:variables");
            //variables.forEach((key,value)-> System.out.println(key + " " + value));
            DecryptedMesg = WeiBullDecryptionMesg("WeiBullDecryptionMesg", WeiBullExprn, "Rand", Rand, "y", "WeiCharRand3",RandC, Exprn, SilentFlag);
            variablesDecrypt.remove("m");
            variablesDecrypt.remove("A");
        }
        //System.out.println("WeibullDecrypt:After WeiBullDecryptionMesg:DecryptedMesg.length()=" + DecryptedMesg.length());
        /**
         * ************************ WeiBull Decryption Ends ***************
         */
        
    }

    public static StringBuilder WeiBullEncryptionMesg(String AlgoName, String Exprn, String Rand3Str, Double WeiRand3, String DiffWithRespTo, Double RandC, String Mesg, Double Constant_Of_Mapping, boolean SilentFlag) {
        //SilentFlag=false;
        try{
            Thread.sleep(10);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        //System.out.println("WeiBullEncryptionMesg:Message:WeiRand3=" + WeiRand3);
        if (SilentFlag == false) {
            System.out.println("WeiBullEncryptionMesg:Message:Exprn=" + Exprn);
            System.out.println("WeiBullEncryptionMesg:Message:Mesg=" + Mesg);
            System.out.println("WeiBullEncryptionMesg:Message:" + Rand3Str + "=" + WeiRand3);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        if ((Exprn == null) || (Exprn.equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        if ((Mesg == null) || (Mesg.equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        //Exprn = Exprn + "*" + DiffWithRespTo + "+" + RandC;
        Exprn=DiffWithRespTo + "+" + RandC;
        String[] Temp = Mesg.split(EncTerminatorString);
        if (SuperSuppressOutput==false)
            System.out.println("WeiBullEncryptionMesg:Number of Characters:len=" + Temp.length);
        if (SilentFlag == false) {
            System.out.println("WeiBullEncryptionMesg:Message:Exprn=" + Exprn + " WeiRand3=" + WeiRand3 + " m=" + variablesEncrypt.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull);
        }
        variablesEncrypt.put(DiffWithRespTo, 1.0);
        variablesEncrypt.put(Rand3Str, WeiRand3);
        if (SilentFlag == false) {
            System.out.println("WeiBullEncryptionMesg:Message:Exprn=" + Exprn);
            System.out.println("WeiBullEncryptionMesg:Message:Mesg.length()=" + Mesg.length());
        }
        for (int MesgIndex = 0; (MesgIndex < Temp.length); MesgIndex++) {
            //if(Temp[MesgIndex].matches("[0-9\\.]+[Ee]*[0-9]*"))
            //System.out.println("WeiBullEncryptionMesg:Message:Temp[" + MesgIndex +"]=" + Temp[MesgIndex]);
            if (!Temp[MesgIndex].equalsIgnoreCase("")) {
                StringBuilder TempStrBuild=WeibullEncryptSBox(Exprn, Temp, MesgIndex, DiffWithRespTo, Constant_Of_Mapping,SilentFlag);
                NewEncryptedMesg.append(TempStrBuild);
                if(!TempStrBuild.toString().endsWith(EncTerminatorString))
                    NewEncryptedMesg.append(EncTerminatorString);
                //System.out.println("WeiBullEncryptionMesg:Final:TempStrBuild=" + TempStrBuild + " Temp[" + MesgIndex + "]=" + Temp[MesgIndex]);
            }
        }
        if (SilentFlag == false) {
            System.out.println("WeiBullEncryptionMesg:Final:NewEncryptedMesg=" + NewEncryptedMesg);
            System.out.println("WeiBullEncryptionMesg:Final:NumOfCharsMesg=" + Temp.length);
        }
        variablesEncrypt.remove(Rand3Str);
        variablesEncrypt.remove(DiffWithRespTo);

        //System.out.println("WeiBullEncryptionMesg:Final:NewEncryptedMesg.length()=" + NewEncryptedMesg.length() );
        return NewEncryptedMesg;
    }

    public static StringBuilder WeiBullDecryptionMesg(String AlgoName, String Exprn, String Rand3Str, Double WeiRand3, String DiffWithRespTo, String RandCStr,Double RandC, String Mesg, boolean SilentFlag) {
        //SilentFlag=false;try{
        try{
            Thread.sleep(10);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        String BaseExprn=Exprn;
        //System.out.println("WeiBullDecryptionMesg:Message:WeiRand3=" + WeiRand3);
        if (SilentFlag == false) {
            System.out.println("WeiBullDecryptionMesg:Message:Exprn=" + Exprn);
            System.out.println("WeiBullDecryptionMesg:Message:Mesg=" + Mesg);
            System.out.println("WeiBullDecryptionMesg:Message:" + Rand3Str + "=" + WeiRand3);
            System.out.println("WeiBullDecryptionMesg:Message:DiffWithRespTo=" + DiffWithRespTo);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        if ((Exprn == null) || (Exprn.equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        if ((Mesg == null) || (Mesg.equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        //Exprn = "(" + DiffWithRespTo + "-" + RandC + ")" + "/" + Exprn;
        Exprn = DiffWithRespTo + "-" + RandC;
        String[] Temp = Mesg.split(DeTerminatorString);
        //variablesDecrypt.put("Xn", 1.0);
        variablesDecrypt.put(DiffWithRespTo, 1.0);
        variablesDecrypt.put(RandCStr, RandC);
        variablesDecrypt.put(Rand3Str, WeiRand3);
        if (SuperSuppressOutput==false)
            System.out.println("WeiBullDecryptionMesg:Number of Characters:len=" + Temp.length);
        if (SilentFlag == false) {
            System.out.println("WeiBullDecryptionMesg:Message:Exprn=" + Exprn + " WeiRand3=" + WeiRand3 + " m=" + variablesDecrypt.get("m") + " MDivisor=" + MDivisor + " MDivisorWeiBull=" + MDivisorWeiBull + " Xn=" + variablesDecrypt.get("Xn")+ " DiffWithRespTo=" + variablesDecrypt.get(DiffWithRespTo));
        }
        for (int MesgIndex = 0; (MesgIndex < Temp.length);) {
            if ((!Temp[MesgIndex].equalsIgnoreCase(""))
                    && (!Temp[MesgIndex].equalsIgnoreCase(",")) 
                    &&(Double.isFinite(Double.parseDouble(Temp[MesgIndex])))
                    ) {
                StringBuilder TempStrBuild=WeibullDecryptSBox(Exprn, BaseExprn,Temp, MesgIndex, DiffWithRespTo, RandCStr, RandC, SilentFlag);
                NewEncryptedMesg.append(TempStrBuild);
                if(!NewEncryptedMesg.toString().endsWith(DeTerminatorString))
                        NewEncryptedMesg.append(DeTerminatorString);
                if (SilentFlag == false) {
                    System.out.println("WeiBullDecryptionMesg:Message:Temp[MesgIndex]=" + Temp[MesgIndex] + " TempStrBuild=" + TempStrBuild);
                }
                MesgIndex++;
            } else {
                MesgIndex++;
                variablesDecrypt.put("Xn", 1.0);
            }
        }
        if (SilentFlag == false) {
            System.out.println("WeiBullDecryptionMesg:Final:NewEncryptedMesg=" + NewEncryptedMesg);
            System.out.println("WeiBullDecryptionMesg:Final:NumOfCharsMesg=" + Temp.length);
        }
        variablesDecrypt.remove(Rand3Str);
        variablesDecrypt.remove(RandCStr);
        variablesDecrypt.remove(DiffWithRespTo);
        variablesDecrypt.remove("Xn");
        //System.out.println("WeiBullDecryptionMesg:Final:NewEncryptedMesg.length()=" + NewEncryptedMesg.length() );
        return NewEncryptedMesg;
    }
    // Confusion Functions
    public static StringBuilder ConfusionSimOld(String EncryptedMesg1, Double Value, boolean SilentFlag) {
        String EncryptedExprn = "";
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        for (int j = 0, MyChar = Value.intValue() + SuccessiveCharsIncrementSim; j < SuccessiveCharsLenSim; MyChar++, j++) {
            if (j==0)
                ;
            else
                Value = ShannonEncryptSBox(("" + MyChar), SilentFlag);
            if ((EncryptedMesg == null) || (EncryptedMesg.toString().equalsIgnoreCase(""))) {
                EncryptedMesg.append(Value);
            } else {
                StringBuilder Str1 = new StringBuilder(Value.toString());
                EncryptedExprn=EncryptedMesg.toString();
                NewEncryptedMesg = new StringBuilder(EncryptedExprn);
                if ((EncryptedExprn.endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (Str1.toString().startsWith(EncTerminatorString))) {
                    NewEncryptedMesg.append(Str1);
                     NewEncryptedMesg.append(EncTerminatorString);
                } else if ((!EncryptedExprn.endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
                    NewEncryptedMesg.append(EncTerminatorString);
                    NewEncryptedMesg.append(Str1);
                    NewEncryptedMesg.append(EncTerminatorString);
                } else if ((!EncryptedExprn.endsWith(EncTerminatorString)) && (!Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
                    NewEncryptedMesg.append(EncTerminatorString).append(Str1).append(EncTerminatorString);
                } else if ((!EncryptedExprn.endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
                    NewEncryptedMesg.append(EncTerminatorString);
                    NewEncryptedMesg.append(Str1);
                    NewEncryptedMesg.append(EncTerminatorString);
                } else if ((EncryptedExprn.endsWith(EncTerminatorString)) && (!Str1.toString().endsWith(EncTerminatorString))) {
                    NewEncryptedMesg.append(Str1);
                    NewEncryptedMesg.append(EncTerminatorString);
                } else if ((EncryptedExprn.endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
                    NewEncryptedMesg.append(Str1);
                    NewEncryptedMesg.append(EncTerminatorString);
                }
                String TempStr = NewEncryptedMesg.toString();
                if (TempStr.startsWith(EncTerminatorString)) {
                    NewEncryptedMesg = new StringBuilder(TempStr.replaceFirst(EncTerminatorString, ""));
                }
                EncryptedMesg = NewEncryptedMesg;
            }
        }
        return NewEncryptedMesg;
    }
    public static StringBuilder DiffusionJunkSimEncrypt(StringBuilder NewEncryptedMesg, String EncondingType,  boolean SilentFlag){
        
        String[] Temp = new String[NewEncryptedMesg.length()];
        String Exprn1=NewEncryptedMesg.toString();
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn1.split(EncTerminatorString);
            for (int i = 0; ((SilentFlag == false)&&(i < Temp.length) ); i++) {
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkSimEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length) ); i++) {
                Temp[i] = "" + Exprn1.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkSimEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
            // Adding Sucessive Junk Char
            boolean Flag=false;
            Double MyTemp=0.0;
            StringBuilder StrBuildTemp = new StringBuilder("");
            for(int i=0; i < Temp.length; ){
                Flag=false;
                if ((Temp[i] != null) 
                        && (!Temp[i].equalsIgnoreCase("")) 
                        && (Double.isFinite(Double.valueOf(Temp[i])))
                        && ( (i==0)
                        ||((i >0)&&(StrBuildTemp.toString().endsWith(EncTerminatorString)))
                        )
                        ){
                    StrBuildTemp.append(Temp[i]);
                    StrBuildTemp.append(EncTerminatorString);
                    i++;
                    Flag=true;
                }else {
                    if((i >0)&&(!StrBuildTemp.toString().endsWith(EncTerminatorString))){
                        StrBuildTemp.append(EncTerminatorString);
                    }
                    Flag=false;
                }
                
                // Adding Sucessive Chars
                
                for (int j = 0; (Flag==true)&&(j < SuccessiveCharsLenSim); j++) {
                    // Weak Junk Char BUT AVOIDS INFINITY
                    if (DiffusionOperator=='+'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharSim+SuccessiveCharsIncrementSim;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) + SuccessiveCharsIncrementSim;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp += SuccessiveCharsIncrementSim;
                        }
                    }
                    else if (DiffusionOperator=='-'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharSim-SuccessiveCharsIncrementSim;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) - SuccessiveCharsIncrementSim;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp -= SuccessiveCharsIncrementSim;
                        }
                    }
                    else if (DiffusionOperator=='*'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharSim*SuccessiveCharsIncrementSim;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) * SuccessiveCharsIncrementSim;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp *= SuccessiveCharsIncrementSim;
                        }
                    }
                    else if (DiffusionOperator=='/'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharSim/SuccessiveCharsIncrementSim;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) / SuccessiveCharsIncrementSim;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp /= SuccessiveCharsIncrementSim;
                        }
                    }
                    StrBuildTemp.append(MyTemp);
                    StrBuildTemp.append(EncTerminatorString);
                }
            }
            EncryptedMesg=StrBuildTemp;
            Encryption.ReWork("DiffusionJunkSimEncrypt");
            NewEncryptedMesg=new StringBuilder(EncryptedMesg);
            return NewEncryptedMesg;
    }
    
    public static StringBuilder DiffusionJunkWeiBullEncrypt(StringBuilder NewEncryptedMesg, String EncondingType,  boolean SilentFlag){
        String[] Temp = new String[NewEncryptedMesg.length()];
        String Exprn1=NewEncryptedMesg.toString();
        //System.out.println("Sender:DiffusionJunkWeiBullEncrypt:variables");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn1.split(EncTerminatorString);
            for (int i = 0; ((SilentFlag == false)&&(i < Temp.length) ); i++) {
                if (SilentFlag == false) {
                    System.out.println("ConfusionWeiBull:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length) ); i++) {
                Temp[i] = "" + Exprn1.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("ConfusionWeiBull:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
            // Adding Sucessive Junk Char
            // Add Confusion && Diffusion
            NewEncryptedMesg = new StringBuilder("");
            boolean Flag=false;
            Double MyTemp=0.0;
            for(int i=0; i < Temp.length; ){
                Flag=false;
                if ((Temp[i] != null) 
                        && (!Temp[i].equalsIgnoreCase("")) 
                        && (Double.isFinite(Double.valueOf(Temp[i]))) ){
                    NewEncryptedMesg.append(Temp[i]);
                    NewEncryptedMesg.append(EncTerminatorString);
                    i++;
                    Flag=true;
                }
                // Adding Sucessive Chars
                
                for (int j = 0; (Flag==true)&&(j < SuccessiveCharsLenWeiBull); j++) {
                    // Weak Junk Char BUT AVOIDS INFINITY
                    if (DiffusionOperator=='+'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharWeiBull+SuccessiveCharsIncrementWeiBull;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) + SuccessiveCharsIncrementWeiBull;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp += SuccessiveCharsIncrementWeiBull;
                        } 
                    }
                    else if (DiffusionOperator=='-'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharWeiBull-SuccessiveCharsIncrementWeiBull;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) - SuccessiveCharsIncrementWeiBull;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp -= SuccessiveCharsIncrementWeiBull;
                        }
                    }
                    else if (DiffusionOperator=='*'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharWeiBull*SuccessiveCharsIncrementWeiBull;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) * SuccessiveCharsIncrementWeiBull;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp *= SuccessiveCharsIncrementWeiBull;
                        }
                    }
                    else if (DiffusionOperator=='/'){
                        if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar"))
                            MyTemp=1.0*TheFOBRandomCharWeiBull/SuccessiveCharsIncrementWeiBull;
                        else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                                Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                                MyTemp = 1.0 * ((char) Xn_LCG) / SuccessiveCharsIncrementWeiBull;
                        }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                                MyTemp /= SuccessiveCharsIncrementWeiBull;
                        }
                    }
                    NewEncryptedMesg.append(MyTemp);
                    NewEncryptedMesg.append(EncTerminatorString);
                }
            }
            EncryptedMesg=NewEncryptedMesg;
            Encryption.ReWork("DiffusionJunkWeiBullEncrypt");
            NewEncryptedMesg=new StringBuilder(EncryptedMesg);
            
            return NewEncryptedMesg;
    }
    public static StringBuilder DiffusionJunkSimDecrypt(String Exprn,String EncondingType, boolean SilentFlag){
        DecryptedMesg=new StringBuilder(Exprn);
        String[] Temp = new String[Exprn.length()];
        //System.out.println("Receiver:DiffusionJunkSimDecrypt:variables");
        //variables.forEach((key,value)-> System.out.println(key + " " + value));
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = DecryptedMesg.toString().split(DeTerminatorString);
            for (int i = 0; (i < Temp.length); i++) {
                if((Temp[i].contains(","))){
                    Temp[i]=Decryption.ReWorkLowLevel(Temp[i],",");
                }else if ((Temp[i].contains("@"))){
                    Temp[i]=Decryption.ReWorkLowLevel(Temp[i],"@");
                }
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkSimDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length) ); i++) {
                Temp[i] = "" + Exprn.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkSimDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
            // Remove Sucessive Junk Char
            // Removing Sucessive Junk Chars
            for(int i=0; i < Temp.length; ){
                if ((Temp[i] != null) 
                        && (!Temp[i].equalsIgnoreCase("")) 
                        && (Double.isFinite(Double.valueOf(Temp[i]))) ){
                    NewEncryptedMesg.append(Temp[i]);
                    NewEncryptedMesg.append(DeTerminatorString);
                   }
                i=i+SuccessiveCharsLenSim+1;
            }
            if (SuppressSystemOutput==false)
                System.out.println("DiffusionJunkSimDecrypt:NewEncryptedMesg:length=" + NewEncryptedMesg.length() + " NewEncryptedMesg=" + NewEncryptedMesg);
            String[] MyCharDropped=NewEncryptedMesg.toString().split(DeTerminatorString);
            if (SuppressSystemOutput==false)
                System.out.println("DiffusionJunkSimDecrypt:MyCharDropped:length=" + MyCharDropped.length);
            return NewEncryptedMesg;
    }
    public static StringBuilder DiffusionJunkWeiBullDecrypt(StringBuilder Exprn,String EncondingType, boolean SilentFlag){
        DecryptedMesg=Exprn;
        String[] Temp = new String[DecryptedMesg.length()];
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = DecryptedMesg.toString().split(DeTerminatorString);
            for (int i = 0; (i < Temp.length); i++) {
                if((Temp[i].contains(","))){
                    Temp[i]=Decryption.ReWorkLowLevel(Temp[i],",");
                }else if ((Temp[i].contains("@"))){
                    Temp[i]=Decryption.ReWorkLowLevel(Temp[i],"@");
                }
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkWeiBullDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length) ); i++) {
                Temp[i] = "" + DecryptedMesg.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkWeiBullDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
            // Remove Sucessive Junk Char
            // Removing Sucessive Junk Chars
            for(int i=0; i < Temp.length; ){
                   if ((Temp[i] != null) 
                        && (!Temp[i].equalsIgnoreCase("")) 
                        && (Double.isFinite(Double.valueOf(Temp[i]))) ){
                    NewEncryptedMesg.append(Temp[i]);
                    NewEncryptedMesg.append(DeTerminatorString);
                    }
                    i=i+SuccessiveCharsLenWeiBull+1;
              }
            return NewEncryptedMesg;
    }
}
