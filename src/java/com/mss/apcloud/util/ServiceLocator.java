/*******************************************************************************
 *
 * Project : Miracle Supply Chain Visibility portal v2.0
 *
 * Package : com.mss.mscvp.utill
 *
 * Date    : Mar 12, 2013 1:36:56 PM
 *
 * Author  : Nagireddy seerapu <nseerapu@miraclesoft.com>
 *
 * File    : ServiceLocator.java
 *

 * *****************************************************************************
 */
package com.mss.apcloud.util;

import com.mss.apcloud.DashBoard.DashBoardImpl;
import com.mss.apcloud.DashBoard.DashBoardService;
import com.mss.apcloud.ajax.AjaxHandlerService;
import com.mss.apcloud.ajax.AjaxHandlerServiceImpl;
import com.mss.apcloud.contactus.ContactUsService;
import com.mss.apcloud.contactus.ContactUsServiceImpl;
import com.mss.apcloud.general.GeneralService;
import com.mss.apcloud.general.GeneralServiceImpl;
import com.mss.apcloud.techdetails.TechDetailsService;
import com.mss.apcloud.techdetails.TechDetailsServiceImpl;

/*
 * This Class Creates instances of all classes.
 */
public class ServiceLocator {

    /** Creates a new instance of ServiceLocator */
    private ServiceLocator() {
    }

    public static GeneralService getGeneralService() {
        GeneralService generalService = new GeneralServiceImpl();
        return generalService;
    }

    public static AjaxHandlerService getAjaxHandlerService() {
        AjaxHandlerService ajaxHandlerService = new AjaxHandlerServiceImpl();
        return ajaxHandlerService;
    }
    
     public static DashBoardService getDashBoardService() {
        DashBoardService dashboardService = new DashBoardImpl();
        return dashboardService;
    }
     
     public static TechDetailsService getTechDetailsService() {
        TechDetailsService techDetailsService = new TechDetailsServiceImpl();
        return techDetailsService;
    }
      public static ContactUsService getContactUsService() {
        ContactUsService contactUsService = new ContactUsServiceImpl();
        return contactUsService;
    }
    /*  public static BmTrackingService getBmTrackingService() throws ServiceLocatorException{
    BmTrackingService bmTrackingService = new BmTrackingServiceImpl();
    //  BmTrackingService bmTrackingService = null;
    return bmTrackingService;
    }  */
}
