 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.util.AppConstants;
import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.DataSourceDataProvider;
import com.mss.apcloud.util.DateUtility;
import com.mss.apcloud.util.ServiceLocator;
import com.mss.apcloud.util.ServiceLocatorException;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author Kalpana
 */
public class DashBoardAction1 extends ActionSupport implements ServletRequestAware, ServletResponseAware  {

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

     public String getDashboard() throws ServiceLocatorException, SQLException {
        System.out.println("-----getWorkshopData--------"+getResultMessage());
        String workshopIds = "";
        String projectType = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        resultType = INPUT;
        HttpSession session = httpServletRequest.getSession(false);
        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
            if (session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID) != null) {
                workshopIds = session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID).toString();
            }
          //  System.out.println("workshopids====" + workshopIds);

            connection = ConnectionProvider.getInstance().getConnection();
            String sessionname;
            String location;
            String date;
            String duration;
            String queryString = "Select Id,DATE,TopicName,TopicLink,Location  from tblWorkshop";
            boolean workshopEnabled = false;
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(queryString);
                while (resultSet.next()) {
                    GeneralVTO generalVTO = new GeneralVTO();
                    generalVTO.setId(resultSet.getInt("Id"));
                    //System.out.println("resultSet.getIntid -->" + resultSet.getInt("Id"));
                    String workshopId = resultSet.getInt("Id") + "";
                    // System.out.println("daet=-->" + DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                    generalVTO.setDATE(DateUtility.getInstance().convertToviewFormat(resultSet.getDate("DATE").toString()));
                    generalVTO.setTopicName(resultSet.getString("TopicName"));
                    generalVTO.setTopicLink(resultSet.getString("TopicLink"));
                    generalVTO.setLocation(resultSet.getString("Location"));
                    if (workshopIds != null && !"".equals(workshopIds)) {
                        workshopEnabled = DataSourceDataProvider.getInstance().getEnrollWorkshopIds(workshopIds, workshopId);
                    //    System.out.println("workshopId------->" + workshopId + "----->" + workshopEnabled);
                    }
                    generalVTO.setWorkshopEnabled(workshopEnabled);
                    workshopList.add(generalVTO);
                    resultType = SUCCESS;
                }
               if(getResultMessage()!=null&&"".equals(getResultMessage()))
               {
                if(getResultMessage().equals("success")){
                    setResultMessage("success");
                }
                else
                {
                    setResultMessage("error");
                }
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
        }
        return resultType;
    }
    public String enrollWorkshop() {
//        String resultMsg = "";
//        HttpSession session = httpServletRequest.getSession(false);
//        String workshopIds = "";
//        if (session.getAttribute(AppConstants.SESSION_EMAIL) != null) {
//            try {
//                if (session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID) != null) {
//                    workshopIds = session.getAttribute(AppConstants.SESSION_ENROLLWORKSHOPID).toString();
//                }
//
//                System.out.println("workshop id---->" + getWorkshopId());
////                resultMsg = ServiceLocator.getGeneralService().enrollWorkshop(getWorkshopId(), session.getAttribute(AppConstants.SESSION_EMAIL).toString(), workshopIds);
//                if (resultMsg.equals("success")) {
//                    
//                     session.setAttribute(AppConstants.SESSION_ENROLLWORKSHOPID, workshopIds+","+getWorkshopId());
//                    
//                    
//                     setResultMessage("success");
//                //    System.out.println("success enroll");
//                    return SUCCESS;
//                } 
//                setResultMessage("error");
//            }  catch (ServiceLocatorException ex) {
//                ex.printStackTrace();
//              //  Logger.getLogger(AjaxHandlerAction.class.getName()).log(Level.SEVERE, null, ex);
//                
//            }
//        }
        return INPUT;
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
    
}
