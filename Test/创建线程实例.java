package Test;
//定义一个线程或者目标类
public class 创建线程实例 {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            //执行的任务
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }
        private static class MyRunnable implements Runnable{
            @Override
            public void run() {
                for (int i = 100; i <110 ; i++) {
                    System.out.println(i);
                }
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Thread a  = new MyThread();//创建一个线程对象，该线程要干的工作，就在线程类中，已被覆写
        a.start();                                  //把a线程放入就绪队列
        a.join();//1.主线程放弃CPU，2.直到a结束之前，承诺再也不抢CPU
                    // 主线程阻塞在这里，直到a线程执行结束，才接着往下执行
        System.out.println("a 一定结束了");

        Runnable target = new MyRunnable();//创建一个目标对象，具体要做的实现，见run方法
        Thread b = new Thread(target);//拿着目标对象，去创建线程对象，这个线程要干的活，就是目标对象中指定的。
        b.start();
        b.join();
        System.out.println("b 一定结束了");

        Runnable target2 = new MyThread();//创建一个Thread对象，因为 Thread实现了Runnable，所以可以看做创建了目标对象
        Thread c= new Thread(target2);
        c.start();
        c.join();
        System.out.println("c 一定结束了");
    }

    private static void 了解即可_使用匿名类创建线程对象(){
        //等同于直接创建线程对象
        Thread a = new Thread(){
            @Override
            public void run() {
          //指定线程要干的活
            }
        };
        //等同于先创建目标对象，再创建线程对象
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                //指定线程要干的活
            }
        });
        //b的变形，使用lambda表达式
        Thread c = new Thread(( ) -> {
            //指定线程要干的活
        });
    }
}
