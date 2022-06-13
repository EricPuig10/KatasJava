package tasks;

public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

     public void saveTask(String title){
         Task task = new Task(title);
         this.repository.save(task);


         //new tarea
         //guardar a base de dades falsa
         // notificar x diferents llocs

         //Alta cohesió + baix acoplament (dev sobre contractes)
    }
}
