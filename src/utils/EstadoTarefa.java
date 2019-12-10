package utils;

public enum EstadoTarefa {

	Pendente(1), Realizando(2), Finalizado(3);
	
	public int estadoTarefa;
	EstadoTarefa (int estadoTarefa) {
		this.estadoTarefa = estadoTarefa;
	}
	
}
