public abstract class Appointment implements Billable {
    protected String id;
    protected Patient patient;
    protected Doctor doctor;
    protected String dateTime; // simple string for demo purposes

    // 計費相關
    protected double baseFee = 0.0;
    protected double insuranceCoveragePercent = 0.0; // 0.0 - 1.0

    public Appointment(String id, Patient patient, Doctor doctor, String dateTime) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDateTime() {
        return dateTime;
    }

    public abstract void displayDetails();

    // 設定計費參數（子類可於建構時呼叫）
    public void setBaseFee(double fee) {
        this.baseFee = fee;
    }

    public void setInsuranceCoveragePercent(double p) {
        this.insuranceCoveragePercent = p;
    }

    // Billable 實作（可由子類覆寫以提供更細緻邏輯）
    @Override
    public double calculateFee() {
        return baseFee;
    }

    @Override
    public double getInsuranceCoverage() {
        return baseFee * insuranceCoveragePercent;
    }

    @Override
    public double getPatientPayable() {
        return baseFee - getInsuranceCoverage();
    }

    // 提供給醫師的病人資訊摘要（可被子類覆寫以包含額外欄位）
    public String getPatientInfoForDoctor() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient Name: ").append(patient != null ? patient.getName() : "(none)").append("\n");
        sb.append("Age: ").append(patient != null ? String.valueOf(patient.getAge()) : "(unknown)").append("\n");
        sb.append("Medical Record Number: ").append(patient != null ? patient.getMedicalRecordNumber() : "(none)");
        return sb.toString();
    }
}
