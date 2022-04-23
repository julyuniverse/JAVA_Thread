/**
 * 자바에서 thread를 만드는 방법 2가지
 * 1. Thread 클래스를 상속
 * 2. Runnable 인터페이스를 임플러먼트스(구현)
 */

// 2. Runnable 인터페이스를 임플러먼트스(구현)
class MyThread2 implements Runnable {
    @Override
    public void run() {
        int i;
        for (i = 1; i <= 200; i++) {
            System.out.print(i + "\t");
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");

        MyThread2 runnable = new MyThread2();

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        System.out.println(Thread.currentThread() + "end");

        // 결과
        // Thread[main,5,main]start
        // Thread[main,5,main]end
        // 1	1	2	2	3	4	3	5	4	6	5	6	7	...

        /**
         * thread 수는 총 3개
         * main, th1, th2
         *
         * 결과를 보면 main 쓰레드가 제일 먼저 끝났고 이어서 th1, th2가 각각 실행된다.
         */

        // inner class로 생성해서 thread 구현
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };

        run.run();
    }
}
