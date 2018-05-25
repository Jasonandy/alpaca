/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.tools.extra.mail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import cn.ucaner.alpaca.framework.utils.tools.log.Log;
import cn.ucaner.alpaca.framework.utils.tools.log.LogFactory;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.extra.mail   
* @ClassName：MailUtil   
* @Description：   <p> 邮件工具类，基于javax.mail封装 </p>
* @Author： -    
* @CreatTime：2018年5月25日 上午10:21:44   
* @Modify By：   
* @ModifyTime：  2018年5月25日
* @Modify marker：   
* @version    V1.0
 */
public class MailUtil {
	private static Log log = LogFactory.get();

	/**
	 * 发送邮件给单收件人
	 * 
	 * @param to 收件人
	 * @param subject 标题
	 * @param content 正文
	 * @param isHtml 是否为HTML
	 */
	public static void send(String to, String subject, String content, boolean isHtml) {
		List<String> list = new ArrayList<String>();
		list.add(to);
		send(list, subject, content, isHtml);
	}

	/**
	 * 使用默认的设置账户发送邮件
	 * 
	 * @param tos 收件人列表
	 * @param subject 标题
	 * @param content 正文
	 * @param isHtml 是否为HTML
	 */
	public static void send(Collection<String> tos, String subject, String content, boolean isHtml) {
		try {
			send(GlobalMailAccount.INSTANCE.getAccount(), tos, subject, content, isHtml);
		} catch (MessagingException e) {
			log.error("Send mail error!", e);
		}
	}

	/**
	 * 发送邮件给多人
	 * 
	 * @param mailAccount 邮件认证对象
	 * @param tos 收件人列表
	 * @param subject 标题
	 * @param content 正文
	 * @param isHtml 是否为HTML格式
	 * @throws MessagingException
	 */
	public static void send(MailAccount mailAccount, Collection<String> tos, String subject, String content, boolean isHtml) throws MessagingException {
		// 认证登录
		final Session session = createSession(mailAccount);

		final Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(mailAccount.getFrom()));
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		if (isHtml) {
			final BodyPart html = new MimeBodyPart();
			html.setContent(content, "text/html; charset=utf-8");
			
			final Multipart mainPart = new MimeMultipart();
			mainPart.addBodyPart(html);
		} else {
			msg.setText(content);
		}

		for (String to : tos) {
			msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
			log.debug("Send mail to {} successed.", to);
		}
	}

	/**
	 * 创建邮件会话
	 * 
	 * @param mailAccount 邮件帐号信息
	 * @return 邮件会话 {@link Session}
	 */
	public static Session createSession(final MailAccount mailAccount) {
		return Session.getDefaultInstance(mailAccount.getSmtpProps(), //
				mailAccount.isAuth() ? new UserPassAuthenticator(mailAccount.getUser(), mailAccount.getPass()) : null);
	}
}
