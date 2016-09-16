package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 11204974
 */
public class ContaDAODerby implements ContaDAO {

    @Override
    public void transferir(Conta c1, Conta c2) throws DAOContaException {
        c1.transferir(c2);
        String sql = "UPDATE conta SET valor = ? WHERE id = ?";

        try (Connection conexao = BancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setDouble(1, c1.getValor());
                comando.setInt(2, c1.getId());
 
            }
        } catch (Exception e) {
            throw new DAOContaException("Falha na alteração", e);
        }

    }

}

