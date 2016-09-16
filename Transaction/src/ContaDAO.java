
import transaction.Conta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 11204974
 */
public interface ContaDAO {

	void transferir(Conta c1, Conta c2) throws DAOContaException;

        
}

