package SpringMVC.Servlet.basic.web.frontcontroller.v1.controller;

/**
 * 다형성을 이용한 Controller를 구현 [Save]
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

public class MemberSaveControllerV1 implements ControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		req.setAttribute("member", member);

		String viewPath = "/WEB-INF/views/saveResult.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
