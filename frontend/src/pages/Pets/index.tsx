import { useState } from "react";
import { toast } from "react-toastify";

import { Header } from "@/components/Header";
import { PetCard } from "@/components/PetCard";
import { ToastRemove } from "@/components/ToastRemove";

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
    }
  ]);

  const handleRemovePet = (id: number, name: string) => {
    toast(
      <ToastRemove
        onConfirm={() => {
          setPets(pets.filter(pet => pet.id !== id));
          toast.dismiss();
        }}
        onCancel={() => toast.dismiss()}
        petName={name}
      />,
      {
        position: "top-center",
        autoClose: false,
        closeOnClick: false,
        draggable: false,
        closeButton: false,
        toastId: `delete-pet-${id}`,
      }
    );
  }

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
    </Container>
  </>);
}

export default Pets;