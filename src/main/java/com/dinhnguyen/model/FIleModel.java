package com.dinhnguyen.model;

public class FIleModel extends AbtracModel<FIleModel> {
	private Long id_usersent ;
	private Long id_userreceived ;
	public Long getId_usersent() {
		return id_usersent;
	}
	public void setId_usersent(Long id_usersent) {
		this.id_usersent = id_usersent;
	}
	public Long getId_userreceived() {
		return id_userreceived;
	}
	public void setId_userreceived(Long id_userreceived) {
		this.id_userreceived = id_userreceived;
	}
	
}
