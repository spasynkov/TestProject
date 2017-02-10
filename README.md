# TestProject
###### Trying to implement some test project I found somwhere in the internet :earth_africa:

### System Functionality
**Supporting the following scenarios:**

1. User enter the system URL address in web browser.
2. System displays a page showing a list of available job position names for which applications can be submitted.
3. User selects a job position which he wants to apply.
4. System displays a form to submit job application.  The form includes: 
  * Text fields:
    1. First name (mandatory),
    2. Surname (mandatory),
    3. E-Mail address (mandatory),
    4. Description (optional);
  * Field CV - File field for CV upload.
5. User fills the form and press the "Send application" button.
6. System validates if the person has not previously submitted an application for the position.  If this condition is fulfilled, the system saves the application data in the database.
Data saved includes:
  1. - [x] Data from the form,
  2. - [ ] CV file (saved as a BLOB in database),
  3. - [x] Application request time.
  4. - [x] The IP address of the computer from which the application is sent. 
7. - [x] If the data entry is successful, the system displays a page thanking you for submitting application. 
8. - [x] If the write data fails, the system displays an information page with the error description.

**In addition, the system should implement the web service which allows:**
* - [ ] Getting information about the number of submitted applications,
* - [ ] Getting information about the number of submitted applications for a given job position,
* - [ ] Checking whether a person identified by an e-Mail has submitted application for the position,
* - [ ] Download application data with the file CV, which are submitted by a person with the specified e-mail address.
- [x] Access to web-service services should be protected by login and password.

**Implementation**

1. The system should be based on Java Enterprise Edition (JEE) and JDK 7 or 8. 
2. It is acceptable to use the Spring Framework. 
3. The system should use a Model - View - Controller design pattern. 
4. Building app should be automated by Apache Maven or Gradle. 
5. System source codes should include unit tests implemented. 
6. System should use an Apache Tomcat server and MySQL database 

**What should be delivered**

7. The source code of the system with scripts: Maven / Gradle, DDL 
8. Data model diagram 
9. Instructions how to run the application 
10. Generated Javadoc documentation 

**Criteria for evaluation**

1. Application structure 
2. Error Handling 
3. The readability of the source code 
4. The correctness of the implementation 
5. Comments
