/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function formatPhone(element){
    str=new String(element.value);
    element.value=str.replace(/[A-Za-z\(\)\.\-\x\s,]/g,"");
    num=element.value;
    var _return;
    if(num.length==10){
        _return="(";
        var ini=num.substring(0,3);
        _return+=ini+")";
        var st=num.substring(3,6);
        _return+="-"+st+"-";
        var end=num.substring(6,10);
        _return+=end;
        element.value="";
        element.value=_return;

    }else{
        if(num.length>13){//alert("Phone Number should be 10 characters");
            showAlertModal("Phone Number should be 10 characters");
            element.value=_return;
            element.value="";
            element.focus();
            return false;
        }
        else{
            if(num.length<13){//alert("Please give atleast  10 charcters in PhoneNumber");
         
                showAlertModal("Please give atleast  10 charcters in PhoneNumber");
                element.value="";
            }
        }
    }
    return _return;
}
//adding +91 before giving the phone number
function newFormatPhone(element){
    // var res = str.substring(3);
   
    if((element.value).length==10){
        str=new String((element.value));
    }
    else{
        str=new String((element.value).substring(3));
    }
    //  alert(str);
    element.value=str.replace(/[A-Za-z\(\)\.\-\x\s,]/g,"");
    // alert(element.value);
    num=element.value;
    var _return="+91";
    if(num.length==10){
        _return+="(";
        var ini=num.substring(0,3);
        _return+=ini+")";
        var st=num.substring(3,6);
        _return+="-"+st+"-";
        var end=num.substring(6,10);
        _return+=end;
        element.value="";
        element.value=_return;

    }else{
        //  alert(num.length);
        if(num.length>10){//alert("Phone Number should be 10 characters");
            showAlertModal("Phone Number should be 10 characters");
            element.value=_return;
            //  element.value="";
            element.focus();
            return false;
        }
        else{
            if(num.length<10){//alert("Please give atleast  10 charcters in PhoneNumber");
         
                showAlertModal("Please give atleast  10 charcters in PhoneNumber");
                element.value=_return;
            }
        }
        
    }
    return _return;
}
 
function checkEmail(element)
{
    if(element.value.length>60){
        element.value="";
        //alert("Invalid E-mail Address! Please re-enter.");
        showAlertModal("Email length must be less than 60 characters.");
        //alert("Invalid E-mail Address! Please re-enter.");
        return(false);
    }
    if(element.value.length<=60){
        // [^@]+@[^@]+\.[a-zA-Z]{2,6} //  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
        if(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(element.value)){  
            return(true);
        }
    }
    element.value="";
    //alert("Invalid E-mail Address! Please re-enter.");
    showAlertModal("Invalid E-mail Address! Please re-enter.");
    //alert("Invalid E-mail Address! Please re-enter.");
    return(false);
}
 
function validatenumber(xxxxx){
    var maintainplus="";
    var numval=xxxxx.value;
    if(numval.charAt(0)=="+"){
        var maintainplus="+";
    }
    curnumbervar=numval.replace(/[\\A-Za-z!"?$%^&*+_={};:'@#~,?\/<>?|`?\]\[]/g,"");
    xxxxx.value=maintainplus+curnumbervar;
    var maintainplus="";
    xxxxx.focus;
}
 
function valueCheck(myForm){
    email=myForm.value;
    var is_value=email.indexOf("miraclesoft.com");
    if(is_value==-1){
        myForm.value="";
 
        showAlertModal("You should enter valid Miracle Mail Id!");
    }
}
 
function isNumber(evt) {
    
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode!=46 && charCode > 31 && (charCode < 48 || charCode > 57) && charCode >= 1 && charCode <=100)
        return false;
    
    return true;
}


function fieldLengthValidator(element) {
    // alert('fieldLengthValidator')
    //alert(element.id);
    var i=0;
    
    //New Change middlename
    if(element.id=="firstname" || element.id=="lastname" || element.id=="employeeName" || element.id=="middlename" || element.id=="firstName" || element.id=="lastName" || element.id== "fullName"||element.id=="principalName"|| element.id=="fname" || element.id=="lname" ||  element.id=="frmCompany" || element.id=="otherCollegeName" )
    {
        i=60;
    }
    if(element.id=="code")
    {
        i=8;
    }
    if(element.id=="facultyambassadorName"||element.id=="studentname"||element.id=="studentname1"||element.id=="studentname2"||element.id=="studentname3")
    {
        i=120;
    }
    
    if(element.id=="organization" || element.id=="currentOrganization" || element.id=="facebookProfile")

    {
        i=100;
    }
    if(element.id=='cCity'||element.id=='nCity'||element.id=="currentLocation" ||element.id=="experience" ||element.id=="educationalQualification" ||element.id=="city" || element.id=="employeePeriod"|| element.id=="nativePlace"|| element.id=="workLocation"|| element.id=="state"|| element.id=="country" || element.id=="nativeDistrict"|| element.id=="nativeState"|| element.id=="curentDistrict"|| element.id=="currentState"||element.id=="district")

    {
        i=30;
    }
    if(element.id=="designation" || element.id=="empDesignation" || element.id=="department" || element.id== "currentOccupation"  || element.id== "title" || element.id== "updatetitle")

    {
        i=40;
    }
    if(element.id=="description")

    {
        i=500;
    }
    if(element.id=="email" || element.id=="name" || element.id=="companyName" || element.id=="updateemail"||element.id=="updatename" || element.id=="updatecompanyName" || element.id=="existingCompanyName" ||  element.id=="frmDesignation" || element.id=="userId")

    {
       
        i=60;
    }
    if(element.id=="employeeId")

    {
        i=20;  
    }
    if(element.id=="reasonsToLeave" || element.id=="dropPoint")

    {
        i=500;
    }
    if(element.id=="zip" || element.id=="nativeZipcode" || element.id=="currentZipcode"||element.id=="zipcode" || element.id=="collegeid")

    {
        i=6;
    }
    if(element.id=="suggestions")

    {
        i=10000;
    }
    if(element.id=="street")
    {
        i=150;
    }
    if(element.id=="collegeCode" || element.id=="status" || element.id=="updatestatus") 
    {
        i=8;  
    }    
    if(element.id=="collegeName" || element.id=="webSite" || element.id=="location"){
        i=100;  
    } 
    if(element.id=="frmOtherBranch")
    {
        i=6;   
    }
      
    //for edit validation
    if(element.id=="collegeCode1"){
        i=8;  
    }    
    if(element.id=="collegeName1" || element.id=="webSite1" || element.id=="location1"){
        i=100;  
    }    
   
    if(element.id=="password" || element.id=="retypePassword"|| element.id=="oldPassword"|| element.id=="newPassword"|| element.id=="confirmPassword" ){
        i=15;  
    }  
    if(element.id=="areasOfExpertise" || element.id=="updateareaOfExpertise" || element.id=="areaOfExpertise")
    { 
      
        i=1500;   
        // alert("in if"+i)
    }
    //new changes for registration 
    if(element.id=="yearOfPass"){
        i=10;  
    }
   // alert(i)
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
       
        var str=new String(element.value);
        element.value=str.substring(0,i);
            
        //   document.getElementById("resultmessage").style.color= "red";
        // 	document.getElementById("resultmessage").innerHTML="The "+element.id+" length must be less than "+i+" characters";
        //  alert("here 11111111");
           
        showAlertModal("The "+element.id+" length must be less than "+i+" characters");
        //alert("The "+element.id+" length must be less than "+i+" characters");
        element.focus();
        return false;
    }
    return true;
        
        
}

function NumericValidation(eventObj)
{
    var keycode;
 
    if(eventObj.keyCode) //For IE
        keycode = eventObj.keyCode;
    else if(eventObj.Which)
        keycode = eventObj.Which;  // For FireFox
    else
        keycode = eventObj.charCode; // Other Browser
 
    if (keycode!=8) //if the key is the backspace key
    {
        if (keycode<48||keycode>57) //if not a number
            return false; // disable key press
        else
            return true; // enable key press
    }        
}
 
 
var specialKeys = new Array();
specialKeys.push(8); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode
    var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    if(!ret){
        // alert("Please enter numerics only!");
        showAlertModal("Please enter numerics only!");
    }
    //document.getElementById("error").style.display = ret ? "none" : "inline";
    return ret;
}
        
        
function validateDays(obj) {
    if(obj.value <=90){
                
    }else {
        //alert("Please enter below 90 days!");
        showAlertModal("Please enter below 90 days!");
        obj.value = "";
    }
}
        
        
        
function changeDropPoint(event){
    //alert(event.value);
    var corporateTrans = event.value;
    if(corporateTrans=='Yes'){
        document.getElementById("dropPoint").readOnly = false;
    }else{
        document.getElementById("dropPoint").value='';
        document.getElementById("dropPoint").readOnly = true;
    }
}


function checkMandatoryFields() {
    var jobTitle =  document.getElementById("jobTitle").value; 
   
    if(jobTitle.trim().length==0){
        showAlertModal("Please select position.");  
        return false;
    }else{
        return true;
    }
  
// alert("-->"+jobTitle+"<--");
   
}


function enableLoginWhenEnter(e) {
    var keynum;
    var keychar;
    var numcheck;
    
    if(window.event) {
        keynum = e.keyCode;
    }
    else if(e.which) // Netscape/Firefox/Opera
    {
        keynum = e.which;
    }
    try{
        if(keynum==13){
            doSubmit();
            return false;
        }
    }catch(e){
        alert("Error"+e);
    }
};
function passwordValidation()
{
    //alert("123");
    if($('#password').val()==$('#retypePassword').val())
    {
        //alert("here");
        return true;
    }
    else
    {
        showAlertModal("Password not matching");
        document.getElementById("retypePassword").value="";
        return false;
    }
};
function registrationValidation()
{
    // alert("here111");
    //  &&formatPhone('workPhone')&&passwordValidation()
    //alert($('#workPhone').val());
    if($('#firstname').val()==""||$('#firstname').val()==null)
    {
        showAlertModal("Enter First Name");
           
        $('#firstname').css("border", "1px solid red");
            
        return false;
    }
    if($('#lastname').val()==""||$('#lastname').val()==null)
    {
        showAlertModal("Enter Last Name");
        $('#lastname').css("border", "1px solid red");
        $('#lastname').focus();
        return false;
    }
    if($('#email').val()==""||$('#email').val()==null)
    {
        showAlertModal("Enter Email");
        $('#email').css("border", "1px solid red");
        $('#email').focus();
        return false;
    }
    if($('#workPhone').val()==""||$('#workPhone').val()==null)
    {
        showAlertModal("Enter Phone Number");
        $('#workPhone').css("border", "1px solid red");
        $('#workPhone').focus();
        return false;
    }
    if($('#password').val()==""||$('#password').val()==null)
    {
        showAlertModal("Enter Password");
        $('#password').css("border", "1px solid red");
        $('#password').focus();
        return false;
    }
    if($('#retypePassword').val()==""||$('#retypePassword').val()==null)
    {
        showAlertModal("Enter Retype Password");
        $('#retypePassword').css("border", "1px solid red");
        $('#retypePassword').focus();
        return false;
    }
    if($('#profession').val()==-1){
        showAlertModal("Select your Profession");
        $('#profession').css("border", "1px solid red");
        return false;
    }
    else
    {
            
        if($('#profession').val()=="1"){
            if($('#frmCollege').val()==-1)
            {
                showAlertModal("Select your college");
                $('#frmCollege').css("border", "1px solid red");
                return false;
 
            }
        }
        else if($('#profession').val()=="2")
        {
            //alert($('#profession').val()+"1111111"+$('#frmCompany').val());
            if($('#frmCompany').val()==""||$('#frmCompany').val()==null)
            {
                alert("com name")
                showAlertModal("Enter Organisation name");
                $('#frmCompany').css("border", "1px solid red");
                $('#frmCompany').focus();
                return false;
            }
          
            if($('#frmDesignation').val()==""||$('#frmDesignation').val()==null)
            {
                showAlertModal("Enter Your Designation");
                $('#frmDesignation').css("border", "1px solid red");
                $('#frmDesignation').focus();
                return false;
            }      

                
        }
        else if($('#profession').val()=="5"){
            if($('#yearOfPass').val()==""||$('#yearOfPass').val()==null)
            {
                showAlertModal("Enter yearOfPass");
                $('#yearOfPass').css("border", "1px solid red");
                $('#yearOfPass').focus();
                return false;
            } 
        }
        
        else
        {
            if($('#otherCollegeName').val()==""||$('#otherCollegeName').val()==null)
            {
                showAlertModal("Enter College Name");
                $('#otherCollegeName').css("border", "1px solid red");
                $('#otherCollegeName').focus();
                return false;
            }
        }
    }
    if($('#profession').val()=="1"){
        if($('#branch').val()==-1){
            showAlertModal("Select your branch");
            $('#branch').css("border", "1px solid red");
            return false;
        }
   
        
        else if($('#branch').val()=="Others")
        {
            
            if($('#frmOtherBranch').val()==""||$('#frmOtherBranch').val()==null)
            {
                showAlertModal("Enter Branch Name");
                $('#frmOtherBranch').css("border", "1px solid red");
                $('#frmOtherBranch').focus();
                return false;
            }
                
        }
        if($('#year').val()==-1){
            showAlertModal("Select your year of studing");
            $('#year').css("border", "1px solid red");
            return false;
        }
    
        
    }
    
    /*if($('#facebookProfile').val()==""||$('#facebookProfile').val()==null)
    {
        showAlertModal("Enter facebookProfile");
        $('#facebookProfile').css("border", "1px solid red");
        $('#facebookProfile').focus();
        return false;
    }*/
        
  
    if($('#street').val()==""||$('#street').val()==null)
    {
        showAlertModal("Enter Street");
        $('#street').css("border", "1px solid red");
        $('#street').focus();
        return false;
    }
    if($('#state').val()==-1){
        showAlertModal("Select your state");
        $('#state').css("border", "1px solid red");
        return false;
    }
    if($('#district').val()==-1)
    {
        showAlertModal("Select your district");
        $('#district').css("border", "1px solid red");
        return false;
 
    }
    if($('#city').val()==""||$('#city').val()==null)
    {
        showAlertModal("Enter City");
        $('#city').css("border", "1px solid red");
        $('#city').focus();
        return false;
    }
    
    if($('#zipcode').val()==""||$('#zipcode').val()==null)
    {
        showAlertModal("Enter Zip Code");
        $('#zipcode').css("border", "1px solid red");
        $('#zipcode').focus();
        return false;
    }
    if(document.getElementById("frmCollege").value=="Others"){
       
        showAlertModal("You Can't enter your college name, you have to intimate to your faculty to enroll your college name")
        return false;
    }
    
}
function borderCssChange(element)
{
    var rr="#"+element.id;
    // alert("border"+rr);
    
    $(rr).css("border", "1px solid #CCC");
}
function enrollValidation()
{
    if($('#collegeName').val()==-1){
        showAlertModal("Select your College Name");
        return false;
    }
    if($('#collegeid').val()==""||$('#collegeid').val()==null)
    {
        showAlertModal("Enter College Id");
           
        $('#collegeid').css("border", "1px solid red");
            
        return false;
    }
    if($('#code').val()==""||$('#code').val()==null)
    {
        showAlertModal("Enter Code");
        $('#code').css("border", "1px solid red");
        $('#code').focus();
        return false;
    }

    if($('#location').val()==""||$('#location').val()==null)
    {
        showAlertModal("Enter Location");
        $('#location').css("border", "1px solid red");
        $('#location').focus();
        return false;
    }
    
    if($('#facultyambassadorName').val()==""||$('#facultyambassadorName').val()==null)
    {
        showAlertModal("Enter Faculty Ambassador Name");
        $('#facultyambassadorName').css("border", "1px solid red");
        $('#facultyambassadorName').focus();
        return false;
    }
    if($('#facultyambassadorPhoneNumber').val()==""||$('#facultyambassadorPhoneNumber').val()==null)
    {
        showAlertModal("Enter Faculty Phone Number");
        $('#facultyambassadorPhoneNumber').css("border", "1px solid red");
        $('#facultyambassadorPhoneNumber').focus();
        return false;
    }
    if($('#facultyambassadorEmail').val()==""||$('#facultyambassadorEmail').val()==null)
    {
        showAlertModal("Enter Faculty Email");
        $('#facultyambassadorEmail').css("border", "1px solid red");
        $('#facultyambassadorEmail').focus();
        return false;
    }
    if($('#studentname').val()==""||$('#studentname').val()==null)
    {
        showAlertModal("Enter First Student Name");
        $('#studentname').css("border", "1px solid red");
        $('#studentname').focus();
        return false;
    }
    if($('#studentPhoneNumber').val()==""||$('#studentPhoneNumber').val()==null)
    {
        showAlertModal("Enter First Student Phone Number");
        $('#studentPhoneNumber').css("border", "1px solid red");
        $('#studentPhoneNumber').focus();
        return false;
    }
    if($('#studentEmail').val()==""||$('#studentEmail').val()==null)
    {
        showAlertModal("Enter First Student Email");
        $('#studentEmail').css("border", "1px solid red");
        $('#studentEmail').focus();
        return false;
    }
    if($('#studentBranch').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear').css("border", "1px solid red");
        return false;
    }
    if($('#studentname1').val()==""||$('#studentname1').val()==null)
    {
        showAlertModal("Enter Second Student Name");
        $('#studentname1').css("border", "1px solid red");
        $('#studentname1').focus();
        return false;
    }
    if($('#studentPhoneNumber1').val()==""||$('#studentPhoneNumber1').val()==null)
    {
        showAlertModal("Enter Second Student Phone Number");
        $('#studentPhoneNumber1').css("border", "1px solid red");
        $('#studentPhoneNumber1').focus();
        return false;
    }
    if($('#studentEmail1').val()==""||$('#studentEmail1').val()==null)
    {
        showAlertModal("Enter Second Student Email");
        $('#studentEmail1').css("border", "1px solid red");
        $('#studentEmail1').focus();
        return false;
    }
    
    if($('#studentBranch1').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch1').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear1').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear1').css("border", "1px solid red");
        return false;
    }
    if($('#studentname2').val()==""||$('#studentname2').val()==null)
    {
        showAlertModal("Enter Third Student Name");
        $('#studentname2').css("border", "1px solid red");
        $('#studentname2').focus();
        return false;
    }
    if($('#studentPhoneNumber2').val()==""||$('#studentPhoneNumber2').val()==null)
    {
        showAlertModal("Enter Third Student Phone Number");
        $('#studentPhoneNumber2').css("border", "1px solid red");
        $('#studentPhoneNumber2').focus();
        return false;
    }
    if($('#studentEmail2').val()==""||$('#studentEmail2').val()==null)
    {
        showAlertModal("Enter Third Student Email");
        $('#studentEmail2').css("border", "1px solid red");
        $('#studentEmail2').focus();
        return false;
    }
    
     
    
    if($('#studentBranch2').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch2').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear2').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear2').css("border", "1px solid red");
        return false;
    }
    if($('#studentname3').val()==""||$('#studentname3').val()==null)
    {
        showAlertModal("Enter Fourth Student Name");
        $('#studentname3').css("border", "1px solid red");
        $('#studentname3').focus();
        return false;
    }
    if($('#studentPhoneNumber3').val()==""||$('#studentPhoneNumber3').val()==null)
    {
        showAlertModal("Enter Fourth Student Phone Number");
        $('#studentPhoneNumber3').css("border", "1px solid red");
        $('#studentPhoneNumber3').focus();
        return false;
    }
    if($('#studentEmail3').val()==""||$('#studentEmail3').val()==null)
    {
        showAlertModal("Enter Fourth Student Email");
        $('#studentEmail3').css("border", "1px solid red");
        $('#studentEmail3').focus();
        return false;
    }
    
     
    
    if($('#studentBranch3').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch3').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear3').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear3').css("border", "1px solid red");
        return false;
    }
    
}




/*function setProfession(){
 
    var prof=document.getElementById("profession").value;
    // alert(prof);
    var collegeIdHidden=document.getElementById("collegeIdHidden").value;
    //var year=document.getElementById("year").value;
    // alert(prof);

    document.getElementById("branch").value="-1";
    if(collegeIdHidden!=null && collegeIdHidden!=""){
      
        document.getElementById("studentDiv").style.display="block";
        document.getElementById("profession").value=1;
    }
    else{
      
        if(prof=="-1"){    
            document.getElementById("studentDiv").style.display="none";
            document.getElementById("employeeDiv").style.display="none";
            document.getElementById("branchdiv").style.display="none";
            document.getElementById("yeardiv").style.display="none";
            document.getElementById("facebookProfile").style.display="none";
        }
        else if(prof=="1")
        {
            document.getElementById("collegeDiv").style.display="none";
            document.getElementById("yearOfPassDiv").style.display="none";
            document.getElementById("employeeDiv").style.display="none";
            document.getElementById("studentDiv").style.display="block";
            document.getElementById("yeardiv").style.display="block";
            document.getElementById("branchdiv").style.display="block";
           
            document.getElementById("facebookProfile").style.display="block";
            
            
            
        }
        else if(prof=="5")
        {
            document.getElementById("studentDiv").style.display="none"; 
            document.getElementById("employeeDiv").style.display="none";
            document.getElementById("yeardiv").style.display="none"; 
            
            document.getElementById("collegeDiv").style.display="block";
            document.getElementById("yearOfPassDiv").style.display="block";
            document.getElementById("branchdiv").style.display="block";
            document.getElementById("facebookProfile").style.display="block";
              
        
        }
        else
        {
            
            document.getElementById("yearOfPassDiv").style.display="none";
            document.getElementById("studentDiv").style.display="none";
            document.getElementById("employeeDiv").style.display="block";  
            document.getElementById("yeardiv").style.display="none";  
            document.getElementById("branchdiv").style.display="none";
            document.getElementById("branchOtherDiv").style.display="none";
            document.getElementById("collegeDiv").style.display="none";
            document.getElementById("facebookProfile").style.display="block";
    
        }
    }
}*/

function resetFormFields(){
    //alert('resetFormFields');
    document.getElementById('Submitbutton').disabled=false;
    document.getElementById("resultMessage1").innerHTML="";
    document.getElementById("emailForPass").value="";
}
             
             
function loginfieldLengthValidator(element) 
{
    // alert("element-->"+element);
    var i=0;
    if(element.id=="Emailid")
    {
        i=60;
    }
    if(element.id=="password")
    {
        i=100;
    }
    if(element.id=="emailForPass")
    {
        i=60;
    }
    
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
        str=new String(element.value);
        element.value=str.substring(0,i);
            
        //   document.getElementById("resultmessage").style.color= "red";
        // 	document.getElementById("resultmessage").innerHTML="The "+element.id+" length must be less than "+i+" characters";
           
           
        showAlertModal("The "+element.id+" length must be less than "+i+" characters");
        //alert("The "+element.id+" length must be less than "+i+" characters");
        element.focus();
        return false;
    }
    return true;
}


function emailLengthValidater(element)
{
    // alert("emailLengthValidater");
    var i=0;
    if(element.id=="emailForPass")
    {
        i=60;
        emailForPassname="E-Mail Id";
        
    }
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
        str=new String(element.value);
        element.value=str.substring(0,i);
            
        //   document.getElementById("resultmessage").style.color= "red";
        document.getElementById("resultMessage1").innerHTML="<font color='red'>The "+emailForPassname+" length must be less than "+i+" characters</font>";
           
      
        // showAlertModal("The "+element.id+" length must be less than "+i+" characters");
        //alert("The "+element.id+" length must be less than "+i+" characters");
        element.focus();
        return false;
    }
    
}


function checkEmailOnOverlay(element)
{
    // alert("checkEmailOnOverlay");
    if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(element.value)){
        return(true);
    }
    element.value="";
    document.getElementById("resultMessage1").innerHTML="<font color='red'>Invalid E-mail Address! Please re-enter.</font>";
    // alert("Invalid E-mail Address! Please re-enter.");
    // showAlertModal("Invalid E-mail Address! Please re-enter.");
    //alert("Invalid E-mail Address! Please re-enter.");
    return(false);
}

function loginValidation()
{
    //alert("loginValidation");
    //  &&formatPhone('workPhone')&&passwordValidation()
    //alert($('#workPhone').val());
    if($('#emailid').val()==""||$('#emailid').val()==null)
    {
        showAlertModal("Enter Email Id");
           
        $('#emailid').css("border", "1px solid red");
            
        return false;
    }
    if($('#password').val()==""||$('#password').val()==null)
    {
        showAlertModal("Enter Password");
        $('#password').css("border", "1px solid red");
        $('#password').focus();
        return false;
    }
}

function getBranch(){
    //   var branch=document.getElementById("branch").value;

    //alert("------getBranch------")
    if(document.getElementById("branch").value=="Others"){
        document.getElementById("branchOtherDiv").style.display="block";
    //alert("----frmOtherBranch----"+frmOtherBranch);
    } else{
        document.getElementById("branchOtherDiv").style.display="none";
    }

}

function contactUsValidation()
{
    // alert("here111");
    //  &&formatPhone('workPhone')&&passwordValidation()
    //alert($('#workPhone').val());
    if($('#fname').val()==""||$('#fname').val()==null)
    {
        showAlertModal("Enter first name");
           
        $('#fname').css("border", "1px solid red");
            
        return false;
    }
    if($('#lname').val()==""||$('#lname').val()==null)
    {
        showAlertModal("Enter last name");
        $('#lname').css("border", "1px solid red");
        
        return false;
    }
    if($('#email').val()==""||$('#email').val()==null)
    {
        showAlertModal("Enter email address");
        $('#email').css("border", "1px solid red");
        $('#email').focus();
        return false;
    }
    if($('#phone').val()==""||$('#phone').val()==null)
    {
        showAlertModal("Enter phone number");
        $('#phone').css("border", "1px solid red");
        $('#phone').focus();
        return false;
    }
    
    if($('#organization').val()==""||$('#organization').val()==null)
    {
        showAlertModal("Enter your organization ");
        $('#organization').css("border", "1px solid red");
        $('#organization').focus();
        return false;
    }
     
    if($('#designation').val()==""||$('#designation').val()==null)
    {
        showAlertModal("Enter your designation");
        $('#designation').css("border", "1px solid red");
        $('#designation').focus();
        return false;
    }
        
    
}


function resetEmpPwdSubmit(){  
    var cofirmPwd = document.resetForm.confirmPassword.value;
    var newPassword = document.resetForm.newPassword.value;
    var oldPassword = document.resetForm.oldPassword.value;
    if(cofirmPwd=="" || cofirmPwd==null || newPassword=="" || newPassword==null || oldPassword=="" || oldPassword==null){
        // alert("Enter Details");
        showAlertModal("Enter Details");
        return (false);
    }else if(newPassword != cofirmPwd){     
        showAlertModal("password not matched!");
        //        alert("password not matched!");
        document.resetForm.newPassword.value = '';
        document.resetForm.confirmPassword.value = '';
        return (false);
    }else {
        return (true);
    }
}

function updateEnrollValidation()
{
    
    if($('#location').val()==""||$('#location').val()==null)
    {
        showAlertModal("Enter Location");
        $('#location').css("border", "1px solid red");
        $('#location').focus();
        return false;
    }
    
    if($('#facultyambassadorName').val()==""||$('#facultyambassadorName').val()==null)
    {
        showAlertModal("Enter Faculty Ambassador Name");
        $('#facultyambassadorName').css("border", "1px solid red");
        $('#facultyambassadorName').focus();
        return false;
    }
    if($('#facultyambassadorPhoneNumber').val()==""||$('#facultyambassadorPhoneNumber').val()==null)
    {
        showAlertModal("Enter Faculty Phone Number");
        $('#facultyambassadorPhoneNumber').css("border", "1px solid red");
        $('#facultyambassadorPhoneNumber').focus();
        return false;
    }
    if($('#facultyambassadorEmail').val()==""||$('#facultyambassadorEmail').val()==null)
    {
        showAlertModal("Enter Faculty Email");
        $('#facultyambassadorEmail').css("border", "1px solid red");
        $('#facultyambassadorEmail').focus();
        return false;
    }
    if($('#studentname').val()==""||$('#studentname').val()==null)
    {
        showAlertModal("Enter First Student Name");
        $('#studentname').css("border", "1px solid red");
        $('#studentname').focus();
        return false;
    }
    if($('#studentPhoneNumber').val()==""||$('#studentPhoneNumber').val()==null)
    {
        showAlertModal("Enter First Student Phone Number");
        $('#studentPhoneNumber').css("border", "1px solid red");
        $('#studentPhoneNumber').focus();
        return false;
    }
    if($('#studentEmail').val()==""||$('#studentEmail').val()==null)
    {
        showAlertModal("Enter First Student Email");
        $('#studentEmail').css("border", "1px solid red");
        $('#studentEmail').focus();
        return false;
    }
    if($('#studentBranch').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear').css("border", "1px solid red");
        return false;
    }
    if($('#studentname1').val()==""||$('#studentname1').val()==null)
    {
        showAlertModal("Enter Second Student Name");
        $('#studentname1').css("border", "1px solid red");
        $('#studentname1').focus();
        return false;
    }
    if($('#studentPhoneNumber1').val()==""||$('#studentPhoneNumber1').val()==null)
    {
        showAlertModal("Enter Second Student Phone Number");
        $('#studentPhoneNumber1').css("border", "1px solid red");
        $('#studentPhoneNumber1').focus();
        return false;
    }
    if($('#studentEmail1').val()==""||$('#studentEmail1').val()==null)
    {
        showAlertModal("Enter Second Student Email");
        $('#studentEmail1').css("border", "1px solid red");
        $('#studentEmail1').focus();
        return false;
    }
    
    if($('#studentBranch1').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch1').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear1').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear1').css("border", "1px solid red");
        return false;
    }
    if($('#studentname2').val()==""||$('#studentname2').val()==null)
    {
        showAlertModal("Enter Third Student Name");
        $('#studentname2').css("border", "1px solid red");
        $('#studentname2').focus();
        return false;
    }
    if($('#studentPhoneNumber2').val()==""||$('#studentPhoneNumber2').val()==null)
    {
        showAlertModal("Enter Third Student Phone Number");
        $('#studentPhoneNumber2').css("border", "1px solid red");
        $('#studentPhoneNumber2').focus();
        return false;
    }
    if($('#studentEmail2').val()==""||$('#studentEmail2').val()==null)
    {
        showAlertModal("Enter Third Student Email");
        $('#studentEmail2').css("border", "1px solid red");
        $('#studentEmail2').focus();
        return false;
    }
    
     
    
    if($('#studentBranch').val()==-1){
        showAlertModal("Select your Branch");
        $('#studentBranch2').css("border", "1px solid red");
        return false;
    }
    
    if($('#studentYear2').val()==-1){
        showAlertModal("Select your year of study");
        $('#studentYear2').css("border", "1px solid red");
        return false;
    }
    
    if($('#studentname3').val()==""||$('#studentname3').val()==null)
    {
        showAlertModal("Enter Fourth Student Name");
        $('#studentname3').css("border", "1px solid red");
        $('#studentname3').focus();
        return false;
    }
    if($('#studentPhoneNumber3').val()==""||$('#studentPhoneNumber3').val()==null)
    {
        showAlertModal("Enter Fourth Student Phone Number");
        $('#studentPhoneNumber3').css("border", "1px solid red");
        $('#studentPhoneNumber3').focus();
        return false;
    }
    if($('#studentEmail3').val()==""||$('#studentEmail3').val()==null)
    {
        showAlertModal("Enter Fourth Student Email");
        $('#studentEmail3').css("border", "1px solid red");
        $('#studentEmail3').focus();
        return false;
    }
    
     
    
    if($('#studentBranch3').val()==-1){
        showAlertModal("Select Fourth student Branch");
        $('#studentBranch3').css("border", "1px solid red");
        return false;
    }
    if($('#studentYear3').val()==-1){
        showAlertModal("Select Fourth student year of study");
        $('#studentYear3').css("border", "1px solid red");
        return false;
    }
}

function contactFieldLengthValidator(element)
{ 
    var i=0;
    if(element.id=="description")
    {        
        i=500;             
    } 
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
        str=new String(element.value);
        element.value=str.substring(0,i);                            
        showAlertModal("The "+element.id+" length must be less than "+i+" characters");
        
        element.focus();
        return false;
    }
}

function startingCapital(ele)
{
    var str=ele.value;
    //alert(str);
    var totString="";
    var split=str.split(" ");
    for(var i=0;i<split.length;i++)
    {
        totString+=split[i].charAt(0).toUpperCase() + split[i].slice(1)+" ";
    }
    ele.value=totString;
}
function workshopFieldlengthValidator(element)
{
    var i=0;
    if(element.id=="subTopic" || element.id=="venue" || element.id=="companyNameText")
    {
        i=100;
    }
    if(element.id=="workLocation" )
    {
        i=80;
    }
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
       
        var str=new String(element.value);
        element.value=str.substring(0,i);
            
        //   document.getElementById("resultmessage").style.color= "red";
        // 	document.getElementById("resultmessage").innerHTML="The "+element.id+" length must be less than "+i+" characters";
        //  alert("here 11111111");
          
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addCollegeMessg").innerHTML='<div class="cal-sm-12"> The '+element.id+' length must be less than '+i+' characters</div>';
        // showAlertModal();
        //alert("The "+element.id+" length must be less than "+i+" characters");
        element.focus();
        return false;
    }
}


function dateComparision()
{
    //alert("here");
    var fromDate=document.getElementById("frmDate").value;
    var toDate=document.getElementById("toDate").value;
   
    //alert(fromDate);
    if(fromDate.length>0&&toDate.length>0)
    {
        var fromDate1=new Date(fromDate);
        var toDate1=new Date(toDate);
        if(fromDate1>toDate1)
        {
            //                    alert("From date must be grater than to date");
            document.getElementById("resultMessg2").style.display='block';
            document.getElementById("searchWorkshop").innerHTML='<div class="cal-sm-12"> From date must be lessthan To date</div>';//
            return false;       
        }
            
    }
    
    return true;
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





//------------------


//validation for register coatch details
function coachDetailsValidation()
{
    //  alert("here111");
   
    if($('#name').val()==""||$('#name').val()==null)
    {
        showAlertModal("Enter name");
           
        $('#name').css("border", "1px solid red");
            
        return false;
    }
    if($('#email').val()==""||$('#email').val()==null)
    {
        showAlertModal("Enter email address");
        $('#email').css("border", "1px solid red");
        $('#email').focus();
        return false;
    }
    
    
    if($('#title').val()==""||$('#title').val()==null)
    {
        showAlertModal("Enter title");
        $('#title').css("border", "1px solid red");
       
        return false;
    }
    if($('#companyName').val()==""||$('#companyName').val()==null)
    {
        showAlertModal("Enter companyName");
        $('#companyName').css("border", "1px solid red");
        $('#companyName').focus();
        return false;
    }
    if($('#phone').val()==""||$('#phone').val()==null)
    {
        showAlertModal("Enter Phone number");
        $('#phone').css("border", "1px solid red");
        $('#phone').focus();
        return false;
    }
    
    if($('#areasOfExpertise').val()==""||$('#areasOfExpertise').val()==null)
    {
        showAlertModal("Enter areasOfExpertise");
        $('#areasOfExpertise').css("border", "1px solid red");
        //$('#companyName').focus();
        return false;
    }
        
    return true;
}

function checkProfNotOthers(){
    //  alert('------')
    if(document.getElementById("frmCollege").value=="Others"){
       
        showAlertModal("You Can't enter your college name, you have to intimate to your faculty to enroll your college name"); 
        
    }
}

function imageValidation()
{
    // alert("Entered");
	      
    var fullPath = document.getElementById('image').value;
    //  alert(fullPath);
    if (fullPath) {
        var arr1 = new Array;
        arr1 = fullPath.split("\\");
        var len = arr1.length;
        var img1 = arr1[len-1];
        var filext = img1.substring(img1.lastIndexOf(".")+1);
        // alert(fullPath);
        if(filext == "jpeg" || filext == "png" || filext == 'gif' || filext == 'jpg'|| filext == 'PNG')
        {
            
            var size = document.getElementById('image').files[0].size;
            // alert(size);
             
            if(size<200000) {
                //alert("heretss");
                var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
                var filename = fullPath.substring(startIndex);
                if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
                    filename = filename.substring(1);
                }
                document.getElementById('imageFileName').value=filename;
               
                  
            }else {
                // alert("File size must be less than 200 kb");
                document.getElementById('image').value='';
                document.getElementById("resultMessg").style.display='block';
                document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> File size must be less than 200 kb</div>';
                return (false);
            }
        }else {
            // alert("Invalid File Format Selected.Please choose doc/docx/txt/pdf/rtf formats.");
            
            document.getElementById('image').value='';
            document.getElementById("resultMessg").style.display='block';
            document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12">Invalid File Format Selected.Please choose jpeg/png/gif/jpg formats.</div>';
            

            return false;
        }
            	
    }
    return false;
}

//topicsFieldLenthValidators

function topicsFieldLenthValidators(element)
{
    //alert("hii"+ element.id);
    var i=0;
    if(element.id=="topicName" || element.id=="websitelink" || element.id=="blogs"||element.id=="title" )
    {
        i=100;
    }
    if(element.id=="bodyContent" )
    {
        i=9000;
    }
    
    if(element.id=="videoTutorail" || element.id=="tutorials" )
    {
        i=500;
    }
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
       
        var str=new String(element.value);
        element.value=str.substring(0,i);
            
        //   document.getElementById("resultmessage").style.color= "red";
        // 	document.getElementById("resultmessage").innerHTML="The "+element.id+" length must be less than "+i+" characters";
        //  alert("here 11111111");
         
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> The '+element.id+' length must be less than '+i+' characters</div>';
        // showAlertModal();
        //alert("The "+element.id+" length must be less than "+i+" characters");
        element.focus();
        return false;
    }
}



function documentValidation()
{
	      
    var fullPath = document.getElementById('document').value;
    // alert(fullPath);
    if (fullPath) {
        var arr1 = new Array;
        arr1 = fullPath.split("\\");
        var len = arr1.length;
        var img1 = arr1[len-1];
        var filext = img1.substring(img1.lastIndexOf(".")+1);
        //alert(fullPath);
        if(filext == "doc" || filext == "docx" || filext == 'txt' || filext == 'pdf' || filext == 'rtf'|| filext == 'pptx' || filext == 'ppt' )
        {
            
            var size = document.getElementById('document').files[0].size;
             //alert(size);
             
            if(size<12097152) {
                //alert("heretss");
                var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
                var filename = fullPath.substring(startIndex);
                
                if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
                    filename = filename.substring(1);
                }
                document.getElementById('documentFileName').value=filename;
                
                  
            }else {
                // alert("File size must be less than 2 MB");
                document.getElementById("resultMessg").style.display='block';
                document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12">File size must be less than 2 MB.</div>';
                
                return (false);
            }
        }else {
            //alert("Invalid File Format Selected.Please choose doc/docx/txt/pdf/rtf formats.");
            
            document.getElementById("resultMessg").style.display='block';
            document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12">Invalid File Format Selected.Please choose doc/docx/txt/pdf/rtf formats.</div>';
            
            
            return false;
        }
            	
    }
    return false;
}


function topicsValidation()
{
    //  alert("here111");
   
    if($('#topicName').val()==""||$('#topicName').val()==null)
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter topic name </div>';
        //showAlertModal("Enter topic name");
           
        $('#topicName').css("border", "1px solid red");
            
        return false;
    }
    if($('#image').val()==""||$('#image').val()==null)
    {
        //showAlertModal("Upload image");
        
        if($('#type').val()!='update')
        {
            document.getElementById("resultMessg").style.display='block';
            document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Upload image</div>';
            $('#image').css("border", "1px solid red");
        
            return false;
        }
    }
    
    
    if($('#status').val()==-1)
    {
        //showAlertModal("Please select status");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Please select status</div>';
        $('#status').css("border", "1px solid red");
       
        return false;
    }
    if($('#title').val()==""||$('#title').val()==null)
    {
        //showAlertModal("Enter body content");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter title </div>';
        $('#title').css("border", "1px solid red");
        
        return false;
    }
    if($('#bodyContent').val()==""||$('#bodyContent').val()==null)
    {
        //showAlertModal("Enter body content");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter body content</div>';
        $('#bodyContent').css("border", "1px solid red");
        
        return false;
    }
    if($('#videoTutorail').val()==""||$('#videoTutorail').val()==null)
    {
        //showAlertModal("Enter video tutorail");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter video tutorail</div>';
        $('#videoTutorail').css("border", "1px solid red");
        
        return false;
    }
    
    if($('#websitelink').val()==""||$('#websitelink').val()==null)
    {
        //showAlertModal("Enter website link");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter website link</div>';
        $('#websitelink').css("border", "1px solid red");
  
        return false;
    }
    if($('#tutorials').val()==""||$('#tutorials').val()==null)
    {
        //showAlertModal("Enter tutorials links");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter tutorials links</div>';
        $('#tutorials').css("border", "1px solid red");
  
        return false;
    }
    if($('#blogs').val()==""||$('#blogs').val()==null)
    {
        //showAlertModal("Enter blog links");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter blog links</div>';
        $('#blogs').css("border", "1px solid red");
  
        return false;
    }
    return true;
}

function documnetFromValidation()
{
    //  alert("here111");
   
    if($('#docName').val()==""||$('#docName').val()==null)
    {
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Enter document title </div>';
        //showAlertModal("Enter topic name");
           
        $('#topicName').css("border", "1px solid red");
            
        return false;
    }
    if($('#uploadType').val()!='update')
    {
        if($('#type').val()==-1)
        {
            //showAlertModal("Please select status");
            document.getElementById("resultMessg").style.display='block';
            document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Please select type</div>';
            $('#type').css("border", "1px solid red");
       
            return false;
        }
    
        if($('#type').val()!="WebExSessions")
        {
            if($('#image').val()==""||$('#image').val()==null)
            {
                //showAlertModal("Upload image");
                document.getElementById("resultMessg").style.display='block';
                document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Upload image</div>';
                $('#image').css("border", "1px solid red");
                ;
                return false;
            }
            if($('#document').val()==""||$('#document').val()==null)
            {
                //showAlertModal("Upload image");
                document.getElementById("resultMessg").style.display='block';
                document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Upload document</div>';
                $('#document').css("border", "1px solid red");
                ;
                return false;
            }
        }else{
              if($('#webExUrl').val()==""||$('#webExUrl').val()==null)
            {
                //showAlertModal("Upload image");
                document.getElementById("resultMessg").style.display='block';
                document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12">Enter Webex url</div>';
                $('#webExUrl').css("border", "1px solid red");
                ;
                return false;
            }  
                
        }
    }
    if($('#status').val()==-1)
    {
        //showAlertModal("Please select status");
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> Please select status</div>';
        $('#status').css("border", "1px solid red");
       
        return false;
 
    }
	
    return true;
}



function documentsFieldLenthValidators(element)
{
    //alert("hii"+ element.id);
    var i=0;
    if(element.id=="docName" || element.id=="webExUrl"  )
    {
        i=100;
    }
   
    if(element.value.replace(/^\s+|\s+$/g,"").length>i) {
       
        var str=new String(element.value);
        element.value=str.substring(0,i);
            
        //   document.getElementById("resultmessage").style.color= "red";
        // 	document.getElementById("resultmessage").innerHTML="The "+element.id+" length must be less than "+i+" characters";
        //  alert("here 11111111");
         
        document.getElementById("resultMessg").style.display='block';
        document.getElementById("addTopicsMessg").innerHTML='<div class="cal-sm-12"> The '+element.id+' length must be less than '+i+' characters</div>';
        // showAlertModal();
        //alert("The "+element.id+" length must be less than "+i+" characters");
        element.focus();
        return false;
    }
}


//reset user pwd
function resetuserPwd(){  
  
    var cofirmPwd = document.resetForm.confirmPassword.value;
    var newPassword = document.resetForm.newPassword.value;
    var userId = document.resetForm.userId.value;
    if(cofirmPwd=="" || cofirmPwd==null || newPassword=="" || newPassword==null || userId=="" || userId==null){
    
        // alert("Enter Details");
        showAlertModal("Please enter all details ");
        return (false);
    }else if(newPassword != cofirmPwd){     
        showAlertModal("password not matched!");
        //        alert("password not matched!");
        document.resetForm.newPassword.value = '';
        document.resetForm.confirmPassword.value = '';
        return (false);
    }else {
        return (true);
    }
}


// validation for edit registration page

function registrationEditValidation(){
  //  alert($('#profession').val());
   // alert('entered------------------')
    if($('#fname').val()==""||$('#fname').val()==null)
    {
        //alert("fnameeeeeeeeeeeeeee")
        showAlertModal("Enter First Name");
        alert("enter first name")  
        $('#fname').css("border", "1px solid red");
            
        return false;
    }
    
    
    if($('#lname').val()==""||$('#lname').val()==null)
    {
      //  alert("lllllllllllllln")
        showAlertModal("Enter Last Name");
           
        $('#lname').css("border", "1px solid red");
            
        return false;
    }
   
    if($('#email').val()==""||$('#email').val()==null)
    {
        showAlertModal("Enter Email");
        $('#email').css("border", "1px solid red");
        $('#email').focus();
        return false;
    }
   
    if($('#phoneNumber').val()==""||$('#phoneNumber').val()==null)
    {
        showAlertModal("Enter Phone Number");
        $('#phoneNumber').css("border", "1px solid red");
        $('#phoneNumber').focus();
        return false;
    }
    
    
   
    if($('#profession').val()=="1"){
        if($('#profession').val()==-1){
            showAlertModal("Select your Profession");
            $('#profession').css("border", "1px solid red");
            return false;
        }
        else
        {
         
             
            if($('#branch').val()==-1){
                showAlertModal("Select your branch");
                $('#branch').css("border", "1px solid red");
                return false;
            }
   
        
            else if($('#branch').val()=="Others")
            {
            
                if($('#frmOtherBranch').val()==""||$('#frmOtherBranch').val()==null)
                {
                    showAlertModal("Enter Branch Name");
                    $('#frmOtherBranch').css("border", "1px solid red");
                    $('#frmOtherBranch').focus();
                    return false;
                }
                
            }
            if($('#year').val()==-1){
                showAlertModal("Select your year of studing");
                $('#year').css("border", "1px solid red");
                return false;
            }
    
        }
   
    
            
    }
    else if($('#profession').val()=="2")
    {
        //alert($('#profession').val()+"1111111"+$('#frmCompany').val());
        if($('#frmCompany').val()==""||$('#frmCompany').val()==null)
        {
          //  alert("com name")
            showAlertModal("Enter Organisation name");
            $('#frmCompany').css("border", "1px solid red");
            $('#frmCompany').focus();
            return false;
        }
          
        if($('#frmDesignation').val()==""||$('#frmDesignation').val()==null)
        {
            showAlertModal("Enter Your Designation");
            $('#frmDesignation').css("border", "1px solid red");
            $('#frmDesignation').focus();
            return false;
        }      

                
    }
       
    else if($('#profession').val()=="3")
    {
       // alert($('#profession').val()+"1111111"+$('#location').val());
        if($('#collegeCode').val()==""||$('#collegeCode').val()==null)
        {
           // alert("com name")
            showAlertModal("Enter College Code");
            $('#collegeCode').css("border", "1px solid red");
            $('#collegeCode').focus();
            return false;
        }
        
          
        if($('#code').val()==""||$('#code').val()==null)
        {
           // alert("codeeeeeeeeeeee")
            showAlertModal("Enter code");
            $('#code').css("border", "1px solid red");
            $('#code').focus();
            return false;
        }
       // alert("location val-->"+$('#location').val());
        if($('#location').val().trim()==""||$('#location').val()==null)
        {
           // alert("looooooooooooo")
            showAlertModal("Enter location");
            $('#location').css("border", "1px solid red");
            $('#location').focus();
            return false;
        } 
          
    
    
    }
  //  alert("street val-->"+$('#street').val());
   
    //if($('#profession').val()=="3"){
      
    //  }
    if($('#street').val().trim()=="" || $('#street').val()==null)
    {
        //alert("streetttttttttttttttt")
        showAlertModal("Enter Street");
        $('#street').css("border", "1px solid red");
        $('#street').focus();
        return false;
    }
   
  // alert("city val-->"+$('#city').val());
    if($('#city').val().trim()==""||$('#city').val()==null)
    {
       // alert("cityyyyyyyyyyy")
        showAlertModal("Enter City");
        $('#city').css("border", "1px solid red");
        $('#city').focus();
        return false;
    }
    
    // alert("zipcode val-->"+$('#zipcode').val());
    if($('#zipcode').val().trim()==""||$('#zipcode').val()==null)
    {
       // alert("zipcodeeeeeeeeeeeeee")
        showAlertModal("Enter Zip Code");
        $('#zipcode').css("border", "1px solid red");
        $('#zipcode').focus();
        return false;
    }
   

}

//for edit reg page otherbranch field has to enable and disable  
function getRegBranch(flag){
    var branch=document.getElementById("branch").value;
    var branchHiddenValue=document.getElementById("branchHiddenValue").value;
    //  alert(flag); 
    //  alert(branchHiddenValue);
    
    if(flag=="onload"){
        if(branchHiddenValue=="ECE" || branchHiddenValue=="EEE" || branchHiddenValue=="CSE" || branchHiddenValue=="IT" || branchHiddenValue=="MCA"){
            document.getElementById("branchdiv").style.display="block";
        }
        else
        {
            document.getElementById("branch").value="Others";
            document.getElementById("frmOtherBranch").value=branchHiddenValue;
            //document.getElementById("branchdiv").style.display="none";
            document.getElementById("branchOtherDiv").style.display="block";
        }
    }
    else{
        if(document.getElementById("branch").value=="Others"){
            document.getElementById("branchOtherDiv").style.display="block";
        // alert("----frmOtherBranch----");
        } else{
            document.getElementById("branchOtherDiv").style.display="none";
        }
    
        
    }


}