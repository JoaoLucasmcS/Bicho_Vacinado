import styled, { css } from "styled-components";
import { Form, Field, ErrorMessage } from "formik";

export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100vw;
  height: 100vh;
`

export const BackButton = styled.button`
  width: 5vh;
  height: 5vh;
  display: flex;
  justify-content: center;
  align-items: center;

  position: absolute;
  top: 5vh;
  left: 5vw;

  background-color: ${({ theme }) => theme.COLORS.BLUE};
  border-radius: 50%;
  border: none;
  cursor: pointer;

  font-size: ${({ theme }) => theme.FONT_SIZE.XXL}px;
  color: ${({ theme }) => theme.COLORS.WHITE};

  transition: 0.2s ease-in-out;

  &:hover {
    background-color: ${({ theme }) => theme.COLORS.BLUE_700};
    color: ${({ theme }) => theme.COLORS.WHITE};

    box-shadow: 0 0 5px ${({ theme }) => theme.COLORS.BLUE_700};
  }
`

export const FormContainer = styled(Form)`
  display: flex;
  justify-content: center;
  flex-direction: column;

  gap: 1vh;
  min-width: 25vw;
  max-width: 50vw;
  height: 100%;

  padding: 2vh 2vw;
`;

export const FormLabel = styled.label`
  ${({ theme }) => css`
    color: ${theme.COLORS.GRAY_600};
    font-size: ${theme.FONT_SIZE.XS}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
  `}
`

export const FormField = styled(Field)`
  width: 100%;
  min-height: 3vh;
  max-height: 5vh;

  border-radius: 0 15px 15px 0;
  padding: 3px;
  border: 1px solid ${({ theme }) => theme.COLORS.BLUE};

  transition: 0.2s ease-in-out;
  resize: none;

  ${({ theme }) => css`
    color: ${theme.COLORS.GRAY_700};
    font-size: ${theme.FONT_SIZE.SM}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
  `}

  &::placeholder {
    ${({ theme }) => css`
    color: ${theme.COLORS.GRAY_300};
    font-size: ${theme.FONT_SIZE.SM}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
    `}
  }

  &:focus {
    border: 1px solid ${({ theme }) => theme.COLORS.ORANGE};
    outline: none;
    box-shadow: 0 0 2px ${({ theme }) => theme.COLORS.ORANGE};
  }
`

export const FormErrorMessage = styled(ErrorMessage)`
  ${({ theme }) => css`
    color: ${theme.COLORS.RED};
    font-size: ${theme.FONT_SIZE.XS}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
  `}
`

export const FormButton = styled.button`
  width: 100%;
  height: 5vh;
  border-radius: 20px;
  cursor: pointer;

  background-color: ${({ theme }) => theme.COLORS.BLUE};
  color: ${({ theme }) => theme.COLORS.WHITE};
  border: none;

  font-family: ${({ theme }) => theme.FONT_FAMILY.POPPINS};

  transition: 0.2s ease-in-out;

  &:hover {
    background-color: ${({ theme }) => theme.COLORS.ORANGE};
    color: ${({ theme }) => theme.COLORS.WHITE};
  }
`