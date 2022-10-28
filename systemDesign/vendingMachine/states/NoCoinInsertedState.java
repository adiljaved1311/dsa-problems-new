package systemDesign.vendingMachine.states;

import systemDesign.vendingMachine.VendingMachine;

public class NoCoinInsertedState implements State{
    VendingMachine vendingMachine;

    public NoCoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.setCurVendingMachineState(vendingMachine.getCoinInsertedState());
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalArgumentException("No coin is inserted");
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalArgumentException("No coin is inserted");
    }
}
