package br.ufal.ic.drca.resources;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.ufal.ic.drca.core.Student;
import br.ufal.ic.drca.db.StudentDAO;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentsResource {

	
	private StudentDAO studentDAO;
	
	public StudentsResource(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	@GET
	@UnitOfWork
	public List<Student> findByName(@QueryParam("name") Optional<String> name) {
		if (name.isPresent()) {
			return studentDAO.findByName(name.get());
		}else {
			return studentDAO.findAll();
		
		}
	}
	
	@GET
	@Path("/{id}")
	@UnitOfWork
	public Optional<Student> findById(@PathParam("id") int registry) {
		return studentDAO.findByRegistry(registry);
	}
}
