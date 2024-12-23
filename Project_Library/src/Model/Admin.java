package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Admin extends Employee {
	
	
	public Admin(String name, String surname, LocalDate birthday, String phoneNumber, Double salary,
			AccessLevel level, String userId, String password) {
		super(name, surname, birthday, phoneNumber, salary, level, userId, password);
		
	}

  
}
