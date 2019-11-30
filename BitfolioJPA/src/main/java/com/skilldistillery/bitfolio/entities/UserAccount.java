package com.skilldistillery.bitfolio.entities;





import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name= "user_profile_id")
	private UserProfile user;
	
	private String username;
	
	private String email;
	
	@Column(name="password")
	private String saltedPassword;
	
	@Column(name="password_salt")
	private String salt;
	
	@Column(name="password_hash_algorithm")
	private String hashAlgo;
	
	@Column(name="password_reminder_token")
	private String passToken;
	
	@Column(name="password_reminder_expire")
	private String passExpire;
	
	@Column(name="email_confirmation_token")
	private String emailToken;
	
	@Column(name="registration_time")
	private String registrationTime;
	
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSaltedPassword() {
		return saltedPassword;
	}

	public void setSaltedPassword(String saltedPassword) {
		this.saltedPassword = saltedPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashAlgo() {
		return hashAlgo;
	}

	public void setHashAlgo(String hashAlgo) {
		this.hashAlgo = hashAlgo;
	}

	public String getPassToken() {
		return passToken;
	}

	public void setPassToken(String passToken) {
		this.passToken = passToken;
	}

	public String getPassExpire() {
		return passExpire;
	}

	public void setPassExpire(String passExpire) {
		this.passExpire = passExpire;
	}

	public String getEmailToken() {
		return emailToken;
	}

	public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}

	public String getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserAccount(int id, UserProfile user, String username, String email, String saltedPassword, String salt,
			String hashAlgo, String passToken, String passExpire, String emailToken, String registrationTime,
			boolean active) {
		super();
		this.id = id;
		this.user = user;
		this.username = username;
		this.email = email;
		this.saltedPassword = saltedPassword;
		this.salt = salt;
		this.hashAlgo = hashAlgo;
		this.passToken = passToken;
		this.passExpire = passExpire;
		this.emailToken = emailToken;
		this.registrationTime = registrationTime;
		this.active = active;
	}

	public UserAccount() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailToken == null) ? 0 : emailToken.hashCode());
		result = prime * result + ((hashAlgo == null) ? 0 : hashAlgo.hashCode());
		result = prime * result + id;
		result = prime * result + ((passExpire == null) ? 0 : passExpire.hashCode());
		result = prime * result + ((passToken == null) ? 0 : passToken.hashCode());
		result = prime * result + ((registrationTime == null) ? 0 : registrationTime.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((saltedPassword == null) ? 0 : saltedPassword.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (active != other.active)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailToken == null) {
			if (other.emailToken != null)
				return false;
		} else if (!emailToken.equals(other.emailToken))
			return false;
		if (hashAlgo == null) {
			if (other.hashAlgo != null)
				return false;
		} else if (!hashAlgo.equals(other.hashAlgo))
			return false;
		if (id != other.id)
			return false;
		if (passExpire == null) {
			if (other.passExpire != null)
				return false;
		} else if (!passExpire.equals(other.passExpire))
			return false;
		if (passToken == null) {
			if (other.passToken != null)
				return false;
		} else if (!passToken.equals(other.passToken))
			return false;
		if (registrationTime == null) {
			if (other.registrationTime != null)
				return false;
		} else if (!registrationTime.equals(other.registrationTime))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (saltedPassword == null) {
			if (other.saltedPassword != null)
				return false;
		} else if (!saltedPassword.equals(other.saltedPassword))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAccount [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", saltedPassword=");
		builder.append(saltedPassword);
		builder.append(", salt=");
		builder.append(salt);
		builder.append(", hashAlgo=");
		builder.append(hashAlgo);
		builder.append(", passToken=");
		builder.append(passToken);
		builder.append(", passExpire=");
		builder.append(passExpire);
		builder.append(", emailToken=");
		builder.append(emailToken);
		builder.append(", registrationTime=");
		builder.append(registrationTime);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}
	
	
}
