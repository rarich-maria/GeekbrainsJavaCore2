public class MyThread extends Thread{

    float[] arr;
    int pos;

        public MyThread (float[] arr, int pos) {
            this.arr=arr;
            this.pos=pos;
        }

        @Override
        public void run() {
            int h = arr.length;
            long a = System.currentTimeMillis();
            for (int i = 0; i < h; i++) {
                int j=pos+i;
                arr[i] = (float)(arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
            System.out.printf("Время выполнени потока для массива от [%d]: %d \n", pos,  System.currentTimeMillis() - a);

        }

}
