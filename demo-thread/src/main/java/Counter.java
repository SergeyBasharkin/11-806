import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count;

    public Counter(int count) {
        this.count = new AtomicInteger(count);
    }

    public void inc(){count.getAndIncrement();}
    public void dec(){count.decrementAndGet();}

    public int getCount() { return count.get();}

}
