import styled, { css } from "styled-components";
import { Form, Field, ErrorMessage } from "formik";

export const FormContainer = styled(Form)`
  display: flex;
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
  border: 1px solid ${({ theme }) => theme.COLORS.ORANGE};

  resize: none;
  transition: 0.2s ease-in-out;

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
    border: 1px solid ${({ theme }) => theme.COLORS.BLUE};
    outline: none;
    box-shadow: 0 0 2px ${({ theme }) => theme.COLORS.BLUE};
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

  background-color: ${({ theme }) => theme.COLORS.ORANGE};
  color: ${({ theme }) => theme.COLORS.WHITE};
  border: none;

  font-family: ${({ theme }) => theme.FONT_FAMILY.POPPINS};

  transition: 0.2s ease-in-out;

  &:hover {
    background-color: ${({ theme }) => theme.COLORS.BLUE};
    color: ${({ theme }) => theme.COLORS.WHITE};
  }
`