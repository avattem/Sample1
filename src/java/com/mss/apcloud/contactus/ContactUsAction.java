/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.contactus;

import com.mss.apcloud.util.ServiceLocator;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author miracle
 */
public class ContactUsAction extends ActionSupport  implements ServletRequestAware{
     private HttpServletRequest servletRequest;
      private String resultType;
      private String resultMessage;
      private String fname;
      private String lname;
      private String phone;
      private String description;
      private String email;
       private String category;
      private String organization;
      private String designation;
     
     
     public String insertContactUsData() {
        String resultMessage = "";
//        System.out.println("here insert ........." + this.firstname);
//        try {
//            String userExist = ServiceLocator.getGeneralService().userExistance(getEmail(), getWorkPhone());
//            if (userExist.equals("noteixst")) {
//
//             /*   if (!"".equals(getCollegeIdHidden())) {
//
//                 //   System.out.println("-----inif-----0000000000000-" + getCollegeIdHidden());
//                    setFrmCollege(getCollegeIdHidden());
//                }  */
//
//
//                resultMessage = ServiceLocator.getGeneralService().insertRegDetails(this);
//                if (resultMessage.equals("success")) {
//                    ServiceLocator.getGeneralService().insertHubbleRegDetails(this);
//
//                    setId(1);
//                    setResultMessage("success");
//                    // setResultMessage( "<font style='color:green;font-weight:bold;font-size:14px;'>Details added Successfully</font>");
//
//
//
//                    System.out.println("getCollegeIdHidden-->" + getCollegeIdHidden());
//                    if (getCollegeIdHidden() != null) {
//
//                        System.out.println("-----inif-----0000000000000-" + getCollegeIdHidden());
//                        setResultMessage("regLogin");
//                    }
//                }
//                resultType = SUCCESS;
//            } else {
//
//                setId(1);
//                setResultMessage("email");
//                //    setResultMessage( "<font style='color:red;font-weight:bold;font-size:14px;'>Email or phone number alredy exist</font>");
//
//                //servletRequest.getSession(true).setAttribute(AppConstants.RESULT_MESSAGE, "<font style='color:red;font-weight:bold;font-size:14px;'>Email or phone number alredy exist</font>");
//                resultType = SUCCESS;
//
//            }
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultType = ERROR;
//
//        }
        return SUCCESS;
    }
         public String doAddContactUsData() {
         setResultType(LOGIN);
                try {                  
                   setResultMessage(ServiceLocator.getContactUsService().addContactUsData(this));
                    setResultType(SUCCESS);
                } catch (Exception ex) {
                    setResultType(ERROR);
                }
          
      
        return getResultType();
    }
    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    /**
     * @return the resultType
     */
    public String getResultType() {
        return resultType;
    }

    /**
     * @param resultType the resultType to set
     */
    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    /**
     * @return the resultMessage
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * @param resultMessage the resultMessage to set
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

  
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the eMail
     */
   

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
}
