package br.ufal.ic.drca.resources;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import br.ufal.ic.drca.core.Student;

@Path("/")
public class IndexResource {

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	public List<Student> index() {
		return Arrays.asList(new Student("Joao", "7012"));
	}
	
}
