package SpringMVC.Servlet.basic.web.frontcontroller.v1.controller;

/**
 * 다형성을 이용한 Controller를 구현 [List]
 * Spring MVC-1
 * 강의명 : 프론트 컨트롤러 도입 - v1
 * @since 2022.03.22
 * @author sangdob
 */

import SpringMVC.Servlet.basic.web.frontcontroller.v1.ControllerV1;
import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();

		req.setAttribute("members", members);

		String viewPath = "/WEB-INF/views/list.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
