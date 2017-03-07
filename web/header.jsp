
<!DOCTYPE html>
<html>
    <!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
    <!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
        <head>
            <meta charset="utf-8">
            <%@ taglib prefix="s" uri="/struts-tags" %>
            <title>AP Cloud Initiative</title>
            <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
            <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

            <!-- image carousel css ends-->

            <!-- Stylesheets -->
            <!-- Bootstrap is included in its original form, unaltered -->
            <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css"/>">

            <link href="<s:url value="/img/favicon.ico"/>" rel="shortcut icon">




            <!-- Related styles of various icon packs and plugins -->
            <link rel="stylesheet" href="<s:url value="/css/plugins.css"/>">

            <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
            <link rel="stylesheet" href="<s:url value="/css/main.css"/>">

            <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
            <link rel="stylesheet" href="<s:url value="/css/themes.css"/>">
            <!-- END Stylesheets -->

            <!-- Modernizr (browser feature detection library) -->
            
            <style>
                .blue{
                    background-color:#00aae7;
                }
                .scrol{
                    border-radius: 4px !important;
                    height:10px;
                    color: #ffffff !important;
                    background-color: #ef4048;
                }
                .scrol:hover{
                    color: #ffffff !important;
                    background-color: #ef4048;
                }
            </style>
        </head>
        <body>
            <!-- Page Container -->
            <!-- In the PHP version you can set the following options from inc/config file -->
            <!-- 'boxed' class for a boxed layout -->
            <div id="" class="boxed">
                <header>
                    <div class="container">
                        <!-- Site Logo -->
                        <a href="<s:url value="/home.action"/>" style="text-decoration:none"><img src="<s:url value="/img/apcloud-web-logo-horizontal.png"/>" height="70px"  ></a> 
                        <!-- END Site Logo -->

                        <!-- Site Navigation -->
                        <nav>
                            <!-- Menu Toggle -->
                            <br>
                            <!-- Toggles menu on small screens -->
                            <a href="javascript:void(0)" class="btn btn-default site-menu-toggle visible-xs visible-sm">Menu</a>
                            <!-- END Menu Toggle -->

                            <!-- Main Menu -->
                            <ul class="site-nav">
                                <li>
                                    <a href="<s:url value="/about-us.action"/>" >About Us</a>
                                </li>

                                <li>
                                    <a href="<s:url value="/general/workshop.action"/>" >Workshops</a>
                                </li>

                                <li>
                                    <a href="<s:url value="/general/college.action"/>">Colleges</a>
                                </li>
                                <li>
                                    <a href="<s:url value="/general/contactUS.action"/>">Contact Us</a>
                                </li>
                                <s:if test="%{#session.username!=null && #session.username!= ''}"> 
                                    <li>
                                        <a href="<s:url value="/general/logout.action"/>">Logout</a>
                                    </li>
                                </s:if><s:else>
                                    <li>
                                        <a href="<s:url value="/general/login.action"/>">Login</a>
                                    </li>
                                    <li>
                                        <a href="<s:url value="/enroll.action"/>" class="black scrol">Enroll Today &nbsp;<i class="fa fa-arrow-right"></i></a>   
                                    </li>
                                </s:else>
                            </ul>

                            <!-- END Main Menu -->
                        </nav>
                        <!-- END Site Navigation -->
                    </div>
                </header>
            </div>
        </body>
    </html>