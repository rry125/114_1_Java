public class Clinic implements Notifiable{
    private String name;
    private ContactMethod preferredContactMethod = ContactMethod.EMAIL;

    public Clinic(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ContactMethod getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(ContactMethod method) {
        this.preferredContactMethod = method;
    }

    // 預設顯示資訊，子類可覆寫
    public void displayInfo() {
        System.out.println("Clinic Name: " + getName());
    }



    @Override
    public void sendReminder(Appointment appointment) {
        String msg = "Reminder for appointment " + (appointment != null ? appointment.getId() : "(unknown)") + ".";
        sendNotification(msg);
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[Notification to " + getName() + " via " + getPreferredContactMethod() + "] " + message);
    }

    public static void main(String[] args){

        Doctor doc = new Doctor("Dr. Alice", "Cardiology", "D-12345");
        Nurse nurse = new Nurse("Bob", "ER", "N-6789");
        AdminStaff admin = new AdminStaff("Carol", "Receptionist", "A-2468");
        Patient patient = new Patient("Dave", 30, "MRN-001");

        doc.displayInfo();
        System.out.println();
        nurse.displayInfo();
        System.out.println();
        admin.displayInfo();
        System.out.println();
        patient.displayInfo();
        System.out.println();

        // 使用 AppointmentManager 管理所有預約
        AppointmentManager manager = new AppointmentManager();

        TelemedicineAppointment tele = new TelemedicineAppointment(
                "T-100", patient, doc, "2025-12-20 09:00",
                "Zoom", "https://zoom.example/meet/100", 30);

        RegularAppointment reg = new RegularAppointment(
                "R-200", patient, doc, "2025-12-15 14:00", "Routine check");

        FollowUpAppointment follow = new FollowUpAppointment(
                "F-201", patient, doc, "2026-01-05 10:00",
                "Follow-up for test results", reg, "Review lab results");

        EmergencyAppointment emerg = new EmergencyAppointment(
                "E-300", patient, doc, "2025-12-19 08:00",
                "High", "0912-345-678 (emergency contact)");

        // 加入 manager（addAppointment 會觸發將病人摘要回傳給醫師）
        manager.addAppointment(tele);
        manager.addAppointment(reg);
        manager.addAppointment(follow);
        manager.addAppointment(emerg);

        System.out.println();
        System.out.println("=== All scheduled appointments (manager.listAll) ===");
        manager.listAll();

        System.out.println("=== Get next appointment from manager ===");
        Appointment next = manager.getNextAppointment();
        if (next != null) {
            next.displayDetails();
            // 處理看診（範例資料：診斷、處方、檢查結果）
            manager.processAppointment(next,
                    "Acute upper respiratory infection",
                    "Amoxicillin 500mg", "Take one capsule three times daily for 7 days",
                    "Oropharynx redness, mild wheeze");

            System.out.println();
            System.out.println("=== Records stored in manager ===");
            manager.listAllRecords();

            System.out.println();
            System.out.println("=== Doctor's seen patients ===");
        } else {
            System.out.println("No next appointment.");
        }
    }


}