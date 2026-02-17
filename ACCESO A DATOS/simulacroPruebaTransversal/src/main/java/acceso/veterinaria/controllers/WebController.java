package acceso.veterinaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.services.AnimalService;
import exceptions.AnimalNotFoundException;

@Controller
@RequestMapping("/miweb")

public class WebController {
	@Autowired
	private AnimalService animalService;

	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/crearanimal")
	@ResponseBody
	public String addAnimal(@RequestBody Animal animal) {
		return animalService.createAnimal(animal);
	}
	@PutMapping("/animal/{id}")
	public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
		Animal addedAnimal = animalService.updateAnimal(id, animal);
		return new ResponseEntity<>(addedAnimal, HttpStatus.OK);
	}

	@RequestMapping("/animales")
	public String catalog(Model model) {
		List<Animal> animales = animalService.findAllAnimals();
		model.addAttribute("animales", animales);
		return "animales	";
	}
	
    // Método para obtener un producto por ID
    @GetMapping("/animal/{id}")
    public String getAnimaltById(@PathVariable Long id, Model model) {
        Animal animal = animalService.findByIdAnimal(id);
    	model.addAttribute("detalleAnimal", animal);
        return "detalle";
    }
    
	
	@ExceptionHandler(AnimalNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(AnimalNotFoundException anfe) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, anfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	

}
