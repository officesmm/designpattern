package creational._2abstractfactory;

class HomeLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}//End of the HomeLoan class.
class BusinessLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}//End of the BusinessLoan class.
class EducationLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}//End of the EducationLoan class.