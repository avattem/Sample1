<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <title>AP Cloud Initiative | Contact Us</title>

        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- END Icons -->

        <!--image carousel css-->

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

        <!-- image carousel css ends-->

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css"/>">

        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="<s:url value="/css/plugins.css"/>">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="<s:url value="/css/main.css"/>">

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="<s:url value="/css/themes.css"/>">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>


        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
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
        <style type="text/css">

            .icon{
                background-color: #0d416b;
                border-radius: 50px;
                color: #fff;
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
    <body>
        <!-- Page Container -->
        <!-- In the PHP version you can set the following options from inc/config file -->
        <!-- 'boxed' class for a boxed layout -->
        <div id="" class="boxed">
            <!-- Site Header -->
            <section class="site-section site-section-top site-section-light backgroundImage">
                <div class="">
                    <div class="push text-center">
                        <h1 class="animation-fadeInQuick2Inv"><strong>Contact Us</strong></h1>
                    </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

                    </div>
                </div>
            </section>
            <!-- END Site Header -->

            <!-- Intro + Action -->

            <!-- END Intro + Action -->

            <!-- END Promo Features -->

            <!-- Promo #1 -->
            <section class="site-section site-content border-bottom overflow-hidden">
                <div class="container">

                    <br>
                    <div class="row"> <s:if test="%{resultMessage == 'success'}">
                            <div class="alert alert-success">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>

                                <p>Thank you for your patience in filling in the details. We will be back with you soon.</p>
                            </div>
                        </s:if>
                        <s:elseif test="%{resultMessage=='error'}">
                            <div class="alert alert-danger">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <p>   Please Try Again...</p>
                            </div>
                        </s:elseif> 

                    </div>
                    <div class="row">
                        <div class="col-sm-6">

                            <s:form method="post" action="doAddContactUsData.action" theme="simple" id="myForm" onsubmit="return contactUsValidation();"  >
                                <!--<form action="contact.html#form-contact" method="post" id="form-contact">-->
                                <div class="form-group">
                                    <label for="contact-name">First Name</label>
                                   <s:textfield id="fname" name="fname" type="text" placeholder="First Name" cssClass="form-control input-lg" onchange="fieldLengthValidator(this);borderCssChange(this);startingCapital(this);"/>
                                </div>
                                <div class="form-group">
                                    <label for="contact-name">Last Name</label>
                                    <s:textfield id="lname" name="lname" type="text" placeholder="Last Name" cssClass="form-control input-lg" onchange="fieldLengthValidator(this);borderCssChange(this);startingCapital(this);"/>
                                </div>
                                <div class="form-group">
                                    <label for="contact-email">Email</label>
                                 <s:textfield id="email" name="email" type="text" placeholder="Email Address" cssClass="form-control input-lg" onchange="borderCssChange(this);return checkEmail(this);" />
                                </div>
                                <div class="form-group">
                                    <label for="contact-email">Phone Number</label>
                                    <s:textfield id="phone" name="phone" type="text" placeholder="Phone" cssClass="form-control input-lg" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this);" onkeypress="return isNumberKey(event)" />
                                </div>

                                <div class="form-group">
                                    <label for="contact-email">Organization</label>
                                    <s:textfield id="organization" name="organization" type="text" placeholder="Organization" cssClass="form-control input-lg" onchange="fieldLengthValidator(this);borderCssChange(this);startingCapital(this);"/>
                                </div>
                                <div class="form-group">
                                    <label for="contact-email">Designation</label>
                                    <s:textfield id="designation" name="designation" type="text" placeholder="Designation" cssClass="form-control input-lg" onchange="fieldLengthValidator(this);borderCssChange(this);startingCapital(this);"/>
                                </div>


                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <br>
                                        <span class="fa-stack fa-1x">
                                            <i class="fa fa-phone fa-stack-1x icon"></i>
                                        </span>&nbsp;&nbsp;0891-6623556 <br> <br>
                                        <span class="fa-stack fa-1x">
                                            <a href="http://www.fb.com/andhracloud"> <i class="fa fa-facebook fa-stack-1x icon"></i>
                                        </span>&nbsp;&nbsp; /andhracloud</a> <br><br>
                                    </div>
                                    <div class="col-sm-6">
                                        <br>
                                        <span class="fa-stack fa-1x">
                                            <a href="mailto:apcloud@miraclesoft.com">    <i class="fa fa-envelope fa-stack-1x icon"></i>
                                        </span>&nbsp;&nbsp; apcloud@miraclesoft.com</a> <br><br>

                                        <span class="fa-stack fa-1x">
                                            <a href="http://twitter.com/andhracloud"><i class="fa fa-twitter fa-stack-1x icon"></i>
                                        </span>&nbsp;&nbsp;/andhracloud</a> <br><br>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div style="text-decoration:none; overflow:hidden; height:380px; width:600px; max-width:100%;"><div id="my-map-canvas" style="height:100%; width:100%;max-width:100%;"><iframe style="height:100%;width:100%;border:0;" frameborder="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1899.3829925349744!2d83.39513499999998!3d17.802692000000008!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a395a5c79b2e825%3A0x9b27a2752b51972e!2sMiracle+Heights!5e0!3m2!1sen!2sin!4v1425405223167" defer="defer" async="async"></iframe></script>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>



                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="contact-message">Message</label>
                                    <s:textarea cssClass="form-control input-lg" id="description" name="description" placeholder="How can we help?" rows="7" onchange="contactFieldLengthValidator(this);"/>
                     
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-lg btn-primary col-sm-12">Send Message</button>
                                </div>
                            </div>
                        </div>
                    </s:form>
                    <br><br>
                    </section>
            
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
                                    <button type="button" class="btn btn-danger" data-dismiss="modal" style="width: 85px;">
                                        Close
                                    </button>
                                </div><!-- Modal Footer -->
                            </div><!-- Modal Content -->
                        </div><!-- Modal Dialog -->
                    </div>
                    <!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
                    <script src="js/vendor/jquery-2.2.0.min.js"></script>
                    <script src="js/vendor/bootstrap.min.js"></script>
                    <script src="js/plugins.js"></script>
                    <script src="js/app.js"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


                    <s:include value="footer.jsp"/>
                    </body>
                    </html>