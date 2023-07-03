package bloco;

import java.util.HashSet;
import java.util.Set;

import model.Docente;
import model.interfaces.Publicador;
import model.interfaces.Sensor;

public class BlocoUAI implements Publicador {

    private Set<Sensor> sensores;
    private Set<Docente> docentes = new HashSet<Docente>();

    public BlocoUAI(Set<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void setDocentes (Set<Docente> docentes) {
        this.docentes = docentes;
    }

    public void docenteEntrada(Docente docente) {
        if (!this.checkHasDocentesPresentes()) {
            System.out.println("Aparelhos ligados!");
        }
        this.docentes.add(docente);
        this.notifySubscribers();
    }

    public void docenteSaida(Docente docente) {
        this.docentes.remove(docente);
        this.notifySubscribers();
        if (!this.checkHasDocentesPresentes()) {
            System.out.println("Aparelhos desligados! Não há mais docentes no bloco.");
        }
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
            sensor.update(this.checkHasDocentesPresentes());
        }
    }

    private boolean checkHasDocentesPresentes() {
        return docentes.size() > 0;
    }

}
