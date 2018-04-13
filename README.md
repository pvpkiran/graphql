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
