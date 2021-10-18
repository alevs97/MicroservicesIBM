package academy.exercise.one.adminmicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DescriptionCreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="passion")
	private String passion;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_age")
	private int minAge;
	
	@Column(name="max_age")
	private int maxAge;
	
	@Column(name="credit_cards")
	private String creditCards;
	
	public DescriptionCreditCard() {
		
	}
	
	
	public DescriptionCreditCard(String passion, double minSalary, 
			double maxSalary, int minAge, int maxAge,String creditCards) {
		super();
		this.passion = passion;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.creditCards = creditCards;
	}
	
	public String getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(String creditCards) {
		this.creditCards = creditCards;
	}
	public String getPassion() {
		return passion;
	}
	public void setPassion(String passion) {
		this.passion = passion;
	}
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", creditCards=" + creditCards + ", passion=" + passion + ", minSalary=" + minSalary
				+ ", maxSalary=" + maxSalary + ", minAge=" + minAge + ", maxAge=" + maxAge + "]";
	}
	
}
