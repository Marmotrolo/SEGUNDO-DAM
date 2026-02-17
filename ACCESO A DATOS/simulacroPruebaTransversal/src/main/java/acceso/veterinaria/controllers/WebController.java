package acceso.veterinaria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;
import acceso.veterinaria.services.AnimalesServices;
import exceptions.AnimalNotFoundException;

@Controller
@RequestMapping("/miweb")

public class WebController {
	@Autowired
	private AnimalesServices animalService;

	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/crearanimal")
	@ResponseBody
	public String addAnimal(@RequestBody Animal animal) {
		return animalService.createAnimal(animal);
	}
	
	@PostMapping("/agregarvacunaaanimal/{idAnimal}")
	@ResponseBody
	public Map<String, Object>  agregarvacunaaanimal ( @PathVariable Long idAnimal,@RequestBody Vacuna vacuna){
		Map<String, Object> respuesta= new HashMap<>();
		if(animalService.agregarvacunaaanimal(idAnimal, vacuna)!=null) {
		 respuesta.put("exito", true);
		    respuesta.put("mensaje", "Datos cargados correctamente");
		    respuesta.put("codigo", 200);
}
		return respuesta;
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
		return "animales";
	}
	
    // Método para obtener un producto por ID
    @GetMapping("/animal/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        Animal animal = animalService.findByIdAnimal(id);
        System.out.println(animal.getNombre());
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
