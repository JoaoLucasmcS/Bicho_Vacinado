import styled, { css } from "styled-components";

type ButtonProps = {
  type: "PRIMARY" | "SECONDARY";
}

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  position: fixed;
  top: 0;
  z-index: 2;

  width: 100vw;
  height: 100vh;

  background-color: #00000080;
`;

export const FormContainer = styled.div`
  min-width: 60vw;
  max-width: 95vw;
  height: 90vh;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  gap: 2rem;

  background-color: ${({ theme }) => theme.COLORS.BACKGROUND};
  border-radius: 8px;

  padding: 2rem;
`

export const FormTitle = styled.h1`
  ${({ theme }) => css`
    color: ${theme.COLORS.ORANGE};
    font-size: ${theme.FONT_SIZE.XXL};
    font-family: ${theme.FONT_FAMILY.POPPINS};
  `}
`

export const ButtonContainer = styled.div`
  width: 100%;

  display: flex;
  flex-direction: row;

  align-items: center;
  justify-content: center;
  gap: 2vw;
`

export const Button = styled.button<ButtonProps>`
  width: 10vh;
  height: 4vh;

  border-radius: 20px;
  cursor: pointer;

  ${({ theme, type }) => css`
    background-color: ${type === "PRIMARY" ? theme.COLORS.BACKGROUND : theme.COLORS.BLUE};
    color: ${type === "PRIMARY" ? theme.COLORS.ORANGE : theme.COLORS.WHITE};
    border: ${type === "PRIMARY" ? `1px solid ${theme.COLORS.ORANGE}` : `none`};

    font-family: ${theme.FONT_FAMILY.POPPINS};
  `}

  transition: 0.2s ease-in-out;

  &:hover {
    ${({ theme, type }) => css`
      background-color: ${type === "PRIMARY" ? theme.COLORS.ORANGE : theme.COLORS.BLUE_700};
      color: ${type === "PRIMARY" ? theme.COLORS.WHITE : theme.COLORS.WHITE};
    `}
  }
`