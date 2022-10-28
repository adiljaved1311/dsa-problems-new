package systemDesign.vendingMachine.states;

import systemDesign.vendingMachine.VendingMachine;
import systemDesign.vendingMachine.inventory.Inventory;
import systemDesign.vendingMachine.inventory.Product;

public class DispenseState implements State {
    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalArgumentException("Product getting dispensed !!!");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalArgumentException("Product getting dispensed !!!");
    }

    @Override
    public void dispense(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProductAt(aisleNumber);
        inventory.deductProductCount(aisleNumber);
        double change = vendingMachine.getAmount() - product.getPrice();
        vendingMachine.setAmount(0);
        vendingMachine.setCurVendingMachineState(vendingMachine.getNoCoinInsertedState());

        System.out.println("Product name : "+product.getName()+" having Id : "+product.getProductId()+" is dispensed please collect your change "+change);
    }
}
