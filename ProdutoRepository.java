import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public List<Produto> buscarProdutosPorNome(String nome) {
        List<Produto> resultado = new ArrayList<>();

        if (nome == null || nome.trim().isEmpty()) {
            return resultado;
        }

        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(produto);
            }
        }

        return resultado;
    }

    public List<Produto> buscarProdutosPorCategoria(String categoria) {
        List<Produto> resultado = new ArrayList<>();

        if (categoria == null || categoria.trim().isEmpty()) {
            return resultado;
        }

        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(produto);
            }
        }

        return resultado;
    }

    public boolean editarProduto(String nomeAtual, Produto dadosAtualizados) {
        Produto produto = encontrarPorNomeExato(nomeAtual);

        if (produto == null || dadosAtualizados == null) {
            return false;
        }

        produto.setNome(dadosAtualizados.getNome());
        produto.setMarca(dadosAtualizados.getMarca());
        produto.setCategoria(dadosAtualizados.getCategoria());
        produto.setSubcategoria(dadosAtualizados.getSubcategoria());
        produto.setPreco(dadosAtualizados.getPreco());
        produto.setDataCompra(dadosAtualizados.getDataCompra());
        produto.setQuantidade(dadosAtualizados.getQuantidade());
        produto.setDataValidade(dadosAtualizados.getDataValidade());
        produto.setObservacoes(dadosAtualizados.getObservacoes());
        return true;
    }

    public boolean excluirProduto(String nome) {
        Produto produto = encontrarPorNomeExato(nome);

        if (produto == null) {
            return false;
        }

        produtos.remove(produto);
        return true;
    }

    private Produto encontrarPorNomeExato(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}
