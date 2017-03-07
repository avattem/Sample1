<%-- 
    Document   : schedule
    Created on : Jun 27, 2016, 2:13:41 PM
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
    <title>AP Cloud Initiative | Exam Instruction</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

	<meta content=" Don't miss any of our workshops at your location or college. Here is the list of the scheduled workshops enclosed with all the complete details." name="Description">
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

<body>
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
                    
              Instructions
        
                    </h1>
                     
                </div>
               
                <div class="col-sm-6 text-right">
                    <ul class="breadcrumb pull-right">
                       
                        <li>
                            <a href="certification.action">
                            Certifications
                            </a>
                        </li>
                        <li class="active">
                          Instructions
                        </li>
                    </ul>
                </div>
                </div>
         
      
       <div class="row">
           <div class="col-sm-12">
           <iframe src="http://www.miraclesoft.com/Hubble/mcertification/mcertLoginCheck.action?empId=<s:property value="%{userId}"/>&examTypeId=<s:property value="%{examId}"/>" style="width: 100%; height: 750px"
scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0">
</iframe>  
           <%--   <iframe src="http://172.17.12.234:8084/Hubble/mcertification/mcertLoginCheck.action?empId=<s:property value="%{userId}"/>&examTypeId=<s:property value="%{examId}"/>" style="width: 100%; height: 750px"
scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0">
</iframe> --%>
           </div>
       </div>
      

 


                </div>
        
  

</body>

 <s:include value="footer.jsp"/> 
</html>
