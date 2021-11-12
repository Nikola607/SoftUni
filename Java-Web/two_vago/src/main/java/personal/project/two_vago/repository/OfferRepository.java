package personal.project.two_vago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.project.two_vago.models.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
