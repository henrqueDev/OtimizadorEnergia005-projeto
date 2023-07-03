package model.eletronico;

import model.interfaces.Eletronico;
import model.interfaces.Sensor;

public class Lampada implements Eletronico, Sensor {

    private boolean isOn;

    public Lampada() {
        this.isOn = false;
    }

    @Override
    public void update(Boolean state) {
        if (state) {
            this.ligar();
        } else {
            this.desligar();
        }
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
