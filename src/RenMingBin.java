/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 16:07
 * @Description: 人民币
 */
public class RenMingBin {
    private static  final char[] data = {'零', '壹', '贰', '叁', '肆', '伍', '陆','柒','捌','玖'};
    private static final char[] units = {'元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿', '拾', '佰'};

    public static void main(String[] args) {
        System.out.println(convert(1230567892)); //壹拾贰亿叁仟伍拾陆万柒仟捌佰玖拾贰元
    }

    private static String convert(int money) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (money != 0) {
            int number = money % 10;
            if (number == 0 && num != 0) {
                num++;
            } else {
                sb.insert(0, units[num++]);
            }
            if (number != 0 ) {
                sb.insert(0, data[number]);
            }
            money /= 10;
        }
        return sb.toString();
    }
}
