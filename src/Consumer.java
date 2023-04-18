public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String s="";
                int sumTaken=0;
                int counter=1;
                for (int y: buffer.take()) {
                    sumTaken+=y*counter;
                    counter*=5;
                    s=y+" "+s;
                }
                s="На момент взятия 2 потоком в буфере хранились числа :"+s;
                System.out.println(s);
                System.out.println("Поток 2 преобразовал  " + sumTaken);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
