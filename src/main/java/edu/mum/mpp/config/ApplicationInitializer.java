package edu.mum.mpp.config;


import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(Config.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dispatcher.setLoadOnStartup(1);
        //dispatcher.addMapping("/");
        dispatcher.addMapping("/");
        // dispatcher.addMapping("/user/**");

        // Here, set desired context class using 'contextClass' parameter.
        dispatcher.setInitParameter("contextClass", ctx.getClass().getName());

        servletContext.addListener(new ContextLoaderListener(ctx));


    }

    //@Override
    //protected Filter[] getServletFilters() {
      //  Filter [] singleton = { new CORSFilter() };
        //return singleton;
    //}

    //@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityConfig.class };
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        return new Class[] { SecurityConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }



}
