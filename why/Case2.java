package why;

import java.util.Scanner;

//计算斐波那锲数
public class Case2 {
    static class FibThread extends Thread{
        int n;

        FibThread(int n){
            this.n = n;
        }

        @Override
        public void run() {
            System.out.printf("fib(%d) = %d%n",n,fib(n));
        }
    }
    static long fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("请输入你要计算的数：");
            int n = scanner.nextInt();
            scanner.nextLine();
            new FibThread(n).start();
        }
    }
}
