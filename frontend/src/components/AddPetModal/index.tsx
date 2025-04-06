/* eslint-disable @typescript-eslint/no-unused-vars */
import {
  Container,
  FormContainer,
  Button,
  ButtonContainer,
  FormTitle
} from "./styles"

type Props = {
  handleOpenAddPet: () => void;
  handleCloseAddPet: () => void;
}

export const AddPetModal = ({ handleOpenAddPet, handleCloseAddPet }: Props) => {
  return (
    <Container>
      <FormContainer>
        <FormTitle>Adicionar Pet</FormTitle>

        <ButtonContainer>
          <Button type="PRIMARY" onClick={handleCloseAddPet}>
            Cancelar
          </Button>
          <Button type="SECONDARY" onClick={handleCloseAddPet}>
            Adicionar
          </Button>
        </ButtonContainer>
      </FormContainer>
    </Container>
  )
}