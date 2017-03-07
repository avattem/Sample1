<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | Workshops 
        </title>
        <link rel="stylesheet" href="galry.css" type="text/css" />
        <script type="text/javascript" src="galry.js"></script>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/prettyPhoto.css" rel="stylesheet">
        <link href="../css/animate.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href="../css/default.css" rel="stylesheet" type="text/css">
        <link href="../css/component.css" rel="stylesheet" type="text/css">
        <script src="js/modernizr.custom.js"></script><!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../images/favicon.ico" rel="shortcut icon">

        <script type="text/JavaScript" src="<s:url value="/js/AppConstents.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
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
        <style>
          
        </style>
        <style>
            ul.source, ul.target {
                min-height: 50px;
                margin: 10px 1px 10px 0px;
                padding: 6px;
                border-width: 1px;

                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                border-radius: 3px;
                list-style-type: none;
                list-style-position: inside;
            }

            .source li, .target li {
                margin: 5px;
                padding: 5px;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                border-radius: 4px;
                text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
            }
            .source li {
                background-color: #fff;

                color: #00aae7;
                height:50px;
                width:100%;
            }
            .target li {
                background-color: #ebf5e6;
                border: 1px solid #d6e9c6;
                color: #468847;
            }
            .sortable-dragging {
                border-color: #ccc !important;
                background-color: #fafafa !important;
                color: #bbb !important;
            }
            .sortable-placeholder {
                height: 40px;
            }
            .source .sortable-placeholder {
                border: 2px dashed #f8e0b1 !important;
                background-color: #fefcf5 !important;
            }
            .target .sortable-placeholder {
                border: 2px dashed #add38d !important;
                background-color: #f6fbf4 !important;
            }

            .nav-tabs> li.active> a {

                cursor: default;
                background-color: #fff;
                border: 1px solid #fff;
                border-bottom-color: transparent;
            }
            .nav-tabs {
                border-bottom: 1px solid #2368a0;
            }
            .imgBox:hover 
            { -moz-box-shadow: 0 0 10px #ccc;
              -webkit-box-shadow: 0 0 10px #ccc;
              box-shadow: 0 0 10px #ccc; }
            </style>
            <style>
            .embed-container embed{border-radius:0px !important;}
            h4 {font-size:14px !important;font-weight:bold;}
            .modal-footer{ margin:0px 5px 5px 0px !important;}
            .modal-content{width:800px;margin-left:-110px;margin-top:10px;}
            .on-load-modal-content{background-color: #fff; width:400px;height:150px;}
        </style>
         <style type="text/css">
           .backgroundImage {
            background-image: url("../img/headerimage.png");
           -webkit-background-size: cover;
              -moz-background-size: cover;
              -o-background-size: cover;
              background-size: cover;
               
           }
          
        </style>
    </head><!--/head-->
    <s:include value="../header.jsp"/>  
    <body>

        <script type="text/javascript">
            //    $(window).load(function(){
            //        $('#mainModal').modal('show');
            //    });
        </script>
        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>Update Details</strong></h1>
                        </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">
                        
                    </div>
                
            </section>
        <section class="site-section site-content border-bottom overflow-hidden" id="portfolio">
            

            <div class="row ">
                <s:if test='%{#session.username != null}'>
                    <div class="col-sm-2"> 
                       
                        <s:include value="../LeftMenu.jsp"/>  
                    </div>
                    <div class="col-sm-10">
                        <!--sidebar end-->
                        <div class="tab-content">
                            <div class="row  tab-pane active" id="updatecollege" style="width: 97%;position: relative;left: 14px;">
                                <div class="row">
                                    <div class="col-sm-6 text-left">
                                        <h1 class="heavy">

                                            

                                        </h1>

                                    </div>
                                </div>
                            </s:if>
                            <s:else>
                                <div class="col-sm-12">
                                    <!--sidebar end-->
                                    <div >
                                        <div >
                                            <div class="row">
                                                <div class="col-sm-6 text-left">
                                                    <h1 class="heavy">

                                                        Enroll Your College

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
                                                            Enroll
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>      
                                        </s:else>



                                        <s:if test="%{resultMessage == 'success'}">
                                            <div class="row">
                                                <div class="alert alert-success">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    <strong>Updated Successfully</strong> 
                                                </div>
                                            </div>
                                        </s:if>
                                        <s:elseif test="%{resultMessage=='exist'}">
                                            <div class="row">
                                                <div class="alert alert-danger">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    College already enrolled
                                                </div>
                                            </div>
                                        </s:elseif>


                                        <div class="row">

                                            <div class="col-sm-12">

                                                <s:form method="post" theme="simple" action="updateEnrollCollege.action" id="myForm" onsubmit="return updateEnrollValidation();">
                                                    <br>
                                                    <s:hidden name="id" id="id"/>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select Your College---" id="collegeName" name="collegeName" value="%{collegeName}" list="collegeMap" disabled="true" onchange="getCollegeCode();"/>  

                                                            </div>

                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control "  id="collegeId" name="collegeId" placeholder="College Id*" required="required" type="text" disabled="true" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                                            </div>

                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" id="location" name="location" placeholder="Location*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">

                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="Code" id="Code" placeholder="Code*" required="required" type="text" disabled="true" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                                            </div>
                                                        </div>


                                                    </div>
                                                    <hr>
                                                    <p>Enter your faculty details here</p>

                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="facultyambassadorName" id="facultyambassadorName" disabled="true" placeholder="Faculty Ambassador Name*" required="required" type="text" onchange="borderCssChange(this); fieldLengthValidator(this);"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="facultyambassadorPhoneNumber" id="facultyambassadorPhoneNumber" disabled="true" placeholder="Faculty Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                                            </div>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" name="facultyambassadorEmail" id="facultyambassadorEmail" disabled="true" placeholder="Faculty Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <hr>
                                                    <p class="methodText">Nominate 4 Students from 3rd and 4th Year as ambassadors</p>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="studentname" id="studentname" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="studentPhoneNumber" id="studentPhoneNumber" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                                            </div>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="studentEmail" id="studentEmail" placeholder="Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch" name="studentBranch" value="%{studentBranch}" onchange="borderCssChange(this);"/>
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear" name="studentYear" value="%{studentYear}" onchange="borderCssChange(this);"/>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" name="studentname1" id="studentname1" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
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
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch1" name="studentBranch1" value="%{studentBranch1}" />
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear1" name="studentYear1" value="%{studentYear1}" />
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" name="studentname2" id="studentname2" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" name="studentPhoneNumber2" id="studentPhoneNumber2" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
                                                            </div>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="studentEmail2" id="studentEmail2" placeholder="Email*" required="required" type="text" onchange="borderCssChange(this);return checkEmail(this);"/>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch2" name="studentBranch2" value="%{studentBranch2}" />
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear2" name="studentYear2" value="%{studentYear2}" />
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="studentname3" id="studentname3" placeholder="Student Name*" required="required" type="text" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control " name="studentPhoneNumber3" id="studentPhoneNumber3" placeholder="Phone Number*" required="required" type="text" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this)" onkeypress="return isNumberKey(event)"/>
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
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Branch" list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}"  id="studentBranch3" name="studentBranch3" value="%{studentBranch3}" />
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:select cssClass="form-control"  headerKey="-1" headerValue="Year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}"  id="studentYear3" name="studentYear3" value="%{studentYear3}" />
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <s:submit cssClass="btn btn-primary col-sm-12" id="btnSubmit" name="btnSubmit" tabindex="12" type="submit" value="Update"> </s:submit>
                                                                </div>
                                                            </div>

                                                    </div>

                                                    <!--copy 1 from contact first row ends-->
                                                    <div class="row">
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
                                    </div>

                                </div>
                                <!--sidebar end-->
                            </div> 
                        </div>
                    </div>
                    <br>

                    <!-- Reference: https://github.com/ashleydw/lightbox/ -->

                    <link type="text/css" href="webinar.css">



                    <!--sidebar-->


                    <br><br><br>
                    <!-- Modal -->


                    </section>  <s:include value="../footer.jsp"/> 
                    </body>

                    </html>