import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public List<Produto> buscarProdutosPorUUID(UUID uuid){ // Método para buscar produtos por UUID (01/10/26)
        List<Produto> resultado = new ArrayList<>();

        if(uuid == null || uuid.toString().trim().isEmpty()){
            return resultado;
        }

        for (Produto produto : produtos) {
            if (produto.getUUID().equals(uuid)) {
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

    public boolean editarProduto(UUID uuid, Produto dadosAtualizados) { // Método para editar produtos por UUID (01/10/26)
        Produto produto = encontrarPorUUID(uuid);

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

    public boolean excluirProduto(UUID uuid) {
        Produto produto = encontrarPorUUID(uuid);

        if (produto == null) {
            return false;
        }

        produtos.remove(produto);
        return true;
    }

    private Produto encontrarPorUUID(UUID uuid) {
        for (Produto produto : produtos) {
            if (produto.getUUID().equals(uuid)) {
                return produto;
            }
        }
        return null;
    }
}

