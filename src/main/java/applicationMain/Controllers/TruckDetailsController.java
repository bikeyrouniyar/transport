package applicationMain.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import applicationMain.Models.TruckDetailsModel;
import applicationMain.Services.TruckDetailsService;

@RestController
@RequestMapping("/truck")
public class TruckDetailsController {

	@Autowired
	private TruckDetailsService truckService;
	
	@PostMapping("/create")
	public ResponseEntity<?> newDate(@Valid @RequestBody TruckDetailsModel truck){
		String createNew=truckService.createTruckDetails(truck);
		return new ResponseEntity<String>(createNew,HttpStatus.CREATED);
		}
	
	@GetMapping
	public ResponseEntity<?> getall(){
		List<TruckDetailsModel> getTruck=truckService.getall();
		return new ResponseEntity<List<TruckDetailsModel>>(getTruck,HttpStatus.OK);
	}
	
	
}
