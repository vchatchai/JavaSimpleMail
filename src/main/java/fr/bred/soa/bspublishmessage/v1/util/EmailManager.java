package fr.bred.soa.bspublishmessage.v1.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class EmailManager.
 */
@Data
@Slf4j
public class EmailManager {

	/** email server */
	private String host = "smtp.gmail.com";
//	private String host = "aspmx.l.google.com";

	/** port */
//	private int port = 587;
	private int port = 25;

	/** sender email */
//    private String sender = "email";
	private String senderAddress = "email";
	private String senderName = "No-Reply";

	/** sender password */
	private String senderPassword = "";

	private Mailer mailer;	
	
	

	public EmailManager() {
		super();
		mailer = MailerBuilder
				.withSMTPServer(host, port, senderAddress, senderPassword)
				.withDebugLogging(true)
				.withTransportStrategy(TransportStrategy.SMTP)
				.withTransportModeLoggingOnly(false)
				.buildMailer();

	}


	public void sendEmail(String receiver, String destinationAddress, String subject, String message)
			throws IOException {
//        log.info(String.format("Send Email to %s", destinationAddress));
		if ("true".equals("true")) {
			// ConfigLoader.loadProperties("simplejavamail.properties"); // optional default
			// ConfigLoader.loadProperties("overrides.properties"); // optional extra

			// almost everything is optional:
			// Email email = EmailBuilder.startingBlank()
			// .to("lollypop", "lolly.pop@somemail.com")
			// .to("C. Cane", "candycane@candyshop.org")
			// .ccWithFixedName("C. Bo group", "chocobo1@candyshop.org",
			// "chocobo2@candyshop.org")
			// .withRecipientsUsingFixedName("Tasting Group", BCC,
			// "taster1@cgroup.org;taster2@cgroup.org;tester &lt;taster3@cgroup.org&gt;")
			// .bcc("Mr Sweetnose &lt;snose@candyshop.org&gt;")
			// .withReplyTo("lollypop", "lolly.pop@othermail.com")
			// .withSubject("hey")
			// .withHTMLText("&lt;img src=&#39;cid:wink1&#39;&gt;&lt;b&gt;We should meet
			// up!&lt;/b&gt;&lt;img src=&#39;cid:wink2&#39;&gt;")
			// .withPlainText("Please view this email in a modern email client!")
			// .withEmbeddedImage("wink1", imageByteArray, "image/png")
			// .withEmbeddedImage("wink2", imageDatesource)
			// .withAttachment("invitation", pdfByteArray, "application/pdf")
			// .withAttachment("dresscode", odfDatasource)
			// .withHeader("X-Priority", 5)
			// .withReturnReceiptTo()
			// .withDispositionNotificationTo("notify-read-emails@candyshop.com")
			// .withBounceTo("tech@candyshop.com")
			// .signWithDomainKey(privateKeyData, "somemail.com", "selector")
			// .buildEmail();


			InputStream logInput1 = this.getClass().getResourceAsStream("bredit-logo.png");
			InputStream logInput2 = this.getClass().getResourceAsStream("bredit-logo.png");

			Email email = EmailBuilder.startingBlank()
					.to(receiver, destinationAddress)
					.from(senderName, senderAddress)
					.withSubject(subject)
//                    .withHTMLText(String.format("<img src=\"cid:wink1\"><b>We should meet up! %s <b/><img src=\"cid:wink2\">", receiver))
//					.withHTMLText("<p><IMG SRC=\"cid:wink1\" alt=\"Logo\"><H1>Chatchai Vichai</H1></p>")
//					.withEmbeddedImage("wink1", IOUtils.readFully(logInput1, logInput1.available()), "image/png")
//					.withEmbeddedImage("wink2", IOUtils.readFully(logInput2, logInput2.available()), "image/png")
					// .withEmbeddedImage("wink2", imageDatesource)
					 .withPlainText(message)
					// .withAttachment("invitation", pdfByteArray, "application/pdf")
					// .withAttachment("dresscode", odfDatasource)
                    .withHeader("X-Priority", 1)
					// .signWithDomainKey(privateKeyData, "somemail.com", "selector")
					.buildEmail();


			mailer.sendMail(email,false);
			
		}
	}

}
