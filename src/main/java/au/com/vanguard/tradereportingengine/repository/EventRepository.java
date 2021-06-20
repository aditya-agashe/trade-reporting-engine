package au.com.vanguard.tradereportingengine.repository;

import au.com.vanguard.tradereportingengine.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
