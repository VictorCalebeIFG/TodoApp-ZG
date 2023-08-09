import java.util.List;
import java.util.ArrayList;

public class Canvas {
    public int taskCount = 0 ;
    List<Task> taskList = new ArrayList<>();

    public void adicionarTask(Task task){
        this.taskList.add(task);
        task.id = this.taskCount+"";
        taskCount +=1;
    }

    public void removerTask(String idTask){
        for (Task task : this.taskList) {
            if(task.id == idTask){
                this.taskList.remove(task);
            }
        }
    }

    public void mostrarTask(){
        for (Task task : this.taskList) {
            System.out.printf("Tarefa: %s - iD:{%s}\nDescricao: %s \n ",task.nome,task.id);
        }
    }

}
