package cs.miu.cs544.team2.Service.interfaces;


import cs.miu.cs544.team2.Model.Faculty;

public interface FacultyService {
    void saveFaculty(Faculty faculty);
    Faculty getFaculty(String email);
    void deleteFaculty(String email);
    boolean updateFaculty(Faculty faculty);
}
