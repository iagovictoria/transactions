/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

/**
 *
 * @author 11204974
 */
public class Conta {

    /**
     * @param args the command line arguments
     */
    
    private int id;
    private double saldo;

    public Conta(int id, double saldo){
        this.id = id;
        this.saldo = saldo;
        
    }
    
    public int getId() {
        return id;
    }

    public double getValor() {
        return saldo;
    }

    public void setValor(double valor) {
        this.saldo = saldo;
    }
    
    public void transferir(Conta c1, Conta c2){
        c1.saldo = c1.saldo - 50.00;
        c2.saldo = c2.saldo + 50.00;
    }
 
    
}
