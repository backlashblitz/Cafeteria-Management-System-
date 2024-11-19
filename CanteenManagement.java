

public class CanteenManagement {

    public int singara = 20;
    public int bread = 20;
    public int water = 20;
    public int drinks = 20;

    public int quantity = 0;

    public void addItems(int a) {
        singara += a;
        bread += a;
        water += a;
        drinks += a;

    }

    public void displayLeft() {
        System.out.println("Showing the available items.\n");
        System.out.println("Singara     " + singara + " items\n");
        System.out.println("Cream Bread     " + bread + " items\n");
        System.out.println("Water       " + water + " items\n");
        System.out.println("CocaCola        " + drinks + " items\n");

    }
}
