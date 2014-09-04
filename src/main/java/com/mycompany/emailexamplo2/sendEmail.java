package com.mycompany.emailexamplo2;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author magdiel-bruno
 */
public class sendEmail {

    public static void main(String[] args) {
        final String email = "ifpbpod@gmail.com";
        final String pass = "rmi12345";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pass);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("magdiel.ildefonso@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("magdiel.ildefonso@gmail.com, fernandodof@gmail.com"));
            message.setSubject("HTML");
            message.setText("<html><a href='http://www.google.com'>Google</a></html>");
            
            Transport.send(message);

            System.out.println("Ok!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
