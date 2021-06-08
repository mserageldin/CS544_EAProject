package cs.miu.cs544.team2.Service.ModelServiceInterfaces;

import cs.miu.cs544.team2.Model.Personnel;

public interface PersonnelService {
    void savePersonnel(Personnel personnel);
    Personnel getPersonnel(String email);
    void deletePersonnel(String email);
    boolean updatePersonnel(Personnel personnel);
}
