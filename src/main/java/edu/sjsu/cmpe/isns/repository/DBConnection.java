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
	
}