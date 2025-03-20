package at.htlle.sam.beispiel1;

public class Bsp1 {
    public static void main(String[] args){
        String[] stringArray = new String[5];
        stringArray[0] = "1. String";
        stringArray[1] = "2. String";
        stringArray[2] = "3. String";
        stringArray[3] = "4. String";
        stringArray[4] = null;

        stringAusgabe(stringArray);
        System.out.println("------------------------------");
        System.out.println(arrayAnzahl(stringArray));
        System.out.println("------------------------------");
        addString(stringArray, "Hallo");
        stringAusgabe(stringArray);
        System.out.println("------------------------------");
        deleteString(stringArray, "Hallo");
        stringAusgabe(stringArray);
        System.out.println("------------------------------");




    }
    public static void stringAusgabe(String[] stringArray){
        for (int i = 0; i<stringArray.length; i++){
            System.out.println(stringArray[i]);
        }
    }
    public static int arrayAnzahl(String[] stringArray){
        int counter = 0;
        for (int i = 0; i<stringArray.length; i++){
            if (stringArray[i] == null){
                counter += 1;
            }
        }
        return counter;
    }
    public static void addString(String[] stringArray, String addonString){
        for (int i = 0; i<stringArray.length; i++){
            if (stringArray[i] == null){
                stringArray[i] = addonString;
            }
        }
    }
    public static void deleteString(String[] stringArray, String deleteString){
        for (int i = 0; i<stringArray.length; i++){
            if (stringArray[i].equals(deleteString)){
                stringArray[i] = null;
            }
        }
    }
}
