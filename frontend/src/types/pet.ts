export type PetIcon = 'cat1' | 'cat2' | 'cat3' | 'cat4' | 'cat5' | 'dog1' | 'dog2' | 'dog3' | 'dog4' | 'dog5';

export type PetProps = {
  id: number;
  name: string;
  age: number;
  type: string;
  description: string;
  icon: PetIcon;
}