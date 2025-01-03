import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private final TextUI ui;

    protected ArrayList<Room> availebleRooms;
    protected ArrayList<Booking> specificBookings;
    protected ArrayList<Booking> allBookings;

    public BookingSystem(){
        this.ui = new TextUI();
    }

    public boolean isAvailable(Room room, LocalDate date){
        specificBookings = io.loadBookingsForSpeceficRoom(room.getRoomNumber());
        for (Booking booking : specificBookings){
            if(date.getDayOfMonth() == booking.getDay() && date.getMonthValue() == booking.getMonth() && date.getYear() == booking.getYear() && room.getRoomNumber() == booking.getRoomNumber()){
                ui.displayMsg("Lokale: " + room.getRoomNumber() + ".er reserverede på dags dato: " + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + ".");
                return false;
            }
        }
        ui.displayMsg("Lokale: " + room.getRoomNumber() + ".er ledigt på dags dato: " + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + ".");
        return true;
    }

    public List<Room> findAvailable(int capacity, LocalDate date){
        allBookings = io.loadAllBookings();
        availebleRooms = io.loadAllRooms();
        for (Room room : availebleRooms){
            availebleRooms.removeIf(thisRoom -> thisRoom.getCapacity() < capacity);
        }
        for (Booking booking : allBookings){
            if(date.getDayOfMonth() == booking.getDay() && date.getMonthValue() == booking.getMonth() && date.getYear() == booking.getYear()){
                for (Room room : availebleRooms) {
                    availebleRooms.removeIf(thisRoom -> thisRoom.getRoomNumber() == booking.getRoomNumber());
                }
            }
        }
        ui.displayMsg("Lokaler som ikke er reserverede på dags dato: " + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + ". Med plads til mindst: " + capacity + ".");
        ui.displayAvailableRooms(availebleRooms);
        return availebleRooms;
    }

    public Booking book(Room room, LocalDate date, User user){
        boolean bookable = isAvailable(room, date);
        //try {
            if (bookable) {
                Booking booking = new Booking(room.getRoomNumber(), room.getCapacity(), date.getDayOfMonth(), date.getMonthValue(), date.getYear(), user.getUsername(), user.getPassword());
                ui.displayMsg("Lokale " + room.getRoomNumber() + ". er nu reserveret til " + user.getUsername() + " på datoen: " +  date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + ".");
                return booking;
            } else if (!bookable){
                ui.displayMsg("Lokale " + room.getRoomNumber() + ". er ikke ledigt på datoen: " +  date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + ".");
                return null;
            }
        ui.displayMsg("noget gik galt under bookingen");
        return null;
    }

    public void cancel(Booking specificBooking){
        allBookings = io.loadAllBookings();
        for (Booking booking : allBookings) {
            allBookings.removeIf(thisBooking -> thisBooking.getRoomNumber() == specificBooking.getRoomNumber() && thisBooking.getDay() == specificBooking.getDay() && thisBooking.getMonth() == specificBooking.getMonth() && thisBooking.getYear() == specificBooking.getYear() && thisBooking.getPassword().equals(specificBooking.getPassword()));
            ui.displayMsg("Din reservation");
        }
    }



}
