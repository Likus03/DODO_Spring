package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
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
    public List<WorkerRequestDTO> getWorkersByParameter(@PathVariable String param) {
        return workerService.readBySearch(param);
    }

    @PatchMapping("worker/{id}")
    public boolean updateWorker(@PathVariable UUID id, @RequestBody WorkerRequestDTO request) {
        if (workerService.findById(id) != null) {
            return workerService.update(id, request);
        }
        return false;
    }
}
