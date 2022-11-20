package fastcode.api.util.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Lazy
public class AuthInterceptor extends HandlerInterceptorAdapter{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("####################### Previous Handler #########################");
		// session 객체를 가져옴
        HttpSession session = request.getSession();
        // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
        Object obj = session.getAttribute("sessionUser");
        //String id = (String)session.getAttribute("id");
        //exclude-mapping 대신, 요청된 url
        String requestUrl = request.getRequestURL().toString();
        //하단의 Url 체크를 통해, login 페이지는 예외처리를 해줘야 무한 리디렉션에서 벗어날 수 있다
        if(requestUrl.contains(request.getContextPath()+"/home")){
        	return true;
        }
        if ( obj == null ){
            // 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
            response.sendRedirect(request.getContextPath()+"/home");
            logger.info("========== Redirect ==========");
            // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
            return false;
        }
        // preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
        // 따라서 true로하면 컨트롤러 uri로 가게 됨.
        return true;
	}
	
}
