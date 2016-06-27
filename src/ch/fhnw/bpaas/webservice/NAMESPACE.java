package ch.fhnw.bpaas.webservice;

public enum NAMESPACE {
	
	OWL		("owl",							"http://www.w3.org/2002/07/owl#"),
	RDFS	("rdfs",						"http://www.w3.org/2000/01/rdf-schema#"),
	RDF		("rdf",							"http://www.w3.org/1999/02/22-rdf-syntax-ns#"),
	BPAAS	(ONTOLOGY.BPAAS.getPrefix(),	"http://ikm-group.ch/archimeo/bpaas#"),
	APQC	(ONTOLOGY.APQC.getPrefix(),		"http://ikm-group.ch/archimeo/apqc#"),
	FBPDO	(ONTOLOGY.FBPDO.getPrefix(),	"http://ikm-group.ch/archimeo/fbpdo#"),
	TOP		(ONTOLOGY.TOP.getPrefix(),		"http://ikm-group.ch/archiMEO/top#"),
	EO		(ONTOLOGY.EO.getPrefix(), 		"http://ikm-group.ch/archiMEO/eo#");

	private String prefix;
	private String url;
	
	NAMESPACE(String prefix, String url) {
		this.prefix = prefix;
		this.url = url;
	}

	public String getPrefix() {
		return prefix;
	}
	
	public String getURI() {
		return url;
	}

}