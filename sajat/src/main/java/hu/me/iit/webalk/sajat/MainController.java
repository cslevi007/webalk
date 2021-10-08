package hu.me.iit.webalk.sajat;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "bicycle")
public class MainController {
	private final BicycleService bicycleService;

	public MainController(BicycleService bicycleService) {
		super();
		this.bicycleService = bicycleService;
	}
	
	@GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<BicycleDto> allBicycles(){
		return bicycleService.findAll();
	}
	
	@PostMapping(path = "")
	public void newBicycle(@RequestBody @Valid BicycleDto bicycleDto) {
		bicycleService.save(bicycleDto);
	}
	
	@PutMapping(path = "")
	public void replaceBicycle(@RequestBody @Valid BicycleDto bicycleDto) {
		bicycleService.save( bicycleDto);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteArticle(@PathVariable Long id) {
		bicycleService.deleteById(id);
	}
}
