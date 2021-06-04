package cs.miu.cs544.team2;


import cs.miu.cs544.team2.Model.Role;
import cs.miu.cs544.team2.Model.RoleType;
import cs.miu.cs544.team2.Model.Timeslot;
import cs.miu.cs544.team2.Service.interfaces.RoleService;
import cs.miu.cs544.team2.Service.interfaces.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalTime;

@Component
public class StartUpRunner implements CommandLineRunner {
    @Autowired
    private RoleService roleRepo;
    @Autowired
    private TimeslotService timeslot;


    @Transactional
    public void run(String... args) throws Exception {

        Role student = new Role(RoleType.STUDENT);
        Role faculty = new Role(RoleType.FACULTY);
        Role personnel = new Role(RoleType.PERSONNEL);
        Role administrator = new Role(RoleType.ADMINISTRATOR);
        Timeslot timeslot1 = new Timeslot("AM","Morning", LocalTime.of(10,00),LocalTime.of(12,30));
        Timeslot timeslot2 = new Timeslot("PM","Afternoon",LocalTime.of(14,00),LocalTime.of(16,00));
        Timeslot timeslot3 = new Timeslot("PM", "Evening",LocalTime.of(19,00), LocalTime.of(20,30));

        roleRepo.saveRole(student);
        roleRepo.saveRole(faculty);
        roleRepo.saveRole(personnel);
        roleRepo.saveRole(administrator);

        timeslot.saveTimeSlot(timeslot1);
        timeslot.saveTimeSlot(timeslot2);
        timeslot.saveTimeSlot(timeslot3);

    }
}
