INSERT INTO Users (id, login, password, firstName, lastName, address, nationality, DNI, birthday) 
VALUES
	(1, 'freije@example.com', 'asdf', 'Fernando', 'Freije', 'Calle Adosinda', 'Español', '00000001A', '1990-01-01'),
	(2, 'pablo@example.com', 'asdf', 'Pablo', 'Garcia', 'Calle Asturias', 'Español', '00000002A', '1991-01-01'),
	(3, 'david@example.com', 'asdf', 'David', 'Garcia', 'Calle Azteca', 'Español', '00000003A', '1992-01-01'),
	(4, 'Juan@example.com', 'asdf', 'Juan', 'Torres', 'Calle Federico Garcia Lorca', 'Español', '90500084Y', '1993-01-01'),
	(5, 'Luis@example.com', 'asdf', 'Luis', 'López', 'Calle Adosinda', 'Español', '19160962F', '1994-01-01');
	
INSERT INTO Comments (id, title, comments) 
VALUES
	(1, 'Comment 1', 'This is a mock comment 1'),
	(2, 'Comment 2', 'This is a mock comment 2'),
	(3, 'Comment 3', 'This is a mock comment 3');
	
INSERT INTO Proposals (id, id_owner, title, description) 
VALUES
	(1, 1, 'Justice for everyone', 'This is a mock description'),
	(2, 2, 'Peace in the world', 'This is a mock description'),
	(3, 3, 'Free videogames', 'This is a mock description');

INSERT INTO Votes (id, id_proposal, id_user, id_comment)
VALUES
	(1, 1, 1, 1),
	(2, 2, 2, 2),
	(3, 3, 3, 3);

