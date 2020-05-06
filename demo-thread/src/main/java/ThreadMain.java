public class ThreadMain {
    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread.yield();

        System.out.println("Hello from Main");
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println("Hello from Thread");
        }
    }
}
