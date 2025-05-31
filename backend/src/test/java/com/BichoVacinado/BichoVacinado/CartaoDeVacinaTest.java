package com.BichoVacinado.BichoVacinado;

import com.BichoVacinado.BichoVacinado.dto.request.CartaoDeVacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.CartaoDeVacinaResponse;
import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.repository.CartaoDeVacinaRepository;
import com.BichoVacinado.BichoVacinado.repository.PetRepository;
import com.BichoVacinado.BichoVacinado.service.CartaoDeVacinaService;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CartaoDeVacinaTest {
    @Mock
    private CartaoDeVacinaRepository cartaoDeVacinaRepository;

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private CartaoDeVacinaService cartaoService;

    private CartaoDeVacina cartaoDeVacina;
    private CartaoDeVacinaRequest request;
    private CartaoDeVacinaResponse response;
    private Pet pet;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        pet = new Pet();
        pet.setId(1L);

        request = new CartaoDeVacinaRequest();
        request.setPetId(1L);
        request.setNome("Cartao do Carlos");

        cartaoDeVacina = new CartaoDeVacina();
        cartaoDeVacina.setId(1L);
        cartaoDeVacina.setNome(request.getNome());
        cartaoDeVacina.setPet(pet);

        response = new CartaoDeVacinaResponse();
        response.setId(1L);
        response.setNome(request.getNome());
        response.setPetId(1L);
        response.setNomePet("Carlao");
    }

    @Test
    void criarCartaoDeVacina() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));
        when(cartaoDeVacinaRepository.save(any(CartaoDeVacina.class))).thenReturn(cartaoDeVacina);
        CartaoDeVacinaResponse result = cartaoService.cadastrar(request);

        assertNotNull(result);
        assertEquals(cartaoDeVacina.getId(), result.getId());
        assertEquals(cartaoDeVacina.getNome(), result.getNome());

        verify(petRepository, times(1)).findById(anyLong());
        verify(cartaoDeVacinaRepository, times(1)).save(any(CartaoDeVacina.class));
    }

    @Test
    void buscarCartaoDeVacinaPorId() {
        when(cartaoDeVacinaRepository.findById(1L)).thenReturn(Optional.of(cartaoDeVacina));

        CartaoDeVacinaResponse result = cartaoService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(response.getId(), result.getId());
        assertEquals(response.getNome(), result.getNome());
        assertEquals(response.getPetId(), result.getPetId());

        verify(cartaoDeVacinaRepository, times(1)).findById(1L);
    }

    @Test
    void buscarCartaoDeVacinaPorPetId() {
        when(cartaoDeVacinaRepository.findByPetId(1L)).thenReturn(Optional.of(cartaoDeVacina));

        CartaoDeVacinaResponse result = cartaoService.buscarPorPetId(1L);

        assertNotNull(result);
        assertEquals(response.getId(), result.getId());
        assertEquals(response.getNome(), result.getNome());
        assertEquals(response.getPetId(), result.getPetId());

        verify(cartaoDeVacinaRepository, times(1)).findByPetId(1L);
    }

    @Test
    void buscarCartaoDeVacinaPorIdInexistente() {
        when(cartaoDeVacinaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> cartaoService.buscarPorId(99L));
        verify(cartaoDeVacinaRepository, times(1)).findById(99L);
    }

    @Test
    void buscarCartaoDeVacinaPorPetIdInexistente() {
        when(cartaoDeVacinaRepository.findByPetId(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> cartaoService.buscarPorPetId(99L));
        verify(cartaoDeVacinaRepository, times(1)).findByPetId(99L);
    }

    @Test
    void criarCartaoDeVacinaComPetInexistente() {
        when(petRepository.findById(99L)).thenReturn(Optional.empty());

        CartaoDeVacinaRequest requestInvalido = new CartaoDeVacinaRequest();
        requestInvalido.setPetId(99L);
        requestInvalido.setNome("Cartao Invalido");

        assertThrows(RuntimeException.class, () -> cartaoService.cadastrar(requestInvalido));
        verify(petRepository, times(1)).findById(99L);
        verify(cartaoDeVacinaRepository, never()).save(any());
    }

    @Test
    void nomeNuloAoCriarCartaoDeVacina() {
        CartaoDeVacinaRequest request = new CartaoDeVacinaRequest();
        request.setNome(null);
        request.setPetId(1L);

        Set<ConstraintViolation<CartaoDeVacinaRequest>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals("Nome do cartão é obrigatório", violations.iterator().next().getMessage());
    }

    @Test
    void petIdNuloAoCriarCartaoDeVacina() {
        CartaoDeVacinaRequest request = new CartaoDeVacinaRequest();
        request.setNome("Cartao Válido");
        request.setPetId(null);

        Set<ConstraintViolation<CartaoDeVacinaRequest>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals("ID do pet é obrigatório", violations.iterator().next().getMessage());
    }

    @Test
    void nomeVazioAoCriarCartaoDeVacina() {
        CartaoDeVacinaRequest request = new CartaoDeVacinaRequest();
        request.setNome("");
        request.setPetId(1L);

        Set<ConstraintViolation<CartaoDeVacinaRequest>> violations = validator.validate(request);

        assertFalse(violations.isEmpty());
        assertEquals("Nome do cartão é obrigatório", violations.iterator().next().getMessage());
    }
}
