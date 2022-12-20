package com.dinhnguyen.Dao;

import java.util.List;

import com.dinhnguyen.model.CTNhomChat;


public interface IDetailgroupchatDAO extends GenericDAO<CTNhomChat> {
	Long save(CTNhomChat ctNhomChat);
	void Del(Long id_nguoidung);
	CTNhomChat findone(Long id_nhomchat,Long id_nguoidung);
	List<CTNhomChat> findAll(Long id_nhomchat);
}
