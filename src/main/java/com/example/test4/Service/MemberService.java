package com.example.test4.Service;


import com.example.test4.Repository.MemberRepository;
import com.example.test4.dto.MemberResponseDto;
import com.example.test4.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public MemberResponseDto findMember(Long id)
    {

        try {
            Optional<Member> memberOptional = memberRepository.findById(id);

//            if (memberOptional.isEmpty()) {
//                throw new RuntimeException("해당 회원을 찾을 수 없습니다.");
//            }

            Member member = memberOptional.get();
            return new MemberResponseDto(member.getId(), member.getName(), member.getEmail(), member.getPw());
        }
        catch(NullPointerException e){
            System.out.println(e);
        }

        return null;

    }
    @Transactional
    public List<MemberResponseDto> findAllMember()
    {
        List<Member> members = memberRepository.findAll();

        return members.stream()
                .map(member -> new MemberResponseDto(member.getId(), member.getName(), member.getEmail(), member.getPw()))
                .collect(Collectors.toList());
    }





}