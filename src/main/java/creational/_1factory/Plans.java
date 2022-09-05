package creational._1factory;

class DomesticPlan extends Plan {
    //@override
    public void getRate() {
        rate = 3.50;
    }
}

class CommercialPlan extends Plan {
    //@override
    public void getRate() {
        rate = 7.50;
    }
}

class InstitutionalPlan extends Plan {
    //@override
    public void getRate() {
        rate = 5.50;
    }
}
