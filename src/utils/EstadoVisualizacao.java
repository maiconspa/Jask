package utils;

public enum EstadoVisualizacao {

	enviado(1), recebido(2), visualizado(3);
	
	public int estadoVisualizacao;
	EstadoVisualizacao (int estadoVisualizacao) {
		this.estadoVisualizacao = estadoVisualizacao;
	}
	
}
