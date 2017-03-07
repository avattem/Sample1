/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.techdetails;

import com.mss.apcloud.util.ServiceLocator;
import com.mss.apcloud.util.ServiceLocatorException;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author miracle
 */
public class TechDetailsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    
    
    private HttpServletRequest servletRequest;
    private HttpServletResponse servletResponse;
    private int topicId;
    private String title;
    private String bodyContent;
    private String videoTutorialLink1;
    private String videoTutorialLink2;
    private String imageName;
    private String websitelink;
    private String tutorialLink;
    private String blogLink;
    private String video;
    private String flag;
    // private list videoTutorailList;
    private List videoTutorailList = new ArrayList();
    private  List docRepoList = new ArrayList();
    private int id;
    private String topicName;
    private String type;
    private String docName;
    private String fileName;
    private String filePath;
    private String imagePath;
    private String topicLink;
    private String path;
    private int prsentations ;
    private int webxSessions ;
    private int installationGuide;
   
    private List tutorialList = new ArrayList();
   
    private List blogLinkList = new ArrayList();

    
    public String getData() throws ServiceLocatorException 
    {
      //  System.out.println("---getData----" + getTopicId()+ "    " +getFlag());
        
        ServiceLocator.getTechDetailsService().getData(this);
        ServiceLocator.getTechDetailsService().getRepoData(this);
             return SUCCESS;
       
        
    }
    public void renderImage() {
        try {
            
           // System.out.println("path-->"+getPath());
            InputStream inputStream = null;
            OutputStream outputStream = null;
           // System.out.println("path" + path);
            servletResponse.setContentType("application/force-download");
            File file = new File(getPath());
          //  inputStream = new FileInputStream(file.getAbsolutePath());
              inputStream = new FileInputStream(file);
            outputStream = servletResponse.getOutputStream();

            if (outputStream == null) {
            } else {

                servletResponse.setContentType("text/html");
                int noOfBytesRead = 0;
                byte[] byteArray = null;

                while (true) {
                    byteArray = new byte[1024];
                    noOfBytesRead = inputStream.read(byteArray);
                    if (noOfBytesRead == -1) {
                        break;
                    }
                    outputStream.write(byteArray);

                }
                inputStream.close();
                outputStream.close();
            }

        } catch (IOException ex) {
            System.err.println("IOException in render Image "+ex.getMessage());
           // ex.printStackTrace();
        }
    }
   

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public List getDocRepoList() {
        return docRepoList;
    }

    public void setDocRepoList(List docRepoList) {
        this.docRepoList = docRepoList;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * @return the topicId
     */
    public int getTopicId() {
        return topicId;
    }

    /**
     * @param topicId the topicId to set
     */
    public void setTopicId(int topicId) {
        this.topicId = topicId;
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
     * @return the bodyContent
     */
    public String getBodyContent() {
        return bodyContent;
    }

    /**
     * @param bodyContent the bodyContent to set
     */
    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public String getVideoTutorialLink1() {
        return videoTutorialLink1;
    }

    public void setVideoTutorialLink1(String videoTutorialLink1) {
        this.videoTutorialLink1 = videoTutorialLink1;
    }

    public String getVideoTutorialLink2() {
        return videoTutorialLink2;
    }

    public void setVideoTutorialLink2(String videoTutorialLink2) {
        this.videoTutorialLink2 = videoTutorialLink2;
    }

    /**
     * @return the videoTutorialLink
     */
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * @return the imageLocation
     */
    /**
     * @return the websitelink
     */
    public String getWebsitelink() {
        return websitelink;
    }

    /**
     * @param websitelink the websitelink to set
     */
    public void setWebsitelink(String websitelink) {
        this.websitelink = websitelink;
    }

    /**
     * @return the tutuorialLink
     */
    public String getTutorialLink() {
        return tutorialLink;
    }

    public void setTutorialLink(String tutorialLink) {
        this.tutorialLink = tutorialLink;
    }

    /**
     * @return the blogLink
     */
    public String getBlogLink() {
        return blogLink;
    }

    /**
     * @param blogLink the blogLink to set
     */
    public void setBlogLink(String blogLink) {
        this.blogLink = blogLink;
    }

    /**
     * @return the videoTutorailList
     */
    public List getVideoTutorailList() {
        return videoTutorailList;
    }

    /**
     * @param videoTutorailList the videoTutorailList to set
     */
    public void setVideoTutorailList(List videoTutorailList) {
        this.videoTutorailList = videoTutorailList;
    }

    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public HttpServletResponse getServletResponse() {
        return servletResponse;
    }

    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    public List getBlogLinkList() {
        return blogLinkList;
    }

    public void setBlogLinkList(List blogLinkList) {
        this.blogLinkList = blogLinkList;
    }

    public List getTutorialList() {
        return tutorialList;
    }

    public void setTutorialList(List tutorialList) {
        this.tutorialList = tutorialList;
    }

    public int getInstallationGuide() {
        return installationGuide;
    }

    public void setInstallationGuide(int installationGuide) {
        this.installationGuide = installationGuide;
    }

    public int getPrsentations() {
        return prsentations;
    }

    public void setPrsentations(int prsentations) {
        this.prsentations = prsentations;
    }

    public int getWebxSessions() {
        return webxSessions;
    }

    public void setWebxSessions(int webxSessions) {
        this.webxSessions = webxSessions;
    }
    /**
     * @return the videoTutorailList
     */
    
    
}
