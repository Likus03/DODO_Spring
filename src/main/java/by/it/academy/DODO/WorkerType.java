package by.it.academy.DODO;

import com.fasterxml.jackson.annotation.JsonProperty;

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
