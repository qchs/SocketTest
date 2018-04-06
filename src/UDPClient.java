import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by Lenovo on 2018/4/6.
 */
public class UDPClient {
    public static void main(String[] args) {
        long q= 3343356564536356563L;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(baos);
        try {
            dos.writeLong(q);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        byte buf[] = ("hello").getBytes();
        byte buf[] = baos.toByteArray();
        System.out.println(buf.length);

        try {
            //将数据打包，附上目的地地址
            DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 8888));
            //自己也得有个端口号
            DatagramSocket ds = new DatagramSocket(9999);
            //发送咯，到不到看造化
            ds.send(dp);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
