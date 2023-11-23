package br.com.healthflow.dominio;

public class Paciente implements Comparable<Paciente>{

    private int idPaciente;
    private String nome;
    private int cpf;
    private String rg;
    private String telefone;
    private String endereco;
    private String email;
    private String sexo;
    private String tipoSangue;
    private double altura;
    private double peso;
    private String escolaridade;
	
	public Paciente() {
	}

    public Paciente(int idPaciente, String nome, String rg, int cpf, String endereco, String email, String telefone, String sexo, String tipoSangue, String escolaridade) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.sexo = sexo;
        this.tipoSangue = tipoSangue;
        this.escolaridade = escolaridade;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }


	@Override
	public int compareTo(Paciente o) {
		return nome.compareTo(o.getNome());
	}

}
