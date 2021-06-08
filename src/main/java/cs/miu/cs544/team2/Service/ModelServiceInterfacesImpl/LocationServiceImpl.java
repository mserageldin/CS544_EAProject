package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.Location;
import cs.miu.cs544.team2.Repository.LocationRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepo locationRepo;

    @Override
    public void saveLocation(Location location) {
        if(null != location){
            if(!locationRepo.existsByBuildingAndRoomNumber(location.getBuilding(),location.getRoomNumber())){
                locationRepo.save(location);
            }
        }
    }

    @Override
    public Location getLocation(String building, String roomNumber) {
        if(null != building && null != roomNumber){
            if(locationRepo.existsByBuildingAndRoomNumber(building,roomNumber)){
                return locationRepo.findByBuildingAndRoomNumber(building, roomNumber);
            }
        }
        return null;
    }

    @Override
    public void deleteLocation(String building, String roomNumber) {
        if(null != building && null != roomNumber){
            if(locationRepo.existsByBuildingAndRoomNumber(building,roomNumber)){
                locationRepo.delete(locationRepo.findByBuildingAndRoomNumber(building,roomNumber));
            }
        }
    }

    @Override
    public boolean updateLocation(String building, String roomNumber) {
        return false;
    }
}
