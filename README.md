Fluent Commerce API Test cases
---------------------------------

Problem Statement
----------------------

API endpoint
https://reqres.in/api
Please perform the following steps
1. Make a POST call to endpoint with /login with missing fields provided with expected validation error message "Missing email or username" and assert on the error message and response code = 400
{
"password": "mypassword" }
2. Make a POST call to endpoint /login with all fields provided and assert on token value is "QpwL5tke4Pnpja7X" and response code = 200
{
"email": "myemail@email.com", "password": "mypassword"
}
3. Make a GET call to endpoint /users?per_page=100 and extract id belonging to first_name = "Tobias"
4. Make a GET call to endpoint /users/Id with Id value from step 3 and assert on the id and first_name fields values are 9, Tobias
respectively
Automate the above steps with either
a. Postman collection with newman runner and execution results output to a file or
b. Any other framework of choice with execution results output to a file
Please attach collection json if using postman or source files if using other framework together with the results output.


Solution
---------

This is a Java-maven project to make the rest api calls and test the output of the calls

The tests are located inside the QueryAPI class located at src/main/java/com/commerce/fluent/tests folder

The tests cases are named to match the problem statement except point 3 which is not a test but just a method to get id for user Tobias

The final out from console appeared like this -

Console Output
------------------

Request sent: 
/users?per_page=100
Response received: 
{"page":1,"per_page":100,"total":12,"total_pages":1,"data":[{"id":1,"first_name":"George","last_name":"Bluth","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"},{"id":2,"first_name":"Janet","last_name":"Weaver","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},{"id":3,"first_name":"Emma","last_name":"Wong","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"},{"id":4,"first_name":"Eve","last_name":"Holt","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"},{"id":5,"first_name":"Charles","last_name":"Morris","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"},{"id":6,"first_name":"Tracey","last_name":"Ramos","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"},{"id":7,"first_name":"Michael","last_name":"Lawson","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"},{"id":8,"first_name":"Lindsay","last_name":"Ferguson","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg"},{"id":9,"first_name":"Tobias","last_name":"Funke","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg"},{"id":10,"first_name":"Byron","last_name":"Fields","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg"},{"id":11,"first_name":"George","last_name":"Edwards","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg"},{"id":12,"first_name":"Rachel","last_name":"Howell","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg"}]}
Request sent: 
/users/9
Response received: 
{"data":{"id":9,"first_name":"Tobias","last_name":"Funke","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg"}}
With body: {
    "password": "mypassword",
    "email": "myemail@email.com"
}
Response received: 
{"token":"QpwL5tke4Pnpja7X"}
With body: {"password": "mypassword"}
Response received: 
{"error":"Missing email or username"}
With body: {"password": "mypassword"}
Response received: 
{"error":"Missing email or username"}

Process finished with exit code 0

