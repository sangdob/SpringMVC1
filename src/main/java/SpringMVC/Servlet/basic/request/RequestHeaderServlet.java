package SpringMVC.Servlet.basic.request;

/**
 * HTTPServletRequest의 정보를 확인하는 Class
 * Spring MVC-1
 * 강의명 : HttpServletRequest - 기본 사용법
 * @since 2022.03.15
 * @author sangdob
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printRequestSpec(req);
        printRequestHeaders(req);
        printHeaderUtils(req);
        printEtc(req);
    }

    private void printRequestSpec(HttpServletRequest req) {
        System.out.println();
        System.out.println("------Request-Line -- Start ------");
        System.out.println("request.getMethod() = " + req.getMethod());
        System.out.println("request.getProtocol() = " + req.getProtocol());
        System.out.println("request.getSchema() =" + req.getScheme());
        System.out.println("request.getRequestURL() = " + req.getRequestURL());
        System.out.println("request.getRequestURI() = " + req.getRequestURI());
        System.out.println("request.getQueryString() = " + req.getQueryString());
        System.out.println("request.isSecure() = " + req.isSecure());
        System.out.println("------Request-Line -- End -------");
        System.out.println();
    }

    private void printRequestHeaders(HttpServletRequest req){
        System.out.println();
        System.out.println("------Request-Headers -- Start ------");

       /* Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){ //가지고있는 속성
            String headerName = headerNames.nextElement();
            System.out.println("HeaderName = " + headerName);
        }*/

        //Refactoring lambda형식
        req.getHeaderNames().asIterator()
                .forEachRemaining(s -> System.out.println("headerName = " + s));
        System.out.println("request.getLocale() = " + req.getLocale());

        System.out.println("------Request-Headers -- End ------");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest req){
        System.out.println();
        System.out.println("------Request-Headers-Utils -- Start ------");
        System.out.println("[Request Host 조회]");

        System.out.println("request.getSereverName() = " + req.getServerName());
        System.out.println("request.getServerPort() = " + req.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 조회]");

        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale = " + req.getLocale());
        System.out.println();

        System.out.println("[Cookie 조회]");
        if (req.getCookies() != null){
            for(Cookie cookie : req.getCookies()){
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        }

        System.out.println("[Content 조회]");
        System.out.println("request.getContentType() = " + req.getContentType());
        System.out.println("request.getContentLength() = " + req.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + req.getCharacterEncoding());

        System.out.println("------Request-Headers-Utils -- End ------");
        System.out.println();
    }

    private void printEtc(HttpServletRequest req){
        System.out.println();
        System.out.println("------Request-Remote -- Start ------");


        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + req.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + req.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + req.getRemotePort());
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + req.getLocalName());
        System.out.println("request.getLocalAddr() = " + req.getLocalAddr());
        System.out.println("request.getLocalPort() = " + req.getLocalPort());
        System.out.println();

        System.out.println("------Request-Remote -- End ------");
        System.out.println();

    }
}
