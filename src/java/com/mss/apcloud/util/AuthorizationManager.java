/*
 * AuthorizationManager.java
 *
 * Created on December 15, 2007, 7:42 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mss.apcloud.util;

/**
 *
 * @author miracle
 */
public class AuthorizationManager {
    
    public static AuthorizationManager _instance;
    
    /** Creates a new instance of AuthorizationManager */
    private AuthorizationManager() {
    }
    
    public static AuthorizationManager getInstance(){
        if(_instance == null){
            _instance = new AuthorizationManager();
        }
        return _instance;
    }
    
    public boolean isAuthorizedUser(String accessKey, int roleId){
        boolean isAuthorized = false;
       // System.err.print("roleId in  AUTH******---"+roleId);
        try{
            
            
            String authorizedRoleIds = SecurityProperties.getProperty(accessKey);
            String authorizedRoleIdsArray[] = authorizedRoleIds.split(",");
            for(int counter=0;counter < authorizedRoleIdsArray.length;counter++){
                if(roleId == Integer.parseInt(authorizedRoleIdsArray[counter])) isAuthorized = true;
            }
        }catch(Exception slex){
            
        }
        return isAuthorized;
    }
    
}
