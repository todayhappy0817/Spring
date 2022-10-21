package Hello.Hellospring.repository;

import Hello.Hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null 값일 경우 초기값으로 사용
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
