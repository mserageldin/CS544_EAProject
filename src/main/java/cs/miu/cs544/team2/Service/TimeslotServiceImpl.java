package cs.miu.cs544.team2.Service;


import cs.miu.cs544.team2.Model.Timeslot;
import cs.miu.cs544.team2.Repository.TimeslotRepo;
import cs.miu.cs544.team2.Service.interfaces.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeslotServiceImpl implements TimeslotService {
    @Autowired
    private TimeslotRepo timeslotRepo;


    @Override
    public void saveTimeSlot(Timeslot timeslot) {
        if(null != timeslot){
            if(!timeslotRepo.existsTimeslotByTitle(timeslot.getTitle())){
                timeslotRepo.save(timeslot);
            }
        }
    }
}
