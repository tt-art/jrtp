package com.acks.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer userId;
private String fullName ;
private String email;
private Long phno;
private String gender;
private LocalDate dob;
private Long ssn;
private String activeSwitch="Y";
@CreationTimestamp
private LocalDate createdDate;
@UpdateTimestamp
private LocalDate updateDate;
@Override
public String toString() {
	return "UserAccount [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phno=" + phno
			+ ", gender=" + gender + ", dob=" + dob + ", ssn=" + ssn + ", activeSwitch=" + activeSwitch
			+ ", createdDate=" + createdDate + ", updateDate=" + updateDate + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getPhno() {
	return phno;
}
public void setPhno(Long phno) {
	this.phno = phno;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public Long getSsn() {
	return ssn;
}
public void setSsn(Long ssn) {
	this.ssn = ssn;
}
public String getActiveSwitch() {
	return activeSwitch;
}
public void setActiveSwitch(String activeSwitch) {
	this.activeSwitch = activeSwitch;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}
public LocalDate getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(LocalDate updateDate) {
	this.updateDate = updateDate;
}


	
}
