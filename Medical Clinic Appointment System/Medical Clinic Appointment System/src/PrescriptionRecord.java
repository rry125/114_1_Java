public class PrescriptionRecord {
    private String id;
    private Patient patient;
    private Clinic doctor; // 與 Main 連結
    private String dateTime;
    private String medication;
    private String instructions;

    public PrescriptionRecord(String id, Patient patient, Clinic doctor, String dateTime, String medication, String instructions) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.medication = medication;
        this.instructions = instructions;
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Clinic getDoctor() { return doctor; }
    public String getDateTime() { return dateTime; }
    public String getMedication() { return medication; }
    public String getInstructions() { return instructions; }

    public void display() {
        System.out.println("[PrescriptionRecord] id=" + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Medication: " + medication);
        System.out.println("Instructions: " + instructions);
    }

    public String getSummaryForDoctor() {
        return "Prescription(" + id + ") for " + (patient != null ? patient.getName() : "(none)") + ": " + medication;
    }
}
