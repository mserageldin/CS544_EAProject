package cs.miu.cs544.team2.Service.interfaces;


import cs.miu.cs544.team2.Model.Location;

public interface LocationService {
    void saveLocation(Location location);
    Location getLocation(String building, String roomNumber);
    void deleteLocation(String building, String roomNumber);
    boolean updateLocation(String building, String roomNumber);
}
