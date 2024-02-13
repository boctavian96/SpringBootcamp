USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
-- 
CREATE TABLE `users` (
	`username` varchar(50) NOT NULL,
    `password` varchar(68) NOT NULL,
    `enabled` tinyint NOT NULL,
    
    PRIMARY KEY(`username`)
)DEFAULT CHARSET=latin1;

--
-- Inserting data for basic users
-- pass: fun123
INSERT INTO `users`
VALUES
('octavian', '{bcrypt}$2a$10$GB4fgbdhVIFO8nw8cjqRoOL.0.ZTCBNRCfTu.tsRrPOgpjk6qf9/C', 1),
('adelina', '{bcrypt}$2a$10$bkj0py8RxbpJfTxlw.mBwODX/kMRhyvzXN9QvOqVtFfPNf95HN6.O', 1),
('jula', '{bcrypt}$2a$10$GMPPts5fHjXm3wlknv79ROsgHxhqk95.JUbWQgOQPRoDtpnHyn72m', 1);

--
-- Table structure for 'authorities'
--

-- authorities == roles.
CREATE TABLE `authorities`(
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,
UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
)DEFAULT CHARSET = latin1;

-- 
-- Insert dummy roles
-- 

INSERT INTO `authorities`
VALUES
('jula', 'ROLE_EMPLOYEE'),
('adelina', 'ROLE_EMPLOYEE'),
('adelina', 'ROLE_MANAGER'),
('octavian', 'ROLE_EMPLOYEE'),
('octavian', 'ROLE_MANAGER'),
('octavian', 'ROLE_ADMIN');

-- IMPORTANT: Internally Spring uses 'ROLE_' prefix.
