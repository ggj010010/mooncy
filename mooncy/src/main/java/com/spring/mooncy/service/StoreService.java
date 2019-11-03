package com.spring.mooncy.service;
import java.util.List;

import com.spring.mooncy.dto.CustomerDTO;
import com.spring.mooncy.dto.StoreDTO;


public interface StoreService {
	public List<StoreDTO> searchList(StoreDTO storeDTO,String id);
	public List<StoreDTO> manager_searchList();
}
