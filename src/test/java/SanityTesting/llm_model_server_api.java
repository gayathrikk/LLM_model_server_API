package SanityTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.ContentType;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class llm_model_server_api {

    private static final String BASE_URL = "http://dgx5.humanbrain.in:8999/v1/chat/completions";
    private static final String MODEL = "Llama-3.3-70B-Instruct";

    @Test
    public void validateLlamaApiResponse() throws Exception {
        int statusCode = sendRequest("Hi");

        System.out.println("🔹 API Status Code: " + statusCode);

        if (statusCode == 200) {
            Assert.assertTrue(true, "API returned 200 OK");
        } else {
            // ❌ Status NOT OK → Send Gmail + Fail test
            sendFailureEmail(statusCode);
            Assert.fail("Expected 200 but got " + statusCode);
        }
    }

    public int sendRequest(String prompt) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL);

            // JSON body
            String jsonBody = "{\n" +
                    "  \"model\": \"" + MODEL + "\",\n" +
                    "  \"messages\": [{\"role\": \"system\", \"content\": \"" + prompt + "\"}],\n" +
                    "  \"temperature\": 0,\n" +
                    "  \"frequency_penalty\": 1.0,\n" +
                    "  \"top_p\": 0.1,\n" +
                    "  \"max_tokens\": 1000,\n" +
                    "  \"stream\": false\n" +
                    "}";

            request.setEntity(new StringEntity(jsonBody, ContentType.APPLICATION_JSON));
            request.setHeader("Authorization", "Bearer empty");

            try (CloseableHttpResponse response = client.execute(request)) {
                return response.getCode(); // return only status code
            }
        }
    }

    public void sendFailureEmail(int statusCode) {
        final String fromEmail = "automationsoftware25@gmail.com";
        final String toEmail = "sriramv@htic.iitm.ac.in";
        final String password = "wjzcgaramsqvagxu"; // App-specific password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            // ✅ Add CC recipients
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(
                    "divya.d@htic.iitm.ac.in," +
                    "venip@htic.iitm.ac.in"
            ));

            message.setSubject("LLM model server API ❌");

            message.setText("Hi,\n\n"
                    + "I am LLM model server API and I’ve failed to serve the request.\n"
                    + "Expected 200 but got " + statusCode + " from API: " + BASE_URL + "\n\n"
                    + "Please take a look and help me get back on track. 🙏");

            Transport.send(message);
            System.out.println("Failure notification email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email notification.");
        }
    }
}
