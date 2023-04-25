package mediator;

class Employee {
    private String name;
    private String designation;
    private double salary;
    
    public Employee(String name, String designation, double salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public Memento save() {
        return new Memento(name, designation, salary);
    }
    
    public void restore(Memento memento) {
        this.name = memento.getName();
        this.designation = memento.getDesignation();
        this.salary = memento.getSalary();
    }
    
    static class Memento {
        private String name;
        private String designation;
        private double salary;
        
        public Memento(String name, String designation, double salary) {
            this.name = name;
            this.designation = designation;
            this.salary = salary;
        }
        
        public String getName() {
            return name;
        }
        
        public String getDesignation() {
            return designation;
        }
        
        public double getSalary() {
            return salary;
        }
    }
}

public class MementoExample {
    public static void main(String[] args) {
        Employee employee = new Employee("Ravi", "Manager", 50000);
        System.out.println("Employee before change: " + employee.getName() + ", " + employee.getDesignation() + ", " + employee.getSalary());
        
        Employee.Memento memento = employee.save();
        employee.setName("Rahul");
        employee.setDesignation("Developer");
        employee.setSalary(40000);
        System.out.println("Employee after change: " + employee.getName() + ", " + employee.getDesignation() + ", " + employee.getSalary());
        
        employee.restore(memento);
        System.out.println("Employee after restore: " + employee.getName() + ", " + employee.getDesignation() + ", " + employee.getSalary());
    }
}
