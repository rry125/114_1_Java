public class Nurse extends Clinic {
    private String department;
    private String employeeId;

    public Nurse(String name, String department, String employeeId) {
        super(name);
        this.department = department;
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nurse Name: " + getName());
        System.out.println("Department: " + department);
        System.out.println("Employee ID: " + employeeId);
    }
}
