public class Main {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        for (int i=0; i<h; i++) {
            arr[i]=1;
            arr[SIZE-1-i]=1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);

    }

}
