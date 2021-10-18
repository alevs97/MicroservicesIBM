package academy.exercise.one.usermicroservice.service;

import java.util.List;


import academy.exercise.one.usermicroservice.models.Card;

public interface IUserMicroserviceService {
	
	public List<Card> listOfCardsByPassionSalaryAge(String passion, Double salary, Integer age);
}
