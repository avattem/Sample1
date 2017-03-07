/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.DashBoard;

import com.mss.apcloud.util.ServiceLocatorException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author miracle
 */
public interface DashBoardService {

    public List getDashBoardDetails(String workShopIds, String college, String professionType) throws ServiceLocatorException;

    public String enrollWorkshop(String workshopId, String emailId, String workshopIds) throws ServiceLocatorException;

    public List getDashboardWorkshop(String workShopIds, String contactDetails, String college, String professionType) throws ServiceLocatorException;

    public List getTechTopicData(String enrollTopics) throws ServiceLocatorException;

    public String updateDetails(DashBoardAction dashBoardAction,String professionType) throws ServiceLocatorException;

    public Collection getMcertExamReviewCollection(int creId, int noOfRecords) throws ServiceLocatorException;

    public List getAvailableCertifications(int userId, String professionType) throws ServiceLocatorException;

    public List getWorkshopDetailsTopicWise(int userId) throws ServiceLocatorException;

    public String getWorkshopTopics(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public List leftMenuCollege(String collegeCode, String college, String location, String codeGenerate, String link, String frmDate, String toDate) throws ServiceLocatorException;

    public String getEnolledCollegeDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String updateEnrollCollege(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public List enrollLeftMenuCollege(DashBoardAction dashBoardAction, String collegeCode, String college, String location, String codeGenerate, String link, String frmDate, String toDate) throws ServiceLocatorException;

    public String getWorkshopAddDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String getCurrcullamAddTopicsData(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String generateCollegeExcel(String frmDate, String toDate) throws ServiceLocatorException;

//new coach details
    public List registredCoachDetailsSearch(DashBoardAction dashBoardAction,String name, String title, String email, String phoneNumber, String companyName, String areaOfExpertise, String status, String frmDate, String toDate) throws ServiceLocatorException;

    public List getWorkshopRegistratesData(String workshopCode) throws ServiceLocatorException;

    public List topicsListRetrive(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String insertorUpdateTopics(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String topicsAddorUpdate(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String topicImageDownload(int topicId) throws ServiceLocatorException;

    public String updateTopics(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public List getDocumentsList(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String insertDocumentDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException;

    public String updateDocumentDetails(DashBoardAction dashBoardAction) throws ServiceLocatorException;
    
       public String excelSheetForWorkshopregDetails(DashBoardAction dashBoardAction, String queryString) throws ServiceLocatorException;
}
