package com.miaomu.auth.controller;


import com.miaomu.auth.service.impl.MiaomuUserServiceImpl;
import com.miaomu.common.entity.vo.UserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jeff·Tang
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/v1")
@Api(value = "用户模块", tags = "用户管理")
public class MiaomuUserController {
    @Autowired
    private MiaomuUserServiceImpl miaomuUserService;

    @PostMapping("user")
    @ApiOperation("注册")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        return miaomuUserService.addUser(userRequest);
    }

    @PutMapping("user")
    @ApiOperation("修改")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        return miaomuUserService.updateUser(userRequest);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation("删除")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return miaomuUserService.deleteUser(id);
    }

    @GetMapping("users")
    @ApiOperation("列表")
    public ResponseEntity<?> users(@RequestParam Integer currentPage, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false, defaultValue = "0") Integer sort, @RequestParam(required = false, defaultValue = "") String params) {
        return miaomuUserService.users(currentPage, pageSize, params, sort);
    }

    @GetMapping("user/{id}")
    @ApiOperation("详情")
    public ResponseEntity<?> user(@PathVariable Integer id) {
        return miaomuUserService.user(id);
    }

}
