import java.util.PriorityQueue;

class SeatManager {
    private PriorityQueue<Integer> availableSeats;

    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            availableSeats.offer(i);
        }
    }

    public int reserve() {
        if (!availableSeats.isEmpty()) {
            int seatNumber = availableSeats.poll();
            return seatNumber;
        }
        return -1; // No available seats.
    }

    public void unreserve(int seatNumber) {
        availableSeats.offer(seatNumber);
    }
}


/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */