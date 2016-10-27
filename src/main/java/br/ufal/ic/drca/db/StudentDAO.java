package br.ufal.ic.drca.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import br.ufal.ic.drca.core.Student;
import io.dropwizard.hibernate.AbstractDAO;

public class StudentDAO extends AbstractDAO<Student> {

	public StudentDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	//TODO: Finish Queries
	public List<Student> findAll() {
		return list(namedQuery("br.ufal.ic.drca.core.Student.findAll"));
	}
	
	public List<Student> findByName(String name) {
		StringBuilder build = new StringBuilder("%");
		build.append(name).append("%");
		return list(
				namedQuery("br.ufal.ic.drca.core.Student.finByName")
				.setParameter("name", build.toString())
		);
	}
	public Optional<Student> findByRegistry(int registry) {
		return Optional.ofNullable(get(registry));
	}
	
}
