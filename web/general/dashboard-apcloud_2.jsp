<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
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
<link  rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        
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
            //    $(window).load(function(){
            //        $('#mainModal').modal('show');
            //    });
        </script>

        <section class="container" id="portfolio">
            <br>
            <br>
            <br>
            <br>
            <br>

            <div class="row ">
                <div class="col-sm-2"> 
                    <br><br><br> <br><br><br>
                   <s:include value="../LeftMenu.jsp"/>  
                </div>
                <div class="col-sm-10">
                    <!--sidebar end-->
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
                                            Location
                                        </th>
                                        <th>
                                            Topic Name
                                        </th>
                                        <th>
                                            curriculum
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
                                            <td align="left"><s:property value="location"/></td>
                                            <td align="left"><a href="<%=request.getContextPath()%>/<s:property value="topicLink"/>" target="blank"><s:property value="topicName"/></a></td>
                                            <td><a href="#" data-toggle="modal" data-target="#myModal" onclick="getCurriculam(<s:property value="id"/>);">Curriculam</a></td>
                                            <td align="left"><s:if test="%{!workshopEnabled}"> <a href="<%=request.getContextPath()%>/general/enrollWorkshop?workshopId=<s:property value="id"/>"> <button class="btn btn-primary" name="btnSubmit"  >enroll</button></a></s:if></td>
                                        </tr>
                                    </s:iterator>


                                </tbody>
                            </table>

                        </div>

                        <!--sidebar end-->

                        <div class="row  tab-pane" id="Certification"> 
                            <p class="methodText">Certifications</p>

                        </div>
                        <div class="row  tab-pane" id="Myprofile">
                            <s:form method="post" theme="simple" action="" id="myForm">
                                <br>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="form-control">Name</label></div>

                                        <div class="form-group">
                                            <label class="form-control">Phone Number</label></div>


                                        <div class="form-group">
                                            <label class="form-control">Email</label></div>

                                        <div class="form-group">


                                            <s:if test='%{professionType == "1"}'>
                                                <label class="form-control">College</label></div>
                                            </s:if>
                                            <s:elseif test='%{professionType == "2"}'>
                                            <label class="form-control">Company Name</label></div>
                                        </s:elseif>

                                </div>
                                <div class="col-sm-5">
                                    <div class="form-group">
                                        <s:textfield type="text" cssClass="form-control" disabled="true" required="required" placeholder="Name" id="name" name="name" />
                                    </div>

                                    <div class="form-group">
                                        <s:textfield type="text" cssClass="form-control" disabled="true" required="required" placeholder="Phone Number" id="phoneNumber" name="phoneNumber" />
                                    </div>
                                    <div class="form-group">
                                        <s:textfield type="text" cssClass="form-control" disabled="true" required="required" placeholder="Email" id="email" name="email" />
                                    </div>
                                    <div class="form-group">
                                        <s:textfield type="text" cssClass="form-control" disabled="true" required="required" placeholder="College" id="college" name="college" />
                                    </div>

                                </div>
                                <div class="col-sm-6"></div>
                            </div>
                        </s:form>
                        <div class="row">
                            <div class="col-sm-8">
                                <hr>
                                <h5 class="heavy">My Workshops</h5>
                                <hr>
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <th>#</th>
                                    <th>Workshop</th>
                                    <th>Status</th>

                                    </thead>
                                    <tbody>
                                        <%int val = 0;%>
                                        <s:iterator value="workshopList">
                                            <s:if test="%{workshopEnabled}">
                                                <%val++;%>
                                                <tr> 


                                                    <td align="left"><%=val%></td>
                                                    <td align="left"><s:property value="topicName"/></td>
                                                    <td><s:property value="workshopStatus"/></td>
                                                </tr>
                                            </s:if>
                                        </s:iterator>
                                    </tbody>


                                </table>
                            </div>
                            <div class="col-sm-4"></div>
                        </div>


                    </div> 
                </div>
            </div>
            <br>

            <!-- Reference: https://github.com/ashleydw/lightbox/ -->

            <link type="text/css" href="webinar.css">



            <!--sidebar-->


            <br><br><br>
            <!-- Modal -->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 class="heavy modal-title">Curriculam</h3>
                            <hr>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div id="getCurriculamData"></div>
                                </div>
                            </div>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>  <s:include value="../footer.jsp"/> 
</body>

</html>