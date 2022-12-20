package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.model.NhomChat;
import com.dinhnguyen.service.IGroupchatService;

public class GroupchatService implements IGroupchatService{

	@Inject
	private IGroupchatDAO iGroupchatDAO; 
	@Override
	public NhomChat save(NhomChat nhomChat) {
		Long id_nhomchat = iGroupchatDAO.save(nhomChat);
		return iGroupchatDAO.findone(id_nhomchat);
	}

	@Override
	public void Del(Long id_nhomchat) {
		iGroupchatDAO.Del(id_nhomchat);
	}

	@Override
	public void Update(NhomChat nhomChat) {
		iGroupchatDAO.Update(nhomChat);
	}

	@Override
	public List<NhomChat> findAllnhomchatbyiduser(Long id_user) {
		return iGroupchatDAO.findallNhomchatbyiduser(id_user);
	}

}
