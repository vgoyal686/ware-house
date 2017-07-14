package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;
import com.example.model.Warehouse;

@Repository("wareHouseRepository")
public interface IWareHouseRepository extends JpaRepository<Warehouse, Long> {
	Warehouse findByEmail(String email);
}
