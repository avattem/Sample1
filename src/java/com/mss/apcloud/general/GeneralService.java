/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.general.RegistrationAction;
import com.mss.apcloud.util.*;
import java.util.List;

/**
 *
 * @author miracle
 */
public interface GeneralService {

    public String insertRegDetails(RegistrationAction registrationAction) throws ServiceLocatorException;

    public String userExistance(String email, String phone) throws ServiceLocatorException;

    public String enrollCollegeDetails(RegistrationAction registrationAction) throws ServiceLocatorException;

    public String collegeExistance(String college) throws ServiceLocatorException;

    public int insertHubbleRegDetails(RegistrationAction registrationAction) throws ServiceLocatorException;

    public int updatePassword(PasswordAction passwordAction) throws ServiceLocatorException;

    public List enrollDetailsSearch(RegistrationAction registrationAction, String query) throws ServiceLocatorException;

    public String excelSheetForRegistratioDetails(RegistrationAction registrationAction, String queryString) throws ServiceLocatorException;
     public int insertRegisterCoachDetails(RegistrationAction registrationAction) throws ServiceLocatorException;
    public String userExistanceInCoachDet(String email, String phone) throws ServiceLocatorException;
    
     //reset user password
    public String updateUserPassword(PasswordAction passwordAction) throws ServiceLocatorException;
    
    //edit for registration details
     public GeneralVTO editRegidtrationDetails(RegistrationAction registrationAction, String query) throws ServiceLocatorException;
     
     //updating registration details
    public String updateRegistrationDetails(RegistrationAction registrationAction) throws ServiceLocatorException;
    
}
