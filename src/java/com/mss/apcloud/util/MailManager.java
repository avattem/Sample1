package com.mss.apcloud.util;

import com.mss.apcloud.general.RegistrationAction;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
//import java.io.UnsupportedEncodingException;
import java.io.*;
//new

import java.util.HashSet;
import com.mss.apcloud.util.DataSourceDataProvider;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
// New imports for authentication
import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 * The
 * <code>MailManager</code> class is used for getting user password details from
 * <i>ForgotPassword.jsp</i> page.
 *
 * @author RajaReddy.Andra <a
 * href="mailto:randra@miraclesoft.com">randra@miraclesoft.com</a>
 *
 * @version 1.0 Nov 01, 2007
 *
 */
public class MailManager {

    public MailManager() {
    }
    // private static final String SMTP_AUTH_USER = "hubbleapp@miraclesoft.com";
    // private static final String SMTP_AUTH_PWD  = "R0leMod3l";
    // private static final String SMTP_HOST  = "mail.miraclesoft.com";
    private static final String SMTP_AUTH_USER = com.mss.apcloud.util.Properties.getProperty("Mail.Auth").toString();
    private static final String SMTP_AUTH_PWD = com.mss.apcloud.util.Properties.getProperty("Mail.Auth.pwd").toString();
    private static final String SMTP_HOST = com.mss.apcloud.util.Properties.getProperty("Mail.Host").toString();
    private static final String SMTP_PORT = com.mss.apcloud.util.Properties.getProperty("Mail.Port").toString();
    // private static final String SMTP_HOST  = "192.168.5.5";

    /**
     * Starting of Send Method
     *
     * @param loginId it is mailId of user
     * @param userName it is Name of the user
     * @param password it is password of the MirageV2 account
     * @throws NoSuchProviderException
     * @throws MessagingException UPDATED
     */
    public String sendResetPwd(String emailId, String userName, String password) {

        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        /**
         * The to is used for storing the user mail id to send details.
         */
        String resultMessage = "";
        String to = emailId;

        /**
         * The from is used for storing the from address.
         */
        String from = "apcloud@miraclesoft.com";

        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!

        /**
         * The host is used for storing the IP address of mail
         */
        /**
         * The props is instance variabel to
         * <code>Properties</code> class
         */
        Properties props = new Properties();

        /**
         * Here set smtp protocal to props
         */
        props.setProperty("mail.transport.protocol", "smtp");

        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /**
         * Here set the authentication for the host *
         */
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
        // mailSession.setDebug(true);
        mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Password Details");
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();

            htmlText.append("  <html xmlns=\"http://www.w3.org/1999/xhtml\">  ");
            htmlText.append("  <head>  ");
            htmlText.append("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">  ");
            htmlText.append("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\">  ");
            htmlText.append("  <title>  Faculty Enrollment </title>  ");
            htmlText.append("  <style>  ");
            htmlText.append("   @font-face {  ");
            htmlText.append(" font-family: 'source_sans_probold';  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot');  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('  ");
            htmlText.append(" http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('  ");

            htmlText.append("  http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('  ");
            htmlText.append(" http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('  ");
            htmlText.append(" http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg');  ");
            htmlText.append("font-weight: normal;  ");
            htmlText.append("font-style: normal;}  ");


            htmlText.append("@font-face { font-family: 'source_sans_prosemibold';  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot');  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg');  ");
            htmlText.append(" font-weight: normal;  ");
            htmlText.append(" font-style: normal;  ");
            htmlText.append(" }   ");

            htmlText.append(" @font-face {  ");
            htmlText.append(" font-family: 'source_sans_proregular';  ");
            htmlText.append("src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot');  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg');  ");
            htmlText.append(" font-weight: normal;  ");
            htmlText.append(" font-style: normal;  ");
            htmlText.append("}  ");

            htmlText.append(" body {  ");
            htmlText.append("margin: 0px;  ");
            htmlText.append(" padding: 0px;  ");
            htmlText.append(" }  ");
            htmlText.append(" ::selection {  ");
            htmlText.append(" background: #ff2f2f;  ");

            htmlText.append(" }  ");
            htmlText.append(" ::-moz-selection {  ");
            htmlText.append(" background: #ff2f2f;  ");

            htmlText.append(" }  ");

            htmlText.append(" @media only screen and (max-width: 640px) {  ");

            htmlText.append(" table[class=scale] {  ");
            htmlText.append("width: 100%!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" table[class=scale-center-both] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-left: 20px!important;  ");
            htmlText.append(" padding-right: 20px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" table[class=scale-center-bottom] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-bottom: 12px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" table[class=margin-center] {  ");
            htmlText.append(" margin: auto!important;  ");
            htmlText.append(" }  ");
            htmlText.append("table[class=hide] {  ");
            htmlText.append("display: none!important;  ");
            htmlText.append(" }  ");

            htmlText.append(" td[class=scale-center-both] {  ");
            htmlText.append("width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-left: 20px!important;  ");
            htmlText.append("  padding-right: 20px!important;  ");
            htmlText.append("  }  ");
            htmlText.append(" td[class=scale-center-left] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: right!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=scale-center-bottom] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-bottom: 24px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=scale-center-bottom-both] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-bottom: 12px!important;  ");
            htmlText.append(" padding-left: 20px!important;  ");
            htmlText.append(" padding-right: 20px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=bottom12] {  ");
            htmlText.append(" padding-bottom: 12px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=bottom19] {  ");
            htmlText.append(" padding-bottom: 19px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=bottom21] {  ");
            htmlText.append(" padding-bottom: 21px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=height4] {  ");
            htmlText.append(" height: 4px!important;  ");
            htmlText.append(" font-size: 1px!important;  ");
            htmlText.append(" }  ");

            htmlText.append(" img[class=\"scale\"] {  ");
            htmlText.append(" width: 90%!important;  ");
            htmlText.append("}  ");
            htmlText.append(" img[class=\"reset\"] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" }  ");
            htmlText.append("  }  ");
            htmlText.append("  </style>  ");
            htmlText.append("  </head>  ");
            htmlText.append("  <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\">  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">  &nbsp;  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\">  ");
            htmlText.append("  <img mc:edit=\"Logo\" src=\"http://www.miraclesoft.com/images/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\">  ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">  About </a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"http://www.apcloud.in/ac/general/contactUS.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\"> Contact Us </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">  &nbsp;  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(http://www.miraclesoft.com/images/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"http://www.miraclesoft.com/images/apcloud-banner.jpg\" data-bgcolor=\"Header\" data-bg=\"Header\">  ");

            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\">  ");
            htmlText.append("  <b>  World's Destination  </b>   for   <b> Digital Transformation  </b> Skilled Workforce  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");

            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\">  ");
            htmlText.append("  <b>  Password Details </b>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\">  ");
            htmlText.append("  <font color=\"#232527\">    <b> Dear " + userName + "  </b>  ");
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
//            htmlText.append("  <tr>  ");
//            htmlText.append("  <td>  ");
//            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
//            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
//            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
//           
//           
//           // htmlText.append("  Thank you for enrolling your college to our  <b> AP Cloud Initiative  </b> . You can use the below username and password to login into our portal. ");
//            htmlText.append("  </p>  ");
//            htmlText.append("  </div>  ");
//            htmlText.append("  </div>  ");
//            htmlText.append("  </td>  ");
//            htmlText.append("  </tr>  ");

            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#232527\">  ");

//            htmlText.append(" <b> Hello " + userName + ",</b>");
//            htmlText.append(" <br><b> Password " + password + ",</b>");



            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\">  Login :  </b>   " + emailId + "");
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");


            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#232527\">  ");
            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\">  Password:  </b>  " + password + " ");
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");


            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");

            htmlText.append("<font color='red'> Note: To better protect your account,make sure that your password is memorable.</font>");
            htmlText.append("  <font color=\"#232527\">  ");
//            htmlText.append("<br>for you but difficult for others to guess. Never use the same password that ");
//            htmlText.append("<br>you have used in the past, and do not share your password with anyone.</font> ");
//           
            // htmlText.append("  Thank you for enrolling your college to our  <b> AP Cloud Initiative  </b> . You can use the below username and password to login into our portal. ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");


//             htmlText.append("<font color='red'> Note: To better protect your account,make sure that your password is memorable.</font>");
//              htmlText.append("  <font color=\"#232527\">  ");
//            htmlText.append("<br>for you but difficult for others to guess. Never use the same password that ");
//            htmlText.append("<br>you have used in the past, and do not share your password with anyone.</font> ");

            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 13px;\">  ");
            htmlText.append("  <font color=\"#ef4048\">  ");
            htmlText.append(" Please login and change your password within 48 hours of this email ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#b7b2b3\">  ");
            htmlText.append("  <b>  Thanks &amp; Regards, </b>  ");
            htmlText.append("  <br>   AP Cloud Team,  ");
            htmlText.append("  <br>   Miracle Software Systems, Inc. ");
            htmlText.append("  <br>   Email :   <a href=\"mailto:apcloud@miraclesoft.com\" target=\"blank\" style=\"text-decoration:none\">   <font color=\"#b7b2b3\">  apcloud@miraclesoft.com </a>  </font>  ");
            htmlText.append("  <br>  Phone : 0891-6623556 ");
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\">  ");
            htmlText.append("  <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"10\">  &nbsp;</td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\">  ");

            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td width=\"200\" align=\"center\" style=\"text-align: center;\">  ");
            htmlText.append("  <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://twitter.com/andhracloud\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Footer\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"18\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\">  ");
            htmlText.append("  <b>  © Copyright 2016   <span style=\"color:#00aae7;\">  Miracle Software Systems, Inc.</span>    </b>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");

            htmlText.append("    &nbsp;  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
//            htmlText.append("  <div id=\"edit_link\" class=\"hidden\" style=\"display: none;\">  ");
//
//            htmlText.append("  <div class=\"close_link\">  ");
//            htmlText.append("  </div>  ");
//
//            htmlText.append("  <input type=\"text\" id=\"edit_link_value\" class=\"createlink\" placeholder=\"Your URL\">  ");
//
//            htmlText.append("  <div id=\"change_image_wrapper\">  ");
//
//            htmlText.append("  <div id=\"change_image\">  ");
//
//            htmlText.append("  <p id=\"change_image_button\"> Change &nbsp;  <span class=\"pixel_result\">    </span>  ");
//            htmlText.append("  </p>  ");
//            htmlText.append("  </div>  ");
//
//            htmlText.append("  <input type=\"button\" value=\"\" id=\"change_image_link\">  ");
//
//            htmlText.append("  <input type=\"button\" value=\"\" id=\"remove_image\">  ");
//            htmlText.append("  </div>  ");
//
//            htmlText.append("  <div id=\"tip\">  ");
//            htmlText.append("  </div>  ");
//            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </body>  ");
            htmlText.append("  </html>  ");

            // System.out.println("ResetPWD-->"+htmlText.toString());


            messageBodyPart.setContent(htmlText.toString(), "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            //System.out.println("Mail Sent ----->");
            resultMessage = "MailSent";
            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return resultMessage;
    }

    public String sendCollegeEnrollment(RegistrationAction registrationAction) {

        //    System.out.println("---nominiee---" + registrationAction.getStudentEmail() + " pemail--> " + registrationAction.getPrincipalEmail() + "---aemail----" + registrationAction.getFacultyambassadorEmail());
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        /**
         * The to is used for storing the user mail id to send details.
         */
        String resultMessage = "";
        /**
         * The from is used for storing the from address.
         */
        String from = "apcloud@miraclesoft.com";

        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!

        /**
         * The host is used for storing the IP address of mail
         */
        /**
         * The props is instance variabel to
         * <code>Properties</code> class
         */
        Properties props = new Properties();

        /**
         * Here set smtp protocal to props
         */
        props.setProperty("mail.transport.protocol", "smtp");

        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /**
         * Here set the authentication for the host *
         */
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
        // mailSession.setDebug(true);
        mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Thank you for Registering into AP Cloud Initiative ");
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(registrationAction.getStudentEmail()));

            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();
            /*--------------------------------------------------------*/


            htmlText.append(" <html xmlns=\"http://www.w3.org/1999/xhtml\"> ");
            htmlText.append(" <head> ");
            htmlText.append(" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
            htmlText.append(" <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\"> ");
            htmlText.append(" <title>Student Enrollment</title> ");
            htmlText.append(" <style> ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_probold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_prosemibold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_proregular'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'),  url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'),url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");

            htmlText.append(" body { ");
            htmlText.append(" margin: 0px; ");
            htmlText.append(" padding: 0px; ");
            htmlText.append(" } ");
            htmlText.append(" ::selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");
            htmlText.append(" ::-moz-selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");

            htmlText.append(" @media only screen and (max-width: 640px) { ");

            htmlText.append(" table[class=scale] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=margin-center] { ");
            htmlText.append(" margin: auto!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=hide] { ");
            htmlText.append(" display: none!important; ");
            htmlText.append(" } ");

            htmlText.append(" td[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-left] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: right!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 24px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom12] { ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom19] { ");
            htmlText.append(" padding-bottom: 19px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom21] { ");
            htmlText.append(" padding-bottom: 21px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=height4] { ");
            htmlText.append(" height: 4px!important; ");
            htmlText.append(" font-size: 1px!important; ");
            htmlText.append(" } ");

            htmlText.append(" img[class=\"scale\"] { ");
            htmlText.append(" width: 90%!important; ");
            htmlText.append(" } ");
            htmlText.append(" img[class=\"reset\"] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" } ");
            htmlText.append(" </style> ");
            htmlText.append(" </head> ");
            htmlText.append(" <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\"> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append(" <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\"> ");
            htmlText.append(" <img mc:edit=\"Logo\" src=\"http://www.miraclesoft.com/images/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\"> ");
            htmlText.append(" </a> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\"> ");
            htmlText.append(" <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">About</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"http://www.apcloud.in/ac/general/contactUS.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">Contact Us</a> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(http://www.miraclesoft.com/images/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"http://www.miraclesoft.com/images/apcloud-banner.jpg\" data-bgcolor=\"Header\" data-bg=\"Header\"> ");

            htmlText.append(" <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\"> ");
            htmlText.append(" <b>World's Destination</b> for <b>Digital Transformation</b> Skilled Workforce ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");

            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append(" <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"15\">&nbsp;</td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\"> ");
            htmlText.append(" <b>College Enrollment Student Email</b> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append(" <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append(" <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append(" <p style=\"line-height:200%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\"> ");
            htmlText.append("    <font color=\"#232527\"><b>Dear " + registrationAction.getStudentname() + ",</b> ");
            htmlText.append(" </font> ");
            htmlText.append(" </p> ");
            htmlText.append(" </div> ");
            htmlText.append(" </div> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"10\"></td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append(" <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append(" <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\">");
            htmlText.append(" Thank you for showing interest in registering for The AP Cloud Initiative and welcome to the world of Digital Transformation. ");
            htmlText.append(" </font> ");
            htmlText.append(" </p> ");
            htmlText.append("  </div> ");
            htmlText.append(" </div>  ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"10\"></td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append(" <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append(" <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append(" AP Cloud Initiative is being conducted by <a href=\"http://www.miraclesoft.com\" target=\"blank\" style=\"text-decoration:none;\"> <font color=\"#232527\"><b>Miracle Software Systems, Inc.,</b> </font></a> a global thought leader and a US Based Software Services form. AP Cloud will be launched on 5th August, 2016. Our main vision is to create 100,000 Skilled Professionals in Digital Transformation Technologies and thereby positively affect the AP economy.  ");
            htmlText.append(" </font> ");
            htmlText.append(" </p> ");
            htmlText.append(" </div> ");
            htmlText.append(" </div>  ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"10\"></td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append(" <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append(" <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append(" For more details please visit <a href=\"http://www.apcloud.in\" target=\"_blank\" style=\"text-decoration:none\"><font color=\"#00aae7\"><b>www.apcloud.in</b></font></a> ");
            htmlText.append(" </font> ");
            htmlText.append(" </p> ");
            htmlText.append(" </div> ");
            htmlText.append(" </div>  ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"10\"></td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append(" <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append(" <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append("    If you have any queries regarding the program please contact our AP Cloud Team at<a href=\"mailto:apcloud@miraclesoft.com\" target=\"blank\" style=\"text-decoration:none; font-color:#232527;\"> ");
            htmlText.append("        <font color=\"#232527\"><b>apcloud@miraclesoft.com</b></font></a> (or) reach us at <b>0891-6623556</b>. ");
            htmlText.append("    </font> ");
            htmlText.append(" </p> ");
            htmlText.append(" </div> ");
            htmlText.append(" </div>  ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");

            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"15\"></td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append(" <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append(" <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#b7b2b3\"> ");
            htmlText.append(" <b>Thanks &amp; Regards,</b> ");
            htmlText.append(" <br> AP Cloud Team, ");
            htmlText.append(" <br> Miracle Software Systems, Inc. ");
            htmlText.append(" <br> Email : <a href=\"mailto:apcloud@miraclesoft.com\" target=\"blank\" style=\"text-decoration:none\"><font color=\"#b7b2b3\">apcloud@miraclesoft.com</a></font> ");
            htmlText.append(" <br> Phone : 0891-6623556 ");
            htmlText.append(" </font> ");
            htmlText.append(" </p> ");
            htmlText.append(" </div> ");
            htmlText.append(" </div>  ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\"> ");
            htmlText.append(" <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"10\">&nbsp;</td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td> ");
            htmlText.append("    <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\"> ");
            htmlText.append(" <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\"> ");

            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td width=\"200\" align=\"center\" style=\"text-align: center;\"> ");
            htmlText.append(" <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td width=\"10\"> ");
            htmlText.append(" <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\"> ");
            htmlText.append(" <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append(" </a> ");
            htmlText.append(" </td> ");
            htmlText.append(" <td width=\"10\">");
            htmlText.append(" <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\"> ");
            htmlText.append(" <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append(" </a> ");
            htmlText.append(" </td> ");
            htmlText.append(" <td width=\"10\"> ");
            htmlText.append(" <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\"> ");
            htmlText.append(" <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append(" </a> ");
            htmlText.append(" </td> ");
            htmlText.append(" <td width=\"10\"> ");
            htmlText.append(" <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\"> ");
            htmlText.append(" <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append(" </a> ");
            htmlText.append(" </td> ");
            htmlText.append(" <td width=\"10\"> ");
            htmlText.append(" <a href=\"https://twitter.com/andhracloud\" target=\"_blank\"> ");
            htmlText.append(" <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append(" </a> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#232527\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#232527\" data-bgcolor=\"Footer\"> ");
            htmlText.append(" <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"18\">&nbsp;</td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\"> ");
            htmlText.append(" <b>© Copyright 2016 <span style=\"color:#00aae7;\">Miracle Software Systems, Inc.</span></b> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append(" &nbsp; ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
//            htmlText.append(" <div id=\"edit_link\" class=\"hidden\" style=\"display: none;\"> ");
//
//            htmlText.append(" <div class=\"close_link\"></div> ");
//
//            htmlText.append(" <input type=\"text\" id=\"edit_link_value\" class=\"createlink\" placeholder=\"Your URL\"> ");
//
//            htmlText.append(" <div id=\"change_image_wrapper\"> ");
//
//            htmlText.append(" <div id=\"change_image\"> ");
//
//            htmlText.append(" <p id=\"change_image_button\">Change &nbsp; <span class=\"pixel_result\"></span> ");
//            htmlText.append(" </p> ");
//            htmlText.append(" </div> ");
//
//            htmlText.append(" <input type=\"button\" value=\"\" id=\"change_image_link\"> ");
//
//            htmlText.append(" <input type=\"button\" value=\"\" id=\"remove_image\"> ");
//            htmlText.append(" </div> ");
//
//            htmlText.append(" <div id=\"tip\"></div> ");
//            htmlText.append(" </div> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append(" </table> ");
            htmlText.append(" </body> ");

            htmlText.append(" </html> ");



            messageBodyPart.setContent(htmlText.toString(), "text/html");
           // System.out.println("Student College Enroll-->" + htmlText.toString());
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));

            resultMessage = "MailSent";
            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return resultMessage;
    }

    public String sendfacultyEnrollmentdetails(RegistrationAction registrationAction) {

        //   System.out.println("---nominiee---" + registrationAction.getStudentEmail() + " pemail--> " + registrationAction.getPrincipalEmail() + "---aemail----" + registrationAction.getFacultyambassadorEmail());
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        /**
         * The to is used for storing the user mail id to send details.
         */
        String resultMessage = "";
        /**
         * The from is used for storing the from address.
         */
        String from = "apcloud@miraclesoft.com";

        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!

        /**
         * The host is used for storing the IP address of mail
         */
        /**
         * The props is instance variabel to
         * <code>Properties</code> class
         */
        Properties props = new Properties();

        /**
         * Here set smtp protocal to props
         */
        props.setProperty("mail.transport.protocol", "smtp");

        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /**
         * Here set the authentication for the host *
         */
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
        // mailSession.setDebug(true);
        mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Welcome to AP Cloud Initiative");
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(registrationAction.getFacultyambassadorEmail()));

            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();
            htmlText.append("  <html xmlns=\"http://www.w3.org/1999/xhtml\">  ");
            htmlText.append("  <head>  ");
            htmlText.append("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">  ");
            htmlText.append("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\">  ");
            htmlText.append("  <title>  Faculty Enrollment </title>  ");
            htmlText.append("  <style>  ");
            htmlText.append("   @font-face {  ");
            htmlText.append(" font-family: 'source_sans_probold';  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot');  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('  ");
            htmlText.append(" http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('  ");

            htmlText.append("  http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('  ");
            htmlText.append(" http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('  ");
            htmlText.append(" http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg');  ");
            htmlText.append("font-weight: normal;  ");
            htmlText.append("font-style: normal;}  ");


            htmlText.append("@font-face { font-family: 'source_sans_prosemibold';  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot');  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg');  ");
            htmlText.append(" font-weight: normal;  ");
            htmlText.append(" font-style: normal;  ");
            htmlText.append(" }   ");

            htmlText.append(" @font-face {  ");
            htmlText.append(" font-family: 'source_sans_proregular';  ");
            htmlText.append("src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot');  ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg');  ");
            htmlText.append(" font-weight: normal;  ");
            htmlText.append(" font-style: normal;  ");
            htmlText.append("}  ");

            htmlText.append(" body {  ");
            htmlText.append("margin: 0px;  ");
            htmlText.append(" padding: 0px;  ");
            htmlText.append(" }  ");
            htmlText.append(" ::selection {  ");
            htmlText.append(" background: #ff2f2f;  ");

            htmlText.append(" }  ");
            htmlText.append(" ::-moz-selection {  ");
            htmlText.append(" background: #ff2f2f;  ");

            htmlText.append(" }  ");

            htmlText.append(" @media only screen and (max-width: 640px) {  ");

            htmlText.append(" table[class=scale] {  ");
            htmlText.append("width: 100%!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" table[class=scale-center-both] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-left: 20px!important;  ");
            htmlText.append(" padding-right: 20px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" table[class=scale-center-bottom] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-bottom: 12px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" table[class=margin-center] {  ");
            htmlText.append(" margin: auto!important;  ");
            htmlText.append(" }  ");
            htmlText.append("table[class=hide] {  ");
            htmlText.append("display: none!important;  ");
            htmlText.append(" }  ");

            htmlText.append(" td[class=scale-center-both] {  ");
            htmlText.append("width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-left: 20px!important;  ");
            htmlText.append("  padding-right: 20px!important;  ");
            htmlText.append("  }  ");
            htmlText.append(" td[class=scale-center-left] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: right!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=scale-center-bottom] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-bottom: 24px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=scale-center-bottom-both] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" text-align: center!important;  ");
            htmlText.append(" padding-bottom: 12px!important;  ");
            htmlText.append(" padding-left: 20px!important;  ");
            htmlText.append(" padding-right: 20px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=bottom12] {  ");
            htmlText.append(" padding-bottom: 12px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=bottom19] {  ");
            htmlText.append(" padding-bottom: 19px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=bottom21] {  ");
            htmlText.append(" padding-bottom: 21px!important;  ");
            htmlText.append(" }  ");
            htmlText.append(" td[class=height4] {  ");
            htmlText.append(" height: 4px!important;  ");
            htmlText.append(" font-size: 1px!important;  ");
            htmlText.append(" }  ");

            htmlText.append(" img[class=\"scale\"] {  ");
            htmlText.append(" width: 90%!important;  ");
            htmlText.append("}  ");
            htmlText.append(" img[class=\"reset\"] {  ");
            htmlText.append(" width: 100%!important;  ");
            htmlText.append(" }  ");
            htmlText.append("  }  ");
            htmlText.append("  </style>  ");
            htmlText.append("  </head>  ");
            htmlText.append("  <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\">  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">  &nbsp;  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\">  ");
            htmlText.append("  <img mc:edit=\"Logo\" src=\"http://www.miraclesoft.com/images/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\">  ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">  About </a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"http://www.apcloud.in/ac/general/contactUS.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\"> Contact Us </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">  &nbsp;  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(http://www.miraclesoft.com/images/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"http://www.miraclesoft.com/images/apcloud-banner.jpg\" data-bgcolor=\"Header\" data-bg=\"Header\">  ");

            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\">  ");
            htmlText.append("  <b>  World's Destination  </b>   for   <b> Digital Transformation  </b> Skilled Workforce  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");

            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\">  ");

            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\">  ");
            htmlText.append("  <font color=\"#232527\">    <b> Dear " + registrationAction.getFacultyambassadorName() + "  </b>  ");
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#232527\">  ");
            htmlText.append("  Thank you for enrolling your college to our  <b> AP Cloud Initiative  </b> . You can use the below username and password to login into our portal. ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");

            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#232527\">  ");
            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\">  Login :  </b> " + registrationAction.getFacultyambassadorEmail());
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#232527\">  ");
            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\">  Password:  </b> " + registrationAction.getPassword());
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 13px;\">  ");
            htmlText.append("  <font color=\"#ef4048\">  ");
            htmlText.append(" Please login and change your password within 48 hours of this email ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\">  ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\">  ");
            htmlText.append("  <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\">  ");
            htmlText.append("  <font color=\"#b7b2b3\">  ");
            htmlText.append("  <b>  Thanks &amp; Regards, </b>  ");
            htmlText.append("  <br>   AP Cloud Team,  ");
            htmlText.append("  <br>   Miracle Software Systems, Inc. ");
            htmlText.append("  <br>   Email :   <a href=\"mailto:apcloud@miraclesoft.com\" target=\"blank\" style=\"text-decoration:none\">   <font color=\"#b7b2b3\">  apcloud@miraclesoft.com </a>  </font>  ");
            htmlText.append("  <br>  Phone : 0891-6623556 ");
            htmlText.append("  </font>  ");
            htmlText.append("  </p>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\">  ");
            htmlText.append("  <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"10\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td>  ");
            htmlText.append("  <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\">  ");

            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td width=\"200\" align=\"center\" style=\"text-align: center;\">  ");
            htmlText.append("  <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  <td width=\"10\">  ");
            htmlText.append("  <a href=\"https://twitter.com/andhracloud\" target=\"_blank\">  ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\">  ");
            htmlText.append("  </a>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Footer\">  ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"18\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\">  ");
            htmlText.append("  <b>  © Copyright 2016   <span style=\"color:#00aae7;\">  Miracle Software Systems, Inc.</span>    </b>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">  &nbsp; </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\">  ");
            htmlText.append("  <tbody>  ");
            htmlText.append("  <tr>  ");
            htmlText.append("  <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");

            htmlText.append("    &nbsp;  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
//            htmlText.append("  <div id=\"edit_link\" class=\"hidden\" style=\"display: none;\">  ");
//
//            htmlText.append("  <div class=\"close_link\">  ");
//            htmlText.append("  </div>  ");
//
//            htmlText.append("  <input type=\"text\" id=\"edit_link_value\" class=\"createlink\" placeholder=\"Your URL\">  ");
//
//            htmlText.append("  <div id=\"change_image_wrapper\">  ");
//
//            htmlText.append("  <div id=\"change_image\">  ");
//
//            htmlText.append("  <p id=\"change_image_button\"> Change &nbsp;  <span class=\"pixel_result\">    </span>  ");
//            htmlText.append("  </p>  ");
//            htmlText.append("  </div>  ");
//
//            htmlText.append("  <input type=\"button\" value=\"\" id=\"change_image_link\">  ");
//
//            htmlText.append("  <input type=\"button\" value=\"\" id=\"remove_image\">  ");
//            htmlText.append("  </div>  ");
//
//            htmlText.append("  <div id=\"tip\">  ");
//            htmlText.append("  </div>  ");
//            htmlText.append("  </div>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </td>  ");
            htmlText.append("  </tr>  ");
            htmlText.append("  </tbody>  ");
            htmlText.append("  </table>  ");
            htmlText.append("  </body>  ");
            htmlText.append("  </html>  ");

          //  System.out.println("faculty --------->" + htmlText.toString());
            messageBodyPart.setContent(htmlText.toString(), "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            //System.out.println("Mail Sent ----->");
            resultMessage = "MailSent";
            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return resultMessage;
    }

    public String sendRegistrationMail(RegistrationAction registrationAction) throws ServiceLocatorException {
       // System.out.println("----sendRegistrationMail new Method-----");
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        /**
         * The to is used for storing the user mail id to send details.
         */
//        registrationAction.getPrincipalEmail(),registrationAction.getFacultyambassadorEmail(),registrationAction.getStudentEmail(), registrationAction.getCollegeName(),registrationAction.getLocation()
        String resultMessage = "";
//        String to = emailId;
        String branch = "";

        /**
         * The from is used for storing the from address.
         */
        String from = "apcloud@miraclesoft.com";

        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!

        /**
         * The host is used for storing the IP address of mail
         */
        /**
         * The props is instance variabel to
         * <code>Properties</code> class
         */
        Properties props = new Properties();

        /**
         * Here set smtp protocal to props
         */
        props.setProperty("mail.transport.protocol", "smtp");

        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /**
         * Here set the authentication for the host *
         */
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
        // mailSession.setDebug(true);
        mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Apcloud Registration Details");
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(registrationAction.getEmail()));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();



            htmlText.append("  <html xmlns=\"http://www.w3.org/1999/xhtml\"> ");
            htmlText.append("  <head> ");
            htmlText.append("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
            htmlText.append("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\"> ");
            htmlText.append("  <title> AP Cloud Initiative </title> ");
            htmlText.append("  <style> ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_probold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_prosemibold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_proregular'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'),  url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'),url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");

            htmlText.append(" body { ");
            htmlText.append(" margin: 0px; ");
            htmlText.append(" padding: 0px; ");
            htmlText.append(" } ");
            htmlText.append(" ::selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");
            htmlText.append(" ::-moz-selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");

            htmlText.append(" @media only screen and (max-width: 640px) { ");

            htmlText.append(" table[class=scale] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=margin-center] { ");
            htmlText.append(" margin: auto!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=hide] { ");
            htmlText.append(" display: none!important; ");
            htmlText.append(" } ");

            htmlText.append(" td[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-left] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: right!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 24px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom12] { ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom19] { ");
            htmlText.append(" padding-bottom: 19px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom21] { ");
            htmlText.append(" padding-bottom: 21px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=height4] { ");
            htmlText.append(" height: 4px!important; ");
            htmlText.append(" font-size: 1px!important; ");
            htmlText.append(" } ");

            htmlText.append(" img[class=\"scale\"] { ");
            htmlText.append(" width: 90%!important; ");
            htmlText.append(" } ");
            htmlText.append(" img[class=\"reset\"] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" } ");
            htmlText.append("  </style> ");
            htmlText.append("  </head> ");
            htmlText.append("  <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\"> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\"> ");
            htmlText.append("  <img mc:edit=\"Logo\" src=\"http://www.miraclesoft.com/images/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\"> ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">About   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"http://www.apcloud.in/ac/general/contactUS.action\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">Contact Us   </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(http://www.miraclesoft.com/images/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"http://www.miraclesoft.com/images/apcloud-banner.jpg\" data-bgcolor=\"Header\" data-bg=\"Header\"> ");

            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\"> ");
            htmlText.append("  <b>World's Destination   </b>  for   <b>Digital Transformation   </b> Skilled Workforce ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");

            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\"> ");
            htmlText.append("  <b> Registration Successful </b> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\"> ");
            htmlText.append("  <font color=\"#232527\"><b>Hello " + registrationAction.getFirstname() + "." + registrationAction.getLastname() + ",</b> ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append("  You are successfully registered to AP CLOUD Initiative in our portal. ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");

            if (registrationAction.getProfession().equals("1")) {
                String response = DataSourceDataProvider.getInstance().getIndividualcollegeNameAndLocation(registrationAction.getFrmCollege());

                if (response != null && !"".equals(response)) {
                    String arr[] = response.split("@@@");
                    htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>CollegeName:</b> " + arr[0] + "");
                    htmlText.append("  </font> ");
                    htmlText.append("  </p> ");
                    htmlText.append("  </div> ");
                    htmlText.append("  </div> ");
                    htmlText.append("  </td> ");
                    htmlText.append("  </tr> ");
                    htmlText.append("  <tr> ");
                    htmlText.append("  <td> ");
                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
                    if (registrationAction.getBranch().equals("Others")) {
                        branch = registrationAction.getFrmOtherBranch();
                    } else {
                        branch = registrationAction.getBranch();
                    }
                    htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Branch:</b> " + branch + " <br>");
                    htmlText.append("  </font> ");
                    htmlText.append("  </p> ");
                    htmlText.append("  </div> ");
                    htmlText.append("  </div> ");
                    htmlText.append("  </td> ");
                    htmlText.append("  </tr> ");
                    htmlText.append("  <tr> ");
                    htmlText.append("  <td> ");
                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\">");
                    htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Location:</b> " + arr[1] + " <br>");
                    htmlText.append("  </font> ");
                    htmlText.append("  </p> ");
                    htmlText.append("  </div> ");
                    htmlText.append("  </div> ");
                    htmlText.append("  </td> ");
                    htmlText.append("  </tr> ");
                    htmlText.append("  <tr> ");
                    htmlText.append("  <td> ");
                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
                }
            } else {

                htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>CompanyName:</b> " + registrationAction.getFrmCompany() + " <br>");
                htmlText.append("  </font> ");
                htmlText.append("  </p> ");
                htmlText.append("  </div> ");
                htmlText.append("  </div> ");
                htmlText.append("  </td> ");
                htmlText.append("  </tr> ");
                htmlText.append("  <tr> ");
                htmlText.append("  <td> ");
                htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
                htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
                htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            }




            htmlText.append(" Please  <a href='http://www.apcloud.in/ac/general/login.action' target=\"_blank\" style=\"font-size: 14px; color: #00aae7;\"><b> click here  </b></a>  to enroll to our active workshop. ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#b7b2b3\"> ");
            htmlText.append("  <b> Thanks & Regards,</b> ");
            htmlText.append("  <br>  AP Cloud Team,");
            htmlText.append("  <br> Miracle Software Systems, Inc. ");
            htmlText.append("  <br> Email : apcloud@miraclesoft.com ");
            htmlText.append("  <br>  Phone : 0891-6623556 ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\"> ");
            htmlText.append("  <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"10\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\"> ");

            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td width=\"200\" align=\"center\" style=\"text-align: center;\"> ");
            htmlText.append("  <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://twitter.com/andhracloud\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Footer\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"18\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\"> ");
            htmlText.append("  <b> © Copyright 2016  <span style=\"color:#00aae7;\">Miracle Software Systems, Inc.</span></b> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  &nbsp;");

            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
//            htmlText.append("  <div id=\"edit_link\" class=\"hidden\" style=\"display: none;\"> ");
//
//            htmlText.append("  <div class=\"close_link\"></div> ");
//
//            htmlText.append("  <input type=\"text\" id=\"edit_link_value\" class=\"createlink\" placeholder=\"Your URL\"> ");
//
//            htmlText.append("  <div id=\"change_image_wrapper\"> ");
//
//            htmlText.append("  <div id=\"change_image\"> ");
//
//            htmlText.append("  <p id=\"change_image_button\">Change &nbsp;   <span class=\"pixel_result\"></span> ");
//            htmlText.append("  </p> ");
//            htmlText.append("  </div> ");
//
//            htmlText.append("  <input type=\"button\" value=\"\" id=\"change_image_link\"> ");
//
//            htmlText.append("  <input type=\"button\" value=\"\" id=\"remove_image\"> ");
//            htmlText.append("  </div> ");
//
//            htmlText.append("  <div id=\"tip\"></div> ");
//            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </body> ");
            htmlText.append("  </html> ");

            messageBodyPart.setContent(htmlText.toString(), "text/html");

            // System.out.println("User Registrtaion-->"+htmlText.toString());
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            //System.out.println("Mail Sent ----->");
            resultMessage = "MailSent";
            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return resultMessage;
    }

//
//    public String sendRegistrationMail(RegistrationAction registrationAction) throws ServiceLocatorException {
//        System.out.println("--sendRegistrationMail-- nows--"+registrationAction.getEmail());
//        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
//        /**
//         * The to is used for storing the user mail id to send details.
//         */
////        registrationAction.getPrincipalEmail(),registrationAction.getFacultyambassadorEmail(),registrationAction.getStudentEmail(), registrationAction.getCollegeName(),registrationAction.getLocation()
//        String resultMessage = "";
////        String to = emailId;
//        String branch = "";
//
//        /**
//         * The from is used for storing the from address.
//         */
//        String from = "apcloud@miraclesoft.com";
//
//        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
//
//        /**
//         * The host is used for storing the IP address of mail
//         */
//        /**
//         * The props is instance variabel to
//         * <code>Properties</code> class
//         */
//        Properties props = new Properties();
//
//        /**
//         * Here set smtp protocal to props
//         */
//        props.setProperty("mail.transport.protocol", "smtp");
//
//        //**Here set the address of the host to props */
//        props.setProperty("mail.host", SMTP_HOST);
//        props.put("mail.smtp.starttls.enable", "true");
//        /**
//         * Here set the authentication for the host *
//         */
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", SMTP_PORT);
//
//        Authenticator auth = new SMTPAuthenticator();
//        // Session mailSession = Session.getDefaultInstance(props, null);
//        Session mailSession = Session.getDefaultInstance(props, auth);
//        // mailSession.setDebug(true);
//        mailSession.setDebug(false);
//        Transport transport;
//        try {
//            transport = mailSession.getTransport();
//            MimeMessage message = new MimeMessage(mailSession);
//            message.setSubject("Apcloud Registration Details");
//            message.setFrom(new InternetAddress(from));
//
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(registrationAction.getEmail()));
//            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));
//
//
//            // This HTML mail have to 2 part, the BODY and the embedded image
//            //
//            MimeMultipart multipart = new MimeMultipart("related");
//
//            // first part  (the html)
//            BodyPart messageBodyPart = new MimeBodyPart();
//            StringBuilder htmlText = new StringBuilder();
//
//
//
//            htmlText.append("  <html xmlns=\"http://www.w3.org/1999/xhtml\"> ");
//            htmlText.append("  <head> ");
//            htmlText.append("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
//            htmlText.append("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\"> ");
//            htmlText.append("  <title> AP Cloud Initiative </title> ");
//            htmlText.append("  <style> ");
//            htmlText.append(" @font-face { ");
//            htmlText.append(" font-family: 'source_sans_probold'; ");
//            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot'); ");
//            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg'); ");
//            htmlText.append(" font-weight: normal; ");
//            htmlText.append(" font-style: normal; ");
//            htmlText.append(" } ");
//            htmlText.append(" @font-face { ");
//            htmlText.append(" font-family: 'source_sans_prosemibold'; ");
//            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot'); ");
//            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg'); ");
//            htmlText.append(" font-weight: normal; ");
//            htmlText.append(" font-style: normal; ");
//            htmlText.append(" } ");
//            htmlText.append(" @font-face { ");
//            htmlText.append(" font-family: 'source_sans_proregular'; ");
//            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot'); ");
//            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'),  url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'),url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg'); ");
//            htmlText.append(" font-weight: normal; ");
//            htmlText.append(" font-style: normal; ");
//            htmlText.append(" } ");
//
//            htmlText.append(" body { ");
//            htmlText.append(" margin: 0px; ");
//            htmlText.append(" padding: 0px; ");
//            htmlText.append(" } ");
//            htmlText.append(" ::selection { ");
//            htmlText.append(" background: #ff2f2f; ");
//
//            htmlText.append(" } ");
//            htmlText.append(" ::-moz-selection { ");
//            htmlText.append(" background: #ff2f2f; ");
//
//            htmlText.append(" } ");
//
//            htmlText.append(" @media only screen and (max-width: 640px) { ");
//
//            htmlText.append(" table[class=scale] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" table[class=scale-center-both] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" text-align: center!important; ");
//            htmlText.append(" padding-left: 20px!important; ");
//            htmlText.append(" padding-right: 20px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" table[class=scale-center-bottom] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" text-align: center!important; ");
//            htmlText.append(" padding-bottom: 12px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" table[class=margin-center] { ");
//            htmlText.append(" margin: auto!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" table[class=hide] { ");
//            htmlText.append(" display: none!important; ");
//            htmlText.append(" } ");
//
//            htmlText.append(" td[class=scale-center-both] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" text-align: center!important; ");
//            htmlText.append(" padding-left: 20px!important; ");
//            htmlText.append(" padding-right: 20px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=scale-center-left] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" text-align: right!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=scale-center-bottom] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" text-align: center!important; ");
//            htmlText.append(" padding-bottom: 24px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=scale-center-bottom-both] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" text-align: center!important; ");
//            htmlText.append(" padding-bottom: 12px!important; ");
//            htmlText.append(" padding-left: 20px!important; ");
//            htmlText.append(" padding-right: 20px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=bottom12] { ");
//            htmlText.append(" padding-bottom: 12px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=bottom19] { ");
//            htmlText.append(" padding-bottom: 19px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=bottom21] { ");
//            htmlText.append(" padding-bottom: 21px!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" td[class=height4] { ");
//            htmlText.append(" height: 4px!important; ");
//            htmlText.append(" font-size: 1px!important; ");
//            htmlText.append(" } ");
//
//            htmlText.append(" img[class=\"scale\"] { ");
//            htmlText.append(" width: 90%!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" img[class=\"reset\"] { ");
//            htmlText.append(" width: 100%!important; ");
//            htmlText.append(" } ");
//            htmlText.append(" } ");
//            htmlText.append("  </style> ");
//            htmlText.append("  </head> ");
//            htmlText.append("  <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\"> ");
//            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
//            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
//            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td> ");
//            htmlText.append("  <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td> ");
//            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\"> ");
//            htmlText.append("  <img mc:edit=\"Logo\" src=\"https://newsletters-2016-vnallamalla.c9users.io/AP_Cloud/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\"> ");
//            htmlText.append("  </a> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\"> ");
//            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">About   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"http://www.apcloud.in/ac/general/contactUS.action\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">Contact Us   </a> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
//            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(https://newsletters-2016-vnallamalla.c9users.io/AP_Cloud/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"images/img01.png\" data-bgcolor=\"Header\" data-bg=\"Header\"> ");
//
//            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\"> ");
//            htmlText.append("  <b>World's Destination   </b>  for   <b>Digital Transformation   </b> Skilled Workforce ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
//            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
//            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td height=\"15\">&nbsp;</td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\"> ");
//            htmlText.append("  <b> Registration Successful </b> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  </tbody> ");
//            htmlText.append("  </table> ");
//            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
//            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
//            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
//            htmlText.append("  <tbody> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td> ");
//            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\"> ");
//            htmlText.append("  <font color=\"#232527\"><b>Hello " + registrationAction.getFirstname() + "." + registrationAction.getLastname() + ",</b> ");
//            htmlText.append("  </font> ");
//            htmlText.append("  </p> ");
//            htmlText.append("  </div> ");
//            htmlText.append("  </div> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td> ");
//            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
//            htmlText.append("  You are successfully registered to AP CLOUD Initiative in our portal. ");
//            htmlText.append("  </font> ");
//            htmlText.append("  </p> ");
//            htmlText.append("  </div> ");
//            htmlText.append("  </div> ");
//            htmlText.append("  </td> ");
//            htmlText.append("  </tr> ");
//            htmlText.append("  <tr> ");
//            htmlText.append("  <td> ");
//            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
//
//            if (registrationAction.getProfession().equals("1")) {
//                String response = DataSourceDataProvider.getInstance().getIndividualcollegeNameAndLocation(registrationAction.getFrmCollege());
//
//                if (response != null && !"".equals(response)) {
//                    String arr[] = response.split("@@@");
//                    htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>CollegeName:</b> " + arr[0] + "");
//                    htmlText.append("  </font> ");
//                    htmlText.append("  </p> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </td> ");
//                    htmlText.append("  </tr> ");
//                    htmlText.append("  <tr> ");
//                    htmlText.append("  <td> ");
//                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
//                    if (registrationAction.getBranch().equals("Others")) {
//                        branch = registrationAction.getFrmOtherBranch();
//                    } else {
//                        branch = registrationAction.getBranch();
//                    }
//                    htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Branch:</b> " + branch + " <br>");
//                    htmlText.append("  </font> ");
//                    htmlText.append("  </p> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </td> ");
//                    htmlText.append("  </tr> ");
//                    htmlText.append("  <tr> ");
//                    htmlText.append("  <td> ");
//                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\">");
//                    htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Location:</b> " + arr[1] + " <br>");
//                    htmlText.append("  </font> ");
//                    htmlText.append("  </p> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </td> ");
//                    htmlText.append("  </tr> ");
//                    htmlText.append("  <tr> ");
//                    htmlText.append("  <td> ");
//                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
//                }
//            } else {
//               
//                htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>CompanyName:</b> " + registrationAction.getFrmCompany() + " <br>");
//                htmlText.append("  </font> ");
//                    htmlText.append("  </p> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </div> ");
//                    htmlText.append("  </td> ");
//                    htmlText.append("  </tr> ");
//                    htmlText.append("  <tr> ");
//                    htmlText.append("  <td> ");
//                    htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//                    htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//                    htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
//            }
//
//
//
//
//                htmlText.append(" Please  <a href='http://www.apcloud.in/ac/general/login.action' target=\"_blank\" style=\"font-size: 14px; color: #00aae7;\"><b> click here  </b></a>  to enroll to our active workshop. ");
//                htmlText.append("  </font> ");
//                htmlText.append("  </p> ");
//                htmlText.append("  </div> ");
//                htmlText.append("  </div> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td height=\"15\">&nbsp;</td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td> ");
//                htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
//                htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
//                htmlText.append("  <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#b7b2b3\"> ");
//                htmlText.append("  <b> Thanks &amp; Regards,</b> ");
//                htmlText.append("  <br>  AP Cloud Team,");
//                htmlText.append("  <br> Miracle Software Systems, Inc. ");
//                htmlText.append("  <br> Email : apcloud@miraclesoft.com ");
//                htmlText.append("  <br>  Phone : 0891-6623556 ");
//                htmlText.append("  </font> ");
//                htmlText.append("  </p> ");
//                htmlText.append("  </div> ");
//                htmlText.append("  </div> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
//                htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\"> ");
//                htmlText.append("  <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td height=\"10\">&nbsp;</td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td> ");
//                htmlText.append("  <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
//                htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\"> ");
//                htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\"> ");
//
//                htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td width=\"200\" align=\"center\" style=\"text-align: center;\"> ");
//                htmlText.append("  <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td width=\"10\"> ");
//                htmlText.append("  <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\"> ");
//                htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
//                htmlText.append("  </a> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  <td width=\"10\"> ");
//                htmlText.append("  <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\"> ");
//                htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
//                htmlText.append("  </a> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  <td width=\"10\"> ");
//                htmlText.append("  <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\"> ");
//                htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
//                htmlText.append("  </a> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  <td width=\"10\"> ");
//                htmlText.append("  <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\"> ");
//                htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
//                htmlText.append("  </a> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  <td width=\"10\"> ");
//                htmlText.append("  <a href=\"https://twitter.com/andhracloud\" target=\"_blank\"> ");
//                htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
//                htmlText.append("  </a> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Body\"> ");
//                htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Footer\"> ");
//                htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td height=\"18\">&nbsp;</td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\"> ");
//                htmlText.append("  <b> © Copyright 2016  <span style=\"color:#00aae7;\">Miracle Software Systems, Inc.</span></b> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
//                htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
//                htmlText.append("  <tbody> ");
//                htmlText.append("  <tr> ");
//                htmlText.append("  <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  &nbsp;");
//
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  <div id=\"edit_link\" class=\"hidden\" style=\"display: none;\"> ");
//
//                htmlText.append("  <div class=\"close_link\"></div> ");
//
//                htmlText.append("  <input type=\"text\" id=\"edit_link_value\" class=\"createlink\" placeholder=\"Your URL\"> ");
//
//                htmlText.append("  <div id=\"change_image_wrapper\"> ");
//
//                htmlText.append("  <div id=\"change_image\"> ");
//
//                htmlText.append("  <p id=\"change_image_button\">Change &nbsp;   <span class=\"pixel_result\"></span> ");
//                htmlText.append("  </p> ");
//                htmlText.append("  </div> ");
//
//                htmlText.append("  <input type=\"button\" value=\"\" id=\"change_image_link\"> ");
//
//                htmlText.append("  <input type=\"button\" value=\"\" id=\"remove_image\"> ");
//                htmlText.append("  </div> ");
//
//                htmlText.append("  <div id=\"tip\"></div> ");
//                htmlText.append("  </div> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </td> ");
//                htmlText.append("  </tr> ");
//                htmlText.append("  </tbody> ");
//                htmlText.append("  </table> ");
//                htmlText.append("  </body> ");
//                htmlText.append("  </html> ");
//
//                messageBodyPart.setContent(htmlText.toString(), "text/html");
//
//                // System.out.println("User Registrtaion-->"+htmlText.toString());
//                // add it
//                multipart.addBodyPart(messageBodyPart);
//
//                // put everything together
//                message.setContent(multipart);
//
//                transport.connect();
//                transport.sendMessage(message,
//                        message.getRecipients(Message.RecipientType.TO));
//                //System.out.println("Mail Sent ----->");
//                resultMessage = "MailSent";
//                transport.close();
//            } catch (NoSuchProviderException ex) {
//            ex.printStackTrace();
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//        }
//        return resultMessage;
//    }
    public String sendContactMail(String firstName, String lastName, String eMail, String phone, String discription) throws ServiceLocatorException {

        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        /**
         * The to is used for storing the user mail id to send details.
         */
//        registrationAction.getPrincipalEmail(),registrationAction.getFacultyambassadorEmail(),registrationAction.getStudentEmail(), registrationAction.getCollegeName(),registrationAction.getLocation()
        String resultMessage = "";
//        String to = emailId;
        String branch = "";

        /**
         * The from is used for storing the from address.
         */
       // String from = "apcloud@miraclesoft.com";
         String from = eMail;

        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!

        /**
         * The host is used for storing the IP address of mail
         */
        /**
         * The props is instance variabel to
         * <code>Properties</code> class
         */
        Properties props = new Properties();

        /**
         * Here set smtp protocal to props
         */
        props.setProperty("mail.transport.protocol", "smtp");

        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /**
         * Here set the authentication for the host *
         */
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
        // mailSession.setDebug(true);
        mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("You Have Been Contacted");
            message.setFrom(new InternetAddress(from));

          message.addRecipient(Message.RecipientType.TO, new InternetAddress("apcloud@miraclesoft.com"));
        //    message.addRecipient(Message.RecipientType.TO, new InternetAddress("skola2@miraclesoft.com"));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();



            htmlText.append(" <html xmlns=\"http://www.w3.org/1999/xhtml\"> ");
            htmlText.append("    <head> ");
            htmlText.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
            htmlText.append("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\"> ");
            htmlText.append("  <title> Contact Us </title> ");
            htmlText.append("  <style> ");

            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_probold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_prosemibold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_proregular'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'),  url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'),url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");

            htmlText.append(" body { ");
            htmlText.append(" margin: 0px; ");
            htmlText.append(" padding: 0px; ");
            htmlText.append(" } ");
            htmlText.append(" ::selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");
            htmlText.append(" ::-moz-selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");

            htmlText.append(" @media only screen and (max-width: 640px) { ");

            htmlText.append(" table[class=scale] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");

            htmlText.append(" table[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=margin-center] { ");
            htmlText.append(" margin: auto!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=hide] { ");
            htmlText.append(" display: none!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-left] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: right!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 24px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom12] { ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom19] { ");
            htmlText.append(" padding-bottom: 19px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom21] { ");
            htmlText.append(" padding-bottom: 21px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=height4] { ");
            htmlText.append(" height: 4px!important; ");
            htmlText.append(" font-size: 1px!important; ");
            htmlText.append(" } ");

            htmlText.append(" img[class=\"scale\"] { ");
            htmlText.append(" width: 90%!important; ");
            htmlText.append(" } ");
            htmlText.append(" img[class=\"reset\"] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" } ");
            htmlText.append("   </style> ");
            htmlText.append("  </head> ");
            htmlText.append("   <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\"> ");
            htmlText.append("   <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("    <tr> ");
            htmlText.append("   <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("    <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("    <tbody> ");
            htmlText.append("    <tr> ");
            htmlText.append("   <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\"> &nbsp;  </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td> ");
            htmlText.append("  <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\"> ");
            htmlText.append("   <img mc:edit=\"Logo\" src=\"http://www.miraclesoft.com/images/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\"> ");
            htmlText.append("   </a> ");
            htmlText.append("   </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("   <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("   <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\"> ");
            htmlText.append("   <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\"> About  </a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"http://www.apcloud.in/ac/general/contactUS.action\" target=\"blank\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\"> Contact Us </a> ");
            htmlText.append("  </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("    </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append(" <tr> ");
            htmlText.append(" <td height=\"15\" style=\"font-size: 1px;\"> &nbsp; </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("   </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("   </td> ");
            htmlText.append(" </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("    <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(http://www.miraclesoft.com/images/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"http://www.miraclesoft.com/images/apcloud-banner.jpg\" data-bgcolor=\"Header\" data-bg=\"Header\"> ");

            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\"> ");
            htmlText.append("   <b> World's Destination  </b>for   <b> Digital Transformation </b> Skilled Workforce ");
            htmlText.append("  </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("  </table> ");

            htmlText.append("   </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append(" </td> ");
            htmlText.append(" </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("    <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("   <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("   <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("   <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("   <td height=\"15\"> &nbsp; </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("   <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\"> ");
            htmlText.append("   <b> You Have Been Contacted!! </b> ");
            htmlText.append("   </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("    </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append(" <tr> ");
            htmlText.append("   <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("   <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("   <p style=\"line-height:200%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\"> ");
            htmlText.append("  <font color=\"#232527\"> <b>Hello APCloud Team, </b> ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append(" </div> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("   <div class=\"contentEditable\"  style = \"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"> <font color=\"#232527\"> ");
            htmlText.append(" You have been contacted from <b> " + firstName + " " + lastName + " </b>  through our portal. Can you please have a look at the below details and respond back.");
            htmlText.append("  </font> ");
            htmlText.append("   </p> ");
            htmlText.append("   </div> ");
            htmlText.append("   </div> ");
            htmlText.append("  </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("   <div class=\"contentEditable\"  style = \"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"> <font color=\"#232527\"> ");
            htmlText.append("   <b style=\"font-size: 14px; color: #ef4048;\"> Name : </b>  " + firstName + "." + lastName + "");
            htmlText.append("   </font> ");
            htmlText.append("   </p> ");
            htmlText.append("  </div> ");
            htmlText.append("   </div> ");
            htmlText.append(" </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("   <div class=\"contentEditable\"  style = \"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"> <font color=\"#232527\"> ");
            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\">Email :  </b>" + eMail + "");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("   </div> ");
            htmlText.append("    </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("   <div class=\"contentEditable\"  style = \"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"> <font color=\"#232527\"> ");
            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\">Contact : </b> " + phone + "");
            htmlText.append("  </font> ");
            htmlText.append("   </p> ");
            htmlText.append("   </div> ");
            htmlText.append("  </div> ");
            htmlText.append("   </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("    <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("   <div class=\"contentEditable\"  style = \"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:200%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"> <font color=\"#232527\"> ");
            htmlText.append("  <b style=\"font-size: 14px; color: #ef4048;\"> Description :</b> " + discription + "");
            htmlText.append("  </font> ");
            htmlText.append("   </p> ");
            htmlText.append("   </div> ");
            htmlText.append("  </div> ");
            htmlText.append("    </td> ");
            htmlText.append("   </tr> ");

            htmlText.append("   <tr> ");
            htmlText.append("  <td height=\"15\"> &nbsp; </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td> ");
            htmlText.append(" <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("   <div class=\"contentEditable\"  style = \"text-align: center;\"> ");
            htmlText.append("   <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"> <font color=\"#b7b2b3\"> ");
            htmlText.append("  <b> Thanks &amp; Regards,  </b> ");
            htmlText.append("  <br>  AP Cloud Team,");
            htmlText.append("    <br>  Miracle Software Systems, Inc.");
            htmlText.append("   <br> Email :<a href=\"mailto:apcloud@miraclesoft.com\" target=\"blank\" style=\"text-decoration:none\">    <font color=\"#b7b2b3\">apcloud@miraclesoft.com</a></font> ");
            htmlText.append("   <br> Phone : 0891-6623556 ");
            htmlText.append("  </font> ");
            htmlText.append("    </p> ");
            htmlText.append("    </div> ");
            htmlText.append("   </div> ");
            htmlText.append("   </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("    </tbody> ");
            htmlText.append("    </table> ");
            htmlText.append("    </td> ");
            htmlText.append("  </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append("    </table> ");
            htmlText.append("   </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("    </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("   <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\"> ");
            htmlText.append("    <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td height=\"10\">&nbsp;  </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("   <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("   <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("   </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("   <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append(" <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\"> ");
            htmlText.append("   <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\"> ");

            htmlText.append(" <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td width=\"200\" align=\"center\" style=\"text-align: center;\"> ");
            htmlText.append("  <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("   <td width=\"10\"> ");
            htmlText.append("   <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\"> ");
            htmlText.append("   <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("   </a> ");
            htmlText.append("   </td> ");
            htmlText.append("   <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("   <td width=\"10\"> ");
            htmlText.append("   <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\"> ");
            htmlText.append("   <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("    </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("   <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("   </td> ");
            htmlText.append("   <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://twitter.com/andhracloud\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("   </a> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("    </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("    </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td bgcolor=\"#232527\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append(" <td bgcolor=\"#232527\" data-bgcolor=\"Footer\"> ");
            htmlText.append("   <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append(" <td height=\"18\">&nbsp; </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\"> ");
            htmlText.append("   <b> © Copyright 2016 <span style=\"color:#00aae7;\"> ");
            htmlText.append("    Miracle Software Systems, Inc. </span> </b> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp; </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("    </td> ");
            htmlText.append("   </tr> ");
            htmlText.append(" </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("   </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("   <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("   <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("   <tbody> ");
            htmlText.append("   <tr> ");
            htmlText.append("   <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> &nbsp;");

            htmlText.append("  </td> ");
            htmlText.append(" </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("   </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("   </table> ");
//            htmlText.append("   <div id=\"edit_link\" class=\"hidden\" style=\"display: none;\"> ");
//
//            htmlText.append("  <div class=\"close_link\">  </div> ");
//
//            htmlText.append("   <input type=\"text\" id=\"edit_link_value\" class=\"createlink\" placeholder=\"Your URL\"> ");
//
//            htmlText.append("  <div id=\"change_image_wrapper\"> ");
//
//            htmlText.append("  <div id=\"change_image\"> ");
//
//            htmlText.append("   <p id=\"change_image_button\"> Change &nbsp;   <span class=\"pixel_result\">    </  </span> ");
//            htmlText.append("  </p> ");
//            htmlText.append("   </div> ");
//
//            htmlText.append("   <input type=\"button\" value=\"\" id=\"change_image_link\"> ");
//
//            htmlText.append("    <input type=\"button\" value=\"\" id=\"remove_image\"> ");
//            htmlText.append("  </div> ");
//
//            htmlText.append("   <div id=\"tip\"> </div> ");
//            htmlText.append("    </div> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("   </table> ");
            htmlText.append("   </td> ");
            htmlText.append("   </tr> ");
            htmlText.append("   </tbody> ");
            htmlText.append("    </table> ");
            htmlText.append("    </td> ");
            htmlText.append("    </tr> ");
            htmlText.append("    </tbody> ");
            htmlText.append("    </table> ");
            htmlText.append("    </body> ");
            htmlText.append("    </html> ");


            messageBodyPart.setContent(htmlText.toString(), "text/html");

            // System.out.println("Contact us-->"+htmlText.toString());
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            //System.out.println("Mail Sent ----->");
            resultMessage = "MailSent";
            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return resultMessage;
    }

    
     public String sendRegistrationCoachMail(RegistrationAction registrationAction) throws ServiceLocatorException {
      //  System.out.println("----sendRegistrationMail new Method-----");
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        /**
         * The to is used for storing the user mail id to send details.
         */
//        registrationAction.getPrincipalEmail(),registrationAction.getFacultyambassadorEmail(),registrationAction.getStudentEmail(), registrationAction.getCollegeName(),registrationAction.getLocation()
        String resultMessage = "";
//        String to = emailId;
        String branch = "";

        /**
         * The from is used for storing the from address.
         */
        String from = "apcloud@miraclesoft.com";

        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!

        /**
         * The host is used for storing the IP address of mail
         */
        /**
         * The props is instance variabel to
         * <code>Properties</code> class
         */
        Properties props = new Properties();

        /**
         * Here set smtp protocal to props
         */
        props.setProperty("mail.transport.protocol", "smtp");

        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /**
         * Here set the authentication for the host *
         */
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
        // mailSession.setDebug(true);
        mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Apcloud Registration Details");
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(registrationAction.getEmail()));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();



            htmlText.append("  <html xmlns=\"http://www.w3.org/1999/xhtml\"> ");
            htmlText.append("  <head> ");
            htmlText.append("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
            htmlText.append("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0;\" name=\"viewport\"> ");
            htmlText.append("  <title> AP Cloud Initiative </title> ");
            htmlText.append("  <style> ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_probold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-bold-webfont.svg#source_sans_probold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_prosemibold'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.eot?#iefix') format('embedded-opentype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff2') format('woff2'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-semibold-webfont.svg#source_sans_prosemibold') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");
            htmlText.append(" @font-face { ");
            htmlText.append(" font-family: 'source_sans_proregular'; ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot'); ");
            htmlText.append(" src: url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.eot?#iefix') format('embedded-opentype'),  url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff2') format('woff2'),url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.woff') format('woff'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.ttf') format('truetype'), url('http://www.stampready.net/Fonts/source_sans_pro/sourcesanspro-regular-webfont.svg#source_sans_proregular') format('svg'); ");
            htmlText.append(" font-weight: normal; ");
            htmlText.append(" font-style: normal; ");
            htmlText.append(" } ");

            htmlText.append(" body { ");
            htmlText.append(" margin: 0px; ");
            htmlText.append(" padding: 0px; ");
            htmlText.append(" } ");
            htmlText.append(" ::selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");
            htmlText.append(" ::-moz-selection { ");
            htmlText.append(" background: #ff2f2f; ");

            htmlText.append(" } ");

            htmlText.append(" @media only screen and (max-width: 640px) { ");

            htmlText.append(" table[class=scale] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=margin-center] { ");
            htmlText.append(" margin: auto!important; ");
            htmlText.append(" } ");
            htmlText.append(" table[class=hide] { ");
            htmlText.append(" display: none!important; ");
            htmlText.append(" } ");

            htmlText.append(" td[class=scale-center-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-left] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: right!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 24px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=scale-center-bottom-both] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" text-align: center!important; ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" padding-left: 20px!important; ");
            htmlText.append(" padding-right: 20px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom12] { ");
            htmlText.append(" padding-bottom: 12px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom19] { ");
            htmlText.append(" padding-bottom: 19px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=bottom21] { ");
            htmlText.append(" padding-bottom: 21px!important; ");
            htmlText.append(" } ");
            htmlText.append(" td[class=height4] { ");
            htmlText.append(" height: 4px!important; ");
            htmlText.append(" font-size: 1px!important; ");
            htmlText.append(" } ");

            htmlText.append(" img[class=\"scale\"] { ");
            htmlText.append(" width: 90%!important; ");
            htmlText.append(" } ");
            htmlText.append(" img[class=\"reset\"] { ");
            htmlText.append(" width: 100%!important; ");
            htmlText.append(" } ");
            htmlText.append(" } ");
            htmlText.append("  </style> ");
            htmlText.append("  </head> ");
            htmlText.append("  <body marginwidth=\"0\" marginheight=\"0\" style=\"margin-top: 0; margin-bottom: 0; padding-top: 0; padding-bottom: 0; width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\" offset=\"0\" topmargin=\"0\" leftmargin=\"0\"> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Navigation\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/01.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <table width=\"165\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" target=\"blank\"> ");
            htmlText.append("  <img mc:edit=\"Logo\" src=\"http://www.miraclesoft.com/images/apcloud_Horizontal.png\" style=\"display:block; margin: 0 auto;\" alt=\"logo\" width=\"170\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"265\" style=\"padding-top:23px;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"right\" style=\"font-family:'source_sans_proregular', Lato; font-size: 14px; line-height: 20px; color: #232527\" class=\"scale-center-both\" data-link-color=\"Nav Links\" data-link-size=\"Nav Links\" data-link-style=\"text-decoration: none; font-size: 14px; color: #232527\" data-size=\"Nav Links\" data-max=\"22\"> ");
            htmlText.append("  <a href=\"http://www.apcloud.in/ac/home.action\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">About   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"http://www.apcloud.in/ac/general/contactUS.action\" style=\"text-decoration: none; color: #232527\" data-color=\"Nav Links\">Contact Us   </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Header\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/02.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"170\" bgcolor=\"#394c52\" style=\"background: url(http://www.miraclesoft.com/images/apcloud-banner.jpg) center top no-repeat, #394c52;\" background=\"http://www.miraclesoft.com/images/apcloud-banner.jpg\" data-bgcolor=\"Header\" data-bg=\"Header\"> ");

            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_prosemibold', Lato; font-size: 32px; color: #ffffff;\" data-color=\"Header Title\" data-size=\"Header Title\" data-min=\"14\"> ");
            htmlText.append("  <b>World's Destination   </b>  for   <b>Digital Transformation   </b> Skilled Workforce ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");

            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Title\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/03.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"left\" style=\"font-family:'source_sans_probold', Lato; font-size: 19px; color: #2368a0;\" data-color=\"Big Title\" data-size=\"Big Title\" data-min=\"14\"> ");
            htmlText.append("  <b> Registration Successful </b> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Text +Button\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/04.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Module\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-size: 14px;font-family:'source_sans_proregular', Lato;padding-top:20px;\"> ");

            htmlText.append("  <font color=\"#232527\"><b>Hello " + registrationAction.getName() + ",</b> ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append("  You are successfully registered to AP CLOUD Initiative in our portal. ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");

            htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Company Name:</b> " + registrationAction.getCompanyName() + " <br>");
            //htmlText.append("  <font color=\"#232527\"><b>Company Name " + registrationAction.getCompanyName()  + ",</b> ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Phone:</b> " + registrationAction.getPhone() + " <br>");
            // htmlText.append("  <font color=\"#232527\"><b>Hello " + registrationAction.getPhone()  + ",</b> ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
           
             htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");
            htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Title:</b> " + registrationAction.getTitle() + " <br>");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");

            htmlText.append(" <b style='font - size : 14px;  color: #ef4048;  '>Area Of Expertise:</b> " + registrationAction.getAreasOfExpertise() + " <br>");
            //  htmlText.append("  <font color=\"#232527\"><b>Hello " + registrationAction.getAreasOfExpertise()  + ",</b> ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");

           
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:180%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#232527\"> ");





          //  htmlText.append(" Please  <a href='http://www.apcloud.in/ac/general/login.action' target=\"_blank\" style=\"font-size: 14px; color: #00aae7;\"><b> click here  </b></a>  to enroll to our active workshop. ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <div class=\"contentEditableContainer contentTextEditable\"> ");
            htmlText.append("  <div class=\"contentEditable\" style=\"text-align: center;\"> ");
            htmlText.append("  <p style=\"line-height:150%; text-align: justify; font-family:Lato, Helvetica, sans-serif;font-size: 14px;\"><font color=\"#b7b2b3\"> ");
            htmlText.append("  <b> Thanks & Regards,</b> ");
            htmlText.append("  <br>  AP Cloud Team,");
            htmlText.append("  <br> Miracle Software Systems, Inc. ");
            htmlText.append("  <br> Email : apcloud@miraclesoft.com ");
            htmlText.append("  <br>  Phone : 0891-6623556 ");
            htmlText.append("  </font> ");
            htmlText.append("  </p> ");
            htmlText.append("  </div> ");
            htmlText.append("  </div> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Quote\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/06.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Quote\"> ");
            htmlText.append("  <table width=\"470\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"10\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td> ");
            htmlText.append("  <table width=\"40\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Icons\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/07.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#FFFFFF\" data-bgcolor=\"Icons\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px 0px;\"> ");

            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td width=\"200\" align=\"center\" style=\"text-align: center;\"> ");
            htmlText.append("  <table width=\"200\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://www.facebook.com/andhracloud/\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/facebook.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://plus.google.com/104381127288956493644\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/googleplus.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://www.linkedin.com/groups/10313125\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/linkedin.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://www.youtube.com/c/Team_MSS\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/youtube.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  <td width=\"10\"> ");
            htmlText.append("  <a href=\"https://twitter.com/andhracloud\" target=\"_blank\"> ");
            htmlText.append("  <img src=\"http://www.miraclesoft.com/images/newsletters/twitter.png\" alt=\"facebook\" width=\"26\" height=\"auto\" data-max-width=\"40\" data-customicon=\"true\"> ");
            htmlText.append("  </a> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"Footer\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/08.png\" class=\"\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#232527\" data-bgcolor=\"Footer\"> ");
            htmlText.append("  <table width=\"560\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale-center-both\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"18\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td align=\"center\" style=\"font-family:'source_sans_proregular', Lato; font-size: 13px; line-height: 27px; color: #FFFFFF;\" data-color=\"Paragraph Footer\" data-size=\"Paragraph Footer\" data-max=\"18\"> ");
            htmlText.append("  <b> © Copyright 2016  <span style=\"color:#00aae7;\">Miracle Software Systems, Inc.</span></b> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"15\" style=\"font-size: 1px;\">&nbsp;</td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" data-module=\"End\" class=\"hide\" data-thumb=\"http://www.stampready.net/dashboard/templates/cityguide/main/thumbnails/09.png\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\"> ");
            htmlText.append("  <table width=\"620\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"scale\"> ");
            htmlText.append("  <tbody> ");
            htmlText.append("  <tr> ");
            htmlText.append("  <td height=\"42\" bgcolor=\"#e5eaeb\" data-bgcolor=\"Body\">  &nbsp;");

            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");

            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </td> ");
            htmlText.append("  </tr> ");
            htmlText.append("  </tbody> ");
            htmlText.append("  </table> ");
            htmlText.append("  </body> ");
            htmlText.append("  </html> ");

            messageBodyPart.setContent(htmlText.toString(), "text/html");

            // System.out.println("User Registrtaion-->"+htmlText.toString());
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            //System.out.println("Mail Sent ----->");
            resultMessage = "MailSent";
            transport.close();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return resultMessage;
    }

    
    
    private static class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
