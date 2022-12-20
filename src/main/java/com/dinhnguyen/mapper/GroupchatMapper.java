package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.NhomChat;

public class GroupchatMapper implements RowMapper<NhomChat> {

	@Override
	public NhomChat mapRow(ResultSet rs) {
		try {
			NhomChat groChat = new NhomChat();
			groChat.setId_nguoitao(rs.getLong("id_nguoitao"));
			groChat.setId_nhomchat(rs.getLong("id_nhomchat"));
			groChat.setTennhom(rs.getString("tennhom"));
			groChat.setImage(rs.getString("image"));
			return groChat ;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null ;
		}
	}

}
