import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class AppointmentManager {
    private final List<Appointment> appointments = new ArrayList<>();
    // 紀錄儲存
     final java.util.List<PrescriptionRecord> prescriptionRecords = new java.util.ArrayList<>();
     private final java.util.List<ExaminationRecord> examinationRecords = new java.util.ArrayList<>();

    public void addAppointment(Appointment appt) {
        // 一律加入列表（若為緊急且 priority，排序時會放在前面）
        appointments.add(appt);
        // 依 priority(緊急先) 再依日期時間排序（dateTime 使用 yyyy-MM-dd HH:mm 格式可字典排序）
        Collections.sort(appointments, new Comparator<Appointment>() {
            @Override
            public int compare(Appointment a1, Appointment a2) {
                boolean p1 = (a1 instanceof EmergencyAppointment) && ((EmergencyAppointment) a1).isPriority();
                boolean p2 = (a2 instanceof EmergencyAppointment) && ((EmergencyAppointment) a2).isPriority();
                if (p1 && !p2) return -1;
                if (!p1 && p2) return 1;
                // 同一優先等級，依 dateTime 字串比較
                if (a1.getDateTime() == null) return 1;
                if (a2.getDateTime() == null) return -1;
                return a1.getDateTime().compareTo(a2.getDateTime());
            }
        });
        // 新增後將病人摘要傳回給該預約的醫師（若有）
        if (appt.getDoctor() != null) {
            String info = appt.getPatientInfoForDoctor();
            appt.getDoctor().receivePatientInfo(info);
        }
    }

    public List<Appointment> listAppointments() {
        return new ArrayList<>(appointments);
    }

    public void listAll() {
        for (Appointment a : appointments) {
            a.displayDetails();
            System.out.println();
        }
    }

    public Appointment getNextAppointment() {
        if (appointments.isEmpty()) return null;
        return appointments.remove(0);
    }

    // 處理看診：建立診斷/處方/檢查紀錄，通知醫師，並記錄該醫師已看診的病人
    public void processAppointment(Appointment appt, String diagnosis, String medication, String instructions, String findings) {
        if (appt == null) return;
        Clinic docMain = appt.getDoctor();
        // 建立診斷紀錄並加入病人內（不要在 manager 儲存）
        if (diagnosis != null && !diagnosis.isEmpty()) {
            DiagnosisRecord dr = new DiagnosisRecord("DR-" + System.currentTimeMillis(), appt.getPatient(), docMain, appt.getDateTime(), diagnosis);
            if (appt.getPatient() != null) {
                appt.getPatient().addDiagnosisRecord(dr);
            }
            if (docMain instanceof Doctor) ((Doctor) docMain).receivePatientInfo(dr.getSummaryForDoctor());
        }
        // 建立處方紀錄
        if (medication != null && !medication.isEmpty()) {
            PrescriptionRecord pr = new PrescriptionRecord("PR-" + System.currentTimeMillis(), appt.getPatient(), docMain, appt.getDateTime(), medication, instructions != null ? instructions : "");
            prescriptionRecords.add(pr);
            if (docMain instanceof Doctor) ((Doctor) docMain).receivePatientInfo(pr.getSummaryForDoctor());
        }
        // 建立檢查紀錄
        if (findings != null && !findings.isEmpty()) {
            ExaminationRecord er = new ExaminationRecord("ER-" + System.currentTimeMillis(), appt.getPatient(), docMain, appt.getDateTime(), findings);
            examinationRecords.add(er);
            if (docMain instanceof Doctor) ((Doctor) docMain).receivePatientInfo(er.getSummaryForDoctor());
        }

        // 記錄醫師已看診該病人（僅 Doctor 需要紀錄）
        if (docMain instanceof Doctor) {
            ((Doctor) docMain).recordSeenPatient(appt.getPatient());
        }
    }

    // 列出所有紀錄（簡易）
    public void listAllRecords() {
        System.out.println("=== Diagnosis Records are stored within each Patient ===");
        System.out.println("=== Prescription Records ===");
        for (PrescriptionRecord p : prescriptionRecords) p.display();
        System.out.println("=== Examination Records ===");
        for (ExaminationRecord e : examinationRecords) e.display();
    }

    public Appointment findById(String id) {
        for (Appointment a : appointments) {
            if (a.getId() != null && a.getId().equals(id)) return a;
        }
        return null;
    }

    public boolean cancel(String id) {
        Appointment a = findById(id);
        if (a != null) {
            return appointments.remove(a);
        }
        return false;
    }
}
