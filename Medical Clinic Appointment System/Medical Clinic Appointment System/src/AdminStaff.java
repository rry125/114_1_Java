public class AdminStaff extends Clinic {
    private String position;
    private String employeeId;

    public AdminStaff(String name, String position, String employeeId) {
        super(name);
        this.position = position;
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Staff Name: " + getName());
        System.out.println("Position: " + position);
        System.out.println("Employee ID: " + employeeId);
    }

}
