import { PetIcon } from '@/types/pet'

import { IconGrid, IconImage, IconOption } from './styles'

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

const iconMap: Record<PetIcon, string> = {
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
}

type Props =  {
  selectedIcon: PetIcon;
  onIconSelect: (icon: PetIcon) => void;
}

export const IconSelector = ({ selectedIcon, onIconSelect }: Props) => {
  return (
    <IconGrid>
      {(Object.keys(iconMap) as PetIcon[]).map((icon) => (
        <IconOption
          key={icon}
          selected={selectedIcon === icon}
          onClick={() => onIconSelect(icon)}
        >
          <IconImage src={iconMap[icon]} alt={icon} />
        </IconOption>
      ))}
    </IconGrid>
  )
}