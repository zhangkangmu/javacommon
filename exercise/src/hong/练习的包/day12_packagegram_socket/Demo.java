package hong.练习的包.day12_packagegram_socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * Created by zhangyuhong
 * Date:2017/12/31
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        System.out.println(hostName);
        InetAddress byName = InetAddress.getByName("hong-bijiben");
        System.out.println(byName.getHostAddress());
        System.out.println(localHost.getHostAddress());
        ServerSocket serverSocket = new ServerSocket(8888);
    }
}
