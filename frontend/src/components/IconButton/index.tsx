import { IconContainer } from "./styles"

type Props = {
  type?: 'PRIMARY' | 'SECONDARY';
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  icon: any;
}

export const IconButton = ({ type = 'PRIMARY', icon }: Props) => {
  return (
    <IconContainer type={type}>
      {icon}
    </IconContainer>
  )
}
