import java.util.List;
import java.util.ArrayList;

public class Canvas {
    public int taskCount = 0 ;
    List<Task> taskList = new ArrayList<>();

    public void adicionarTask(Task task){
        this.taskList.add(task);
        task.id = this.taskCount;
        taskCount +=1;
    }

    public void removerTask(int idTask){
        int count = 0;
        for (Task task:this.taskList){
            System.out.println(task.id == idTask);
            if(task.id == idTask){
                this.taskList.remove(count);
            }
            count +=1 ;
        }
    }

    public void mostrarTask(){
        for (Task task : this.taskList) {
            System.out.printf("Tarefa: %s - iD:{%s} - estado:%s -DataLimite:%s \nDescricao: %s  \n\n",task.nome,task.id,task.estado,task.dataLimite,task.descricao);
        }
    }

}
