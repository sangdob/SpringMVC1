package SpringMVC.Servlet.basic.web.frontcontroller.v3;

import SpringMVC.Servlet.basic.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

	ModelView process(Map<String, String> paramMap);

}
