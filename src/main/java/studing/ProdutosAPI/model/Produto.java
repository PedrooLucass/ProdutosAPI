package studing.ProdutosAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_produto")
@Data
public class Produto {

    // Por default o name da váriavel no db já é o mesmo do nome daqui, porém, caso seja outro o nome, por exemplo, no db a var seja 'identificacao', então podemos usar o name = "idenficacao" dentro de Column
    @Id
    @Column(name = "id")
    private String id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;
}
