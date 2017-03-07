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

                $('#enrollcollegelist').DataTable({
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
            
            var addSerialNumber = function () {
                var i = 0
                $('idd').each(function(index) {
                    $(this).find('td:nth-child(1)').html(index-1+1);
                });
            };


        </script>
        <script>
            function generateExportExcelSheet(){
                var exportExcelSheet;
                var gridDownload=document.getElementById('gridDownload').value; //gridDownload
                // alert(gridDownload);
                var url= "exportEnrollExcelSheet.action?gridDownload="+gridDownload+"&enrollExcelSheet="+exportExcelSheet; //gridDownload
    
                //   alert(url);
                window.location=url;
                    
            }
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
                       <h1 class="animation-fadeInQuick2Inv"><strong>Enrolled Colleges List</strong></h1>
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
                            <s:form name="enrollLeftMenuColl" action='../general/enrollLeftMenuCollege.action' method="post"  theme="simple" onsubmit="return dateComparision();">
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

                                            <s:textfield name="frmDate" id="frmDate" placeholder="From Date" cssClass="form-control col-sm-12" value="" />
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <s:textfield name="toDate" id="toDate" placeHolder="To Date" cssClass="form-control col-sm-12" value="" />
                                        </div>
                                    </div>
                                    <div class="col-sm-1" style="margin-left: 251px">
                                        <div class="form-group">
                                            <s:submit cssClass="btn btn-primary col-sm-0" id="Search" name="Search" tabindex="12" type="Search" value="Search" />
                                        </div>

                                    </div>



                                    <div class="col-sm-1" style="margin-left: 4px">
                                        <div onclick="generateExportExcelSheet()"  class="btn btn-primary col-sm-0">&nbsp;ExportToExcel</div>
                                    </div>


                                    <%-- <div class="col-sm-1" style="margin-left: 4px">
                                <div class="form-group">
                                    <s:submit cssClass="btn btn-primary col-sm-0" id="exportToExcel" name="exportToExcel" tabindex="12" type="exportToExcel" value="ExportToExcel" onclick="generateExportExcelSheet()"/>
                                </div>

                                    </div>  --%>  

                                </div>
                            </s:form>
                            <div class="row">
                                <table class="table t_st03" id="enrollcollegelist">
                                    <thead>
                                        <tr>

                                            <th>

                                                <i class="fa fa-barcode" aria-hidden="true" name="id" id="id"></i>&nbsp;  Sno
                                            </th>
                                            <th>
                                                <i class="fa fa-barcode" aria-hidden="true"></i> College Code
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
                                            <th>
                                                <img src="../images/Students-256.png" style="max-width: 35px;max-height: 26px">  <i   aria-hidden="true"></i>  Ambassadors
                                                </img>
                                            </th>
                                            <!--                                            <th>
                                                                                            <i class="fa fa-location-arrow" aria-hidden="true"></i>  Student
                                                                                        </th>-->
                                        </tr>

                                    </thead>
                                    <tbody>
<%int i=0;%>
                                        <s:iterator value="enrollCollegeMenuList">

                                            <tr> 



                                                <td align="left" ><%=++i%></td>
                                                <%--<td align="left"><s:property value="DATE"/></td>--%>
                                                <%--<td align="left"><s:property value="collegeCode"/></a></td>--%>
                                                <td align="left" style="margin-left: 20px"><s:property value="collegeCode"/></td>
                                                <td align="left"><s:property value="CollegeName"/></a></td>
                                                <td align="left"><s:property value="Code"/></td>
                                                <td align="left"><s:property value="location"/></td>
                                                <%--   <td align="left"><a href="<s:property value="Link"/>" target="blank"></a></td>--%>
                                                <td align="left"><a href="<s:property value="link"/>" target="blank"><s:property value="link"/></a></td>
                                                <%--<td align="left"><s:property value="facultyName"/></td>--%>
                                                <td> <a href="#" data-toggle="modal" data-target="#myModal" onclick="getEnrollCollegeCoordinators('<s:property value="collegeId"/>');">Contact Details</a></td>


                                                <%-- <td> <a href="#" data-toggle="modal" data-target="#myModal" onclick="getCollegeCoordinators('<s:property value="collegeId"/>','<s:property value="Code"/>','<s:property value="DATE"/>','<s:property value="location"/>');">Contact Details</a></td>--%>

                                                <%--<td align="left"><a class="btn btn-primary" href="<%=request.getContextPath()%>/general/leftMenuCollege.action?workshopCode=<s:property value="Code"/>">Enroll Topics</a></td>--%>
                                                <%-- <td align="left"><a href="#" title="click to edit" onclick="setCollegeDet('<s:property value="collegeCode"/>','<s:property value="CollegeName"/>','<s:property value="link"/>','<s:property value="location"/>')" data-toggle="modal" data-target="#myModal2" ><s:property value="collegeCode"/></a></td> --%>
                                            </tr>
                                           
                                        </s:iterator>
                                       

                                    </tbody>
                                </table> 
                                        <s:hidden name="gridDownload" id="gridDownload" value="%{gridDownload}"/>
                            </div>

                        </div>
                        <!--sidebar end-->
                    </div> 
                </div>
            </div>
            <br>

            <!-- Reference: https://github.com/ashleydw/lightbox/ -->

            <link type="text/css" href="webinar.css">
            <br><br><br>
            <!--model for faculty -->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog" style="position:unset;">

                    <!-- Modal content-->
                    <div class="modal-content ambassidor" style="margin-left: -57px;margin-top: -29px;max-width: 811px;margin-bottom: 500px">
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




            <!-- Modal -->

            <!--modal end-->

        </section>  <s:include value="../footer.jsp"/> 
    </body>

</html>