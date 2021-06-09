package chapter07;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "»—‰«„Â")
public class Programmer extends Employee {

	
	private String skills;
	private Integer programmer_bonus;
	
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public Integer getProgrammer_bonus() {
		return programmer_bonus;
	}
	public void setProgrammer_bonus(Integer programmer_bonus) {
		this.programmer_bonus = programmer_bonus;
	}
	
	
}
