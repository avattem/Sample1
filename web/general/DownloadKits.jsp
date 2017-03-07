<%-- 
    Document   : DownloadKits
    Created on : Aug 5, 2016, 5:10:10 PM
    Author     : miracle
--%>
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
                       <h1 class="animation-fadeInQuick2Inv"><strong>Download Kits</strong></h1>
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
                    <div class="container">
    <div class="row" style="margin-top:122px">
        <div class="col-md-12">
<%--            <a href="<s:url value="/general/downloadAllKits.action?fileName=DemoKits_V0.3.zip"/>" class="btn btn-primary btn-lg" onclick="">View</a>--%>
            <a href="<s:url value="/general/doDownloadKits.action?fileName=DemoKits_V0.3.zip"/>" class="btn btn-primary btn-lg" value=""><i class=" fa fa-wrench fa-spin"></i>Demo Kit</a>
            <a href="<s:url value="/general/doDownloadKits.action?fileName=StarterKit_V0.3.zip"/>" class="btn btn-primary btn-lg" value=""><i class="  fa fa-suitcase"></i>Starter Kit</a>
            <a href="<s:url value="/general/doDownloadKits.action?fileName=HelloWorldLabs.zip"/>" class="btn btn-primary btn-lg" value=""> <i class="fa fa-file-code-o"></i>HelloWorld Labs</a>
<!--            <button class="btn btn-primary btn-lg"><i class="fa fa-circle-o-notch fa-spin"></i> Demo Kit</button>
            <button class="btn btn-primary btn-lg"><i class="fa fa-refresh fa-spin"></i> Starter Kit</button>
            <button class="btn btn-primary btn-lg"><i class="fa fa-spinner fa-spin"></i> HelloWorld Labs</button>-->
        </div>
                </div>
                <br>
                    </div>
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
