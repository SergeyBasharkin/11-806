package store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    store.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                store.put();
            }
        }).start();
    }
}
