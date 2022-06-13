package tasks;

public class MySqlRepository implements TaskRepository {

    public void save(Task task){
        System.out.println("La tarea s'ha guardat a SQL:" + task.getTitle());
    }
}
