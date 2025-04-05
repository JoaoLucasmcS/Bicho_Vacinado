import { NavLink } from "react-router-dom";
import styled, { css } from "styled-components";

export const Container = styled.div`
  width: 100%;
  height: 10vh;

  display: flex;
  flex-direction: row;

  justify-content: space-between;
  align-items: center;

  padding: 0 4vw;
`

export const Group = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
`

export const Logo = styled.img`
  width: 2.5vw;
  height: 5vh;
`

export const HeaderImage = styled.img`
  width: 2.5vw;
  height: 5vh;

  border-radius: 50%;
  border: 1px solid ${({ theme }) => theme.COLORS.BLUE};
  cursor: pointer;
`

export const Nav = styled.nav`
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 20px;
`

export const NavItem = styled(NavLink)`
  width: 3vw;
  ${({ theme }) => css`
    color: ${theme.COLORS.ORANGE};
    font-size: ${theme.FONT_SIZE.MD}px;
    font-family: ${theme.FONT_FAMILY.POPPINS};
  `}

  &.active {
    ${({ theme }) => css`
      color: ${theme.COLORS.BLUE};
      font-weight: 700;
    `}
  }

  transition: 0.2s ease-in-out;

  &:hover {
    ${({ theme }) => css`
      color: ${theme.COLORS.BLUE};
      font-weight: 700;
      transform: scale(1.02);
    `}
  }
`

export const LineDivisor = styled.div`
  height: 3vh;
  width: 1px;
  background-color: ${({ theme }) => theme.COLORS.GRAY_400};
  margin-right: 1vw;
`