/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.ajax;

import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.MailManager;
import com.mss.apcloud.util.PasswordUtility;
import com.mss.apcloud.util.ServiceLocator;
import com.mss.apcloud.util.ServiceLocatorException;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.mss.apcloud.util.AppConstants;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miracle
 */
public class AjaxHandlerAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private HttpServletRequest servletRequest;
    private HttpServletResponse servletResponse;
    private String email;
    private String phoneNumber;
    private int stateID;
    private int workshopId;
    private int topicId;
    private int userId;
    private String topicsList;
    private String inserType;
    private String collegeName;
    private String location;
    private String collegeCode;
    private String link;
    public String workshopDate;
    private String currcullamDate;
    private String durationTime;
    private String subTopic;
    private int currculamId;
    private String venue;

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public HttpServletResponse getServletResponse() {
        return servletResponse;
    }

    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public void userExistance() {
        System.out.println("gggggggggggg");
        System.out.println("--------->" + getEmail() + "    " + getPhoneNumber());
        String resultMsg = "";
        try {
            resultMsg = ServiceLocator.getAjaxHandlerService().userExistance(email, phoneNumber);
            System.out.println("---" + resultMsg);
            if (!resultMsg.equals("No data")) {
                servletResponse.setContentType("text");
                servletResponse.getWriter().write(resultMsg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServiceLocatorException se) {
            se.printStackTrace();
        }

    }
    //New method for setting districts based on state id

    public String getDistrictNames() {
        //System.out.println("gggggggggggg");
        System.out.println("--------->" + getStateID());
        try {
            /*
             *This if loop is to check whether there is Session or not
             **/

            String responseString = ServiceLocator.getAjaxHandlerService().getDistrictNames(getStateID());
            servletResponse.setContentType("text/xml");
            servletResponse.getWriter().write(responseString);
            //Close Session Checking
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private int collegeId;

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeCodes() throws ServiceLocatorException {
        try {
            /*
             *This if loop is to check whether there is Session or not
             **/
            //  if (httpServletRequest.getSession(false).getAttribute(ApplicationConstants.SESSION_USER_ID) != null) {
           // System.out.println("getCollegeCodes-->" + getCollegeId());
            String responseString = "";
            responseString = ServiceLocator.getAjaxHandlerService().getCollegeCodes(getCollegeId());
            servletResponse.setContentType("text/xml");
            servletResponse.getWriter().write(responseString);
        }//Close Session Checking
        catch (IOException ex) {
            ex.printStackTrace();
        }


        return null;
    }

    public String check() throws ServiceLocatorException {
        try {
            /*
             *This if loop is to check whether there is Session or not
             **/
            //  if (httpServletRequest.getSession(false).getAttribute(ApplicationConstants.SESSION_USER_ID) != null) {
            //System.out.println("getCollegeCodes-->" + getCollegeName());
            String responseString = "";
            responseString = ServiceLocator.getAjaxHandlerService().check(getCollegeName());
            servletResponse.setContentType("text/xml");
            servletResponse.getWriter().write(responseString);
        }//Close Session Checking
        catch (IOException ex) {
            ex.printStackTrace();
        }


        return null;
    }
    private String resultType;
    private String emailForPass;

    public String getEmailForPass() {
        return emailForPass;
    }

    public void setEmailForPass(String emailForPass) {
        this.emailForPass = emailForPass;
    }
    private String resultMessage = "";

    public String forgotPassword() throws Exception {
      //  System.out.println("---forgotPassword----");
        String email = getEmailForPass().trim();
        resultMessage = regetPwd(email);
      //  System.out.println("resultMessage  forgotPassword-->" + resultMessage);
        servletResponse.setContentType("text");
        servletResponse.getWriter().write(resultMessage);

        return null;
    }

    public String regetPwd(String emailId) throws ServiceLocatorException, SQLException {
      //  System.out.println("regetPwd-->" + emailId);
        boolean isReget = false;
        int count = 0;
        String queryString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String result = null;
        String resultMessage = "";
        DataSourceDataProvider dataSourceDataProvider = null;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.createStatement();
            String status = DataSourceDataProvider.getInstance().isEmailExists(emailId);
            //System.out.println("status-->" + status);
            if (!"nodata".equals(status)) {
                String name = DataSourceDataProvider.getInstance().getEmpNameByEmailId(emailId);
                String psw = generatePassword(4);
                PasswordUtility passwordUtility = new PasswordUtility();
                String psaw1 = passwordUtility.encryptPwd(psw);
                //System.out.println("psaw1-->" + psaw1);
                queryString = "UPDATE tblRegistrationDetails SET PASSWORD='" + psaw1 + "' WHERE Email='" + emailId + "'";
                statement = connection.createStatement();
                int updatedRows = statement.executeUpdate(queryString);
              //  System.out.println("updatedRows-->" + updatedRows);
                if (updatedRows > 0) {
                    forgotHubblePasswordSubmit(psaw1, emailId);

                    MailManager sendMail = new MailManager();
                   // System.out.println("sendResetPwd-->" + emailId + "  " + name + " " + psw);
                    int mailFlag = Integer.parseInt(com.mss.apcloud.util.Properties.getProperty("Mail.Flag"));
                    if (mailFlag == 1) {
                        resultMessage = sendMail.sendResetPwd(emailId, name, psw);
                        if (resultMessage.equalsIgnoreCase("MailSent")) {
                            resultMessage = "mailsend";
                        } else {
                            //   resultMessage = "Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id.";
                            resultMessage = "TryAgain";
                            //getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE1, "<font color=\"red\" size=\"2.5\">Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id. </font>");
                        }
                    }
                } else {
                    resultMessage = "databaseException";
                }

            } else {
                resultMessage = "nouserexisted";
            }
        } catch (SQLException se) {
            resultMessage = "databaseException";
        }finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return resultMessage;
    }

    public String forgotHubblePasswordSubmit(String pwd, String mailId) throws ServiceLocatorException, SQLException {

       // System.out.println("forgotHubblePasswordSubmit-pwd->" + pwd + "-->mail-->" + mailId);


        String queryString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String resultMessage = "";


        try {
            connection = ConnectionProvider.getInstance().getHubbleDbConnection();

            statement = connection.createStatement();

            queryString = "UPDATE tblMcertConsultant SET PASSWORD='" + pwd + "' WHERE Email='" + mailId + "'";
           // System.out.println("queryString-in--forgotHubblePasswordSubmit--->" + queryString);
            // System.out.println("----------Email---------"+mailId);
            //  System.out.println("----------pwd---------"+pwd);
            statement = connection.createStatement();
            int updatedRows = statement.executeUpdate(queryString);
         //   System.out.println("updatedRows-->" + updatedRows);
            if (updatedRows > 0) {
                resultMessage = "updated";
                //System.out.println("resultMessage-->" + resultMessage);

            }


        } catch (SQLException se) {
            resultMessage = "databaseException";
        }finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return resultMessage;


    }

    public String generatePassword(int noOfCharacters) {

        /*@param generatedPwd used to store String*/
        String generatedPwd = "";

        int randInt;

        /**
         *Random() method Creates a new random number generator
         *currentTimeMillis() method Returns the current value of the most precise available system
         *timer, in nanoseconds.
         */
        Random random = new Random(System.currentTimeMillis());

        /*
         *the next pseudorandom, uniformly distributed value from this random number generator's sequence.
         *and that is stored in randomOne and randomTwo
         */
        long randomOne = random.nextLong();
        long randomTwo = random.nextLong();

        /**
         *toHexString() method return the string representation of the unsigned
         *value represented by the argument in hexadecimal
         *that String stored in hashCodeOne and hashCodeTwo
         */
        String hashCodeOne = Long.toHexString(randomOne);
        String hashCodeTwo = Long.toHexString(randomTwo);

        /*@param generatedPwd used to store concatinate string of hashCodeOne and hashCodeTwo*/
        generatedPwd = hashCodeOne + hashCodeTwo;

        if (generatedPwd.length() > noOfCharacters) {
            generatedPwd = generatedPwd.substring(0, noOfCharacters);
        }

        return generatedPwd.toUpperCase();
    }
    private int topicValue;
    private String topicName;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getTopicValue() {
        return topicValue;
    }

    public void setTopicValue(int topicValue) {
        this.topicValue = topicValue;
    }

    public void getRepoData() {
        String resultMsg = "";
      //  System.out.println("repo");
        if (servletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                resultMsg = ServiceLocator.getAjaxHandlerService().getRepoData(getTopicValue(), getTopicName());
              //  System.out.println("---" + resultMsg);
                if (!resultMsg.equals("No data")) {
                    servletResponse.setContentType("text");
                    servletResponse.getWriter().write(resultMsg);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ServiceLocatorException se) {
                se.printStackTrace();
            }
        }
    }
    private String fileId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void getDocumentfile() throws ServiceLocatorException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String fileName = "";
        String filePath = "";
        if (servletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                filePath = DataSourceDataProvider.getInstance().getDocumentfile(getFileId());
               // fileName = filePath.split("/")[(filePath.split("/").length) - 1];
              //  System.out.println("fileName--" + fileName);
                servletResponse.setContentType("application/force-download");
                File file = new File(filePath);
                fileName = file.getName();
                inputStream = new FileInputStream(file.getAbsolutePath());
                outputStream = servletResponse.getOutputStream();

                if (outputStream == null) {
                } else {

                    servletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                    int noOfBytesRead = 0;
                    byte[] byteArray = null;

                    while (true) {
                        byteArray = new byte[1024];
                        noOfBytesRead = inputStream.read(byteArray);
                        if (noOfBytesRead == -1) {
                            break;
                        }
                        outputStream.write(byteArray, 0, noOfBytesRead);

                    }
                    inputStream.close();
                    outputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       // return SUCCESS;
    }
    private String workshopCode;

    public void getCurriculam() {
        String resultMsg = "";
      //  System.out.println("getCurriculam" + workshopCode);

        try {
            resultMsg = ServiceLocator.getAjaxHandlerService().getCurriculam(workshopCode);
          //  System.out.println("---" + resultMsg);
            if (!resultMsg.equals("No data")) {
                servletResponse.setContentType("text");
                servletResponse.getWriter().write(resultMsg);
            }
        } catch (IOException ex) {
            Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceLocatorException ex) {
            Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getCollegeCoordinators() {
        String resultMsg = "";
       // System.out.println("getCurriculam" + collegeId);

        try {
            resultMsg = ServiceLocator.getAjaxHandlerService().getCollegeCoordinators(collegeId);
          //  System.out.println("---" + resultMsg);
            servletResponse.setContentType("text");
            if (!resultMsg.equals("No data")) {

                servletResponse.getWriter().write(resultMsg);
            } else {
                servletResponse.getWriter().write(resultMsg);
            }
        } catch (IOException ex) {
            Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceLocatorException ex) {
            Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getTechTopicsData() {
       // System.out.println("getTechTopicsData");
        String resultMsg;
        try {
            resultMsg = ServiceLocator.getAjaxHandlerService().getTechTopicData();

            if (!resultMsg.equals("No data")) {
                servletResponse.setContentType("text");
                servletResponse.getWriter().write(resultMsg);
            }
        } catch (IOException ex) {
            Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
        }

    }

    //getExamResultsByTopicId
    public String getExamResultsByTopicId() {
        /*
         *This if loop is to check whether there is Session or not
         **/

        try {
            String responseString = ServiceLocator.getAjaxHandlerService().getExamResultsByTopicId(String.valueOf(getUserId()), String.valueOf(getTopicId()));

          //  System.out.println("responseString-->" + responseString);
            servletResponse.setContentType("text");
            servletResponse.getWriter().write(responseString);
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void enrollTechTopic() {
        String resultMsg = "";
        HttpSession session = servletRequest.getSession(false);
        String workshopIds = "";
        String enrolledTopics = "";

        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                //email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();

                userId = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());
               // System.out.println("topicsList topics --->" + topicsList + "----->" + inserType + "---wscod--" + workshopCode + "--user--" + userId);
                resultMsg = ServiceLocator.getAjaxHandlerService().enrollTechTopic(getTopicsList(), userId + "", inserType, workshopCode);
                if (resultMsg.equals("success")) {
                    if (!"".equals(enrolledTopics)) {
                        enrolledTopics += "," + getTopicId();
                    } else {
                        enrolledTopics += getTopicId();
                    }
                    //                    session.setAttribute(AppConstants.SESSION_ENROLLTOPICS, enrolledTopics );
                    servletResponse.setContentType("text");
                    servletResponse.getWriter().write(resultMsg);



                }


            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                //  Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public void getEnrolledTopicsList() {
        String resultMsg = "";
        HttpSession session = servletRequest.getSession(false);
        String workshopIds = "";
        String enrolledTopics = "";

        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                //email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();

                userId = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());
               // System.out.println("topicsList topics --->" + topicsList + "----->" + inserType + "---wscod--" + workshopCode + "--user--" + userId);
                resultMsg = ServiceLocator.getAjaxHandlerService().getEnrolledTopicsList(userId + "", workshopCode);

                if (!resultMsg.equals("No data")) {
                    servletResponse.setContentType("text");
                    servletResponse.getWriter().write(resultMsg);
                }






            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                //  Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public String generateCode(int noOfCharacters) {

        /*@param generatedPwd used to store String*/
        String generateCode = "";

        int randInt;

        /**
         *Random() method Creates a new random number generator
         *currentTimeMillis() method Returns the current value of the most precise available system
         *timer, in nanoseconds.
         */
        Random random = new Random(System.currentTimeMillis());

        /*
         *the next pseudorandom, uniformly distributed value from this random number generator's sequence.
         *and that is stored in randomOne and randomTwo
         */
        long randomOne = random.nextLong();
        long randomTwo = random.nextLong();

        /**
         *toHexString() method return the string representation of the unsigned
         *value represented by the argument in hexadecimal
         *that String stored in hashCodeOne and hashCodeTwo
         */
        String hashCodeOne = Long.toHexString(randomOne);
        String hashCodeTwo = Long.toHexString(randomTwo);

        /*@param generatedPwd used to store concatinate string of hashCodeOne and hashCodeTwo*/
        generateCode = hashCodeOne + hashCodeTwo;

        if (generateCode.length() > noOfCharacters) {
            generateCode = generateCode.substring(0, noOfCharacters);
        }

        return generateCode.toUpperCase();
    }

    public void editCollegeDet() {
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                String code = generateCode(6);
                ServiceLocator.getAjaxHandlerService().editCollegeDet(getCollegeCode(), getCollegeName(), getLocation(), getLink(), email);
                servletResponse.setContentType("text");
                servletResponse.getWriter().write("success");

            } catch (Exception ex) {
            }
        }

    }

    public void getAddCollegeDet() {
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
             String code = "";
            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                 String isColExist = DataSourceDataProvider.getInstance().isCollegeCodeExistedOrNot(getCollegeCode().trim());
              // System.out.println("isColExist-->" + isColExist);
                if (isColExist == "notexist") {
                  code = generateCode(6);
               // ServiceLocator.getAjaxHandlerService().getAddCollegeDet(getCollegeCode(), getCollegeName(), code, getLocation(), getLink(), email);
                    ServiceLocator.getAjaxHandlerService().getAddCollegeDet(getCollegeCode(), getCollegeName(), code, getLocation(), getLink(), email);
                
                } else {
                    code = "AlreadyExists";
                }

                servletResponse.setContentType("text");
                servletResponse.getWriter().write(code);


            } catch (Exception ex) {
            }
        }



    }

    public void getEnrollCollegeCoordinators() {
        String resultMsg = "";
        // System.out.println("getEnrollCollegeCoordinators----------------------"+collegeId);

        try {
            resultMsg = ServiceLocator.getAjaxHandlerService().getEnrollCollegeCoordinators(collegeId);
            //  System.out.println("------------------getEnrollCollegeCoordinators---------------" + resultMsg);
            servletResponse.setContentType("text");
            servletResponse.getWriter().write(resultMsg);
        } catch (Exception ex) {
        }

    }
    private int workshopType;

    public int getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(int workshopType) {
        this.workshopType = workshopType;
    }
    public void addWorkshop() {
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();


                String response = ServiceLocator.getAjaxHandlerService().addWorkshop(getCollegeName(), getWorkshopDate(), getLocation(), email,getWorkshopType());


                servletResponse.setContentType("text");
                if (response.equals("success")) {
                    servletResponse.getWriter().write("<div class=\"alert alert-success\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Workshop added successfully</strong></div>");
                } else {
                    servletResponse.getWriter().write("<div class=\"alert alert-danger\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Please try Latter</strong></div>");
                }



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public void updateWorkshop() {
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();


                String response = ServiceLocator.getAjaxHandlerService().updateWorkshop(workshopCode, getWorkshopDate(), getLocation(), email);


                servletResponse.setContentType("text");
                if (response.equals("success")) {
                    servletResponse.getWriter().write("<div class=\"alert alert-success\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Workshop updated successfully</strong></div>");
                } else {
                    servletResponse.getWriter().write("<div class=\"alert alert-danger\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Please try Latter</strong></div>");
                }



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addCurrculumData() {
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();


                String response = ServiceLocator.getAjaxHandlerService().addCurrculumData(getCurrcullamDate(), getTopicId(), getDurationTime(), getSubTopic(), email, getWorkshopCode(), venue);


                servletResponse.setContentType("text");
                //servletResponse.getWriter().write(response);
                if (response.equals("success")) {
                    servletResponse.getWriter().write("<div class=\"alert alert-success\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Currculum added successfully</strong></div>");
                } else {
                    servletResponse.getWriter().write("<div class=\"alert alert-danger\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Please try Latter</strong></div>");
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateCurrculumData() {
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            try {
                this.email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();


                String response = ServiceLocator.getAjaxHandlerService().updateCurrculumData(this);


                servletResponse.setContentType("text");
                if (response.equals("success")) {
                    servletResponse.getWriter().write("<div class=\"alert alert-success\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Currculum updated successfully</strong></div>");
                } else {
                    servletResponse.getWriter().write("<div class=\"alert alert-danger\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Please try Latter</strong></div>");
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void getWorkshopCodeByCollegeName() {
       // System.out.println("getWorkshopCodeByCollegeName-->");
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();

                String code = ServiceLocator.getAjaxHandlerService().getWorkshopCodeByCollegeName(getCollegeId());


                servletResponse.setContentType("text");
                servletResponse.getWriter().write(code);


            } catch (Exception ex) {
            }
        }



    }

    public void getEnrolledWorkshopandTopics() {
        String resultMsg = "";
        HttpSession session = servletRequest.getSession(false);
        //System.out.println("getEnrolledWorkshopandTopics" + userId);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            try {
                resultMsg = ServiceLocator.getAjaxHandlerService().getEnrolledWorkshopandTopics(userId);
                System.out.println("---" + resultMsg);
                if (!resultMsg.equals("No data")) {
                    servletResponse.setContentType("text");
                    servletResponse.getWriter().write(resultMsg);
                }


            } catch (Exception ex) {
            }
        }

    }
    //edit coach details
    private String name;
    private String title;
    private String companyName;
    private String areaOfExpertise;
    private String status;
    private int id;
    private String coachemail;

    public void editCoachDetils() {
        String resultMessage = "";
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString(); 
                // String code = generateCode(6);
                resultMessage = ServiceLocator.getAjaxHandlerService().editCoachDetils(getId(), getName(),getCoachemail() ,getPhoneNumber(),getTitle(), getCompanyName(), getAreaOfExpertise(), getStatus(), email);
                if ("success".equalsIgnoreCase(resultMessage)) {
                    resultMessage = "Successfully Updated";
                } else {
                    resultMessage = "Please Try Again";
                }

                servletResponse.setContentType("text");
                servletResponse.getWriter().write(resultMessage);

            } catch (Exception ex) {
            }
        }

    }
    //get add coach details
    private String existingCompanyName;

    public void getAddCoachDet() {
      //  System.out.println("--getAddCoachDet-----");
        int updatedRows = 0;
        HttpSession session = servletRequest.getSession(false);


        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            String resultMessage = "";

            try {
                String email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                String userExist = ServiceLocator.getGeneralService().userExistanceInCoachDet(getEmail(), getPhoneNumber());
                if (userExist.equals("noteixst")) {
                    //String code = generateCode(6);
                    resultMessage = ServiceLocator.getAjaxHandlerService().getAddCoachDet(getName(), getEmail(), getTitle(), getExistingCompanyName(), getPhoneNumber(), getAreaOfExpertise(), getStatus());

                    if ("success".equals(resultMessage)) {
                        resultMessage = "success";//Successfully added
                    } else {
                        resultMessage = "failure";//Something went wrong
                    }
                } else {
                    resultMessage = "exist";//Already Email or Phone exist
                }

                servletResponse.setContentType("text");
                servletResponse.getWriter().write(resultMessage);
                //Overlay lo emani ravali? success anena??S?U???successfully added
                //servletResponse.getWriter().write(code);


            } catch (Exception ex) {
            }
        }



    }

    public int getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(int workshopId) {
        this.workshopId = workshopId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getWorkshopCode() {
        return workshopCode;
    }

    public void setWorkshopCode(String workshopCode) {
        this.workshopCode = workshopCode;
    }

    /**
     * @return the topicId
     */
    public int getTopicId() {
        return topicId;
    }

    /**
     * @param topicId the topicId to set
     */
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getInserType() {
        return inserType;
    }

    public void setInserType(String inserType) {
        this.inserType = inserType;
    }

    public String getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(String topicsList) {
        this.topicsList = topicsList;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the collegeCode
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * @param collegeCode the collegeCode to set
     */
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    public String getWorkshopDate() {
        return workshopDate;
    }

    public void setWorkshopDate(String workshopDate) {
        this.workshopDate = workshopDate;
    }

    public String getCurrcullamDate() {
        return currcullamDate;
    }

    public void setCurrcullamDate(String currcullamDate) {
        this.currcullamDate = currcullamDate;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }

    public int getCurrculamId() {
        return currculamId;
    }

    public void setCurrculamId(int currculamId) {
        this.currculamId = currculamId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the areaOfExpertise
     */
    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    /**
     * @param areaOfExpertise the areaOfExpertise to set
     */
    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the existingCompanyName
     */
    public String getExistingCompanyName() {
        return existingCompanyName;
    }

    /**
     * @param existingCompanyName the existingCompanyName to set
     */
    public void setExistingCompanyName(String existingCompanyName) {
        this.existingCompanyName = existingCompanyName;
    }

    public String getCoachemail() {
        return coachemail;
    }

    public void setCoachemail(String coachemail) {
        this.coachemail = coachemail;
    }
    
    
}
