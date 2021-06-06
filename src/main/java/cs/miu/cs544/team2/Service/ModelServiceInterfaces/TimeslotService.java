package cs.miu.cs544.team2.Service.ModelServiceInterfaces;


import cs.miu.cs544.team2.Model.Timeslot;

import java.time.LocalDateTime;

public interface TimeslotService {
    void saveTimeSlot(Timeslot timeslot);
    Timeslot getTimeSlot(LocalDateTime localDateTime);
}
