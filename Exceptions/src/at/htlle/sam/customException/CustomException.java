package at.htlle.sam.customException;

public class CustomException {
    public static void main(String[] args) {
        String name = null;
        try {
            System.out.println(name.length());
        }catch(RuntimeException e) {
            e.printStackTrace();
        }

    }
}
