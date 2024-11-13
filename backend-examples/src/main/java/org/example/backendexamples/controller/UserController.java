package org.example.backendexamples.controller;

import lombok.RequiredArgsConstructor;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.service.UserService;
import org.example.backendexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PatchMapping("password")

    public ResultVO patchPassword(@RequestBody User user, @RequestAttribute("uid")String uid){
        userService.updateUserPasswordById(uid,user.getPassword());
        return ResultVO.ok();
    }
}