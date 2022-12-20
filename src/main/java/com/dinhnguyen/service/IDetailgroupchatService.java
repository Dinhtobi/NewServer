package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.CTNhomChat;

public interface IDetailgroupchatService {
	CTNhomChat save(CTNhomChat ctNhomChat);
	void Del(Long id_nguoidung);
	List<CTNhomChat> findall(Long id_nhomchat);
}
