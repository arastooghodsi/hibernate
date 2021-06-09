package chapter07;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "„œ∆—")
public class Manager extends Employee {
	
	
	private String role;
	private Integer manager_bonus;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getManager_bonus() {
		return manager_bonus;
	}
	public void setManager_bonus(Integer manager_bonus) {
		this.manager_bonus = manager_bonus;
	}
	
	
	

}
