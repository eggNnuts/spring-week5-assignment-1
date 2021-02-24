package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.UserService;
import com.codesoom.assignment.dto.UserDto;
import com.codesoom.assignment.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 회원 정보와 관련된 HTTP 요청을 처리합니다.
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원을 저장하고 저장된 회원 정보를 반환합니다.
     *
     * @param userRequestDto 저장할 회원의 정보
     * @return 저장한 회원의 정보
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    /**
     * id에 해당하는 회원을 수정합니다.
     *
     * @param id             수정할 회원의 id
     * @param userRequestDto 수정할 회원의 정보
     * @return 수정된 회원의 정보
     */
    @PatchMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }
}
