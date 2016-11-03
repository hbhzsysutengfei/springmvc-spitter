package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/", "homepage", "index" })
public class HomeController {

	public HomeController() {
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}

}
