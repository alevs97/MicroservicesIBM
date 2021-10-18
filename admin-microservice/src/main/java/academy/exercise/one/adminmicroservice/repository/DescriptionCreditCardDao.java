package academy.exercise.one.adminmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import academy.exercise.one.adminmicroservice.entity.DescriptionCreditCard;

public interface DescriptionCreditCardDao extends JpaRepository <DescriptionCreditCard,Long>{
	
	List<DescriptionCreditCard> findByPassion(String passion);

	
}
