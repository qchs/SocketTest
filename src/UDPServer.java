import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Lenovo on 2018/4/6.
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            //建立一个监听接口
            DatagramSocket ds = new DatagramSocket(8888);
            //准备一个大包袱接收数据，数据存在数组里
            byte buf[] = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            while (true) {
                ds.receive(dp);
                //构造字符串，从0到接收到的最后一位
//                for (byte x :
//                        buf) {
//                    System.out.print( x);
//                }
//                String str = buf.toString();
//                System.out.println(str);
                //接到了字节数组，如何转化成long类型
                ByteArrayInputStream bais=new ByteArrayInputStream(buf);
                DataInputStream dis=new DataInputStream(bais);
                System.out.println(dis.readLong());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
