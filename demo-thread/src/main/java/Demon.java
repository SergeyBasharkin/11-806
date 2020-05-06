public class Demon {

    public static void main(String[] args) {
        Thread timer = new Thread(() -> {
            int seconds = 0;

            while (true){
                seconds++;
                System.out.println(seconds);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timer.setDaemon(true);

        System.out.println("start");
        timer.start();
        System.out.println("stop");
    }
}
