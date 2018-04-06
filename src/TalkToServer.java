import java.io.*;
import java.net.Socket;

/**
 * Created by Lenovo on 2018/4/6.
 */
public class TalkToServer {
    public static void main(String[] args) {
        DataInputStream responseFromServer=null;
        DataOutputStream infoToServer=null;
        String str =null;
        try {
            do {
            //申请连接服务器
            Socket s=new Socket("127.0.0.1",8888);
            //从键盘读取内容



                OutputStream os = s.getOutputStream();
                infoToServer = new DataOutputStream(os);
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                str= br.readLine();
//             String  str="hi server!";
                //发送给服务器
                infoToServer.writeUTF("client:" + s.getInetAddress() + ":" + s.getPort() + " says :" + str);

                //接收服务器传来的信息
                InputStream is = s.getInputStream();
                responseFromServer = new DataInputStream(is);
                if (responseFromServer != null) {
                    System.out.println(responseFromServer.readUTF());
                }
            }while (!str.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
