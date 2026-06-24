package studing.ProdutosAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studing.ProdutosAPI.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);
}
