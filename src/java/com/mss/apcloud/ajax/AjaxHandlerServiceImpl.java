/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.ajax;

import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.DateUtility;
import com.mss.apcloud.util.ServiceLocatorException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import org.json.JSONObject;

/**
 *
 * @author miracle
 */
public class AjaxHandlerServiceImpl implements AjaxHandlerService {
    //method for check the user email and phone number existance

    public String userExistance(String email, String phone) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String query = "SELECT email,phonenum FROM tblRegistrationDetails WHERE email='" + email + "' OR phonenum='" + phone + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                if (resultSet.getString(1).trim().equals(email.trim())) {
                    //    System.out.println("email exit");
                    response = "email already exist";
                } else if (resultSet.getString(2).trim().equals(phone.trim())) {
                    //  System.out.println("phone exit");
                    response = "phone number already exist";
                }

                //  System.out.println("==="+resultSet.getString(1)+"==="+resultSet.getString(2));

            }
            if ("".equals(response) || response == null) {
                response = "No data";
            }

            //System.err.println("Result----"+sb);
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
        return response;
    }
    //New method for setting districts based on state id

    public String getDistrictNames(int stateId) throws ServiceLocatorException {
        StringBuffer stringBuffer = new StringBuffer();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String queryString = "SELECT 	`DistrictId`, `DistrictName` FROM `apcloud`.`tblLKDistrictsList` WHERE StateId=	" + stateId;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();
            //stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            stringBuffer.append("<xml version=\"1.0\">");
            stringBuffer.append("<STATE Description=\"" + stateId + "\">");
            stringBuffer.append("<DISTRICT districtId=\"-1\">--Please Select--</DISTRICT>");
            while (resultSet.next()) {
                stringBuffer.append("<DISTRICT districtId=\"" + resultSet.getInt("DistrictId") + "\">" + resultSet.getString("DistrictName") + "</DISTRICT>");

            }
            stringBuffer.append("</STATE>");
            stringBuffer.append("</xml>");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceLocatorException sle) {
            sle.printStackTrace();
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        //System.out.println("Practice List: " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public String check(String Name) throws ServiceLocatorException {
        String resultString = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = null;

        queryString = "SELECT CollegeName,CollegeCode FROM tblEnrollCollegeDetails WHERE CollegeName="
                + Name;



        //  System.out.println("queryString-->getCollegeNames-->"+queryString);

        connection = ConnectionProvider.getInstance().getConnection();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                resultString = "College Already enrolled";
            }


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

        //   System.out.println("resultString-->"+resultString);
        return resultString;
    }

    public String getCollegeCodes(int id) throws ServiceLocatorException {
        String resultString = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = null;

        queryString = "SELECT CollegeCode FROM tblLKCollegesList WHERE Id=" + id;

        // System.out.println("queryString-->getCollegeCodes-->" + queryString);
        connection = ConnectionProvider.getInstance().getConnection();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            if (resultSet.next()) {
                resultString = resultSet.getString("CollegeCode");
            }


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

        // System.out.println("resultString-->" + resultString);
        return resultString;
    }

    public String getRepoData(int value, String topicName) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String query = "SELECT id,topicid,topicname,type,docname,filename,filepath FROM tbldocsrepo WHERE topicid='" + value + "' AND topicname='" + topicName + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                response += resultSet.getString("id") + "@@@" + resultSet.getString("type") + "@@@" + resultSet.getString("docname") + "^^^";
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
        return response;
    }

    public String getCurriculam(String workshopCode) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        //String query = "SELECT 	TopicId,Date,TopicName,DurationTime,WorkshopCode FROM tblCurriculam WHERE WorkshopCode='" + workshopCode + "'";
//        String query = "SELECT tblLKTopics.id as TopicId,tblLKTopics.topicname,tblLKTopics.topiclink,tblCurriculam.date,tblCurriculam.DurationTime,tblCurriculam.SubTopic,tblCurriculam.WorkshopCode,tblCurriculam.venue";
//        query += " FROM tblLKTopics JOIN tblCurriculam ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblCurriculam.WorkshopCode='" + workshopCode + "' AND tblLKTopics.Status='Active' order by tblCurriculam.TopicID";
        
          String query = "SELECT tblLKTopics.id AS TopicId,tblLKTopics.topicname,tblLKTopics.topiclink,tblCurriculam.DATE,tblCurriculam.DurationTime,tblCurriculam.SubTopic,tblCurriculam.WorkshopCode,tblCurriculam.venue FROM tblLKTopics JOIN tblCurriculam ";
        query += " ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblCurriculam.WorkshopCode='" + workshopCode + "' AND tblLKTopics.STATUS='Active' ORDER BY DATE,STR_TO_DATE(tblCurriculam.DurationTime , '%h:%i %p') ";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = DateUtility.getInstance().convertToviewFormat(resultSet.getDate("Date").toString());
                response += date + "@@@" + resultSet.getString("TopicName") + "@@@" + resultSet.getString("DurationTime") + "@@@" + resultSet.getString("TopicId") + "@@@" + resultSet.getString("SubTopic") + "@@@" + resultSet.getString("venue") + "^^^";
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
        return response;


    }

    public String getCollegeCoordinators(int collegeId) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String query = "SELECT 	 tblEnrollCollegeDetails.FacultyName,";
        query += "tblEnrollCollegeDetails.Fac_PhoneNum, tblEnrollCollegeDetails.Fac_Email, tblEnrollCollegeDetails.Student1Name, tblEnrollCollegeDetails.Student1Email,tblEnrollCollegeDetails.Student1Branch,tblEnrollCollegeDetails.Student1Year,";
        query += "tblEnrollCollegeDetails.Student1PhoneNum,tblEnrollCollegeDetails.Student2Name,tblEnrollCollegeDetails.Student2Email, tblEnrollCollegeDetails.Student2PhoneNum,tblEnrollCollegeDetails.Student2Branch,tblEnrollCollegeDetails.Student2Year, ";
        query += "tblEnrollCollegeDetails.Student3Name, tblEnrollCollegeDetails.Student3Email, tblEnrollCollegeDetails.Student3PhoneNum,tblEnrollCollegeDetails.Student3Branch,tblEnrollCollegeDetails.Student3Year,tblLKCollegesList.CollegeName, ";
        query += "tblEnrollCollegeDetails.Student4Name, tblEnrollCollegeDetails.Student4Email, tblEnrollCollegeDetails.Student4PhoneNum,tblEnrollCollegeDetails.Student4Branch,tblEnrollCollegeDetails.Student4Year,tblLKCollegesList.CollegeName ";
        query += " FROM tblEnrollCollegeDetails JOIN  tblLKCollegesList ON (tblEnrollCollegeDetails.CollegeName=tblLKCollegesList.id) WHERE tblEnrollCollegeDetails.CollegeName =" + collegeId;

        //System.out.println("---->" + query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // String date=DateUtility.getInstance().convertToviewFormat(resultSet.getDate("Date").toString());

                response += resultSet.getString("FacultyName") + "@@@" + resultSet.getString("Fac_PhoneNum") + "@@@" + resultSet.getString("Fac_Email");
                response += "@@@" + resultSet.getString("Student1Name") + "@@@" + resultSet.getString("Student1PhoneNum") + "@@@" + resultSet.getString("Student1Email") + "@@@" + resultSet.getString("Student1Branch") + "@@@" + resultSet.getString("Student1Year");
                response += "@@@" + resultSet.getString("Student2Name") + "@@@" + resultSet.getString("Student2PhoneNum") + "@@@" + resultSet.getString("Student2Email") + "@@@" + resultSet.getString("Student2Branch") + "@@@" + resultSet.getString("Student2Year");
                response += "@@@" + resultSet.getString("Student3Name") + "@@@" + resultSet.getString("Student3PhoneNum") + "@@@" + resultSet.getString("Student3Email") + "@@@" + resultSet.getString("Student3Branch") + "@@@" + resultSet.getString("Student3Year");
                response += "@@@" + resultSet.getString("Student4Name") + "@@@" + resultSet.getString("Student4PhoneNum") + "@@@" + resultSet.getString("Student4Email") + "@@@" + resultSet.getString("Student4Branch") + "@@@" + resultSet.getString("Student4Year") + "@@@" + resultSet.getString("CollegeName");
                // response += "@@@" + resultSet.getString("CollegeName");

                // System.out.println("response-->"+response);
            } else {
                response = "No data";
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
        return response;

    }

    public String getTechTopicData() throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String docRepoList = "";
        String query = "SELECT id,topicname,topiclink,imageurls FROM tblLKTopics WHERE Status='Active'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                docRepoList += resultSet.getInt("id") + "@@@" + resultSet.getString("topicname") + "@@@" + resultSet.getString("topiclink") + "@@@" + resultSet.getString("imageurls") + "^^^";

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
        return docRepoList;
    }

    //getExamResultsByTopicId
    public String getExamResultsByTopicId(String consultantId, String topicId) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String docRepoList = "";
        JSONObject mainJson = new JSONObject();
        try {

            int mcertId = DataSourceDataProvider.getInstance().getMcertIdByActualId(consultantId);

            String queryString = "SELECT tblMcertResult.ExamKeyId AS examKeyId,tblMcertResult.EmpId AS empId,Marks,TotalQuestions,AttemptedQuestions,DateSubmitted,ExamStatus,tblMcertKey.ExamTypeId,tblMcertSetExam.ExamType AS examType FROM tblMcertResult LEFT JOIN tblMcertKey ON tblMcertKey.ID=tblMcertResult.ExamKeyId LEFT JOIN tblMcertSetExam  ON tblMcertSetExam.Id=tblMcertKey.ExamTypeId WHERE tblMcertResult.EmpId = 'MSSMCERT" + mcertId + "' AND tblMcertKey.ExamTypeId=" + topicId;
            // System.out.println("queryString-->" + queryString);
            connection = ConnectionProvider.getInstance().getHubbleDbConnection();
            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();

            JSONObject subJson;
            int count = 0;
            while (resultSet.next()) {
                subJson = new JSONObject();
                subJson.put("empId", resultSet.getString("empId"));
                subJson.put("examType", resultSet.getString("examType"));
                subJson.put("Marks", resultSet.getString("Marks"));
                subJson.put("TotalQuestions", resultSet.getString("TotalQuestions"));
                subJson.put("AttemptedQuestions", resultSet.getString("AttemptedQuestions"));
                subJson.put("DateSubmitted", resultSet.getString("DateSubmitted"));
                subJson.put("ExamStatus", resultSet.getString("ExamStatus"));
                subJson.put("examKeyId", resultSet.getString("examKeyId"));

                mainJson.put(String.valueOf(count), subJson);
                count++;
            }



            //System.err.println("Result----"+response);
        } catch (SQLException sqle) {
            throw new ServiceLocatorException(sqle);
        } catch (Exception sqle) {
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
        return mainJson.toString();
    }

   public String enrollTechTopic(String topicsList, String userId, String inserType, String workshopCode) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String enrolledTopicsIds = "";
        int updatedRows = 0;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            String sqlString = "INSERT INTO `apcloud`.`tblEnrolledWorkshopTopics` (`registredId`,`workshopCode`,`enrollTopics`) VALUES(?,?,?)";

            preparedStatement = connection.prepareStatement(sqlString);
            String[] topics = topicsList.split(",");
            for (int i = 0; i < topics.length; i++) {
                preparedStatement.setString(1, userId);
                preparedStatement.setString(2, workshopCode);
                preparedStatement.setString(3, topics[i]);

                updatedRows = preparedStatement.executeUpdate();
            }
//            connection = ConnectionProvider.getInstance().getConnection();
//
//
//            // System.out.println("enrolledTopicsIds-->" + topicsList);
//            callableStatement = connection.prepareCall("{CALL spEnrollTopics(?,?,?,?)}");
//            callableStatement.setString(1, userId);
//            callableStatement.setString(2, workshopCode);
//            callableStatement.setString(3, topicsList);
//            callableStatement.setString(4, inserType);
//            callableStatement.execute();
            //System.err.println("Result----" + response);
            return "success";
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

    public String getEnrolledTopicsList(String userId, String workshopCode) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
//        String query = "SELECT 	DATE,TopicName,DurationTime,WorkshopCode FROM ";
//        query += "tblCurriculam WHERE WorkshopCode='" + workshopCode + "' AND FIND_IN_SET(topicid,(SELECT CAST(GROUP_CONCAT(enrolledTopicsList SEPARATOR ',') AS CHAR)  FROM tblEnrolledWorkshopTopics WHERE registredId=" + userId + " AND workshopCode='" + workshopCode + "' ))";
        String query = "SELECT tblLKTopics.id AS TopicId,tblLKTopics.topicname,tblLKTopics.topiclink,tblCurriculam.DATE,tblCurriculam.DurationTime,tblCurriculam.SubTopic,tblCurriculam.WorkshopCode";

        query += " FROM tblLKTopics JOIN tblCurriculam ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblCurriculam.WorkshopCode='" + workshopCode + "'";
        query += " AND tblLKTopics.STATUS='Active'  AND TopicId  in (SELECT enrollTopics  ";
        query += "  FROM tblEnrolledWorkshopTopics WHERE registredId=" + userId + " AND workshopCode='" + workshopCode + "' )ORDER BY tblCurriculam.TopicID";
       // System.out.println("query--> " + query);

        

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = DateUtility.getInstance().convertToviewFormat(resultSet.getDate("Date").toString());
                response += date + "@@@" + resultSet.getString("TopicName") + "@@@" + resultSet.getString("DurationTime") + "@@@" + resultSet.getString("TopicId") + "@@@" + resultSet.getString("SubTopic") + "^^^";
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
        return response;
    }

    public String editCollegeDet(String collegeCode, String collegeName, String location, String link, String email) throws ServiceLocatorException {

        //System.out.println("here");


        String result = "";
        String query = "";
        int updatedRows = 0;
        Connection connection = null;
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        try {

            connection = ConnectionProvider.getInstance().getConnection();
            //UPDATE tblLkCollegesList1 SET  CollegeName="nitss" ,Website= "www.nitss.com"  WHERE WCode="w05"

            query = "UPDATE tblLKCollegesList SET  CollegeName='" + collegeName + "' ,Website='" + link + "' ,Location='" + location + "' ,CollegeCode='" + collegeCode + "' ,ModifiedBy='" + email + "' WHERE CollegeCode='" + collegeCode + "'";
           // System.out.println("--->" + query);
            pstatement = connection.prepareStatement(query);


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

    public String getAddCollegeDet(String collegeCode, String collegeName, String codegenerate, String location, String link, String email) throws ServiceLocatorException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String returnStmt = "FAILURE";
        int updatedRows = 0;

        try {
            connection = ConnectionProvider.getInstance().getConnection();


            String sqlString = "INSERT INTO tblLKCollegesList(CollegeCode,CollegeName,Location,Website,code,CreatedBy) VALUES (?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, collegeCode);
            preparedStatement.setString(2, collegeName);
            preparedStatement.setString(3, location);
            preparedStatement.setString(4, link);


            preparedStatement.setString(5, codegenerate);
            preparedStatement.setString(6, email);
            updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                returnStmt = "error";
            } else if (updatedRows == 1) {
                returnStmt = "success";
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
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
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return returnStmt;

    }

    public String getEnrollCollegeCoordinators(int collegeId) throws ServiceLocatorException {
        //   System.out.println("---------getEnrollCollegeCoordinators-------------");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        /*  String query = "SELECT tblEnrollCollegeDetails.FacultyName,";
        query += "tblEnrollCollegeDetails.Fac_PhoneNum, tblEnrollCollegeDetails.Fac_Email, tblEnrollCollegeDetails.Student1Name, 
        tblEnrollCollegeDetails.Student1Email,tblEnrollCollegeDetails.Student1Branch,tblEnrollCollegeDetails.Student1Year,";
        query += "tblEnrollCollegeDetails.Student1PhoneNum,tblEnrollCollegeDetails.Student2Name,tblEnrollCollegeDetails.Student2Email, 
        tblEnrollCollegeDetails.Student2PhoneNum,tblEnrollCollegeDetails.Student2Branch,tblEnrollCollegeDetails.Student2Year, ";
        query += "tblEnrollCollegeDetails.Student3Name, tblEnrollCollegeDetails.Student3Email, 
        tblEnrollCollegeDetails.Student3PhoneNum,tblEnrollCollegeDetails.Student3Branch,tblEnrollCollegeDetails.Student3Year,tblLKCollegesList.CollegeName 
        ";
        query += " FROM tblEnrollCollegeDetails JOIN  tblLKCollegesList ON (tblEnrollCollegeDetails.CollegeName=tblLKCollegesList.id) WHERE 
        tblEnrollCollegeDetails.CollegeName =" + collegeId;*/

        String query = "SELECT tblEnrollCollegeDetails.FacultyName,tblEnrollCollegeDetails.Fac_PhoneNum,tblEnrollCollegeDetails.Fac_Email,tblEnrollCollegeDetails.Student1Name,tblEnrollCollegeDetails.Student1Email,tblEnrollCollegeDetails.Student1Branch,tblEnrollCollegeDetails.Student1Year,tblEnrollCollegeDetails.Student1PhoneNum,tblEnrollCollegeDetails.Student2Name,tblEnrollCollegeDetails.Student2Email, tblEnrollCollegeDetails.Student2PhoneNum,tblEnrollCollegeDetails.Student2Branch,tblEnrollCollegeDetails.Student2Year,tblEnrollCollegeDetails.Student3Name,tblEnrollCollegeDetails.Student3Email,tblEnrollCollegeDetails.Student3PhoneNum,tblEnrollCollegeDetails.Student3Branch,tblEnrollCollegeDetails.Student3Year,tblEnrollCollegeDetails.Student4Name,tblEnrollCollegeDetails.Student4Email,tblEnrollCollegeDetails.Student4Branch,tblEnrollCollegeDetails.Student4Year,tblEnrollCollegeDetails.Student4PhoneNum,tblLKCollegesList.CollegeName FROM tblEnrollCollegeDetails JOIN  tblLKCollegesList ON (tblEnrollCollegeDetails.CollegeName=tblLKCollegesList.id) WHERE tblEnrollCollegeDetails.CollegeName ='" + collegeId + "'";

        // System.out.println("--------getEnrollCollegeCoordinators------------>" + query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // String date=DateUtility.getInstance().convertToviewFormat(resultSet.getDate("Date").toString());
                // response = resultSet.getString("PrincipalName") + "@@@" + resultSet.getString("Prin_PhoneNum") + "@@@" + resultSet.getString("Prin_Email");
                response = resultSet.getString("FacultyName") + "@@@" + resultSet.getString("Fac_PhoneNum") + "@@@" + resultSet.getString("Fac_Email");
                response += "@@@" + resultSet.getString("Student1Name") + "@@@" + resultSet.getString("Student1PhoneNum") + "@@@"
                        + resultSet.getString("Student1Email") + "@@@" + resultSet.getString("Student1Branch") + "@@@" + resultSet.getString("Student1Year");
                response += "@@@" + resultSet.getString("Student2Name") + "@@@" + resultSet.getString("Student2PhoneNum") + "@@@"
                        + resultSet.getString("Student2Email") + "@@@" + resultSet.getString("Student2Branch") + "@@@" + resultSet.getString("Student2Year");
                response += "@@@" + resultSet.getString("Student3Name") + "@@@" + resultSet.getString("Student3PhoneNum") + "@@@"
                        + resultSet.getString("Student3Email") + "@@@" + resultSet.getString("Student3Branch") + "@@@" + resultSet.getString("Student3Year");
                response += "@@@" + resultSet.getString("Student4Name") + "@@@" + resultSet.getString("Student4PhoneNum") + "@@@"
                        + resultSet.getString("Student4Email") + "@@@" + resultSet.getString("Student4Branch") + "@@@" + resultSet.getString("Student4Year") + "@@@"
                        + resultSet.getString("CollegeName");
                // response += "@@@" + resultSet.getString("CollegeName");

                // System.out.println("-----------getEnrollCollegeCoordinators---------------response-->"+response);
            } else {
                response = "No data";
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
        return response;

    }

    public String addWorkshop(String collegeName, String workshopDate, String location, String email,int workshopType) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "error";
        String enrolledTopicsIds = "";
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionProvider.getInstance().getConnection();

           
            // System.out.println("enrolledTopicsIds-->" + topicsList);
            callableStatement = connection.prepareCall("{CALL spWorkshopAddEdit(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, DateUtility.getInstance().convertStringToMySQLDate(workshopDate));
            /* if (workshopDate != null && !"".equals(workshopDate)) {
           String query = ("Date >= '" + DateUtility.getInstance().convertStringToMySQLDate(workshopDate) + "' ");
                 System.out.println("date----"+query);
            // query += (" OR ModifiedDate >= '" + DateUtility.getInstance().convertStringToMySQLDate(frmDate) + "' ");

        }*/
            callableStatement.setString(2, collegeName);
            callableStatement.setString(3, location);
            callableStatement.setString(4, email);
            callableStatement.setTimestamp(5, DateUtility.getInstance().getCurrentMySqlDateTime());
            callableStatement.setString(6, "Insert");
            callableStatement.setString(7, "");
            callableStatement.setInt(8, workshopType);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.execute();
            response = callableStatement.getString(9);
            //System.err.println("Result----" + response);

            response = "success";

        } catch (SQLException sqle) {

            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (callableStatement != null) {
                    callableStatement.close();
                    callableStatement = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException sql) {
                //System.err.print("Error :"+sql);
            }

        }
        return response;
    }

    public String updateWorkshop(String workshopCode, String workshopDate, String location, String email) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String enrolledTopicsIds = "";
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionProvider.getInstance().getConnection();


            // System.out.println("enrolledTopicsIds-->" + topicsList);
            callableStatement = connection.prepareCall("{CALL spWorkshopAddEdit(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, DateUtility.getInstance().convertStringToMySQLDate(workshopDate));
            callableStatement.setString(2, "");
            callableStatement.setString(3, location);
            callableStatement.setString(4, email);
            callableStatement.setTimestamp(5, DateUtility.getInstance().getCurrentMySqlDateTime());
            callableStatement.setString(6, "Update");
            callableStatement.setString(7, workshopCode);
            callableStatement.setInt(8, 0);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.execute();
            //response= callableStatement.getString(8);
            //System.err.println("Result----" + response);
            return "success";
        } catch (SQLException sqle) {

            throw new ServiceLocatorException(sqle);
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }
                if (callableStatement != null) {
                    callableStatement.close();
                    callableStatement = null;
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

    public String addCurrculumData(String currcullamDate, int topicId, String durationTime, String subTopic, String email, String workshopCode, String venue) throws ServiceLocatorException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String returnStmt = "FAILURE";
        int updatedRows = 0;

        try {
            connection = ConnectionProvider.getInstance().getConnection();


            String sqlString = "INSERT INTO `tblCurriculam` (`Date`,`TopicId`,`DurationTime`,`WorkshopCode`,`SubTopic`,`CreatedBy`,`CreatedDate`,`venue`) VALUES (?,?,?,?,?,?,?,?)";
           // System.out.println("Str---->" + sqlString);
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, DateUtility.getInstance().convertStringToMySQLDate(currcullamDate));
            preparedStatement.setString(2, topicId + "");
            preparedStatement.setString(3, durationTime);
            preparedStatement.setString(4, workshopCode);


            preparedStatement.setString(5, subTopic);
            preparedStatement.setString(6, email);
            preparedStatement.setTimestamp(7, DateUtility.getInstance().getCurrentMySqlDateTime());
            preparedStatement.setString(8, venue);
            //DateUtility.getInstance().getCurrentMySqlDateTime()
            updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                returnStmt = "error";
            } else if (updatedRows == 1) {
                returnStmt = "success";
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
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
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return returnStmt;

    }

    public String updateCurrculumData(AjaxHandlerAction ajaxHandlerAction) throws ServiceLocatorException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String returnStmt = "FAILURE";
        int updatedRows = 0;

        try {
            connection = ConnectionProvider.getInstance().getConnection();


            String sqlString = "UPDATE tblCurriculam SET  Date = ?,TopicId = ? ,DurationTime = ? ,SubTopic = ? , ModifiedBy = ? , ModifiedDate = ? ,venue = ?	WHERE	id = ? AND  WorkshopCode = ?;";
           // System.out.println("Str---->" + sqlString);
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, DateUtility.getInstance().convertStringToMySQLDate(ajaxHandlerAction.getCurrcullamDate()));
            preparedStatement.setString(2, ajaxHandlerAction.getTopicId() + "");
            preparedStatement.setString(3, ajaxHandlerAction.getDurationTime());
            preparedStatement.setString(4, ajaxHandlerAction.getSubTopic());
            preparedStatement.setString(5, ajaxHandlerAction.getEmail());
            preparedStatement.setTimestamp(6, DateUtility.getInstance().getCurrentMySqlDateTime());
            preparedStatement.setString(7, ajaxHandlerAction.getVenue());
            preparedStatement.setInt(8, ajaxHandlerAction.getCurrculamId());
            preparedStatement.setString(9, ajaxHandlerAction.getWorkshopCode());



            //DateUtility.getInstance().getCurrentMySqlDateTime()
            updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                returnStmt = "error";
            } else if (updatedRows == 1) {
                returnStmt = "success";
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
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
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return returnStmt;

    }

    public String getWorkshopCodeByCollegeName(int collegeName) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";

        String query = "SELECT CODE FROM tblWorkshop WHERE CollegeName='" + collegeName + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                response = resultSet.getString("CODE");
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
        return response;
    }
    public String getEnrolledWorkshopandTopics(int userId) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String query=" SELECT tblLKTopics.id AS TopicId,tblLKTopics.topicname, t1.workshopCode"
                + "  FROM tblLKTopics JOIN  tblEnrolledWorkshopTopics AS t1 ON (tblLKTopics.id=t1.enrollTopics) WHERE t1.registredId=" + userId +" ORDER BY t1.workshopCode";
//        String query = "SELECT tblLKTopics.id AS TopicId,tblLKTopics.topicname,tblCurriculam.SubTopic,tblCurriculam.WorkshopCode AS workshopCode";
//        query += " FROM tblLKTopics JOIN tblCurriculam ON (tblLKTopics.id=tblCurriculam.TopicID) WHERE tblLKTopics.STATUS='Active' ";
//        query += " AND FIND_IN_SET(TopicId ,(SELECT CAST(GROUP_CONCAT(enrolledTopicsList SEPARATOR ',') AS CHAR)  FROM tblEnrolledWorkshopTopics ";
//        query += " WHERE registredId=" + userId + " ))  AND FIND_IN_SET(workshopCode ,(SELECT CAST(GROUP_CONCAT(workshopcode SEPARATOR ',') AS CHAR)  FROM tblEnrolledWorkshopTopics ";
//        query += " WHERE registredId=" + userId + " )) ORDER BY tblCurriculam.TopicId";
      //  System.out.println("query ---->" + query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                response += resultSet.getString("workshopCode") + "@@@" + resultSet.getString("topicname") + "^^^";
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
        return response;
    }
    
    
    public String editCoachDetils(int id,String name,String emaill,String phoneNum, String title, String companyName, String areaOfExpertise, String status, String email) throws ServiceLocatorException {

      //  System.out.println("editCoachDetils-------------start");


        String result = "";
        String query = "";
        int updatedRows = 0;
        Connection connection = null;
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        try {

            connection = ConnectionProvider.getInstance().getConnection();
            //UPDATE tblLkCollegesList1 SET  CollegeName="nitss" ,Website= "www.nitss.com"  WHERE WCode="w05"

            query = "UPDATE tblCoachDetails SET  NAME='" + name + "',Email='" + emaill + "',phoneNumber='" + phoneNum + "' ,Title='" + title + "' ,NameofExistingCompany='" + companyName + "' ,AreasOfExpertise='" + areaOfExpertise + "' ,STATUS='" + status + "' ,ModifiedBy='" + email + "' WHERE Id ='" + id + "'";
           // System.out.println("--->" + query);
            pstatement = connection.prepareStatement(query);
            

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
    //add coach details
    public String getAddCoachDet(String name, String email, String title, String existingCompanyName, String phoneNumber, String areaOfExpertise, String status) throws ServiceLocatorException {

        //System.out.println("---getAddCoachDet---");
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String returnStmt = "FAILURE";
        int updatedRows = 0;

        try {
            connection = ConnectionProvider.getInstance().getConnection();


            String sqlString = "INSERT INTO tblCoachDetails(NAME,Email,phoneNumber,Title,NameofExistingCompany,AreasOfExpertise,STATUS) VALUES (?,?,?,?,?,?,?)";
            //System.out.println("---sqlString----"+sqlString);
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
           // System.out.println("---name---"+name);
            preparedStatement.setString(2, email);
          //  System.out.println("---email---"+email);
            preparedStatement.setString(3, phoneNumber);
           // System.out.println("---title---"+title);
            preparedStatement.setString(4, title);
          //  System.out.println("---existingCompanyName---"+existingCompanyName+""+phoneNumber+""+areaOfExpertise+""+status);

            preparedStatement.setString(5, existingCompanyName);
            preparedStatement.setString(6, areaOfExpertise);
            preparedStatement.setString(7, status);
            updatedRows = preparedStatement.executeUpdate();

            if(updatedRows>0){
                 returnStmt = "success";
            }
            else{
                returnStmt = "error";
            }
            
        } catch (Exception sqe) {
            sqe.printStackTrace();
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
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return returnStmt;

    }
}
