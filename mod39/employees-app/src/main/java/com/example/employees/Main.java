package com.example.employees;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        // Em um JAR, o 'src/main/webapp' não existe.
        // O Maven coloca os arquivos em META-INF/resources dentro do JAR.
        // Apontamos o docBase para o próprio JAR ou diretório atual.
        String docBase = new File(".").getAbsolutePath();

        Context ctx = tomcat.addWebapp("", docBase);

        // Registro manual do Servlet para evitar erro 404
        EmployeeServlet employeeServlet = new EmployeeServlet();
        Tomcat.addServlet(ctx, "employeeServlet", employeeServlet);
        ctx.addServletMappingDecoded("/employee", "employeeServlet");

        System.out.println("Servidor iniciado! Acesse: http://localhost:8080/employee");

        tomcat.start();


        tomcat.getServer().await();
    }
}