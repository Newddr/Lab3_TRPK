import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buffer {
    private List<Integer> buffer = new ArrayList<Integer>();
    private final int BUFFER_SIZE = 8;

    public synchronized void put(int number) throws InterruptedException {
        while (buffer.size() == BUFFER_SIZE) {
            wait();
        }
        buffer.add(number);
        notifyAll();
    }

    public synchronized List<Integer> take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        List<Integer> taken = new ArrayList<Integer>(buffer);
        buffer.clear();
        notifyAll();
        Collections.reverse(taken);
        return taken;
    }

}
