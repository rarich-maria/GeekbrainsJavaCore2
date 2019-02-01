import java.util.ArrayList;

public class Task1 {

    public static void main (String [] args) {
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("мама");
        arrList.add("папа");
        arrList.add("яблоко");
        arrList.add("мама");
        arrList.add("ритм");
        arrList.add("мама");
        arrList.add("мама");
        arrList.add("мис");
        arrList.add("мис");
        arrList.add("зима");
        arrList.add("ветер");
        arrList.add("зима");
        arrList.add("зима");
        arrList.add("зима");
        System.out.println(arrList);

        compare(arrList);

    }

    public static void compare (ArrayList<String> arrList) {
        while (arrList.size()!=0){
            int count=0;
            String a=arrList.get(0);

            for (int i=0; i<arrList.size(); i++) {
                while (i<arrList.size() && a.equals(arrList.get(i))) {
                    count++;
                    arrList.remove(i);
                }
            }

            System.out.printf ("Слово %s повторяется %d раз %n", a, count);

        }
    }

}
