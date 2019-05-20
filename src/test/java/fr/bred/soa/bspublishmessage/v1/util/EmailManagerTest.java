package fr.bred.soa.bspublishmessage.v1.util;

import java.io.IOException;

import org.junit.Test;

public class EmailManagerTest {

    @Test
    public void testSendEmail() throws IOException, InterruptedException {
        System.out.println("testSendEmail start ");

        EmailManager email = new EmailManager();

        String receiver = "Chatchai Vichai";
//        String destinationAddress = "email";
        String destinationAddress = "email";
        


      
//        String subject = "Test Send Email2";
//        String message = "Test";
    	
//    	String subjectTemplate  = "Incoming Transfer";
//    	String template = "Dear <<Customer name>>\nSubject: <<TRN_DESC>>\n\nYour account has been debited due to  <<TRN_DESC>> as follows\n\n        Transaction Date: <<DD/MM/YYYY HH:MM:SS>>\n        Transaction Number: <<transaction reference no>>\n        Account: <<Customer account  in the format as XXXXXX-1234>>\n        Amount (USD): 10,000.00\n\nShould you require further information, please kindly contact:\n        - Bred Cambodia (24 hours) at Tel. XXXXXXX\n        - Email: info@bredcambodia.com\n        - Facebook: BRED Bank Cambodia\n\nYours sincerely,\nBRED Bank Cambodia\n";
    			
        String subjectTemplate1 = "Test Template1";
        String template1 = "Dear <<Customer name>>\nSubject: <<TRN_DESC>>\n\nYour account has been debited due to  <<TRN_DESC>> as follows\n\n        Transaction Date: <<DD/MM/YYYY HH:MM:SS>>\n        Transaction Number: <<transaction reference no>>\n        Account: <<Customer account  in the format as XXXXXX-1234>>\n        Amount (USD): 10,000.00\n\nShould you require further information, please kindly contact:\n        - Bred Cambodia (24 hours) at Tel. XXXXXXX\n        - Email: info@bredcambodia.com\n        - Facebook: BRED Bank Cambodia\n\nYours sincerely,\nBRED Bank Cambodia\n";

        String subjectTemplate2 = "Test Template2";
        String template2 = "Dear <<Customer name>>\nSubject: <<TRN_DESC>>\n\nYour account has been credited due to  <<TRN_DESC>> as follows\n\n        Transaction Date: <<DD/MM/YYYY HH:MM:SS>>\n        Transaction Number: <<transaction reference no>>\n        Account: <<Customer account>>\n        Amount (USD): 10,000.00\n\nShould you require further information, please kindly contact:\n        - Bred Cambodia (24 hours) at Tel. XXXXXXX\n        - Email: info@bredcambodia.com\n        - Facebook: BRED Bank Cambodia\n\nYours sincerely,\nBRED Bank Cambodia\n";
        

        email.sendEmail(receiver, destinationAddress, subjectTemplate1, template1);
        email.sendEmail(receiver, destinationAddress, subjectTemplate2, template2);
       
//        Thread.currentThread().sleep(20000L);
        System.out.println("testSendEmail done. ");
    }

}