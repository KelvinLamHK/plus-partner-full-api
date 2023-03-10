CREATE TABLE TPolicyAssignment (
    policyNumber VARCHAR(60) unique NOT NULL,
    agentCode VARCHAR(30),
    trCode VARCHAR(150),
    trEmailAddress VARCHAR(900),
    trPhoneNumber VARCHAR(450),
    trNameEng VARCHAR(900),
    trNameChi VARCHAR(900),
    ChannelCode VARCHAR(30),
    updatedDate DATETIME,
	CONSTRAINT  PKTPolicyAssignment PRIMARY KEY CLUSTERED (policyNumber)
);

DROP TABLE TPolicyAssignment;

SELECT * FROM TPolicyAssignment;