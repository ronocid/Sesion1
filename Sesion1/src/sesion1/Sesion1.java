
package sesion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class Sesion1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/informesdi","root","erintiacs");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("report1.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,conexion);
            JRExporter exporter;
            exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporteSesion1PDF.pdf"));
            exporter.exportReport();
            
        } catch (SQLException | ClassNotFoundException | JRException ex) {
            Logger.getLogger(Sesion1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
