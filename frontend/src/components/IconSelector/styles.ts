import styled from "styled-components";

type IconOptionProps = {
  selected: boolean;
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
  background-color: ${({ selected }) => (selected ? '#f0f0f0' : 'transparent')};
  cursor: pointer;
  
  border: 2px solid transparent;
  border-radius: 5px;
  border-color: ${({ selected }) => (selected ? '#4CAF50' : 'transparent')};
  
  transition: all 0.2s ease;
  
  &:hover {
    background-color: #f5f5f5;
  }
`;

export const IconImage = styled.img`
  width: 50px;
  height: 50px;
  object-fit: contain;
`;
