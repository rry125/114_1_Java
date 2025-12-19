public interface Notifiable {
    void sendReminder(Appointment appointment);
    void sendNotification(String message);
    ContactMethod getPreferredContactMethod();
}

