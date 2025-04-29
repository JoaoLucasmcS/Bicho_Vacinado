import styled from "styled-components";

type IconOptionProps = {
  selected: boolean;
  type: "PRIMARY" | "SECONDARY"
}

export const IconGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(80px, 1fr));
  gap: 10px;
  margin-top: 10px;
`;

export const IconOption = styled.div<IconOptionProps>`
  display: flex;
  flex-direction: column;
  align-items: center;
  
  padding: 5px;
  background-color: ${({ selected, theme }) => (selected ? theme.COLORS.WHITE : 'transparent')};
  cursor: pointer;
  
  border: 2px solid transparent;
  border-radius: 5px;
  border-color: ${({ selected, theme, type }) => (`${
    type === "PRIMARY" ?
    (selected ? theme.COLORS.ORANGE : `transparent`) :
    (selected ? theme.COLORS.BLUE : `transparent`)}`)
    };
  
  transition: all 0.2s ease;
  
  &:hover {
    background-color: ${({ theme }) => theme.COLORS.GRAY_100};
  }
`;

export const IconImage = styled.img`
  width: 50px;
  height: 50px;
  object-fit: contain;
`;
