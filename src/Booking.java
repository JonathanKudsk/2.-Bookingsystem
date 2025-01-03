public class Booking {
    protected int capacity;
    protected int roomNumber;
    protected int day;
    protected int month;
    protected int year;
    protected String username;
    protected String password;

    public Booking(int roomNumber, int capacity, int day, int month, int year, String username, String password) {
        this.capacity = capacity;
        this.roomNumber = roomNumber;
        this.day = day;
        this.month = month;
        this.year = year;
        this.username = username;
        this.password = password;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
