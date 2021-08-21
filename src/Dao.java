import java.sql.ResultSet;
import java.sql.SQLException;

import util.RequirementTypeEnum;

public class Dao {
    private Conector conectorDB;

    public Dao(String url) {
        conectorDB = new Conector(url);
    }

    public Object[][] getReqs(RequirementTypeEnum requirementType) {
        ResultSet resultSet = null;
        Object reqs[][] = null;

        try {

            switch (requirementType) {
                case REQUIREMENT_1:
                    resultSet = this.conectorDB.getReq1DB();
                    break;
                case REQUIREMENT_2:
                    resultSet = this.conectorDB.getReq2DB();
                    break;

                default:
                    resultSet = this.conectorDB.getReq3DB();
                    break;
            }

            resultSet.last(); // Envia el resulset a la ultima posicion
            int dimmension = resultSet.getRow(); // Obtiene el número de filas
            resultSet.beforeFirst(); // Deja el resulset por default en su posición inicial
            int columnCount = resultSet.getMetaData().getColumnCount();
            reqs = new Object[dimmension][columnCount];
            int i = 0;

            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    reqs[i][j] = String.valueOf(resultSet.getObject(j + 1));
                }
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reqs;
    }

}