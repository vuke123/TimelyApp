package hrprodigy.task.Timely.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
//@Table(name="work_sessions")
//@CrossOrigin
public class WorkSession implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private LocalDateTime start;
    private LocalDateTime stop;
    private String duration;
    private String project;

    public WorkSession(){}

    public WorkSession(LocalDateTime start) {
        this.start = start;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
