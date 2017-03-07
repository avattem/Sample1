<%-- 
    Document   : college
    Created on : Jun 27, 2016, 2:10:43 PM
    Author     : miracle
--%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
    <!--<![endif]-->
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>AP Cloud Initiative</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta content="Provided is the list of colleges for which we are committed to train the current & future IT professionals with the Required Digital Transformation skills." name="Description">

        <!--    <link href="css/bootstrap.min.css" rel="stylesheet">
                <link href="css/font-awesome.min.css" rel="stylesheet">
                <link href="css/main.css" rel="stylesheet">
                <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
                <link rel="stylesheet" type="text/css" href="css/default.css"/>
                <link rel="stylesheet" type="text/css" href="css/component.css"/>-->
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/main.css"/>">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/default.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/component.css"/>">
        <script src="js/modernizr.custom.js"></script>
        
        
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.ico">
         <script type="text/JavaScript" src="<s:url value="/js/custom.js"/>"></script>
  <style type="text/css">
           .backgroundImage {
            background-image: url("../img/headerimage.png");
           -webkit-background-size: cover;
              -moz-background-size: cover;
              -o-background-size: cover;
              background-size: cover;
               
           }
          
        </style>
		
    </head>
    <s:include value="header.jsp"/>  

    <body  onload="getCollegeAndLoc()">
        
         <section class="site-section site-section-top site-section-light themed-background-dark-default backgroundImage">
                
                    <div class="push text-center">
                       <h1 class="animation-fadeInQuick2Inv"><strong>AP Cloud Initiative</strong></h1>
                        </div>
                    <div class="site-promo-img visibility-none" data-toggle="animation-appear" data-animation-class="animation-slideUpQuick" data-element-offset="0">
                        
                    </div>
                
            </section>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 text-left">
                    <h1 class="heavy">

                        Colleges

                    </h1>

                </div>

                <div class="col-sm-6 text-right">
                    <ul class="breadcrumb pull-right">

                        <li>
                            <a href="../home.action">
                                AP Cloud
                            </a>
                        </li>
                        <li class="active">
                            Colleges
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
           
                <div class="col-sm-12">
                    <p>We are now committed to ensuring that the Required Digital Transformation skills are provided to all of the Current and the Future Software Professionals studying in the following colleges</p>
                    <form method="post" action="" id="myForm">
                        <br>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <s:hidden id="coleLoc" value="%{collegeString}"/>
                                    <div id="collegeLocations">
                                    </div>

                                </div>

                            </div>

                        </div>







                    </form>

                </div>
              

            </div>


        </div>


        <br><br><br>
    </body>
    <s:include value="footer.jsp"/> 
</html>
