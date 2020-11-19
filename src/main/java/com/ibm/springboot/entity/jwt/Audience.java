package com.ibm.springboot.entity.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {

	private String clientId;

	private String base64Secret;

	private String name;

	private int expiresSecond;

	public Audience() {
		super();
	}

	public Audience(String clientId, String base64Secret, String name, int expiresSecond) {
		super();
		this.clientId = clientId;
		this.base64Secret = base64Secret;
		this.name = name;
		this.expiresSecond = expiresSecond;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getBase64Secret() {
		return base64Secret;
	}

	public void setBase64Secret(String base64Secret) {
		this.base64Secret = base64Secret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExpiresSecond() {
		return expiresSecond;
	}

	public void setExpiresSecond(int expiresSecond) {
		this.expiresSecond = expiresSecond;
	}

}
