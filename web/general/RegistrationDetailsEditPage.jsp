
<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>
            AP Cloud Initiative | Registration Details Edit Page 
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
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
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
    </head><!--/head-->
    <s:include value="../header.jsp"/>  
    <body onload="getRegBranch('onload');">
        <%-- <script>
            function isUrlEdit(obj) {
                var  url_validate = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
                if(!url_validate.test(obj.value)){
    
                    document.getElementById("resultMessg1").style.display='block';
                    document.getElementById("editRegistrationmessg1").innerHTML='<div class="cal-sm-3">  Invalid Url</div>';
                    
                    obj.value = '';
                }
            }
        </script> --%>



        <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">

            <div class="push text-center">
                <h1 class="animation-fadeInQuick2Inv"><strong>AP Cloud Initiative</strong></h1>
            </div>
            <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">

            </div>

        </section>
        <section class="" id="portfolio">  
            <div id="resultMessage1"  style="display: none;">
                <span id ="resultMessage1" ></span>
            </div>
            <div class="row ">
                <div class="col-sm-2"> 

                    <s:include value="../LeftMenu.jsp"/>  
                </div>   

                <div class="col-sm-10">
                    <div class="row">
                        <s:if test="%{resultMessage == 'success'}">
                            <div class="alert alert-success">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Successfully Updated</strong> 
                            </div>
                        </s:if>
                    </div>
                    <!--sidebar end-->
                    <div class="tab-content">
                        <div class="row  tab-pane active" id="Myprofile">

                            <table style="margin:0 0 29px"> <tr><th class="p_tit"><i class="fa fa-minus" aria-hidden="true"></i> Edit Registration Details </th></tr></table>
                            <s:form method="post" theme="simple" action="updateRegistrationDetails.action" id="myForm" onsubmit="return registrationEditValidation();">
                                <br>
                                <div class="row">
                                    <div class="col-sm-4">

                                        <s:hidden name="userId" id="userId"/>

                                        <div class="form-group">
                                            First&nbsp;Name :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:textfield name="fname" cssClass="form-control" id="fname" value="%{generalVTO.fname}"  onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>

                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            Last&nbsp;Name :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:textfield name="lname" cssClass="form-control" id="lname" value="%{generalVTO.lname}" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>

                                        </div>
                                    </div>       

                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            Email :
                                        </div>

                                        <div class="form-group">

                                            <s:textfield name="email" cssClass="form-control" id="email" value="%{generalVTO.email}" onchange="borderCssChange(this);return checkEmail(this);"/>

                                        </div>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-sm-4">



                                        <div class="form-group">
                                            Phone&nbsp;Number :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:textfield name="phoneNumber" cssClass="form-control" id="phoneNumber" value="%{generalVTO.phoneNumber}" onchange="borderCssChange(this);return formatPhone(this);" onblur="return validatenumber(this);" onkeypress="return isNumberKey(event)"/>

                                        </div>
                                    </div>

                                    <s:if test="profession==1">     
                                        <s:hidden name="profession" id="profession" value="1"/>     
                                        <div class="col-sm-4" >
                                            <div class="form-group">
                                                College/Company :
                                            </div>

                                            <div class="form-group">

                                                <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                                <s:select name="collegeName" cssClass="form-control" id="collegeName" list="collegeMap"  value="%{generalVTO.collegeName}"  onchange="fieldLengthValidator(this);borderCssChange(this);"/>
                                            </div>
                                        </div>       



                                    </div> 
                                    <div class="row" >


                                        <div class="col-sm-4" id="branchdiv" >
                                            <div class="form-group">
                                                Branch :
                                            </div>

                                            <div class="form-group" >
                                                <s:hidden id="branchHiddenValue" value="%{generalVTO.branch}"/>
                                                <s:select cssClass="form-control" id="branch" name="branch"  list="#@java.util.LinkedHashMap@{'ECE':'ECE','EEE':'EEE','CSE':'CSE','IT':'IT','MCA':'MCA','Others':'Others'}" value="%{generalVTO.branch}" onchange="getRegBranch('onchange');">
                                                </s:select>
                                            </div>


                                        </div>  

                                        <div class="col-sm-3" id="branchOtherDiv" style="display: none">
                                            <div class="form-group">
                                                Other&nbsp;Branch :
                                            </div>
                                            <div class="form-group">

                                                <s:textfield cssClass="form-control"  id="frmOtherBranch" name="frmOtherBranch" value="%{generalVTO.frmOtherBranch}" onchange="borderCssChange(this);fieldLengthValidator(this);"/>

                                            </div>
                                        </div>


                                        <div class="col-sm-4" >
                                            <div class="form-group" >
                                                Year :
                                            </div>
                                            <div class="form-group" >
                                                <s:select name="year" cssClass="form-control" id="year" list="#@java.util.LinkedHashMap@{'1st year':'1st year','2nd year':'2nd year','3rd year':'3rd year','4th year':'4th year'}" value="%{generalVTO.year}" onchange="borderCssChange(this);fieldLengthValidator(this);">
                                                </s:select>
                                            </div>
                                        </div>

                                    </div>       




                                </s:if>
                                <s:elseif test="profession==2">

                                    <s:hidden name="profession" id="profession" value="2"/> 

                                    <div class="col-sm-4" id="employeeDiv" >
                                        <div class="form-group">
                                            Organisation :
                                        </div>
                                        <div class="form-group"> 

                                            <s:textfield cssClass="form-control"  id="frmCompany" name="frmCompany" value="%{generalVTO.frmCompany}" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>

                                        </div>
                                    </div>
                                    <div class="col-sm-4" id="designationDiv" >
                                        <div class="form-group">
                                            Designation :
                                        </div>
                                        <div class="form-group">

                                            <s:textfield cssClass="form-control"  id="frmDesignation" name="frmDesignation" value="%{generalVTO.frmDesignation}" onchange="borderCssChange(this);fieldLengthValidator(this)"/>

                                        </div>
                                    </div>  
                                </s:elseif>
                                <s:elseif test="profession==3">
                                    <s:hidden name="profession" id="profession" value="3"/>     
                                    <div class="col-sm-4" >
                                        <div class="form-group">
                                            College/Company :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:select name="collegeName" cssClass="form-control" id="collegeName" list="collegeMap"  value="%{generalVTO.collegeName}"  onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            College&nbsp;Id :
                                        </div>
                                        <div class="form-group">
                                            <s:textfield cssClass="form-control"  id="collegeCode" name="collegeCode"  value="%{generalVTO.collegeCode}" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                        </div>

                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            Code :
                                        </div>
                                        <div class="form-group">
                                            <s:textfield cssClass="form-control" id="code" name="code"  value="%{generalVTO.code}" onchange="borderCssChange(this);fieldLengthValidator(this);"/>
                                        </div>

                                    </div> 
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            Location :
                                        </div>
                                        <div class="form-group">
                                            <s:textfield cssClass="form-control" id="location" name="location"  value="%{generalVTO.location}" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>
                                        </div>

                                    </div>
                                </s:elseif>
                                <s:if test="profession==3">

                                </s:if>
                                <s:else>



                                    <div class="col-sm-4" >



                                        <div class="form-group" >
                                            Face&nbsp;Book&nbsp;Profile :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:textfield name="fbprofile" cssClass="form-control" id="fbprofile" value="%{generalVTO.fbprofile}" />

                                        </div>
                                    </div>

                                    <!--                                    <div class="row">-->


                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            Street :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:textfield name="street" cssClass="form-control" id="street" value="%{generalVTO.street}" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>

                                        </div>
                                    </div>       

                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            City :
                                        </div>

                                        <div class="form-group">

                                            <s:textfield name="city" cssClass="form-control" id="city" value="%{generalVTO.city}" onchange="borderCssChange(this);fieldLengthValidator(this);startingCapital(this);"/>

                                        </div>
                                    </div>

                                </div>

                                <div class="row">


                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            District :
                                        </div>

                                        <div class="form-group">

                                            <%-- <s:textfield name="collegeCode1" cssClass="form-control" id="collegeCode1" value="" readonly="true" onchange="fieldLengthValidator(this);"/>--%>
                                            <s:select name="district" list="districtIdList" cssClass="form-control" id="district" value="%{generalVTO.district}" onchange=""/>

                                        </div>
                                    </div> 
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            State :
                                        </div>

                                        <div class="form-group">

                                            <s:select name="state" cssClass="form-control" list="stateMap" id="state" value="%{generalVTO.state}" onchange=""/>

                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            Zip&nbspCode :
                                        </div>

                                        <div class="form-group">

                                            <s:textfield name="zipcode" cssClass="form-control" id="zipcode" value="%{generalVTO.zipcode}" onchange="borderCssChange(this);fieldLengthValidator(this);" onkeypress="return isNumberKey(event)"/>

                                        </div>
                                    </div>

                                </div>     

                            </s:else>


                        </div>
                        <div class="row" style="margin-left: 68%">
                            <s:submit  cssClass="btn btn-primary col-sm-12" tabindex="12" value="Update"/>
                        </div>
                    </s:form>



                </div> 
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

            </div>

            <!--        </div>   </div>   -->



            <br>

            <!-- Reference: https://github.com/ashleydw/lightbox/ -->

            <link type="text/css" href="webinar.css">



            <!--sidebar-->










            <!--  modal for edit end -->


        </section>  <s:include value="../footer.jsp"/> 
    </body>

</html>








