/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-22 17:41
 * @Description: volatile 原子性操作
 */
public class Volatile {
    private static   boolean active;
    private static volatile int i = 0;

    static class  FirstRunnable implements  Runnable {
        private String name;

        public FirstRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            active = true;
            while (active) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " :  " + (++i));
            }
        }
    }

    static class  TwoRunnable implements  Runnable {
        private String name;

        public TwoRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            active = true;
            while (active) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " stop   " + --i);
            }
        }

    }

    public static void main(String[] args) {
        FirstRunnable mr = new FirstRunnable("A");
        Thread td = new Thread(mr);
        td.start();
        TwoRunnable mr2 = new TwoRunnable("B");
        Thread td2 = new Thread(mr2);
        td2.start();
    }
}
