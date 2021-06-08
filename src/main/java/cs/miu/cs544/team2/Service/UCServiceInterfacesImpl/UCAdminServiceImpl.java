package cs.miu.cs544.team2.Service.UCServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.*;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.*;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class UCAdminServiceImpl implements UCAdminService {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseOfferingService courseOfferingService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private TimeslotService timeslotService;
    @Autowired
    private GeneratorService generatorService;


    @Override
    public void addCourse(String courseCode, String abbreviation, String name, String description) {
        courseService.saveCourse(new Course(courseCode,abbreviation,name,description));
    }

    @Override
    public void dropCourse(String courseCode) {
        courseService.deleteCourse(courseCode);
    }

    @Override
    public void addCourseOffering(String courseCode, int month, int year, int capacity, String buildingName, String roomNumber) {
        LocalDate start = LocalDate.of(year,month,01);
        LocalDate end = LocalDate.of(year,month, 28);
        String period = start.getMonth().toString();
        Course course = courseService.getCourse(courseCode);
        Location location = locationService.getLocation(buildingName,roomNumber);

        courseOfferingService.saveCourseOffering(new CourseOffering(course,period,start,end,capacity,location));
    }

    @Override
    public void dropCourseOffering(String period, String courseCode) {
        courseOfferingService.deleteCourseOffering(courseService.getCourse(courseCode),period);
    }

    @Override
    public void registerStudent(String firstName, String lastName, String email, String visaStatus, String status, String track, LocalDate entryDate) {
        Role a = roleService.getRole("Student");
        String studentId = generatorService.updateGenerator().getStudentId();
        String studentBarCode = generatorService.updateGenerator().getBarCode();
        Student student = new Student(firstName,lastName,email,studentId,visaStatus,status,track,entryDate,studentBarCode);
        student.addRole(a);
        studentService.saveStudent(student);
    }

    @Override
    public void dropStudent(String studentId) {
        studentService.deleteStudent(studentId);
    }

    @Override
    public void addFaculty(String firstName, String lastName, String email, String title) {
        Role a = roleService.getRole("Faculty");
        Faculty faculty = new Faculty(firstName,lastName,email,title);
        faculty.addRole(a);
        facultyService.saveFaculty(faculty);
    }

    @Override
    public void dropFaculty(String email) {
        facultyService.deleteFaculty(email);
    }

    @Override
    public void addPersonnel(String firstName, String lastName, String email, String title) {
        Role a = roleService.getRole("Personnel");
        Personnel personnel = new Personnel(firstName,lastName,email,title);
        personnel.addRole(a);
        personnelService.savePersonnel(personnel);
    }

    @Override
    public void dropPersonnel(String email) {
        personnelService.deletePersonnel(email);
    }

    @Override
    public void addAdministrator(String firstName, String lastName, String email, String title) {
        Role a = roleService.getRole("Administrator");
        Administrator administrator = new Administrator(firstName,lastName,email,title);
        administrator.addRole(a);
        administratorService.saveAdministrator(administrator);
    }

    @Override
    public void dropAdministrator(String email) {
        administratorService.deleteAdministrator(email);
    }

    @Override
    public void addRole(String email, String role) {
        Student student = studentService.getStudentByEmail(email);
        Faculty faculty = facultyService.getFaculty(email);
        Personnel personnel = personnelService.getPersonnel(email);
        Administrator administrator = administratorService.getAdministrator(email);
        Role a = roleService.getRole(role);
        if(null != student){
            if (!student.getRoles().contains(a)) student.addRole(a);
        }else if (null != faculty){
            if (!faculty.getRoles().contains(a)) faculty.addRole(a);
        }else if (null != personnel){
            if (!personnel.getRoles().contains(a)) personnel.addRole(a);
        }else if (null != administrator){
            if (!administrator.getRoles().contains(a)) administrator.addRole(a);
        }
    }

    @Override
    public void dropRole(String email, String role) {
        Student student = studentService.getStudentByEmail(email);
        Faculty faculty = facultyService.getFaculty(email);
        Personnel personnel = personnelService.getPersonnel(email);
        Administrator administrator = administratorService.getAdministrator(email);
        Role a = roleService.getRole(role);
        if(null != student){
            if (student.getRoles().contains(a)) student.deleteRole(a);
        }else if (null != faculty){
            if (faculty.getRoles().contains(a)) faculty.deleteRole(a);
        }else if (null != personnel){
            if (personnel.getRoles().contains(a)) personnel.deleteRole(a);
        }else if (null != administrator){
            if (administrator.getRoles().contains(a)) administrator.deleteRole(a);
        }

    }

    @Override
    public void addLocation(String name, String building, String roomNumber, int capacity) {
        locationService.saveLocation(new Location(name,building,roomNumber,capacity));
    }

    @Override
    public void dropLocation(String building, String roomNumber) {
        locationService.deleteLocation(building,roomNumber);
    }

    @Override
    public void addTimeSlot(String code, String title, LocalTime startTime, LocalTime endTime) {
        timeslotService.saveTimeSlot(new Timeslot(code,title,startTime,endTime));
    }
}
