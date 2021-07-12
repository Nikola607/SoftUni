import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("table_wizards_deposits")
                .createEntityManager();

        em.getTransaction().begin();

        Product product = new Product();

        product.setName("Test_Product");
        product.setPrice(BigDecimal.TEN);
        product.setQuantity(5);

        em.getTransaction().commit();
    }
}
