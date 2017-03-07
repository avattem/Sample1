<%-- 
    Document   : LeftMenu
    Created on : Jul 6, 2016, 5:35:31 PM
    Author     : miracle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <style>
               .show-menu      
            {
                background-color:#2368a0;
              
                z-index: 1;
            
                height: 100%;
              
            }   

        </style>
    </head>
    <body>
        <div class="hold-transition skin-blue sidebar-mini" id="myowndiv">

            <table id="" class="table table-bordered table-hover">

                <tbody>
                    <tr>
                <nav id="show-menu" class="show-menu">
                    <div class="sideBySide">
                        <div class="left">
                            <ul class="source nav nav-tabs tabs-left">
                                <s:if test='%{#session.professionType == "1"}'>
                                        
                                    <li ><a href="<%=request.getContextPath()%>/general/workshopDashboard.action" >Workshop</a></li>
                                  <li ><a href="<%=request.getContextPath()%>/general/techTopics.action" >Topics</a></li>
                                <li><a href="<%=request.getContextPath()%>/general/certification.action" >Certification</a></li>

                                <li><a href="<%=request.getContextPath()%>/general/myProfile.action" >My Profile</a></li>
                              <li><a href="<%=request.getContextPath()%>/general/downloadkits.action" >Download Kits</a></li>
                                        
                                    </s:if>
                                     <s:elseif test='%{#session.professionType == "3"}'>
                                        <li><a href="<%=request.getContextPath()%>/general/enolledCollegeDetails.action" >Enrolled Details</a></li>
                                        <li><a href="<%=request.getContextPath()%>/general/downloadkits.action" >Download Kits</a></li>
                                       
                                    </s:elseif>
                                    <s:elseif test='%{#session.professionType == "2"}'>
                                         <li ><a href="<%=request.getContextPath()%>/general/workshopDashboard.action" >Workshop</a></li>
                                           <li ><a href="<%=request.getContextPath()%>/general/techTopics.action" >Topics</a></li>
                              <%--  <li><a href="<%=request.getContextPath()%>/general/certification.action" >Certification</a></li> --%>

                                <li><a href="<%=request.getContextPath()%>/general/myProfile.action" >My Profile</a></li>
                               
                                    </s:elseif>
                                <s:elseif test='%{#session.professionType == "4"}'>
                                <li><a href="<%=request.getContextPath()%>/general/leftMenuCollege.action" >Colleges&nbsp;List</a></li>
                                <li ><a href="<%=request.getContextPath()%>/general/workshopDetailsAdd.action" >Workshops</a></li>
                                <li><a href="<%=request.getContextPath()%>/general/enrollLeftMenuCollege.action" >Enrolled&nbsp;Colleges</a></li>
                                  <li><a href="<%=request.getContextPath()%>/general/registrationDetailsSearch.action" >RegistrationDetails</a></li>
                                  <li><a href="<%=request.getContextPath()%>/general/downloadkits.action" >Download Kits</a></li>
                                  <li><a href="<%=request.getContextPath()%>/general/registredCoachDetailsSearch.action" >RegisteredCoachDetails</a></li>
                                   <li><a href="<%=request.getContextPath()%>/general/topicsList.action" >Topic List</a></li>
                                  
                                </s:elseif>
                                 <li><a href="<%=request.getContextPath()%>/general/resetPassword.action" >Reset Password</a></li>  
                                  <li><a href="<%=request.getContextPath()%>/general/resetUserPassword.action" >Reset&nbsp;User&nbsp;Password</a></li> 
                            </ul>
                            <br><br><br><br> <br><br><br><br>
                            <br><br><br><br> <br><br><br><br>
                            <br><br><br><br> 
                           

                        </div>
                    </div>
                </nav>

                </tr>

            </table>
        </div>
    </body>
</html>
