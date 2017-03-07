<%-- 
    Document   : about-us
    Created on : Aug 4, 2016, 7:20:21 PM
    Author     : miracle
--%>
<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <meta charset="utf-8">

        <title>AP Cloud Initiative | About Us</title>

        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- END Icons -->

        <!--image carousel css-->
        <style>


            #myCarousel .thumbnail {
                margin-bottom: 0;
            }
            .carousel-control.left, .carousel-control.right {
                background-image:none !important;
            }
            .carousel-control {
                color:#fff;
                top:40%;
                color:#428BCA;
                bottom:auto;
                padding-top:4px;
                width:30px;
                height:30px;
                text-shadow:none;
                opacity:1;
            }
            .carousel-control:hover {
                color: #d9534f;
            }
            .carousel-control.left, .carousel-control.right {
                background-image:none !important;
            }
            .carousel-control.right {
                left:auto;
                right:-32px;
            }
            .carousel-control.left {
                right:auto;
                left:-32px;
            }
            .carousel-indicators {
                bottom:-30px;
            }
            .carousel-indicators li {
                border-radius:0;
                width:10px;
                height:10px;
                background:#ccc;
                border:1px solid #ccc;
            }
            .carousel-indicators .active {
                width:12px;
                height:12px;
                background:#3276b1;
                border-color:#3276b1;
            }
        </style>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

        <!-- image carousel css ends-->

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Related styles of various icon packs and plugins -->


        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="css/main.css">

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="css/themes.css">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
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
            <style type="text/css">
            .backgroundImage {
                background-image: url("img/headerimage.png");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;

            }

        </style>

    </head>
    <s:include value="header.jsp"/>  
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
                    <h1 class="animation-fadeInQuick2Inv"><strong> <s:property value="title"/></strong></h1>
                </div>
                <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

                </div>

            </section>
            <!-- END Intro + Action -->

            <!-- END Promo Features -->

            <!-- Promo #1 -->
            <section class="site-section site-content border-bottom overflow-hidden">
                <div class="">
                    <div class="row ">
                        <s:if test="%{#session.username!=null && #session.username!= ''}">
                            <div class="col-sm-2"> 

                                <s:include value="LeftMenu.jsp"/>  
                            </div>

                            <div class="col-sm-10">
                                <!--sidebar end-->
                                <div class="tab-content">
                                    <div class="row  tab-pane active" style="width: 97%;position: relative;left: 14px;"> 
                                        <div class="row">
                                            <div class="col-sm-6 text-left">
                                                <h1 class="heavy">

                                                    <%--<s:property value="title"/>--%>

                                                </h1>

                                            </div>
                                            <div class="col-sm-6 text-right">
                                                <ul class="breadcrumb pull-right">


                                                    <s:if test='%{#session.professionType == "1"}'>
                                                        <li>
                                                            <a href="<%=request.getContextPath()%>/general/workshopDashboard.action">
                                                                Workshop
                                                            </a>
                                                        </li>
                                                    </s:if>
                                                    <s:else>
                                                        <li >
                                                            <a href="<%=request.getContextPath()%>/general/techTopics.action" >Topics</a>
                                                        </li>
                                                    </s:else>
                                                    <li class="active">
                                                        <s:property value="title"/>
                                                    </li>
                                                </ul>
                                            </div>     
                                        </div>
                                    </s:if>       
                                    <s:else>
                                        <div class="col-sm-12" style="margin-top:82px">
                                            <div>
                                                <div>
                                                    <div class="row">
                                                        <div class="col-sm-6 text-left">
                                                            <h1 class="heavy">

                                                                <s:property value="title"/>

                                                            </h1>

                                                        </div>
                                                        <div class="col-sm-6 text-right">
                                                            <ul class="breadcrumb pull-right">

                                                                <li>
                                                                    <a href="home.action">
                                                                        AP Cloud
                                                                    </a>
                                                                </li>
                                                                <li class="active">
                                                                    <s:property value="title"/>
                                                                </li>
                                                            </ul>
                                                        </div>     
                                                    </div>
                                                </s:else>

                                                <div class="row">

                                                    <div class="col-sm-9">

                                                        <%
                                                            out.print(request.getAttribute("bodyContent"));
                                                        %>


                                                    </div>
                                                    <div class="col-sm-3">
                                                        <s:url id="image" action="renderImage" namespace="/">
                                                            <s:param name="path" value="imageName" ></s:param>
                                                        </s:url>
                                                        <s:property value="imagename"/>
                                                        <img class="img-responsive" src="<s:property value="#image"/>" alt="<s:property value="title"/> | AP Cloud | Technologoes"  title="<s:property value="title"/>"/>
                                                    </div>
                                                </div>
                                                <br>   

                                                <div class="row">
                                                    <div class="col-sm-4">



                                                        <div id="myCarousel" class="carousel slide carousel-v1">
                                                            <div class="carousel-inner">
                                                                <%int k = 0;%>
                                                                <s:iterator value="videoTutorailList">

                                                                    <%if (k < 1) {%>
                                                                    <div class="item active">
                                                                        <%} else {
                                                                        %>                                         
                                                                        <div class="item">
                                                                            <%}
                                                                        k++;%>
                                                                            <div class='embed-container'>    <iframe width="100%" height="auto" src="<s:property/>" frameborder="0" allowfullscreen></iframe></div>
                                                                        </div>  




                                                                    </s:iterator>
                                                                </div>
                                                            </div>

                                                            <div class="carousel-arrow">
                                                                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                                                                    <i class="fa fa-angle-left"></i>
                                                                </a>
                                                                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                                                                    <i class="fa fa-angle-right"></i>
                                                                </a>
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-8">

                                                            <table class="table table-hover table-striped">

                                                                <tbody>
                                                                    <tr>
                                                                        <td> <h5 class="heavy">Website</h5></td>
                                                                        <td> <a href="<s:property value="websitelink"/>" target="_blank" class="linkText"><s:property value="websitelink"/></a></td>
                                                                        <!--                                <td> <a href="http://cassandra.apache.org/" target="_blank" class="linkText">http://cassandra.apache.org/</a></td>-->
                                                                    </tr>

                                                                    <tr>
                                                                        <td > <h5 class="heavy">Tutorials</h5></td>
                                                                        <s:iterator value="tutorialList">        


                                                                            <td>
                                                                                <a href="<s:property/>" target="_blank" class="linkText"><s:property/></a>
                                                                            </td>

                                                                        </s:iterator> 
                                                                    </tr>
                                                                    <tr>
                                                                        <td> <h5 class="heavy">Blog</h5></td>
                                                                        <td>
                                                                            <s:iterator value="blogLinkList">                                         
                                                                                <a href="<s:property/>" target="_blank" class="linkText"><s:property/></a>

                                                                            </s:iterator> 
                                                                        </td>
                                                                    </tr>

                                                                </tbody>
                                                            </table>

                                                        </div>



                                                    </div>


                                                    <s:if test="%{#session.username!=null && #session.username!= ''}">
                                                        <s:if test="%{installationGuide>=1||prsentations>=1||webxSessions>=1}">
                                                            <div class="row ">
                                                                <div class="col-sm-12">
                                                                    <h3 class="heavy">Library :</h3>
                                                                    <hr>
                                                                    <s:if test="%{installationGuide>=1}">
                                                                        <h5 class="heavy">Instllation Guide:</h5>
                                                                        <div class="row">
                                                                            <div class="col-sm-2">
                                                                                <hr>
                                                                            </div>
                                                                        </div>



                                                                        <div class="container">
                                                                            <section class="row">
                                                                                <div class="col-sm-10">

                                                                                    <%int j = 0;%>
                                                                                    <s:iterator value="docRepoList">
                                                                                        <s:if test="%{type=='instllationGuide'}">
                                                                                            <%j++;
                                                                                        if (j % 3 == 0) {%>
                                                                                            <div class="row text-center">
                                                                                                <%}%>
                                                                                                <div class="col-md-4 col-sm-6 hero-feature">
                                                                                                    <div class="thumbnail">
                                                                                                        <div class="caption">

                                                                                                            <s:url id="image" action="renderImage" namespace="/">
                                                                                                                <s:param name="path" value="imagePath" ></s:param>
                                                                                                            </s:url>
                                                                                                            <img class="img-responsive" src="<s:property value="#image"/>" width="100%" height="150" style="border:1px solid #000000" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"/>
                                                                                                            <h4><a href="#"><s:property value="docName"/></a></h4>

                                                                                                            <a href="#" class="btn btn-default" onclick="getDocumentfile(<s:property value="id"/>)" >Download</a>

                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <%if (j % 3 == 0) {%>
                                                                                            </div> 
                                                                                            <%}%>
                                                                                        </s:if>
                                                                                    </s:iterator>



                                                                                </div>
                                                                            </section>
                                                                        </div>

                                                                    </s:if>
                                                                    <s:if test="%{prsentations>=1}">
                                                                        <h5 class="heavy">Presentations</h5>
                                                                        <div class="row">
                                                                            <div class="col-sm-2">
                                                                                <hr>
                                                                            </div>
                                                                        </div>



                                                                        <div class="container">
                                                                            <section class="row">
                                                                                <div class="col-sm-10">

                                                                                    <%int i = 0;%>
                                                                                    <s:iterator value="docRepoList">
                                                                                        <s:if test="%{type=='presentation'}">
                                                                                            <%i++;
                                                                                        if (i % 3 == 0) {%>
                                                                                            <div class="row text-center">
                                                                                                <%}%>
                                                                                                <div class="col-md-4 col-sm-6 hero-feature">
                                                                                                    <div class="thumbnail">
                                                                                                        <div class="caption">

                                                                                                            <s:url id="image" action="renderImage" namespace="/">
                                                                                                                <s:param name="path" value="imagePath" ></s:param>
                                                                                                            </s:url>
                                                                                                            <img class="img-responsive" src="<s:property value="#image"/>" width="100%" height="150" style="border:1px solid #000000" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"/>
                                                                                                            <h4><a href="#"><s:property value="docName"/></a></h4>

                                                                                                            <a href="#" class="btn btn-default" onclick="getDocumentfile(<s:property value="id"/>)" >Download</a>

                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <%if (i % 3 == 0) {%>
                                                                                            </div> 
                                                                                            <%}%>
                                                                                        </s:if>
                                                                                    </s:iterator>



                                                                                </div>
                                                                            </section>
                                                                        </div>
                                                                    </s:if>
                                                                    <s:if test="%{webxSessions>=1}">

                                                                        <hr>

                                                                        <h5 class="heavy">WebEx Sessions :</h5>
                                                                        <div class="row">
                                                                            <div class="col-sm-2">
                                                                                <hr>
                                                                            </div>
                                                                        </div>


                                                                        <div class="container">
                                                                            <section class="row">
                                                                                <div class="col-sm-10">
                                                                                    <%int l = 0;%>

                                                                                    <s:iterator value="docRepoList">
                                                                                        <s:if test="%{type=='WebExSessions'}">
                                                                                            <%l++;
                                                                                        if (l % 3 == 0) {%>
                                                                                            <div class="row text-center">
                                                                                                <%}%>
                                                                                                <div class="col-md-4 col-sm-6 hero-feature">
                                                                                                    <div class="thumbnail">
                                                                                                        <style>.embed-container { position: relative; padding-bottom: 56.25%; height: 0; overflow: hidden; max-width: 100%; } .embed-container iframe, .embed-container object, .embed-container embed { position: absolute; top: 0; left: 0; width: 100%; height: 100%; }</style><div class='embed-container'><iframe width='560' height='315' src='<s:property value="filePath"/>' frameborder='0' allowfullscreen></iframe></div>
                                                                                                        <div class="caption">
                                                                                                            <h4><a href="#"><s:property value="docName"/></a></h4>



                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <%if (l % 3 == 0) {%>
                                                                                            </div> 
                                                                                            <%}%>
                                                                                        </s:if>
                                                                                    </s:iterator>



                                                                                </div>
                                                                            </section>
                                                                        </div>
                                                                    </s:if>
                                                                </div>
                                                            </div>
                                                        </s:if>
                                                    </s:if>


                                                </div>
                                            </div> 
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <br><br><br>
                            <!--image carousel-->

                            <!-- image carousel-->





                            </section>


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
