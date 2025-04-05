import catIcon1 from '@assets/icons/iconCat1.png';
import catIcon2 from '@assets/icons/iconCat2.png';
import catIcon3 from '@assets/icons/iconCat3.png';
import catIcon4 from '@assets/icons/iconCat4.png';
import catIcon5 from '@assets/icons/iconCat5.png';
import dogIcon1 from '@assets/icons/iconDog1.png';
import dogIcon2 from '@assets/icons/iconDog2.png';
import dogIcon3 from '@assets/icons/iconDog3.png';
import dogIcon4 from '@assets/icons/iconDog4.png';
import dogIcon5 from '@assets/icons/iconDog5.png';

export type PetIconName = 'cat1' | 'cat2' | 'cat3' | 'cat4' | 'cat5' | 'dog1' | 'dog2' | 'dog3' | 'dog4' | 'dog5';

export const petIcons = {
  cat1: catIcon1,
  cat2: catIcon2,
  cat3: catIcon3,
  cat4: catIcon4,
  cat5: catIcon5,
  dog1: dogIcon1,
  dog2: dogIcon2,
  dog3: dogIcon3,
  dog4: dogIcon4,
  dog5: dogIcon5,
} as const;

export type PetIconsType = typeof petIcons;

export const getPetIcon = (iconName: PetIconName): string => {
  return petIcons[iconName];
}