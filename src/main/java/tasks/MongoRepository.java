package tasks;

public class MongoRepository implements TaskRepository{

    @Override
    public void save(Task task) {
        System.out.println("La tarea s'ha guardat a MongoDb:" + task.getTitle());
    }
}
