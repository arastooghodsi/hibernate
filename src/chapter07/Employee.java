package chapter07;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name = "entity_type")
@DiscriminatorValue(value = "ò«—„‰œ")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	private String name;
	private Integer base_salary;
	
	
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
	public Integer getBase_salary() {
		return base_salary;
	}
	public void setBase_salary(Integer base_salary) {
		this.base_salary = base_salary;
	}
	
	
	
}
