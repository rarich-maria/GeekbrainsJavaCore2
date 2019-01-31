import java.util.HashMap;
import java.util.HashSet;

public class Task2 {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> catalog = new HashMap<String, HashSet<String>>();
        HashSet<String> hash1= new HashSet<String>();
        hash1.add("24-53-25");
        hash1.add("89514707684");

        catalog.put("Рарич", hash1);
        //outputCatalog(catalog);
        addElem(catalog, "Рарич", "89304050963");
        addElem(catalog, "Иванов", "85-85-69");
        addElem(catalog, "Леонова", "+79603456789");
        //outputCatalog(catalog);
        outputPhone ("Рарич", getPhone(catalog, "Рарич"));
        outputPhone ("Иванов", getPhone(catalog, "Иванов"));
        outputPhone ("Леонова", getPhone(catalog, "Леонова"));

    }


    public static void addElem (HashMap<String, HashSet<String>> catalog  , String keyCatalog, String value) {


        if (catalog.keySet().contains(keyCatalog)) {
            catalog.get(keyCatalog).add(value);
        }else {
            HashSet<String> hash= new HashSet<String>();
            hash.add(value);
            catalog.put(keyCatalog, hash);
        }
            /*boolean resalt=false;
            for (String k: catalog.keySet()) {
             if(k.equals(keyCatalog)) {
                    catalog.get(k).add(value);
                    resalt=true;
                    break;
                }
             }

            if (!resalt) {
                HashSet<String> hash= new HashSet<String>();
                hash.add(value);
                catalog.put(keyCatalog, hash);
            }*/
    }

    public static void outputCatalog (HashMap<String, HashSet<String>> catalog) {

        for (String k: catalog.keySet()) {
            System.out.printf("%s%n", k);
            for (String v: catalog.get(k)) { //Итератор по хешсету это я для себя пишу
                System.out.printf("\t%s%n", v);
            }
        }

    }

    public static HashSet<String> getPhone (HashMap<String, HashSet<String>> catalog, String lastName) {
        /*System.out.printf ("По фамилии %s найдены следующие телефонные номера: %n", lastName);
        for (String v: catalog.get(lastName)) { //Итератор по хешсету
            System.out.printf("\t%s%n", v);
        }*/
        return catalog.get(lastName);
    }

    public static void outputPhone (String lastName, HashSet<String> phons ) {
        System.out.printf ("По фамилии %s найдены следующие телефонные номера: %n", lastName);
        System.out.println(phons);

    }


}
