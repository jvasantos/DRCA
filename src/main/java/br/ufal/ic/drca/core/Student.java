package br.ufal.ic.drca.core;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "com.javaeeeee.dwstart.core.Employee.findAll",
            query = "select e from Employee e"),
    @NamedQuery(name = "com.javaeeeee.dwstart.core.Employee.findByName",
            query = "select e from Employee e "
            + "where e.firstName like :name "
            + "or e.lastName like :name")
})
public class Student {
		
	
	@NotBlank
	private String name;
	
	@Id
	@NotBlank
	private String registry;
	
	@NotBlank
	@Column(name = "mandatory_credits")
	private int manCredits;
	
	@NotBlank
	@Column(name = "optional_credits")
	private int optCredits;
	
	@NotBlank
	private String course;
	
	private List<Subject> subjects;
	
	public Student() {
	}
	

	public Student(String name, String registry, int manCredits, int optCredits, String course,
			List<Subject> subjects) {
		this.name = name;
		this.registry = registry;
		this.manCredits = manCredits;
		this.optCredits = optCredits;
		this.course = course;
		this.subjects = subjects;
	}



	public String getName() {
		return name;
	}

	public String getRegistry() {
		return registry;
	}
	
	public int getManCredits() {
		return manCredits;
	}

	public int getOptCredits() {
		return optCredits;
	}

	public String getCourse() {
		return course;
	}

	public List<Subject> getSubjectss() {
		return subjects;
	}
}
