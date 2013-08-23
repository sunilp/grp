package com.gpr.db.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * User of the Portal
 *
 */
@Entity(name="appuser")
    public class User implements Serializable, UUIDType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

    @Column
	private String firstName;

    @Column
	private String lastName;

    @Column
	private String email;

    @Column
	@Type(type = "uuid-char")
	private UUID uuid;

    public String getEmail() {
        UUID.randomUUID();
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}