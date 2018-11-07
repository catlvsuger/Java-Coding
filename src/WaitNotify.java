/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-25 16:36
 * @Description:
 */
public class WaitNotify {
    static  boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) {
        Wait wait = new Wait();
        Notify notify = new Notify();
        Thread waitThread = new Thread(wait, "waitThread");
        Thread notifyThread = new Thread(notify, "notifyThread");
        waitThread.start();
        notifyThread.start();
    }


    static  class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println("flag :"+ String.valueOf(flag));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("do something !!!");

            }
        }
    }

    static  class  Notify implements  Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                lock.notifyAll();
                flag = false;
                System.out.println("flag :"+ String.valueOf(flag));
            }
        }
    }
}