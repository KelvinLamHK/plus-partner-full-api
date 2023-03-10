CREATE TABLE TBroker (
    brokerCode VARCHAR(500) unique NOT NULL,
    brokerShortForm VARCHAR(500) NOT NULL,
    brokerName VARCHAR(2000) NOT NULL,
	CONSTRAINT  PKTBroker PRIMARY KEY CLUSTERED (brokerCode)
);

DROP TABLE TBroker;

SELECT * FROM TBroker;
