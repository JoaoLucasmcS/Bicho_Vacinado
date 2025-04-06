import { ButtonContainer, ButtonToast, Container, ToastTitle } from "./styles";

type Props = {
  onConfirm: () => void;
  onCancel: () => void;
  petName: string;
}

export const ToastRemove = ({ onConfirm, onCancel, petName }: Props) => {
  return (
    <Container>
      <ToastTitle>Você tem certeza que deseja remover {petName}?</ToastTitle>
      <ButtonContainer>
        <ButtonToast type="PRIMARY" onClick={onCancel}>Cancelar</ButtonToast>
        <ButtonToast type="SECONDARY" onClick={onConfirm}>Confirmar</ButtonToast>
      </ButtonContainer>
    </Container>
  )
}