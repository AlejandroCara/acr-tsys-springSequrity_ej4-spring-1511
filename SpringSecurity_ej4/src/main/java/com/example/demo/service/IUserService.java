package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.User;

public interface IUserService {
	// Metodos del CRUD
		public List<UserRecord> listAll();

		public User add(User proyecto);

		public User getOne(String email);

		public User update(User proyecto);

		public void eliminar(String email);
}
