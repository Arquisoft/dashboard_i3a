INSERT INTO Users (login, password, firstName, lastName, address, nationality, DNI, birthday, gender) 
VALUES
	('freije@example.com', 'asdf', 'Fernando', 'Freije', 'Calle Adosinda', 'Español', '00000001A', '1990-01-01', 'male'),
	('pablo@example.com', 'asdf', 'Pablo', 'Garcia', 'Calle Asturias', 'Español', '00000002A', '1991-01-01', 'male'),
	('david@example.com', 'asdf', 'David', 'Garcia', 'Calle Azteca', 'Español', '00000003A', '1992-01-01', 'male'),
	('Juan@example.com', 'asdf', 'Juan', 'Torres', 'Calle Federico Garcia Lorca', 'Español', '90500084Y', '1993-01-01', 'male'),
	('Luis@example.com', 'asdf', 'Luis', 'López', 'Calle Adosinda', 'Español', '19160962F', '1994-01-01', 'male');
	

INSERT INTO Proposals (id_owner, title, description) 
VALUES
	(1, 'Justice for everyone', 'This is a mock description'),
	(2, 'Peace in the world', 'This is a mock description'),
	(3, 'Free videogames', 'This is a mock description');

INSERT INTO Votesproposals (id_proposal, id_user, value)
VALUES
	(1, 1, false),
	(2, 2, true),
	(3, 3, true);
	
INSERT INTO Comments (id_proposal, id_user, id_commentparent, title, text) 
VALUES
	(1, 1, null, 'Comment 1', 'This is a mock comment 1'),
	(1, 3 ,1, 'Comment 2', 'This is a mock comment of comment 1'),
	(2, 2, 1, 'Comment 3', 'This is another mock comment');

INSERT INTO Votescomments (id_comment, id_user, value)
VALUES
	(1, 1, false),
	(2, 2, true),
	(3, 3, true);
	

	

