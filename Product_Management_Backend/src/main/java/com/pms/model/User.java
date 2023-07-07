package com.pms.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(length=25)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters")
    @Column(length=30)
    private String password;
    
    @Column(length=25)
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String Emailid;
    
    @Column(length=10)
    private long phoneno;
  
    public User() {
        
    }

    public User(String username, String password, String Emailid) {
        this.username = username;
        this.password = password;
        this.Emailid = Emailid;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
    
}