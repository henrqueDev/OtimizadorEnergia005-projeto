package model.eletronico;

import model.interfaces.Eletronico;
import model.interfaces.Sensor;

public class ArCondicionado implements Eletronico, Sensor {

    private Integer id;
    private boolean isOn;
    private int temperatura;

    public ArCondicionado(Integer id, int temperatura) {
        this.id = id;
        this.isOn = false;
        this.temperatura = temperatura;
    }

    public void setTemperatura(int num) {
        this.temperatura = num;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    @Override
    public void update(Boolean state) {
        if (state) {
            // System.out.println("Ar Condicionado ligado!");
            this.ligar();
        } else {
            // System.out.println("Ar Condicionado desligado!");
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
