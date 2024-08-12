package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Membership;
import com.demo.service.MembershipService;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembershipById(@PathVariable Long id) {
        return membershipService.getMembershipById(id)
                .map(membership -> ResponseEntity.ok().body(membership))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Membership createMembership(@RequestBody Membership membership) {
        return membershipService.saveMembership(membership);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membership> updateMembership(@PathVariable Long id, @RequestBody Membership membershipDetails) {
        return membershipService.getMembershipById(id)
                .map(membership -> {
                    membership.setMembershipType(membershipDetails.getMembershipType());
                    membership.setPrice(membershipDetails.getPrice());
                    Membership updatedMembership = membershipService.saveMembership(membership);
                    return ResponseEntity.ok().body(updatedMembership);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMembership(@PathVariable Long id) {
        return membershipService.getMembershipById(id)
                .map(membership -> {
                    membershipService.deleteMembership(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}