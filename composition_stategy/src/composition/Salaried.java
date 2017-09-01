package composition;

import strategy.employee.Employee;

public class Salaried {

    private EmployeeInfo employee;
    private double salaryValue;

    public Salaried(EmployeeInfo employee) {
        this.employee = employee;
    }

    public double calculateSalary(){
        return 0;
    }

    public void setEmployee(EmployeeInfo employee) {
        this.employee = employee;
    }

    public EmployeeInfo getEmployee() {
        return employee;
    }

    public String getName() {
        return employee.getName();
    }

    public int getId() {
        return employee.getId();
    }

    public void setName(String name){
        this.employee.setName(name);
    }


}
