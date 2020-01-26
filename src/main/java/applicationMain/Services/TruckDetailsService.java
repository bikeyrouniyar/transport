package applicationMain.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import applicationMain.Models.TruckDetailsModel;
import applicationMain.Repositories.TruckDetailsRepository;

@Service
public class TruckDetailsService {

	@Autowired
	private TruckDetailsRepository truckRepo;
	
	public String createTruckDetails(TruckDetailsModel details) {
		TruckDetailsModel toDb=truckRepo.save(details);
		return "Details Saved to DB";
		}
	
	public List<TruckDetailsModel> getall() {
		List<TruckDetailsModel> getTruck=truckRepo.findAll();
		return getTruck;
	}

}
