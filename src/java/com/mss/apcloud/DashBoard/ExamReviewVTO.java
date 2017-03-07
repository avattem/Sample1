/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.DashBoard;

import java.io.Serializable;

/**
 *
 * @author miracle
 */
public class ExamReviewVTO implements Serializable{
    private String mcertLoginId;
    private String examTypeName;
    private int minMarks;
    private int totalQuestions;
    private int attemptedQuestions;
    private String dateSubmitted;
    private String examStatus;
    private String examKeyId;
private int marks;
    /**
     * @return the mcertLoginId
     */
    public String getMcertLoginId() {
        return mcertLoginId;
    }

    /**
     * @param mcertLoginId the mcertLoginId to set
     */
    public void setMcertLoginId(String mcertLoginId) {
        this.mcertLoginId = mcertLoginId;
    }

    /**
     * @return the examTypeName
     */
    public String getExamTypeName() {
        return examTypeName;
    }

    /**
     * @param examTypeName the examTypeName to set
     */
    public void setExamTypeName(String examTypeName) {
        this.examTypeName = examTypeName;
    }

    /**
     * @return the minMarks
     */
    public int getMinMarks() {
        return minMarks;
    }

    /**
     * @param minMarks the minMarks to set
     */
    public void setMinMarks(int minMarks) {
        this.minMarks = minMarks;
    }

    /**
     * @return the totalQuestions
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * @param totalQuestions the totalQuestions to set
     */
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    /**
     * @return the attemptedQuestions
     */
    public int getAttemptedQuestions() {
        return attemptedQuestions;
    }

    /**
     * @param attemptedQuestions the attemptedQuestions to set
     */
    public void setAttemptedQuestions(int attemptedQuestions) {
        this.attemptedQuestions = attemptedQuestions;
    }

    /**
     * @return the dateSubmitted
     */
    public String getDateSubmitted() {
        return dateSubmitted;
    }

    /**
     * @param dateSubmitted the dateSubmitted to set
     */
    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    /**
     * @return the examStatus
     */
    public String getExamStatus() {
        return examStatus;
    }

    /**
     * @param examStatus the examStatus to set
     */
    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    /**
     * @return the examKeyId
     */
    public String getExamKeyId() {
        return examKeyId;
    }

    /**
     * @param examKeyId the examKeyId to set
     */
    public void setExamKeyId(String examKeyId) {
        this.examKeyId = examKeyId;
    }

    /**
     * @return the marks
     */
    public int getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
}
