<%-- 
    Document   : collegeListActivation
    Created on : Jul 21, 2016, 7:38:40 PM
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
            AP Cloud Initiative | Workshops 
        </title>
        <link rel="stylesheet" href="galry.css" type="text/css" />
        <link rel="stylesheet" href="overley.css" type="text/css" />
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
        <link  rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <%--  <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>--%>
        <script type="text/JavaScript" src="<s:url value="/js/AppConstents.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=1.0"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js?version=1.0"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>

        <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
        <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
        <script src="<s:url value="/js/plugins.js"/>"></script>
        <script src="<s:url value="/js/app.js"/>"></script>
        <!-- image carousel js-->
        <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
        <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>


        
          <script>
            $(document).ready(function () {


                // $("#compTypeSearchResults").DataTable();
                //alert("kdfh");

                $('#workshoplist').DataTable({
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
        <script>
            var dateToday = new Date();
            //  alert("date")
            $(function() {
                // alert("enter")
                $( "#workshopDate" ).datepicker({
                    
                    numberOfMonths: 1,
                    showButtonPanel: true,
                    minDate: dateToday
                });
            });
        </script>
        <script>
            $( function() {
                $( "#frmDate" ).datepicker();
            } );
            $( function() {
                $( "#toDate" ).datepicker();
            } );
            //workshopDate
            $( function() {
                $( "#workshopDate" ).datepicker();
            } );
 
        </script>

         <script>
            function generateWorkshopDetExcelSheet(){
                var exportExcelSheet;
                var gridDownload=document.getElementById('gridDownload').value; //gridDownload
               //  alert(gridDownload);
                var url= "exportWorkshopDetExcelSheet.action?gridDownload="+gridDownload+"&workshopDetExcelSheet="+exportExcelSheet; //gridDownload
    
                //   alert(url);
                window.location=url;
                    
            }
        </script>
        
        <script type="text/javascript">
            //    $(window).load(function(){
            //        $('#mainModal').modal('show');
            //    });
        </script>

        <script>
            function doEditCollegeDet(){
                alert("doEditCollegeDet")
                window.location="editCollegeDet.action";
                alert("--------")
            }
        </script>
        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">

            <div class="push text-center">
                <h1 class="animation-fadeInQuick2Inv"><strong>Add/Update Workshops </strong></h1>
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
                        <div class="row  tab-pane active" id="Workshop" style="width: 97%;position: relative;left: 14px;">

<!--                            <table style="margin:0 0 29px"> <tr><th class="p_tit"><i class="fa fa-minus" aria-hidden="true"></i> Add/Update Workshops </th></tr></table>-->

                            <s:form name="workshopDetailsAdd" action='../general/workshopDetailsAdd.action' method="post" theme="simple" onsubmit="return dateComparision();">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="alert alert-danger" id="resultMessg2" style="display: none;">
                                            <a href="#" class="close" onclick="closeAlert2();" aria-label="close">&times;</a>
                                            <strong><span id="searchWorkshop"></span></strong> 
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <div class="form-group">
                                            <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select type---" id="workshopFormType" name="workshopFormType" list="#@java.util.LinkedHashMap@{'1':'College','2':'Company'}"   value="%{workshopType}" onchange="changeWorkshopType();"/>
                                        </div>
                                    </div> 
                                    <div class="col-sm-2">
                                        <div class="form-group">

                                            <s:textfield name="frmDate" id="frmDate" placeholder="From Date" cssClass="form-control col-sm-12" value="" onclick="datePic()"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <div class="form-group">
                                            <s:textfield name="toDate" id="toDate" placeHolder="To Date" cssClass="form-control col-sm-12" value="" onclick="datePic()"/>
                                        </div>
                                    </div>
                                        
                                    <div class="col-sm-1" >
                                        <div class="form-group">
                                            <s:submit cssClass="btn btn-primary col-sm-0" id="Search" name="Search" tabindex="12" type="Search" value="Search" onclick="getCollegeLMDetails()"/>
                                        </div>

                                    </div>
                                    <div class="col-sm-1" >
                                        <div class="form-group">
                                            <%--<s:submit cssClass="btn btn-primary col-sm-0" id="Add" name="Add" tabindex="12" type="Add" value="Add" onclick="getCurriculam()"/>--%>
                                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="">Add</a>
                                        </div>
                                    </div>
                                            
                                      <div class="col-sm-1" >
                                       <div class="form-group">
                                        <div onclick="generateWorkshopDetExcelSheet()"  class="btn btn-primary col-sm-0">&nbsp;ExportToExcel</div>
                                    </div>  
                                   </div>    
                                            <div class="col-sm-3"></div>
                                </div>
                            </s:form>

                            <div class="row">
                                 <div class="col-sm-12">
                                <table class="table t_st03" id="workshoplist">
                                    <thead>
                                        <tr>

                                            <th>
                                                <i class="fa  fa-barcode" aria-hidden="true"></i>  Sno
                                            </th>
                                            <th>
                                                <i class="fa  fa-barcode" aria-hidden="true"></i>  Code
                                            </th>


                                            <th>
                                                <i class="fa fa-university" aria-hidden="true"></i> College/Company Name
                                            </th>
                                            <th>
                                                <i class="fa fa-calendar" aria-hidden="true"></i> Date
                                            </th>
                                            <th>
                                                <i class="fa fa-users" aria-hidden="true"></i>  Ambassadors
                                            </th>

                                            <th>
                                                <i class="fa fa-location-arrow" aria-hidden="true"></i>  Location
                                            </th>
                                            <th>
                                                <i class="fa fa-file" aria-hidden="true"></i> Curriculum
                                            </th>

                                                                                    <th>
                                        <i class="fa fa-users" aria-hidden="true"></i> Registraints 
                                         </th>

                                        </tr>

                                    </thead>
                                    <tbody>
                                        <% int i = 1;%>
                                        <s:iterator value="workshopList">
                                            <tr> 

                                                <td align="left"><%out.println(i);%></td>
                                                <td align="left">
                                                    <a href="#" data-toggle="modal" data-target="#myModal" onclick="getEditModal('<s:property value="Code"/>','<s:property value="CollegeName"/>','<s:property value="location"/>','<s:property value="DATE"/>','<s:property value="workshopType"/>');">    <s:property value="Code"/></a>
                                                </td>


                                                <td align="left"><a href="<s:property value="Link"/>" target="blank"><s:property value="CollegeName"/></a></td>
                                                <td align="left"><s:property value="DATE"/></td>
                                                <td> <a href="#" data-toggle="modal" data-target="#myModal" onclick="getCollegeCoordinators('<s:property value="collegeId"/>','<s:property value="Code"/>','<s:property value="DATE"/>','<s:property value="location"/>');">Contact Details</a></td>


                                                <td align="left"><s:property value="location"/></td>

                                                <%--                                                <td><a href="#" data-toggle="modal" data-target="#myModal" onclick="getCurriculam('<s:property value="Code"/>','<s:property value="CollegeName"/>','<s:property value="location"/>');">Curriculam</a></td>--%>
                                                <td align="left"><a class="btn btn-primary" href="<%=request.getContextPath()%>/general/CurrcullamAddTopicsData.action?workshopCode=<s:property value="Code"/>&collegeName=<s:property value="CollegeName"/>">Add/Edit</a></td>
                                                <td> <a class="btn btn-primary" href="getRegistratesTopicsData.action?workshopCode=<s:property value="Code"/>&collegeName=<s:property value="CollegeName"/>">View</a></td>
                                                <%-- <td align="left">
                                                   <s:if test="%{!workshopEnabled}"> 
                                                        <a href="<%=request.getContextPath()%>/general/enrollWorkshop?workshopId=<s:property value="id"/>">
                                                            <button class="btn btn-primary" name="btnSubmit"  >enroll</button>
                                                        </a>
                                                    </s:if>
                                                </td>--%>
                                                <%i++;%>
                                            </tr>
                                        </s:iterator>


                                    </tbody>
                                </table> 
                                        <s:hidden name="gridDownload" id="gridDownload" value="%{gridDownload}"/> 
                            </div> </div>
                            <!--                           <div class="col-sm-3" style="margin-left: 790px">
                                                            <div class="form-group">
                            <%--<s:submit cssClass="btn btn-primary col-sm-0" id="Add" name="Add" tabindex="12" type="Add" value="Add" onclick="getCurriculam()"/>--%>
                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#myModal2" onclick="">Edit</a>
                        </div>
                    </div> -->

                        </div>
                        <!--sidebar end-->
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
                <div class="modal-dialog" style="position:unset;">

                    <!-- Modal content-->
                    <div class="modal-content ambassidor" >

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" onclick="reloadWorkshopAddPage();" style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">Add WorkShop Details</h3>

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

                                        <s:hidden id="workshopCode" name="workshopcode"></s:hidden>
                                         <s:hidden id="workshopCode" name="workshopcode"></s:hidden>

                                        <div class="row">
                                             <div id="workshopTypeSelect" style="display: block;">
                                            <div class="cal-sm-3">
                                                Type :
                                            </div>

                                            <div class="cal-sm-3">
                                               
                                                    <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select type---" id="workshopType" name="workshopType" list="#@java.util.LinkedHashMap@{'1':'College','2':'Company'}"   value="%{workshopType}" onchange="changeWorkshopType();"/>
                                        
                                            </div>
                                             </div>
                                        </div>
                                            <div class="row">
                                                <div class="cal-sm-3" id="collegeOrCompany">
                                                    College Name :
                                                </div>

                                                <div class="cal-sm-3">
                                                    <div id="collegeSelect" style="display: block;">
                                                    <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select Your College---" id="frmCollege" name="frmCollege" list="collegeMap"  value="%{collegeid}" onchange="borderCssChange(this);"/>
                                                </div>
                                                <div id="companyText" style="display:none">
                                                    <s:textfield name="companyNameText" cssClass="form-control" id="companyNameText"  value="" onchange="workshopFieldlengthValidator(this);startingCapital(this);"/>

                                                </div>
                                                <div id="collegeText" style="display:none">
                                                    <s:textfield name="collegeNameText" cssClass="form-control" id="collegeNameText" readonly="true" value=""/>

                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="cal-sm-3">
                                                Location :
                                            </div>

                                            <div class="cal-sm-3">

                                                <s:textfield name="workLocation" cssClass="form-control" id="workLocation" value="" onblur="workshopFieldlengthValidator(this);startingCapital(this);" />

                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="cal-sm-3">
                                                Date :
                                            </div>
                                            <div class="cal-sm-3">

                                                <s:textfield name="workshopDate" cssClass="form-control" id="workshopDate" value=""  onclick="dateFromToday()"/>

                                            </div>

                                        </div>


                                        <div class="row">
                                            <div id="saveOverlayEnable" style="display: block;">
                                                <button class="btn btn-primary col-sm-12" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." id="save" name="save" tabindex="12" type="save" value="save" onclick="addWorkshopDetails();"> Save</button>
                                            </div>
                                            <div id="updateOverlayEnable" style="display: none;">
                                                <button class="btn btn-primary col-sm-12" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." id="update" name="update" tabindex="12" type="update" value="update" onclick="updateWorkshopData();"> Update</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div>



            <!--modal end-->



        </div>
    </section>  <s:include value="../footer.jsp"/> 
</body>

</html>	