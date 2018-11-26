package br.senai.sp.cfp127.model;

public class Compromisso {
	private String titulo;
	private String descricao;
	private String data;
	private String horaInicio;
	private String horaFim;
	private int cod_compromisso;
	private Usuario usuario;
	private int prioridade;
	private int status;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String dataFim) {
		this.horaFim = dataFim;
	}

	public int getCod_compromisso() {
		return cod_compromisso;
	}

	public void setCod_compromisso(int cod_compromisso) {
		this.cod_compromisso = cod_compromisso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraInicio() {
		return horaInicio;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
