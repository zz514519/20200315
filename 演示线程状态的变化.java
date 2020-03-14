public class 演示线程状态的变化 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100_0000 ; i++) {

            }
        }
    }
    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println(t.getState());//线程的状态 new
        t.start();
        System.out.println(t.getState());//线程的状态runnable

        while (t.isAlive());//只要线程活着，一直循环

        System.out.println(t.getState());//现成的状态terminated
    }
}
