import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Conector {
    private Connection connect;

    public Conector(String url) {
        super();
        connectDB(url);
    }

    public ResultSet getReq1DB() {
        // TODO
        String sql = "SELECT SUM(Cantidad) AS total, id_proyecto, pagado, proveedor" + " FROM Compra"
                + " WHERE Pagado='NO'" + " GROUP BY ID_Proyecto" + " HAVING total > 50;";
        return executeQuery(sql);
    }

    public ResultSet getReq2DB() {
        // TODO
        String sql = "SELECT Proyecto.Fecha_Inicio AS inicio, t.Financiable, t.Estrato, Proyecto.Porcentaje_Cuota_Inicial * 100"
                + " FROM Proyecto" + " JOIN Tipo t ON Proyecto.ID_Tipo=t.ID_Tipo"
                + " WHERE t.Estrato >= 5 AND t.Financiable=0 AND Proyecto.Porcentaje_Cuota_Inicial > 0.2"
                + " ORDER BY inicio";
        return executeQuery(sql);
    }

    public ResultSet getReq3DB() {
        // TODO
        String sql = "SELECT p.ID_Proyecto, c.Pagado, p.Clasificacion" + " FROM Proyecto p"
                + " JOIN Tipo t ON p.ID_Tipo=t.ID_Tipo" + " JOIN Compra c ON c.ID_Proyecto=p.ID_Proyecto"
                + " JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion=c.ID_MaterialConstruccion"
                + " WHERE p.Clasificacion IN ('Apartaestudio','Apartamento') AND c.Pagado IN ('NO','Parcialmente') AND mc.Importado='Si' AND p.Acabados='No'"
                + " GROUP BY p.ID_Proyecto;";
        return executeQuery(sql);
    }

    public Connection connectDB(String url) {
        try {
            connect = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
