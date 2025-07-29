package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 추상화에 의존

    @Autowired // 자동 의존관계 주입 ac.getBean(MemberRepository.class) 이게 자동으로 들어간다고 보면 됨
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 생성자를 통해서 구현체에 뭐가 들어갈지 정함

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
