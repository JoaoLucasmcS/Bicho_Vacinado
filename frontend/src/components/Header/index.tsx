import { NavLink } from "react-router-dom";

import { Container, Group, Logo, HeaderImage, Nav, NavItem, LineDivisor } from "./styles";

import LogoHeader from "@assets/logoBV.png";
import PersonIcon from "@assets/personIcon.png"

export const Header = () => {
  return (
    <Container>
      <NavLink 
        to="/">
        <Logo
          src={LogoHeader}
          alt="Logo do Bicho Vacinado"
        />
      </NavLink>

      <Group>
        <Nav>
          <NavItem to="/">Home</NavItem>
          <NavItem to="/pets">Pets</NavItem>
        </Nav>

        <LineDivisor />

        <HeaderImage
          src={PersonIcon}
        />
      </Group>
    </Container>
  )
}