
package com.app.dao;

import com.app.vo.ActivityVO;
import com.app.vo.ContactDetailsVO;
import com.app.vo.FriendRequestVO;
import com.app.vo.MiniDetailsVO;
import com.app.vo.PersonalDetailsVO;
import com.app.vo.ProDetailsVO;
import java.util.ArrayList;

public interface UserDAO {
    public int registerUser(String firstName,String lastName,String email,String password,String sex,String dob);
    public boolean loginUser(String username,String password);
    public int getUserNo(String username);
    public String getFullName(int userNo);
    public String getName(int userNo);
    public String getProfilePic(int userNo);
    public ArrayList<Integer> getFriendMainList(int userNo);
    public void updateStatus(int userNo, String status);
    public ArrayList<ActivityVO>getActivities(int userNo);
    public ArrayList<Integer> getFullFriendList(int userNo);
    public boolean isFriend(int user, int friend);
    public boolean isFriendRequested(int user, int friend);
    public void addFriendRequest(int requestFor,int requestBy, String message);
    public ArrayList<FriendRequestVO> getFriendRequest(int userNO);
    public void acceptFriendRequest(int requestNo);
    public void rejectFriendRequest(int requestNo);
    public ArrayList<Integer> search(String keyWord);
    public MiniDetailsVO getMiniDetails(int userNO);
    public ContactDetailsVO getContactDetails(int userNO);
    public PersonalDetailsVO getPersonalDetails(int userNO);
    public ProDetailsVO getProfessionalDetails(int userNO);
}
