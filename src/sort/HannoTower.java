package sort;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-11-15 16:50
 * @Description: 汉诺塔问题：其在一个庙宇中留下了三根金刚石的棒，第一根上面套着64个大小不一的圆形金片。
 * 其中，最大的金片在最底下，其余的依次叠上去，且一个比一个小，如下图所示。勃拉玛要求众僧将该金刚石棒中的金片逐个地移到另一个棒上，
 * 规定一次只能移动一个金片，且金片在放到棒上时，大的只能放在小的下面，但是可以利用中间的一根棒作为辅助移动使用。
 * 参考： https://www.cnblogs.com/tonglin0325/p/5362236.html
 */
public class HannoTower {
    private  static  int count;

    public static void main(String[] args) {
        int nDisks = 4;
        doTowers(nDisks, 'A', 'B', 'C');
        System.out.println("移动次数： "  + count);
    }
    public static void doTowers(int topN, char from, char inter, char to) {
        count++;
        if (topN == 1){
            System.out.println("Disk 1 from "
                    + from + " to " + to);
        }else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk "
                    + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

    public void hannoTowerQuestion(int n) {
        int count = 0;
        if (n == 3) {

        }
    }
}
