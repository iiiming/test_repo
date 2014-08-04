<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
	<head>
    	<meta name="viewport" content="width=device-width, initial-scale=1">

	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" name="viewport" content="user-scalable=no,width=device-width" />
	<script type="text/javascript" src="resources/js/jquery/jquery-1.10.2.js"></script>
    
	<!-- FAVICON -->
	<link rel="SHORTCUT ICON" href="resources/images/valogo.ico" type="image/x-icon">
	<link rel="icon" href="resources/images/valogo.ico" type="image/x-icon" />    
	<link rel="apple-touch-icon" sizes="114x114" href="resources/images/favico_va_touch_114x114.png" />
	<link rel="apple-touch-icon" sizes="72x72" href="resources/images/favico_va_touch_72x72.png" />
	<link rel="apple-touch-icon" href="resources/images/favico_va_touch_57x57.png" />
    <meta name="msapplication-square310x310logo" content="resources/images/favico_va_310x310.png" />
    	
    <title>Veteran Login</title>
	<link href="resources/css/partialpage/standardtopofpage-partial.css" rel="stylesheet" type="text/css"/>
	<link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
	<link href="resources/css/common-ui-styles/forms.css" rel="stylesheet" type="text/css">
	<link href="resources/css/formButtons.css" rel="stylesheet" type="text/css"/>
	<link href="resources/css/partialpage/menu-partial.css" rel="stylesheet" type="text/css"/>
	<link href="resources/css/mobileStyle/mediaQueryMain.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
		$(function() {
			$("#assessmentLoginForm").submit(function(event){ 
		   		showLoading();
		   		event.preventDefault();
		   		this.submit();
			}); 
			if($("#lastName").val().length > 0){
				$("#errorDiv").removeClass("input-help");
				$("#errorImage").hide();
			}else{
				$("#errorDiv").addClass("input-help");
				$("#errorImage").show();
			}
			if($("#lastFourSsn").val().length > 3){
				var regex =  /^\d+$/;
				if(regex.test($("#lastFourSsn").val())){
					$("#lastFourSsnErrorDiv").removeClass("input-help");
					$("#lastFourSsnErrorDiv").removeAttr("style");
					$("#lastFourSsnImage").hide();
				}else{
					$("#lastFourSsnErrorDiv").addClass("input-help");
					$("#lastFourSsnImage").show();
				}
			}else{
				$("#lastFourSsnErrorDiv").addClass("input-help");
				$("#lastFourSsnImage").show();
			}
			 if($("#birthDate").val() != ""){
				$("#birthDateErrorDiv").removeClass("input-help");
				$("#birthDateErrorDiv").removeAttr("style");
			}else{
				$("#birthDateErrorDiv").addClass("input-help");
			}
			if($("#middleName").val() != ""){
				$("#middleNameErrorDiv").removeClass("input-help");
				$("#middleNameErrorDiv").removeAttr("style");
			}else{
				$("#middleNameErrorDiv").addClass("input-help");
			} 
			
			
			$("#logoutReason").click(function(){$(this).slideUp(300);});
			
			$("<img/>")
				.attr("src", "resources/images/submitting.gif")
				.attr("alt", "loading")
				.attr("id", "loading_image")
				.addClass("submitImg")
				.hide()
				.appendTo($("#veteranLoginButtonWrapper"));
			
		});
		function showLoading(){ // show loding indicator and disable submit button
			var buttonWrapper = $("#veteranLoginButtonWrapper");
			buttonWrapper.find("#veteranLogin").hide();
			buttonWrapper.find("#loading_image").show();
		}
	</script>

	<!-- Bootstrap -->
	<link href="<c:url value="/resources/js/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard_new.css" />" rel="stylesheet" type="text/css">
	</head>
	<body>

      
    
    
    
    <%@ include file="/WEB-INF/views/partialpage/survey_header_new.jsp" %>
	<div id="clear-fix"></div>
<div class="container left-right-shadow">
      
      <div class="row">
    <div class="col-md-6  col-md-offset-3 main_container_login">
     	<h1 class="text-center">Veteran Login</h1>
     	
     	<div id="logoutReason">
  
    		<% if("timeout".equalsIgnoreCase(request.getParameter("reason"))){
				 	out.println("<div class='alert alert-warning'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><img alt=\"logged out due to inactivity\" title=\"logged out due to inactivity\" src=\"resources/images/warning-triangle.png\">");
			 		out.println("You have been logged out due to a period of inactivity.<br/>Please log back in to continue.</div>");    
			     }
		 
			    //another option is "complete" which is passed here when the user just completed their screening
			    if("complete".equalsIgnoreCase(request.getParameter("reason"))){
			 		out.println("<div class='alert alert-warning'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>You have successfully completed your assessment!</div>");    
			    }
			 %>
  	</div>
  	
  	
        <form:form id="assessmentLoginForm" method="post" modelAttribute="assessmentLoginFormBean" autocomplete="off" role="form">
       
        <%-- <div><span class="requireMark">*</span> indicates required fields</div> --%>
        <c:if test="${assessmentLoginFormBean.additionalFieldRequired}">
              <div id="formError" class="alert alert-info"> Additional information is required to log in. Please enter your Date of Birth and Middle Name. </div>
        </c:if>
        <c:if test="${not empty loginErrorMessage}">
              <div class="alert alert-danger">${loginErrorMessage}</div>
        </c:if>
        <s:bind path="*">
           <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <form:label path="lastName">Last Name</form:label>
                    <form:input path="lastName" id="lastName" class="immediate-help form-control input-lg" maxlength="30" tabindex="1" placeholder="Enter Last Name" />
                    <c:if test="${status.error}">
                          <div id="errorDiv" class="input-help"> <img id="errorImage" src="resources/images/errorIcon.jpg" class="errorImgWidth"/><form:errors path="lastName"/></div>
                     </c:if>
              	</div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
                  <div class="form-group">
                    <form:label path="lastFourSsn">Last Four SSN</form:label>
                    <form:input path="lastFourSsn" id="lastFourSsn" class="immediate-help form-control input-lg" maxlength="4" type="password" tabindex="2" placeholder="Enter Last Four SSN" />
                    <c:if test="${status.error}">
                          <div id="lastFourSsnErrorDiv" class="input-help errorInputStyle"> <img id="lastFourSsnImage" src="resources/images/errorIcon.jpg" class="errorImgWidth" /><form:errors path="lastFourSsn" /></div>
                    </c:if>
              	  </div>
             </div>
          </div>
              <c:if test="${assessmentLoginFormBean.additionalFieldRequired}">
            <div class="row">
                  <div class="col-md-12">
                <div class="form-group">


                          <form:label path="birthDate">Date of Birth</form:label>
                          <form:input path="birthDate" class="immediate-help form-control input-lg" maxlength="10" placeholder="MM/DD/YYYY"/>
                          <c:if test="${status.error}">
                        	<div id="birthDateErrorDiv" class="input-help "> <img id="birthDateImage" src="resources/images/errorIcon.jpg" class="errorImgWidth"/>
                              <form:errors path="birthDate" />
                            </div>
                      </c:if>


                    </div>
              </div>
                </div>
            <div class="row">
                  <div class="col-md-12">
                <div class="form-group">


                          <form:label path="middleName">Middle Name</form:label>
                          <form:input path="middleName" class="form-control input-lg"  maxlength="30" placeholder="Enter Middle Name" />
                          <c:if test="${status.error}">
                        	<div id="middleNameErrorDiv" class="input-help">
							  <!--  <img id="middleNameImage" src="resources/images/errorIcon.jpg" class="errorImgWidth"/> -->
                              <form:errors path="middleName" cssClass="error" />
                            </div>
                      </c:if>


                    </div>
              </div>
                </div>
          </c:if>
            </s:bind>

        <div class="row">
              <div class="col-md-12">
            <div class="form-group">
                  <form:hidden path="additionalFieldRequired" />
                  <div id="veteranLoginButtonWrapper" class="rightLogin_">
                <input type="submit" id="veteranLogin" class="submitButton btn btn-primary btn-block form-control btn-lg" value="Login">
              </div>
                </div>
          </div>
            </div>
      </form:form>
        </div>
  </div>
    </div>
<%@ include file="/WEB-INF/views/partialpage/footer.jsp" %>
</body>
</html>