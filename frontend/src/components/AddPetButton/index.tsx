import { Container, Title } from "./styles"

type Props = {
  onClick: () => void;
}

export const AddPetButton = ({ onClick }: Props) => {
  return (
    <Container onClick={onClick}>
      <Title>
        Adicionar um novo Pet <span>+</span>
      </Title> 
    </Container>
  )
}