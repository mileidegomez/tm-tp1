package tm2021.lab1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    
    public static void main(String[] args) throws Exception {
        
        String input ;
        
        Socket cs = new Socket( args[0], 9000 ) ;
        OutputStream os = cs.getOutputStream() ;
        do {
            input = readLine() + "\n";
            os.write( input.getBytes() ) ;
        } while( ! input.equals(".\n") ) ;
        os.close() ;
        cs.close() ;
    }
    
    public static String readLine() throws Exception {
        return new BufferedReader( new InputStreamReader( System.in ) ).readLine() ;
    }
}
