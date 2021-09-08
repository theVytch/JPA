package dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComandoBanco {

    public ComandoBanco(){}

    public void salvarInformacaoBanco(){
    // Iniciando o JPA manualmente;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

    //   -----------informacoes salvas no banco de dados -----------------------
        Pessoa p1 = new Pessoa(null, "Eduardo", "edu@gmail.com");
        Pessoa p2 = new Pessoa(null, "Borel", "Borel@gmail.com");
        Pessoa p3 = new Pessoa(null, "Igor", "Igor@gmail.com");

    //  ----------- comando para salvar no banco -----------------------
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

    public void buscarNoBanco( Integer ID){
    // ----------- Iniciando o JPA manualmente;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
    //  ---------- comando para buscar no banco -----------------------
        Pessoa p = em.find(Pessoa.class, ID);
        System.out.println(p);

        em.close();
        emf.close();
    }

    public void apagarNoBanco(Integer ID){
        // ----------- Iniciando o JPA manualmente;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // ---------- comando para remover no banco -----------------------
        // ---------- ele só vai excluir quando fizer uma buscar, transactio, remove e commit -------
                Pessoa p = em.find(Pessoa.class, ID);
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
        // ----------- Sempre que for uma operação que não é uma simples consulta precisa colocar uma transação -----------
    }

}
