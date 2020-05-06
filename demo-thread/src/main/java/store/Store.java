package store;

public class Store {
    private volatile int product = 0;

    public synchronized void get() throws InterruptedException {
        if (product == 0){
            wait();
        }
        product--;
        System.out.println("get " + product);
        notify();
    }

    public synchronized void put(){
        if (product>=3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        notify();
        System.out.println("put " + product);
    }
}
