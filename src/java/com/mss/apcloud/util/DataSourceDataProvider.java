/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.util;

import com.mss.apcloud.general.GeneralVTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author miracle
 */
public class DataSourceDataProvider {

    private static DataSourceDataProvider _instance;

    public static DataSourceDataProvider getInstance() throws ServiceLocatorException {
        try {
            if (_instance == null) {
                _instance = new DataSourceDataProvider();
            }
        } catch (Exception ex) {
            throw new ServiceLocatorException(ex);
        }
        return _instance;
    }

// methods for setting of states and districts select boxes in registration form
    public Map getStateNames() throws ServiceLocatorException {

        Map stateList = new HashMap();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConnectionProvider.getInstance().getConnection();
        String queryString = "SELECT StateId, StateName FROM `apcloud`.`tblLKStatesList`";
        try {
            // System.out.println("connection--->"+connection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                //  System.out.println("--->"+resultSet.getInt("StateId"));
                stateList.put(resultSet.getInt("StateId"), resultSet.getString("StateName"));
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
        return stateList;
    }

    public Map getDistrictNames() throws ServiceLocatorException {

        Map districtList = new HashMap();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConnectionProvider.getInstance().getConnection();
        String queryString = "SELECT 	`DistrictId`, `DistrictName` FROM `apcloud`.`tblLKDistrictsList`";
        try {
            // System.out.println("connection--->"+connection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                //  System.out.println("--->"+resultSet.getInt("StateId"));
                districtList.put(resultSet.getInt("DistrictId"), resultSet.getString("DistrictName"));
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
        return districtList;
    }

    /* *****************************************************************************
     * Date :  06-23-2016
     *
     * Author: Ramya Gonthina<rgonthina1@miraclesoft.com
     *
     * ForUse : getCollegeNames() method is used to get all college names
     *
     * *****************************************************************************
     */
    public Map getCollegeNames() throws ServiceLocatorException {
        //   System.out.println("********************DataSourceDataProvider :: getCollegeNames Method Start*********************");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getConnection();
        queryString = "SELECT Id,CollegeName FROM tblLKCollegesList ORDER BY CollegeName ASC";
        //  System.out.println("getCollegeNames :: query string ------>" + queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                collegeNameMap.put(resultSet.getInt("Id"), resultSet.getString("CollegeName"));
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
        //  System.out.println("********************DataSourceDataProvider :: getCountryNames Method End*********************");
        return collegeNameMap;
    }

    public int getEmailCheck(String email) throws ServiceLocatorException {

        int Count = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        connection = ConnectionProvider.getInstance().getConnection();
        String queryString = "SELECT COUNT(*) as Count FROM tblLkAuthorsAndSpeakers WHERE EmailId LIKE '" + email + "'";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                Count = resultSet.getInt("Count");
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
        return Count;
    }

    public String isEmailExists(String emailId) throws ServiceLocatorException {
        //  System.out.println("--isEmailExists---");
        String result = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String queryString = null;

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            //  String SQL_QUERY = "SELECT Email,FName,LName, PASSWORD from tblRegistrationDetails where Email= '" + getFirstname().trim() + "'";
            queryString = "SELECT Email FROM tblRegistrationDetails WHERE Email LIKE '" + emailId + "'";

            //queryString = "SELECT LoginId,PASSWORD,CONCAT(FirstName,'.',LastName) AS NAME FROM tblCrmContactAlias WHERE Email LIKE '"+emailId+"'";  
            //queryString = "SELECT LoginId,PASSWORD,CONCAT(FirstName,'.',LastName) AS NAME FROM tblCrmContact WHERE Email1 LIKE '"+emailId+"'";  

            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString("Email");
            } else {
                result = "nodata";
            }
            // System.out.println("dsdp--->"+result);            
        } catch (SQLException sql) {
            throw new ServiceLocatorException(sql);
        } finally {
            try {
                // resultSet Object Checking if it's null then close and set null
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
                throw new ServiceLocatorException(ex);
            }
        }
        return result;
    }

    public String getEmpNameByEmailId(String emailId) throws ServiceLocatorException {

        String result = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String queryString = null;

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            queryString = "SELECT Email,FName,LName, PASSWORD from tblRegistrationDetails where Email='" + emailId + "'";
            //      queryString = "SELECT LoginId,CONCAT(FName,'.',LName) AS NAME FROM tblEmployee WHERE Email1 LIKE '"+emailId+"'";
            //queryString = "SELECT LoginId,PASSWORD,CONCAT(FirstName,'.',LastName) AS NAME FROM tblCrmContactAlias WHERE Email LIKE '"+emailId+"'";  
            //queryString = "SELECT LoginId,PASSWORD,CONCAT(FirstName,'.',LastName) AS NAME FROM tblCrmContact WHERE Email1 LIKE '"+emailId+"'";  

            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString("FName") + "." + resultSet.getString("LName");
                // System.out.println("result-->"+result);
            } else {
                result = "nodata";
            }
            // System.out.println("dsdp--->"+result);            
        } catch (SQLException sql) {
            throw new ServiceLocatorException(sql);
        } finally {
            try {
                // resultSet Object Checking if it's null then close and set null
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
                throw new ServiceLocatorException(ex);
            }
        }
        return result; // returning the object.
    }

    public int userExists(String emailId) throws ServiceLocatorException {
        String result = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String queryString = null;
        int count = 0;
        int recordfound = 0;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            queryString = "SELECT COUNT(*) as total FROM tblRegistrationDetails WHERE Email=  '" + emailId.trim() + "'";
            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //  System.out.println("resultSet.getInt-->"+resultSet.getInt("total")); 
                recordfound = resultSet.getInt("total");
                if (recordfound > 0) {
                    count = 1;
                }

            }
            // System.out.println("dsdp--->"+result);            
        } catch (SQLException sql) {
            throw new ServiceLocatorException(sql);
        } finally {
            try {
                // resultSet Object Checking if it's null then close and set null
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
                throw new ServiceLocatorException(ex);
            }
        }
        return count; // returning the object.
    }

    public String getDocumentfile(String fileId) throws ServiceLocatorException {
        String result = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String queryString = null;
        int count = 0;
        int recordfound = 0;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            queryString = "SELECT filepath FROM tblDocsRepo WHERE id=" + fileId;
            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                result = resultSet.getString("filepath");


            }
            //  System.out.println("dsdp--->"+result);            
        } catch (SQLException sql) {
            throw new ServiceLocatorException(sql);
        } finally {
            try {
                // resultSet Object Checking if it's null then close and set null
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
                throw new ServiceLocatorException(ex);
            }
        }
        return result; // returning the object.
    }

    /* *****************************************************************************
    
     * ForUse : getCollegeAndLoc() method is used to get all college names and Locations
    
     */
    public List getCollegeAndLoc() throws ServiceLocatorException {
        //    System.out.println("******************** :: getCollegeAndLoc Method Start*********************");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        String colLis = "";
        List collegeList = new ArrayList();
        //   Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getConnection();
        queryString = "SELECT Id,CollegeName,Location,Website FROM tblLKCollegesList ORDER BY CollegeName ASC";
        // System.out.println("getCollegeAndLoc :: query string ------>" + queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                GeneralVTO generalVTO=new GeneralVTO();
               // colLis = colLis + resultSet.getInt("Id") + "|" + resultSet.getString("CollegeName") + "|" + resultSet.getString("Location") + " | " + resultSet.getString("Website") + "^";
          generalVTO.setId(resultSet.getInt("Id"));

                generalVTO.setCollegeName(resultSet.getString("CollegeName"));


                generalVTO.setLocation(resultSet.getString("Location"));
                generalVTO.setWebsite(resultSet.getString("Website"));
                collegeList.add(generalVTO);

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
        //  System.out.println("********************:: getCollegeAndLoc Method End*********************");
        return collegeList;
    }

    public boolean getEnrollWorkshopIds(String multipleWorkshopIds, String workshopId) throws ServiceLocatorException {

        //  System.out.println("multipleWorkshopIds-->"+multipleWorkshopIds+"   "+ workshopId);
        String[] workshopids = multipleWorkshopIds.split(",");
        for (int i = 0; i < workshopids.length; i++) {
            if (workshopids[i].equals(workshopId)) {
                return true;
            }
        }
        return false;
    }

    public int getMcertIdByActualId(String actualId) throws ServiceLocatorException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        int mcertId = 0;
        //   Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getHubbleDbConnection();
        queryString = "SELECT Id FROM tblMcertConsultant WHERE ActualId=" + actualId;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            if (resultSet.next()) {
                mcertId = resultSet.getInt("Id");
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

        return mcertId;
    }

    public String getEnrolledTopicsList(int userId, String workshopCode) throws ServiceLocatorException {
        String result = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String queryString = null;
        int count = 0;
        int recordfound = 0;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            queryString = "select enrollTopics from tblEnrolledWorkshopTopics where registredId='" + userId + "' and workshopCode='" + workshopCode + "'";
            //  System.out.println("query dsdp-->" + queryString);
            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                if(count==0){
                    result = resultSet.getString("enrollTopics");
                }
                else{
                    result +=","+resultSet.getString("enrollTopics");
                }
                count++;
            }
             // System.out.println("dsdp--->"+result);            
        } catch (SQLException sql) {
            throw new ServiceLocatorException(sql);
        } finally {
            try {
                // resultSet Object Checking if it's null then close and set null
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
                throw new ServiceLocatorException(ex);
            }
        }
        return result; // returning the object.
    }

    public String isCollegeCodeExisted(String collegename, String code) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        //  String response = "";SELECT * FROM tblLkCollegesList1 WHERE CollegeCode="w03"

        String query = "SELECT * FROM tblLKCollegesList WHERE  Id='" + collegename + "' and CODE='" + code.trim() + "'";
        // System.out.println("query-->"+query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                response = "exist";

                //  System.out.println("==="+resultSet.getString(1)+"==="+resultSet.getString(2));

            }
            if ("".equals(response) || response == null) {
                response = "notexist";
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
        // System.out.println("response iscollegecode existed-->+response");
        return response;
    }

    public String getIndividualcollegeNameAndLocation(String collegename) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        //  String response = "";SELECT * FROM tblLkCollegesList1 WHERE CollegeCode="w03"
        //  SELECT CollegeName,Location FROM tblLKCollegesList WHERE Id=1
        String query = "SELECT CollegeName,Location FROM tblLKCollegesList WHERE  Id='" + collegename + "'";
        // System.out.println("query-->"+query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                resultSet.getString("CollegeName");
                resultSet.getString("Location");
                response += resultSet.getString("CollegeName") + "@@@" + resultSet.getString("Location");


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
        // System.out.println("response iscollegecode existed-->+response");
        return response;
    }

    public Map getCollegeNamesNotRegistred(String collegeList) throws ServiceLocatorException {
        //   System.out.println("********************DataSourceDataProvider :: getCollegeNames Method Start*********************");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getConnection();
       // queryString = "SELECT Id,CollegeName FROM tblLKCollegesList where Id NOT IN ( " + collegeList + " )ORDER BY CollegeName ASC";
        
         queryString = "SELECT Id,CollegeName FROM tblLKCollegesList where 1=1 ";
         if(!"".equals(collegeList))
         queryString = queryString +" AND Id NOT IN ( " + collegeList + " ) ";
         
         queryString =  queryString +" ORDER BY CollegeName ASC";
       // System.out.println("getCollegeNames :: query string ------>" + queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                collegeNameMap.put(resultSet.getInt("Id"), resultSet.getString("CollegeName"));
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
        //  System.out.println("********************DataSourceDataProvider :: getCountryNames Method End*********************");
        return collegeNameMap;
    }

    public Map getTopicsMap() throws ServiceLocatorException {
        //   System.out.println("********************DataSourceDataProvider :: getCollegeNames Method Start*********************");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getConnection();
        queryString = "SELECT Id,TopicName FROM tblLKTopics ORDER BY TopicName ASC";
        //System.out.println("getCollegeNames :: query string ------>" + queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                collegeNameMap.put(resultSet.getInt("Id"), resultSet.getString("TopicName"));
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
        //  System.out.println("********************DataSourceDataProvider :: getCountryNames Method End*********************");
        return collegeNameMap;
    }
    
    
     public String getGridData(String query) throws ServiceLocatorException{
      //  System.out.println("********************DataSourceDataProvider :: getGridData Method Start*********************");
      
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    
        String resultString = "";
        
        
      //  System.out.println("getGridData :: query string ------>" + query);
        
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
                    
            
                    resultString = "Sno" + "|" + "College Code " + "|" + "College Name" + "|" + " Code 	" + "|" + " Location " + "|" + "Web Site " + "|" + "Faculty" + "|" + "Student1 Details" + "|" + "Student2 Details" + "|" + "Student3 Details" + "|" + "Student4 Details" +"^";
               
                 
                while (resultSet.next()) {
                   
                        resultString += resultSet.getString("id") + "|"
                                + resultSet.getString("CollegeCode") + "|"
                                + resultSet.getString("CollegeName") + "|"
                                + resultSet.getString("Code") + "|"
                                + resultSet.getString("Location") + "|"
                                + resultSet.getString("Website") + "|"
                                + getFacultyGridData(resultSet.getString("collegeId") )+ "^";
                             
                            //  getFacultyGridData(); 
                        
                         
                   
                }
                
                
            }
         catch (SQLException ex) {
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
      //  System.out.println("********************DataSourceDataProvider :: getGridData Method End*********************");
        return resultString;
    }

      
      //new 
	  public String getFacultyGridData(String collegeId) throws ServiceLocatorException{
      //  System.out.println("********************DataSourceDataProvider :: getFacultyGridData Method Start*********************");
      
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    
        String resultString = "";
        
        
        
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            
             String query = "SELECT tblEnrollCollegeDetails.FacultyName,tblEnrollCollegeDetails.Fac_PhoneNum,tblEnrollCollegeDetails.Fac_Email,"
                + "tblEnrollCollegeDetails.Student1Name,tblEnrollCollegeDetails.Student1Email,tblEnrollCollegeDetails.Student1Branch,"
                + "tblEnrollCollegeDetails.Student1Year,tblEnrollCollegeDetails.Student1PhoneNum,tblEnrollCollegeDetails.Student2Name,"
                + "tblEnrollCollegeDetails.Student2Email, tblEnrollCollegeDetails.Student2PhoneNum,tblEnrollCollegeDetails.Student2Branch,"
                + "tblEnrollCollegeDetails.Student2Year,tblEnrollCollegeDetails.Student3Name,tblEnrollCollegeDetails.Student3Email,"
                + "tblEnrollCollegeDetails.Student3PhoneNum,tblEnrollCollegeDetails.Student3Branch,tblEnrollCollegeDetails.Student3Year,"
                + "tblEnrollCollegeDetails.Student4Name,tblEnrollCollegeDetails.Student4Email,tblEnrollCollegeDetails.Student4Branch,"
                + "tblEnrollCollegeDetails.Student4Year,tblEnrollCollegeDetails.Student4PhoneNum,tblLKCollegesList.CollegeName "
                + "FROM tblEnrollCollegeDetails JOIN  tblLKCollegesList ON (tblEnrollCollegeDetails.CollegeName=tblLKCollegesList.id)"
                + " WHERE tblEnrollCollegeDetails.CollegeName ='" + collegeId+"'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
         //   System.out.println("getFacultyGridData :: query string ------>" + query);
                    
            
                //  resultString = "Sno" + "|" + "College Code " + "|" + "College Name" + "|" + " Code " + "|" + " Location " + "|" + "Web Site " + "|" + "Ambassadors" + "^";
               
                 
                while (resultSet.next()) {
                   
                        resultString += resultSet.getString("FacultyName") + ","
                                + resultSet.getString("Fac_PhoneNum") + ","
                                + resultSet.getString("Fac_Email") + ","+"|"
                                + resultSet.getString("Student1Name") + ","
                                + resultSet.getString("Student1PhoneNum") + ","
                                + resultSet.getString("Student1Email") + ","
                                + resultSet.getString("Student1Branch") + ","
                                + resultSet.getString("Student1Year") + "." +"|"
                                + resultSet.getString("Student2Name") + ","
                                + resultSet.getString("Student2PhoneNum") + ","
                                + resultSet.getString("Student2Email") + ","
                                + resultSet.getString("Student2Branch") + ","
                                + resultSet.getString("Student2Year") + "."+"|" 
                                + resultSet.getString("Student3Name") + ","
                                + resultSet.getString("Student3PhoneNum") + ","
                                + resultSet.getString("Student3Email") + ","
                                + resultSet.getString("Student3Branch") + ","
                                + resultSet.getString("Student3Year") + "."+"|"
                                + resultSet.getString("Student4Name") + ","
                                + resultSet.getString("Student4PhoneNum") + ","
                                + resultSet.getString("Student4Email") + ","
                                + resultSet.getString("Student4Branch") + ","
                                + resultSet.getString("Student4Year") + "";
                                 
                        
                         
                   
                }
            }
         catch (SQLException ex) {
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
            
       // System.out.println("********************DataSourceDataProvider :: getFacultyGridData Method End*********************");
        return resultString;
    }


    public Map getEnrolledCollegeNames() throws ServiceLocatorException {
        //   System.out.println("********************DataSourceDataProvider :: getCollegeNames Method Start*********************");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getConnection();
        queryString = "SELECT Id,CollegeName FROM tblLKCollegesList  WHERE Id IN(SELECT CollegeName FROM tblEnrollCollegeDetails)  ORDER BY CollegeName ASC";
        //  System.out.println("getCollegeNames :: query string ------>" + queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                collegeNameMap.put(resultSet.getInt("Id"), resultSet.getString("CollegeName"));
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
        //  System.out.println("********************DataSourceDataProvider :: getCountryNames Method End*********************");
        return collegeNameMap;
    }
    //-----------------------------------------------------------
    public List getExamCompletedList(int actualId) throws ServiceLocatorException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        List<Integer> examCompleted=new ArrayList<Integer>();
        //int mcertId = 0;
        //   Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getHubbleDbConnection();
        queryString = "SELECT ExamTypeId FROM tblMcertKey JOIN tblMcertResult ON (tblMcertKey.id=ExamKeyId)"
                + " WHERE tblMcertKey.EMPID=(SELECT id FROM tblMcertConsultant WHERE ActualId="+ actualId+")";
       // System.out.println("-------------->"+queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
               examCompleted.add(resultSet.getInt("ExamTypeId"));
               // System.out.println("exam id--->"+resultSet.getInt("ExamTypeId"));
               //return true;
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

        return examCompleted;
    }
    public boolean isExamCompleted(List<Integer> examCompleted,int examId)
    {
        for(int i=0;i<examCompleted.size();i++)
        {
            if(examCompleted.get(i)==examId)
            {
              // System.out.println("isexam -->"+examCompleted.get(i));
                return true;
            }
        }
        return false;
    }
    
  /* 
     * 
     * college code exist or not
     */
    public String isCollegeCodeExistedOrNot(String code) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        //  String response = "";SELECT * FROM tblLkCollegesList1 WHERE CollegeCode="w03"

        String query = "SELECT CollegeCode FROM tblLKCollegesList WHERE  CollegeCode='" + code + "'";
       //  System.out.println("query-->"+query);
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                response = "exist";

                //  System.out.println("==="+resultSet.getString(1)+"==="+resultSet.getString(2));

            }
            if ("".equals(response) || response == null) {
                response = "notexist";
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
        // System.out.println("response iscollegecode existed-->+response");
        return response;
    }  
    
    
    public List getExamExistedHubbleList() throws ServiceLocatorException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = "";
        List<Integer> examExistedHubbleList=new ArrayList<Integer>();
        //int mcertId = 0;
        //   Map collegeNameMap = new LinkedHashMap();
        connection = ConnectionProvider.getInstance().getHubbleDbConnection();
        queryString = "SELECT Id FROM tblMcertSetExam WHERE STATUS='Active'";
                
     //   System.out.println("-------------->"+queryString);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
               examExistedHubbleList.add(resultSet.getInt("Id"));
               // System.out.println("exam id--->"+resultSet.getInt("Id"));
               //return true;
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

        return examExistedHubbleList;
    } 
    
     //registercoach det excel
    public String getRegisterCoachExcelDeta(String query) throws ServiceLocatorException {
         System.out.println("********************DataSourceDataProvider :: getRegisterCoachGridData Method Start*********************");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String resultString = "";
        int i=1;

        //  System.out.println("getGridData :: query string ------>" + query);

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.createStatement();
            // query = "SELECT Id,NAME,Email,phoneNumber,Title,NameofExistingCompany,AreasOfExpertise,STATUS FROM tblCoachDetails";
            resultSet = statement.executeQuery(query);
            System.out.println("-----query----"+query);

            resultString = "Sno" + "|" + "Name " + "|" + "Email" + "|" + "Phone" + "|" + " Title " + "|" + "Company Name " + "|" + "AOE" + "|" + "Status"  + "^";
            System.out.println("resultString"+resultString);

            while (resultSet.next()) {

              // resultString += resultSet.getString("ID") + "|"
                resultString += i++ + "|"
                        + resultSet.getString("NAME") + "|"
                        + resultSet.getString("Email") + "|"
                        + resultSet.getString("phoneNumber") + "|"
                        + resultSet.getString("Title") + "|"
                        + resultSet.getString("NameofExistingCompany") + "|"
                        + resultSet.getString("AreasOfExpertise") + "|"
                        + resultSet.getString("STATUS") + "^";
                       // + getRegGridData(resultSet.getString("collegeId")) + "^";

                //  getFacultyGridData(); 



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
        //  System.out.println("********************DataSourceDataProvider :: getGridData Method End*********************");
        return resultString;
    }
    
    
    //excel sheet for workshop
     public String getWorkshopExcelDeta(String queryString) throws ServiceLocatorException {
         System.out.println("********************DataSourceDataProvider :: getRegisterCoachGridData Method Start*********************");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String resultString = "";
        int i=1;

        //  System.out.println("getGridData :: query string ------>" + query);

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.createStatement();
            // query = "SELECT Id,NAME,Email,phoneNumber,Title,NameofExistingCompany,AreasOfExpertise,STATUS FROM tblCoachDetails";
            resultSet = statement.executeQuery(queryString);
            System.out.println("-----query----"+queryString);

            resultString = "Sno" + "|" + " Code " + "|" + "College/Company Name" + "|" + "Date" + "|" +  "Location" + "|"  + "Faculty" + "|" + "Student1 Details" + "|" + "Student2 Details" + "|" + "Student3 Details" + "|" + "Student4 Details" +  "^";
            System.out.println("resultString"+resultString);

            while (resultSet.next()) {
                String compOrClg="";
                if (resultSet.getInt("workshopType") == 1) {
                  
                    compOrClg=(resultSet.getString("CollegeName"));
                    
                } else {
                    compOrClg=(resultSet.getString("companyName"));
                    
                }
              // resultString += resultSet.getString("ID") + "|"
                resultString += i++ + "|"
                        + resultSet.getString("Code") + "|"
                        + compOrClg + "|"
                       
                        + DateUtility.getInstance().convertToviewFormat(resultSet.getString("Date")) + "|"
                      //  + resultSet.getString("Ambassadors") + "|"
                        + resultSet.getString("Location") + "|"
                      //  + resultSet.getString("Ambassadors") + "|"
                      //  + resultSet.getString("STATUS") + "^";
                
                        + getFacultyGridData(resultSet.getString("collegeId")) + "^";

                //  getFacultyGridData(); 



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
        //  System.out.println("********************DataSourceDataProvider :: getGridData Method End*********************");
        return resultString;
    }
}
