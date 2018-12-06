package ua.kiev.prog.refrash;

public class ThreadEx implements Runnable {
    private int counter;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + counter++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadEx main = new ThreadEx();
        Thread thread1 = new Thread(main);
        Thread thread2 = new Thread(main);
        thread1.start();
        thread2.start();
    }
}
