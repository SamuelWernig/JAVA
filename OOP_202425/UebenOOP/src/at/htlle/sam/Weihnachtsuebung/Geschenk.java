package at.htlle.sam.Weihnachtsuebung;

public class Geschenk {
    private String beschreibung;

    public Geschenk(String beschreibung) {
        this.beschreibung = beschreibung;
    }






    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    @Override
    public String toString() {
        return beschreibung;
    }
}
