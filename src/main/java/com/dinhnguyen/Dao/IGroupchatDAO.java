package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.NhomChat;

public interface IGroupchatDAO extends GenericDAO<NhomChat>{
	Long save(NhomChat nhomChat);
	void Del(Long id_nhomchat);
	void Update(NhomChat nhomChat);
	NhomChat findone(Long id_nhomchat) ;
	List<NhomChat> findallNhomchatbyiduser(Long id_user);
}
