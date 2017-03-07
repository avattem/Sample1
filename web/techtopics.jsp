<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | Technical Topics 
        </title>
        <link rel="stylesheet" href="galry.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/main.css"/>">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/default.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/component.css"/>"></link>
        <script type="text/javascript" src="galry.js"></script>
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/prettyPhoto.css"/>"></link>
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/animate.css"/>"></link>
        <script src="js/modernizr.custom.js"></script><!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../images/favicon.ico" rel="shortcut icon">

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
            <style>
            .loadingImg {
                width: 100%;
                height: 100%;
                top: 0px;
                left: 0px;
                position: fixed;
                display: block;
                opacity: 0.7;
                background-color: #9999C2;
                z-index: 99;
                text-align: center;
            }

            #LoadingContent {
                position: absolute;
                top: 30%;
                left: 40%;
                z-index: 100;
            }
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
    <s:include value="header.jsp"/>  
    <body>

        <script type="text/javascript">
            //    $(window).load(function(){
            //        $('#mainModal').modal('show');
            //    });
        </script>
        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>Technical Topics</strong></h1>
                        </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">
                        
                    </div>
                
            </section>
        <section class="site-section site-content border-bottom overflow-hidden" id="portfolio">
            
            <div id="loadingAcoountSearch" class="loadingImg" style="display: none;">
                <span id ="LoadingContent" > <img src="<s:url value="/images/cloud_loading_256.gif"/>"   ></span>
            </div>

            <div class="row ">
                <s:if test='%{#session.username != null}'>
                    <div class="col-sm-2"> 
                        
                        <s:include value="LeftMenu.jsp"/>  
                    </div>
                    <div class="col-sm-10">
                    </s:if>
                    <s:else>
                        <div class="col-sm-12">
                        </s:else>
                        <!--sidebar end-->
                        <div class="tab-content">

                            <!--sidebar end-->

                            <div class="row  tab-pane active" id="Certification" style="width: 97%;position: relative;left: 14px;"> 
                                <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-6 text-left">
<!--                                        <h1 class="heavy">
                                            Technical Topics:
                                        </h1>-->
                                    </div>
                                    <div class="col-sm-5">
                                        <ul class="breadcrumb pull-right">

                                            <s:if test='%{#session.username != null}'>
                                                <s:if test='%{(#session.professionType == "1" || #session.professionType == "2" )}'>
                                                    <li>
                                                        <a href="<%=request.getContextPath()%>/general/workshopDashboard.action">
                                                            Workshop
                                                        </a>
                                                    </li>
                                                </s:if>
                                            </s:if>
                                            <s:else>
                                                <li>
                                                    <a href="<%=request.getContextPath()%>/general/workshop.action">
                                                        Workshop
                                                    </a>
                                                </li>
                                            </s:else>
                                            <li class="active" >
                                                Topics
                                            </li>

                                        </ul>
                                    </div>   
                                    <div class="col-sm-1"></div>
                                </div>
                                <s:if test='%{(#session.professionType == "1" || #session.professionType == "2" ) && topicEnable==1}'>
                                    <s:hidden id="workshopCode" name="workshopCode" />
                                    <s:hidden id="totalTopics" name="totalTopics"/>
                                    <s:hidden id="enrolledTotalTopics" name="enrolledTotalTopics"/>
                                    <s:if test="%{totalTopics!=enrolledTotalTopics}">
                                        <div class="row">
                                            <div class="col-sm-3">   <h4 class="heavy">WorkShop Code :<span style="color:black;"> <s:property value="workshopCode"/></span></h4>  </div>
                                            <div class="col-sm-3">
                                                <div id="enrollTopicsAll" style="display: block">
                                                     <s:hidden id="topicsList" name="topicsList"/>
                                                    <a class="btn btn-primary col-sm-6" href="#"  onclick="enrollAllTopics()"> 

                                                        Enroll All</a>

                                                </div>
                                            </div> 
                                                    <div class="col-sm-3"></div>
                                        </div>
                                    </s:if>
                                </s:if>
                                <div class="row">
                                    <%int i = 0;%>
                                    <s:iterator value="docRepoList">

                                        <%if (i % 4 == 0) {%>
                                    </div><div class="row">
                                        <%}
                                            i++;%>
                                        <div class="col-sm-3" target="_blank" >
                                            <div class="row">
                                                <a  href="<%=request.getContextPath()%>/techdetails.action?topicId=<s:property value="topicId"/>"> 
                                                     <s:url id="image" action="renderImage" namespace="/">
                                                            <s:param name="path" value="imagePath" ></s:param>
                                                        </s:url>
                                                    <img class="img-responsive" src="<s:property value="#image"/>" alt="<s:property value="topicName"/> | AP Cloud | Technologoes" title="<s:property value="topicName"/>" style="max-width:100%;"  width="100" height="100" />
                                                </a>
                                            </div>
                                            <s:if test='%{(#session.professionType == "1" || #session.professionType == "2" ) && topicEnable==1}'>

                                                <div class="row">
                                                    <s:if test="%{!topicEnabled}">
                                                        <div id="enrollTopicEnable<s:property value="topicId"/>" style="display: block"> <a class="btn btn-primary col-sm-6" href="#"  onclick="enrollTopic('<s:property value="topicId"/>','single')"> 
                                                                Enroll</a></div>
                                                        <div id="enrollTopicDisable<s:property value="topicId"/>" style="display: none" >
                                                            <a class="btn btn-success col-sm-6" href="#" onclick="alreadyEnrolled();"> 
                                                                Enrolled</a></div>
                                                            </s:if>
                                                            <s:else>

                                                        <a class="btn btn-success col-sm-6" href="#" onclick="alreadyEnrolled();"> 
                                                            Enrolled</a>
                                                        </s:else>
                                                </div>

                                            </s:if>
                                        </div>
                                    </s:iterator>
                                </div>
                                   </div>
                            </div>
                        </div> 
                    </div>
                </div>
                <br>

                <!-- Reference: https://github.com/ashleydw/lightbox/ -->

                <link type="text/css" href="webinar.css">

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog"  style="position: unset;">
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

                <!--sidebar-->


                <br><br><br>
                <!-- Modal -->
            </div>
        </section>  <s:include value="footer.jsp"/> 
    </body>

</html>
