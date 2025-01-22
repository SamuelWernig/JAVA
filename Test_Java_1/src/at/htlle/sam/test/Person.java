package at.htlle.sam.test;

public class Person {
    //Attribute
    private String vorName;  // Name und Nachname
    private String nachName;
    private Tier[] tiere; // Array mit max 5 tieren durch Constante
    private int tiereCount; // Counter umzusehen wie viele Tiere in dem Array sind

    public Person(String vorName, String nachName) {
        this.tiere = new Tier[Constants.MAX_ANZAHL_TIERE];
        this.tiereCount = 0;
        this.vorName = vorName;
        this.nachName = nachName;
    }
    public Person(){ // Hab verstanden dass alle auch über einen Default Constructor verfügen sollen
    }
    //Methods
    public boolean neuesHaustier(Tier t){
        if(tiereCount>= Constants.MAX_ANZAHL_TIERE){
            return false;
        }else{
            tiere[tiereCount] = t;
            this.tiereCount++;
            return true;
        }
    }
    public void zeigeTiere(){
        for(int i=0; i<tiereCount; i++){
            System.out.println(tiere[i]);    //Es wird Automatisch die toString Methode verwendet
        }
    }


    //Getter and Setter

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }


}
