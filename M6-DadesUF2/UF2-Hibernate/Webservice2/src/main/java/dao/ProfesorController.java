package dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/ies/professor") // This means URL's start with /ies/professor (after Application path)
public class ProfesorController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private ProfesorRepository repository;

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private ModuloRepository mrepository;


	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewProfe(@RequestParam String name, @RequestParam String ape1,
			@RequestParam String ape2) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Profesor p = new Profesor();
		p.setNombre(name);
		p.setApe1(ape1);
		p.setApe2(ape2);
		repository.save(p);

		return "Saved";
	}

    ///MAP GET requests which are followed by an id
	@GetMapping(path = "/{id}")
	public @ResponseBody Profesor getUser(@PathVariable int id) {  //the ID in the path will be an int. Note how this is different to appending request parameters
		Optional<Profesor> p = repository.findById(id); //It is returned as an optional. Optionals are java constructs that can contain null values without causing exceptions
		return p.get();  //returns the JSON representation of the Professor DataObject
	}

	@GetMapping(path = "/{id}/afegir")     ///MAP GET requests which are followed by an id, and the string "afegir"
	public @ResponseBody String afegirModul(@PathVariable int id, @RequestParam int modul) {
		Optional<Profesor> op = repository.findById(id);
		Optional<Modulo> om = mrepository.findById(modul);
		Profesor p = op.get();  //you can access optionals using get. It won't cause an exception if contains a null
		Modulo m = om.get();
		if (p.getHoresAssignades() + m.getHoresSetmana() > 19) {
			return "No es pot afegir el Modul ja que es sobrepassen les hores assignades";
			
		} else {
			p.getModulos().add(m);
			m.getProfesores().add(p);
			p.setHorasAsignadas(p.getHorasAsignadas() + m.getHorasSemana());
			System.out.println(repository);
			repository.save(p);
			mrepository.save(m);
			return "OK";
		}

	}

	@GetMapping(path = "/cognom/{cognom}")
	public @ResponseBody Iterable<Profesor> getAllUsers2(@PathVariable String cognom) {
		// This returns a JSON Array with the users (each one will be a JSON Object)
		return repository.findByApe1OrderByNombreAsc(cognom);  //notice how we only declared this function and did not define it. Contents are created reflexively
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Profesor> getAllUsers() {
		// This returns a JSON or XML with the users
		return repository.findAll();
	}
}
