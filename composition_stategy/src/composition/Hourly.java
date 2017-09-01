package composition;

public class Hourly {

    private EmployeeInfo employee;
    private double hourValue;

    public Hourly(EmployeeInfo employee) {
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

