# Library

This project was generated with spring boot.
Using maven.as Security used Spring security oauth2 and jwt.
db- mysql
## Development server

Run `mvn spring-boot:run` . Navigate to `http://localhost:8080/`. 


##  Additional info.
token base authontiocationdan istife olunur.
access_token ve refresh_token elde etmek ucun .Postman la
`http://localhost:8080/oauth/token?password=633&username=nahid633@mail.ru&grant_type=password`
[Authontication basic(username:clienapp password:123456)]

Login ucun email ve password istife olunur.
Register  ucun istifadecinin Full Name, email ve password teleb olunur.
Seach using Google api.  suretli iwlemesi ucun front ende istifade olub.
Lakin backende service kimide istifade edilib.(sadece yoxlaniw ucun).

refereces link 
[Security]-`https://github.com/royclarkson/spring-rest-service-oauth`