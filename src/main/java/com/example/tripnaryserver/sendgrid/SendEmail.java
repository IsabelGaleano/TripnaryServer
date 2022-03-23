package com.example.tripnaryserver.sendgrid;

import com.example.tripnaryserver.dto.CodigoDefDto;
import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class SendEmail {
    public void correoVerificacionUsuario(int codigo, String correo){
        Email from = new Email("lgaleanoh@ucenfotec.ac.cr");
        String subject = "Prueba";
        Email to = new Email(correo);
        Content content = new Content("text/plain", "Código es: " + codigo);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
