package edu.sjsu.cmpe.isns.dto;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.isns.domain.User;
import edu.sjsu.cmpe.isns.repository.DBConnection;


	@JsonPropertyOrder(alphabetic = true)
	public class UsersDto extends LinksDto {
		private List<User> Users;

		/**
		 * @param User
		 * @throws UnknownHostException 
		 */
		public UsersDto() throws UnknownHostException {
			super();
			UserDto ud=new UserDto();
			ud.makeConnection();
			//this.Users = Users;
		}

		

		/**
		 * @param User
		 *            the User to set
		 * @throws UnknownHostException 
		 */
		public String getAlldeptUsers(String department) throws UnknownHostException {
			DBConnection db=new DBConnection("user");
			//this.Users = db.getAllUsersInDepartment(department);
			return  db.getAllUsersInDepartment(department);
			// TODO Auto-generated method stub
			
		}
		
		
	}
