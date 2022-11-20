package fastcode.api.uat.adm.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bitcamp.lms.dwh.enums.Messenger;
import com.bitcamp.lms.dwh.utility.Util;
import com.bitcamp.lms.sec.domain.CertHistory;
import com.bitcamp.lms.sec.repository.CertHistoryRepository;
import com.bitcamp.lms.sec.serviceImpl.CertHistoryServiceImpl;
import com.bitcamp.lms.sec.serviceImpl.MailSendServiceImpl__;
import com.bitcamp.lms.uss.domain.Manager;
import com.bitcamp.lms.uss.serviceImpl.ManagerServiceImpl;

// https://rongscodinghistory.tistory.com/3?category=693395
// https://moonong.tistory.com/45
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@SessionAttributes({"authEmail"})
@RequestMapping("/sec/register")  
public class UesrAuthorHistoryController {
	// final MailSendServiceImpl__ service;
	final CertHistory certHistory;
	final CertHistoryServiceImpl service;
	final ManagerServiceImpl managerService;
	final HttpSession session;
	//final CertHistoryRepository repository;
	@PostMapping("/manager")
    public Messenger getMailAuth(@RequestBody Manager param){
		certHistory.setMbEmail(param.getMbEmail());
		certHistory.setCrDate(Util.today.get().toString());
		certHistory.setCrTime(Util.time.get().toString());
		certHistory.setUuid(Util.uuid.get());
	   if(!service.exists(param.getMbEmail())) { 
		   service.save(certHistory);
	   }else {
		   service.update(certHistory);
	   }	
	   service.sendAuthMail(certHistory);
       return Messenger.SUCCESS;

 	}
	@PostMapping("/manager-uuid")
    public Messenger matchUuid(@RequestBody CertHistory param){
	   String uuid = service.findUuidByEmail(param.getMbEmail());
	   Messenger result = null;
	   if(param.getUuid().equals(uuid)) {
		   session.removeAttribute("authEmail");
		   session.setAttribute("authEmail", param.getMbEmail());
		   result = Messenger.SUCCESS;
	   }else {
		   result = Messenger.FAILURE;
	   }
	   return result;
 	}
	@PostMapping("/managerSignup")
    public Messenger signup(@RequestBody Manager param){
		managerService.save(param);
       return Messenger.SUCCESS;

 	}
}
