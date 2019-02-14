// This problem was asked by Snapchat.

// Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), 
// find the minimum number of rooms required.

// For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
import java.util.*;
final class Interval {
    private final int start;
    private final int end;
    private Interval(int start, int end){
        this.start = start;
        this.end = end;
    };
    public static Interval valueOf(int start, int end){
        return new Interval(start, end);
    }
    public int get_start(){
        return this.start;
    }
    public int get_end(){
        return this.end;
    }
    @Override
    public String toString(){
        return "("+start+","+end+")";
    }
}

public class App {

    public static boolean hasOverlap(Interval a, Interval b){
        int a_start = a.get_start();
        int a_end = a.get_end();
        int b_start = b.get_start();
        int b_end = b.get_end();

        if (b_start > a_start && b_start < a_end){
            return true;
        }
        if (b_end > a_start && b_end < a_end){
            return true;
        }
        return false;
    }
    // Converts a string into an arraylist of Intervals
    public static ArrayList<Interval> identify_intervals(String intervals){
        String new_intervals = intervals.replaceAll("\\[\\(","");
        new_intervals = new_intervals.replaceAll("\\)\\]","");
        String[] formattedIntervals = new_intervals.split("\\), \\(");
        
        ArrayList<Interval> all_intervals = new ArrayList<Interval>();
        for (String item: formattedIntervals){
            String[] item_values = item.split(", ");
            Interval interval_instance = Interval.valueOf(Integer.valueOf(item_values[0]), Integer.valueOf(item_values[1]));
            all_intervals.add(interval_instance);
        }
        return all_intervals;
    }

    public static void print_interval (ArrayList<Interval> list){
        for (Interval interval: list){
            System.out.println(interval.toString());
        }
    }
    // Finds the minimum number of rooms from given intervals
    public static int min_no_rooms(String intervals){
        int total_rooms = 0;
        ArrayList<Interval> not_visited = identify_intervals(intervals);
        while (!not_visited.isEmpty()){
            ArrayList<Interval> spare_room = new ArrayList<Interval>();
            for (int i = 0; i < not_visited.size();){
                Interval instance = not_visited.get(i);
                boolean overlapping = false;
                for (int j = 0; j < spare_room.size(); j++){
                    if (hasOverlap(spare_room.get(j), instance)){
                        overlapping = true;
                        break;
                    }
                }
                if (overlapping == false){
                    spare_room.add(instance);
                    not_visited.remove(i);
                } else {
                    i++;
                }
            }
            total_rooms += 1;
        }
        return total_rooms;

    }

    public static void main(String[] args) {
        System.out.println("Starting ...");
        System.out.println(min_no_rooms("[(30, 75), (0, 50), (60, 150)]"));
        // System.out.println(min_no_rooms("[(30, 75), (0, 50), (50, 60), (60, 150)]"));
    }
}