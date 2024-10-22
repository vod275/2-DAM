package Tema1;

import java.io.IOException;
import java.util.List;

public class HijoPipe {

	  private List<String> comando;

	    public HijoPipe(List<String> comando) {
	        this.comando = comando;
	    }
	    
	    public Process iniciarProceso() throws IOException {
	        ProcessBuilder pb = new ProcessBuilder(comando);
	        return pb.start();
	    }

}
