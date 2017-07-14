package com.example.service;

import java.util.List;

import com.example.model.User;
import com.example.model.Warehouse;

public interface IWarehouseService {
	public Warehouse findWarehouseByEmail(String email);
	public void saveWarehouse(Warehouse wßarehouse);
	List<Warehouse> findWarehouses();
}
