/*******************************************************************************
 *
 * Project : Miracle Supply Chain Visibility portal v2.0
 *
 * Package : com.mss.mscvp.general
 *
 * Date    : Mar 11, 2013 1:28:58 PM
 *
 * Author  : Nagireddy seerapu <nseerapu@miraclesoft.com>
 *
 * File    : DataServiceLocator.java
 *

 * *****************************************************************************
 */
package com.mss.apcloud.util;


/*import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;*/
//import com.ibm.db2.jcc.DB2DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.struts2.interceptor.ServletRequestAware;


/**
 * This is a Data Service Locator object used to abstract all JNDI usage and to
 * hide the complexities of initial context creation, DataSource lookup.
 * Multiple clients can reuse the Service Locator object to reduce code
 * complexity, provide a single point of control, and improve performance by
 * providing a caching facility.
 * <p>
 * This class reduces the client complexity that results from the client's
 * dependency on and need to perform lookup and creation processes, which are
 * resource-intensive. To eliminate these problems, this pattern provides a
 * mechanism to abstract all dependencies and network details into the Service
 * Locator.
 * 
 * <p>
 * Usage: This is a Singleton class, usage is as follows:<br>
 * Use the getInstance method to create an instance of the class.
 * 
 * <code>ServiceLocator serviceLocator = ServiceLocator.getInstance();</code>
 * 
 * @author MrutyumjayaRao Chennu<mchennu@miraclesoft.com>
 * 
 * @version 1.0
 * 
 */
public class DataServiceLocator {

    private Context context;
    private static DataServiceLocator _instance;

    private DataServiceLocator() throws ServiceLocatorException {
        try {
            context = new InitialContext();
        } catch (Exception ex) {
            throw new ServiceLocatorException(ex);
        }
    }

    /**
     * @return An instance of the DataServiceLocator class
     * @throws ServiceLocatorException
     */
    public static DataServiceLocator getInstance()
            throws ServiceLocatorException {
        try {
            if (_instance == null) {
                _instance = new DataServiceLocator();
            }
        } catch (Exception ex) {
            throw new ServiceLocatorException(ex);
        }
        return _instance;
    }

    /*
     * @param dataSourceName
     *            - Name of the DataSource, needs to be looked up
     * @return Looked DataSource from the JNDI registry.
     * @throws ServiceLocatorException
     *             when there exists a problem Looking up the Data Source.
     */
    /*public DataSource getDataSource(String dataSourceName)
    throws ServiceLocatorException {
    DataSource dataSource = null;
    
    try {
    System.out.println("before geting datasource");
    if (CacheManager.getCache().containsKey(dataSourceName)) {
    System.out.println("before geting datasource in ifff");
    dataSource = (DataSource) CacheManager.getCache().get(
    dataSourceName);
    System.out.println("after geting datasource in ifff");
    
    } else {
    System.out.println("before geting datasource in else");
    
    dataSource = (DataSource) context.lookup("java:comp/env/"+ dataSourceName);
    //dataSource = (DataSource) context.lookup(dataSourceName);
    System.out.println("after geting datasource in else");
    CacheManager.getCache().put(dataSourceName, dataSource);				
    }
    } catch (Exception ex) {
    throw new ServiceLocatorException(
    ErrorMessages.CANNOT_GET_DATASOURCE + ex.getMessage(), ex);
    }
    
    return dataSource;
    }*/
    public DataSource getDataSource(String dataSourceName)
            throws ServiceLocatorException {

        DataSource dataSource = null;

        try {
            // System.out.println("before iff");
            if (CacheManager.getCache().containsKey(dataSourceName)) {
                // System.out.println("in iff");
                dataSource = (DataSource) CacheManager.getCache().get(dataSourceName);
                // System.out.println("in iff after");

            } else {
                //   System.out.println("dsstart--->"+dataSourceName);
                /*dataSource = (DataSource) context.lookup("java:comp/env/"+dataSourceName);
                System.out.println("dataSource--->"+dataSource);
                CacheManager.getCache().put(dataSourceName, dataSource);
                System.out.println("dsend");*/



                Context ctx = new InitialContext();
                // System.out.println("context1--->"+ctx);
                // Context envCtx=(Context)ctx.lookup("java:comp/env/"+dataSourceName);
                // System.out.println("hiiii123");
                dataSource = (DataSource) ctx.lookup("java:comp/env/" + dataSourceName);
                // System.out.println("afetr  hiiii123");
                //  System.out.println("ds--->"+ds);
                // System.out.println("dsend");
            }
        } catch (Exception ex) {
            System.err.println("exceptionee--->" + ex.getMessage());
            throw new ServiceLocatorException(ErrorMessages.CANNOT_GET_DATASOURCE + ex.getMessage(), ex);
        }


        return dataSource;
    }
}
