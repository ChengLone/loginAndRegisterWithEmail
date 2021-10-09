package com.wang.springbootloginregister.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class MailService {

    //使用spring注解将 yml配置文件中的邮箱获取到
    @Value("${spring.mail.username}")
    private String mailUsername;

    //注入java发邮件的对象
    @Resource
    private JavaMailSender javaMailSender;

    //注入模板引擎，发送以模板引擎构建的html邮件
    @Resource
    private TemplateEngine templateEngine;

    /**
     * 激活账号邮件发送
     *
     * @param activationUrl  激活 url 链接
     * @param email          收件人邮箱
     */
    public void sendMailForActivationAccount(String activationUrl, String email){
        //创建邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
            //设置邮件主题
            message.setSubject("个人账号激活");
            //设置邮件发送者
            message.setFrom(mailUsername);
            //设置邮件的接受者，可以多个
            message.setTo(email);
            //设置邮件的抄送人，可以多个
//            message.setCc();
            //设置隐秘抄送人，可以多个
//            message.setBcc();
            //设置邮件发送日期
            message.setSentDate(new Date());
            //创建上下文环境
            Context context = new Context();
            context.setVariable("activationUrl",activationUrl);
            context.setVariable("email",email);
            String text = templateEngine.process("activation-account.html",context);
            //邮件发送
            message.setText(text,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }


}
