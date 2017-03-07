<%-- 
    Document   : ResetUserPassword
    Created on : sep 15, 2016, 4 PM
    Author     : miracle
--%>

<%@page import="com.mss.apcloud.util.AppConstants"%>
<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title> 
            AP Cloud Initiative | Reset user Password
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
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js?version=1.0"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
         <script src="<s:url value="/js/vendor/jquery-2.2.0.min.js"/>"></script> 
                    <script src="<s:url value="/js/vendor/bootstrap.min.js"/>"></script>
                    <script src="<s:url value="/js/plugins.js"/>"></script>
                    <script src="<s:url value="/js/app.js"/>"></script>
                    <!-- image carousel js-->
                    <script src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="<s:url value="/js/vendor/modernizr-2.8.3.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/Validation.js?version=1.0"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
     
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
<!--            <style>
            .embed-container embed{border-radius:0px !important;}
            h4 {font-size:14px !important;font-weight:bold;}
            .modal-footer{ margin:0px 5px 5px 0px !important;}
            .modal-content{width:800px;margin-left:-110px;margin-top:10px;height:550px;}
            .on-load-modal-content{background-color: #fff; width:400px;height:150px;}
        </style>-->
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

        <script type="text/javascript">
            //    $(window).load(function(){
            //        $('#mainModal').modal('show');
            //    });
        </script>
 <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>AP Cloud Initiative</strong></h1>
                        </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">
                        
                    </div>
                
            </section>
        <section class="" id="portfolio">
          
		

            <div class="row ">
                <div class="col-sm-2"> 
                  
                    <s:include value="LeftMenu.jsp"/>  
                </div>
               
                <br>

                 <div class="col-sm-10">
                    <!--sidebar end-->
                    <div class="tab-content">
                        <div class="row  tab-pane active" id="ResetPassword">
                            

                           <s:form action="resetUserPasswordSubmit.action" name="resetForm" theme="simple" onsubmit="return resetuserPwd();">
                               <%
                                if (request.getAttribute(AppConstants.RESULT_MESSAGE) != null) {
                                    out.println(request.getAttribute(AppConstants.RESULT_MESSAGE));
                                }
                            %> 
                               <br>
                                
                                <div class="row">
                            <!--copy 1 from contact first row starts-->
                            <div class="col-sm-2">  <label>User&nbsp;Id</label></div>
                            <div class="col-sm-5">
                                <div class="form-group">

                                  <%--  <s:textfield cssClass="form-control" placeholder="Email*" name="emailid" id="emailid" required="required"  onchange="checkEmail(this);borderCssChange(this);" /> --%>
                                    
                                      <s:textfield cssClass="form-control" id="userId" name="userId" placeholder="email*" required="required"  onchange="fieldLengthValidator(this);borderCssChange(this);"  />
                                </div>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2"><label> New Password</label></div>
                            <div class="col-sm-5">
                                <div class="form-group">

                                    <s:password cssClass="form-control" id="newPassword" name="newPassword" placeholder="Password*" required="required" onchange="fieldLengthValidator(this);borderCssChange(this);"  />
                                </div>
                            </div>
                        </div>
                                
                          <div class="row">
                            <div class="col-sm-2"><label> Confirm Password</label></div>
                            <div class="col-sm-5">
                                <div class="form-group">

                                    <s:password cssClass="form-control" id="confirmPassword" name="confirmPassword" placeholder="Password*" required="required" onchange="fieldLengthValidator(this);borderCssChange(this);"  />
                                </div>
                            </div>
                        </div>
                                
                        <div>    
                            
                        </div>
                        <!--copy 1 from contact first row ends-->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <s:submit cssClass="btn btn-primary col-sm-7" id="btnSubmit" name="btnSubmit" tabindex="12" value="submit" type="submit"> </s:submit>
                                    </div>
                                </div>
                            </div>
                            </s:form>
                           

                        </div> 
                    </div>
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

                <div class="col-sm-1"></div>
               
            </div>
                

            <!--sidebar-->


            <br><br><br> <br><br><br><br><br><br><br>
            
        </section>  <s:include value="footer.jsp"/> 
    </body>

</html>




