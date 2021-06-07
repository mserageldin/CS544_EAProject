package cs.miu.cs544.team2.Service.UCServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.AttendanceReport;
import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.BarCodeRecordService;
import cs.miu.cs544.team2.Service.UCServiceInterfaces.UCPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UCPersonnelServiceImpl implements UCPersonnelService {

    @Autowired
    private BarCodeRecordService barCodeRecordService;


    @Override
    public List<AttendanceReport> getAllTimeAttendanceOfAStudent(String studentId) {
        List<BarCodeRecord> barCodeRecordList = barCodeRecordService.getStudentBarCodeRecordById(studentId);
        List<AttendanceReport> attendanceReportList = new ArrayList<>();
        Set<String> courseCode;
        courseCode = barCodeRecordList.stream().map(BarCodeRecord::getCourseCode).collect(Collectors.toSet());
        for(String k: courseCode){
            int count=0;
            BarCodeRecord record = null;
            for (BarCodeRecord c: barCodeRecordList){
                if(c.getCourseCode().equalsIgnoreCase(k)){
                    record = c;
                    count++;
                }
            }
            if(null != record){
                attendanceReportList.add(new AttendanceReport(record.getStudent().getFirstName(), record.getStudent().getLastName(),record.getStudent().getStudentId(), k, count));
            }
        }
        return attendanceReportList;
    }

}
