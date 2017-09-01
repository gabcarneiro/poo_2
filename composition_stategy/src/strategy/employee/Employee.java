package strategy.employee;

public class Employee {

    private String name;
    private PayCalculation pc;

    public Employee(String name, PayCalculation pc) {
        this.name = name;
        this.pc = pc;
    }

    public double calculateSalary(){
       return pc.calculateSalary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PayCalculation getPc() {
        return pc;
    }

    public void setPc(PayCalculation pc) {
        this.pc = pc;
    }
}
