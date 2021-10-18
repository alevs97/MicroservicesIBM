package academy.exercise.one.usermicroservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import academy.exercise.one.usermicroservice.models.AdminMicroservice;
import academy.exercise.one.usermicroservice.models.Card;
import academy.exercise.one.usermicroservice.proxy.AdminMicroserviceProxy;

@Service
public class UserMicroserviceServiceImpl implements IUserMicroserviceService{
	
	
	private static final Logger log = LoggerFactory.getLogger(UserMicroserviceServiceImpl.class);
	
	@Autowired
	private AdminMicroserviceProxy proxy;
	
	@Override
	public List<Card> listOfCardsByPassionSalaryAge(String passion, Double salary, Integer age) {
		
		AdminMicroservice adminResponse = proxy.retrieveAdminMicroservice(passion, salary, age);

		if(adminResponse == null) {
			return null;
		}
		List<Card> listCard = new ArrayList<Card>();
		
		log.info(adminResponse.toString());
		
		String[] arrayCard = adminResponse.getCreditCards().split(",");
		
		for(int i = 0; i < arrayCard.length ; i++) {
			listCard.add(new Card(i,arrayCard[i]));
		}
		
		return listCard;
	}

}
