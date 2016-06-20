package ch.fhnw.bpaas.webservice;

public enum ONTOLOGY {
	BPAAS	("bpaas",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/bpaas.ttl",	"bpaas.ttl"),
	APQC	("apcq",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/apqc.ttl",		"apqc.ttl"),
	FBPDO	("fbpdo",	"TTL",	"https://raw.githubusercontent.com/benlammel/CloudSocketAlignmentPrototype/master/ontologies/fbpdo.ttl",	"fbpdo.ttl"),
	TOP		("top",		"TTL",	"https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/TOP/TOP.ttl",							"TOP.ttl"),
	EO		("eo",		"TTL", 	"https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/EO/EO.ttl", 							"EO.ttl"),
	ARCHIMEO("archimeo","TTL", 	"https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/ArchiMEO.ttl", 						"ArchiMEO.ttl");
	
	private String prefix;
	private String format;
	private String remoteURL;
	private String localURL;

	ONTOLOGY(String prefix, String format, String remoteURL, String localURL) {
		this.prefix = prefix;
		this.format = format;
		this.remoteURL = remoteURL;
		this.localURL = localURL;
	}

	public String getRemoteURL() {
		return remoteURL;
	}

	public String getFormat() {
		return format;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getLocalURL() {
		return localURL;
	}	

}
