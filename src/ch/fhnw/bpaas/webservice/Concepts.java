package ch.fhnw.bpaas.webservice;

public enum Concepts {
	ACTION					("fbpdo:Action"									,	true),
	OBJECT					("fbpdo:Object"									,	true),
	APQC					("apqc:AmericanProductivityAndQualityCenter"	,	true),
	TYPE_OF_BACKUP			("bpaas:TypeOfBackup"							,	false),
	LEVEL					("bpaas:RequirementLevel"						,	false),
	TYPE_OF_ENCRYPTION 		("bpaas:TypeOfEncryption"						,	false),
	LOCATION 				("top:Location"									,	false),
    PAYMENT_PLAN  			("bpaas:PaymentPlan"							,	false),
	OFFERED_PAYMENT_PLAN 	("bpaas:OfferedPaymentPlan"						,	false);
	
	private String concept;
	private boolean classConcept;

	private Concepts(String concept, boolean classConcept) {
		this.concept = concept;
		this.classConcept = classConcept;
	}

	public String getConcept() {
		return concept;
	}

	public boolean isClass() {
		return classConcept;
	}
}
