package spittr.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;
import spittr.exception.DuplicateSpittleException;
import spittr.exception.SpittleNotFoundException;
import spittr.model.Spittle;
import spittr.model.SpittleForm;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(@RequestParam(value = "max", defaultValue = SpittleController.MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count, Model model) {
		model.addAttribute("spittleList", spittleRepository.findSpitters(max, count));
		return "spittles";
	}

	// @RequestMapping(value="/show", method = RequestMethod.GET)
	// public String showSpittle(@RequestParam(value="spittleId") long
	// spittleId,
	// Model model){
	// model.addAttribute("spittle",spittleRepository.findOne(spittleId));
	// return "spittle";
	// }

	@RequestMapping(value = "{spittleId}", method = RequestMethod.GET)
	public String showSpittle(@PathVariable(value = "spittleId") long spittleId, Model model) {
		Spittle spittle =  spittleRepository.findOne(spittleId);
		if(spittle == null){
			throw new SpittleNotFoundException();
		}
		model.addAttribute("spittle",spittle );
		return "spittle";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveSpittle(SpittleForm spittleForm, Model model) throws DuplicateSpittleException{
		spittleRepository.save(new Spittle(null, spittleForm.getMessage(),new Date(), spittleForm.getLongitude(), spittleForm.getLongitude()));
		return "redirect:/spittles";		
	}
	
	
	

}
