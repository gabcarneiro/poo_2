package strategy.employee;

public class Tester {

    public static void main(String[] args) {

        PayCalculation horista = new PayHourly();
        PayCalculation salariado = new PaySalaried();

        Employee amanda = new Employee("amanda", horista);
        Employee gabriel = new Employee("gabriel", salariado);

        System.out.println(gabriel.calculateSalary());
        System.out.println(amanda.calculateSalary());
    }
}
