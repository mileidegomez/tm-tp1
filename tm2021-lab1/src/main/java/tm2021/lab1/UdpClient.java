package tm2021.lab1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    
    public static void main(String[] args) throws Exception {
        
        final int port = 9000 ;
        final InetAddress address = InetAddress.getByName( args[0] ) ;
        
        DatagramSocket socket = new DatagramSocket() ;
        String input ;
        do {
            input = readLine() + "\n";
            DatagramPacket packet = new DatagramPacket( input.getBytes(), input.getBytes().length ) ;
            packet.setAddress( address ) ;
            packet.setPort( port ) ;
            socket.send( packet ) ;

        } while( ! input.equals(".\n") ) ;
        
        socket.close() ;
    }
    
    
    public static String readLine() throws Exception {
        return new BufferedReader( new InputStreamReader( System.in ) ).readLine() ;
    }
}
