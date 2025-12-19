public class FollowUpAppointment extends Appointment {
    private String reason;
    private String previousAppointmentId;
    private Appointment previousAppointment; // 關聯前次預約
    private String notes;

    public FollowUpAppointment(String id, Patient patient, Doctor doctor, String dateTime,
                               String reason, Appointment previousAppointment, String notes) {
        super(id, patient, doctor, dateTime);
        this.reason = reason;
        this.previousAppointment = previousAppointment;
        this.previousAppointmentId = previousAppointment != null ? previousAppointment.getId() : null;
        this.notes = notes;
    }

    public String getReason() {
        return reason;
    }

    public String getPreviousAppointmentId() {
        return previousAppointmentId;
    }

    public Appointment getPreviousAppointment() {
        return previousAppointment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Follow-up Appointment]");
        System.out.println("Appointment ID: " + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Reason: " + reason);
        System.out.println("Previous Appointment ID: " + (previousAppointmentId != null ? previousAppointmentId : "(none)"));
        if (previousAppointment != null) {
            System.out.println("Previous Appointment Date/Time: " + previousAppointment.getDateTime());
        }
        System.out.println("Notes: " + (notes != null ? notes : ""));
    }
}
