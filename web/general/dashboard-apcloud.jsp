<%@page import="com.mss.apcloud.util.AppConstants"%>
<!DOCTYPE html>
<html >
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta content="Here in the AP Cloud Initiative dashboard, we provide all the topics and scheduled workshops with the tools which are listed in the page." name="Description">
        
        <title>
            Miracle Software Systems, Inc. | Events Gallery 
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
<!--        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>-->
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <link  rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script>
            $(document).ready(function () {


                // $("#compTypeSearchResults").DataTable();
                //alert("kdfh");

                $('#list').DataTable({
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
            .scroll {
                max-height: 150px;
                overflow-y: auto;
            }


        </style>
        <style>
            .show-menu      
            {
                background-color:#2368a0;
                position: fixed;
                top:80px;
                left:-300px;
                z-index: 1;
                width: 180px;
                height: 100%;
                -webkit-transform: translate3d(300px,0,0);
                -moz-transform: translate3d(300px,0,0);
                -o-transform: translate3d(300px,0,0);
                -ms-transform: translate3d(300px,0,0);
                transform: translate3d(300px,0,0);      
                -webkit-transition: all 0.3s linear;
                -moz-transition: all 0.3s linear;
                -ms-transition: all 0.3s linear;
                -o-transition: all 0.3s linear;
                transition: all 0.3s linear;
            }  

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
            .modal-content{width:800px;margin-left:-110px;margin-top:10px;height:550px;}
            .on-load-modal-content{background-color: #fff; width:400px;height:150px;}
        </style>
    </head><!--/head-->
    <s:include value="../header.jsp"/> 
    <body>

        <script type="text/javascript">
//            $(window).load(function(){
//                $('#mainModal').modal('show');
//            });
            
            function redirectPage(obj){
        
                if(obj.value=='developer'){
                    //window.location='../cloud-developer.action';
                    $("#developerTab").click();
                    $('#mainModal').modal('hide');
                    //$('#mainclose').click();
                    //alert("nnnnnnnnnnn");
                }else {
                    // window.location='../cloud-admin.action';
                    $("#adminTab").click();
                    $('#mainModal').modal('hide');
                }
            }
        </script>

        <section class="container" id="portfolio">
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="modal fade" id="mainModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog " role="document">
                    <div class="on-load-modal-content modal-xs" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title heavy" id="myModalLabel">Select your role</h3>
                        </div>
                        <div class="modal-body row">
                            <form action="">
                                <div class="col-sm-6"><input type="radio" name="user" value="developer" onclick="redirectPage(this)" /> Cloud Developer<br>
                                </div>       
                                <div class="col-sm-6"><input type="radio" name="user" value="admin" onclick="redirectPage(this)"/> Cloud Administrator<br>
                                </div>
                            </form>

                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>


    <div class="row ">
        <div class="col-sm-2"> 
            <br><br><br> <br><br><br>
            <s:include value="../LeftMenu.jsp"/> 
        </div>
        <!--sidebar end-->
        <div class="col-sm-10">
            <div class="tab-content">
                <div class="row  tab-pane active" id="Workshop">
                     <s:if test="%{resultMessage == 'success'}">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Successfully enrolled</strong> 
                        </div>
                    </s:if>
                    <s:elseif test="%{resultMessage=='error'}">
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            Please try latter
                        </div>
                    </s:elseif>
                    <table class="table table-hover table-striped" id="list">
                        <thead>
                            <tr>
                                
                                <th>
                                    Date
                                </th>
                                <th>
                                    Code
                                </th>
                                <th>
                                    College Name
                                </th>
                                <th>
                                    Location
                                </th>
                                <th>
                                    Topic Name
                                </th>
                                <th>
                                    Enroll
                                </th>
                            </tr>

                        </thead>
                        <tbody>
                            
                            <s:iterator value="workshopList">
                        <tr> 

                 
                            <td align="left"><s:property value="DATE"/></td>
                            <td align="left"><s:property value="Code"/></td>
                            <td align="left"><s:property value="CollegeName"/></td>
                            <td align="left"><s:property value="location"/></td>
                            <td align="left"><a href="<%=request.getContextPath()%>/<s:property value="topicLink"/>" target="blank"><s:property value="topicName"/></a></td>
                             <td align="left"><s:if test="%{!workshopEnabled}"> <a href="<%=request.getContextPath()%>/general/enrollWorkshop?workshopId=<s:property value="id"/>"> <button class="btn btn-primary" name="btnSubmit"  >enroll</button></a></s:if></td>
                        </tr>
                    </s:iterator>
                        </tbody>
                    </table>

                </div>

                <div class="row tab-pane" id="Curriculam">

                    <table class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>
                                    Day
                                </th>
                                <th>
                                    Topic
                                </th>
                                <th>
                                    Duration
                                </th>
                            </tr>

                        </thead>
                        <tbody>
                            <tr>
                                <td>1-14-2016</td>
                                <td>Node.js</td> 
                                <td>30 Mins</td>  
                            </tr>
                            <tr>
                                <td>1-14-2016</td>
                                <td>Angular.js</td> 
                                <td>40 Mins</td>  
                            </tr>
                            <tr>
                                <td>1-14-2016</td>
                                <td>MongoDB</td> 
                                <td>45 Mins</td>  
                            </tr>
                            <tr>
                                <td>1-14-2016</td>
                                <td>Node.js</td> 
                                <td>30 Mins</td>  
                            </tr>
                        </tbody>
                    </table>

                </div>

                <div class="tab-pane" id="Tools" align="center">
                    <div class="row">
                        <div class="col-sm-4">
                            <img class="imgBox" src="../images/iaas.png" id="iaas"  data-toggle="modal" href="#myModal1" onclick="getRepoData('iaas',1);">
                        </div>
                        <div class="col-sm-4">
                            <img class="imgBox" src="../images/saas.png" class="img-responsive" data-toggle="modal" data-target="#myModal1" onclick="getRepoData('saas',2);">
                        </div>
                        <div class="col-sm-4">
                            <img class="imgBox" src="../images/paas.png" class="img-responsive" data-toggle="modal" data-target="#myModal1" onclick="getRepoData('paas',3);">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-4">
                            <img class="imgBox" src="../images/Angular_Js.png"  class="img-responsive" data-toggle="modal" href="#myModal1">
                        </div>
                        <div class="col-sm-4">
                            <img class="imgBox" src="../images/IBM-bluemix.png" class="img-responsive" data-toggle="modal" href="#myModal1">
                        </div>
                        <div class="col-sm-4">
                            <img class="imgBox" src="../images/Express.png" class="img-responsive" data-toggle="modal" href="#myModal1">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-4"><img class="imgBox" src="../images/javascript_logo.png" class="img-responsive" data-toggle="modal" href="#myModal1"></div>
                        <div class="col-sm-4"> <img class="imgBox" src="../images/Mongo-DB.png" class="img-responsive" data-toggle="modal" href="#myModal1"></div>
                        <div class="col-sm-4"><img class="imgBox" src="../images/node.png" class="img-responsive" data-toggle="modal" href="#myModal9"></div>
                    </div>   
                </div>

                <!--Developer Div Start-->

                <div class="row tab-pane" id="developer">


                    <!--                    <div class="col-sm-4"></div>
                                        <div class="col-sm-8">-->
                    <h3 class="heavy">Welcome  <% out.println(session.getAttribute(AppConstants.SESSION_DBUSERNAME)); %>!</h3>
<!--                        <h3 class="heavy">Welcome User!</h3>-->

                    
                    <p class="methodText">
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                    </p>


                    <p class="methodText">
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                    </p>

                    <p class="methodText">
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                    </p>

                    <!--                </div>-->

                </div>
                <!--Developer Div End-->


                <!--Admin Div Start -->
                <div class="row tab-pane" id="admin">


                    <h3 class="heavy">Welcome  <% out.println(session.getAttribute(AppConstants.SESSION_DBUSERNAME)); %>!</h3>
<!--                        <h3 class="heavy">Welcome Admin!</h3>-->
                        <p class="methodText">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                        <p class="methodText">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                        <p class="methodText">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                    


                </div>

                <!--Admin Div end-->

            </div>
        </div>
    </div>
    <br>

    <!-- Reference: https://github.com/ashleydw/lightbox/ -->
    <script src="http://rawgithub.com/ashleydw/lightbox/master/dist/ekko-lightbox.js"></script>
    <link type="text/css" href="webinar.css">


    <!--Modal1-->

    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Tool 1</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-12">
                            <ul class="nav nav-pills">
                                <li class="active"><a data-toggle="pill" href="#home">Presentation</a></li>
                                <li><a data-toggle="pill" href="#menu1">WebEx Sessions</a></li>
                                <li><a data-toggle="pill" href="#menu2">Installation Guide</a></li>

                            </ul>

                            <div class="tab-content">
                                <div id="home" class="tab-pane fade in active">
                                    <h3>HOME</h3>
                                    <div class="row">
                                       <div id="contentDisplay" >
                                           
                                       </div>
                                    </div>

                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                </div>
                                <div id="menu1" class="tab-pane fade">
                                    <h3>Menu 1</h3>
                                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Menu 2</h3>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                                </div>
                                <div id="menu3" class="tab-pane fade">
                                    <h3>Menu 3</h3>
                                    <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>

    <!--end of modal1-->
    <!--Modal2-->

    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Tool 2</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-12">
                            <ul class="nav nav-pills nav nav-tabs tabs-left">
                                <li class="active"><a data-toggle="pill" href="#home">Presentation</a></li>
                                <li><a data-toggle="pill" href="#menu1">WebEx Sessions</a></li>
                                <li><a data-toggle="pill" href="#menu2">Installation Guide</a></li>
                                <li><a data-toggle="pill" href="#menu3">Menu 3</a></li>
                            </ul>

                            <div class="tab-content">
                                <div id="home" class="tab-pane fade in active">
                                    <h3>HOME</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                </div>
                                <div id="menu1" class="tab-pane fade">
                                    <h3>Menu 1</h3>
                                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Menu 2</h3>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                                </div>
                                <div id="menu3" class="tab-pane fade">
                                    <h3>Menu 3</h3>
                                    <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>

    <!--end of modal2-->
    <!--Modal3-->

    <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Tool 3</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-12">
                            <ul class="nav nav-pills">
                                <li class="active"><a data-toggle="pill" href="#home">Presentation</a></li>
                                <li><a data-toggle="pill" href="#menu1">WebEx Sessions </a></li>
                                <li><a data-toggle="pill" href="#menu2">Installation Guide</a></li>
                                <li><a data-toggle="pill" href="#menu3">Menu 3</a></li>
                            </ul>

                            <div class="tab-content">
                                <div id="home" class="tab-pane fade in active">
                                    <h3>HOME</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                </div>
                                <div id="menu1" class="tab-pane fade">
                                    <h3>Menu 1</h3>
                                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Menu 2</h3>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                                </div>
                                <div id="menu3" class="tab-pane fade">
                                    <h3>Menu 3</h3>
                                    <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>


    <!--end of modal3-->
    <!--Modal4-->

    <div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Tool 4</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-12">
                            <ul class="nav nav-pills">
                                <li class="active"><a data-toggle="pill" href="#home">Home</a></li>
                                <li><a data-toggle="pill" href="#menu1"></a></li>
                                <li><a data-toggle="pill" href="#menu2">Menu 2</a></li>
                                <li><a data-toggle="pill" href="#menu3">Menu 3</a></li>
                            </ul>

                            <div class="tab-content">
                                <div id="home" class="tab-pane fade in active">
                                    <h3>HOME</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                </div>
                                <div id="menu1" class="tab-pane fade">
                                    <h3>Menu 1</h3>
                                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Menu 2</h3>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                                </div>
                                <div id="menu3" class="tab-pane fade">
                                    <h3>Menu 3</h3>
                                    <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>


    <!--end of modal4-->
    <!--Modal5-->
    <div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Presentation 5</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-7">
                            <iframe src="https://www.slideshare.net/slideshow/embed_code/key/ijai3Yw12oj75v" width="500px" height="250px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border:1px solid #CCC; border-width:1px; margin-bottom:5px; max-width: 100%;" allowfullscreen> </iframe> <div style="margin-bottom:5px"> <strong> <a href="https://www.slideshare.net/SivaKusampudi/marketing-58972037" title="Marketing" target="_blank"></strong> </a></div>

                        </div>

                        <div class="col-sm-5">
                            <p class="methodText">In today?s demanding market-place it is important for an enterprise to be connected to its business partners and this becomes complicated when the partners lack MQ skills and support personnel. This is where the MQ Appliance used to connect you with your business partners in a simple, secure and reliable manner. The MQ Appliance brings great aspects such as simplicity, scalability and remote deployment. </p>
                        </div></div>


                </div>
                <div class="modal-footer">
                </div>

            </div>
        </div>
    </div>


    <!--end of modal5-->
    <!--Modal6-->

    <div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Presentation 6</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-7">
                            <iframe src="https://www.slideshare.net/slideshow/embed_code/key/ijai3Yw12oj75v" width="500px" height="250px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border:1px solid #CCC; border-width:1px; margin-bottom:5px; max-width: 100%;" allowfullscreen> </iframe> <div style="margin-bottom:5px"> <strong> <a href="https://www.slideshare.net/SivaKusampudi/marketing-58972037" title="Marketing" target="_blank"></strong> </a></div>

                        </div>

                        <div class="col-sm-5">
                            <p class="methodText">In today?s demanding market-place it is important for an enterprise to be connected to its business partners and this becomes complicated when the partners lack MQ skills and support personnel. This is where the MQ Appliance used to connect you with your business partners in a simple, secure and reliable manner. The MQ Appliance brings great aspects such as simplicity, scalability and remote deployment. </p>
                        </div></div>
                    <div class="row">
                        <div id="disqus_thread" class="col-sm-12 scroll">
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                </div>

            </div>
        </div>
    </div> 

    <!--end of modal6-->
    <!--Modal7-->
    <div class="modal fade" id="myModal7" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Presentation 7</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-7">
                            <iframe src="https://www.slideshare.net/slideshow/embed_code/key/ijai3Yw12oj75v" width="500px" height="250px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border:1px solid #CCC; border-width:1px; margin-bottom:5px; max-width: 100%;" allowfullscreen> </iframe> <div style="margin-bottom:5px"> <strong> <a href="https://www.slideshare.net/SivaKusampudi/marketing-58972037" title="Marketing" target="_blank"></strong> </a></div>

                        </div>

                        <div class="col-sm-5">
                            <p class="methodText">In today?s demanding market-place it is important for an enterprise to be connected to its business partners and this becomes complicated when the partners lack MQ skills and support personnel. This is where the MQ Appliance used to connect you with your business partners in a simple, secure and reliable manner. The MQ Appliance brings great aspects such as simplicity, scalability and remote deployment. </p>
                        </div></div>
                    <div class="row">
                        <div id="disqus_thread" class="col-sm-12 scroll">
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                </div>

            </div>
        </div>
    </div>

    <!--end of modal7-->
    <!--Modal8-->

    <div class="modal fade" id="myModal8" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Presentation 8</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-7">
                            <iframe src="https://www.slideshare.net/slideshow/embed_code/key/ijai3Yw12oj75v" width="500px" height="250px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border:1px solid #CCC; border-width:1px; margin-bottom:5px; max-width: 100%;" allowfullscreen> </iframe> <div style="margin-bottom:5px"> <strong> <a href="https://www.slideshare.net/SivaKusampudi/marketing-58972037" title="Marketing" target="_blank"></strong> </a></div>

                        </div>

                        <div class="col-sm-5">
                            <p class="methodText">In today?s demanding market-place it is important for an enterprise to be connected to its business partners and this becomes complicated when the partners lack MQ skills and support personnel. This is where the MQ Appliance used to connect you with your business partners in a simple, secure and reliable manner. The MQ Appliance brings great aspects such as simplicity, scalability and remote deployment. </p>
                        </div></div>
                    <div class="row">
                        <div id="disqus_thread" class="col-sm-12 scroll">
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                </div>

            </div>
        </div>
    </div>

    <!--end of modal8-->
    <!--modal 9-->
    <div class="modal fade" id="myModal9" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog " role="document">
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title heavy" id="myModalLabel">Tool 9</h3>
                </div>
                <div class="modal-body">
                    <div class="row"> <div class="col-sm-12">
                            <ul class="nav nav-pills">
                                <li class="active"><a data-toggle="pill" href="#home">Presentation</a></li>
                                <li><a data-toggle="pill" href="#menu1">WebEx Sessions</a></li>
                                <li><a data-toggle="pill" href="#menu2">Installation Guide</a></li>

                            </ul>

                            <div class="tab-content">
                                <div id="home" class="tab-pane fade in active">

                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="thumbnail">
                                                <div class="caption">
                                                    <iframe src="https://docs.zoho.com/show/publish/qu3o1e0a793e891c34b1fbfff951f82dbd841/params?toolbar=false&menu=false&loop=true" width="100%" height="150" style="border:1px solid #000000" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>
                                                    <h4><a href="#">Presentation 1</a></h4>
                                                    <a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#myModal5">Preview</a> 
                                                    <a href="#" class="btn btn-default">Download</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="thumbnail">
                                                <div class="caption">
                                                    <iframe src="https://docs.zoho.com/show/publish/qu3o1e0a793e891c34b1fbfff951f82dbd841/params?toolbar=false&menu=false&loop=true" width="100%" height="150" style="border:1px solid #000000" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>
                                                    <h4><a href="#">Presentation 1</a></h4>
                                                    <a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#myModal6">Preview</a> 
                                                    <a href="#" class="btn btn-default">Download</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="thumbnail">
                                                <div class="caption">
                                                    <iframe src="https://docs.zoho.com/show/publish/qu3o1e0a793e891c34b1fbfff951f82dbd841/params?toolbar=false&menu=false&loop=true" width="100%" height="150" style="border:1px solid #000000" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>
                                                    <h4><a href="#">Presentation 1</a></h4>
                                                    <a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#myModal7">Preview</a> 
                                                    <a href="#" class="btn btn-default">Download</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                </div>
                                <div id="menu1" class="tab-pane fade">
                                    <h3>Menu 1</h3>
                                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Menu 2</h3>
                                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                                </div>
                                <div id="menu3" class="tab-pane fade">
                                    <h3>Menu 3</h3>
                                    <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>


    <!-- /.box-body -->

    <!--sidebar-->


    <br><br><br>

</section><s:include value="../footer.jsp"/> 
</body>

</html>