package com.spring.mooncy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mooncy.dao.StoreDAO;
import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.dto.StoreDTO;
import com.spring.mooncy.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	

	@Autowired
	StoreDAO storeDAO;

	

	@Override
	public List<StoreDTO> searchList(StoreDTO storeDTO, String id) {
		
		storeDTO.setM_id(id);
		return storeDAO.searchList(storeDTO);
	}
}
