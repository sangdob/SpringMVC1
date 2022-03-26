package SpringMVC.Servlet.basic.web.springmvc.v2;

import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/newForm")
	public ModelAndView newform(){
		System.out.println("SpringMemberFormControllerV1.process");
		return new ModelAndView("newForm");
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		ModelAndView modelAndView = new ModelAndView("saveResult");

		modelAndView.addObject("member", member);

		return modelAndView;
	}

	@RequestMapping
	public ModelAndView list(){
		List<Member> members = memberRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("members", members);

		return modelAndView;
	}
}
