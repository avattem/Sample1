<%-- 
    Document   : RegisterCoachDetails
    Created on : Aug 5, 2016, 10:35:41 PM
    Author     : miracle
--%>

<html class="no-js">
    <!--<![endif]-->
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@page  import="com.mss.apcloud.util.AppConstants"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>AP Cloud Initiative</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta content="Use this service to register your required details as mentioned in the form and you can login to our dashboard with the registered credentials." name="Description">

        <!--  new      <link href="css/bootstrap.min.css" rel="stylesheet">
                <link href="css/font-awesome.min.css" rel="stylesheet">
                <link href="css/main.css" rel="stylesheet">
                <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
                <link rel="stylesheet" type="text/css" href="css/default.css"/>
                <link rel="stylesheet" type="text/css" href="css/component.css"/>-->

        <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/main.css"/>">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/default.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/component.css"/>"></link>
        <script src="js/modernizr.custom.js"></script>


        <script type="text/JavaScript" src="<s:url value="/js/Validation.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=1.1"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>



        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="../images/favicon.ico">
        
  <style type="text/css">
           .backgroundImage {
            background-image: url("../img/headerimage.png");
           -webkit-background-size: cover;
              -moz-background-size: cover;
              -o-background-size: cover;
              background-size: cover;
               
           }
          
        </style>

    </head>
    <s:include value="../header.jsp"/> 

    <body >
        <script>
            function showAlertModal(msg)
            {
                //alert(msg);
                document.getElementById('showAlertText').innerHTML = msg;
                $('#myModalvalidationCoach').modal('show');
                return false;
            }
            function clickHereToLoginPage(){
              
                //window.location="general/reglogin.action";
                window.location="general/login.action";

            }
        </script>
        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>AP Cloud Initiative</strong></h1>
                        </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">
                        
                    </div>
                
            </section>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 text-left">
                    <h1 class="heavy">

                        Register As a Coach

                    </h1>

                </div>

                <div class="col-sm-6 text-right">
                    <ul class="breadcrumb pull-right">

                        <li>
                            <a href="../home.action">
                                AP Cloud
                            </a>
                        </li>
                        <li class="active">
                            Register As a Coach
                        </li>
                    </ul>
                </div>
            </div>

            <div class="row">
                <%--  <s:if test="%{resultMessage == 'success'}">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Successfully Registered</strong> 
                        </div>
                    </s:if>--%>
              <%-- <s:if test="%{resultMessage == 'success'}">
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Successfully Registered</strong> 
                    </div>
                </s:if>
                <s:elseif test="%{resultMessage=='emailExist'}">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        Already Phone Number Or Email Existed
                    </div>
                </s:elseif>--%>
               <%
                                        String noHTMLString = ""; 
                                        if (request.getAttribute(AppConstants.RESULT_MESSAGE) != null) {
                                            // out.println(request.getAttribute(AppConstants.RESULT_MESSAGE));

                                            //   noHTMLString = request.getAttribute(AppConstants.RESULT_MESSAGE).toString().replaceAll("\\<.*?>","");
                                            noHTMLString = request.getAttribute(AppConstants.RESULT_MESSAGE).toString();
                                            out.println(noHTMLString);
                                        }
                                    %>
                               
            </div>


            <div class="row">
                <div class="col-sm-12">
                    <s:form method="post" action="registerCoachDetalis.action" theme="simple" id="myForm" onsubmit="return coachDetailsValidation();"  >
                        <h6 class="heavy">Basic Details</h6>

                        <div class="row">
                            <!--copy 1 from contact first row starts-->
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <s:textfield style="height: 40px;" cssClass="form-control col-sm-12" id="name" name="name" placeholder="Name*" required="required" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                </div>

                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <s:textfield style="height: 40px;" cssClass="form-control col-sm-12" name="email" id="email" placeholder="Email*" required="required"  onchange="borderCssChange(this);return checkEmail(this);"/>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="form-group">
                                    <s:textfield style="height: 40px;" cssClass="form-control" placeholder="Title" name="title" id="title" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                </div>
                            </div>

                        </div>



                        <div class="row">
                            <!--copy 1 from contact first row starts-->
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <s:textfield style="height: 40px;" cssClass="form-control" placeholder="Company Name" name="companyName" id="companyName" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <s:textfield style="height: 40px;" cssClass="form-control" placeholder="Phone Number*" name="phone" id="phone" required="required" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this);" onkeypress="return isNumberKey(event)"/>
                                </div>
                            </div>

                        </div>

                        <div class="row">
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <s:textfield style="height: 60px;" cssClass="form-control col-sm-12" id="areasOfExpertise" name="areasOfExpertise" placeholder="Description*" required="required" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                </div>

                            </div>
                        </div>

                        <br>
                        <div class="row" align="center"> 
                            <div class="col-sm-6" >
                                <div class="form-group" >
                                    <s:submit cssClass="btn btn-primary col-sm-12" id="btnSubmit" name="btnSubmit" tabindex="12" type="submit" value="Register"/>
                                </div>
                            </div>   
                        </div>   
                    </s:form>
                        
                </div>


                <div class="col-sm-1"></div>
            </div>

        </div>


        <div class="modal fade" id="myModalvalidationCoach" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" style="position:unset">
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
            </div>
        <br><br><Br>
    </body>
    <s:include value="../footer.jsp"/> 
</html>
