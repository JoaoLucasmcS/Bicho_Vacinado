import styled, { css } from "styled-components";

type ContainerProps = {
  type: 'PRIMARY' | 'SECONDARY';
}


export const Container = styled.div`
  width: 100%;
  height: 30vh;

  position: relative;
  display: flex;
  align-items: flex-end;
  justify-content: center;
  
  margin-top: 5vh;
`

export const CardContainer = styled.div<ContainerProps>`
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;

  width: 100%;
  height: 17vh;
  border-radius: 20px;
  background-color: ${({ theme, type }) => type === 'PRIMARY' ? theme.COLORS.BLUE : theme.COLORS.ORANGE};
`

export const PetIcon = styled.img`
  width: 12vw;
  
  position: absolute;
  top: 0;
  left: 10%;
  z-index: 1;
  transform: translateY(0%);
`

export const PetInfo = styled.div`
  width: 20%;
  height: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;

`

export const PetName = styled.h1`
  ${({ theme }) => css`
    font-size: ${theme.FONT_SIZE.XXL}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
    color: ${theme.COLORS.WHITE};
  `}

  font-weight: 700;
  text-align: left;
`

export const PetSubtitle = styled.h3`
  ${({ theme }) => css`
    font-size: ${theme.FONT_SIZE.SM}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
    color: ${theme.COLORS.GRAY_100};
  `}

  font-weight: 400;
  text-align: left;
`

export const IconGroup = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  gap: 1vw;

  width: 20%
`

