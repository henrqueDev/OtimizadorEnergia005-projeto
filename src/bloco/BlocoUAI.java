package bloco;

import java.util.Set;

import model.Docente;
import model.interfaces.Publicador;
import model.interfaces.Sensor;

public class BlocoUAI implements Publicador {

    private Set<Sensor> sensores;
    private Set<Docente> docentes;

    public BlocoUAI(Set<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void docenteEntrada(Docente docente) {
        this.docentes.add(docente);
    }

    public void docenteSaida(Docente docente) {
        this.docentes.remove(docente);
    }

    @Override
    public void subscribe(Sensor sensor) {
        this.sensores.add(sensor);
    }

    @Override
    public void unsubscribe(Sensor sensor) {
        this.sensores.remove(sensor);
    }

    @Override
    public void notifySubscribers() {
        for (Sensor sensor : this.sensores) {
            sensor.update(this.checkDocentesPresentes());
        }
    }

    private boolean checkDocentesPresentes() {
        return docentes.size() > 0;
    }

}
