package creational._4singleton;

public class _MainSingleton {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // TODO Auto-generated method stub
        Employee emp1 = new Employee();
        emp1.setName("neutro");

        Employee emp2 = new Employee();
        emp2.setName("neutro");

        boolean isEqual = emp1.equals(emp1);

        isEqual = emp1 == emp2;
        System.out.println("Is Equal Test1 = " + isEqual);

        Singleton.getInstance(Employee.class).setName("Hello");
        emp1 = Singleton.getInstance(Employee.class);
        emp2 = Singleton.getInstance(Employee.class);

        isEqual = emp1 == emp2;
        System.out.println("Is Equal Test2 = " + isEqual);

        System.out.println("emp1 = " + emp1.getName());
        System.out.println("emp2 = " + emp2.getName());

        Singleton.getInstance(Department.class).setName("Information Technology");
        Department dpt1 = Singleton.getInstance(Department.class);
        Department dpt2 = Singleton.getInstance(Department.class);

        isEqual = dpt1 == dpt2;
        System.out.println("Is Equal Test3 = " + isEqual);

        System.out.println("dpt1 = " + dpt1.getName());
        System.out.println("dpt2 = " + dpt2.getName());

    }
}
