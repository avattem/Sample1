/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.DashBoard;

import com.mss.apcloud.general.GeneralVTO;
import com.mss.apcloud.util.AppConstants;
import com.mss.apcloud.util.AuthorizationManager;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.Properties;
import com.mss.apcloud.util.ServiceLocator;
import com.mss.apcloud.util.ServiceLocatorException;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Kalpana
 */
public class DashBoardAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private GeneralVTO generalVTO;
    private int id;
    private String topicName;
    private String DATE;
    private String resultType;
    private String topicLink;
    private String location;
    private boolean workshopEnabled;
    private List workshopList = new ArrayList();
    private int sno = 0;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private String workshopId;
    private String resultMessage;
    private String workshopStatus;
    private String phoneNumber;
    private String college;
    private String name;
    private String email;
    private String professionType;
    private int topicId;
    private String code;
    private String collegeName;
    private String contactDetails;
    private String collegeId;
    private String contacts;
    private List docRepoList = new ArrayList();
    public String type;
    public String docName;
    public String fileName;
    public String filePath;
    public String imagePath;
    private Collection currentExamReviewCollection;
    private String workshopByTopic;
    private String durationTime;
    private String status;
    private String enrollTopics;
    private List workshopDetailsList = new ArrayList();
    private int userId;
    private int examId;
    private String workshopCode;
    private String topicsList;
    private int topicEnable;
    private int totalTopics;
    private int enrolledTotalTopics;
    private String collegeCode;
    private String frmDate;
    private String toDate;
    private String codegenerate;
    private List collegeMenuList;
    private String link;
    private String facultyambassadorName;
    private String facultyambassadorPhoneNumber;
    private String facultyambassadorEmail;
    private String studentname;
    private String studentPhoneNumber;
    private String studentEmail;
    private String studentBranch;
    private String studentYear;
    private String studentname1;
    private String studentPhoneNumber1;
    private String studentEmail1;
    private String studentBranch1;
    private String studentYear1;
    private String studentname2;
    private String studentPhoneNumber2;
    private String studentEmail2;
    private String studentBranch2;
    private String studentYear2;
    private String studentname3;
    private String studentPhoneNumber3;
    private String studentEmail3;
    private String studentBranch3;
    private String studentYear3;
    private Map collegeMap;
    private List enrollCollegeMenuList;
    private String collegeList;
    private String subTopic;
    private Map topicsMap;
    private String currculamId;
    private String enrollExcelSheet;
    private String gridDownload;
    private String venue;
    private int startExamEnable;
    private String firstName;
    private String lastName;
    private int workshopFormType;
    private int workshopType;
    private int examExistInHubble;
    private String profissionType;
    //new one
    private List registraintsDetailsList;
    private List topicList = new ArrayList();
    private File image = null;
    private int ecertId;
    private String bodyContent;
    private String videoTutorail;
    private String websitelink;
    private String tutorials;
    private String blogs;
    private int contentId;
    private List documentList = new ArrayList();
    private String imageFileName;
    private String documentFileName;
    private File document = null;
    private String webExName;
    private String webExUrl;
    private String uploadType;
    private int documentId;
    private List coachDetailsList;
    private String title;
    private String companyName;
    private String areasOfExpertise;

    public String getDashboard() throws ServiceLocatorException, SQLException {

        String workshopIds = "";
        String projectType = "";
        resultType = INPUT;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
            if (session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID) != null) {
                workshopIds = session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID).toString();
            }
            if (session.getAttribute(AppConstants.SESSION_COLLEGEID) != null) {
                collegeId = session.getAttribute(AppConstants.SESSION_COLLEGEID).toString();
            }

            if (session.getAttribute(AppConstants.SESSION_PHONENUM) != null) {
                phoneNumber = session.getAttribute(AppConstants.SESSION_PHONENUM).toString();
            }
            if (session.getAttribute(AppConstants.SESSION_COLLEGE) != null) {
                college = session.getAttribute(AppConstants.SESSION_COLLEGE).toString();
            }
            if (session.getAttribute(AppConstants.SESSION_DBUSERNAME) != null) {
                name = session.getAttribute(AppConstants.SESSION_DBUSERNAME).toString();
            }
            if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
            }

            boolean workshopEnabled = false;
            try {

                workshopList = ServiceLocator.getDashBoardService().getDashBoardDetails(workshopIds, collegeId, getProfessionType());

                if (getResultMessage() != null && "".equals(getResultMessage())) {
                    if (getResultMessage().equals("success")) {
                        setResultMessage("success");
                    } else {
                        setResultMessage("error");
                    }
                }
                if (getResultMessage() != null && "".equals(getResultMessage())) {
                    if (getResultMessage().equals("success")) {
                        setResultMessage("success");
                    } else {
                        setResultMessage("email");
                    }
                }
                resultType = SUCCESS;
            } catch (Exception ex) {
                throw new ServiceLocatorException(ex);
            }
        }
        return resultType;
    }

    public String enrollWorkshop() {
        String resultMsg = "";
        HttpSession session = httpServletRequest.getSession(false);
        String workshopIds = "";
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                if (session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID) != null) {
                    workshopIds = session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID).toString();
                }


                resultMsg = ServiceLocator.getDashBoardService().enrollWorkshop(getWorkshopId(), session.getAttribute(AppConstants.SESSION_EMAIL).toString(), workshopIds);
                if (resultMsg.equals("success")) {

                    session.setAttribute(AppConstants.SESSION_ENROLLWORKSHOPID, workshopIds + "," + getWorkshopId());


                    setResultMessage("success");
                    //    System.out.println("success enroll");
                    return SUCCESS;
                }
                setResultMessage("error");
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                //  Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return INPUT;
    }

    public String getDashboardWorkshop() throws ServiceLocatorException, SQLException {
        //   System.out.println("-----getDashboardWorkshop--------" + getResultMessage());
        String workshopIds = "";
        String projectType = "";
        String contactDetails = "";


        resultType = INPUT;
        // HttpSession session = httpServletRequest.getSession(false);

        /* if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
        email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();*/
        //  if (session.getAttribute(AppConstants.SESSION_CONTACTDETAILS) != null) {
        //  contactDetails = session.getAttribute(AppConstants.SESSION_CONTACTDETAILS).toString();
        //   }

        /* if (session.getAttribute(AppConstants.SESSION_PHONENUM) != null) {
        phoneNumber = session.getAttribute(AppConstants.SESSION_PHONENUM).toString();
        }
        if (session.getAttribute(AppConstants.SESSION_COLLEGE) != null) {
        college = session.getAttribute(AppConstants.SESSION_COLLEGE).toString();
        }
        if (session.getAttribute(AppConstants.SESSION_DBUSERNAME) != null) {
        name = session.getAttribute(AppConstants.SESSION_DBUSERNAME).toString();
        }
        if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
        }*/



        boolean workshopEnabled = false;
        try {
            workshopList = ServiceLocator.getDashBoardService().getDashboardWorkshop(workshopIds, getContactDetails(), getCollege(), getProfessionType());

            if (getResultMessage() != null && "".equals(getResultMessage())) {
                if (getResultMessage().equals("success")) {
                    setResultMessage("success");
                } else {
                    setResultMessage("error");
                }
            }
            resultType = SUCCESS;
        } catch (Exception ex) {
            throw new ServiceLocatorException(ex);
        }
        //   }
        return resultType;
        // }

    }

    public String getTechTopics() {

        String enrollTopics = "";
        try {
            HttpSession session = httpServletRequest.getSession(false);
            if (session.getAttribute(AppConstants.SESSION_ENROLLTOPICS) != null) {
                enrollTopics = session.getAttribute(AppConstants.SESSION_ENROLLTOPICS).toString();
            }

            docRepoList = ServiceLocator.getDashBoardService().getTechTopicData(enrollTopics);
            setTopicEnable(0);

        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String getProfission() {
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {

            if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
            }
            if (professionType != null && !"".equals(professionType)) {
                if (professionType != null && !"".equals(professionType)) {
                    if ("1".equals(professionType)) {
                        return "student";
                    } else if ("2".equals(professionType)) {
                        return "software";
                    } else if ("3".equals(professionType)) {
                        return "facult";
                    } else if ("4".equals(professionType)) {
                        return "admin";
                    } else if ("5".equals(professionType)) {
                        return "passoutStudent";
                    }
                }
            }
        }
        return INPUT;
    }
//
    //  private String companyName;name
    private String salary;

    public String updateDetails() throws ServiceLocatorException {
        resultMessage = "";

        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            id = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());
            String professionType = httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
            resultMessage = ServiceLocator.getDashBoardService().updateDetails(this, professionType);



            if (resultMessage.equals("success")) {
                setResultMessage("success");
                //     System.out.println("result---------------" + resultMessage);
                httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_FIRSTNAME, getFirstName());
                httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_LASTNAME, getLastName());
                //   System.out.println("---in update---" + getLastName());
                // httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_DBUSERNAME, getlName());
                httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_PHONENUM, getPhoneNumber());
                //  httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_EMAIL, getEmail()); 
                httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_COLLEGEID, getCollegeId());




                httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_COMPANYNAME, getCompanyName());
                httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_SALARY, getSalary());


                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }
//        setResultMessage( "success");



    }

    public String getCertifications() {
        resultType = INPUT;
        if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {


                resultType = SUCCESS;
            } catch (Exception ex) {
                ex.printStackTrace();
                resultType = ERROR;
            }
        }
        return resultType;
    }

    public String getAvailableCertifications() {
        resultType = INPUT;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                userId = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());
                professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();

                //  docRepoList=  ServiceLocator.getDashBoardService().getTechTopicData();
                docRepoList = ServiceLocator.getDashBoardService().getAvailableCertifications(userId, professionType);
                // int mcertId = DataSourceDataProvider.getInstance().getMcertIdByActualId(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID).toString());
                //  setCurrentExamReviewCollection(ServiceLocator.getDashBoardService().getMcertExamReviewCollection(mcertId, 15));

                resultType = SUCCESS;
            } catch (Exception ex) {
                ex.printStackTrace();
                resultType = ERROR;
            }
        }
        return resultType;
    }
    //getExamDetailsByTopicId

    public String getExamDetailsByTopicId() {
        resultType = INPUT;
        if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {


                setUserId(getUserId());
                setExamId(getExamId());

                //  docRepoList=  ServiceLocator.getDashBoardService().getTechTopicData();
                //docRepoList=  ServiceLocator.getDashBoardService().getAvailableCertifications();
                // int mcertId = DataSourceDataProvider.getInstance().getMcertIdByActualId(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID).toString());
                //  setCurrentExamReviewCollection(ServiceLocator.getDashBoardService().getMcertExamReviewCollection(mcertId, 15));

                resultType = SUCCESS;
            } catch (Exception ex) {
                ex.printStackTrace();
                resultType = ERROR;
            }
        }
        return resultType;
    }

    public String getMyProfile() {

        String workshopIds = "";
        String projectType = "";
        resultType = INPUT;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                if (session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID) != null) {
                    workshopIds = session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID).toString();
                }

                if (session.getAttribute(AppConstants.SESSION_PHONENUM) != null) {
                    phoneNumber = session.getAttribute(AppConstants.SESSION_PHONENUM).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_COLLEGE) != null) {
                    college = session.getAttribute(AppConstants.SESSION_COLLEGE).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_COLLEGEID) != null) {
                    collegeId = session.getAttribute(AppConstants.SESSION_COLLEGEID).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_DBUSERNAME) != null) {
                    name = session.getAttribute(AppConstants.SESSION_DBUSERNAME).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                    professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_ENROLLTOPICS) != null) {
                    enrollTopics = session.getAttribute(AppConstants.SESSION_ENROLLTOPICS).toString();
                    //workshopDetailsList = ServiceLocator.getDashBoardService().getWorkshopDetailsTopicWise(enrollTopics, collegeId);
                }

                if (session.getAttribute(AppConstants.SESSION_COMPANYNAME) != null) {
                    companyName = session.getAttribute(AppConstants.SESSION_COMPANYNAME).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_SALARY) != null) {
                    salary = session.getAttribute(AppConstants.SESSION_SALARY).toString();
                }

                if (session.getAttribute(AppConstants.SESSION_FIRSTNAME) != null) {
                    firstName = session.getAttribute(AppConstants.SESSION_FIRSTNAME).toString();
                }
                if (session.getAttribute(AppConstants.SESSION_LASTNAME) != null) {
                    lastName = session.getAttribute(AppConstants.SESSION_LASTNAME).toString();
                }
                userId = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());

                collegeMap = DataSourceDataProvider.getInstance().getCollegeNames();



                workshopDetailsList = ServiceLocator.getDashBoardService().getWorkshopDetailsTopicWise(userId);




                boolean workshopEnabled = false;




                if (getResultMessage() != null && "".equals(getResultMessage())) {
                    if (getResultMessage().equals("success")) {
                        setResultMessage("success");
                    } else {
                        setResultMessage("error");
                    }
                }
                if (getResultMessage() != null && "".equals(getResultMessage())) {
                    if (getResultMessage().equals("success")) {
                        setResultMessage("success");
                    } else {
                        setResultMessage("email");
                    }
                }
                resultType = SUCCESS;
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
        return resultType;

    }

    public String getWorkshopTopics() {
        String enrollTopics = "";

        try {

            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID) != null) {
                userId = Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID).toString());

                resultType = ServiceLocator.getDashBoardService().getWorkshopTopics(this);
                setTopicEnable(1);

            }

        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
        //return resultType;
    }

    public String leftMenuCollege() {
        resultType = LOGIN;
        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID) != null) {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("COLLEGE_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }
                    if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_COLLEGELIST) != null) {
                        httpServletRequest.getSession(false).removeAttribute(AppConstants.SESSION_COLLEGELIST);
                    }
                    setCollegeMenuList(ServiceLocator.getDashBoardService().leftMenuCollege(getCollegeCode(), getCollegeName(), getLocation(), getCodegenerate(), getLink(), getFrmDate(), getToDate()));
                    httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_COLLEGELIST, getCollegeMenuList());
                    resultType = SUCCESS;
                }
            }
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            resultType = ERROR;
        }
        return resultType;
    }

    public String getEnolledCollegeDetails() {
        resultType = LOGIN;
        try {
            HttpSession session = httpServletRequest.getSession(false);
            if (session.getAttribute(AppConstants.SESSION_ID) != null) {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("ENROLL_COLLEGE_DETAILS", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                    collegeId = session.getAttribute(AppConstants.SESSION_COLLEGEID).toString();
                    userId = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());

                    resultType = ServiceLocator.getDashBoardService().getEnolledCollegeDetails(this);
                    collegeMap = DataSourceDataProvider.getInstance().getCollegeNames();
                    resultType = SUCCESS;
                }
            }

        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            resultType = ERROR;
        }
        return resultType;
    }

    public String updateEnrollCollege() {
        try {
            HttpSession session = httpServletRequest.getSession(false);
            if (session.getAttribute(AppConstants.SESSION_ID) != null) {
                userId = Integer.parseInt(session.getAttribute(AppConstants.SESSION_ID).toString());
                name = session.getAttribute(AppConstants.SESSION_EMAIL).toString();

                resultType = ServiceLocator.getDashBoardService().updateEnrollCollege(this);
                setResultMessage("success");

            }

        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }
    private String facultyName;
    // private String student;

    public String enrollLeftMenuCollege() {
        // System.out.println("-----------enrollLeftMenuCollege-----------");
        resultType = LOGIN;
        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID) != null) {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("ENROLLED_COLLGE_LIST", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    HttpSession session = httpServletRequest.getSession(false);
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }
                    setEnrollCollegeMenuList(ServiceLocator.getDashBoardService().enrollLeftMenuCollege(this, getCollegeCode(), getCollegeName(), getLocation(), getCodegenerate(), getLink(), getFrmDate(), getToDate()));
                    resultType = SUCCESS;
                }
            }
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            resultType = ERROR;
        }
        return resultType;

    }

    public String workshopDetailsAdd() {
        resultType = LOGIN;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("WORKSHOP_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }

                    if ("4".equals(professionType)) {
                        String resultMess = ServiceLocator.getDashBoardService().getWorkshopAddDetails(this);
                        collegeMap = DataSourceDataProvider.getInstance().getCollegeNamesNotRegistred(getCollegeList());
                        resultType = SUCCESS;
                    } else {
                        resultType = INPUT;

                    }
                }
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                resultType = ERROR;

            }
        }
        return resultType;

    }

    public String getCurrcullamAddTopicsData() {
        String enrollTopics = "";

        try {

            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID) != null) {
                userId = Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID).toString());

                resultType = ServiceLocator.getDashBoardService().getCurrcullamAddTopicsData(this);
                topicsMap = DataSourceDataProvider.getInstance().getTopicsMap();


            }

        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String exportEnrollExcelSheet() {

        String filename = "getEnrollExcelSheet";
        OutputStream out = null;
        //  System.out.println("getGridDownload-->"+getGridDownload());
        try {
            filename = filename.concat(".xls");

            httpServletResponse.setContentType("application/vnd.ms-excel");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            int count;
            WritableWorkbook wworkbook;
            wworkbook = Workbook.createWorkbook(httpServletResponse.getOutputStream());
            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
            Label label;
            wsheet.setColumnView(0, 10);
            wsheet.setColumnView(1, 15);
            wsheet.setColumnView(2, 40);
            wsheet.setColumnView(3, 15);
            wsheet.setColumnView(4, 15);
            wsheet.setColumnView(5, 30);
            wsheet.setColumnView(6, 60);
            wsheet.setColumnView(7, 70);
            wsheet.setColumnView(8, 70);
            wsheet.setColumnView(9, 70);
            wsheet.setColumnView(10, 70);
            if (!"".equals(getGridDownload())) {
                String data = DataSourceDataProvider.getInstance().getGridData(getGridDownload());
                // String data1 = DataSourceDataProvider.getInstance().getFacultyGridData(getGridDownload());

                //  System.out.println("---------data---------"+data);
                setGridDownload(data);

                WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
                cellFont.setColour(Colour.BLACK);

                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBackground(Colour.LIGHT_BLUE);

                String[] s = getGridDownload().split(Pattern.quote("^"));
                for (int i = 0; i < s.length; i++) {

                    String ss = s[i];
                    String[] inner = ss.split(Pattern.quote("|"));

                    for (int j = 0; j < inner.length; j++) {

                        if (i == 0) {
                            label = new Label(j, i, inner[j], cellFormat);
                            wsheet.addCell(label);
                        } else {
                            label = new Label(j, i, inner[j]);
                            wsheet.addCell(label);
                        }
                    }
                }
            }
            wworkbook.write();
            wworkbook.close();
        } catch (Exception e) {
        } finally {

            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                }

            }
        }
        //  System.out.println("********************RecruitmentAjaxHandlerAction :: doDownloadXlsResults() Action End*********************");
        return null;
    }

    public void generateCollegeExcel() {

        resultType = INPUT;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_DBUSERNAME) != null) {

                String responseString = "";

                String fileLocation = "";


                //  queryString = "SELECT CONCAT(FName,' ' ,LName) as NAME,Email,PhoneNum FROM tblRegistrationDetails where 1=1";
                fileLocation = ServiceLocator.getDashBoardService().generateCollegeExcel(getFrmDate(), getToDate());

                httpServletResponse.setContentType("application/force-download");

                if (!"".equals(fileLocation)) {
                    File file = new File(fileLocation);

                    //   File file = new File("D:\\usr\\local\\ProjectFiles\\RegistratioDetails\\details.xls");

                    String fileName = "";

                    fileName = file.getName();
                    System.out.println("");
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
                    httpServletRequest.setAttribute(AppConstants.RESULT_MESSAGE, resultMessage);

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

        // return resultType;
    }

    public void doDownloadKits() throws ServiceLocatorException {
        // System.out.println("---getDocumentfile---");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String fileName = "";
        String filePath = "";
        if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                //  System.out.println("fileName-->" + fileName);
                filePath = Properties.getProperty("Kits.Downlodad.Path") + "/" + getFileName();
                fileName = filePath.split("/")[(filePath.split("/").length) - 1];
                // System.out.println("fileName--" + fileName);
                httpServletResponse.setContentType("application/force-download");
                File file = new File(filePath);
                //  System.out.println("fileName----->" + file.getAbsolutePath());
                inputStream = new FileInputStream(file.getAbsolutePath());
                outputStream = httpServletResponse.getOutputStream();

                if (outputStream == null) {
                } else {

                    httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
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
                    // return SUCCESS;
                }
            } catch (IOException ex) {
                //ex.printStackTrace();
                //  return "accessFailed";
            }
        }
        // return INPUT;
    }
//new registercoach at leftmenu

    public String registredCoachDetailsSearch() {
        //   System.out.println("--registredCoachDetailsSearch--in action----");
        resultType = LOGIN;
        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID) != null) {
                resultType = "accessFailed";
                //   if (AuthorizationManager.getInstance().isAuthorizedUser("COLLEGE_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {

                setCoachDetailsList(ServiceLocator.getDashBoardService().registredCoachDetailsSearch(this, getName(), getEmail(), getPhoneNumber(), getTitle(), getCompanyName(), getAreasOfExpertise(), getStatus(), getFrmDate(), getToDate()));
                //  httpServletRequest.getSession(false).setAttribute(AppConstants.SESSION_COLLEGELIST, getCollegeMenuList());
                resultType = SUCCESS;
                //  }
            }
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            resultType = ERROR;
        }
        return resultType;
    }

    public String getRegistratesTopicsData() {

        resultType = LOGIN;
        // HttpSession session = servletRequest.getSession(false);

        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_ID) != null) {
                resultType = "accessFailed";

                setRegistraintsDetailsList(ServiceLocator.getDashBoardService().getWorkshopRegistratesData(getWorkshopCode()));


                resultType = SUCCESS;
            }
        } catch (ServiceLocatorException ex) {
            ex.printStackTrace();
            resultType = ERROR;
        }
        return resultType;
    }

    public String topicsListRetrive() {
        resultType = LOGIN;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("WORKSHOP_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }


                    topicList = ServiceLocator.getDashBoardService().topicsListRetrive(this);
                    resultType = SUCCESS;
                }
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                resultType = ERROR;

            }
        }
        return resultType;

    }

    public String insertorUpdateTopics() {
        resultType = LOGIN;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("WORKSHOP_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }

                    //       System.out.println("--" + topicName + "---" + ecertId + "---" + image.getAbsolutePath() + "--" + status);
                    System.out.println("type " + type);
                    if ("update".equalsIgnoreCase(type)) {
                        ServiceLocator.getDashBoardService().updateTopics(this);
                        setResultMessage("Topic updated successfully");
                    } else {
                        ServiceLocator.getDashBoardService().insertorUpdateTopics(this);
                        setResultMessage("Topic added successfully");

                    }
                    resultType = SUCCESS;
                }
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                resultType = ERROR;

            }
        }
        return resultType;

    }

    public String topicDetails() {
        resultType = LOGIN;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                resultType = "accessFailed";
                // System.out.println("result message---->" + resultMessage);
                if (AuthorizationManager.getInstance().isAuthorizedUser("WORKSHOP_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }
                    if (topicId != 0) {
                        ServiceLocator.getDashBoardService().topicsAddorUpdate(this);
                    }
                    resultType = SUCCESS;
                }
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                resultType = ERROR;

            }
        }
        return resultType;
    }

    public void topicImageDownload() throws ServiceLocatorException {
        //   System.out.println("---getDocumentfile---");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String fileName = "";
        String filePath = "";
        if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {

                filePath = ServiceLocator.getDashBoardService().topicImageDownload(topicId);
                // fileName = filePath.split("/")[(filePath.split("/").length) - 1];

                httpServletResponse.setContentType("application/force-download");
                File file = new File(filePath);
                fileName = file.getName();
                // System.out.println("fileName----->" + file.getAbsolutePath());
                inputStream = new FileInputStream(file.getAbsolutePath());
                outputStream = httpServletResponse.getOutputStream();

                if (outputStream == null) {
                } else {

                    httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
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
                    // return SUCCESS;
                }
            } catch (IOException ex) {
                //ex.printStackTrace();
                //  return "accessFailed";
            }
        }
        // return INPUT;
    }

    public String getDocumentsList() {
        resultType = LOGIN;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("WORKSHOP_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }


                    documentList = ServiceLocator.getDashBoardService().getDocumentsList(this);
                    resultType = SUCCESS;
                }
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                resultType = ERROR;

            }
        }
        return resultType;

    }

    public String insertDocumentDetails() {
        resultType = LOGIN;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            try {
                email = session.getAttribute(AppConstants.SESSION_EMAIL).toString();
                resultType = "accessFailed";
                if (AuthorizationManager.getInstance().isAuthorizedUser("WORKSHOP_ADD_EDIT", Integer.parseInt(httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString()))) {
                    if (session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE) != null) {
                        professionType = session.getAttribute(AppConstants.SESSION_PROFESSION_TYPE).toString();
                    }

                    //       System.out.println("--" + topicName + "---" + ecertId + "---" + image.getAbsolutePath() + "--" + status);
                    //    System.out.println("type " + uploadType);
                    if ("update".equalsIgnoreCase(uploadType)) {
                        ServiceLocator.getDashBoardService().updateDocumentDetails(this);
                        setResultMessage("Document details updated successfully");
                    } else {
                        ServiceLocator.getDashBoardService().insertDocumentDetails(this);
                        setResultMessage("Document added successfully");
                    }

                    resultType = SUCCESS;
                }
            } catch (ServiceLocatorException ex) {
                ex.printStackTrace();
                resultType = ERROR;

            }
        }
        return resultType;

    }
    //registercoach det excelsheet
    private String registerCoachExcelSheet;
    private String workshopDetExcelSheet;

    public String exportRegisterCoachDetExcelSheet() {
        System.out.println("entered-----");
        String filename = "getRegisterCoachExcelSheet";
        OutputStream out = null;
        System.out.println("getGridDownload-->" + getGridDownload());
        try {
            filename = filename.concat(".xls");

            httpServletResponse.setContentType("application/vnd.ms-excel");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            int count;
            WritableWorkbook wworkbook;
            wworkbook = Workbook.createWorkbook(httpServletResponse.getOutputStream());
            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
            Label label;
            wsheet.setColumnView(0, 10);
            wsheet.setColumnView(1, 25);
            wsheet.setColumnView(2, 30);
            wsheet.setColumnView(3, 20);
            wsheet.setColumnView(4, 30);
            wsheet.setColumnView(5, 40);
            wsheet.setColumnView(6, 90);
            wsheet.setColumnView(7, 20);
            // wsheet.setColumnView(8, 70);
            // wsheet.setColumnView(9, 70);
            // wsheet.setColumnView(10, 70);
            if (!"".equals(getGridDownload())) {
                String data = DataSourceDataProvider.getInstance().getRegisterCoachExcelDeta(getGridDownload());
                // String data1 = DataSourceDataProvider.getInstance().getFacultyGridData(getGridDownload());

                System.out.println("---------data---------" + data);
                setGridDownload(data);

                WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
                cellFont.setColour(Colour.BLACK);

                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBackground(Colour.LIGHT_BLUE);

                String[] s = getGridDownload().split(Pattern.quote("^"));
                for (int i = 0; i < s.length; i++) {

                    String ss = s[i];
                    String[] inner = ss.split(Pattern.quote("|"));

                    for (int j = 0; j < inner.length; j++) {

                        if (i == 0) {
                            label = new Label(j, i, inner[j], cellFormat);
                            wsheet.addCell(label);
                        } else {
                            label = new Label(j, i, inner[j]);
                            wsheet.addCell(label);
                        }
                    }
                }
            }
            wworkbook.write();
            wworkbook.close();
        } catch (Exception e) {
        } finally {

            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                }

            }
        }
        //  System.out.println("******************** :: doDownloadXlsResults() Action End*********************");
        return null;
    }

    //excel sheet for workshop
    public String exportWorkshopDetExcelSheet() {
        System.out.println("entered-----");
        String filename = "getWorkshopDetExcelSheet";
        OutputStream out = null;
        System.out.println("getGridDownload-->" + getGridDownload());
        try {
            filename = filename.concat(".xls");

            httpServletResponse.setContentType("application/vnd.ms-excel");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            int count;
            WritableWorkbook wworkbook;
            wworkbook = Workbook.createWorkbook(httpServletResponse.getOutputStream());
            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
            Label label;
            wsheet.setColumnView(0, 10);
            wsheet.setColumnView(1, 25);
            wsheet.setColumnView(2, 30);
            wsheet.setColumnView(3, 20);
            wsheet.setColumnView(4, 60);
            wsheet.setColumnView(5, 60);
            wsheet.setColumnView(6, 70);
            wsheet.setColumnView(7, 70);
            wsheet.setColumnView(8, 70);
            wsheet.setColumnView(9, 70);

            if (!"".equals(getGridDownload())) {
                String data = DataSourceDataProvider.getInstance().getWorkshopExcelDeta(getGridDownload());
                // String data1 = DataSourceDataProvider.getInstance().getFacultyGridData(getGridDownload());

                System.out.println("---------data---------" + data);
                setGridDownload(data);

                WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
                cellFont.setColour(Colour.BLACK);

                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                cellFormat.setBackground(Colour.LIGHT_BLUE);

                String[] s = getGridDownload().split(Pattern.quote("^"));
                for (int i = 0; i < s.length; i++) {

                    String ss = s[i];
                    String[] inner = ss.split(Pattern.quote("|"));

                    for (int j = 0; j < inner.length; j++) {

                        if (i == 0) {
                            label = new Label(j, i, inner[j], cellFormat);
                            wsheet.addCell(label);
                        } else {
                            label = new Label(j, i, inner[j]);
                            wsheet.addCell(label);
                        }
                    }
                }
            }
            wworkbook.write();
            wworkbook.close();
        } catch (Exception e) {
        } finally {

            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                }

            }
        }
        //  System.out.println("******************** :: doDownloadXlsResults() Action End*********************");
        return null;
    }

    public void excelSheetForWorkshopregDetails() {
        System.out.println("excelSheetForWorkshopregDetails" + collegeName);
        resultType = INPUT;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            if (httpServletRequest.getSession(false).getAttribute(AppConstants.SESSION_DBUSERNAME) != null) {
                //  setCollegeList(DataSourceDataProvider.getInstance().getCollegeNames());

                String responseString = "";

                String fileLocation = "";
                String query = "SELECT DISTINCT(tblRegistrationDetails.id),CONCAT(FName,' ' ,LName) AS NAME,Email,PhoneNum,ProfessionType,CollegeName,College,tblEnrolledWorkshopTopics.CreatedDate "
                        + "FROM tblEnrolledWorkshopTopics  JOIN tblRegistrationDetails ON (tblRegistrationDetails.id=registredId)  LEFT OUTER JOIN tblLKCollegesList ON (College=tblLKCollegesList.Id) "
                        + "WHERE tblEnrolledWorkshopTopics.workshopCode = '" + workshopCode + "'  GROUP BY tblRegistrationDetails.id";
                // System.out.println("query in query action-->" + query.toString());
                //  queryString = "SELECT CONCAT(FName,' ' ,LName) as NAME,Email,PhoneNum FROM tblRegistrationDetails where 1=1";
                fileLocation = ServiceLocator.getDashBoardService().excelSheetForWorkshopregDetails(this, query);
                //  System.out.println("fileLocation-->" + fileLocation);
                httpServletResponse.setContentType("application/force-download");

                if (!"".equals(fileLocation)) {
                    File file = new File(fileLocation);

                    //   File file = new File("D:\\usr\\local\\ProjectFiles\\RegistratioDetails\\details.xls");
                    System.out.println("--------->" + file.getAbsolutePath());
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
                    httpServletRequest.setAttribute(AppConstants.RESULT_MESSAGE, resultMessage);

                }
            }//Close Session Checking
        } catch (FileNotFoundException ex) {
            try {
                ex.printStackTrace();
                httpServletResponse.sendRedirect("../general/exception.action?exceptionMessage='No File found'");
            } catch (IOException ex1) {
                ex1.printStackTrace();
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


    }

    public String registerWorkshop() {
        // System.out.println("----register1-------"); 
        return SUCCESS;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public List getDocRepoList() {
        return docRepoList;
    }

    public void setDocRepoList(List docRepoList) {
        this.docRepoList = docRepoList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * @return the generalVTO
     */
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
     * @return the topicName
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * @param topicName the topicName to set
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * @return the DATE
     */
    public String getDATE() {
        return DATE;
    }

    /**
     * @param DATE the DATE to set
     */
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    /**
     * @return the topicLink
     */
    public String getTopicLink() {
        return topicLink;
    }

    /**
     * @param topicLink the topicLink to set
     */
    public void setTopicLink(String topicLink) {
        this.topicLink = topicLink;
    }

    /**
     * @return the workshopList
     */
    public List getWorkshopList() {
        return workshopList;
    }

    /**
     * @param workshopList the workshopList to set
     */
    public void setWorkshopList(List workshopList) {
        this.workshopList = workshopList;
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
     * @return the sno
     */
    public int getSno() {
        return sno;
    }

    /**
     * @param sno the sno to set
     */
    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public HttpServletRequest getServletRequest() {
        return httpServletRequest;
    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public boolean isWorkshopEnabled() {
        return workshopEnabled;
    }

    public void setWorkshopEnabled(boolean workshopEnabled) {
        this.workshopEnabled = workshopEnabled;
    }

    public String getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(String workshopId) {
        this.workshopId = workshopId;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getWorkshopStatus() {
        return workshopStatus;
    }

    public void setWorkshopStatus(String workshopStatus) {
        this.workshopStatus = workshopStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfessionType() {
        return professionType;
    }

    public void setProfessionType(String professionType) {
        this.professionType = professionType;
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
     * @return the collegeName
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * @param collegeName the collegeName to set
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * @return the contacts
     */
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    /**
     * @return the contactDetails
     */
    public String getContactDetails() {
        return contactDetails;
    }

    /**
     * @param contactDetails the contactDetails to set
     */
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * @return the currentExamReviewCollection
     */
    public Collection getCurrentExamReviewCollection() {
        return currentExamReviewCollection;
    }

    /**
     * @param currentExamReviewCollection the currentExamReviewCollection to set
     */
    public void setCurrentExamReviewCollection(Collection currentExamReviewCollection) {
        this.currentExamReviewCollection = currentExamReviewCollection;
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

    /**
     * @return the examId
     */
    public int getExamId() {
        return examId;
    }

    /**
     * @param examId the examId to set
     */
    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getEnrollTopics() {
        return enrollTopics;
    }

    public void setEnrollTopics(String enrollTopics) {
        this.enrollTopics = enrollTopics;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkshopByTopic() {
        return workshopByTopic;
    }

    public void setWorkshopByTopic(String workshopByTopic) {
        this.workshopByTopic = workshopByTopic;
    }

    public List getWorkshopDetailsList() {
        return workshopDetailsList;
    }

    public void setWorkshopDetailsList(List workshopDetailsList) {
        this.workshopDetailsList = workshopDetailsList;
    }

    public String getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(String topicsList) {
        this.topicsList = topicsList;
    }

    public String getWorkshopCode() {
        return workshopCode;
    }

    public void setWorkshopCode(String workshopCode) {
        this.workshopCode = workshopCode;
    }

    public int getTopicEnable() {
        return topicEnable;
    }

    public void setTopicEnable(int topicEnable) {
        this.topicEnable = topicEnable;
    }

    public int getEnrolledTotalTopics() {
        return enrolledTotalTopics;
    }

    public void setEnrolledTotalTopics(int enrolledTotalTopics) {
        this.enrolledTotalTopics = enrolledTotalTopics;
    }

    public int getTotalTopics() {
        return totalTopics;
    }

    public void setTotalTopics(int totalTopics) {
        this.totalTopics = totalTopics;
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
     * @return the codegenerate
     */
    public String getCodegenerate() {
        return codegenerate;
    }

    /**
     * @param codegenerate the codegenerate to set
     */
    public void setCodegenerate(String codegenerate) {
        this.codegenerate = codegenerate;
    }

    /**
     * @return the collegeMenuList
     */
    public List getCollegeMenuList() {
        return collegeMenuList;
    }

    /**
     * @param collegeMenuList the collegeMenuList to set
     */
    public void setCollegeMenuList(List collegeMenuList) {
        this.collegeMenuList = collegeMenuList;
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

    public Map getCollegeMap() {
        return collegeMap;
    }

    public void setCollegeMap(Map collegeMap) {
        this.collegeMap = collegeMap;
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

    public String getStudentBranch3() {
        return studentBranch3;
    }

    public void setStudentBranch3(String studentBranch3) {
        this.studentBranch3 = studentBranch3;
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

    public String getStudentEmail3() {
        return studentEmail3;
    }

    public void setStudentEmail3(String studentEmail3) {
        this.studentEmail3 = studentEmail3;
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

    public String getStudentPhoneNumber3() {
        return studentPhoneNumber3;
    }

    public void setStudentPhoneNumber3(String studentPhoneNumber3) {
        this.studentPhoneNumber3 = studentPhoneNumber3;
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

    public String getStudentYear3() {
        return studentYear3;
    }

    public void setStudentYear3(String studentYear3) {
        this.studentYear3 = studentYear3;
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

    public String getStudentname3() {
        return studentname3;
    }

    public void setStudentname3(String studentname3) {
        this.studentname3 = studentname3;
    }

    /**
     * @return the enrollCollegeMenuList
     */
    public List getEnrollCollegeMenuList() {
        return enrollCollegeMenuList;
    }

    /**
     * @param enrollCollegeMenuList the enrollCollegeMenuList to set
     */
    public void setEnrollCollegeMenuList(List enrollCollegeMenuList) {
        this.enrollCollegeMenuList = enrollCollegeMenuList;
    }

    public String getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(String collegeList) {
        this.collegeList = collegeList;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCurrculamId() {
        return currculamId;
    }

    public void setCurrculamId(String currculamId) {
        this.currculamId = currculamId;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }

    public Map getTopicsMap() {
        return topicsMap;
    }

    public void setTopicsMap(Map topicsMap) {
        this.topicsMap = topicsMap;
    }

    /**
     * @return the enrollExcelSheet
     */
    public String getEnrollExcelSheet() {
        return enrollExcelSheet;
    }

    /**
     * @param enrollExcelSheet the enrollExcelSheet to set
     */
    public void setEnrollExcelSheet(String enrollExcelSheet) {
        this.enrollExcelSheet = enrollExcelSheet;
    }

    /**
     * @return the gridDownload
     */
    public String getGridDownload() {
        return gridDownload;
    }

    /**
     * @param gridDownload the gridDownload to set
     */
    public void setGridDownload(String gridDownload) {
        this.gridDownload = gridDownload;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getStartExamEnable() {
        return startExamEnable;
    }

    public void setStartExamEnable(int startExamEnable) {
        this.startExamEnable = startExamEnable;
    }

    /**
     * @return the coachDetailsList
     */
    public List getCoachDetailsList() {
        return coachDetailsList;
    }

    /**
     * @param coachDetailsList the coachDetailsList to set
     */
    public void setCoachDetailsList(List coachDetailsList) {
        this.coachDetailsList = coachDetailsList;
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
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkshopFormType() {
        return workshopFormType;
    }

    public void setWorkshopFormType(int workshopFormType) {
        this.workshopFormType = workshopFormType;
    }

    public int getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(int workshopType) {
        this.workshopType = workshopType;
    }

    public int getExamExistInHubble() {
        return examExistInHubble;
    }

    public void setExamExistInHubble(int examExistInHubble) {
        this.examExistInHubble = examExistInHubble;
    }

    /**
     * @return the profissionType
     */
    public String getProfissionType() {
        return profissionType;
    }

    /**
     * @param profissionType the profissionType to set
     */
    public void setProfissionType(String profissionType) {
        this.profissionType = profissionType;
    }

    /**
     * @return the registraintsDetailsList
     */
    public List getRegistraintsDetailsList() {
        return registraintsDetailsList;
    }

    /**
     * @param registraintsDetailsList the registraintsDetailsList to set
     */
    public void setRegistraintsDetailsList(List registraintsDetailsList) {
        this.registraintsDetailsList = registraintsDetailsList;
    }

    public String getBlogs() {
        return blogs;
    }

    public void setBlogs(String blogs) {
        this.blogs = blogs;
    }

    public String getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }

    public String getDocumentFileName() {
        return documentFileName;
    }

    public void setDocumentFileName(String documentFileName) {
        this.documentFileName = documentFileName;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public List getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List documentList) {
        this.documentList = documentList;
    }

    public int getEcertId() {
        return ecertId;
    }

    public void setEcertId(int ecertId) {
        this.ecertId = ecertId;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public List getTopicList() {
        return topicList;
    }

    public void setTopicList(List topicList) {
        this.topicList = topicList;
    }

    public String getTutorials() {
        return tutorials;
    }

    public void setTutorials(String tutorials) {
        this.tutorials = tutorials;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getVideoTutorail() {
        return videoTutorail;
    }

    public void setVideoTutorail(String videoTutorail) {
        this.videoTutorail = videoTutorail;
    }

    public String getWebExName() {
        return webExName;
    }

    public void setWebExName(String webExName) {
        this.webExName = webExName;
    }

    public String getWebExUrl() {
        return webExUrl;
    }

    public void setWebExUrl(String webExUrl) {
        this.webExUrl = webExUrl;
    }

    public String getWebsitelink() {
        return websitelink;
    }

    public void setWebsitelink(String websitelink) {
        this.websitelink = websitelink;
    }

    /**
     * @return the registerCoachExcelSheet
     */
    public String getRegisterCoachExcelSheet() {
        return registerCoachExcelSheet;
    }

    /**
     * @param registerCoachExcelSheet the registerCoachExcelSheet to set
     */
    public void setRegisterCoachExcelSheet(String registerCoachExcelSheet) {
        this.registerCoachExcelSheet = registerCoachExcelSheet;
    }

    /**
     * @return the workshopDetExcelSheet
     */
    public String getWorkshopDetExcelSheet() {
        return workshopDetExcelSheet;
    }

    /**
     * @param workshopDetExcelSheet the workshopDetExcelSheet to set
     */
    public void setWorkshopDetExcelSheet(String workshopDetExcelSheet) {
        this.workshopDetExcelSheet = workshopDetExcelSheet;
    }
}
