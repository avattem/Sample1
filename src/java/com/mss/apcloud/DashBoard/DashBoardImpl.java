/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.DashBoard;

import com.mss.apcloud.general.GeneralVTO;
import com.mss.apcloud.techdetails.MeterialsVTO;
import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.DateUtility;
import com.mss.apcloud.util.ServiceLocatorException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author miracle
 */
public class DashBoardImpl implements DashBoardService {

  public List getDashBoardDetails(String workShopIds, String college, String professionType) throws ServiceLocatorException {
        // System.out.println("entered----getDashBoardDetails-----");
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        //  String queryString1="";
        List workshopList = new ArrayList();
        connection = ConnectionProvider.getInstance().getConnection();
        //  System.out.println("-first---");
        String sessionname;
        String location;
        String date;
        String duration;
        String workshopStatus;

        // String queryString = "Select Id,CODE,DATE,CollegeName,TopicName,TopicLink,Location FROM tblWorkshop WHERE ;
        // String queryString = "Select Id,CODE,DATE,CollegeName,TopicName,TopicLink,Location FROM tblWorkshop WHERE 1=1";
//        String queryString = "SELECT tblWorkshop.CollegeName,tblWorkshop.Id,tblWorkshop.CODE,tblWorkshop.DATE,tblWorkshop.TopicId,tblLKTopics.TopicName,"
//                + " tblLKTopics.TopicLink,tblWorkshop.Location FROM tblWorkshop "
//                + " LEFT JOIN tblLKTopics ON (tblWorkshop.Topicid=tblLKTopics.id)"
//                + " WHERE 1=1";
//        String queryString = "SELECT tblWorkshop.id,tblWorkshop.CODE,tblWorkshop.DATE,tblLKCollegesList.CollegeName,tblLKCollegesList.id  AS collegeid,tblLKCollegesList.Location,tblLKCollegesList.Website, tblWorkshop.Id"
//                + " FROM tblLKCollegesList "
//                + " JOIN tblWorkshop ON (tblWorkshop.CollegeName=tblLKCollegesList.id)"
//                + " WHERE 1=1";
        String queryString = "SELECT tblWorkshop.id,tblWorkshop.CODE,tblWorkshop.DATE,tblLKCollegesList.CollegeName,tblLKCollegesList.Id  AS collegeid, tblWorkshop.CollegeName  AS companyName,tblWorkshop.Location,tblLKCollegesList.Website, tblWorkshop.Id, tblWorkshop.workshopType"
                + " FROM tblWorkshop  "
                + " LEFT OUTER JOIN tblLKCollegesList ON (tblWorkshop.CollegeName=tblLKCollegesList.id)"
                + " WHERE 1=1";
        //  String queryString = "Select Id,CODE,DATE,CollegeName,TopicName,TopicLink,Location  from tblWorkshop";
           /* String queryString = "SELECT tblWorkshop.CODE,tblWorkshop.DATE,tblLKCollegesList.CollegeName,tblLKCollegesList.Location"
         + " FROM tblLKCollegesList "
         + " JOIN tblWorkshop ON (tblWorkshop.CollegeName=tblLKCollegesList.id)"
         + " WHERE 1=1";*/
        boolean workshopEnabled = false;

        //    System.out.println("--query execuute--" + queryString);

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                GeneralVTO generalVTO = new GeneralVTO();
                generalVTO.setCode(resultSet.getString("CODE"));
                generalVTO.setCollegeId(resultSet.getString("collegeid"));
                generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
//                generalVTO.setCollegeName(resultSet.getString("CollegeName"));

                 if (resultSet.getInt("workshopType") == 1) {
                 
                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));
                     generalVTO.setLink(resultSet.getString("Website"));
                } else {
                    generalVTO.setCollegeName(resultSet.getString("companyName"));
                     generalVTO.setLink("#");
                }
                generalVTO.setLocation(resultSet.getString("Location"));
                generalVTO.setId(resultSet.getInt("Id"));
//                generalVTO.setLink(resultSet.getString("Website"));

                //System.out.println("resultSet.getIntid -->" + resultSet.getInt("Id"));
                String workshopId = resultSet.getInt("Id") + "";


//                System.out.println("daet=-->" + DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                date = DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString());
//                generalVTO.setDATE(date);
                if (dateComparision(date).equals("after")) {
                    workshopStatus = "Pending";
                } else {
                    workshopStatus = "Completed";
                }

                //    System.out.println("--third---" + resultSet.getString("CollegeName"));
                generalVTO.setWorkshopStatus(workshopStatus);

                if (workShopIds != null && !"".equals(workShopIds)) {
                    workshopEnabled = DataSourceDataProvider.getInstance().getEnrollWorkshopIds(workShopIds, workshopId);
                    //System.out.println("workshopId------->" + workshopId + "----->" + workshopEnabled);
                }
                generalVTO.setWorkshopEnabled(workshopEnabled);
                workshopList.add(generalVTO);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServiceLocatorException(ex);
        } finally {

            try {
                // resultSet Object Checking if it's null then close and set null
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
            } catch (SQLException ex) {
                throw new ServiceLocatorException(ex);
            }
        }
        return workshopList;
    }


    public String dateComparision(String Date) {
        String returnMsg = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date date1 = sdf.parse(Date);
            Date date2 = sdf.parse(DateUtility.getInstance().getCurrentMySqlDate());
            if (date1.after(date2)) {
                returnMsg = "after";
            } else {
                returnMsg = "before";
            }
        } catch (ServiceLocatorException ex) {

            Logger.getLogger(DashBoardImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DashBoardImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnMsg;
    }

    public String enrollWorkshop(String workshopId, String email, String workshopIds) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String enrollWorkhopIds = "";
        //String query = "SELECT EnrolledWorkshopIds FROM tblRegistrationDetails WHERE email='" + email + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            // preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
            if (workshopIds != null && !"".equals(workshopIds)) {

                enrollWorkhopIds = workshopIds + "," + workshopId;
                //   System.out.println("her------>" + enrollWorkhopIds);
            } else {
                enrollWorkhopIds = workshopId;
            }
            // }

            String query1 = "update tblRegistrationDetails set EnrolledWorkshopIds='" + enrollWorkhopIds + "' WHERE email='" + email + "'";
            preparedStatement = connection.prepareStatement(query1);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return "success";
            } else {
                return "error";
            }
            //System.err.println("Result----" + response);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }


    }

      public List getDashboardWorkshop(String workShopIds, String contactDetails, String college, String professionType) throws ServiceLocatorException {

        String workshopIds = "";
        String projectType = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List workshopList = new ArrayList();
        // resultType = INPUT;
//
        //   System.out.println("workshopids====" + workshopIds);

        connection = ConnectionProvider.getInstance().getConnection();
        String sessionname;
        String location;
        String date;
        String duration;
        //  String queryString = "Select Id,CODE,DATE,TopicName,TopicLink,Location  from tblWorkshop";
        //    String queryString = "Select Id,CODE,DATE,CollegeName,TopicName,Location,Contact  from tblWorkshop";
        String queryString = "SELECT tblWorkshop.id,tblWorkshop.CODE,tblWorkshop.DATE,DATE_FORMAT(tblWorkshop.DATE,'%d-%m-%Y') AS WorkShopDate,tblLKCollegesList.CollegeName,tblLKCollegesList.Id  AS collegeid, tblWorkshop.CollegeName  AS companyName,tblWorkshop.Location,tblLKCollegesList.Website, tblWorkshop.Id, tblWorkshop.workshopType"
                + " FROM tblWorkshop  "
                + " LEFT OUTER JOIN tblLKCollegesList ON (tblWorkshop.CollegeName=tblLKCollegesList.id)"
                + " WHERE 1=1";
        boolean workshopEnabled = false;
       // System.out.println("queryString-->"+queryString);
        
//        if (professionType != null && !"".equals(professionType)) {
//            if (professionType.equals("1")) {
//                queryString += " and tblWorkshop.CollegeName LIKE '" + college + "%'";
//                //System.out.println("----second----" + queryString);
//            }
//        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                GeneralVTO generalVTO = new GeneralVTO();
                //generalVTO.setId(resultSet.getInt("Id"));

                //String workshopId = resultSet.getInt("Id") + "";
                generalVTO.setCode(resultSet.getString("CODE"));
                generalVTO.setCollegeId(resultSet.getString("collegeid"));
                
                //WorkShopDate
                generalVTO.setDATE(resultSet.getString("WorkShopDate"));
               // generalVTO.setDATE(resultSet.getString("DATE"));
                if (resultSet.getInt("workshopType") == 1) {

                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));
                    generalVTO.setLink(resultSet.getString("Website"));
                } else {
                    generalVTO.setCollegeName(resultSet.getString("companyName"));
                    generalVTO.setLink("#");
                }
                generalVTO.setLocation(resultSet.getString("Location"));
                generalVTO.setId(resultSet.getInt("Id"));
//                
//                generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
//                generalVTO.setCollegeName(resultSet.getString("CollegeName"));
//                generalVTO.setId(resultSet.getInt("Id"));
//                generalVTO.setLink(resultSet.getString("Website"));
//
//                generalVTO.setLocation(resultSet.getString("Location"));



                workshopList.add(generalVTO);

            }
            // enrollWorkshop();


            // System.out.println("------end----");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                // resultSet Object Checking if it's null then close and set null
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
            } catch (SQLException ex) {
                throw new ServiceLocatorException(ex);
            }
        }
        //   }
        return workshopList;
    }

    public List getTechTopicData(String enrollTopics) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List docRepoList = new ArrayList();
        boolean topicsEnrolled = false;

        String query = "SELECT id,topicname,topiclink,imageurls FROM tblLKTopics WHERE Status='Active'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MeterialsVTO meterialsVTO = new MeterialsVTO();
                meterialsVTO.setTopicId(resultSet.getInt("id"));
                meterialsVTO.setTopicName(resultSet.getString("topicname"));
                if (enrollTopics != null && !"".equals(enrollTopics)) {
                    topicsEnrolled = DataSourceDataProvider.getInstance().getEnrollWorkshopIds(enrollTopics, resultSet.getInt("id") + "");

                }
                meterialsVTO.setTopicEnabled(topicsEnrolled);
                // System.out.println("-------->"+resultSet.getString("topicname"));
                meterialsVTO.setImagePath(resultSet.getString("imageurls"));
                docRepoList.add(meterialsVTO);
            }



            /// System.err.println("Result----" + docRepoList.size());
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return docRepoList;
    }

    public String updateDetails(DashBoardAction dashBoardAction,String professionType) throws ServiceLocatorException {
        //       System.out.println("herte"+registrationAction.getLastname());
        //System.out.println("here");


        String result = "";
        String query = "";
        int updatedRows = 0;
        Connection connection = null;
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;



        /*@param primaryAction used to store actions*///name
        try {

            // DataSourceDataProvider.getInstance().   spCreConsultantDetails
            connection = ConnectionProvider.getInstance().getConnection();
          
            int i1 = dashBoardAction.getId();



           //FName LName UPDATE tblRegistrationDetails SET  FName='sai',LName='ramm'  WHERE id="280"

            query = "UPDATE tblRegistrationDetails SET  FName=?,LName=?,PhoneNum=?,College=?,CompanyName=?,Salary=?   WHERE id=" + i1;

            pstatement = connection.prepareStatement(query);

           pstatement.setString(1, dashBoardAction.getFirstName());
            //System.out.println("name------"+dashBoardAction.getFirstName());
            pstatement.setString(2, dashBoardAction.getLastName());
           //  System.out.println("name------"+dashBoardAction.getLastName());
            pstatement.setString(3, dashBoardAction.getPhoneNumber());
             if (professionType.equals("1")) 
            {
                    
                    pstatement.setString(4, dashBoardAction.getCollegeId());

                } else if (professionType.equals("2")) {
                   
                     pstatement.setString(4, dashBoardAction.getCompanyName());

                }
            else if (professionType.equals("3")) {
                   
                     pstatement.setString(4, dashBoardAction.getCollegeId());

                }
            
            
          //  pstatement.setString(4, dashBoardAction.getCollegeId());
            pstatement.setString(5, dashBoardAction.getCompanyName());
            pstatement.setString(6, dashBoardAction.getSalary());

            updatedRows = pstatement.executeUpdate();

            if (updatedRows > 0) {
                result = "success";
            }




        } catch (SQLException se) {
            throw new ServiceLocatorException(se);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (pstatement != null) {
                    pstatement.close();
                    pstatement = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException se) {
                throw new ServiceLocatorException(se);
            }
        }

        return result;
    }

    /*
    Exam Result
     * Author : Santosh Kola
     * Date : 07/10/2016
     */
    public Collection getMcertExamReviewCollection(int creId, int noOfRecords) throws ServiceLocatorException {
        Map creExamReviewMap = new TreeMap();
        int counter = 1;
        String tempCreatedDate = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //String queryString = "SELECT * FROM tblCreVPComments WHERE CreId="+creId+" AND  DeletedFlag != 1 ORDER BY CretedDate DESC";
            String queryString = "SELECT tblMcertResult.ExamKeyId AS examKeyId,tblMcertResult.EmpId AS empId,Marks,TotalQuestions,AttemptedQuestions,DateSubmitted,ExamStatus,tblMcertKey.ExamTypeId,tblMcertSetExam.ExamType AS examType FROM tblMcertResult LEFT JOIN tblMcertKey ON tblMcertKey.ID=tblMcertResult.ExamKeyId LEFT JOIN tblMcertSetExam  ON tblMcertSetExam.Id=tblMcertKey.ExamTypeId WHERE tblMcertResult.EmpId = 'MSSMCERT" + creId + "'";
            // System.out.println("Cre Exam Review Query-->"+queryString);
            connection = ConnectionProvider.getInstance().getHubbleDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                if (counter <= noOfRecords) {
                    ExamReviewVTO creExamReviewVTO = new ExamReviewVTO();
                    creExamReviewVTO.setMcertLoginId(resultSet.getString("empId"));
                    creExamReviewVTO.setExamTypeName(resultSet.getString("examType"));
                    creExamReviewVTO.setMarks(resultSet.getInt("Marks"));
                    creExamReviewVTO.setTotalQuestions(resultSet.getInt("TotalQuestions"));
                    creExamReviewVTO.setAttemptedQuestions(resultSet.getInt("AttemptedQuestions"));
                    creExamReviewVTO.setDateSubmitted(resultSet.getString("DateSubmitted"));
                    creExamReviewVTO.setExamStatus(resultSet.getString("ExamStatus"));
                    creExamReviewVTO.setExamKeyId(String.valueOf(resultSet.getInt("examKeyId")));
                    creExamReviewMap.put("examVTO" + counter, creExamReviewVTO);
                    counter++;
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
            throw new ServiceLocatorException(se);
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
            } catch (SQLException se) {
                se.printStackTrace();
                throw new ServiceLocatorException(se);
            }
        }
        return creExamReviewMap.values();
    }

    /*
    Start exam enable values and description 
    -1      Exam date graterthan current date
    0       Exam is enable or exam date lessthan current date
    1       Exam has been already completed
     */
   public List getAvailableCertifications(int userId, String professionType) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List docRepoList = new ArrayList();
        String query = "";

        //  query = "SELECT id,topicname,topiclink,imageurls,ExamId FROM tblLKTopics WHERE 1=1 AND Status='Active' ";
//        if (professionType != null && !"".equals(professionType)) {
//            if (professionType.equals("1")) {
        query = "SELECT DISTINCT (TopicName),tblLKTopics.id,DATE,DurationTime,ExamId,WorkshopCode FROM tblLKTopics LEFT OUTER JOIN tblCurriculam ON(tblLKTopics.id=TopicId) WHERE 1=1 AND STATUS='Active'";
        query += " AND tblLKTopics.id IN(SELECT enrollTopics FROM tblEnrolledWorkshopTopics WHERE registredId=" + userId + ") AND WorkshopCode IN (SELECT workshopCode FROM tblEnrolledWorkshopTopics WHERE registredId=" + userId + ") GROUP BY tblLKTopics.id";
        //System.out.println("----second----" + queryString);
//            }
//        }



     //   System.out.println("query--->" + query);
        try {
            List<Integer> examCompletedList = DataSourceDataProvider.getInstance().getExamCompletedList(userId);
            List<Integer> examExistedHubbleList = DataSourceDataProvider.getInstance().getExamExistedHubbleList();
            
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            MeterialsVTO meterialsVTO;
            while (resultSet.next()) {
                meterialsVTO = new MeterialsVTO();
                meterialsVTO.setTopicId(resultSet.getInt("id"));
                meterialsVTO.setTopicName(resultSet.getString("topicname"));

//                if (professionType != null && !"".equals(professionType)) {
//                    if (professionType.equals("1")) {
                String date = resultSet.getString("DATE");
                meterialsVTO.setDate(DateUtility.getInstance().convertToviewFormat(resultSet.getString("DATE")));
                //String duration = resultSet.getString("DurationTime");
                meterialsVTO.setDurationTime(resultSet.getString("DurationTime"));
                if (dateAndTimeComparision(date).equals("after")) {

                    meterialsVTO.setStartExamEnable(-1);
                   // System.out.println("----meterialsVTO----");
                } else {
                    boolean examCompleted = DataSourceDataProvider.getInstance().isExamCompleted(examCompletedList, resultSet.getInt("ExamId"));
                    if (!examCompleted) {
                        meterialsVTO.setStartExamEnable(0);
                    } else {
                        meterialsVTO.setStartExamEnable(1);
                    }
                }
//                        
//                    }
                //   }
                //System.out.println("Exam Completed-------->" + DataSourceDataProvider.getInstance().isExamCompleted(examCompletedList, resultSet.getInt("ExamId")));
                //  meterialsVTO.setImagePath(resultSet.getString("imageurls"));
                
                if(examExistedHubbleList.contains(resultSet.getInt("ExamId")))
                {
                    meterialsVTO.setExamExistInHubble(0);
                }else
                {
                    meterialsVTO.setExamExistInHubble(1);
                }
                meterialsVTO.setExamId(resultSet.getInt("ExamId"));
                docRepoList.add(meterialsVTO);
            }



            /// System.err.println("Result----" + docRepoList.size());
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return docRepoList;
    }

    public String dateAndTimeComparision(String Date) {
        String returnMsg = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("IST"));
            Date date1 = sdf.parse(Date);
          //  System.out.println("date1 -->" + date1);
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
            Date date2 = sdf2.parse(DateUtility.getInstance().getCurrentMySqlDate());
           // System.out.println("date2 -->" + date2);
            if (date1.after(date2)) {
                returnMsg = "after";
            } else {
                returnMsg = "before";
            }
           // System.out.println("--------?" + returnMsg);
        } catch (ServiceLocatorException ex) {
            Logger.getLogger(DashBoardImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DashBoardImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnMsg;
    }

    public List getWorkshopDetailsTopicWise(int userId) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List workshopDetailsList = new ArrayList();
        String status;
        String query = "SELECT Code,date FROM tblWorkshop WHERE 1=1 ";
        query += " AND   FIND_IN_SET(CODE,(SELECT CAST(GROUP_CONCAT(workshopCode SEPARATOR ',') AS CHAR)  FROM tblEnrolledWorkshopTopics WHERE registredId=" + userId + "))";
//        String query = " SELECT tblCurriculam.DATE,tblCurriculam.TopicId,tblCurriculam.TopicName,tblCurriculam.DurationTime,tblCurriculam.WorkshopCode,tblWorkshop.CollegeName ";
//        query += "FROM tblCurriculam JOIN tblWorkshop ON (tblCurriculam.WorkshopCode=tblWorkshop.CODE) WHERE tblCurriculam.TopicId IN(" + enrolledTopics + ") and tblWorkshop.CollegeName=" + collegeId;

        // System.out.println("query in getWorkshopDetailsTopicWise--> " + query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GeneralVTO generalVTO = new GeneralVTO();
                generalVTO.setCode(resultSet.getString("Code"));
                generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getString("DATE")));
                String date = DateUtility.getInstance().convertToviewFormat(resultSet.getString("DATE"));
                dateComparision(date);
                if (dateComparision(date).equals("after")) {
                    status = "Upcoming";
                    generalVTO.setStatus(status);
                } else {

                    status = "Completed";
                    generalVTO.setStatus(status);
                }
                // System.out.println("-------->"+resultSet.getString("topicname"));

                workshopDetailsList.add(generalVTO);
            }



            /// System.err.println("Result----" + docRepoList.size());
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return workshopDetailsList;
    }

    public String getWorkshopTopics(DashBoardAction dashBoardAction) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List docRepoList = new ArrayList();
        String topicsList = "";
        boolean topicsEnrolled = false;
        String enrollTopics = "";
        int totalTopics = 0;
        int enrolledTotalTopics = 0;
//        String query = "SELECT tblLKTopics.id,tblLKTopics.topicname,tblLKTopics.topiclink,tblLKTopics.imageurls,tblCurriculam.WorkshopCode";
//        query += " FROM tblLKTopics JOIN tblCurriculam ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblCurriculam.WorkshopCode='" + dashBoardAction.getWorkshopCode() + "' AND tblLKTopics.Status='Active' order by tblCurriculam.TopicID";
        String query = "SELECT DISTINCT(tblLKTopics.id),tblLKTopics.topicname,tblLKTopics.topiclink,tblLKTopics.imageurls,tblCurriculam.WorkshopCode";
        query += " FROM tblLKTopics JOIN tblCurriculam ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblCurriculam.WorkshopCode='" + dashBoardAction.getWorkshopCode() + "' AND tblLKTopics.Status='Active' order by tblCurriculam.TopicID";

        try {
            //  System.out.println("query--->" + query);
            connection = ConnectionProvider.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            enrollTopics = DataSourceDataProvider.getInstance().getEnrolledTopicsList(dashBoardAction.getUserId(), dashBoardAction.getWorkshopCode());
            while (resultSet.next()) {

                totalTopics++;

                MeterialsVTO meterialsVTO = new MeterialsVTO();
                meterialsVTO.setTopicId(resultSet.getInt("id"));
                meterialsVTO.setTopicName(resultSet.getString("topicname"));
                if (enrollTopics != null && !"".equals(enrollTopics)) {
                    topicsEnrolled = DataSourceDataProvider.getInstance().getEnrollWorkshopIds(enrollTopics, resultSet.getInt("id") + "");
                    //System.out.println("topicsEnrolled------->" + resultSet.getInt("id") + "----->" + topicsEnrolled);
                }
                if (topicsEnrolled) {
                    enrolledTotalTopics++;
                } else {
                    if (i < 1) {
                        topicsList += resultSet.getInt("id");
                    } else {
                        topicsList += "," + resultSet.getInt("id");
                    }

                    i++;
                }
                meterialsVTO.setTopicEnabled(topicsEnrolled);
                // System.out.println("-------->"+resultSet.getString("topicname"));
                meterialsVTO.setImagePath(resultSet.getString("imageurls"));
                docRepoList.add(meterialsVTO);
            }
            dashBoardAction.setTotalTopics(totalTopics);
            dashBoardAction.setEnrolledTotalTopics(enrolledTotalTopics);


            /// System.err.println("Result----" + docRepoList.size());
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        dashBoardAction.setTopicsList(topicsList);
        dashBoardAction.setDocRepoList(docRepoList);
        return "success";
    }

    public List leftMenuCollege(String collegeCode, String college, String location, String codeGenerate, String link, String frmDate, String toDate) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List workshopList = new ArrayList();



        String query = "SELECT id,CollegeCode,CollegeName,Code,Website,Location,CreatedDate,ModifiedDate FROM tblLKCollegesList where 1=1";
        if (frmDate != null && !"".equals(frmDate)) {
            query += (" AND CreatedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");
            // query += (" OR ModifiedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");

        }
        if (toDate != null && !"".equals(toDate)) {
            query += (" AND CreatedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");
            //query += (" OR ModifiedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");

        }

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            GeneralVTO generalVTO;
            while (resultSet.next()) {
                generalVTO = new GeneralVTO();



                //  generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                generalVTO.setCollegeCode(resultSet.getString("CollegeCode"));

                generalVTO.setCollegeName(resultSet.getString("CollegeName"));


                generalVTO.setCode(resultSet.getString("Code"));

                generalVTO.setLink(resultSet.getString("Website"));
                generalVTO.setLocation(resultSet.getString("Location"));
                generalVTO.setFrmDate(resultSet.getString("CreatedDate"));


                generalVTO.setToDate(resultSet.getString("ModifiedDate"));




                //    response = resultSet.getInt("Id") + "" + resultSet.getString("CollegeName") + "" + resultSet.getString("Website");

                workshopList.add(generalVTO);

            }
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return workshopList;
    }

    public String getEnolledCollegeDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT  tblEnrollCollegeDetails.id,tblEnrollCollegeDetails.FacultyName,tblEnrollCollegeDetails.Fac_PhoneNum, tblEnrollCollegeDetails.Fac_Email,";
        query += " tblEnrollCollegeDetails.Student1Name, tblEnrollCollegeDetails.Student1Email,tblEnrollCollegeDetails.Student1Branch,tblEnrollCollegeDetails.Student1Year,";
        query += "tblEnrollCollegeDetails.Student1PhoneNum,tblEnrollCollegeDetails.Student2Name,tblEnrollCollegeDetails.Student2Email, tblEnrollCollegeDetails.Student2PhoneNum,tblEnrollCollegeDetails.Student2Branch,tblEnrollCollegeDetails.Student2Year, ";
        query += "tblEnrollCollegeDetails.Student3Name, tblEnrollCollegeDetails.Student3Email, tblEnrollCollegeDetails.Student3PhoneNum,tblEnrollCollegeDetails.Student3Branch,tblEnrollCollegeDetails.Student3Year, ";
        query += "tblEnrollCollegeDetails.Student4Name, tblEnrollCollegeDetails.Student4Email, tblEnrollCollegeDetails.Student4PhoneNum,tblEnrollCollegeDetails.Student4Branch,tblEnrollCollegeDetails.Student4Year,tblEnrollCollegeDetails.CollegeName,tblEnrollCollegeDetails.code,tblEnrollCollegeDetails.location,tblEnrollCollegeDetails.collegeCode ";
        query += " FROM tblEnrollCollegeDetails  WHERE tblEnrollCollegeDetails.CollegeName =" + dashBoardAction.getCollegeId() + " AND tblEnrollCollegeDetails.Fac_Email='" + dashBoardAction.getEmail() + "'";


        try {
            // System.out.println("query--->" + query);
            connection = ConnectionProvider.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int i = 0;

            if (resultSet.next()) {
                dashBoardAction.setId(resultSet.getInt("id"));
                dashBoardAction.setCollegeName(resultSet.getString("collegeName"));
                dashBoardAction.setCollegeId(resultSet.getString("collegeCode"));
                dashBoardAction.setLocation(resultSet.getString("location"));
                dashBoardAction.setCode(resultSet.getString("code"));
                dashBoardAction.setFacultyambassadorName(resultSet.getString("FacultyName"));
                dashBoardAction.setFacultyambassadorEmail(resultSet.getString("Fac_Email"));
                dashBoardAction.setFacultyambassadorPhoneNumber(resultSet.getString("Fac_PhoneNum"));

                dashBoardAction.setStudentname(resultSet.getString("Student1Name"));
                dashBoardAction.setStudentEmail(resultSet.getString("Student1Email"));
                dashBoardAction.setStudentPhoneNumber(resultSet.getString("Student1PhoneNum"));
                dashBoardAction.setStudentBranch(resultSet.getString("Student1Branch"));
                dashBoardAction.setStudentYear(resultSet.getString("Student1Year"));

                dashBoardAction.setStudentname1(resultSet.getString("Student2Name"));
                dashBoardAction.setStudentEmail1(resultSet.getString("Student2Email"));
                dashBoardAction.setStudentPhoneNumber1(resultSet.getString("Student2PhoneNum"));
                dashBoardAction.setStudentBranch1(resultSet.getString("Student2Branch"));
                dashBoardAction.setStudentYear1(resultSet.getString("Student2Year"));

                dashBoardAction.setStudentname2(resultSet.getString("Student3Name"));
                dashBoardAction.setStudentEmail2(resultSet.getString("Student3Email"));
                dashBoardAction.setStudentPhoneNumber2(resultSet.getString("Student3PhoneNum"));
                dashBoardAction.setStudentBranch2(resultSet.getString("Student3Branch"));
                dashBoardAction.setStudentYear2(resultSet.getString("Student3Year"));

                dashBoardAction.setStudentname3(resultSet.getString("Student4Name"));
                dashBoardAction.setStudentEmail3(resultSet.getString("Student4Email"));
                dashBoardAction.setStudentPhoneNumber3(resultSet.getString("Student4PhoneNum"));
                dashBoardAction.setStudentBranch3(resultSet.getString("Student4Branch"));
                dashBoardAction.setStudentYear3(resultSet.getString("Student4Year"));
            }



            /// System.err.println("Result----" + docRepoList.size());
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }

        return "success";
    }

    public String updateEnrollCollege(DashBoardAction dashBoardAction) throws ServiceLocatorException {
        String result = "";
        int updatedRows = 0;
        Connection connection = null;
        CallableStatement cstatement = null;
        ResultSet resultSet = null;



        /*@param primaryAction used to store actions*/
        try {

            // DataSourceDataProvider.getInstance().   spCreConsultantDetails
            connection = ConnectionProvider.getInstance().getConnection();
            cstatement = connection.prepareCall("call spEnrollCollDetails(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,?,?)");
            cstatement.setString(1, dashBoardAction.getCode());
            cstatement.setString(2, dashBoardAction.getCollegeName());
            cstatement.setString(3, dashBoardAction.getCollegeId());
            cstatement.setString(4, dashBoardAction.getLocation());
            cstatement.setString(5, dashBoardAction.getFacultyambassadorName());
            cstatement.setString(6, dashBoardAction.getFacultyambassadorPhoneNumber());
            cstatement.setString(7, dashBoardAction.getFacultyambassadorEmail());
            cstatement.setString(8, dashBoardAction.getStudentname());
            cstatement.setString(9, dashBoardAction.getStudentEmail());
            cstatement.setString(10, dashBoardAction.getStudentPhoneNumber());
            //  System.out.println("dashBoardAction.getStudentBranch()-->"+dashBoardAction.getStudentBranch()+"   "+dashBoardAction.getStudentYear());
            cstatement.setString(11, dashBoardAction.getStudentBranch());
            cstatement.setString(12, dashBoardAction.getStudentYear());

            cstatement.setString(13, dashBoardAction.getStudentname1());
            cstatement.setString(14, dashBoardAction.getStudentEmail1());
            cstatement.setString(15, dashBoardAction.getStudentPhoneNumber1());
            cstatement.setString(16, dashBoardAction.getStudentBranch1());
            cstatement.setString(17, dashBoardAction.getStudentYear1());

            cstatement.setString(18, dashBoardAction.getStudentname2());
            cstatement.setString(19, dashBoardAction.getStudentEmail2());
            cstatement.setString(20, dashBoardAction.getStudentPhoneNumber2());
            cstatement.setString(21, dashBoardAction.getStudentBranch2());
            cstatement.setString(22, dashBoardAction.getStudentYear2());
            cstatement.setString(23, dashBoardAction.getStudentname3());
            cstatement.setString(24, dashBoardAction.getStudentEmail3());
            cstatement.setString(25, dashBoardAction.getStudentPhoneNumber3());
            cstatement.setString(26, dashBoardAction.getStudentBranch3());
            cstatement.setString(27, dashBoardAction.getStudentYear3());
            cstatement.setTimestamp(28, DateUtility.getInstance().getCurrentMySqlDateTime());
            cstatement.setString(29, "");
            cstatement.setString(30, "Update");
            cstatement.setInt(31, dashBoardAction.getId());
            cstatement.setString(32, dashBoardAction.getName());
            updatedRows = cstatement.executeUpdate();

            if (updatedRows > 0) {
                result = "success";
            }

            //  addCreAcademics(creAction,maxCreId);


        } catch (SQLException se) {
            throw new ServiceLocatorException(se);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (cstatement != null) {
                    cstatement.close();
                    cstatement = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException se) {
                throw new ServiceLocatorException(se);
            }
        }

        return "error";
    }

    public List enrollLeftMenuCollege(DashBoardAction dashBoardAction, String collegeCode, String college, String location, String codeGenerate, String link, String frmDate, String toDate) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List enrollList = new ArrayList();
        //  System.out.println("----enrollLeftMenuCollege----");
  /*  String query ="SELECT tblEnrollCollegeDetails.id,tblEnrollCollegeDetails.CollegeCode,tblLKCollegesList.CollegeName"
        + " tblEnrollCollegeDetails.Location,tblEnrollCollegeDetails.CODE,tblLKCollegesList.Website,tblEnrollCollegeDetails.EnrolledDate"
        + " tblEnrollCollegeDetails.ModifiedDate FROM tblEnrollCollegeDetails" 
        + " JOIN tblLKCollegesList ON (tblEnrollCollegeDetails.CollegeName=tblLKCollegesList.id)"
        + " WHERE 1=1";*/
        String query = "SELECT tblEnrollCollegeDetails.id,tblEnrollCollegeDetails.CollegeCode,tblLKCollegesList.CollegeName,tblEnrollCollegeDetails.Location,"
                + "tblEnrollCollegeDetails.CODE,tblLKCollegesList.Website,tblEnrollCollegeDetails.EnrolledDate,tblEnrollCollegeDetails.ModifiedDate,tblLKCollegesList.id as collegeId "
                + "FROM tblEnrollCollegeDetails JOIN tblLKCollegesList ON (tblEnrollCollegeDetails.CollegeName=tblLKCollegesList.id) WHERE 1=1";
        if (frmDate != null && !"".equals(frmDate)) {
            query += (" AND EnrolledDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");
            // query += (" OR ModifiedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");
            // System.out.println("---getFrmDate--" + query);
        }
        if (toDate != null && !"".equals(toDate)) {
            query += (" AND EnrolledDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");
            //query += (" OR ModifiedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");
            //System.out.println("---getToDate--" + query);
        }
        // System.out.println("---query----" + query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GeneralVTO generalVTO = new GeneralVTO();



                //  generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                generalVTO.setId(resultSet.getInt("id"));
                //  System.out.println("-----id---------"+id);
                generalVTO.setCollegeCode(resultSet.getString("CollegeCode"));

                generalVTO.setCollegeName(resultSet.getString("CollegeName"));


                generalVTO.setLocation(resultSet.getString("Location"));
                //   generalVTO.setFacultyName(resultSet.getString("FacultyName"));


                generalVTO.setLink(resultSet.getString("Website"));

                generalVTO.setCode(resultSet.getString("Code"));

                generalVTO.setFrmDate(resultSet.getString("EnrolledDate"));


                generalVTO.setToDate(resultSet.getString("ModifiedDate"));
                generalVTO.setCollegeId(resultSet.getString("collegeId"));

                // System.out.println("resultSet.getIntid -->" + resultSet.getInt("Id"));
                //    response = resultSet.getInt("Id") + "" + resultSet.getString("CollegeName") + "" + resultSet.getString("Website");

                enrollList.add(generalVTO);

            }
            dashBoardAction.setGridDownload(query);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return enrollList;
    }

    public String getWorkshopAddDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException {
       // System.out.println("entered----getWorkshopAddDetails-----");
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String date = "";
        String frmDate = dashBoardAction.getFrmDate();
        String toDate = dashBoardAction.getToDate();
        String collegeList = "";
        List workshopList = new ArrayList();
        connection = ConnectionProvider.getInstance().getConnection();
        //  System.out.println("-first---");

        String workshopStatus;

        String queryString = "SELECT tblWorkshop.id,tblWorkshop.CODE,tblWorkshop.DATE,tblLKCollegesList.CollegeName,tblLKCollegesList.Id  AS collegeid, tblWorkshop.CollegeName  AS companyName,tblWorkshop.Location,tblLKCollegesList.Website, tblWorkshop.Id, tblWorkshop.workshopType"
                + " FROM tblWorkshop  "
                + " LEFT OUTER JOIN tblLKCollegesList ON (tblWorkshop.CollegeName=tblLKCollegesList.id)"
                + " WHERE 1=1";
        if (frmDate != null && !"".equals(frmDate)) {
            queryString += (" AND tblWorkshop.DATE >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");
            // query += (" OR ModifiedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");

        }
        if (toDate != null && !"".equals(toDate)) {
            queryString += (" AND tblWorkshop.DATE <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");
            //query += (" OR ModifiedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");

        }
      //  System.out.println("--->"+dashBoardAction.getWorkshopFormType());
        if(dashBoardAction.getWorkshopFormType()!=-1&&dashBoardAction.getWorkshopFormType()!=0)
        {
            queryString += (" AND tblWorkshop.workshopType = '" + dashBoardAction.getWorkshopFormType() + "' ");
        }
        boolean workshopEnabled = false;

     //   System.out.println("--query execuute--" + queryString);

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                GeneralVTO generalVTO = new GeneralVTO();
                generalVTO.setCode(resultSet.getString("CODE"));
                generalVTO.setCollegeId(resultSet.getString("collegeid"));

                generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                if (resultSet.getInt("workshopType") == 1) {
                    if ("".equals(collegeList)) {
                        collegeList = resultSet.getString("collegeid");
                    } else {
                        collegeList += "," + resultSet.getString("collegeid");
                    }
                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));
                    generalVTO.setLink(resultSet.getString("Website"));
                } else {
                    generalVTO.setCollegeName(resultSet.getString("companyName"));
                    generalVTO.setLink("#");
                }
                generalVTO.setLocation(resultSet.getString("Location"));
                generalVTO.setId(resultSet.getInt("Id"));
                generalVTO.setWorkshopType(resultSet.getInt("workshopType"));

                //System.out.println("resultSet.getIntid -->" + resultSet.getInt("Id"));
                String workshopId = resultSet.getInt("Id") + "";


//                System.out.println("daet=-->" + DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                date = DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString());

                if (dateComparision(date).equals("after")) {
                    workshopStatus = "Pending";
                } else {
                    workshopStatus = "Completed";
                }


                generalVTO.setWorkshopStatus(workshopStatus);



                workshopList.add(generalVTO);

            }
             dashBoardAction.setGridDownload(queryString);
            dashBoardAction.setWorkshopList(workshopList);
            dashBoardAction.setCollegeList(collegeList);
          //  System.out.println("college list---->" + collegeList);

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new ServiceLocatorException(ex);

        } finally {

            try {
                // resultSet Object Checking if it's null then close and set null
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
            } catch (SQLException ex) {
                throw new ServiceLocatorException(ex);
            }
        }
        return "success";

    }

    public String getCurrcullamAddTopicsData(DashBoardAction dashBoardAction) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List docRepoList = new ArrayList();
        String topicsList = "";
        boolean topicsEnrolled = false;
        String enrollTopics = "";
        int totalTopics = 0;
        int enrolledTotalTopics = 0;
        String query = "SELECT tblCurriculam.id as CurrculamID,tblLKTopics.id,tblLKTopics.topicname,tblLKTopics.topiclink,tblCurriculam.DATE,tblCurriculam.DurationTime,tblCurriculam.WorkshopCode,tblCurriculam.SubTopic,tblCurriculam.venue";
        query += " FROM tblLKTopics JOIN tblCurriculam ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblCurriculam.WorkshopCode='" + dashBoardAction.getWorkshopCode() + "' AND tblLKTopics.Status='Active' order by tblCurriculam.TopicID";
        try {
        //    System.out.println("query--->" + query);
            connection = ConnectionProvider.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            // enrollTopics = DataSourceDataProvider.getInstance().getEnrolledTopicsList(dashBoardAction.getUserId(), dashBoardAction.getWorkshopCode());
            while (resultSet.next()) {


                MeterialsVTO meterialsVTO = new MeterialsVTO();
                meterialsVTO.setCurrculamId(resultSet.getString("CurrculamID"));
                meterialsVTO.setTopicId(resultSet.getInt("id"));
                meterialsVTO.setTopicName(resultSet.getString("topicname"));
                meterialsVTO.setVenue(resultSet.getString("venue"));
                // meterialsVTO.setTopicEnabled(topicsEnrolled);
                meterialsVTO.setDate(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                meterialsVTO.setDurationTime(resultSet.getString("DurationTime"));
                meterialsVTO.setSubTopic(resultSet.getString("SubTopic"));
                // System.out.println("-------->"+resultSet.getString("topicname"));

                docRepoList.add(meterialsVTO);
            }



            /// System.err.println("Result----" + docRepoList.size());
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        dashBoardAction.setTopicsList(topicsList);
        dashBoardAction.setDocRepoList(docRepoList);
        return "success";
    }

    /*
     * College List Excel
     * Author : Santosh kola
     * Date : 07/26/2016
     */
    public String generateCollegeExcel(String frmDate, String toDate) throws ServiceLocatorException {
        String filePath = "";
        StringBuffer sb = null;

        Connection connection = null;
        /**
         * preStmt,preStmtTemp are reference variable for PreparedStatement .
         */
        PreparedStatement preStmt = null;

        /**
         * The queryString is useful to get queryString result to the particular
         * jsp page
         */
        /**
         * The statement is useful to execute the above queryString
         */
        ResultSet resultSet = null;
        HashMap map = null;
        double totalAmount = 0.0;
        double totalOpprtunity = 0.0;
        double floortotalsum = 0.0;
        String generatedPath = "";
        List finalList = new ArrayList();
        try {
            generatedPath = com.mss.apcloud.util.Properties.getProperty("CollegeList.Download.Path");
            File file = new File(generatedPath);
            if (!file.exists()) {
                file.mkdirs();
            }

            FileOutputStream fileOut = new FileOutputStream(file.getAbsolutePath() + "/CollegeList.xls");
            connection = ConnectionProvider.getInstance().getConnection();


            String query = "SELECT id,CollegeCode,CollegeName,Code,Website,Location,CreatedDate,ModifiedDate FROM tblLKCollegesList where 1=1";
            if (frmDate != null && !"".equals(frmDate)) {
                query += (" AND CreatedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");
                // query += (" OR ModifiedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");

            }
            if (toDate != null && !"".equals(toDate)) {
                query += (" AND CreatedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");
                //query += (" OR ModifiedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");

            }
            String reportToName = "";
            List teamList = null;
            int j = 1;
            //  System.out.println("query...."+query);
            preStmt = connection.prepareStatement(query);
            resultSet = preStmt.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String CollegeCode = resultSet.getString("CollegeCode");
                String CollegeName = resultSet.getString("CollegeName");
                String Code = resultSet.getString("Code");
                String Website = resultSet.getString("Website");
                String Location = resultSet.getString("Location");
                String CreatedDate = resultSet.getString("CreatedDate");
                String ModifiedDate = totalAmount + resultSet.getString("ModifiedDate");

                map = new HashMap();
                map.put("SNO", String.valueOf(j));
                map.put("CollegeCode", CollegeCode);
                map.put("CollegeName", CollegeName);
                map.put("Code", Code);
                map.put("Website", Website);
                map.put("Location", Location);

                map.put("CreatedDate", CreatedDate);
                map.put("ModifiedDate", ModifiedDate);


                finalList.add(map);
                j++;

            }


            if (finalList.size() > 0) {
                filePath = file.getAbsolutePath() + "/CollegeList.xls";
                HSSFWorkbook hssfworkbook = new HSSFWorkbook();
                HSSFSheet sheet = hssfworkbook.createSheet("College Sheet");

                HSSFFont timesBoldFont1 = hssfworkbook.createFont();
                timesBoldFont1.setFontHeightInPoints((short) 13);
                timesBoldFont1.setColor(HSSFColor.BLACK.index);
                timesBoldFont1.setFontName("Arial");

                HSSFCellStyle cellColor = hssfworkbook.createCellStyle();
                cellColor.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
                cellColor.setAlignment(HSSFCellStyle.ALIGN_LEFT);
                cellColor.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cellColor.setBorderTop((short) 1); // single line border
                cellColor.setBorderBottom((short) 1); // single line border
                cellColor.setFont(timesBoldFont1);

                HSSFCellStyle cellColor1 = hssfworkbook.createCellStyle();

                cellColor1.setFillForegroundColor(HSSFColor.WHITE.index);
                cellColor1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
                cellColor1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cellColor1.setBorderTop((short) 1); // single line border
                cellColor1.setBorderBottom((short) 1); // single line border
                cellColor1.setFont(timesBoldFont1);


                HSSFCellStyle cs = hssfworkbook.createCellStyle();

                HSSFCellStyle headercs = hssfworkbook.createCellStyle();
                headercs.setFillForegroundColor(HSSFColor.BLUE.index);
                headercs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                headercs.setBorderTop((short) 1); // single line border
                headercs.setBorderBottom((short) 1); // single line border
                // cs.setFont(timesBoldFont1);

                HSSFFont timesBoldFont = hssfworkbook.createFont();
                timesBoldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                timesBoldFont.setFontHeightInPoints((short) 13);
                timesBoldFont.setColor(HSSFColor.WHITE.index);
                timesBoldFont.setFontName("Calibri");
                headercs.setFont(timesBoldFont);
                // cs.setFont(timesBoldFont);
                HSSFFont footerFont = hssfworkbook.createFont();
                footerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                timesBoldFont.setFontHeightInPoints((short) 13);
                footerFont.setFontName("Calibri");

                HSSFCellStyle footercs = hssfworkbook.createCellStyle();
                footercs.setFont(footerFont);


                HSSFDataFormat df = hssfworkbook.createDataFormat();
                HSSFRow row = sheet.createRow((short) 0);
                HSSFCell cell = row.createCell((short) 0);

                HSSFCell cell1 = row.createCell((short) 1);

                HSSFCell cell2 = row.createCell((short) 2);
                HSSFCell cell3 = row.createCell((short) 3);

                HSSFCell cell4 = row.createCell((short) 4);
                HSSFCell cell5 = row.createCell((short) 5);
                HSSFCell cell6 = row.createCell((short) 6);
                HSSFCell cell7 = row.createCell((short) 7);

                cell.setCellValue("SNO");
                cell1.setCellValue("CollegeCode");
                cell2.setCellValue("CollegeName");
                cell3.setCellValue("Code");
                cell4.setCellValue("Website");
                cell5.setCellValue("Location");
                cell6.setCellValue("CreatedDate");
                cell7.setCellValue("ModifiedDate");





                cell.setCellStyle(headercs);
                cell1.setCellStyle(headercs);
                cell2.setCellStyle(headercs);
                cell3.setCellStyle(headercs);
                cell4.setCellStyle(headercs);
                cell5.setCellStyle(headercs);
                cell6.setCellStyle(headercs);
                cell7.setCellStyle(headercs);

                int count = 1;

                if (finalList.size() > 0) {
                    Map stateHistorylMap = null;
                    for (int i = 0; i < finalList.size(); i++) {
                        stateHistorylMap = (Map) finalList.get(i);
                        row = sheet.createRow((short) count++);
                        cell = row.createCell((short) 0);

                        cell1 = row.createCell((short) 1);
                        cell2 = row.createCell((short) 2);
                        cell3 = row.createCell((short) 3);
                        cell4 = row.createCell((short) 4);
                        cell5 = row.createCell((short) 5);
                        cell6 = row.createCell((short) 6);
                        cell7 = row.createCell((short) 7);



                        cell.setCellValue((String) stateHistorylMap.get("SNO"));
                        cell1.setCellValue((String) stateHistorylMap.get("CollegeCode"));
                        cell2.setCellValue((String) stateHistorylMap.get("CollegeName"));
                        cell3.setCellValue((String) stateHistorylMap.get("Code"));
                        cell4.setCellValue((String) stateHistorylMap.get("Website"));
                        cell5.setCellValue((String) stateHistorylMap.get("Location"));
                        cell6.setCellValue((String) stateHistorylMap.get("CreatedDate"));
                        cell7.setCellValue((String) stateHistorylMap.get("ModifiedDate"));



                        if (count % 2 == 0) {
                            cell.setCellStyle(cellColor1);
                            cell1.setCellStyle(cellColor1);
                            cell2.setCellStyle(cellColor1);
                            cell3.setCellStyle(cellColor1);
                            cell4.setCellStyle(cellColor1);
                            cell5.setCellStyle(cellColor1);
                            cell6.setCellStyle(cellColor1);
                            cell7.setCellStyle(cellColor1);

                        } else {
                            cell.setCellStyle(cellColor);
                            cell1.setCellStyle(cellColor);
                            cell2.setCellStyle(cellColor);
                            cell3.setCellStyle(cellColor);
                            cell4.setCellStyle(cellColor);
                            cell5.setCellStyle(cellColor);
                            cell6.setCellStyle(cellColor);
                            cell7.setCellStyle(cellColor);
                        }
                    }
                    row = sheet.createRow((short) count++);
                    cell = row.createCell((short) 0);

                    cell1 = row.createCell((short) 1);
                    cell2 = row.createCell((short) 2);
                    cell3 = row.createCell((short) 3);
                    cell4 = row.createCell((short) 4);
                    cell5 = row.createCell((short) 5);
                    cell6 = row.createCell((short) 6);
                    cell7 = row.createCell((short) 7);


                    cell.setCellStyle(footercs);
                    cell1.setCellStyle(footercs);
                    cell2.setCellStyle(footercs);
                    cell3.setCellStyle(footercs);

                    cell4.setCellStyle(footercs);
                    cell5.setCellStyle(footercs);
                    cell6.setCellStyle(footercs);
                    cell7.setCellStyle(footercs);
                }


                sheet.autoSizeColumn((int) 0);
                sheet.autoSizeColumn((int) 3);
                sheet.autoSizeColumn((int) 4);
                sheet.setColumnWidth(1, 50 * 256);
                sheet.setColumnWidth(2, 35 * 256);
                sheet.setColumnWidth(5, 25 * 256);
                sheet.setColumnWidth(6, 25 * 256);
                sheet.setColumnWidth(7, 25 * 256);

                hssfworkbook.write(fileOut);
                fileOut.flush();
                fileOut.close();


            }


        } catch (FileNotFoundException fne) {

            fne.printStackTrace();
        } catch (IOException ioe) {

            ioe.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (preStmt != null) {
                    preStmt.close();
                    preStmt = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        }

        return filePath;


    }

    //new coach details 
    public List registredCoachDetailsSearch(DashBoardAction dashBoardAction,String name, String title, String email, String phoneNumber, String companyName, String areaOfExpertise, String status, String frmDate, String toDate) throws ServiceLocatorException {
      //  System.out.println("--registredCoachDetailsSearch--");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List regCoachList = new ArrayList();


        //Id NAME  phoneNumber Title NameofExistingCompany AreasOfExpertise
        String query = "SELECT Id,NAME,Email,phoneNumber,Title,NameofExistingCompany,AreasOfExpertise,STATUS,CreatdeDate,ModifiedDate FROM tblCoachDetails where 1=1";
        if (frmDate != null && !"".equals(frmDate)) {
            query += (" AND CreatdeDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");
            // query += (" OR ModifiedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");

        }
        if (toDate != null && !"".equals(toDate)) {
            query += (" AND CreatdeDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");
            //query += (" OR ModifiedDate <= '" + DateUtility.getInstance().convertStringToMySQLDate(toDate) + "' ");

        }

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            GeneralVTO generalVTO;
            while (resultSet.next()) {
                generalVTO = new GeneralVTO();



                //  generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                generalVTO.setId(resultSet.getInt("Id"));
                generalVTO.setName(resultSet.getString("NAME"));
              //  System.out.println("--name---" + resultSet.getString("NAME"));
                generalVTO.setPhoneNum(resultSet.getString("phoneNumber"));
             //   System.out.println("--name---" + resultSet.getString("phoneNumber"));
                generalVTO.setEmail(resultSet.getString("Email"));
                generalVTO.setTitle(resultSet.getString("Title"));
              //  System.out.println("--name---" + resultSet.getString("Title"));
                generalVTO.setCompanyName(resultSet.getString("NameofExistingCompany"));
               // System.out.println("--companyname---" + resultSet.getString("NameofExistingCompany"));
                generalVTO.setAreasOfExpertise(resultSet.getString("AreasOfExpertise"));
                generalVTO.setStatus(resultSet.getString("STATUS"));
                generalVTO.setFrmDate(resultSet.getString("CreatdeDate"));

               // System.out.println("--name---" + resultSet.getString("CreatdeDate"));

                generalVTO.setToDate(resultSet.getString("ModifiedDate"));




                //    response = resultSet.getInt("Id") + "" + resultSet.getString("CollegeName") + "" + resultSet.getString("Website");

                regCoachList.add(generalVTO);

            }
            dashBoardAction.setGridDownload(query);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return regCoachList;
    }
    
        public List getWorkshopRegistratesData(String workshopCode) throws ServiceLocatorException {


        //System.out.println("------------impl getRegistratesTopicsData----");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        DateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm z");
        Date date;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List registraintsWorkshopList = new ArrayList();

        String profissionType = "";
//        String query=" SELECT tblLKTopics.id AS TopicId,tblLKTopics.topicname, t1.workshopCode"
//                + "  FROM tblLKTopics JOIN  tblEnrolledWorkshopTopics AS t1 ON (tblLKTopics.id=t1.enrollTopics) WHERE t1.registredId=" + userId +" ORDER BY t1.workshopCode";

        // String query = " SELECT tblRegistrationDetails.id,CONCAT(FName,'.',LName) AS NAME,Email,PhoneNum,CollegeName,ProfessionType FROM tblEnrolledWorkshopTopics INNER JOIN tblRegistrationDetails ON (registredId=tblRegistrationDetails.id) LEFT OUTER JOIN tblLKCollegesList ON (College=tblLKCollegesList.Id) WHERE workshopCode = '" + workshopCode + "'";

        String query = "SELECT DISTINCT(tblRegistrationDetails.id),CONCAT(FName,'.',LName) AS NAME,Email,PhoneNum,ProfessionType,CollegeName,College ,tblEnrolledWorkshopTopics.CreatedDate "
                + "FROM tblEnrolledWorkshopTopics  JOIN tblRegistrationDetails ON (tblRegistrationDetails.id=registredId)  LEFT OUTER JOIN tblLKCollegesList ON (College=tblLKCollegesList.Id) "
                + "WHERE tblEnrolledWorkshopTopics.workshopCode = '" + workshopCode + "'  GROUP BY tblRegistrationDetails.id";
       // System.out.println("--?" + query);


        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            GeneralVTO generalVTO;
            while (resultSet.next()) {
                generalVTO = new GeneralVTO();
                generalVTO.setName(resultSet.getString("NAME"));
                generalVTO.setEmail(resultSet.getString("Email"));
                System.out.println("------" + resultSet.getString("NAME") + "" + resultSet.getString("Email") + "" + resultSet.getString("PhoneNum") + "" + resultSet.getString("CollegeName"));
                generalVTO.setPhoneNum(resultSet.getString("PhoneNum"));
                // generalVTO.setCompanyName(resultSet.getString("CompanyName"));
                date = sdf.parse(resultSet.getTimestamp("CreatedDate").toString() + " MST");
                sdf1.setTimeZone(TimeZone.getTimeZone("IST"));
                System.out.println(sdf1.format(date));
                generalVTO.setDATE(sdf1.format(date));
                System.out.println("createdDate-->" + resultSet.getTimestamp("CreatedDate").toString());
                if ("1".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Student";
                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));

                } else if ("2".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Software";
                    generalVTO.setCollegeName(resultSet.getString("College"));

                } else if ("3".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Faculty";
                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));

                } else if ("4".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Admin";

                }
                generalVTO.setProfissionType(profissionType);
                //  System.out.println("------"+resultSet.getString("ProfessionType"));
                registraintsWorkshopList.add(generalVTO);

                //response += resultSet.getString("id") + "@@@" + resultSet.getString("NAME") + "@@@" + resultSet.getString("Email") + "@@@" + resultSet.getString("PhoneNum") + "@@@" + resultSet.getString("CollegeName") + "@@@" + profissionType + "^^^";
            }



            System.err.println("Result----" + response);
        } catch (ParseException ex) {
            Logger.getLogger(DashBoardImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return registraintsWorkshopList;
    }
       
    public List topicsListRetrive(DashBoardAction dashBoardAction) throws ServiceLocatorException {

     //   System.out.println("------------impl getRegistratesTopicsData----");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List topicsList = new ArrayList();

        String profissionType = "";


        String query = "SELECT id , topicName , examId , status FROM tblLKTopics";



        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            MeterialsVTO meterialsVTO;
            while (resultSet.next()) {
                meterialsVTO = new MeterialsVTO();
                meterialsVTO.setId(resultSet.getInt("id"));
                meterialsVTO.setTopicName(resultSet.getString("topicName"));

                meterialsVTO.setExamId(resultSet.getInt("examId"));
                //System.out.println("examid-->" + resultSet.getInt("examId"));
                // generalVTO.setCompanyName(resultSet.getString("CompanyName"));


                meterialsVTO.setStatus(resultSet.getString("status"));
                //  System.out.println("------"+resultSet.getString("ProfessionType"));
                topicsList.add(meterialsVTO);

                //response += resultSet.getString("id") + "@@@" + resultSet.getString("NAME") + "@@@" + resultSet.getString("Email") + "@@@" + resultSet.getString("PhoneNum") + "@@@" + resultSet.getString("CollegeName") + "@@@" + profissionType + "^^^";
            }



           // System.err.println("Result----" + response);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return topicsList;
    }

    public String insertorUpdateTopics(DashBoardAction dashBoardAction) throws ServiceLocatorException {
      //  System.out.println("------------impl getRegistratesTopicsData----");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        CallableStatement cstatement = null;
        List topicsList = new ArrayList();
        String filePath = "";
        String generatedPath = "";
        int updatedRows;
        String result = "error";
        generatedPath = com.mss.apcloud.util.Properties.getProperty("Topic.Image.Path") + "/" + dashBoardAction.getTopicName().trim().replace(" ", "_") + "/logo";
        File dir = new File(generatedPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            filePath = generatedPath + "/" + dashBoardAction.getTopicName().trim() + ".png";
            File file = new File(filePath);
            FileUtils.copyFile(dashBoardAction.getImage(), file);
           // System.out.println("--->" + filePath + "--" + dashBoardAction.getEcertId());
            connection = ConnectionProvider.getInstance().getConnection();

            cstatement = connection.prepareCall("call spTopicsInsertorUpdate(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?)");
            cstatement.setString(1, dashBoardAction.getTopicName());
            cstatement.setString(2, filePath);
            cstatement.setString(3, dashBoardAction.getEcertId() + "");
            cstatement.setString(4, dashBoardAction.getStatus());
            cstatement.setString(5, dashBoardAction.getBodyContent());
            cstatement.setString(6, dashBoardAction.getVideoTutorail());
            cstatement.setString(7, dashBoardAction.getWebsitelink());
            cstatement.setString(8, dashBoardAction.getTutorials());
            cstatement.setString(9, dashBoardAction.getBlogs());
            cstatement.setString(10, dashBoardAction.getEmail());
            cstatement.setTimestamp(11, DateUtility.getInstance().getCurrentMySqlDateTime());
            cstatement.setString(12, "Insert");
            cstatement.setString(13, dashBoardAction.getTitle());
            cstatement.setInt(14, dashBoardAction.getTopicId());
            cstatement.registerOutParameter(15, Types.INTEGER);
            updatedRows = cstatement.executeUpdate();
            //cstatement.getInt(18)

            dashBoardAction.setTopicId(cstatement.getInt(15));
            if (updatedRows > 0) {
                result = "success";
            }





           // System.err.println("Result---- success" + updatedRows);
        } catch (Exception sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (cstatement != null) {
                    cstatement.close();
                    cstatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return result;
    }

    public String topicsAddorUpdate(DashBoardAction dashBoardAction) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List topicsList = new ArrayList();

        String profissionType = "";


        String query = "SELECT tblLKTopics.id , tblLKTopics.topicName , tblLKTopics.ImageUrls, tblLKTopics.examId , tblLKTopics.STATUS, tblTechDetails.title,tblTechDetails.id AS contentId ,tblTechDetails.bodyContent, "
                + " tblTechDetails.videoTutorialLink,tblTechDetails.imagelocation,tblTechDetails.websitelink,tblTechDetails.tutuoriallink, tblTechDetails.bloglink"
                + " FROM tblLKTopics JOIN tblTechDetails ON (tblLKTopics.id=tblTechDetails.topicId) WHERE tblLKTopics.id=" + dashBoardAction.getTopicId();


        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            MeterialsVTO meterialsVTO;
            while (resultSet.next()) {

                dashBoardAction.setTopicId(resultSet.getInt("id"));
                dashBoardAction.setTopicName(resultSet.getString("topicName"));
                dashBoardAction.setTitle(resultSet.getString("title"));
                dashBoardAction.setImagePath(resultSet.getString("ImageUrls"));
                dashBoardAction.setEcertId(resultSet.getInt("examId"));
                dashBoardAction.setStatus(resultSet.getString("STATUS"));
                dashBoardAction.setContentId(resultSet.getInt("contentId"));
                dashBoardAction.setBodyContent(resultSet.getString("bodyContent"));
                dashBoardAction.setVideoTutorail(resultSet.getString("videoTutorialLink"));
                dashBoardAction.setWebsitelink(resultSet.getString("websitelink"));
                dashBoardAction.setTutorials(resultSet.getString("tutuoriallink"));
                dashBoardAction.setBlogs(resultSet.getString("bloglink"));
                dashBoardAction.setType("update");



            }



          //  System.err.println("Result----" + response);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }

        return "success";
    }

    public String topicImageDownload(int topicId) throws ServiceLocatorException {
    //    System.out.println("--topicImageDownload--");
        String imagePath = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List topicsList = new ArrayList();

        String profissionType = "";


        String query = "select imageurls from tblLKTopics where id=" + topicId;


        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            MeterialsVTO meterialsVTO;
            while (resultSet.next()) {

                imagePath = resultSet.getString("imageurls");


                //response += resultSet.getString("id") + "@@@" + resultSet.getString("NAME") + "@@@" + resultSet.getString("Email") + "@@@" + resultSet.getString("PhoneNum") + "@@@" + resultSet.getString("CollegeName") + "@@@" + profissionType + "^^^";
            }



           // System.err.println("Result----" + response);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return imagePath;
    }

    public String updateTopics(DashBoardAction dashBoardAction) throws ServiceLocatorException {
      //  System.out.println("------------impl updateTopics----");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        CallableStatement cstatement = null;
        int topicId = dashBoardAction.getTopicId();
        String filePath = "";
        String generatedPath = "";
        int updatedRows;
        String result = "error";
        generatedPath = com.mss.apcloud.util.Properties.getProperty("Topic.Image.Path") + "/" + dashBoardAction.getTopicName().trim().replace(" ", "_") + "/logo";
        File dir = new File(generatedPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            if (dashBoardAction.getImage() != null) {
                filePath = generatedPath + "/" + dashBoardAction.getImageFileName();

                File file = new File(filePath);
                FileUtils.copyFile(dashBoardAction.getImage(), file);
            } else {
                filePath = dashBoardAction.getImagePath();
            }

           // System.out.println("--->" + filePath + "--" + dashBoardAction.getEcertId());
            connection = ConnectionProvider.getInstance().getConnection();

            cstatement = connection.prepareCall("call spTopicsInsertorUpdate(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?)");
            cstatement.setString(1, dashBoardAction.getTopicName());
            cstatement.setString(2, filePath);
            cstatement.setString(3, dashBoardAction.getEcertId() + "");
            cstatement.setString(4, dashBoardAction.getStatus());
            cstatement.setString(5, dashBoardAction.getBodyContent());
            cstatement.setString(6, dashBoardAction.getVideoTutorail());
            cstatement.setString(7, dashBoardAction.getWebsitelink());
            cstatement.setString(8, dashBoardAction.getTutorials());
            cstatement.setString(9, dashBoardAction.getBlogs());
            cstatement.setString(10, dashBoardAction.getEmail());
            cstatement.setTimestamp(11, DateUtility.getInstance().getCurrentMySqlDateTime());
            cstatement.setString(12, "Update");
            cstatement.setString(13, dashBoardAction.getTitle());
            cstatement.setInt(14, dashBoardAction.getTopicId());
            cstatement.registerOutParameter(15, Types.INTEGER);
            updatedRows = cstatement.executeUpdate();

            if (updatedRows > 0) {
                result = "success";
            }
            dashBoardAction.setTopicId(topicId);




       //     System.err.println("Result---- success" + updatedRows);
        } catch (Exception sqle) {
            sqle.printStackTrace();
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (cstatement != null) {
                    cstatement.close();
                    cstatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return result;
    }

    public List getDocumentsList(DashBoardAction dashBoardAction) throws ServiceLocatorException {
       // System.out.println("------------impl getRegistratesTopicsData----");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List documentList = new ArrayList();




        String query = "SELECT id,TopicId,TYPE,DocName,STATUS,FilePath,ImagePath FROM tblDocsRepo WHERE TopicId=" + dashBoardAction.getTopicId();

     //   System.out.println("--->" + query);


        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            MeterialsVTO meterialsVTO;
            while (resultSet.next()) {
                meterialsVTO = new MeterialsVTO();
                meterialsVTO.setId(resultSet.getInt("id"));
                meterialsVTO.setTopicId(resultSet.getInt("TopicId"));
                meterialsVTO.setType(resultSet.getString("TYPE"));
                meterialsVTO.setDocName(resultSet.getString("DocName"));
                meterialsVTO.setStatus(resultSet.getString("status"));
                meterialsVTO.setFilePath(resultSet.getString("FilePath"));
                meterialsVTO.setImagePath(resultSet.getString("ImagePath"));
               // System.out.println("------" + resultSet.getString("TYPE"));
                documentList.add(meterialsVTO);

                //response += resultSet.getString("id") + "@@@" + resultSet.getString("NAME") + "@@@" + resultSet.getString("Email") + "@@@" + resultSet.getString("PhoneNum") + "@@@" + resultSet.getString("CollegeName") + "@@@" + profissionType + "^^^";
            }



          //  System.err.println("Result----" + response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return documentList;

    }

    public String insertDocumentDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException {
       // System.out.println("------------impl getRegistratesTopicsData----");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String imageFilePath = "";
        String docFilePath = "";
        String generatedImagePath = "";
        String generatedDocumentPath = "";
        int updatedRows;
        Calendar now = Calendar.getInstance();
        Formatter fmt = new Formatter();
        String result = "error";
     //   System.out.println("-topicName-" + dashBoardAction.getTopicName().trim().replace(" ", "_"));


        try {
            if (!dashBoardAction.getType().equalsIgnoreCase("WebExSessions")) {
                generatedImagePath = com.mss.apcloud.util.Properties.getProperty("Topic.Image.Path") + "/" + dashBoardAction.getTopicName().trim().replace(" ", "_") + "/" + "docImages" + "/" + dashBoardAction.getType() + "/" + now.get(Calendar.YEAR) + "/" + fmt.format("%tB", now) + "/" + now.get(Calendar.DATE);
                File dirImage = new File(generatedImagePath);
                if (!dirImage.exists()) {
                    dirImage.mkdirs();
                }
                generatedDocumentPath = com.mss.apcloud.util.Properties.getProperty("Topic.Image.Path") + "/" + dashBoardAction.getTopicName().trim().replace(" ", "_") + "/" + dashBoardAction.getType() + "/" + now.get(Calendar.YEAR) + "/" + fmt.format("%tB", now) + "/" + now.get(Calendar.DATE);
                File dirDoc = new File(generatedDocumentPath);
                if (!dirDoc.exists()) {
                    dirDoc.mkdirs();
                }

                imageFilePath = generatedImagePath + "/" + dashBoardAction.getImageFileName();
                File imageFile = new File(imageFilePath);
                FileUtils.copyFile(dashBoardAction.getImage(), imageFile);
             //   System.out.println("--->" + imageFilePath);

                docFilePath = generatedDocumentPath + "/" + dashBoardAction.getDocumentFileName();
                File docFile = new File(docFilePath);
                FileUtils.copyFile(dashBoardAction.getDocument(), docFile);
             //   System.out.println("--->" + docFilePath);
            }

            String SqlQuery = "INSERT INTO `tblDocsRepo` (`TopicId`, `Type`, `DocName`, `FileName`, `FilePath`, `ImagePath`, `CreatedBy`, `CreatedDate`, `Status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            connection = ConnectionProvider.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.setInt(1, dashBoardAction.getTopicId());
            preparedStatement.setString(2, dashBoardAction.getType());
            preparedStatement.setString(3, dashBoardAction.getDocName());
            preparedStatement.setString(4, dashBoardAction.getDocumentFileName());
            if (dashBoardAction.getType().equalsIgnoreCase("WebExSessions")) {
                preparedStatement.setString(4, "videolinks");
                preparedStatement.setString(5, dashBoardAction.getWebExUrl());
                preparedStatement.setString(6, "");
            } else {
                preparedStatement.setString(4, dashBoardAction.getDocumentFileName());
                preparedStatement.setString(5, docFilePath);
                preparedStatement.setString(6, imageFilePath);
            }
            preparedStatement.setString(7, dashBoardAction.getEmail());

            preparedStatement.setTimestamp(8, DateUtility.getInstance().getCurrentMySqlDateTime());
            preparedStatement.setString(9, dashBoardAction.getStatus());

            updatedRows = preparedStatement.executeUpdate();
            //cstatement.getInt(18)


            if (updatedRows > 0) {
                result = "success";
            }





        //    System.err.println("Result---- success" + updatedRows);
        } catch (Exception sqle) {
            sqle.printStackTrace();
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return result;
    }

    public String updateDocumentDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        CallableStatement cstatement = null;
        String imageFilePath = "";
        String docFilePath = "";
        String generatedImagePath = "";
        String generatedDocumentPath = "";
        int updatedRows;
        Calendar now = Calendar.getInstance();
        Formatter fmt = new Formatter();


        String result = "error";



        try {
            if (!dashBoardAction.getType().equalsIgnoreCase("WebExSessions")) {

                if (dashBoardAction.getImage() != null) {
                    new File(dashBoardAction.getImagePath()).delete();
                    generatedImagePath = com.mss.apcloud.util.Properties.getProperty("Topic.Image.Path") + "/" + dashBoardAction.getTopicName().trim().replace(" ", "_") + "/" + "docImages" + "/" + dashBoardAction.getType() + "/" + now.get(Calendar.YEAR) + "/" + fmt.format("%tB", now) + "/" + now.get(Calendar.DATE);
                    File dirImage = new File(generatedImagePath);
                    if (!dirImage.exists()) {
                        dirImage.mkdirs();
                    }
                    imageFilePath = generatedImagePath + "/" + dashBoardAction.getImageFileName();
                    File imageFile = new File(imageFilePath);
                    FileUtils.copyFile(dashBoardAction.getImage(), imageFile);
                    dashBoardAction.setImagePath(imageFilePath);
                }
                if (dashBoardAction.getDocument() != null) {
                    new File(dashBoardAction.getFilePath()).delete();
                    generatedDocumentPath = com.mss.apcloud.util.Properties.getProperty("Topic.Image.Path") + "/" + dashBoardAction.getTopicName().trim().replace(" ", "_") + "/" + dashBoardAction.getType() + "/" + now.get(Calendar.YEAR) + "/" + fmt.format("%tB", now) + "/" + now.get(Calendar.DATE);
                    File dirDoc = new File(generatedDocumentPath);
                    if (!dirDoc.exists()) {
                        dirDoc.mkdirs();
                    }

                    docFilePath = generatedDocumentPath + "/" + dashBoardAction.getDocumentFileName();
                    File docFile = new File(docFilePath);
                    FileUtils.copyFile(dashBoardAction.getDocument(), docFile);
                    dashBoardAction.setFilePath(docFilePath);
                }
            }
            String SqlQuery = "UPDATE `tblDocsRepo` SET  `DocName` = ?,`Type`=?,`FilePath`=?, `ImagePath`=? , `ModifiedBy` = ? , `ModifiedDate` = ? , `Status` = ? WHERE	`id` = ? ;";
            connection = ConnectionProvider.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(SqlQuery);

            preparedStatement.setString(1, dashBoardAction.getDocName());
            preparedStatement.setString(2, dashBoardAction.getType());
            if (!dashBoardAction.getType().equalsIgnoreCase("WebExSessions")) {
                preparedStatement.setString(3, dashBoardAction.getFilePath());
                preparedStatement.setString(4, dashBoardAction.getImagePath());
            } else {
                preparedStatement.setString(3, dashBoardAction.getWebExUrl());
                preparedStatement.setString(4, "");
            }
            preparedStatement.setString(5, dashBoardAction.getEmail());
            preparedStatement.setTimestamp(6, DateUtility.getInstance().getCurrentMySqlDateTime());
            preparedStatement.setString(7, dashBoardAction.getStatus());
            preparedStatement.setInt(8, dashBoardAction.getDocumentId());

            updatedRows = preparedStatement.executeUpdate();
            //cstatement.getInt(18)


            if (updatedRows > 0) {
                result = "success";
            }





           // System.err.println("Result---- success" + updatedRows);
        } catch (Exception sqle) {
            sqle.printStackTrace();
            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return result;
    }
    
    
   public String excelSheetForWorkshopregDetails(DashBoardAction dashBoardAction, String queryString) throws ServiceLocatorException {
        String filePath = "";
        StringBuffer sb = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        DateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm z");
        Date date;

        Connection connection = null;
        /**
         * preStmt,preStmtTemp are reference variable for PreparedStatement .
         */
        PreparedStatement preStmt = null;

        /**
         * The queryString is useful to get queryString result to the particular
         * jsp page
         */
        /**
         * The statement is useful to execute the above queryString
         */
        ResultSet resultSet = null;
        HashMap map = null;
        String generatedPath = "";
        List finalList = new ArrayList();
        try {

            generatedPath = com.mss.apcloud.util.Properties.getProperty("WorkshopsReg.Details.Path");
            File file = new File(generatedPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOut = new FileOutputStream(file.getAbsolutePath() + "/WorkshopRegDetails.xls");
            connection = ConnectionProvider.getInstance().getConnection();

            String query = null;
            List teamList = null;
            int j = 1;

            preStmt = connection.prepareStatement(queryString);
            resultSet = preStmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("Email");
                String phoneNum = resultSet.getString("PhoneNum");
                String CollegeName = "";
                String profissionType = "";
                
                if ("1".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Student";
                    CollegeName = resultSet.getString("CollegeName");
                    System.out.println("Student College-->" + CollegeName);

                } else if ("2".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Software";

                    CollegeName = resultSet.getString("College");
                    System.out.println("Software College-->" + CollegeName);
                } else if ("3".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Faculty";
                    CollegeName = resultSet.getString("CollegeName");

                } else if ("4".equals(resultSet.getString("ProfessionType"))) {
                    profissionType = "Admin";

                }
                date = sdf.parse(resultSet.getTimestamp("CreatedDate").toString() + " MST");
                sdf1.setTimeZone(TimeZone.getTimeZone("IST"));
                System.out.println(sdf1.format(date));
                //date=sdf1.format(date);
                map = new HashMap();
                
                map.put("SNO", String.valueOf(j));
                map.put("NAME", name);
                map.put("Email", email);
                map.put("PhoneNum", phoneNum);
                map.put("CollegeName", CollegeName);
                map.put("ProfissionType", profissionType);
                map.put("Date", sdf1.format(date));

                finalList.add(map);
                j++;
            }


            if (finalList.size() > 0) {
                filePath = file.getAbsolutePath() + "/WorkshopRegDetails.xls";
                HSSFWorkbook hssfworkbook = new HSSFWorkbook();
                HSSFSheet sheet = hssfworkbook.createSheet("Details");

                HSSFFont timesBoldFont1 = hssfworkbook.createFont();
                timesBoldFont1.setFontHeightInPoints((short) 13);
                timesBoldFont1.setColor(HSSFColor.BLACK.index);
                timesBoldFont1.setFontName("Arial");

                HSSFCellStyle cellColor = hssfworkbook.createCellStyle();
                cellColor.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
                cellColor.setAlignment(HSSFCellStyle.ALIGN_LEFT);
                cellColor.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cellColor.setBorderTop((short) 1); // single line border
                cellColor.setBorderBottom((short) 1); // single line border
                cellColor.setFont(timesBoldFont1);

                HSSFCellStyle cellColor1 = hssfworkbook.createCellStyle();

                cellColor1.setFillForegroundColor(HSSFColor.WHITE.index);
                cellColor1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
                cellColor1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cellColor1.setBorderTop((short) 1); // single line border
                cellColor1.setBorderBottom((short) 1); // single line border
                cellColor1.setFont(timesBoldFont1);


                HSSFCellStyle cs = hssfworkbook.createCellStyle();
                HSSFCellStyle css1 = hssfworkbook.createCellStyle();
                HSSFCellStyle css2 = hssfworkbook.createCellStyle();
                HSSFCellStyle headercs = hssfworkbook.createCellStyle();
                headercs.setFillForegroundColor(HSSFColor.BLUE.index);
                headercs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                headercs.setBorderTop((short) 1); // single line border
                headercs.setBorderBottom((short) 1); // single line border
                // cs.setFont(timesBoldFont1);

                HSSFFont timesBoldFont = hssfworkbook.createFont();
                timesBoldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                timesBoldFont.setFontHeightInPoints((short) 13);
                timesBoldFont.setColor(HSSFColor.WHITE.index);
                timesBoldFont.setFontName("Calibri");
                headercs.setFont(timesBoldFont);
                // cs.setFont(timesBoldFont);
                HSSFFont footerFont = hssfworkbook.createFont();
                footerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                timesBoldFont.setFontHeightInPoints((short) 13);
                footerFont.setFontName("Calibri");

                HSSFCellStyle footercs = hssfworkbook.createCellStyle();
                footercs.setFont(footerFont);


                HSSFDataFormat df = hssfworkbook.createDataFormat();
                HSSFRow row = sheet.createRow((short) 0);
                HSSFCell cell = row.createCell((short) 0);

                HSSFCell cell1 = row.createCell((short) 1);

                HSSFCell cell2 = row.createCell((short) 2);
                HSSFCell cell3 = row.createCell((short) 3);

                HSSFCell cell4 = row.createCell((short) 4);
                HSSFCell cell5 = row.createCell((short) 5);
                HSSFCell cell6 = row.createCell((short) 6);

                cell.setCellValue("SNO");
                cell1.setCellValue("NAME");
                cell2.setCellValue("Email");
                cell3.setCellValue("PhoneNum");
                cell4.setCellValue("College/Company Name");
                cell5.setCellValue("Profission Type");
                cell6.setCellValue("Date");

                cell.setCellStyle(headercs);
                cell1.setCellStyle(headercs);
                cell2.setCellStyle(headercs);
                cell3.setCellStyle(headercs);
                cell4.setCellStyle(headercs);
                cell5.setCellStyle(headercs);
                cell6.setCellStyle(headercs);

                int count = 1;

                if (finalList.size() > 0) {
                    Map stateHistorylMap = null;
                    for (int i = 0; i < finalList.size(); i++) {
                        stateHistorylMap = (Map) finalList.get(i);
                        row = sheet.createRow((short) count++);
                        cell = row.createCell((short) 0);

                        cell1 = row.createCell((short) 1);
                        cell2 = row.createCell((short) 2);
                        cell3 = row.createCell((short) 3);
                        cell4 = row.createCell((short) 4);
                        cell5 = row.createCell((short) 5);
                        cell6 = row.createCell((short) 6);

                        cell.setCellValue((String) stateHistorylMap.get("SNO"));
                        cell1.setCellValue((String) stateHistorylMap.get("NAME"));
                        cell2.setCellValue((String) stateHistorylMap.get("Email"));
                        cell3.setCellValue((String) stateHistorylMap.get("PhoneNum"));
                        cell4.setCellValue((String) stateHistorylMap.get("CollegeName"));
                        cell5.setCellValue((String) stateHistorylMap.get("ProfissionType"));
                        cell6.setCellValue((String) stateHistorylMap.get("Date"));




                        if (count % 2 == 0) {
                            cell.setCellStyle(cellColor1);
                            cell1.setCellStyle(cellColor1);
                            cell2.setCellStyle(cellColor1);
                            cell3.setCellStyle(cellColor1);
                            cell4.setCellStyle(cellColor1);
                            cell5.setCellStyle(cellColor1);
                            cell6.setCellStyle(cellColor1);


                        } else {
                            cell.setCellStyle(cellColor);
                            cell1.setCellStyle(cellColor);
                            cell2.setCellStyle(cellColor);
                            cell3.setCellStyle(cellColor);
                            cell4.setCellStyle(cellColor);
                            cell5.setCellStyle(cellColor);
                            cell6.setCellStyle(cellColor);

                        }
                    }




                }
                //  sheet.autoSizeColumn((int)1000000);
                sheet.setColumnWidth(0, 15 * 256);
                sheet.setColumnWidth(1, 30 * 256);
                sheet.setColumnWidth(2, 35 * 256);
                sheet.setColumnWidth(3, 30 * 256);
                sheet.setColumnWidth(4, 40 * 256);
                sheet.setColumnWidth(5, 40 * 256);
                sheet.setColumnWidth(6, 40 * 256);

                hssfworkbook.write(fileOut);
                fileOut.flush();
                fileOut.close();


            }


        } catch (FileNotFoundException fne) {

            fne.printStackTrace();
        } catch (IOException ioe) {

            ioe.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (preStmt != null) {
                    preStmt.close();
                    preStmt = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        }

        return filePath;

    }

}
