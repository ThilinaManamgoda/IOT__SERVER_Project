package org.maana.iot_project.optional_apis;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.maana.iot_project.models.ServerConstants;
import org.maana.iot_project.models.sensor.Sensor;

public class SendMailTLS extends SensorAction {

	private String toEmailAddress;
	private int condition;

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public SendMailTLS() {

	}

	public String getToEmailAddress() {
		return toEmailAddress;
	}

	public void setToEmailAddress(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}

	public void sendMail(String text) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ServerConstants.EMAIL_USERNAME, ServerConstants.EMAIL_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ServerConstants.EMAIL_FROM_EMAIL_ADDRESS));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
			message.setSubject(ServerConstants.EMAIL_SUBJECT);
			message.setText(text);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void execute(Sensor sensor, String arg, long userId) {
		sendMail(ServerConstants.EMAIL_MESSAGE + ServerConstants.EMAIL_MESSAGE_SENSOR_ID + sensor.getSensorId() + ","
				+ ServerConstants.EMAIL_MESSAGE_SENSOR_MODEL + sensor.getSensor_Model().getSensorModel() + ","
				+ ServerConstants.EMAIL_MESSAGE_SENSOR_TYPE + sensor.getSensor_Model().getSensorType().getSensorType()
				+ "," + ServerConstants.EMAIL_MESSAGE_SENSOR_VALUE + sensor.getSensorCriticalValue());
	}

	@Override
	public int getCondition() {
		return condition;
	}

	@Override
	public int getSensorthresholdValue() {
		return sensorThresholdValue;
	}

	@Override
	public void setSensorthresholdValue(int sensorThresholdValue) {
		this.sensorThresholdValue = sensorThresholdValue;
	}

}