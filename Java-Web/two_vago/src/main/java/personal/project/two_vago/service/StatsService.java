package personal.project.two_vago.service;

import org.springframework.stereotype.Service;
import personal.project.two_vago.models.entities.view.StatsView;

@Service
public interface StatsService {
    void onRequest();
    StatsView getStats();
}
