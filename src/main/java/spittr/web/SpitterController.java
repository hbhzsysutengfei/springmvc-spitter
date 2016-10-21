package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpitterRepository;
import spittr.model.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	@Autowired
	private SpitterRepository spitterRespository;
	
	@RequestMapping(method=RequestMethod.GET,value="/register")
	public String showRegistrationForm(Model model){
		model.addAttribute("spitter", new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors/*, Model model*/){
		if(errors.hasErrors()){
			return "registerForm";
		}
		
		spitterRespository.save(spitter);
		
		//model.addAttribute("spitter",spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable(value="username") String username, Model model ){
		Spitter spitter = spitterRespository.findbyUserName(username);
		model.addAttribute("spitter",spitter);		
		return "profile";
	}

}
