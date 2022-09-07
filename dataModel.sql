use bankmangement;

CREATE TABLE additionalDetails(
	form_no long ,
    religion VARCHAR(15),
    category VARCHAR(20),
    income VARCHAR(20),
    education VARCHAR(20),
    occupation VARCHAR(20),
    pan VARCHAR(10),
    adhaar VARCHAR(12),
    seniorCitizen VARCHAR(3),
    existingAccount VARCHAR(3)
);

CREATE TABLE accountType(
	form_no long,
    account_type VARCHAR(20),
    card_number CHAR(16),
    pin CHAR(4),
	service_required VARCHAR(100)
);

DROP TABLE additonaldetails;
SELECT * FROM signup;
SELECT * FROM additionaldetails;