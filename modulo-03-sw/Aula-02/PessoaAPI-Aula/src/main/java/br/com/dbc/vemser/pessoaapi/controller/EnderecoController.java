package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController (EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping // GET localhost:8080/endereco
    public List<Endereco> enderecos() {
        return enderecoService.enderecos();
    }

    @GetMapping("/{id-endereco}") // GET localhost:8080/endereco
    public Endereco enderecoById(@RequestParam("id-endereco") Integer idEndereco) throws Exception {
        return enderecoService.getEndereco(idEndereco);
    }

    @GetMapping("/bypessoa/{id-pessoa}") // GET localhost:8080/endereco/bypessoa/{id-pessoa}
    public List<Endereco> listByPessoa(@RequestParam("id-pessoa") Integer id) {
        return enderecoService.listByPessoa(id);
    }

    @PostMapping // POST localhost:8080/endereco
    public Endereco create(@RequestBody Endereco endereco) throws Exception{
        return enderecoService.create(endereco);
    }

    @PostMapping("/{idPessoa}") // PUT localhost:8080/endereco/{idPessoa}
    public Endereco createByPessoa(@RequestParam("idPessoa") Integer id,
                           @RequestBody Endereco endereco) throws Exception {
        return enderecoService.createByPessoa(id, endereco);
    }

    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
    public Endereco update(@PathVariable("idEndereco") Integer id,
                         @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
