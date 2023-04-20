package com.example.test4.Controller;

import com.example.test4.Service.MemberService;
import com.example.test4.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * @param id
     */
    @GetMapping("/member/{id}")
    public MemberResponseDto getMemberInfo(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/member")
    public List<MemberResponseDto> getMemberList() {
        return memberService.findAllMember();
    }

}