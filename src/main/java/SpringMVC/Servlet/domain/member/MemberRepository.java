package SpringMVC.Servlet.domain.member;

/**
 * MemberRepository로써 데이터를 저장하는 singleton형태이다
 * 강의명 : 회원관리 애플리케이션 요구사항
 * @since 2022.03.16
 * @author sangdobaw
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

	private static final Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	private static final MemberRepository instance = new MemberRepository();

	public static MemberRepository getInstance() {
		return instance;
	}

	private MemberRepository() {
	}

	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public Member findById(Long id){
		return store.get(id);
	}

	public void clearStore(){
		store.clear();
	}
}
