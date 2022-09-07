package structural._14decoratorvendingmachine;

class Tea extends Beverage {
    public Tea(String name) {
        super(name);
        setPrice(10);
    }

    public void decorateBeverage() {
        System.out.println("Cost of:" + name + ":" + price);
        // You can add some more functionality
    }
}

class Coffee extends Beverage{
    public Coffee(String name){
        super(name);
        setPrice(15);
    }
    public void decorateBeverage(){
        System.out.println("Cost of:"+ name +":"+ price);
        // You can add some more functionality
    }
}