package studing.ProdutosAPI.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studing.ProdutosAPI.model.Produto;
import studing.ProdutosAPI.repository.ProdutoRepository;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);

        produto.setId(UUID.randomUUID().toString());

        produtoRepository.save(produto);
        return produto;
    }
}
