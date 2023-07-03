package model.eletronico;

import model.interfaces.Eletronico;

public class Lampada implements Eletronico {

    private boolean isOn;

    public Lampada() {
        this.isOn = false;
    }

    public boolean checkStatus() {
        return this.isOn;
    }

    public void ligar() {
        this.isOn = true;
    }

    public void desligar() {
        this.isOn = false;
    }

}
