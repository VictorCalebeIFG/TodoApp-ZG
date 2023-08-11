import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveSystem {

    public static void salvarCanvas(Canvas canvas, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(canvas);
            System.out.println("Salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Canvas carregarCanvas(String fileName) {
        Canvas canvas = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            canvas = (Canvas) inputStream.readObject();
            System.out.println("Carregado com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return canvas;
    }

    
}
