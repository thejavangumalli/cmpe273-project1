package edu.sjsu.cmpe.isns.repository;

import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.fusesource.stomp.jms.message.StompJmsMessage;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.sjsu.cmpe.isns.domain.AwsEmail;
import edu.sjsu.cmpe.isns.domain.User;

public class DBConnection {

	MongoClient mc;
	DB database;
	DBCollection coll;
	ArrayList<String> emails=new ArrayList<String>();
	String user = env("APOLLO_USER", "admin");
	String password = env("APOLLO_PASSWORD", "password");
	String host = env("APOLLO_HOST", "54.219.156.168");
	int port = Integer.parseInt(env("APOLLO_PORT", "61613"));
	String destination;
	StompJmsConnectionFactory factory;
	Connection connection;
	Session session;
	Destination dest;
	MessageConsumer consumer;
	Message msg;
	public DBConnection(String collectionTable) throws UnknownHostException {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://admin:password@ds053648.mongolab.com:53648/cmpe273project");
		mc = new MongoClient(uri);
		database = mc.getDB(uri.getDatabase());
		coll = database.getCollection(collectionTable);
		
	}
public void StoreUser(edu.sjsu.cmpe.isns.domain.User request) {
		BasicDBObject document = new BasicDBObject();
		//System.out.println("In Store User"+request.getUserName());
		 if(request.getUserName()!=null)
		{
			BasicDBObject findQuery = new BasicDBObject("userName",request.getUserName());
			coll = database.getCollection("user");
			DBObject userNm = coll.findOne(findQuery);
			//System.out.println(userNm);
			//System.out.println("User Name"+userNm.get("userName"));
			if((userNm==null)||(userNm.get("userName")==null))
			{
			//document.put("_id", request.getId());
			document.put("userName",request.getUserName());
			document.put("password",request.getPassword());
			document.put("firstName", request.getFirstName());
			document.put("lastName", request.getLastName());
			document.put("eMail", request.geteMail());
			document.put("phoneNumber", request.getPhoneNumber());
			document.put("department", request.getDepartment());
			coll.insert(document);
			}
			
		}
		
		

	}

public boolean DeleteEmployeeByUserName(String username) 
    {
		BasicDBObject findQuery = new BasicDBObject("userName", username);
		if(coll.find(findQuery).count()!=0)
		{
	    coll.remove(findQuery);
	    return true;
		}
		
		else
		{
			System.out.println("User does not exist in the collection");
			return false;
		}
		
	}

	public ArrayList<User> usersInStore() {
		// BasicDBObject findQuery = new BasicDBObject("firstName", "raj");
		ArrayList<User> usrList = new ArrayList<User>();

		DBCursor docs = coll.find();
		while (docs.hasNext()) {
			DBObject doc = docs.next();
			User usr = new User();
			//usr.setId(Integer.parseInt(doc.get("id").toString()));
			usr.setFirstName(doc.get("firstName").toString());
			usr.setLastName(doc.get("lastName").toString());
			usr.seteMail(doc.get("eMail").toString());
			usr.setPhoneNumber(doc.get("phoneNumber").toString());
			usr.setDepartment(doc.get("department").toString());
			usr.setUserName(doc.get("userName").toString());
			usr.setPassword(doc.get("password").toString());
			
			usrList.add(usr);
			// System.out.println("id"+doc.get("id")+"Name "+doc.get("firstName"));
		}
		return usrList;
	}


    
    public String getAllUsersInDepartment(String dept) {
		String deptuser="";
		ArrayList<User> deptList = new ArrayList<User>();
		BasicDBObject findQuery = new BasicDBObject("department", dept);
		//findQuery.put("department", dept);
		//coll = database.getCollection("user");
		DBCursor docs = coll.find(findQuery);
		
		while (docs.hasNext()) {
			DBObject doc = docs.next();
			User usr = new User();
			//usr.setId((Integer) doc.get("id"));
			usr.setFirstName(doc.get("firstName").toString());
			usr.setLastName(doc.get("lastName").toString());
			usr.seteMail(doc.get("eMail").toString());
			usr.setPhoneNumber(doc.get("phoneNumber").toString());
			usr.setDepartment(doc.get("department").toString());
			//System.out.println(usr.getFirstName()+""+usr.getId());
			deptList.add(usr);
			deptuser+="\""+doc.get("userName").toString()+"\""+",";
			//System.out.println("id"+doc.get("id")+"Name "+doc.get("firstName"));
		}
		return deptuser;
		 
	}
	
	public void sendpersonEmail(String username) throws Exception {
		BasicDBObject findQuery = new BasicDBObject("userName", username);
		DBCursor docs = coll.find(findQuery);
		while (docs.hasNext()) {
			DBObject doc = docs.next();
			if(doc.get("eMail").toString()!=null)
			emails.add(doc.get("eMail").toString());		}
		@SuppressWarnings("unused")
		AwsEmail email=new AwsEmail(emails,"Please login to check your notification");
		
	}
}