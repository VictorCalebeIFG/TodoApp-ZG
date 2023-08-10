import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Canvas {
    public int taskCount = 0 ;
    List<Task> taskList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);

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
        int count = 0;
        for (Task task:this.taskList){
            if(task.id == idTask){
                this.taskList.remove(count);
            }
            count +=1 ;
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
    
    // Atua na interface de usuário.
    public void terminalAdicionarTask(){
        int prioridade = 0;

        System.out.println("\nDigite o nome da Task:");
        String nomeTask = this.scanner.nextLine();

        System.out.println("Digite a categoria da task:");
        String categoria = this.scanner.nextLine();

        System.out.println("Digite a Descricao:");
        String Descricao = this.scanner.nextLine();
        
        while(prioridade <1 || prioridade>5){
            System.out.println("Digite a prioridade da task (deve estar entre 1 e 5):");
            prioridade = this.scanner2.nextInt();
        }
        
        System.out.print("Data Limite para entrega (formato yyyy-MM-dd HH:mm:ss): ");
        String dataUsuario = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //Modifica o formado da data.
        LocalDateTime dataObjeto = LocalDateTime.parse(dataUsuario, dateTimeFormatter);                     //Cria um objeto data.

        
        Task novaTask = new Task(nomeTask, Descricao, dataObjeto, "Vou Fazer",prioridade,categoria);

        this.adicionarTask(novaTask);

        System.out.println("\nTask Adicionada !\n");


    }

    public void terminalComandos(){
        System.out.println("O que deseja Fazer ?\n{1}-\tMostrar Tasks\n{2}-\tAdicionar Task\n{3}-\tRemover Task\n{4}-\tMudar Estado \n{12}-\tFiltrar por pioridade\n{13}-\tFiltrar por categoria\n{14}-\tFiltrar por status\n{77}-\tSair\n");
        boolean loop = true;

        while(loop){

        
            String comando = this.scanner.nextLine();

            switch (comando) {
                case "1":
                    mostrarPrioridade(5);
                    mostrarPrioridade(4);
                    mostrarPrioridade(3);
                    mostrarPrioridade(2);
                    mostrarPrioridade(1);
                    break;
                case "2":
                    terminalAdicionarTask();
                    break;
                case "3":
                    System.out.println("Digite o ID da task que deseja remover:");
                    int remove = this.scanner2.nextInt();
                    this.removerTask(remove);
                    break;
                case "4":
                    System.out.println("Digite qual task você quer mudar o estado.");
                    int idEstado = this.scanner2.nextInt();
                    System.out.println("Digite o novo estado.");
                    String estado = this.scanner.nextLine();
                    this.mudarEstadoTask(idEstado, estado);
                    break;
                case "12":
                    System.out.println("Digite qual prioridae quer mostrar:");
                    int prioridade = this.scanner2.nextInt();
                    this.mostrarPrioridade(prioridade);
                    break;
                case "13":
                    System.out.println("Digite qual categoria quer mostrar:");
                    String categoria = this.scanner.nextLine();
                    this.mostrarCategoria(categoria);
                    break;
                case "14":
                    System.out.println("Digite qual status quer mostrar:");
                    String status = this.scanner.nextLine();
                    this.mostrarStatus(status);      

                case "77":
                    loop = false;
            }
        }
    }   

}
