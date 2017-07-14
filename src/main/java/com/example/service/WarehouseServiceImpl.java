package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Warehouse;
import com.example.repository.WareHouseRepository;

@Service("warehouseService")
public class WarehouseServiceImpl implements IWarehouseService
{

	@Autowired
	private WareHouseRepository wareHouseRepository;

	@Override
	public Warehouse findWarehouseByEmail(String email)
	{
		return wareHouseRepository.findByEmail(email);
	}

	@Override
	public void saveWarehouse(Warehouse warehouse)
	{
		wareHouseRepository.save(warehouse);
	}

	@Override
	public List<Warehouse> findWarehouses()
	{
		return wareHouseRepository.findAll();
	}

}
