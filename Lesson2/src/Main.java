public class Main {

    public static void main (String [] args) {


        String [][] arr = {{"1", "2", "3", "5"},
                  {"gh", "1", "6", "1"},
                  {"4", "1", "6", "1"},
                  {"4", "1", "6", "6"}};

        doSum (arr);

    }

    public static void doSum (String [][] arr) {
        int sum=0;

        try {
            checkSizeArray (arr.length, arr [0].length);
            for (int i=0; i<arr.length; i++ ) {
                for (int j = 0; j < arr[0].length; j++) {
                    checkData(arr[i][j], i, j);
                    sum+=Integer.valueOf (arr[i][j]);
                }
            }
            System.out.println ("Сумма элементов массива: " + sum);
        }catch (MySizeArrayException e) {
            System.out.println ("Ошибка! Размер массива должен быть 4х4");
        }catch (MyArrayDataException e) {
            System.out.println("Ошибка. Невозможно просуммировать все элементы массива!");
        }

    }



    public static void checkData (String arr, int i, int j) throws MyArrayDataException  {
        try {Integer.valueOf(arr);}
        catch (Exception e){
            System.out.printf("Элемент массива [%s, %d]  не является числом. %n", i, j);
            throw new MyArrayDataException();
        }

    }

    public static void checkSizeArray (int line, int column) throws MySizeArrayException {

        if (line!=4 || column!=4) {throw new MySizeArrayException ();}
    }



}
