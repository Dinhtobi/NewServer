package com.dinhnguyen.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.CTNhomChat;
import com.dinhnguyen.service.IDetailgroupchatService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet(urlPatterns = {"/api-admin-detailgroupchat"})
public class DetailGroupchatAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IDetailgroupchatService iDetailgroupchatService; 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		CTNhomChat ct = httpUtil.of(req.getReader()).toUsers(CTNhomChat.class);
		ct = iDetailgroupchatService.save(ct);
		mapper.writeValue(res.getOutputStream(), ct);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		CTNhomChat ct = httpUtil.of(req.getReader()).toUsers(CTNhomChat.class);
		iDetailgroupchatService.Del(ct.getId_nguoidung());
		mapper.writeValue(res.getOutputStream(), ct);
	}
}
