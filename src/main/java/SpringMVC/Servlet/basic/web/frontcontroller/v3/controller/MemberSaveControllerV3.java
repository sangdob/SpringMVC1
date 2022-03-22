package SpringMVC.Servlet.basic.web.frontcontroller.v3.controller;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.ControllerV3;
import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3{
	private MemberRepository memberRepository = MemberRepository.getInstance();


	@Override
	public ModelView process(Map<String, String> paramMap) {
		String username = paramMap.get("username");
		int age = Integer.parseInt(paramMap.get("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		ModelView modelView = new ModelView("saveResult");
		modelView.getModel().put("member", member);

		return modelView;
	}
}
