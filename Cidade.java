public enum Cidade {
    BELO_HORIZONTE("Belo Horizonte", "13"),
    FORTALEZA("Fortaleza", "20"),
    RECIFE("Recife", "50"),
    JOAO_PESSOA("João Pessoa", "42"),
    SAO_LUIS("São Luís", "35"),
    NATAL("Natal", "61");

    private final String nome;
    private final String codigo;

    private Cidade(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}