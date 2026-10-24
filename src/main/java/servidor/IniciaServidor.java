package servidor;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import servlet.InterfaceServlet;

public class IniciaServidor {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        String webapp = (new File("src/main/webapp")).getAbsolutePath();
        Context context = tomcat.addWebapp("", webapp);
        String nomeServlet = "InterfaceServlet";
        Tomcat.addServlet(context, nomeServlet, new InterfaceServlet());
        context.addServletMappingDecoded("/interface-bd", nomeServlet);
        tomcat.start();
        tomcat.getServer().await();
    }
}
