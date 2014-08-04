<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="resources/js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/adminDashboardTabs.js"></script>

<link href="resources/css/jquery/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css" />

<link href="resources/images/valogo.ico" rel="icon" type="image/x-icon" />
<link href="resources/images/valogo.ico" rel="SHORTCUT ICON" type="image/x-icon" />

<link href="resources/css/partialpage/standardtopofpage-dashboard.css" rel="stylesheet" type="text/css" />
<link href="resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<link href="resources/css/partialpage/menu-partial.css" rel="stylesheet" type="text/css" />
<link href="resources/css/veteranSearch.css" rel="stylesheet" type="text/css" />
<link href="resources/css/formButtons.css" rel="stylesheet" type="text/css" />

<!-- Bootstrap -->
<link href="<c:url value="/resources/js/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard_new.css" />" rel="stylesheet" type="text/css" />


<title>Create Battery</title>

<script type="text/javascript">
	$(document).ready(function() {
		tabsLoad("createBattery");
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

				<h1>Create Battery</h1>

				<c:if test="${!isCprsVerified}">
					<div class="alert alert-danger">
						Your VistA account information needs to be verified before you can save or read any data from VistA. 
						Search result will not include any data from VistA. 
					</div>
				</c:if>

				<c:if test="${isReadOnly}">
					<div class="alert alert-danger">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						This battery is read only and no longer editable.
					</div>
				</c:if>

                <div class="border-radius-main-form">
                    <div class="row">
                        
						<div class="col-md-6">
							Name (Last, First Middle)
							<div class="txt_lable_lg">
								<c:out value="${veteran.fullName}" />
							</div>
						</div>
						<div class="col-md-3">
							Status
							<div class="txt_lable_lg">
								<c:choose>
								      <c:when test="${(!empty veteran.veteranId) && (empty veteran.veteranIen)}">
								      	<div>Only Exists in DB</div>
								      </c:when>
									  <c:when test="${(!empty veteran.veteranIen) && (empty veteran.veteranId)}">
								      	<div>Only Exists in VistA</div>
								      </c:when>
								       <c:when test="${(!empty veteran.veteranIen) && (!empty veteran.veteranId)}">
								      	<div>Mapped Veteran</div>
								      </c:when>
								      <c:otherwise>
								      </c:otherwise>
								</c:choose>	
							</div>
						</div>
                        
                        <div class="col-md-2">
                            Date of Birth
                            <div class="txt_lable_lg">
                                <fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${veteran.birthDate}" />
                            </div>
                        </div>
                        <div class="col-md-1 text-right">
                            SSN-4
                            <div class="txt_lable_lg text-right">
                                <c:out value="${veteran.ssnLastFour}" />
                            </div>
                        </div>
                    </div>

                    <hr />

                    <div class="row">
                        <div class="col-md-2">
                            Phone
                            <div class="txt_lable_md">
                                <c:out value="${veteran.phone}" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            Work
                            <div class="txt_lable_md">
                                <c:out value="${veteran.workPhone}" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            Cell
                            <div class="txt_lable_md">
                                <c:out value="${veteran.cellPhone}" />
                            </div>
                        </div>
                        <div class="col-md-4">
                            Email
                            <div class="txt_lable_md">
                                <c:out value="${veteran.email}" />
                            </div>
                        </div>
                        <div class="col-md-2 text-right">
                            VistA IEN
                            <div class="txt_lable_md">
                                <c:out value="${veteran.veteranIen}" />
                            </div>
                        </div>
                    </div>
                </div>

                <br/>
				
				<c:if test="${not isCreateMode}">
					<div class="border-radius-main-form">
						<div class="row">
							<div class="col-md-2">
								Battery ID
								<div class="txt_lable_md">
									<c:out value="${editVeteranAssessmentFormBean.veteranAssessmentId}" />
								</div>
							</div>
							<div class="col-md-2">
								Status
								<div class="txt_lable_md">
									<c:out value="${veteranAssessmentStatus}" />
								</div>
							</div>
							<div class="col-md-4">
								Created By
								<div class="txt_lable_md">
									<c:out value="${createdByUser}" />
								</div>
							</div>
							<div class="col-md-2">
								Date Created
								<div class="txt_lable_md">
									<fmt:formatDate type="both" pattern="MM/dd/yyyy HH:mm:ss" value="${dateCreated}" />
								</div>
							</div>
							<div class="col-md-2">
								Date Completed
								<div class="txt_lable_md">
									<fmt:formatDate type="both" pattern="MM/dd/yyyy HH:mm:ss" value="${dateCompleted}" />
								</div>
							</div>
						</div>
					</div>
				</c:if>



				<div>
					<form:form modelAttribute="editVeteranAssessmentFormBean" autocomplete="off" method="post">
						<form:hidden path="veteranId"/>
						<form:hidden path="veteranAssessmentId"/>

						<form:errors path="*" element="div" cssClass="alert alert-danger" />
						<br />
						
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<form:label path="selectedProgramId">Program *</form:label>
									<form:select path="selectedProgramId" cssClass="form-control" disabled="${isReadOnly}">
										<form:option value="" label="Please Select a Program"/>
										<form:options items="${programList}" itemValue="stateId" itemLabel="stateName"/>
									</form:select>
									<form:errors path="selectedProgramId" cssClass="help-inline"/>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<form:label path="selectedClinicId">VistA Clinic *</form:label>
									<form:select path="selectedClinicId" cssClass="form-control" disabled="${isReadOnly}">
										<form:option value="" label="Please Select a Clinic"/>
										<form:options items="${clinicList}" itemValue="stateId" itemLabel="stateName"/>
									</form:select>
									<form:errors path="selectedClinicId" cssClass="help-inline"/>
								</div>
							</div>
							<div class="col-md-3">								
								<div class="form-group">
									<form:label path="selectedNoteTitleId">Note Title *</form:label>
									<form:select path="selectedNoteTitleId" cssClass="form-control" disabled="${isReadOnly}">
										<form:option value="" label="Please Select a Note Title"/>
										<form:options items="${noteTitleList}" itemValue="stateId" itemLabel="stateName"/>
									</form:select>
									<form:errors path="selectedNoteTitleId" cssClass="help-inline"/>
								</div>
							</div>
							<div class="col-md-3">								
								<div class="form-group">
									<form:label path="selectedClinicianId">Clinician *</form:label>
									<form:select path="selectedClinicianId" cssClass="form-control" disabled="${isReadOnly}">
										<form:option value="" label="Please Select a Clinician"/>
										<form:options items="${clinicianList}" itemValue="stateId" itemLabel="stateName"/>
									</form:select>
									<form:errors path="selectedClinicianId" cssClass="help-inline"/>
								</div>
							</div>
						</div>

						<hr/>

						<div class="row">
							<div class="col-md-12">






								<h4>Please Select Screening Modules for the Veteran</h4>
								<div class="border_box">
								

								<div class="row">
									<div class="col-md-4">
										<h4>Battery</h4>


										
                                        <div class="radio_block">
                                        	<c:forEach var="item" items="${batteryList}">
                                        		
                                            </c:forEach>
                                            <form:errors path="selectedBatteryId" cssClass="help-inline"/>
										</div>

										
										<hr />
												<div class="row">
													<div class="col-md-6 padding_5"><div class="border_right_gray text-center"><strong>Highlight & Select Screening Modules</strong></div></div>
													<div class="col-md-6 padding_5"><div class="text-center"><strong>Highlight Screening Modules</strong></div></div>
												</div>
												<hr />
												
										<ul class="battery_list" style="padding: 0px">

											<li>
												
											</li>

											<c:forEach var="item" items="${batteryList}">
												<!--extract the relationship between this battery and program. Means extract all the programs this battery belongs to -->
												<li class="${programsMap[item.stateId]}"><!-- program_1 - Khalid please add value here -->
													<div class="row">
														<div class="col-md-6 padding_5">
														<div class="radio border_right_gray">
		                                        			<form:radiobutton path="selectedBatteryId" value="${item.stateId}" label="${item.stateName}" cssClass="battery_${item.stateId}" disabled="${isReadOnly}" /> 
		                                            	</div>
		                                            	</div>
														<div class="col-md-6 padding_5">
															<span class="battery_${item.stateId} battery_highlight_${item.stateId}"><a href="#" class="btn btn-warning btn-block highlight_module_item" role="button"><span class="glyphicon glyphicon-bookmark"></span> Highlight <c:out value="${item.stateName}" /></a></span>
														</div>
													</div>
												</li>
											</c:forEach>

											
										</ul>	
										
										<hr />
											<span  class="clear_all"><a href="#" class="btn btn-default btn-xs" role="button">Clear all </a></span> <span  class="reset"><a href="#" class="btn btn-default btn-xs" role="button">Reset </a></span>
											<hr />					
									</div>

									<div class="col-md-8">
				    					<table class="table table-striped table-hover module_list">
				    						<thead>
				    							<tr>
				    								<th scope="col" class="col-md-6">Screening Module</th>
				    								<th scope="col" class="col-md-3">Description</th>
				    								<th scope="col" class="col-md-3">Notes</th>
				    							</tr>
				    						</thead>
				    						<tbody>
											    <c:forEach var="item" items="${surveyList}">
				                                    <tr>
				                                        <td>
				                                            <c:set var="classNameVar" value=" " />
				                                            <c:forEach var="battery" items="${item.batteryList}">
				                                                <c:set var="classNameVar">
				                                                    <c:out value="${classNameVar} battery_${battery.batteryId}"  />
				                                                </c:set>
				                                            </c:forEach>
				                                            <form:checkbox path="selectedSurveyIdList" value="${item.surveyId}" label="${item.name}" cssClass="${classNameVar}" disabled="${isReadOnly}" />
				                                        </td>
				                                        <td><c:out value="${item.description}" /></td>
				                                        <td><c:out value="${item.note}" /></td>
				                                    </tr>
				                                </c:forEach>                
				    						</tbody>
				    					</table>
			    					</div>
								</div>

								<div class="row">
									<div class="col-md-8 col-md-offset-4 text-right ">
										<c:if test="${not isReadOnly}">
											<input id="saveButton" name="saveButton" value="Save" type="submit" class="btn btn-primary" />
										</c:if>
										<c:if test="${isReadOnly}">
											<input id="saveButton" name="saveButton" value="Save" type="submit" disabled class="btn btn-primary" />
										</c:if>
		                        		<input id="cancelButton" name="cancelButton" value="Cancel" type="submit" class="btn btn-default" />
									</div>
								</div>
								
								</div>
								
								
								
								
								
								
								
								
								
							</div>
						</div>
					</form:form>

					<div class="clear-fix"></div>
				</div>
			</div>
		</div>
	</div>

	<br />
	<br />
</body>

<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/js/bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dashboard/editVeteranAssessment.js" />"></script>



</html>
