import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Doctor extends Clinic implements Schedulable {
    private String specialty;
    private String licenseNumber;

    // 記錄已看診過的病人
    private java.util.List<Patient> seenPatients = new java.util.ArrayList<>();
    // 排程用時段管理
    private java.util.List<TimeSlot> availableSlots = new java.util.ArrayList<>();
    private java.util.List<TimeSlot> bookedSlots = new java.util.ArrayList<>();

    public Doctor(String name, String specialty, String licenseNumber) {
        super(name);
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
        // 預設加入一個示範時段
        // 可由外部使用 getAvailableSlots/bookSlot 管理
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor Name: " + getName());
        System.out.println("Specialty: " + specialty);
        System.out.println("License Number: " + licenseNumber);
    }

    // 接收並顯示給醫師的病人摘要資訊（由 AppointmentManager 呼叫）
    public void receivePatientInfo(String info) {
        System.out.println("--- Patient info delivered to Dr. " + getName() + " ---");
        System.out.println(info);
        System.out.println("--- End of patient info ---");
    }

    // 記錄醫師已看診的病人
    public void recordSeenPatient(Patient p) {
        if (p == null) return;
        // 若尚未記錄，加入清單
        boolean exists = false;
        for (Patient sp : seenPatients) {
            if (sp.getMedicalRecordNumber() != null && sp.getMedicalRecordNumber().equals(p.getMedicalRecordNumber())) {
                exists = true;
                break;
            }
        }
        if (!exists) seenPatients.add(p);
    }

    public java.util.List<Patient> getSeenPatients() {
        return new java.util.ArrayList<>(seenPatients);
    }

    // Schedulable 實作
    @Override
    public ArrayList<TimeSlot> getAvailableSlots(LocalDate date) {
        ArrayList<TimeSlot> result = new ArrayList<>();
        for (TimeSlot ts : availableSlots) {
            if (ts.getStart().toLocalDate().equals(date)) result.add(ts);
        }
        return result;
    }

    @Override
    public boolean bookSlot(TimeSlot slot) {
        if (slot == null) return false;
        for (Iterator<TimeSlot> it = availableSlots.iterator(); it.hasNext(); ) {
            TimeSlot t = it.next();
            if (t.getStart().equals(slot.getStart()) && t.getEnd().equals(slot.getEnd())) {
                it.remove();
                bookedSlots.add(slot);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cancelSlot(TimeSlot slot) {
        if (slot == null) return false;
        for (Iterator<TimeSlot> it = bookedSlots.iterator(); it.hasNext(); ) {
            TimeSlot t = it.next();
            if (t.getStart().equals(slot.getStart()) && t.getEnd().equals(slot.getEnd())) {
                it.remove();
                availableSlots.add(slot);
                return true;
            }
        }
        return false;
    }

    // 供測試或初始化使用
    public void addAvailableSlot(TimeSlot slot) {
        if (slot != null) availableSlots.add(slot);
    }

}
