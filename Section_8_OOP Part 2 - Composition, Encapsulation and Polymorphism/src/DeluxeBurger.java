public class DeluxeBurger extends Hamburger {
/*


    private String addition1Name = "chips";
    private double addition1Price = 5;

    private String addition2Name = "drinks";
    private double addition2Price = 10;
*/


/*    public DeluxeBurger() {
        super("Deluxe Burger", "AAAA", 15, "Delux Roll");
    }*/

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAddition1("Chips", 2.75);
        super.addHamburgerAddition2("Drink", 1.81);
    }


   /* public double getAddition1Price() {
        return addition1Price;
    }

    public void setAddition1Price(double addition1Price) {
        this.addition1Price = addition1Price;
    }

    public double getAddition2Price() {
        return addition2Price;
    }

    public void setAddition2Price(double addition2Price) {
        this.addition2Price = addition2Price;
    }
*/
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("This type of humburger has fix addition!");
    }

    public void addHamburgerAddition2(String name, double price) {
        System.out.println("This type of humburger has fix addition!");
    }

    public void addHamburgerAddition3(String name, double price) {
        System.out.println("This type of humburger has fix addition!");
    }

    public void addHamburgerAddition4(String name, double price) {
        System.out.println("This type of humburger has fix addition!");
    }


   /* public double itemizeHamburger() {
        double hamburgerPrice = price;
        System.out.println(name + " hamburger " + " on a " + breadRollType + " roll "
                + "with " + meat + ", price is "  + price);
        if(this.addition1Name != null) {
            hamburgerPrice += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1Price);
        }
        if(this.addition2Name != null) {
            hamburgerPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2Price);
        }


        return hamburgerPrice;
    }*/

}
