import java.util.Random;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    Random random = new Random();
    @Override
    public void run() {
        for (int i = 0; i < 1200; i++) {
            try {
                int gen_Int = random.nextInt(5);
                buffer.put(gen_Int);
                System.out.println("Поток 1, итерация " +i+ " сгенерировано число " + gen_Int);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
