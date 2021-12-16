package com.diploma.backend.controller;

import com.diploma.backend.entity.Account;
import com.diploma.backend.models.AuthToken;
import com.diploma.backend.models.LoginUser;
import com.diploma.backend.security.TokenProvider;
import com.diploma.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody LoginUser loginUser){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getLogin(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public ResponseEntity<Account> userAuth(@PathVariable String name){
        Account account = accountService.findByLogin(name);
        if(account != null){
            return ResponseEntity.ok(account);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
