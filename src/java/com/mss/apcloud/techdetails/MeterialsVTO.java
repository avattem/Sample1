/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.techdetails;

/**
 *
 * @author miracle
 */
public class MeterialsVTO {

    public int id;
    public int topicId;
    public String topicName;
    public String type;
    public String docName;
    public String fileName;
    public String filePath;
    public String imagePath;
    private String topicLink;
    private int examId;
    private boolean topicEnabled;
    private String date;
    private String durationTime;
    private String subTopic;
    private String currculamId;
    private String venue;
    private int startExamEnable;
    
     private int examExistInHubble;

     
     private String status;
     
     
     
     

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
    
    
    public int getExamExistInHubble() {
        return examExistInHubble;
    }

    public void setExamExistInHubble(int examExistInHubble) {
        this.examExistInHubble = examExistInHubble;
    }

    public int getStartExamEnable() {
        return startExamEnable;
    }

    public void setStartExamEnable(int startExamEnable) {
        this.startExamEnable = startExamEnable;
    }
    
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
    

    public String getCurrculamId() {
        return currculamId;
    }

    public void setCurrculamId(String currculamId) {
        this.currculamId = currculamId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }
    
    
    

    public boolean isTopicEnabled() {
        return topicEnabled;
    }

    public void setTopicEnabled(boolean topicEnabled) {
        this.topicEnabled = topicEnabled;
    }

    public String getTopicLink() {
        return topicLink;
    }

    public void setTopicLink(String topicLink) {
        this.topicLink = topicLink;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the examId
     */
    public int getExamId() {
        return examId;
    }

    /**
     * @param examId the examId to set
     */
    public void setExamId(int examId) {
        this.examId = examId;
    }
}
