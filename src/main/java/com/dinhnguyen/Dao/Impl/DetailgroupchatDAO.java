package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IDetailgroupchatDAO;
import com.dinhnguyen.mapper.DetailGroupchatMapper;
import com.dinhnguyen.model.CTNhomChat;


public class DetailgroupchatDAO extends AbstractDAO<CTNhomChat> implements IDetailgroupchatDAO {

	@Override
	public Long save(CTNhomChat ctNhomChat) {
		String sql = "Insert into ctnhomchat(id_nhomchat , id_nguoidung , thoigianthamgia) values (?,?,?)";
		return insert(sql, ctNhomChat.getId_nhomchat() , ctNhomChat.getId_nguoidung() , ctNhomChat.getThoigianthamgia());
	}

	@Override
	public void Del(Long id_nguoidung) {
		String sql = "delete from ctnhomnhat where id_nguoidung = ?";
		update(sql, id_nguoidung);
	}

	@Override
	public CTNhomChat findone( Long id_nhomchat,Long id_nguoidung) {
		String sql = "select * from ctnhomchat where id_nguoidung = ? and id_nhomchat = ?" ;
		try {
			List<CTNhomChat> list = query(sql, new DetailGroupchatMapper() , id_nguoidung , id_nhomchat);
			return list.isEmpty()? null : list.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<CTNhomChat> findAll(Long id_nhomchat) {
		String sql = "select * from ctnhomchat where id_nhomchat = ?";
		return query(sql,new DetailGroupchatMapper(), id_nhomchat);
	}

}
