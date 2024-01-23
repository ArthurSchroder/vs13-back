package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    @Slf4j
    @RestController
    @RequestMapping("/endereco")
    public class EnderecoController {
        private final EnderecoService enderecoService;
        private final EmailService emailService;

        public EnderecoController (EnderecoService enderecoService, EmailService emailService) {
            this.enderecoService = enderecoService;
            this.emailService = emailService;
        }

        @GetMapping // GET localhost:8080/endereco
        public List<EnderecoDTO> enderecos() {
            return enderecoService.enderecos();
        }

        @GetMapping("/{id-endereco}") // GET localhost:8080/endereco
        public EnderecoDTO enderecoById(@RequestParam("id-endereco") Integer idEndereco) throws Exception {
            return enderecoService.getEndereco(idEndereco);
        }

        @GetMapping("/bypessoa/{id-pessoa}") // GET localhost:8080/endereco/bypessoa/{id-pessoa}
        public List<EnderecoDTO> listByPessoa(@RequestParam("id-pessoa") Integer id) {
            return enderecoService.listByPessoa(id);
        }

        @PostMapping // POST localhost:8080/endereco
        public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoDTOS endereco) throws Exception {
            log.debug("Criando endereço");

            EnderecoDTO enderecoCriado = enderecoService.create(endereco);
            log.debug("Endereço criado!");

            emailService.sendEmail();
            //return ResponseEntity.ok(pessoaService.create(pessoa));
            return new ResponseEntity<>(enderecoCriado, HttpStatus.OK);
        }

        @PostMapping("/{idPessoa}") // PUT localhost:8080/endereco/{idPessoa}
        public EnderecoDTO createByPessoa(@RequestParam("idPessoa") Integer id,
                                       @RequestBody EnderecoDTOS endereco) throws Exception {
            return enderecoService.createByPessoa(id, endereco);
        }

        @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
        public Endereco update(@PathVariable("idEndereco") Integer id,
                               @RequestBody Endereco enderecoAtualizar) throws Exception {
            emailService.sendEmail();
            log.debug("Endereço atualizado");
            return enderecoService.update(id, enderecoAtualizar);
        }

        @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
        public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
            log.debug("Endereço excluído");
            enderecoService.delete(id);
        }
}
