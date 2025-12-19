public class TelemedicineAppointment extends Appointment {
    private String platform;
    private String meetingLink;
    private int durationMinutes;

    public TelemedicineAppointment(String id, Patient patient, Doctor doctor, String dateTime,
                                   String platform, String meetingLink, int durationMinutes) {
        super(id, patient, doctor, dateTime);
        this.platform = platform;
        this.meetingLink = meetingLink;
        this.durationMinutes = durationMinutes;
    }

    public String getPlatform() {
        return platform;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Telemedicine Appointment]");
        System.out.println("Appointment ID: " + id);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "(none)"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "(none)"));
        System.out.println("Platform: " + platform);
        System.out.println("Meeting Link: " + meetingLink);
        System.out.println("Duration (minutes): " + durationMinutes);
    }
}
