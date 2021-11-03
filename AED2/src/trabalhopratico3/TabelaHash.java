package trabalhopratico3;

public class TabelaHash {
    private NoArvore[] tabela;
    private int tamanho;

    public TabelaHash(int maxTam) {
        this.tabela = new NoArvore[3];
        this.tamanho = 0;
    }

    public NoArvore[] getTabela() {
        return tabela;
    }

    public int tamanho() {
        return tamanho;
    }

    private int funcaoHash(int chave) {
        return (int) (Math.floor(this.tamanho() * (chave * 0.567 % 1)));
    }

    public NoArvore busca(int chave) {
        int index = funcaoHash(chave);
        int i = 0;

        while (this.getTabela()[i] != null && this.getTabela()[index].getChave() != chave && i < this.getTabela().length) {
            i++;
            index = (index + 1);
        }
        NoArvore result = this.getTabela()[index];

        if (result != null && result.getChave() == chave) {
            return result;
        }
        return null;
    }

    public boolean insere(int chave, Object valor) {
        int index = funcaoHash(chave);
        NoArvore noAtual = this.tabela[index];
        boolean exists = false;
        while (noAtual != null && noAtual.getChave() != chave){
            if(chave < noAtual.getChave()){
                noAtual = noAtual.getEsquerda();
            } else {
                noAtual = noAtual.getDireita();
            }
        }

        if (noAtual == null){
            noAtual.setPai();
        }




    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.tabela.length; i++) {
            result = result.concat(String.format("Posição %d da tabela:\n", i));
            result = result.concat(this.caminhaIdentado(this.getTabela()[i], 0));
        }
        return result;
    }

    public String caminhaIdentado(NoArvore subArvore, int indentacao) {
        String result = "";
        if (subArvore == null || this.tamanho() == 0) {
            return "";
        }
        for (int i = 0; i < indentacao; i++) {
            result = result.concat(" ");
        }
        result = result.concat(subArvore.toString()).concat("\n");

        result = result.concat(this.caminhaIdentado(subArvore.getEsquerda(), indentacao + 1));
        result = result.concat(this.caminhaIdentado(subArvore.getDireita(), indentacao + 1));
        return result;
    }
}
