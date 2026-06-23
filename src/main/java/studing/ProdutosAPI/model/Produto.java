package studing.ProdutosAPI.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Produto {

    private String id;
    private String nome;
    private String descricao;
    private Double preco;
}
