import java.time.Duration;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Alarme {

    boolean playing = false;

    public long getTempoRestante(LocalDateTime target){
        LocalDateTime tempoAgora = LocalDateTime.now();
        Duration duration = Duration.between(tempoAgora, target);
        long horasRestantes = duration.toSeconds();
        return horasRestantes;
    }

    public boolean isTaskFinalizada(Task task){
        boolean resposta = (getTempoRestante(task.dataLimite) <=0) ? true : false ;
        return resposta;
    }

    public void mostrar_aviso(String mensagem){
        System.out.println(mensagem);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        JOptionPane.showMessageDialog(frame, mensagem, "AVISO", JOptionPane.WARNING_MESSAGE);
    }

    public void iniciaAlarme(Canvas canvas){
        while(this.playing){
            synchronized (canvas.taskList){
                if (!canvas.taskList.isEmpty()){
                    try {
                        for (Task task : canvas.taskList) {
                            if(task.alarme == true && isTaskFinalizada(task)){
                                mostrar_aviso(String.format("A task [%s] terminou seu limite de tempo.",task.nome));
                                task.alarme = false;
                            }
                    }
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    
                    
                }
                
            }
            
        }
    }


    
}
