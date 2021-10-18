package academy.exercise.one.usermicroservice.models;

import org.springframework.stereotype.Component;


public class AdminMicroservice {
	
	private String passion;
	private double minSalary;
	private double maxSalary;
	private int minAge;
	private int maxAge;
	private String creditCards;
	
	public AdminMicroservice(String passion, double minSalary, double maxSalary, int minAge, int maxAge,
			String creditCards) {
		super();
		this.passion = passion;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.minAge = minAge;
		this.maxAge = maxAge;
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

	public String getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(String creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public String toString() {
		return "AdminMicroservice [passion=" + passion + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary
				+ ", minAge=" + minAge + ", maxAge=" + maxAge + ", creditCards=" + creditCards + "]";
	}
	
	
	
	
}
