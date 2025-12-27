// TC: O(m log m) sorting + heap push/pop O(m log n)
// SC: O(m + n) for  hashmap and 3 PQ
import java.util.*;

class Pair implements Comparable<Pair> {
    int endTime;
    int room;

    Pair(int endTime, int room) {
        this.endTime = endTime;
        this.room = room;
    }

    public int compareTo(Pair other) {
        if (this.endTime != other.endTime) {
            return this.endTime - other.endTime;
        }
        return this.room - other.room;
    }
}

class Solution {

    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;
        PriorityQueue<Pair> busyRooms = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) 
        availableRoom.offer(i);

        for (int i = 0; i < m; i++) 
        {
            int[] meeting = meetings[i];
            int startTime = meeting[0];
            int endTime = meeting[1];

            // we gotta release room that are free and put them into available PQ from busyRoom PQ
            while(!busyRooms.isEmpty() && busyRooms.peek().endTime <= startTime)
            {
                availableRoom.offer(busyRooms.poll().room);
            }
            if (!availableRoom.isEmpty()) 
            {
                int roomNo = availableRoom.poll();
                map.put(roomNo, map.getOrDefault(roomNo, 0) + 1);
                busyRooms.offer(new Pair(endTime, roomNo));
            }
            else 
            {
                // delayed meeting
                int duration = endTime - startTime;

                Pair busyRoom = busyRooms.poll();
                int meetingFinishTime = busyRoom.endTime;

                map.put(busyRoom.room, map.getOrDefault(busyRoom.room, 0) + 1);
                busyRooms.offer(new Pair(meetingFinishTime + duration, busyRoom.room));
            }
        }

        // return the count of room having larger meetng held.
        int maxCount = 0;
        int resRoom = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int room = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && room < resRoom)) {
                maxCount = count;
                resRoom = room;
            }
        }
        return resRoom;
    }
}
