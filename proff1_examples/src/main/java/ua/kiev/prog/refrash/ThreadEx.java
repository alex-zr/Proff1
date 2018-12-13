package ua.kiev.prog.refrash;

public class ThreadEx implements Runnable {
    private int counter;

    @Override
    public void run() {
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
        Thread thread = new Thread(main);
        Thread thread2 = new Thread(main);
        thread.start();
        thread2.start();
    }
}
