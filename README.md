**Demo project to demonstrate GraphQL.**  
 
   Start the project and hit these two endpoints to test it  
   1. POST Request. URL:  http://localhost:8080/book Message body  
   `{
   allBooks {
      title
    }
   }`   
   
   2. POST Request. URL:  http://localhost:8080/book Message body  
   `{
    book(isbn:"1") {
       title
     }
    }`


Some of the drawbacks according to me,   

1. You need to pass inidividual field names. If the messaege body is `{ allBooks { } }`, it will not fetch anything.  
2. Declaring data types as Date and enum are not possible in graphsql file
                                                                         
                                                                               
                                                                         
                                                                         