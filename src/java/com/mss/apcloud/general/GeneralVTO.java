/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.general;

import java.io.Serializable;

/**
 *
 * @author Kalpana
 */
public class GeneralVTO implements Serializable {

    private int id;
    private String location;
    private String DATE;
    private String duration;
    private String sessionname;
    private int sno = 0;
    private String link;
    private String topicName;
    private String topicLink;
    private boolean workshopEnabled;
    private String workshopStatus;
    private int topicId;
    private String code;
    private String collegeName;
    private String codes;
    private String contactDetails;
    private String collegeId;
    private String workshopByTopic;
    private String durationTime;
    private String workshopDate;
    private String status;
    private String frmDate;
    private String toDate;
    private String collegeCode;
    private String name;
    private String email;
    private String phoneNum;
    private String userId;
    //new coach
    private String title;
    private String companyName;
    private String areasOfExpertise;
    private int workshopType;
    private String website;
    private String profissionType;
//for edit reg page
    private String fname;
    private String lname;
    private String branch;
    private String year;
    private String facebookLink;
    private String street;
    private String city;
    private String district;
    private String zipcode;
    private String state;
    private String phoneNumber;
    private String designation;
    private String frmCompany;
    private String frmDesignation;
    private String frmOtherBranch;

    public int getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(int workshopType) {
        this.workshopType = workshopType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkshopByTopic() {
        return workshopByTopic;
    }

    public void setWorkshopByTopic(String workshopByTopic) {
        this.workshopByTopic = workshopByTopic;
    }

    public String getWorkshopDate() {
        return workshopDate;
    }

    public void setWorkshopDate(String workshopDate) {
        this.workshopDate = workshopDate;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getWorkshopStatus() {
        return workshopStatus;
    }

    public void setWorkshopStatus(String workshopStatus) {
        this.workshopStatus = workshopStatus;
    }

    public String getTopicLink() {
        return topicLink;
    }

    public void setTopicLink(String topicLink) {
        this.topicLink = topicLink;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public boolean isWorkshopEnabled() {
        return workshopEnabled;
    }

    public void setWorkshopEnabled(boolean workshopEnabled) {
        this.workshopEnabled = workshopEnabled;
    }

    public String getSessionname() {
        return sessionname;
    }

    public void setSessionname(String sessionname) {
        this.sessionname = sessionname;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
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
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the collegeName
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * @param collegeName the collegeName to set
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * @return the codes
     */
    public String getCodes() {
        return codes;
    }

    /**
     * @param codes the codes to set
     */
    public void setCodes(String codes) {
        this.codes = codes;
    }

    /**
     * @return the contactDetails
     */
    public String getContactDetails() {
        return contactDetails;
    }

    /**
     * @param contactDetails the contactDetails to set
     */
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * @return the frmDate
     */
    public String getFrmDate() {
        return frmDate;
    }

    /**
     * @param frmDate the frmDate to set
     */
    public void setFrmDate(String frmDate) {
        this.frmDate = frmDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return the collegeCode
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * @param collegeCode the collegeCode to set
     */
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the areasOfExpertise
     */
    public String getAreasOfExpertise() {
        return areasOfExpertise;
    }

    /**
     * @param areasOfExpertise the areasOfExpertise to set
     */
    public void setAreasOfExpertise(String areasOfExpertise) {
        this.areasOfExpertise = areasOfExpertise;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the profissionType
     */
    public String getProfissionType() {
        return profissionType;
    }

    /**
     * @param profissionType the profissionType to set
     */
    public void setProfissionType(String profissionType) {
        this.profissionType = profissionType;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the facebookLink
     */
    public String getFacebookLink() {
        return facebookLink;
    }

    /**
     * @param facebookLink the facebookLink to set
     */
    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the frmCompany
     */
    public String getFrmCompany() {
        return frmCompany;
    }

    /**
     * @param frmCompany the frmCompany to set
     */
    public void setFrmCompany(String frmCompany) {
        this.frmCompany = frmCompany;
    }

    /**
     * @return the frmDesignation
     */
    public String getFrmDesignation() {
        return frmDesignation;
    }

    /**
     * @param frmDesignation the frmDesignation to set
     */
    public void setFrmDesignation(String frmDesignation) {
        this.frmDesignation = frmDesignation;
    }

    /**
     * @return the frmOtherBranch
     */
    public String getFrmOtherBranch() {
        return frmOtherBranch;
    }

    /**
     * @param frmOtherBranch the frmOtherBranch to set
     */
    public void setFrmOtherBranch(String frmOtherBranch) {
        this.frmOtherBranch = frmOtherBranch;
    }
}
