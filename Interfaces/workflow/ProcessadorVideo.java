import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {

	private List<CanalNotificacao> canais;
	
	
	
	public ProcessadorVideo() {
		super();
		
		canais = new ArrayList<>();
	}

	public void registrarCanal (CanalNotificacao canal) {
		canais.add(canal);
	}
	
	public void processar(Video video) {
		for (CanalNotificacao canalNotificacao : canais) {
			Mensagem m = new Mensagem(String.format("%s - %s",video.getNome(), video.getFormato()), TipoMensagem.LOG);
			canalNotificacao.notificar(m);
		}
	}
}
