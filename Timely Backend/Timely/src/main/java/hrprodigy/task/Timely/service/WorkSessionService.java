package hrprodigy.task.Timely.service;

import hrprodigy.task.Timely.model.WorkSession;
import hrprodigy.task.Timely.repo.WorkSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;


@Service
public class WorkSessionService {
    @Autowired
    private final WorkSessionRepo worksessionrepo;

    public WorkSessionService(WorkSessionRepo worksessionrepo) {
        this.worksessionrepo = worksessionrepo;
    }

    public WorkSession addWorkSession(){
        WorkSession session = new WorkSession(LocalDateTime.now());
        return worksessionrepo.save(session);
    }

    public WorkSession updateSession(String projectName){
        System.out.println(projectName);
        WorkSession workSession = null;
        List<WorkSession> allSessions = worksessionrepo.findAll();
        for(WorkSession session: allSessions){
            if(session.getProject() == null) {
                workSession = session;
                continue;
            }
        }
        LocalDateTime start = workSession.getStart();
        workSession.setStop(LocalDateTime.now());
        workSession.setProject(projectName);

        Period period = Period.between(workSession.getStart().toLocalDate(), LocalDateTime.now().toLocalDate());
        String durationString = "";
        Duration duration = Duration.between(workSession.getStart().toLocalTime(), LocalDateTime.now().toLocalTime());
        long seconds = duration.getSeconds();
        long hours = seconds/3600;
        long leftSeconds = seconds%3600;
        long minutes = leftSeconds/60;
        seconds = leftSeconds%60;

        durationString = String.valueOf(period.getDays()) + " days "
        + String.valueOf(hours) + " hours " + String.valueOf(minutes) + " minutes";
        workSession.setDuration(durationString);
        worksessionrepo.deleteById(start);
        System.out.println(workSession.getDuration() + " --- duration");
        System.out.println(workSession.getStop() + " --- stop");
        return worksessionrepo.save(workSession);
    }


    public List<WorkSession> showAllSessions(){
        return worksessionrepo.findAll();
    }

}
