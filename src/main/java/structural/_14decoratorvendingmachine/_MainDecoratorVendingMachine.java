package structural._14decoratorvendingmachine;

public class _MainDecoratorVendingMachine {
    public static void main(String args[]) {
        Beverage beverage = new SugarDecorator(new LemonDecorator(new Tea("Assam Tea")));
        beverage.decorateBeverage();
        System.out.println();
        beverage = new SugarDecorator(new LemonDecorator(new Coffee("Cappuccino")));
        beverage.decorateBeverage();
    }
}
