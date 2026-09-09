import java.util.*;

class UndergroundSystem {

    // customer ID -> check-in information
    HashMap<Integer, CheckIn> checkIns;

    // "start,end" -> [totalTime, numberOfTrips]
    HashMap<String, double[]> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {

        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "," + stationName;

        double travelTime = t - checkIn.time;

        if (!trips.containsKey(route)) {
            trips.put(route, new double[]{0, 0});
        }

        trips.get(route)[0] += travelTime;
        trips.get(route)[1]++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "," + endStation;

        double[] data = trips.get(route);

        return data[0] / data[1];
    }

    // Helper class
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}