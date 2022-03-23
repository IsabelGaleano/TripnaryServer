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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SendEmail {

    private Response responseResult;

    public void correoVerificacionUsuario(int codigo, String correo){
        Email from = new Email("tripnaryp@gmail.com");
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
            this.responseResult = response;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
