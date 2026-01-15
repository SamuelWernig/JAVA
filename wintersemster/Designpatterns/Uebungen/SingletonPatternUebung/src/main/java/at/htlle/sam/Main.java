package at.htlle.sam;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConfigManager cm = ConfigManager.getInstance();

        System.out.println(cm.toString());

    }
}