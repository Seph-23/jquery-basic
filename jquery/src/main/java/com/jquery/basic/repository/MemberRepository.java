package com.jquery.basic.repository;

import com.jquery.basic.domain.Member;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

  private final EntityManager em;

  public void save(Member member) {       //멤버 엔티티를 디비에 저장.
    em.persist(member);
  }

  public Member findMember(Long id) {
    return em.find(Member.class, id);
  }

  public List<Member> findAll() {         //Member entity 전체를 리스트로 반환
    return em.createQuery("select m from Member m", Member.class).getResultList();
  }

  public Optional<Member> findByLoginId(String loginId) {
    return findAll().stream().filter(m -> m.getUserId().equals(loginId)).findFirst();
  }

}
