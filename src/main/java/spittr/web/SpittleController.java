package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static final String MAX_LONG_AS_STRING =  "9223372036854775807";
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public String spittles(
			@RequestParam(value="max", defaultValue=SpittleController.MAX_LONG_AS_STRING) long max,
			@RequestParam(value="count", defaultValue="20") int count
			,Model model){		
		model.addAttribute("spittleList", spittleRepository.findSpitters(max, count));
		return "spittles";
	}
	
//	@RequestMapping(value="/show", method = RequestMethod.GET)
//	public String showSpittle(@RequestParam(value="spittleId") long spittleId,
//			Model model){
//		model.addAttribute("spittle",spittleRepository.findOne(spittleId));
//		return "spittle";
//	}
	
	@RequestMapping(value="{spittleId}", method=RequestMethod.GET)
	public String showSpittle(@PathVariable(value="spittleId") long spittleId, Model model){
		model.addAttribute("spittle", spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	

}
