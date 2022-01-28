package com.kmit.mkp.controller;

import com.kmit.mkp.dto.LoginDto;
import com.kmit.mkp.dto.OrdersDto;
import com.kmit.mkp.dto.UserDto;
import com.kmit.mkp.dto.UserTokenDto;
import com.kmit.mkp.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("login")
    public UserTokenDto postLogin(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

    @PostMapping("verify")
    public UserDto postVerify(@RequestBody UserTokenDto userTokenDto){
        return loginService.verify(userTokenDto);
    }
}
