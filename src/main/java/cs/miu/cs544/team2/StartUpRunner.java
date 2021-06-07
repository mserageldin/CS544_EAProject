package cs.miu.cs544.team2;


import cs.miu.cs544.team2.Model.Person;
import cs.miu.cs544.team2.Model.Registration;
import cs.miu.cs544.team2.Model.Generator;
import cs.miu.cs544.team2.Model.Role;
import cs.miu.cs544.team2.Model.RoleType;
import cs.miu.cs544.team2.Model.Student;
import cs.miu.cs544.team2.Model.Timeslot;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.GeneratorService;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.PersonService;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.RoleService;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.TimeslotService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class StartUpRunner implements CommandLineRunner {
    @Autowired
    private RoleService roleRepo;
    @Autowired
    private TimeslotService timeslot;
    @Autowired
    private PersonService personService;
    @Autowired
    private GeneratorService generatorService;

    @Transactional
    public void run(String... args) throws Exception {

        Role student = new Role(RoleType.STUDENT);
        Role faculty = new Role(RoleType.FACULTY);
        Role personnel = new Role(RoleType.PERSONNEL);
        Role administrator = new Role(RoleType.ADMINISTRATOR);

        Timeslot timeslot1 = new Timeslot("AM","Morning", LocalTime.of(10,00),LocalTime.of(12,30));
        Timeslot timeslot2 = new Timeslot("PM","Afternoon",LocalTime.of(14,00),LocalTime.of(16,00));
        Timeslot timeslot3 = new Timeslot("PM", "Evening",LocalTime.of(19,00), LocalTime.of(20,30));

        Generator generator = new Generator("MIU20210601","ATTMIU20210601");

        roleRepo.saveRole(student);
        roleRepo.saveRole(faculty);
        roleRepo.saveRole(personnel);
        roleRepo.saveRole(administrator);

        timeslot.saveTimeSlot(timeslot1);
        timeslot.saveTimeSlot(timeslot2);
        timeslot.saveTimeSlot(timeslot3);
        List<Role> coll=new ArrayList<Role>();
        coll.add(new Role(RoleType.STUDENT));
        Person stud=new Person( 1, "user", "$2a$10$RfGoQbp9Q5OI4LNBoXO.suQCuGxMT/dnIqgC6g35PTxf60x1TIjF6", "Moh","Serag", "email1",coll); 
        List<Role> coll1=new ArrayList<Role>();
        coll1.add(new Role(RoleType.FACULTY));
        Person admin=new Person( 2, "admin", "$2a$10$.J5fdM7YNK8UXRQIKt993.PEjR1AYjkQxKGp27vBKGQTrPi4e5I3m", "admin","admin", "email1",coll1);
        personService.savePerson(stud);
        personService.savePerson(admin);
//        insert into USERS (id, username, password, address, email, fullname, instructions, mobile) values
//        (1, 'user', '$2a$10$RfGoQbp9Q5OI4LNBoXO.suQCuGxMT/dnIqgC6g35PTxf60x1TIjF6', 'add1', 'email1', 'fullname1', 'instruction1', '323233'),
//        (2, 'admin', '$2a$10$.J5fdM7YNK8UXRQIKt993.PEjR1AYjkQxKGp27vBKGQTrPi4e5I3m', 'admin', 'admin', 'admin', 'admin', '000000');

        generatorService.save(generator);

    }
}
