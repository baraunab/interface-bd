package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Schemata;

public class ConsultaDAO {
    public List<Schemata> listaBancos() {
        List<Schemata> bancos = new ArrayList();
        String sql = "select schema_name from schemata;";

        try (
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ) {
            while(rs.next()) {
                Schemata banco = new Schemata();
                banco.setSchema_name(rs.getString("schema_name"));
                bancos.add(banco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bancos;
    }
}
