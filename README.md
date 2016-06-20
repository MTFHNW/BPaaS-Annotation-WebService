# BPaaS-Annotation-WebService

Purpose
--------
This web service is used for semantically lifting of modelling elements.

Functionality 
--------
The web service loads the in the following mentioned ontologies and creates a temporary model.
Requests on the web service will be used to query for sub-instances and subclasses in the loaded ontologies. The return format is plain and cvs format.
The returned set is split into two parts
1. label
2. concept names (including namespace)
The label is what the user can select and is numbered starting by 0. The concept names is the related URI for the label

Example request:
	http://localhost:8080/bpaas:PaymentPlan

Example return:
	0_TryFreeFirst;1_PrepaidAnnualPlan;2_CustomizablePlan;3_MonthlyFee;4_FreeOfCharge;;bpaas:TryFreeFirst;bpaas:PrepaidAnnualPlan;bpaas:CustomizablePlan;bpaas:MonthlyFee;bpaas:FreeOfCharge;

Ontologies
--------
1. BPAAS: Business Process as a Service Ontology [ [Repository Website](https://github.com/BPaaSModelling/BPaaS-Ontology) | [Turtle File](https://raw.githubusercontent.com/BPaaSModelling/BPaaS-Ontology/master/bpaas.ttl) ]
2. APQC: American Productivity and Quality Center Ontology [ [Repository Website](https://github.com/BPaaSModelling/APQC-Ontology) | [Turtle File](https://raw.githubusercontent.com/BPaaSModelling/APQC-Ontology/master/apqc.ttl) ]
3. FBPDO: Functional Business Process Description Ontology [ [Repository Website](https://github.com/BPaaSModelling/Functional-Business-Process-Description-Ontology) | [Turtle File](https://raw.githubusercontent.com/BPaaSModelling/Functional-Business-Process-Description-Ontology/master/fbpdo.ttl) ]
4. ARCHIMEO Ontology (meta ontology) [ [Repository Website](https://github.com/ikm-group/ArchiMEO) | [Turtle File](https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/ArchiMEO.ttl) ]
  1. TOP Ontology [ [Repository Website](https://github.com/ikm-group/ArchiMEO) | [Turtle File](https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/TOP/TOP.ttl) ]
  2. EO: Enterprise Object Ontology [ [Repository Website](https://github.com/ikm-group/ArchiMEO) | [Turtle File](https://raw.githubusercontent.com/ikm-group/ArchiMEO/master/ARCHIMEO/EO/EO.ttl) ]

Prerequisites
--------
* Java 1.8
* Internet connection
* tested on MAC OSX 10.11.15 and Windows 10 Education, Version 10.0.10240

How to..
--------

#### Start
Download the following files:
1. BPaaS-Annotation-WebService-0.0.1-SNAPSHOT.war
2. webapp-runner.jar

	java -jar webapp-runner.jar BPaaS-Annotation-WebService-0.0.1-SNAPSHOT.war

#### Test
Enter the following URL into your browser
  http://localhost:8080/

If “Hello!” is returned, the web service works fine.
