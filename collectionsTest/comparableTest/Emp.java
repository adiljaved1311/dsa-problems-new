package collectionsTest.comparableTest;

public class Emp implements Comparable<Emp> {

    private int empid;
    private String name;
    private int phone;

    @Override
    public int compareTo(Emp o) {
        return this.empid-o.getEmpid();
    }

    public Emp(int empid, String name, int phone) {
        this.empid = empid;
        this.name = name;
        this.phone = phone;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
