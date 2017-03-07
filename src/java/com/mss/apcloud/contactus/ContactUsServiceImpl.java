/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.contactus;

import com.mss.apcloud.util.ConnectionProvider;
import com.mss.apcloud.util.MailManager;
import com.mss.apcloud.util.ServiceLocatorException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author miracle
 */
public class ContactUsServiceImpl implements ContactUsService{

     @Override
    public String addContactUsData(ContactUsAction contactUsAction) throws ServiceLocatorException {

        Connection connection = null;
        //CallableStatement callableStatement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String returnStmt = "FAILURE";
        int updatedRows = 0;
        String resultMessage;
        try {
            connection = ConnectionProvider.getInstance().getConnection();


            String sqlString = "INSERT INTO tblContactData(FirstName,LastName,EMail,Phone,Description,Category,Organization,Designation) VALUES (?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sqlString);

            preparedStatement.setString(1, contactUsAction.getFname());
            preparedStatement.setString(2, contactUsAction.getLname());
            preparedStatement.setString(3, contactUsAction.getEmail());
            preparedStatement.setString(4, contactUsAction.getPhone());
            preparedStatement.setString(5, contactUsAction.getDescription());
            preparedStatement.setString(6, contactUsAction.getCategory());
            preparedStatement.setString(7, contactUsAction.getOrganization());
            preparedStatement.setString(8, contactUsAction.getDesignation());
            updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                returnStmt = "error";
            } else if (updatedRows == 1) {
                returnStmt = "success";
                MailManager sendMail = new MailManager();
//                System.out.println("sendResetPwd-->" + emailId + "  " + name + " " + psw);
                int mailFlag = Integer.parseInt(com.mss.apcloud.util.Properties.getProperty("Mail.Flag"));
                if (mailFlag == 1) {
                    resultMessage = sendMail.sendContactMail(contactUsAction.getFname(), contactUsAction.getLname(), contactUsAction.getEmail(), contactUsAction.getPhone(), contactUsAction.getDescription());
                    if (resultMessage.equalsIgnoreCase("MailSent")) {
                        resultMessage = "mailsend";
                    } else {
                        //   resultMessage = "Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id.";
                        resultMessage = "TryAgain";
                        //getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE1, "<font color=\"red\" size=\"2.5\">Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id. </font>");
                    }
                }
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
