public class Patient extends Clinic implements Queueable {
    private int age;
    private String medicalRecordNumber;
    // 病人的診斷紀錄
    private java.util.List<DiagnosisRecord> diagnosisRecords = new java.util.ArrayList<>();
    // 候診相關
    private int queueNumber = -1;
    private int priority = 0; // 0=normal, higher = higher priority

    public Patient(String name, int age, String medicalRecordNumber) {
        super(name);
        this.age = age;
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void addDiagnosisRecord(DiagnosisRecord dr) {
        if (dr == null) return;
        diagnosisRecords.add(dr);
    }

    public java.util.List<DiagnosisRecord> getDiagnosisRecords() {
        return new java.util.ArrayList<>(diagnosisRecords);
    }

    // Queueable 實作
    @Override
    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int q) {
        this.queueNumber = q;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    @Override
    public int getEstimatedWaitTime() {
        // 簡單估算：每位等待者平均 15 分鐘，優先度會減少等待時間
        int basePerPatient = 15; // minutes
        int est = (queueNumber > 0 ? queueNumber : 0) * basePerPatient;
        // priority reduces wait time
        est = Math.max(0, est - priority * 5);
        return est;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Medical Record Number: " + medicalRecordNumber);
    }

    public String getName() {
        return super.getName();
    }
}
