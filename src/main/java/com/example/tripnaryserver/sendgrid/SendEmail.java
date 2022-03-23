package com.example.tripnaryserver.sendgrid;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import java.io.IOException;

public class SendEmail {
    public void correoVerificacionUsuario(int codigo, String correo){
//        Email from = new Email("david@rodriguezcoto.com");
//        String subject = " ";
//        Email to = new Email(correo);
//        Content content = new Content("text/html", " ");
//        Mail mail = new Mail(from, subject, to, content);
//        mail.setTemplateId("d-09125658c35f47e4a48ab15086648107");
//        Personalization personalization = new Personalization();
//        personalization.addDynamicTemplateData("header", codigo);
//        SendGrid sg = new SendGrid("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");
//        Request request = new Request();
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            Response response = sg.api(request);
//            System.out.println(response.getStatusCode());
//            System.out.println(response.getBody());
//            System.out.println(response.getHeaders());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String templateId = "d-09125658c35f47e4a48ab15086648107";
        Mail mail = new Mail();
        mail.setFrom(new Email("david@rodriguezcoto.com", "Tripnary"));
        mail.setTemplateId(templateId);
        Personalization personalization = new Personalization();
        personalization.addDynamicTemplateData("header", codigo);
        personalization.addTo(new Email(correo));
        mail.addPersonalization(personalization);
        sendInternal(mail);
    }
    private void sendInternal(Mail mail) {
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
