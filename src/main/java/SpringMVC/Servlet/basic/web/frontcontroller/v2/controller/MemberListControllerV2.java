package SpringMVC.Servlet.basic.web.frontcontroller.v2.controller;

import SpringMVC.Servlet.basic.web.frontcontroller.MyView;
import SpringMVC.Servlet.basic.web.frontcontroller.v2.ControllerV2;
import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2{

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();

		req.setAttribute("members", members);
		return new MyView("/WEB-INF/views/list.jsp");
	}
}
