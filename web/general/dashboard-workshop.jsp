<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <%@page import="com.mss.apcloud.util.AppConstants"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">

        <title>AP Cloud Initiative | Workshops</title>

        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- END Icons -->

        <!--image carousel css-->
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

        <!-- image carousel css ends-->

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="<s:url value="../css/main.css"/>">
        <link rel="stylesheet" href="<s:url value="../css/bootstrap.min.css"/>">


        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="<s:url value="../css/plugins.css"/>">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="<s:url value="../css/main.css"/>">

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="<s:url value="../css/themes.css"/>">

        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
        <script type="text/JavaScript" src="<s:url value="/js/AppConstents.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=2.1"/>"></script>
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
        <style>
            a{
                text-decoration:none !important;
            }


            /*            .open-btn1 {
                            width:103%;
                            border-top: 2px solid #76889A;
                            border-bottom: 2px solid #76889A;
                            border:100%;
                            background: #fff;
                            color: #76889A !important;
                            display: inline-block;
                            margin: 10px 0 0;
                            padding: 9px 16px;
                            text-decoration: none !important;
                        }*/
            .ga
            {
                color:#00aae7;
            }
            h4{
                color:#fff !important;
                font-weight:bolder !important;
            }
            .backgroundImage {
                background-image: url("../img/headerimage.png");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                opacity: .8 !important;  
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
        <s:include value="../header.jsp"/> 
        <body>
            <!-- Page Container -->
            <!-- In the PHP version you can set the following options from inc/config file -->
            <!-- 'boxed' class for a boxed layout -->
            <div id="" class="boxed">
            <!-- Site Header -->

            <!-- END Site Header -->

            <!-- Intro + Action -->
            <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">

                <div class="push text-center">
                    <h1 class="animation-fadeInQuick2Inv"><strong>Upcoming Workshops</strong></h1>
                </div>
                <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

                </div>

            </section>
            <!-- END Intro + Action -->

            <!-- END Promo Features -->

            <!-- Promo #1 -->
            <section class="site-section site-content border-bottom overflow-hidden">

                <!--image carousel-->
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                        <!-- Partial Responsive Block -->


                        <table class="table  table-striped table-responsive" style="width: 100%">
                            <thead>


                            <th  width="10%">
                                <i class="fa ga fa-barcode" aria-hidden="true"></i> <font size="3px">Code</font>
                            </th>
                            <th width="25%"><i class="fa ga fa-calendar" aria-hidden="true"></i><font size="3px">Date(DD-MM-YYYY)</font></th>
                            <th width="25%">
                                <i class="fa ga fa-university" aria-hidden="true"></i><font size="3px">College/Company&nbsp;Name</font>
                            </th>
                            <th>
                                <i class="fa ga fa-location-arrow" aria-hidden="true"></i> <font size="3px">Location</font>
                            </th>
                            <th width="15%">
                                <i class="fa ga fa-users" aria-hidden="true"></i> <font size="3px">Ambassadors</font>  
                            </th>
                            <th width="15%">
                                <i class="fa ga fa-file" aria-hidden="true"></i>  <font size="3px">Curriculum</font>
                            </th>
                            <th>
                                <i class="fa ga fa-file" aria-hidden="true"></i>  <font size="3px">Enroll</font>
                            </th>

                            </thead>
                            <tbody>
                                <%int i = 0;%>

                                <s:iterator value="workshopList">

                                    <%  if (i % 2 == 0) {%> 
                                    <tr>     
                                        <% } else {%>
                                    <tr class="info">                             
                                        <%}%>

                                        <td align="left"><s:property value="Code"/></td>
                                        <td align="left"><s:property value="DATE"/></td>

                                        <td align="left"><a href="<s:property value="Link"/>" target="blank"><s:property value="CollegeName"/></a></td>

                                        <td align="left"><s:property value="location"/></td>
                                        <td> <a href="#" data-toggle="modal" data-target="#myModal" onclick="getCollegeCoordinators('<s:property value="collegeId"/>','<s:property value="Code"/>','<s:property value="DATE"/>','<s:property value="location"/>');">View</a></td>


                                        <td><a href="#" data-toggle="modal" data-target="#myModal" onclick="getCurriculam('<s:property value="Code"/>','<s:property value='%{CollegeName.replaceAll("\'", "&quot")}'/>','<s:property value="location"/>');">
                                                View

                                            </a></td>
                                        <td>
                                            <a href="<%=request.getContextPath()%>/general/login.action"> 
                                                <button class="btn btn-primary" name="btnSubmit" style="height:28px;width:100px;">Enroll</button></a>
                                        </td> 

                                    </tr>
                                    <%i++;%>
                                </s:iterator>                     
                            </tbody>
                        </table>

                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content" >
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" name="titleName" id="titleName"></h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div id="techTopics" ></div>
                                            </div>
                                        </div>

                                        <!--                                <div class="row"><div class="col-sm-4 wrkshp"><div class="heavy"><strong>Workshop Code</strong>  </div>W01</div><div class="col-sm-4"><div class="heavy"><strong>Date</strong> </div> 07/20/2016</div><div class="col-sm-4"><div class="heavy"><strong>Location</strong> </div> Tekkali</div></div>
                                                                        <div class="row open-btn" id="addClass" href="#"><i class="fa ga fa-users" aria-hidden="true"></i>&nbsp <span class="heavy"><strong>Faculty Details</strong></span> </div>
                                                                        <div class="row"><br><div class="col-sm-4"><span class="heavy">UshaRani Kola</span><br><i class="fa fa-phone"></i>&nbsp +91-(752)-361-4526<br><i class="fa fa-envelope-o bigicon"></i>&nbsp UshaRani@gmail.com<br><i class="fa fa-university"></i>&nbsp AITAM</div><div class="col-sm-4"><span class="heavy"> Prasanna Setti</span><br><i class="fa fa-phone"></i>&nbsp; +91-(852)-147-8521<br><i class="fa fa-envelope-o bigicon"></i>&nbsp PrasannaSetti@gmail.com<br><i class="fa fa-university"></i>&nbsp AITAM</div></div>
                                                                        <div class="row open-btn" id="addClass" href="#"><i class="fa ga fa-graduation-cap" aria-hidden="true"></i>&nbsp <span class="heavy"><strong>Student Details</strong></span> </div>
                                                                        <div class="row"><br><div class="col-sm-4"><span class="heavy">UshaRani Kola</span><br><i class="fa fa-phone"></i>&nbsp;&nbsp;+91-(752)-361-4526<br><i class="fa fa-envelope-o bigicon"></i>&nbsp UshaRani@gmail.com<br><i class="fa fa-university"></i>&nbsp AITAM</div><div class="col-sm-4"><span class="heavy"> Prasanna Setti</span><br><i class="fa fa-phone"></i>&nbsp; +91-(852)-147-8521<br><i class="fa fa-envelope-o bigicon"></i>&nbsp PrasannaSetti@gmail.com<br><i class="fa fa-university"></i>&nbsp AITAM</div></div>-->
                                    </div>

                                </div>
                            </div>
                        </div> 
                        <!-- END Partial Responsive Block -->

                    </div>
                    <div class="col-sm-1"></div>
                </div>


                <!-- image carousel-->





            </section>
            <!-- END Promo #1 -->


            <!-- Quick Stats -->

            <!-- END Quick Stats -->

            <!-- Promo #2 -->
            <!-- END Promo #2 -->

            <!-- Sign Up Action -->

            <!-- END Sign Up Action -->

            <!-- Promo #3 -->
            <!-- END Testimonials -->

            <!-- Footer -->

            <!-- END Footer -->
        </div>
        <!-- END Page Container -->

        <!-- Scroll to top link, initialized in js/app.js - scrollToTop() -->
        <a href="#" id="to-top"><i class="fa fa-arrow-up"></i></a>

        <!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
        <script src="js/vendor/jquery-2.2.0.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>
        <!-- image carousel js-->
        <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
        <script>
            $('#myCarousel').carousel({
                interval:   4000
            });
        </script>
        <!--  <?php include 'footer.php'; ?>-->
        <s:include value="../footer.jsp"/> 
    </body>
</html>