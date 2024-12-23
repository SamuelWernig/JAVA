package at.htlle.sam.Weihnachtsuebung;

public class Person {
    private String name;
    private Geschenk[] geschenke;
    private int counter;

    public Person(String name) {
        this.name = name;
        this.geschenke = new Geschenk[Constants.MAX_GESCHENKE];
        this.counter = 0;
    }


    public boolean geschenkHinzufuegen(Geschenk g) {
        if (counter >= geschenke.length) {
            return false;
        }
        geschenke[counter] = g;
        counter++;
        return true;
    }


    public void zeigeGeschenke() {
        System.out.println("Geschenke von " + name + ":");
        for (int i = 0; i < counter; i++) {
            System.out.println(geschenke[i]);
        }
    }
    public boolean geschenkLoeschen(Geschenk g) {
        if (counter >= geschenke.length) {
            return false;
        }else{
            for (int i = 0; i < counter; i++) {
                if (geschenke[i] == g){
                    geschenke[i] = geschenke[counter];
                    geschenke[counter] = null;
                }
            }
            counter--;
            return true;
        }
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
   public String toString() {
        String result = name+": ";
        for (int i = 0; i < geschenke.length; i++) {
            if (geschenke[i] != null) {
                result +=geschenke[i]+ ", ";
            }

        }
        return result;
    }

}
