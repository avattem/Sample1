<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
    <!--<![endif] new jps page-->
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@page  import="com.mss.apcloud.util.AppConstants"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>AP Cloud Initiative</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta content="Learn all the technical skills required to be a Digital Transformation Professional, while studying your academics. Why the wait? Start enrolling Now!." name="Description">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/main.css"/>">

        <link rel="stylesheet" type="text/css" href="<s:url value="/css/default.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/component.css"/>">

        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"/>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js?version=1.0"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>

        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=1.0"/>"></script>
        <script src="js/modernizr.custom.js"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="../images/favicon.ico">

        <style type="text/css">
            .backgroundImage {
                background-image: url("../img/headerimage.png");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                opacity: .8 !important;  
            }
            .site-section-top {
                padding-top: 187px !important;}
            </style>
        </head>
        <s:include value="header.jsp"/>  

        <body>
            <div id="" class="boxed">
            <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">

                <div class="push text-center">
                    <h1 class="animation-fadeInQuick2Inv"><strong>Enroll Your College</strong></h1>
                </div>
                <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

                </div>

            </section>

            <div class="">
                <section class="site-section site-content border-bottom overflow-hidden">
                <div class="row">
                    <div class="col-sm-1"></div>
                     <div class="col-sm-10">
                    <s:if test="%{resultMessage == 'success'}">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Successfully Registered</strong> 
                        </div>
                    </s:if>
                    <s:elseif test="%{resultMessage=='exist'}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            College already enrolled
                        </div>
                    </s:elseif> <s:elseif test="%{resultMessage=='already user existed'}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            Already Phone Number Or Email Existed
                        </div>
                    </s:elseif>
                    <s:elseif test="%{resultMessage=='code mismatch'}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            Given Code Is Not Associated With Any Registered College
                        </div>
                    </s:elseif>
                     </div>
                </div>









                <div class="row">

                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">

                        <s:form method="post" theme="simple" action="enrollCollege.action" id="myForm" onsubmit="return enrollValidation();">

                            <h4><strong>College Details</strong></h4>
                            <h6>Enter your College Details here to Organize workshops </h6>
                            <br>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select Your College---" id="collegeName" name="collegeName" list="collegeMap" onchange="getCollegeCode();"/>  

                                    </div>

                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control"  id="collegeid" name="collegeid" placeholder="College Id*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                    </div>

                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" id="code" name="code" placeholder="Code*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                    </div>

                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" id="location" name="location" placeholder="Location*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                    </div>

                                </div>
                            </div>
                            <hr>
                            <h4><strong>Faculty Details</strong></h4>
                            <h6>Enter your College Faculty details here who will be our Point of Contact</h6><br>

                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="facultyambassadorName" id="facultyambassadorName" placeholder="Faculty Ambassador Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="facultyambassadorPhoneNumber" id="facultyambassadorPhoneNumber" placeholder="Faculty Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                    </div>
                                </div>


                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="facultyambassadorEmail" id="facultyambassadorEmail" placeholder="Faculty Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                    </div>
                                </div>

                            </div>
                            <hr>
                            <h4><strong>Student Ambassadors</strong></h4>
                            <h6>Nominate 4 Students from 3rd or 4th Year as Student Ambassadors for this program</h6><br>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentname" id="studentname" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentPhoneNumber" id="studentPhoneNumber" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                    </div>
                                </div>


                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentEmail" id="studentEmail" placeholder="Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch" name="studentBranch" value="" onchange="borderCssChange(this);"/>
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear" name="studentYear" value="" onchange="borderCssChange(this);"/>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentname1" id="studentname1" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentPhoneNumber1" id="studentPhoneNumber1" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                    </div>
                                </div>


                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentEmail1" id="studentEmail1" placeholder="Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch1" name="studentBranch1" value="" />
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear1" name="studentYear1" value="" />
                                    </div>
                                </div>
                                <div class="col-sm-4"></div>
                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentname2" id="studentname2" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentPhoneNumber2" id="studentPhoneNumber2" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                    </div>
                                </div>


                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentEmail2" id="studentEmail2" placeholder="Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch2" name="studentBranch2" value="" />
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear2" name="studentYear2" value="" />
                                    </div>
                                </div>
                                <div class="col-sm-4"></div>
                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentname3" id="studentname3" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentPhoneNumber3" id="studentPhoneNumber3" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                    </div>
                                </div>


                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:textfield cssClass="form-control" name="studentEmail3" id="studentEmail3" placeholder="Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch3" name="studentBranch3" value="" onchange="borderCssChange(this);"/>
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear3" name="studentYear3" value="" onchange="borderCssChange(this);"/>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <s:submit cssClass="btn btn-info col-sm-12" id="btnSubmit" name="btnSubmit" tabindex="12" type="submit"> </s:submit>
                                    </div>
                                </div>
                            </div>

                            <!--copy 1 from contact first row ends-->
                            <div class="row">
                                <div class="col-sm-4"></div>
                                <div class="col-sm-4"></div>
                                <div class="col-sm-4"></div>

                            </div>

                        </s:form>
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
                        </div><!-- Modal Container-->  
                    </div>


                </div>

</section>
            </div>

        </div>
        <br><br><br>
    </body>
    <s:include value="footer.jsp"/> 
</html>
