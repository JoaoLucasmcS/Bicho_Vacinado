import styled, { css } from "styled-components";

type IconProps = {
  type: 'PRIMARY' | 'SECONDARY';
}

export const IconContainer = styled.button<IconProps>`
  background-color: ${({ theme }) => theme.COLORS.WHITE};
  border-radius: 20px;
  border: none;

  width: 2.5vw;
  height: 2.5vw;

  display: flex;
  justify-content: center;
  align-items: center;

  cursor: pointer;
  transition: 0.2s ease-in-out;

  ${({ theme, type }) => css`
    color: ${type === 'PRIMARY' ? theme.COLORS.BLUE : theme.COLORS.RED};
    font-size: ${theme.FONT_SIZE.XL}px;
  `}

  &:hover {
    background-color: ${({ theme }) => theme.COLORS.GRAY_200};
    font-size: ${({ theme }) => theme.FONT_SIZE.XXL}px;
  }
`