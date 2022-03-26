package SpringMVC.Servlet.basic.web.springmvc.v1;

import SpringMVC.Servlet.domain.member.Member;
import SpringMVC.Servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v1/members")
	public ModelAndView process(){
		List<Member> members = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("members", members);

		return modelAndView;
	}
}
