package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Admin;

public interface AdminService {
	List<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long id);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Long id);
}
