<!DOCTYPE html>
<html class="no-js"> 
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>


        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | Colleges 
        </title>
        <link href="css/font-awesome.min.css" rel="stylesheet">
 <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link  rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="table/jquery.min.js"></script> 
        <script src="table/jquery-ui.min.js"></script>
        <script type="text/javascript" src="table/paging.js"></script> 
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <style type="text/css">
            .backgroundImage {
                background-image: url("../img/headerimage.png");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;

            }
            .ga
            {
                color:#00aae7;
            }

            .backgroundImage {
                background-image: url("../img/headerimage.png");
                opacity: .8 !important;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;

            }


            .backgroundImage2 {
                background-image: url("../img/bg-ground1.jpg");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }

            .site-section-top {
                padding-top: 187px !important;}


        </style>
        <style type="text/css">
            #jquery-script-menu {
                position: fixed;
                height: 90px;
                width: 100%;
                top: 0;
                left: 0;
                border-top: 5px solid #316594;
                background: #fff;
                -moz-box-shadow: 0 2px 3px 0px rgba(0, 0, 0, 0.16);
                -webkit-box-shadow: 0 2px 3px 0px rgba(0, 0, 0, 0.16);
                box-shadow: 0 2px 3px 0px rgba(0, 0, 0, 0.16);
                z-index: 999999;
                padding: 10px 0;
                -webkit-box-sizing:content-box;
                -moz-box-sizing:content-box;
                box-sizing:content-box;
            }

            .jquery-script-center {
                width: 960px;
                margin: 0 auto;
            }
            .jquery-script-center ul {
                width: 212px;
                float:left;
                line-height:45px;
                margin:0;
                padding:0;
                list-style:none;
            }
            .jquery-script-center a {
                text-decoration:none;
            }

            .jquery-script-clear {
                clear:both;
                height:0;
            }
            .paging-nav {
                text-align: left;
                margin-top: 25px;
            }

            .paging-nav a {
                margin: auto 1px;
                text-decoration: none;
                display: inline-block;
                padding: 1px 7px;
                background: #91b9e6;
                color: white;
                border-radius: 3px;
            }

            .paging-nav .selected-page {
                background: #187ed5;
                font-weight: bold;
            }

            #tableData {
                width:100%;
                margin: 0 auto;
            }
            table,table tr,table td,th{
/*                width:100% !important;*/
            }
        </style>
        <script>
            $(document).ready(function () {


                // $("#compTypeSearchResults").DataTable();
              //  alert("kdfh");

                $('#tableData').DataTable({
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
    </head>
    <s:include value="header.jsp"/>
    <!--      <?php include 'header.php'; ?>-->
    <body>
        <div id="" class="boxed">
            <section class="site-section site-section-top site-section-light backgroundImage">
                <div class="">
                    <div class="push text-center">
                        <h1 class="animation-fadeInQuick2Inv"><strong>Associated Colleges</strong></h1>
                    </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

                    </div>
                </div>
            </section>
            <div class="container">
                <section class="site-section site-content border-bottom">

                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">
                            <!-- Partial Responsive Block -->
                            <div class="">
                                <table id="tableData" class="table table-striped table-borderless table-vcenter">
                                    <thead>
                                        <tr>
                                            <th ><i class="fa ga fa-university" aria-hidden="true"></i> &nbsp;College Name</th>
                                            <th><i class="fa ga fa-television" aria-hidden="true" ></i> &nbsp;Website</th>
                                            <th><i class="fa ga fa-location-arrow" aria-hidden="true"></i> &nbsp;Location</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%int i = 0;%>
                                        <s:iterator value= "collegeLocList">
                                           
                                              
                                                 <%  if (i % 2 == 0) {%> 
                                                    <tr style="background-color: #f9f9f9;">     
                                                    <% } else {%>
                                                    <tr class="info">                             
                                                    <%}%>
                                                

                                                <td>
                                                    <s:property value="collegeName"/>

                                                </td>
                                                <td >
                                                    <s:a href="%{website}" class="info" target="_blank" ><s:property value="website"/></s:a>
                                                    <%-- <td><s:a href="#" onclick="window.open('%{url}');"><s:property value="url" /></s:a></td>--%>

                                                </td>
                                                <td>
                                                    <s:property value="location"/>

                                                </td>
                                            </tr>
                                            <%i++;%>
                                        </s:iterator>

                                    </tbody>
                                </table>
                                <div class="row">
                                    <div class="col-sm-6" style="float:right !important;">
                                        <a href="../enroll.jsp">

                                            <button type="button" class="btn btn-info pull-right" style="margin-top:34px;"> 
                                                <font color="white" text-decoration="none">Do You Want to <strong>Enroll Your College </strong> Click Here !!</font></button></a>
                                    </div>
                                    <div class="col-sm-6">&nbsp;

                                        <!--                                      <script type="text/javascript" src="table/paging.js"></script> -->
                                        <script type="text/javascript">
                                            $(document).ready(function() {
                                                //  $('#tableData').paging({limit:10});
                                            });
                                        </script>
                                    </div>

                                </div>

                                <br>    <!-- END Partial Responsive Content -->

                            </div>

                            <br><br><br>    <!-- END Partial Responsive Block -->
                        </div>
                        <div class="col-sm-1"></div>

                    </div>
                </section>
            </div>
        </div>

        <a href="#" id="to-top"><i class="fa fa-arrow-up"></i></a>

        <!--  <?php include 'footer.php'; ?>-->
        <s:include value="footer.jsp"/> 
    </body>
</html>
