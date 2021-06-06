package cs.miu.cs544.team2.Service.ModelServiceInterfaces;

import cs.miu.cs544.team2.Model.Generator;

public interface GeneratorService {
    void save(Generator generator);
    Generator getGenerator();
    void updateGenerator();
    void deleteGenerator(Generator generator);
}
