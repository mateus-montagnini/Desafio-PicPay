package com.mrocha.br.services;

import com.mrocha.br.domain.user.User;
import com.mrocha.br.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String mess) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, mess);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("URL", notificationRequest, String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            System.out.println("Erro ao enviar notificacao");
            throw new Exception("Servico de notificacoes esta fora do ar");
        }
    }
}
