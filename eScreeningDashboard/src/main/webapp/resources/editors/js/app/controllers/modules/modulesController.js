/**
 * 
 */
    Editors.controller('moduleController', ['$rootScope', '$scope', '$state', function ($rootScope, $scope, $state) {
            $rootScope.selectedQuestion = {};


            $rootScope.createModule = function(){
                return {
                    index:null,
                    moduleId:null,
                    title:'Enter Module Title',
                    status:'',
                    description:'Enter Module Description',
                    questions:[]
                };
            }

            $rootScope.createQuestion = function(){
                return {
                    measureId:null,
                    displayOrder:-1,
                    measureText:"",
                    measureType:"",
                    vistaVariable: "",
                    helpText:"",
                    ppi:false,
                    mha:false,
                    answers:[],
                    validations:[]
                };
            }

            $rootScope.createBattery = function(){
                return {
                    batteryId:null,
                    title:"Enter Battery Title",
                    description:"Enter Battery Description",
                    sections:[]
                };
            }

            $rootScope.createSection = function(){
                return {
                    sectionId:null,
                    title:'Enter Section Title',
                    modules:[]
                }
            }

            $rootScope.createFormula = function(){
                alert('Not presently implemented');
            }

            $rootScope.createTemplate = function(){
                alert('Not presently implemented');
            }

            $rootScope.createRule = function(){
                alert('Not presently implemented');
            }

            $rootScope.createTableQuestion = function(){
                var q = $scope.createQuestion();
                q.childAnswers = [];
                return q;
            }

            $rootScope.battery = $rootScope.createBattery();
            $rootScope.module = $rootScope.createModule();

            $scope.addQuestion = function(){
                $scope.selectedQuestion = $rootScope.createQuestion();
                $scope.goToQuestions();
            }

            $scope.editQuestion = function(q){
                $scope.selectedQuestion = q;
                $scope.goToQuestions();
            }

            $scope.deleteQuestion = function(q){

            }

            $scope.goToQuestions = function(){

                $state.go('modules-editor.addedit.questions.freetextreadonly');
            }

            /* ---- Button Actions ---- */

            $scope.goToSelection = function(){
                $state.go('modules-editor.selection');
            }

            $scope.goToSections = function(){
                $state.go('modules-editor.addedit.mapsection');
            }

            $scope.goToMapConsult = function(){
                $state.go('modules-editor.addedit.questions.mapconsult');
            }

            $scope.goToFormulaExpression = function(){
                $state.go('modules-editor.addedit.expressioneditor');
            }

            $scope.goToCreateVar = function(){
                $state.go('modules-editor.addedit.createvariable.questionvariable');
            }
     }]);

    Editors.controller('moduleSelectController',['$rootScope','$scope','$state', '$filter', 'ngTableParams', function($rootScope, $scope, $state, $filter, ngTableParams){

        $scope.modules = [
            {id:1, title:'Identification', status:'Published', description:'Veteran\'s self identification module.', questions:[]},
            {id:2, title:'Demographics', status:'Editable', description:'Veteran\'s demographic information.', questions:[]},
            {id:3, title:'Service History',  status:'Editable', description:'Veteran\'s Military Service history module.', questions:[]},
            {id:4, title:'Spiritual Beliefs', status:'Published', description:'Veteran\'s spiritual beliefs.', questions:[]},
            {id:5, title:'General Physical Health', status:'Editable', description:'Veteran\'s physical health module.', questions:[]},
            {id:6, title:'General Mental Health', status:'Editable', description:'Veteran\'s mental health module (general).', questions:[]},
            {idx:7, title:'OEF/OIF PTSD', status:'Editable', description:'Post-Traumatic Stress Disorder module.', questions:[]},
            {id:8, title:'OEF/OIF Anxiety Spectrum', status:'Editable', description:'Anxiety Spectrum identification module.', questions:[]},
            {id:9, title:'OEF/OIF Something 1', status:'Published', description:'I\'m your friendly, neighborhood description!', questions:[]},
            {id:10, title:'OEF/OIF Something 2', status:'Editable', description:'I\'m your friendly, neighborhood description!', questions:[]},
            {id:11, title:'OEF/OIF Something 3', status:'Editable', description:'I\'m your friendly, neighborhood description!', questions:[]}
        ]

        var data = $scope.modules;

        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10,          // count per page
            filter: {
                title: ''       // initial filter
            },
            sorting: {
                title: 'asc'     // initial sorting
            }
        }, {
            total: data.length, // length of data
            getData: function($defer, params) {
                // use build-in angular filter
                var filteredData = params.filter() ?
                        $filter('filter')(data, params.filter()) :
                        data;
                var orderedData = params.sorting() ?
                        $filter('orderBy')(filteredData, params.orderBy()) :
                        data;

                params.total(orderedData.length); // set total for recalc pagination
                $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            }
        });

        $scope.buildQuestions = function(){
            var ques = [];
            var qId = 1;
            for (var i = 0; i<10; i++)
            {
                var q = $rootScope.createQuestion();
                q.measureId = qId;
                q.measureText = "What is your name? Q:: " + qId;
                q.displayOrder = qId;
                q.measureType="freeText";
                q.vistaVariable="00A00" + qId;
                q.helpText="I am some Help Text.";
                q.ppi=true;
                q.mha=false;
                q.answers=[];
                q.validations=[];
                ques.push(q);
                qId++;
            }

            return ques;
        }

        /* ---- Button Actions ---- */
        $scope.editModule = function(mod){
            $rootScope.module = mod;
            mod.questions =  $scope.buildQuestions();
            $state.go('modules-editor.addedit.questionnull');
        }

        $scope.addModule = function(){
            $rootScope.module = $rootScope.createModule();
            $state.go('modules-editor.addedit.questionnull');
        }

        $scope.goToAddEdit = function(){
            $state.go('modules-editor.addedit.questionnull');
        }

        $scope.cancel = function(){
            alert('Will take user back to Editors Entry View.');
        }
    }]);

    Editors.controller('addEditModuleController', ['$rootScope', '$scope', '$state', function($rootScope, $scope, $state){
        var tmpList = [];

        $scope.selectedQuestion = null;

        $scope.editQuestion = function(question){
            $scope.selectedQuestion = question;

            switch (question.measuretype){
                case 'freeText':
                case 'readOnly':
                    $state.go('modules-editor.addedit.questions.freetextreadonly');
                    break;
                case 'selectOne':
                case'selectMulti':
                    $state.go('modules-editor.addedit.questions.selectsinglemultiple');
                    break;
                case 'selectOneMatrix':
                case 'selectMultiMatrix':
                    $state.go('modules-editor.addedit.questions.selectsinglemultiplematrix');
                    break;
                case 'tableQuestion':
                    $state.go('modules-editor.addedit.questions.tablequestion');
                    break;
                case 'instructions':
                    $state.go('modules-editor.addedit.questions.instructions');
                    break;
                default:
                    $state.go('modules-editor.addedit.questions.freetextreadonly');
            }

        }

        $scope.addQuestion = function(){
            $scope.selectedQuestion = $rootScope.createQuestion();
            $state.go('modules-editor.addedit.questions.freetextreadonly');
        }

        $scope.deleteQuestion = function(question){
            alert('Will delete the Question with VISTA Variable: ' + question.vistaVariable);
        }

        $scope.sortableOptions = {
            update: function(e, ui) {
                var logEntry = tmpList.map(function(i){
                    return i.value;
                }).join(', ');
               // $scope.sortingLog.push('Update: ' + logEntry);
            },
            stop: function(e, ui) {
                // this callback has the changed model
                var logEntry = tmpList.map(function(i){
                    return i.value;
                }).join(', ');
                //$scope.sortingLog.push('Stop: ' + logEntry);
            }
        };
     }]);

     Editors.controller('questionsController', ['$rootScope', '$scope', '$state', function($rootScope, $scope, $state){

             $scope.qTypes = [
                 {name:"Free/Read-Only Text", value:1},
                 {name:"Select Single", value:2},
				 {name:"Select Multiple", value:3},
                 {name:"Select Single Matrix", value:4},
				 {name:"Select Multiple Matrix", value:5},
                 {name:"Table Question", value:6},
                 {name:"Instructions", value:7}];

             $scope.qType = $scope.qTypes[0];

             $scope.$watch( 'qType', function( qType ) {
                 var url = 'modules-editor.addedit.questions.freetextreadonly';
                 switch(qType.name){
                     case 'Free/Read-Only Text':
                         url = 'modules-editor.addedit.questions.freetextreadonly';
                         break;
                     case 'Select Single':
                         url = 'modules-editor.addedit.questions.selectsinglemultiple';
                         break;
					case 'Select Multiple':
                         url = 'modules-editor.addedit.questions.selectsinglemultiple';
                         break;
                     case 'Select Single Matrix':
                         url = 'modules-editor.addedit.questions.selectsinglemultiplematrix';
                         break;
					 case 'Select Multiple Matrix':
                         url = 'modules-editor.addedit.questions.selectsinglemultiplematrix';
                         break;
                     case 'Table Question':
                         url = 'modules-editor.addedit.questions.tablequestion';
                         break;
                     case 'Instructions':
                         url = 'modules-editor.addedit.questions.instructions';
                         break;
                 }
                 $state.go(url);
             });

             $scope.goToAddEdit = function(){
                 $state.go('modules-editor.addedit.questionnull');
             }



     }]);