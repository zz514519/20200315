import java.util.Scanner;

public class 普通状态位的方式通知停止 {
    private static boolean condtion = true;

    static class 写作业 implements Runnable{
        @Override
        public void run() {
            while (condtion){
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
                    //
                    break;
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
        condtion = false;
        System.out.println("已经通知停止写作业");
        t.join();
        System.out.println("已经停止写作业");
    }
}
