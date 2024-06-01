import java.util.ArrayList;
import java.util.List;

public class MeuHashMap<K, V> {
    private static final int CAPACIDADE_PADRAO = 16; // Capacidade inicial do array
    private List<Node<K, V>>[] tabela;
    private int tamanho; // Número de elementos no mapa

    public MeuHashMap() {
        this.tabela = new ArrayList[CAPACIDADE_PADRAO];
        this.tamanho = 0;
    }

    public void inserir(K chave, V valor) {
        if (chave == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        int indice = hash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = new ArrayList<>();
        }

        // Verifica se a chave já existe na lista vinculada ao índice
        for (Node<K, V> node : tabela[indice]) {
            if (node.chave.equals(chave)) {
                throw new IllegalArgumentException("Chave duplicada: " + chave);
            }
        }

        // Se a chave não existe, adiciona uma nova entrada
        tabela[indice].add(new Node<>(chave, valor));
        tamanho++;
    }

    public V recuperar(K chave) {
        if (chave == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        int indice = hash(chave);
        List<Node<K, V>> lista = tabela[indice];
        if (lista != null) {
            for (Node<K, V> node : lista) {
                if (node.chave.equals(chave)) {
                    return node.valor;
                }
            }
        }
        return null; // Chave não encontrada
    }

    public void remover(K chave) {
        if (chave == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        int indice = hash(chave);
        List<Node<K, V>> lista = tabela[indice];
        if (lista != null) {
            lista.removeIf(node -> node.chave.equals(chave));
            tamanho--;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    // Retorna uma lista de todas as chaves presentes no mapa
    public List<K> chaves() {
        List<K> chaves = new ArrayList<>();
        for (List<Node<K, V>> lista : tabela) {
            if (lista != null) {
                for (Node<K, V> node : lista) {
                    chaves.add(node.chave);
                }
            }
        }
        return chaves;
    }

    private int hash(K chave) {
        // Uma função de hash simples apenas para demonstração
        return Math.abs(chave.hashCode()) % CAPACIDADE_PADRAO;
    }

    private static class Node<K, V> {
        K chave;
        V valor;

        public Node(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
}
