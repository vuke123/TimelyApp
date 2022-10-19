package hrprodigy.task.Timely.repo;

import hrprodigy.task.Timely.model.WorkSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface WorkSessionRepo extends JpaRepository<WorkSession, LocalDateTime> {
}
