/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import com.mss.apcloud.general.RegistrationAction;
import com.mss.apcloud.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.omg.PortableServer.ThreadPolicyOperations;

/**
 *
 * @author miracle
 */
public class GeneralServiceImpl implements GeneralService {

    //method for check the user email and phone number existance
    public String userExistance(String email, String phone) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "noteixst";
        String query = "SELECT email,phonenum FROM tblRegistrationDetails WHERE email='" + email + "' OR phonenum='" + phone + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                response = "exist";

                //  System.out.println("==="+resultSet.getString(1)+"==="+resultSet.getString(2));

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

    public String insertRegDetails(RegistrationAction registrationAction) throws ServiceLocatorException {
       // System.out.println("insertRegDetails");

        String result = "";
        int updatedRows = 0;
        Connection connection = null;
        CallableStatement cstatement = null;
        ResultSet resultSet = null;


        String resultMessage;
        /*@param primaryAction used to store actions*/
        try {

            // DataSourceDataProvider.getInstance().   spCreConsultantDetails
            connection = ConnectionProvider.getInstance().getConnection();
            // cstatement = connection.prepareCall("call spInsertRegDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
            cstatement = connection.prepareCall("call spInsertRegDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            cstatement.setString(1, registrationAction.getFirstname());
            cstatement.setString(2, registrationAction.getLastname());
            cstatement.setString(3, registrationAction.getEmail());
            cstatement.setString(4, PasswordUtility.encryptPwd(registrationAction.getPassword()));
            cstatement.setString(5, registrationAction.getWorkPhone());
            cstatement.setString(6, registrationAction.getProfession());
            if (registrationAction.getProfession().equals("1")) {
                cstatement.setString(7, registrationAction.getFrmCollege());
                cstatement.setString(17, "");
                cstatement.setString(8, registrationAction.getFacebookProfile());
                 if (registrationAction.getBranch().equals("Others")) {
                cstatement.setString(9, registrationAction.getFrmOtherBranch());

            } else {                    
                cstatement.setString(9, registrationAction.getBranch());
            }
            }  else if (registrationAction.getProfession().equals("2")) {

                cstatement.setString(7, registrationAction.getFrmCompany());
                cstatement.setString(8, registrationAction.getFacebookProfile());
                cstatement.setString(17, registrationAction.getFrmDesignation());
                cstatement.setString(9, "");
             //   System.out.println("FrmDesignation----" + registrationAction.getFrmDesignation());

            }

            cstatement.setString(10, registrationAction.getYear());
            cstatement.setString(11, registrationAction.getStreet());
            cstatement.setString(12, registrationAction.getCity());
            cstatement.setString(13, registrationAction.getDistrict());
            cstatement.setString(14, registrationAction.getZipcode());
            cstatement.setString(15, registrationAction.getState());
            cstatement.setTimestamp(16, DateUtility.getInstance().getCurrentMySqlDateTime());
            cstatement.registerOutParameter(18, Types.INTEGER);

            cstatement.executeUpdate();
            updatedRows = cstatement.getInt(18);
            //System.out.println("updatedRows-->" + updatedRows);
            if (updatedRows > 0) {
                registrationAction.setRegisteredId(cstatement.getInt(18));
                //  System.out.println("setRegisteredId-->"+cstatement.getInt(14));
                //  System.out.println("setRegisteredId111-->"+registrationAction.getRegisteredId());
                result = "success";
                MailManager sendMail = new MailManager();
//                System.out.println("sendResetPwd-->" + emailId + "  " + name + " " + psw);
                int mailFlag = Integer.parseInt(com.mss.apcloud.util.Properties.getProperty("Mail.Flag"));
                if (mailFlag == 1) {
                    resultMessage = sendMail.sendRegistrationMail(registrationAction);
                    if (resultMessage.equalsIgnoreCase("MailSent")) {
                        resultMessage = "mailsend";
                    } else {
                        //   resultMessage = "Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id.";
                        resultMessage = "TryAgain";
                        //getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE1, "<font color=\"red\" size=\"2.5\">Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id. </font>");
                    }
                }

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

        return result;
    }

    public int insertHubbleRegDetails(RegistrationAction registrationAction) throws ServiceLocatorException {
        //       System.out.println("herte"+registrationAction.getLastname());

        String result = "";
        int updatedRows = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        /*@param primaryAction used to store actions*/
        try {

            // DataSourceDataProvider.getInstance().   spCreConsultantDetails
            connection = ConnectionProvider.getInstance().getHubbleDbConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO tblMcertConsultant(LoginId,Password,Fname,Lname,Email,Phone,ActualId) VALUES(?,?,?,?,?,?,?) ");
            preparedStatement.setString(1, "MSSMCERT" + registrationAction.getRegisteredId());
            preparedStatement.setString(2, PasswordUtility.encryptPwd(registrationAction.getPassword()));
            preparedStatement.setString(3, registrationAction.getFirstname());
            preparedStatement.setString(4, registrationAction.getLastname());
            preparedStatement.setString(5, registrationAction.getEmail());
            preparedStatement.setString(6, registrationAction.getWorkPhone());
            preparedStatement.setInt(7, registrationAction.getRegisteredId());
            updatedRows = preparedStatement.executeUpdate();
            //  addCreAcademics(creAction,maxCreId);


        } catch (SQLException se) {
            se.printStackTrace();
            // throw new ServiceLocatorException(se);
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
            } catch (SQLException se) {
                throw new ServiceLocatorException(se);
            }
        }

        return updatedRows;
    }

    public String enrollCollegeDetails(RegistrationAction registrationAction) throws ServiceLocatorException {

        String result = "";
        int updatedRows = 0;
        Connection connection = null;
        CallableStatement cstatement = null;
        ResultSet resultSet = null;
        String response;
        String resultMessage;

        /*@param primaryAction used to store actions*/

        try {
            String codereposnse = DataSourceDataProvider.getInstance().isCollegeCodeExisted(registrationAction.getCollegeName(), registrationAction.getCode());

            if (!codereposnse.equalsIgnoreCase("notexist")) {


                response = userExistance(registrationAction.getFacultyambassadorEmail(), registrationAction.getFacultyambassadorPhoneNumber());
                // DataSourceDataProvider.getInstance().   spCreConsultantDetails

                if (response == "exist") {
                    result = "exist";
                } else {

                    connection = ConnectionProvider.getInstance().getConnection();
                    cstatement = connection.prepareCall("call spEnrollCollDetails(?,?,?,?,?,"
                            + "?,?,?,?,?,"
                            + "?,?,?,?,?,"
                            + "?,?,?,?,?,"
                            + "?,?,?,?,?,"
                            + "?,?,?,?,?,?,?)");
                    cstatement.setString(1, registrationAction.getCode());
                    cstatement.setString(2, registrationAction.getCollegeName());
                    cstatement.setString(3, registrationAction.getCollegeid());
                    cstatement.setString(4, registrationAction.getLocation());
                    cstatement.setString(5, registrationAction.getFacultyambassadorName());

                    cstatement.setString(6, registrationAction.getFacultyambassadorPhoneNumber());
                    cstatement.setString(7, registrationAction.getFacultyambassadorEmail());
                    cstatement.setString(8, registrationAction.getStudentname());
                    cstatement.setString(9, registrationAction.getStudentEmail());
                    cstatement.setString(10, registrationAction.getStudentPhoneNumber());


                    cstatement.setString(11, registrationAction.getStudentBranch());
                    cstatement.setString(12, registrationAction.getStudentYear());
                    cstatement.setString(13, registrationAction.getStudentname1());
                    cstatement.setString(14, registrationAction.getStudentEmail1());
                    cstatement.setString(15, registrationAction.getStudentPhoneNumber1());

                    cstatement.setString(16, registrationAction.getStudentBranch1());
                    cstatement.setString(17, registrationAction.getStudentYear1());
                    cstatement.setString(18, registrationAction.getStudentname2());
                    cstatement.setString(19, registrationAction.getStudentEmail2());
                    cstatement.setString(20, registrationAction.getStudentPhoneNumber2());

                    cstatement.setString(21, registrationAction.getStudentBranch2());
                    cstatement.setString(22, registrationAction.getStudentYear2());
                    cstatement.setString(23, registrationAction.getStudentname3());
                    cstatement.setString(24, registrationAction.getStudentEmail3());
                    cstatement.setString(25, registrationAction.getStudentPhoneNumber3());

                    cstatement.setString(26, registrationAction.getStudentBranch3());
                    cstatement.setString(27, registrationAction.getStudentYear3());
                    cstatement.setTimestamp(28, DateUtility.getInstance().getCurrentMySqlDateTime());
                    String psw = generatePassword(4);
                    PasswordUtility passwordUtility = new PasswordUtility();
                    String psaw1 = passwordUtility.encryptPwd(psw);

                    registrationAction.setPassword(psw);
                    cstatement.setString(29, psaw1);
                    cstatement.setString(30, "Insert");
                    cstatement.setInt(31, 1);
                    cstatement.setString(32, "");
                    updatedRows = cstatement.executeUpdate();

                    if (updatedRows > 0) {

                        result = "success";
                        MailManager sendMail = new MailManager();
//                System.out.println("sendResetPwd-->" + emailId + "  " + name + " " + psw);
                        int mailFlag = Integer.parseInt(com.mss.apcloud.util.Properties.getProperty("Mail.Flag"));
                        if (mailFlag == 1) {
                            String studentDetails = sendMail.sendCollegeEnrollment(registrationAction);
                            String facultyDetails = sendMail.sendfacultyEnrollmentdetails(registrationAction);
                            if (studentDetails.equalsIgnoreCase("MailSent") && facultyDetails.equalsIgnoreCase("MailSent")) {
                                resultMessage = "mailsend";
                            } else {
                                //   resultMessage = "Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id.";
                                resultMessage = "TryAgain";
                                //getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE1, "<font color=\"red\" size=\"2.5\">Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id. </font>");
                            }


                        }

                    }

                    //  addCreAcademics(creAction,maxCreId);


                }
            } else {

                result = "code mismatch";
                //resultMessage = "code mismatch";
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

        return result;
    }

    public String collegeExistance(String college) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        String query = "SELECT CollegeName FROM tblEnrollCollegeDetails WHERE CollegeName='" + college + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                response = "exist";

                //  System.out.println("==="+resultSet.getString(1)+"==="+resultSet.getString(2));

            }
            if ("".equals(response) || response == null) {
                response = "noteixst";
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

    public int updatePassword(PasswordAction passwordAction) throws ServiceLocatorException {
        // System.out.println("==updatePassword=="+passwordAction.getEmailId());
        /*@param isUpdate is used to store boolean value false*/
        int updatedRows = 0;
        /*@param password is used to store password of the user*/
        String password = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        PasswordUtility passwordUtility = new PasswordUtility();
        String queryString = "SELECT Password FROM tblRegistrationDetails WHERE Email='" + passwordAction.getEmailId() + "'";

        try {
            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                password = resultSet.getString("Password");
            }


            password = passwordUtility.decryptPwd(password);

            if (statement != null) {
                statement.close();
                statement = null;
            }
            /*here checking weather passwor exist or not ,if it exit the update will be done.*/
            if (passwordAction.getOldPassword().equalsIgnoreCase(password)) {
                //   System.out.println("----in iffffff-----");
                String encryptPass = passwordUtility.encryptPwd(passwordAction.getNewPassword());
                queryString = "UPDATE tblRegistrationDetails SET Password='" + encryptPass + "' WHERE Email='" + passwordAction.getEmailId() + "'";
                //  System.out.println("queryString-->"+queryString);
                statement = connection.createStatement();
                updatedRows = statement.executeUpdate(queryString);
                //  System.out.println("updatedRows-->"+updatedRows);
            }


        } catch (SQLException se) {
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
                throw new ServiceLocatorException(se);
            }
        }
        return updatedRows;

    }

    public String generatePassword(int noOfCharacters) {

        /*@param generatedPwd used to store String*/
        String generatedPwd = "";

        int randInt;

        /**
         *Random() method Creates a new random number generator
         *currentTimeMillis() method Returns the current value of the most precise available system
         *timer, in nanoseconds.
         */
        Random random = new Random(System.currentTimeMillis());

        /*
         *the next pseudorandom, uniformly distributed value from this random number generator's sequence.
         *and that is stored in randomOne and randomTwo
         */
        long randomOne = random.nextLong();
        long randomTwo = random.nextLong();

        /**
         *toHexString() method return the string representation of the unsigned
         *value represented by the argument in hexadecimal
         *that String stored in hashCodeOne and hashCodeTwo
         */
        String hashCodeOne = Long.toHexString(randomOne);
        String hashCodeTwo = Long.toHexString(randomTwo);

        /*@param generatedPwd used to store concatinate string of hashCodeOne and hashCodeTwo*/
        generatedPwd = hashCodeOne + hashCodeTwo;

        if (generatedPwd.length() > noOfCharacters) {
            generatedPwd = generatedPwd.substring(0, noOfCharacters);
        }

        return generatedPwd.toUpperCase();
    }

    public List enrollDetailsSearch(RegistrationAction registrationAction, String query) throws ServiceLocatorException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        List<GeneralVTO> enrolldetails = new ArrayList();


        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            GeneralVTO generalVTO;
            while (resultSet.next()) {
                generalVTO = new GeneralVTO();
                generalVTO.setFname(resultSet.getString("FName"));
                generalVTO.setLname(resultSet.getString("LName"));
                generalVTO.setEmail(resultSet.getString("Email"));
                generalVTO.setPhoneNum(resultSet.getString("PhoneNum"));
                generalVTO.setUserId(resultSet.getString("id"));
                 if (resultSet.getString("CollegeName") != null) {
                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));
                } else {
                    generalVTO.setCollegeName(resultSet.getString("College"));
                }
                generalVTO.setProfissionType(resultSet.getString("ProfessionType"));
                
                enrolldetails.add(generalVTO);
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

        return enrolldetails;
    }

    public String excelSheetForRegistratioDetails(RegistrationAction registrationAction, String queryString) throws ServiceLocatorException {

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
        String generatedPath = "";
        List finalList = new ArrayList();
        try {

            generatedPath = com.mss.apcloud.util.Properties.getProperty("Regsistration.Details.Path");
            File file = new File(generatedPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOut = new FileOutputStream(file.getAbsolutePath() + "/Details.xls");
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
                String CollegeName;
                if (resultSet.getString("CollegeName") != null) {
                    CollegeName = resultSet.getString("CollegeName");
                } else {
                    CollegeName = resultSet.getString("College");
                }

                map = new HashMap();
                map.put("SNO", String.valueOf(j));
                map.put("NAME", name);
                map.put("Email", email);
                map.put("PhoneNum", phoneNum);
                map.put("CollegeName", CollegeName);

                finalList.add(map);
                j++;
            }


            if (finalList.size() > 0) {
                filePath = file.getAbsolutePath() + "/Details.xls";
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


                cell.setCellValue("SNO");
                cell1.setCellValue("NAME");
                cell2.setCellValue("Email");
                cell3.setCellValue("PhoneNum");
                cell4.setCellValue("CollegeName/Company");

                cell.setCellStyle(headercs);
                cell1.setCellStyle(headercs);
                cell2.setCellStyle(headercs);
                cell3.setCellStyle(headercs);
                cell4.setCellStyle(headercs);


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

                        cell.setCellValue((String) stateHistorylMap.get("SNO"));
                        cell1.setCellValue((String) stateHistorylMap.get("NAME"));
                        cell2.setCellValue((String) stateHistorylMap.get("Email"));
                        cell3.setCellValue((String) stateHistorylMap.get("PhoneNum"));
                        cell4.setCellValue((String) stateHistorylMap.get("CollegeName"));



                        if (count % 2 == 0) {
                            cell.setCellStyle(cellColor1);
                            cell1.setCellStyle(cellColor1);
                            cell2.setCellStyle(cellColor1);
                            cell3.setCellStyle(cellColor1);
                            cell4.setCellStyle(cellColor1);


                        } else {
                            cell.setCellStyle(cellColor);
                            cell1.setCellStyle(cellColor);
                            cell2.setCellStyle(cellColor);
                            cell3.setCellStyle(cellColor);
                            cell4.setCellStyle(cellColor);

                        }
                    }




                }
                //  sheet.autoSizeColumn((int)1000000);
                sheet.setColumnWidth(0, 15 * 256);
                sheet.setColumnWidth(1, 30 * 256);
                sheet.setColumnWidth(2, 35 * 256);
                sheet.setColumnWidth(3, 30 * 256);
                sheet.setColumnWidth(4, 40 * 256);

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

    public int insertRegisterCoachDetails(RegistrationAction registrationAction) throws ServiceLocatorException {
       // System.out.println("herte---------insertRegisterCoachDetails----------");

        String result = "";
        String resultMessage;
        int updatedRows = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {


            connection = ConnectionProvider.getInstance().getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO tblCoachDetails(NAME,Email,Title,PhoneNumber,NameofExistingCompany,AreasOfExpertise) VALUES(?,?,?,?,?,?) ");
            preparedStatement.setString(1, registrationAction.getName());
            // System.out.println("----name-----" + registrationAction.getName());

            preparedStatement.setString(2, registrationAction.getEmail());
            // System.out.println("----email-----" + registrationAction.getEmail());
            preparedStatement.setString(3, registrationAction.getTitle());
            preparedStatement.setString(4, registrationAction.getPhone());
            preparedStatement.setString(5, registrationAction.getCompanyName());
            preparedStatement.setString(6, registrationAction.getAreasOfExpertise());
            // preparedStatement.setString(7, registrationAction.getEmail());
            //System.out.println("---email---"+registrationAction.getEmail());

            updatedRows = preparedStatement.executeUpdate();
            result = "success";
            MailManager sendMail = new MailManager();
//                System.out.println("sendResetPwd-->" + emailId + "  " + name + " " + psw);
            int mailFlag = Integer.parseInt(com.mss.apcloud.util.Properties.getProperty("Mail.Flag"));
            if (mailFlag == 1) {

                resultMessage = sendMail.sendRegistrationCoachMail(registrationAction);
                if (resultMessage.equalsIgnoreCase("MailSent")) {
                    resultMessage = "mailsend";
                } else {
                    //   resultMessage = "Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id.";
                    resultMessage = "TryAgain";
                    //getHttpServletRequest().setAttribute(AppConstants.RESULT_MESSAGE1, "<font color=\"red\" size=\"2.5\">Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id. </font>");
                }
            }



        } catch (SQLException se) {
            se.printStackTrace();
            // throw new ServiceLocatorException(se);
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
            } catch (SQLException se) {
                throw new ServiceLocatorException(se);
            }
        }

        return updatedRows;
    }

    public String userExistanceInCoachDet(String email, String phone) throws ServiceLocatorException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "noteixst";
        String query = "SELECT Email,phoneNumber FROM tblCoachDetails WHERE Email='" + email + "' OR phoneNumber='" + phone + "'";
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                response = "exist";

                //  System.out.println("==="+resultSet.getString(1)+"==="+resultSet.getString(2));

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
    
    
     //reset user passsword
    public String updateUserPassword(PasswordAction passwordAction) throws ServiceLocatorException {
        System.out.println("==update user Password==" + passwordAction.getUserId());
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String queryString = null;
        // String result = "notExist";
        String resultMsg = "";

        PasswordUtility passwordUtility = new PasswordUtility();
         try {
            String status = DataSourceDataProvider.getInstance().isEmailExists(passwordAction.getUserId());

            connection = ConnectionProvider.getInstance().getConnection();
            //statement = connection.createStatement();
          
            /*here checking weather email exist or not ,if it exit the update will be done.*/
            if ("nodata".equalsIgnoreCase(status)) {
                resultMsg = "EmailNotExist";
            } else {
                System.out.println("----in iffffff-----");
                String encryptPass = passwordUtility.encryptPwd(passwordAction.getNewPassword());
                queryString = "UPDATE tblRegistrationDetails SET Password='" + encryptPass + "' WHERE Email='" + passwordAction.getUserId() + "'";
                System.out.println("queryString-->" + queryString);
                statement = connection.createStatement();
                statement.executeUpdate(queryString);
                System.out.println("updatedRows-->");
                resultMsg = "updated";
            }

        } catch (SQLException se) {
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
                throw new ServiceLocatorException(se);
            }
        }
        return resultMsg;

    }
    
      //edit registration details
    public GeneralVTO editRegidtrationDetails(RegistrationAction registrationAction, String query) throws ServiceLocatorException {
        System.out.println("----in impl----editreg-");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String response = "";
        // List<GeneralVTO> registereditdetails = new ArrayList();

        GeneralVTO generalVTO = null;
        try {
            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                generalVTO = new GeneralVTO();
                generalVTO.setFname(resultSet.getString("FName"));
                generalVTO.setLname(resultSet.getString("LName"));
                generalVTO.setEmail(resultSet.getString("Email"));
                generalVTO.setPhoneNumber(resultSet.getString("PhoneNum"));
                generalVTO.setUserId(resultSet.getString("id"));
//                if (resultSet.getString("CollegeName") != null) {
//                    generalVTO.setCollegeName(resultSet.getString("CollegeName"));
//                } else {
                generalVTO.setCollegeName(resultSet.getString("College"));
                //  }
                if ("3".equals(registrationAction.getProfession())) {

                    generalVTO.setCollegeCode(resultSet.getString("CollegeCode"));
                    generalVTO.setLocation(resultSet.getString("Location"));
                    generalVTO.setCode(resultSet.getString("CODE"));
                } else {
                   // if("1".equals(registrationAction.getBranch().equals("Others"))){
                   //generalVTO.setFrmOtherBranch(resultSet.getString("Branch"));
                       // System.out.println("--otherbranch----"+resultSet.getString("Branch"));
                   // }else{
                    
                    generalVTO.setBranch(resultSet.getString("Branch"));
                   //  System.out.println("--branch----"+resultSet.getString("Branch"));
                   // }
                    generalVTO.setYear(resultSet.getString("YEAR"));
                    generalVTO.setFacebookLink(resultSet.getString("FaceBookLink"));
                    generalVTO.setStreet(resultSet.getString("Street"));
                    generalVTO.setCity(resultSet.getString("City"));
                    generalVTO.setDistrict(resultSet.getString("District"));
                    generalVTO.setZipcode(resultSet.getString("ZipCode"));
                    generalVTO.setState(resultSet.getString("State"));
                    generalVTO.setFrmCompany(resultSet.getString("CompanyName"));
                    System.out.println("-----------" + resultSet.getString("CompanyName"));
                    generalVTO.setFrmDesignation(resultSet.getString("Designation"));
                    System.out.println("------designation---" + resultSet.getString("Designation"));
                }

                // generalVTO.setCollegeCode(resultSet.getString("CollegeCode"));
                //  generalVTO.setCode(resultSet.getString("CODE"));
                //  generalVTO.setLocation(resultSet.getString("Location"));
                //   System.out.println("------faculty---" + resultSet.getString("Location")+""+resultSet.getString("CODE")+""+resultSet.getString("CollegeCode"));

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

        return generalVTO;
    }

    //update registration details
    public String updateRegistrationDetails(RegistrationAction registrationAction) throws ServiceLocatorException {
        System.out.println("--------updateRegistrationDetails-------impl--------------");


        String result = "";
        String professionType = "";

        String query = "";
        String collegeQuery = "";
        int updatedRows = 0;
        Connection connection = null;
        Connection connection1 = null;
        PreparedStatement pstatement = null;
        PreparedStatement pstatement1 = null;
        ResultSet resultSet = null;
        //  GeneralVTO generalVTO = null;
        try {


            connection = ConnectionProvider.getInstance().getConnection();
            connection1 = ConnectionProvider.getInstance().getConnection();

            System.out.println("user id-->" + registrationAction.getUserId());
            System.out.println("profession-->" + registrationAction.getProfession());
            if ("1".equals(registrationAction.getProfession())) { 
               if("Others".equals(registrationAction.getBranch())){
                   registrationAction.setBranch(registrationAction.getFrmOtherBranch());
               }
                
                query = "UPDATE tblRegistrationDetails SET FName='" + registrationAction.getFname() + "',LName='" + registrationAction.getLname() + "' ,Email='" + registrationAction.getEmail() + "' ,PhoneNum='" + registrationAction.getPhoneNumber() + "' ,College='" + registrationAction.getCollegeName() + "',Branch='" + registrationAction.getBranch() + "',YEAR='" + registrationAction.getYear() + "' ,FaceBookLink='" + registrationAction.getFbprofile() + "',Street='" + registrationAction.getStreet() + "',City='" + registrationAction.getCity() + "',District='" + registrationAction.getDistrict() + "',ZipCode='" + registrationAction.getZipcode() + "',State='" + registrationAction.getState() + "' WHERE id='" + registrationAction.getUserId() + "'";

            } else if ("2".equals(registrationAction.getProfession())) {
                query = "UPDATE tblRegistrationDetails SET FName='" + registrationAction.getFname() + "',LName='" + registrationAction.getLname() + "' ,Email='" + registrationAction.getEmail() + "' ,PhoneNum='" + registrationAction.getPhoneNumber() + "'  ,FaceBookLink='" + registrationAction.getFbprofile() + "',Street='" + registrationAction.getStreet() + "',City='" + registrationAction.getCity() + "',District='" + registrationAction.getDistrict() + "',ZipCode='" + registrationAction.getZipcode() + "',State='" + registrationAction.getState() + "',CompanyName='" + registrationAction.getFrmCompany() + "',Designation='" + registrationAction.getFrmDesignation() + "' ,College='" + registrationAction.getFrmCompany() + "'  WHERE id='" + registrationAction.getUserId() + "'";

            } else if ("3".equals(registrationAction.getProfession())) {
                query = "UPDATE tblRegistrationDetails SET FName='" + registrationAction.getFname() + "',LName='" + registrationAction.getLname() + "' ,Email='" + registrationAction.getEmail() + "' ,PhoneNum='" + registrationAction.getPhoneNumber() + "'  WHERE id='" + registrationAction.getUserId() + "'";

                collegeQuery = "UPDATE tblEnrollCollegeDetails SET CollegeCode='" + registrationAction.getCollegeCode() + "',CODE='" + registrationAction.getCode() + "',Location='" + registrationAction.getLocation() + "'  WHERE Fac_Email='" + registrationAction.getEmail() + "'";

                pstatement1 = connection1.prepareStatement(collegeQuery);
                updatedRows = pstatement1.executeUpdate();
            }



            System.out.println("---query---" + collegeQuery);

            pstatement = connection.prepareStatement(query);
            updatedRows = pstatement.executeUpdate();



            System.out.println("updated-->" + updatedRows);
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
                if (pstatement1 != null) {
                    pstatement1.close();
                    pstatement1 = null;
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
}
