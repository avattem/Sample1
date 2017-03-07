<%-- 
    Document   : footer
    Created on : Aug 4, 2016, 4:26:11 PM
    Author     : miracle
--%>


<!DOCTYPE html>
<html>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">

        
 
           
        </head>
<body>
        <!-- Page Container -->
        <!-- In the PHP version you can set the following options from inc/config file -->
        <!-- 'boxed' class for a boxed layout -->
<div id="" class="boxed">
    
   <!-- Footer -->
            <footer class="site-footer site-section site-section-light">
                <div class="container">
                    <!-- Footer Links -->
                    <div class="row">
                        <div class="col-sm-4">
                            <h4 class="footer-heading">AP Cloud</h4>
                            <ul class="footer-nav ul-breath list-unstyled">
                                
                                <li><a href="<s:url value="/enroll.action"/>">Enroll Today</a></li>
                                <li><a href="<s:url value="/general/contactUS.action"/>">Contact Us</a></li>
                                <li><a href="<s:url value="/general/registerCoach.action"/>">Register as a coach</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-4">
                         <h4 class="footer-heading">Get Acccess to</h4>
                         <ul class="footer-nav ul-breath list-unstyled">
<!--                                 <li><a href="#">Technologies</a></li>
                                <li><a href="#">WebEx Sessions</a></li>
                                <li><a href="#">Presentations</a></li>-->

                                <li><a href="<s:url value="/general/login.action"/>">Technologies</a></li>
                                
                                <li><a href="<s:url value="/general/login.action"/>">Presentations</a></li>

                            </ul>
                             </div>
                        <div class="col-sm-4">
                            <br>
                           <img class="img-responsive" src="http://www.miraclesoft.com/images/logo.png"> 
                            <br><ul class="footer-nav footer-nav-links list-inline">
                                <li><a href="https://www.facebook.com/andhracloud" target="_blank" class="social-facebook" data-toggle="tooltip" title="Like our Facebook page"><i class="fa fa-fw fa-facebook"></i></a></li>
                                <li><a href="https://twitter.com/andhracloud" target="_blank" class="social-twitter" data-toggle="tooltip" title="Follow us on Twitter"><i class="fa fa-fw fa-twitter"></i></a></li>
                                <li><a href="https://plus.google.com/104381127288956493644/posts/p/pub" target="_blanknk" class="social-google-plus" data-toggle="tooltip" title="Like our Google+ page"><i class="fa fa-fw fa-google-plus"></i></a></li>
                                <li><a href="https://www.linkedin.com/groups/10313125" class="social-linkedin" data-toggle="tooltip" title="Follow us on LinkedIn"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="https://www.youtube.com/channel/UC6JwAnSWoF2eMEz6RnDWJhg" class="social-youtube" data-toggle="tooltip" title="Watch our videos on YouTube"><i class="fa fa-youtube-play"></i></a></li>
                            </ul>
                             <em><span>2016</span></em> &copy;  Miracle Software Systems, Inc
                           
                        </div>
                    </div>
                    <!-- END Footer Links -->
                </div>
            </footer>
            <!-- END Footer -->
        </div>
        <!-- END Page Container -->

        <!-- Scroll to top link, initialized in js/app.js - scrollToTop() -->
        <a href="#" id="to-top"><i class="fa fa-arrow-up"></i></a>
            </div>
        </body>
</html>