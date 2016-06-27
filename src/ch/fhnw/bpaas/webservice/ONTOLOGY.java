package ch.fhnw.bpaas.webservice;

public enum ONTOLOGY {
	BPAAS	("bpaas",	"TTL",	"https://raw.githubusercontent.com/BPaaSModelling/BPaaS-Ontology/master/bpaas.ttl"),
	APQC	("apqc",	"TTL",	"https://raw.githubusercontent.com/BPaaSModelling/APQC-Ontology/master/apqc.ttl"),
	FBPDO	("fbpdo",	"TTL",	"https://raw.githubusercontent.com/BPaaSModelling/Functional-Business-Process-Description-Ontology/master/fbpdo.ttl"),
	TOP		("top",		"TTL",	"resources/ArchiMEO/TOP/TOP.ttl"),
	EO		("eo",		"TTL", 	"resources/ArchiMEO/EO/EO.ttl"),
	ARCHIMEO("archimeo","TTL", 	"resources/ArchiMEO/ArchiMEO.ttl");
	
	private String prefix;
	private String format;
	private String remoteURL;

	ONTOLOGY(String prefix, String format, String remoteURL) {
		this.prefix = prefix;
		this.format = format;
		this.remoteURL = remoteURL;
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
}
