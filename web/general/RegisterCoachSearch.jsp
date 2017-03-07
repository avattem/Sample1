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
        <script type="text/JavaScript" src="<s:url value="/js/AppConstents.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=2.1"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>

         <script type="text/JavaScript" src="<s:url value="/js/Validation.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>                
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js?version=1.0"/>"></script>

        
        <script>
            $(document).ready(function () {


                // $("#compTypeSearchResults").DataTable();
                //alert("kdfh");

                $('#registredCoachList').DataTable({
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
         <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

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
            $( function() {
                $( "#frmDate" ).datepicker();
            
                $( "#toDate" ).datepicker();
            } );


 
        </script>

         <script>
            function generateRegisterCoachDetExcelSheet(){
                var exportExcelSheet;
                var gridDownload=document.getElementById('gridDownload').value; //gridDownload
                // alert(gridDownload);
                var url= "exportRegisterCoachDetExcelSheet.action?gridDownload="+gridDownload+"&registerCoachExcelSheet="+exportExcelSheet; //gridDownload
    
                //   alert(url);
                window.location=url;
                    
            }
        </script>

        <script type="text/javascript">
            function showAlertModal(msg)
            {
                //  alert(msg);
                document.getElementById('showAlertText').innerHTML = msg;
                $('#myModalvalidationCoach').modal('show');
                return false;
            }
      
            
            
        </script>


        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">

            <div class="push text-center">
                <h1 class="animation-fadeInQuick2Inv"><strong>Registered Coach Details</strong></h1>
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
                            <s:form name="registercoachDet" action='../general/registredCoachDetailsSearch.action' method="post"  theme="simple" onsubmit="return dateComparision();return coachDetailsValidation();">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="alert alert-danger" id="resultMessg2" style="display: none;">
                                            <a href="#" class="close" onclick="closeAlert2();" aria-label="close">&times;</a>
                                            <strong><span id="searchWorkshop"></span></strong> 
                                        </div>
                                    </div>
                                </div>
                                <div class="row">

                                    <div class="col-sm-3">
                                        <div class="form-group">

                                            <s:textfield name="frmDate" id="frmDate" placeholder="From Date" cssClass="form-control col-sm-12" value="" onclick="datePic()"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
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
                                          
                                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#myModalCoach" onclick="">Add</a>
                                        </div>
                                    </div>
                                         <div class="col-sm-1" style="margin-left: 4px">
                                        <div onclick="generateRegisterCoachDetExcelSheet()"  class="btn btn-primary col-sm-0">&nbsp;ExportToExcel</div>
                                    </div>
                                    <!-- <div class="col-sm-1" >
                                   <div class="form-group">
                                     
                                       <a href="#" class="btn btn-primary" onclick="generateCollegeExcel();">ExportExcel</a>
                                   </div>
                               </div> -->
                                </div>
                            </s:form>

                            <div class="row">
                                <table class="table t_st03" id="registredCoachList">
                                    <thead>
                                        <tr>

                                            <th>
                                                <i class="fa fa-barcode" aria-hidden="true"></i>&nbsp;  Sno
                                            </th>
                                            <th>
                                                <i class="fa fa-user" aria-hidden="true"></i>&nbsp; Name

                                            </th>
                                            <th>
                                                <i class="fa fa-envelope" aria-hidden="true"></i>&nbsp; Email

                                            </th>
                                            <th>
                                                <i class="fa fa-phone" aria-hidden="true"></i>&nbsp; Phone

                                            </th>
                                            <th>
                                                <i  aria-hidden="true"></i> Title
                                            </th>

                                            <th>
                                                <i class="fa fa-building-o" aria-hidden="true"></i>  Company&nbsp;Name
                                            </th>
                                            <th>
                                                <i  aria-hidden="true"></i>  AOE
                                            </th>

                                            <th>
                                                <i  aria-hidden="true"></i>  Status
                                            </th>

                                        </tr>

                                    </thead>
                                    <tbody>
                                        <%int i = 0;%>
                                        <s:iterator value="coachDetailsList">
                                            <tr> 



                                                <%--                                            <td align="left"><s:property value="DATE"/></td>--%>
                                                <td align="left"><%=++i%></td>                              
                                                <%-- <td align="left"><a href="#" onclick="setCollegeDet('<s:property value="collegeCode"/>','<s:property value="CollegeName"/>','<s:property value="link"/>','<s:property value="location"/>')" data-toggle="modal" data-target="#myModal2" ><s:property value="collegeCode"/></a></td>--%>
                                                <td align="left"><a href="#" title="click to edit" onclick="setCoachDet('<s:property value="name"/>','<s:property value="title"/>','<s:property value="companyName"/>','<s:property value="areasOfExpertise"/>','<s:property value="status"/>','<s:property value="id"/>','<s:property value="email"/>','<s:property value="phoneNum"/>')" data-toggle="modal" data-target="#myModal2" ><s:property value="name"/></a></td>
                                                <%--                                                <td align="left"><s:property value="name"/></td>--%>
                                                <td align="left"><s:property value="email"/></td>
                                                <td align="left"><s:property value="phoneNum"/></td>
                                                <td align="left"><s:property value="title"/></td>

                                                <td align="left"><s:property value="companyName"/></td>
                                                <td align="left">
                                                    <a href="#" data-toggle="modal" data-target="#myModal" onclick="getAreaOfExpertiseDeta('<s:property value="areasOfExpertise"/>');">View</a>
                                                </td>
                                                <td align="left"><s:property value="status"/></td>

                                                <%--   <td align="left"><a href="<s:property value="Link"/>" target="blank"></a></td>--%>
                                                <%--<td align="left"><a href="<s:property value="link"/>" target="blank"><s:property value="link"/></a></td>--%>

                                                <%--                                            <td> <a href="#" data-toggle="modal" data-target="#myModal" onclick="getCollegeCoordinators('<s:property value="collegeId"/>','<s:property value="Code"/>','<s:property value="DATE"/>','<s:property value="location"/>');">Contact Details</a></td>--%>



                                                <%--<td align="left"><a class="btn btn-primary" href="<%=request.getContextPath()%>/general/leftMenuCollege.action?workshopCode=<s:property value="Code"/>">Enroll Topics</a></td>--%>

                                            </tr>
                                        </s:iterator>


                                    </tbody>
                                </table> 
                                        <s:hidden name="gridDownload" id="gridDownload" value="%{gridDownload}"/> 
                            </div>
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
            <!-- Modal  for add coach details start -->
               <div id="myModalCoach" class="modal fade" role="dialog">
                   <div class="modal-dialog" style="position:unset">

                    <!-- Modal content-->
                    <div class="modal-content ambassidor" style="margin-left: 43px;max-height: 600px;max-width: 561px">

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" onclick="reloadPageCoach();" style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">Add Coach Details</h3>

                        </div>
                        <div class="modal-body">

                            <div class="row" id="addCoachDetails">
                                <div class="alert alert-success" id="resultMessg" style="display: none;">
                                    <a href="#" class="close" onclick="closeAddCoachAlert();" aria-label="close">&times;</a>
                                    <strong><span id="addCoachDet"></span></strong> 
                                </div>
                                <div class="col-sm-12">


                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Name :
                                        </div>

                                        <div class="cal-sm-3">

                                            <s:textfield name="name" cssClass="form-control" id="name" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Email :
                                        </div>

                                        <div class="cal-sm-3">

                                            <s:textfield name="email" cssClass="form-control" id="email" value="" onblur="borderCssChange(this);return checkEmail(this);"/> 

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Phone Number :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="phoneNumber" cssClass="form-control" id="phoneNumber" value="+91" onchange="borderCssChange(this);return newFormatPhone(this);" onblur="return validatenumber(this);" onkeypress="return isNumberKey(event);" />

                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Title :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="title" cssClass="form-control" id="title" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>

                                    </div>  
                                            
                                     <div class="row">
                                        <div class="cal-sm-3">
                                            Company&nbsp;Name :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="existingCompanyName" cssClass="form-control" id="existingCompanyName" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>

                                    </div> 
                                      <div class="row">
                                        <div class="cal-sm-3">
                                            Area&nbsp;Of&nbsp;Expertise :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="areaOfExpertise" cssClass="form-control" id="areaOfExpertise" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>

                                    </div>   
                                          
                                      <div class="row">
                                        <div class="cal-sm-3">
                                            Status :
                                        </div>
                                        <div class="cal-sm-3">

                                            <%--  <s:textfield name="status" cssClass="form-control" id="status" value="" onchange="fieldLengthValidator(this);"/>--%>
                                             <s:select cssClass="form-control"  headerKey="-1" headerValue="---Please Select Status---" list="#@java.util.LinkedHashMap@{'Created':'Created','Approved':'Approved','Rejected':'Rejected'}"  id="status" name="status" value="" />
                                        </div>

                                    </div>       
                                    <div class="row">
                                        <button class="btn btn-primary col-sm-12" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." id="save" name="save" tabindex="12" type="save" value="save" onclick="getAddCoachDet();"> Save</button>
                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div>



            <!--Modal  for add coach details  end-->
            <!--modal for edit coach details start-->

            <div id="myModal2" class="modal fade" role="dialog" style="padding-right: 30px">
                <div class="modal-dialog" style="position:unset; margin-left: 338px;">

                    <!-- Modal content-->
                    <div class="modal-content ambassidor" style="margin-left: 43px;max-height: 600px;max-width: 561px">

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" onclick="reloadPageCoach();"  style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">Edit Coach Details</h3>

                        </div>
                        <div class="modal-body" >
                            <div class="row" id="editCoachmessg11"> 
                                <div class="alert alert-success" id="resultMessg1" style="display: none;">
                                    <a href="#" class="close" onclick="closeUpdateCoachAlert();" aria-label="close">&times;</a>

                                    <strong><span id="editCoachmessg1"></span></strong> 
                                </div>
                                <div class="col-sm-12">

                                    <div class="row">
                                        <s:hidden id="updateid" name="id"/>
                                        <div class="cal-sm-3" >
                                            Name :
                                        </div>

                                        <div class="cal-sm-3" >

                                            <s:textfield name="name" cssClass="form-control" id="updatename" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>
                                    </div>
                                     <div class="row">
                                        <s:hidden id="id" name="id"/>
                                        <div class="cal-sm-3" >
                                            Email :
                                        </div>

                                        <div class="cal-sm-3" >

                                            <s:textfield name="email" cssClass="form-control" id="updateemail" value="" onchange="borderCssChange(this);return checkEmail(this);" />

                                        </div>
                                    </div>       
                                       <div class="row">
                                        <div class="cal-sm-3">
                                            Phone Number :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="phoneNumber" cssClass="form-control" id="updatephoneNumber" value="" onchange="borderCssChange(this);return newFormatPhone(this);" onblur="return validatenumber(this);" onkeypress="return isNumberKey(event);" />

                                        </div>

                                    </div>      
                                    <div class="row">
                                        <div class="cal-sm-3" >
                                            Title :
                                        </div>

                                        <div class="cal-sm-3">

                                            <s:textfield name="title" cssClass="form-control" id="updatetitle" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Company Name :
                                        </div>
                                        <div class="cal-sm-3" >

                                            <s:textfield name="companyName" cssClass="form-control" id="updatecompanyName" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Area&nbsp;Of&nbsp;Expertise :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="areaOfExpertise" cssClass="form-control" id="updateareaOfExpertise" value="" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Status :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:select cssClass="form-control"  headerKey="-1" headerValue="" list="#@java.util.LinkedHashMap@{'Created':'Created','Approved':'Approved','Rejected':'Rejected'}"  id="updatestatus" name="status" value="" />

                                        </div>

                                    </div>

                                    <%--  <div class="row">
                                          <div class="cal-sm-3">
                                              Wcode :
                                          </div>
                                          <div class="cal-sm-3">

                                            <s:textfield name="wcode1" cssClass="form-control" id="wcode1" value="" />

                                        </div>

                                    </div>  --%>     

                                    <div class="row">
                                        <button class="btn btn-primary col-sm-12" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." id="edit" name="edit" tabindex="12" type="edit" value="edit" onclick="editCoachDetils();">Update</button>
                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div> 
            <!--modal for edit coach details end-->                    
            <!-- Alert modal Start -->                

            <!-- Alert modal end -->
            <div class="modal fade" id="myModalvalidationCoach" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" style="position:unset">
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

            <!--modal start for displaying area of expertise layout when we click view button-->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog" style="position:unset;">
                    <!-- Modal content-->
                    <div class="modal-content ambassidor" >

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">Area Of Expertise</h3>

                        </div>
                        <div class="modal-body">

                            <span  id="areaOfExpertiseInModal">
                               
                            </span>
                        </div>

                    </div>
                </div>
            </div>
            <!-- modal end for displaying area of expertise layout when we click view button -->
       
    </section>  <s:include value="../footer.jsp"/> 
</body>

</html>
