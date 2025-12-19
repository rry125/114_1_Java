public class ExaminationRecord {
    private String id;
    private Patient patient;
    private Clinic doctor; // 與 Main 連結
    private String dateTime;
    private String findings;

    public ExaminationRecord(String id, Patient patient, Clinic doctor, String dateTime, String findings) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.findings = findings;
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Clinic getDoctor() { return doctor; }
    public String getDateTime() { return dateTime; }
    public String getFindings() { return findings; }

    public void display() {
        System.out.println("[ExaminationRecord] id=" + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Findings: " + findings);
    }

    public String getSummaryForDoctor() {
        return "Examination(" + id + ") for " + (patient != null ? patient.getName() : "(none)") + ": " + findings;
    }
}

