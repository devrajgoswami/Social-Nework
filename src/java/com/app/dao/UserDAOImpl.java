/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.dao.DBService.ConnectionManager;
import com.app.vo.ActivityVO;
import com.app.vo.ContactDetailsVO;
import com.app.vo.FriendRequestVO;
import com.app.vo.MiniDetailsVO;
import com.app.vo.PersonalDetailsVO;
import com.app.vo.ProDetailsVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devraj
 */
public class UserDAOImpl implements UserDAO {

    private Connection con;
    private static final Logger logger=Logger.getLogger(UserDAOImpl.class.getName());
    public UserDAOImpl() {
        con=ConnectionManager.getMySQLConnection();
    }

    public int registerUser(String firstName, String lastName, String email, String password, String sex, String dob) {
        int userNo=-1,n=0;
        try {
            PreparedStatement ps=con.prepareStatement("insert into userMaster (firstName, lastName, email, password, gender, dob) values (?,?,?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, sex);
            ps.setString(6, dob);
            n=ps.executeUpdate();
            if(n>0)
                logger.log(Level.INFO, "User : {0} {1} has been registered...", new Object[]{firstName, lastName});
            else
                logger.warning("User registration failed...");
            ConnectionManager.releaseResource(ps,null);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        try {
            PreparedStatement ps=con.prepareStatement("SELECT userNO FROM userMaster WHERE email=?");
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                userNo=rs.getInt("userNO");
            ConnectionManager.releaseResource(ps,rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        if(userNo>0){
            try {
                PreparedStatement ps=con.prepareStatement("INSERT INTO userDetails (userNO) values(?)");
                ps.setInt(1, userNo);
                ps.executeUpdate();
                ConnectionManager.releaseResource(ps,null);
            } catch (SQLException ex) {
                logger.severe(ex.toString());
            }
        }
        return userNo;
    }

    public boolean loginUser(String username, String password) {
        boolean login=false;
        String passcode=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT password FROM userMaster WHERE email=? OR userID=?");
            ps.setString(1,username);
            ps.setString(2,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                passcode=rs.getString("password");
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        if(password.equals(passcode))
            login=true;
        return login;
    }

    public int getUserNo(String username) {
        int userNo=0;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT userNO FROM userMaster WHERE email=? OR userID=?");
            ps.setString(1,username);
            ps.setString(2,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                userNo=rs.getInt("userNO");
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return userNo;
    }

    public String getFullName(int userNo) {
        String fullName=null,firstName=null,lastName=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT firstName, lastName FROM userMaster WHERE userNO=?");
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                firstName=rs.getString("firstName");
                lastName=rs.getString("lastName");
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        fullName =firstName+" "+lastName;
        return fullName;
    }
    
    public String getName(int userNo) {
        String name=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT firstName FROM userMaster WHERE userNO=?");
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                name=rs.getString("firstName");
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return name;
    }
    
    public String getProfilePic(int userNo){
        String picName=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT profilePic FROM userMaster WHERE userNO=?");
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                picName=rs.getString("profilePic");
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return picName;
    }
    
    public ArrayList<Integer> getFriendMainList(int userNo){
        ArrayList<Integer> friends = new ArrayList<Integer>();
        int count=0;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT friendNo FROM friendList WHERE userNO=?");
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next() && count<9){
                Integer friendNo = new Integer(rs.getInt("friendNo"));
                friends.add(friendNo);
                count++;
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return friends;
    }
    
    public ArrayList<Integer> getFullFriendList(int userNo){
        ArrayList<Integer> friends = new ArrayList<Integer>();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT friendNo FROM friendList WHERE userNO=?");
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer friendNo = new Integer(rs.getInt("friendNo"));
                friends.add(friendNo);
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return friends;
    }
    
    public void updateStatus(int userNo, String status){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO activities (ActivityType,ActivityOf,ActivityBy,Message) values('status',?,?,?)");
            ps.setInt(1,userNo);
            ps.setInt(2,userNo);
            ps.setString(3,status);
            ps.executeUpdate();
            ConnectionManager.releaseResource(ps, null);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
    }
    
    public ArrayList<ActivityVO>getActivities(int userNo){
        ArrayList<ActivityVO>activities=new ArrayList<ActivityVO>();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT *, hour(TIMEDIFF(sysdate(),time)) AS hour, minute(TIMEDIFF(sysdate(),time)) AS minute FROM activities WHERE ActivityOf=? order by ActivityNo desc");
            ps.setInt(1,userNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ActivityNo = rs.getInt("ActivityNo");
                String ActivityType = rs.getString("ActivityType");
                int ActivityBy = rs.getInt("ActivityBy");
                String Message = rs.getString("Message");
                String time = rs.getString("Time");
                int hour = rs.getInt("hour");
                int minute = rs.getInt("minute");
                ActivityVO activity = new ActivityVO(ActivityNo, ActivityType, ActivityBy, Message, time, hour, minute);
                activities.add(activity);
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return activities;
    }
    
    public boolean isFriend(int user, int friend){
        boolean status = false;
        if(user == friend)
            return true;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM friendList WHERE userNO=? AND friendNo=?");
            ps.setInt(1,user);
            ps.setInt(2,friend);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                status=true;
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return status;
    }
    
    public boolean isFriendRequested(int user, int friend){
        boolean status = false;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM friendRequest WHERE requestFor=? AND requestBy=?");
            ps.setInt(1,friend);
            ps.setInt(2,user);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                status=true;
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return status;
    }
    
    public void addFriendRequest(int requestFor,int requestBy, String message){
       try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO friendRequest (requestFor,requestBy,message) values(?,?,?)");
            ps.setInt(1,requestFor);
            ps.setInt(2,requestBy);
            ps.setString(3,message);
            ps.executeUpdate();
            ConnectionManager.releaseResource(ps, null);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        } 
    }
    public ArrayList<FriendRequestVO> getFriendRequest(int userNO){
       ArrayList<FriendRequestVO> list = new ArrayList<FriendRequestVO>();
       try {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM friendRequest WHERE requestFor=?");
            ps.setInt(1,userNO);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int requestNo=rs.getInt("SrNo");
                int requestBy=rs.getInt("requestBy");
                String requestByName=getFullName(requestBy);
                String message=rs.getString("message");
                FriendRequestVO friend = new FriendRequestVO(requestNo, requestBy, requestByName, message);
                list.add(friend);
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        } 
       return list;
    }
    
    public void acceptFriendRequest(int requestNo){
        int requestBy=0,requestFor=0;
        boolean proceed=false;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM friendRequest WHERE SrNo=?");
            ps.setInt(1,requestNo);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                requestFor=rs.getInt("requestFor");
                requestBy=rs.getInt("requestBy");
                proceed=true;
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
       if(proceed){
            try {
                PreparedStatement ps=con.prepareStatement("INSERT INTO friendList values(?,?)");
                ps.setInt(1,requestFor);
                ps.setInt(2,requestBy);
                ps.executeUpdate();
                ConnectionManager.releaseResource(ps, null);
            } catch (SQLException ex) {
                logger.severe(ex.toString());
            }
            try {
                PreparedStatement ps=con.prepareStatement("INSERT INTO friendList values(?,?)");
                ps.setInt(1,requestBy);
                ps.setInt(2,requestFor);
                ps.executeUpdate();
                ConnectionManager.releaseResource(ps, null);
            } catch (SQLException ex) {
                logger.severe(ex.toString());
            }
            try {
                PreparedStatement ps=con.prepareStatement("DELETE FROM friendRequest where SrNo=?");
                ps.setInt(1,requestNo);
                ps.executeUpdate();
                ConnectionManager.releaseResource(ps, null);
            } catch (SQLException ex) {
                logger.severe(ex.toString());
            }
       }
    }
    
    public void rejectFriendRequest(int requestNo){
        try {
            PreparedStatement ps=con.prepareStatement("DELETE FROM friendRequest where SrNo=?");
            ps.setInt(1,requestNo);
            ps.executeUpdate();
            ConnectionManager.releaseResource(ps, null);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
    }
    
    public ArrayList<Integer> search(String keyWord){
        ArrayList<Integer> users = new ArrayList<Integer>();
        try {
            PreparedStatement ps=con.prepareStatement("SELECT userNO FROM userMaster WHERE concat(firstName,' ',lastName) like ?");
            ps.setString(1,"%"+keyWord+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                users.add(rs.getInt("userNO"));
            ConnectionManager.releaseResource(ps, null);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return users;
    }
    
    public MiniDetailsVO getMiniDetails(int userNO){
        MiniDetailsVO vo=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT gender, FLOOR(DATEDIFF(SYSDATE(),dob)/365) AS age, DAY(dob) AS date, MONTHNAME(dob) AS month, email FROM usermaster WHERE userNo=?");
            ps.setInt(1,userNO);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String gender=rs.getString("gender");
                int age=rs.getInt("age");
                int date=rs.getInt("date");
                String month=rs.getString("month");
                String email=rs.getString("email");
                vo=new MiniDetailsVO(gender, age, date, month, email);
            }
            ConnectionManager.releaseResource(ps, null);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return vo;
    }
    
    public ContactDetailsVO getContactDetails(int userNO){
        ContactDetailsVO vo=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT mobile,city,state,country FROM userDetails WHERE userNo=?");
            ps.setInt(1,userNO);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String mobile=rs.getString("mobile");
                String city=rs.getString("city");
                String state=rs.getString("state");
                String country=rs.getString("country");
                vo=new ContactDetailsVO(mobile, city, state, country);
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return vo;
    }
    
    public PersonalDetailsVO getPersonalDetails(int userNO){
        PersonalDetailsVO vo=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT aboutMe,favMovie,favMusic,favBook,favQuote,favCuisine FROM userDetails WHERE userNo=?");
            ps.setInt(1,userNO);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String aboutMe=rs.getString("aboutMe");
                String favMovie=rs.getString("favMovie");
                String favMusic=rs.getString("favMusic");
                String favBook=rs.getString("favBook");
                String favQuote=rs.getString("favQuote");
                String favCuisine=rs.getString("favCuisine");
                vo=new PersonalDetailsVO(aboutMe, favMovie, favMusic, favBook, favQuote, favCuisine);
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return vo;
    }
    
    public ProDetailsVO getProfessionalDetails(int userNO){
        ProDetailsVO vo=null;
        try {
            PreparedStatement ps=con.prepareStatement("SELECT school,college,degree,occupation FROM userDetails WHERE userNo=?");
            ps.setInt(1, userNO);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String school=rs.getString("school");
                String college=rs.getString("college");
                String degree=rs.getString("degree");
                String occupation=rs.getString("occupation");
                vo=new ProDetailsVO(school, college, degree, occupation);
            }
            ConnectionManager.releaseResource(ps, rs);
        } catch (SQLException ex) {
            logger.severe(ex.toString());
        }
        return vo;
    }
}
