package br.com.luizpalazzo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.luizpalazzo.dao.CourseDao;
import br.com.luizpalazzo.entity.Student;
import br.com.luizpalazzo.helper.Command;

public class Enroll implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int idCurso = Integer.parseInt(request.getParameter("selected_id"));
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("usuario");
		CourseDao dao = new CourseDao();
		
		if(dao.verifyEnroll(idCurso, student.getId())){
			dao.enroll(idCurso, student.getId());
			session.setAttribute("mensagem", "Matrícula efetuada com sucesso!");
			return "success.jsp";
		}else{
			session.setAttribute("mensagem", "O aluno já possui uma matrícula para essa disciplina!");
			return "error.jsp";
		}

	}

}
