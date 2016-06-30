package ch.fhnw.bpaas.webservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
public class OntologyManager {
	
	private HashMap<String,String> resultSet;
	
	private static final String DELIMITERCHAR = ";";
	private Model rdfModel;

	public OntologyManager() {
		rdfModel = ModelFactory.createDefaultModel();
		
		setNamespaces();
		loadOntologyiesToModel();
		//debugging ontology
//		printToFile(rdfModel, "01_loaded_and_combined_model.ttl");
	}

	private void loadOntologyiesToModel() {
		for(ONTOLOGY ontology : ONTOLOGY.values()){
//			RDFDataMgr.read(rdfModel, this.getClass().getClassLoader().getResourceAsStream(ontology.getRemoteURL()), Lang.TTL);
//			RDFDataMgr.read(rdfModel, ontology.getRemoteURL()) ;
			rdfModel.read(ontology.getRemoteURL(), ontology.getFormat());
			
		}
	}

	private void printToFile(Model model, String FILENAME) {
		try {
			RDFDataMgr.write(new FileOutputStream(new File(FILENAME)), model, Lang.TTL) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setNamespaces() {
		for (NAMESPACE ns : NAMESPACE.values()) {
			rdfModel.setNsPrefix(ns.getPrefix(), ns.getURI());
		}
	}

	public ResultSet query(ParameterizedSparqlString queryStr) {
		addNamespacesToQuery(queryStr);
		//printout for console
		System.out.println(queryStr.toString());
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, rdfModel);

		return qexec.execSelect();
	}

	private void addNamespacesToQuery(ParameterizedSparqlString queryStr) {
		for (NAMESPACE ns : NAMESPACE.values()) {
			queryStr.setNsPrefix(ns.getPrefix(), ns.getURI());
		}
	}

	public String queryConcept(String concept) {
		int i = 0;
		resultSet = new HashMap<String,String>();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		instanceQuery(concept);
		subClassQuery(concept);
		
		for(Entry<String, String> item : resultSet.entrySet()){
			sb.append(i++ +"_" +item.getValue());
			sb.append(DELIMITERCHAR);
			sb2.append(formatURI(item.getKey()));
			sb2.append(DELIMITERCHAR);
		}
		if(sb.equals("")){
			return null;
		}else{
			return sb.append(DELIMITERCHAR).append(sb2).toString();
		}
	}
		
	private String formatURI(String string) {
		String[] array = string.split("/");
		return array[array.length-1].replace("#",":");
	}

	private void subClassQuery(String concept) {
		ParameterizedSparqlString queryStr = new ParameterizedSparqlString();
		queryStr.append("SELECT ?subject ?label WHERE {");
		queryStr.append("?subject rdfs:subClassOf " +concept +" .");
		queryStr.append("?subject rdfs:label ?label .");
		queryStr.append("}");
		processResults(query(queryStr));
	}

	private void instanceQuery(String concept) {
		ParameterizedSparqlString queryStr = new ParameterizedSparqlString();
		queryStr.append("SELECT ?subject ?label WHERE {");
		queryStr.append("?subject rdf:type " +concept +" .");
		queryStr.append("?subject rdfs:label ?label .");
		queryStr.append("}");
		processResults(query(queryStr));
	}

	private void processResults(ResultSet results) {
		while (results.hasNext()) {
			QuerySolution soln = results.next();
			resultSet.put(soln.get("subject").toString(), soln.get("label").toString());
		}
	}
}
