package br.com.healthflow.dominio;

public class Sintoma implements Comparable<Sintoma> {

    private Long id;

    private String nomeSintoma;

    public Sintoma() {
    }

    public Sintoma(String nomeSintoma) {
        this.nomeSintoma = nomeSintoma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSintoma() {
        return nomeSintoma;
    }

    public void setNomeSintoma(String nomeSintoma) {
        this.nomeSintoma = nomeSintoma;
    }

    @Override
    public int compareTo(Sintoma o) {
        return nomeSintoma.compareTo(o.getNomeSintoma());
    }
}
