import { ThemeProvider } from "styled-components";

import { GlobalStyle } from "@theme/global";
import { theme } from "@theme/theme";

import AppRoutes from "@routes/Routes";

const App = () => {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <AppRoutes />
    </ThemeProvider>
  )
}

export default App;