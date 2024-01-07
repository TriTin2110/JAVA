import java.util.HashMap;
import java.util.Map;

public class PutVaGet {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Nguyen Tri Tin", "21/10/2003");
        map.put("Ho Viet Trung", "19/05/2003");
        map.put("Nguyen Thi Lan", "21/08/2003");
        System.out.println(map.get("Nguyen Tri Tin"));
        map.remove("Ho Viet Trung");
        map.replace("Nguyen Tri Tin", "21/10/2003", "19/12/2003");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
    }
}
