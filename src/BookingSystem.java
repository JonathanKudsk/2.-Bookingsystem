import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private final TextUI ui;

    protected ArrayList<Room> availebleRooms;
    protected ArrayList<Booking> allBookings;

    public BookingSystem(){
        this.ui = new TextUI();
    }

    public boolean isAvailable(ArrayList<Room> allRooms, LocalDate todaysDate){
        for (Booking booking : allBookings){
            if(todaysDate.getDayOfMonth() == booking.getDay() && todaysDate.getMonthValue() == booking.getMonth() && todaysDate.getYear() == booking.getYear()){
               allRooms.removeIf(room -> room.getRoomNumber() == booking.getRoomNumber());
            }
        }
        ui.displayMsg("Lokaler som ikke er reserverede på dags dato: " + todaysDate.getDayOfMonth() + "-" + todaysDate.getMonthValue() + "-" + todaysDate.getYear() + ".");
        for (Room room : allRooms) {
            ui.displayMsg(room.toString());
        }
    }

    public List<Room> findAvailable(int capacity, LocalDate todaysDate){
        availebleRooms = io.loadAllRooms();
        for (Room room : availebleRooms){
            availebleRooms.removeIf(thisRoom -> thisRoom.getCapacity() < capacity);
        }
        for (Booking booking : allBookings){
            if(todaysDate.getDayOfMonth() == booking.getDay() && todaysDate.getMonthValue() == booking.getMonth() && todaysDate.getYear() == booking.getYear() && capacity >= booking.getCapacity()){
                availebleRooms.removeIf(room -> room.getRoomNumber() == booking.getRoomNumber());
            }
        }
        ui.displayMsg("Lokaler som ikke er reserverede på dags dato: " + todaysDate.getDayOfMonth() + "-" + todaysDate.getMonthValue() + "-" + todaysDate.getYear() + ".");
        for (Room room : availebleRooms) {
            ui.displayMsg(room.toString());
        }
    }

}
