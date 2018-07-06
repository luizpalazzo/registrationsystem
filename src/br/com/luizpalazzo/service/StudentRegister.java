package br.com.luizpalazzo.service;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luizpalazzo.dao.StudentDao;
import br.com.luizpalazzo.entity.Student;
import br.com.luizpalazzo.helper.Command;

public class StudentRegister implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data_nascimento"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String foto = request.getParameter("foto");
		
		Student student = new Student(cpf, nome, email, senha, foto, dataNascimento);
		
		try{
			StudentDao dao = new StudentDao();
			dao.save(student);
			request.setAttribute("mensagem", "Aluno "+nome+" cadastrado com sucesso!");
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		return "success.jsp";
	}

}
