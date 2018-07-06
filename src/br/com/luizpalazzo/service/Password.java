package br.com.luizpalazzo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.luizpalazzo.dao.PasswordDao;
import br.com.luizpalazzo.entity.Student;
import br.com.luizpalazzo.helper.Command;

public class Password implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String senha = request.getParameter("senha1");
		PasswordDao dao = new PasswordDao();
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("usuario");
		dao.changePassword(senha, student.getId());
		session.setAttribute("mensagem", "Senha alterada com sucesso");
		return "success.jsp";
	}

}
