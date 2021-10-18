package academy.exercise.one.adminmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.exercise.one.adminmicroservice.entity.DescriptionCreditCard;
import academy.exercise.one.adminmicroservice.models.ErrorResponse;
import academy.exercise.one.adminmicroservice.service.AdminMicroserviceServiceImpl;



@RestController
public class AdminMicroserviceController {
	
	
	@Autowired
	private AdminMicroserviceServiceImpl service;
	
	@Autowired
	private ErrorResponse badrequest;
	
	@RequestMapping(value="/passion/{passion}")
	public ResponseEntity<?> getListPassions(
			@PathVariable String passion){
		List<DescriptionCreditCard> cards = service.listOfCardsByPassion(passion.toLowerCase());
		if(cards == null) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body(badrequest.setMessage(
							passion,
							"Passion Not Available - Check your input",
							"Error in service - listOfCardsByPassion"));
		}
		return ResponseEntity.ok(cards);
	}
	
	@RequestMapping(value="/salary/{salary}")
	public ResponseEntity<?> getListSalaries(
			@PathVariable Double salary){
		List<DescriptionCreditCard> cards = service.listOfCardsBySalary(salary);
		if(cards == null) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body(badrequest.setMessage(
							salary.toString(),
							"Salary under the range of 7,000 - Check your input",
							"Error in service - listOfCardsBySalary"));
		}
		return ResponseEntity.ok(cards);
	}
	
	@RequestMapping(value="/age/{age}")
	public ResponseEntity<?> getListAge(
			@PathVariable Integer age){
		List<DescriptionCreditCard> cards = service.listOfCardsByAge(age);
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
	
	@RequestMapping(value="/passion/{passion}/salary/{salary}/age/{age}")
	public ResponseEntity<?> getPassionSalaryAgeAdmin(
			@PathVariable String passion,
			@PathVariable Double salary,
			@PathVariable Integer age){
		DescriptionCreditCard card = service.listOfCardsByPassionSalaryAge(passion.toLowerCase(),salary,age);
		if(card == null) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body(badrequest.setMessage(
							"Passion ->" +passion +"|  Salary ->"+salary.toString()+"|  Age ->"+age.toString(),
							"Available ages (18 - 75), Salary under the range of 7,000 or Passion Not Available - Check your inputs",
							"Error in service - listOfCardsByPassionSalaryAge"));
		}
		return ResponseEntity.ok(card);
	}
	
}
