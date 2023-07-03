import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import bloco.BlocoUAI;
import db.Database;
import model.Docente;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Selecione a Opção de teste:\n1-Bloco vazio e docentes entram\n2-Bloco cheio e docentes saem do bloco\n3-Entram e saem docentes do bloco");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        try {
            int value = Integer.parseInt(answer);
            System.out.println("\n");
            doTest(value);
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas Números!");
            return;
        }

    }

    private static void doTest(int value) {
        Database db = new Database();
        Set<Docente> docentes = db.getAllDocentes();
        BlocoUAI bloco = new BlocoUAI(db.getAllSensors());

        switch (value) {
            case 1:
                for (Docente docente : docentes) {
                    bloco.docenteEntrada(docente);
                }
                ;
                break;
            case 2:
                // Seta os docentes para não disparar o notify para ligar os aparelhos
                bloco.setDocentes(docentes);

                for (Docente docente : new ArrayList<Docente>(docentes)) {
                    bloco.docenteSaida(docente);
                }
                ;
                break;
            case 3:
                System.out.println("Docentes entram em bloco vazio:");
                for (Docente docente : docentes) {
                    bloco.docenteEntrada(docente);
                }
                ;
                System.out.println("\n");
                System.out.println("Todos os docentes saem do bloco.");
                for (Docente docente : docentes) {
                    bloco.docenteSaida(docente);
                }
                ;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
