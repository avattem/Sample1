/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function checkLogin(loginId,password){

    //  document.getElementById("resultMessage").innerHTML='';
     
    closeErrorMsg();
    var xmlhttp;
                
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            //     document.getElementById("loading").style.display = 'none';
            $("#btnSubmit1").button('reset');
            var response=xmlhttp.responseText;
            //  alert(response);
            populateResults(response);
        //document.getElementById("posttype").innerHTML = xmlhttp.responseText;
        }else {
            //document.getElementById("loading").style.display = 'block';
            $("#btnSubmit1").button('loading');
        }
    }
    xmlhttp.open("GET","../classes/AjaxLogin.php?loginId="+loginId+"&password="+escape(password)+"&existed=0",true);
    xmlhttp.send();
 
   
        
}


function check(){
                
    
    var collegeName = document.getElementById("collegeName").value; 
                 
    var req;
                
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        req = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }              
                
    var url ="check.action?collegeName="+collegeName;
    req.onreadystatechange = function() {

        if (req.readyState == 4) {

            if (req.status == 200) {

                //alert(req.responseText); 
                if(req.responseText == "College Already enrolled")
                {
               
                    showAlertModal(req.responseText);
                    document.getElementById("collegeName").value="-1";    
             
                    $('#collegeid').val('');
              
               
                }

                                  
            }
           
        }
    };
    req.open("GET", url, "true");
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send(null);
}


function populateResults(res){
    if(res==200){
   
    
        document.getElementById("loginModalClosId").click();
    }else {
        //document.getElementById("resultMessage").innerHTML="<font color='red'>"+res+"</font>";
        displayErrorMessage(res);
    }

}


function getBodyContent(){

    var libId=document.getElementById("libId").value;
    ///alert(libId);
    if(libId!='0'){
        var xmlhttp;
                
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("loadingImage").style.display = 'none';
                var response=xmlhttp.responseText;
                // alert(response);
                populateBodyConetnt(response);
            //    document.getElementById("posttype").innerHTML = xmlhttp.responseText;
            }else {
                document.getElementById("loadingImage").style.display = 'block';
            }
        }
        xmlhttp.open("GET","../../classes/AjaxBodyContent.php?libId="+libId,true);
        xmlhttp.send();
 
    }
        
}
function populateBodyConetnt(res){
    //alert(res);
    var result = res.split("$#@");
   
    document.getElementById("pageContentId").innerHTML=result[0];
    document.getElementById("breadcomLabelId").innerHTML=result[1];
    document.getElementById("contentTitleId").innerHTML=result[2];
    if(result[7]==1){
        
        if(result[8]==1){
            // document.getElementById("downloadContentId").innerHTML="<a class=\"btn btn-primary btn-md\" href=\"../../resource/get-resource.php?refId="+result[3]+"&objectId="+result[4]+"\">Download Product Brief</a>";
            document.getElementById("downloadContentId").innerHTML="<a class=\"btn btn-primary btn-md\" href=\"../../download/DownloadDocs.php?refId="+result[3]+"&objectId="+result[4]+"\">Download "+result[9]+"</a>";
        }else {
            document.getElementById("isAuthorized").value=1;
            $('#myModal1').modal('hide');
            document.getElementById("downloadContentId").innerHTML="<a class=\"btn btn-primary btn-md\" href=\"../../download/DownloadDocs.php?refId="+result[3]+"&objectId="+result[4]+"\">Download "+result[9]+"</a>";
        }
         
    }
   
    
    document.getElementById("pageContentId2").innerHTML=result[5];
    document.getElementById("publishedDateLabelId").innerHTML=result[6];
   
}


function getAuthors() {
    var libId=document.getElementById("libId").value;
    ///alert(libId);
    if(libId!='0'){
        var xmlhttp;
                
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("loadingImage").style.display = 'none';
                var response=xmlhttp.responseText;
                // alert(response);
                populateAuthors(response);
            //   document.getElementById("posttype").innerHTML = xmlhttp.responseText;
            }else {
                document.getElementById("loadingImage").style.display = 'block';
            }
        }
        xmlhttp.open("GET","../../classes/AjaxLibraryAuthors.php?libId="+libId,true);
        xmlhttp.send();
 
    }
        
}


function populateAuthors(response){
   
    document.getElementById("authorsId").innerHTML=response;
}


function checkSurveyLogin(loginId,password){

    // alert("checkkkkkkkkkkkkkkkkk---------------------->");
    // document.getElementById("resultMessage").innerHTML='';
    closeErrorMsg();
       
    var xmlhttp;
                
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            //  document.getElementById("loading").style.display = 'none';
            $("#btnSubmit1").button('reset');
            var response=xmlhttp.responseText;
            populateSurveyResults(response);
            
        }else {
            //  document.getElementById("loading").style.display = 'block';
            $("#btnSubmit1").button('loading');
        }
    }
    xmlhttp.open("GET","../classes/AjaxLogin.php?loginId="+loginId+"&password="+escape(password)+"&existed=1",true);
    xmlhttp.send();       
}


function populateSurveyResults(res){

    var result = res.split("|");

    if(result[0]=="valid"){
        document.getElementById("loginModalClosId").click();
        document.getElementById("frmFullName").value=result[1]+" "+result[2];
        document.getElementById("frmPhone").value=result[3];
        document.getElementById("frmEmailId").value=result[4];
        if(result[6]==0 || result[6]=="" || result[6]==null )
        {
            document.getElementById("frmEmpNo").value="N/A";
        }else{
            document.getElementById("frmEmpNo").value=result[6];
        }
        document.getElementById("tempFrmFullName").value=result[1]+" "+result[2];
        document.getElementById("tempFrmPhone").value=result[3];
        document.getElementById("tempFrmEmailId").value=result[4];
        document.getElementById("tempFrmEmpNo").value=result[6];
    }else {
        //document.getElementById("resultMessage").innerHTML="<font color='red'>"+res+"</font>";
        displayErrorMessage(res);
    }

}

function checkEmployeeLogin(loginId,password){
    //alert("checkemployeelogin");
    document.getElementById("resultMessage").innerHTML='';
     
       
    var xmlhttp;
                
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("loading").style.display = 'none';
            var response=xmlhttp.responseText;
            //  alert(response);
            populateLoginResults(response);
        //document.getElementById("posttype").innerHTML = xmlhttp.responseText;
        }else {
            document.getElementById("loading").style.display = 'block';
        }
    }
    xmlhttp.open("GET","../classes/AjaxLogin.php?loginId="+loginId+"&password="+escape(password)+"&existed=0",true);
    xmlhttp.send();
 
}
function checkLibraryEmployeeLogin(loginId,password){
    //alert("checkemployeelogin");
    document.getElementById("resultMessage").innerHTML='';
     
       
    var xmlhttp;
                
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("loading").style.display = 'none';
            var response=xmlhttp.responseText;
            //  alert(response);
            populateLoginResults(response);
        //document.getElementById("posttype").innerHTML = xmlhttp.responseText;
        }else {
            document.getElementById("loading").style.display = 'block';
        }
    }
    xmlhttp.open("GET","../../classes/AjaxLogin.php?loginId="+loginId+"&password="+escape(password)+"&existed=0",true);
    xmlhttp.send();
 
}

function populateLoginResults(res){
    // alert(res);

    if(res==200){
        //document.getElementById("loginModalClosId").click();
        $("#myModal1").modal('hide');
        $("#myModal2").modal('hide');
    }else {
        document.getElementById("resultMessage").innerHTML="<font color='red'>"+res+"</font>";
    }

}


function displayErrorMessage(message){
    $("#resultMessage").html(message);
    $("#errorMsgDiv").show();
}
function closeErrorMsg() {
    $("#resultMessage").html("");
    $("#errorMsgDiv").hide();
}

function userExistance()
{
    
    if(($("#email").val()!=null&&$("#email").val()!='')&&($("#workPhone").val()!=null&&$("#workPhone").val()!=''))
    {
        //alert("111111111111");
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/userExistance?email='+$("#email").val()+'&phoneNumber='+$("#workPhone").val(),
						
            timeout : 60000
        }).success(function(data) {
            if(data.indexOf("exist")>0){
                showAlertModal(data);
                document.getElementById("btnSubmit").disabled = true;
            // alert("sample output data from pb -->"+data);
            }
            else
            {
                document.getElementById("btnSubmit").disabled = false;
            }
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
    }
}

function getDistrictsBasedOnStateId() {
  
    var stateId = document.getElementById("state").value;
    //alert("in js------------>"+stateId)
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getDistrictNames.action?stateID='+stateId,
						
        timeout : 60000
    }).success(function(data) {
				
        populateDistricts(data);
                               
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}


function populateDistricts(resXML) {    
    //   alert(resXML);
    var districtId = document.getElementById("district");
    var state = resXML.getElementsByTagName("STATE")[0];
    var districts = state.getElementsByTagName("DISTRICT");
    districtId.innerHTML=" ";
    // alert(districts.length);
    for(var i=0;i<districts.length;i++) {
        var districtName = districts[i];
        var att = districtName.getAttribute("districtId");
        //  alert(att);
        var name = districtName.firstChild.nodeValue;
        // alert(name);
        var opt = document.createElement("option");
        opt.setAttribute("value",att);
        opt.appendChild(document.createTextNode(name));
        districtId.appendChild(opt);
    }
}

function getCollegeCode(){
                
    document.getElementById("collegeid").value="";
    var collegeName = document.getElementById("collegeName").value; 
                 
    //  alert(collegeName);
    var req;
                
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        req = new XMLHttpRequest();
    }
    else {
        // code for IE6, IE5
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
                
                
    // var req = newXMLHttpRequest();
    var url ="getCollegeCodes.action?collegeId="+collegeName;
    req.onreadystatechange = function() {

        if (req.readyState == 4) {

            if (req.status == 200) {

                //  alert(req.responseText); //
                         
                document.getElementById("collegeid").value=req.responseText;
                check();
                            
            }
            else
            {
                alert("Error occured");
            }
        }
    };
    req.open("GET", url, "true");
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send(null);
	
	
                
} 

function initRequest(url) {
    if (window.XMLHttpRequest) {
        return new XMLHttpRequest();
    }
    else
    if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
    
}



function forgetPassword()
{     
    
    var emailForPass=document.getElementById('emailForPass').value;
    if($('#emailForPass').val()==""||$('#emailForPass').val()==null)
    {
        
        document.getElementById('resultMessage1').innerHTML = "<font color=\"red\" size=\"2.5\"> Enter Email Id.   </font>";
        $('#emailForPass').css("border", "1px solid red");
            
        return false;
    }
    if(emailForPass)
    { 
      
        var url='ajax/forgotPasswordSubmit.action?emailForPass='+emailForPass;  
        // document.getElementById('loadingMessage').innerHTML="<font color=\"blue\" size=\"2.5\"> loading...   </font>";
        //document.getElementById('Submitbutton').disabled=true;        
        var req = initRequest(url);
        req.onreadystatechange = function() {  
            $("#Submitbutton").button('loading');
      
            if (req.readyState == 4) {
                if (req.status == 200) {    
                       
                    forgotpasswordResponsehandler(req.responseText);  
                    $("#Submitbutton").button('reset');
                } 
            }
        };
        //  alert(url)
        req.open("GET",url,"true");
        req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        req.send(null);
    }
}









function forgotpasswordResponsehandler(response){      
    document.getElementById('loadingMessage').style.display = "none";    
    if(response=="mailsend")
    {
        document.getElementById('resultMessage1').innerHTML = "<font color=\"green\" size=\"2.5\"> Congrats! We have sent the password to your Official EmailId.   </font>";
     
        document.getElementById('Submitbutton').disabled=true;
    }
    else if(response=="TryAgain")
    {
        document.getElementById('resultMessage1').innerHTML = "<font color=\"red\" size=\"2.5\"> Please Try Again Later.   </font>";
        document.getElementById('Submitbutton').disabled=false;
    }
    else if(response=="nouserexisted")
    {
        document.getElementById('resultMessage1').innerHTML = "<font color=\"red\" size=\"2.5\"> Sorry! The given email id is not associated with any account in AP Cloud.Please enter valid email id. </font>";
        document.getElementById('Submitbutton').disabled=false;
    }
    else if(response=="databaseException")
    {
        document.getElementById('resultMessage1').innerHTML = "<font color=\"red\" size=\"2.5\"> DataBase Exception. </font>";
        document.getElementById('Submitbutton').disabled=false;
    }
    
}


function getRepoData(topicName,topicValue)
{
    
    // alert("ajax"+topicName+"------"+topicValue);
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getRepoData?topicValue='+topicValue+'&topicName='+topicName,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        // alert('success'+data);
        contentDisplay(data,topicName);
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}

function contentDisplay(data,topicName)
{
    
    var str='';
    var split1=data.split('^^^');
    
    
    for(var i=0;i<split1.length;i++){
        var split2=split1[i].split('@@@');
        var fileType=split2[1];
        if(fileType=='presentation'){
            //    str+='<input type="hidden" id="'+topicName+i+'" value="'+split2[1]+'">';
            str+='<div class="col-sm-4"><div class="thumbnail"><div class="caption"><iframe src="../images/'+topicName+'.png" width="100%" height="150" style="border:1px solid #000000" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>'
            str+='<h4><a href="#">'+split2[2]+'</a></h4><a href="#" class="btn btn-default" onclick="getDocumentfile(\''+split2[0]+'\');">Download</a></div></div></div>'
    
        }
    }
    document.getElementById("contentDisplay").innerHTML=str;
}


function getDocumentfile(fileId){
    //alert("------>"+fileId);
    window.location='ajax/getDocumentfile?fileId='+fileId;
//   $.ajax(
//    {
//        type : 'post',
//						
//        url : 'ajax/getDocumentfile?filePath='+filePath,
//        async: false,
//						
//        timeout : 60000
//    }).success(function(data) {
//        alert('success'+data);
//        contentDisplay(data,topicName);
//    }).error(function(x, t, m) {
//        if (t == "timeout") {
//            alert("time-->" + t);
//        } else {
//            alert("elese part timer");
//        }
//    });
    
}

function getCurriculam(workshopCode,collName,location)
{
    //alert(workshopCode);
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getCurriculam.action?workshopCode='+workshopCode,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        //alert('success'+data);
        curriculamData(data,workshopCode ,collName,location);
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}



function curriculamData(data,workshopCode,collName,location)
{
    //style="width:750px; height:300px; overflow:auto;" 
    var str='';
    var split1=data.split('^^^');
   
    document.getElementById('titleName').innerHTML=workshopCode+"&nbsp;&nbsp;in&nbsp;&nbsp;"+collName.replace(/&quot/g, "\'")+"&nbsp;&nbsp;("+location+")";
    str+='<table class="table  table-striped table-responsive"><thead><tr><th><i class="fa fa-calendar"></i>Date</th><th><i class="fa fa-clock-o"></i>Time</th><th><i class="fa fa-file-code-o"></i>Topic</th><th><i class="fa fa-file-code-o"></i>SubTopic</th> <th><i class="fa  fa-location-arrow"></i>Venue</th></tr></thead><tbody>'
    for(var i=0;i<split1.length-1;i++){
        var split2=split1[i].split('@@@');
        
        str+='<tr><td><span>'+split2[0]+'</span></td><td><span>'+split2[2]+'</span></td><td><span><a  href="'+CONTEXT_PATH+'/techdetails.action?topicId='+split2[3]+'" target="blank">'+split2[1]+'</span></td><td><span>'+split2[4]+'</span></td><td><span>'+split2[5]+'</span></td></tr>';
    
        
    }
    str+='</tbody></table>';
    
    document.getElementById("techTopics").innerHTML=str;
}

function getCollegeCoordinators(collegeId,workshopCode,Date,localtion){
    //alert(collegeName);
    if(collegeId!=''){
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/getCollegeCoordinators.action?collegeId='+collegeId,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            //alert('success'+data);
        
            coordinatorsContent(data,workshopCode,Date,localtion);
       
        
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
    }
    else{
        
        document.getElementById("techTopics").innerHTML="No co-ordinators registered"
    }
// alert(str);
}

function coordinatorsContent(data,workshopCode,Date,localtion){
    var str='';
  
    
    if(data!='No data'){
        
        // str='<div class="row"><div class="col-sm-4 wrkshp"><div class="heavy">Workshop Code : </div>'+workshopCode+'</div><div class="col-sm-4"><div class="heavy">Date :</div> '+Date+'</div><div class="col-sm-4"><div class="heavy">Location :</div> '+localtion+'</div></div>';
        var split=data.split('@@@');
        document.getElementById('titleName').innerHTML=split[23]+' Ambassadors for AP Cloud Initiative';
        str+='<div class="row open-btn" id="addClass"   href="#"><i class="fa ga fa-users" aria-hidden="true"></i>&nbsp<span class="heavy"><strong>Workshop and Faculty Details</strong></span> </div>';
        str+='<div class="row"><br><div class="col-sm-6">';
        str+='<i class="fa  fa-barcode" aria-hidden="true"></i><span class="heavy">Workshop Code :</span>'+workshopCode+'<br>'+'<i class="fa fa-calendar"></i><span class="heavy">Date :</span>'+Date+'<br>'+'<i class="fa fa-location-arrow bigicon"></i><span class="heavy">Location :</span> '+localtion+'</div>';
        str+='<div class="col-sm-6"><span class="heavy">'+split[0]+'</span><br>'+'<i class="fa fa-phone"></i>&nbsp;'+'+91-'+split[1]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[2]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div></div>';
        str+='<div class="row open-btn" id="addClass"   href="#"><i class="fa ga fa-graduation-cap" aria-hidden="true"></i>&nbsp <span class="heavy" ><strong>Student ambassadors</strong></span> </div>';
        str+='<br><div class="row"><div class="col-sm-4">'+'<span class="heavy">'+split[3]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[4]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[5]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[6]+' '+split[7]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str +='<div class="col-sm-4">'+'<span class="heavy">'+split[8]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[9]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[10]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[11]+' '+split[12]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str+='<div class="col-sm-4">'+'<span class="heavy">'+split[13]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[14]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[15]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[16]+' '+split[17]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str+='</div><br><div class="row"><div class="col-sm-4">'+'<span class="heavy">'+split[18]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[19]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[20]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[21]+' '+split[22]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div></div>';
    }
    else{
        
        str="No co-ordinators registered"
    }
    // alert(str);
    document.getElementById("techTopics").innerHTML=str;

}

//new
function getTechTopicsData()
{
    //alert("hi");
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getTechTopicsData.action',
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        //   alert('success'+data);
        techTopicData(data);
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}

function techTopicData(data)
{
    var split1=data.split("^^^");
    var str='<div class="row">'
    for(var i=0;i<split1.length-1;i++)
    {
        if(i%4==0)
        {
            str+='</div><div class="row">'
        }
        var split2=split1[i].split('@@@');
        str+= '<div class="col-sm-3" target="_blank" class="linkText">'
        str+='<a href="'+CONTEXT_PATH+'/techdetails?topicId='+split2[0]+'">' 
        str+='<img class="img-responsive" src="'+CONTEXT_PATH+'/'+split2[3]+'" alt="'+split2[1]+' | AP Cloud | Technologoes" title="'+split2[1]+'" style="max-width:100%;" /></a></div>'
    }
    str+='</div>';
    //alert(str);
    document.getElementById("techTopics").innerHTML=str;
}


function enrollTopic(topicId)
{
    alert(topicId);
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/enrollTechTopic.action?topicId='+topicId,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        alert('success'+data);
        if(data=="success")
        {
            document.getElementById("enrollTopicDisable"+topicId).style.display='block';
            document.getElementById("enrollTopicEnable"+topicId).style.display='none';
        }
     
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}
function enrollAllTopics()
{
    var topicsList=document.getElementById("topicsList").value;
    enrollTopic(topicsList,'multi')
}
function enrollTopic(topicId,inserType)
{
    var workshopCode =   document.getElementById("workshopCode").value;
    //alert(topicId+"----------"+workshopCode+'--------'+inserType);

    if(workshopCode!=""&&workshopCode!=null){
        document.getElementById("loadingAcoountSearch").style.display = "block";
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/enrollTechTopic.action?topicsList='+topicId+'&workshopCode='+workshopCode+'&inserType='+inserType,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            //  alert('success'+data);
            if(data=="success")
            {
                if(inserType=='multi'){
                    document.getElementById("loadingAcoountSearch").style.display = "none";
                    location.reload(); 
                }else{
                    document.getElementById("enrollTopicDisable"+topicId).style.display='block';
                    //  alert("11111111");
                    document.getElementById("enrollTopicEnable"+topicId).style.display='none';
                    // alert("aaaaaa");
                    
                    var totalTopics=document.getElementById("totalTopics").value;
                    var topicsList=document.getElementById("topicsList").value;
                    var topicsList1='';
                    var split=topicsList.split(',');
                    var j=0;
                    for(var i=0;i<split.length;i++)
                    {
                        if(split[i]!=topicId)
                        {
                            if(j<1)
                                topicsList1 =split[i];
                            else
                                topicsList1+= ','+split[i];
                            j++;          
                                    
                        }
                    }
                    document.getElementById("topicsList").value=topicsList1;
                    var    enrolledTopics=parseInt(document.getElementById("enrolledTotalTopics").value, 10) ;
                    enrolledTopics=enrolledTopics+1;
                    //alert(enrolledTopics);
                    document.getElementById("enrolledTotalTopics").value=enrolledTopics;
                    if(totalTopics==enrolledTopics)
                    {
                        document.getElementById("enrollTopicsAll").style.display='none';
                    }
                    document.getElementById("loadingAcoountSearch").style.display = "none";
                    showAlertModal("Successfully enrolled");
                }
            }
            
     
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
    }
}

function getEnrolledTopicsList(workshopCode)
{
    // alert(workshopCode);
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getEnrolledTopicsList.action?&workshopCode='+workshopCode,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        //alert('success'+data);
            
        getEnrolledTopicsContent(data,workshopCode);
                 
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}

function getEnrolledTopicsContent(data,workshopCode)
{
    //style="width:750px; height:300px; overflow:auto;" 
    //    alert("hhh11");
    //    alert(data);
    
    
    var str='';
    var split1=data.split('^^^');
   
    //   document.getElementById('titleName').innerHTML=workshopCode;
   
    str+='<div style="width:750px; height:400px; overflow:auto;"><table class="table t_st03"><thead><tr><th><i class="fa fa-calendar"></i>Date</th><th><i class="fa fa-clock-o"></i>Time</th><th><i class="fa fa-file-code-o"></i>Topic</th><th><i class="fa fa-file-code-o"></i>SubTopic</th></tr></thead><tbody>'
    for(var i=0;i<split1.length-1;i++){
        var split2=split1[i].split('@@@');
        
        str+='<tr><td><span>'+split2[0]+'</span></td><td><span>'+split2[2]+'</span></td><td><span>'+split2[1]+'</span></td><td><span>'+split2[4]+'</span></td></tr>';
    
        
    }
    str+='</tbody></table></div>';
    
    document.getElementById("techTopics").innerHTML=str;
}

function alreadyEnrolled()
{
    showAlertModal("You have already enrolled this topic");
}


function setCollegeDet(code,collegename,link,location){
    //alert(code);
    //alert(collegename);
    // alert(link);
    document.getElementById("collegeName1").value=collegename;
    //alert("-----collegeName----"+collegename)
    document.getElementById("collegeCode1").value=code;
    document.getElementById("webSite1").value=link;
    //
    document.getElementById("location1").value=location;
//  alert("-----wcode----"+wcode)
}


function getAddCollegeDet()
{
    //alert("-----getAddCollegeDet----")       
    
    var collegeName=document.getElementById("collegeName").value;
    // alert(collegeName+" "+webSite+""+collegeCode1+""+location);
    var webSite=document.getElementById("webSite").value;
    // alert(collegeName+" "+webSite+""+collegeCode1+""+location);
    var collegeCode1=document.getElementById("collegeCode").value.toUpperCase();
    var location=document.getElementById("location").value;
    
    if(collegeName.length>0&&webSite.length>0&&collegeCode1.length>0&&location.length>0)
    {
        $("#save").button('loading');
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/getAddCollegeDet.action?collegeName='+collegeName+'&link='+webSite+'&collegeCode='+collegeCode1+'&location='+location,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            // alert('success'+data);
        
            document.getElementById("resultMessg").style.display='block';
           
            if(data=="AlreadyExists")//AlreadyExists
            
            {
                alert("data"+data)
                document.getElementById("resultMessg").className="alert alert-danger";
               document.getElementById("addCollegeMessg").innerHTML="<div class='cal-sm-3'>College Already Exists</div>";
            //  document.getElementById("addCollegeMessg").innerHTML="<div class='alert alert-danger'><a class='close' data-dismiss='alert' href='#'>&times;</a><font color=\"red\" size=\"3.5\">College Already Exists </font></div>";
                
            }
            else{
                
             document.getElementById("resultMessg").className="alert alert-success";
            document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-3">  Code Generated : '+data+'</div>';
            alert("data"+data)
            }
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
        $("#save").button('reset');
    }else
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
//alert(collegeName+" "+webSite+""+collegeCode1+""+location);
   
}

function closeAlert()
{
    document.getElementById("addCollegeMessg").innerHTML='';
    document.getElementById("resultMessg").style.display='none';
}
function closeAlert1()
{
    document.getElementById("editCollegemessg1").innerHTML='';
    document.getElementById("resultMessg1").style.display='none';
    
}
function reloadPage()
{
    window.location='leftMenuCollege.action';
}



function editCollegeDet()
{
    
    var collegeName=document.getElementById("collegeName1").value;
    //alert("-----collegeName----"+collegeName)
    var link=document.getElementById("webSite1").value;
    // alert("-----link----"+link)
    var collegeCode1=document.getElementById("collegeCode1").value;
    // alert("-----collegeCode1----"+collegeCode1)
    var location1=document.getElementById("location1").value;
    // alert("-----location1----"+location1)
    
    // alert(collegeName+" "+link);
    if(collegeName.length>0&&link.length>0&&collegeCode1.length>0&&location1.length>0)
    {
        $("#edit").button('loading');
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/editCollegeDet.action?collegeName='+collegeName+'&link='+link+'&collegeCode='+collegeCode1+'&location='+location1,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            //alert('success'+data);
            document.getElementById("resultMessg1").style.display='block';
            document.getElementById("editCollegemessg1").innerHTML='<div class="cal-sm-3">  Updated  :  '+data+'</div>';
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
        $("#edit").button('reset');
    }else
    {
        document.getElementById("resultMessg1").style.display='block';
        document.getElementById("editCollegemessg1").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
    
}




function isUrl(obj) {
    
    var  url_validate = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
    if(!url_validate.test(obj.value)){
    
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-3">  Invalid Url</div>';
     
        obj.value = '';
    // alert('error');
    }

}


function getEnrollCollegeCoordinators(collegeId,workshopCode,localtion){
    // alert("collegeName---------------"+collegeId);
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getEnrollCollegeCoordinators.action?collegeId='+collegeId,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        //alert('success'+data);
        
        coordinatorsContentt(data,workshopCode,localtion);
       
        
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}


function coordinatorsContentt(data,workshopCode,localtion){
    //alert("------------coordinatorsContentt-------------------")
    var str='';
  
   
    
    if(data!='No data'){
        
        // str='<div class="row"><div class="col-sm-4 wrkshp"><div class="heavy">Workshop Code : </div>'+workshopCode+'</div><div class="col-sm-4"><div class="heavy">Date :</div> '+Date+'</div><div class="col-sm-4"><div class="heavy">Location :</div> '+localtion+'</div></div>';
        var split=data.split('@@@');
        document.getElementById('titleName').innerHTML=split[23]+' Ambassadors for AP Cloud Initiative';
        str+='<div class="row open-btn" id="addClass"   href="#"><img src="../images/FACULTY-ICON-new.jpg"> <span class="heavy"> Faculty Details</span> </div>';
        str+='<div class="row"><br><div class="col-sm-0">';
        //str+='<i class="fa  fa-barcode" aria-hidden="true"></i><span class="heavy">Workshop Code :</span>'+workshopCode+'<br>'+'<i class="fa fa-calendar"></i><span //class="heavy">Date :</span>'+Date+'<br>'+'<i class="fa fa-location-arrow bigicon"></i><span class="heavy">Location :</span> '+localtion+'</div>';
        str+='<span class="heavy">'+split[0]+'</span><br>'+'<i class="fa fa-phone"></i>&nbsp;'+'+91-'+split[1]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[2]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str+='<div class="row open-btn" id="addClass"   href="#"><img src="../images/Students-256.png"> <span class="heavy" style="position: relative; top: 8px;">Student ambassadors</span> </div>';
        str+='<br><div class="row"><div class="col-sm-4">'+'<span class="heavy">'+split[3]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[4]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[5]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[6]+' '+split[7]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str +='<div class="col-sm-4">'+'<span class="heavy">'+split[8]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[9]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[10]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[11]+' '+split[12]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str+='<div class="col-sm-4">'+'<span class="heavy">'+split[13]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[14]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[15]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[16]+' '+split[17]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div>';
        str+='<div class="col-sm-4">'+'<span class="heavy">'+split[18]+'</span><br><i class="fa fa-phone"></i>&nbsp;+91-'+split[19]+'<br>'+'<i class="fa fa-envelope-o bigicon"></i>'+split[20]+'<br> <i class="fa fa-graduation-cap" aria-hidden="true"></i>'+split[21]+' '+split[22]+'<br>'+'<i class="fa fa-university"></i>'+split[23]+'</div></div>';

    }
    else{
        
        str="No co-ordinators registered"
    }
    // alert(str);
    document.getElementById("techTopics").innerHTML=str;

} 


function reloadWorkshopAddPage()
{
    window.location='workshopDetailsAdd.action';
}

function addWorkshopDetails()
{
    closeAlert();
    document.getElementById("addWorkshopResultMessg").innerHTML='';
    var workshopType=document.getElementById("workshopType").value;
    //alert("-----getAddCollegeDet----")       
    var companyName=document.getElementById("companyNameText").value;
    var collegeName=document.getElementById("frmCollege").value;
    //   alert(collegeName+" ");
    var workLocation=document.getElementById("workLocation").value.trim();
    //    alert(workLocation);
    var workshopDate=document.getElementById("workshopDate").value;
    //    alert(workshopDate);
    //var location=document.getElementById("location").value;
   
    if(workshopType=="2")
    {
        collegeName= companyName;
    }
    if(workshopType!="-1"&&(collegeName!="-1"||companyName.length>0)&&workLocation.length>0&&workshopDate.length>0)
    {
        
        $("#save").button('loading');
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/addWorkshop.action?collegeName='+collegeName+'&workshopDate='+workshopDate+'&location='+workLocation+'&workshopType='+workshopType,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            //alert('success'+data);
        
            //document.getElementById("resultMessg").style.display='block';
            document.getElementById("addWorkshopResultMessg").innerHTML=data;
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
        $("#save").button('reset');
    }else
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }   
}


function getEditModal(code, collegeName,location,date,workshopType)
{
//    alert(workshopType);
    
    //document.getElementById("workshopType").value=workshopType;
    //document.getElementById("workshopType").style.disable=true;
    document.getElementById("workshopTypeSelect").style.display='none';
    //document.getElementById("workshopTypeText").style.display='block';
    
   // document.getElementById("workshopTypeTextValue").value=collegeName;
    if(workshopType=='2')
    {
        document.getElementById("collegeOrCompany").innerHTML="Company Name";
    }
    //collegeOrCompany
    document.getElementById("workshopCode").value=code;
    document.getElementById("collegeNameText").value=collegeName;
    //   alert(collegeName+" ");workshopType
    
    document.getElementById("workLocation").value=location;
    //    alert(workLocation);
    document.getElementById("workshopDate").value=date;
    
    document.getElementById("saveOverlayEnable").style.display='none';
    
    document.getElementById("collegeSelect").style.display='none';
    
    document.getElementById("updateOverlayEnable").style.display='block';
    
    document.getElementById("collegeText").style.display='block';
    document.getElementById("titleName").innerHTML='Update Workshop Details';
}


function updateWorkshopData()
{
    closeAlert();
    document.getElementById("addWorkshopResultMessg").innerHTML='';
    var workshopCode=document.getElementById("workshopCode").value;
    //document.getElementById("collegeNameText").value=collegeName;
    var location =document.getElementById("workLocation").value.trim();
    var date=document.getElementById("workshopDate").value;
    
    // alert(location+" "+date);
    if(location.length>0&&date.length>0)
    {
        $("#update").button('loading');
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/updateWorkshop.action?workshopCode='+workshopCode+'&workshopDate='+date+'&location='+location,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            // alert('success'+data);
        
            // document.getElementById("resultMessg").style.display='block';
            document.getElementById("addWorkshopResultMessg").innerHTML=data;
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
        $("#update").button('reset');
    }else
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
    

}


function reloadCurrcullamAddPage()
{
    var workshopCode=document.getElementById("workshopCode").value;
    var CollegeName=document.getElementById("CollegeName").value;
    // alert(CollegeName);
    window.location='CurrcullamAddTopicsData.action?workshopCode='+workshopCode+"&collegeName="+CollegeName;
}


function addCurrculumData()
{
    closeAlert();
    document.getElementById("addCurriculumResultMessg").innerHTML='';
    var currcullamDate=document.getElementById("currcullamDate").value;
    var topicId=document.getElementById("topicId").value;
    var startTime=document.getElementById("startTime").value;
   
    var endTime=document.getElementById("endTime").value;
    
    var midDayForm1=document.getElementById("midDayFrom1").value;
     
    var midDayForm2=document.getElementById("midDayFrom2").value;
    var durationTime=startTime+" "+midDayForm1+"-"+endTime+" "+midDayForm2;
    var subTopic=document.getElementById("subTopic").value.trim();
    var workshopCode=document.getElementById("workshopCode").value;
    var   venue= document.getElementById("venue").value.trim();
    //alert(currcullamDate+ "  "+topicId+ " " +durationTime+" "+subTopic);
    if(topicId!="-1"&&currcullamDate.length>0&&durationTime.length>0&&subTopic.length>0&&startTime.length>0&&endTime.length&&venue.length)
    {
        if(timeComparision())
        {
            $("#save").button('loading');
            $.ajax(
            {
                type : 'post',
						
                url : 'ajax/addCurrculumData.action?currcullamDate='+currcullamDate+'&topicId='+topicId+'&durationTime='+durationTime+'&subTopic='+subTopic+'&workshopCode='+workshopCode+'&venue='+venue,
                async: false,
						
                timeout : 60000
            }).success(function(data) {
                //alert('success'+data);
        
                //document.getElementById("resultMessg").style.display='block';
                document.getElementById("addCurriculumResultMessg").innerHTML=data;
            }).error(function(x, t, m) {
                if (t == "timeout") {
                    alert("time-->" + t);
                } else {
                    alert("elese part timer");
                }
            });
            $("#save").button('reset');
        }
        else
        {
            document.getElementById("resultMessg").style.display='block';
            document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Start time less than end time </div>';
        }
    }else
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
}



function enterdTime(element) {
    var x = element;

    var f=x.value;

    if(f.length==1 && f>1){
        //alert("0"+f);
        f="0"+f;
    }
    if(f.length==2){
        var s=f.substring(1,2);
        //alert(s);
        if(s==":" || s==" "){
            x.value ="0"+f.substring(0,1)+":";
        }
        else{
            x.value = f+":";
        }
    }
    else {
        x.value=f;
    }

}


function timeValidator(element) {
    var x = element;
    var f=x.value;

    if(f.length==1){

        f = "0"+f+":";

    }
   
    var s=f.split(':');



    if((s[0]>=0) && (s[0]<13) && ((s[1]>=0) && (s[1]<60)) ){


        if(s[1]==""){

            x.value =s[0]+':'+"00";
        }
        else if(s[1].length==1){
            x.value =s[0]+':'+"0"+s[1];
        // s[1]="0"+s[1];
        }
        else
        {
            x.value =s[0]+':'+s[1];
        }
    }
    else{
        x.value ="";
        alert('Enter time in 12 hours based')
    }
}



function getCurriculumEditModal(date,topicId,durationTime,subTopic,currculamId,venue)
{
    
    //alert(date+"      "+topicId+"  "+durationTime+"  "+subTopic+"  "+currculamId);
    document.getElementById("currcullamDate").value=date;
    document.getElementById("topicId").value=topicId;
    var timeSplit =durationTime.split('-');
    document.getElementById("currculumId1").value=currculamId;
    document.getElementById("startTime").value=timeSplit[0].split(' ')[0];
   
    document.getElementById("endTime").value=timeSplit[1].split(' ')[0];
    
    document.getElementById("midDayFrom1").value=timeSplit[0].split(' ')[1];
     
    document.getElementById("midDayFrom2").value=timeSplit[1].split(' ')[1];
    
    //var durationTime=startTime+" "+midDayForm1+"-"+endTime+" "+midDayForm2;
    document.getElementById("subTopic").value=subTopic;
    document.getElementById("venue").value=venue;
    document.getElementById("saveOverlayEnable").style.display='none';
    //   var workshopCode=document.getElementById("workshopCode").value;
    document.getElementById("updateOverlayEnable").style.display='block';
    
    
    document.getElementById("titleName").innerHTML='Update  Currculum Details';
}

function updateCurrculumData()
{
    closeAlert();
    document.getElementById("addCurriculumResultMessg").innerHTML='';
   
    var currcullamDate=document.getElementById("currcullamDate").value;
    var topicId=document.getElementById("topicId").value;
    var startTime=document.getElementById("startTime").value;
    var currculamId = document.getElementById("currculumId1").value;
    var endTime=document.getElementById("endTime").value;
    
    var midDayForm1=document.getElementById("midDayFrom1").value;
     
    var midDayForm2=document.getElementById("midDayFrom2").value;
    var durationTime=startTime+" "+midDayForm1+"-"+endTime+" "+midDayForm2;
    var subTopic=document.getElementById("subTopic").value.trim();
    var workshopCode=document.getElementById("workshopCode").value;
    var   venue= document.getElementById("venue").value.trim();
    // alert(currcullamDate+ "  "+topicId+ " " +durationTime+" "+subTopic);
    if(topicId!="-1"&&currcullamDate.length>0&&durationTime.length>0&&subTopic.length>0&&startTime.length>0&&endTime.length&&venue.length)
    {
        if(timeComparision())
        {
            $("#update").button('loading');
            $.ajax(
            {
                type : 'post',
						
                url : 'ajax/updateCurrculumData.action?currcullamDate='+currcullamDate+'&topicId='+topicId+'&durationTime='+durationTime+'&subTopic='+subTopic+'&workshopCode='+workshopCode+'&currculamId='+currculamId+'&venue='+venue,
                async: false,
						
                timeout : 60000
            }).success(function(data) {
                // alert('success'+data);
        
                //document.getElementById("resultMessg").style.display='block';
                document.getElementById("addCurriculumResultMessg").innerHTML=data;
            }).error(function(x, t, m) {
                if (t == "timeout") {
                    alert("time-->" + t);
                } else {
                    alert("elese part timer");
                }
            });
            $("#update").button('reset');
        }
        else
        {
            document.getElementById("resultMessg").style.display='block';
            document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Start time less than end time </div>';
        }
    }else
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
}
function populateWorkShopCode()
{
    //  alert('populateWorkShopCode');
    var collegeId=document.getElementById("colleges").value;
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getWorkshopCodeByCollegeName.action?collegeId='+collegeId,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        //alert('success'+data);
        generateWorkshopCode(data);
        
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}

function generateWorkshopCode(data)
{
    //  alert('data-->'+data);
    document.getElementById("workshopCode").value=data;
}

function generateExcelForm()
{   
    var colleges=document.getElementById("colleges").value;
    // alert(colleges)
    var frmDate=document.getElementById("frmDate").value;
    var toDate=document.getElementById("toDate").value;
    var profession=document.getElementById("profession").value;
    window.location="generatExcelForRegistration.action?colleges="+colleges+"&frmDate="+frmDate+"&toDate="+toDate;
}





/*
* Function Generate Excel for College List
Author : Santosh Kola
Date : 07/26/2016
* */

function generateCollegeExcel(){
    
    //frmDate
    //toDate
    var frmDate=$("#frmDate").val();
    var toDate=$("#toDate").val();
    window.location="generateCollegeExcel.action?frmDate"+frmDate+"&toDate"+toDate;
}


function getEnrolledWorkshopandTopics(userId)
{
    // alert(workshopCode);
    $.ajax(
    {
        type : 'post',
						
        url : 'ajax/getEnrolledWorkshopandTopics.action?&userId='+userId,
        async: false,
						
        timeout : 60000
    }).success(function(data) {
        // alert('success'+data);
            
        getEnrolledWorkshopandTopicsData(data);
                 
    }).error(function(x, t, m) {
        if (t == "timeout") {
            alert("time-->" + t);
        } else {
            alert("elese part timer");
        }
    });
}

function getEnrolledWorkshopandTopicsData(data)
{
    //style="width:750px; height:300px; overflow:auto;" 
    //    alert("hhh11");
    //    alert(data);
    
    
    var str='';
    if(data!=''&&data.length>0){
        var split1=data.split('^^^');
   
        //   document.getElementById('titleName').innerHTML=workshopCode;
   
        str+='<div style="width:750px; height:400px; overflow:auto;"><table class="table t_st03"><thead><tr><th>Sno</th><th><i class="fa  fa-barcode"></i>WorkshopCode</th><th><i class="fa fa-file-code-o"></i>Topic</th></tr></thead><tbody>'
        var sno=1;
        for(var i=0;i<split1.length-1;i++){
            
            var split2=split1[i].split('@@@');
        
            str+='<tr><td><span>'+sno+'</span></td><td><span>'+split2[0]+'</span></td><td><span>'+split2[1]+'</span></td></tr>';
            sno++;
        
        }
        str+='</tbody></table></div>';
    }
    else
    {
        str="No workshop enrolled"
    }
    document.getElementById("techTopics").innerHTML=str;
}

function timeComparision()
{
    
    var currcullamDate=document.getElementById("currcullamDate").value;
       
    var startTime=document.getElementById("startTime").value;
       
    var endTime=document.getElementById("endTime").value;
    
    var midDayForm1=document.getElementById("midDayFrom1").value;
     
    var midDayForm2=document.getElementById("midDayFrom2").value;
       		
    var time1=new Date(currcullamDate+' '+startTime+' '+midDayForm1);
    var time2=new Date(currcullamDate+' '+endTime+' '+midDayForm2);
    if(time1>time2)
    {
        //alert("start time less than end time  ");
        return false;
    }
    return true;
            
}
function closeAlert2()
{
    document.getElementById("searchWorkshop").innerHTML='';
    document.getElementById("resultMessg2").style.display='none';
    
}
//register coach
function reloadPageCoach()
{
    window.location='registredCoachDetailsSearch.action';
}
//edit coach details
function setCoachDet(name,title,companyName,areasOfExpertise,status,id,email,phoneNum){
   
    document.getElementById("updatename").value=name;
    document.getElementById("updateemail").value=email;
    document.getElementById("updatephoneNumber").value=phoneNum;
 
    document.getElementById("updatetitle").value=title;
    document.getElementById("updatecompanyName").value=companyName;
   
    document.getElementById("updateareaOfExpertise").value=areasOfExpertise;
    document.getElementById("updatestatus").value=status;
    document.getElementById("updateid").value=id;

}

function editCoachDetils()
{
    
    var name=document.getElementById("updatename").value;
    var email=document.getElementById("updateemail").value;
    var phoneNum=document.getElementById("updatephoneNumber").value;
    var title=document.getElementById("updatetitle").value;
    var companyName=document.getElementById("updatecompanyName").value;
    var areaOfExpertise=document.getElementById("updateareaOfExpertise").value;
    var status=document.getElementById("updatestatus").value;
    var id=document.getElementById("updateid").value;
  //  alert(email);
    if(name.length>0&&email.length>0&&phoneNum.length>=17&&title.length>0&&companyName.length>0&&areaOfExpertise.length>0&&status.length>0)
    {
        $("#edit").button('loading');
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/editCoachDetils.action?name='+name+'&coachemail='+email+'&phoneNumber='+phoneNum+'&title='+title+'&companyName='+companyName+'&areaOfExpertise='+areaOfExpertise+'&status='+status+'&id='+id,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            //alert('success'+data);
            document.getElementById("resultMessg1").style.display='block';
            document.getElementById("editCoachmessg1").innerHTML='<div class="cal-sm-3"> '+data+'</div>';
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
        $("#edit").button('reset');
    }else
    {
        document.getElementById("resultMessg1").style.display='block';
        document.getElementById("editCoachmessg1").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
    
}


//area of expertise in register coach
function getAreaOfExpertiseDeta(areasOfExpertise)
{
    document.getElementById("areaOfExpertiseInModal").innerHTML=areasOfExpertise;
}

//add register coach details
function getAddCoachDet()
{
    //alert("-----getAddCollegeDet----")       
    
    var name=document.getElementById("name").value;
   
    var email=document.getElementById("email").value;
  // alert(collegeName+" "+webSite+""+collegeCode1+""+location);
    var phoneNumber=document.getElementById("phoneNumber").value;
    var title=document.getElementById("title").value;
    var existingCompanyName=document.getElementById("existingCompanyName").value;
    var areaOfExpertise=document.getElementById("areaOfExpertise").value;
    var status=document.getElementById("status").value;
   //  alert(name+" "+email+""+phoneNumber+""+title+""+existingCompanyName+""+areaOfExpertise+""+status);
    if(name.length>0&&email.length>0&&phoneNumber.length>=17&&title.length>0&&existingCompanyName.length>0&&areaOfExpertise.length>0&&status.length>0)
    {
        $("#save").button('loading');
        $.ajax(
        {
            type : 'post',
						
            url : 'ajax/getAddCoachDet.action?name='+name+'&email='+email+'&phoneNumber='+phoneNumber+'&title='+title+'&existingCompanyName='+existingCompanyName+'&areaOfExpertise='+areaOfExpertise+'&status='+status,
            async: false,
						
            timeout : 60000
        }).success(function(data) {
            // alert('success'+data);
            
            if(data=="success"){
                document.getElementById("addCoachDet").innerHTML='<div class="cal-sm-3">Successfully added</div>';
                 document.getElementById('resultMessg').className='alert alert-success';  
            }else if(data=="failure"){
               document.getElementById("addCoachDet").innerHTML='<div class="cal-sm-3">Please try again</div>';
              document.getElementById('resultMessg').className='alert alert-danger';  
            }
            else{
               document.getElementById("addCoachDet").innerHTML='<div class="cal-sm-3">Already Email or Phone exist</div>'; 
             document.getElementById('resultMessg').className='alert alert-danger';  
            }
        
            document.getElementById("resultMessg").style.display='block';
            
        }).error(function(x, t, m) {
            if (t == "timeout") {
                alert("time-->" + t);
            } else {
                alert("elese part timer");
            }
        });
        $("#save").button('reset');
    }else
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCoachDet").innerHTML='<div class="cal-sm-12"> Please enter mandatory fields </div>';
    }
//alert(collegeName+" "+webSite+""+collegeCode1+""+location);
   
}
function closeUpdateCoachAlert()
{
    //document.getElementById("editCollegemessg1").innerHTML='';
    document.getElementById("resultMessg1").style.display='none';
    
}
function closeAddCoachAlert()
{
   // document.getElementById("resultMessg").innerHTML='';
    document.getElementById("resultMessg").style.display='none';
}
//

function changeWorkshopType()
{
    var selectVal=$('#workshopType').val();
    if(selectVal=='2')
    {
        document.getElementById("collegeOrCompany").innerHTML="Company Name";
        document.getElementById("companyText").style.display='block';
        document.getElementById("collegeSelect").style.display='none';
    }
    else
    {
        document.getElementById("collegeOrCompany").innerHTML="College Name";
        document.getElementById("companyText").style.display='none';
        document.getElementById("collegeSelect").style.display='block';      
    }
}




function changeWorkshopType()
{
    var selectVal=$('#workshopType').val();
    if(selectVal=='2')
    {
        document.getElementById("collegeOrCompany").innerHTML="Company Name";
        document.getElementById("companyText").style.display='block';
        document.getElementById("collegeSelect").style.display='none';
    }
    else
    {
        document.getElementById("collegeOrCompany").innerHTML="College Name";
        document.getElementById("companyText").style.display='none';
        document.getElementById("collegeSelect").style.display='block';      
    }
}

function reloadTopicsPage()
{
   // alert("hii");
    window.location='topicsDetails.action';
}

function closeTopicsAlert()
{
    
    document.getElementById("addTopicsMessg").innerHTML='';
    document.getElementById("resultMessg").style.display='none';
    
}


function topicImageDownload(topicId)
{
  //  alert(topicId);
    window.location="topicImageDownload?topicId="+topicId;
    
}


function reloadDocumentsPage(topicId,topicName)
{
   // alert("hii");
  
    window.location='documentsList.action?topicId='+topicId+'&topicName='+topicName;
}


function generateWorkshopRegExcel()
{   
    var workshopCode=document.getElementById("workshopCode").value;    
    var collegeName=document.getElementById("collegeName").value;    
    //alert(workshopCode);
    window.location="generatExcelForWorkshopsReg.action?workshopCode="+workshopCode+"&collegeName="+collegeName;
}