package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.Timeslot;
import cs.miu.cs544.team2.Repository.TimeslotRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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


    @Override
    public Timeslot getTimeSlot(LocalDateTime timeslot) {
        List<Timeslot> timeslotList = timeslotRepo.findAll();
        int hr = timeslot.getHour();
        int min = timeslot.getMinute();
        for(Timeslot a: timeslotList){
            if(hr>=a.getStartTime().getHour() && hr<=a.getEndTime().getHour()){
                if(hr==a.getEndTime().getHour()){
                    if(min <= a.getEndTime().getMinute()){
                        return null;
                    }else return a;
                }else return a;
            }
        }
        return null;
    }
}
