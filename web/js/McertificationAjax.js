/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




function showDetailResult(examKey){
    $('#myModal8').modal('show');
     
     
}




function getExamResultsByTopicId(topicId,userId){
    $("#resultData").html("");
    
    //$("#loadingSpan").html('<font color=red>Processing please wait</font>');
    $.ajax({
        url:'ajax/getExamResultsByTopicId.action?topicId='+topicId+'&userId='+userId,//
        context: document.body,
        success: function(responseText) {
//          alert(responseText);
            if(responseText!='{}')
            {
                var jsonObj = $.parseJSON(responseText);
             
                var resultData = '<table class="table t_st03"><thead><tr><th> <i class="fa fa-calculator" aria-hidden="true"></i> TotalMarks</th><th><i class="fa fa-check" aria-hidden="true"></i> MarksObtained</th><th><i class="fa fa-check-circle-o" aria-hidden="true"></i> AttemptedQuestions</th><th><i class="fa fa-calendar" aria-hidden="true"></i> DateSubmitted</th><th> <i class="fa fa-hourglass" aria-hidden="true"></i> Status</th></tr></thead><tbody>';
                $.each(jsonObj, function(key,val){
                    resultData = resultData+'<tr><td>'+val.TotalQuestions+'</td><td>'+val.Marks+'</td><td>'+val.AttemptedQuestions+'</td><td>'+val.DateSubmitted+'</td><td>'+val.ExamStatus+'</td></tr>'
                     
                     
                     
                
                     
                //  var subJsonObj = $.parseJSON(val);
                //  alert(subJsonObj["examType"]);
                //  alert( val.examType);
                //        alert("key : "+key+" ; value : "+subJsonObj["examType"]);
                //        alert("key : "+key+" ; value : "+subJsonObj["Marks"]);
                //        alert("key : "+key+" ; value : "+subJsonObj["TotalQuestions"]);
                //        alert("key : "+key+" ; value : "+subJsonObj["AttemptedQuestions"]);
                //        alert("key : "+key+" ; value : "+subJsonObj["DateSubmitted"]);
                //        alert("key : "+key+" ; value : "+subJsonObj["ExamStatus"]);
                //        alert("key : "+key+" ; value : "+subJsonObj["examKeyId"]);
        
        
                });
                resultData = resultData+'</tbody></table>';
                //resultData
             //   $("#loadingSpan").html('');
                $("#resultData").html(resultData);
                $("#myModal1").modal('show');
            }
            else
            {
                    
                showAlertModal('No result found');
            }
        }, 
        error: function(e){
                
            alert("error-->"+e);
        }
    });
    document.getElementById("loadingAcoountSearch").style.display = "none";
//$('#myModal').colorbox.resize();
}

