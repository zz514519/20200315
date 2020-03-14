import java.util.Scanner;

public class 如何让一个线程停止 {
    static class 写作业 implements Runnable{
        @Override
        public void run() {
            while (Thread.interrupted()){//如果没睡，通过这里知道要停止的消息
                try{
                    System.out.println("写第一份作业");
                    Thread.sleep(3*1000);
                    System.out.println("写第二份作业");
                    Thread.sleep(3*1000);
                    System.out.println("写第三份作业");
                    Thread.sleep(3*1000);
                    System.out.println("写第四份作业");
                    Thread.sleep(3*1000);
                    System.out.println("写第五份作业");
                    Thread.sleep(3*1000);
                }catch (InterruptedException e){
                    //如果睡了，通过这里来知道要停止的消息
                    break;//我主动停下来
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new 写作业());
        t.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("准备通知停止写作业");
        t.interrupt();

        System.out.println("已经通知停止写作业");
        t.join();

        System.out.println("已经停止写作业");
    }
}
