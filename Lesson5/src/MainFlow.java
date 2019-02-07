public class MainFlow {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {

        float[] arr = new float[SIZE];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long ccc = System.currentTimeMillis();

        for (int i=0; i<h; i++) {
            arr[i]=1;
            arr[SIZE-1-i]=1;
        }

        System.out.printf("Время заполнени я массива %d \n", System.currentTimeMillis() - ccc);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, 0, a2, 0, h);

        MyThread mtr1 = new MyThread(a1, 0);
        MyThread mtr2 = new MyThread(a2, h);
        mtr1.start();
        mtr2.start();
        mtr1.join();
        mtr2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.printf("Время выполнени потоков %d \n", System.currentTimeMillis() - a);

    }

}
