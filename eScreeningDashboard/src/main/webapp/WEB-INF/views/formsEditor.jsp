<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html ng-app="Editors">
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10">
    <link rel="icon" href="http://54.235.74.13/escreeningdashboard-test/dashboard/resources/images/valogo.ico" type="image/x-icon">
    <link rel="SHORTCUT ICON" href="http://54.235.74.13/escreeningdashboard-test/dashboard/resources/images/valogo.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=yes">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>VA Editors</title>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/editors/vendors/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/editors/css/escreening/standardtopofpage-dashboard.css" type="text/css">
    <link rel="stylesheet" href="resources/editors/css/escreening/menu-partial.css" type="text/css">
    <link rel="stylesheet" href="resources/editors/css/escreening/userManagement.css" type="text/css">
    <link rel="stylesheet" href="resources/editors/css/escreening/formButtons.css" type="text/css">
    <link rel="stylesheet" href="resources/editors/css/escreening/jquery-ui-1.10.3.custom.min.css" type="text/css">
    <link rel="stylesheet" href="resources/editors/css/escreening/standardtopofpage-dashboard_new.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/editors/css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="resources/js/jquery/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/editors/vendors/angular/angular.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular-resource.min.js"></script>
    <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-sanitize.min.js'></script>
    <script type="text/javascript" src="resources/editors/vendors/lodash/lodash.min.js"></script>
    
    <!-- Utility classes and non-Angular, non-framework classes -->
    <script type="text/javascript" src="resources/editors/js/app/utils/HttpRejectionProcessor.js"></script>

    <!-- Vendor library JavaScript classes -->
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/Object.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/ArrayExtention.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/DateExtention.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/BytePushersApplication.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/Errors.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/DateConverter.js"></script>

    
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/Response.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/ResponseException.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/ResponseExceptionStackTrace.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/ResponseStatus.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/ResponseStatusTransformer.js"></script>
    <script type="text/javascript" src="resources/vendor-libs/byte-pushers/js/ResponseTransformer.js"></script>

    <!-- Domain Object -->
    <script type="text/javascript" src="resources/editors/js/app/domains/EScreeningDashboardApp.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/domains/Survey.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/domains/SurveySection.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/domains/SurveySectionTransformer.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/domains/SurveySectionsTransformer.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/domains/SurveysTransformer.js"></script>

	<!--  Batteries Domain -->
	<script type="text/javascript" src="resources/editors/js/app/domains/Battery.js"></script>
	<script type="text/javascript" src="resources/editors/js/app/domains/BatteryTransformer.js"></script> 
	<script type="text/javascript" src="resources/editors/js/app/domains/BatteriesTransformer.js"></script>
	   
	
	<!-- Modules -->
    <script type="text/javascript" src="resources/editors/vendors/angularUtils/angularUtils.js"></script>
    <script type="text/javascript" src="resources/editors/vendors/angularUtils/directives/uiBreadcrumbs/uiBreadcrumbs.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/angular-animate.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/angular-routing.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/ui-bootstrap-tpls-0.10.0.min.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/angular-texteditor.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/ngTable/ng-table.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/sortable.js"></script>
    <script type="text/javascript" src="resources/editors/js/directives/xeditable.min.js"></script>
    
    <!-- Services -->
    <script type="text/javascript" src="resources/editors/js/app/services/SurveySectionService.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/services/BatteryService.js"></script>
    
    <!-- Application Definition file -->
    <script type="text/javascript" src="resources/editors/main.js"></script>
    
    
    
    <!-- Controllers -->
    
    <!-- Entry View -->
    <script type="text/javascript" src="resources/editors/js/app/controllers/home/entryController.js"></script>
    
    <!-- Batteries View States -->
    <script type="text/javascript" src="resources/editors/js/app/controllers/batteries/batteriesAbstractController.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/controllers/batteries/batteriesSelectionController.js"></script>
    <script type="text/javascript" src="resources/editors/js/app/controllers/batteries/batteriesAddEditController.js"></script>
    
    <!-- Survey Sections View State -->
    <script type="text/javascript" src="resources/editors/js/app/controllers/sections/sectionsController.js"></script>
    
    <!-- Modules View State(s) -->
    <script type="text/javascript" src="resources/editors/js/app/controllers/modules/modulesController.js"></script>
    
    <!-- UI-Router View States definition -->
    <script type="text/javascript" src="resources/editors/states.js"></script>
    
    <style type="text/css">
	    @media (min-width:1024px) { 
			.navbar > .container {
			    text-align: center;
			}
			.navbar-header,.navbar-brand,.navbar .navbar-nav,.navbar .navbar-nav > li {
			    float: none;
			    display: inline-block;
			}
			.collapse.navbar-collapse {
			    float: none;
			    display: inline-block!important;
			    width: auto;
			    clear: none;
			}
		}
    </style>
</head>
<body style="">
<!-- Top Nav Content -->
<div id="outerPageDiv">
    <div id="headerDiv" class="top_header">
        <div class="container bg_transparent">
            <div class="row">
                <div class="col-md-9">
                    <div id="vaLogoDiv"><a href="home" ><img src="resources/editors/css/escreening/dva_eha_logo.png" alt="Department of Veterans Affairs | eScreening Program" border="0"></a></div>
                </div>
                <div class="col-md-3 text-right">
                    <div id="welcomeDiv">
                        <div id="loggedInUser">
                        	<sec:authorize access="isAuthenticated()">
								<span id="welcomeMessage" ><span class="glyphicon glyphicon-user"></span> Welcome <sec:authentication property="principal.fullName"/> | </span> 
								<a  href="handleLogoutRequest">
								<!--   <input  class="buttonSignout" type="button" value="Sign Out">-->
								<a href="handleLogoutRequest">Logout <span class="glyphicon glyphicon-log-out"></span></a>
								</a>
							</sec:authorize>
							<sec:authorize access="isAnonymous()">
								<div class="header_support">
									<div>Support and Problems</div>
									<span class="label label-primary"><a href="#">Email US</a> OR (800) 827-1000</span>
								</div>						
							</sec:authorize>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <div class="clearfix"></div>
    <div class="navbar navbar-default navbar-update" role="navigation">
        <div class="container bg_transparent">
            <div class="navbar-header">
                <nav class="navbar-collapse collapse">
                    <ul id="tabs" class="nav navbar-nav">
                        <!-- Here you can see ui-sref in action again. Also notice the use of $state.includes, which
                             will set the links to 'active' if, for example on the first link, 'assessment-editor' or any of
                             its descendant states are activated. -->
                        <li ng-class="{active: $state.includes('battery-editor')}">
                            <a ui-sref="battery-editor.selection">Manage Batteries</a>
                        </li>
                        <li ng-class="{active: $state.includes('modules-editor')}">
                            <a ui-sref="modules-editor.selection">Manage Modules</a>
                        </li>
                        <li ng-class="{active: $state.includes('sections-editor')}">
                            <a ui-sref="sections-editor">Manage Sections</a>
                        </li>
                        <li ng-class="{active: $state.includes('templates')}">
                        	<a ui-sref="templates.templatelistview">Templates</a> 
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <!-- /Top Nav Content -->
    <!-- Application Active Region Content - Wraps the active navigation module -->
    	<div id="bodyDiv" class="bgImgMiddle">
	        <div class="left-right-shadow main-container container" style="padding:0px;margin:0 auto;">
	        	<div class="container">
            		<div class="col-md-12" ui-view></div>
        		</div>
	        </div>
        </div>

    <div class="container" style="padding:0px;">
        <footer>
            <div class="footer_container">
                <div class="container bg_transparent">
                    <div class="row">
                        <div class="col-md-12"> U.S. Department of Veterans Affairs | eScreening Program (Ver 1.0) </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</body>
</html>

