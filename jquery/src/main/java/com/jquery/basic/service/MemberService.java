package com.jquery.basic.service;

import com.jquery.basic.domain.Member;
import com.jquery.basic.dto.MemberForm;
import com.jquery.basic.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Optional<Member> findByLoginId(String userId) {
    return memberRepository.findByLoginId(userId);
  }

  /**
   * 회원가입
   */
  @Transactional
  public void signUp(MemberForm memberForm) {
    Member member = Member.createMember(memberForm);
    memberRepository.save(member);
  }
}
