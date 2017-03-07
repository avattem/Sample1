/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.techdetails;

import com.mss.apcloud.util.ServiceLocatorException;
import java.util.List;

/**
 *
 * @author miracle
 */
public interface TechDetailsService {
     public String getData(TechDetailsAction techDetailsAction) throws ServiceLocatorException;
      public String getRepoData(TechDetailsAction techDetailsAction)throws ServiceLocatorException;
}
