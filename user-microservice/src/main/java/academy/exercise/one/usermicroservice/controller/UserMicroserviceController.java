package academy.exercise.one.usermicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import academy.exercise.one.usermicroservice.models.Card;
import academy.exercise.one.usermicroservice.models.ErrorResponse;
import academy.exercise.one.usermicroservice.service.UserMicroserviceServiceImpl;

@RestController
public class UserMicroserviceController {
	
	@Autowired
	private UserMicroserviceServiceImpl service;
	
	@Autowired
	private ErrorResponse badrequest;
	
	@GetMapping("/passion/{passion}/salary/{salary}/age/{age}")
	public ResponseEntity<?> getPassionSalaryAgeAdmin(
			@PathVariable String passion,
			@PathVariable Double salary,
			@PathVariable Integer age){
		List<Card> cards = service.listOfCardsByPassionSalaryAge(passion,salary,age);
		if(cards == null) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body(badrequest.setMessage(
							age.toString(),
							"Available ages (18 - 75) - Check your input",
							"Error in service - listOfCardsByAge"));
		}
		return ResponseEntity.ok(cards);
	}
}
