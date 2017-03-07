/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.util.AppConstants;
import com.mss.apcloud.util.AuthorizationManager;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.DateUtility;
import com.mss.apcloud.util.ServiceLocator;
import com.mss.apcloud.util.ServiceLocatorException;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author miracle
 */
public class RegistrationAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private HttpServletRequest servletRequest;
    private HttpServletResponse httpServletResponse;
    private String firstname;
    private String lastname;
    private String email;
    private String workPhone;
    private String password;
    private String retypePassword;
    private String profession;
    private String branch;
    private String year;
    private String frmCollege;
    private String street;
    private String city;
    private String district;
    private String state;
    private String zipcode;
    private String collegeName;
    private String collegeid;
    private String location;
    private String principalName;
    private String principalPhoneNumber;
    private String principalEmail;
    private String facultyambassadorName;
    private String facultyambassadorPhoneNumber;
    private String facultyambassadorEmail;
    private String studentname;
    private String studentPhoneNumber;
    private String studentEmail;
    private String studentname1;
    private String studentPhoneNumber1;
    private String studentEmail1;
    private String studentname2;
    private String studentPhoneNumber2;
    private String studentEmail2;
    private Map stateMap;
    private String frmCompany;
    private Map districtIdList;
    private String message;
    private Map collegeMap;
    private int id;
    private String resultMessage;
    private String collegeString;
    private int registeredId;
    private String collegeIdHidden;
    private String resultType;
    private String frmOtherBranch;
    private String studentBranch;
    private String studentYear;
    private String studentBranch1;
    private String studentYear1;
    private String studentBranch2;
    private String studentYear2;
    private String code;
    private String studentname3;
    private String studentPhoneNumber3;
    private String studentEmail3;
    private String studentBranch3;
    private String studentYear3;
    private String colleges;
    private String frmDate;
    private String toDate;
    private List enrolldetails;
    private Map collegeList;
    private String workshopCode;
    private String userId;
 private String name;
    private String phone;
    private String title;
    private String companyName;
    private String dateOfCreation;
    private String areasOfExpertise;
    
    //
     private String otherCollegeName;
     private String facebookProfile;
     private String yearOfPass;
     private String studentCollegeName;
     
     
      private String website;
    private List collegeLocList;
    
    private String frmDesignation;
    private String regFlag;

    private GeneralVTO generalVTO;
    private String designation;
    
    
    public String insertRegDetails() {
        String resultMessage = "";
      //  System.out.println("here insert ........." + this.firstname);
        try {
            String userExist = ServiceLocator.getGeneralService().userExistance(getEmail(), getWorkPhone());
            if (userExist.equals("noteixst")) {

                /*   if (!"".equals(getCollegeIdHidden())) {
                
                //   System.out.println("-----inif-----0000000000000-" + getCollegeIdHidden());
                setFrmCollege(getCollegeIdHidden());
                }  */


                resultMessage = ServiceLocator.getGeneralService().insertRegDetails(this);
                if (resultMessage.equals("success")) {
                    ServiceLocator.getGeneralService().insertHubbleRegDetails(this);

                    setId(1);
                   // setResultMessage("<font color='green' size='4.5'>Successfully Registered</font>");
                    setResultMessage("success");
                    // setResultMessage( "<font style='color:green;font-weight:bold;font-size:14px;'>Details added Successfully</font>");



                    //System.out.println("getCollegeIdHidden-->" + getCollegeIdHidden());
                    if (getCollegeIdHidden() != null) {

                       // System.out.println("-----inif-----0000000000000-" + getCollegeIdHidden());
                        //setResultMessage("regLogin");
                      //  setResultMessage("<font color='green' size='4.5'>Successfully Registered</font>");
                        setResultMessage("success");
                    }
                }
                resultType = SUCCESS;
            } else {

                setId(1);
                setResultMessage("email");
                //    setResultMessage( "<font style='color:red;font-weight:bold;font-size:14px;'>Email or phone number alredy exist</font>");

                //servletRequest.getSession(true).setAttribute(AppConstants.RESULT_MESSAGE, "<font style='color:red;font-weight:bold;font-size:14px;'>Email or phone number alredy exist</font>");
                resultType = "emailExist";

            }



        } catch (Exception e) {
            e.printStackTrace();
            resultType = ERROR;

        }
        return resultType;
    }

    public String enrollCollegeDetails() {
        String result = "";
       // System.out.println("here........." + this.collegeid);
        try {
            String colegeExist = ServiceLocator.getGeneralService().collegeExistance(getCollegeName());
            if (colegeExist.equals("noteixst")) {
                result = ServiceLocator.getGeneralService().enrollCollegeDetails(this);
                if (result.equals("success")) {
                    collegeMap = DataSourceDataProvider.getInstance().getCollegeNames();
                    setResultMessage("success");
                    //setResultMessage("<font style='color:green;font-weight:bold;font-size:14px;'>Details Inserted Successfully</font>");
                    // servletRequest.getSession(true).setAttribute(AppConstants.RESULT_MESSAGE, "<font style='color:green;font-weight:bold;font-size:14px;'>Details Inserted Successfully</font>");
                    return SUCCESS;
                } else if (result.equals("exist")) {

                    setResultMessage("already user existed");
                    return SUCCESS;

                } else if (result.equals("code mismatch")) {

                    setResultMessage("code mismatch");
                    return SUCCESS;

                } else {
                    return ERROR;
                }
            } else {

                setId(1);
                setResultMessage("exist");

                return SUCCESS;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String getRegistrationForm() {

        String result = "";
      //  System.out.println("here.........");
        try {
            setStateMap(DataSourceDataProvider.getInstance().getStateNames());
            setDistrictIdList(DataSourceDataProvider.getInstance().getDistrictNames());
            //collegeMap = DataSourceDataProvider.getInstance().getCollegeNames();
            collegeMap = DataSourceDataProvider.getInstance().getEnrolledCollegeNames();
            collegeMap.put("Others","Others");
            //servletRequest.setAttribute(AppConstants.RESULT_MESSAGE, getResultMessage());
            if (getResultMessage() != null && "".equals(getResultMessage())) {
                if (getResultMessage().equals("success")) {
                    setResultMessage("success");
                } else {
                    setResultMessage("email");
                }
            }

           // System.out.println("==================" + getStateMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String enrollCollege() {
        try {

            collegeMap = DataSourceDataProvider.getInstance().getCollegeNames();
            // servletRequest.setAttribute(AppConstants.RESULT_MESSAGE, getResultMessage());
            if (getResultMessage() != null && "".equals(getResultMessage())) {
                if (getResultMessage().equals("success")) {
                    setResultMessage("success");
                }

            }
        } catch (ServiceLocatorException ex) {
            Logger.getLogger(RegistrationAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return SUCCESS;
    }

    public String getCollegeLis() {


        try {

          //  collegeString = DataSourceDataProvider.getInstance().getCollegeAndLoc();
            collegeLocList = DataSourceDataProvider.getInstance().getCollegeAndLoc();

        } catch (ServiceLocatorException ex) {
            Logger.getLogger(RegistrationAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return SUCCESS;
    }

    public String enrollDetailsSearch() {
        try {
            resultType = LOGIN;
            String query;

            if (servletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("REGISTRATION_LIST", Integer.parseInt(servletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    //setCollegeList(DataSourceDataProvider.getInstance().getCollegeNames());
                    setCollegeList(DataSourceDataProvider.getInstance().getEnrolledCollegeNames());
                    query = "SELECT tblRegistrationDetails.id , FName,LName,Email,PhoneNum,CollegeName,College,ProfessionType FROM tblRegistrationDetails LEFT OUTER JOIN tblLKCollegesList ON College=tblLKCollegesList.id where 1=1";


                    if (getProfession() != null && !"".equals(getProfession())) {
                        query += " and ProfessionType='" + getProfession() + "'";
                    } else {
                        query += " and ProfessionType='1'";//Default Student -->1S/w --> 2,Faculty-->3,Admin-->4
                    }

                    if (getColleges() != null && !"".equals(getColleges())) {
                        query += " and College='" + getColleges() + "'";

                    }
                    if (getFrmDate() != null && !"".equals(getFrmDate())) {
                        query += (" AND DATE(tblRegistrationDetails.CreatedDate) >= '" + DateUtility.getInstance().convertStringToMySQLDate(getFrmDate()) + "' ");
                    }
                    if (getToDate() != null && !"".equals(getToDate())) {
                        query += (" AND DATE(tblRegistrationDetails.CreatedDate) <= '" + DateUtility.getInstance().convertStringToMySQLDate(getToDate()) + "' ");
                    }
                    setEnrolldetails(ServiceLocator.getGeneralService().enrollDetailsSearch(this, query));

                    setWorkshopCode(getWorkshopCode());
                    // System.out.println("enroll in action -->"+getEnrolldetails().size());
                    resultType = SUCCESS;

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return resultType;
    }

    public String excelSheetForRegistratioDetails() {

        resultType = INPUT;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            if (servletRequest.getSession(false).getAttribute(AppConstants.SESSION_DBUSERNAME) != null) {
                //  setCollegeList(DataSourceDataProvider.getInstance().getCollegeNames());
                setCollegeList(DataSourceDataProvider.getInstance().getEnrolledCollegeNames());
                String responseString = "";

                String fileLocation = "";
                String query = "";
               query = "SELECT tblRegistrationDetails.id , CONCAT(FName,' ' ,LName) AS NAME,Email,PhoneNum,CollegeName,College FROM tblRegistrationDetails LEFT OUTER JOIN tblLKCollegesList ON College=tblLKCollegesList.id where 1=1";


                    if (getProfession() != null && !"".equals(getProfession())) {
                        query += " and ProfessionType='" + getProfession() + "'";
                    } else {
                        query += " and ProfessionType='1'";//Default Student -->1S/w --> 2,Faculty-->3,Admin-->4
                    }

                    if (getColleges() != null && !"".equals(getColleges())) {
                        query += " and College='" + getColleges() + "'";

                    }
                    if (getFrmDate() != null && !"".equals(getFrmDate())) {
                        query += (" AND DATE(tblRegistrationDetails.CreatedDate) >= '" + DateUtility.getInstance().convertStringToMySQLDate(getFrmDate()) + "' ");
                    }
                    if (getToDate() != null && !"".equals(getToDate())) {
                        query += (" AND DATE(tblRegistrationDetails.CreatedDate) <= '" + DateUtility.getInstance().convertStringToMySQLDate(getToDate()) + "' ");
                    }
               // System.out.println("query in query action-->" + query.toString());
                //  queryString = "SELECT CONCAT(FName,' ' ,LName) as NAME,Email,PhoneNum FROM tblRegistrationDetails where 1=1";
                fileLocation = ServiceLocator.getGeneralService().excelSheetForRegistratioDetails(this, query);
              //  System.out.println("fileLocation-->" + fileLocation);
                httpServletResponse.setContentType("application/force-download");

                if (!"".equals(fileLocation)) {
                    File file = new File(fileLocation);

                    //   File file = new File("D:\\usr\\local\\ProjectFiles\\RegistratioDetails\\details.xls");

                    String fileName = "";

                    fileName = file.getName();
                   // System.out.println("");
                    if (file.exists()) {
                        inputStream = new FileInputStream(file);
                        outputStream = httpServletResponse.getOutputStream();
                        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
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
                        resultType = SUCCESS;
                    } else {
                        throw new FileNotFoundException("File not found");
                    }
                } else {

                    resultMessage = "<font color=\"red\" size=\"1.5\">Sorry! No records for this Employee!</font>";
                    servletRequest.setAttribute(AppConstants.RESULT_MESSAGE, resultMessage);

                }







            }//Close Session Checking
        } catch (FileNotFoundException ex) {
            try {
                httpServletResponse.sendRedirect("../general/exception.action?exceptionMessage='No File found'");
            } catch (IOException ex1) {
                // Logger.getLogger(MarketingAction.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return resultType;
    }

    public String registerAsCoach() throws ServiceLocatorException {
        
        String resultMessage = "";
        int updatedRows = 0;
        
        try {
             String userExist = ServiceLocator.getGeneralService().userExistanceInCoachDet(getEmail(), getPhone());
            if (userExist.equals("noteixst")) {
            
            updatedRows = ServiceLocator.getGeneralService().insertRegisterCoachDetails(this);
            
            if (updatedRows > 0) {
                setResultMessage("success");
                resultType = SUCCESS;
            }
          
        }else {
                setId(1);
                setResultMessage("emailExist");
                //    setResultMessage( "<font style='color:red;font-weight:bold;font-size:14px;'>Email or phone number alredy exist</font>");
                //servletRequest.getSession(true).setAttribute(AppConstants.RESULT_MESSAGE, "<font style='color:red;font-weight:bold;font-size:14px;'>Email or phone number alredy exist</font>");
                resultType = SUCCESS;
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultType;
    }

   public String redirectCoachDetails() {

        if ("success".equals(getResultMessage())) {



            servletRequest.setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-success'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"green\" size=\"3.5\"><b>Successfully Registered</b> </font></div>");
        }
        if("emailExist".equals(getResultMessage())){
          servletRequest.setAttribute(AppConstants.RESULT_MESSAGE, "<div class='alert alert-danger'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"red\" size=\"3.5\"><b>Already Phone Number Or Email Existed</b> </font></div>");  
        }

        return SUCCESS;
    }

     //edit details for registration page
    private List registereditdetails;

    public String editRegidtrationDetails() {
        System.out.println("----------editRegidtrationDetails---------");
        try {
            resultType = LOGIN;
            String query;

            if (servletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("REGISTRATION_LIST", Integer.parseInt(servletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    //setCollegeList(DataSourceDataProvider.getInstance().getCollegeNames());
                    // setCollegeList(DataSourceDataProvider.getInstance().getEnrolledCollegeNames());
                    // query = "SELECT tblRegistrationDetails.id , CONCAT(FName,' ' ,LName) AS NAME,Email,PhoneNum,CollegeName,College FROM tblRegistrationDetails LEFT OUTER JOIN tblLKCollegesList ON College=tblLKCollegesList.id where 1=1";
                    collegeMap = DataSourceDataProvider.getInstance().getCollegeNames();
                    setStateMap(DataSourceDataProvider.getInstance().getStateNames());
                    System.out.println("------state");
                    setDistrictIdList(DataSourceDataProvider.getInstance().getDistrictNames());
                    
                    
                    System.out.println("------" + collegeMap);
                    if("3".equals(getProfession())){
                        query="SELECT tblRegistrationDetails.id,FName,LName,Email,PhoneNum,College,CollegeCode,Location,CODE"
                                + " FROM tblRegistrationDetails JOIN tblEnrollCollegeDetails ON (Fac_Email=Email AND CollegeName=College) "
                                + " WHERE tblRegistrationDetails.id='"+getUserId()+"'" ;
                    }else{
                        
                    
                   query = "SELECT tblRegistrationDetails.id , FName,LName,Email,PhoneNum,CollegeName,College,PASSWORD,Branch,YEAR,"
                           + " FaceBookLink,Street,City,District,ZipCode,State,CompanyName,Designation,ProfessionType FROM tblRegistrationDetails "
                           + " LEFT OUTER JOIN tblLKCollegesList ON College=tblLKCollegesList.id  where 1=1";
                   /* query = "SELECT tblRegistrationDetails.id , FName,LName,Email,PhoneNum,CollegeName,"
                            + " College,PASSWORD,Branch,YEAR,FaceBookLink,Street,City,District,"
                            + " ZipCode,State,CompanyName,Designation,ProfessionType,"
                            
                            + " FROM tblRegistrationDetails LEFT OUTER JOIN tblLKCollegesList ON College=tblLKCollegesList.id "
                            + " where 1=1";*/

                    
                    if (getProfession() != null && !"".equals(getProfession())) {
                        query += " and ProfessionType='" + getProfession() + "'";
                    } else {
                        query += " and ProfessionType='1' ";
                    }

                    if (getColleges() != null && !"".equals(getColleges())) {
                        query += " and College='" + getColleges() + "'";

                    }
                    query=query+" and tblRegistrationDetails.id='"+getUserId()+"'";
                    }
                    System.out.println("query==" + query);
                    /*if (getFrmDate() != null && !"".equals(getFrmDate())) {
                    query += (" AND DATE(tblRegistrationDetails.CreatedDate) >= '" + DateUtility.getInstance().convertStringToMySQLDate(getFrmDate()) + "' ");
                    }
                    if (getToDate() != null && !"".equals(getToDate())) {
                    query += (" AND DATE(tblRegistrationDetails.CreatedDate) <= '" + DateUtility.getInstance().convertStringToMySQLDate(getToDate()) + "' ");
                    }*/
                    setGeneralVTO(ServiceLocator.getGeneralService().editRegidtrationDetails(this, query));

                    // setWorkshopCode(getWorkshopCode());
                    // System.out.println("enroll in action -->"+getEnrolldetails().size());
                    resultType = SUCCESS;

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return resultType;
    }

    // updating registered details
     private String fname;
    private String lname;
     private String fbprofile;
    private String phoneNumber;
    private String collegeCode;
   
       public String updateRegistrationDetails() throws ServiceLocatorException {
           String result = "";
           
        System.out.println("--updateRegistrationDetails--in action----");
        resultType = LOGIN;
        try {
            
               // result=ServiceLocator.getGeneralService().updateRegistrationDetails(getUserId(),getFname(),getLname(), getEmail(), getPhoneNumber(), getCollegeName(),getBranch(),getYear(),getFbprofile(),getStreet(),getCity(),getDistrict(),getZipcode(),getState(),getFrmCompany(),getDesignation());
                result=ServiceLocator.getGeneralService().updateRegistrationDetails(this);
              if (result.equals("success")) {
                  setResultMessage("success");
              }
                resultType = SUCCESS;
        }
        catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            resultType = ERROR;
        }
        return resultType;
    }
    
    public Map getCollegeMap() {
        return collegeMap;
    }

    public void setCollegeMap(Map collegeMap) {
        this.collegeMap = collegeMap;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFrmCollege() {
        return frmCollege;
    }

    public void setFrmCollege(String frmCollege) {
        this.frmCollege = frmCollege;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFrmCompany() {
        return frmCompany;
    }

    public void setFrmCompany(String frmCompany) {
        this.frmCompany = frmCompany;
    }

    public Map getDistrictIdList() {
        return districtIdList;
    }

    public void setDistrictIdList(Map districtIdList) {
        this.districtIdList = districtIdList;
    }

    public Map getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map stateMap) {
        this.stateMap = stateMap;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }

    public String getFacultyambassadorEmail() {
        return facultyambassadorEmail;
    }

    public void setFacultyambassadorEmail(String facultyambassadorEmail) {
        this.facultyambassadorEmail = facultyambassadorEmail;
    }

    public String getFacultyambassadorName() {
        return facultyambassadorName;
    }

    public void setFacultyambassadorName(String facultyambassadorName) {
        this.facultyambassadorName = facultyambassadorName;
    }

    public String getFacultyambassadorPhoneNumber() {
        return facultyambassadorPhoneNumber;
    }

    public void setFacultyambassadorPhoneNumber(String facultyambassadorPhoneNumber) {
        this.facultyambassadorPhoneNumber = facultyambassadorPhoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail;
    }

    public String getPrincipalPhoneNumber() {
        return principalPhoneNumber;
    }

    public void setPrincipalPhoneNumber(String principalPhoneNumber) {
        this.principalPhoneNumber = principalPhoneNumber;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentEmail1() {
        return studentEmail1;
    }

    public void setStudentEmail1(String studentEmail1) {
        this.studentEmail1 = studentEmail1;
    }

    public String getStudentEmail2() {
        return studentEmail2;
    }

    public void setStudentEmail2(String studentEmail2) {
        this.studentEmail2 = studentEmail2;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentPhoneNumber1() {
        return studentPhoneNumber1;
    }

    public void setStudentPhoneNumber1(String studentPhoneNumber1) {
        this.studentPhoneNumber1 = studentPhoneNumber1;
    }

    public String getStudentPhoneNumber2() {
        return studentPhoneNumber2;
    }

    public void setStudentPhoneNumber2(String studentPhoneNumber2) {
        this.studentPhoneNumber2 = studentPhoneNumber2;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentname1() {
        return studentname1;
    }

    public void setStudentname1(String studentname1) {
        this.studentname1 = studentname1;
    }

    public String getStudentname2() {
        return studentname2;
    }

    public void setStudentname2(String studentname2) {
        this.studentname2 = studentname2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getCollegeString() {
        return collegeString;
    }

    public void setCollegeString(String collegeString) {
        this.collegeString = collegeString;
    }

    /**
     * @return the registeredId
     */
    public int getRegisteredId() {
        return registeredId;
    }

    /**
     * @param registeredId the registeredId to set
     */
    public void setRegisteredId(int registeredId) {
        this.registeredId = registeredId;
    }

    /**
     * @return the collegeIdHidden
     */
    public String getCollegeIdHidden() {
        return collegeIdHidden;
    }

    /**
     * @param collegeIdHidden the collegeIdHidden to set
     */
    public void setCollegeIdHidden(String collegeIdHidden) {
        this.collegeIdHidden = collegeIdHidden;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the frmOtherBranch
     */
    public String getFrmOtherBranch() {
        return frmOtherBranch;
    }

    /**
     * @param frmOtherBranch the frmOtherBranch to set
     */
    public void setFrmOtherBranch(String frmOtherBranch) {
        this.frmOtherBranch = frmOtherBranch;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        this.studentBranch = studentBranch;
    }

    public String getStudentBranch1() {
        return studentBranch1;
    }

    public void setStudentBranch1(String studentBranch1) {
        this.studentBranch1 = studentBranch1;
    }

    public String getStudentBranch2() {
        return studentBranch2;
    }

    public void setStudentBranch2(String studentBranch2) {
        this.studentBranch2 = studentBranch2;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public String getStudentYear1() {
        return studentYear1;
    }

    public void setStudentYear1(String studentYear1) {
        this.studentYear1 = studentYear1;
    }

    public String getStudentYear2() {
        return studentYear2;
    }

    public void setStudentYear2(String studentYear2) {
        this.studentYear2 = studentYear2;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the studentname3
     */
    public String getStudentname3() {
        return studentname3;
    }

    /**
     * @param studentname3 the studentname3 to set
     */
    public void setStudentname3(String studentname3) {
        this.studentname3 = studentname3;
    }

    /**
     * @return the studentPhoneNumber3
     */
    public String getStudentPhoneNumber3() {
        return studentPhoneNumber3;
    }

    /**
     * @param studentPhoneNumber3 the studentPhoneNumber3 to set
     */
    public void setStudentPhoneNumber3(String studentPhoneNumber3) {
        this.studentPhoneNumber3 = studentPhoneNumber3;
    }

    /**
     * @return the studentEmail3
     */
    public String getStudentEmail3() {
        return studentEmail3;
    }

    /**
     * @param studentEmail3 the studentEmail3 to set
     */
    public void setStudentEmail3(String studentEmail3) {
        this.studentEmail3 = studentEmail3;
    }

    /**
     * @return the studentBranch3
     */
    public String getStudentBranch3() {
        return studentBranch3;
    }

    /**
     * @param studentBranch3 the studentBranch3 to set
     */
    public void setStudentBranch3(String studentBranch3) {
        this.studentBranch3 = studentBranch3;
    }

    /**
     * @return the studentYear3
     */
    public String getStudentYear3() {
        return studentYear3;
    }

    /**
     * @param studentYear3 the studentYear3 to set
     */
    public void setStudentYear3(String studentYear3) {
        this.studentYear3 = studentYear3;
    }

    /**
     * @return the colleges
     */
    public String getColleges() {
        return colleges;
    }

    /**
     * @param colleges the colleges to set
     */
    public void setColleges(String colleges) {
        this.colleges = colleges;
    }

    /**
     * @return the frmDate
     */
    public String getFrmDate() {
        return frmDate;
    }

    /**
     * @param frmDate the frmDate to set
     */
    public void setFrmDate(String frmDate) {
        this.frmDate = frmDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return the enrolldetails
     */
    public List getEnrolldetails() {
        return enrolldetails;
    }

    /**
     * @param enrolldetails the enrolldetails to set
     */
    public void setEnrolldetails(List enrolldetails) {
        this.enrolldetails = enrolldetails;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    /**
     * @return the collegeList
     */
    public Map getCollegeList() {
        return collegeList;
    }

    /**
     * @param collegeList the collegeList to set
     */
    public void setCollegeList(Map collegeList) {
        this.collegeList = collegeList;
    }

    /**
     * @return the workshopCode
     */
    public String getWorkshopCode() {
        return workshopCode;
    }

    /**
     * @param workshopCode the workshopCode to set
     */
    public void setWorkshopCode(String workshopCode) {
        this.workshopCode = workshopCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return the dateOfCreation
     */
    public String getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation the dateOfCreation to set
     */
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * @return the areasOfExpertise
     */
    public String getAreasOfExpertise() {
        return areasOfExpertise;
    }

    /**
     * @param areasOfExpertise the areasOfExpertise to set
     */
    public void setAreasOfExpertise(String areasOfExpertise) {
        this.areasOfExpertise = areasOfExpertise;
    }

    /**
     * @return the otherCollegeName
     */
    public String getOtherCollegeName() {
        return otherCollegeName;
    }

    /**
     * @param otherCollegeName the otherCollegeName to set
     */
    public void setOtherCollegeName(String otherCollegeName) {
        this.otherCollegeName = otherCollegeName;
    }

    /**
     * @return the facebookProfile
     */
    public String getFacebookProfile() {
        return facebookProfile;
    }

    /**
     * @param facebookProfile the facebookProfile to set
     */
    public void setFacebookProfile(String facebookProfile) {
        this.facebookProfile = facebookProfile;
    }

    /**
     * @return the yearOfPass
     */
    public String getYearOfPass() {
        return yearOfPass;
    }

    /**
     * @param yearOfPass the yearOfPass to set
     */
    public void setYearOfPass(String yearOfPass) {
        this.yearOfPass = yearOfPass;
    }

    /**
     * @return the studentCollegeName
     */
    public String getStudentCollegeName() {
        return studentCollegeName;
    }

    /**
     * @param studentCollegeName the studentCollegeName to set
     */
    public void setStudentCollegeName(String studentCollegeName) {
        this.studentCollegeName = studentCollegeName;
    }

    public List getCollegeLocList() {
        return collegeLocList;
    }

    public void setCollegeLocList(List collegeLocList) {
        this.collegeLocList = collegeLocList;
    }

    public String getFrmDesignation() {
        return frmDesignation;
    }

    public void setFrmDesignation(String frmDesignation) {
        this.frmDesignation = frmDesignation;
    }

    public String getRegFlag() {
        return regFlag;
    }

    public void setRegFlag(String regFlag) {
        this.regFlag = regFlag;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the registereditdetails
     */
    public List getRegistereditdetails() {
        return registereditdetails;
    }

    /**
     * @param registereditdetails the registereditdetails to set
     */
    public void setRegistereditdetails(List registereditdetails) {
        this.registereditdetails = registereditdetails;
    }

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
     * @return the fbprofile
     */
    public String getFbprofile() {
        return fbprofile;
    }

    /**
     * @param fbprofile the fbprofile to set
     */
    public void setFbprofile(String fbprofile) {
        this.fbprofile = fbprofile;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @return the generalVTO
     */
    public GeneralVTO getGeneralVTO() {
        return generalVTO;
    }

    /**
     * @param generalVTO the generalVTO to set
     */
    public void setGeneralVTO(GeneralVTO generalVTO) {
        this.generalVTO = generalVTO;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
