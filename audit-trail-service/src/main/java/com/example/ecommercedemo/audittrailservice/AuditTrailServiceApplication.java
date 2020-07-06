package com.example.ecommercedemo.audittrailservice;

import com.example.ecommercedemo.audittrailservice.model.AuditTrailModel;
import com.example.ecommercedemo.audittrailservice.repository.AuditTrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class AuditTrailServiceApplication {

	@Autowired
	private AuditTrailRepository auditTrailRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuditTrailServiceApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handleMessage(Message message){
		AuditTrailModel auditTrailModel = new AuditTrailModel(message.getMessage());
		auditTrailRepository.save(auditTrailModel);
	}

	public static class Message{
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return String.format("Message {}", message);
		}
	}
}
