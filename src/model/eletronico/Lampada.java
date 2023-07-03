package model.eletronico;

import model.interfaces.Eletronico;
import model.interfaces.Sensor;

public class Lampada implements Eletronico, Sensor {

    private Integer id;

    private boolean isOn;

    public Lampada(Integer id) {
        this.id = id;
        this.isOn = false;
    }

    @Override
    public void update(Boolean state) {
        if (state) {
            // System.out.println("Lâmpada ligada!");
            this.ligar();
        } else {
            // System.out.println("Lâmpada desligada!");
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
