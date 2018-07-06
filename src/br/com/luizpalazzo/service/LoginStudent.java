package br.com.luizpalazzo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.luizpalazzo.dao.StudentDao;
import br.com.luizpalazzo.entity.Student;
import br.com.luizpalazzo.helper.Command;

public class LoginStudent implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		StudentDao dao = new StudentDao();
		Student student = null;
		HttpSession session = request.getSession();;
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		student = dao.findActiveUser(email, senha);
		
		if(student != null){
			session.setAttribute("usuario", student);
			session.setAttribute("role", "aluno");
			return "restricted/dashboard.jsp";
		}else{
			session.setAttribute("mensagem", "Usuário ou senha incorretos!");
			return "error.jsp";
		}
		
		
		
	}

}
