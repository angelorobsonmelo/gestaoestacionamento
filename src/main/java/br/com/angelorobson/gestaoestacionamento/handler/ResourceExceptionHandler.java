package br.com.angelorobson.gestaoestacionamento.handler;

import br.com.angelorobson.gestaoestacionamento.domain.DetalhesErro;
import br.com.angelorobson.gestaoestacionamento.services.exceptions.Excecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {


	@ExceptionHandler(Excecao.class)
	public ResponseEntity<DetalhesErro> handleDadoNaoEncontradoException
							(Excecao e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O dado buscado não pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.gerenciamentoestacionamento.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
