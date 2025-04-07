import { PetIconName } from '@/utils/petIcons';

export type PetProps = {
  id: number;
  name: string;
  age: number;
  type: string;
  description: string;
  icon: PetIconName;
}

export type PetType = "Cachorro" | "Gato";