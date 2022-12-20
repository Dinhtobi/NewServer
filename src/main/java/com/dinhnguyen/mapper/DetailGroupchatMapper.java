package com.dinhnguyen.mapper;

import java.sql.ResultSet;

import com.dinhnguyen.model.CTNhomChat;

public class DetailGroupchatMapper implements RowMapper<CTNhomChat> {

	@Override
	public CTNhomChat mapRow(ResultSet rs) {
		try {
			CTNhomChat ct = new CTNhomChat();
			ct.setId_nguoidung(rs.getLong("id_nguoidung"));
			ct.setId_nhomchat(rs.getLong("id_nhomchat"));
			ct.setThoigianroikhoi(rs.getString("thoigianroikhoi"));
			ct.setThoigianthamgia(rs.getString("thoigianthamgia"));
			return ct; 
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null; 
		}
	}

}
