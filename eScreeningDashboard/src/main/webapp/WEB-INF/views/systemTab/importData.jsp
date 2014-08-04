<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.10.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/adminDashboardTabs.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/systemTab/importData.js" />"></script>

<link href="<c:url value="/resources/images/valogo.ico" />" rel="icon" type="image/x-icon" />
<link href="<c:url value="/resources/images/valogo.ico" />" rel="SHORTCUT ICON" type="image/x-icon" />

<link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/jquery.dataTables.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/partialpage/menu-partial.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/veteranSearch.css" />" rel="stylesheet" type="text/css" />


<!-- Bootstrap -->
<link href="<c:url value="/resources/js/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard_new.css" />" rel="stylesheet" type="text/css" />


<title>Import Data</title>

<script type="text/javascript">
	$(document).ready(function() {
		tabsLoad("systemConfiguration");
	});
	

</script>

<style type="text/css">

	
</style>
</head>
<body>

	<div id="outerPageDiv">
		<%@ include file="/WEB-INF/views/partialpage/standardtopofpage-partial.jsp"%>

		<div class="navbar navbar-default navbar-update" role="navigation">
			<div class="container bg_transparent">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<nav class="navbar-collapse collapse">
					<ul class="nav navbar-nav" id="tabs">
					</ul>
				</nav><!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="mainDiv">
	</div>

	<div class="container left-right-shadow">
		<div class="row">
			<div class="col-md-12">

				<h1>Import Data</h1>

				<c:if test="${!isCprsVerified}">
					<div class="alert alert-danger">
						Your VistA account information needs to be verified before you can save or read any data from VistA. 
						Features on this page will be disabled.  <a href="myAccount#verify" ><strong>Click here to verify</strong></a>
					</div>
				</c:if>

				<div>
					<!--<form:form autocomplete="off" method="post"></form:form>-->
						
						
						<div class="row">
							<div class="col-md-4">
								<div class="border-radius-box-a ">
									<div class="gray-lighter border-bottom-solid-gray">
										<h3>Import VistA Clinic List from VistA</h3>
									</div>
									<div class="box-padding-10  text-center">
										<p class="min-height-140">
											Clinics that appear in dropdown downboxes and throughout the eScreening are from VistA. 
											Use the button below to import any new clinics into the system. A message will indicate 
											the number of new clinics added to the system, if any.
										</p>

										<hr />

										<c:if test="${isCprsVerified}">
											<button id="importClinicListButton" name="importClinicListButton" class="btn btn-primary btn_import"  data-toggle="modal"
	                                        	data-target="#import_modal" data-case="case_clinic" data-content="Are you sure you want to import clinic lists data from VistA?"
	                                            data-title="Import VistA Clinic List">Import VistA Clinic List</button>
										</c:if>
										<c:if test="${!isCprsVerified}">
											<button id="importClinicListButton" name="importClinicListButton" class="btn btn-primary btn_import"  data-toggle="modal" disabled
	                                        	data-target="#import_modal" data-case="case_clinic" data-content="Are you sure you want to import clinic lists data from VistA?"
	                                            data-title="Import VistA Clinic List">Import VistA Clinic List</button>
										</c:if>
									</div>
								</div>
							</div>
							

							<div class="col-md-4">
								<div class="border-radius-box-a">
									<div class="gray-lighter border-bottom-solid-gray">
										<h3>Import Clinical Reminder List from VistA</h3>
									</div>
									<div class="box-padding-10  text-center">
										<p class="min-height-140">
											Clinical Reminder names that appear in dropdown downboxes and throughout the eScreening are from VistA. 
											Use the button below to import any new clinical reminder names into the system. A message will indicate 
											the number of new clinical reminder names added to the system, if any.
										</p>

										<hr />

										<c:if test="${isCprsVerified}">
											<button id="importClinicalReminderListButton" name="importClinicalReminderListButton" type="submit" class="btn btn-primary btn_import" 
	                                        	data-toggle="modal" data-target="#import_modal" data-case="case_clinic_reminder" 
	                                            data-content="Are you sure you want to import Clinical Reminder Lists from VistA?"
	                                            data-title="Import Clinical Reminder List">Import Clinical Reminder List</button>
										</c:if>
										<c:if test="${!isCprsVerified}">
											<button id="importClinicalReminderListButton" name="importClinicalReminderListButton" type="submit" class="btn btn-primary btn_import" disabled
	                                        	data-toggle="modal" data-target="#import_modal" data-case="case_clinic_reminder" 
	                                            data-content="Are you sure you want to import Clinical Reminder Lists from VistA?"
	                                            data-title="Import Clinical Reminder List">Import Clinical Reminder List</button>
										</c:if>
									</div>
								</div>
							</div>
							
							
							<div class="col-md-4">
								<div class="border-radius-box-a">
									<div class="gray-lighter border-bottom-solid-gray">
										<h3>Import Note Title List from VistA</h3>
									</div>
									<div class="box-padding-10  text-center">
										<p class="min-height-140">
											Note Titles that appear in dropdown downboxes and throughout the eScreening are from VistA. 
											Use the button below to import any new note titles into the system. A message will indicate 
											the number of new note titles added to the system, if any.
										</p>

										<hr />

										<c:if test="${isCprsVerified}">
											<button id="importNoteTitleListButton" name="importNoteTitleListButton"  type="submit" class="btn btn-primary btn_import" 
	                                        	data-toggle="modal" data-target="#import_modal" data-case="case_note" data-content="Are you sure you want to import Note Title List from VistA?"
	                                            data-title="Import Notes Titles List">Import Note Title List</button>
										</c:if>
										<c:if test="${!isCprsVerified}">
											<button id="importNoteTitleListButton" name="importNoteTitleListButton"  type="submit" class="btn btn-primary btn_import" disabled
	                                        	data-toggle="modal" data-target="#import_modal" data-case="case_note" data-content="Are you sure you want to import Note Title List from VistA?"
	                                            data-title="Import Notes Titles List">Import Note Title List</button>
										</c:if>
									</div>
								</div>
							</div>

						</div>
						
					
				 
						
						<!-- Modal -->
						<div class="modal fade" id="import_modal" tabindex="-1" role="dialog" aria-labelledby="import_modal_label" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      
                              <form name="verifyForm" id="verifyForm">
                                  <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="import_modal_label">Import Clinic List</h4>
                                  </div>
                                  <div class="modal-body">
                                    <div class="alert alert-info" id="verification_message">Are you sure you want to import clinic lists data from VistA?</div>
                                    
                                    
                                    <div class="alert alert-success hide" id="verification_successed">Your account has been verified successfully! Thank You.</div>
                           			<div class="alert hide" id="verification_message"></div> 
    
                                  </div>
                                  <div class="modal-footer">
                                  	<div class="btns_verify_block">
                                  		<button type="submit" class="btn btn-primary" id="btn_verify"  data-text-loading="Loading...">Yes</button>                                 
                                        <button type="button" class="btn btn-default" data-dismiss="modal" id="btn_close">Cancel</button>
                                    </div>
                                  </div>
                              </form>

                              
						    </div>
						  </div>
						</div>
						
					<div class="clear-fix"></div>
				</div>
			</div>
		</div>
	</div>

	


<%@ include file="/WEB-INF/views/partialpage/footer.jsp" %>
	
</body>

<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/js/bootstrap.js" />"></script>




</html>
