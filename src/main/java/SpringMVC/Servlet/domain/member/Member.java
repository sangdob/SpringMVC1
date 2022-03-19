package SpringMVC.Servlet.domain.member;

/**
 * MemberVo 형태
 * 강의명 : 회원관리 애플리케이션 요구사항
 * @since 2022.03.16
 * @author sangdob
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private Long id;
	private String name;
	private int age;

	public Member() {
	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
