package studing.ProdutosAPI.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import studing.ProdutosAPI.model.Produto;
import studing.ProdutosAPI.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;
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

    // Caso eu quisesse poderia ser um @GetMapping(/{id}/{nome}/{qualquer_outra_variavel})
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable("id") String id) {
        /* Essa opção também é válida, sempre bom saber uma forma diferente de fazer o mesmo para caso outro programador tenha feito assim

        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
        */

        return produtoRepository.findById(id).orElse(null);
    }

    /*
    Caso na requisição esteja http://localhost:8080/produtos?nome=NomeQualquer&descricao=DescricaoQualquer
    Posso colocar como parametro dessa função como:
    buscarTodos(@RequestParam("nome") String nome, @RequestParam("descricao") String descricao)
    e quantos mais parâmetros eu quiser passar pela URL
    */
    @GetMapping
    public List<Produto> buscarTodos(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto) {

        produto.setId(id);
        produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }
}
