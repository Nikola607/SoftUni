package personal.project.two_vago.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import personal.project.two_vago.models.entities.view.StatsView;
import personal.project.two_vago.service.StatsService;

@Component
public class StatsServiceImpl implements StatsService {
    private int anonymousRequests, authRequests;

    @Override
    public void onRequest() {
        Authentication authentication = SecurityContextHolder.
                getContext().
                getAuthentication();



        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authRequests++;
        } else {
            anonymousRequests++;
        }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(authRequests, anonymousRequests);
    }
}
