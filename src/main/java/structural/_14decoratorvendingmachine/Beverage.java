package structural._14decoratorvendingmachine;

abstract class Beverage {
    protected String name;
    protected int price;

    public Beverage() {

    }

    public Beverage(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected int getPrice() {
        return price;
    }

    protected abstract void decorateBeverage();

}
