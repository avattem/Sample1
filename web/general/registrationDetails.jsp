
<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | Workshops 
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

        <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

        <script language="JavaScript" src="<s:url value="/js/dhtmlxcalendar.js"/>"></script>
        <script src="js/modernizr.custom.js"></script><!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../images/favicon.ico" rel="shortcut icon">

        <script type="text/JavaScript" src="<s:url value="/js/AppConstents.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=2.1"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
<link  rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>                
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script language="JavaScript" src="<s:url value="/js/dhtmlxcalendar.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js?version=1.0"/>"></script>
        
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
        
        
        <style type="text/css">
           

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

            .embed-container embed{border-radius:0px !important;}
            h4 {font-size:14px !important;font-weight:bold;}
            .modal-footer{ margin:0px 5px 5px 0px !important;}
            .modal-content{width:800px;margin-left:-110px;margin-top:10px;}
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
        <script>
            $( function() {
                $( "#frmDate" ).datepicker();
            } );
            $( function() {
                $( "#toDate" ).datepicker();
            } );
 
        </script>
         <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>Registration Details</strong></h1>
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
                    <div class="tab-content">
                        <div class="row  tab-pane active" id="Myprofile" style="width: 97%;position: relative;left: 14px;">

                            
                            <s:form method="post" theme="simple" action="enrollDetailsSearch.action" id="myForm">
                                <br>

                                <div class="row">

                                    <div class="col-sm-4">
                                        <div class="form-group">

                                            <s:select name="colleges" id="colleges" cssClass="form-control" headerKey="" headerValue="--Select College--" list="collegeList" theme="simple" onchange="populateWorkShopCode()"/> 
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <s:textfield name="workshopCode" id="workshopCode" placeholder="Workshop Code" cssClass="form-control col-sm-12" value="%{workshopCode}" readonly="true"/>

                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group">

                                            <s:select name="profession" id="profession" cssClass="form-control" list="#@java.util.LinkedHashMap@{'1':'Student','2':'Software Engineer','3':'Faculty'}" /> 
                                        </div>
                                    </div>         

                                </div>

                                <div class="row">

                                    <div class="col-sm-4">
                                        <div class="form-group">

                                            <s:textfield name="frmDate" id="frmDate" placeholder="From Date" cssClass="form-control col-sm-12" value="%{frmDate}" onclick="datePic()"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <s:textfield name="toDate" id="toDate" placeHolder="To Date" cssClass="form-control col-sm-12" value="%{toDate}" onclick="datePic()"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-2" >
                                        <div class="form-group">

                                            <s:submit cssClass="btn btn-primary" id="Search" name="Search" tabindex="12" type="Search" value="Search" onclick="getCollegeLMDetails()"/>
                                        </div>

                                    </div>
                                    <div class="col-sm-2" >
                                        <div class="form-group">
                                            <input class="btn btn-primary" id="generateExcel" name="generateExcel" tabindex="12" type="button" value="GenerateExcel" onclick="generateExcelForm();"/>


                                        </div>
                                    </div>
                                </div>


                            </s:form>



                        </div> 
                    </div>




                    <div class="row">
                        <table class="table t_st03" id="list">
                            <thead>
                                <tr>


                                    <th>
                                        <i  class="fa-calendar-check-o" aria-hidden="true"></i> Sno
                                    </th>
                                    <th>
                                        <i class="fa fa-users" aria-hidden="true"></i> Name
                                    </th>
                                    <th>
                                        <i class="fa fa-envelope" aria-hidden="true"></i>  Email
                                    </th>
                                    <th>
                                        <i class="fa fa-phone" aria-hidden="true"></i>  Phone Number
                                    </th>
                                    <th>
                                        <i class="fa fa-university" aria-hidden="true"></i>  College/Company
                                    </th>
                                    <th>
                                        <i class="fa  fa-registered" aria-hidden="true"></i>  Enrolled Workshops
                                    </th>

                                </tr>

                            </thead>
                            <tbody>

                                <%int val = 0;%>

                                <s:iterator value="enrolldetails">
                                    <%val++;%>
                                    <tr> 

                                        <td align="left"><%=val%></td> 
                                         <td align="left"><a href="editRegidtrationDetails.action?userId=<s:property value="userId"/>&profession=<s:property value="profissionType"/>"> <s:property value="fname"/><s:property value="lname"/></a></td>
                                         
                                         <%-- <td align="left"><s:property value="name"/></td>--%>
                                        <td align="left"><s:property value="email"/></td>
                                        <td align="left"><s:property value="PhoneNum"/></td>
                                        <td align="left"><s:property value="collegeName"/></td>
                                        <td align="left">

                                            <a href="#" data-toggle="modal" data-target="#myModal" onclick="getEnrolledWorkshopandTopics('<s:property value="userId"/>');">View</a>
                                        </td>


                                    </tr>
                                </s:iterator>


                            </tbody>
                        </table> 
                    </div>       
                </div>   </div>   



            <br>

            <!-- Reference: https://github.com/ashleydw/lightbox/ -->

            <link type="text/css" href="webinar.css">



            <!--sidebar-->


            <br><br><br>
            <!--modal-->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog" style="position:unset;">
                    <!-- Modal content-->
                    <div class="modal-content ambassidor" >

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">WorkShop and topics Details</h3>

                        </div>
                        <div class="modal-body">

                            <div class="row" id="collegeRegDetails">
                                <div class="alert alert-danger" id="resultMessg" style="display: none;">
                                    <a href="#" class="close" onclick="closeAlert();" aria-label="close">&times;</a>
                                    <strong><span id="addCollegeMessg"></span></strong> 
                                </div>
                                <span id="addWorkshopResultMessg"></span>
                                <div class="col-sm-12">
                                    <div id="techTopics">

                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!-- Modal -->


        </section>  <s:include value="../footer.jsp"/> 
    </body>

</html>








