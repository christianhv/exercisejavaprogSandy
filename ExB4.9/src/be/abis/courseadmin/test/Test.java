package be.abis.courseadmin.test;

import be.abis.courseadmin.model.*;

public class Test {

    public static void main(String[] args) {

        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("TDD",2,450);

        Company comp1 = new Company("Abis");
        Company comp2 = new Company("IBM");

        Person p1 = new Person("Mary","Jones",comp1);
        Person p2=new Person("John","Doe");
        Person p3 = new Person("Bob","Janssens",new Company("TTL"));



        System.out.println("\n------------------------ExB4.8 Services abstract----------------------------------");
        CompanySession companySession1 = new CompanySession(course2,"5/10/2022",comp1,p3,comp2);
        CompanySession companySession2 = new CompanySession(course1,"7/11/2022",comp2,p1,comp2,5);
        PublicSession publicSession = new PublicSession(course2,"22/11/2022",comp1,p3);

       Consultancy consultancy = new Consultancy();
        Service[] services = {companySession1,consultancy,companySession2,publicSession};
        for (Service s : services){
            if (s instanceof Session){
                ((Session) s).printInfo();
            }
            System.out.println("The price for the " +s.getClass().getSimpleName() + " is " +s.calculatePrice() +".\n");
        }
      
    }
}
