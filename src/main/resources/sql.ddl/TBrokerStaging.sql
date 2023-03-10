CREATE TABLE TBrokerStaging (
    brokerCode VARCHAR(500) unique NOT NULL,
    brokerShortForm VARCHAR(500) NOT NULL,
    brokerName VARCHAR(2000) NOT NULL,
	CONSTRAINT  PKTBrokerStaging PRIMARY KEY CLUSTERED (brokerCode)
);

DROP TABLE TBrokerStaging;

SELECT * FROM TBrokerStaging;