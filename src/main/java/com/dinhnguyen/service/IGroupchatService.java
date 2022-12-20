package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.NhomChat;

public interface IGroupchatService {
	NhomChat save(NhomChat nhomChat);
	void Del(Long id_nhomchat);
	void Update(NhomChat nhomChat);
	List<NhomChat> findAllnhomchatbyiduser(Long id_user);
}
