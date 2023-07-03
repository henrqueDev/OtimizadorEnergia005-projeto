package db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import model.Docente;
import model.eletronico.ArCondicionado;
import model.eletronico.Lampada;
import model.interfaces.Sensor;

public final class Database {
    private Set<Docente> docentes;
    private Set<Sensor> sensores;

    public Database() {
        this.docentes = new HashSet<Docente>(
                new ArrayList<>(Arrays.asList(
                        new Docente(
                                111,
                                "Sion"
                            ),
                        new Docente(
                                222,
                                "Jão"
                            ),
                        new Docente(
                                333,
                                "Chico Melancia"
                            ),
                        new Docente(
                                444,
                                "Carla"
                            ),
                        new Docente(
                                555,
                                "Fabiana"
                            )
                        )));

        this.sensores = new HashSet<Sensor>(
            new ArrayList<>(Arrays.asList(
                new ArCondicionado(
                    1,
                    15
                    ),
                new ArCondicionado(
                    2,
                    19
                    ),
                new Lampada(1),
                new Lampada(1)

            ))
        );

    }

    public Set<Docente> getAllDocentes() {
        return this.docentes;
    }

    public Set<Sensor> getAllSensors() {
        return this.sensores;
    }

}
