package edu.sjsu.cmpe.isns.dto;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.isns.domain.AwsEmail;
import edu.sjsu.cmpe.isns.domain.User;
import edu.sjsu.cmpe.isns.repository.DBConnection;

@JsonPropertyOrder(alphabetic = true)
public class UserDto extends LinksDto {
	private User user;
	ArrayList<String> emails=new ArrayList<String>();
	public UserDto(User user) {
		super();
		this.user = user;
	}

	public UserDto() {

	}

	/**
	 * @return the book
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@SuppressWarnings("unused")
	public void makeConnection() throws UnknownHostException {
		DBConnection dbc = new DBConnection("user");
		// return dbc.establishConnection();
	}

	
	public ArrayList<User> getAllUsers() throws UnknownHostException {
		DBConnection dbc = new DBConnection("user");
		return dbc.usersInStore();
	}
	/*
	 * public ArrayList<UserDto> getUsersListByDept(String department) throws
	 * UnknownHostException { DBConnection dbc=new DBConnection("user");
	 * ArrayList<UserDto> usersList= new ArrayList<UserDto>();
	 * usersList=dbc.usersInDepartment("department");
	 * usersList=dbc.coll.find("department"); return usersList; }
	 */
}