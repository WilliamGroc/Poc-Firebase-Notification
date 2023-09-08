package com.wag.app.notification.appnotification.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FirebaseMessagingService {

  @Autowired
  private FirebaseMessaging firebaseMessaging;

  public String sendNotification(Note note, String token) throws FirebaseMessagingException {
    Notification notification = Notification
      .builder()
      .setTitle(note.getSubject())
      .setBody(note.getContent())
      .build();

      Message message = Message.builder()
      .setToken(token)
      .setNotification(notification)
      .build();

      return this.firebaseMessaging.send(message);
  }
}
