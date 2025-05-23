/* eslint-disable @typescript-eslint/no-unused-vars */
import { FormAddPet } from "@/components/FormAddPet"

import {
  Container,
  FormContainer,
  Button,
  ButtonContainer,
  FormTitle
} from "./styles"

type Props = {
  handleCloseAddPet: () => void;
}

export const AddPetModal = ({ handleCloseAddPet }: Props) => {
  return (
    <Container>
      <FormContainer>
        <FormTitle>Adicionar Pet</FormTitle>

        <FormAddPet
          onSubmit={async (values) => {
            console.log("Valores do formulário:", values)
          }}
        />

        <ButtonContainer>
          <Button type="PRIMARY" onClick={handleCloseAddPet}>
            Cancelar
          </Button>
        </ButtonContainer>
      </FormContainer>
    </Container>
  )
}