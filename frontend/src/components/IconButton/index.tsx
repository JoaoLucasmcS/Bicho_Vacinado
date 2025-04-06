import { IconContainer } from "./styles"

type Props = {
  type?: 'PRIMARY' | 'SECONDARY';
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  icon: any;
  onClick?: (event: React.MouseEvent) => void;
}

export const IconButton = ({ type = 'PRIMARY', icon, onClick }: Props) => {
  return (
    <IconContainer type={type} onClick={onClick}>
      {icon}
    </IconContainer>
  )
}
