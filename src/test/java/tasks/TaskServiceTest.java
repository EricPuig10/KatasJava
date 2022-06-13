package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void saveTaskTest() {
        var taskService = new TaskService(new MySqlRepository());
        taskService.saveTask("tarea 1");
    }
}