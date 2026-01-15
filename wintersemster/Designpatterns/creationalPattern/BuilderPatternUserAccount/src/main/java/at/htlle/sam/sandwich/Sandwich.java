package at.htlle.sam.sandwich;

public class Sandwich {
    private String bread;
    private String cheese;
    private String sauce;
    private String patty;
    private String ham;

    public Sandwich(Builder builder){
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

        public Builder(String Bread, String Cheese, String Sauce){
            this.bread = Bread;
            this.cheese = Cheese;
            this.sauce = Sauce;
        }

        public Builder withPatty(String patty){
            this.patty = patty;
            return this;
        }
        public Builder withHam(String ham){
            this.ham = ham;
            return this;
        }

        public Sandwich build(){
            return new Sandwich(this);
        }

    }
}
