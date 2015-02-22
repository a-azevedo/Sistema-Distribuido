import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastEmissor {

    public static void main(String[] args)
    {
       MulticastSocket socket = null;
       InetAddress grupo=null;
       try
       {
           socket=new MulticastSocket();
           grupo=InetAddress.getByName("226.7.8.9");
           
           byte[]msg="teste".getBytes();
           //porta-->6789
           DatagramPacket pacote=new DatagramPacket(msg,msg.length,grupo,6789);
           
           socket.send(pacote);
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       finally
       {
           try
           {
                socket.close();
           }
           catch(Exception e)
            {
                e.printStackTrace();
            }    
            
       }
            
               
    }
    
}
