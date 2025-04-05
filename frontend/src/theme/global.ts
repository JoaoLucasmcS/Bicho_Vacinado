import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;

    max-width: 100%;
    overflow-x: hidden;

    scroll-behavior: smooth;
    word-wrap: break-word;
    overflow-wrap: break-word;

    text-decoration: none;
  }
`;