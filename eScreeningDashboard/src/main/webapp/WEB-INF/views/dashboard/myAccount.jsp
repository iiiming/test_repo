<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html  ng-app="passwordChangeFormApp">
<head>
<title>My Account</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<script type="text/javascript" src="resources/js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/js/angular/angular.min.js"></script>
<script type="text/javascript" src="resources/js/dashboard/myAccount.js"></script>
<script type="text/javascript" src="resources/js/adminDashboardTabs.js"></script>
<link rel="icon" href="resources/images/valogo.ico" type="image/x-icon">
<link rel="SHORTCUT ICON" href="resources/images/valogo.ico" type="image/x-icon" />
<link href="resources/css/partialpage/standardtopofpage-dashboard.css" rel="stylesheet" type="text/css">
<link href="resources/css/partialpage/menu-partial.css" rel="stylesheet" type="text/css">
<link href="resources/css/userManagement.css" rel="stylesheet" type="text/css">
<link href="resources/css/myAccount.css" rel="stylesheet" type="text/css">

<link href="resources/css/formButtons.css" rel="stylesheet" type="text/css"/>
<link href="resources/css/jquery/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript">	
    $(document).ready(function() {
    	tabsLoad("myAccount");
    	
    	/* The following code is  show and hide the angularjs validations for all  browsers. */
    	$("#currentPassword").click(function(){
    		$(this).removeClass("ng-pristine");
    		$("#newPassword").addClass("ng-pristine");
    		$("#confirmedPassword").addClass("ng-pristine")
    		
    	});
		$("#newPassword").click(function(){
			$(this).removeClass("ng-pristine");
    		$("#currentPassword").addClass("ng-pristine");
    		$("#confirmedPassword").addClass("ng-pristine")
    	});
		$("#confirmedPassword").click(function(){
			$(this).removeClass("ng-pristine");
    		$("#currentPassword").addClass("ng-pristine");
    		$("#newPassword").addClass("ng-pristine")
		});
    });
</script>




<script type="text/javascript">
   
   $(document).ready(function() {
	   
	   
	   
	   
	   
		       $.ajax({
		          type : 'get',
		           url : 'myAccount/services/users/active/myInfo', // in here you should put your query 
		           data :  '',
			       success : function(data)
			           {								
			             $('.acc_firstName').empty().html(data['firstName']);
			             $('.acc_middleName').empty().html(data['middleName']);
			             $('.acc_lastName').empty().html(data['lastName']);
			             $('.acc_phoneNumber').empty().html(data['phoneNumber']);
			             $('.acc_emailAddress').empty().html(data['emailAddress']);
			             
			             $('.acc_roleName').empty().html(data['roleName']);
			             
			             var cprsVerified = data['cprsVerified'];
			             if(cprsVerified == "false"){
			            	 $('.acc_cprsVerified').empty().html("Not Verified");
			            	 $(".user_verification_link").removeClass("hide");
			             }else{
			            	 $('.acc_cprsVerified').empty().html("Verified");
			            	 $(".user_verification_link").addClass("hide");
			             }
			             
			           }
		    	});
		       
		       
		       
		       $('#verifyForm').submit(function(){
		    	   	  
		    	   	  var accessCode = $('#cprsAccessCode').val();
				      var verifyCode = $('#cprsVerifyCode').val();
				      
				     
				      $('#btn_verify').button();
				      $("#btn_verify").button('loading');
				      
			
				       $.ajax({
				          type : 'post',
				           url : 'myAccount/services/users/active/verifyVistaAccount', // in here you should put your query 
				           data :  'accessCode='+ accessCode + '&verifyCode=' + verifyCode, // here you pass your id via ajax . vid & vien
				                     // in php you should use $_POST['post_id'] to get this value 
				       success : function(r)
				           {
				    	   	
				    	   	var isSuccessful = r['isSuccessful'];
				    	   	var userMessage = r['userMessage'];
				    	   	//isSuccessful = "true";
				    	   	
				    	   	if(isSuccessful == "true"){
				    	   		$("#verification_message").removeClass("hide");
				    	   		$("#verification_message").addClass("alert-success");
				    	   		$("#verification_message").removeClass("alert-danger");
				    	   		$('#verification_message').empty().html(userMessage);
				    	   		$('.acc_cprsVerified').empty().html("Verified");
				    	   		$(".user_verification_link, #btn_verify").addClass("hide");
				    	   		$('#btn_close').text("Continue");
								$(':input','#verifyForm')
									.not(':button, :submit, :reset, :hidden')
								 	.val('');
				    	   		
				    	   	}else{
				    	   		$("#verification_message").removeClass("hide");
				    	   		$("#verification_message").addClass("alert-danger");
				    	   		$("#verification_message").removeClass("alert-success");
				    	   		$('#verification_message').empty().html(userMessage);
				    	   		$("#btn_verify").removeAttr('disabled');
				    	   		$("#btn_verify").removeClass('disabled');
				    	   		$("#btn_verify").text('Verify Now');


								$(':input','#verifyForm')
									.not(':button, :submit, :reset, :hidden')
								 	.val('');
 
				    	   	 	//$("#btn_verify").removeClass("disabled");

				    	   	}
				    	   	
		
				           }
				    });
					
				});

		       
		       
		   
       	    
		      
		       
		       
		       
		       // Call verify from outside links ...
		       var hash = window.location.hash;
		       if (hash == "#verify") {
		          $('#verify_modal').modal({
		         	 keyboard: false,
		         	 backdrop: 'static'
		          });
		       }
		       
		    // Handle close event
		  	    $("#verify_modal").on('hidden.bs.modal', function () {	
		  	    	$("#cprsAccessCode").val("");
		  	    	$("#cprsVerifyCode").val("");
		  	    	$("#verification_message").addClass("hide");
		  	    });
			    
		  	  
		       
   });
     
</script>

<!-- Bootstrap -->
<link href="<c:url value="/resources/js/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard_new.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<!--<div id="outerPageDiv" ></div>-->
  <%@ include file="/WEB-INF/views/partialpage/standardtopofpage-partial.jsp" %>
  <div class="navbar navbar-default navbar-update" role="navigation">
    <div class="container bg_transparent">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      </div>
      <nav class="navbar-collapse collapse">
        <ul class="nav navbar-nav" id="tabs">
        </ul>
      </nav>
      <!--/.nav-collapse --> 
    </div>
  </div>
  <div id="bodyDiv" class="bgImgMiddle_">
    <div ng-controller="myAccountController"  class="formDiv_">
      <div class="container left-right-shadow">
        <div class="row">
          <div class="col-md-12">
            <h1>My Account</h1>
            
            <div class="assessmentDashboardForm">
            <form name="changePasswordForm" novalidate ng-submit="submitMyForm(myAccountFormBean)">
              <div class="row">
                <div class="col-md-4">
                  <div class="form-group">
                    <label class="control-label_" for="currentPassword">Current Password</label>
                    <input type="password" id="currentPassword" name="currentPassword" placeholder="Current password" required ng-model="myAccountFormBean.currentPassword" class="form-control">
                    <div id="pwdRequiredId" class="input-help"> Current password is required </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label_" for="newPassword">New Password</label>
                    <input class="immediate-help form-control" id="newPassword" name="newPassword" password-validate required type="password" id="inputPassword" placeholder="New password" ng-model="myAccountFormBean.newPassword">
                    <div class="input-help errorMargin">
                      <h4>Password must meet the following requirements:</h4>
                      <ul>
                        <li ng-class="pwdHasLetter">At least <strong>one small letter</strong></li>
                        <li ng-class="pwdHasNumber">At least <strong>one number</strong></li>
                        <li ng-class="pwdValidLength">At least <strong>8 characters long</strong></li>
                        <li ng-class="pwdHasCapital">At least <strong>one capital letter</strong></li>
                        <li ng-class="pwdHasSpecial">At least <strong>one special character</strong></li>
                      </ul>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="control-label_" for="confirmedPassword">Confirm Password</label>
                    <input class="immediate-help form-control" id="confirmedPassword"  name="confirmedPassword" password-validate  match-data="newPassword" required type="password" id="confirmPassword" placeholder="Confirm password" ng-model="myAccountFormBean.confirmedPassword" >
                    <div class="input-help">
                      <h4>Confirmed password should match with new password</h4>
                    </div>
                  </div>
                  <div class="changePasswordBtns">
                    <button type="submit" id="submitButton" class="submitButton btn btn-primary form-control">Change Password</button>
                    <button class="submitButton btn btn-primary form-control" disabled>Change Password</button>
                  </div>
                </div>
              	
                <div class="col-md-4"><br>
                  <div class="border-radius-main-form gray-lighter">
                  		
                        
                        

                    
                    
                    <div class="row">
                    	<div class="col-md-12">
                        	<h2><span class="acc_lastName"></span>, <span class="acc_firstName"></span> <span class="acc_middleName"></span></h2><br>
							
                            <label>CPRS Verified</label>
                            <div><span class="acc_cprsVerified"></span> <span class="user_verification_link hide"><a href="#"  data-toggle="modal" data-target="#verify_modal" data-controls-modal="#verify_modal"  data-backdrop="static"  data-keyboard="false"> (Click here to verify your account)</a></span></div><br>
							<label>Email Address</label>
                            <div><span class="acc_emailAddress"></span></div><br>
                            
                            <label>Phone Number</label>
                            <div><span class="acc_phoneNumber"></span></div><br>
                            
                            
                            <label>User Role</label>
                            <div><span class="acc_roleName"></span></div><br>
                            
                        </div>
                    </div>
                    
                    
                    
                    
            
                    
                   
                    
                   
                    



                  </div>
                </div>
              </div>
              
              <br/>
              <div align="center" id="successDiv"></div>
              <!-- to display the success message  -->
             
            </form>
            
            
            
             <!-- Modal -->
                    <div class="modal fade" id="verify_modal" tabindex="-1" role="dialog" aria-labelledby="verify_modal_label" aria-hidden="true">
                      <div class="modal-dialog">
                        <div class="modal-content">
                        
                        
                         <form name="verifyForm" id="verifyForm">
                          <div class="modal-header">
                            <button type="button" id="close_ico" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="verify_modal_label">Verify VistA Account</h4>
                          </div>
                          <div class="modal-body">
                          
                          
                           <div class="alert alert-success hide" id="verification_successed">Your account has been verified successfully! Thank You.</div>
                           <div class="alert hide" id="verification_message"></div>
                           
                           <div><div id="cprsAccessCodeError" style="display:none;"></div>

							<div class="row">
                            	<div class="col-md-6">
                                <div class="form-group">
                                <label>Access Code:</label>
                                <input type="password" id="cprsAccessCode" class="form-control" placeholder="Enter Access Code" maxlength="30"  required="required" />
                                
                                <div id="cprsVerifyCodeError" style="padding-left:231px;display:none;"></div>
                            </div>
                                </div>
                                <div class="col-md-6">
                                 <div class="form-group">
                                    <label>Verify Code:</label>
                                   	<input type="password" id="cprsVerifyCode" class="form-control" placeholder="Enter Verify Code"  maxlength="30" required/>
                                   <div id="errorDiv" align="center" style="color:red;"></div>
                            	</div>
                                </div>
                            </div>
                            

                           
     
                             
                           
                           
                           
                           
                          </div>
                          <div class="modal-footer">
                          
                          	<div class="btns_verify_block">
	                            <button type="button" class="btn btn-default" data-dismiss="modal" id="btn_close">Close</button>
	                            <button type="submit" class="btn btn-primary" id="btn_verify" data-text-loading="Verifying...">Verify Now</button>
                            </div>

                          </div>
                         </form> 
                          
                          
                          
                        </div>
                      </div>
                    </div>
                    
                    
                    
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@ include file="/WEB-INF/views/partialpage/footer.jsp" %>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/js/bootstrap.js" />"></script>
</body>
</html>
