public class EmergencyAppointment extends Appointment {
    private String severityLevel;
    private String emergencyContact;
    private boolean priority; // 插隊標記

    public EmergencyAppointment(String id, Patient patient, Doctor doctor, String dateTime,
                                String severityLevel, String emergencyContact) {
        super(id, patient, doctor, dateTime);
        this.severityLevel = severityLevel;
        this.emergencyContact = emergencyContact;
        this.priority = true; // 緊急加號預設為優先
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public void markAsEmergency() {
        this.priority = true;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Emergency Appointment]");
        System.out.println("Appointment ID: " + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Severity Level: " + severityLevel);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Priority (插隊): " + (priority ? "Yes" : "No"));
    }
}
