package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                comando.setDouble(1, c1.getSaldo());
                comando.setInt(2, c1.getId());
                comando.executeUpdate();

                comando.setDouble(1, c2.getSaldo());
                comando.setInt(2, c2.getId());
                comando.executeUpdate();

            }
        } catch (Exception e) {
            throw new DAOContaException("Falha na alteração", e);
        }

    }

    @Override
    public List<Conta> buscarContas() throws DAOContaException {
        Random ran = new Random();
        List<Conta> contas = new ArrayList<>();
        int n = ran.nextInt(50) + 1;
        int n2 = n;
        while (n == n2) {
            n2 = ran.nextInt(50) + 1;
        }

        String sql = "select * from conta WHERE (id = ? OR id = ?)";
        try (Connection conexao = BancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, n);
                comando.setInt(2, n2);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        Conta c1 = new Conta(
                                resultado.getInt("id"),
                                resultado.getDouble("saldo")
                        );
                        contas.add(c1);
                    }
                    return contas;
                }
            }
        } catch (Exception e) {
            throw new DAOContaException("Falha na busca", e);
        }
        
    }


}
