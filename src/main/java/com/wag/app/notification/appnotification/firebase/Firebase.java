package com.wag.app.notification.appnotification.firebase;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@Configuration
public class Firebase {

  @Bean
  FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
    return FirebaseMessaging.getInstance(firebaseApp);
  }

  @Bean
  FirebaseApp firebaseApp(GoogleCredentials credentials) {
    FirebaseOptions options = FirebaseOptions
      .builder()
      .setCredentials(credentials)
      .build();

    return FirebaseApp.initializeApp(options);
  }

  @Bean
  GoogleCredentials googleCredentials() throws IOException {
    return GoogleCredentials.fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
  }
}
