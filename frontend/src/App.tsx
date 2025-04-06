import { ThemeProvider } from "styled-components";
import { ToastContainer } from "react-toastify";

import { GlobalStyle } from "@theme/global";
import { theme } from "@theme/theme";

import AppRoutes from "@routes/Routes";

const App = () => {
  return (
    <ThemeProvider theme={theme}>
      <ToastContainer position="top-center" autoClose={5000} />
      <GlobalStyle />
      <AppRoutes />
    </ThemeProvider>
  )
}

export default App;