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
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.c;
import static Security.Configuration.FOBRandomChar;
import static Security.Decryption.DecryptPerfFLAG;
import static Security.Encryption.EncryptPerfFLAG;
import static Security.Encryption.EncryptStrFuncTimeTaken;
import static Security.Decryption.DecryptStrFuncTimeTaken;
import static Security.PacketSynchronizedAlgebraicCipher.myPrivKy;
import static Security.Security.MySimple;
import static Security.Security.MySimpleWeiBull;
import static Security.Security.ScramVarGapExprn;
import static Security.Security.Xn_LCG;
import static Security.Security.varOccassion;
import static Security.Configuration.MessageInvariant;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class LowLevelSecurityFramework {

    public static Logger log = Logger.getLogger(LowLevelSecurityFramework.class.getName());
    //FOBRandomChar:This is slower
    //FOBStandardChar:This is faster
    
    //public static int TheFOBRandomChar = '$';//Valid Values are : @ :OR ANY OTHER CHAR
    public static int TheFOBRandomCharSim = ',';//Valid Values are : @ :OR ANY OTHER CHAR
    public static int TheFOBRandomCharWeiBull = '$';//Valid Values are : @ :OR ANY OTHER CHAR
    public static int TheFOBRandomCharRotate = '@';//Valid Values are : @ :OR ANY OTHER CHAR
    public static int TheFOBRandomCharScram = ':';//Valid Values are : @ :OR ANY OTHER CHAR
    public static int UnicityForEnglish=28;// Standard Unicity distance for English Language:27.6
    
    public static Double OccaLowerLimitFE = 0.1000;//0.5100;//0.9500;
    public static Double OccaUpperLimitFE = 1.5100;//1.03;
    public static Double OccaLowerLimitSE = 0.01500;//0.9500;
    public static Double OccaUpperLimitSE = 1.10;//1.03;

    public static Double ShannonEncryption(String AlgoName, Double Value, String Exprn, String DiffWithRespTo) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        boolean SilentFlag = true;
        variablesEncrypt.put(DiffWithRespTo, Value);
        if (SilentFlag == false) {
            System.out.println("ShannonEncryption:Before parse:Value=" + Value);
            variablesEncrypt.forEach((key, value) -> {
                System.out.println("ShannonEncryption:variable left=" + key + " value=" + value);
            }
            );
            System.out.println("ShannonEncryption:Before parse:Exprn=" + Exprn);
            System.out.println("ShannonEncryption:Before parse:DiffWithRespTo=" + DiffWithRespTo);
        }
        LCGexpValue = parse(Exprn, variablesEncrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        variablesEncrypt.remove(DiffWithRespTo);
        if (SilentFlag == false) {
            System.out.println("ShannonEncryption:After parse:RetValue=" + RetValue);
        }
        return RetValue;
    }

    public static Double ShannonDecryption(String AlgoName, Double Value, String Exprn, String DiffWithRespTo) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        variablesDecrypt.put(DiffWithRespTo, Value);
        LCGexpValue = parse(Exprn, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        variablesDecrypt.remove(DiffWithRespTo);
        return RetValue;
    }

    

    public static Double OccasionalismEncryptionFEvent(String AlgoName, Double Value, String Exprn, String DiffWithRespTo) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        varOccassion.put(DiffWithRespTo, Value);
        LCGexpValue = parse(Exprn, varOccassion, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        varOccassion.remove(DiffWithRespTo);
        return RetValue;
    }

    public static Double OccasionalismDecryptionFEvent(String AlgoName, Double Value, String Exprn, String DiffWithRespTo) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        varOccassion.put(DiffWithRespTo, Value);
        LCGexpValue = parse(Exprn, varOccassion, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        varOccassion.remove(DiffWithRespTo);
        return RetValue;
    }

    public static Double OccasionalismEncryptionSEvent(String AlgoName, Double Value, String Exprn, String DiffWithRespTo) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        varOccassion.put(DiffWithRespTo, Value);
        LCGexpValue = parse(Exprn, varOccassion, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        varOccassion.remove(DiffWithRespTo);
        return RetValue;
    }

    public static Double OccasionalismDecryptionSEvent(String AlgoName, Double Value, String Exprn, String DiffWithRespTo) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        varOccassion.put(DiffWithRespTo, Value);
        LCGexpValue = parse(Exprn, varOccassion, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        varOccassion.remove(DiffWithRespTo);
        return RetValue;
    }

    //Zeroth Equation
    public static String FormOccasionEqnFEvent(String DiffWithRespTo, Double Sender, Double Receiver, int MessageLen, Double OTP, Double Occasion, String[] argsXn) {
        String Equation = "";
        // Sender State Value
        String Order = "";
        String CoefficientOrder = "";
        Equation = "Sender" + CoefficientOrder + "*" + DiffWithRespTo + "1" + Order;
        varOccassion.put("Sender", Sender);
        varOccassion.put(DiffWithRespTo + "1", 1.0);

        // MessageLength State Value
        Order = "^2";
        CoefficientOrder = "^3";
        Equation += "+" + "MessageLen" + CoefficientOrder + "*" + DiffWithRespTo + "2" + Order;
        varOccassion.put("MessageLen", MessageLen * 1.0);
        if (MessageInvariant.equalsIgnoreCase("MessageInvariant")) {
            varOccassion.put(DiffWithRespTo + "2", 0.0);
        } else if (MessageInvariant.equalsIgnoreCase("MessageVariant")) {
            varOccassion.put(DiffWithRespTo + "2", 1.0);
        } else {
            varOccassion.put(DiffWithRespTo + "2", 2.0);
        }

        // OTP State Value
        Order = "^3";
        CoefficientOrder = "^3";
        Equation += "+" + "OTP" + CoefficientOrder + "*" + DiffWithRespTo + "3" + Order;
        varOccassion.put("OTP", OTP);
        varOccassion.put(DiffWithRespTo + "3", 1.0);

        // Receiver State Value
        Order = "";
        CoefficientOrder = "";
        Equation += "+" + "Receiver" + CoefficientOrder + "*" + DiffWithRespTo + "4" + Order;
        varOccassion.put("Receiver", Receiver);
        varOccassion.put(DiffWithRespTo + "4", 1.0);

        // Occasion State Value
        Order = "";
        CoefficientOrder = "^6";
        Equation += "+" + "Occasion" + CoefficientOrder + "*" + DiffWithRespTo + "5" + Order;
        varOccassion.put("Occasion", Occasion);
        varOccassion.put(DiffWithRespTo + "5", 1.0);

        // VarArgs Loop
        // VarArgs State Value
        Order = "";
        CoefficientOrder = "";
        for (int i = 0, j = 6; i < argsXn.length; i += 2, j++) {
            Equation += "+" + argsXn[i] + CoefficientOrder + "*" + DiffWithRespTo + (j) + Order;
            varOccassion.put(argsXn[i], Double.parseDouble(argsXn[i + 1]));
            varOccassion.put(DiffWithRespTo + (j), 1.0);
            //System.out.println("FormOccasionEqnFEvent:First Event:argsXn["+ i + "]=" + argsXn[i] + " Value=" + argsXn[i+1]);
        }

        return Equation;
    }

    //Zeroth Equation
    public static String FormOccasionEqnSEvent(String DiffWithRespTo, Double Sender, Double Receiver, int MessageLen, Double OTP, Double Occasion, String[] argsXn) {
        String Equation = "";
        // Sender State Value
        String Order = "";
        String CoefficientOrder = "";
        Equation = "Sender" + CoefficientOrder + "*" + DiffWithRespTo + "1" + Order;
        varOccassion.put("Sender", Sender);
        varOccassion.put(DiffWithRespTo + "1", 1.0);

        // MessageLength State Value
        Order = "^3";
        CoefficientOrder = "^3";
        Equation += "+" + "MessageLen" + CoefficientOrder + "*" + DiffWithRespTo + "2" + Order;
        varOccassion.put("MessageLen", MessageLen * 1.0);
        if (MessageInvariant.equalsIgnoreCase("MessageInvariant")) {
            varOccassion.put(DiffWithRespTo + "2", 0.0);
        } else if (MessageInvariant.equalsIgnoreCase("MessageVariant")) {
            varOccassion.put(DiffWithRespTo + "2", 1.0);
        } else {
            varOccassion.put(DiffWithRespTo + "2", 2.0);
        }

        // OTP State Value
        Order = "^2";
        CoefficientOrder = "^2";
        Equation += "+" + "OTP" + CoefficientOrder + "*" + DiffWithRespTo + "3" + Order;
        varOccassion.put("OTP", OTP);
        varOccassion.put(DiffWithRespTo + "3", 1.0);

        // Receiver State Value
        Order = "";
        CoefficientOrder = "";
        Equation += "+" + "Receiver" + CoefficientOrder + "*" + DiffWithRespTo + "4" + Order;
        varOccassion.put("Receiver", Receiver);
        varOccassion.put(DiffWithRespTo + "4", 1.0);

        // Occasion State Value
        Order = "";
        CoefficientOrder = "^6";
        Equation += "+" + "Occasion" + CoefficientOrder + "*" + DiffWithRespTo + "5" + Order;
        varOccassion.put("Occasion", Occasion);
        varOccassion.put(DiffWithRespTo + "5", 1.0);

        // VarArgs Loop
        // VarArgs State Value
        Order = "";
        CoefficientOrder = "";
        for (int i = 0, j = 5; i < argsXn.length; i += 2, j++) {
            Equation += "+" + argsXn[i] + CoefficientOrder + "*" + DiffWithRespTo + (j) + Order;
            varOccassion.put(argsXn[i], Double.parseDouble(argsXn[i + 1]));
            varOccassion.put(DiffWithRespTo + (j), 1.0);
            //System.out.println("FormOccasionEqnSEvent:Second Event:argsXn["+ i + "]=" + argsXn[i] + " Value=" + argsXn[i+1]);

        }
        return Equation;
    }

    public static boolean CauseFirstEventNNCReceiver(Double SenderFirstEvent, Double FirstEvent) {
        String StrSenderFirstEvent=""+SenderFirstEvent;
        String StrFirstEvent=""+FirstEvent;
        Double MySFEDBL=0.0;
        Double MyFEDBL=0.0;
        String[] DataTempStrSplitSFE=StrSenderFirstEvent.split("E");
        String[] DataTempStrSplitFE=StrFirstEvent.split("E");
        boolean FlagReverseCond=false;
        
        if ((SenderFirstEvent.doubleValue() != 0.0)
                && (SenderFirstEvent.doubleValue() == FirstEvent.doubleValue())) {
            return true;// Channel is OK for Communication
        }
        else if ((SenderFirstEvent.doubleValue() != 0.0)
                // At the First Event Stage
                // You can only add pad char to the Message Length: 
                // Trim is the only other option to delete chars and that too only for white space chars
                && (FirstEvent.doubleValue() > (OccaLowerLimitFE * SenderFirstEvent.doubleValue()))
                && (FirstEvent.doubleValue() < (OccaUpperLimitFE * SenderFirstEvent.doubleValue()))) {
            return true;// Channel is OK for Communication
        }else if((SenderFirstEvent.doubleValue() != 0.0)
                && (SenderFirstEvent.doubleValue() != FirstEvent.doubleValue()) ){
           if ( (DataTempStrSplitSFE.length==DataTempStrSplitFE.length) && (DataTempStrSplitSFE.length > 1)){
               if (DataTempStrSplitSFE[1].equalsIgnoreCase(DataTempStrSplitFE[1]) ){// Both Exponents are same Order
                   if ( Double.parseDouble(DataTempStrSplitSFE[0]) < (Double.parseDouble(DataTempStrSplitFE[0]))  ){
                       FlagReverseCond=true;
                       System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism:Condition Reversed:First Event: SenderFirstEvent=" + SenderFirstEvent + " FirstEvent=" + FirstEvent + ConsoleColors.RESET);
                   }
                   MySFEDBL=Double.parseDouble(DataTempStrSplitSFE[0]);
                   MyFEDBL=Double.parseDouble(DataTempStrSplitFE[0]);
               }
           }
           if((FlagReverseCond==true) && ( (MyFEDBL*OccaLowerLimitFE)<(MySFEDBL))
                   &&(MyFEDBL*OccaUpperLimitFE)>(MySFEDBL)){
               return true;
           }else if ( ( (MyFEDBL*OccaLowerLimitFE)<(MySFEDBL) && (myPrivKy<=75) )
                          && ((MyFEDBL*OccaUpperLimitFE)>(MySFEDBL)) ){
               System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism:Condition Reveresed:Low Key Length:First Event: MySFEDBL=" + MySFEDBL + " MyFEDBL=" + MyFEDBL + ConsoleColors.RESET);
               return true;
           }else if ( (MySFEDBL==0.0)&&(MyFEDBL==0.0)){
               // Exponents are not equal
               // Has to be reworked.
               return true;
           }
           System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism:Condition Failed:First Event: MySFEDBL=" + MySFEDBL + " MyFEDBL=" + MyFEDBL + ConsoleColors.RESET);
           return false;
        } else {
            System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism failed:First Event: SenderFirstEvent=" + SenderFirstEvent + " FirstEvent=" + FirstEvent + ConsoleColors.RESET);
            return false;
        }
        
    }

    public static boolean CauseSecondEventNNCReceiver(Double SenderSecondEvent, Double SecondEvent) {
        if ((SenderSecondEvent.doubleValue() != 0.0)
                && (SenderSecondEvent.doubleValue() == SecondEvent.doubleValue())) {
            return true;// Channel is OK for Communication
        } else if ((SenderSecondEvent.doubleValue() != 0.0)
                &&(MessageInvariant.equalsIgnoreCase("MessageInvariant"))
                && (SecondEvent.doubleValue() > (OccaLowerLimitSE * SenderSecondEvent.doubleValue()))
                && (SecondEvent.doubleValue() < (OccaUpperLimitSE * SenderSecondEvent.doubleValue()))
                ){
            return true;// Channel is OK for Communication
        } else if ((SenderSecondEvent.doubleValue() != 0.0)
                &&(MessageInvariant.equalsIgnoreCase("MessageVariant"))
                && (SecondEvent.doubleValue() > (OccaLowerLimitSE * SenderSecondEvent.doubleValue()))
                && (SecondEvent.doubleValue() < (OccaUpperLimitSE * SenderSecondEvent.doubleValue()))
                ){
            return true;// Channel is OK for Communication
        }else if ((SenderSecondEvent.doubleValue() != 0.0)
                &&(MessageInvariant.equalsIgnoreCase("MessageVariant"))
                && (SenderSecondEvent.doubleValue() > (OccaLowerLimitSE * SecondEvent.doubleValue()))
                && (SenderSecondEvent.doubleValue() < (OccaUpperLimitSE * SecondEvent.doubleValue()))
                ){
            System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism:Second Event:REDUCED REVERSED: SenderSecondEvent=" + SenderSecondEvent + " SecondEvent=" + SecondEvent + ConsoleColors.RESET);
            return true;// Channel is OK for Communication
        }else if ((SenderSecondEvent.doubleValue() != 0.0)
                &&(MessageInvariant.equalsIgnoreCase("MessageVariant"))
                ){
            System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism:Second Event:REDUCED: SenderSecondEvent=" + SenderSecondEvent + " SecondEvent=" + SecondEvent + ConsoleColors.RESET);
            return true;// Channel is OK for Communication
        } else {
            System.out.println(ConsoleColors.RED + "DecryptMessage:Occasionalism failed:Second Event: SenderSecondEvent=" + SenderSecondEvent + " SecondEvent=" + SecondEvent + ConsoleColors.RESET);
            return false;
        }
    }

    //Diff Equation :First Event
    public static String FormOccasionDiffEqnFEvent(String DiffWithRespTo, Double Sender, Double Receiver, int MessageLen, Double OTP, String[] argsXn) {
        String Equation = "";
        // Sender State Value
        String Order = "";
        String CoefficientOrder = "";
        Equation = "Sender" + CoefficientOrder + "*" + DiffWithRespTo + "1" + Order;
        varOccassion.put("Sender", Sender);
        varOccassion.put(DiffWithRespTo + "1", 1.0);

        // MessageLength State Value
        Order = "";
        CoefficientOrder = "";
        Equation += "+" + "MessageLen" + CoefficientOrder + "*" + DiffWithRespTo + "2" + Order;
        varOccassion.put("MessageLen", MessageLen * 1.0);
        varOccassion.put(DiffWithRespTo + "2", 1.0);

        // OTP State Value
        Order = "^3";
        CoefficientOrder = "";
        Equation += "+" + "OTP" + CoefficientOrder + "*" + DiffWithRespTo + "3" + Order;
        varOccassion.put("OTP", OTP);
        varOccassion.put(DiffWithRespTo + "3", 1.0);

        // Receiver State Value
        Order = "";
        CoefficientOrder = "";
        Equation += "+" + "Receiver" + CoefficientOrder + "*" + DiffWithRespTo + "4" + Order;
        varOccassion.put("Receiver", Receiver);
        varOccassion.put(DiffWithRespTo + "4", 1.0);

        // VarArgs Loop
        // VarArgs State Value
        Order = "";
        CoefficientOrder = "";
        for (int i = 0, j = 5; i < argsXn.length; i += 2, j++) {
            Equation += "+" + argsXn[i] + CoefficientOrder + "*" + DiffWithRespTo + (j) + Order;
            varOccassion.put(argsXn[i], Double.parseDouble(argsXn[i + 1]));
            varOccassion.put(DiffWithRespTo + (j), 1.0);
            //System.out.println("FormOccasionDiffEqnFEvent:First Event:argsXn["+ i + "]=" + argsXn[i] + " Value=" + argsXn[i+1]);
        }

        // Random State Value
        Double Random = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        CoefficientOrder = "";
        Equation += "+" + "Random" + CoefficientOrder;
        varOccassion.put("Random", Random);
        //System.out.println("FormOccasionDiffEqnFEvent:First Event:Random=" + Random);
        return Equation;
    }
    //Diff Equation :Second Event

    public static String FormOccasionDiffEqnSEvent(String DiffWithRespTo, Double Sender, Double Receiver, int MessageLen, Double OTP, String[] argsXn) {
        String Equation = "";
        // Sender State Value
        String Order = "";
        String CoefficientOrder = "";
        Equation = "Sender" + CoefficientOrder + "*" + DiffWithRespTo + "1" + Order;
        varOccassion.put("Sender", Sender);
        varOccassion.put(DiffWithRespTo + "1", 1.0);

        // MessageLength State Value
        Order = "";
        CoefficientOrder = "";
        Equation += "+" + "MessageLen" + CoefficientOrder + "*" + DiffWithRespTo + "2" + Order;
        varOccassion.put("MessageLen", MessageLen * 1.0);
        varOccassion.put(DiffWithRespTo + "2", 1.0);

        // OTP State Value
        Order = "^3";
        CoefficientOrder = "";
        Equation += "+" + "OTP" + CoefficientOrder + "*" + DiffWithRespTo + "3" + Order;
        varOccassion.put("OTP", OTP);
        varOccassion.put(DiffWithRespTo + "3", 1.0);

        // Receiver State Value
        Order = "";
        CoefficientOrder = "";
        Equation += "+" + "Receiver" + CoefficientOrder + "*" + DiffWithRespTo + "4" + Order;
        varOccassion.put("Receiver", Receiver);
        varOccassion.put(DiffWithRespTo + "4", 1.0);

        // VarArgs Loop
        // VarArgs State Value
        Order = "";
        CoefficientOrder = "";
        for (int i = 0, j = 5; i < argsXn.length; i += 2, j++) {
            Equation += "+" + argsXn[i] + CoefficientOrder + "*" + DiffWithRespTo + (j) + Order;
            varOccassion.put(argsXn[i], Double.parseDouble(argsXn[i + 1]));
            varOccassion.put(DiffWithRespTo + (j), 1.0);
            //System.out.println("FormOccasionDiffEqnFEvent:First Event:argsXn["+ i + "]=" + argsXn[i] + " Value=" + argsXn[i+1]);
        }

        // Random State Value
        Double Random = (double) MySimpleWeiBull.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
        CoefficientOrder = "";
        Equation += "+" + "Random" + CoefficientOrder;
        varOccassion.put("Random", Random);
        //System.out.println("FormOccasionDiffEqnSEvent:Second Event:Random=" + Random);
        return Equation;
    }

    public static char[] Scram(String MyMesg, boolean SilentFlag) {
        int m = 3;
        int DataLimit = MyMesg.length() * m;
        String Exprn = "m*Xn";
        String DiffWithRespTo = "Xn";
        char[] Data = new char[MyMesg.length() * m];
        for (int i = 0, j = 0, n = 1; (i < MyMesg.length()) && (j < DataLimit); n = 1, i++) {
            j = i;
            // General Solution to Transposition Scrambling
            if ((j > 0) && (DataLimit <= Data.length) && (i < MyMesg.length()) && (j < DataLimit)) {
                Data[j] = '@';
            }
            if ((j > 0) && (DataLimit <= Data.length) && (i < MyMesg.length()) && (j < DataLimit)) {
                Data[ScramPosition(n, MyMesg.length(), j, SilentFlag)] = MyMesg.charAt(i);
            }
            n++;
            if ((j > 0) && (DataLimit <= Data.length) && (i < MyMesg.length()) && (j < DataLimit)) {
                Data[ScramPosition(n, MyMesg.length(), j, SilentFlag)] = '@';
            }
            // Particular Solution to Transposition Scrambling
            if ((j == 0)) {
                Data[j] = '@';
                Data[ScramPosition((n - 1), MyMesg.length(), j, SilentFlag)] = MyMesg.charAt(i);
                Data[n * MyMesg.length()] = '@';
            }
        }
        return Data;
    }

    public static String UnScram(String Mesg, boolean SilentFlag) {
        int m = 3;
        int UnScramMesgLen = Mesg.length() / m;
        String Exprn = "1/m*Xn";
        String DiffWithRespTo = "Xn";

        int UnScramPosBegin = UnScramPosition(UnScramMesgLen, SilentFlag);
        int UnScramPosEnd = UnScramPosition(UnScramMesgLen, SilentFlag) * (m - 1);

        String UnScrambMesg = Mesg.substring(UnScramPosBegin, UnScramPosEnd);
        return UnScrambMesg;
    }

    public static int ScramPosition(int n, int MesgLen, int MyMesgPos, boolean SilentFlag) {

        return n * MesgLen + MyMesgPos;
    }

    public static int UnScramPosition(int MesgLen, boolean SilentFlag) {

        return MesgLen;
    }

    // Below Functions Scramble by adding a variable length gap char 
    // between 2 valid message characters
    public static char[] ScramVarGap(String MyMesg, boolean SilentFlag) {
        int m = 3;
        int c = 5;
        int DataLimit = MyMesg.length() * m;
        ScramVarGapExprn = "m*Xn+c";
        String DiffWithRespTo = "Xn";
        char[] Data = new char[MyMesg.length() * m + c];
        boolean Flag = false;
        int z = 0;
        for (int i = 0, j = 0, n = 1; (i < MyMesg.length()) && (j < DataLimit); n = 1, i++, Flag = false, z = 0) {
            j = i;
            // General Solution to Transposition Scrambling
            if ((j > 0) && (DataLimit <= Data.length) && (i < MyMesg.length()) && (j < DataLimit)) {
                z = ScramPositionVarGap(m, n, c, MyMesg.length(), j, ScramVarGapExprn, DiffWithRespTo, SilentFlag);
                if (FOBRandomChar.equalsIgnoreCase("FOBRandomChar")) {
                    for (int k = 1; (k < m) && ((z - k) > 0); k++) {
                        if ((k < 2) && (i < (UnicityForEnglish) ) )
                            Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        else
                            Xn_LCG++;
                        Data[z - k] = (char) Xn_LCG;
                    }
                } else if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                    for (int k = 1; (k < m) && ((z - k) > 0); k++) {
                        Data[z - k] = (char)TheFOBRandomCharScram;
                    }
                }
                Data[z] = MyMesg.charAt(i);
                Flag = true;
                if (FOBRandomChar.equalsIgnoreCase("FOBRandomChar")) {
                    for (int k = 1; k < m; k++) {
                        if (k < 2)
                            Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        else
                            Xn_LCG++;
                        Data[z + k] = (char) Xn_LCG;
                    }
                } else if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                    for (int k = 1; k < m; k++) {
                        Data[z + k] = (char)TheFOBRandomCharScram;
                    }
                }
            }
            n++;

            // Particular Solution to Transposition Scrambling
            if ((j == 0)) {
                z = ScramPositionVarGap(m, (n - 1), c, MyMesg.length(), j, ScramVarGapExprn, DiffWithRespTo, SilentFlag);
                if (FOBRandomChar.equalsIgnoreCase("FOBRandomChar")) {
                    for (int k = 0; (k < z); k++) {
                        Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        Data[k] = (char) Xn_LCG;
                    }
                } else if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                    for (int k = 0; (k < z); k++) {
                        Data[k] = (char)TheFOBRandomCharScram;
                    }
                }
                Data[z] = MyMesg.charAt(i);
                if (FOBRandomChar.equalsIgnoreCase("FOBRandomChar")) {
                    for (int k = 1; (k < m) && ((z + k) > 0); k++) {
                        Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        Data[z + k] = (char) Xn_LCG;
                    }
                } else if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                    for (int k = 1; (k < m) && ((z + k) > 0); k++) {
                        Data[z + k] = (char)TheFOBRandomCharScram;
                    }
                }
            }
        }
        return Data;
    }

    public static int UnScramVarGap(int i, StringBuilder Mesg, boolean SilentFlag) {
        int m = 3;
        int c = 5;
        int UnScramMesgLen = Mesg.length() / m;
        String Exprn = "y/m-c/m";
        String DiffWithRespTo = "y";

        int UnScramPosBegin = UnScramPositionVarGap(i, m, 2, c, UnScramMesgLen, Exprn, DiffWithRespTo, SilentFlag);
        int UnScrambMesg = 0;
        if (UnScramPosBegin > 0) {
            UnScrambMesg = Mesg.charAt(UnScramPosBegin);
            return UnScrambMesg;
        }else
            return -1;
    }

    public static int ScramPositionVarGap(int m, int n, int c, int MesgLen, int MyMesgPos, String Exprn, String DiffWithRespTo, boolean SilentFlag) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        variablesEncrypt.put(DiffWithRespTo, MyMesgPos * 1.0);
        variablesEncrypt.put("m", m * 1.0);
        variablesEncrypt.put("n", n * 2.0);
        variablesEncrypt.put("c", c * 1.0);
        if (SilentFlag == false) {
            System.out.println("ScramPositionVarGap:Before parse:MesgLen=" + MyMesgPos);
            variablesEncrypt.forEach((key, value) -> {
                System.out.println("ScramPositionVarGap:variable left=" + key + " value=" + value);
            }
            );
            System.out.println("ScramPositionVarGap:Before parse:Exprn=" + Exprn);
            System.out.println("ScramPositionVarGap:Before parse:DiffWithRespTo=" + DiffWithRespTo);
        }
        LCGexpValue = parse(Exprn, variablesEncrypt, DiffWithRespTo,false, "Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        variablesEncrypt.remove("c");
        variablesEncrypt.remove("n");
        variablesEncrypt.remove("m");
        variablesEncrypt.remove(DiffWithRespTo);

        if (SilentFlag == false) {
            System.out.println("ScramPositionVarGap:After parse:RetValue=" + RetValue + " char=" + (char)RetValue.intValue());
        }
        return RetValue.intValue();
    }

    public static int UnScramPositionVarGap(int i, int m, int n, int c, int MesgLen, String Exprn, String DiffWithRespTo, boolean SilentFlag) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        variablesDecrypt.put(DiffWithRespTo, i * 1.0);
        variablesDecrypt.put("m", m * 1.0);
        variablesDecrypt.put("n", n * 2.0);
        variablesDecrypt.put("c", c * 1.0);
        if (SilentFlag == false) {
            System.out.println("UnScramPositionVarGap:Before parse:MesgLen=" + MesgLen);
            variablesDecrypt.forEach((key, value) -> {
                System.out.println("UnScramPositionVarGap:variablesDecrypt left=" + key + " value=" + value);
            }
            );
            System.out.println("UnScramPositionVarGap:Before parse:Exprn=" + Exprn);
            System.out.println("UnScramPositionVarGap:Before parse:DiffWithRespTo=" + DiffWithRespTo);
        }
        LCGexpValue = parse(Exprn, variablesDecrypt, DiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
        Double RetValue = LCGexpValue.eval();
        variablesDecrypt.remove("c");
        variablesDecrypt.remove("n");
        variablesDecrypt.remove("m");
        variablesDecrypt.remove(DiffWithRespTo);
        if (SilentFlag == false) {
            System.out.println("UnScramPositionVarGap:After parse:RetValue=" + RetValue);
        }
        //return RetValue.intValue();
        if (((i - c) >= 0) && (((i - c) % m) == 0)) {
            return i;
        } else {
            return -1;
        }
    }

    public static String SplitEncryptDBl(String Exprn, boolean SilentFlag) {
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            EncryptStrFuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(EncryptStrFuncTimeTaken)));
        }
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValue2 = (() -> 0.0);
        if (SilentFlag == false) {
            System.out.println("SplitEncryptDBl:Message:Exprn=" + Exprn);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        String TotalEncryptedMesg = "";
        if ((Exprn.equalsIgnoreCase("")) || (Exprn == null)) {
            return TotalEncryptedMesg;
        }
        String[] Temp = Exprn.split(",@");
        if (SilentFlag == false) {
            System.out.println("SplitEncryptDBl:MessageBytes:Temp=" + Temp[0]);
        }
        int NumOfCharsMesg = Temp.length;
        for (int MesgIndex = 0; (MesgIndex < NumOfCharsMesg); MesgIndex++) {
            String[] DBlSplit = Temp[MesgIndex].split("E");
            int NumOfCharsInDBl = DBlSplit.length;
            if (NumOfCharsInDBl == 2) {
                NewEncryptedMesg.append(DBlSplit[0]).append(",@").append(DBlSplit[1]).append(",@");
            }
            else if((NumOfCharsInDBl==1)||(NumOfCharsInDBl==-1)||(NumOfCharsInDBl==0))
                NewEncryptedMesg.append(Temp[MesgIndex]).append("E0").append(",@");
            if (SilentFlag == false) {
                System.out.println("SplitEncryptDBl:Message:Temp[" + MesgIndex + "]=" + Temp[MesgIndex] );
            }
        }
        if (SilentFlag == false) {
            System.out.println("SplitEncryptDBl:Final:NewEncryptedMesg=" + NewEncryptedMesg);
            System.out.println("SplitEncryptDBl:Final:NumOfCharsMesg=" + NumOfCharsMesg);
        }
        if ((EncryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            EncryptStrFuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(EncryptStrFuncTimeTaken)));
        }
        return NewEncryptedMesg.toString();
    }

    public static String JoinDecryptDBl(String Exprn, boolean SilentFlag) {
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            if (TimeTaken.length == 3) {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                DecryptStrFuncTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
        }
        if (SilentFlag == false) {
            System.out.println("JoinDecryptDBl:Message:Exprn=" + Exprn);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        if ((Exprn.equalsIgnoreCase("")) || (Exprn == null)) {
            return "";
        }
        String[] Temp = Exprn.split(",@");
        int NumOfChars = Temp.length;
        for (int MesgIndex = 0; (MesgIndex < NumOfChars); MesgIndex += 2) {
            StringBuilder DBlSplit = new StringBuilder("");
            if (((MesgIndex+1) < NumOfChars)&&(!Temp[MesgIndex + 1].contains(".")) && (!Temp[MesgIndex + 1].contains("E"))) {
                DBlSplit.append(Temp[MesgIndex]).append("E").append(Temp[MesgIndex + 1]);
            } else {
                if( ((MesgIndex+1) < NumOfChars)&&(Temp[MesgIndex + 1].endsWith(".0")) ){
                    Temp[MesgIndex + 1]=Temp[MesgIndex + 1].replaceFirst(".0", "");
                }
                if( ((MesgIndex+1) < NumOfChars)&&(!Temp[MesgIndex + 1].equalsIgnoreCase(""))&&(!Temp[MesgIndex + 1].endsWith(".0")) )
                    DBlSplit.append(Temp[MesgIndex]).append("E").append(Temp[MesgIndex + 1]);
                else if ( ((MesgIndex+1) < NumOfChars)&&(Temp[MesgIndex + 1].equalsIgnoreCase("")) )
                    DBlSplit.append(Temp[MesgIndex]);
                if (DBlSplit.toString().contains("EE")) {
                    DBlSplit.append(DBlSplit.toString().replaceFirst("EE", "E") );
                }
                if (DBlSplit.toString().endsWith("E")) {
                    DBlSplit.append(DBlSplit.toString().replaceFirst("E", "") );
                }
            }
            if (SilentFlag == false) {
                System.out.println("JoinDecryptDBl:Message:Temp[" + MesgIndex + "]=" + " E Temp[" + (MesgIndex +1)+ "]=" + Temp[MesgIndex+1] + " DBlSplit=" + DBlSplit);
            }

            NewEncryptedMesg.append(DBlSplit).append(",@");
        }
        if (SilentFlag == false) {
            System.out.println("JoinDecryptDBl:Message:Final:NewEncryptedMesg=" + NewEncryptedMesg);
            System.out.println("JoinDecryptDBl:Final:NumOfChars=" + NumOfChars);
        }
        if ((DecryptPerfFLAG == false)) {
            LocalDateTime current = LocalDateTime.now();
            String[] TimeTaken = current.toString().split(":");
            String localStrCurrentTimeTaken = "";
            if (TimeTaken.length == 3) {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0) + (Double.parseDouble(TimeTaken[2])));
            } else {
                localStrCurrentTimeTaken = "" + ((Integer.parseInt(TimeTaken[1]) * 60.0));
            }
            DecryptStrFuncTimeTaken = "" + ((Double.parseDouble(localStrCurrentTimeTaken) - Double.parseDouble(DecryptStrFuncTimeTaken)));
        }
        return NewEncryptedMesg.toString();
    }
}
