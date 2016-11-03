package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import spittr.data.SpitterRepository;
import spittr.model.Spitter;
import spittr.model.SpitterForm;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRespository;

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRespository = spitterRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("spitter", new Spitter());
		return "registerForm";
	}

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	// public String processRegistration(
	// @RequestPart("profilePicture") MultipartFile profilePicture,
	// @Valid Spitter spitter,
	// Errors errors/* , Model model */) throws IllegalStateException,
	// IOException {
	// if (errors.hasErrors()) {
	// return "registerForm";
	// }
	//
	// profilePicture.transferTo(new
	// File("/spittr/images/"+profilePicture.getOriginalFilename()));
	//
	// spitterRespository.save(spitter);
	//
	// // model.addAttribute("spitter",spitter);
	// return "redirect:/spitter/" + spitter.getUsername();
	// }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid SpitterForm spitterForm, Errors errors, Model model)
			throws IllegalStateException, IOException {

		if (errors.hasErrors()) {
			return "registerForm";
		}

		Spitter spitter = spitterForm.toSpitter();
		this.spitterRespository.save(spitter);
		MultipartFile profilePicture = spitterForm.getProfilePicture();
		profilePicture.transferTo(new File("/tmp/spitter/" + spitter.getUsername() + ".jpg"));

		model.addAttribute("username", spitter.getUsername());
		
		return "redirect:/spitter/{username}";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable(value = "username") String username, Model model) {
		Spitter spitter = spitterRespository.findbyUserName(username);
		model.addAttribute("spitter", spitter);
		return "profile";
	}

}
