package az.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * `http://localhost:8080/oauth/token?password=633&username=nahid633@mail.ru&grant_type=password` METHOD POST
 * then  http://localhost:8080/account/search/nahid633@mail.ru?access_token=WHICH IS YOUR GET.
 * */
@SpringBootApplication
public class Application  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
