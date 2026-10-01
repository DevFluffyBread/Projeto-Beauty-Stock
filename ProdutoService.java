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

    public List<Produto> buscarProduto(UUID uuid) {
        return produtoRepository.buscarProdutosPorUUID(uuid);
    }

    public List<Produto> filtrarPorCategoria(String categoria) {
        return produtoRepository.buscarProdutosPorCategoria(categoria);
    }

    public boolean editarProduto(UUID uuid, Produto dadosAtualizados) {
        return produtoRepository.editarProduto(uuid, dadosAtualizados);
    }

    public boolean excluirProduto(UUID uuid) {
        return produtoRepository.excluirProduto(uuid);
    }
}
