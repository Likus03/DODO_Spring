package by.it.academy.DODO;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Enumeration representing different types of workers.
 */
public enum WorkerType {
    @JsonProperty("ADMIN")
    ADMIN,
    @JsonProperty("MANAGER")
    MANAGER,
    @JsonProperty("COURIER")
    COURIER,
    @JsonProperty("KITCHEN_WORKER")
    KITCHEN_WORKER;

    WorkerType() {
    }
}
