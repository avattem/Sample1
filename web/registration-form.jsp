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
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/component.css"/>">
        <script src="js/modernizr.custom.js"></script>


        <script type="text/JavaScript" src="<s:url value="/js/Validation.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=1.1"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>

        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        

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
            .ga
            {
                color:#00aae7;
            }

            .backgroundImage {
                background-image: url("../img/headerimage.png");
                opacity: .8 !important;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;

            }


            .backgroundImage2 {
                background-image: url("../img/bg-ground1.jpg");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }

            .site-section-top {
                padding-top: 187px !important;}


        </style>

    </head>
    <s:include value="header.jsp"/>  

    <body onload="getDistrictsBasedOnStateId();">
        <script>
            function clickHereToLoginPage(){
              
                //window.location="general/reglogin.action";
                window.location="general/login.action";

            }
        </script>
        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">

            <div class="push text-center">
                <h1 class="animation-fadeInQuick2Inv"><strong>Enroll Yourself!!</strong></h1>
            </div>
            <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

            </div>

        </section>
        <div class="container">
          <!--  <div class="row">
                <div class="col-sm-6 text-left">
                    <h1 class="heavy">

                        Registration Form

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
                            Registration Form
                        </li>
                    </ul>
                </div>
            </div>
-->
            <div class="row">
                <%--  <s:if test="%{resultMessage == 'success'}">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Successfully Registered</strong> 
                        </div>
                    </s:if>--%>
                <s:if test="%{resultMessage=='email'}">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        Email or Phone number exist
                    </div>
                </s:if> 
                <%--  <s:elseif test="%{resultMessage == 'regLogin'}"> 
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Successfully Registered</strong> 
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!--                            <td><a href="#" name="btnSubmit" title="click to move to Login page" onclick="moveToLoginPage()">Login</a></td>-->
<!--                            <button class="btn btn-primary" name="btnSubmit"  onclick="moveToLoginPage()">Login</button>-->
                        </div>
                    </s:elseif>--%>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <s:form method="post" action="registration.action" theme="simple" id="myForm" onsubmit="return registrationValidation();"  >






                        <%--out.println("---if----");--%>
                        <h3 class="heavy"><strong>Basic Details</strong></h3>
                        <div class="row">
                            <!--copy 1 from contact first row starts-->
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control col-sm-12" id="firstname" name="firstname" placeholder="First Name*" required="required" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                </div>

                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control col-sm-12" name="lastname" id="lastname" placeholder="Last Name*" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control" placeholder="Email*" name="email" id="email" required="required"  onchange="borderCssChange(this);return checkEmail(this);" />
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control" placeholder="Phone Number*" name="workPhone" id="workPhone" required="required"  onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this);" onkeypress="return isNumberKey(event)"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:password cssClass="form-control col-sm-12" id="password" name="password" placeholder="Password*" required="required" onchange="fieldLengthValidator(this);borderCssChange(this);" onkeyup="IsValidPassword(this)"  />
                                </div>

                            </div>

                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:password cssClass="form-control col-sm-12" name="retypePassword" id="retypePassword" placeholder="Retype Password*" required="required"  onchange="fieldLengthValidator(this);borderCssChange(this);return passwordValidation();"/>
                                </div>
                            </div>


                            <s:if test="regFlag=='student'">  
                                <s:hidden name="profession" id="profession" value="1"/> 


                                <div class="col-sm-3" id="studentDiv" >
                                    <div class="form-group">
                                        <s:if test="collegeid!=null">

                                            <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select Your College---" id="frmCollege" name="frmCollege" list="collegeMap"  value="%{collegeid}" onchange="borderCssChange(this);checkProfNotOthers()"/>
                                        </s:if>
                                        <s:else >
                                            <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select Your College---" id="frmCollege" name="frmCollege" list="collegeMap" value="%{collegeid}" onchange="borderCssChange(this);checkProfNotOthers()"/>

                                        </s:else>
                                        <s:hidden id="collegeIdHidden" name="collegeIdHidden" value="%{collegeid}"/>
                                        <%--  <s:else>
                                          <s:textfield cssClass="form-control" placeholder="College Name*" id="collegeName" name="collegeName" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                        
                                           </s:else>--%>
                                    </div>
                                </div>

                                <div class="col-sm-3" id="branchdiv" >
                                    <div class="form-group" >
                                        <select class="form-control" id="branch" name="branch" onchange="getBranch();borderCssChange(this);">
                                            <option value="-1"> Branch </option>
                                            <option value="ECE">ECE</option>
                                            <option value="EEE">EEE</option>
                                            <option value="CSE">CSE</option>
                                            <option value="IT">IT</option>
                                            <option value="MCA">MCA</option>
                                            <option value="Others">Others</option>

                                        </select>
                                    </div>
                                </div></div>
                            <div class="row">
                                <div class="col-sm-3" id="yearOfPassDiv" style="display: none">
                                    <div class="form-group">

                                        <s:textfield cssClass="form-control" placeholder="Year Of Pass*" id="yearOfPass" name="yearOfPass" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                    </div>
                                </div>  
                                <div class="col-sm-3" id="branchOtherDiv" style="display: none">
                                    <div class="form-group">

                                        <s:textfield cssClass="form-control" placeholder="Branch Name*" id="frmOtherBranch" name="frmOtherBranch" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                    </div>
                                </div>

                                <div class="col-sm-3" id="yeardiv" > 
                                    <div class="form-group" >
                                        <select class="form-control" id="year" name="year" onchange="borderCssChange(this);">
                                            <option value="-1"> Year </option>
                                            <option value="1st year">1st year</option>
                                            <option value="2nd year">2nd year</option>
                                            <option value="3rd year">3rd year</option>
                                            <option value="4th year">4th year</option>


                                        </select>
                                    </div>
                                </div>

                            </s:if>  

                            <s:elseif test="regFlag=='profission'">

                                <s:hidden name="profession" id="profession" value="2"/> 

                                <div class="col-sm-3" id="employeeDiv" >
                                    <div class="form-group"> 

                                        <s:textfield cssClass="form-control" placeholder="Organisation*" id="frmCompany" name="frmCompany" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>

                                    </div>
                                </div>
                                <div class="col-sm-3" id="designationDiv" >
                                    <div class="form-group">

                                        <s:textfield cssClass="form-control" placeholder="Designation*" id="frmDesignation" name="frmDesignation" onchange="borderCssChange(this);fieldLengthValidator(this)"/>

                                    </div>
                                </div>  
                            </s:elseif>


                            <div class="col-sm-3"> 
                                <div class="form-group">
                                    <s:textfield cssClass="form-control" placeholder="FaceBook Profile*" name="facebookProfile" id="facebookProfile" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);" />
                                </div>
                            </div>

                        </div>  
                        <h3 class="heavy"><strong>Address Details</strong></h3> 
                        <hr>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control col-sm-12" id="street" name="street" placeholder="Street*" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:select list="stateMap" name="state" id="state" value="2"  cssClass="form-control" onchange="getDistrictsBasedOnStateId();" /> 
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:select   name="district"  id="district" list="districtIdList" cssClass="form-control" value="%{districtId}" onchange="" />
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control col-sm-12" id="city" name="city" placeholder="City*" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                </div>

                            </div>

                            <div class="col-sm-3">
                                <div class="form-group">
                                    <s:textfield cssClass="form-control col-sm-12" id="zipcode" name="zipcode" placeholder="Zip Code*" required="required"  onchange="borderCssChange(this);fieldLengthValidator(this);" onkeypress="return isNumberKey(event)"/>
                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <s:submit cssClass="btn btn-primary col-sm-12" id="btnSubmit" name="btnSubmit" tabindex="12" type="submit" value="Register"/>
                                </div>
                            </div>

                            <!--copy 1 from contact first row starts-->

                        </div>
                        <div class="row">
                            <div style="margin-left: 675px" class="col-sm-6">
                                <div class="form-group">
                                    <%--        <s:submit cssClass="btn btn-primary col-sm-12" id="clickToLogIn" name="clickToLogIn" tabindex="12" type="submit" value="If You Have Already Registered Please Click Her For Login"/>--%>
                                    If You Have Already Registered <a href="<s:url value="/general/login.action"/>" id="clickToLogIn" name="clickToLogIn"  > <font color="darkblue" size="2.5"> Click Here </font></a>
                                </div>
                            </div>
                        </div>



                    </div>

                </div>          

                <!--copy 1 from contact first row starts-->



                <!--copy 1 from contact first row ends-->


            </s:form>
        </div>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="position: unset;">
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

        <div class="col-sm-1"></div>
    </div>

</div>


<div>

</div>
<br><br><Br>
</body>
<s:include value="footer.jsp"/> 
</html>

