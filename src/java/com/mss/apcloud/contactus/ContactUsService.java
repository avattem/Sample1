/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.contactus;

import com.mss.apcloud.util.ServiceLocatorException;

/**
 *
 * @author miracle
 */
public interface ContactUsService {
    public String addContactUsData(ContactUsAction contactUsAction) throws ServiceLocatorException;
}
