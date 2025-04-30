package com.BichoVacinado.BichoVacinado;

import com.BichoVacinado.BichoVacinado.dto.request.StationRequest;
import com.BichoVacinado.BichoVacinado.dto.response.StationResponse;
import com.BichoVacinado.BichoVacinado.model.VaccinationStation;
import com.BichoVacinado.BichoVacinado.repository.StationRepository;
import com.BichoVacinado.BichoVacinado.service.StationService;

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
	private StationRepository stationRepository;

	@InjectMocks
	private StationService stationService;

	private VaccinationStation station;
	private StationRequest request;
	private StationResponse response;
	private Validator validator;

	@BeforeEach
	void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		request = new StationRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone("81940025922");

		station = new VaccinationStation();
		station.setId(1L);
		station.setNome(request.getNome());
		station.setEndereco(request.getEndereco());
		station.setTelefone(request.getTelefone());

		response = new StationResponse();
		response.setId(1L);
		response.setNome(request.getNome());
		response.setEndereco(request.getEndereco());
		response.setTelefone(request.getTelefone());
	}

	@Test
	void criarVaccinationStation() {
		when(stationRepository.save(any(VaccinationStation.class))).thenReturn(station);
		StationResponse result = stationService.cadastrar(request);

		assertNotNull(result);
		assertEquals(response.getId(), result.getId());
		assertEquals(response.getNome(), result.getNome());
		assertEquals(response.getEndereco(), result.getEndereco());
		assertEquals(response.getTelefone(), result.getTelefone());

		verify(stationRepository, times(1)).save(any(VaccinationStation.class));
	}

	@Test
	void nomeNuloAoCriarVaccinationStation() {
		StationRequest request = new StationRequest();
		request.setNome(null);
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone("81940025922");

		Set<ConstraintViolation<StationRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals("Nome é obrigatório", violations.iterator().next().getMessage());
	}

	@Test
	void enderecoNuloAoCriarVaccinationStation() {
		StationRequest request = new StationRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco(null);
		request.setTelefone("81940025922");

		Set<ConstraintViolation<StationRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals("Endereço é obrigatório", violations.iterator().next().getMessage());
	}

	@Test
	void telefoneNuloAoCriarVaccinationStation() {
		StationRequest request = new StationRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone(null);

		Set<ConstraintViolation<StationRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals("Telefone é obrigatório", violations.iterator().next().getMessage());
	}

	@Test
	void telefoneCurtoAoCriarVaccinationStation() {
		StationRequest request = new StationRequest();
		request.setNome("Bicho Vacinado");
		request.setEndereco("Rua Bicho Vacinado");
		request.setTelefone("123");

		Set<ConstraintViolation<StationRequest>> violations = validator.validate(request);

		assertFalse(violations.isEmpty());
		assertEquals(
				"Telefone precisa ter, pelo menos, 10 dígitos.", violations.iterator().next().getMessage()
		);
	}

	@Test
	void atualizarVaccinationStationExistente() {
		Long id = 1L;
		when(stationRepository.findById(id)).thenReturn(Optional.of(station));
		when(stationRepository.save(any(VaccinationStation.class))).thenReturn(station);

		request.setNome("PetVet Atualizado");
		request.setEndereco("Nova Rua, 456");
		request.setTelefone("11888888888");

		StationResponse result = stationService.atualizar(id, request);

		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals("PetVet Atualizado", result.getNome());
		assertEquals("Nova Rua, 456", result.getEndereco());
		assertEquals("11888888888", result.getTelefone());

		verify(stationRepository, times(1)).findById(id);
		verify(stationRepository, times(1)).save(any(VaccinationStation.class));
	}

	@Test
	void atualizarVaccinationStationInexistente() {
		Long id = 99L;
		when(stationRepository.findById(id)).thenReturn(Optional.empty());

		assertThrows(RuntimeException.class, () -> stationService.atualizar(id, request));

		verify(stationRepository, times(1)).findById(id);
		verify(stationRepository, never()).save(any(VaccinationStation.class));
	}
}
