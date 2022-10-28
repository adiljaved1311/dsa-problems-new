package systemDesign.vendingMachine;

import systemDesign.vendingMachine.inventory.Inventory;
import systemDesign.vendingMachine.inventory.Product;
import systemDesign.vendingMachine.states.CoinInsertedState;
import systemDesign.vendingMachine.states.DispenseState;
import systemDesign.vendingMachine.states.NoCoinInsertedState;
import systemDesign.vendingMachine.states.State;

public class VendingMachine {
    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertedState coinInsertedState;
    private DispenseState dispenseState;
    private State curVendingMachineState;
    private Inventory inventory;
    private double amount;
    private static final int AISLE_COUNT = 2;

    public VendingMachine() {
        noCoinInsertedState = new NoCoinInsertedState(this);
        coinInsertedState = new CoinInsertedState(this);
        dispenseState = new DispenseState(this);
        curVendingMachineState = (State) noCoinInsertedState;
        amount = 0.0;
        inventory = new Inventory(AISLE_COUNT);
    }

    public boolean hasSufficientAmount(double expectedAmount) {
        return expectedAmount <= this.amount;
    }

    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public void setCoinInsertedState(CoinInsertedState coinInsertedState) {
        this.coinInsertedState = coinInsertedState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getCurVendingMachineState() {
        return curVendingMachineState;
    }

    public void setCurVendingMachineState(State curVendingMachineState) {
        this.curVendingMachineState = curVendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void insertCoin(double amount) {
        this.curVendingMachineState.insertCoin(amount);
        System.out.println(amount + " coin is inserted");
    }

    public void pressButton(int aisleNumber) {
        this.curVendingMachineState.pressButton(aisleNumber);
        this.curVendingMachineState.dispense(aisleNumber);
    }

    public void addProduct(Product product) {
        try {
            this.getInventory().addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
