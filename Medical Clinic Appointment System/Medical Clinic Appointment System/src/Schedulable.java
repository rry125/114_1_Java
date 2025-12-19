import java.time.LocalDate;
import java.util.ArrayList;

public interface Schedulable {
    ArrayList<TimeSlot> getAvailableSlots(LocalDate date);
    boolean bookSlot(TimeSlot slot);
    boolean cancelSlot(TimeSlot slot);
}

