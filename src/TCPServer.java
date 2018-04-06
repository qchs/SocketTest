import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lenovo on 2018/4/6.
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(6666);
            int c=0;
            while (true){
                Socket sInServer= ss.accept();
                c++;
                System.out.println(c+" client is in!");
                DataInputStream dis=new DataInputStream(sInServer.getInputStream());
                System.out.println(dis.readUTF());
//                dis.close();
                //有一个先后顺序，服务器先读后写，还得判断读的内容不为空
                DataOutputStream dos=new DataOutputStream(sInServer.getOutputStream());
                dos.writeUTF("hello"+sInServer.getInetAddress()+":"+sInServer.getPort());
                dos.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
