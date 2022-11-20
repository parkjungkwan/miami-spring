package fastcode.api.uat.adm.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.bitcamp.lms.ext.domain.MailUtil;
import com.bitcamp.lms.sec.domain.CertHistory;
import com.bitcamp.lms.sec.repository.AuthRepository;
import com.bitcamp.lms.sec.repository.CertHistoryRepository;
import com.bitcamp.lms.sec.service.CertHistoryService;

import lombok.RequiredArgsConstructor;

//https://moonong.tistory.com/45
@Service @RequiredArgsConstructor
public class AdminAuthHistoryServiceImpl implements CertHistoryService{
	final JavaMailSenderImpl mailSender;
    // @Autowired CertHistoryRepository certHistoryRepository;
	final CertHistoryRepository repository;
    final CertHistory certHistory;
    
    @Override
    public String generateAuthCode(int size) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }
    
    @Override
    public void sendAuthMail(CertHistory certHistory) {
        try {
            MailUtil sendMail = new MailUtil(mailSender);
            sendMail.setSubject("회원가입 이메일 인증");
            sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
            .append("<p>아래 인증키를 입력창에 입력하세요</p>")
            .append("<p>"+certHistory.getUuid()+"</p>")
            .toString());
            sendMail.setFrom("pakjkwan2@gmail.com", "관리자");
            sendMail.setTo(certHistory.getMbEmail());
            sendMail.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    
    public String findUuidByEmail(String email) {
    	return repository.findByEmail(email);
    }
    public int save(CertHistory param) {
    	return repository.save(param);
    }
    public int update(CertHistory param) {
    	return repository.update(param);
    }
    public boolean exists(String id) {
    	return repository.exists(id);
    }
}








