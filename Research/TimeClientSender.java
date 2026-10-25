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
package Research;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class TimeClientSender {
   public static Logger log = Logger.getLogger(TimeClientSender.class.getName()); 
   public static void main(String [] args){
        int port=6000;
        try {
            InetAddress hostName=InetAddress.getByName("localhost");
            System.out.println(" TimeClientSender hostName=" + hostName + " port=" + port);
            InetAddress remoteaddress=InetAddress.getLocalHost();
            //"127.0.0.1";//"fe80::5445:5245:444f%4";
            int localPort=6001;
            InetAddress localAddr=InetAddress.getLocalHost();
            //Socket socket = new Socket(hostName,port);
            Socket socket = new Socket(remoteaddress, port, localAddr,localPort);
            //InputStream input = socket.getInputStream();
            //BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output , true);
            writer.println("Hello World");
            writer.flush();
        }catch(UnknownHostException ex){
            System.out.println(" TimeClientSender UnknownHostException Exception:" + ex.getMessage());
            ex.printStackTrace();
        }catch(IOException ex){
            System.out.println(" TimeClientSender IOException Exception:" + ex.getMessage());
            ex.printStackTrace();
        }catch(Exception ex){
            System.out.println(" TimeClientSender Generic Exception:" + ex.getMessage());
            ex.printStackTrace();
        }
   }
}
