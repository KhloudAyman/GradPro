package serv.robot;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.fabric.xmlrpc.base.Array;

import c.beans.robot;
import c.beans.user;
import db.connection.connectionUtils;
import db.connection.mySQLConnUtils;

public class RobotUtils {
	
	public static List<robot> getRobotData(Connection conn) throws SQLException {
		  
		  List<robot> robotData = new ArrayList<robot>();
			 
	      String sql = "Select * from multiagent.robot";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
//	      pstm.setString(1);
	 
	      ResultSet rs = pstm.executeQuery();
	      
	      int rID;
	      String rIP;
	      int robotAvailability;
	      int parkingX;
	      int parkingY;
	      float maxLoad;
	      int status;
	      
	      
//	      userAccount user = new userAccount();
	 
	      while (rs.next()) {
	    	  rID = rs.getInt(1);
	    	  rIP = rs.getString(10);
	    	  parkingX = rs.getInt(4);
	    	  parkingY = rs.getInt(5);
	    	  robotAvailability = rs.getInt(2);
	    	  maxLoad = rs.getFloat(6);
	    	  status = rs.getInt(9);

	    	  robot robot = new robot();
	    	  robot.setR_ID(rID);
	    	  robot.setR_IP(rIP);
	    	  robot.setparkingX(parkingX);
	    	  robot.setparkingY(parkingY);
	    	  robot.setAVAILITY(robotAvailability);
	    	  robot.setMAXLOAD(maxLoad);
	    	  robot.setstatus(status);
	    	 
	    	  robotData.add(robot);
//	          return userData;
	      }
	      return robotData;
	  }
	  
	  
	
//	public static Map<Integer, Integer> getAvailableRobotID(Connection conn) throws SQLException {
//		
//		  Map<Integer, Integer> robotData = new HashMap<>(); 
//	      String sql = "Select * from robot_table where robot_availability = 1";
//	      PreparedStatement pstm = conn.prepareStatement(sql);
//	      ResultSet rs = pstm.executeQuery();
//	      int rID;
//	      int noOfTasks;
//	      while (rs.next()) {
//	    	  rID = rs.getInt(1);
//	    	  noOfTasks = rs.getInt(7);
//	    	  robotData.put(noOfTasks, rID);
//	      }
//	      return robotData;
//	  }
	
///*	
////	this choose the id and the count of the first available available robot 
//	public static int choosingFirstRobotId(Connection conn) throws SQLException, ClassNotFoundException{
////		List<Integer> keyValue = new ArrayList<Integer>();
//		Map<Integer, Integer> a = getAvailableRobotID(conn);
//		Map.Entry<Integer,Integer> entry=a.entrySet().iterator().next();
////	    int keyCount= entry.getKey();
//   	    int valueId=entry.getValue();
////   	    keyValue.add(keyCount);
////   	    keyValue.add(valueId);
//   	    return valueId;
//   	    
//	}
////*/
//
//	//return id for all robots that will be suitable for task
//	public static List<Integer> choosingMultiRobot(Connection conn, int noOfRobotForTask) throws SQLException, ClassNotFoundException{
//		Map<Integer, Integer> a = getAvailableRobotID(conn);
//		int counterRobot = 0;
//		int robotForCondition = noOfRobotForTask+1;
//		  List<Integer> idForRobotToAssign = new ArrayList<>();
//		    Iterator it = a.entrySet().iterator();
//		    while (it.hasNext()) {
//		    	counterRobot++;
//		        Map.Entry pair = (Map.Entry)it.next();
////		        System.out.println("iterator: "+pair.getKey() + " = " + pair.getValue());
////		        System.out.println("it:  "+counterRobot);
//		        it.remove(); // avoids a ConcurrentModificationException
//		    	if(counterRobot<robotForCondition){
//		    		idForRobotToAssign.add((Integer) pair.getValue());
//		    	}
//		    }
//		    return idForRobotToAssign;
//   	    
//	}
//	
//	  public static List<robot> getAvailableDataForChoosenRobot(Connection conn, List<Integer> id) throws SQLException, ClassNotFoundException{
//		  Map<Integer, robot> returnedData = getAvailableRData(conn);
////		  List<Integer> id = choosingMultiRobot(conn, noOfRobotForTask);
//		  List <robot> rDataValues = new ArrayList<>();
////		  indexOfIDList = id.get(i) to get the value of id from id list
////		  it returned the id to get the data from returnedData from list
//		  int sizeOfIDList = id.size();
//		  for(int i=0; i<sizeOfIDList; i++){
//			  rDataValues.add(returnedData.get(id.get(i)));
////			  System.out.println("inside robot location:  "+returnedData.get(id.get(i)));
//		  }
////		  robotAccount rDataValues = returnedData.get(id);
//		  return rDataValues;
//	  }
//	  
//	  //take input of maxWeightLoad in the runtime(while user enter the data in the assign task)
//	  public static int calculateNoOfRobotsForTask(Connection conn, float maxWeightOfLoad) throws SQLException, ClassNotFoundException{
//		  Map<Integer, robot> dataAboutMaxLoadForRobot = getAvailableRData(conn);
//		  int firstID = choosingFirstRobotId(conn);
//		  robot maxLoadData = dataAboutMaxLoadForRobot.get(firstID);
//		  float maxLoadOfRobot =maxLoadData.getMAXLOAD();
//		  float noOfRobotsF = maxWeightOfLoad/maxLoadOfRobot;
//		  int noOfRobotsInt = (int) Math.ceil(noOfRobotsF);
//		  
//		  return noOfRobotsInt;
//	  }
	
//	public static void assignTask(Connection conn, int maxWeightOfLoad) throws ClassNotFoundException, SQLException{
//		String sql = "UPDATE robot_table SET robot_availability=?, robot_nooftasks =? WHERE robot_id = ?";
//	      PreparedStatement pstm = conn.prepareStatement(sql);
////	      ResultSet rs = pstm.executeQuery();    
////	/*      
//		int incNoOfTasksForRobot=0;
//		int idFromAvailabeRobotData;
//		int getId;
//		int noOfRobotInTask = calculateNoOfRobotsForTask(conn, maxWeightOfLoad);
//		List<Integer> idOfRobotsAvailable = choosingMultiRobot(conn, noOfRobotInTask);
//		List<robot> availabeRobotData = getAvailableDataForChoosenRobot(conn, idOfRobotsAvailable);
//		int sizeOfAvailabeRobotData = availabeRobotData.size();
////		System.out.println("kjkj: "+sizeOfAvailabeRobotData);
//		for(int i=0; i<sizeOfAvailabeRobotData; i++){
//
////			incNoOfTasksForRobot = (availabeRobotData.get(i).getNoOfTasks())+1;
//			getId = availabeRobotData.get(i).getR_ID();
////			System.out.println("Before Update:  "+ availabeRobotData.get(i).getNoOfTasks());
//			System.out.println("Before Update:  "+ getId);
//			pstm.setInt(1, 0);
//			pstm.setInt(2, incNoOfTasksForRobot);
//			pstm.setInt(3, getId);
//			pstm.executeUpdate();
//			System.out.println("task no update:  "+incNoOfTasksForRobot);
//			System.out.println("id:  "+ getId);
//			
//		}
////	*/	
//
//
//	      
//
//	}
//	
	
//	public static List<robotAccount> getUnAvailableRobot(Connection conn) throws SQLException {
//		  
//		  List<robotAccount> robotData = new ArrayList<robotAccount>();
//			 
//	      String sql = "Select * from robot_table where robot_availability = 0";
//	 
//	      PreparedStatement pstm = conn.prepareStatement(sql);
////	      pstm.setString(1);
//	 
//	      ResultSet rs = pstm.executeQuery();
//	      
//	      int rID;
//	      int robotAvailability;
//	      int fkTaskID;
//	      float xLocation;
//	      float yLocation;
//	      float maxLoad;
//	      int noOfTasks;
//	      
////	      userAccount user = new userAccount();
//	 
//	      while (rs.next()) {
//	    	  rID = rs.getInt(1);
//	    	  robotAvailability = rs.getInt(2);
//	    	  fkTaskID = rs.getInt(3);
//	    	  xLocation = rs.getFloat(4);
//	    	  yLocation = rs.getFloat(5);
//	    	  maxLoad = rs.getFloat(6);
//	    	  noOfTasks = rs.getInt(7);
//
//	    	  robotAccount robot = new robotAccount();
//	    	  robot.setrID(rID);
//	    	  robot.setXLocation(xLocation);
//	    	  robot.setYLocation(yLocation);
//	    	  robot.setMaxLoad(maxLoad);
//	    	  robot.setNoOfTasks(noOfTasks);
//	    	 
//	    	  robotData.add(robot);
//	      }
//	      return robotData;
//	  }

	
	/*  
	  //return value for specific choosen id first id
	  public static robotAccount getAvailableRLocation(Connection conn) throws SQLException, ClassNotFoundException{
		  Map<Integer, robotAccount> returnedData = getAvailableRData(conn);
		  int id = choosingRobot(conn);
		  robotAccount rDataValues = returnedData.get(id);
		  return rDataValues;
	  }
	  */
	  
//	  //return all data about available robot
//	  public static Map<Integer, robot> getAvailableRData (Connection conn) throws SQLException {
//		  Map<Integer, robot> robotData = new HashMap<>();
//	      String sql = "Select * from robot_table where robot_availability = 1;";
//	      PreparedStatement pstm = conn.prepareStatement(sql);
//	      ResultSet rs = pstm.executeQuery();
//	      
//	      int R_ID;
//	      String R_IP;
//	      int AVAILITY;
//	      int maxLoad;
//	      int status;
//	       
//	      while (rs.next()) {
//	    	  R_ID = rs.getInt(1);
//	    	  R_IP = rs.getString(2);
//	    	  AVAILITY = rs.getInt(3);
//	    	  maxLoad = rs.getInt(4);
//	    	  status = rs.getInt(5);
//	    	  
//
//	    	  robot robot = new robot();
//	    	  robot.setR_ID(R_ID);
//	    	  robot.setR_IP(R_IP);
//	    	  robot.setAVAILITY(AVAILITY);
//	    	  robot.setMAXLOAD(maxLoad);
//	    	  robot.setstatus(status);
//	    	 
//	    	  robotData.put(R_ID,robot);
//	      }
//	      System.out.println("robotData:  "+robotData);
//	      return robotData;
//	  }
//	  
//	  
//	  
	  public static void deleteRobot(int id){
		  String sql = "DELETE FROM multiagent.robot " + "WHERE robot_id = ?";
		  Connection conn = null;
		  PreparedStatement pstm = null;
//		  int rs;
		try {
			conn = mySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, id);
			 pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
//	  
	  public static int updateRobot(int R_ID ,String robot_IP, int parkingX, int parkingY, float maxLoad){
		
			  String sql = "UPDATE multiagent.robot " + "SET robotIP = ? , robot_maxLoad = ? ,  robot_x = ?, robot_y = ?"
			  		+ " WHERE robot_id = ?;";
			  Connection conn = null;
			  PreparedStatement pstm = null;
			  int i=0;			  
			  //int rs;
			try {
				conn = mySQLConnUtils.getMySQLConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      try {
				 pstm = conn.prepareStatement(sql);
				 pstm.setString(1, robot_IP);
				
				 pstm.setFloat(2, maxLoad);
				 pstm.setInt(3, parkingX);
				 pstm.setInt(4,parkingY);
				 pstm.setInt(5,R_ID);
			     i= pstm.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      return i;
	  }
	  
	  
//	  public static void main(String[] args) throws SQLException, ClassNotFoundException{
//		  Connection conn = null;
//		  conn = mySQLConnUtils.getMySQLConnection();
//		  Map<Integer, Integer> a = getAvailableRobotID(conn);
//		  
//		  Iterator it = a.entrySet().iterator();
//		    while (it.hasNext()) {
//		    	
//		        Map.Entry pair = (Map.Entry)it.next();
//		        
//		        System.out.println("iterator: "+pair.getKey() + " = " + pair.getValue());
//		        
//		        it.remove(); // avoids a ConcurrentModificationException
//		    
//		    	
//		    }
//		  
//		  List<Integer> j= choosingMultiRobot(conn,6);
////
////		    System.out.println("size of list:  "+ j.size());
////		    
////		    List<robotAccount> k =  getAvailableRLocation(conn, 4);
//		    for(int m=0 ;m <6; m++){
//		    	System.out.println("list:  "+j.get(m));
//		    }
////		    Map<Integer, robotAccount> b=  getAvailableRData(conn);
////		    System.out.println(b.size());
//		    
		    
		    
//		    int r = choosingFirstRobotId(conn);
//		    System.out.println("Choose first robot id:  "+ r);
//		  assignTask(conn, 20);
//		    int v =calculateNoOfRobotsForTask(conn, 35);
//		    System.out.println("hello v:  "+v);
/*  
		  //
		  //iterate through map --> get the first and last element
		  int i=0;
		  List<Integer> j = new ArrayList<>();
		    Iterator it = a.entrySet().iterator();
		    while (it.hasNext()) {
		    	i++;
		        Map.Entry pair = (Map.Entry)it.next();
		        
		        System.out.println("iterator: "+pair.getKey() + " = " + pair.getValue());
		        System.out.println("it:  "+i);
		        it.remove(); // avoids a ConcurrentModificationException
		    	if(i<5){

		        j.add((Integer) pair.getValue());
		    	}
		    	
		    }
		    for(int m=0 ;m <4; m++){
		    	System.out.println("list:  "+j.get(m));
		    }
		  //end iterate
		   //
		    
 */
		    
//		  Map<Integer, Integer> a = getAvailableRobot(conn);
//		  System.out.println("hello a:  "+a);
//		  
//		  Map<Integer, robotAccount> c = assignRobotTask(conn);
//		  System.out.println("hello map:  "+c);
//		  
//		  int i = choosingRobot(conn);
//		  System.out.println("class: "+i);
//		  System.out.println("value class: "+i.get(1));
		  
		 
		  
//		  Map<String,String> map=new HashMap<>();
//		  Map.Entry<Integer,Integer> entry=a.entrySet().iterator().next();
//		  int key= entry.getKey();
//		  int value=entry.getValue();
//		  System.out.println("Key: "+key);
//		  System.out.println("Value: "+value);
//		    final Map<Integer,String> orderMap = new LinkedHashMap<Integer,String>();
//		    orderMap.put(6, "Six");
//		    orderMap.put(7, "Seven");
//		    orderMap.put(3, "Three");
//		    orderMap.put(100, "Hundered");
//		    orderMap.put(10, "Ten");
//
//		    final Set<Entry<Integer, String>> mapValues = orderMap.entrySet();
//		    final int maplength = mapValues.size();
//		    final Entry<Integer,String>[] test = new Entry[maplength];
//		    mapValues.toArray(test);
//
//		    System.out.print("First Key:"+test[0].getKey());
//		    System.out.println(" First Value:"+test[0].getValue());
//
//		    System.out.print("Last Key:"+test[maplength-1].getKey());
//		    System.out.println(" Last Value:"+test[maplength-1].getValue());

		  
		  
//		  System.out.println(conn);
//		  Map<Integer, robotAccount> testMap = assignRobotTask(conn);
//		  System.out.println(testMap.keySet());
//		  List<robotAccount> r = getUnAvailableRobot(conn);
//		  System.out.println(r.get(1).getNoOfTasks());
	  //}

}
