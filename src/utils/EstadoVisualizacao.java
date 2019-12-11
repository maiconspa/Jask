package utils;

public enum EstadoVisualizacao{

	Enviado(1), Recebido(2), Visualizado(3);
	
	public int estadoVisualizacao;
	EstadoVisualizacao (int estadoVisualizacao) {
		this.estadoVisualizacao = estadoVisualizacao;
	}
	
}
