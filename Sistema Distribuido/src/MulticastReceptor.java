import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastReceptor {
    
    public static void main (String[]args)
    {
        MulticastSocket socket=null;
        InetAddress grupo=null;
    try
       {
           socket=new MulticastSocket(6789);
           grupo=InetAddress.getByName("226.7.8.9");
           
           socket.joinGroup(grupo);
           
           while(true)
           {                      
                byte[]msg=new byte[1000];
                //porta-->6789
                DatagramPacket pacote=new DatagramPacket(msg,msg.length);
           
                socket.receive(pacote);
                System.out.println("mensagem recebida: "+new String(pacote.getData()));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       finally
       {
           try
           {
               socket.leaveGroup(grupo);
                socket.close();
           }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
