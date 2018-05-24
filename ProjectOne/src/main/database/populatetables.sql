INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('username1', 'password1', 'John', 'Smith', 'johnsmith@yahoo.com', 1);
INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('bearcat', 'zooanimal', 'Terry', 'Johnson', 'terryfolds@yahoo.com', 0);
INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('supermanfan', 'nocapes123', 'Elise', 'Parkins', 'eparkins@yahoo.com', 0);
INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('sigbox3', 'hoolibib', 'Gavin', 'Belson', 'belsong3@hooli.com', 0);
INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('notimportant', 'darktimes', 'Eric', 'Michaels', 'emc@yahoo.com', 0);
INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('u1', 'p1', 'TestUser', 'TestUserLast', 't1@yahoo.com', 0);
INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER)
    VALUES ('m1', 'n1', 'TestManager', 'TestManagerLast', 'm1@yahoo.com', 1);
    

INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (200, 'pending', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 9.95);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (201, 'approved', 'Borem bipsum bolor bit bamet, consectetur adipiscing elit.', 12.34);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (202, 'denied', 'Corem cipsum color cit camet, consectetur adipiscing elit.', 29.99);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (203, 'pending', 'Dorem dipsum dolor dit damet, consectetur adipiscing elit.', 150.55);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (204, 'pending', 'Eorem epsum eolor eit eamet, consectetur adipiscing elit.', 200.00);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (205, 'pending', 'Dorem dipsum dolor dit damet, consectetur adipiscing elit.', 99.55);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (205, 'pending', 'Eorem epsum eolor eit eamet, consectetur adipiscing elit.', 111.00);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (205, 'approved', 'Dorem dipsum dolor dit damet, consectetur adipiscing elit.', 222.55);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (205, 'approved', 'Eorem epsum eolor eit eamet, consectetur adipiscing elit.', 333.00);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (205, 'denied', 'Forem fipsum folor fit famet, consectetur adipiscing elit.', 444.55);
INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE)
    VALUES (205, 'denied', 'Gorem gepsum golor git gamet, consectetur adipiscing elit.', 555.00);
    
INSERT INTO REIMB_IMAGES (IMAGE_REIMB_ID) VALUES (1);
INSERT INTO REIMB_IMAGES (IMAGE_REIMB_ID) VALUES (2);
INSERT INTO REIMB_IMAGES (IMAGE_REIMB_ID) VALUES (3);
INSERT INTO REIMB_IMAGES (IMAGE_REIMB_ID) VALUES (4);
INSERT INTO REIMB_IMAGES (IMAGE_REIMB_ID) VALUES (5);

COMMIT;
/

