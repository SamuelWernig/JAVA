package at.htlle.sam.Woerterzaehler;

import java.util.HashMap;

public class Woerterzaehler {
    private String text = "Berge faszinieren Menschen seit jeher. Sie ragen majestätisch in den Himmel, geprägt von Fels, Schnee und zeitloser Stille. Für viele symbolisieren sie Freiheit, Stärke und Erhabenheit. Wer einmal einen Berggipfel erreicht hat, kennt das Gefühl: Stolz, Ehrfurcht und tiefer Frieden. Der Weg dorthin ist oft mühsam – steile Pfade, raue Witterung und körperliche Anstrengung fordern Ausdauer und Willenskraft. Doch genau das macht das Erlebnis so besonders.\n" +
            "\n" +
            "Berge bieten nicht nur eine beeindruckende Kulisse, sondern auch Lebensraum für vielfältige Tier- und Pflanzenarten. Steinböcke, Murmeltiere, seltene Blumen – sie alle haben sich an das oft raue Klima angepasst. Auch für den Menschen sind Berge ein Rückzugsort: zum Wandern, Klettern oder einfach zum Durchatmen. In einer zunehmend hektischen Welt bieten sie Ruhe und Klarheit.\n" +
            "\n" +
            "Besonders in den Alpen, aber auch in anderen Gebirgen weltweit, spürt man die Kraft der Natur. Alte Hütten, klare Bergseen und frische Luft lassen den Alltag vergessen. Ob allein oder in Gesellschaft – ein Tag in den Bergen ist wie eine Reise zu sich selbst. Wer sie mit Respekt behandelt, wird reich belohnt – mit Ausblicken, Erinnerungen und innerer Ruhe.";

    private HashMap<String,Integer> map = new HashMap<String,Integer>();
    private String[] worte = text.split("[^a-zA-Z0-9äöüÄÖÜß]+");

    public void zaehlWoerter(String[] worte, String wort){
        int i=0;
        for(String w:worte){
            if(w.equals(wort)){
                i += 1;
            }
        }
        map.put(wort, i);
    }


    public String[] getWorte() {
        return worte;
    }

    public void setWorte(String[] worte) {
        this.worte = worte;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public static void main(String[] args) {
        Woerterzaehler w = new Woerterzaehler();
        w.zaehlWoerter(w.getWorte(), "Berge");
        System.out.println(w.map.get("Berge"));
    }
}

