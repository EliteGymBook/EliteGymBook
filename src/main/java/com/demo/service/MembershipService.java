package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Membership;

public interface MembershipService {

	 List<Membership> getAllMemberships();
	 Optional<Membership> getMembershipById(Long id);
	 Membership saveMembership(Membership membership);
	 void deleteMembership(Long id);
}
