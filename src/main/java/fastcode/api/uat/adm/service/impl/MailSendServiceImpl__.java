package fastcode.api.uat.adm.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.bitcamp.lms.ext.domain.MailUtil;
import com.bitcamp.lms.sec.domain.CertHistory;
import com.bitcamp.lms.sec.repository.AuthRepository;
import com.bitcamp.lms.sec.repository.CertHistoryRepository;

import lombok.RequiredArgsConstructor;

//https://moonong.tistory.com/45
@Service @RequiredArgsConstructor
public class MailSendServiceImpl__ {
    final JavaMailSenderImpl mailSender;
    // @Autowired CertHistoryRepository certHistoryRepository;
    @Autowired CertHistoryRepository certHistoryRepository;
    final CertHistory certHistory;
	private int size;

    //인증키 생성
    @SuppressWarnings("unused")
	private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }
    
    
    public void sendAuthMail(CertHistory certHistory) {
    	certHistoryRepository.save(certHistory);
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
}
