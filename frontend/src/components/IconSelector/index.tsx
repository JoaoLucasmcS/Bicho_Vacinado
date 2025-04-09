import { petIcons, PetIconName } from "@utils/petIcons";

import { IconGrid, IconImage, IconOption } from './styles'

type Props =  {
  type?: "PRIMARY" | "SECONDARY";
  selectedIcon: PetIconName;
  onIconSelect: (icon: PetIconName) => void;
}

export const IconSelector = ({ type="PRIMARY", selectedIcon, onIconSelect }: Props) => {
  return (
    <IconGrid>
      {(Object.keys(petIcons) as PetIconName[]).map((icon) => (
        <IconOption
          key={icon}
          type={type}
          selected={selectedIcon === icon}
          onClick={() => onIconSelect(icon)}
        >
          <IconImage
            src={petIcons[icon]}
            alt={icon}
          />
        </IconOption>
      ))}
    </IconGrid>
  )
}