package studing.ProdutosAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studing.ProdutosAPI.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
