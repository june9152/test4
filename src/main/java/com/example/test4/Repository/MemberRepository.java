package com.example.test4.Repository;

import com.example.test4.entity.Member;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>
{

}
