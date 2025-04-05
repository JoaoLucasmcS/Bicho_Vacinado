import { PetProps } from "@/types/pet";

import { CardContainer, Container } from "./styles";

type Props = {
  type?: 'PRIMARY' | 'SECONDARY';
  pet: PetProps;
}

// eslint-disable-next-line @typescript-eslint/no-unused-vars
export const PetCard = ({ type='PRIMARY', pet }: Props) => {
  return (
    <Container>
      <CardContainer 
        type={type}
      >

      </CardContainer>
    </Container>
  )
}