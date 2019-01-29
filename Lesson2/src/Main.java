public class Main {

    public static void main (String [] args) {


        String [][] arr = {{"4", "2", "3", "5"},
                  {"0", "1", "6", "1"},
                  {"4", "1", "6", "7" },
                  {"4", "1", "op", "5"}};

        doSum (arr);

    }

    public static void doSum (String [][] arr) {
        int sum=0;

        try {
            for (int i=0; i<arr.length; i++ ) {
                checkSizeArray (arr.length, arr [i].length);
                for (int j = 0; j < arr[i].length; j++) {
                    checkData(arr[i][j], i, j);
                    sum+=Integer.valueOf (arr[i][j]);
                }
            }
            System.out.println ("Сумма элементов массива: " + sum);
        }catch (MySizeArrayException e) {
            e.setText();
        }catch (MyArrayDataException e) {
            System.out.println (e.setText());
        }
    }



    public static void checkData (String arr, int i, int j) throws MyArrayDataException  {
        try {Integer.valueOf(arr);}
        catch (Exception e){
            throw new MyArrayDataException(i, j);
        }

    }

    public static void checkSizeArray (int line, int column) throws MySizeArrayException {

        if (line!=4 || column!=4) {throw new MySizeArrayException ();}
    }



}
