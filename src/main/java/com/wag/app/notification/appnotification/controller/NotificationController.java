package com.wag.app.notification.appnotification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.wag.app.notification.appnotification.firebase.FirebaseMessagingService;
import com.wag.app.notification.appnotification.firebase.Note;

@RestController
public class NotificationController {

  @Autowired
  private FirebaseMessagingService firebaseMessagingService;

  @PostMapping(value = "/")
  @ResponseBody
  public String PostNotification(
    @RequestBody Note note,
    @RequestParam String token
  ) throws FirebaseMessagingException {
    return this.firebaseMessagingService.sendNotification(note, token);
  }
}
