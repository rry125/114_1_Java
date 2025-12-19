public class DiagnosisRecord {
    private String id;
    private Patient patient;
    private Clinic doctor; // 與 Main 連結
    private String dateTime;
    private String diagnosis;

    public DiagnosisRecord(String id, Patient patient, Clinic doctor, String dateTime, String diagnosis) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Clinic getDoctor() { return doctor; }
    public String getDateTime() { return dateTime; }
    public String getDiagnosis() { return diagnosis; }

    public void display() {
        System.out.println("[DiagnosisRecord] id=" + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Diagnosis: " + diagnosis);
    }

    public String getSummaryForDoctor() {
        return "DiagnosisRecord(" + id + ") for " + (patient != null ? patient.getName() : "(none)") + ": " + diagnosis;
    }
}

