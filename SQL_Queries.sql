create database if not exists employeeManagementDb;


use employeeManagementDb;


-- Database Script for "employees" table

	-- Snippet -> 01
        -- Disable safe updates
			SET SQL_SAFE_UPDATES = 0;
		-- Delete any existing rows
			delete from employees;
		 -- Revert to the previous value
			SET SQL_SAFE_UPDATES = 1;  
            
	-- Snippet -> 02
    INSERT INTO employees (id, firstName, lastName, email) VALUES (1,'Suresh', 'Reddy', 'suresh_reddy@gmail.com');
    INSERT INTO employees (id, firstName, lastName, email) VALUES (2, 'Murali', 'Mohan', 'murali_mohan@gmail.com');
    INSERT INTO employees (id, firstName, lastName, email) VALUES (3, 'Daniel', 'Denson', 'daniel_denson@gmail.com');
    INSERT INTO employees (id, firstName, lastName, email) VALUES (4, 'Tanya', 'Gupta', 'tanya_gupta@gmail.com'); 
    INSERT INTO employees (id, firstName, lastName, email) VALUES (5, 'Murali', 'Singh', 'murali_singh@gmail.com');







-- Database Script for "roles" table

	-- Snippet -> 01
        -- Disable safe updates
			SET SQL_SAFE_UPDATES = 0;
		-- Delete any existing rows
			delete from roles;
		 -- Revert to the previous value
			SET SQL_SAFE_UPDATES = 1;  
            
            
	-- Snippet -> 02
    INSERT INTO roles (roleId, roleName) VALUES (1, 'ADMIN');
    INSERT INTO roles (roleId, roleName) VALUES (2, 'MANAGER');
    INSERT INTO roles (roleId, roleName) VALUES (3, 'USER');







-- Database Script for "usersTable" table

	-- Snippet -> 01
        -- Disable safe updates
			SET SQL_SAFE_UPDATES = 0;
		-- Delete any existing rows
			delete from usersTable;
		 -- Revert to the previous value
			SET SQL_SAFE_UPDATES = 1;  
            

	-- Snippet -> 02
		-- Encrypted passwords for below users
			-- Admin (password: Admin): "$2a$10$6jxm83ijVU8ySxLQ6h9Xz.urVyJmyypJXr8uw9tRzeoU69B0QwY8G"
            -- Manager (password : Manager): "$2a$10$wer6cptqFepScsAhHdfx3e49VDxgbq5yYZyRCRZyDoi12LwAaqqai"
            -- User (password : "User"): "$2a$10$v5SyPfGLl4w0cpJCZ.KiyeF/QO.dLPBfEpnqSrgJ7aQRjEkq6Zijm"


	-- Snippet -> 03
    INSERT INTO usersTable (usersId, password, username) VALUES (1, '$2a$10$6jxm83ijVU8ySxLQ6h9Xz.urVyJmyypJXr8uw9tRzeoU69B0QwY8G', 'Admin');
    INSERT INTO usersTable (usersId, password, username) VALUES (2, '$2a$10$wer6cptqFepScsAhHdfx3e49VDxgbq5yYZyRCRZyDoi12LwAaqqai', 'Manager');
    INSERT INTO usersTable (usersId, password, username) VALUES (3, '$2a$10$v5SyPfGLl4w0cpJCZ.KiyeF/QO.dLPBfEpnqSrgJ7aQRjEkq6Zijm', 'User');




        
        

-- Mapping in "userRoleMapping" Table:

	-- Snippet -> 01
        -- Disable safe updates
			SET SQL_SAFE_UPDATES = 0;
		-- Delete any existing rows
			delete from userRoleMapping;
		 -- Revert to the previous value
			SET SQL_SAFE_UPDATES = 1; 
            
            
	-- Snippet -> 02
		-- Mapping for above mentioned data
		-- Column -> userId      roleId
			--			1			1     -> 'Admin' user with 'ADMIN' role
			--			2			2     -> 'Manager' user with 'MANAGER' role
			--			3			3     -> 'User' user with 'User' role
            

	-- Snippet -> 03
    INSERT INTO userRoleMapping (user_Id, role_Id) VALUES (1, 1);
    INSERT INTO userRoleMapping (user_Id, role_Id) VALUES (2, 2);
    INSERT INTO userRoleMapping (user_Id, role_Id) VALUES (3, 3);