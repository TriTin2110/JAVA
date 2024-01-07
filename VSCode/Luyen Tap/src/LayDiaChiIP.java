import java.net.InetAddress;

public class LayDiaChiIP {
        public static void main(String[] args) {
                try {
                        InetAddress ip = InetAddress.getLocalHost();
                        System.out.println(ip.getHostAddress());
                } catch (Exception e) {
                        System.out.println(e);
                }

        }
}
