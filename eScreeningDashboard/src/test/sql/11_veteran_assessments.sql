/* Add an assessment with each state value */
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (1, 1, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (2, 2, 5, 8, 1, 10, 50, 2, 1); 
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (3, 3, 5, 9, 1, 10, 50, 3, 1); 
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (4, 1, 5, 7, 0, 150, 100, 4, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (5, 2, 5, 8, 0, 300, 100, 5, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (6, 3, 5, 9, 0, 30, 100, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (7, 1, 5, 7, 0, 40, 100, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (8, 2, 5, 8, 0, 50, 100, 3, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id, signed_by_user_id) VALUES (9, 3, 5, 9, 0, 60, 100, 4, 1, 1);

/* These are associated with a clinician who is not associated with the same clinics at above */
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (10, 4, 5, 1, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (11, 5, 5, 2, 1, 10, 50, 2, 1); 
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (12, 6, 5, 3, 1, 300, 100, 4, 1); 

/* Minimal vets used */
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (13, 14, 6, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (14, 15, 5, 1, 0, 0, 0, 1, 1);

/* Add Surveys to Assessments */
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (1, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (1, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (1, 3);

INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (2, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (2, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (2, 3);

INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (3, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (3, 2);

INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (13, 1);

/* bulk assessment create for Veterans */
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (15, 17, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (16, 17, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id, battery_id, note_title_id) VALUES (17, 17, 5, 17, 0, 0, 0, 1, 1, 5, 8);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id, battery_id, note_title_id) VALUES (18, 18, 5, 17, 0, 0, 0, 1, 1, 5, 8);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (19, 19, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (20, 20, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (21, 21, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (22, 22, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (23, 23, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (24, 24, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (25, 25, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (26, 26, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (27, 27, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (28, 28, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (29, 29, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (30, 30, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (31, 31, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (32, 32, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (33, 33, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (34, 34, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (35, 35, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (36, 36, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (37, 37, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (38, 38, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (39, 39, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (40, 40, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (41, 41, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (42, 42, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (43, 43, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (44, 44, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (45, 45, 5, 7, 0, 0, 0, 2, 1);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (46, 46, 5, 7, 0, 0, 0, 2, 2);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (47, 47, 5, 7, 0, 0, 0, 2, 2);
INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (48, 48, 5, 7, 0, 0, 0, 2, 1);


/* insert veteran assessment audit log example data */
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (1, 1, 100, 'Clinician', 1, 1, 1);
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (2, 1, 100, 'Clinician', 1, 1, 2);
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_first_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (3, 1, 200, 'One', 'Veteran', 2, 2, 3);
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_first_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (4, 1, 200, 'One', 'Veteran', 2, 2, 3);
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_first_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (5, 1, 200, 'One', 'Veteran', 2, 2, 3);
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_first_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (6, 1, 200, 'One', 'Veteran', 2, 4,4);
INSERT INTO veteran_assessment_audit_log (veteran_assessment_audit_log_id, veteran_assessment_id, person_id, person_last_name, person_type_id, assessment_status_id, veteran_assessment_event_id) VALUES (7, 1, 100, 'Clinician', 1, 5, 5);

/*Simple setup for quick testing of OOO */

/* Add short OOO assessment for veteran 17 */
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (17, 1);

/* Add full OOO assessment for veteran 18 */
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 3);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 4);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 5);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 6);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 7);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 8);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 9);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 10);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 11); -- table type question
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 12);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 13);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 14);  -- select one matrix
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 15);  -- select multi matrix
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 16);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 17);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 18);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 19);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 20);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 21);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 22);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 23);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 24);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 25);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 26);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 27);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 28);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 29);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 30);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 31);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 32);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 33);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 34);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 35);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 36);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 37);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (18, 38);


/* test data for clinical note template */

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (49, 49, 5, 7, 0, 0, 0, 2, 4);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 1);
/*
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 3);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 3);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 5);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 6);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 7);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 8);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 9);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 10);
*/
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 11); -- table type question
/*
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 12);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 13);
*/
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 14);  -- select one matrix
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 15);  -- select multi matrix
/*
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 16);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 17);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 18);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 19);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 20);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 21);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 22);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 23);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 24);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 25);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 26);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 27);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 28);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 29);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 30);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 31);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 32);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 33);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 34);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 35);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 36);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 37);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (49, 38);
*/

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id,clinician_id,clinic_id,access_mode,duration,percent_complete,assessment_status_id, created_by_user_id) VALUES (50, 49, 5, 7, 0, 0, 0, 2, 4);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (50, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (50, 11);

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id, clinician_id, clinic_id, access_mode, duration, percent_complete, assessment_status_id, created_by_user_id) VALUES (51, 10, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (51, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (51, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (51, 3);

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id, clinician_id, clinic_id, access_mode, duration, percent_complete, assessment_status_id, created_by_user_id) VALUES (52, 11, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (52, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (52, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (52, 3);

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id, clinician_id, clinic_id, access_mode, duration, percent_complete, assessment_status_id, created_by_user_id) VALUES (53, 12, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (53, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (53, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (53, 3);

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id, clinician_id, clinic_id, access_mode, duration, percent_complete, assessment_status_id, created_by_user_id) VALUES (54, 13, 5, 7, 0, 0, 0, 1, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (54, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (54, 2);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (54, 3);

INSERT INTO veteran_assessment (veteran_assessment_id, veteran_id, clinician_id, clinic_id, access_mode, duration, percent_complete, assessment_status_id, created_by_user_id) VALUES (55, 44, 5, 7, 0, 0, 0, 3, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (55, 1);
INSERT INTO veteran_assessment_survey (veteran_assessment_id, survey_id) VALUES (55, 32);

-- Update the pgoram_id field to be the clinic's
UPDATE veteran_assessment va 
INNER JOIN clinic c ON va.clinic_id = c.clinic_id 
SET va.program_id = c.program_id
WHERE va.program_id IS NULL;

-- Update the note_title_id field (we might have to fix this if some note titles don't make sense for an assessment)
UPDATE veteran_assessment va 
SET va.note_title_id = 3
WHERE va.note_title_id IS NULL;


INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (1, 1);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (1, 2);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (1, 3);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (1, 4);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (1, 5);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (1, 6);

INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (55, 1);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (55, 2);

-- data for alerts graph 
-- veteran_assessment_dashboard_alert should have pointer to veteran_assessment_id which is in Incomplete State (assessment_status_id=2)
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (38, 1);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (39, 2);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (40, 3);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (41, 4);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (42, 5);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (43, 6);

INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (46, 1);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (47, 2);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (48, 3);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (2, 4);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (7, 5);
INSERT INTO veteran_assessment_dashboard_alert (veteran_assessment_id, dashboard_alert_id) VALUES (11, 6);

