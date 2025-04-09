/* eslint-disable @typescript-eslint/no-unused-vars */
import { Header } from "@/components/Header";
import { PetCard } from "@/components/PetCard";
import { AddPetButton } from "@/components/AddPetButton";
import { AddPetModal } from "@/components/AddPetModal";

import { usePets } from "@/hooks/usePets";
import { PetProps } from "@/types/pet";

import { Container } from "./styles";


const Pets = () => {
  const initialPets = ([
    {
      id: 1,
      name: "Rex",
      age: 3,
      type: "Cachorro",
      description: "Um cachorro brincalhão e cheio de energia",
      icon: "dog1",
    },

    {
      id: 2,
      name: "Pingo",
      age: 1,
      type: "Cachorro",
      description: "Um cachorro brincalhão e cheio de energia",
      icon: "dog2",
    },

    {
      id: 3,
      name: "Mel",
      age: 1,
      type: "Gato",
      description: "Um gato muito Fofo",
      icon: "cat5",
    },
  ]) as PetProps[];

  const { pets, isOpen, handleRemovePet, handleOpenAddPet, handleCloseAddPet } = usePets(initialPets);

  return (<>
    <Header />
    
    <Container>
      {pets.map((pet, index) => (
        <PetCard 
          key={pet.id}
          type={index % 2 === 0 ? 'PRIMARY' : 'SECONDARY'}
          pet={pet}
          onRemove={handleRemovePet}
        />
      ))}

      <AddPetButton 
        onClick={handleOpenAddPet}
      />
    </Container>

    {isOpen && (
      <AddPetModal 
        handleOpenAddPet={handleOpenAddPet}
        handleCloseAddPet={handleCloseAddPet}
      />
    )}
  </>);
}

export default Pets;