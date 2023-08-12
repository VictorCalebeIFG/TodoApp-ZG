import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Canvas implements Serializable{
    public int taskCount = 0 ;
    List<Task> taskList = new ArrayList<>();
    
    transient Scanner  scanner = new Scanner(System.in);
    transient Scanner  scanner2 = new Scanner(System.in);

    /**
     * Recebe um objeto do tipo task e adiciona na lista do canvas.
     */
    public void adicionarTask(Task task){
        this.taskList.add(task);
        task.id = this.taskCount;
        taskCount +=1;
    }

    /**
     * Recebe um valor inteiro e remove o item na posição recebida.
     * @param idTask
     */
    public void removerTask(int idTask){
        Iterator<Task> iterator = this.taskList.iterator();
        
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.id == idTask) {
                iterator.remove(); // Remove o elemento atual de forma segura
            }
        }
    }

    /**
     * Muda o estado de uma task. Recebe o ID da task e o novo estado.
     * @param idTask
     * @param estado
     */
    public void mudarEstadoTask(int idTask, String estado){
        for (Task task:this.taskList){
            if(task.id == idTask){
                task.setEstado(estado);
            }
        }
    }
    /**
        Recebe uma task e mostra seus intens de forma formatada.
        @param
    */
    public void mostrarTask(Task task){
        System.out.printf("Tarefa: %s - iD:{%s} - Prioridade: %d - Categoria: %s - estado:%s - DataLimite:%s \nDescricao: %s  \n\n",
                                task.nome,
                                task.id,
                                task.prioridade,
                                task.categoria,
                                task.estado,
                                task.dataLimite,
                                task.descricao
                        );
    
    }

    /**
     * Mostra somente as task com a prioridade escolhida.
     * @param prioridade
     */
    public void mostrarPrioridade(int prioridade){
        for (Task task : taskList) {
            if(task.prioridade == prioridade){
                mostrarTask(task);
            }
        }
    }

    /**
     * Mostra as taks filtradas por categoria.
     * @param categoria
     */

    public void mostrarCategoria(String categoria){
        for (Task task : taskList) {
            if(task.categoria.equals(categoria)){
                mostrarTask(task);
            }
        }
    }

    /**
     * Mostra as tasks filtradas por status.
     * @param status
     * 
     */
    public void mostrarStatus(String status){
        for (Task task : taskList) {
            if(task.estado.equals(status)){
                mostrarTask(task);
            }
        }
    }
    
    /**
     * Cria uma interface de usuário via termial que pede e adiciona uma task ao canvas.taksList.
     * @param null
     */
    public void terminalAdicionarTask(){
        
        TerminalUI terminalUI = new TerminalUI();

        terminalUI.adicionarTaksUI();

        Task novaTask = new Task(terminalUI.getNomeTask(),
                                terminalUI.getDescricao(),
                                terminalUI.getDia(),
                                "Todo",
                                terminalUI.getPrioridade(),
                                terminalUI.getCategoria());

        novaTask.alarme = terminalUI.alarme;

        this.adicionarTask(novaTask);

        System.out.println("\nTask Adicionada !\n");


    }
    
    /**
     * Inicia a interface de usuário via terminal. É através dessa função que o usuário interage com a aplicação.
     * @VictorCalebeIFG
     */
    public void terminalComandos(){
        TerminalUI interfaceUsuario = new TerminalUI();
        interfaceUsuario.terminalComandosUI(this);
    }   

}
