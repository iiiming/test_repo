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
    <link href="<c:url value="/resources/css/jquery/jquery-ui-1.10.3.custom.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/images/valogo.ico" />" rel="icon" type="image/x-icon" />
    <link href="<c:url value="/resources/images/valogo.ico" />" rel="SHORTCUT ICON" type="image/x-icon" />
    <link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/jquery.dataTables.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/partialpage/menu-partial.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/veteranSearch.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/common-ui-styles/circle.css" />" rel="stylesheet" type="text/css" />
    
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/js/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/partialpage/standardtopofpage-dashboard_new.css" />" rel="stylesheet" type="text/css" />
    <title>Assessment Summary</title>
    <script type="text/javascript">
        $(document).ready(function() {
            tabsLoad("assessmentDashboard");
        });
    </script>
    <style type="text/css">
        /* for print preview styles  */
        @page { size: auto; margin: 17mm 0mm 16.12mm 0mm;}
        .container_main { width: 96%;  padding: 0 2%; margin: 0 auto;}
        .templateHeader { }
        .templateFooter { }
        .templateSectionTitle { font-weight:bold; }
        .templateSection { }
        .moduleTemplateTitle { font-weight: bold; }
        .moduleTemplateText { margin: 10px 0 20px; }
        
        @media print {
        .non-printable { display: none; }
        body { overflow: visible !important;}
        }
    </style>
</head>
<body>
<div id="outerPageDiv" class="noPrint">
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
</div>
<div class="container left-right-shadow noPrint">
  <form:form modelAttribute="assessmentSummaryFormBean" autocomplete="off" method="post">
    <div class="row">
      <div class="col-md-5">
        <h1>Assessment Summary</h1>
      </div>
      <div class="col-md-7">
        <div class="text-right h1_align"> <strong>Current Status: </strong> <span class="label label-success">${veteranAssessmentInfo.assessmentStatusName}</span>
          <c:if test="${not empty assessmentStatusList}"> |
            <div class="h1_status form-inline">
              <form:label path="selectedAssessmentStatusId">Update Status to:</form:label>
              <form:select path="selectedAssessmentStatusId" cssClass="form-control">
                <form:option value="${veteranAssessmentInfo.assessmentStatusId}" label="Please Select a Status"/>
                <form:options items="${assessmentStatusList}" itemValue="stateId" itemLabel="stateName" />
              </form:select>
              <div class="text-right">
                <form:errors path="selectedAssessmentStatusId" cssClass="help-inline" />
              </div>
            </div>
          </c:if>
          <c:if test="${empty assessmentStatusList}">
            <form:hidden path="selectedAssessmentStatusId"/>
          </c:if>
        </div>
      </div>
    </div>
    <form:hidden path="selectedVeteranAssessmentId"/>
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <br />
    <div class="row">
      <div class="col-md-12">
        <c:if test="${!isCprsVerified}">
          <div class="alert alert-danger"> Your VistA account information needs to be verified before you can save or read any data from VistA. </div>
        </c:if>
        <c:if test="${callResult.hasError}">
          <div class="alert alert-danger">
            <c:out value="${callResult.userMessage}"/>
          </div>
          <div class="panel-danger-system">
            <div class="panel-group" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"> System Error <span class="label label-danger">Click here for more error details</span> </a> </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse">
                  <div class="panel-body">
                    <c:out value="${callResult.systemMessage}"/>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </c:if>
        <c:if test="${!callResult.hasError}">
          <c:if test="${not empty callResult.userMessage}">
            <div class="alert alert-info">
              <c:out value="${callResult.userMessage}"/>
            </div>
          </c:if>
        </c:if>
        <div class="border-radius-main-form">
          <div class="row">
            <div class="col-md-2"> Program Name
              <div class="txt_lable_lg">
                <c:out value="${veteranAssessmentInfo.programName}" />
              </div>
            </div>
            <div class="col-md-6"> Name (Last, First Middle)
              <div class="txt_lable_lg">
                <c:out value="${veteranAssessmentInfo.veteranFullName}" />
              </div>
            </div>
            <div class="col-md-2"> Date of Birth
              <div class="txt_lable_lg">
                <fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${veteranAssessmentInfo.birthDate}" />
              </div>
            </div>
            <div class="col-md-2 text-right"> SSN-4
              <div class="txt_lable_lg text-right">
                <c:out value="${veteranAssessmentInfo.ssnLastFour}" />
              </div>
            </div>
          </div>
          <hr />
          <div class="row">
            <div class="col-md-2"> Phone
              <div class="txt_lable_md">
                <c:out value="${veteranAssessmentInfo.phone}" />
              </div>
            </div>
            <div class="col-md-2"> Work
              <div class="txt_lable_md">
                <c:out value="${veteranAssessmentInfo.officePhone}" />
              </div>
            </div>
            <div class="col-md-2"> Cell
              <div class="txt_lable_md">
                <c:out value="${veteranAssessmentInfo.cellPhone}" />
              </div>
            </div>
            <div class="col-md-4"> Email
              <div class="txt_lable_md">
                <c:out value="${veteranAssessmentInfo.email}" />
              </div>
            </div>
            <div class="col-md-2 text-right"> VistA IEN
				<div class="txt_lable_md">
					<c:out value="${veteranAssessmentInfo.veteranIen}" />
				</div>
				
				<c:if test="${isCprsVerified}">
					<c:if test="${empty veteranAssessmentInfo.veteranIen}">
						<s:url var="mapVeteranToVistaUrl" value="/dashboard/mapVeteranToVistaRecord" htmlEscape="true">
							<s:param name="vid" value="${veteranAssessmentInfo.veteranId}" />
						</s:url>
						<div class="text-left">
							<a href="${mapVeteranToVistaUrl}">Map to VistA Record</a>
						</div>
					</c:if>
				</c:if>
              
            </div>
          </div>
          <hr />
          <div class="row">
            <div class="col-md-2"> Battery Name
              <div class="txt_lable_md">
                <c:out value="${veteranAssessmentInfo.batteryName}" />
              </div>
            </div>
            <div class="col-md-2"> Created By
              <div class="txt_lable_md">
                <c:out value="${veteranAssessmentInfo.createdByUserFullName}" />
              </div>
            </div>
            <div class="col-md-2"> Date Created
              <div class="txt_lable_md">
                <fmt:formatDate type="date" pattern="MM/dd/yyyy HH:mm:ss" value="${veteranAssessmentInfo.dateCreated}" />
              </div>
            </div>
            <div class="col-md-2"> Date Completed
              <div class="txt_lable_md">
                <fmt:formatDate type="date" pattern="MM/dd/yyyy HH:mm:ss" value="${veteranAssessmentInfo.dateCompleted}" />
              </div>
            </div>
            <div class="col-md-4 text-right"> Veteran Summary
              <div class="txt_lable_md"> <a href="#"  data-toggle="modal" data-target="#patient_summary_modal">View Veteran Summary</a> </div>
            </div>
          </div>
        </div>
        <br/>
        <c:if test="${not empty alertList}">
          <c:set var="completeness_col" scope="session" value="8"/>
        </c:if>
        <c:if test="${empty alertList}">
          <c:set var="completeness_col" scope="session" value="12"/>
        </c:if>
        <div class="row">
          <div class="col-md-${completeness_col}">
            <div class="panel panel-default min-height-175">
              <div class="panel-heading">
                <h3 class="panel-title"><strong>Completeness</strong></h3>
              </div>
              <div class="panel-body">
                <div class="progress_list">
                  <c:if test="${not empty progressList}">
                    <ul>
                      <c:forEach var="item" items="${progressList}">
                        <li class="col-md-2">
                          <div class="text-center circle_progress_wrapper">
                            <div class="c100 p<c:out value="${item.percentComplete}" /> small"> <span>
                              <c:out value="${item.percentComplete}" />
                              %</span>
                              <div class="slice">
                                <div class="bar"></div>
                                <div class="fill"></div>
                              </div>
                            </div>
                          </div>
                          <div class="clear-fix"></div>
                          <div class="circle_progress_title">
                            <c:out value="${item.surveySectionName}" />
                          </div>
                        </li>
                      </c:forEach>
                    </ul>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
          <c:if test="${not empty alertList}">
            <div class="col-md-4">
              <div class="panel panel-default min-height-175">
                <div class="panel-heading">
                  <h3 class="panel-title"><strong>Alerts</strong></h3>
                </div>
                <div class="panel-body">
                  <ul class="alert_group_danger">
                    <c:forEach var="item" items="${alertList}">
                      <li><i class="glyphicon glyphicon-warning-sign"></i>
                        <c:out value="${item.alertName}" />
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>
          </c:if>
        </div>
        <div>
          <div class="row">
            <div class="col-md-4">
              <div class="form-group">
                <form:label path="selectedClinicId">VistA Clinic *</form:label>
                <form:select path="selectedClinicId" cssClass="form-control">
                  <form:option value="" label="Please Select a Clinic"/>
                  <form:options items="${clinicList}" itemValue="stateId" itemLabel="stateName"/>
                </form:select>
                <form:errors path="selectedClinicId" cssClass="help-inline"/>
              </div>
            </div>
            <div class="col-md-4">
              <div class="form-group">
                <form:label path="selectedNoteTitleId">Note Title *</form:label>
                <form:select path="selectedNoteTitleId" cssClass="form-control">
                  <form:option value="" label="Please Select a Note Title"/>
                  <form:options items="${noteTitleList}" itemValue="stateId" itemLabel="stateName"/>
                </form:select>
                <form:errors path="selectedNoteTitleId" cssClass="help-inline"/>
              </div>
            </div>
            <div class="col-md-4">
              <div class="form-group">
                <form:label path="selectedClinicianId">Clinician *</form:label>
                <form:select path="selectedClinicianId" cssClass="form-control">
                  <form:option value="" label="Please Select a Clinician"/>
                  <form:options items="${clinicianList}" itemValue="stateId" itemLabel="stateName"/>
                </form:select>
                <form:errors path="selectedClinicianId" cssClass="help-inline"/>
              </div>
            </div>
          </div>
          <hr />
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input id="reviewAssessmentButton" name="reviewAssessmentButton" value="Review Assessment" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#assessment_reminders_modal" />
                <c:if test="${isCprsVerified}">
                  <input id="saveToVistaModal" name="saveToVistaModal" value="Save To VistA" type="button" class="btn btn-primary" data-toggle="modal" data-target="#save_to_vista_modal" <c:if test="${veteranAssessmentInfo.assessmentStatusName != 'Complete'}">disabled="disabled"</c:if> />
                </c:if>
                <c:if test="${!isCprsVerified}">
                  <input id="saveToVistaModal" name="saveToVistaModal" value="Save To VistA" type="button" class="btn btn-primary" disabled data-toggle="modal" data-target="#save_to_vista_modal" />
                </c:if>
                <input id="healthFactorTitlesButton" name="healthFactorTitlesButton" value="Health Factor Titles" type="button" class="btn btn-primary"  data-toggle="modal" data-target="health_factor_titles_modal" />
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group text-right">
                <input id="saveButton" name="saveButton" value="Save" type="submit" class="btn btn-primary" />
                <input id="cancelButton" name="cancelButton" value="Cancel" type="submit" class="btn btn-default" />
              </div>
            </div>
          </div>
          
          <!-- Modal Veteran Summary -->
          <div class="modal fade" id="patient_summary_modal" tabindex="-1" role="dialog" aria-labelledby="patient_summary_modal_label" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="patient_summary_modal_label">Veteran Summary</h4>
                </div>
                <div class="modal-body"> Veteran Summary Contents </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>
          
          <!-- Modal Veteran Summary -->
          <div class="modal fade" id="save_to_vista_modal" tabindex="-1" role="dialog" aria-labelledby="save_to_vista_modal_label" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="save_to_vista_modal_label">Save to VistA</h4>
                </div>
                <div class="modal-body">
                  <div class="alert alert-warning">Are you sure you want to Save Data to VistA?</div>
                </div>
                <div class="modal-footer">
                  <input id="saveToVistaButton" name="saveToVistaButton" value="Save" type="submit" class="btn btn-primary" />
                  <button type="button" class="btn btn-default" data-dismiss="modal" id="btn_close">Close</button>
                </div>
              </div>
            </div>
          </div>
          
          <!-- Modal Review Summary 
                    <div class="modal fade" id="assessment_reminders_modal" tabindex="-1" role="dialog" aria-labelledby="assessment_reminders_modal_label" aria-hidden="true">
                      <div class="modal-dialog">
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="assessment_reminders_modal_label">Assessment Reminders</h4>
                          </div>
                          <div class="modal-body">
                            Assessment Reminders Contents
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    --> 



		          <!-- Modal Review Summary 
                    <div class="modal fade" id="timeout_modal" tabindex="-1" role="dialog" aria-labelledby="timeout_modal_label" aria-hidden="true">
                      <div class="modal-dialog">
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="timeout_modal_label">Assessment Reminders</h4>
                          </div>
                          <div class="modal-body">
                            Timeout
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    --> 
                  


          
          <br />
        </div>
      </div>
    </div>
    <!-- row --> 
  </form:form>
</div>

<!-- Modal -->
<div class="custom_modal" >
  <div class="modal fade" id="AssessmentReportPreview" tabindex="-1" role="dialog" aria-labelledby="AssessmentReportPreview" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header noPrint">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Review Assessment Preview</h4>
        </div>
        <div class="modal-body yesPrint">
          <div class="modal_contents">Loading...</div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Health Factor Titles Modal -->

<div class="modal fade" id="healthFactorTitles" tabindex="-1" role="dialog" aria-labelledby="healthFactorTitles" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header noPrint">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="healthFactorTitlesLabel">View Health Factors</h4>
      </div>
      <div class="modal-body yesPrint">
        <div class="modal_contents">Loading...</div>
      </div>
    </div>
  </div>
</div>
<div class="clear-fix"></div>
<div  class="noPrint">
  <%@ include file="/WEB-INF/views/partialpage/footer.jsp" %>
</div>

<!--  Work arounf to Solve Print Problem in Chrome  -->
<div>-</div>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/js/bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dashboard/assessmentSummary.js" />"></script>
<script>
        
	        $(document).ready(function() {
	        	$(this).on("click", '#reviewAssessmentButton', function(e){
	        		  e.preventDefault();
	        		  
	        		  
	        		  var modal_contents = $("#AssessmentReportPreview .modal_contents");
	        		  $('#AssessmentReportPreview').modal('show');
	        		  $(modal_contents).html('<i class="ajax_loading text-center"></i> Loading...');
	        		  
	        		  var vaid = ${veteranAssessmentInfo.veteranAssessmentId};
	        		   $.ajax({
	        			  	type : 'get',
	        			  	contentType: 'application/json',
	        			   	url : 'assessmentSummary/assessments/' + vaid + '/cprsNote',
	        		   		success : function(r)
	        				 {  
	        					 $(modal_contents).show().html(r);
	        				 }
	        		});
	        	});

	        	$(this).on("click", '#healthFactorTitlesButton', function(e){
	        		  e.preventDefault();
	        		  $('#healthFactorTitles').modal('show'); 
	        		  
	        		  var vaid = ${veteranAssessmentInfo.veteranAssessmentId};
	        		   $.ajax({
	        			  	type : 'get',
	        			  	contentType: 'application/json',
	        			   	url : 'assessmentSummary/assessments/' + vaid + '/healthFactorTitles',
	        		   		success : function(r)
	        				 {
								  console.log(r);
	        					 
	        					 $('#healthFactorTitles .modal_contents').show().html(r);
	        				 }
	        		});
	        	});
	        	
	        });
        
        </script>
</html>
