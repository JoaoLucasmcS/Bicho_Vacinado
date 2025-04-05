import styled from "styled-components";

type ContainerProps = {
  type: 'PRIMARY' | 'SECONDARY';
}

export const Container = styled.div`
  width: 100%;
  height: 20vh;

  display: flex;
  align-items: center;
  justify-content: center;
`

export const CardContainer = styled.div<ContainerProps>`
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;

  width: 100%;
  height: 15vh;
  border-radius: 20px;
  background-color: ${({ theme, type }) => type === 'PRIMARY' ? theme.COLORS.BLUE : theme.COLORS.ORANGE};
`

export const PetIcon = styled.img`
  
`

export const Icon = styled.div`

`