package bloco;

import java.util.Set;

import model.Docente;
import model.interfaces.Sensor;

public class BlocoUAI {

    private Set<Sensor> sensores;
    private Set<Docente> docentes;

    public BlocoUAI(Set<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void subscribe(Docente docente) {
        this.docentes.add(docente);
    }

    public void unsubscribe(Docente docente) {
        this.docentes.remove(docente);
    }

    public void notifySalas() {
        for (Sensor sensor : this.sensores) {
            sensor.update(this.checkDocentesPresentes());
        }
    }

    private boolean checkDocentesPresentes() {
        return docentes.size() > 0;
    }

}
