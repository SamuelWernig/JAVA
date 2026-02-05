package at.htlle.sam.sandwich;

public class Sandwich {
    private String bread;
    private String cheese;
    private String sauce;
    private String patty;
    private String ham;

    private Sandwich(Builder builder) {
        this.bread = builder.bread;
        this.cheese = builder.cheese;
        this.sauce = builder.sauce;
        this.patty = builder.patty;
        this.ham = builder.ham;
    }

    @Override
    public String toString() {
        return bread + ", " + cheese + ", " + sauce + ", " + patty + ", " + ham;
    }

    public static class Builder {
        private String bread;
        private String cheese;
        private String sauce;
        private String patty;
        private String ham;

        public Builder(String bread, String cheese, String sauce){
            this.bread = bread;
            this.cheese = cheese;
            this.sauce = sauce;
        }

        public Builder newBread(String bread){
            this.bread = bread;
            return this;
        }
        public Builder newCheese(String cheese){
            this.cheese = cheese;
            return this;
        }
        public Builder newSauce(String sauce){
            this.sauce = sauce;
            return this;
        }
        public Builder newPatty(String patty){
            this.patty = patty;
            return this;
        }
        public Builder newHam(String ham){
            this.ham = ham;
            return this;
        }
        public Sandwich build(){
            return new Sandwich(this);
        }

    }

}
