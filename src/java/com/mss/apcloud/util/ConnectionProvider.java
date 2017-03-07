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
 * File    : ConnectionProvider.java
 *

 * *****************************************************************************
 */
package com.mss.apcloud.util;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import javax.sql.DataSource;



public class ConnectionProvider {

    private static ConnectionProvider _instance;
    private DataSource dataSource;
    private Connection connection;

    private ConnectionProvider() {
    }

    public static ConnectionProvider getInstance() {

        if (_instance == null) {
            _instance = new ConnectionProvider();
        }
        return _instance;
    }

    /**
     *
     * @return returns Connection from IntialContext
     */
    /*  public Connection getConnection() throws ServiceLocatorException{
    try{
    
    
    //dataSource = DataServiceLocator.getInstance().getDataSource(Properties.getProperty("Db.Datasource.Name"));
    dataSource = DataServiceLocator.getInstance().getDataSource("jndi/mscvp");
    connection = dataSource.getConnection();
    }catch(ServiceLocatorException se) {
    throw new ServiceLocatorException("Exception in Connection Provider");
    }catch(SQLException sqlEx) {
    throw new ServiceLocatorException(sqlEx);
    }
    return connection;
    
    
    }*/
    public Connection getConnection() throws ServiceLocatorException {
        try {
            // System.out.println("connection-->"+Properties.getProperty("New.DataSource.Name"));
            dataSource = DataServiceLocator.getInstance().getDataSource(Properties.getProperty("New.DataSource.Name"));
            //   System.out.println("connection11");
            connection = dataSource.getConnection();
            // System.out.println("connection-->"+connection);
        } catch (ServiceLocatorException se) {
            throw new ServiceLocatorException("Exception in Connection Provider" + se.getMessage());
        } catch (SQLException sqlEx) {
            throw new ServiceLocatorException(sqlEx);
        }
        return connection;
    }
    public Connection getHubbleDbConnection() throws ServiceLocatorException {
        try {
            // System.out.println("connection-->"+Properties.getProperty("New.DataSource.Name"));
            dataSource = DataServiceLocator.getInstance().getDataSource(Properties.getProperty("Hubble.DataSource.Name"));
            //   System.out.println("connection11");
            connection = dataSource.getConnection();
            // System.out.println("connection-->"+connection);
        } catch (ServiceLocatorException se) {
            throw new ServiceLocatorException("Exception in Connection Provider" + se.getMessage());
        } catch (SQLException sqlEx) {
            throw new ServiceLocatorException(sqlEx);
        }
        return connection;
    }
}
