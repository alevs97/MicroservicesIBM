package academy.exercise.one.adminmicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academy.exercise.one.adminmicroservice.entity.DescriptionCreditCard;

@Service
public interface IAdminMicroserviceService {
	
	public List<DescriptionCreditCard> listOfCardsByPassion(String passion);
	
	public List<DescriptionCreditCard> listOfCardsBySalary(Double salary);
	
	public List<DescriptionCreditCard> listOfCardsByAge(Integer age);
	
	public DescriptionCreditCard listOfCardsByPassionSalaryAge(String passion,Double salary,Integer age);
}
