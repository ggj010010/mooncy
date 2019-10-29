package com.spring.mooncy.dao;
import java.util.List;

import com.spring.mooncy.dto.StoreDTO;

public interface StoreDAO {

	public List<StoreDTO> searchList(StoreDTO storeDTO);

}