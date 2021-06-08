package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;


import cs.miu.cs544.team2.Model.BarCodeRecord;
import cs.miu.cs544.team2.Model.Location;
import cs.miu.cs544.team2.Model.Student;
import cs.miu.cs544.team2.Model.Timeslot;
import cs.miu.cs544.team2.Repository.BarCodeRecordRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.BarCodeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BarCodeRecordServiceImpl implements BarCodeRecordService {

    @Autowired
    private BarCodeRecordRepo barCodeRecordRepo;

//    @Override
//    public void saveBarCodeRecord(Student student, Location location, Timeslot timeslot, String courseCode, String facultyName) {
//        if(null != student && null != location && null != timeslot && null != courseCode && null != facultyName){
//            barCodeRecordRepo.save(new BarCodeRecord(student.getBarcode(),timeslot, LocalDateTime.now(),location,student, LocalDate.now().getMonth().toString(),courseCode,facultyName));
//        }
//    }

    @Override
    public List<BarCodeRecord> getStudentBarCodeRecord(String studentId, String courseCode, String period) {
        if(null != studentId && null != courseCode && null != period){
            if(barCodeRecordRepo.existsByStudentIdAndCourseCodeAndPeriod(studentId,courseCode, period)){
              return barCodeRecordRepo.findByStudentIdAndCourseCodeAndPeriod(studentId,courseCode,period);
            }
        }
        return null;
    }

    @Override
    public List<BarCodeRecord> getAllStudentBarCodeRecord(String facultyName, String courseCode, String period) {
        if(null != facultyName && null != courseCode && null != period){
            if(barCodeRecordRepo.existsByFacultyNameAndCourseCodeAndPeriod(facultyName,courseCode,period)){
                return barCodeRecordRepo.findByFacultyNameAndCourseCodeAndPeriod(facultyName,courseCode,period);
            }
        }

        return null;
    }

    
	@Override
    public Object updateBarCodeRecord(String studentId, String courseCode, String period, LocalDateTime localDateTime) {
          return null;
    }

    @Override
    public List<BarCodeRecord> getStudentBarCodeRecordById(String studentId) {
        if(null != studentId){
            if(barCodeRecordRepo.existsByStudentId(studentId)) {
                barCodeRecordRepo.findAllByStudentId(studentId);
            }
        }
        return null;
    }

	@Override
	public void saveBarCodeRecord(Student student, Location location, Timeslot timeslot, String courseCode,
			String facultyName) {
		// TODO Auto-generated method stub
		
	}
}
