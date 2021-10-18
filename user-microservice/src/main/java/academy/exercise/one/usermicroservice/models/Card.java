package academy.exercise.one.usermicroservice.models;

import org.springframework.stereotype.Component;

@Component
public class Card {
	
	private Integer id;
	private String name;
	
	public Card() {
		
	}
	
	public Card(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public Card addCard(Integer id, String name) {
		this.id = id;
		this.name = name;
		return this;
	}
}
