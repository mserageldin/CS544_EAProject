package cs.miu.cs544.team2.Service.ModelServiceInterfacesImpl;

import cs.miu.cs544.team2.Model.Generator;
import cs.miu.cs544.team2.Repository.GeneratorRepo;
import cs.miu.cs544.team2.Service.ModelServiceInterfaces.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private GeneratorRepo generatorRepo;

    @Override
    public void save(Generator generator) {
        if(null != generator){
            if(!generatorRepo.existsById(1)){
                generatorRepo.save(generator);
            }
        }
    }


    @Override
    public Generator getGenerator() {
        return generatorRepo.findAll().get(0);
    }

    @Override
    public Generator updateGenerator() {
        Generator a = getGenerator();
        String studentIdLetters = a.getStudentId().substring(0,3);
        int studentIdNumbers = Integer.parseInt(a.getStudentId().substring(3));
        studentIdNumbers += 1;
        String newStudentId = studentIdLetters + studentIdNumbers;

        String studentBarCodeLetters = a.getBarCode().substring(0,6);
        int studentBarCodeNumbers = Integer.parseInt(a.getBarCode().substring(6));
        studentBarCodeNumbers += 1;
        String newBarCode = studentBarCodeLetters + studentBarCodeNumbers;


        deleteGenerator(a);
        save(new Generator(newStudentId,newBarCode));
        return new Generator(newStudentId,newBarCode);
    }

    @Override
    public void deleteGenerator(Generator generator) {
        if(null != generator){
            generatorRepo.delete(generator);
        }
    }
}
