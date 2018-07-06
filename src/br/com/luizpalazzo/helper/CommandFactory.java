package br.com.luizpalazzo.helper;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public class CommandFactory {
	
	@SuppressWarnings("unchecked")
	public Command getCommand(HttpServletRequest request, ServletContext context) {
		String action = request.getParameter("action");
		try {
			Object object = context.getAttribute("paramsMap");
			Map<String, Class<?>> map = (Map<String, Class<?>>)object;
			Class<?> clazz = map.get(action);
			Command command = (Command)clazz.newInstance();
			return command;
		}
		catch(Exception error) {
			throw new RuntimeException("Invalid action!", error);
		}
	}

}
