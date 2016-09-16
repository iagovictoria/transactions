/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import java.util.List;

/**
 *
 * @author 11204974
 */
public class ContaApp {
    
    
    public static void main(String [] args) throws DAOContaException
	{
            ContaDAO conta = new ContaDAODerby();
            
		List<Conta> contas = conta.buscarContas();
                
                for(Conta c : contas ){
                    System.out.println(c.getId() + ": " + c.getSaldo());
                }
                    
	}
    
    
}
    
    

