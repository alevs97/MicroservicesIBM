package academy.exercise.one.adminmicroservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.exercise.one.adminmicroservice.entity.DescriptionCreditCard;
import academy.exercise.one.adminmicroservice.repository.DescriptionCreditCardDao;


@Service
public class AdminMicroserviceServiceImpl implements IAdminMicroserviceService{

	private static final Logger log = LoggerFactory.getLogger(AdminMicroserviceServiceImpl.class);
	
	@Autowired
	private DescriptionCreditCardDao repository;
	
	@Override
	public List<DescriptionCreditCard> listOfCardsByPassion(String passion) {
		// TODO Auto-generated method stub
		List<DescriptionCreditCard> list =  repository.findByPassion(passion);
		if(list.isEmpty()) {
			log.info("Error in service - listOfCardsByPassion");
			return null;
		}
		log.info("Sucesfull in service - listOfCardsByPassion");
		return list;
	}

	@Override
	public List<DescriptionCreditCard> listOfCardsBySalary(Double salary) {
		// TODO Auto-generated method stub
		if(validateSalary(salary)) {
		
			List<DescriptionCreditCard> listCards = new ArrayList<DescriptionCreditCard>();
			
			for(DescriptionCreditCard des: repository.findAll()) {
				if(des.getMinSalary() <= salary  && salary <= des.getMaxSalary()) {
					listCards.add(des);
					log.info("Succesfull in service - listOfCardsBySalary");
				}
			}
			return listCards;
		}
		log.info("Succesfull in service - listOfCardsBySalary");
		return null;
	}

	@Override
	public List<DescriptionCreditCard> listOfCardsByAge(Integer age) {
		if(validateAge(age)) {
			
		
			List<DescriptionCreditCard> listCards = new ArrayList<DescriptionCreditCard>();
			
			for(DescriptionCreditCard des: repository.findAll()) {
				if(des.getMinAge() <= age &&  age <= des.getMaxAge() ) {
					listCards.add(des);
					
				}
			}
			log.info("Succesfull in service - listOfCardsByAge");
			return listCards;
		
		}
		log.info("Error in service - listOfCardsByAge");
		return null;
	}

	@Override
	public DescriptionCreditCard listOfCardsByPassionSalaryAge(String passion, Double salary, Integer age) {

		
		DescriptionCreditCard card = new DescriptionCreditCard();
		log.info(validatePassion(passion).toString());
		
		if(validatePassion(passion) && validateSalary(salary) && validateAge(age)) {
			
			
			for(DescriptionCreditCard des: repository.findAll()) {
				
				if(des.getMinSalary() <= salary  && salary <= des.getMaxSalary()) {
					if(des.getMinAge() <= age &&  age <= des.getMaxAge()) {
						if(des.getPassion().equals(passion)) {
							card = des;
							log.info("Succesfull in service - listOfCardsByPassionSalaryAge");
						}
					}
				}
			}
			return card;
		}
		log.info("Error in service - listOfCardsByPassionSalaryAge");
		return null;
	}

	private Boolean validatePassion(String passion) {
		List<DescriptionCreditCard> list =  repository.findByPassion(passion);
		if(list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private Boolean validateAge(int age) {
		if(age <= 18 || age >= 75) {
			return false;
		}
		return true;
	}
	
	private Boolean validateSalary(double salary) {
		if(salary < 7000 ) {
			return false;
		}
		return true;
	}
}
