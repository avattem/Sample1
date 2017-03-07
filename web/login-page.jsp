<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <%@page import="com.mss.apcloud.util.AppConstants"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <title>AP Cloud | Login</title>


        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link href="<s:url value="/img/favicon.ico"/>" rel="shortcut icon">

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css"/>">

        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="<s:url value="/css/plugins.css"/>">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="<s:url value="/css/main.css"/>">

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href=" <s:url value="/css/themes.css"/>">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/includes/javascripts/jquery.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>                
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <style>
            h4{
                color:#fff !important;
                font-weight:bolder !important;
            }
            
            * {
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            .animation-pullDown {
                animation-name: pullDown;
                -webkit-animation-name: pullDown;
                animation-duration: 1.1s;
                -webkit-animation-duration: 1.1s;
                animation-timing-function: ease-out;
                -webkit-animation-timing-function: ease-out;
                transform-origin: 50% 0%;
                -ms-transform-origin: 50% 0%;
                -webkit-transform-origin: 50% 0%;
            }
            .block {
                margin: 0 0 10px;
                padding: 20px 15px 1px;
                background-color: RGBA(35, 37, 39, 0.78);
                border-top-left-radius: 2px;
                border-top-right-radius: 2px;
                -webkit-box-shadow: 0 2px 0 rgba(218, 224, 232, .5);
                box-shadow: 0 2px 0 rgba(218, 224, 232, .5);
            }
            .animation-fadeInQuick {
                animation-name: fadeInQuick;
                -webkit-animation-name: fadeInQuick;
                animation-duration: 0.5s;
                -webkit-animation-duration: 0.5s;
                animation-timing-function: ease-out;
                -webkit-animation-timing-function: ease-out;
                visibility: visible !important;
            }
            .block-title {
                margin: -20px -5px 20px;
                border-bottom: 2px solid #dae0e8;
                border-top-left-radius: 2px;
                border-top-right-radius: 2px;
                color:white;
            }
            .form-group {
                display: block;
                margin-top: 0em;
                color:white!important;
            }
            body{

                background: #000 url('../img/login-bgscreen.jpg') no-repeat center center fixed;

                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                margin: 0 auto;
                display: block;
                position: relative;
                height: 100%;
                width: 100%;
                text-align: center;

            }

        </style>

    </head>

    <body class="" style="height:100%;width:100%;">
        <div >
            <!-- Page Container -->
            <!-- In the PHP version you can set the following options from inc/config file -->
            <!-- 'boxed' class for a boxed layout -->
            <div id="page-container" style="">
                <!-- Site Header -->

                <!-- END Site Header -->

                <!-- Intro -->

                <!-- Login Container -->
                <div class="row ">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4" >
                        <div id="login-container">
                            <br>
                            <center> 

                                <a href="<s:url value="/home.action"/>">  <img src="<s:url value="/img/apcloud-web-logo-horizontal-1.png"/>" class="img-responsive text-center push-top-bottom animation-pullDown"/></center></a>
                                   
        
                                  <div class="row">  
                                <div class="col-sm-12" style="text-align: center">
                                    <%--     <%
                            String noHTMLString = "";
                                        if (request.getAttribute(AppConstants.RESULT_MESSAGE) != null) {
                                           // out.println(request.getAttribute(AppConstants.RESULT_MESSAGE));
                                            
                                            // noHTMLString = request.getAttribute(AppConstants.RESULT_MESSAGE).toString().replaceAll("\\<.*?>","");
                                             noHTMLString = request.getAttribute(AppConstants.RESULT_MESSAGE).toString();
                                              out.println(noHTMLString+".");
                                        }
                                    %>  --%>

                                    <%
                                        String noHTMLString = "";
                                        if (request.getAttribute(AppConstants.RESULT_MESSAGE) != null) {
                                            // out.println(request.getAttribute(AppConstants.RESULT_MESSAGE));

                                            //   noHTMLString = request.getAttribute(AppConstants.RESULT_MESSAGE).toString().replaceAll("\\<.*?>","");
                                            noHTMLString = request.getAttribute(AppConstants.RESULT_MESSAGE).toString();
                                            out.println(noHTMLString);
                                            noHTMLString = "";

                                        }

                                    %>
                                </div>
                            </div>

                            <div class="block animation-fadeInQuick">
                                <!-- Login Title -->
                                <div class="block-title text-left">
                                    <h3><strong>Login</strong></h3>
                                </div>
                                <!-- END Login Title -->

                                <!-- Login Form -->
                                <s:form id="form-login" theme="simple"  method="post" action="loginCheck.action" cssClass="form-horizontal" onsubmit="return loginValidation()">
                                    <div class="form-group">
                                        <label for="login-email" class="col-xs-12 text-left">Email</label>
                                        <div class="col-xs-12">
                                            <s:textfield cssClass="form-control" placeholder="Your email.." name="emailid" id="emailid" required="required"  onchange="checkEmail(this);borderCssChange(this);" />

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="login-password" class="col-xs-12 text-left">Password</label>
                                        <div class="col-xs-12 ">
                                            <s:password cssClass="form-control " id="password" name="password" placeholder="Your password.." required="required" onchange="borderCssChange(this);"  />

                                        </div>
                                    </div>
                                    <div class="form-group form-actions">
                                        <div class="col-xs-8 ">
                                            <label class="csscheckbox csscheckbox-primary pull-left ">
                                             <a href="#" data-toggle="modal" data-target="#myModalemailcheck" onclick="resetFormFields()">  
                                              <font color="#00aae7">   Forgot Password? </font>
                                                 </a>
                                            </label>
                                        </div>
                                        <div class="col-xs-4 text-right">
                                            <s:submit cssClass="btn btn-effect-ripple btn-sm btn-info" id="btnSubmit" name="btnSubmit" tabindex="12" value="Log In" type="submit"> </s:submit>
                                            <!--<button type="submit" class="btn btn-effect-ripple btn-sm btn-info" data-toggle="modal" data-target="#myModal"><strong>Log In</strong></button>-->
                                        </div>
                                    </div>
                                </s:form>
                                <!-- END Login Form -->

                                <!-- Social Login -->

                                <!-- END Social Login -->
                            </div>

                            <!-- alert-->

                            <!-- alert ends-->
                            <!-- END Login Block -->

                            <!-- Footer -->

                            <!-- END Footer -->
                        </div>
                        <strong><center class="text-dark"><em><span>2016</span></em> &copy;  Miracle Software Systems, Inc.</center> </strong>
                    </div>
                    <div class="col-sm-4"></div>
                </div>



                <!-- END Page Container -->
                <!--show alert model-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body">
                                <strong>
                                    <div id="showAlertText">
                                    </div>
                                </strong>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">
                                    Close
                                </button>
                            </div><!-- Modal Footer -->
                        </div><!-- Modal Content -->
                    </div><!-- Modal Dialog -->
                </div><!-- Modal Container-->
                
                <!--forget password model-->
                
                 <div id="myModalemailcheck" class="modal fade" role="dialog">
            <div class="modal-dialog" >

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="heavy modal-title">Forgot Password</h4>
<!--                        <hr>-->
                    </div>
                    <div id="loadingMessage"></div>
                    <div class="modal-body">
                        <div class="row">

                            <div class="col-sm-6">

                                <form method="post" action="" id="myForm">
                                    <div class="row">
                                        <!--copy 1 from contact first row starts-->
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <s:textfield cssClass="form-control" id="emailForPass" name="emailForPass" placeholder="Email*" required="required" onchange="emailLengthValidater(this);checkEmailOnOverlay(this);borderCssChange(this);"/>
                                            </div>

                                        </div>
                                    </div>

                                    <div id="resultMessage1" style="width: 400px;"></div>
                                    <!--copy 1 from contact first row ends-->
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <button class="btn btn-effect-ripple btn-sm btn-info col-sm-12" id="Submitbutton" name="Submitbutton" tabindex="12" type="button" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." onclick="return forgetPassword();"> Submit </button>

                                            </div>
                                        </div>
                                    </div>

                                </form>

                            </div>
                            <div class="col-sm-6"></div>


                        </div>
                    </div>
                    <div class="modal-footer">

                    </div>

                </div>
            </div>
        </div>

                <!-- Scroll to top link, initialized in js/app.js - scrollToTop() -->
                <a href="#" id="to-top"><i class="fa fa-arrow-up"></i></a>
            </div>
            <!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
            <script src="js/vendor/jquery-2.2.0.min.js"></script>
            <script src="js/vendor/bootstrap.min.js"></script>
            <script src="js/plugins.js"></script>
            <script src="js/app.js"></script>
            <script src="js/pages/readyLogin.js"></script>

    </body>
</html>
