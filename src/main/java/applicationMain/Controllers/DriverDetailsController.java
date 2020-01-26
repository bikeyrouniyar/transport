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

import applicationMain.Models.DriverDetailsModel;
import applicationMain.Services.DriverDetailsService;

@RestController
@RequestMapping("/driver")
public class DriverDetailsController {

	@Autowired
	private DriverDetailsService driverService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody DriverDetailsModel details){
		String createNew=driverService.createDetails(details);
		return new ResponseEntity<String>(createNew,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall(){
		List<DriverDetailsModel> getDriver=driverService.getAll();
		return new ResponseEntity<List<DriverDetailsModel>>(getDriver,HttpStatus.OK);
	}

}
