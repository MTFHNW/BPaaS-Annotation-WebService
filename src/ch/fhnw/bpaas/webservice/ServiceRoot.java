package ch.fhnw.bpaas.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ServiceRoot {
	
	private OntologyManager ontology = new OntologyManager();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello!";
	}
	
	@Path("{a}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String oneParam(@PathParam("a") String a) {
		return ontology.queryConcept(a);
	}
}
