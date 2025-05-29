/* package com.BichoVacinado.BichoVacinado;

import com.BichoVacinado.BichoVacinado.dto.request.PostoDeVacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PostoDeVacinacaoResponse;
import com.BichoVacinado.BichoVacinado.model.PostoDeVacinacao;
import com.BichoVacinado.BichoVacinado.repository.PostoDeVacinacaoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import java.util.Set;

import jakarta.validation.*;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VaccinationStationTest {
	@Mock
	private PostoDeVacinacaoRepository postoDeVacinacaoRepository;

	@InjectMocks
	private StationService stationService;

	private PostoDeVacinacao station;
	private PostoDeVacinacaoRequest request;
	private PostoDeVacinacaoResponse response;
	private Validator validator;

	@BeforeEach
	void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		request = new PostoDeVacinacaoRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone("81940025922");

		station = new PostoDeVacinacao();
		station.setId(1L);
		station.setNome(request.getNome());
		station.setEndereco(request.getEndereco());
		station.setTelefone(request.getTelefone());

		response = new PostoDeVacinacaoResponse();
		response.setId(1L);
		response.setNome(request.getNome());
		response.setEndereco(request.getEndereco());
		response.setTelefone(request.getTelefone());
	}

	@Test
	void criarVaccinationStation() {
		when(postoDeVacinacaoRepository.save(any(PostoDeVacinacao.class))).thenReturn(station);
		PostoDeVacinacaoResponse result = stationService.cadastrar(request);

		assertNotNull(result);
		assertEquals(response.getId(), result.getId());
		assertEquals(response.getNome(), result.getNome());
		assertEquals(response.getEndereco(), result.getEndereco());
		assertEquals(response.getTelefone(), result.getTelefone());

		verify(postoDeVacinacaoRepository, times(1)).save(any(PostoDeVacinacao.class));
	}

	@Test
	void nomeNuloAoCriarVaccinationStation() {
		PostoDeVacinacaoRequest request = new PostoDeVacinacaoRequest();
		request.setNome(null);
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone("81940025922");

		Set<ConstraintViolation<PostoDeVacinacaoRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals("Nome é obrigatório", violations.iterator().next().getMessage());
	}

	@Test
	void enderecoNuloAoCriarVaccinationStation() {
		PostoDeVacinacaoRequest request = new PostoDeVacinacaoRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco(null);
		request.setTelefone("81940025922");

		Set<ConstraintViolation<PostoDeVacinacaoRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals("Endereço é obrigatório", violations.iterator().next().getMessage());
	}

	@Test
	void telefoneNuloAoCriarVaccinationStation() {
		PostoDeVacinacaoRequest request = new PostoDeVacinacaoRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone(null);

		Set<ConstraintViolation<PostoDeVacinacaoRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals("Telefone é obrigatório", violations.iterator().next().getMessage());
	}

	@Test
	void telefoneCurtoAoCriarVaccinationStation() {
		PostoDeVacinacaoRequest request = new PostoDeVacinacaoRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone("123");

		Set<ConstraintViolation<PostoDeVacinacaoRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals(
				"Telefone precisa ter, pelo menos, 10 dígitos.", violations.iterator().next().getMessage()
		);
	}

	@Test
	void atualizarVaccinationStationExistente() {
		Long id = 1L;
		when(postoDeVacinacaoRepository.findById(id)).thenReturn(Optional.of(station));
		when(postoDeVacinacaoRepository.save(any(PostoDeVacinacao.class))).thenReturn(station);

		request.setNome("PetVet Atualizado");
		request.setEndereco("Nova Rua, 456");
		request.setTelefone("11888888888");

		PostoDeVacinacaoResponse result = stationService.atualizar(id, request);

		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals("PetVet Atualizado", result.getNome());
		assertEquals("Nova Rua, 456", result.getEndereco());
		assertEquals("11888888888", result.getTelefone());

		verify(postoDeVacinacaoRepository, times(1)).findById(id);
		verify(postoDeVacinacaoRepository, times(1)).save(any(PostoDeVacinacao.class));
	}

	@Test
	void atualizarVaccinationStationInexistente() {
		Long id = 99L;
		when(postoDeVacinacaoRepository.findById(id)).thenReturn(Optional.empty());

		assertThrows(RuntimeException.class, () -> stationService.atualizar(id, request));

		verify(postoDeVacinacaoRepository, times(1)).findById(id);
		verify(postoDeVacinacaoRepository, never()).save(any(PostoDeVacinacao.class));
	}
}
*/