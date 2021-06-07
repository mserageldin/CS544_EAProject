package cs.miu.cs544.team2.Service.ModelServiceInterfaces;

import cs.miu.cs544.team2.Model.Administrator;

public interface AdministratorService {
    void saveAdministrator(Administrator administrator);
    Administrator getAdministrator(String email);
    void deleteAdministrator(String email);
    boolean updateAdministrator(Administrator faculty);
}
