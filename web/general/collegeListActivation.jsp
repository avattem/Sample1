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
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js?version=1.0"/>"></script>
        
        
       
 <script>
            $(document).ready(function () {


                // $("#compTypeSearchResults").DataTable();
              //  alert("kdfh");

                $('#collegelist').DataTable({
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
            $( function() {
                $( "#frmDate" ).datepicker();
            
                $( "#toDate" ).datepicker();
            } );


 
        </script>


        <script type="text/javascript">
                 function showAlertModal(msg)
            {
                //alert(msg);
                document.getElementById('showAlertText').innerHTML = msg;
                $('#myModalvalidation').modal('show');
                return false;
            }
      
            function isUrlEdit(obj) {
                var  url_validate = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
                if(!url_validate.test(obj.value)){
    
                    document.getElementById("resultMessg1").style.display='block';
                    document.getElementById("editCollegemessg1").innerHTML='<div class="cal-sm-3">  Invalid Url</div>';
                    
                    obj.value = '';
                }
            }
            
            function IsValidPassword(element)
{
    
        $(element).keydown(function(e) {
            if (e.keyCode == 32){ // 32 is the ASCII value for a space
                showAlertModal("The Password field does not allow spaces");
                 element.value="";
                e.preventDefault();
            }
        });
   
}
        </script>

        <script>
            function doEditCollegeDet(){
                
                window.location="editCollegeDet.action";
                
            }
        </script>
 <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>Colleges List</strong></h1>
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
                            <s:form name="leftMenuColl" action='../general/leftMenuCollege.action' method="post"  theme="simple" onsubmit="return dateComparision();">
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
                                          
                                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="">Add</a>
                                        </div>
                                    </div>
                                        <div class="col-sm-1" >
                                        <div class="form-group">
                                          
                                            <a href="#" class="btn btn-primary" onclick="generateCollegeExcel();">ExportExcel</a>
                                        </div>
                                    </div> 
                                         <!-- <div class="col-sm-1" >
                                        <div class="form-group">
                                          
                                            <a href="#" class="btn btn-primary" onclick="generateCollegeExcel();">ExportExcel</a>
                                        </div>
                                    </div> -->
                                </div>
                            </s:form>

                            <div class="row">
                                <table class="table t_st03" id="collegelist">
                                    <thead>
                                        <tr>

                                            <th>
                                                <i class="fa fa-barcode" aria-hidden="true"></i>&nbsp;  Sno
                                            </th>
                                            <th>
                                                <i class="fa fa-barcode" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp; College Code
                                            </th>
                                            <th>
                                                <i class="fa fa-university" aria-hidden="true"></i> College Name
                                            </th>
                                            <th>
                                                <i class="fa fa-barcode" aria-hidden="true"></i>  Code
                                            </th>
                                            <th>
                                                <i class="fa fa-location-arrow" aria-hidden="true"></i>  Location
                                            </th>
                                            <th>
                                                <i class="fa fa-location-arrow" aria-hidden="true"></i>  Web Site
                                            </th>


                                        </tr>

                                    </thead>
                                    <tbody>
                                        <%int i=0;%>
                                        <s:iterator value="collegeMenuList">
                                            <tr> 



                                                <%--                                            <td align="left"><s:property value="DATE"/></td>--%>
                                                    <td align="left"><%=++i%></td>                              
                                                    <td align="left"><a href="#" onclick="setCollegeDet('<s:property value="collegeCode"/>','<s:property value="CollegeName"/>','<s:property value="link"/>','<s:property value="location"/>')" data-toggle="modal" data-target="#myModal2" ><s:property value="collegeCode"/></a></td>
                                                                                                <td align="left"><s:property value="CollegeName"/></td>
                                                                                                <td align="left"><s:property value="Code"/></td>
                                                                                                <td align="left"><s:property value="location"/></td>
                                                <%--   <td align="left"><a href="<s:property value="Link"/>" target="blank"></a></td>--%>
                                                <td align="left"><a href="<s:property value="link"/>" target="blank"><s:property value="link"/></a></td>

                                                <%--                                            <td> <a href="#" data-toggle="modal" data-target="#myModal" onclick="getCollegeCoordinators('<s:property value="collegeId"/>','<s:property value="Code"/>','<s:property value="DATE"/>','<s:property value="location"/>');">Contact Details</a></td>--%>



                                                <%--<td align="left"><a class="btn btn-primary" href="<%=request.getContextPath()%>/general/leftMenuCollege.action?workshopCode=<s:property value="Code"/>">Enroll Topics</a></td>--%>

                                            </tr>
                                        </s:iterator>


                                    </tbody>
                                </table> 
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
            <!-- Modal -->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog" style="position:unset">

                    <!-- Modal content-->
                    <div class="modal-content ambassidor" style="margin-left: 43px;max-height: 600px;max-width: 561px">

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" onclick="reloadPage();" style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">Add College Details</h3>

                        </div>
                        <div class="modal-body">

                            <div class="row" id="collegeRegDetails">
                                <div class="alert alert-success" id="resultMessg" style="display: none;">
                                    <a href="#" class="close" onclick="closeAlert();" aria-label="close">&times;</a>
                                    <strong><span id="addCollegeMessg"></span></strong> 
                                </div>
                                <div class="col-sm-12">


                                    <div class="row">
                                        <div class="cal-sm-3">
                                            College Code :
                                        </div>

                                        <div class="cal-sm-3">

                                            <s:textfield name="collegeCode" cssClass="form-control" id="collegeCode" value="" onchange="fieldLengthValidator(this);"/>

                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            College Name :
                                        </div>

                                        <div class="cal-sm-3">

                                            <s:textfield name="collegeName" cssClass="form-control" id="collegeName" value="" onchange="fieldLengthValidator(this);"/>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="cal-sm-3">
                                            WebSite :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="webSite" cssClass="form-control" id="webSite" value="" onchange="fieldLengthValidator(this);isUrl(this);" />

                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Location :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="location" cssClass="form-control" id="location" value="" onchange="fieldLengthValidator(this);"/>

                                        </div>

                                    </div>       
                                    <div class="row">
                                        <button class="btn btn-primary col-sm-12" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." id="save" name="save" tabindex="12" type="save" value="save" onclick="getAddCollegeDet();"> Save</button>
                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div>



            <!--modal end-->


            <div id="myModal2" class="modal fade" role="dialog" style="padding-right: 30px">
                <div class="modal-dialog" style="position:unset; margin-left: 338px;">

                    <!-- Modal content-->
                    <div class="modal-content ambassidor" style="margin-left: 43px;max-height: 600px;max-width: 561px">

                        <div style="background-color:#0096DE;border-bottom:1px solid #fff" class="modal-header">
                            <button data-dismiss="modal" onclick="reloadPage();"  style="color:#fff; opacity: 1;" class="close" type="button">×</button>
                            <h3 name="titleName" id="titleName" class="heavy modal-title">Edit College Details</h3>

                        </div>
                        <div class="modal-body" >
                            <div class="row" id="editCollegeRegDetails">
                                <div class="alert alert-success" id="resultMessg1" style="display: none;">
                                    <a href="#" class="close" onclick="closeAlert1();" aria-label="close">&times;</a>

                                    <strong><span id="editCollegemessg1"></span></strong> 
                                </div>
                                <div class="col-sm-12">

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            College Code :
                                        </div>

                                        <div class="cal-sm-3">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value=""  onchange="fieldLengthValidator(this);"/>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="cal-sm-3">
                                            College Name :
                                        </div>

                                        <div class="cal-sm-3">

                                            <s:textfield name="collegeName1" cssClass="form-control" id="collegeName1" value="" onchange="fieldLengthValidator(this);"/>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="cal-sm-3">
                                            WebSite :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="webSite1" cssClass="form-control" id="webSite1" value="" onchange="fieldLengthValidator(this);isUrlEdit(this);"/>

                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="cal-sm-3">
                                            Location :
                                        </div>
                                        <div class="cal-sm-3">

                                            <s:textfield name="location1" cssClass="form-control" id="location1" value="" onchange="fieldLengthValidator(this);"/>

                                        </div>

                                    </div>

                                    <%--  <div class="row">
                                          <div class="cal-sm-3">
                                              Wcode :
                                          </div>
                                          <div class="cal-sm-3">

                                            <s:textfield name="wcode1" cssClass="form-control" id="wcode1" value="" />

                                        </div>

                                    </div>    --%>        
                                    <div class="row">
                                        <button class="btn btn-primary col-sm-12" data-loading-text="<i class='fa fa-spinner fa-spin '></i> loading..." id="edit" name="edit" tabindex="12" type="edit" value="edit" onclick="editCollegeDet();">Update</button>
                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div>
                                    
                    <!-- Alert modal Start -->                
                                    <div class="modal fade" id="myModalvalidation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
<!-- Alert modal end -->
                                    
                                    
        </div>
    </section>  <s:include value="../footer.jsp"/> 
</body>

</html>
