package collectionsTest.comparatorTest;

import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        Emp emp1 = new Emp(2,"Adil",8130768);
        Emp emp2 = new Emp(1,"Kundan",989946);
        Emp emp3 = new Emp(3,"Dubey",8130146);

        ArrayList<Emp> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        System.out.println(empList);

        Collections.sort(empList,new CompareByName());
        System.out.println(empList);
    }
}

