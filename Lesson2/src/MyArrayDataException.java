public class MyArrayDataException extends Exception {

    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i=i;
        this.j=j;

    }

    public String setText () {

        System.out.println("Ошибка. Невозможно просуммировать все элементы массива!");
        return String.format ("Элемент массива [%s, %d]  не является числом. %n", i, j);
    }

}
