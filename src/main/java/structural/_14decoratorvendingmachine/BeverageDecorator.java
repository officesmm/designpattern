package structural._14decoratorvendingmachine;

abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
        setName(beverage.getName() + "+" + getDecoratedName());
        setPrice(beverage.getPrice() + getIncrementPrice());
    }

    public void decorateBeverage() {
        beverage.decorateBeverage();
        System.out.println("Cost of:" + getName() + ":" + getPrice());
    }

    public abstract int getIncrementPrice();

    public abstract String getDecoratedName();
}