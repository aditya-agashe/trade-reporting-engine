To execute the solution:

1. Clone the repository

2. Run maven command: mvn spring-boot:run. Alternatively, run using IDE
   
3. Open Postman
   
4. Make a POST request to localhost:8080/api/events (The app runs on port 8080)
   
5. In payload pass the path to parent directory where the events xml files are kept in JSON format
      e.g 
       {
       "dirPath" : "C:\\dev\\eventXML"
       }
6. The response is in JSON format



Design Considerations:
1. I have used API POST request as trigger. The response and request is to be in JSON format.

2. Followed TDD as much as possible.

3. Used Factory Design Pattern for Parser and FilterCriteria. In case the application is to be extended for JSON input files. Similarly, filter criteria can be changed easily.

4. The application is broken-up in layers, such as controller, service, repository. Used component where needed.

5. All XML parsing logic is in class XMLParser.

6. All Filter Criteria logic is in class SimpleFilterCriteria.

7. Used Builder pattern to build Event.

8. Due to limit of time, I have used String data type for currency. Ideally it should be BigDecimal.

9. Used In-memory H2 database and Spring Data JPA for persistence.



Assumptions
1. The input files are placed directly inside the parent folder. They cannot be placed in sub-folders. I haven't tested this.



Trade-offs
1. Between consecutive runs, the table events will be deleted. Possibly a column to differentiate runs might be added.

2. The entity/model is directly exposed as representation. Better practice is to use a transfer object for response. 

3. I haven't written units for the Controller layer. However, each layer below this layer has been unit tested.

4. Security has not been implemented.

