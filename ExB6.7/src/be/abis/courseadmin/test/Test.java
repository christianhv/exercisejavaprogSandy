package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryListCompanyRepository();

        System.out.println("\n------------------------ExB6.7 Hobbies TreeSet----------------------------------");

        try {
            Company comp1 = cr.findCompany(1);
            Company comp2 = cr.findCompany("smals");
            Company comp3 = cr.findCompany(4);

            Person p1 = new Person("Mary","Jones", Gender.FEMALE,comp1);
            Person p2=new Person("John","Doe",Gender.OTHER,comp1);
            Person p3 = new Person("Bob","Janssens", Gender.MALE,comp3);
            Person p4 = new Person("An","Smets", Gender.FEMALE,comp2);
            Person p5 = new Person("Sam","Smets", Gender.OTHER,comp2);
            Person p6 = new Person("Peter","Vanroose", Gender.MALE,comp1);
            p1.addHobby("soccer");
            p2.addHobbies("gaming", "walking", "cooking");
            p3.addHobbies("soccer", "dancing");
            p4.addHobbies("arts","dancing");
            p5.addHobby("martial arts");
            p6.addHobbies("singing","playing music","hiking");

            Person[] persons = {p1, p2, p3,p4,p5,p6};

            for (Person p : persons) {
                System.out.println(p + "'s hobbies are:");
                for (String hobby : p.getHobbies()) {
                    System.out.println(hobby);
                }
            }

        } catch (CompanyNotFoundException cnf) {
            cnf.printStackTrace();
        }


    }
}
