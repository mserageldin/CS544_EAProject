package cs.miu.cs544.team2.Service.UCServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.AttendanceReport;
import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Model.CourseOffering;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.BarCodeRecordServiceImpl;
import cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl.FacultyServiceImpl;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UCFacultyServiceImpl implements UCFacultyService {

    @Autowired
    private BarCodeRecordServiceImpl barCodeRecordService;
    @Autowired
    private FacultyServiceImpl facultyService;

    @Override
    public List<AttendanceReport> getAllStudentBarCodeRecord(String facultyName, String courseCode, String period) {
        List<BarCodeRecord> barCodeRecordList = barCodeRecordService.getAllStudentBarCodeRecord(facultyName,courseCode,period);
        List<AttendanceReport> attendanceReportList = new ArrayList<>();
        Set<String> studentId;
        studentId = barCodeRecordList.stream().map(barCodeRecord -> barCodeRecord.getStudent().getStudentId()).distinct().collect(Collectors.toSet());
        for(String b: studentId){
            int count=0;
            BarCodeRecord record = null;
            for (BarCodeRecord c: barCodeRecordList){
                if(c.getStudent().getStudentId().equalsIgnoreCase(b)){
                    record = c;
                    count++;
                }
            }
            if(null != record){
                attendanceReportList.add(new AttendanceReport(record.getStudent().getFirstName(), record.getStudent().getLastName(),record.getStudent().getStudentId(), courseCode, count));
            }
        }
        return attendanceReportList;
    }

    @Override
    public List<CourseOffering> getLast6Courses(String emailAddress) {
        List<CourseOffering> courseOfferings = facultyService.getFaculty(emailAddress).getOffering();
        List<CourseOffering> courseOfferingList = new ArrayList<>();
        if(courseOfferings.size() > 6){
            for(int i=courseOfferings.size()-1; i>=(courseOfferings.size()-6);i--){
                courseOfferingList.add(courseOfferings.get(i));
            }
            return courseOfferingList;
        }
        return courseOfferings;
    }
}
