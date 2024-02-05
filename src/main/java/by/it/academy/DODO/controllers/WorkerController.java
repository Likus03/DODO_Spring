package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.services.worker.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class WorkerController {
    private final WorkerService workerService;

    @GetMapping("workers/{param}")
    public List<WorkerDTO> getWorkersByParameter(@PathVariable String param) {
        return workerService.readBySearch(param);
    }

    @PatchMapping("worker/{id}")
    public boolean updateWorker(@PathVariable UUID id, @RequestBody WorkerDTO request) {
        if (workerService.findById(id) != null) {
            return workerService.update(id, request);
        }
        return false;
    }
}
