package fastcode.api.uat.adm.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bitcamp.lms.sec.repository.AuthRepository;
import com.bitcamp.lms.uss.domain.Manager;
import com.bitcamp.lms.uss.domain.Student;
import com.bitcamp.lms.uss.domain.Tutor;

// https://rongscodinghistory.tistory.com/3?category=693395
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@Scope("session")
@SessionAttributes({"sessionUser"})
@RequestMapping("/sec/auth")
public class UserAuthorController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AuthRepository repository;
    
    @PostMapping("/student")
    public @ResponseBody Map<?,?> studentLogin(@RequestBody Student param, HttpSession session,HttpServletResponse response){
    	HashMap<String,Object> map = new HashMap<>();
    	String returnURL ="";
        if ( session.getAttribute("sessionUser") !=null ){
        	logger.info("[LOG] 기존에 login이란 세션 값이 존재한다면, 기존값을 제거해 준다.");
            session.removeAttribute("sessionUser");
            session.removeAttribute("sessionUserName");
        }
        logger.info("[LOG] 로그인이 성공하면 Student 객체를 반환한다.");
        Student student = repository.studentLogin(param);
        if ( student !=null ){
        	logger.info("[LOG] 로그인 성공 ::: 세션에 sessionUser 으로 User 객체를 저장해 논다.");
            session.setAttribute("sessionUser", student);
            session.setAttribute("sessionUserName", student.getStudentName());
            // returnURL ="redirect:/sec/stu/stu-login";// 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
            returnURL = makeReturnUrl("2");
            /*
             *  [   세션 추가되는 부분      ]
             */
            // 1. 로그인이 성공하면, 그 다음으로 로그인 폼에서 쿠키가 체크된 상태로 로그인 요청이 왔는지를 확인한다.
            if ( param.isUseCookie() ){// dto 클래스 안에 useCookie 항목에 폼에서 넘어온 쿠키사용 여부(true/false)가 들어있을 것임
                // 쿠키 사용한다는게 체크되어 있으면...
                // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에 저장한다.
                Cookie cookie = new Cookie("cookieUser", session.getId());
                // 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24*7);// 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
                // 쿠키를 적용해 준다.
                response.addCookie(cookie);
            }
        }else {// 로그인에 실패한 경우
        	map.put("result", "FAILURE");
        }
        logger.info("[LOG] 로그인  후 돌아가기 :: "+ returnURL); 
        
        map.put("url", returnURL);
        map.put("sessionUser", student);
        return map;


    }
    public String makeReturnUrl(String levelNumber) {
    	String returnUrl = "";
    	switch (levelNumber) {
		case "1": returnUrl = "user"; break;
		case "2": returnUrl = "student"; break;
		case "3": returnUrl = "tutor"; break;
		case "4": returnUrl = "staff"; break;
		case "5": returnUrl = "manager"; break;
		case "6": returnUrl = "admin"; break;
		case "7": returnUrl = "testTaker"; break;
		default:
			break;
		}
    	
    	return String.format("main/%s", returnUrl);
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/home";
    }
    @PostMapping("/manager")
    public @ResponseBody Map<?,?> managerLogin(@RequestBody Manager param, HttpSession session,HttpServletResponse response){
    	HashMap<String,Object> map = new HashMap<>();
    	String returnURL ="";
        if ( session.getAttribute("sessionUser") !=null ){
        	logger.info("[LOG] 기존에 login이란 세션 값이 존재한다면, 기존값을 제거해 준다.");
            session.removeAttribute("sessionUser");
            session.removeAttribute("sessionUserName");
        }
        logger.info("[LOG] 매니저 로그인 정보 : "+param.toString());
        Manager manager = repository.managerLogin(param);
        if ( manager !=null ){
        	logger.info("[LOG] 매니저 로그인 성공 ::: 세션에 sessionUser 으로 User 객체를 저장해 논다.");
        	map.put("result", "SUCCESS");
        	session.setAttribute("sessionUser", manager);
            session.setAttribute("sessionUserName", manager.getMbrName());
            // returnURL ="redirect:/sec/stu/stu-login";// 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
            returnURL = makeReturnUrl("5");
            /*
             *  [   세션 추가되는 부분      ]
             */
            // 1. 로그인이 성공하면, 그 다음으로 로그인 폼에서 쿠키가 체크된 상태로 로그인 요청이 왔는지를 확인한다.
            if ( param.isUseCookie() ){// dto 클래스 안에 useCookie 항목에 폼에서 넘어온 쿠키사용 여부(true/false)가 들어있을 것임
                // 쿠키 사용한다는게 체크되어 있으면...
                // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에 저장한다.
                Cookie cookie = new Cookie("cookieUser", session.getId());
                // 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24*7);// 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
                // 쿠키를 적용해 준다.
                response.addCookie(cookie);
            }
        }else {// 로그인에 실패한 경우
        	logger.info("[LOG] 매니저 로그인 실패");
        	map.put("result", "FAILURE");
        }
        logger.info("[LOG] 로그인  결과 :: "+ map.get("result")); 
        logger.info("[LOG] 로그인  URL :: "+ returnURL); 
        map.put("url", returnURL);
        map.put("sessionUser", manager);
        return map;


    }
    
    @PostMapping("/tutor")
    public @ResponseBody Map<?,?> tutorLogin(@RequestBody Tutor param, HttpSession session,HttpServletResponse response){
    	
    	String returnURL ="";
        if ( session.getAttribute("sessionUser") !=null ){
        	logger.info("[LOG] 기존에 login이란 세션 값이 존재한다면, 기존값을 제거해 준다.");
            session.removeAttribute("sessionUser");
            session.removeAttribute("sessionUserName");
        }
        logger.info("[LOG] 로그인이 성공하면 Student 객체를 반환한다.");
        Tutor tutor = repository.tutorLogin(param);
        if ( tutor !=null ){
        	logger.info("[LOG] 로그인 성공 ::: 세션에 sessionUser 으로 User 객체를 저장해 논다.");
            session.setAttribute("sessionUser", tutor);
            session.setAttribute("sessionUserName", tutor.getTutName());
            // returnURL ="redirect:/sec/stu/stu-login";// 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
            returnURL = makeReturnUrl("3");
            /*
             *  [   세션 추가되는 부분      ]
             */
            // 1. 로그인이 성공하면, 그 다음으로 로그인 폼에서 쿠키가 체크된 상태로 로그인 요청이 왔는지를 확인한다.
            if ( param.isUseCookie() ){// dto 클래스 안에 useCookie 항목에 폼에서 넘어온 쿠키사용 여부(true/false)가 들어있을 것임
                // 쿠키 사용한다는게 체크되어 있으면...
                // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에 저장한다.
                Cookie cookie = new Cookie("cookieUser", session.getId());
                // 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24*7);// 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
                // 쿠키를 적용해 준다.
                response.addCookie(cookie);
            }
        }else {// 로그인에 실패한 경우
            returnURL ="redirect:/";// 로그인 폼으로 다시 가도록 함
        }
        logger.info("[LOG] 로그인  후 돌아가기 :: "+ returnURL); 
        HashMap<String,Object> map = new HashMap<>();
        map.put("url", returnURL);
        map.put("sessionUser", tutor);
        return map;


    }
    
}

