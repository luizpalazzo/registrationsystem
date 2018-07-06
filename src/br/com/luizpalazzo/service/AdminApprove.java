package br.com.luizpalazzo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.luizpalazzo.dao.AdministratorDao;
import br.com.luizpalazzo.helper.Command;

public class AdminApprove implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("selected_id");
		AdministratorDao dao = new AdministratorDao();
		dao.acceptStudent(Integer.parseInt(id));
		
		HttpSession session = request.getSession();
		session.setAttribute("mensagem", "Acesso concedido!");
		
		return "success.jsp";
	}

}
