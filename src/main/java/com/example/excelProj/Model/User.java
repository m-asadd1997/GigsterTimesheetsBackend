package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String password;

    @Column
    private Boolean active;
    
    @Column
    private String userType;

    @Column
	private String organizationName;
//    @Column
//    private Long clientId;
	@Lob
	private byte[] userImage;

	@OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
	@JsonIgnore
	List<Timesheets> timesheets;

	@OneToMany(mappedBy = "supervisor",cascade = {CascadeType.ALL})
	@JsonIgnore
	List<Timesheets> timesheetsForSupervisor;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public List<Timesheets> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheets> timesheets) {
		this.timesheets = timesheets;
	}

	public List<Timesheets> getTimesheetsForSupervisor() {
		return timesheetsForSupervisor;
	}

	public void setTimesheetsForSupervisor(List<Timesheets> timesheetsForSupervisor) {
		this.timesheetsForSupervisor = timesheetsForSupervisor;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
}
