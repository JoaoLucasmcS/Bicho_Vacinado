import 'styled-components';
import { theme } from '@theme/theme';

type ThemeType = typeof theme;

declare module 'styled-components' {
  export interface DefaultTheme {
    COLORS: ThemeType['COLORS'];
    FONT_SIZE: ThemeType['FONT_SIZE'];
    FONT_FAMILY: ThemeType['FONT_FAMILY'];
  }
}