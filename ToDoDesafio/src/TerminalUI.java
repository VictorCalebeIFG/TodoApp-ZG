import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TerminalUI {

    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);

    String nomeTask ;
    String categoria;
    String descricao;
    
    int prioridade = 0;
    LocalDateTime dia = LocalDateTime.now();

    boolean alarme = false;
    
    /**
     * Inicia a interface de usuário onde será feita as adições de uma task
     */
    public void adicionarTaksUI(){
        
        System.out.println("\nDigite o nome da Task:");
        this.nomeTask = this.scanner2.nextLine();

        System.out.println("Digite a categoria da task:");
        this.categoria = this.scanner2.nextLine();

        System.out.println("Digite a Descricao:");
        this.descricao = this.scanner2.nextLine();
        
        while(prioridade <1 || prioridade>5){
            System.out.println("Digite a prioridade da task (deve estar entre 1 e 5):");
            prioridade = this.scanner1.nextInt();
        }
        
        System.out.print("Data Limite para entrega (formato yyyy-MM-dd HH:mm:ss): ");
        String dataUsuario = scanner2.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //Modifica o formado da data.
        this.dia = LocalDateTime.parse(dataUsuario, dateTimeFormatter);                     //Cria um objeto data.

        System.out.print("Gostaria de acionar o alarme ? (sim/nao)");
        String querAlarme = scanner2.nextLine();
        this.alarme = (querAlarme.equals("sim")) ? true : false;

    }

    /**
     * Inicia a interface de usuário pela qual será feita a interação com as tasks.
     * @param canvas
     */
    public void terminalComandosUI(Canvas canvas){
        System.out.println("O que deseja Fazer ?\n\n{1}-\t\tMostrar Tasks\t\t\t{2}-\t\tAdicionar Task\n{3}-\t\tRemover Task\t\t\t{4}-\t\tMudar Estado \n{12}-\t\tFiltrar por pioridade\t\t{13}-\t\tFiltrar por categoria\n{save}-\t\tSalvar tasks\t\t\t{load}-\t\tCarregar arquivo.\n{14}-\t\tFiltrar por status\t\t{77}-\t\tSair\n");
        boolean loop = true;

        while(loop){

            String comando = this.scanner1.nextLine();

            switch (comando) {
                case "1":
                    if (canvas.taskList.size() == 0){
                        System.out.println("Sua lista está vazia digite {2} para adicionar algo");
                    }
                    else{
                        canvas.mostrarPrioridade(5);
                        canvas.mostrarPrioridade(4);
                        canvas.mostrarPrioridade(3);
                        canvas.mostrarPrioridade(2);
                        canvas.mostrarPrioridade(1);
                    }
                    
                    break;
                case "2":
                    canvas.terminalAdicionarTask();
                    break;
                case "3":
                    System.out.println("Digite o ID da task que deseja remover:");
                    int remove = this.scanner2.nextInt();
                    canvas.removerTask(remove);
                    break;
                case "4":
                    System.out.println("Digite qual task (ID) você quer mudar o estado.");
                    int idEstado = this.scanner2.nextInt();
                    System.out.println("Digite o novo estado.");
                    String estado = this.scanner1.nextLine();
                    canvas.mudarEstadoTask(idEstado, estado);
                    break;
                case "12":
                    System.out.println("Digite qual prioridae quer mostrar:");
                    int prioridade = this.scanner2.nextInt();
                    canvas.mostrarPrioridade(prioridade);
                    break;
                case "13":
                    System.out.println("Digite qual categoria quer mostrar:");
                    String categoria = this.scanner1.nextLine();
                    canvas.mostrarCategoria(categoria);
                    break;
                case "14":
                    System.out.println("Digite qual status quer mostrar:");
                    String status = this.scanner1.nextLine();
                    canvas.mostrarStatus(status);      
                    break;
                case "save":
                    SaveSystem.salvarCanvas(canvas, "canvas.save");
                    break;
                case "load":
                    Canvas loadCanvas = SaveSystem.carregarCanvas("canvas.save"); 
                    canvas.taskList = loadCanvas.taskList;
                    canvas.taskCount = loadCanvas.taskCount;
                    break;
                case "77":
                    loop = false;
            }
        }
    } 
    
    
    
    
    
    public String getCategoria() {
        return categoria;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getDia() {
        return dia;
    }
    public String getNomeTask() {
        return nomeTask;
    }
    public int getPrioridade() {
        return prioridade;
    }

    public boolean getAlarme() {
        return this.alarme;
    }

}
