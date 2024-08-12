package com.demo.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gym_name")
    private String gymName;

    @Column(name = "gym_address")
    private String gymAddress;

    @Column(name = "gym_contact")
    private String gymContact;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private GymOwner gymOwner;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Membership> memberships;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getGymAddress() {
		return gymAddress;
	}

	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}

	public String getGymContact() {
		return gymContact;
	}

	public void setGymContact(String gymContact) {
		this.gymContact = gymContact;
	}

	public GymOwner getGymOwner() {
		return gymOwner;
	}

	public void setGymOwner(GymOwner gymOwner) {
		this.gymOwner = gymOwner;
	}

	public Set<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(Set<Membership> memberships) {
		this.memberships = memberships;
	}

    
}
