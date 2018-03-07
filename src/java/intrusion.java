/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author divyavirmani
 */
@WebServlet(urlPatterns = {"/intrusion"})
public class intrusion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            sendMail();
        } catch (MessagingException ex) {
            Logger.getLogger(intrusion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMail() throws AddressException, MessagingException {    
      // Recipient's email ID needs to be mentioned.
      String to = "ashishkharbanda1990@gmail.com";
      String host = "smtp.gmail.com";
      Properties prop = System.getProperties();
      prop.put("mail.smtp.starttls.enable", "true");
      prop.put("mail.smtp.host",host);
      prop.put("mail.smtp.user","virmani.divya18@gmail.com");
      prop.put("mail.smtp.password","");
      prop.put("mail.smtp.port",587);
      prop.put("mail.smtp.auth", "true"); 
      Session session = Session.getDefaultInstance(prop,null);
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("virmani.divya18@gmail.com"));
      InternetAddress toAddress = new InternetAddress(to);
      InternetAddress[] arr = new InternetAddress[1];
      arr[0] = toAddress;
      message.setSubject("Intrusion Occured!!!!!!!!!");
      message.setText("ALERT!!!! An intrusion has been detected. Please check you premises");
      Transport t = session.getTransport("smtp");
      t.connect(host,"virmani.divya18@gmail.com","");
      t.sendMessage(message, arr);
     
   }
}
