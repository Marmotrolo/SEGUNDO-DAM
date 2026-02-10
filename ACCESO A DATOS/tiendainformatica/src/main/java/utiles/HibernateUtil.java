package utiles;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static ServiceRegistry registro;
	private static SessionFactory factoriaSession;

	public static SessionFactory getFactoriaSession() {
	    if (factoriaSession == null) {
	        try {
	            // Forzamos a que busque explícitamente el archivo en los recursos
	            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
	            builder.configure("tienda.cfg.xml"); // Asegúrate que el nombre sea exacto
	            
	            registro = builder.build();
	            MetadataSources sources = new MetadataSources(registro);
	            factoriaSession = sources.buildMetadata().buildSessionFactory();

	        } catch (Exception e) {
	            System.err.println("Error al cargar la configuración: " + e.getMessage());
	            if (registro != null) {
	                StandardServiceRegistryBuilder.destroy(registro);
	            }
	            throw new RuntimeException(e);
	        }
	    }
	    return factoriaSession;
	}

	public static void shutdown() {
		if (registro != null) {
			StandardServiceRegistryBuilder.destroy(registro);
		}
	}
}
