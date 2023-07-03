package bloco;

import java.util.Set;

import model.interfaces.Eletronico;
import model.interfaces.Sensor;

public class Sala implements Sensor {

    private Set<Eletronico> eletronicos;

    public Sala(Set<Eletronico> eletronicos) {
        this.eletronicos = eletronicos;
    }

    @Override
    public void update(Boolean state) {
        if (state) {
            this.ligarEletronicos();
        } else {
            this.desligarEletronicos();
        }
    }

    private void desligarEletronicos() {
        for (Eletronico eletronico : eletronicos) {
            eletronico.desligar();
        }
    }

    private void ligarEletronicos() {
        for (Eletronico eletronico : eletronicos) {
            eletronico.ligar();
        }
    }

}
