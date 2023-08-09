import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Canvas MyCanvas = new Canvas();
        
        Task myTask1 = new Task("MyTask1", "MyDesc1", LocalDateTime.now(), "Vou Fazer1");
        Task myTask2 = new Task("MyTask2", "MyDesc2", LocalDateTime.now(), "Vou Fazer2");
        Task myTask3 = new Task("MyTask3", "MyDesc3", LocalDateTime.now(), "Vou Fazer3");
        
        MyCanvas.adicionarTask(myTask1);
        MyCanvas.adicionarTask(myTask2);
        MyCanvas.adicionarTask(myTask3);
        
        MyCanvas.terminalAdicionarTask();

        //MyCanvas.mostrarTask();
        MyCanvas.mostrarTask();
    }
}