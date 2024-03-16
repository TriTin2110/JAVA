import java.net.InetAddress;
import java.net.UnknownHostException;

public class DiaChiIP {
        public static void main(String[] args) {
                String tenMien = "titv.vn";
                try {
                        InetAddress inet = InetAddress.getByName(tenMien);
                        System.out.println(inet.getHostAddress());
                } catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }
}
