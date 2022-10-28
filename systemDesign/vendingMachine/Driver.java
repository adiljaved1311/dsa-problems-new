package systemDesign.vendingMachine;

import systemDesign.vendingMachine.inventory.Product;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product hersheys = new Product("hersheys",1,5.0);
        // inserting 3 hersheys
        for(int i=1 ; i <=3 ; i++)
            vendingMachine.addProduct(hersheys);

        Product pepsi = new Product("pepsi",2,2.0);
        // inserting 3 pepsi
        for(int i=1; i<=3 ; i++)
            vendingMachine.addProduct(pepsi);

        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(3.0);
        vendingMachine.pressButton(1);

    }
}
