/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.util.AppConstants;
import com.mss.apcloud.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Miracle
 */
public class PasswordAction extends ActionSupport implements ServletRequestAware {

    private String resultType;
    /*@param resulMessage used to store message to display on login page*/
    private String resultMessage;
    private String oldPassword;
    /*@param newPassword used to store new password of the employee*/
    private String newPassword;
    /*@param confirmPassword used to store confirmation password of the employee*/
    private String confirmPassword;
    private String emailId;
    private HttpServletRequest httpServletRequest;
    private String userId;
    public String execute() {
//        applicationDataProvider = applicationDataProvider.getInstance();
        try {
            resultType = INPUT;
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
                setResultMessage(getResultMessage());
                resultType = SUCCESS;
            }
        } catch (Exception ex) {
            //List errorMsgList = ExceptionToListUtility.errorMessages(ex);
            httpServletRequest.getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = ERROR;
        }
        return resultType;

    }//end of the resetPassword() method 

    public String resetPassword() throws Exception {
//        applicationDataProvider = applicationDataProvider.getInstance();
        try {
            resultType = INPUT;
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {

                try {
                    setEmailId(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL).toString());
                    int updatedRows = ServiceLocator.getGeneralService().updatePassword(this);
                    if (updatedRows == 1) {//isReset                         
                        getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class=\"row\"> <div class=\"alert alert-success\"  style=\"width: 580px;\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Congrats! You have changed your password succesfully ! </strong> </div></div>");
                        setResultMessage("<div class=\"row\"> <div class=\"alert alert-success\" style=\"width: 300px;\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Congrats! You have changed your password succesfully ! </strong> </div></div>");

                        resultType = SUCCESS;
                    } else {
                       // System.out.println("----in else------");
                        getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class=\"row\"> <div class=\"alert alert-danger\" style=\"width: 580px;\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Sorry! We are not able to change your password. Please enter valid password ! </strong> </div></div>");
                        setResultMessage("<div class=\"row\"> <div class=\"alert alert-danger\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Sorry! We are not able to change your password. Please enter valid password ! </strong> </div></div>");

                        resultType = INPUT;
                    }
                    httpServletRequest.setAttribute("resultMessage", resultMessage);
                    resultType = SUCCESS;

                } catch (Exception ex) {
                    //List errorMsgList = ExceptionToListUtility.errorMessages(ex);
                    httpServletRequest.getSession(false).setAttribute("errorMessage", ex.toString());
                    resultType = ERROR;
                }

            }//Closing Sessiong Checking
        } catch (Exception ex) {
            //List errorMsgList = ExceptionToListUtility.errorMessages(ex);
            httpServletRequest.getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = ERROR;
        }
        return resultType;

    }//end of the resetPassword() method

     //reset user password 
    public String resetUserPassword() throws Exception {
        System.out.println("----reset user pwd action---------");
        try {
            resultType = LOGIN;
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
                String resultMsg = ServiceLocator.getGeneralService().updateUserPassword(this);
                if ("updated".equals(resultMsg)) {//isReset                         
                    getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class=\"row\"> <div class=\"alert alert-success\"  style=\"width: 580px;\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Congrats! You have changed your password succesfully ! </strong> </div></div>");

                } else {
                    getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class=\"row\"> <div class=\"alert alert-danger\" style=\"width: 580px;\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>email not existed </strong> </div></div>");
                }
                resultType = SUCCESS;
            }
        } catch (Exception ex) {
            httpServletRequest.getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = ERROR;
        }
        return resultType;

    }//end of the resetuserPassword() method
    
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.setHttpServletRequest(httpServletRequest);
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}