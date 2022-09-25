package collectionsTest.hashmap;

import java.util.WeakHashMap;

class Employee{
    int id;
    String name;
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void finalize(){
        System.out.println("Employee object destroyed");
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        WeakHashMap<Employee,String> wMap = new WeakHashMap<>();
        Employee emp = new Employee(1,"Adil");
        wMap.put(emp,"First");
        emp = null; // WeakHashMap can't protect its key by garbage collector
        System.gc();
        Thread.sleep(5000);
        System.out.println(emp);
        System.out.println(wMap);
    }
}
