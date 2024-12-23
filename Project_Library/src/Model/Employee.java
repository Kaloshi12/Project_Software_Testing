package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private  String name ;
	private String surname;
	private LocalDate birthday;
	private String phoneNumber;
	private Double salary;
	private AccessLevel level;
	private String userId;
	private String password;
	
	
	public Employee(String name, String surname, LocalDate birthday, String phoneNumber, double i, AccessLevel level,
			String userId, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.salary = i;
		this.level = level;
		this.userId = userId;
		this.password = password;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public AccessLevel getLevel() {
		return level;
	}
	public void setLevel(AccessLevel level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + ", level=" + level + ", userId=" + userId + ", password="
				+ password + "]";
	}
	
	

}
