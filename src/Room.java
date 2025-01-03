public class Room {
    protected int capacity;
    protected int roomNumber;

    public Room(int roomNumber, int capacity) {
        this.capacity = capacity;
        this.roomNumber = roomNumber;
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

    @Override
    public String toString() {
        return "RoomNumber: " + roomNumber + "Capacity: " + capacity + '.';
    }
}
