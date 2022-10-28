package systemDesign.vendingMachine.states;

import systemDesign.vendingMachine.VendingMachine;
import systemDesign.vendingMachine.inventory.Inventory;
import systemDesign.vendingMachine.inventory.Product;

public class CoinInsertedState implements State{
    VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(vendingMachine.getAmount()+amount);
    }

    @Override
    public void pressButton(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProductAt(aisleNumber);
        if(!vendingMachine.hasSufficientAmount(product.getPrice())){
            throw new IllegalArgumentException("Insufficient amount to buy this product");
        }
        if(!inventory.checkIfProductAvailable(product.getProductId())){
            throw new IllegalArgumentException("Product not available");
        }
        vendingMachine.setCurVendingMachineState(vendingMachine.getDispenseState());
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalArgumentException("Product not chosen yet");
    }
}
