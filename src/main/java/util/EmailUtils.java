package util;

import org.apache.commons.mail.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmailUtils {

    private static HtmlEmail email;

    public EmailUtils(){

    }

    public static void enviarEmail(){
        try{
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("emailtestesantander@gmail.com", "Santander123"));
            email.setSSLOnConnect(true);
            email.setFrom("mariana.groppa@santander.com.br");
            email.setSubject("Aniversariantes Estação 33");
            email.setMsg("Teste dispardo de email aniversariantes");
            email.addTo("mariana.groppa@santander.com.br");
            email.addTo("gabriel.ruiz@santander.com.br");
            email.addTo("richard.mota@santander.com.br");
            //email.addTo("astato@santander.com.br");
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public static void enviarEmailComHtml() {
        try{
            email = new HtmlEmail ();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("emailtestesantander@gmail.com", "Santander123"));
            email.setSSLOnConnect(true);
            email.addTo("gabriel.eliaz@hotmail.com");
            email.addTo("mariana.groppa@santander.com.br");
            email.addTo("gabriel.ruiz@santander.com.br");
            email.addTo("richard.mota@santander.com.br");
            email.setFrom ("gabriel.ruiz@santander.com.br");
            email.setSubject ("Testar e-mail com imagem embutida");

    //        incorpora a imagem e obtém o id do conteúdo
            //URL url = new URL ("https://scontent.faqa4-1.fna.fbcdn.net/v/t1.6435-9/53316650_2127749710639085_1308123927419027456_n.jpg?_nc_cat=108&ccb=1-3&_nc_sid=09cbfe&_nc_ohc=ebcDEARPNF0AX-KW472&tn=kQ9YcfsV5Qe0x1ve&_nc_ht=scontent.faqa4-1.fna&oh=ae939775d7fa6e8523f0b4eb2903bf0d&oe=60C28696");
            //String cid = email.embed (url, "richard");

            // definir a mensagem html
            email.setHtmlMsg ("<div>" +
                    "<img src=\"src/main/resources/img/richard.jpg\">" +
                    "<h1>Feliz Anivers&aacute;rio</h1>" +
                    "<p> Parab&eacute;ns @Richard, muitas felicidades e sucesso! </p>" +
                    "</div>" +
                    "</html>");

            // definir a mensagem alternativa
            email.setTextMsg ("Seu cliente de e-mail não suporta mensagens HTML");

            // envie o email
            email.send ();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
