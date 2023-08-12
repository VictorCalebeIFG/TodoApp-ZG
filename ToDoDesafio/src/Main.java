

public class Main {
    public static void main(String[] args) {
        Canvas MyCanvas = new Canvas();

        Alarme alarme = new Alarme();
        alarme.playing = true;

        //Criando uma Thread para rodar o Alarme.
        Thread alarmeThread = new Thread(()->{
            alarme.iniciaAlarme(MyCanvas);
        });

        // Crindo uma Thread para rodar a interface de Usuário.
        Thread terminalInterfaceThread = new Thread(()->{
            MyCanvas.terminalComandos();
        });
        
        alarmeThread.start();

        terminalInterfaceThread.start();

    }
}