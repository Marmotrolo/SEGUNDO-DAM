package boletin1;


import java.io.IOException;

public class AbrirCMD {
    public static void main(String[] args) {

        String[] comando = {
            "cmd.exe","/c", "start","cmd.exe","/k","tasklist"
        };

        ProcessBuilder pb = new ProcessBuilder(comando);

        try {
            Process p = pb.start();
        } catch (IOException e) {
            System.out.println(e);
        }
        finally {
        	System.out.println("Proceso terminado");
        }
    }
}

