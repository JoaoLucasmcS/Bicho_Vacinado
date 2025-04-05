import { useState } from "react";

import { Header } from "@/components/Header";
import { PetCard } from "@/components/PetCard";

import { PetProps } from "@/types/pet";

import { Container } from "./styles";

const Pets = () => {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [ pets, setPets ] = useState<PetProps[]>([
    {
      id: 1,
      name: "Rex",
      age: 3,
      type: "Cachorro",
      description: "Um cachorro brincalhão e cheio de energia",
      icon: "dog1",
    }
  ]);

  return (<>
    <Header />
    
    <Container>
      {pets.map((pet, index) => (
        <PetCard 
          key={pet.id}
          type={index % 2 === 0 ? 'PRIMARY' : 'SECONDARY'}
          pet={pet}
        />
      ))}
    </Container>
  </>);
}

export default Pets;