package SpringMVC.Servlet.basic.web.frontcontroller.v3.controller;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;
import SpringMVC.Servlet.basic.web.frontcontroller.v3.ControllerV3;
import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		List<Member> members = memberRepository.findAll();
		ModelView modelView = new ModelView("list");
		modelView.getModel().put("members", members);

		return modelView;
	}
}
