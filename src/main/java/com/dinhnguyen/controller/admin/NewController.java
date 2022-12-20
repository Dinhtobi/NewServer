package com.dinhnguyen.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.constant.SystemConstant;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.PageRequest;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IUserService;
import com.dinhnguyen.sort.Sorter;
import com.dinhnguyen.util.Formutil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 8533934601025223038L;
	@Inject
	private IUserService uService;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		/*
		 * UserModel model = new UserModel(); String pageStr = req.getParameter("page");
		 * String maxPageItemStr = req.getParameter("maxPageItem");
		 * 
		 * if (pageStr != null) { model.setPage(Integer.parseInt(pageStr)); } else {
		 * model.setPage(1); } if (maxPageItemStr != null) {
		 * model.setMaxPageItem(Integer.parseInt(maxPageItemStr)); }
		 */
		UserModel model =Formutil.toUsers(UserModel.class, req);
		String view ="";
		if(model.getType().equals(SystemConstant.LIST)) {
		Pageble pageble = new PageRequest(model.getPage() , model.getMaxPageItem() ,
				new Sorter(model.getSortName(),model.getSortBy()));
		model.setKq(uService.findAll(pageble));
		model.setTotalItem(uService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, model);
		view = "/views/admin/New/list.jsp";
		
		}
		else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId()!=null) {
				model = uService.findone(model.getId());
			}else {
				
			}
			view = "/views/admin/New/edit.jsp";
			
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
		requestDispatcher.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}
}
