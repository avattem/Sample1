/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.ajax;

import com.mss.apcloud.util.ServiceLocatorException;

/**
 *
 * @author miracle
 */
public interface AjaxHandlerService {

    public String userExistance(String email, String phone) throws ServiceLocatorException;
    //New method for setting districts based on state id

    public String getDistrictNames(int stateID) throws ServiceLocatorException;

    public String getCollegeCodes(int id) throws ServiceLocatorException;

    public String check(String Name) throws ServiceLocatorException;

    public String getRepoData(int value, String topicName) throws ServiceLocatorException;

    public String getCurriculam(String workshopCode) throws ServiceLocatorException;

    public String getCollegeCoordinators(int collegeName) throws ServiceLocatorException;
    //new

    public String getTechTopicData() throws ServiceLocatorException;

    public String getExamResultsByTopicId(String consultantId, String topicId) throws ServiceLocatorException;

    public String enrollTechTopic(String topicsList, String userId, String inserType, String workshopCode) throws ServiceLocatorException;

    public String getEnrolledTopicsList(String userId, String workshopCode) throws ServiceLocatorException;

    public String getAddCollegeDet(String collegeCode, String collegeName, String codegenerate, String location, String link, String email) throws ServiceLocatorException;

    public String editCollegeDet(String collegeCodes, String collegeName, String location, String link, String email) throws ServiceLocatorException;

    public String getEnrollCollegeCoordinators(int collegeName) throws ServiceLocatorException;

    public String addWorkshop(String collegeName, String workshopDate, String location, String email,int workshopType) throws ServiceLocatorException;

    public String updateWorkshop(String workshopCode, String workshopDate, String location, String email) throws ServiceLocatorException;

    public String addCurrculumData(String currcullamDate, int topicId, String durationTime, String subTopic, String email, String workshopCode, String venue) throws ServiceLocatorException;

    public String updateCurrculumData(AjaxHandlerAction ajaxHandlerAction) throws ServiceLocatorException;

    public String getWorkshopCodeByCollegeName(int collegeName) throws ServiceLocatorException;

    public String getEnrolledWorkshopandTopics(int userId) throws ServiceLocatorException;
    
    //edit coach details
    public String editCoachDetils(int id,String name,String emaill,String phoneNum,String title,String companyName,String areaOfExpertise,String status,String email) throws ServiceLocatorException;
    
     public String getAddCoachDet(String name, String email, String title, String existingCompanyName, String phoneNumber, String areaOfExpertise,String status) throws ServiceLocatorException;
}