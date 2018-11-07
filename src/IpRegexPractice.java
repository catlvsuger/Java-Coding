import java.util.TreeSet;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 14:45
 * @Description:
 */
public class IpRegexPractice {
    public static void main(String[] args) {
        ipSort("192.168.1.254   10.10.10.10  2.2.2.2   165.134.2.123");
    }

    private static void ipSort(String ip) {
        //前面加00  00192.00168.001.00254   0010.去掉0010.0010.0010  002.002.002.002   00165.00134.002.00123
        ip  = ip.replaceAll("(\\d+)", "00$1");
        System.out.println(ip);
        // 去掉多余的0  192.168.1.254   10.10.10.10  2.2.2.2   165.134.2.123
        ip = ip.replaceAll("0*(\\d+)","$1");
        System.out.println(ip);
        String[] arr = ip.split(" +");
        TreeSet<String> treeSet = new TreeSet<>();
        for (String st : arr) {
            treeSet.add(st);
        }
        for (String st : treeSet) {
            System.out.println(st.replaceAll("0*(\\d+)","$1"));
        }
    }
}
