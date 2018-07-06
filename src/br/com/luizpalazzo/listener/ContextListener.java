package br.com.luizpalazzo.listener;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	Map<String, Class<?>> map = new HashMap<>();
    	Enumeration<String> names = context.getInitParameterNames();
    	while(names.hasMoreElements()) {
    		String nome = names.nextElement();
    		String value = context.getInitParameter(nome);
    		try {
    			Class<?> clazz = Class.forName(value);
    			map.put(nome, clazz);
    		}
    		catch(Exception error) {
    			throw new RuntimeException(error);
    		}
    	}
    	context.setAttribute("paramsMap", map);
    	System.out.println("Context Initialized!");
    }
	
}
