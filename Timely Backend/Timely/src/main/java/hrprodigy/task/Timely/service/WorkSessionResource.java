package hrprodigy.task.Timely.service;


import hrprodigy.task.Timely.model.WorkSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sessions")
public class WorkSessionResource {
    private final WorkSessionService sessionService;

    public WorkSessionResource(WorkSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public ResponseEntity<List<WorkSession>> getAllSessions (){
        List<WorkSession> sessions = sessionService.showAllSessions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkSession> addSession(){
        WorkSession session = sessionService.addWorkSession();
        return new ResponseEntity<>(session, HttpStatus.CREATED);

    }
    @PostMapping("/update")
    public ResponseEntity<WorkSession> updateSession(String projectName){
        WorkSession session = sessionService.updateSession(projectName);
        return new ResponseEntity<>(session, HttpStatus.CREATED);

    }

}
