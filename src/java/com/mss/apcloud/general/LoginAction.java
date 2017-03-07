 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.util.AppConstants;
import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.DateUtility;
import com.mss.apcloud.util.PasswordUtility;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.regex.Pattern;

/**
 *
 * @author miracle
 */
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private PasswordUtility passwordUtility;
    private String emailid;
    private String password;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private HttpSession httpSession;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    private String resultType;
    private Timestamp createdtime;
    private String resultMessage = "";
    private String Email;
    private String emailForPass;
    private String workshopId;
    private String dbId;

    public String logincheck() throws Exception {
        resultType = "accessFailed";
        //System.out.println("haiiieee");
        passwordUtility = new PasswordUtility();
        String dbPassword = "";
        String dbEmail = "";
        String dbUsername = "";
        String dbenrollworkshopIds = "";
        String dbPhoneNumber = "";
        String dbCollege = "";
        String dbCollegeID = "";
        String dbProfessionType = "";

        String dbCompanyName = "";
        String dbSalary = "";
        String dbFirstName = "";
        String dbLastName = "";


       // System.out.println("getEmailid-->" + getEmailid());
       // System.out.println("getPassword-->" + getPassword());
        CallableStatement callableStatement = null;
        try {
           // System.out.println("--In try--");
            connection = ConnectionProvider.getInstance().getConnection();

            HttpSession session = getHttpServletRequest().getSession(true);
            // System.out.println("connection-->" + connection);
            if (connection != null) {
                if (getEmailid() != null && getPassword() != null) {
                    callableStatement = connection.prepareCall("{CALL spLogin2(?,?)}");
                    callableStatement.setString(1, getEmailid());
                    callableStatement.registerOutParameter(2, Types.VARCHAR);
                    callableStatement.execute();
                    String outPutString = callableStatement.getString(2);
                    // System.out.println("outPutString---->"+outPutString);
                    // updatedRows1 ee@gmail.com|firts|second String s[]=updatedRows1.split("\\|");

                    //connection = ConnectionProvider.getInstance().getConnection();

                    if (!"nouser".equals(outPutString)) {
//                        String str[] = outPutString.split("\\^");
                        String str[] = outPutString.split(Pattern.quote("^"));
                        dbId = str[0];
                        dbEmail = str[1];
                        dbUsername = str[2] + " " + str[3];
                        dbFirstName = str[2];
                        dbLastName = str[3];

                        dbPassword = str[4];
                        dbPhoneNumber = str[5];
                        dbCollege = str[6];
                        dbCollegeID = str[7];
                        dbProfessionType = str[8];
                        
                        dbCompanyName = str[11];
                        dbSalary = str[12];

                        if (str.length >= 10) {
                            // System.out.println("--length--" + str.length + "-----" + str[4]);
                            if (str[9] != null && !"".equals(str[9])) {
                                // System.out.println("---In ifffff for topics ids--"+str[9]);

                                session.setAttribute(AppConstants.SESSION_ENROLLTOPICS, str[9]);

                            }
                            if (str.length >= 11) {
                                //  System.out.println("---In ifffff for workshop ids--");
                                dbenrollworkshopIds = str[10];
                                session.setAttribute(AppConstants.SESSION_ENROLLWORKSHOPID, dbenrollworkshopIds);
                            }
                        }
                        /*  if (str.length >= 12) {
                        // System.out.println("--length--" + str.length + "-----" + str[4]);
                        if (str[11] != null && !"".equals(str[11])) {
                        // System.out.println("---In ifffff for topics ids--"+str[9]);
                        
                        session.setAttribute(AppConstants.SESSION_ENROLLTOPICS, str[11]);
                        
                        }
                        if (str.length >= 13) {
                        //  System.out.println("---In ifffff for workshop ids--");
                        dbenrollworkshopIds = str[12];
                        session.setAttribute(AppConstants.SESSION_ENROLLWORKSHOPID, dbenrollworkshopIds);
                        }
                        }*/
                        //  System.out.println("dbEmail-------->"+dbEmail+" "+dbUsername+" "+dbPassword);
                        String decPassword = passwordUtility.decryptPwd(dbPassword);
                        // System.out.println("decPassword-->" + decPassword);
                        if (decPassword.equalsIgnoreCase(getPassword().trim()) && dbEmail.equalsIgnoreCase(getEmailid().trim())) {
                            //  System.out.println("--DecPassword--" + decPassword + "     " + dbEmail);
                            //   session.setAttribute(AppConstants.SESSION_PASSWORD, dbPassword);
                            session.setAttribute(AppConstants.SESSION_ID, dbId);
                            session.setAttribute(AppConstants.SESSION_EMAIL, dbEmail);
                            session.setAttribute(AppConstants.SESSION_DBUSERNAME, dbUsername);
                          //  System.out.println("username----" + dbUsername);
                            session.setAttribute(AppConstants.SESSION_PHONENUM, dbPhoneNumber);
                            session.setAttribute(AppConstants.SESSION_COLLEGE, dbCollege);
                            session.setAttribute(AppConstants.SESSION_COLLEGEID, dbCollegeID);
                            session.setAttribute(AppConstants.SESSION_PROFESSION_TYPE, dbProfessionType);
                          //  System.out.println("dbCompanyName-->in login action-->" + dbCompanyName);
                          //  System.out.println("dbSalary-->in login action-->" + dbSalary);
                            session.setAttribute(AppConstants.SESSION_COMPANYNAME, dbCompanyName);
                            session.setAttribute(AppConstants.SESSION_SALARY, dbSalary);
                            session.setAttribute(AppConstants.SESSION_FIRSTNAME, dbFirstName);
                          //  System.out.println("firstname-***********---" + dbFirstName);
                            session.setAttribute(AppConstants.SESSION_LASTNAME, dbLastName);
                           // System.out.println("lastname--************--" + dbLastName);
                            logUserAccess();

                            //    System.out.println("resultType-->" + resultType);
                            if (getWorkshopId() != null && !"".equals(getWorkshopId())) {
                                //   System.out.println("-----inif-----0000000000000-"+getWorkshopId());
                                resultType = "workshop";
                            } else {
                                resultType = SUCCESS;
                            }

                            // System.out.println("---aftetr success--");
                        } else {
                            //   setResultMessage("Please Login with valid UserId and Password! ");
                            //   System.out.println("sdfdsfsf-->"+getResultMessage());
                            //    getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<font color=\"red\" size=\"2.5\">Please Login with valid UserId and Password! </font>");
                            getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-danger'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"red\" size=\"3.5\">Please Login with valid UserId and Password! </font></div>");
                            // servletRequest.setAttribute(AppConstants.RESULT_MESSAGE,"<font style='color:green;font-weight:bold;font-size:14px;'>Details Inserted Successfully</font>");
                            //  getHttpServletRequest().setAttribute("errorMessage", "<font color=\"red\" size=\"1.5\">Please Login with valid UserId and Password! </font>");
                            resultType = INPUT;
                        }


                    } else {
                        // System.out.println("---if count 0---");
                        //  getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<font color=\"red\" size=\"2.5\">Please Check Your EmailId</font>");
                        getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-danger'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"red\" size=\"3.5\">Please Check Your EmailId! </font></div>");
                        resultType = INPUT;
                    }



                } else {
                    // System.out.println("---if connection doesnt exists---");
                    // setResultMessage("Please Try Again Later! ");
                    //   getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<font color=\"red\" size=\"2.5\">Please Try Again Later! </font>");
                   // getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-danger'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"red\" size=\"3.5\">Please Try Again Later!</font></div>");

                    resultType = INPUT;
                }
            }
        } catch (Exception ex) {

            //  System.out.println("--In catch --");
            ex.printStackTrace();
            resultMessage = "Please Try Again Later! ";
            // getHttpServletRequest().getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = INPUT;
        } finally {
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
            } catch (SQLException sqle) {
                throw new Exception(sqle);
            }
        }

        //  System.out.println("resultType-->" + resultType);
        return resultType;

    }

    public void logUserAccess() throws Exception {
        //  System.out.println("---logUserAccess---");
        try {
            if (getHttpServletRequest().getSession(false) != null) {
                String Email = getHttpServletRequest().getSession(false).getAttribute(AppConstants.SESSION_EMAIL).toString();
                // System.out.println("Email-->" + Email);
                String forwarded = httpServletRequest.getHeader("X-FORWARDED-FOR");
                String via = httpServletRequest.getHeader("VIA");
                String remote = httpServletRequest.getRemoteAddr();
                String agent = httpServletRequest.getHeader("User-Agent");
                Timestamp accessedtime = (DateUtility.getInstance().getCurrentMySqlDateTime());
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                boolean isInserted = false;
                String query = null;
                try {
                    connection = ConnectionProvider.getInstance().getConnection();
                    query = "insert into tblLogUserAccess(LoginId,X_FORWARDED_FOR1,VIA, REMOTE_ADDR,User_Agent,DateAccessed) values(?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, Email);
                    preparedStatement.setString(2, forwarded);
                    preparedStatement.setString(3, via);
                    preparedStatement.setString(4, remote);
                    preparedStatement.setString(5, agent);
                    preparedStatement.setTimestamp(6, accessedtime);
                    int x = preparedStatement.executeUpdate();
                    preparedStatement.close();
                    if (x > 0) {
                        isInserted = true;
                    }
                } catch (SQLException sql) {
                    sql.printStackTrace();
                    // throw new ServiceLocatorException(sql);
                } finally {
                    try {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                            preparedStatement = null;
                        }
                        if (connection != null) {
                            connection.close();
                            connection = null;
                        }
                    } catch (SQLException sqle) {
                        //    throw new ServiceLocatorException(sqle);
                    }
                }


            }
        } catch (Exception ex) {
            //List errorMsgList = ExceptionToListUtility.errorMessages(ex);
            ex.printStackTrace();
            getHttpServletRequest().getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = INPUT;
        }
        //   return resultType;
    }

//     public String forgotPassword() throws Exception 
//     {
//         resultType = SUCCESS;
//         System.out.println("---forgotPassword----");
//         System.out.println("get email-->"+getEmailForPass());
//         System.out.println("req attr-->"+getHttpServletRequest().getAttribute("emailForPass").toString());         
//         return resultType;
//          }
    /**
     *doLogout() method is used to invalidate session
     */
    public String doLogout() throws Exception {
        //  System.out.println("Employee Logout");
        try {
            if (getHttpServletRequest().getSession(false) != null) {
                getHttpServletRequest().getSession(false).invalidate();


            }
            resultType = SUCCESS;
        } catch (Exception ex) {
            //List errorMsgList = ExceptionToListUtility.errorMessages(ex);
            getHttpServletRequest().getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = ERROR;
        }
        return resultType;
    }

    public String getDashboard() {
        //  System.out.println("----sessionvalidate----");
        resultType = INPUT;
        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
                resultType = SUCCESS;
            }




        } catch (Exception ex) {
            //List errorMsgList = ExceptionToListUtility.errorMessages(ex);
            getHttpServletRequest().getSession(false).setAttribute("errorMessage", ex.toString());
            resultType = INPUT;
        }
        return resultType;
    }

    /*  public String regLogin(){
    // System.out.println("----regLogin----");
    getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, getResultMessage());
    return SUCCESS;
    }*/
    public String regLogin() {
        // System.out.println("----regLogin----");
        //  System.out.println("getResultMessage-->" + getResultMessage());
        if (getResultMessage().equals("success")) {
            getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-success'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"green\" size=\"3.5\">Successfully Registered </font></div>");
        }
        // getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-success'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color='green' size='4.5'>Successfully Registered</font><div>");
        return SUCCESS;
    }

    /**
     * @return the httpServletRequest
     */
    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    /**
     * @param httpServletRequest the httpServletRequest to set
     */
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * @return the httpServletResponse
     */
    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    /**
     * @param httpServletResponse the httpServletResponse to set
     */
    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.setHttpServletRequest(httpServletRequest);
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
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
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the emailForPass
     */
    public String getEmailForPass() {
        return emailForPass;
    }

    /**
     * @param emailForPass the emailForPass to set
     */
    public void setEmailForPass(String emailForPass) {
        this.emailForPass = emailForPass;
    }

    /**
     * @return the emailid
     */
    public String getEmailid() {
        return emailid;
    }

    /**
     * @param emailid the emailid to set
     */
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the workshopId
     */
    public String getWorkshopId() {
        return workshopId;
    }

    /**
     * @param workshopId the workshopId to set
     */
    public void setWorkshopId(String workshopId) {
        this.workshopId = workshopId;
    }

    /**
     * @return the dbId
     */
    public String getDbId() {
        return dbId;
    }

    /**
     * @param dbId the dbId to set
     */
    public void setDbId(String dbId) {
        this.dbId = dbId;
    }
    /**
     * @return the Email
     */
}
