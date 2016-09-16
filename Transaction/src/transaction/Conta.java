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

    public Conta(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;

    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void transferir(Conta c) {
        if (this.saldo >= 50) {
            this.saldo = this.saldo - 50.00;
            c.saldo = c.saldo + 50.00;
        }
    }

}
