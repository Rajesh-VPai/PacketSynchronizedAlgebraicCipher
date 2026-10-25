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
package Shannon_Mapping;

import static Calculus.DiffrIntegrSep.MyFuncDiff;
import Calculus.MathsExpressionParser;
import static Calculus.MathsContxtLAv.MyFuncExpress;
import static Calculus.MathsContxtLAv.MyFuncSimple;
import static Calculus.MathsExpressionParser.parse;
import static Shannon_Mapping.ShannonHighLevelUsage.variables;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rajesh V Pai
 */
public class K_Mapping {
    public static MathsExpressionParser.Expression LCGexpValue = (() -> 0.0);
    public String KFunctionStr=null;
    public K_Mapping(String Exprn){
        ParseEquation(Exprn);
    }    
    public long ParseEquation(String Exprn){
        MyFuncExpress();
        MyFuncDiff();
        MyFuncSimple();
        String DiffWithRespTo = "Xn";
        if (!(variables.containsKey("Xn")) )
                variables.put("Xn", 1.0);
        if (!(variables.containsKey("keyx")) )
                variables.put("keyx", 1.0);
        
        this.KFunctionStr=Exprn;
        LCGexpValue = parse(Exprn, variables, DiffWithRespTo, false, "Silent", MathsExpressionParser.LogLevel.Off);
        return LCGexpValue.eval().longValue();
    }
}
