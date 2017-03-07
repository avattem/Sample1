/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.DateUtility;
import com.mss.apcloud.util.ServiceLocatorException;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miracle
 */
public class ScheduleAction extends ActionSupport {
  private GeneralVTO generalVTO;
    private int id;
    private String sessionname;
    private String location;
    private String DATE;
    private String duration;
    private String resultType;
    private int sno=0;
    private String link;
    private List schedulelist = new ArrayList();
    
    
    public String getSchedulesResults() throws ServiceLocatorException {
      //  System.out.println("-----getSchedulesResults--------");        
        String projectType = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        resultType=INPUT;
        connection = ConnectionProvider.getInstance().getConnection();
        String sessionname;
        String location;
        String date;
        String duration;       
        String queryString = "Select sessionname,location,DATE,duration,link  from tblSessionsSchedule";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                setSno(getSno() + 1);
                GeneralVTO generalVTO = new GeneralVTO();
                generalVTO.setSno(getSno());
                generalVTO.setSessionname(resultSet.getString("sessionname"));
               // System.out.println("resultSet.getString sessionname-->"+resultSet.getString("sessionname"));
                generalVTO.setLocation(resultSet.getString("location"));                
                generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                generalVTO.setDuration(resultSet.getString("duration"));
              //  System.out.println("resultSet.getString-->"+resultSet.getString("link"));
                generalVTO.setLink(resultSet.getString("link"));
                schedulelist.add(generalVTO);
                resultType=SUCCESS;
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
        
        return resultType;
    }


    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public GeneralVTO getGeneralVTO() {
        return generalVTO;
    }

    public void setGeneralVTO(GeneralVTO generalVTO) {
        this.generalVTO = generalVTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public List getSchedulelist() {
        return schedulelist;
    }

    public void setSchedulelist(List schedulelist) {
        this.schedulelist = schedulelist;
    }

    public String getSessionname() {
        return sessionname;
    }

    public void setSessionname(String sessionname) {
        this.sessionname = sessionname;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
  
}
