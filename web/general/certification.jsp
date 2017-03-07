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

        <script type="text/JavaScript" src="<s:url value="/js/ajaxUtil.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
        <script type="text/JavaScript" src="<s:url value="/js/McertificationAjax.js"/>"></script>
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
                       
                        <!--sidebar end-->

                        <div class="row  tab-pane active" id="Certification"> 
                            <b>Name:&nbsp;&nbsp;&nbsp;</b><b><s:property value="#session.fullname"/></b>
                            <table class="table table-hover table-striped">
                        <thead>
                            <tr>
                            <%--  <th>ConsultantId</th> --%>
                              <th>ExamName</th>
                              <th>Total Questions</th>
                              <th>Attempted Questions</th>
                              <th>Marks</th>
                              <th>DateSubmitted</th>
                              <th>ExamStatus</th>
                              
                            </tr>

                        </thead>
                        <tbody>
                            
                                    
                            <s:iterator value="#request.currentExamReviewCollection">
                        <tr> 
 <%-- <%
                                        String examKeyId = request.getAttribute("examKeyId").toString();
                                        %>
                 
                          <td><a href="javascript:showDetailResult('<%=examKeyId%>');" ><s:property value="mcertLoginId"/></a></td>  --%>
                            <td align="left"><s:property value="examTypeName"/></td>
                            <td align="left"><s:property value="totalQuestions"/></td>
                            <td align="left"><s:property value="attemptedQuestions"/></td>
                            <td align="left"><s:property value="marks"/></td>
                                        <td align="left"><s:property value="dateSubmitted"/></td>
                                       <td align="left"><s:property value="examStatus"/></td>
                        </tr>
                    </s:iterator>
                        </tbody>
                    </table>
                            
                            
                            
                            
                            

                        </div>
                    </div> 
                </div>
            </div>
            <br>

            <!-- Reference: https://github.com/ashleydw/lightbox/ -->

            



            <!--sidebar-->


            <br><br><br>
            
            
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
            
            
            
            <!-- Modal -->
        </div>
    </section>  <s:include value="../footer.jsp"/> 
</body>

</html>