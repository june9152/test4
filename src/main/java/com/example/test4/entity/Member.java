package com.example.test4.entity;

import com.example.test4.dto.MemberResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pw;

    public Member(String name,String email,String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
    }
    public Member(MemberResponseDto requestDto) {
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.pw = requestDto.getPw();
    }

    public void update(MemberResponseDto requestDto) {
        LocalDate now = LocalDate.now();

        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.pw = requestDto.getPw();
    }
}
