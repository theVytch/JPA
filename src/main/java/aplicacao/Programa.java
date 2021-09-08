package aplicacao;

import dominio.ComandoBanco;
import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class Programa {

    public static void main(String[] args) {
        ComandoBanco cb = new ComandoBanco();
        for (int i = 8 ; i <=10; i++){
            cb.apagarNoBanco(i);
        }

    }
}
