import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lenovo on 2018/4/6.
 */
public class RespondToClient {
    public static void main(String[] args) {

        DataInputStream infoFromClient=null;
        DataOutputStream responseToClient=null;
        try {
            ServerSocket ss=new ServerSocket(8888);
            while (true){
                //建立连接
                Socket sInServer =ss.accept();
                System.out.println("a client in!");
                //读取客户端发来的信息
                InputStream is= sInServer.getInputStream();
                infoFromClient = new DataInputStream(is);
                if (infoFromClient!=null){
                    System.out.println(infoFromClient.readUTF());
                }
                //从键盘读取内容
                OutputStream os=sInServer.getOutputStream();
                responseToClient= new DataOutputStream(os);
                InputStreamReader isr=new InputStreamReader(System.in);
                BufferedReader br=new BufferedReader(isr);
                String str= br.readLine();
                //给客户端发信息
                responseToClient.writeUTF("Server: "+str);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
