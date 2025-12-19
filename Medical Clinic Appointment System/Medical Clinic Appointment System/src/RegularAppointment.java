public class RegularAppointment extends Appointment {
    private String reason;
    private String status;

    public RegularAppointment(String id, Patient patient, Doctor doctor, String dateTime, String reason) {
        super(id, patient, doctor, dateTime);
        this.reason = reason;
        this.status = "Scheduled";
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Regular Appointment]");
        System.out.println("Appointment ID: " + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Reason: " + reason);
        System.out.println("Status: " + status);
    }


}
