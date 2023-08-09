import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Canvas {
    public int taskCount = 0 ;
    List<Task> taskList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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

    public void terminalAdicionarTask(){
        System.out.println("Digite o nome da Task:");
        String nomeTask = this.scanner.nextLine();
        
        System.out.println("Digite a Descricao:");
        String Descricao = this.scanner.nextLine();
        
        System.out.print("Data Limite para entrega (formato yyyy-MM-dd HH:mm:ss): ");
        String dataUsuario = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //Modifica o formado da data.
        LocalDateTime dataObjeto = LocalDateTime.parse(dataUsuario, dateTimeFormatter);                     //Cria um objeto data.

        Task novaTask = new Task(nomeTask, Descricao, dataObjeto, "Vou Fazer");

        this.adicionarTask(novaTask);


    }

}
