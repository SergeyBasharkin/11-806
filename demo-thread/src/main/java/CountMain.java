public class CountMain {
    static Counter counter = new Counter(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            Counter counter1 = counter;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 1_000_000; i++) {
                counter1.inc();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1_000_000; i++) {
                counter.dec();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
