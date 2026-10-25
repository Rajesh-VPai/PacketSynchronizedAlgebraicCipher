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
import Calculus.ExprSimpleStrSep;
import Calculus.MathsExpressionParser;
import static Calculus.MathsExpressionParser.parse;
import static RandomNumber.UserResearchStudy.MaxExponent;
import static RandomNumber.UserResearchStudy.Modulus;
import static RandomNumber.UserResearchStudy.ModulusEncrypt;
import static RandomNumber.UserResearchStudy.a;
import static RandomNumber.UserResearchStudy.c;
import static Security.Decryption.DeTerminatorString;
import static Security.Decryption.DecryptedMesg;
import static Security.Encryption.EncTerminatorString;
import static Security.Encryption.EncryptedMesg;
import static Security.EquationPairGeneration.FractionEncryptComputerDiffWithRespTo;
import static Security.EquationPairGeneration.FractionEncryptComputerExprn;
import static Security.EquationPairGeneration.FractionEncryptDiffWithRespTo;
import static Security.EquationPairGeneration.FractionEncryptExprn;
import static Security.Configuration.FOBRandomChar;
import static Security.Configuration.NumberOfFractions;
import static Security.LowLevelSecurityFramework.TheFOBRandomCharRotate;
import static Security.LowLevelSecurityFramework.UnicityForEnglish;
import static Security.PacketSynchronizedAlgebraicCipher.SuppressSystemOutput;
import static Security.Security.MySimple;
import static Security.Security.Xn_LCG;
import static Security.Security.variablesDecrypt;
import static Security.Security.variablesEncrypt;
import static Security.SubstitutionBox.DiffusionOperator;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class TranspositionPBox {

    public static Logger log = Logger.getLogger(TranspositionPBox.class.getName());

    // WorkFactor Variables
    public static int NumberOfSymbols = 10;
    // Column 0 should never start with '0' as 04.0 is changed to 4.0
    public static int[][] MappedCharsMorseCode = {
        {'9', '5', '1', '3', '2', '4', '5', '8', '7', '9'}, // '0'
        {'8', '6', '1', '1', '1', '1', '1', '1', '1', '1'}, // '1'
        {'7', '7', '2', '2', '2', '2', '2', '2', '2', '2'}, // '2'
        {'6', '8', '3', '3', '3', '3', '3', '3', '3', '3'}, // '3'
        {'4', '5', '4', '4', '4', '4', '4', '4', '4', '4'}, // '4'
        {'1', '4', '5', '5', '5', '5', '5', '5', '5', '5'}, // '5'
        {'3', '3', '6', '6', '6', '6', '6', '6', '6', '6'}, // '6'
        {'5', '2', '7', '7', '7', '7', '7', '7', '7', '7'}, // '7'
        {'2', '1', '8', '8', '8', '8', '8', '8', '8', '8'}, // '8'
        {'1', '9', '9', '9', '9', '9', '9', '9', '9', '9'}, // '9'
    };

    // Confusion && Diffusion Low Level Variables
    public static int SuccessiveCharsLenRotate = 2;//5;
    public static int SuccessiveCharsIncrementRotate = 1;//3;
    public static int SuccessiveCharsLenJumble = 2;
    public static int SuccessiveCharsIncrementJumble = 1;

    public static String FractionEncryptN(String Exprn, boolean SilentFlag) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValue2 = (() -> 0.0);
        if (SilentFlag == false) {
            System.out.println("FractionEncryptN:Message:Exprn=" + Exprn);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        StringBuilder TotalEncryptedMesg = new StringBuilder("");
        if ((Exprn.equalsIgnoreCase("")) || (Exprn == null)) {
            return "";
        }
        String[] Temp = Exprn.split(EncTerminatorString);
        if (SilentFlag == false) {
            System.out.println("FractionEncryptN:MessageBytes:Temp=" + Temp[0]);
        }
        Double CurChar = 0.0;
        int OldProcChar = 0;
        int ProcChar = 0;
        int NumOfCharsMesg = Temp.length;
        for (int MesgIndex = 0, k = 0; (MesgIndex < NumOfCharsMesg); MesgIndex++, k = 0) {
            NewEncryptedMesg = new StringBuilder("");
            CurChar = Double.parseDouble(Temp[MesgIndex]);
            int NumOfChars = Temp[MesgIndex].length();
            if (SilentFlag == false) {
                System.out.println("FractionEncryptN:Message:Temp[" + MesgIndex + "]=" + Temp[MesgIndex] + " CurChar=" + CurChar + " int=" + CurChar + " int(0)=" + (int) '0');
            }
            String MyTempData = String.valueOf(CurChar);
            int[] TempCurFractionChar = new int[NumberOfFractions];
            int[] TempCur1on1 = new int[MyTempData.length() * NumberOfFractions + NumberOfFractions];
            for (int j = 0; j < MyTempData.length(); j++) {
                OldProcChar = ProcChar;
                ProcChar = MyTempData.charAt(j);
                TempCurFractionChar = new int[NumberOfFractions];
                if ((ProcChar >= '0') && (ProcChar <= '9')) {
                    // Atomic Fractionating Encryption Begins
                    //MorseCode Table Traversal
                    FractionEncryptExprn = "x";
                    FractionEncryptDiffWithRespTo = "x";
                    int iFracMorse = 0;
                    int jFrac = 0;
                    //Computer Memory Traversal
                    variablesEncrypt.put("NumberOfFractions", 1.0 * NumberOfFractions);
                    FractionEncryptComputerExprn = "i";
                    FractionEncryptComputerDiffWithRespTo = "i";
                    //TempCur1on1[k++]=ProcChar;
                    for (int i = 0; i < NumberOfFractions; i++) {
                        if ((ProcChar >= '0') && (ProcChar <= '9')) {
                            variablesEncrypt.put("x", 1.0 * (ProcChar - '0'));
                        } else {
                            variablesEncrypt.put("x", 1.0 * (0));
                        }
                        LCGexpValue = parse(FractionEncryptExprn, variablesEncrypt, FractionEncryptDiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                        iFracMorse = (int) Math.rint(LCGexpValue.eval());
                        variablesEncrypt.put("i", 1.0 * i);
                        LCGexpValue2 = parse(FractionEncryptComputerExprn, variablesEncrypt, FractionEncryptComputerDiffWithRespTo, false,"Silent", MathsExpressionParser.LogLevel.Off);
                        jFrac = (int) Math.rint(LCGexpValue2.eval());
                        if (SilentFlag == false) {
                            System.out.println("FractionEncryptN:Message:jFrac=" + jFrac + " iFracMorse=" + iFracMorse + " i=" + i + " MyTempData.charAt(j)=" + MyTempData.charAt(j));
                            System.out.println("FractionEncryptN:Message:TempCurFractionChar[" + jFrac + "]=" + (char) TempCurFractionChar[jFrac] + " MappedCharsMorseCode[" + iFracMorse + "]=" + (char) MappedCharsMorseCode[iFracMorse][i] + " i=" + i);
                        }
                        TempCurFractionChar[jFrac] = (char) (MappedCharsMorseCode[iFracMorse][i]);
                        if (SilentFlag == false) {
                            System.out.println("FractionEncryptN:Message:TempCurFractionChar[" + jFrac + "]=" + (char) TempCurFractionChar[jFrac] + " MappedCharsMorseCode[" + iFracMorse + "]=" + (char) MappedCharsMorseCode[iFracMorse][i] + " i=" + i);
                        }
                    }
                    // Atomic Fractionating Encryption Ends
                    for (int i = 0; (i < NumberOfFractions) && (k < TempCur1on1.length); i++) {
                        if ((TempCurFractionChar[i] >= '0') && (TempCurFractionChar[i] <= '9')) {
                            TempCur1on1[k++] = TempCurFractionChar[i];
                        }
                    }
                } else {
                    if (((OldProcChar == 'E') && (ProcChar == 'E'))
                            || ((OldProcChar == '.') && (ProcChar == '.'))
                            || ((OldProcChar == 'e') && (ProcChar == 'e'))
                            || ((OldProcChar == ',') && (ProcChar == ','))
                            || ((OldProcChar == '@') && (ProcChar == '@')))
                        ; else {
                        //NewEncryptedMesg.append((char) ProcChar);
                        TempCur1on1[k++] = ProcChar;
                    }
                }
            }
            //System.out.println("FractionEncryptN:Message:Temp[" + MesgIndex + "]=" + Temp[MesgIndex] );
            for (int i = 0; i < k; i++) {
                if (TempCur1on1[i] != 0) {
                    NewEncryptedMesg.append((char) TempCur1on1[i]);
                }
            }
            for (int i = 0; i < TempCur1on1.length; i++) {
                TempCur1on1[i] = 0;
            }
            //System.out.println("FractionEncryptN:Message:NewEncryptedMesg=" + NewEncryptedMesg );
            NewEncryptedMesg.append(EncTerminatorString);
            //System.out.println("FractionEncryptN:CurChar=" + CurChar + " NewEncryptedMesg=" + NewEncryptedMesg);
            TotalEncryptedMesg.append(NewEncryptedMesg);
        }
        if (SilentFlag == false) {
            System.out.println("FractionEncryptN:Final:NewEncryptedMesg=" + NewEncryptedMesg);
            System.out.println("FractionEncryptN:Final:TotalEncryptedMesg=" + TotalEncryptedMesg);
            System.out.println("FractionEncryptN:Final:NumOfCharsMesg=" + NumOfCharsMesg);
        }
        variablesEncrypt.remove("i");
        variablesEncrypt.remove("x");
        return TotalEncryptedMesg.toString();
    }

    public static String FractionDecryptN(String Exprn, boolean SilentFlag) {
        MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
        MathsExpressionParser.Expression LCGexpValue2 = (() -> 0.0);
        if (SilentFlag == false) {
            System.out.println("FractionDecryptN:Message:Exprn=" + Exprn);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        StringBuilder TotalEncryptedMesg = new StringBuilder("");
        if ((Exprn.equalsIgnoreCase("")) || (Exprn == null)) {
            return "";
        }
        StringBuilder StrBuildMesg = new StringBuilder(Exprn);
        DecryptedMesg = Decryption.ReWork("FractionDecryptN");
        StrBuildMesg=DecryptedMesg;
        char[] TempCurFractionChar = new char[NumberOfFractions];
        char[] TempCurFractionCharEqn = new char[NumberOfFractions];
        String[] Temp = StrBuildMesg.toString().split(DeTerminatorString);
        int NumOfChars = Temp.length;
        int CurChar = 0;
        int OldCurChar = 0;
        int ProcessingCurChar = 0;
        int CurCharConfirm = 0;
        int NumOfCharPostDecrypt=0;

        for (int MesgIndex = 0, j = 0; (MesgIndex < NumOfChars); MesgIndex++, j = 0) {
            NewEncryptedMesg = new StringBuilder("");
            char[] TempCur1on1 = new char[Temp[MesgIndex].length()];
            boolean FlagGotEDOT = false;
            for (int i = 0; i < TempCur1on1.length; i++) {
                TempCur1on1[i] = 0;
            }
            if (SilentFlag == false) {
                System.out.println("FractionDecryptN:Message:Temp[" + MesgIndex + "]=" + Temp[MesgIndex] + " CurChar=" + CurChar + " int=" + CurChar + " int(0)=" + (int) '0');
            }
            for (int n = 0; (n < Temp[MesgIndex].length()) && (j < Temp[MesgIndex].length());) {
                // Atomic Fractionating Decryption Begins
                OldCurChar = CurChar;
                if (n == 0) {
                    CurChar = Temp[MesgIndex].charAt(0);
                }
                if (SilentFlag == false) {
                    System.out.println("FractionDecryptN:Loop Top:NewEncryptedMesg=" + NewEncryptedMesg + " CurChar=" + (char) CurChar + " n=" + n);
                }
                // Atomic Fractionating Decryption Ends
                int row = 0;
                int col = 0;
                boolean FoundFlag = true;
                CurChar = Temp[MesgIndex].charAt(n);
                // Atomic Fractionating Decryption Begins
                if ((n < Temp[MesgIndex].length()) && (CurChar >= '0') && (CurChar <= '9')) {
                    CurChar = Temp[MesgIndex].charAt(n);
                    ProcessingCurChar = CurChar;
                    if ((CurChar >= '0') && (CurChar <= '9')) {
                        row = CurChar - '0';
                    }
                    if (SilentFlag == false) {
                        System.out.println("FractionDecryptN:Loop Top:ProcessingCurChar=" + ProcessingCurChar + " Num=" + Temp[MesgIndex]);
                    }
                    //TempCur1on1[j++]=(char)CurChar;
                    for (int x = 0; ((x < NumberOfFractions) && ((n + x) < Temp[MesgIndex].length())); x++) {
                        ProcessingCurChar = Temp[MesgIndex].charAt(n + x);
                        if ((ProcessingCurChar >= '0') && (ProcessingCurChar <= '9')) {
                            TempCurFractionChar[x] = (char) ProcessingCurChar;
                        } else {
                            FlagGotEDOT = true;
                            break;
                        }
                        if (SilentFlag == false) {
                            System.out.println("FractionDecryptN:Loop Code Bottom:TempCurFractionChar[" + x + "]=" + (char) TempCurFractionChar[x] + " Temp[" + MesgIndex + "]=" + (char) Temp[MesgIndex].charAt(x) + " n=" + n + " x=" + x);
                        }
                    }
                    row = SearchMorse(TempCurFractionChar);
                    for (int i = 0; i < TempCurFractionChar.length; i++) {
                        TempCurFractionChar[i] = 0;
                    }
                    if (row > -1) {
                        CurCharConfirm = row + '0';
                        if (((CurCharConfirm >= '0') && (CurCharConfirm <= '9'))
                                || (CurCharConfirm == '.')
                                || (CurCharConfirm == 'E')
                                || (CurCharConfirm == 'e')) {
                            TempCur1on1[j++] = (char) CurCharConfirm;
                        }
                        if (SilentFlag == false) {
                            System.out.println("FractionDecryptN:FOUND && DECRYPTED:NewEncryptedMesg=" + NewEncryptedMesg + " CurChar=" + (char) CurChar + " CurCharConfirm=" + (char) CurCharConfirm);
                        }
                    } else {
                        if ((FlagGotEDOT == true)
                                && ((ProcessingCurChar == '.')
                                || (ProcessingCurChar == 'E')
                                || (ProcessingCurChar == 'e'))) {
                            TempCur1on1[j++] = (char) ProcessingCurChar;
                            FlagGotEDOT = false;
                        }
                        if (SilentFlag == false) {
                            System.out.println("FractionDecryptN:DID NOT FIND SYMBOL:NewEncryptedMesg=" + NewEncryptedMesg + " CurChar=" + (char) CurChar + " CurCharConfirm=" + (char) CurCharConfirm);
                        }
                    }
                    // Atomic Fractionating Decryption Ends
                } else {
                    if ((CurChar == '.')
                            || (CurChar == 'E')
                            || (CurChar == 'e')) {
                        TempCur1on1[j++] = (char) CurChar;
                    }
                    //System.out.println("FractionDecryptN:Reached:2:n=" + n + " j=" + j + " MesgIndex=" + MesgIndex);
                }
                // Increment n
                if ((CurChar >= '0') && (CurChar <= '9')) {
                    n += NumberOfFractions;
                    //System.out.println("FractionDecryptN:Reached:1:n=" + n + " MesgIndex=" + MesgIndex);
                    //n++;
                } else {
                    if (((OldCurChar == 'E') && (CurChar == 'E'))
                            || ((OldCurChar == '.') && (CurChar == '.'))
                            || ((OldCurChar == 'e') && (CurChar == 'e'))
                            || ((OldCurChar == ',') && (CurChar == ','))
                            || ((OldCurChar == '@') && (CurChar == '@'))) {
                        n++;
                    } else {
                        //NewEncryptedMesg.append((char) CurChar);
                        //TempCur1on1[j++]=(char)CurChar;
                        n++;
                    }
                }
            }
            NumOfCharPostDecrypt=j;
            for (int i = 0; i < NumOfCharPostDecrypt; i++) {
                if ((TempCur1on1[i] != 0) && (
                        (TempCur1on1[i] >= '0')
                        || (TempCur1on1[i] <= '9')
                        || (TempCur1on1[i] == '.')
                        || (TempCur1on1[i] == 'E')
                        || (TempCur1on1[i] == 'e'))) {
                    NewEncryptedMesg.append(TempCur1on1[i]);
                }
            }
            for (int i = 0; i < TempCur1on1.length; i++) {
                TempCur1on1[i] = 0;
            }
            
            //System.out.println("FractionDecryptN:Temp[MesgIndex]=" + Temp[MesgIndex] + " NewEncryptedMesg=" + NewEncryptedMesg );
            TotalEncryptedMesg.append(NewEncryptedMesg).append(DeTerminatorString);
            if (SilentFlag == false) {
                System.out.println("FractionDecryptN:Message:Pre-Final:NewEncryptedMesg=" + NewEncryptedMesg + " MesgIndex=" + MesgIndex + " Out of NumOfChars=" + NumOfChars + " Messages.");
            }
        }
        
        if (SilentFlag == false) {
            System.out.println("FractionDecryptN:Message:Final:TotalEncryptedMesg=" + TotalEncryptedMesg);
            System.out.println("FractionDecryptN:Final:NumOfChars=" + NumOfChars);
        }
        variablesDecrypt.remove("n");
        variablesDecrypt.remove("NumberOfFractions");
        return TotalEncryptedMesg.toString();
    }
    public static void MapDecrypt(String[] Temp, int MesgIndex, int CurChar, int n, int row, int j, int ProcessingCurChar, int CurCharConfirm, char[] TempCur1on1, char[] TempCurFractionChar,boolean FlagGotEDOT, StringBuilder NewEncryptedMesg, boolean SilentFlag){
                
    }
    public static int SearchMorse(char[] TempCurFractionChar) {
        int col = 0;
        int row = 0;
        boolean FoundFlag = false;
        for (col = 0; ((col < NumberOfFractions/*MappedCharsMorseCode[0].length*/)); col++) {
            if ((row < MappedCharsMorseCode.length) && (col < MappedCharsMorseCode[0].length) && (col < TempCurFractionChar.length) && (TempCurFractionChar[col] >= '0') && (TempCurFractionChar[col] <= '9') && (TempCurFractionChar[col] == MappedCharsMorseCode[row][col])) {
                ;//DO NOTHING
            } else if ((row < MappedCharsMorseCode.length) && (col < MappedCharsMorseCode[0].length) && (col < TempCurFractionChar.length) && (TempCurFractionChar[col] >= '0') && (TempCurFractionChar[col] <= '9') && (TempCurFractionChar[col] != MappedCharsMorseCode[row][col])) {
                FoundFlag = false;
                if (row < 10) {
                    row++;
                    col = 0;
                }
                // break;
            }
            //if((FoundFlag==false)&&(col < NumberOfFractions))
            //    break;
        }
        if (row >= 0 && (row <= 10)) {
            return row;
        } else {
            return -1;
        }
    }

    public static StringBuilder RotateStrEncrypt(StringBuilder Exprn, String EncondingType, int OffsetRotate, int Strlen, boolean SilentFlag) {
        
        if (SuppressSystemOutput==false)
            System.out.println("RotateStrEncrypt:Message:OffsetRotate=" + OffsetRotate + " Strlen=" + Strlen);
        String StrTimeTaken = "";
        StringBuilder NewEncryptedMesg = Exprn;
        EncryptedMesg = NewEncryptedMesg;
        if ((Exprn == null) || (Exprn.toString().equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        String[] Temp = new String[Strlen];
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn.toString().split(EncTerminatorString);
            for (int i = 0; ((SilentFlag == false) && (i < Temp.length)); i++) {
                if (SilentFlag == false) {
                    System.out.println("RotateStrEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length)); i++) {
                Temp[i] = "" + Exprn.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("RotateStrEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        int n = Strlen;
        if (SuppressSystemOutput==false)
            System.out.println("RotateStrEncrypt:Number of Characters:len=" + Temp.length + " Strlen=" + Strlen);
        if (SuppressSystemOutput==false)
            System.out.println("RotateStrEncrypt:OffsetRotate=" + OffsetRotate);
        if ((OffsetRotate < Strlen) && (OffsetRotate >= 0)) {
            if (SuppressSystemOutput==false)
                System.out.println("RotateStrEncrypt:OffsetRotate=" + OffsetRotate + " Strlen=" + Strlen);
        } else {
            System.out.println("RotateStrEncrypt:FATAL ERROR:OffsetRotate=" + OffsetRotate + " Strlen=" + Strlen);
        }
        StringBuilder StrBuildTemp = new StringBuilder("");
        for (int i = OffsetRotate; (i >= 0) && (i < Strlen) && (i < Temp.length); i++) {
            if ( (Temp[i] != null)
                    && (!Temp[i].equalsIgnoreCase(""))
                    && (Double.isFinite(Double.valueOf(Temp[i])))
                    && ( ( (i == OffsetRotate)&&(StrBuildTemp.toString().equalsIgnoreCase("")))
                    || ((i > OffsetRotate) && (StrBuildTemp.toString().endsWith(EncTerminatorString))) )
                    ) {
                if( (i==2942)&&(Temp[i].equalsIgnoreCase("37.0")) &&(Temp[i+1].equalsIgnoreCase("9.605130452970564E9")) )
                    System.out.println(ConsoleColors.BLUE + " i=" + i + ":Gotcha:37.09.605130452970564E9" + ConsoleColors.RESET);
                StrBuildTemp.append(Temp[i]);
                StrBuildTemp.append(EncTerminatorString);
//                if((StrBuildTemp.toString().endsWith(EncTerminatorString)))
//                    ;
//                else 
                    if((StrBuildTemp.toString().contains("37.09.605130452970564E9")) )
                            System.out.println(ConsoleColors.GREEN + " i=" + i + ":Gotcha:37.09.605130452970564E9" + ConsoleColors.RESET);
            } else {
//                if ((i > OffsetRotate) && (!StrBuildTemp.toString().endsWith(EncTerminatorString))) {
//                    StrBuildTemp.append(EncTerminatorString);
//                    i--;
//                }
            }
        }
        for (int i = 0; (i >= 0) && (i < OffsetRotate) && (i < Temp.length); i++) {
            if ((Temp[i] != null)
                    && (!Temp[i].equalsIgnoreCase(""))
                    && (Double.isFinite(Double.valueOf(Temp[i])))
                    && ( ((i == 0)&& (StrBuildTemp.toString().endsWith(EncTerminatorString)))
                    || ((i > 0) && (StrBuildTemp.toString().endsWith(EncTerminatorString))))) {
                if( (i==2942)&&(Temp[i].equalsIgnoreCase("37.0")) &&(Temp[i+1].equalsIgnoreCase("9.605130452970564E9")) )
                    System.out.println(ConsoleColors.RED + " i=" + i + ":Gotcha:37.09.605130452970564E9" + ConsoleColors.RESET);
                StrBuildTemp.append(Temp[i]);
                StrBuildTemp.append(EncTerminatorString);
//                if((StrBuildTemp.toString().endsWith(EncTerminatorString)))
//                    ;
//                else 
                    if((StrBuildTemp.toString().contains("37.09.605130452970564E9")) )
                            System.out.println(ConsoleColors.GREEN + " i=" + i + ":Gotcha:37.09.605130452970564E9" + ConsoleColors.RESET);
            } else {
//                if ((i > 0) && (!StrBuildTemp.toString().endsWith(EncTerminatorString))) {
//                    StrBuildTemp.append(EncTerminatorString);
//                    i--;
//                }
            }
        }

        if (StrBuildTemp.toString().startsWith(EncTerminatorString)) {
            StrBuildTemp = new StringBuilder(StrBuildTemp.toString().replaceFirst(EncTerminatorString, ""));
        }
        if (StrBuildTemp.toString().endsWith(EncTerminatorString)) {
            int k = StrBuildTemp.lastIndexOf(EncTerminatorString);
            StrBuildTemp = new StringBuilder(StrBuildTemp.substring(0, k));
        }
        return StrBuildTemp;
    }

    public static StringBuilder DiffusionJunkRotateEncrypt(StringBuilder NewEncryptedMesg, String EncondingType, boolean SilentFlag) {
       
        String[] Temp = new String[NewEncryptedMesg.length()];
        String Exprn1 = NewEncryptedMesg.toString();
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn1.split(EncTerminatorString);
            for (int i = 0; ((SilentFlag == false) && (i < Temp.length)); i++) {
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkRotateEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length)); i++) {
                Temp[i] = "" + Exprn1.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("DiffusionJunkRotateEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        // Adding Sucessive Junk Char
        boolean Flag = false;
        Double MyTemp=0.0;
        StringBuilder StrBuildTemp = new StringBuilder("");
        for (int i = 0; i < Temp.length;) {
            Flag = false;
            if ((Temp[i] != null)
                    && (!Temp[i].equalsIgnoreCase(""))
                    && (Double.isFinite(Double.valueOf(Temp[i])))
                    && ((i == 0)
                    || ((i > 0) && (StrBuildTemp.toString().endsWith(DeTerminatorString))))) {
                StrBuildTemp.append(Temp[i]);
                StrBuildTemp.append(EncTerminatorString);
                i++;
                Flag = true;
            }
            // Adding Sucessive Chars
            for (int j = 0; (Flag == true) && (j < SuccessiveCharsLenRotate); j++) {
                // Weak Junk Char BUT AVOIDS INFINITY
                if (DiffusionOperator == '+') {
                    if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                        MyTemp = 1.0 * TheFOBRandomCharRotate + SuccessiveCharsIncrementRotate;
                    } else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                        Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        MyTemp = 1.0 * ((char) Xn_LCG) + SuccessiveCharsIncrementRotate;
                    }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                        MyTemp += SuccessiveCharsIncrementRotate;
                    } 
                } else if (DiffusionOperator == '-') {
                    if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                        MyTemp = 1.0 * TheFOBRandomCharRotate - SuccessiveCharsIncrementRotate;
                    } else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                        Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        MyTemp = 1.0 * ((char) Xn_LCG) - SuccessiveCharsIncrementRotate;
                    }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                        MyTemp -= SuccessiveCharsIncrementRotate;
                    } 
                } else if (DiffusionOperator == '*') {
                    if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                        MyTemp = 1.0 * TheFOBRandomCharRotate * SuccessiveCharsIncrementRotate;
                    } else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                        Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        MyTemp = 1.0 * ((char) Xn_LCG) * SuccessiveCharsIncrementRotate;
                    }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                        MyTemp *= SuccessiveCharsIncrementRotate;
                    } 
                } else if (DiffusionOperator == '/') {
                    if (FOBRandomChar.equalsIgnoreCase("FOBStandardChar")) {
                        MyTemp = 1.0 * TheFOBRandomCharRotate / SuccessiveCharsIncrementRotate;
                    } else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                                 &&( j ==0)&&(i <UnicityForEnglish) ){
                        Xn_LCG = MySimple.LCG_Value_RandomSimple(0,"Xn_LCG",Xn_LCG, (long) a, (long) c, (int) Modulus, (int) MaxExponent, (int) ModulusEncrypt,0);
                        MyTemp = 1.0 * ((char) Xn_LCG) / SuccessiveCharsIncrementRotate;
                    }else if ( (FOBRandomChar.equalsIgnoreCase("FOBRandomChar"))
                            && (j >0)&&(i >=UnicityForEnglish)){
                        MyTemp /= SuccessiveCharsIncrementRotate;
                    } 
                }
                StrBuildTemp.append(MyTemp);
                StrBuildTemp.append(EncTerminatorString);
            }
        }
        EncryptedMesg = StrBuildTemp;
        Encryption.ReWork("DiffusionJunkRotateEncrypt");
        NewEncryptedMesg = new StringBuilder(EncryptedMesg);
        return NewEncryptedMesg;
    }

    public static StringBuilder DiffusionJunkRotateDecrypt(String Exprn, String EncondingType, boolean SilentFlag) {
        DecryptedMesg = new StringBuilder(Exprn);
        String[] Temp = new String[Exprn.length()];
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = DecryptedMesg.toString().split(DeTerminatorString);
            for (int i = 0; (i < Temp.length); i++) {
                if ((Temp[i].contains(","))) {
                    Temp[i] = Decryption.ReWorkLowLevel(Temp[i], ",");
                } else if ((Temp[i].contains("@"))) {
                    Temp[i] = Decryption.ReWorkLowLevel(Temp[i], "@");
                }
                if (SilentFlag == false) {
                    System.out.println("ConfusionWeiBullDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length)); i++) {
                Temp[i] = "" + Exprn.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("ConfusionRotateDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        // Remove Sucessive Junk Char
        // Removing Sucessive Junk Chars
        for (int i = 0; i < Temp.length;) {
            if ((Temp[i] != null)
                    && (!Temp[i].equalsIgnoreCase(""))
                    && (Double.isFinite(Double.valueOf(Temp[i])))) {
                NewEncryptedMesg.append(Temp[i]);
                NewEncryptedMesg.append(DeTerminatorString);
            }
            i = i + SuccessiveCharsLenRotate + 1;
        }
        if (SuppressSystemOutput==false)
            System.out.println("ConfusionRotateDecrypt:NewEncryptedMesg:length=" + NewEncryptedMesg.length());
        String[] MyCharDropped = NewEncryptedMesg.toString().split(DeTerminatorString);
        if (SuppressSystemOutput==false)
            System.out.println("ConfusionRotateDecrypt:MyCharDropped:length=" + MyCharDropped.length);
        return NewEncryptedMesg;
    }

    public static StringBuilder RotateStrDecrypt(StringBuilder Exprn, String EncondingType, int OffsetRotate, int Strlen, boolean SilentFlag) {
        StringBuilder StrBuildMesg = new StringBuilder("");
        DecryptedMesg = Exprn;
        StrBuildMesg=DecryptedMesg;
        
        String[] MyCharDropped = StrBuildMesg.toString().split(DeTerminatorString);

        if ((MyCharDropped.length == Strlen) && (MyCharDropped.length > 0) && (Strlen > 0)) {
            if (SuppressSystemOutput==false)
                System.out.println("RotateStrDecrypt:Lengths OK:OffsetRotate=" + OffsetRotate + " Strlen=" + Strlen + " MyCharDropped=" + MyCharDropped.length);
        } else {
            System.out.println("RotateStrDecrypt:Lengths MISMATCH:FATAL ERROR:OffsetRotate=" + OffsetRotate + " Strlen=" + Strlen + " MyCharDropped=" + MyCharDropped.length);
        }

        if (SuppressSystemOutput==false)
            System.out.println("RotateStrDecrypt:Message:OffsetRotate=" + OffsetRotate + " Strlen=" + Strlen + " MyCharDropped=" + MyCharDropped.length);

        int OffsetRotateActual = MyCharDropped.length - OffsetRotate;
        if ((OffsetRotate < Strlen) && (OffsetRotate >= 0)) {
            if (SuppressSystemOutput==false)
                System.out.println("RotateStrDecrypt:Offset OK:OffsetRotate=" + OffsetRotate + " OffsetRotateActual=" + OffsetRotateActual + " Strlen=" + Strlen);
        } else {
            System.out.println("RotateStrDecrypt:Offset MISMATCH:FATAL ERROR:OffsetRotate=" + OffsetRotate + " OffsetRotateActual=" + OffsetRotateActual + " Strlen=" + Strlen);
        }

        String Exprn1 = StrBuildMesg.toString();
        String[] Temp = new String[MyCharDropped.length];
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn1.split(DeTerminatorString);
            for (int i = 0; (i < MyCharDropped.length); i++) {
                if ((Temp[i].contains(","))) {
                    Temp[i] = Decryption.ReWorkLowLevel(Temp[i], ",");
                }
                if ((Temp[i].contains("@"))) {
                    Temp[i] = Decryption.ReWorkLowLevel(Temp[i], "@");
                }
                if ((Temp[i].contains(" "))) {
                    Temp[i] = ExprSimpleStrSep.eatAll(Temp[i],' ');
                }
                if (SilentFlag == false) {
                    System.out.println("RotateStrDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; ((i < Temp.length)); i++) {
                Temp[i] = "" + Exprn1.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("RotateStrDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
       
        for (int i = OffsetRotateActual; (i >= 0) && (i < MyCharDropped.length); i++) {
             try{
                 if ((Temp[i] != null)
                    && (!Temp[i].equalsIgnoreCase(""))
                    &&( (!Temp[i].contains(",")) &&(!Temp[i].contains("@")) )
                    && (Double.isFinite(Double.valueOf(Temp[i])))
                    && ( ((i == OffsetRotateActual)&&(NewEncryptedMesg.toString().equalsIgnoreCase("")) )
                    || ((i > OffsetRotateActual) && (NewEncryptedMesg.toString().endsWith(DeTerminatorString))))) {
                NewEncryptedMesg.append(Temp[i]);
                NewEncryptedMesg.append(DeTerminatorString);
            } else {
//                if ((i > OffsetRotateActual) && (!NewEncryptedMesg.toString().endsWith(DeTerminatorString))) {
//                    NewEncryptedMesg.append(DeTerminatorString);
//                }
            }
                 } catch(NumberFormatException MyNEException){
            System.out.println("RotateStrDecrypt:Exception:Temp[" + i + "]=" + Temp[i]);
            MyNEException.printStackTrace();
          }
        }
        for (int i = 0; (i >= 0) && (i < (OffsetRotateActual)) && (i < MyCharDropped.length); i++) {
             try{
                 if ((Temp[i] != null)
                    && (!Temp[i].equalsIgnoreCase(""))
                    &&( (!Temp[i].contains(",")) &&(!Temp[i].contains("@")) )
                    && (Double.isFinite(Double.valueOf(Temp[i])))
                    && ( ((i == 0)&& (NewEncryptedMesg.toString().endsWith(DeTerminatorString)))
                          ||((i > 0) && (NewEncryptedMesg.toString().endsWith(DeTerminatorString)))
                         ) ) {
                NewEncryptedMesg.append(Temp[i]);
                NewEncryptedMesg.append(DeTerminatorString);
            } else {
//                if ((i > 0) && (!NewEncryptedMesg.toString().endsWith(DeTerminatorString))) {
//                    NewEncryptedMesg.append(DeTerminatorString);
//                }
            }
          } catch(NumberFormatException MyNEException){
            System.out.println("RotateStrDecrypt:Exception:Temp[" + i + "]=" + Temp[i]);
            MyNEException.printStackTrace();
          }
        }
        

        if (NewEncryptedMesg.toString().startsWith(EncTerminatorString)) {
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceFirst(EncTerminatorString, ""));
        }
        if (NewEncryptedMesg.toString().endsWith(EncTerminatorString)) {
            int k = NewEncryptedMesg.lastIndexOf(EncTerminatorString);
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.substring(0, k));
        }
        MyCharDropped = NewEncryptedMesg.toString().split(EncTerminatorString);
        if (SuppressSystemOutput==false)
            System.out.println("RotateStrDecrypt:Final:NewEncryptedMesg.length()=" + NewEncryptedMesg.length() + " MyCharDropped=" + MyCharDropped.length);
        
        DecryptedMesg = NewEncryptedMesg;
        return NewEncryptedMesg;
    }

    public static String JumbleStrEncrypt(String Exprn, String EncondingType, boolean SilentFlag) {
        
        if (SilentFlag == false) {
            System.out.println("JumbleStrEncrypt:Message:Exprn=" + Exprn + " EncondingType=" + EncondingType);
        }
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        if ((Exprn == null) || (Exprn.equalsIgnoreCase(""))) {
            return "";
        }
        String[] MyCharDropped = Exprn.split(EncTerminatorString);
        String[] Temp = new String[MyCharDropped.length];
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn.split(EncTerminatorString);
            for (int i = 0; ((SilentFlag == false) && (i < Temp.length)); i++) {
                if (SilentFlag == false) {
                    System.out.println("JumbleStrEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            Temp = new String[MyCharDropped.length];
            for (int i = 0; (i < Temp.length); i++) {
                Temp[i] = "" + Exprn.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("JumbleStrEncrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        int n = MyCharDropped.length;
        if (SuppressSystemOutput==false)
            System.out.println("JumbleStrEncrypt:Number of Characters:len=" + Temp.length + " MyCharDropped=" + MyCharDropped.length);
        StringBuilder Str1 = new StringBuilder("");
        StringBuilder Str1EndChar = new StringBuilder("");
        StringBuilder EncryptedExprn = new StringBuilder("");
        StringBuilder EncryptedExprnEndChar = new StringBuilder("");
        int MesgIndex = 0;
        //System.out.println("JumbleStrEncrypt:Initial:Exprn.length()=" + Exprn.length());
        //characters/Double Values from 0 UPTO n/2

        Str1 = JumbleEncryptPart1(n, Temp);
        EncryptedExprn = JumbleEncryptPart2(n, Temp, MyCharDropped.length);
        EncryptedExprnEndChar = JumbleEncryptPart3(n, Temp, MyCharDropped.length);
        Str1EndChar = JumbleEncryptPart4(n, Temp);
        if( (!Str1.toString().equalsIgnoreCase(""))&&(Str1.toString().endsWith(EncTerminatorString)) )
            ;
        else if (!Str1.toString().equalsIgnoreCase(""))
            Str1.append(EncTerminatorString);
        if( (!EncryptedExprn.toString().equalsIgnoreCase(""))&&(EncryptedExprn.toString().endsWith(EncTerminatorString)) )
            ;
        else if (!EncryptedExprn.toString().equalsIgnoreCase(""))
            EncryptedExprn.append(EncTerminatorString);
        if( (!EncryptedExprnEndChar.toString().equalsIgnoreCase(""))&&(EncryptedExprnEndChar.toString().endsWith(EncTerminatorString)) )
            ;
        else if (!EncryptedExprnEndChar.toString().equalsIgnoreCase(""))
            EncryptedExprnEndChar.append(EncTerminatorString);
        if( (!Str1EndChar.toString().equalsIgnoreCase(""))&&(Str1EndChar.toString().endsWith(EncTerminatorString)) )
            ;
        else if (!Str1EndChar.toString().equalsIgnoreCase(""))
            Str1EndChar.append(EncTerminatorString);
        // Security Leak: Deterministic EncryptedExprnEndChar
        // Solution is leaky: Depends on Message Length being ODD OR EVEN
        if ((!EncryptedExprnEndChar.toString().equalsIgnoreCase("")) && (n % 2 == 0)) {
            EncryptedExprnEndChar = new StringBuilder("");
        }
        if ((!Str1EndChar.toString().equalsIgnoreCase("")) && (n % 2 == 0)) {
            //System.out.println("JumbleStrEncrypt:Assembly:Str1EndChar=" + Str1EndChar);
            Str1EndChar = new StringBuilder("");
        }
        if ((EncryptedExprn.toString().endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (Str1.toString().startsWith(EncTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((!EncryptedExprn.toString().endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(EncTerminatorString).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((!EncryptedExprn.toString().endsWith(EncTerminatorString)) && (!Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(EncTerminatorString).append(Str1).append(EncTerminatorString).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((!EncryptedExprn.toString().endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(EncTerminatorString).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((EncryptedExprn.toString().endsWith(EncTerminatorString)) && (!Str1.toString().endsWith(EncTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(Str1).append(EncTerminatorString).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((EncryptedExprn.toString().endsWith(EncTerminatorString)) && (Str1.toString().endsWith(EncTerminatorString)) && (!Str1.toString().startsWith(EncTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        }
        if (NewEncryptedMesg.toString().startsWith(EncTerminatorString)) {
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceFirst(EncTerminatorString, ""));
        }
        if (NewEncryptedMesg.toString().endsWith(EncTerminatorString)) {
            int k = NewEncryptedMesg.lastIndexOf(EncTerminatorString);
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.substring(0, k));
        }
        if((NewEncryptedMesg.toString().contains("37.09.605130452970564E9")) )
            System.out.println(ConsoleColors.GREEN + "JumbleStrEncrypt:Gotcha:37.09.605130452970564E9" + ConsoleColors.RESET);
        //System.out.println("JumbleStrEncrypt:Final:NewEncryptedMesg=" + NewEncryptedMesg);
        //System.out.println("JumbleStrEncrypt:Final:NewEncryptedMesg.length()=" + NewEncryptedMesg.length());
        
        return NewEncryptedMesg.toString();
    }

    public static StringBuilder JumbleStrDecrypt(StringBuilder Exprn, String EncondingType, boolean SilentFlag) {
        
        if (SilentFlag == false) {
            System.out.println("JumbleStrDecrypt:Message:Exprn=" + Exprn);
        }
        //System.out.println("JumbleStrDecrypt:Length=" + Exprn.length());
        StringBuilder NewEncryptedMesg = new StringBuilder("");
        if ((Exprn.toString() == null) || (Exprn.toString().equalsIgnoreCase(""))) {
            return NewEncryptedMesg;
        }
        String[] MyCharDropped = Exprn.toString().split(DeTerminatorString);
        String[] Temp = new String[MyCharDropped.length];
        if (EncondingType.equalsIgnoreCase("Double")) {
            Temp = Exprn.toString().split(DeTerminatorString);
            for (int i = 0; (SilentFlag == false) && (i < Temp.length); i++) {
                if (SilentFlag == false) {
                    System.out.println("JumbleStrDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        } else if (EncondingType.equalsIgnoreCase("char")) {
            for (int i = 0; i < Exprn.length(); i++) {
                Temp[i] = "" + Exprn.charAt(i);
                if (SilentFlag == false) {
                    System.out.println("JumbleStrDecrypt:Message:Temp[" + i + "]=" + Temp[i]);
                }
            }
        }
        int n = MyCharDropped.length;
        if (SuppressSystemOutput==false)
            System.out.println("JumbleStrDecrypt:Number of Characters:len=" + Temp.length);
        StringBuilder Str1 = new StringBuilder("");
        StringBuilder Str1EndChar = new StringBuilder("");
        StringBuilder EncryptedExprn = new StringBuilder("");
        StringBuilder EncryptedExprnEndChar = new StringBuilder("");
        int MesgIndex = 0;
        //System.out.println("JumbleStrDecrypt:Initial:Exprn.length()=" + Exprn.length());
        //characters/Double Values from 0 UPTO n/2

        Str1 = JumbleDecryptPart1(n, Temp);
        EncryptedExprn = JumbleDecryptPart2(n, Temp, MyCharDropped.length);
        EncryptedExprnEndChar = JumbleDecryptPart3(n, Temp);
        Str1EndChar = JumbleDecryptPart4(n, Temp);
        if( (!Str1.toString().equalsIgnoreCase(""))&&(Str1.toString().endsWith(DeTerminatorString)) )
            ;
        else if (!Str1.toString().equalsIgnoreCase(""))
            Str1.append(DeTerminatorString);
        if( (!EncryptedExprn.toString().equalsIgnoreCase(""))&&(EncryptedExprn.toString().endsWith(DeTerminatorString)) )
            ;
        else if (!EncryptedExprn.toString().equalsIgnoreCase(""))
            EncryptedExprn.append(DeTerminatorString);
        if( (!EncryptedExprnEndChar.toString().equalsIgnoreCase(""))&&(EncryptedExprnEndChar.toString().endsWith(DeTerminatorString)) )
            ;
        else if (!EncryptedExprnEndChar.toString().equalsIgnoreCase(""))
            EncryptedExprnEndChar.append(DeTerminatorString);
        if( (!Str1EndChar.toString().equalsIgnoreCase(""))&&(Str1EndChar.toString().endsWith(DeTerminatorString)) )
            ;
        else if (!Str1EndChar.toString().equalsIgnoreCase(""))
            Str1EndChar.append(DeTerminatorString);
        // Security Leak: Deterministic EncryptedExprnEndChar
        // Solution is leaky: Depends on Message Length being ODD OR EVEN
        if ((!EncryptedExprnEndChar.toString().equalsIgnoreCase("")) && (n % 2 == 0)) {
            EncryptedExprnEndChar = new StringBuilder("");
        }
        if ((!Str1EndChar.toString().equalsIgnoreCase("")) && (n % 2 == 0)) {
            //System.out.println("JumbleStrDecrypt:Assembly:Str1EndChar=" + Str1EndChar);
            Str1EndChar = new StringBuilder("");
        }
        if ((EncryptedExprn.toString().endsWith(DeTerminatorString)) && (Str1.toString().endsWith(DeTerminatorString)) && (Str1.toString().startsWith(DeTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((!EncryptedExprn.toString().endsWith(DeTerminatorString)) && (Str1.toString().endsWith(DeTerminatorString)) && (!Str1.toString().startsWith(DeTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(DeTerminatorString).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((!EncryptedExprn.toString().endsWith(DeTerminatorString)) && (!Str1.toString().endsWith(DeTerminatorString)) && (!Str1.toString().startsWith(DeTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(DeTerminatorString).append(Str1).append(DeTerminatorString).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((!EncryptedExprn.toString().endsWith(DeTerminatorString)) && (Str1.toString().endsWith(DeTerminatorString)) && (!Str1.toString().startsWith(DeTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(DeTerminatorString).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((EncryptedExprn.toString().endsWith(DeTerminatorString)) && (!Str1.toString().endsWith(DeTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(Str1).append(DeTerminatorString).append(Str1EndChar).append(EncryptedExprnEndChar);
        } else if ((EncryptedExprn.toString().endsWith(DeTerminatorString)) && (Str1.toString().endsWith(DeTerminatorString)) && (!Str1.toString().startsWith(DeTerminatorString))) {
            NewEncryptedMesg.append(EncryptedExprn).append(Str1).append(Str1EndChar).append(EncryptedExprnEndChar);
        }
        if (NewEncryptedMesg.toString().startsWith(DeTerminatorString)) {
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.toString().replaceFirst(DeTerminatorString, ""));
        }
        if (NewEncryptedMesg.toString().endsWith(DeTerminatorString)) {
            int k = NewEncryptedMesg.lastIndexOf(DeTerminatorString);
            NewEncryptedMesg = new StringBuilder(NewEncryptedMesg.substring(0, k));
        }
        //System.out.println("JumbleStrDecrypt:Final:NewEncryptedMesg=" + NewEncryptedMesg);
        //System.out.println("JumbleStrDecrypt:Final:NewEncryptedMesg.length()=" + NewEncryptedMesg.length());
        
        return NewEncryptedMesg;
    }

    public static StringBuilder JumbleEncryptPart1(int n, String[] Temp) {
        StringBuilder Str1 = new StringBuilder("");

        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            if ((Temp[MesgIndex] == null) || (Temp[MesgIndex].equalsIgnoreCase("")))
                        ; else if ((Temp[MesgIndex] != null) && (!Temp[MesgIndex].equalsIgnoreCase("")) && (Str1.toString().equalsIgnoreCase(""))) {
                Str1.append(Temp[MesgIndex]).append(EncTerminatorString);
            } else if ((Temp[MesgIndex] != null) && (Str1.toString().endsWith(DeTerminatorString))) {
                Str1.append(Temp[MesgIndex]).append(EncTerminatorString);
            } else if ((Temp[MesgIndex] != null) && (!Str1.toString().endsWith(EncTerminatorString))) {
                Str1.append(EncTerminatorString).append(Temp[MesgIndex]).append(EncTerminatorString);
            }
        }
        return Str1;
    }

    public static StringBuilder JumbleEncryptPart2(int n, String[] Temp, int Strlen) {
        StringBuilder EncryptedExprn = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            if ((MesgIndex + (n / 2) < Strlen) && (Temp[MesgIndex + (n / 2)].equalsIgnoreCase("")))
                        ; else if ((MesgIndex + (n / 2) < Strlen) && (Temp[MesgIndex + (n / 2)] != null) && (Temp[MesgIndex + (n / 2)] != null) && (EncryptedExprn.toString().equalsIgnoreCase("")) && (!Temp[MesgIndex + (n / 2)].equalsIgnoreCase(""))) {
                EncryptedExprn.append(Temp[MesgIndex + (n / 2)]).append(EncTerminatorString);
            } else if ((MesgIndex + (n / 2) < Strlen) && (Temp[MesgIndex + (n / 2)] != null) && (EncryptedExprn.toString().endsWith(EncTerminatorString))) {
                EncryptedExprn.append(Temp[MesgIndex + (n / 2)]).append(EncTerminatorString);
            } else if ((MesgIndex + (n / 2) < Strlen) && (Temp[MesgIndex + (n / 2)] != null) && (!EncryptedExprn.toString().endsWith(EncTerminatorString))) {
                EncryptedExprn.append(EncTerminatorString).append(Temp[MesgIndex + (n / 2)]).append(EncTerminatorString);
            }
        }
        return EncryptedExprn;
    }

    public static StringBuilder JumbleEncryptPart3(int n, String[] Temp, int StrLen) {
        StringBuilder EncryptedExprnEndChar = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            if ((MesgIndex == ((n / 2) - 1)) && (Temp[StrLen - 1].equalsIgnoreCase("")))
                        ; else if ((MesgIndex == ((n / 2) - 1)) && (EncryptedExprnEndChar.toString().equalsIgnoreCase("")) && (!Temp[StrLen - 1].equalsIgnoreCase(""))) {
                EncryptedExprnEndChar.append(Temp[StrLen - 1]).append(EncTerminatorString);
            } else if ((MesgIndex == ((n / 2) - 1)) && (EncryptedExprnEndChar.toString().endsWith(EncTerminatorString))) {
                EncryptedExprnEndChar.append(Temp[StrLen - 1]).append(EncTerminatorString);
            } else if ((MesgIndex == ((n / 2) - 1)) && (!EncryptedExprnEndChar.toString().endsWith(EncTerminatorString))) {
                EncryptedExprnEndChar.append(EncTerminatorString).append(Temp[StrLen - 1]).append(EncTerminatorString);
            }
        }
        return EncryptedExprnEndChar;
    }

    public static StringBuilder JumbleEncryptPart4(int n, String[] Temp) {
        StringBuilder Str1EndChar = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            // Str1EndChar
            if ((MesgIndex == ((n / 2) - 1)) && ((Temp[(n / 2)] == null) || (Temp[(n / 2)].equalsIgnoreCase(""))))
                        ; else if ((MesgIndex == ((n / 2) - 1)) && (Temp[(n / 2)] != null) && (Str1EndChar.toString().equalsIgnoreCase("")) && (!Temp[(n / 2)].equalsIgnoreCase("")) && (n % 2 == 0)) {
                Str1EndChar.append(Temp[(n / 2)]).append(EncTerminatorString);
            } else if ((MesgIndex == ((n / 2) - 1)) && (Temp[(n / 2)] != null) && (Str1EndChar.toString().endsWith(EncTerminatorString))) {
                Str1EndChar.append(Temp[(n / 2)]).append(EncTerminatorString);
            }
        }
        return Str1EndChar;
    }

    public static StringBuilder JumbleDecryptPart1(int n, String[] Temp) {
        StringBuilder Str1 = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            if ((Temp[MesgIndex] == null) || (Temp[MesgIndex].equalsIgnoreCase("")))
                        ; else if ((Temp[MesgIndex] != null) && (Str1.toString().equalsIgnoreCase("")) && (!Temp[MesgIndex].equalsIgnoreCase(""))) {
                Str1.append(Temp[MesgIndex]).append(DeTerminatorString);
            } else if ((Temp[MesgIndex] != null) && (!Temp[MesgIndex].equalsIgnoreCase("")) && (Str1.toString().endsWith(DeTerminatorString))) {
                Str1.append(Temp[MesgIndex]).append(DeTerminatorString);
            } else if ((Temp[MesgIndex] != null) && (!Temp[MesgIndex].equalsIgnoreCase("")) && (!Str1.toString().endsWith(DeTerminatorString))) {
                Str1.append(DeTerminatorString).append(Temp[MesgIndex]).append(DeTerminatorString);
            }
        }
        return Str1;
    }

    public static StringBuilder JumbleDecryptPart2(int n, String[] Temp, int StrLen) {
        StringBuilder EncryptedExprn = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            if ((MesgIndex + (n / 2) < StrLen)
                    && (Temp[MesgIndex + (n / 2)] == null) || (Temp[MesgIndex + (n / 2)].equalsIgnoreCase("")))
                        ; else if ((MesgIndex + (n / 2) < StrLen) && (Temp[MesgIndex + (n / 2)] != null) && (!Temp[MesgIndex + (n / 2)].equalsIgnoreCase("")) && (EncryptedExprn.toString().equalsIgnoreCase("")) && (!Temp[MesgIndex + (n / 2)].equalsIgnoreCase(""))) {
                EncryptedExprn.append(Temp[MesgIndex + (n / 2)]).append(DeTerminatorString);
            } else if ((MesgIndex + (n / 2) < StrLen) && (Temp[MesgIndex + (n / 2)] != null) && (!Temp[MesgIndex + (n / 2)].equalsIgnoreCase("")) && (EncryptedExprn.toString().endsWith(DeTerminatorString))) {
                EncryptedExprn.append(Temp[MesgIndex + (n / 2)]).append(DeTerminatorString);
            } else if ((MesgIndex + (n / 2) < StrLen) && (Temp[MesgIndex + (n / 2)] != null) && (!Temp[MesgIndex + (n / 2)].equalsIgnoreCase("")) && (!EncryptedExprn.toString().endsWith(DeTerminatorString))) {
                EncryptedExprn.append(DeTerminatorString).append(Temp[MesgIndex + (n / 2)]).append(DeTerminatorString);
            }
        }
        return EncryptedExprn;
    }

    public static StringBuilder JumbleDecryptPart3(int n, String[] Temp) {
        StringBuilder EncryptedExprnEndChar = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            if ((MesgIndex == ((n / 2) - 1)) && (Temp[Temp.length - 1].equalsIgnoreCase("")))
                        ; else if ((MesgIndex == ((n / 2) - 1)) && (EncryptedExprnEndChar.toString().equalsIgnoreCase("")) && (!Temp[Temp.length - 1].equalsIgnoreCase(""))) {
                EncryptedExprnEndChar.append(Temp[Temp.length - 1]).append(DeTerminatorString);
            } else if ((MesgIndex == ((n / 2) - 1)) && (EncryptedExprnEndChar.toString().endsWith(DeTerminatorString))) {
                EncryptedExprnEndChar.append(Temp[Temp.length - 1]).append(DeTerminatorString);
            } else if ((MesgIndex == ((n / 2) - 1)) && (!EncryptedExprnEndChar.toString().endsWith(DeTerminatorString))) {
                EncryptedExprnEndChar.append(DeTerminatorString).append(Temp[Temp.length - 1]).append(DeTerminatorString);
            }
        }
        return EncryptedExprnEndChar;
    }

    public static StringBuilder JumbleDecryptPart4(int n, String[] Temp) {
        StringBuilder Str1EndChar = new StringBuilder("");
        for (int MesgIndex = 0; (MesgIndex < (n / 2)); MesgIndex++) {
            // Str1EndChar
            if (((Temp[(n / 2)] == null) || (Temp[(n / 2)].equalsIgnoreCase(""))) && (MesgIndex == ((n / 2) - 1)))
                        ; else if ((MesgIndex == ((n / 2) - 1)) && (Str1EndChar.toString().equalsIgnoreCase("")) && (!Temp[(n / 2)].equalsIgnoreCase("")) && (n % 2 == 0)) {
                Str1EndChar.append(Temp[(n / 2)]).append(DeTerminatorString);
            } else if ((MesgIndex == ((n / 2) - 1)) && (Temp[(n / 2)] != null) && (Str1EndChar.toString().endsWith(DeTerminatorString))) {
                Str1EndChar.append(Temp[(n / 2)]).append(DeTerminatorString);
            }
        }
        return Str1EndChar;
    }
}
