import styled from "styled-components";

type ButtonToastType = {
  type: 'PRIMARY' | 'SECONDARY'
}

export const Container = styled.div`
  padding: 16px;
  font-family: ${({ theme }) => theme.FONT_FAMILY.POPPINS};
`

export const ToastTitle = styled.p`
  margin-bottom: 12px;
`

export const ButtonContainer = styled.div`
  display: flex;
  gap: 8px;
`

export const ButtonToast = styled.button<ButtonToastType>`
  padding: 6px 12px;
  background: ${({ theme, type }) => type === 'PRIMARY' ? theme.COLORS.WHITE : theme.COLORS.RED};
  border: ${({ theme, type }) => type === 'PRIMARY' ? `1px solid ${theme.COLORS.BLUE}` : 'none'};
  border-radius: 4px;

  font-family: ${({ theme }) => theme.FONT_FAMILY.POPPINS};
  color: ${({ theme, type }) => type === 'PRIMARY' ? theme.COLORS.BLUE : theme.COLORS.WHITE};

  cursor: pointer;
  transition: all 0.2s ease-in-out;

  &:hover {
    background: ${({ theme, type }) => type === 'PRIMARY' ? theme.COLORS.BLUE : theme.COLORS.ORANGE};
    color: ${({ theme, type }) => type === 'PRIMARY' ? theme.COLORS.WHITE : theme.COLORS.WHITE};
  }
`