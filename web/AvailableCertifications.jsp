<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | Certification
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
<link  rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
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
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/McertificationAjax.js"/>"></script>
       
        
         <script>
            $(document).ready(function () {


                // $("#compTypeSearchResults").DataTable();
                //alert("kdfh");

                $('#certificationlist').DataTable({
                    "searching": false,
                    "info": false,
                    "autoWidth": true,
                    "ordering": false,
                    "oLanguage": {
                        "sEmptyTable": "No Records to display"
                    },
                    "preDrawCallback": function (settings) {
                        var api = new $.fn.dataTable.Api(settings);
                        var pagination = $(this)
                        .closest('.dataTables_wrapper')
                        .find('.dataTables_paginate');
                        if (api.page.info().pages <= 1) {
                            pagination.hide();
                        } else {
                            pagination.show();
                        }
                       
                    }
                    
                });
            });
        </script>
        
        <script type="text/javascript" src=" https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js "></script>
        
        
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
            .modal-footer1{ margin:0px 5px 5px 0px !important;}
            .modal-content1{width:800px;margin-left:-110px;margin-top:10px;height:550px;}
            .on-load-modal-content{background-color: #fff; width:400px;height:150px;}
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
        <script type="text/javascript">
           function getExamDetailsByTopicId(examId,userId,examEnable,date,durationTime,examExistInHubble){
              // alert(examExistInHubble);
                if(examEnable==-1)
                {
                    showAlertModal("You can write the exam after "+date+" "+durationTime.split('-')[1]+" .");
                }
                else if(examEnable==1)
                {
                    showAlertModal("Already took the exam on this topic .");
                }
                else{
                    if(examExistInHubble==0){
                    window.location="getExamDetailsByTopicId.action?examId="+examId+"&userId="+userId;
                    }
                    else
                        {
                         showAlertModal("Exam questions not avilable.");   
                        }
                }
                
                
            }
            
            
            function getResultModal(topicName,topicId,userId) {
                // alert(topicName+' '+topicId+' '+userId)
                //alert(topicName);
                document.getElementById("loadingAcoountSearch").style.display = "block";
                $('#titleName').html(topicName+' Result');
                getExamResultsByTopicId(topicId,userId)
                //  $('#myModal').modal('show');
            }
        </script>
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
          
		
		
		
		 <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>Available Certifications</strong></h1>
                        </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">
                        
                    </div>
                
            </section>
        <script type="text/javascript">
            //    $(window).load(function(){
            //        $('#mainModal').modal('show');
            //    });
        </script>

        <section class="site-section site-content border-bottom overflow-hidden" id="portfolio">
            
            <div id="loadingAcoountSearch" class="loadingImg" style="display: none;">
                <span id ="LoadingContent" > <img src="<s:url value="/images/cloud_loading_256.gif"/>"   ></span>
            </div>

            <div class="row ">

                <div class="col-sm-2"> 

                    <s:include value="LeftMenu.jsp"/>  
                </div>
                <div class="col-sm-10">
<!--                    <h1 class="heavy">Available Certifications</h1>-->

                    <!--sidebar end-->
                    <div class="tab-content">

                        <!--sidebar end-->

                        <div class="row  tab-pane active" id="Certification" style="width: 97%;position: relative;left: 14px;"> 
                            <div class="row">
                                <%-- <%int i = 0;%>
                                 <s:iterator value="docRepoList">
                                    
                                     <%if (i % 4 == 0) {%>
                             </div><div class="row">
                                     <%} i++;%>
                                     <div class="col-sm-3" target="_blank" >
                                         <a href="<%=request.getContextPath()%>/getExamDetailsByTopicId.action?examId=<s:property value="examId"/>&userId=<s:property value="#session.id"/>"> 
                                             <img src="<%=request.getContextPath()%>/<s:property value="imagePath"/>" alt="<s:property value="topicName"/> | AP Cloud | Technologoes" title="<s:property value="topicName"/>" style="max-width:100%;" />
                                         </a>
                                     </div>
                                 </s:iterator> --%>
                                <table class="table t_st03" id="certificationlist">
                                    <thead>
                                        <tr>

                                            <th>
                                                <i class="fa fa-file-code-o"></i>  Topic 
                                            </th>
                                            <th>
                                                <i class="fa  fa-clock-o"></i>  Start Exam
                                            </th>
                                            <th>
                                                <i class="fa  fa-file-text"></i> Result
                                            </th>

                                        </tr>

                                    </thead>
                                    <tbody>

                                        <s:iterator value="docRepoList">
                                            <tr>
                                                <td><s:property value="topicName"/></td> 
                                               <td><button type="button" class="btn btn-primary" onclick="getExamDetailsByTopicId('<s:property value="examId"/>','<s:property value="#session.id"/>','<s:property value="startExamEnable"/>','<s:property value="date"/>','<s:property value="durationTime"/>','<s:property value="examExistInHubble"/>')" >Start Exam</button></td> 
                                                <td><button type="button" class="btn btn-primary" onclick="getResultModal('<s:property value="topicName"/>',<s:property value="examId"/>,<s:property value="#session.id"/>);"<s:if test="%{startExamEnable!=1}">disabled="true"</s:if>>Result</button></td> 


                                            </tr>
                                        </s:iterator>



                                    </tbody>
                                </table>


                            </div>
                        </div>
                    </div> 
                </div>
            </div>
            <br>

            <!-- Reference: https://github.com/ashleydw/lightbox/ -->

            <link type="text/css" href="webinar.css">

            <!-- modal start -->
            <div id="myModal1" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content1 ambassidor">
                        <div class="modal-header" style="background-color:#0096DE;border-bottom:1px solid #fff">
                            <button type="button" class="close" style="color:#fff; opacity: 1;" data-dismiss="modal">&times;</button>
                            <h3 class="heavy modal-title" id="titleName" name="titleName"> </h3>
                            
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <span id="loadingSpan"></span>
                                    <span id="resultData"></span>
                                </div>
                            </div>


                        </div>
                        
                    </div>
                </div>
            </div>
            <!-- modal end -->
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
                </div>



            <br><br><br>

            </div>
        </section>  <s:include value="footer.jsp"/> 
    </body>

</html>
