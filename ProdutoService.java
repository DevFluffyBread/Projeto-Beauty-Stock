import java.util.List;

/**
 * Gerencia o cadastro e a manutenção dos produtos em estoque.
 */
public class ProdutoService {
    private final ProdutoRepository produtoRepository = new ProdutoRepository();

    public void cadastrarProduto(Produto produto) {
        produtoRepository.adicionarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.listarProdutos();
    }

    public List<Produto> buscarProduto(String nome) {
        return produtoRepository.buscarProdutosPorNome(nome);
    }

    public List<Produto> filtrarPorCategoria(String categoria) {
        return produtoRepository.buscarProdutosPorCategoria(categoria);
    }

    public boolean editarProduto(String nomeAtual, Produto dadosAtualizados) {
        return produtoRepository.editarProduto(nomeAtual, dadosAtualizados);
    }

    public boolean excluirProduto(String nome) {
        return produtoRepository.excluirProduto(nome);
    }
}
