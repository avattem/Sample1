<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <title>AP Cloud Initiative | Enroll</title>

        <meta name="description" content="AppUI Frontend is a Responsive Bootstrap Site Template created by pixelcave and added as a bonus in AppUI Admin Template package">
        <meta name="author" content="pixelcave">
        <meta name="robots" content="noindex, nofollow">

        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- END Icons -->
 <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script>
        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="css/plugins.css">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="css/main.css">

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="css/themes.css">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <style type="text/css">
            .backgroundImage {
                background-image: url("img/headerimage.png");
                opacity: .8 !important;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;

            }
            .site-section-top {
                padding-top: 187px !important;}
            .site-section {

                padding-bottom: 41px!important;
            }

        </style>

    </head>
    <!--<?php include 'header.php'; ?>-->
    <s:include value="header.jsp"/> 
    <body>

        <div id="page-container" >

            <section class="site-section site-section-top site-section-light themed-background-dark backgroundImage ">
                <div class="container">
                    <h1 class="text-center animation-fadeInQuick2Inv"><strong>Enroll Today !!</strong></h1>
                </div>
            </section>
            <!-- END Intro -->

            <!-- Plans -->
            <section class="site-content site-section">
                <div class="container">
                    <div class="site-block">
                        <div class="row">
                            <div class="col-sm-4">
                                <a href="<s:url value="/general/registrationForm.action?regFlag=student"/>">
                                    <table class="table table-borderless table-pricing">

                                        <thead>
                                            <tr>
                                                <th>Student Registration</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="active">
                                                <td>
                                                    <img src="img/student.png" alt="avatar" class="img-circle img-thumbnail img-thumbnail-avatar-2x">
                                                </td>
                                            </tr>

                                            <tr>
                                                <td> <p class="methodText"> 
                                                        Want to learn new technologies but not getting a chance to discover your favourite technology? Now, there is nothing to worry about as we offer you a golden opportunity to fulfill your wishes of discovering your desired technology. Hit the register button and enroll yourself.
                                                    </p>
                                                </td>
                                            </tr>

                                            <tr class="active">
                                                <td>
                                                    <a href="<s:url value="/general/registrationForm.action?regFlag=student"/>" class="btn btn-effect-ripple  btn-info"><i class="fa fa-arrow-right"></i> Register</a>
                                                </td>
                                            </tr>

                                        </tbody>
                                    </table></a>
                            </div>
                            <div class="col-sm-4">
                                <a href="<s:url value="/general/collegeEnroll.action"/>"><table class="table table-borderless table-pricing">
                                        <thead>

                                            <tr>
                                                <th>Register Institution</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="active">
                                                <td>
                                                    <img src="img/college.png" alt="avatar" class="img-circle img-thumbnail img-thumbnail-avatar-2x">
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <p class="methodText">
                                                        Do you want the beneficiaries of your institution/organization be equipped with industry ready technologies? Then, here is the right path for your aspirants in making their abilities stronger. All you need to do is to just enroll your Institute, and we will come to you and conduct workshops in your premises.
                                                    </p>
                                                </td>
                                            </tr>

                                            <tr class="active">
                                                <td>
                                                    <a href="<s:url value="/general/collegeEnroll.action"/>" class="btn btn-effect-ripple  btn-info"><i class="fa fa-arrow-right"></i> Register</a>
                                                </td>
                                            </tr>

                                        </tbody>

                                    </table>
                                </a>
                            </div>
                            <div class="col-sm-4">
                                <a href="<s:url value="/general/registrationForm.action?regFlag=profission"/>"><table class="table table-borderless table-pricing">
                                        <thead>

                                            <tr>
                                                <th>Professional Registration</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="active">
                                                <td>
                                                    <img src="img/professor.png" alt="avatar" class="img-circle img-thumbnail img-thumbnail-avatar-2x">
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <p class="methodText">

                                                        Are you looking to learn more technologies and want to be a competent employee of your organization? Then, you are at the right place, where you can enhance your skills to the next level. Register yourself and we will assist you in roving your boat towards your dreams.
                                                    </p>
                                                </td>
                                            </tr>

                                            <tr class="active">
                                                <td>
                                                    <a href="<s:url value="/general/registrationForm.action?regFlag=profission"/>" class="btn btn-effect-ripple  btn-info"><i class="fa fa-arrow-right"></i> Register</a>
                                                </td>
                                            </tr>

                                        </tbody>

                                    </table>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END Plans -->


            <!-- END Testimonials -->


        </div>
        <!-- END Page Container -->

        <!-- Scroll to top link, initialized in js/app.js - scrollToTop() -->
        <a href="#" id="to-top"><i class="fa fa-arrow-up"></i></a>

        <!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
        <!--        <script src="js/vendor/jquery-2.2.0.min.js"></script>
                <script src="js/vendor/bootstrap.min.js"></script>
                <script src="js/plugins.js"></script>
                <script src="js/app.js"></script>-->
        <s:include value="footer.jsp"/> 
        <!--<?php include 'footer.php'; ?>-->
    </body>
</html>