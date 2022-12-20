package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IDetailgroupchatDAO;
import com.dinhnguyen.model.CTNhomChat;
import com.dinhnguyen.service.IDetailgroupchatService;

public class DetailgroupchatService implements IDetailgroupchatService{

	@Inject
	private IDetailgroupchatDAO iDetailgroupchatDAO;
	@Override
	public CTNhomChat save(CTNhomChat ctNhomChat) {
		iDetailgroupchatDAO.save(ctNhomChat);
		return iDetailgroupchatDAO.findone(ctNhomChat.getId_nhomchat() , ctNhomChat.getId_nguoidung());
	}

	@Override
	public void Del(Long id_nguoidung) {
		iDetailgroupchatDAO.Del(id_nguoidung);
		
	}

	@Override
	public List<CTNhomChat> findall(Long id_nhomchat) {
		return iDetailgroupchatDAO.findAll(id_nhomchat);
	}

}
