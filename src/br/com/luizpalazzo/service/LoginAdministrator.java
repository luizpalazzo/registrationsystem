package br.com.luizpalazzo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.luizpalazzo.dao.AdministratorDao;
import br.com.luizpalazzo.dao.StudentDao;
import br.com.luizpalazzo.entity.Administrator;
import br.com.luizpalazzo.entity.Student;
import br.com.luizpalazzo.helper.Command;

public class LoginAdministrator implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdministratorDao administratorDao = new AdministratorDao();
		StudentDao studentDao = new StudentDao();
		List<Student> students = null;
		Administrator admin = null;
		HttpSession session = request.getSession();;
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		admin = administratorDao.findByEmailAndSenha(email, senha);
		
		if(admin != null){
			students = studentDao.ListUnvalidated();
			session.setAttribute("usuario", admin);
			session.setAttribute("role", "administrador");
			session.setAttribute("students", students);
			return "restricted/dashboard.jsp";
		}else{
			session.setAttribute("mensagem", "Usuário ou senha incorretos!");
			return "error.jsp";
		}
		
		
		
	}

}
