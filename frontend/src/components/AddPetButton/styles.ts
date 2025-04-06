import styled from "styled-components";

export const Container = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;

  width: 100%;
  height: 25vh;

  margin: 10vh 0;
  border-radius: 20px;

  background-color: ${({ theme }) => theme.COLORS.BACKGROUND};
  border: 2px dashed ${({ theme }) => theme.COLORS.BLACK};
  stroke-dasharray: 4px;
  stroke-dashoffset: 2px;

  color: ${({ theme }) => theme.COLORS.BLACK};

  cursor: pointer;
  transition: all 0.2s ease-in-out;

  &:hover {
    background-color: ${({ theme }) => theme.COLORS.BLUE};
    color: ${({ theme }) => theme.COLORS.WHITE};
    border: 2px solid ${({ theme }) => theme.COLORS.BLACK};
  }
`

export const Title = styled.h1`
  font-size: 3rem;
  font-family: ${({ theme }) => theme.FONT_FAMILY.POPPINS};

  & span {
    font-weight: 300;
  }
`