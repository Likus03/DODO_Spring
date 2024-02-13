package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.services.worker.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class WorkerController {
    private final WorkerService workerService;

    @GetMapping("workers/{parameter}")
    public List<WorkerRequestDTO> getByParameter(@PathVariable String parameter) {
        return workerService.getWorkersByParameter(parameter);
    }

    @PatchMapping("worker/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody WorkerRequestDTO workerRequestDTO) {
        return workerService.updateWorker(id, workerRequestDTO);
    }
}
