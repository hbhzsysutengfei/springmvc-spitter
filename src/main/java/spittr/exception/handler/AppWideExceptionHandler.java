package spittr.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spittr.exception.DupilcateSpittleException;

@ControllerAdvice
public class AppWideExceptionHandler {
	
	@ExceptionHandler(DupilcateSpittleException.class)
	public String handleNotFound(){
		return "error/duplicate";
	}
	
	
}
