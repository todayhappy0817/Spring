package Hello.Hellospring.repository;

import Hello.Hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository= new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save (){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("S1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("s2");
        repository.save(member2);

        Member result =repository.findByName("s2").get();

        assertThat(result).isEqualTo(member2);
    }
}
