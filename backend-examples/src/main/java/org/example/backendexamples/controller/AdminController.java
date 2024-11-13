package org.example.backendexamples.controller;

import lombok.RequiredArgsConstructor;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.service.UserService;
import org.example.backendexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    @PostMapping("users")
    public ResultVO postUser(@RequestBody User user) {
        userService.addUser(user);
        return ResultVO.ok();
    }

    @PutMapping("users/{account}/password")
    public ResultVO putPassword(@PathVariable String account){
        userService.updateUserPassword(account);
        return ResultVO.ok();
    }
    @GetMapping("users")
    public ResultVO getUsers(){

        return ResultVO.success(userService.listUsers());
    }
}
