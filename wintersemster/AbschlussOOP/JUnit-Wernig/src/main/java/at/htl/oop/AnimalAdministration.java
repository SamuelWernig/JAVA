package at.htl.oop;

public class AnimalAdministration {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Dog("Yoda"));
        zoo.addAnimal(new Cat("Lea"));

        for (String sound : zoo.getAllSounds()) {
            System.out.println(sound);
        }
    }
}