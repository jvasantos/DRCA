package br.ufal.ic.drca.db;

import java.util.List;

import org.hibernate.SessionFactory;

import br.ufal.ic.drca.core.Student;
import io.dropwizard.hibernate.AbstractDAO;

public class StudentDAO extends AbstractDAO<Student> {

	public StudentDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<Student> findAll() {
		return list(namedQuery("com.javaeeeee.dwstart.core.Employee.findAll"));
	}
	
}
