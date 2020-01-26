package applicationMain.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import applicationMain.Models.DriverDetailsModel;
import applicationMain.Repositories.DriverDetailsRepository;

@Service
public class DriverDetailsService {

    @Autowired
    private DriverDetailsRepository driverRepo;

    public String createDetails(DriverDetailsModel driverDetails){
        DriverDetailsModel detailsToDb=driverRepo.save(driverDetails);
        return "Data saved to DB";
    }
    
    public List<DriverDetailsModel> getAll() {
    	List<DriverDetailsModel> getDriver=driverRepo.findAll();
    	return getDriver;
    }
   

}
