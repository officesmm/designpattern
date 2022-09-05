package creational._5prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _MainPrototype {
    static int eid;
    static String ename;
    static String edesignation;
    static String eaddress;
    static double esalary;

    public static void main(String[] args) throws IOException {
        defaultData();
//        dataInputRequest();

        EmployeeRecord e1 = new EmployeeRecord(eid, ename, edesignation, esalary, eaddress);

        e1.showRecord();
        System.out.println("\n");
        EmployeeRecord e2 = (EmployeeRecord) e1.getClone();
        e2.showRecord();
    }

    public static void defaultData(){
        eid = 12345;
        ename = "emplyoee 1";
        edesignation = "team 2";
        eaddress = "kimanaku shinosaji 4-7-4";
        esalary = 4360.5;

    }

    public static void dataInputRequest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Employee Id: ");
        eid = Integer.parseInt(br.readLine());
        System.out.print("\n");

        System.out.print("Enter Employee Name: ");
        ename = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Designation: ");
        edesignation = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Address: ");
        eaddress = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Salary: ");
        esalary = Double.parseDouble(br.readLine());
        System.out.print("\n");
    }
}
