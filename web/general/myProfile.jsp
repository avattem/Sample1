<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | My Profile 
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
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
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
            .modal-content{width:800px;margin-left:-110px;margin-top:10px;height:550px;}
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
                <h1 class="animation-fadeInQuick2Inv"><strong>Profile</strong></h1>
            </div>
            <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

            </div>

        </section>

        <section class="site-section site-content border-bottom overflow-hidden" id="portfolio">


            <div class="row ">
                <div class="col-sm-2"> 

                    <s:include value="../LeftMenu.jsp"/>  
                </div>
                <div class="col-sm-10">
                    <!--sidebar end-->
                    <div class="tab-content">
                        <div class="row  tab-pane active" id="Myprofile" style="width: 97%;position: relative;left: 14px;">
                            <div class="row">
                                <s:if test="%{resultMessage == 'success'}">
                                    <div class="alert alert-success">
                                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>

                                        <strong>Successfully Updated </strong>  <br></br> 



                                    </div>
                                </s:if>
                                <s:elseif test="%{resultMessage == 'error'}"  >
                                    <div class="alert alert-danger">
                                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                        Update Failed
                                    </div>
                                </s:elseif> </div>  

                            <s:form method="post" theme="simple" action="update.action" id="myForm">
                                <br>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form-group" style="margin-top: 20px">
                                            <label  >First Name</label></div>
                                        <div class="form-group" style="margin-top: 20px">
                                            <label  >Last Name</label></div>
                                        
                                        <div class="form-group" style="margin-top: 20px">
                                            <label >Phone Number</label></div>


                                        <div class="form-group" style="margin-top: 20px">
                                            <label >Email</label>
                                        </div>

                                        <s:if test='%{professionType == "1"}'>
                                            <div class="form-group" style="margin-top: 20px">
                                                <label >College</label>
                                            </div>
                                        </s:if>
                                    </div>
                                    
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <s:textfield type="text" cssClass="form-control"  required="required" placeholder="First Name" id="firstName" name="firstName" value="%{firstName}"/>
                                        </div> 
                                        <div class="form-group">
                                            <s:textfield type="text" cssClass="form-control"  required="required" placeholder="Last Name" id="lastName" name="lastName" value="%{lastName}"/>
                                        </div> 
                                        <div class="form-group">
                                            <s:textfield type="text" cssClass="form-control"  required="required" placeholder="Phone Number" id="phoneNumber" name="phoneNumber" />
                                        </div>
                                        <div class="form-group">
                                            <s:textfield type="text" cssClass="form-control" disabled="true"  required="required" placeholder="Email" id="email" name="email" />
                                        </div>
                                         <s:if test='%{professionType == "1"}'>
                                            <div class="form-group">
                                                <s:select  cssClass="form-control"  required="required" placeholder="College" id="college" list="collegeMap" value="%{collegeId}" name="collegeId" />
                                            </div>
                                        </s:if>

                                    </div>
                                   <div class="row">
                                        <div class="col-sm-12" style="margin-left: 18px">
                                            <h3 class="heavy">Job Details</h3>
                                        </div> </div>
                                        <div class="col-sm-3">
                                           <div class="form-group" style="margin-top: 15px">
                                               <label  >Compay&nbsp;Name</label></div>

                                        <div class="form-group" style="margin-top: 15px">
                                            <label >Salary</label></div> 
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <s:textfield type="text" cssClass="form-control"  required="required" placeholder="Company Name" id="companyName" name="companyName" value="%{companyName}"/>
                                            </div>
                                            <div class="form-group">
                                                <s:textfield type="text" cssClass="form-control"  required="required" placeholder="Salary" id="salary" name="salary" value="%{salary}"/>
                                            </div> 
                                        </div>
                                    <div class="col-sm-8">
                                        <s:submit cssClass="btn btn-primary col-sm-12" id="btnUpdate" name="btnUpdate" tabindex="12" value="Update"/>
                                    </div>

                                </s:form>
                                <div class="row">
                                    <div class="col-sm-8">
                                        <hr>
                                        <s:if test='%{professionType == "1" || professionType == "2"}'>
                                            <h5 class="heavy">My WorkShops</h5>
                                            <hr>
                                            <table class="table t_st03">
                                                <thead>
                                                <th>#</th>
                                                <th><i class="fa  fa-barcode" aria-hidden="true"></i> Code</th>
                                                <th><i class="fa fa-calendar" aria-hidden="true"></i> Date</th>
                                                <th><i class="fa fa-hourglass" aria-hidden="true"></i> Status</th>

                                                </thead>
                                                <tbody>
                                                    <%int val = 0;%>
                                                    <s:iterator value="workshopDetailsList">

                                                        <%val++;%>
                                                        <tr> 
                                                            <td align="left"><%=val%></td>
                                                            <td align="left">
                                                                <a href="#" data-toggle="modal" data-target="#myModal" onclick="getEnrolledTopicsList('<s:property value="Code"/>');">  <s:property value="code"/></a>    
                                                            </td>
                                                            <td><s:property value="DATE"/></td>
                                                            <td><s:property value="status"/></td>
                                                        </tr>

                                                    </s:iterator>
                                                </tbody>


                                            </table>
                                        </s:if>
                                        <br><br>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>


                            </div> 
                        </div>
                    </div>
                    <br>

                    <!-- Reference: https://github.com/ashleydw/lightbox/ -->

                    <link type="text/css" href="webinar.css">

                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog" style="position: unset;">

                            <!-- Modal content-->
                            <div class="modal-content ambassidor">
                                <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                                    <button data-dismiss="modal" style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                                    <h3 name="titleName" id="titleName" class="heavy modal-title">AP Cloud Ambassadors</h3>

                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div id="techTopics" ></div>
                                        </div>
                                    </div>


                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <!--sidebar-->


                <br><br><br>
                <!-- Modal -->
            </div>
        </section>  <s:include value="../footer.jsp"/> 
    </body>

</html>