import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Lenovo on 2018/4/6.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",6666);
            OutputStream os=s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            String str= "hello server!";
            dos.writeUTF(str);
//            dos.flush();
//            dos.close();

            DataInputStream dis=new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
