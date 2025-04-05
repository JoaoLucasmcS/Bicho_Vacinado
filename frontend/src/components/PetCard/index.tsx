import { FaTrash } from "react-icons/fa";
import { FaEdit } from "react-icons/fa";

import { IconButton } from "@/components/IconButton";

import { PetProps } from "@/types/pet";
import { petIcons } from "@/utils/petIcons";

import {
  CardContainer,
  Container,
  IconGroup,
  PetIcon,
  PetInfo,
  PetName,
  PetSubtitle,
} from "./styles";

type Props = {
  type?: 'PRIMARY' | 'SECONDARY';
  pet: PetProps;
}

export const PetCard = ({ type='PRIMARY', pet }: Props) => {
  return (
    <Container>
      <CardContainer type={type}>
        <PetInfo>
          <PetName>
            {pet.name}
          </PetName>

          <PetSubtitle>
            {pet.type} - {pet.age} anos
          </PetSubtitle>
        </PetInfo>

        <IconGroup>
          <IconButton type="PRIMARY" icon={<FaEdit />}/>
          <IconButton type="SECONDARY" icon={<FaTrash />}/>
        </IconGroup>
      </CardContainer>

      <PetIcon
        src={petIcons[pet.icon]}
        alt={pet.name}
      />
    </Container>
  )
}