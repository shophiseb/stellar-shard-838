package com.example.myproject;
/*package com.trivium.java.taskmanagementsystem1;

import java.sql.DriverManager;
import java.sql.Statement;

public class DBUser {
	public java.sql.Connection  con = null;
	 //  private final String selectMethod = "cursor"; 
	   // Constructor
	
	
	//insert to user n group also
	//task status table
	//trigger
	//remover usertaskgroup
	
	   public DBUser(){}
	   public java.sql.Connection getConnection(){
	        try{
	          //	Class.forName("oracle.jdbc.OracleDriver").newInstance();
	              con =DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","Oracle123");
	             if(con!=null) System.out.println("Connection Successful!");
	        }catch(Exception e){
	             e.printStackTrace();
	             System.out.println("Error Trace in getConnection() : " + e.getMessage());
	       }
	        return con;
	    }
	   public void displayDb(){ 
	  	 String firstName,lastName,email;
	  	 int userId,age,marks,sem;
	  	 String dob;
	        java.sql.ResultSet rs = null;
	        String query = "select USERID,FIRSTNAME,LASTNAME,DATEOFBIRTH,EMAIL from PERSON";
	        try{
	             con= this.getConnection();
	             if(con!=null)
	             {
	          	   Statement stmt = con.createStatement();
	           	   rs = stmt.executeQuery(query);
	          	 System.out.println("**********************************************************************");
	          	 System.out.println("ID\tFIRST NAME   \tLAST NAME   \tdate of birth  \t     Email");
	          	 System.out.println("**********************************************************************");
	          	   while(rs.next())
	          	   {
	          		   userId= rs.getInt(1);
	          		   firstName= rs.getString(2);
	          		   lastName=rs.getString(3);
	          		   dob=rs.getDate(4).toString();
	          		   email=rs.getString(5);
	          		   System.out.println(userId + "\t " + firstName + "\t       "+ lastName + "\t        "+ dob + "\t  "+ email + "\t   ");
	          	   }
	                  rs.close();
	                  rs = null;
	                  closeConnection();
	             }else System.out.println("Error: No active Connection");
	        }catch(Exception e){
	             e.printStackTrace();
	        }
	   }     
	   private void closeConnection(){
	        try{
	             if(con!=null)
	                  con.close();
	             con=null;
	        }catch(Exception e){
	             e.printStackTrace();
	        }
	   }
	   public static void main(String[] args) throws Exception
	     {
	  	 DBUser myDbTest1 = new DBUser();
	        myDbTest1.displayDb();
	     }

}
*/


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

public class DBUser {
	String firstName,lastName,email,password;
	int userId,age,marks,sem,privilege;
	String dob;
	Date birth;

	   public DBUser(String fname, String lname, 
	                   String password,int privilege,String email ) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.password=password;
	      this.email=email;
	      this.privilege=privilege;
	      
	   }
	


	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}


	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}


	private Map phoneNumbers;
	private ArrayList phoneList;
	private HashSet phoneSet;


	//insert to user n group also
	//task status table
	//trigger
	//remover usertaskgroup

	/**
	 * @return the phoneSet
	 */
	public HashSet getPhoneSet() {
		return phoneSet;
	}


	/**
	 * @param phoneSet the phoneSet to set
	 */
	public void setPhoneSet(HashSet phoneSet) {
		this.phoneSet = phoneSet;
	}


	/**
	 * @return the phoneList
	 */
	public ArrayList getPhoneList() {
		return phoneList;
	}


	/**
	 * @param phoneList the phoneList to set
	 */
	public void setPhoneList(ArrayList phoneList) {
		this.phoneList = phoneList;
	}


	/**
	 * @return the phoneNumbers
	 */
	public Map getPhoneNumbers() {
		return phoneNumbers;
	}


	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(Map phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


/*	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}*/


	/*public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public int getSem() {
		return sem;
	}


	public void setSem(int sem) {
		this.sem = sem;
	}

*/
	public int getPrivilege() {
		return privilege;
	}


	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public DBUser(){
		
	}
}
