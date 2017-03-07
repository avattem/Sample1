/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.techdetails;

import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.ServiceLocatorException;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miracle
 */
public class TechDetailsServiceImpl implements TechDetailsService {
//    public String getData(TechDetailsAction dataAction) throws ServiceLocatorException
//    {
//        System.out.println("====getData====");
//        Connection connection = null;
//        PreparedStatement prepstatement = null;
//        ResultSet resultSet = null;
//        String imageLocation="";
//       // List videoTutorailList = new ArrayList();
//        //byte[] image = null;
//        BufferedImage image = null;
//        try{
//             connection = ConnectionProvider.getInstance().getConnection();
//             
//            // topicId title bodyContent videoTutorialLink images websitelink tutuoriallink bloglink tblJspContents
//                     
//            prepstatement = connection.prepareStatement("SELECT * FROM tblTechDetails WHERE topicId = "+dataAction.getTopicId());
//             resultSet = prepstatement.executeQuery();
//            while(resultSet.next())
//            {
//                System.out.println("===in while====");
//                dataAction.setTitle(resultSet.getString("title")); 
//                System.out.println("resultSet.getString-->"+resultSet.getString("title"));
//                dataAction.setBodyContent(resultSet.getString("bodyContent")); 
//                System.out.println("resultSet.getStringimagelocation-->"+resultSet.getString("imagelocation"));
//                dataAction.setImageName(resultSet.getString("imagelocation")); 
//                
//                String videotutoraillink[] = resultSet.getString("videoTutorialLink").split(";");
//                dataAction.setVideoTutorialLink1(videotutoraillink[0]);
//                dataAction.setVideoTutorialLink2(videotutoraillink[1]);
//                           
//                
//                dataAction.setWebsitelink(resultSet.getString("websitelink")); 
//                dataAction.setTutorialLink(resultSet.getString("tutuoriallink")); 
//                dataAction.setBlogLink(resultSet.getString("bloglink")); 
//            }
//        }
//        catch (SQLException se){
//            throw new ServiceLocatorException(se);
//        }finally{
//            try{
//                if(resultSet != null){
//                    resultSet.close();
//                    resultSet = null;
//                }
//                if(prepstatement != null){
//                    prepstatement.close();
//                    prepstatement = null;
//                }
//                if(connection != null){
//                    connection.close();
//                    connection = null;
//                }
//            }catch (SQLException se){
//                throw new ServiceLocatorException(se);
//            }
//        }
//        return null;
//    }

    public String getData(TechDetailsAction dataAction) throws ServiceLocatorException {
        // System.out.println("====getData====");
        Connection connection = null;
        PreparedStatement prepstatement = null;
        ResultSet resultSet = null;
        String imageLocation = "";
        // List videoTutorailList = new ArrayList();
        //byte[] image = null;
        BufferedImage image = null;
        try {
            connection = ConnectionProvider.getInstance().getConnection();

            // topicId title bodyContent videoTutorialLink images websitelink tutuoriallink bloglink tblJspContents

            prepstatement = connection.prepareStatement("SELECT * FROM tblTechDetails WHERE topicId = " + dataAction.getTopicId());
            resultSet = prepstatement.executeQuery();
            while (resultSet.next()) {
                // System.out.println("===in while====");
                dataAction.setTitle(resultSet.getString("title"));
                // System.out.println("resultSet.getString-->"+resultSet.getString("title"));
                dataAction.setBodyContent(resultSet.getString("bodyContent"));
                //  System.out.println("resultSet.getStringimagelocation-->"+resultSet.getString("imagelocation"));
                dataAction.setImageName(resultSet.getString("imagelocation"));

                String videotutoraillink[] = resultSet.getString("videoTutorialLink").split(";");

                List videoTutorialList = Arrays.asList(videotutoraillink);
                dataAction.setVideoTutorailList(videoTutorialList);
//                dataAction.setVideoTutorialLink1(videotutoraillink[0]);
//                dataAction.setVideoTutorialLink2(videotutoraillink[1]);

                dataAction.setWebsitelink(resultSet.getString("websitelink"));
                //  System.out.println("resultSet.getString websitelink-->"+resultSet.getString("websitelink"));

                String tutuoriallink[] = resultSet.getString("tutuoriallink").split(";");


                List tutorialList = Arrays.asList(tutuoriallink);
                // dataAction.setTutorialLink(resultSet.getString("tutuoriallink")); 
                dataAction.setTutorialList(tutorialList);


                String blogLink[] = resultSet.getString("bloglink").split(";");

                List blogList = Arrays.asList(blogLink);
                dataAction.setBlogLinkList(blogList);
                // dataAction.setTutorialList(tutorialList);


                // dataAction.setBlogLink(resultSet.getString("bloglink")); 
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
                if (prepstatement != null) {
                    prepstatement.close();
                    prepstatement = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException se) {
                throw new ServiceLocatorException(se);
            }
        }
        return null;
    }

    public String getRepoData(TechDetailsAction techDetailsAction) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        int prsentations = 0;
        int webxSessions = 0;
        int installationGuide = 0;
        String type = "";
        List docRepoList = new ArrayList();
        String query = "SELECT id,topicid,type,docname,filename,filepath,ImagePath FROM tblDocsRepo WHERE topicId='" + techDetailsAction.getTopicId() + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MeterialsVTO meterialsVTO = new MeterialsVTO();
                //  System.out.println("------->"+resultSet.getString("docname"));
                meterialsVTO.setId(resultSet.getInt("id"));
                meterialsVTO.setTopicId(resultSet.getInt("topicid"));
               // meterialsVTO.setTopicName(resultSet.getString("topicname"));
                type = resultSet.getString("type");
                meterialsVTO.setType(type);

                if ("presentation".equalsIgnoreCase(type)) {
                    prsentations++;
                } else if ("WebExSessions".equalsIgnoreCase(type)) {
                    webxSessions++;
                } else if ("instllationGuide".equalsIgnoreCase(type)) {
                    installationGuide++;
                }
                meterialsVTO.setDocName(resultSet.getString("docname"));
                meterialsVTO.setFilePath(resultSet.getString("filepath"));
                meterialsVTO.setImagePath(resultSet.getString("ImagePath"));
                docRepoList.add(meterialsVTO);
            }

            techDetailsAction.setPrsentations(prsentations);
            techDetailsAction.setWebxSessions(webxSessions);
            techDetailsAction.setInstallationGuide(installationGuide);

            //  System.err.println("Result----"+response);
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
        techDetailsAction.setDocRepoList(docRepoList);
        return "success";
    }
}
