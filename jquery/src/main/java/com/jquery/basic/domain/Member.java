package com.jquery.basic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import com.jquery.basic.dto.MemberForm;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

  @Id @GeneratedValue(strategy = IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(nullable = false, unique = true)
  private String userId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String nickname;

  //생성 메서드
  public static Member createMember(MemberForm memberForm) {
    Member member = new Member();
    member.setUserId(memberForm.getUserId());
    member.setPassword(memberForm.getPassword());
    member.setNickname(memberForm.getNickname());
    return member;
  }
}
