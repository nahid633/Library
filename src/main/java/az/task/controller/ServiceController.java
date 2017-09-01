package az.task.controller;

import az.task.model.Account;
import az.task.model.Book;
import az.task.service.interfaces.AccountService;
import az.task.service.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This controller is responsible to manage the creattion of accounts and search over google api.
 *
 */

@RestController
public class ServiceController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private AccountService accountService;
    @RequestMapping(value = "/search/{q}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> query(@PathVariable("q") String query) {
        try {
            List<Book> book = searchService.queryGoogleBooks(query);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @RequestMapping(value = "/account/search/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findAll(@PathVariable("email")String email) {
        Account account = accountService.findByEmail(email);
        if(account==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        }
        else{
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }
    /**
     * Create a new user account
     * @param account user account
     * @return created account as json
     */
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        accountService.saveUser(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    }
