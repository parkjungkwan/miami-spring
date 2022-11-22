package fastcode.api.cmm.app.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;
/**
 * 게시판 속성관리를 위한 컨트롤러  클래스
 * @author 프로젝트 매니저 박정관
 * @since 2021.02.10
 * @version 1.0
 * @see AppController.java
 *
 * 
 * << 개정이력(Modification Information) >>
 *   
 *   수정일              수정자           수정내용
 *  ----------  -------  ---------------------------
 *   2021.2.10   박정관          최초 생성
 *   2021.2.26   박정관          tiles 적용
 */
@RequiredArgsConstructor
@Controller
@SessionAttributes({"ctx","res","aim","bbs","cop","dwh","ext",
	"itm","olh","qna","sec","uss","qna","pub"})
public class AppController {
	
	
	final HttpSession session;
	final HttpServletRequest request;
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private void context() {
		session.setAttribute("ctx", request.getContextPath());
    	session.setAttribute("res", session.getAttribute("ctx")+"/resources");
    	session.setAttribute("aim", session.getAttribute("res")+"/aim");
    	session.setAttribute("bbs", session.getAttribute("res")+"/bbs");
    	session.setAttribute("cop", session.getAttribute("res")+"/cop");
    	session.setAttribute("dwh", session.getAttribute("res")+"/dwh");
    	session.setAttribute("ext", session.getAttribute("res")+"/ext");
    	session.setAttribute("img", session.getAttribute("ext")+"/image");
    	session.setAttribute("itm", session.getAttribute("res")+"/itm");
    	session.setAttribute("olh", session.getAttribute("res")+"/olh");
    	session.setAttribute("qna", session.getAttribute("res")+"/qna");
    	session.setAttribute("sec", session.getAttribute("res")+"/sec");
    	session.setAttribute("uss", session.getAttribute("res")+"/uss");
    	session.setAttribute("pub", session.getAttribute("res")+"/ext/public");
    	session.setAttribute("time",new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm").format(new Date()));
        logger.info("############ {} Project Initialized ##############  ", session.getAttribute("time"));
	}
	
    @RequestMapping("/")
    public String index() {
    	context();
    	return "def:main/MainView.dwh";
    }
    @GetMapping("/home")
    public String home() {
    	context();
    	return "def:main/MainView.dwh";
    }
    @GetMapping("/adm/{cat}/{dir}/{page}")
    public String adm(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("adm:%s/%s.%s", dir, page, cat);
    }
    @GetMapping("/mgr/{cat}/{dir}/{page}")
    public String mgr(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("mgr:%s/%s.%s", dir, page, cat);
    }
    @GetMapping("/stf/{cat}/{dir}/{page}")
    public String stf(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("stf:%s/%s.%s", dir, page, cat);
    }
    @GetMapping("/std/{cat}/{dir}/{page}")
    public String std(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("std:%s/%s.%s", dir, page, cat);
    }
    @GetMapping("/tkr/{cat}/{dir}/{page}")
    public String tkr(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("tkr:%s/%s.%s", dir, page, cat);
    }
    @GetMapping("/tut/{cat}/{dir}/{page}")
    public String tut(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("tut:%s/%s.%s", dir, page, cat);
    }
    @GetMapping("/usr/{cat}/{dir}/{page}")
    public String usr(
    		@PathVariable String cat,
    		@PathVariable String dir, 
    		@PathVariable String page) {
    	context();
    	return String.format("usr:%s/%s.%s", dir, page, cat);
    }
    
    @GetMapping("/sec/{dir}/{page}")
    public String sec(@PathVariable String dir, @PathVariable String page) {
    	context();
    	return String.format("sec/%s/%s", dir, page);
    }
    @GetMapping("/main/{dir}")
    public String main(@PathVariable String dir) {
    	context();
    	return makeReturnUrl(dir);
    }
    public String makeReturnUrl(String dir) {
    	switch (dir) {
		case "user": dir = "usr:user/UserContainer.uss"; break;
		case "student": dir = "std:train/StudentTrain.itm"; break;
		case "tutor": dir = "tut:tutor/TutorContainer.uss"; break;
		case "staff": dir = "stf:staff/StaffContainer.uss"; break;
		case "manager": dir = "mgr:train/Trains.itm"; break;
		case "admin": dir = "adm:admin/AdminContainer.uss"; break;
		case "testTaker": dir = "tkr:testTaker/TestTakerContainer.uss"; break;
		default:
			break;
		}
    	logger.info("[LOG] HomeController 에서 return 하는 URL : "+dir);
    	return dir;
    }
}

/**
 * 
 * http://localhost:8080/web/uss/student/home
 * HomeController 에서 return 하는 URL : uss/student/StudentContainer
 */
