package ch.fhnw.bpaas.webservice;

public enum ONTOLOGY {
	APQC	("apqc",	"TTL",	"resources/apqc.ttl"),
	FBPDO	("fbpdo",	"TTL",	"https://raw.githubusercontent.com/MTFHNW/Functional-Business-Process-Description-Ontology/master/fbpdo.ttl"),
	TOP		("top",		"TTL",	"resources/ArchiMEO/TOP/TOP.ttl"),
	EO		("eo",		"TTL", 	"resources/ArchiMEO/EO/EO.ttl"),
	BPAAS	("bpaas",	"TTL",	"resources/bpaas.ttl"),
	ARCHIMEO("archimeo","TTL", 	"resources/ArchiMEO/ArchiMEO.ttl"),
	NCO		("nco",		"TTL", 	"resources/ArchiMEO/NCO/NCO.ttl"),
	BMM		("bmm",		"TTL", 	"resources/ArchiMEO/BMM/BMM.ttl");
	
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
