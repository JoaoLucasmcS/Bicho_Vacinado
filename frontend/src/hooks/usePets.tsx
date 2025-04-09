import { useState } from "react";
import { toast } from "react-toastify";

import { PetProps } from "@/types/pet";
import { ToastRemove } from "@components/ToastRemove";

export const usePets = (initialPets: PetProps[]) => {
  const [ pets, setPets ] = useState<PetProps[]>(initialPets);
  const [ isOpen, setIsOpen ] = useState(false);

  const handleRemovePet = (id: number, name: string) => {
    toast(
      <ToastRemove
        onConfirm={() => {
          setPets(prevPets => prevPets.filter(pet => pet.id !== id));
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

  const handleOpenAddPet = () => setIsOpen(true);
  const handleCloseAddPet = () => setIsOpen(false);

  // const handleAddPet = (pet: PetProps) => {}

  return {
    pets,
    isOpen,
    handleRemovePet,
    handleOpenAddPet,
    handleCloseAddPet,
  }
}