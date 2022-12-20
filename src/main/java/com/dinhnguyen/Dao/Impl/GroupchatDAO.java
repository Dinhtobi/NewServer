package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IGroupchatDAO;
import com.dinhnguyen.mapper.GroupchatMapper;
import com.dinhnguyen.model.NhomChat;

public class GroupchatDAO extends AbstractDAO<NhomChat> implements IGroupchatDAO {

	@Override
	public Long save(NhomChat nhomChat) {
		String sql = "insert into nhomchat(tennhom, id_nguoitao ,image) values (?,?,?)";
		return insert(sql, nhomChat.getTennhom(), nhomChat.getId_nguoitao(),nhomChat.getImage());
	}

	@Override
	public void Del(Long id_nhomchat) {
		String sql1 = "Delete from ctnhomchat where id_nhomchat = ? ";
		String sql2 = "Delete from nhomchat where id_nhomchat = ?" ;
		update(sql1, id_nhomchat);
		update(sql2, id_nhomchat);
	}

	@Override
	public void Update(NhomChat nhomChat) {
		StringBuilder sql = new StringBuilder( "Update nhomchat set tennhomchat = ? , image = ?");
		sql.append(" where id_nhomchat = ? ") ;
		update(sql.toString(), nhomChat.getTennhom() , nhomChat.getImage(),nhomChat.getId_nhomchat());
	}

	@Override
	public NhomChat findone(Long id_nhomchat) {
		String sql = "Select * from nhomchat where id_nhomchat = ?" ;
		try {
			List<NhomChat> list= query(sql, new GroupchatMapper(), id_nhomchat);
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<NhomChat> findallNhomchatbyiduser(Long id_user) {
		StringBuilder sql = new StringBuilder("select nc.id_nhomchat , nc.tennhom, nc.id_nguoitao , nc.image from nhomchat as nc , ctnhomchat as ct ");
		sql.append(" where nc.id_nhomchat = ct.id_nhomchat and id_nguoidung = " + id_user) ;
		try {
			return query(sql.toString() , new GroupchatMapper());
		} catch (Exception e) {
			return null;
		}
	}

}
